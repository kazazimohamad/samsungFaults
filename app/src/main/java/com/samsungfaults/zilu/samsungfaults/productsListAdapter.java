package com.samsungfaults.zilu.samsungfaults;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
/**
 * Created by mohamad on 12/26/2017.
 */
public class productsListAdapter extends BaseAdapter {

    private ArrayList products;
    private Context context;

    public productsListAdapter(ArrayList products, Context context){
        this.products = products;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (products == null) {
            return 0;
        }
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
