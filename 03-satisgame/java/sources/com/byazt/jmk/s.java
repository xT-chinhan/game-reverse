package com.byazt.jmk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.stl.ClickInteractView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, 8})
public class s implements x {
    public ClickInteractView n;

    public s(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar) {
        this.n = new ClickInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicBaseWidget.getDynamicHeight(), dynamicBaseWidget.getDynamicHeight());
        layoutParams.gravity = 17;
        this.n.setLayoutParams(layoutParams);
    }

    @Override // com.byazt.jmk.x
    public void n() {
        this.n.n();
    }

    @Override // com.byazt.jmk.x
    public void qg() {
        this.n.qg();
    }

    @Override // com.byazt.jmk.x
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public ClickInteractView s() {
        return this.n;
    }
}
