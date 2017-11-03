package com.hfad.catchat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by itimmis on 11/3/17.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    private String[] data;
    private TestClickListener listener = null;

    public TestAdapter(String[] data)
    {
        this.data = data;
    }

    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.mTextView.setText(data[position]);
    }

    @Override
    public int getItemCount()
    {
        return data.length;
    }

    public void setClickListener(TestClickListener listener) {
        this.listener = listener;
    }






    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView mTextView;

        public ViewHolder(View v)
        {
            super(v);

            mTextView = (TextView)v.findViewById(R.id.rowText);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            if (listener != null) {
                listener.OnTestItemClicked(/* v, getAdapterPosition() */);
            }
        }
    }
}


