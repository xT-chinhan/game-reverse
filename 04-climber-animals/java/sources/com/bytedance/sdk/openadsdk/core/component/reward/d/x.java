package com.bytedance.sdk.openadsdk.core.component.reward.d;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.nw.eg;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.t;

/* JADX INFO: loaded from: classes2.dex */
public class x extends ms {
    boolean f;
    int jw;
    int pc;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean am() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public boolean c() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean l() {
        return true;
    }

    public x(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar) {
        super(tTBaseVideoActivity, lmVar);
        this.pc = 0;
        this.jw = 0;
        this.f = false;
    }

    public static boolean ms(lm lmVar) {
        return nw.ah(lmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public View ny() {
        return com.bytedance.sdk.openadsdk.res.ka.ms(this.f2142ms);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public View ch() {
        if (t.d(this.xr)) {
            this.hi = new RewardJointEndCardFrameLayout(this.f2142ms, this.xr);
        }
        return super.ch();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms, com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void ah() {
        this.y.ms(4);
        this.nw.ms();
        this.f2142ms.t();
        if (t.hi(this.xr)) {
            this.y.xr(true);
        }
        this.pc = nw.ka(this.xr);
        this.jw = nw.c(this.xr);
        yu();
        if (t.d(this.xr)) {
            this.f2142ms.ka();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean sa() {
        return t.d(this.xr) && lm.xr(this.xr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    protected int ab(boolean z) {
        int i;
        if (t.hi(this.xr) || (i = this.pc) == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min(i, 27.0f)) - w());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    protected int ul() {
        if (t.hi(this.xr) || this.pc == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min((this.pc * this.xr.cb()) / 100.0f, 27.0f)) - w());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public void qk() {
        this.y.ms(true);
        this.ny.c(8);
        if (t.ms(this.xr)) {
            zf();
        } else {
            this.y.ka(true);
            this.y.xr(this.xr.rk());
        }
    }

    public void zf() {
        int iVv = this.xr.vv();
        if (iVv == 0) {
            this.ny.ka(0);
            this.y.ka(true);
            this.y.xr(this.xr.rk());
        } else {
            if (iVv != 1) {
                if (iVv != 3) {
                    return;
                }
                this.y.ka(false);
                this.y.xr(false);
                this.y.ms(false, null, null, true, true);
                return;
            }
            this.ny.ka(0);
            this.y.xr(this.xr.rk());
            if (t.d(this.xr)) {
                this.y.ka(lm.xr(this.xr));
            } else {
                this.y.ka(com.bytedance.sdk.openadsdk.op.ch.ms(this.xr));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void x() {
        super.x();
        com.bytedance.sdk.openadsdk.core.playable.xr.ms().ms(this.xr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void xr(boolean z) {
        super.xr(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void u() {
        super.u();
        this.f2142ms.lm();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ah(boolean z) {
        super.ah(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ub() {
        super.ub();
        com.bytedance.sdk.openadsdk.core.playable.xr.ms().xr(this.xr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public boolean of() {
        if (f() > 0) {
            return false;
        }
        if (!t.d(this.xr) && eg.ms(this.xr) == 0) {
            return this.nw.t();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void v() {
        if (t.hi(this.xr)) {
            return;
        }
        int iW = w();
        int i = this.pc;
        int i2 = i - iW;
        if (iW >= i) {
            this.y.ms(false, null, null, true, true);
            if (!t.hi(this.xr)) {
                this.f2142ms.zb();
            }
        } else {
            int i3 = this.jw;
            if (i3 >= i) {
                this.y.ms(false, String.valueOf(i2), null, false, false);
            } else if (iW >= i3) {
                this.y.ms(false, String.valueOf(i2), "跳过", false, true);
            } else {
                this.y.ms(false, String.valueOf(i2), (this.jw - iW) + "s后可跳过", false, false);
            }
        }
        this.f2142ms.ah(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected boolean s() {
        return t.d(this.xr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms ms(final com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar) {
        if (this.b.ka()) {
            return new com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms(false, 0, "");
        }
        this.f2142ms.e();
        this.f2142ms.lm();
        com.bytedance.sdk.openadsdk.core.component.reward.ah.x xVar = new com.bytedance.sdk.openadsdk.core.component.reward.ah.x(this.f2142ms, this.xr);
        xVar.ms(this.nw.t());
        xVar.ms(az());
        return xVar.xr(new com.bytedance.sdk.openadsdk.core.component.reward.ah.ch() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.x.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void ms() {
                com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.ms();
                }
                x.this.f2142ms.k();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void xr() {
                com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.xr();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public int cv() {
        return xr(this.xr);
    }

    public static int xr(lm lmVar) {
        return t.ms(lmVar) ? 6 : 0;
    }
}
