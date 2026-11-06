package com.byazt.jmk;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.stl.BluePressInteractView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, 19})
public class n implements x {
    public BluePressInteractView n;

    public n(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar) {
        double dIc = xVar.ic();
        dIc = dIc == 0.0d ? 1.0d : dIc;
        double dCi = xVar.ci();
        double d = dCi != 0.0d ? dCi : 1.0d;
        int dynamicWidth = (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * dIc);
        int dynamicWidth2 = (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * d);
        this.n = new BluePressInteractView(context, dynamicWidth, dynamicWidth2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicWidth, dynamicWidth2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) com.byazt.cq.fs.n(context, xVar.cx() - 7);
        layoutParams.leftMargin = (int) com.byazt.cq.fs.n(context, xVar.lq() - 3);
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
    public ViewGroup s() {
        return this.n;
    }
}
