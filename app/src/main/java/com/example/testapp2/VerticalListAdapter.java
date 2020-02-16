package com.example.testapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.DividerItemDecoration;


public class VerticalListAdapter extends RecyclerView.Adapter {
    private Context context;
    private String[][] mDataset = new String[20][20];

    public VerticalListAdapter(@NonNull final Context context, @NonNull final String[][] dataset) {
        this.context = context;
        this.mDataset = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View defaultView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_vertical, parent, false);
        return new ContentViewHolder(defaultView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ContentViewHolder) holder).setData(mDataset, context);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder {

        View view;
        String[] nextData = new String[20];

        ContentViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }

        void setData(String[][] dataset, Context context) {
            // Setting recycler view
            RecyclerView recyclerView = view.findViewById(R.id.horizontal_recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL);
            recyclerView.addItemDecoration(itemDecoration);

            int i = 0;
            while (i < 20) {
                nextData[i] = dataset[getLayoutPosition()][i];
                i++;
            }

            // Setting adapter
            HorizontalListAdapter adapter = new HorizontalListAdapter(context, nextData);
            recyclerView.swapAdapter(adapter, false);
        }

    }
}
