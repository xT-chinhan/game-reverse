package com.byazt.mh;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1152, 13})
public abstract class hw implements Function<SparseArray<Object>, Object> {
    public abstract void pr(Object obj);

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null && ((Integer) sparseArray.get(-99999987)).intValue() == 1) {
            pr(sparseArray.get(0, Object.class));
            return null;
        }
        return null;
    }
}
