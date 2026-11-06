package com.byazt.fg;

import android.text.TextUtils;
import android.view.View;
import com.byazt.ln.ViewPager;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1666, 5})
public class q implements ViewPager.l {
    public String n;

    public void n(String str) {
        this.n = str;
    }

    @Override // com.byazt.ln.ViewPager.l
    public void n(View view, float f) {
        if (f >= -1.0f && f <= 1.0f) {
            view.setAlpha(1.0f);
            view.setTranslationX(view.getWidth() * (-f));
            view.setTranslationY(view.getHeight() * f);
        } else {
            view.setAlpha(0.0f);
        }
        if (TextUtils.equals(this.n, "cube")) {
            float height = f < 0.0f ? view.getHeight() : 0.0f;
            view.setPivotX(view.getWidth() * 0.5f);
            view.setPivotY(height);
            view.setRotationX(f * (-90.0f));
        }
    }
}
