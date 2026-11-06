package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.swiper.BaseSwiper;

/* JADX INFO: loaded from: classes2.dex */
public class SwiperView extends BaseSwiper<ViewGroup> {
    public SwiperView(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View ab(int i) {
        return (ViewGroup) this.f389ms.get(i);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper, com.bytedance.adsdk.ugeno.viewpager.ViewPager.d
    public void x(int i) {
        super.x(i);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper, com.bytedance.adsdk.ugeno.viewpager.ViewPager.d
    public void ny(int i) {
        super.ny(i);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View ms(int i, int i2) {
        if (this.f389ms.size() == 0) {
            return new View(getContext());
        }
        View viewAb = ab(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewAb instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (viewAb.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewAb.getParent()).removeView(viewAb);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(viewAb, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }
}
