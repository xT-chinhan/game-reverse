package com.byazt.yhm;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.jt.DynamicUnlockView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, 48})
public class lb implements fw<DynamicUnlockView> {
    public final DynamicUnlockView pr;

    public lb(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar) {
        int iR;
        DynamicUnlockView dynamicUnlockView = new DynamicUnlockView(context);
        this.pr = dynamicUnlockView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        if (fwVar.r() > 0) {
            iR = fwVar.r();
        } else {
            iR = com.byazt.dj.x.pr() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.byazt.js.zo.pr(context, iR);
        dynamicUnlockView.setLayoutParams(layoutParams);
        dynamicUnlockView.setClipChildren(false);
        dynamicUnlockView.setText(fwVar.o());
    }

    @Override // com.byazt.yhm.fw
    public void pr() {
        DynamicUnlockView dynamicUnlockView = this.pr;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.pr();
        }
    }

    @Override // com.byazt.yhm.fw
    public void hw() {
        DynamicUnlockView dynamicUnlockView = this.pr;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.hw();
        }
    }

    @Override // com.byazt.yhm.fw
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public DynamicUnlockView hn() {
        return this.pr;
    }
}
