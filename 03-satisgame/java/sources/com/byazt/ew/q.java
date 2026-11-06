package com.byazt.ew;

/* JADX INFO: loaded from: classes.dex */
public enum q {
    TYPE_2G("2g"),
    TYPE_3G("3g"),
    TYPE_4G("4g"),
    TYPE_5G("5g"),
    TYPE_WIFI("wifi"),
    TYPE_MOBILE("mobile"),
    TYPE_UNKNOWN("unknown");

    public String fs;

    q(String str) {
        this.fs = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.fs;
    }
}
