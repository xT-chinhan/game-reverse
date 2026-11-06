package com.byazt.osr;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.lh.fs;
import com.byazt.stl.TTRatingBar2;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 2279})
public class DynamicStarView extends DynamicBaseWidgetImp {
    public int n;

    public DynamicStarView(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        this.n = 0;
        this.k = new TTRatingBar2(context, null);
        this.k.setTag(Integer.valueOf(getClickArea()));
        addView(this.k, getWidgetLayoutParams());
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        int iN = (int) ((com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.l()) * 5.0f) + com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.s() + com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.q())));
        if (this.x > iN && 4 == this.d.fs()) {
            this.n = (this.x - iN) / 2;
        }
        this.x = iN;
        return new FrameLayout.LayoutParams(this.x, this.fs);
    }

    @Override // com.byazt.osr.DynamicBaseWidget
    public void l() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.x, this.fs);
        layoutParams.topMargin = this.tj;
        layoutParams.leftMargin = this.rv + this.n;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        double dOa = this.d.oa();
        if (com.byazt.twc.q.n() && (dOa < 0.0d || dOa > 5.0d || (this.sz != null && this.sz.getRenderRequest() != null && this.sz.getRenderRequest().d() != 4))) {
            this.k.setVisibility(8);
            return true;
        }
        double d = (dOa < 0.0d || dOa > 5.0d) ? 5.0d : dOa;
        this.k.setVisibility(0);
        ((TTRatingBar2) this.k).n(d, this.d.x(), (int) this.d.l(), ((int) com.byazt.cq.fs.n(this.cp, this.d.qg())) + ((int) com.byazt.cq.fs.n(this.cp, this.d.n())) + ((int) com.byazt.cq.fs.n(this.cp, this.d.l())));
        return true;
    }
}
