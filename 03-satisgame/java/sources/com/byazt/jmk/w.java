package com.byazt.jmk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.stl.ClickSlideUpShakeView;
import com.byazt.stl.ShakeAnimationView;
import com.byazt.stl.ShakeClickView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, 13})
public class w extends hd<ClickSlideUpShakeView> implements k {
    @Override // com.byazt.jmk.hd
    public void q() {
    }

    public w(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar, com.byazt.lh.tj tjVar, boolean z, int i) {
        super(context, dynamicBaseWidget, xVar);
        this.qg = context;
        this.q = xVar;
        this.s = dynamicBaseWidget;
        n(tjVar, xVar, z, i);
    }

    private void n(com.byazt.lh.tj tjVar, com.byazt.lh.x xVar, boolean z, int i) {
        int iSh;
        this.n = new ClickSlideUpShakeView(this.qg, tjVar, z, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.byazt.cq.fs.n(this.qg, 300.0f));
        layoutParams.gravity = 81;
        Context context = this.qg;
        if (xVar.sh() > 0) {
            iSh = xVar.sh();
        } else {
            iSh = com.byazt.twc.q.n() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.byazt.cq.fs.n(context, iSh);
        this.n.setLayoutParams(layoutParams);
        this.n.setClipChildren(false);
        this.n.setSlideText(this.q.b());
        if (this.n instanceof ClickSlideUpShakeView) {
            ((ClickSlideUpShakeView) this.n).setShakeText(this.q.nf());
            final ShakeClickView shakeView = ((ClickSlideUpShakeView) this.n).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new ShakeAnimationView.n() { // from class: com.byazt.jmk.w.1
                    @Override // com.byazt.stl.ShakeAnimationView.n
                    public void n(boolean z2) {
                        if (w.this.s.getDynamicClickListener() != null) {
                            w.this.s.getDynamicClickListener().n(z2, w.this);
                        }
                        shakeView.performClick();
                    }
                });
                shakeView.setOnClickListener((View.OnClickListener) this.s.getDynamicClickListener());
            }
        }
    }

    @Override // com.byazt.jmk.k
    public void l() {
        if (this.n.getParent() != null) {
            ((ViewGroup) this.n.getParent()).setVisibility(8);
        }
    }
}
