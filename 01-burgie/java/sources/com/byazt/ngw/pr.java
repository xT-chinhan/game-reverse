package com.byazt.ngw;

import android.view.View;
import com.byazt.cqf.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1024, 37})
public class pr implements ViewPager.c {
    @Override // com.byazt.cqf.ViewPager.c
    public void pr(View view, float f) {
        float width = f < 0.0f ? view.getWidth() : 0.0f;
        float height = view.getHeight() * 0.5f;
        view.setPivotX(width);
        view.setPivotY(height);
        view.setRotationY(f * 90.0f);
    }
}
