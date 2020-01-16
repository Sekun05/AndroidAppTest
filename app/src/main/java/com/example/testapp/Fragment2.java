package com.example.testapp;

import android.os.Bundle;
//import android.support.v4.app.Fragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment2 extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment2, null);

        Button btn = (Button)v.findViewById(R.id.button2);
        btn.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        // TODO
        ((MainActivity) getContext()).End_Tutorial();
    }
}