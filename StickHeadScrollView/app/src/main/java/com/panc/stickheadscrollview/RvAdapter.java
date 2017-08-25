package com.panc.stickheadscrollview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by panchenhuan on 17/8/25.
 */

public class RvAdapter extends RecyclerView.Adapter<ItemHolder> {
    private Context mContext;

    public RvAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(final ItemHolder holder, int position) {
        holder.mTextView.setText(" === " + position + " === ");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "holder.getAdapterPosition():" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 50;
    }
}
