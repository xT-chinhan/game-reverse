package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.ugeno.ch;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends ah {
    public ka(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, com.bytedance.sdk.openadsdk.core.component.reward.xr.xr xrVar, com.bytedance.sdk.openadsdk.core.component.reward.xr.ka kaVar, boolean z) {
        super(tTBaseVideoActivity, lmVar, xrVar, kaVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ah, com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void ah(View view) {
        super.ah(view);
        this.ka.ah("playable");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ah, com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void xr(View view) {
        super.xr(view);
        if (t.d(this.xr)) {
            this.ka.f();
        } else {
            this.ka.ul();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ah, com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void ms(View view) {
        super.ms(view);
        if (ms()) {
            return;
        }
        this.ka.am().ms();
        if (t.hi(this.xr) || ch.ka(this.xr) || ch.d(this.xr)) {
            this.ka.hi();
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar = new com.bytedance.sdk.openadsdk.core.component.reward.ah.ch() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.ka.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void xr() {
                ka.this.ka.ub();
                ka.this.ka.ms();
            }
        };
        if (this.ka.ms(chVar)) {
            this.c--;
        } else {
            chVar.xr();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ah, com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void c(View view) {
        super.c(view);
        if (ch.ka(this.xr) || ch.d(this.xr)) {
            this.ka.hi();
        } else {
            ms();
        }
    }
}
