package com.samsungfaults.zilu.samsungfaults;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mohamad on 1/6/2018.
 */

public class StationFaultsListAdapter extends RecyclerView.Adapter<StationFaultsListAdapter.ProductViewHolder> {


    private Context context;
    private List<StationFaultModel> models;

    public StationFaultsListAdapter(Context context, List<StationFaultModel> products) {
        this.models = products;
        this.context = context;
    }

    public void notifyData(List<StationFaultModel> productModels){
        this.models = productModels;
        notifyDataSetChanged();
    }

    @Override
    public StationFaultsListAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StationFaultsListAdapter.ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.station_fault_list_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(StationFaultsListAdapter.ProductViewHolder holder, int position) {
        holder.txtStationFaultRowCode.setText(models.get(position).getStaFaultCode());
        holder.txtStationFaultRowName.setText(models.get(position).getStaFaultStationId());
        holder.txtStationFaultRowGroup.setText(String.valueOf(models.get(position).getStaFaultName()));
        if (position % 2 == 0) {
            holder.txtStationFaultRowCode.setBackgroundColor(context.getResources().getColor(R.color.tableOddRow));
            holder.txtStationFaultRowName.setBackgroundColor(context.getResources().getColor(R.color.tableOddRow));
            holder.txtStationFaultRowGroup.setBackgroundColor(context.getResources().getColor(R.color.tableOddRow));
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView txtStationFaultRowCode;
        TextView txtStationFaultRowName;
        TextView txtStationFaultRowGroup;

        public ProductViewHolder(View itemView) {
            super(itemView);
            txtStationFaultRowCode = (TextView) itemView.findViewById(R.id.txtStationFaultRowCode);
            txtStationFaultRowName = (TextView) itemView.findViewById(R.id.txtStationFaultRowName);
            txtStationFaultRowGroup = (TextView) itemView.findViewById(R.id.txtStationFaultRowGroup);

        }
    }
}
