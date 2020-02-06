package com.example.testapp2;

import android.app.Activity;
import android.os.Bundle;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String[] dataset = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_screen_test);
        recyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        int i = 0;
        while (i < 20) {
            dataset[i] = String.format(Locale.ENGLISH, "Data_0%d", i);
            i++;
        }

        // specify an adapter (see also next example)
        mAdapter = new MyListAdapter(dataset);
        recyclerView.setAdapter(mAdapter);
    }
}
