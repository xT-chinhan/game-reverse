package com.byazt.xi;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2018, 20})
public class hn {
    public final SparseArray<Object> pr = new SparseArray<>();

    private hn() {
    }

    public static hn pr() {
        return new hn();
    }

    public hn pr(int i) {
        this.pr.put(-999900, Integer.valueOf(i));
        return this;
    }

    public hn pr(String str) {
        this.pr.put(-999901, str);
        return this;
    }

    public hn pr(boolean z) {
        this.pr.put(-999903, Boolean.valueOf(z));
        return this;
    }

    public hn pr(SparseArray<Object> sparseArray) {
        this.pr.put(-999902, sparseArray);
        return this;
    }

    public SparseArray<Object> hw() {
        return this.pr;
    }
}
