package com.byazt.wea;

import com.byazt.gct.pk;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 571, 19})
public abstract class n implements fs {
    public int l = 0;
    public int n;
    public pk q;
    public int qg;
    public String s;
    public String w;
    public String x;

    public n(String str, String str2) {
        this.x = str;
        this.w = str2;
    }

    public String n() {
        return this.x;
    }

    public String qg() {
        return this.w;
    }

    public boolean s() {
        pk pkVar = this.q;
        if (pkVar != null) {
            return pkVar.t();
        }
        return com.byazt.nf.rv.qg().si();
    }
}
