package com.panc.stickheadscrollview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.panc.stickheadscrollviewlibrary.StickHeadScrollView;

/**
 * Created by panchenhuan on 17/8/25.
 */

public class RvHeadActivity extends AppCompatActivity {

    private StickHeadScrollView mStickHeadScrollView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_with_recyclerview);

        //1.do your job
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RvAdapter(this));
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.sl);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(RvHeadActivity.this, "fresh finish", Toast.LENGTH_SHORT).show();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        View headView = findViewById(R.id.tv_head);
        //避免自动滑动到底部
        headView.setFocusable(true);
        headView.setFocusableInTouchMode(true);
        headView.requestFocus();
        //2.set height
        mStickHeadScrollView = (StickHeadScrollView) findViewById(R.id.sv);
        mStickHeadScrollView.resetHeight(headView,recyclerView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toggle, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.refresh_toggle:
                mSwipeRefreshLayout.setEnabled(!mSwipeRefreshLayout.isEnabled());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
