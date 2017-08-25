package com.panc.stickheadscrollview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by panchenhuan on 17/8/25.
 */

public class TextFragment extends Fragment {

    public static TextFragment newInstance(String message) {
        Bundle args = new Bundle();
        args.putString("msg", message);
        TextFragment fragment = new TextFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        String msg = getArguments().getString("msg");
        textView.setText(msg);
        return textView;
    }
}
