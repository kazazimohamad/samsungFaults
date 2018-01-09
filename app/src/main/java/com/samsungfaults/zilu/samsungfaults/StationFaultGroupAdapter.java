package com.samsungfaults.zilu.samsungfaults;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 1/3/2018.
 */

public class StationFaultGroupAdapter extends BaseAdapter {

    // Your sent context
    private final Context context;
    // Your custom values for the spinner (User)
    private List<StationModel> values;
    private final LayoutInflater mInflater;


    public StationFaultGroupAdapter(Context context,
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
        view = mInflater.inflate(android.R.layout.simple_spinner_item, viewGroup, false);
        TextView textView= (TextView) view.findViewById(android.R.id.text1);
        textView.setText(values.get(i).getFaName());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(android.R.layout.simple_spinner_item, parent, false);
        TextView textView= (TextView) convertView.findViewById(android.R.id.text1);
        textView.setText(values.get(position).getFaName());
        return convertView;
    }

}
