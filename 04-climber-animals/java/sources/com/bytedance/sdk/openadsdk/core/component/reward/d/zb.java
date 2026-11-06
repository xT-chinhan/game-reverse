package com.bytedance.sdk.openadsdk.core.component.reward.d;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;

/* JADX INFO: loaded from: classes2.dex */
public class zb extends ms {
    public static boolean ms(lm lmVar) {
        return true;
    }

    public static int xr(lm lmVar) {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean am() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean sa() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected boolean ti() {
        return true;
    }

    public zb(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar) {
        super(tTBaseVideoActivity, lmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean l() {
        return am();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public void qk() {
        this.y.xr(this.xr.rk());
        if (c()) {
            this.ny.ka(8);
            this.ny.c(8);
            this.y.ms(false);
        } else {
            this.ny.ka(0);
            this.ny.c(0);
            this.y.ka(true);
            this.f2142ms.xn();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ao() {
        super.ao();
        this.y.xr(this.xr.rk());
        this.y.ka(true);
        this.ny.c(0);
        this.ny.ka(0);
        this.f2142ms.xn();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void b() {
        super.b();
        e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void v() {
        if (qf.h(this.xr)) {
            boolean z = !qf.ah();
            boolean zAh = qf.ah();
            this.f2142ms.ah(0);
            if (w() > lm() || this.ao) {
                com.bytedance.sdk.openadsdk.core.x.d.f3760ms = 0;
                this.y.ms(this.u, this.u ? "领取成功" : "", z ? "跳过" : "", zAh, true);
                this.f2142ms.il();
                return;
            }
            int iC = c(true);
            int iC2 = c(false);
            com.bytedance.sdk.openadsdk.core.x.d.f3760ms = iC;
            boolean z2 = w() > this.p.ka() || this.f2142ms.qf();
            this.y.ms(this.u, iC2 + "s" + (this.u ? "后可领取奖励" : ""), z && z2 ? "跳过" : "", zAh && z2, z2);
            xr(iC);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected boolean s() {
        if (!this.u) {
            return false;
        }
        if (this.xr.fm() == 2 && this.xr.du() == 3) {
            return false;
        }
        return (this.xr.fm() == 2 && this.xr.du() == 7) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public int cv() {
        return xr(this.xr);
    }
}
