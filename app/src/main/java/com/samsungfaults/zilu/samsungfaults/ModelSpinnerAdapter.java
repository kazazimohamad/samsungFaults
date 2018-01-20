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

public class ModelSpinnerAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private List<ProductModel> models;

    public ModelSpinnerAdapter(Context context, List<ProductModel> models) {
        this.models = models;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int i) {
        return models.get(i);
    }

    @Override
    public long getItemId(int i) {
        return models.get(i).getId();
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = mInflater.inflate(android.R.layout.simple_spinner_item, viewGroup, false);
        TextView textView= (TextView) view.findViewById(android.R.id.text1);
        textView.setText(models.get(i).getProductName());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(android.R.layout.simple_spinner_item, parent, false);
        TextView textView= (TextView) convertView.findViewById(android.R.id.text1);
        textView.setText(models.get(position).getProductName());
        return convertView;
    }

    @Override
    public boolean isEmpty() {
        return models == null || models.isEmpty();
    }
}
