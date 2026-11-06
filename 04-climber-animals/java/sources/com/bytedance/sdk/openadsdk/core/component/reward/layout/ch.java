package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ch extends xr {
    private float u;
    private FullSwiperView ub;
    private float zb;

    public ch(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, boolean z) {
        super(tTBaseVideoActivity, lmVar, z);
    }

    public void ms(float[] fArr) {
        this.zb = fArr[0];
        this.u = fArr[1];
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ms() {
        super.ms();
        this.ab.setBackgroundColor(0);
        this.ub = new FullSwiperView(this.xr);
    }

    public void ms(List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.ms> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.ub.ms(list).ms(this.zb).xr(this.u).ms(String.valueOf(f.ny(this.ah))).ms();
        this.ab.addView(this.ub, new FrameLayout.LayoutParams(-1, -1));
    }

    public void xr() {
        FullSwiperView fullSwiperView = this.ub;
        if (fullSwiperView != null) {
            fullSwiperView.xr();
        }
    }

    public void ah() {
        FullSwiperView fullSwiperView = this.ub;
        if (fullSwiperView != null) {
            fullSwiperView.ah();
        }
    }

    public void d() {
        FullSwiperView fullSwiperView = this.ub;
        if (fullSwiperView != null) {
            fullSwiperView.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ch() {
        super.ch();
        FullSwiperView fullSwiperView = this.ub;
        if (fullSwiperView != null) {
            fullSwiperView.ka();
        }
    }

    public int ka() {
        FullSwiperView fullSwiperView = this.ub;
        if (fullSwiperView != null) {
            return fullSwiperView.getCurrentPosition();
        }
        return 0;
    }
}
