package com.bytedance.sdk.openadsdk.core.component.splash.ms;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.openadsdk.core.ah.ka;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ny;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.h;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qk;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.tz;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.yu;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected long f2434ms = 0;
    protected long xr = 0;
    protected AtomicBoolean ah = new AtomicBoolean(false);
    protected AtomicBoolean d = new AtomicBoolean(false);
    protected AtomicBoolean ka = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.splash.ms.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0286ms {
        void ms();

        void ms(c cVar);
    }

    public abstract void ah();

    public abstract void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d<ny, ab> dVar, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, boolean z);

    public abstract void ms(ab abVar, String str, InterfaceC0286ms interfaceC0286ms);

    public abstract void ms(tz tzVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, boolean z);

    public abstract void ms(String str, String str2, boolean z, boolean z2, Object obj);

    public abstract void xr();

    public static ms ms() {
        return (ka.ms().hi() & 16) == 16 ? new ah() : new d();
    }

    public void ms(c cVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, boolean z, int i) {
        if (ms(i) && com.bytedance.sdk.openadsdk.core.ka.d.d.ms(cVar.xr()) && !this.ah.get()) {
            this.ah.set(true);
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "cacheRealTimeAdWhenTimeout start");
            ms(new tz(cVar.d(), cVar.xr(), null), xrVar, false);
            if (z) {
                ms(cVar.d(), cVar.xr(), xrVar);
            }
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "cacheRealTimeAdWhenTimeout end");
        }
    }

    public static boolean ms(int i) {
        int iHi = ka.ms().hi();
        if (i == 2) {
            return (iHi & 2) == 2;
        }
        return (i == 3 || i == 1) && (iHi & 32) == 32;
    }

    protected void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar) {
        if (this.ah.get()) {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "已经存储了一个实时广告");
            return;
        }
        if (this.d.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "已在预加载开屏广告....不再发出");
            return;
        }
        if (re.xr().hi(xrVar.d()) && eVar != null) {
            eVar.c = 2;
        }
        re.ms().ms(xrVar, eVar, 4, new yu.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ms.ms.1
            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(int i, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                ms.this.d.set(false);
                xrVar2.ms(i);
                com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                if (com.bytedance.sdk.openadsdk.core.component.splash.c.xr(msVar)) {
                    lm lmVar = msVar.xr().get(0);
                    if (lmVar.jl()) {
                        if ((ms.this.ah == null || !ms.this.ah.get()) && com.bytedance.sdk.openadsdk.core.ka.d.d.ms(lmVar)) {
                            ms.this.ms(new tz(msVar, lmVar, null), xrVar, false);
                            ms.this.ms(msVar, lmVar, xrVar);
                            return;
                        }
                        return;
                    }
                    xrVar2.ms(-4);
                    com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
                    return;
                }
                ms.this.d.set(false);
            }
        });
    }

    public void ms(final com.bytedance.sdk.openadsdk.core.nw.ms msVar, final lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        if (lmVar.fk() == null || lmVar.fk().size() <= 0) {
            return;
        }
        g gVar = lmVar.fk().get(0);
        String strMs = gVar.ms();
        int iXr = gVar.xr();
        int iAh = gVar.ah();
        this.f2434ms = System.currentTimeMillis();
        this.xr = SystemClock.elapsedRealtime();
        qk qkVarAh = com.bytedance.sdk.openadsdk.core.re.ka.ms().ah().ah();
        if (qkVarAh != null) {
            qkVarAh.ms(false);
        }
        final boolean z = qr.u(lmVar) != null;
        h.ms(new com.bytedance.sdk.openadsdk.zb.xr(strMs, gVar.ab()), iXr, iAh, new h.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ms.ms.2
            @Override // com.bytedance.sdk.openadsdk.core.jw.h.ms
            public void ms(com.bytedance.sdk.openadsdk.core.re.ms.xr xrVar2, hi hiVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.c.ms(msVar);
                if (!z) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, "splash_ad", System.currentTimeMillis() - ms.this.f2434ms);
                }
                ms.this.f2434ms = 0L;
                if (z) {
                    com.bytedance.sdk.openadsdk.core.component.splash.c.ms(ms.this.xr, false, true, lmVar, 0L, "preLoadImageSuccess");
                }
                ms.this.d.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.h.ms
            public void ms() {
                com.bytedance.sdk.openadsdk.core.component.splash.c.ms(msVar);
                if (z) {
                    com.bytedance.sdk.openadsdk.core.component.splash.c.ms(ms.this.xr, false, false, lmVar, -7L, "preLoadImageFailed");
                }
                ms.this.d.set(false);
            }
        }, com.bytedance.sdk.openadsdk.op.ny.ka(), 4, null, false);
    }

    public void xr(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar) {
        if (re.xr().xr(f.xr(xrVar)) && xrVar != null && TextUtils.isEmpty(xrVar.nw())) {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "preLoadSplashAd... ");
            e eVar2 = eVar == null ? new e() : eVar.ms();
            eVar2.ab = System.currentTimeMillis();
            eVar2.zb = ch.ub().ti();
            ms(xrVar, eVar2);
        }
    }
}
