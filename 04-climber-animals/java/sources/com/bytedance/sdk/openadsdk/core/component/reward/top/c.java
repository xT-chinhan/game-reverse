package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.ah.ch;
import com.bytedance.sdk.openadsdk.core.component.reward.d.ny;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ah {
    public c(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, com.bytedance.sdk.openadsdk.core.component.reward.xr.xr xrVar, com.bytedance.sdk.openadsdk.core.component.reward.xr.ka kaVar, boolean z) {
        super(tTBaseVideoActivity, lmVar, xrVar, kaVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ah, com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void ah(View view) {
        super.ah(view);
        this.ka.ah("video_player");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ah, com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void xr(View view) {
        super.xr(view);
        if (this.ka.sa() instanceof ny) {
            this.ka.ul();
        }
        this.ka.f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ah, com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void ms(View view) {
        super.ms(view);
        this.ka.am().ms();
        if (qf.h(this.xr)) {
            xr();
        } else {
            ah();
        }
    }

    private void xr() {
        ch chVar = new ch() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.c.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void xr() {
                c.this.ka.ub();
                c.this.ka.az().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ka.ms();
                    }
                }, 100L);
            }
        };
        int i = 2;
        int iKa = this.ka.ka(2);
        if (this.xr.qw() == 7) {
            if (re.xr().ab(String.valueOf(f.ny(this.xr))) && !this.ka.tz()) {
                i = 1;
            }
            iKa = i;
        }
        if (iKa == 1) {
            if (this.ka.ms(chVar)) {
                return;
            }
            chVar.xr();
            return;
        }
        this.ka.xr();
    }

    private void ah() {
        ch chVar = new ch() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.c.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void xr() {
                c.this.ka.xr();
            }
        };
        if (this.ka.ms(chVar)) {
            return;
        }
        chVar.xr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ah, com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void c(View view) {
        super.c(view);
        this.ka.onSkipBorderClick(view);
    }
}
