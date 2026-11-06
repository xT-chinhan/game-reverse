package com.byazt.ld;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1423, 8})
public class s {
    public Typeface l;
    public final String n;
    public final float q;
    public final String qg;
    public final String s;

    public s(String str, String str2, String str3, float f) {
        this.n = str;
        this.qg = str2;
        this.s = str3;
        this.q = f;
    }

    public String n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public String s() {
        return this.s;
    }

    public Typeface q() {
        return this.l;
    }

    public void n(Typeface typeface) {
        this.l = typeface;
    }
}
