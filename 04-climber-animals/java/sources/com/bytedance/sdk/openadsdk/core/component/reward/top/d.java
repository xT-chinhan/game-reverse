package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.ah.ch;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ah {
    public d(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, com.bytedance.sdk.openadsdk.core.component.reward.xr.xr xrVar, com.bytedance.sdk.openadsdk.core.component.reward.xr.ka kaVar, boolean z) {
        super(tTBaseVideoActivity, lmVar, xrVar, kaVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ah, com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void ah(View view) {
        super.ah(view);
        this.ka.ah(this.ah.f());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ah, com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void xr(View view) {
        super.xr(view);
        this.ka.ul();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ah, com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void ms(View view) {
        super.ms(view);
        if (ms()) {
            return;
        }
        this.ka.am().xr();
        if (this.ah.az()) {
            this.ka.ms();
        } else if (qf.h(this.xr)) {
            xr();
        } else {
            ah();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ah, com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void c(View view) {
        super.c(view);
        ms();
    }

    private void xr() {
        ch chVar = new ch() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.d.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void xr() {
                d.this.ka.ms();
            }
        };
        if (this.ka.ms(chVar)) {
            this.c--;
        } else {
            chVar.xr();
        }
    }

    private void ah() {
        this.ka.ms();
    }
}
