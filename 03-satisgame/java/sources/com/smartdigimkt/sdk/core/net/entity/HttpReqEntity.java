package com.smartdigimkt.sdk.core.net.entity;

import com.smartdigimkt.f.i;

/* JADX INFO: loaded from: classes3.dex */
public class HttpReqEntity {
    private String urlType = "";
    private String interceptKey = "";

    private HttpReqEntity() {
    }

    public static HttpReqEntity create() {
        return new HttpReqEntity();
    }

    public String getInterceptKey() {
        return this.interceptKey;
    }

    public String getUrlType() {
        return this.urlType;
    }

    public void setInterceptKey(String str) {
        this.interceptKey = str;
    }

    public String toString() {
        return i.a(new StringBuilder("HttpReqEntity{urlType='").append(this.urlType).append("', interceptKey='"), this.interceptKey, "'}");
    }

    public static HttpReqEntity create(String str) {
        HttpReqEntity httpReqEntity = new HttpReqEntity();
        httpReqEntity.urlType = str;
        return httpReqEntity;
    }

    public static HttpReqEntity create(String str, String str2) {
        HttpReqEntity httpReqEntity = new HttpReqEntity();
        httpReqEntity.urlType = str;
        httpReqEntity.interceptKey = str2;
        return httpReqEntity;
    }
}
