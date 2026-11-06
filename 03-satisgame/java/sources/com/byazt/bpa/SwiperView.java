package com.byazt.bpa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.lb.BaseSwiper;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 405, 1173})
public class SwiperView extends BaseSwiper<ViewGroup> {
    public SwiperView(Context context) {
        super(context);
    }

    @Override // com.byazt.lb.BaseSwiper
    public View cp(int i) {
        return (ViewGroup) this.n.get(i);
    }

    @Override // com.byazt.lb.BaseSwiper, com.byazt.ln.ViewPager.q
    public void d(int i) {
        super.d(i);
    }

    @Override // com.byazt.lb.BaseSwiper, com.byazt.ln.ViewPager.q
    public void oa(int i) {
        super.oa(i);
    }

    @Override // com.byazt.lb.BaseSwiper
    public View n(int i, int i2) {
        if (this.n.isEmpty()) {
            return new View(getContext());
        }
        View viewCp = cp(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewCp instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (viewCp.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewCp.getParent()).removeView(viewCp);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(viewCp, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }
}
