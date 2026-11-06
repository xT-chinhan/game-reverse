package com.byazt.se;

import com.byazt.gct.y;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1270, 18})
public class l extends n {
    public static int l = 2;
    public static int q = 1;
    public String fs;
    public com.byazt.mz.l rv;
    public com.byazt.zq.qg w;
    public y x;

    public l(com.byazt.zq.qg qgVar, y yVar, com.byazt.mz.l lVar) {
        this.w = qgVar;
        this.x = yVar;
        if (qgVar != null) {
            this.fs = qgVar.q();
        }
        this.rv = lVar;
    }

    public com.byazt.zq.qg q() {
        return this.w;
    }

    public y l() {
        return this.x;
    }

    public String w() {
        return this.fs;
    }

    public com.byazt.mz.l x() {
        return this.rv;
    }
}
