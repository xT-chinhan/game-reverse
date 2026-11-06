package com.anythink.rewardvideo.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.l;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ar;
import com.anythink.core.common.h.bc;
import com.anythink.core.common.h.n;
import com.anythink.core.common.i;
import com.anythink.core.common.u;
import com.anythink.core.common.u.h;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.v.p;
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
    boolean f;
    long g;
    long h;
    boolean i;
    boolean l;
    boolean m;
    private ATRewardVideoListener n;
    private CustomRewardVideoAdapter o;
    private com.anythink.core.common.k.e p;
    private long q;
    private long r;
    int j = 0;
    long a = 0;
    boolean k = true;

    public f(CustomRewardVideoAdapter customRewardVideoAdapter, com.anythink.core.common.k.e eVar, ATRewardVideoListener aTRewardVideoListener) {
        this.n = aTRewardVideoListener;
        this.o = customRewardVideoAdapter;
        this.p = eVar;
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayStart() {
        if ((this.o == null || (com.anythink.core.common.v.d.a().a(this.o) && com.anythink.core.common.v.d.a().b(this.o))) && !this.l) {
            this.l = true;
            this.a = System.currentTimeMillis();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.b = jElapsedRealtime;
            if (this.q == 0) {
                this.q = jElapsedRealtime;
            }
            l lVarA = l.a(this.o);
            CustomRewardVideoAdapter customRewardVideoAdapter = this.o;
            if (customRewardVideoAdapter != null) {
                n trackingInfo = customRewardVideoAdapter.getTrackingInfo();
                trackingInfo.a(this.o.getInternalNetworkInfoMap());
                com.anythink.core.common.v.d.a().a(trackingInfo, this.o.getUnitGroupInfo(), 6);
                a(trackingInfo);
                com.anythink.core.common.k.e eVar = this.p;
                if (eVar != null) {
                    eVar.a(this.b, this.o, trackingInfo);
                }
                String strAI = trackingInfo.aI();
                u.a().a(strAI, lVarA);
                a(strAI, 6);
            }
            if (!this.k || this.n == null) {
                return;
            }
            if (lVarA.getNetworkFirmId() == -1) {
                h.a(j.n.b, this.o, null);
            }
            this.n.onRewardedVideoAdPlayStart(lVarA);
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayEnd() {
        if (this.m) {
            return;
        }
        this.m = true;
        if (this.r == 0) {
            this.r = SystemClock.elapsedRealtime();
        }
        CustomRewardVideoAdapter customRewardVideoAdapter = this.o;
        if (customRewardVideoAdapter != null) {
            if (customRewardVideoAdapter.getDismissType() == 0) {
                this.j = 3;
            }
            b(this.o.getTrackingInfo());
        }
        ATRewardVideoListener aTRewardVideoListener = this.n;
        if (aTRewardVideoListener != null) {
            aTRewardVideoListener.onRewardedVideoAdPlayEnd(l.a(this.o));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayFailed(String str, String str2) {
        this.j = 99;
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adShowError, str, str2);
        CustomRewardVideoAdapter customRewardVideoAdapter = this.o;
        if (customRewardVideoAdapter != null) {
            n trackingInfo = customRewardVideoAdapter.getTrackingInfo();
            if (trackingInfo.Y() == 66) {
                this.k = false;
            }
            String strAI = trackingInfo.aI();
            a(errorCode, trackingInfo);
            if (trackingInfo != null) {
                a(trackingInfo.aI());
            }
            a(strAI, 7);
        }
        ATRewardVideoListener aTRewardVideoListener = this.n;
        if (aTRewardVideoListener != null) {
            aTRewardVideoListener.onRewardedVideoAdPlayFailed(errorCode, l.a(this.o));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdClosed() {
        CustomRewardVideoAdapter customRewardVideoAdapter = this.o;
        if (customRewardVideoAdapter != null) {
            n trackingInfo = customRewardVideoAdapter.getTrackingInfo();
            int dismissType = this.j;
            if (dismissType == 0) {
                dismissType = this.o.getDismissType();
            }
            if (dismissType == 0) {
                dismissType = 1;
            }
            trackingInfo.K(dismissType);
            ab.a(trackingInfo, j.r.e, j.r.m, this.c ? "" : "onReward() is not fired");
            long j = this.a;
            if (j != 0) {
                com.anythink.core.common.u.e.a(trackingInfo, this.c, j, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.b);
            }
            Map<String, Object> adExtraInfoMap = this.o.getAdExtraInfoMap();
            if (adExtraInfoMap != null) {
                Object obj = adExtraInfoMap.get(com.anythink.core.common.a.b.C0077b.a);
                if (obj instanceof Integer) {
                    trackingInfo.R(((Integer) obj).intValue());
                }
            }
            com.anythink.core.common.u.e.a(trackingInfo, this.c);
            if (this.d) {
                try {
                    com.anythink.core.common.v.d.a().d(this.o);
                    this.o.clearImpressionListener();
                    this.o.internalDestory();
                } catch (Throwable unused) {
                }
            } else {
                t.b().a(new Runnable() { // from class: com.anythink.rewardvideo.a.f.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.anythink.core.common.v.d.a().d(f.this.o);
                            f.this.o.clearImpressionListener();
                            f.this.o.internalDestory();
                        } catch (Throwable unused2) {
                        }
                    }
                }, 5000L);
            }
            if (trackingInfo != null) {
                a(trackingInfo.aI());
            }
            ATRewardVideoListener aTRewardVideoListener = this.n;
            if (aTRewardVideoListener != null) {
                aTRewardVideoListener.onRewardedVideoAdClosed(l.a(trackingInfo, this.o));
            }
            a(trackingInfo != null ? trackingInfo.aI() : "", 18);
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayClicked() {
        ATRewardVideoListener aTRewardVideoListener;
        CustomRewardVideoAdapter customRewardVideoAdapter = this.o;
        if (!(customRewardVideoAdapter != null ? c(customRewardVideoAdapter.getTrackingInfo()) : true) || (aTRewardVideoListener = this.n) == null) {
            return;
        }
        aTRewardVideoListener.onRewardedVideoAdPlayClicked(l.a(this.o));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onReward() {
        if ((this.o == null || com.anythink.core.common.v.d.a().c(this.o)) && !this.d) {
            this.d = true;
            if (!this.c && this.p != null) {
                n trackingInfo = this.o.getTrackingInfo();
                a(this.p, trackingInfo, true, false);
                this.p.a(this.q, this.r, this.o, trackingInfo);
            }
            this.c = true;
            ATRewardVideoListener aTRewardVideoListener = this.n;
            if (aTRewardVideoListener != null) {
                aTRewardVideoListener.onReward(l.a(this.o));
            }
            CustomRewardVideoAdapter customRewardVideoAdapter = this.o;
            if (customRewardVideoAdapter != null) {
                ab.a(customRewardVideoAdapter.getTrackingInfo(), j.r.i, j.r.m, "");
            }
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardFailed() {
        try {
            if (this.d) {
                return;
            }
            this.d = true;
            n trackingInfo = this.o.getTrackingInfo();
            a(this.p, trackingInfo, false, false);
            ATRewardVideoListener aTRewardVideoListener = this.n;
            if (aTRewardVideoListener != null && (aTRewardVideoListener instanceof ATRewardVideoExListener)) {
                ((ATRewardVideoExListener) aTRewardVideoListener).onRewardFailed(l.a(this.o));
            }
            if (this.o != null) {
                ab.a(trackingInfo, j.r.i, j.r.n, "");
            }
        } catch (Throwable th) {
            com.anythink.core.common.u.e.b("onRewardFailed error", th.getMessage(), t.b().r());
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onDeeplinkCallback(boolean z) {
        ATRewardVideoListener aTRewardVideoListener = this.n;
        if (aTRewardVideoListener != null && (aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            ((ATRewardVideoExListener) aTRewardVideoListener).onDeeplinkCallback(l.a(this.o), z);
        }
        CustomRewardVideoAdapter customRewardVideoAdapter = this.o;
        if (customRewardVideoAdapter != null) {
            ab.a(customRewardVideoAdapter.getTrackingInfo(), j.r.j, z ? j.r.m : j.r.n, "");
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        ATRewardVideoListener aTRewardVideoListener = this.n;
        if (aTRewardVideoListener != null && (aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            ((ATRewardVideoExListener) aTRewardVideoListener).onDownloadConfirm(context, l.a(this.o), aTNetworkConfirmInfo);
        }
        CustomRewardVideoAdapter customRewardVideoAdapter = this.o;
        if (customRewardVideoAdapter != null) {
            ab.a(customRewardVideoAdapter.getTrackingInfo(), j.r.k, j.r.m, "");
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayStart() {
        if (this.o == null || (com.anythink.core.common.v.d.a().a(this.o) && com.anythink.core.common.v.d.a().b(this.o))) {
            this.j = 0;
            if (this.g == 0) {
                this.g = SystemClock.elapsedRealtime();
            }
            this.h = 0L;
            n nVarA = a();
            if (this.o != null && nVarA != null) {
                com.anythink.core.common.v.d.a().a(nVarA, this.o.getUnitGroupInfo(), 6);
                com.anythink.core.common.u.c.a(t.b().g()).a(13, nVarA, this.o.getUnitGroupInfo());
                com.anythink.core.common.v.d.a().a(nVarA, this.o.getUnitGroupInfo(), com.anythink.core.common.v.d.b);
                a(nVarA);
                com.anythink.core.common.k.e eVar = this.p;
                if (eVar != null) {
                    eVar.a(this.b, this.o, nVarA);
                }
            }
            ATRewardVideoListener aTRewardVideoListener = this.n;
            if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
                return;
            }
            ((ATRewardVideoExListener) aTRewardVideoListener).onRewardedVideoAdAgainPlayStart(l.a(nVarA, this.o));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayEnd() {
        if (this.i) {
            return;
        }
        this.i = true;
        if (this.h == 0) {
            this.h = SystemClock.elapsedRealtime();
        }
        n nVarA = a();
        if (this.o != null && nVarA != null) {
            b(nVarA);
        }
        ATRewardVideoListener aTRewardVideoListener = this.n;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onRewardedVideoAdAgainPlayEnd(l.a(nVarA, this.o));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayFailed(String str, String str2) {
        this.j = 99;
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adShowError, str, str2);
        n nVarA = a();
        if (this.o != null && nVarA != null) {
            a(errorCode, nVarA);
        }
        ATRewardVideoListener aTRewardVideoListener = this.n;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onRewardedVideoAdAgainPlayFailed(errorCode, l.a(nVarA, this.o));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayClicked() {
        ATRewardVideoListener aTRewardVideoListener;
        n nVarA = a();
        if (((this.o == null || nVarA == null) ? true : c(nVarA)) && (aTRewardVideoListener = this.n) != null && (aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            ((ATRewardVideoExListener) aTRewardVideoListener).onRewardedVideoAdAgainPlayClicked(l.a(nVarA, this.o));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onAgainReward() {
        com.anythink.core.common.k.e eVar;
        if (this.o == null || com.anythink.core.common.v.d.a().c(this.o)) {
            n nVarA = a();
            if (!this.f && (eVar = this.p) != null) {
                a(eVar, nVarA, true, true);
                this.p.a(this.g, this.h, this.o, nVarA);
            }
            this.f = true;
            ATRewardVideoListener aTRewardVideoListener = this.n;
            if (aTRewardVideoListener != null && (aTRewardVideoListener instanceof ATRewardVideoExListener)) {
                ((ATRewardVideoExListener) aTRewardVideoListener).onAgainReward(l.a(nVarA, this.o));
            }
            if (this.o != null) {
                ab.a(nVarA, j.r.i, j.r.m, "");
            }
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onAgainRewardFailed() {
        try {
            if (this.f) {
                return;
            }
            this.f = true;
            n nVarA = a();
            a(this.p, nVarA, false, true);
            ATRewardVideoListener aTRewardVideoListener = this.n;
            if (aTRewardVideoListener != null && (aTRewardVideoListener instanceof ATRewardVideoExListener)) {
                ((ATRewardVideoExListener) aTRewardVideoListener).onAgainRewardFailed(l.a(nVarA, this.o));
            }
            if (this.o != null) {
                ab.a(nVarA, j.r.i, j.r.n, "");
            }
        } catch (Throwable th) {
            com.anythink.core.common.u.e.b("onAgainRewardFailed error", th.getMessage(), t.b().r());
        }
    }

    private n a() {
        CustomRewardVideoAdapter customRewardVideoAdapter;
        if (this.e == null && (customRewardVideoAdapter = this.o) != null) {
            n nVarAf = customRewardVideoAdapter.getTrackingInfo().af();
            this.e = nVarAf;
            nVarAf.t = 6;
            this.e.n(p.b(this.e.aJ(), this.e.M(), System.currentTimeMillis()));
        }
        return this.e;
    }

    private void a(final n nVar) {
        com.anythink.core.common.v.c.a().a(this.o);
        String ilrd = this.o.getILRD();
        if (!TextUtils.isEmpty(ilrd)) {
            nVar.d(ilrd);
        }
        com.anythink.core.common.v.d.a().a(this.o, new com.anythink.core.common.v.d.a() { // from class: com.anythink.rewardvideo.a.f.2
            @Override // com.anythink.core.common.v.d.a
            public final void b() {
            }

            @Override // com.anythink.core.common.v.d.a
            public final void a() {
                com.anythink.core.common.u.c.a(t.b().g()).a(4, nVar, f.this.o.getUnitGroupInfo());
            }
        });
        if (this.k) {
            com.anythink.core.common.u.c.a(t.b().g()).a(8, nVar);
        }
        ab.a(nVar, j.r.c, j.r.m, "");
    }

    private void a(AdError adError, n nVar) {
        ab.a(nVar, j.r.c, j.r.n, adError.printStackTrace());
        CustomRewardVideoAdapter customRewardVideoAdapter = this.o;
        com.anythink.core.common.u.e.a(nVar, adError, customRewardVideoAdapter != null ? customRewardVideoAdapter.getInternalNetworkInfoMap() : null);
    }

    private static void b(n nVar) {
        ab.a(nVar, j.r.g, j.r.m, "");
        com.anythink.core.common.u.c.a(t.b().g()).a(9, nVar);
    }

    private boolean c(n nVar) {
        com.anythink.core.common.u.c.a(t.b().g()).a(6, nVar);
        if (nVar != null ? nVar.aw() : false) {
            return false;
        }
        com.anythink.core.common.v.c.a().b(this.o);
        ab.a(nVar, j.r.d, j.r.m, "");
        return true;
    }

    private void d(n nVar) {
        com.anythink.core.common.u.c.a(t.b().g()).a(13, nVar, this.o.getUnitGroupInfo());
        com.anythink.core.common.v.d.a().a(nVar, this.o.getUnitGroupInfo(), com.anythink.core.common.v.d.b);
        a(nVar);
    }

    private void a(com.anythink.core.common.k.e eVar, n nVar, boolean z, boolean z2) {
        long jElapsedRealtime;
        long j;
        boolean z3 = z2 ? this.i : this.m;
        i.a();
        String strG = i.g();
        nVar.a(bc.a(z3, strG, z));
        com.anythink.core.common.u.c.a(t.b().g()).a(25, nVar);
        if (z2) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
            j = this.g;
        } else {
            jElapsedRealtime = SystemClock.elapsedRealtime();
            j = this.q;
        }
        com.anythink.core.common.u.e.a(eVar, z, nVar, jElapsedRealtime - j, z3, strG, this.o);
    }

    private static void a(String str) {
        com.anythink.core.common.h.i iVarC;
        if (TextUtils.isEmpty(str) || (iVarC = u.a().c(str)) == null) {
            return;
        }
        u.a().d(str);
        com.anythink.core.common.f.a(t.b().g(), str, "1").c(u.a().b(str, iVarC.a()));
    }

    private static void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.core.common.f fVarA = com.anythink.core.common.f.a(t.b().M(), str, "1");
        if (fVarA.a((ATAdStatusInfo) null, i)) {
            ar arVar = new ar();
            arVar.a(t.b().M());
            arVar.c = i;
            if (fVarA.i() != null) {
                arVar.a(fVarA.i());
            }
            fVarA.b(t.b().M(), "1", str, arVar, null);
        }
    }
}
