package com.byazt.jmk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.stl.ClickSlideUpView;
import com.byazt.stl.ClickSlideUpView2;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, 18})
public class l extends hd<ClickSlideUpView> {
    @Override // com.byazt.jmk.hd
    public void q() {
    }

    public l(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar) {
        super(context, dynamicBaseWidget, xVar);
        n(xVar);
    }

    private void n(com.byazt.lh.x xVar) {
        this.n = new ClickSlideUpView2(this.qg);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.n.setLayoutParams(layoutParams);
        if (this.n instanceof ClickSlideUpView2) {
            ((ClickSlideUpView2) this.n).setButtonText(this.q.b());
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
