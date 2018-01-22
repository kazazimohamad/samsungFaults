package com.samsungfaults.zilu.samsungfaults;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohamad on 1/5/2018.
 */

public class StationSpinerAdapter extends BaseAdapter {

    // Your sent context
    private final Context context;
    // Your custom values for the spinner (User)
    private List<StationModel> values;
    private final LayoutInflater mInflater;


    public StationSpinerAdapter(Context context,
                          List<StationModel> values) {
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
    public StationModel getItem(int i) {
        return values.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = mInflater.inflate(R.layout.group_spinner_item, viewGroup, false);
        TextView textView= (TextView) view.findViewById(R.id.txtGroupeRowName2);
        textView.setText(values.get(i).getId());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.group_spinner_item, parent, false);
        TextView textView= (TextView) convertView.findViewById(R.id.txtGroupeRowName2);
        textView.setText(values.get(position).getId());
        return convertView;
    }

}
