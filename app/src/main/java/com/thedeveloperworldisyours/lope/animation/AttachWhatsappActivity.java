package com.thedeveloperworldisyours.lope.animation;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.thedeveloperworldisyours.lope.R;

public class AttachWhatsappActivity extends AppCompatActivity {

    private PopupWindow mPopupWindow;
    private RelativeLayout parentLayout;
    private boolean isKeyBoardVisible;
    private boolean isPopupVisible;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attach_whatsapp);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        parentLayout = (RelativeLayout) findViewById(R.id.root_view);
        Button button = (Button) findViewById(R.id.activity_messenger_button);


        parentLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();

                parentLayout.getWindowVisibleDisplayFrame(r);

                int heightDiff = parentLayout.getRootView().getHeight() - (r.bottom - r.top);
                if (heightDiff > 100) {
                    //enter your code here
                    if (isPopupVisible) {
                        keepKeyboard();
                        isPopupVisible = false;
                        mPopupWindow.dismiss();
                    }
                } else {
                    //enter code for hid
                }
            }
        });

        checkKeyboardIsOpen(parentLayout);

        button.setOnClickListener((View view) -> {
            if (isKeyBoardVisible) {
                showPopUp();
            }
        });
    }

    private void keepKeyboard() {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }


    private void checkKeyboardIsOpen(final View contentView) {

        parentLayout.getViewTreeObserver().addOnGlobalLayoutListener(() -> {

            Rect r = new Rect();
            contentView.getWindowVisibleDisplayFrame(r);
            int screenHeight = contentView.getRootView().getHeight();

            // r.bottom is the position above soft keypad or device button.
            // if keypad is shown, the r.bottom is smaller than that before.
            int keypadHeight = screenHeight - r.bottom;

            if (keypadHeight > screenHeight * 0.15) { // 0.15 ratio is perhaps enough to determine keypad height.
                // keyboard is opened
                isKeyBoardVisible = true;
            } else {
                // keyboard is closed
                isKeyBoardVisible = false;
            }

        });
    }

    public void showPopUp() {
        isPopupVisible = true;
        // Initialize a new instance of LayoutInflater service
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        // Inflate the custom layout/view
        View customView = inflater.inflate(R.layout.keyboard_layout, null);

        relativeLayout = (RelativeLayout) customView.findViewById(R.id.keyboard_layout_view);
        // Initialize a new instance of popup window
        mPopupWindow = new PopupWindow(
                customView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );


        setSizeForSoftKeyboard();

        // Get a reference for the custom view close button
        Button closeButton = (Button) customView.findViewById(R.id.ib_close);

        // Set a click listener for the popup window close button
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dismiss the popup window
                isPopupVisible = false;
                mPopupWindow.dismiss();
            }
        });

        mPopupWindow.showAtLocation(parentLayout, Gravity.CENTER, 0, 0);
    }

    public void setSizeForSoftKeyboard(){
        relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                parentLayout.getWindowVisibleDisplayFrame(r);

                int screenHeight = getUsableScreenHeight();
                int heightDifference = screenHeight
                        - (r.bottom - r.top);
                int resourceId = getResources()
                        .getIdentifier("status_bar_height",
                                "dimen", "android");
                if (resourceId > 0) {
                    heightDifference -= getResources()
                            .getDimensionPixelSize(resourceId);
                }
                if (heightDifference > 100) {
                    int keyBoardHeight = heightDifference;

                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                    params.height = keyBoardHeight;
                    relativeLayout.setLayoutParams(params);
                }
            }
        });
    }

    private int getUsableScreenHeight() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            DisplayMetrics metrics = new DisplayMetrics();

            WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            windowManager.getDefaultDisplay().getMetrics(metrics);

            return metrics.heightPixels;

        } else {
            return parentLayout.getRootView().getHeight();
        }
    }

}

