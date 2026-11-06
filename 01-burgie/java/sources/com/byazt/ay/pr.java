package com.byazt.ay;

import android.util.SparseArray;
import com.bytedance.android.live.base.api.callback.Callback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 786, 37})
public class pr implements Callback<Object> {
    public final Function<SparseArray<Object>, Object> pr;

    public pr(Function<SparseArray<Object>, Object> function) {
        this.pr = function;
    }

    @Override // com.bytedance.android.live.base.api.callback.Callback
    public void invoke(Object obj) {
        if (this.pr != null) {
            this.pr.apply(com.byazt.ij.hn.pr().pr(0, obj).pr(-99999987, 1).hw().sparseArray());
        }
    }
}
