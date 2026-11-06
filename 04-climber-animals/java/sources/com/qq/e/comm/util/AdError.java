package com.qq.e.comm.util;

/* JADX INFO: loaded from: classes3.dex */
public class AdError {
    private int a;
    private String b;

    public AdError() {
    }

    public int getErrorCode() {
        return this.a;
    }

    public String getErrorMsg() {
        return this.b;
    }

    public AdError(int i, String str) {
        this.a = i;
        this.b = str;
    }
}
