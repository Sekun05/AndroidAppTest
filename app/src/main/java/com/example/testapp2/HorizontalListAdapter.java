package com.example.testapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

public class HorizontalListAdapter extends RecyclerView.Adapter {

    private Context context;
    private String[] mDataset = new String[20];

    public HorizontalListAdapter(@NonNull final Context context, @NonNull final String[] dataset) {
        this.context = context;
        this.mDataset = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View defaultView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_horizontal, parent, false);
        return new HorizontalListAdapter.ContentViewHolder(defaultView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((HorizontalListAdapter.ContentViewHolder) holder).setData(mDataset, context);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        ContentViewHolder(View v) {
//            super(itemView);
//            this.view = itemView;

            super(v);
            mTextView = (TextView) v.findViewById(R.id.list_item_text);
        }

        void setData(String[] data, Context context) {
            mTextView.setText(data[getLayoutPosition()]);
        }
    }
}
