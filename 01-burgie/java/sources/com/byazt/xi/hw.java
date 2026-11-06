package com.byazt.xi;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2018, 13})
public class hw {
    public final SparseArray<Object> pr = new SparseArray<>();

    private hw() {
    }

    public static hw pr() {
        return new hw();
    }

    public hw pr(int i) {
        this.pr.put(-99999987, Integer.valueOf(i));
        return this;
    }

    public hw pr(Class<?> cls) {
        this.pr.put(-99999985, cls);
        return this;
    }

    public hw pr(int i, Object obj) {
        this.pr.put(i, obj);
        return this;
    }

    public SparseArray<Object> hw() {
        return this.pr;
    }
}
