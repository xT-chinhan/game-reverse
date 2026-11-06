package com.byazt.osr;

import android.content.Context;
import android.view.View;
import com.byazt.lh.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 118})
public class DynamicSplitLineView extends DynamicBaseWidgetImp {
    public DynamicSplitLineView(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        this.k = new View(context);
        addView(this.k, getWidgetLayoutParams());
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        this.k.setBackgroundColor(this.d.ur());
        return true;
    }
}
