package com.bytedance.adsdk.ugeno.swiper.ms;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements ViewPager.ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f395ms;

    public void ms(String str) {
        this.f395ms = str;
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.ka
    public void ms(View view, float f) {
        if (f >= -1.0f && f <= 1.0f) {
            view.setAlpha(1.0f);
            view.setTranslationX(view.getWidth() * (-f));
            view.setTranslationY(view.getHeight() * f);
        } else {
            view.setAlpha(0.0f);
        }
        if (TextUtils.equals(this.f395ms, "cube")) {
            float height = f < 0.0f ? view.getHeight() : 0.0f;
            view.setPivotX(view.getWidth() * 0.5f);
            view.setPivotY(height);
            view.setRotationX(f * (-90.0f));
        }
    }
}
