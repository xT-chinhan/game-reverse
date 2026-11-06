package com.byazt.fg;

import android.view.View;
import com.byazt.ln.ViewPager;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1666, 19})
public class n implements ViewPager.l {
    @Override // com.byazt.ln.ViewPager.l
    public void n(View view, float f) {
        float width = f < 0.0f ? view.getWidth() : 0.0f;
        float height = view.getHeight() * 0.5f;
        view.setPivotX(width);
        view.setPivotY(height);
        view.setRotationY(f * 90.0f);
    }
}
