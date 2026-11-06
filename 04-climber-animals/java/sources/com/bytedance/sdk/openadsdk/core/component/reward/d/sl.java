package com.bytedance.sdk.openadsdk.core.component.reward.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sl extends ms {
    private com.bytedance.sdk.openadsdk.core.zb.ka f;
    int jw;
    int pc;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean am() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public boolean c() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean l() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean sa() {
        return false;
    }

    public sl(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar) {
        super(tTBaseVideoActivity, lmVar);
        this.pc = 0;
        this.jw = 0;
        com.bytedance.sdk.openadsdk.core.zb.ka kaVar = new com.bytedance.sdk.openadsdk.core.zb.ka(lmVar);
        this.f = kaVar;
        kaVar.ms(true);
    }

    public static boolean ms(lm lmVar) {
        return lmVar.yu() == 1 && t.ms(lmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void xr(boolean z) {
        super.xr(z);
        this.f.ah();
        if (this.ny instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) this.ny).ny();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ah(boolean z) {
        super.ah(z);
        if (this.ny instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) {
            if (((com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) this.ny).c()) {
                this.f.ms(((com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) this.ny).ka().get());
            }
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) this.ny).x();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ub() {
        super.ub();
        if ((this.ny instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) this.ny).c()) {
            this.f.d();
        }
        this.ny.ch();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void u() {
        super.u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public void qk() {
        this.ny.ka(0);
        this.y.ms(true);
        if (com.bytedance.sdk.openadsdk.core.ugeno.ch.d(this.xr)) {
            this.y.ka(true);
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.ch.ka(this.xr) || com.bytedance.sdk.openadsdk.core.ugeno.ch.d(this.xr)) {
            this.y.xr(false);
        } else {
            this.y.xr(this.xr.rk());
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.ch.ah(this.xr)) {
            this.y.ah(true);
            this.y.ka(true);
            this.y.ms(this.u, f() + "s" + (this.u ? "后可领取奖励" : ""), null, true, true);
        } else {
            this.y.ka(false);
            this.y.ms(false, null, null, true, true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ka(boolean z) {
        super.ka(z);
        if (com.bytedance.sdk.openadsdk.core.ugeno.ch.d(this.xr)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) this.ny).xr(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public boolean of() {
        if (f() > 0) {
            return false;
        }
        if (!com.bytedance.sdk.openadsdk.core.ugeno.ch.ka(this.xr)) {
            return true;
        }
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) this.ny).ms(0);
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    protected int ab(boolean z) {
        if ((this.nw.pc() && t.ms(this.xr)) || this.pc == 0) {
            return 0;
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.ch.ka(this.xr) || com.bytedance.sdk.openadsdk.core.ugeno.ch.d(this.xr)) {
            return Math.max(this.pc - w(), 0);
        }
        return Math.max(Math.min(this.pc, 27) - w(), 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    protected int ul() {
        if ((this.nw.pc() && t.ms(this.xr)) || this.pc == 0) {
            return 0;
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.ch.ka(this.xr) || com.bytedance.sdk.openadsdk.core.ugeno.ch.d(this.xr)) {
            return Math.max(this.pc - w(), 0);
        }
        return Math.max(((int) Math.min((this.pc * this.xr.cb()) / 100.0f, 27.0f)) - w(), 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void x() {
        JSONObject jSONObjectAh;
        super.x();
        com.bytedance.sdk.openadsdk.core.playable.xr.ms().ms(this.xr);
        if (com.bytedance.sdk.openadsdk.core.ugeno.ch.ka(this.xr) || com.bytedance.sdk.openadsdk.core.ugeno.ch.d(this.xr)) {
            com.bytedance.sdk.openadsdk.core.ugeno.ny.ms msVarLe = this.xr.le();
            this.pc = 30;
            if (msVarLe != null && (jSONObjectAh = msVarLe.ah()) != null) {
                this.pc = jSONObjectAh.optInt("reward_time", 30);
            }
        } else {
            this.pc = nw.ka(this.xr);
        }
        this.jw = nw.c(this.xr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public View ny() {
        FrameLayout frameLayout = new FrameLayout(this.f2142ms);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms, com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void ah() {
        this.y.ms(4);
        this.ny.ah(true);
        if (com.bytedance.sdk.openadsdk.core.ugeno.ch.ka(this.xr) || com.bytedance.sdk.openadsdk.core.ugeno.ch.d(this.xr)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) this.ny).ms(Math.max(0, this.pc - w()));
        }
        this.f2142ms.xr(true, true);
        yu();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xr ms(boolean z) {
        this.ny = new com.bytedance.sdk.openadsdk.core.component.reward.layout.ms(this.f2142ms, this.xr, z, this.f, this.y);
        return this.ny;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms ms(final com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar) {
        this.f2142ms.e();
        this.f2142ms.lm();
        com.bytedance.sdk.openadsdk.core.component.reward.ah.x xVar = new com.bytedance.sdk.openadsdk.core.component.reward.ah.x(this.f2142ms, this.xr);
        xVar.ms(this.nw.t());
        xVar.ms(az());
        return xVar.xr(new com.bytedance.sdk.openadsdk.core.component.reward.ah.ch() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.sl.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void ms() {
                com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.ms();
                }
                if (com.bytedance.sdk.openadsdk.core.ugeno.ch.d(sl.this.xr) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) sl.this.ny).d()) {
                    return;
                }
                sl.this.f2142ms.k();
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
    public void nw() {
        super.nw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void b() {
        if (com.bytedance.sdk.openadsdk.core.ugeno.ch.d(this.xr) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) this.ny).ah()) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) this.ny).ms(false);
        } else {
            super.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void v() {
        int iW = w();
        int iMax = Math.max(0, this.pc - iW);
        if (!this.nw.pc()) {
            int i = this.pc;
            if (iW >= i) {
                if (com.bytedance.sdk.openadsdk.core.ugeno.ch.ah(this.xr)) {
                    this.y.ms(this.u, this.u ? "领取成功" : "", null, true, true);
                } else {
                    this.y.ms(false, null, null, true, true);
                }
                this.f2142ms.zb();
            } else if (this.jw >= i) {
                this.y.ms(false, String.valueOf(iMax), null, false, false);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.ch.ah(this.xr)) {
                this.y.ms(this.u, iMax + "s" + (this.u ? "后可领取奖励" : ""), null, this.jw <= iW, true);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.ch.ka(this.xr) || com.bytedance.sdk.openadsdk.core.ugeno.ch.d(this.xr)) {
                if (iW >= this.jw) {
                    this.y.ms(false, null, null, true, true);
                }
            } else if (iW >= this.jw) {
                this.y.ms(false, String.valueOf(iMax), "跳过", false, true);
            } else {
                this.y.ms(false, String.valueOf(iMax), (this.jw - iW) + "s后可跳过", false, false);
            }
        }
        this.f2142ms.ah(0);
        if (com.bytedance.sdk.openadsdk.core.ugeno.ch.ka(this.xr)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) this.ny).ms(iMax);
        }
        if (iMax == 0 && (this.ny instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.ms)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ms) this.ny).ab();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public int cv() {
        return xr(this.xr);
    }

    public static int xr(lm lmVar) {
        return com.bytedance.sdk.openadsdk.core.ugeno.ch.ah(lmVar) ? 6 : 7;
    }
}
