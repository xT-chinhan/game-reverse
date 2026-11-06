package com.bytedance.adsdk.ugeno.swiper.ms;

import android.view.View;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ViewPager.ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final float f396ms = 0.8f;
    final float xr = 0.5f;

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.ka
    public void ms(View view, float f) {
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
