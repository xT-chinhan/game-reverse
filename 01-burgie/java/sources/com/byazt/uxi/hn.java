package com.byazt.uxi;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1300, 20})
public class hn {
    public Typeface c;
    public final String hn;
    public final String hw;
    public final String pr;
    public final float x;

    public hn(String str, String str2, String str3, float f) {
        this.pr = str;
        this.hw = str2;
        this.hn = str3;
        this.x = f;
    }

    public String pr() {
        return this.pr;
    }

    public String hw() {
        return this.hw;
    }

    public String hn() {
        return this.hn;
    }

    public Typeface x() {
        return this.c;
    }

    public void pr(Typeface typeface) {
        this.c = typeface;
    }
}
