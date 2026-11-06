package com.bytedance.sdk.openadsdk.core.component.reward.d;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends ms {
    public static int xr(lm lmVar) {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean am() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean l() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected boolean s() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected boolean ti() {
        return true;
    }

    public ka(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar) {
        super(tTBaseVideoActivity, lmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public View ny() {
        if (this.ah == 2) {
            int iKz = this.xr.kz();
            if (iKz == 3) {
                return com.bytedance.sdk.openadsdk.res.ka.ao(this.f2142ms);
            }
            if (iKz == 33) {
                return com.bytedance.sdk.openadsdk.res.ka.h(this.f2142ms);
            }
            return com.bytedance.sdk.openadsdk.res.ka.qv(this.f2142ms);
        }
        int iKz2 = this.xr.kz();
        if (iKz2 == 3) {
            return com.bytedance.sdk.openadsdk.res.ka.y(this.f2142ms);
        }
        if (iKz2 == 33) {
            return com.bytedance.sdk.openadsdk.res.ka.t(this.f2142ms);
        }
        return com.bytedance.sdk.openadsdk.res.ka.nw(this.f2142ms);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xr ms(boolean z) {
        this.ny = new com.bytedance.sdk.openadsdk.core.component.reward.layout.c(this.f2142ms, this.xr, z);
        return this.ny;
    }

    public static boolean ms(lm lmVar) {
        return (lmVar == null || lm.xr(lmVar)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean sa() {
        if (this.ch.c()) {
            return this.ch.ch();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public void qk() {
        this.ny.ka(8);
        this.ny.c(8);
        this.y.ka(com.bytedance.sdk.openadsdk.op.ch.ms(this.xr));
        this.y.xr(this.xr.rk());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void v() {
        super.v();
        if (qf.h(this.xr)) {
            this.f2142ms.ah(0);
            int iW = w();
            if (iW > lm() || this.ao) {
                com.bytedance.sdk.openadsdk.core.x.d.f3760ms = 0;
                this.y.ms(this.u, this.u ? "领取成功" : "", null, true, true);
                this.f2142ms.il();
                if (this.ch == null || re() != 7) {
                    return;
                }
                this.ch.ms((CharSequence) "0", iW, 0, false);
                return;
            }
            int iC = c(true);
            int iC2 = c(false);
            com.bytedance.sdk.openadsdk.core.x.d.f3760ms = iC;
            boolean z = iW > this.p.ka() || this.f2142ms.qf();
            this.y.ms(this.u, iC2 + "s" + (this.u ? "后可领取奖励" : ""), null, z, z);
            xr(iC);
            if (this.ch == null || re() != 7) {
                return;
            }
            this.ch.ms((CharSequence) String.valueOf(iC2), iW, 0, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public int cv() {
        return xr(this.xr);
    }
}
