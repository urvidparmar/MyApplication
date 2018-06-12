package com.example.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaychang.srv.SimpleCell;
import com.jaychang.srv.SimpleViewHolder;

public class GalaxyCell extends SimpleCell<Galaxy, GalaxyCell.ViewHolder> {


    public GalaxyCell(@NonNull Galaxy item) {
        super(item);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.model;
    }

    /*
    - Return a ViewHolder instance
     */
    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(ViewGroup parent, View cellView) {
        return new ViewHolder(cellView);
    }

    /*
    - Bind data to widgets in our viewholder.
     */
    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull Context context, Object o) {
        viewHolder.titleTxt.setText(getItem().getName());

    }

    /**
     * - Our ViewHolder class.
     * - Inner static class.
     * Define your view holder, which must extend SimpleViewHolder.
     */
    static class ViewHolder extends SimpleViewHolder {

        TextView titleTxt;

        ViewHolder(View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.nameTxt);

        }
    }
}

