package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.RewardGuideSlideUp;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.tapsdk.tapad.e.a;

/* JADX INFO: loaded from: classes2.dex */
public class d extends xr {
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.ah ao;
    private float h;
    private float qv;
    private boolean t;
    private RecyclerView u;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.ms ub;
    private boolean y;
    private RewardGuideSlideUp zb;

    public d(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, boolean z) {
        super(tTBaseVideoActivity, lmVar, z);
        this.y = true;
    }

    public void ms(float[] fArr) {
        this.h = fArr[0];
        this.qv = fArr[1];
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ms() {
        super.ms();
        this.u = (RecyclerView) this.ab.findViewById(2114387891);
        this.zb = (RewardGuideSlideUp) this.ab.findViewById(2114387966);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.ah ahVar = new com.bytedance.sdk.openadsdk.core.component.reward.draw.ah(this.xr, 1, false);
        this.ao = ahVar;
        this.u.setLayoutManager(ahVar);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.ms msVar = new com.bytedance.sdk.openadsdk.core.component.reward.draw.ms(this.xr, this.h, this.qv);
        this.ub = msVar;
        this.u.setAdapter(msVar);
        this.zb.ms();
    }

    public RecyclerView xr() {
        return this.u;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.draw.ms ah() {
        return this.ub;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.draw.ah d() {
        return this.ao;
    }

    public void ka() {
        if (this.y) {
            this.ab.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.d.1
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.y) {
                        d.this.y = false;
                        ul.ms((View) d.this.zb, 0);
                        d.this.zb.getSlideUpAnimatorSet().start();
                        d.this.t = true;
                        d.this.ab.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.d.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.c();
                            }
                        }, a.f);
                    }
                }
            }, 0L);
        }
    }

    public void c() {
        this.y = false;
        if (this.t) {
            ul.ms((View) this.zb, 8);
            this.zb.xr();
            this.t = false;
        }
    }

    public void ms(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.ah ahVar = this.ao;
        if (ahVar == null) {
            return;
        }
        ahVar.xr(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ch() {
        super.ch();
        if (this.zb != null) {
            c();
        }
    }
}
