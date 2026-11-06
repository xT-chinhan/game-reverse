package com.bytedance.adsdk.ugeno.swiper.ms;

import android.view.View;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements ViewPager.ka {
    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.ka
    public void ms(View view, float f) {
        float width = f < 0.0f ? view.getWidth() : 0.0f;
        float height = view.getHeight() * 0.5f;
        view.setPivotX(width);
        view.setPivotY(height);
        view.setRotationY(f * 90.0f);
    }
}
