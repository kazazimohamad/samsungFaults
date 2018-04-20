package com.samsungfaults.zilu.samsungfaults;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by haniyehkhaksar on 1/18/18.
 */

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder> {

    private List<ReportModel> reportModelList;
    private Context context;

    public ReportAdapter(Context context, List<ReportModel> reportModelList) {
        this.reportModelList = reportModelList;
        this.context = context;
    }

    @Override
    public ReportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_report, parent, false);
        ReportViewHolder holder = new ReportViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ReportViewHolder holder, final int position) {

        holder.tvStation.setText(context.getString(R.string.station_id)
                + " " + reportModelList.get(position).getStationId());

        holder.tvError.setText(context.getString(R.string.error_id)
                + " " + reportModelList.get(position).getErrorId());

        holder.tvModel.setText(context.getString(R.string.model_code)
                + " " + reportModelList.get(position).getModelCode());

        holder.tvCount.setText(reportModelList.get(position).getCount() + "");

        if (position % 2 == 0) {
            holder.tvStation.setBackgroundColor(context.getResources().getColor(R.color.tableOddRow));
            holder.tvError.setBackgroundColor(context.getResources().getColor(R.color.tableOddRow));
            holder.tvModel.setBackgroundColor(context.getResources().getColor(R.color.tableOddRow));
        }

        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = reportModelList.get(position).getCount();
                holder.tvCount.setText((count + 1) + "");
                reportModelList.get(position).setCount(count+1);
                int k = new DatabaseHelper(context).updateReport(reportModelList.get(position).getId(), count + 1);
                int k2 = new DatabaseHelper(context).updateExcelReport(reportModelList.get(position).getId(), count + 1);
                Log.i("updateeee", k + "");
            }
        });

//        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int count = reportModelList.get(position).getCount();
//                if (count - 1 <= 0) {
//                    Toast.makeText(context, "Invalid Number. Must be > 0", Toast.LENGTH_LONG).show();
//                } else {
//                    holder.tvCount.setText((count - 1) + "");
//                    reportModelList.get(position).setCount(count - 1);
//                    new DatabaseHelper(context).updateReport(reportModelList.get(position).getId(), count - 1);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return reportModelList.size();
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder {

        private TextView tvStation;
        private TextView tvError;
        private TextView tvModel;
        private TextView tvCount;
        private Button btnPlus;
        //private Button btnMinus;

        public ReportViewHolder(View itemView) {
            super(itemView);

            tvStation = (TextView) itemView.findViewById(R.id.tvStation);
            tvError = (TextView) itemView.findViewById(R.id.tvError);
            tvModel = (TextView) itemView.findViewById(R.id.tvModel);
            tvCount = (TextView) itemView.findViewById(R.id.tvCount);
            btnPlus = (Button) itemView.findViewById(R.id.btnPlus);
            //btnMinus = (Button) itemView.findViewById(R.id.btnMinus);
        }
    }
}
