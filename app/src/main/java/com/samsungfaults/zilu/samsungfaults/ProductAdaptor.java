package com.samsungfaults.zilu.samsungfaults;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mohamad on 12/26/2017.
 */
public class ProductAdaptor extends RecyclerView.Adapter<ProductAdaptor.ProductViewHolder> {

    private Context context;
    private List<ProductModel> models;

    public ProductAdaptor(Context context, List<ProductModel> products) {
        this.models = products;
        this.context = context;
    }

    public void notifyData(List<ProductModel> productModels){
        this.models = productModels;
        notifyDataSetChanged();
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_list_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.tvProductName.setText(models.get(position).getProductName());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView tvProductName;

        public ProductViewHolder(View itemView) {
            super(itemView);
            tvProductName = (TextView) itemView.findViewById(R.id.txtProductRowName);
        }
    }
}
