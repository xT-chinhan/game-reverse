package com.byazt.ngw;

import android.view.View;
import com.byazt.cqf.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1024, 20})
public class hn implements ViewPager.c {
    public final float pr = 0.8f;
    public final float hw = 0.5f;

    @Override // com.byazt.cqf.ViewPager.c
    public void pr(View view, float f) {
        float f2;
        float f3;
        if (f < 0.0f) {
            f2 = (0.19999999f * f) + 1.0f;
        } else {
            f2 = ((-0.19999999f) * f) + 1.0f;
        }
        if (f < 0.0f) {
            f3 = (f * 0.5f) + 1.0f;
        } else {
            f3 = (f * (-0.5f)) + 1.0f;
        }
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
