package com.byazt.fg;

import android.view.View;
import com.byazt.ln.ViewPager;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1666, 26})
public class qg implements ViewPager.l {
    @Override // com.byazt.ln.ViewPager.l
    public void n(View view, float f) {
        int width = view.getWidth();
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                view.setTranslationX((-width) * f);
            } else {
                view.setTranslationX(width);
                view.setTranslationX((-width) * f);
            }
            view.setAlpha(Math.max(0.0f, 1.0f - Math.abs(f)));
            return;
        }
        view.setAlpha(0.0f);
    }
}
