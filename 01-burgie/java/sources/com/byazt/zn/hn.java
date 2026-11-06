package com.byazt.zn;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 94, 20})
public class hn extends pr {
    public int aj;
    public uc c;
    public String fw;
    public boolean k;
    public Context uc;
    public com.byazt.qe.hw vk;
    public boolean w;
    public zo x;
    public int zo = 1;

    public hn(Context context, String str, uc ucVar, zo zoVar, com.byazt.qe.hw hwVar, boolean z) {
        this.uc = context;
        this.fw = str;
        this.c = ucVar;
        this.w = ucVar.c();
        this.hw = ucVar.hw();
        this.x = zoVar;
        this.vk = hwVar;
        this.k = z;
    }

    public uc x() {
        return this.c;
    }

    public zo c() {
        return this.x;
    }

    public Context getContext() {
        return this.uc;
    }

    public String uc() {
        return this.fw;
    }

    public com.byazt.qe.hw fw() {
        return this.vk;
    }

    public int zo() {
        return this.aj;
    }

    public boolean aj() {
        return this.w;
    }
}
