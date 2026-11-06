package com.byazt.jmk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.stl.ClickSlideUpView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, 5})
public class q extends hd<ClickSlideUpView> {
    @Override // com.byazt.jmk.hd
    public void q() {
    }

    public q(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar) {
        super(context, dynamicBaseWidget, xVar);
        n(xVar);
    }

    private void n(com.byazt.lh.x xVar) {
        this.n = new ClickSlideUpView(this.qg);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.byazt.cq.fs.n(this.qg, xVar.sh());
        this.n.setLayoutParams(layoutParams);
        this.n.setSlideText(this.q.b());
        if (this.n instanceof ClickSlideUpView) {
            ((ClickSlideUpView) this.n).setButtonText(this.q.tj());
        }
    }

    @Override // com.byazt.jmk.hd, com.byazt.jmk.x
    public void n() {
        this.n.n();
    }

    @Override // com.byazt.jmk.hd, com.byazt.jmk.x
    public void qg() {
        this.n.qg();
    }
}
