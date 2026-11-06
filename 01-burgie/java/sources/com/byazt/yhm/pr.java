package com.byazt.yhm;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.jt.BluePressInteractView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, 37})
public class pr implements fw {
    public BluePressInteractView pr;

    public pr(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar) {
        double dMw = fwVar.mw();
        dMw = dMw == 0.0d ? 1.0d : dMw;
        double dSv = fwVar.sv();
        double d = dSv != 0.0d ? dSv : 1.0d;
        int dynamicWidth = (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * dMw);
        int dynamicWidth2 = (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * d);
        this.pr = new BluePressInteractView(context, dynamicWidth, dynamicWidth2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicWidth, dynamicWidth2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) com.byazt.js.zo.pr(context, fwVar.od() - 7);
        layoutParams.leftMargin = (int) com.byazt.js.zo.pr(context, fwVar.vj() - 3);
        this.pr.setLayoutParams(layoutParams);
    }

    @Override // com.byazt.yhm.fw
    public void pr() {
        this.pr.pr();
    }

    @Override // com.byazt.yhm.fw
    public void hw() {
        this.pr.hw();
    }

    @Override // com.byazt.yhm.fw
    public ViewGroup hn() {
        return this.pr;
    }
}
