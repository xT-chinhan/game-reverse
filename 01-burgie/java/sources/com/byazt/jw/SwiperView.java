package com.byazt.jw;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.rij.BaseSwiper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, 1089})
public class SwiperView extends BaseSwiper<ViewGroup> {
    public SwiperView(Context context) {
        super(context);
    }

    @Override // com.byazt.rij.BaseSwiper
    public View w(int i) {
        return (ViewGroup) this.pr.get(i);
    }

    @Override // com.byazt.rij.BaseSwiper, com.byazt.cqf.ViewPager.x
    public void k(int i) {
        super.k(i);
    }

    @Override // com.byazt.rij.BaseSwiper, com.byazt.cqf.ViewPager.x
    public void m(int i) {
        super.m(i);
    }

    @Override // com.byazt.rij.BaseSwiper
    public View pr(int i, int i2) {
        if (this.pr.isEmpty()) {
            return new View(getContext());
        }
        View viewW = w(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewW instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (viewW.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewW.getParent()).removeView(viewW);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(viewW, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }
}
