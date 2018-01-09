package com.samsungfaults.zilu.samsungfaults;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mohamad on 12/16/2017.
 */
public class GroupAdaptor extends RecyclerView.Adapter<GroupAdaptor.GroupViewHolder> {

    private Context context;
    private List<groupsModel> models;

    public GroupAdaptor(Context context, List<groupsModel> models) {
        this.models = models;
        this.context = context;
    }

    public void notifyData(List<groupsModel> groupsModels){
        this.models = groupsModels;
        notifyDataSetChanged();
    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GroupViewHolder(LayoutInflater.from(context).inflate(R.layout.group_list_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, int position) {
        holder.tvGroupName.setText(models.get(position).getGroupName());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder {

        TextView tvGroupName;

        public GroupViewHolder(View itemView) {
            super(itemView);
            tvGroupName = (TextView) itemView.findViewById(R.id.txtGroupeRowName);
        }
    }
}
