package com.byazt.yhm;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.jt.ClickSlideUpView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, 121})
public class x extends yb<ClickSlideUpView> {
    public x(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar) {
        super(context, dynamicBaseWidget, fwVar);
        pr(fwVar);
    }

    private void pr(com.byazt.rk.fw fwVar) {
        this.pr = new ClickSlideUpView(this.hw);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.byazt.js.zo.pr(this.hw, fwVar.r());
        this.pr.setLayoutParams(layoutParams);
        this.pr.setSlideText(this.x.o());
        if (this.pr instanceof ClickSlideUpView) {
            ((ClickSlideUpView) this.pr).setButtonText(this.x.vk());
        }
    }

    @Override // com.byazt.yhm.yb
    public void x() {
    }

    @Override // com.byazt.yhm.yb, com.byazt.yhm.fw
    public void pr() {
        this.pr.pr();
    }

    @Override // com.byazt.yhm.yb, com.byazt.yhm.fw
    public void hw() {
        this.pr.hw();
    }
}
