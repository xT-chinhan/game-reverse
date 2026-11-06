package com.bytedance.sdk.openadsdk.core.component.reward.d;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.nw.l;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends ms {
    private final AtomicBoolean az;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.ms.ms e;
    private long f;
    private final int jw;
    private final com.bytedance.sdk.openadsdk.core.video.xr.xr k;
    private final AtomicBoolean lm;
    private final AtomicBoolean m;
    protected final AtomicLong pc;
    private final AtomicBoolean ul;

    public static int xr(lm lmVar) {
        return 10;
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
    public boolean s() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean sa() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean tz() {
        return true;
    }

    public ny(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar) {
        super(tTBaseVideoActivity, lmVar);
        this.jw = 4;
        this.f = 4L;
        this.ul = new AtomicBoolean(false);
        this.az = new AtomicBoolean(false);
        this.m = new AtomicBoolean(false);
        this.lm = new AtomicBoolean(false);
        this.pc = new AtomicLong();
        this.k = new com.bytedance.sdk.openadsdk.core.video.xr.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ny.1
            @Override // com.bytedance.sdk.openadsdk.core.video.xr.xr
            public boolean ms() {
                if (!ny.this.m.get() && !l.xr(ny.this.xr)) {
                    return false;
                }
                ny.this.rt();
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.xr
            public void xr() {
                ny.this.m.set(false);
                ny.this.ny.ka(8);
                if (!ny.this.ab()) {
                    ny.this.f2142ms.k();
                }
                ny.this.f2142ms.i();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.xr
            public void ms(long j, long j2) {
                ny.this.t.xr(j);
                ny.this.t();
                ny.this.pc.set(j);
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.xr
            public void ah() {
                ny.this.p();
                ny.this.lm.set(true);
                ny.this.f2142ms.zb();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.xr
            public boolean d() {
                return ny.this.lm.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.xr
            public long ka() {
                return ny.this.pc.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.xr
            public boolean c() {
                return ny.this.b.c();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.xr
            public Map<String, Object> ab() {
                HashMap map = new HashMap();
                map.put(TTDownloadField.TT_REFER, "in_video");
                return map;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.xr
            public void x() {
                ny.this.vy();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.xr
            public void ny() {
                ny.this.f2142ms.k();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.xr
            public void ch() {
                if (ny.this.f2142ms != null) {
                    ny.this.f2142ms.sl();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.xr
            public int hi() {
                return ny.this.m.get() ? 1 : 2;
            }
        };
    }

    public static boolean ms(lm lmVar) {
        return l.ms(lmVar);
    }

    public void zf() {
        if (this.az.get()) {
            return;
        }
        int iG = (int) this.t.g();
        int iNw = (int) this.t.nw();
        int iAh = l.ah(this.xr);
        if (iAh == 1) {
            ms(l.d(this.xr), iNw, 1000 * ((long) this.p.ah()), false);
        } else if (iAh == 2) {
            ms((int) (iNw * 0.001f * 0.01f * l.d(this.xr)), iNw, iG, false);
        } else {
            if (iAh != 3) {
                return;
            }
            ms(f(), iNw, iG, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt() {
        this.ny.ka(0);
        this.f2142ms.e();
        this.e.ah();
        this.f2142ms.re();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vy() {
        this.ul.set(false);
    }

    private void ms(int i, long j, long j2, boolean z) {
        if (z) {
            if (i <= 3) {
                sk();
            }
        } else if (i > 0) {
            long j3 = ((long) i) * 1000;
            if (j3 > j) {
                return;
            }
            long j4 = j3 - j2;
            if (j4 <= 0 || Math.abs(j4) > 3200) {
                return;
            }
            sk();
        }
    }

    private void sk() {
        this.az.set(true);
        this.e.ms();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public void qk() {
        this.ny.ka(8);
        this.ny.c(0);
        this.y.ka(true);
        this.y.ah(true);
        this.y.xr(true);
        this.y.ms(true);
        this.f2142ms.xn();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void vm() {
        if (this.i != null) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.i.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.k);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.i.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(this.k);
        }
        if (this.x != null) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.x.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.k);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.x.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(this.k);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.ms.ms msVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.ms.ms(this.f2142ms, this.xr, this.k);
        this.e = msVar;
        msVar.ms(this.f2142ms.jw().getSceneFrameContainer(), this.f2142ms.jw().getSceneFrame());
        this.ul.set(l.ah(this.xr) != 0);
        if (this.ul.get()) {
            yu();
            this.h = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public int cv() {
        return xr(this.xr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void v() {
        gy();
        if (qf.h(this.xr)) {
            this.f2142ms.ah(0);
            if (w() > lm() || this.ao) {
                com.bytedance.sdk.openadsdk.core.x.d.f3760ms = 0;
            }
            xr(c(true));
            com.bytedance.sdk.openadsdk.core.x.d.f3760ms = az();
        }
    }

    private void gy() {
        if (this.ul.get()) {
            zf();
            vl();
        }
    }

    private void vl() {
        if (this.az.get()) {
            long j = this.f - 1;
            this.f = j;
            if (j != 0) {
                if (j > 0) {
                    this.e.ms(j);
                }
            } else {
                this.e.ms(j);
                this.m.set(true);
                if (ab()) {
                    this.e.ms(this.i);
                } else {
                    this.e.ms(this.x);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void t() {
        super.t();
        this.h = false;
        boolean z = ((int) (this.t.g() / 1000)) >= this.p.ka() || this.f2142ms.qf();
        if (this.t.pc()) {
            this.y.ms(false, null, "跳过", false, true);
            return;
        }
        int iCv = this.t.cv();
        if (this.t.ms()) {
            return;
        }
        this.y.ms(false, iCv + "s", z ? "跳过" : "", false, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void p() {
        super.p();
        this.y.ms(false, "奖励已领取", "跳过", false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void i() {
        super.i();
        this.y.ms(false, "奖励已领取", "跳过", false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public com.bytedance.sdk.openadsdk.core.video.xr.xr pc() {
        return this.k;
    }
}
