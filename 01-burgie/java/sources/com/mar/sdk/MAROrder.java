package com.mar.sdk;

/* JADX INFO: loaded from: classes2.dex */
public class MAROrder {
    private String extension;
    private String orderID;
    private String productID;
    private String productName;

    public MAROrder() {
    }

    public MAROrder(String orderID, String productID, String productName, String extension) {
        this.orderID = orderID;
        this.productID = productID;
        this.productName = productName;
        this.extension = extension;
    }

    public String getOrderID() {
        return this.orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return this.productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
