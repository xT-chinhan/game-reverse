package com.byazt.gx;

import android.content.Context;
import android.os.Build;
import android.widget.FrameLayout;
import com.byazt.jt.TTRatingBar2;
import com.byazt.rk.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 2060})
public class DynamicStarView extends DynamicBaseWidgetImp {
    public int pr;

    public DynamicStarView(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        this.pr = 0;
        this.ho = new TTRatingBar2(context, null);
        this.ho.setTag(Integer.valueOf(getClickArea()));
        addView(this.ho, getWidgetLayoutParams());
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        int iPr = (int) ((com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.c()) * 5.0f) + com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.hn() + com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.x())));
        if (this.fw > iPr && 4 == this.k.zo()) {
            this.pr = (this.fw - iPr) / 2;
        }
        this.fw = iPr;
        return new FrameLayout.LayoutParams(this.fw, this.zo);
    }

    @Override // com.byazt.gx.DynamicBaseWidget
    public void c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.fw, this.zo);
        layoutParams.topMargin = this.vk;
        layoutParams.leftMargin = this.aj + this.pr;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        super.zo();
        double dM = this.k.m();
        if (com.byazt.dj.x.pr() && (dM < 0.0d || dM > 5.0d || (this.g != null && this.g.getRenderRequest() != null && this.g.getRenderRequest().k() != 4))) {
            this.ho.setVisibility(8);
            return true;
        }
        double d = (dM < 0.0d || dM > 5.0d) ? 5.0d : dM;
        this.ho.setVisibility(0);
        ((TTRatingBar2) this.ho).pr(d, this.k.fw(), (int) this.k.c(), ((int) com.byazt.js.zo.pr(this.w, this.k.hw())) + ((int) com.byazt.js.zo.pr(this.w, this.k.pr())) + ((int) com.byazt.js.zo.pr(this.w, this.k.c())));
        return true;
    }
}
