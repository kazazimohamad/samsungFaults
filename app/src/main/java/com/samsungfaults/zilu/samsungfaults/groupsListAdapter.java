package com.samsungfaults.zilu.samsungfaults;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
/**
 * Created by mohamad on 12/15/2017.
 */
public class groupsListAdapter extends BaseAdapter {

    private ArrayList groups;
    private Context context;

    public groupsListAdapter(ArrayList groups, Context context) {
        this.groups = groups;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (groups == null) {
            return 0;
        }
        return groups.size();
    }

    @Override
    public Object getItem(int position) {
        return groups.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
