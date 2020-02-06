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

    // private String[] dataset = new String[20];
    private String[][] dataset = new String[20][20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_screen_test);

//        ////// 横スクロールリストのテスト //////
//        recyclerView = findViewById(R.id.my_recycler_view);
//
//        // use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
//        recyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
//        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//
//        int i = 0;
//        while (i < 20) {
//            dataset[i] = String.format(Locale.ENGLISH, "Data_0%d", i);
//            i++;
//        }
//
//        // specify an adapter (see also next example)
//        mAdapter = new MyListAdapter(dataset);
//        recyclerView.setAdapter(mAdapter);
//        ////////////////////////////////////

        // 縦横両方ありのリストを呼び出し
        initRecyclerView();
    }

    private void initRecyclerView() {
        // Setting recycler view
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Generate demo data
        int i = 0, j;
        while (i < 20) {
            j = 0;
            while (j < 20) {
                dataset[i][j] = String.format(Locale.ENGLISH, "Data %d - %d", i, j);
                j++;
            }
            i++;
        }
        // Setting adapter
        VerticalListAdapter adapter = new VerticalListAdapter(this, dataset);
        recyclerView.swapAdapter(adapter, false);
    }
}
