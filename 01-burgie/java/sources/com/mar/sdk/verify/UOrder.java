package com.mar.sdk.verify;

/* JADX INFO: loaded from: classes2.dex */
public class UOrder {
    private String extension;
    private String order;
    private String productID;
    private int state;

    public UOrder(int state) {
        this.state = state;
    }

    public UOrder(String order, String ext, String productID) {
        this.order = order;
        this.extension = ext;
        this.productID = productID;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getProductID() {
        return this.productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
