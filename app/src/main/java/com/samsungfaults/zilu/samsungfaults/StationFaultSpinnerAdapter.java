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

public class StationFaultSpinnerAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private List<StationFaultModel> faultModels;

    public StationFaultSpinnerAdapter(Context context, List<StationFaultModel> faultModels) {
        this.faultModels = faultModels;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return faultModels.size();
    }

    @Override
    public Object getItem(int i) {
        return faultModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return Long.valueOf(faultModels.get(i).getId());
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = mInflater.inflate(R.layout.group_spinner_item, viewGroup, false);
        TextView textView= (TextView) view.findViewById(R.id.txtGroupeRowName2);
        textView.setText(faultModels.get(i).getStaFaultName());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.group_spinner_item, parent, false);
        TextView textView= (TextView) convertView.findViewById(R.id.txtGroupeRowName2);
        textView.setText(faultModels.get(position).getStaFaultName());
        return convertView;
    }

    @Override
    public boolean isEmpty() {
        return faultModels == null || faultModels.isEmpty();
    }
}
