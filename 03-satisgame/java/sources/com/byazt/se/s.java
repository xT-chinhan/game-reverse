package com.byazt.se;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1270, 8})
public class s extends n {
    public boolean cp;
    public boolean d;
    public int fs = 1;
    public w l;
    public fs q;
    public int rv;
    public com.byazt.zq.qg tj;
    public Context w;
    public String x;

    public s(Context context, String str, w wVar, fs fsVar, com.byazt.zq.qg qgVar, boolean z) {
        this.w = context;
        this.x = str;
        this.l = wVar;
        this.cp = wVar.l();
        this.qg = wVar.qg();
        this.q = fsVar;
        this.tj = qgVar;
        this.d = z;
    }

    public w q() {
        return this.l;
    }

    public fs l() {
        return this.q;
    }

    public Context getContext() {
        return this.w;
    }

    public String w() {
        return this.x;
    }

    public com.byazt.zq.qg x() {
        return this.tj;
    }

    public int fs() {
        return this.rv;
    }

    public boolean rv() {
        return this.cp;
    }
}
