package com.samsungfaults.zilu.samsungfaults;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 1/1/2018.
 */

public class StationListAdapter extends RecyclerView.Adapter<StationListAdapter.ProductViewHolder> {


    private Context context;
    private List<StationModel> models;

    public StationListAdapter(Context context, List<StationModel> products) {
        this.models = products;
        this.context = context;
    }

    public void notifyData(List<StationModel> productModels){
        this.models = productModels;
        notifyDataSetChanged();
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.station_list_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.txtStationRowCode.setText(models.get(position).getId());
        holder.txtStationRowName.setText(models.get(position).getFaName());
        holder.txtStationRowGroup.setText(String.valueOf(models.get(position).getGroupId()));
        if (position % 2 == 0) {
            holder.txtStationRowCode.setBackgroundColor(context.getResources().getColor(R.color.tableOddRow));
            holder.txtStationRowName.setBackgroundColor(context.getResources().getColor(R.color.tableOddRow));
            holder.txtStationRowGroup.setBackgroundColor(context.getResources().getColor(R.color.tableOddRow));
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView txtStationRowCode;
        TextView txtStationRowName;
        TextView txtStationRowGroup;

        public ProductViewHolder(View itemView) {
            super(itemView);
            txtStationRowCode = (TextView) itemView.findViewById(R.id.txtStationRowCode);
            txtStationRowName = (TextView) itemView.findViewById(R.id.txtStationRowName);
            txtStationRowGroup = (TextView) itemView.findViewById(R.id.txtStationRowGroup);

        }
    }
}
