package com.samsungfaults.zilu.samsungfaults;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by haniyeh on 12/31/17.
 */

public class StationAdapter extends BaseAdapter {

    // Your sent context
    private final Context context;
    // Your custom values for the spinner (User)
    private ArrayList<groupsModel> values;
    private final LayoutInflater mInflater;


    public StationAdapter(Context context,
                          ArrayList<groupsModel> values) {
        super();
        this.context = context;
        this.values = values;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public groupsModel getItem(int i) {
        return values.get(i);
    }

    @Override
    public long getItemId(int i) {
        return values.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = mInflater.inflate(R.layout.group_spinner_item, viewGroup, false);
        TextView textView= (TextView) view.findViewById(R.id.txtGroupeRowName2);
        textView.setText(values.get(i).getGroupName());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.group_spinner_item, parent, false);
        TextView textView= (TextView) convertView.findViewById(R.id.txtGroupeRowName2);
        textView.setText(values.get(position).getGroupName());
        return convertView;
    }

}
