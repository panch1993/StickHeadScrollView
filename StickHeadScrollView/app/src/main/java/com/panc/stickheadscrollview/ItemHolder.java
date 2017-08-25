package com.panc.stickheadscrollview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by panchenhuan on 17/8/25.
 */

public class ItemHolder extends RecyclerView.ViewHolder {

    TextView mTextView;

    public ItemHolder(View itemView) {
        super(itemView);
        mTextView = ((TextView) itemView.findViewById(R.id.tv));
    }
}
