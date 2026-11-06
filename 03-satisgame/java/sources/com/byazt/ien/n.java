package com.byazt.ien;

import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1989, 19})
public abstract class n {
    public List<com.byazt.nd.w.qg> n;
    public l qg;

    public abstract int n();

    public abstract String n(String str, String str2);

    public abstract InputStream q();

    public abstract boolean qg();

    public abstract List<com.byazt.nd.w.qg> s();

    public l l() {
        return this.qg;
    }

    public com.byazt.nd.w.qg n(String str) {
        List<com.byazt.nd.w.qg> list;
        if (str != null && (list = this.n) != null && list.size() > 0) {
            for (com.byazt.nd.w.qg qgVar : this.n) {
                if (str.equals(qgVar.n)) {
                    return qgVar;
                }
            }
        }
        return null;
    }
}
