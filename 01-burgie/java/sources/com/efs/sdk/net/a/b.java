package com.efs.sdk.net.a;

import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Serializable {
    String a;
    long b;
    public String c;
    public String d;
    public String e;
    public long f;
    public int g;
    public String h;
    public long i;

    public final String toString() {
        return "OkHttpInterceptorModle{mRequestId='" + this.a + "', mUrl='" + this.d + "', mMethod='" + this.e + "', mStatus=" + this.g + ", mContentType='" + this.h + "', mCreateTime=" + this.b + ", mCURL='" + this.c + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
