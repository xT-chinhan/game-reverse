package com.anythink.rewardvideo.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.k;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.as;
import com.anythink.core.common.h.be;
import com.anythink.core.common.h.n;
import com.anythink.core.common.t.g;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.o;
import com.anythink.rewardvideo.api.ATRewardVideoExListener;
import com.anythink.rewardvideo.api.ATRewardVideoListener;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f implements CustomRewardedVideoEventListener {
    long b;
    boolean c;
    boolean d;
    n e;
    long f;
    long g;
    boolean h;
    boolean k;
    boolean l;
    private ATRewardVideoListener m;
    private CustomRewardVideoAdapter n;
    private com.anythink.core.common.j.e o;
    private long p;
    private long q;
    private final com.anythink.core.common.f r;
    int i = 0;
    long a = 0;
    boolean j = true;

    public f(CustomRewardVideoAdapter customRewardVideoAdapter, com.anythink.core.common.j.e eVar, ATRewardVideoListener aTRewardVideoListener, com.anythink.core.common.f fVar) {
        this.m = aTRewardVideoListener;
        this.n = customRewardVideoAdapter;
        this.o = eVar;
        this.r = fVar;
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayStart() {
        if (this.n == null || (com.anythink.core.common.u.d.a().a(this.n) && com.anythink.core.common.u.d.a().b(this.n))) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cu, new Runnable() { // from class: com.anythink.rewardvideo.a.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    f.a(f.this, jCurrentTimeMillis, jElapsedRealtime);
                }
            }));
        }
    }

    private void a(long j, long j2) {
        if (this.k) {
            return;
        }
        this.k = true;
        this.a = j;
        this.b = j2;
        if (this.p == 0) {
            this.p = j2;
        }
        k kVarA = k.a(this.n);
        CustomRewardVideoAdapter customRewardVideoAdapter = this.n;
        if (customRewardVideoAdapter != null) {
            n trackingInfo = customRewardVideoAdapter.getTrackingInfo();
            trackingInfo.a(this.n.getInternalNetworkInfoMap());
            com.anythink.core.common.u.d.a().a(trackingInfo, this.n.getUnitGroupInfo(), 6);
            c(trackingInfo);
            com.anythink.core.common.j.e eVar = this.o;
            if (eVar != null) {
                eVar.a(this.b, this.n, trackingInfo);
            }
            String strAQ = trackingInfo.aQ();
            com.anythink.core.common.f fVarA = trackingInfo.a();
            if (fVarA != null) {
                fVarA.a(kVarA);
            }
            a(strAQ, 6);
        }
        if (!this.j || this.m == null) {
            return;
        }
        if (kVarA.getNetworkFirmId() == -1) {
            g.a(i.o.b, this.n, null);
        }
        this.m.onRewardedVideoAdPlayStart(kVarA);
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayEnd() {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cs, new Runnable() { // from class: com.anythink.rewardvideo.a.f.10
            @Override // java.lang.Runnable
            public final void run() {
                if (f.this.l) {
                    return;
                }
                f.this.l = true;
                if (f.this.q == 0) {
                    f.this.q = jElapsedRealtime;
                }
                if (f.this.n != null) {
                    if (f.this.n.getDismissType() == 0) {
                        f.this.i = 3;
                    }
                    f.a(f.this.n.getTrackingInfo());
                }
                if (f.this.m != null) {
                    f.this.m.onRewardedVideoAdPlayEnd(k.a(f.this.n));
                }
            }
        }));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayFailed(String str, String str2) {
        final AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adShowError, str, str2);
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.ct, new Runnable() { // from class: com.anythink.rewardvideo.a.f.11
            @Override // java.lang.Runnable
            public final void run() {
                f.this.i = 99;
                if (f.this.n != null) {
                    n trackingInfo = f.this.n.getTrackingInfo();
                    if (trackingInfo.Z() == 66) {
                        f.this.j = false;
                    }
                    String strAQ = trackingInfo.aQ();
                    f.a(f.this, errorCode, trackingInfo);
                    if (trackingInfo != null) {
                        f.g(trackingInfo);
                    }
                    f.this.a(strAQ, 7);
                }
                if (f.this.m != null) {
                    f.this.m.onRewardedVideoAdPlayFailed(errorCode, k.a(f.this.n));
                }
            }
        }));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdClosed() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cq, new Runnable() { // from class: com.anythink.rewardvideo.a.f.12
            @Override // java.lang.Runnable
            public final void run() {
                f.b(f.this, jCurrentTimeMillis, jElapsedRealtime);
            }
        }));
    }

    private void b(long j, long j2) {
        CustomRewardVideoAdapter customRewardVideoAdapter = this.n;
        if (customRewardVideoAdapter != null) {
            n trackingInfo = customRewardVideoAdapter.getTrackingInfo();
            int dismissType = this.i;
            if (dismissType == 0) {
                dismissType = this.n.getDismissType();
            }
            if (dismissType == 0) {
                dismissType = 1;
            }
            trackingInfo.K(dismissType);
            aa.a(trackingInfo, i.s.e, i.s.m, this.c ? "" : "onReward() is not fired");
            long j3 = this.a;
            if (j3 != 0) {
                com.anythink.core.common.t.f.a(trackingInfo, this.c, j3, j, j2 - this.b);
            }
            Map<String, Object> adExtraInfoMap = this.n.getAdExtraInfoMap();
            if (adExtraInfoMap != null) {
                Object obj = adExtraInfoMap.get(com.anythink.core.common.a.b.C0013b.a);
                if (obj instanceof Integer) {
                    trackingInfo.S(((Integer) obj).intValue());
                }
            }
            com.anythink.core.common.u.c.a().c(this.n);
            com.anythink.core.common.t.f.a(trackingInfo, this.c);
            boolean z = this.d;
            s.b();
            s.a(new AnonymousClass13(), z ? 0L : 5000L);
            if (trackingInfo != null) {
                g(trackingInfo);
            }
            ATRewardVideoListener aTRewardVideoListener = this.m;
            if (aTRewardVideoListener != null) {
                aTRewardVideoListener.onRewardedVideoAdClosed(k.a(trackingInfo, this.n));
            }
            a(trackingInfo != null ? trackingInfo.aQ() : "", 18);
        }
        s.b().ai();
    }

    /* JADX INFO: renamed from: com.anythink.rewardvideo.a.f$13, reason: invalid class name */
    final class AnonymousClass13 implements Runnable {
        AnonymousClass13() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.core.common.u.d.a().d(f.this.n);
                f.this.n.clearImpressionListener();
                f.this.n.internalDestroy();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayClicked() {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cr, new Runnable() { // from class: com.anythink.rewardvideo.a.f.14
            @Override // java.lang.Runnable
            public final void run() {
                boolean zA;
                if (f.this.n != null) {
                    zA = f.a(f.this, f.this.n.getTrackingInfo());
                } else {
                    zA = true;
                }
                if (!zA || f.this.m == null) {
                    return;
                }
                f.this.m.onRewardedVideoAdPlayClicked(k.a(f.this.n));
            }
        }));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onReward() {
        if (this.n == null || com.anythink.core.common.u.d.a().c(this.n)) {
            com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cv, new Runnable() { // from class: com.anythink.rewardvideo.a.f.15
                @Override // java.lang.Runnable
                public final void run() {
                    if (f.this.d) {
                        return;
                    }
                    f.this.d = true;
                    if (!f.this.c && f.this.o != null) {
                        n trackingInfo = f.this.n.getTrackingInfo();
                        f fVar = f.this;
                        f.a(fVar, fVar.o, trackingInfo, true, false);
                        f.this.o.a(f.this.p, f.this.q, f.this.n, trackingInfo);
                    }
                    f.this.c = true;
                    if (f.this.m != null) {
                        f.this.m.onReward(k.a(f.this.n));
                    }
                    if (f.this.n != null) {
                        aa.a(f.this.n.getTrackingInfo(), i.s.i, i.s.m, "");
                    }
                }
            }));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardFailed() {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cw, new Runnable() { // from class: com.anythink.rewardvideo.a.f.16
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (f.this.d) {
                        return;
                    }
                    f.this.d = true;
                    n trackingInfo = f.this.n.getTrackingInfo();
                    f fVar = f.this;
                    f.a(fVar, fVar.o, trackingInfo, false, false);
                    if (f.this.m != null && (f.this.m instanceof ATRewardVideoExListener)) {
                        ((ATRewardVideoExListener) f.this.m).onRewardFailed(k.a(f.this.n));
                    }
                    if (f.this.n != null) {
                        aa.a(trackingInfo, i.s.i, i.s.n, "");
                    }
                } catch (Throwable th) {
                    com.anythink.core.common.t.f.b("onRewardFailed error", th.getMessage(), s.b().r());
                }
            }
        }));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onDeeplinkCallback(final boolean z) {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.ck, new Runnable() { // from class: com.anythink.rewardvideo.a.f.17
            @Override // java.lang.Runnable
            public final void run() {
                if (f.this.m != null && (f.this.m instanceof ATRewardVideoExListener)) {
                    ((ATRewardVideoExListener) f.this.m).onDeeplinkCallback(k.a(f.this.n), z);
                }
                if (f.this.n != null) {
                    aa.a(f.this.n.getTrackingInfo(), i.s.j, z ? i.s.m : i.s.n, "");
                }
            }
        }));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onDownloadConfirm(final Context context, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cl, new Runnable() { // from class: com.anythink.rewardvideo.a.f.2
            @Override // java.lang.Runnable
            public final void run() {
                if (f.this.m != null && (f.this.m instanceof ATRewardVideoExListener)) {
                    ((ATRewardVideoExListener) f.this.m).onDownloadConfirm(context, k.a(f.this.n), aTNetworkConfirmInfo);
                }
                if (f.this.n != null) {
                    aa.a(f.this.n.getTrackingInfo(), i.s.k, i.s.m, "");
                }
            }
        }));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayStart() {
        if (this.n == null || (com.anythink.core.common.u.d.a().a(this.n) && com.anythink.core.common.u.d.a().b(this.n))) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cp, new Runnable() { // from class: com.anythink.rewardvideo.a.f.3
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.i = 0;
                    if (f.this.f == 0) {
                        f.this.f = jElapsedRealtime;
                    }
                    f.this.g = 0L;
                    n nVarF = f.f(f.this);
                    if (f.this.n != null && nVarF != null) {
                        com.anythink.core.common.u.d.a().a(nVarF, f.this.n.getUnitGroupInfo(), 6);
                        f.b(f.this, nVarF);
                        if (f.this.o != null) {
                            f.this.o.a(f.this.b, f.this.n, nVarF);
                        }
                    }
                    if (f.this.m == null || !(f.this.m instanceof ATRewardVideoExListener)) {
                        return;
                    }
                    ((ATRewardVideoExListener) f.this.m).onRewardedVideoAdAgainPlayStart(k.a(nVarF, f.this.n));
                }
            }));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayEnd() {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cn, new Runnable() { // from class: com.anythink.rewardvideo.a.f.4
            @Override // java.lang.Runnable
            public final void run() {
                if (f.this.h) {
                    return;
                }
                f.this.h = true;
                if (f.this.g == 0) {
                    f.this.g = jElapsedRealtime;
                }
                n nVarF = f.f(f.this);
                if (f.this.n != null && nVarF != null) {
                    f.a(nVarF);
                }
                if (f.this.m == null || !(f.this.m instanceof ATRewardVideoExListener)) {
                    return;
                }
                ((ATRewardVideoExListener) f.this.m).onRewardedVideoAdAgainPlayEnd(k.a(nVarF, f.this.n));
            }
        }));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayFailed(String str, String str2) {
        final AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adShowError, str, str2);
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.co, new Runnable() { // from class: com.anythink.rewardvideo.a.f.5
            @Override // java.lang.Runnable
            public final void run() {
                f.this.i = 99;
                n nVarF = f.f(f.this);
                if (f.this.n != null && nVarF != null) {
                    f.a(f.this, errorCode, nVarF);
                }
                if (f.this.m == null || !(f.this.m instanceof ATRewardVideoExListener)) {
                    return;
                }
                ((ATRewardVideoExListener) f.this.m).onRewardedVideoAdAgainPlayFailed(errorCode, k.a(nVarF, f.this.n));
            }
        }));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayClicked() {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cm, new Runnable() { // from class: com.anythink.rewardvideo.a.f.6
            @Override // java.lang.Runnable
            public final void run() {
                n nVarF = f.f(f.this);
                if (((f.this.n == null || nVarF == null) ? true : f.a(f.this, nVarF)) && f.this.m != null && (f.this.m instanceof ATRewardVideoExListener)) {
                    ((ATRewardVideoExListener) f.this.m).onRewardedVideoAdAgainPlayClicked(k.a(nVarF, f.this.n));
                }
            }
        }));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onAgainReward() {
        if (this.n == null || com.anythink.core.common.u.d.a().c(this.n)) {
            com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.ci, new Runnable() { // from class: com.anythink.rewardvideo.a.f.7
                @Override // java.lang.Runnable
                public final void run() {
                    n nVarF = f.f(f.this);
                    if (f.this.o != null) {
                        f fVar = f.this;
                        f.a(fVar, fVar.o, nVarF, true, true);
                        f.this.o.a(f.this.f, f.this.g, f.this.n, nVarF);
                    }
                    if (f.this.m != null && (f.this.m instanceof ATRewardVideoExListener)) {
                        ((ATRewardVideoExListener) f.this.m).onAgainReward(k.a(nVarF, f.this.n));
                    }
                    if (f.this.n != null) {
                        aa.a(nVarF, i.s.i, i.s.m, "");
                    }
                }
            }));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onAgainRewardFailed() {
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cj, new Runnable() { // from class: com.anythink.rewardvideo.a.f.8
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    n nVarF = f.f(f.this);
                    f fVar = f.this;
                    f.a(fVar, fVar.o, nVarF, false, true);
                    if (f.this.m != null && (f.this.m instanceof ATRewardVideoExListener)) {
                        ((ATRewardVideoExListener) f.this.m).onAgainRewardFailed(k.a(nVarF, f.this.n));
                    }
                    if (f.this.n != null) {
                        aa.a(nVarF, i.s.i, i.s.n, "");
                    }
                } catch (Throwable th) {
                    com.anythink.core.common.t.f.b("onAgainRewardFailed error", th.getMessage(), s.b().r());
                }
            }
        }));
    }

    private n a() {
        CustomRewardVideoAdapter customRewardVideoAdapter;
        if (this.e == null && (customRewardVideoAdapter = this.n) != null) {
            n nVarAh = customRewardVideoAdapter.getTrackingInfo().ah();
            this.e = nVarAh;
            nVarAh.t = 6;
            this.e.n(o.b(this.e.aR(), this.e.N(), System.currentTimeMillis()));
        }
        return this.e;
    }

    private void c(final n nVar) {
        com.anythink.core.common.u.c.a().a(this.n);
        String ilrd = this.n.getILRD();
        if (!TextUtils.isEmpty(ilrd)) {
            nVar.d(ilrd);
        }
        com.anythink.core.common.u.d.a().a(this.n, new com.anythink.core.common.u.d.a() { // from class: com.anythink.rewardvideo.a.f.9
            @Override // com.anythink.core.common.u.d.a
            public final void b() {
            }

            @Override // com.anythink.core.common.u.d.a
            public final void a() {
                ai.b(nVar, f.this.n);
                com.anythink.core.common.t.e.a(s.b().g());
                com.anythink.core.common.t.e.a(4, nVar, f.this.n.getUnitGroupInfo());
            }
        });
        if (this.j) {
            com.anythink.core.common.t.e.a(s.b().g());
            com.anythink.core.common.t.e.a(8, nVar);
        }
        aa.a(nVar, i.s.c, i.s.m, "");
    }

    private void a(AdError adError, n nVar) {
        aa.a(nVar, i.s.c, i.s.n, adError.printStackTrace());
        CustomRewardVideoAdapter customRewardVideoAdapter = this.n;
        com.anythink.core.common.t.f.a(nVar, adError, customRewardVideoAdapter != null ? customRewardVideoAdapter.getInternalNetworkInfoMap() : null);
    }

    private static void d(n nVar) {
        aa.a(nVar, i.s.g, i.s.m, "");
        com.anythink.core.common.t.e.a(s.b().g());
        com.anythink.core.common.t.e.a(9, nVar);
    }

    private boolean e(n nVar) {
        ai.c(nVar, this.n);
        com.anythink.core.common.t.e.a(s.b().g());
        com.anythink.core.common.t.e.a(6, nVar);
        if (nVar != null ? nVar.aB() : false) {
            return false;
        }
        com.anythink.core.common.u.c.a().b(this.n);
        aa.a(nVar, i.s.d, i.s.m, "");
        return true;
    }

    private void f(n nVar) {
        com.anythink.core.common.t.e.a(s.b().g());
        com.anythink.core.common.t.e.a(13, nVar, this.n.getUnitGroupInfo());
        com.anythink.core.common.u.d.a().a(nVar, this.n.getUnitGroupInfo(), com.anythink.core.common.u.d.b);
        c(nVar);
    }

    private void a(com.anythink.core.common.j.e eVar, n nVar, boolean z, boolean z2) {
        long jElapsedRealtime;
        long j;
        boolean z3 = z2 ? this.h : this.l;
        com.anythink.core.common.i.a();
        String strC = com.anythink.core.common.i.c();
        nVar.a(be.a(z3, strC, z, this.n.getNetworkInfoMap()));
        com.anythink.core.common.t.e.a(s.b().g());
        com.anythink.core.common.t.e.a(25, nVar);
        if (z2) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
            j = this.f;
        } else {
            jElapsedRealtime = SystemClock.elapsedRealtime();
            j = this.p;
        }
        com.anythink.core.common.t.f.a(eVar, z, nVar, jElapsedRealtime - j, z3, strC, this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(n nVar) {
        com.anythink.core.common.f fVarA;
        com.anythink.core.common.h.i iVarS;
        if (nVar == null || (fVarA = nVar.a()) == null || (iVarS = fVarA.s()) == null) {
            return;
        }
        fVarA.t();
        fVarA.c(fVarA.d(iVarS.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        com.anythink.core.common.f fVar;
        if (TextUtils.isEmpty(str) || (fVar = this.r) == null || !fVar.a((ATAdStatusInfo) null, i)) {
            return;
        }
        as asVar = new as();
        asVar.a(s.b().M());
        asVar.c = i;
        if (fVar.n() != null) {
            asVar.a(fVar.n());
        }
        fVar.b(s.b().M(), "1", str, asVar, null);
    }

    static /* synthetic */ void a(f fVar, long j, long j2) {
        if (fVar.k) {
            return;
        }
        fVar.k = true;
        fVar.a = j;
        fVar.b = j2;
        if (fVar.p == 0) {
            fVar.p = j2;
        }
        k kVarA = k.a(fVar.n);
        CustomRewardVideoAdapter customRewardVideoAdapter = fVar.n;
        if (customRewardVideoAdapter != null) {
            n trackingInfo = customRewardVideoAdapter.getTrackingInfo();
            trackingInfo.a(fVar.n.getInternalNetworkInfoMap());
            com.anythink.core.common.u.d.a().a(trackingInfo, fVar.n.getUnitGroupInfo(), 6);
            fVar.c(trackingInfo);
            com.anythink.core.common.j.e eVar = fVar.o;
            if (eVar != null) {
                eVar.a(fVar.b, fVar.n, trackingInfo);
            }
            String strAQ = trackingInfo.aQ();
            com.anythink.core.common.f fVarA = trackingInfo.a();
            if (fVarA != null) {
                fVarA.a(kVarA);
            }
            fVar.a(strAQ, 6);
        }
        if (!fVar.j || fVar.m == null) {
            return;
        }
        if (kVarA.getNetworkFirmId() == -1) {
            g.a(i.o.b, fVar.n, null);
        }
        fVar.m.onRewardedVideoAdPlayStart(kVarA);
    }

    static /* synthetic */ void a(n nVar) {
        aa.a(nVar, i.s.g, i.s.m, "");
        com.anythink.core.common.t.e.a(s.b().g());
        com.anythink.core.common.t.e.a(9, nVar);
    }

    static /* synthetic */ void a(f fVar, AdError adError, n nVar) {
        aa.a(nVar, i.s.c, i.s.n, adError.printStackTrace());
        CustomRewardVideoAdapter customRewardVideoAdapter = fVar.n;
        com.anythink.core.common.t.f.a(nVar, adError, customRewardVideoAdapter != null ? customRewardVideoAdapter.getInternalNetworkInfoMap() : null);
    }

    static /* synthetic */ void b(f fVar, long j, long j2) {
        CustomRewardVideoAdapter customRewardVideoAdapter = fVar.n;
        if (customRewardVideoAdapter != null) {
            n trackingInfo = customRewardVideoAdapter.getTrackingInfo();
            int dismissType = fVar.i;
            if (dismissType == 0) {
                dismissType = fVar.n.getDismissType();
            }
            if (dismissType == 0) {
                dismissType = 1;
            }
            trackingInfo.K(dismissType);
            aa.a(trackingInfo, i.s.e, i.s.m, fVar.c ? "" : "onReward() is not fired");
            long j3 = fVar.a;
            if (j3 != 0) {
                com.anythink.core.common.t.f.a(trackingInfo, fVar.c, j3, j, j2 - fVar.b);
            }
            Map<String, Object> adExtraInfoMap = fVar.n.getAdExtraInfoMap();
            if (adExtraInfoMap != null) {
                Object obj = adExtraInfoMap.get(com.anythink.core.common.a.b.C0013b.a);
                if (obj instanceof Integer) {
                    trackingInfo.S(((Integer) obj).intValue());
                }
            }
            com.anythink.core.common.u.c.a().c(fVar.n);
            com.anythink.core.common.t.f.a(trackingInfo, fVar.c);
            boolean z = fVar.d;
            s.b();
            s.a(fVar.new AnonymousClass13(), z ? 0L : 5000L);
            if (trackingInfo != null) {
                g(trackingInfo);
            }
            ATRewardVideoListener aTRewardVideoListener = fVar.m;
            if (aTRewardVideoListener != null) {
                aTRewardVideoListener.onRewardedVideoAdClosed(k.a(trackingInfo, fVar.n));
            }
            fVar.a(trackingInfo != null ? trackingInfo.aQ() : "", 18);
        }
        s.b().ai();
    }

    static /* synthetic */ boolean a(f fVar, n nVar) {
        ai.c(nVar, fVar.n);
        com.anythink.core.common.t.e.a(s.b().g());
        com.anythink.core.common.t.e.a(6, nVar);
        if (nVar != null ? nVar.aB() : false) {
            return false;
        }
        com.anythink.core.common.u.c.a().b(fVar.n);
        aa.a(nVar, i.s.d, i.s.m, "");
        return true;
    }

    static /* synthetic */ void a(f fVar, com.anythink.core.common.j.e eVar, n nVar, boolean z, boolean z2) {
        long jElapsedRealtime;
        long j;
        boolean z3 = z2 ? fVar.h : fVar.l;
        com.anythink.core.common.i.a();
        String strC = com.anythink.core.common.i.c();
        nVar.a(be.a(z3, strC, z, fVar.n.getNetworkInfoMap()));
        com.anythink.core.common.t.e.a(s.b().g());
        com.anythink.core.common.t.e.a(25, nVar);
        if (z2) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
            j = fVar.f;
        } else {
            jElapsedRealtime = SystemClock.elapsedRealtime();
            j = fVar.p;
        }
        com.anythink.core.common.t.f.a(eVar, z, nVar, jElapsedRealtime - j, z3, strC, fVar.n);
    }

    static /* synthetic */ n f(f fVar) {
        CustomRewardVideoAdapter customRewardVideoAdapter;
        if (fVar.e == null && (customRewardVideoAdapter = fVar.n) != null) {
            n nVarAh = customRewardVideoAdapter.getTrackingInfo().ah();
            fVar.e = nVarAh;
            nVarAh.t = 6;
            fVar.e.n(o.b(fVar.e.aR(), fVar.e.N(), System.currentTimeMillis()));
        }
        return fVar.e;
    }

    static /* synthetic */ void b(f fVar, n nVar) {
        com.anythink.core.common.t.e.a(s.b().g());
        com.anythink.core.common.t.e.a(13, nVar, fVar.n.getUnitGroupInfo());
        com.anythink.core.common.u.d.a().a(nVar, fVar.n.getUnitGroupInfo(), com.anythink.core.common.u.d.b);
        fVar.c(nVar);
    }
}
