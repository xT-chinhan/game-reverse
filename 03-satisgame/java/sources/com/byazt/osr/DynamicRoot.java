package com.byazt.osr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import com.byazt.lh.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 2220})
public class DynamicRoot extends DynamicBaseWidgetImp {
    public qg n;

    public DynamicRoot(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        return super.fs();
    }

    @Override // com.byazt.osr.DynamicBaseWidget
    public qg n(Bitmap bitmap) {
        n nVar = new n(bitmap, this.n);
        this.n = nVar;
        return nVar;
    }

    @Override // com.byazt.osr.DynamicBaseWidget
    public GradientDrawable getDrawable() {
        qg qgVar = new qg();
        this.n = qgVar;
        return qgVar;
    }

    @Override // com.byazt.osr.DynamicBaseWidget
    public GradientDrawable n(GradientDrawable.Orientation orientation, int[] iArr) {
        qg qgVar = new qg(orientation, iArr);
        this.n = qgVar;
        return qgVar;
    }
}
