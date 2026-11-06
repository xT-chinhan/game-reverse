package com.byazt.ld;

import com.byazt.pp.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1423, 13})
public class w {
    public static final w n = new w();
    public final k<String, com.byazt.pp.w> qg = new k<>(20);

    public static w n() {
        return n;
    }

    public com.byazt.pp.w n(String str) {
        if (str == null) {
            return null;
        }
        return this.qg.n(str);
    }

    public void n(String str, com.byazt.pp.w wVar) {
        if (str == null) {
            return;
        }
        this.qg.n(str, wVar);
    }

    public void n(int i) {
        this.qg.n(i);
    }
}
