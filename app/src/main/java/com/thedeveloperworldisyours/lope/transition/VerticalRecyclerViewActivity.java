package com.thedeveloperworldisyours.lope.transition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.thedeveloperworldisyours.lope.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerticalRecyclerViewActivity extends AppCompatActivity implements VerticalRecyclerViewAdapter.MyClickListener {

    @BindView(R.id.vertical_recycler_view_activity_recycler_view)
    RecyclerView mRecyclerView;

    private VerticalRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vertical_recycler_view_activity);

        ButterKnife.bind(this);

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new VerticalRecyclerViewAdapter(getDataSet(), this);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new VerticalDividerItemDecoration(this);
        mRecyclerView.addItemDecoration(itemDecoration);
        mAdapter.setOnItemClickListener(this);

    }




    private ArrayList<VerticalData> getDataSet() {

        VerticalData dataThe = new VerticalData("The", R.drawable.thedeveloperworldisyours);
        VerticalData dataDeveloper = new VerticalData("Developer", R.drawable.thewordis);
        VerticalData dataWorld = new VerticalData("World", R.drawable.theworldisyours);
        VerticalData dataIs = new VerticalData("Is", R.drawable.thedeveloperworldisyours);
        VerticalData dataYours = new VerticalData("Yours", R.drawable.thewordis);
        VerticalData dataCom = new VerticalData(".com", R.drawable.theworldisyours);

        ArrayList<VerticalData> list = new ArrayList<>();

        list.add(0, dataThe);
        list.add(1, dataDeveloper);
        list.add(2, dataWorld);
        list.add(3, dataIs);
        list.add(4, dataYours);
        list.add(5, dataCom);
        return list;
    }

    @Override
    public void onItemClick(int position, View v) {

    }
}
