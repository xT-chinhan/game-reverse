package com.efs.sdk.net.a;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Serializable {
    String a;
    long b;
    public String c;
    public String d;
    public String e;
    public Map<String, String> f;
    public long g;
    public String h;
    public int i;
    public String j;
    public String k;
    public Map<String, String> l;
    public long m;

    public final String toString() {
        return "OkHttpInterceptorModle{mRequestId='" + this.a + "', mUrl='" + this.d + "', mMethod='" + this.e + "', mStatus=" + this.i + ", mContentType='" + this.j + "', mCreateTime=" + this.b + ", mCURL='" + this.c + "'}";
    }
}
