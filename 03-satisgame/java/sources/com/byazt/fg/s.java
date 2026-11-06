package com.byazt.fg;

import android.view.View;
import com.byazt.ln.ViewPager;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1666, 8})
public class s implements ViewPager.l {
    public final float n = 0.8f;
    public final float qg = 0.5f;

    @Override // com.byazt.ln.ViewPager.l
    public void n(View view, float f) {
        float f2 = ((f < 0.0f ? 0.19999999f : -0.19999999f) * f) + 1.0f;
        float f3 = (f * (f < 0.0f ? 0.5f : -0.5f)) + 1.0f;
        if (f < 0.0f) {
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight() / 2);
        } else {
            view.setPivotX(0.0f);
            view.setPivotY(view.getHeight() / 2);
        }
        view.setScaleX(f2);
        view.setScaleY(f2);
        view.setAlpha(Math.abs(f3));
    }
}
