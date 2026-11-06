package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import com.anythink.basead.exoplayer.i.a;
import com.bytedance.sdk.openadsdk.core.component.reward.ms.ms;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean op() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void xn() {
        String str;
        super.xn();
        if (qf.h(this.ka) || this.jw.cv()) {
            return;
        }
        if (this.ul.pc()) {
            this.pc.ms(false, null, null, true, true);
            return;
        }
        int iG = ((int) this.ul.g()) / 1000;
        String str2 = this.lm.c(false) + "s";
        boolean z = iG >= this.lm.il();
        if (z) {
            str = "跳过";
        } else {
            str = re.xr().ka(String.valueOf(this.k)) ? (this.lm.il() - iG) + "s后可跳过" : null;
        }
        this.pc.ms(false, str2, str, false, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void le() {
        if (this.ah.getAndSet(true)) {
            return;
        }
        d("onAdClose");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void ah(boolean z) {
        byte b = -1;
        if (this.w) {
            if (re.xr().ad() == 1) {
                b = 2000;
            }
        } else if (z) {
            b = 0;
        }
        if (b < 0 || this.b.get()) {
            return;
        }
        if (b == 0) {
            if (this.b.getAndSet(true)) {
                return;
            }
            ms.ms().ms(String.valueOf(this.k));
            return;
        }
        this.xr.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTFullScreenVideoActivity.this.b.getAndSet(true)) {
                    return;
                }
                ms.ms().ms(String.valueOf(TTFullScreenVideoActivity.this.k));
            }
        }, a.f);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void d(String str) {
        com.bytedance.sdk.openadsdk.core.component.reward.ms.ms(1, this.eg, str, null);
    }
}
