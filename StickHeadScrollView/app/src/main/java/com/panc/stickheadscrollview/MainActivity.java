package com.panc.stickheadscrollview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_rv).setOnClickListener(this);
        findViewById(R.id.bt_vp).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, v.getId() == R.id.bt_rv ? RvHeadActivity.class : VpHeadActivity.class);
        startActivity(intent);
    }
}
