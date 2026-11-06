package com.byazt.jmk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.stl.CircleLongPressView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, 26})
public class qg implements x {
    public CircleLongPressView n;

    public qg(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar) {
        this.n = new CircleLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.byazt.cq.fs.n(context, 180.0f), (int) com.byazt.cq.fs.n(context, 180.0f));
        layoutParams.gravity = 17;
        this.n.setLayoutParams(layoutParams);
        this.n.setGuideText(xVar.b());
    }

    @Override // com.byazt.jmk.x
    public void n() {
        this.n.n();
    }

    @Override // com.byazt.jmk.x
    public void qg() {
        this.n.qg();
    }

    @Override // com.byazt.jmk.x
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public CircleLongPressView s() {
        return this.n;
    }
}
