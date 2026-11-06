package com.byazt.ngw;

import android.text.TextUtils;
import android.view.View;
import com.byazt.cqf.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1024, 121})
public class x implements ViewPager.c {
    public String pr;

    public void pr(String str) {
        this.pr = str;
    }

    @Override // com.byazt.cqf.ViewPager.c
    public void pr(View view, float f) {
        if (f >= -1.0f && f <= 1.0f) {
            view.setAlpha(1.0f);
            view.setTranslationX(view.getWidth() * (-f));
            view.setTranslationY(view.getHeight() * f);
        } else {
            view.setAlpha(0.0f);
        }
        if (TextUtils.equals(this.pr, "cube")) {
            float height = f < 0.0f ? view.getHeight() : 0.0f;
            view.setPivotX(view.getWidth() * 0.5f);
            view.setPivotY(height);
            view.setRotationX(f * (-90.0f));
        }
    }
}
