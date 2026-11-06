package com.byazt.yhm;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.jt.PressInteractView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, 108})
public class m implements fw<PressInteractView> {
    public PressInteractView pr;

    public m(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar) {
        this.pr = new PressInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.byazt.js.zo.pr(context, 180.0f), (int) com.byazt.js.zo.pr(context, 180.0f));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) com.byazt.js.zo.pr(context, 20.0f);
        this.pr.setLayoutParams(layoutParams);
        this.pr.setGuideText(fwVar.o());
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
    public PressInteractView hn() {
        return this.pr;
    }
}
