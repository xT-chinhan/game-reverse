package com.byazt.kf;

import android.util.SparseArray;
import android.view.View;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1116, 26})
public class qg extends s {
    public qg(com.byazt.pl.qg qgVar, Function<SparseArray<Object>, Object> function) {
        super(qgVar, function);
    }

    @Override // com.byazt.sg.s
    public View rv() {
        return tv();
    }

    public View tv() {
        try {
            if (this.cp != null) {
                Object objApply = this.cp.apply(com.byazt.of.qg.n().n(8113).n(View.class).qg());
                if (objApply instanceof View) {
                    return (View) objApply;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
