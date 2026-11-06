package com.byazt.yhm;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.jt.PressButtonInteractView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, 250})
public class k implements fw {
    public PressButtonInteractView pr;

    public k(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar) {
        this.pr = new PressButtonInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicBaseWidget.getDynamicHeight(), dynamicBaseWidget.getDynamicHeight());
        layoutParams.gravity = 8388629;
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
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public PressButtonInteractView hn() {
        return this.pr;
    }
}
