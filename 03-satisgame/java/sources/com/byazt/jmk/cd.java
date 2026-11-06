package com.byazt.jmk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.stl.DynamicUnlockView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, 86})
public class cd implements x<DynamicUnlockView> {
    public final DynamicUnlockView n;

    public cd(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar) {
        int iSh;
        DynamicUnlockView dynamicUnlockView = new DynamicUnlockView(context);
        this.n = dynamicUnlockView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        if (xVar.sh() > 0) {
            iSh = xVar.sh();
        } else {
            iSh = com.byazt.twc.q.n() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.byazt.cq.fs.n(context, iSh);
        dynamicUnlockView.setLayoutParams(layoutParams);
        dynamicUnlockView.setClipChildren(false);
        dynamicUnlockView.setText(xVar.b());
    }

    @Override // com.byazt.jmk.x
    public void n() {
        DynamicUnlockView dynamicUnlockView = this.n;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.n();
        }
    }

    @Override // com.byazt.jmk.x
    public void qg() {
        DynamicUnlockView dynamicUnlockView = this.n;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.qg();
        }
    }

    @Override // com.byazt.jmk.x
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public DynamicUnlockView s() {
        return this.n;
    }
}
