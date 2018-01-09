package com.samsungfaults.zilu.samsungfaults;

/**
 * Created by mohamad on 12/26/2017.
 */
public class ProductModel {
    private Integer id;
    private String productName;

    public ProductModel(){

    }
    public ProductModel(String prdName){
        this.productName = prdName;
    }
    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }
}
