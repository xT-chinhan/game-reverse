package com.byazt.h;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1688, 37})
public class pr {
    public final SparseArray<Object> pr;

    private pr() {
        this.pr = new SparseArray<>();
    }

    public pr(SparseArray<Object> sparseArray) {
        this.pr = sparseArray;
    }

    public static pr pr(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        return new pr(sparseArray);
    }

    public pr pr(int i, Object obj) {
        this.pr.put(i, obj);
        return this;
    }

    public SparseArray<Object> pr() {
        return this.pr;
    }
}
