package com.bytedance.sdk.openadsdk.core.component.reward.xr;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.c.ah.h;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.op.ch;
import com.bytedance.sdk.openadsdk.op.ny;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    com.bykv.vk.openvk.component.video.api.d.ah ab;
    private com.bykv.vk.openvk.component.video.api.ah.d ao;
    boolean c;
    private TTBaseVideoActivity ch;
    protected long d;
    private lm hi;
    protected int ka;
    private FrameLayout sl;
    private long u;
    private com.bytedance.sdk.openadsdk.core.xr.ms ub;
    long x;
    private String zb;
    private final int ny = 210;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    boolean f2301ms = false;
    protected boolean xr = false;
    protected boolean ah = false;
    private boolean h = false;

    public c(TTBaseVideoActivity tTBaseVideoActivity) {
        this.ch = tTBaseVideoActivity;
    }

    public void ms(lm lmVar) {
        this.hi = lmVar;
    }

    public void ms(FrameLayout frameLayout, String str, boolean z) {
        if (this.h) {
            return;
        }
        this.h = true;
        this.sl = frameLayout;
        this.zb = str;
        this.c = z;
        if (z) {
            this.ab = new com.bytedance.sdk.openadsdk.core.component.reward.c.xr(this.ch, this.sl, this.hi, this.ub);
        } else {
            this.ab = new com.bytedance.sdk.openadsdk.core.component.reward.c.ms(this.ch, this.sl, this.hi, this.ub);
        }
        this.ka = (int) le();
    }

    public boolean ms() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        return (ahVar == null || ahVar.h() == null || !this.ab.h().ny()) ? false : true;
    }

    public boolean xr() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        return (ahVar == null || ahVar.h() == null || !this.ab.h().zb()) ? false : true;
    }

    public boolean ah() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        return (ahVar == null || ahVar.h() == null || !this.ab.h().u()) ? false : true;
    }

    public boolean d() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        return ahVar != null && ahVar.b();
    }

    public boolean ka() {
        return this.xr;
    }

    public void ms(boolean z) {
        this.xr = z;
    }

    public long c() {
        return this.x;
    }

    public void ms(long j) {
        this.x = j;
    }

    public void xr(boolean z) {
        int i;
        if (this.ab == null) {
            return;
        }
        if (z) {
            i = ul() ? 2 : 4;
        } else {
            i = ul() ? 0 : 1;
        }
        h.ms msVar = new h.ms();
        msVar.xr(h());
        long jT = t();
        msVar.ah(jT);
        long jAo = ao();
        if (p() != null) {
            msVar.ms(p().ms(jAo, jT));
        }
        msVar.ah(1 ^ (ul() ? 1 : 0));
        msVar.d(i);
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (!(ahVar instanceof com.bytedance.sdk.openadsdk.core.video.xr.ms) || ((com.bytedance.sdk.openadsdk.core.video.xr.ms) ahVar).nw.ms(128)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.video.xr.ms) this.ab).nw.ah(128);
        com.bytedance.sdk.openadsdk.c.xr.d.ah(this.ab.qv(), msVar);
    }

    private void eg() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar == null || ahVar.h() == null) {
            return;
        }
        this.x = this.ab.hi();
        if (this.ab.h().ch() || !this.ab.h().ny()) {
            this.ab.c();
            this.ab.ny();
            this.xr = true;
        }
    }

    public void ab() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar == null) {
            return;
        }
        ahVar.ny();
        this.ab = null;
    }

    public void x() {
        if (this.ab != null && xr()) {
            this.ab.xr(true);
        }
    }

    public void ny() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            ahVar.ch();
        }
    }

    public void ms(long j, boolean z) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar == null || this.ah) {
            return;
        }
        if (j != 0) {
            ahVar.ms(j);
            this.ab.xr(z);
        } else {
            ahVar.x();
        }
    }

    public void ms(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar == null || this.ah) {
            return;
        }
        ahVar.ms(map);
    }

    public void ch() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            ahVar.xr();
        }
    }

    public boolean hi() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            return ahVar.d();
        }
        return false;
    }

    public boolean sl() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            return ahVar.ka();
        }
        return false;
    }

    public void xr(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            ahVar.xr(map);
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms interfaceC0325ms) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar instanceof com.bytedance.sdk.openadsdk.core.video.xr.ms) {
            ((com.bytedance.sdk.openadsdk.core.video.xr.ms) ahVar).ms(interfaceC0325ms);
        }
    }

    public void ah(boolean z) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            ahVar.xr(z);
        }
    }

    public boolean zb() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            return ahVar.y();
        }
        return false;
    }

    public long u() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            return ahVar.u();
        }
        return 0L;
    }

    public int ub() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            return ahVar.ub();
        }
        return 0;
    }

    public long ao() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            return ahVar.hi();
        }
        return this.x;
    }

    public long h() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            return ahVar.sl();
        }
        return 0L;
    }

    public int qv() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            return ahVar.zb();
        }
        return 0;
    }

    public void y() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar == null || ahVar.h() == null) {
            return;
        }
        this.ab.h().d();
    }

    public long t() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            return ahVar.u() + this.ab.sl();
        }
        return 0L;
    }

    public long nw() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            return ahVar.u();
        }
        return 0L;
    }

    public boolean b() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            if (ahVar.h() != null) {
                com.bykv.vk.openvk.component.video.api.ms msVarH = this.ab.h();
                if (msVarH.u() || msVarH.ub()) {
                    ((com.bytedance.sdk.openadsdk.core.video.xr.ms) this.ab).il();
                    return true;
                }
            } else if (ka()) {
                ms(false);
                ((com.bytedance.sdk.openadsdk.core.video.xr.ms) this.ab).il();
                return true;
            }
        }
        return false;
    }

    public boolean re() {
        return this.ab != null;
    }

    public boolean i() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        return ahVar != null && ahVar.h() == null;
    }

    public boolean ms(long j, boolean z, int i) {
        if (this.ab == null || qr.u(this.hi) == null) {
            return false;
        }
        com.bykv.vk.openvk.component.video.api.ah.d dVarMs = this.ao;
        if (dVarMs == null) {
            File file = new File(ny.ms(this.hi.pd()).ms(), qr.ab(this.hi));
            if (file.exists() && file.length() > 0) {
                this.f2301ms = true;
            }
            dVarMs = qr.ms(1, this.hi);
            dVarMs.xr(this.hi.df());
            FrameLayout frameLayout = this.sl;
            dVarMs.xr(frameLayout == null ? 100 : frameLayout.getWidth());
            FrameLayout frameLayout2 = this.sl;
            dVarMs.ah(frameLayout2 != null ? frameLayout2.getHeight() : 100);
            dVarMs.ah(this.hi.lx());
            dVarMs.ms(j);
            dVarMs.xr(z);
            if (ch.ms(this.hi)) {
                dVarMs.ms(true);
            }
        }
        return this.ab.ms(dVarMs);
    }

    public void w() {
        ab();
    }

    public void yu() {
        try {
            this.ch.zb(1);
        } catch (Throwable th) {
            sl.d("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
        }
    }

    public void op() {
        try {
            this.ch.u(1);
        } catch (Throwable th) {
            sl.d("TTBaseVideoActivity", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void ms(boolean z, TTBaseVideoActivity tTBaseVideoActivity, boolean z2) {
        boolean zD;
        long jKa;
        boolean zC;
        if (!z2 || z || this.ch.ti()) {
            return;
        }
        if (ah()) {
            com.bytedance.sdk.openadsdk.core.video.xr.xr xrVarPc = this.ch.sa().pc();
            if (xrVarPc != null) {
                zD = xrVarPc.d();
                jKa = xrVarPc.ka();
                zC = xrVarPc.c();
            } else {
                zD = false;
                jKa = 0;
                zC = false;
            }
            if (zD) {
                eg();
                ms(tTBaseVideoActivity);
            } else {
                ms(jKa, zC);
            }
            sl.ms("TTBaseVideoActivity", "resumeOrRestartVideo: continue play");
            return;
        }
        eg();
        ms(tTBaseVideoActivity);
        sl.ms("TTBaseVideoActivity", "resumeOrRestartVideo: recreate video player & exec play");
    }

    protected void ms(TTBaseVideoActivity tTBaseVideoActivity) {
        if (!b() || tTBaseVideoActivity == null) {
            return;
        }
        tTBaseVideoActivity.xr(c(), true);
    }

    public double le() {
        if (qr.u(this.hi) == null) {
            return 0.0d;
        }
        double dC = qr.c(this.hi);
        if (this.hi.tf() != 2 || dC <= 60.0d) {
            return dC;
        }
        return 60.0d;
    }

    public int cv() {
        return this.ka;
    }

    public long g() {
        long jOf = of();
        com.bytedance.sdk.openadsdk.core.video.xr.ms msVarP = p();
        return (msVarP == null || !msVarP.of()) ? jOf : msVarP.ms(this.d, nw());
    }

    public long of() {
        if (hi()) {
            double dC = qr.ao(this.hi).c() * 1000.0d * ((double) p().fm());
            long j = this.d;
            if (dC - j > 210.0d) {
                long j2 = (long) (j + dC);
                this.u = j2;
                return j2;
            }
        }
        return Math.max(this.d, this.u);
    }

    public void xr(long j) {
        this.d = j;
        com.bytedance.sdk.openadsdk.core.video.xr.ms msVarP = p();
        if (!sl() && hi()) {
            this.ka = (int) Math.max(0L, Math.round(le() - ((this.d + (qr.ao(this.hi).c() * 1000.0d)) / 1000.0d)));
        } else if (msVarP != null && !(this.ch.sa() instanceof com.bytedance.sdk.openadsdk.core.component.reward.d.ny)) {
            this.ka = Math.max(0, (int) (le() - (msVarP.k() / 1000)));
        } else {
            this.ka = Math.max(0, (int) (le() - (this.d / 1000)));
        }
    }

    public com.bytedance.sdk.openadsdk.core.video.xr.ms p() {
        return (com.bytedance.sdk.openadsdk.core.video.xr.ms) az();
    }

    public boolean pc() {
        com.bytedance.sdk.openadsdk.core.video.xr.ms msVarP = p();
        if (msVarP == null) {
            return false;
        }
        return msVarP.ti();
    }

    public boolean jw() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar == null) {
            return false;
        }
        return ahVar.ah();
    }

    public com.bykv.vk.openvk.component.video.api.d.xr f() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            return ahVar.qv();
        }
        return null;
    }

    public boolean ul() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar == null || ahVar.h() == null) {
            return false;
        }
        return this.ab.h().c();
    }

    public void ms(int i) {
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar != null) {
            ahVar.ms(i);
        }
    }

    public com.bykv.vk.openvk.component.video.api.d.ah az() {
        return this.ab;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void m() {
        boolean zMs;
        h.ms msVar = new h.ms();
        long jT = t();
        long jAo = ao();
        if (p() != null) {
            msVar.ms(p().ms(jAo, jT));
        }
        msVar.ah(jT);
        msVar.xr(h());
        msVar.ka(3);
        msVar.c(qv());
        com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
        if (ahVar instanceof com.bytedance.sdk.openadsdk.core.video.xr.ms) {
            ((com.bytedance.sdk.openadsdk.core.video.xr.ms) ahVar).nw.ah(32);
            zMs = ((com.bytedance.sdk.openadsdk.core.video.xr.ms) this.ab).nw.ms(2);
        } else {
            zMs = 0;
        }
        com.bytedance.sdk.openadsdk.c.xr.d.ms(f(), msVar, this.ch.ab(), !zMs);
    }

    public boolean lm() {
        return this.ah;
    }

    public void e() {
        this.ah = true;
    }

    public void k() {
        try {
            com.bykv.vk.openvk.component.video.api.d.ah ahVar = this.ab;
            if (ahVar instanceof com.bytedance.sdk.openadsdk.core.video.xr.ms) {
                ((com.bytedance.sdk.openadsdk.core.video.xr.ms) ahVar).v();
            }
        } catch (Throwable unused) {
        }
    }

    public void ms(lm lmVar, com.bykv.vk.openvk.component.video.api.d.ah ahVar, com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        this.hi = lmVar;
        this.ab = ahVar;
        this.ao = dVar;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.xr.ms msVar) {
        this.ub = msVar;
    }

    public void ms(float f) {
        if (this.ab.h() != null) {
            this.ab.h().ms(f);
        }
    }
}
