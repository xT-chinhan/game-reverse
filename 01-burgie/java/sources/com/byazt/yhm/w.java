package com.byazt.yhm;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.jt.HandLongPressView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, 109})
public class w implements fw {
    public HandLongPressView pr;

    public w(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar) {
        this.pr = new HandLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.byazt.js.zo.pr(context, 180.0f), (int) com.byazt.js.zo.pr(context, 180.0f));
        layoutParams.gravity = 17;
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
    public ViewGroup hn() {
        return this.pr;
    }
}
