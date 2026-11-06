package com.qq.e.comm.constants;

/* JADX INFO: loaded from: classes3.dex */
public enum LoginType {
    Unknow(0),
    WeiXin(1),
    QQ(2);

    private int a;

    LoginType(int i) {
        this.a = i;
        ordinal();
    }

    public int getValue() {
        return this.a;
    }
}
