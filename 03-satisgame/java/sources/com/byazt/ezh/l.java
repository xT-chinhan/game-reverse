package com.byazt.ezh;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 166, 18})
public class l {
    public String n;
    public int qg;
    public com.byazt.kc.n s;

    public l(String str, int i) {
        this.n = str;
        this.qg = i;
    }

    public l(com.byazt.kc.n nVar) {
        if (nVar != null) {
            this.n = nVar.qg();
            this.qg = nVar.s();
            this.s = nVar;
        }
    }
}
