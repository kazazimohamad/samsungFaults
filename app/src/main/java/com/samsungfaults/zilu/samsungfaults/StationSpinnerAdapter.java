package com.samsungfaults.zilu.samsungfaults;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by haniyehkhaksar on 1/19/18.
 */

public class StationSpinnerAdapter extends BaseAdapter {
    private final LayoutInflater mInflater;
    private List<StationModel> stationModels;

    public StationSpinnerAdapter(Context context, List<StationModel> stationModels) {
        this.stationModels = stationModels;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return stationModels.size();
    }

    @Override
    public Object getItem(int i) {
        return stationModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return Long.valueOf(stationModels.get(i).getId());
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = mInflater.inflate(R.layout.group_spinner_item, viewGroup, false);
        TextView textView= (TextView) view.findViewById(R.id.txtGroupeRowName2);
        textView.setText(stationModels.get(i).getFaName());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.group_spinner_item, parent, false);
        TextView textView= (TextView) convertView.findViewById(R.id.txtGroupeRowName2);
        textView.setText(stationModels.get(position).getFaName());
        return convertView;
    }

    @Override
    public boolean isEmpty() {
        return stationModels == null || stationModels.isEmpty();
    }
}