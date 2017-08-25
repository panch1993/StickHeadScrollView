package com.panc.stickheadscrollview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.panc.stickheadscrollviewlibrary.StickHeadScrollView;

/**
 * Created by panchenhuan on 17/8/25.
 */

public class VpHeadActivity extends AppCompatActivity {

    private StickHeadScrollView mStickHeadScrollView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_with_viewpager);

        //1.do your job
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(new VpAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tb);
        tabLayout.setupWithViewPager(viewPager);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.sl);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(VpHeadActivity.this, "fresh finish", Toast.LENGTH_SHORT).show();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        //2.set height
        mStickHeadScrollView = (StickHeadScrollView) findViewById(R.id.sv);
        mStickHeadScrollView.resetHeight(tabLayout,viewPager);
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
