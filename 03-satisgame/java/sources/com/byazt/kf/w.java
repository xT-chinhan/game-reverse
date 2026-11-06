package com.byazt.kf;

import android.app.Activity;
import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1116, 13})
public class w extends s {
    public w(com.byazt.pl.qg qgVar, Function<SparseArray<Object>, Object> function) {
        super(qgVar, function);
    }

    @Override // com.byazt.sg.s
    public void n(Activity activity, Object obj, String str) {
        try {
            s(activity);
        } catch (Exception unused) {
        }
    }

    public void s(Activity activity) {
        if (this.tj != null) {
            this.tj.w();
        }
        if (this.cp != null) {
            this.cp.apply(com.byazt.of.qg.n().n(8113).n(Void.class).n(20033, activity).qg());
        }
    }
}
