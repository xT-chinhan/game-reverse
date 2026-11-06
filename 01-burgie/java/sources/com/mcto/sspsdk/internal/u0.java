package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 {
    public int a;
    public long b;
    public String c;
    public String d;
    public String e;
    public final String f;
    public final String g;
    public final String h;
    public String i;
    public final String j;
    public final int k;
    public int l;
    public int m;
    public final int n;
    public final String o;
    public final String p;
    public int q = 0;

    public u0(t0 t0Var) {
        this.a = t0Var.a;
        this.b = t0Var.b;
        this.c = t0Var.c;
        this.d = t0Var.d;
        this.e = t0Var.e;
        this.f = t0Var.f;
        this.g = t0Var.g;
        this.h = t0Var.h;
        this.i = t0Var.i;
        this.k = t0Var.j;
        this.l = t0Var.k;
        this.n = t0Var.l;
        this.o = t0Var.m;
        this.p = t0Var.n;
        this.m = t0Var.o;
        this.j = t0Var.p;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = TextUtils.isEmpty(this.i) ? b() : this.i;
        }
        return this.e;
    }

    public final String b() {
        if (!TextUtils.isEmpty(this.c)) {
            return this.c;
        }
        String strConcat = gj.d(this.d + this.i).concat(".apk");
        this.c = strConcat;
        return strConcat;
    }

    public final String c() {
        return "ApkDownloadConfig{apkName='" + this.i + "', appName='" + this.g + "', downloadLength=0, status=" + this.a + ", fileSize=" + this.b + ", createTime=0, fileName='" + this.c + "', downloadUrl='" + this.d + "', downloadKey='" + this.e + "', appIcon='" + this.h + "', dtt=" + this.k + ", realDt=" + this.l + ", firstDt=" + this.n + ", dbEventType=" + this.m + AbstractJsonLexerKt.END_OBJ;
    }
}
