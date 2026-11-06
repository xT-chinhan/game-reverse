package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.swiper.BaseSwiper;
import com.bytedance.sdk.openadsdk.core.nw.le;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.u.d;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class FullSwiperView extends FrameLayout {
    private boolean ab;
    private Context ah;
    private String c;
    private List<Long> ch;
    private float d;
    private List<FullSwiperItemView> hi;
    private float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private BaseSwiper<ViewGroup> f2237ms;
    private List<Integer> ny;
    private int sl;
    private AtomicBoolean u;
    private List<Integer> x;
    private List<ms> xr;
    private boolean zb;

    public FullSwiperView(Context context) {
        super(context);
        this.ab = false;
        this.zb = true;
        this.u = new AtomicBoolean(false);
        this.ah = context;
        this.x = new ArrayList();
        this.ny = new ArrayList();
        this.ch = new ArrayList();
        this.f2237ms = new SwiperView(context);
        this.hi = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.f2237ms, layoutParams);
    }

    public FullSwiperView ms(List<ms> list) {
        this.xr = list;
        return this;
    }

    public FullSwiperView ms(float f) {
        this.d = f;
        return this;
    }

    public FullSwiperView xr(float f) {
        this.ka = f;
        return this;
    }

    public FullSwiperView ms(String str) {
        this.c = str;
        return this;
    }

    public void ms() {
        le leVarFi;
        List<ms> list = this.xr;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f2237ms.ms(false).ms("dot").d(false).ah(false).xr(false);
        this.f2237ms.setOnPageChangeListener(new com.bytedance.adsdk.ugeno.swiper.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.1
            @Override // com.bytedance.adsdk.ugeno.swiper.ms
            public void ms(boolean z, int i, int i2, boolean z2, boolean z3) {
                FullSwiperView.this.sl = i;
                FullSwiperItemView fullSwiperItemViewXr = FullSwiperView.this.xr(i);
                if (fullSwiperItemViewXr != null && FullSwiperView.this.sl != 0) {
                    fullSwiperItemViewXr.xr(false);
                }
                FullSwiperItemView fullSwiperItemViewXr2 = FullSwiperView.this.xr(i - 1);
                if (fullSwiperItemViewXr2 != null) {
                    fullSwiperItemViewXr2.ao();
                    fullSwiperItemViewXr2.qv();
                }
                FullSwiperView.this.ms(i + 1);
                if (!FullSwiperView.this.ab && i > 0) {
                    FullSwiperView.this.ab = true;
                    d.xr(FullSwiperView.this.c);
                }
                int iIntValue = ((Integer) FullSwiperView.this.x.get(i)).intValue();
                if (iIntValue > 0 && i != FullSwiperView.this.hi.size() - 1) {
                    FullSwiperView.this.ch.add(i, Long.valueOf(System.currentTimeMillis()));
                    if (FullSwiperView.this.u.get()) {
                        return;
                    }
                    FullSwiperView.this.f2237ms.hi(iIntValue);
                }
            }
        });
        for (ms msVar : this.xr) {
            lm lmVarMs = msVar.ms();
            if (lmVarMs != null && (leVarFi = lmVarMs.fi()) != null) {
                this.x.add(Integer.valueOf((int) leVarFi.xr()));
                this.ny.add(0);
                this.ch.add(Long.valueOf(System.currentTimeMillis()));
                FullSwiperItemView fullSwiperItemView = new FullSwiperItemView(this.ah, msVar, this.d, this.ka);
                fullSwiperItemView.setOnSwiperItemInteractListener(new FullSwiperItemView.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.2
                    @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.ms
                    public void ms() {
                        FullSwiperView.this.f2237ms.c();
                        FullSwiperView.this.u.set(true);
                    }
                });
                this.f2237ms.ms(fullSwiperItemView);
                this.hi.add(fullSwiperItemView);
            }
        }
        final FullSwiperItemView fullSwiperItemView2 = this.hi.get(0);
        fullSwiperItemView2.setOnSwiperItemRenderResultListener(new FullSwiperItemView.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.xr
            public void ms(View view, float f, float f2) {
                int iIntValue = ((Integer) FullSwiperView.this.x.get(0)).intValue();
                if (iIntValue <= 0) {
                    FullSwiperView.this.f2237ms.ka();
                } else {
                    FullSwiperView.this.ch.add(0, Long.valueOf(System.currentTimeMillis()));
                    FullSwiperView.this.f2237ms.ka();
                    FullSwiperView.this.f2237ms.hi(iIntValue);
                }
                fullSwiperItemView2.xr(true);
                FullSwiperView.this.ms(1);
            }
        });
        fullSwiperItemView2.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        FullSwiperItemView fullSwiperItemViewXr = xr(i);
        if (fullSwiperItemViewXr != null) {
            fullSwiperItemViewXr.u();
        }
    }

    public void xr() {
        FullSwiperItemView fullSwiperItemViewXr = xr(this.sl);
        if (fullSwiperItemViewXr != null) {
            fullSwiperItemViewXr.ao();
        }
        List<Long> list = this.ch;
        if (list != null && this.sl < list.size()) {
            this.ny.add(this.sl, Integer.valueOf(this.x.get(this.sl).intValue() - ((int) (System.currentTimeMillis() - this.ch.get(this.sl).longValue()))));
        }
        this.f2237ms.c();
    }

    public void ah() {
        FullSwiperItemView fullSwiperItemViewXr = xr(this.sl);
        if (fullSwiperItemViewXr != null) {
            fullSwiperItemViewXr.h();
        }
        if (this.sl == this.hi.size() - 1) {
            return;
        }
        this.f2237ms.ch(this.sl);
        List<Integer> list = this.ny;
        if (list == null || this.sl >= list.size()) {
            return;
        }
        if (!this.zb && !this.u.get()) {
            this.f2237ms.hi(this.ny.get(this.sl).intValue());
        }
        this.zb = false;
    }

    public void d() {
        BaseSwiper<ViewGroup> baseSwiper = this.f2237ms;
        if (baseSwiper != null) {
            baseSwiper.c();
        }
    }

    public void ka() {
        for (FullSwiperItemView fullSwiperItemView : this.hi) {
            if (fullSwiperItemView != null) {
                fullSwiperItemView.y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FullSwiperItemView xr(int i) {
        List<FullSwiperItemView> list = this.hi;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.hi.get(i);
    }

    public int getCurrentPosition() {
        return this.sl;
    }
}
