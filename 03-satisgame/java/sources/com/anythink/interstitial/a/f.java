package com.anythink.interstitial.a;

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
import com.anythink.core.common.h.n;
import com.anythink.core.common.t.g;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.ai;
import com.anythink.interstitial.api.ATInterstitialExListener;
import com.anythink.interstitial.api.ATInterstitialListener;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f implements CustomInterstitialEventListener {
    ATInterstitialListener a;
    CustomInterstitialAdapter b;
    long c;
    long d;
    int e = 0;
    boolean f = true;
    boolean g;
    private final a h;
    private final com.anythink.core.common.f i;

    public f(CustomInterstitialAdapter customInterstitialAdapter, ATInterstitialListener aTInterstitialListener, a aVar, com.anythink.core.common.f fVar) {
        this.a = aTInterstitialListener;
        this.b = customInterstitialAdapter;
        this.h = aVar;
        this.i = fVar;
        if (aVar != null) {
            aVar.a(customInterstitialAdapter, this);
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdVideoStart() {
        final CustomInterstitialAdapter customInterstitialAdapter = this.b;
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bs, new Runnable() { // from class: com.anythink.interstitial.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                CustomInterstitialAdapter customInterstitialAdapter2 = customInterstitialAdapter;
                if (customInterstitialAdapter2 != null) {
                    n trackingInfo = customInterstitialAdapter2.getTrackingInfo();
                    if (f.this.f) {
                        com.anythink.core.common.t.e.a(s.b().g());
                        com.anythink.core.common.t.e.a(8, trackingInfo);
                        if (f.this.a != null) {
                            f.this.a.onInterstitialAdVideoStart(k.a(customInterstitialAdapter));
                        }
                    }
                }
            }
        }));
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdReward() {
        final CustomInterstitialAdapter customInterstitialAdapter = this.b;
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bl, new Runnable() { // from class: com.anythink.interstitial.a.f.5
            @Override // java.lang.Runnable
            public final void run() {
                if (f.this.a != null && (f.this.a instanceof ATInterstitialExListener)) {
                    ((ATInterstitialExListener) f.this.a).onInterstitialAdReward(k.a(customInterstitialAdapter));
                }
                CustomInterstitialAdapter customInterstitialAdapter2 = customInterstitialAdapter;
                if (customInterstitialAdapter2 != null) {
                    aa.a(customInterstitialAdapter2.getTrackingInfo(), i.s.i, i.s.m, "");
                }
            }
        }));
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdVideoEnd() {
        final CustomInterstitialAdapter customInterstitialAdapter = this.b;
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bq, new Runnable() { // from class: com.anythink.interstitial.a.f.6
            @Override // java.lang.Runnable
            public final void run() {
                CustomInterstitialAdapter customInterstitialAdapter2 = customInterstitialAdapter;
                if (customInterstitialAdapter2 != null) {
                    if (customInterstitialAdapter2.getDismissType() == 0) {
                        f.this.e = 3;
                    }
                    n trackingInfo = customInterstitialAdapter.getTrackingInfo();
                    com.anythink.core.common.t.e.a(s.b().g());
                    com.anythink.core.common.t.e.a(9, trackingInfo);
                    if (f.this.a != null) {
                        f.this.a.onInterstitialAdVideoEnd(k.a(customInterstitialAdapter));
                    }
                    aa.a(trackingInfo, i.s.g, i.s.m, "");
                }
            }
        }));
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdVideoError(String str, final String str2) {
        final CustomInterstitialAdapter customInterstitialAdapter = this.b;
        final AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adShowError, str, str2);
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.br, new Runnable() { // from class: com.anythink.interstitial.a.f.7
            @Override // java.lang.Runnable
            public final void run() {
                String strAQ;
                f.this.e = 99;
                CustomInterstitialAdapter customInterstitialAdapter2 = customInterstitialAdapter;
                if (customInterstitialAdapter2 != null) {
                    n trackingInfo = customInterstitialAdapter2.getTrackingInfo();
                    if (trackingInfo.Z() == 66) {
                        f.this.f = false;
                    }
                    com.anythink.core.common.t.f.a(trackingInfo, errorCode, customInterstitialAdapter.getInternalNetworkInfoMap());
                    if (trackingInfo != null) {
                        strAQ = trackingInfo.aQ();
                        f.b(trackingInfo);
                    } else {
                        strAQ = "";
                    }
                    f.this.a(strAQ, 7);
                    aa.a(trackingInfo, i.s.h, i.s.n, str2);
                }
                if (f.this.a != null) {
                    f.this.a.onInterstitialAdVideoError(errorCode);
                }
            }
        }));
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdClose() {
        a aVar;
        final CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null && (aVar = this.h) != null) {
            aVar.c(customInterstitialAdapter);
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bo, new Runnable() { // from class: com.anythink.interstitial.a.f.8
            @Override // java.lang.Runnable
            public final void run() {
                f.a(f.this, customInterstitialAdapter, jCurrentTimeMillis, jElapsedRealtime);
            }
        }));
    }

    private void a(CustomInterstitialAdapter customInterstitialAdapter, long j, long j2) {
        if (customInterstitialAdapter != null) {
            n trackingInfo = customInterstitialAdapter.getTrackingInfo();
            int dismissType = this.e;
            if (dismissType == 0) {
                dismissType = customInterstitialAdapter.getDismissType();
            }
            if (dismissType == 0) {
                dismissType = 1;
            }
            trackingInfo.K(dismissType);
            a aVar = this.h;
            if (aVar != null) {
                trackingInfo.aj(aVar.c());
                trackingInfo.ah(this.h.f());
                trackingInfo.ai(this.h.e());
            }
            aa.a(trackingInfo, i.s.e, i.s.m, "");
            long j3 = this.c;
            if (j3 != 0) {
                com.anythink.core.common.t.f.a(trackingInfo, false, j3, j, j2 - this.d);
            }
            Map<String, Object> adExtraInfoMap = customInterstitialAdapter.getAdExtraInfoMap();
            if (adExtraInfoMap != null) {
                Object obj = adExtraInfoMap.get(com.anythink.core.common.a.b.C0013b.a);
                if (obj instanceof Integer) {
                    trackingInfo.S(((Integer) obj).intValue());
                }
            }
            com.anythink.core.common.u.c.a().c(customInterstitialAdapter);
            com.anythink.core.common.t.f.a(trackingInfo, false);
            s.b();
            s.b(new AnonymousClass9(customInterstitialAdapter));
            a aVar2 = this.h;
            if (aVar2 != null) {
                if (aVar2.b() != 1) {
                    s.b();
                    s.b(new AnonymousClass10());
                    ATInterstitialListener aTInterstitialListener = this.a;
                    if (aTInterstitialListener != null) {
                        aTInterstitialListener.onInterstitialAdClose(k.a(trackingInfo, customInterstitialAdapter));
                    }
                }
            } else {
                ATInterstitialListener aTInterstitialListener2 = this.a;
                if (aTInterstitialListener2 != null) {
                    aTInterstitialListener2.onInterstitialAdClose(k.a(trackingInfo, customInterstitialAdapter));
                }
            }
            if (trackingInfo != null) {
                b(trackingInfo);
            }
            a(trackingInfo != null ? trackingInfo.aQ() : "", 18);
        }
        s.b().ai();
    }

    /* JADX INFO: renamed from: com.anythink.interstitial.a.f$9, reason: invalid class name */
    final class AnonymousClass9 implements Runnable {
        final /* synthetic */ CustomInterstitialAdapter a;

        AnonymousClass9(CustomInterstitialAdapter customInterstitialAdapter) {
            this.a = customInterstitialAdapter;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.core.common.u.d.a().d(this.a);
                this.a.clearImpressionListener();
                this.a.internalDestroy();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.interstitial.a.f$10, reason: invalid class name */
    final class AnonymousClass10 implements Runnable {
        AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.this.h.a();
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdClicked() {
        final CustomInterstitialAdapter customInterstitialAdapter = this.b;
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bn, new Runnable() { // from class: com.anythink.interstitial.a.f.11
            @Override // java.lang.Runnable
            public final void run() {
                CustomInterstitialAdapter customInterstitialAdapter2 = customInterstitialAdapter;
                if (customInterstitialAdapter2 != null) {
                    n nVarA = f.this.a(customInterstitialAdapter2);
                    ai.c(nVarA, customInterstitialAdapter);
                    com.anythink.core.common.t.e.a(s.b().g());
                    com.anythink.core.common.t.e.a(6, nVarA);
                    if (nVarA != null ? nVarA.aB() : false) {
                        return;
                    } else {
                        aa.a(nVarA, i.s.d, i.s.m, "");
                    }
                }
                com.anythink.core.common.u.c.a().b(customInterstitialAdapter);
                if (f.this.a != null) {
                    f.this.a.onInterstitialAdClicked(k.a(customInterstitialAdapter));
                }
                s.b();
                s.b(new Runnable() { // from class: com.anythink.interstitial.a.f.11.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (customInterstitialAdapter == null || f.this.h == null) {
                            return;
                        }
                        f.this.h.b(customInterstitialAdapter);
                    }
                });
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n a(CustomInterstitialAdapter customInterstitialAdapter) {
        a aVar;
        n trackingInfo = customInterstitialAdapter.getTrackingInfo();
        if (trackingInfo != null && (aVar = this.h) != null) {
            if (aVar.b() == 0) {
                trackingInfo.aj(0);
                trackingInfo.ak(-1);
            } else {
                trackingInfo.aj(this.h.c());
                trackingInfo.ak(this.h.d());
            }
        }
        return trackingInfo;
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdShow() {
        a aVar;
        final CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null && (aVar = this.h) != null) {
            aVar.a(customInterstitialAdapter);
        }
        if (customInterstitialAdapter == null || (com.anythink.core.common.u.d.a().a(customInterstitialAdapter) && com.anythink.core.common.u.d.a().b(customInterstitialAdapter))) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bp, new Runnable() { // from class: com.anythink.interstitial.a.f.12
                @Override // java.lang.Runnable
                public final void run() {
                    f.b(f.this, customInterstitialAdapter, jCurrentTimeMillis, jElapsedRealtime);
                }
            }));
        }
    }

    private void b(CustomInterstitialAdapter customInterstitialAdapter, long j, long j2) {
        if (this.g) {
            return;
        }
        this.g = true;
        com.anythink.core.common.u.c.a().a(customInterstitialAdapter);
        this.c = j;
        this.d = j2;
        k kVarA = k.a(customInterstitialAdapter);
        if (customInterstitialAdapter != null) {
            n nVarA = a(customInterstitialAdapter);
            nVarA.a(customInterstitialAdapter.getInternalNetworkInfoMap());
            String ilrd = customInterstitialAdapter.getILRD();
            if (!TextUtils.isEmpty(ilrd)) {
                nVarA.d(ilrd);
            }
            com.anythink.core.common.u.d.a().a(nVarA, customInterstitialAdapter.getUnitGroupInfo(), 6);
            aa.a(nVarA, i.s.c, i.s.m, "");
            com.anythink.core.common.u.d.a().a(customInterstitialAdapter, new AnonymousClass2(nVarA, customInterstitialAdapter));
            com.anythink.core.common.f fVarA = nVarA.a();
            if (fVarA != null) {
                fVarA.a(kVarA);
            }
            a(nVarA.aQ(), 6);
        }
        if (this.a != null) {
            if (kVarA.getNetworkFirmId() == -1) {
                g.a(i.o.d, customInterstitialAdapter, null);
            }
            this.a.onInterstitialAdShow(kVarA);
        }
    }

    /* JADX INFO: renamed from: com.anythink.interstitial.a.f$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.core.common.u.d.a {
        final /* synthetic */ n a;
        final /* synthetic */ CustomInterstitialAdapter b;

        @Override // com.anythink.core.common.u.d.a
        public final void b() {
        }

        AnonymousClass2(n nVar, CustomInterstitialAdapter customInterstitialAdapter) {
            this.a = nVar;
            this.b = customInterstitialAdapter;
        }

        @Override // com.anythink.core.common.u.d.a
        public final void a() {
            ai.b(this.a, this.b);
            com.anythink.core.common.t.e.a(s.b().g());
            com.anythink.core.common.t.e.a(4, this.a, this.b.getUnitGroupInfo());
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onDeeplinkCallback(final boolean z) {
        final CustomInterstitialAdapter customInterstitialAdapter = this.b;
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bk, new Runnable() { // from class: com.anythink.interstitial.a.f.3
            @Override // java.lang.Runnable
            public final void run() {
                if (f.this.a != null && (f.this.a instanceof ATInterstitialExListener)) {
                    ((ATInterstitialExListener) f.this.a).onDeeplinkCallback(k.a(customInterstitialAdapter), z);
                }
                CustomInterstitialAdapter customInterstitialAdapter2 = customInterstitialAdapter;
                if (customInterstitialAdapter2 != null) {
                    aa.a(customInterstitialAdapter2.getTrackingInfo(), i.s.j, z ? i.s.m : i.s.n, "");
                }
            }
        }));
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onDownloadConfirm(final Context context, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        final CustomInterstitialAdapter customInterstitialAdapter = this.b;
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bm, new Runnable() { // from class: com.anythink.interstitial.a.f.4
            @Override // java.lang.Runnable
            public final void run() {
                if (f.this.a != null && (f.this.a instanceof ATInterstitialExListener)) {
                    ((ATInterstitialExListener) f.this.a).onDownloadConfirm(context, k.a(customInterstitialAdapter), aTNetworkConfirmInfo);
                }
                CustomInterstitialAdapter customInterstitialAdapter2 = customInterstitialAdapter;
                if (customInterstitialAdapter2 != null) {
                    aa.a(customInterstitialAdapter2.getTrackingInfo(), i.s.k, i.s.m, "");
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(n nVar) {
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
        if (TextUtils.isEmpty(str) || (fVar = this.i) == null || !fVar.a((ATAdStatusInfo) null, i)) {
            return;
        }
        as asVar = new as();
        asVar.a(s.b().M());
        asVar.c = i;
        if (fVar.n() != null) {
            asVar.a(fVar.n());
        }
        fVar.b(s.b().M(), "3", str, asVar, null);
    }

    static /* synthetic */ void a(f fVar, CustomInterstitialAdapter customInterstitialAdapter, long j, long j2) {
        if (customInterstitialAdapter != null) {
            n trackingInfo = customInterstitialAdapter.getTrackingInfo();
            int dismissType = fVar.e;
            if (dismissType == 0) {
                dismissType = customInterstitialAdapter.getDismissType();
            }
            if (dismissType == 0) {
                dismissType = 1;
            }
            trackingInfo.K(dismissType);
            a aVar = fVar.h;
            if (aVar != null) {
                trackingInfo.aj(aVar.c());
                trackingInfo.ah(fVar.h.f());
                trackingInfo.ai(fVar.h.e());
            }
            aa.a(trackingInfo, i.s.e, i.s.m, "");
            long j3 = fVar.c;
            if (j3 != 0) {
                com.anythink.core.common.t.f.a(trackingInfo, false, j3, j, j2 - fVar.d);
            }
            Map<String, Object> adExtraInfoMap = customInterstitialAdapter.getAdExtraInfoMap();
            if (adExtraInfoMap != null) {
                Object obj = adExtraInfoMap.get(com.anythink.core.common.a.b.C0013b.a);
                if (obj instanceof Integer) {
                    trackingInfo.S(((Integer) obj).intValue());
                }
            }
            com.anythink.core.common.u.c.a().c(customInterstitialAdapter);
            com.anythink.core.common.t.f.a(trackingInfo, false);
            s.b();
            s.b(fVar.new AnonymousClass9(customInterstitialAdapter));
            a aVar2 = fVar.h;
            if (aVar2 != null) {
                if (aVar2.b() != 1) {
                    s.b();
                    s.b(fVar.new AnonymousClass10());
                    ATInterstitialListener aTInterstitialListener = fVar.a;
                    if (aTInterstitialListener != null) {
                        aTInterstitialListener.onInterstitialAdClose(k.a(trackingInfo, customInterstitialAdapter));
                    }
                }
            } else {
                ATInterstitialListener aTInterstitialListener2 = fVar.a;
                if (aTInterstitialListener2 != null) {
                    aTInterstitialListener2.onInterstitialAdClose(k.a(trackingInfo, customInterstitialAdapter));
                }
            }
            if (trackingInfo != null) {
                b(trackingInfo);
            }
            fVar.a(trackingInfo != null ? trackingInfo.aQ() : "", 18);
        }
        s.b().ai();
    }

    static /* synthetic */ void b(f fVar, CustomInterstitialAdapter customInterstitialAdapter, long j, long j2) {
        if (fVar.g) {
            return;
        }
        fVar.g = true;
        com.anythink.core.common.u.c.a().a(customInterstitialAdapter);
        fVar.c = j;
        fVar.d = j2;
        k kVarA = k.a(customInterstitialAdapter);
        if (customInterstitialAdapter != null) {
            n nVarA = fVar.a(customInterstitialAdapter);
            nVarA.a(customInterstitialAdapter.getInternalNetworkInfoMap());
            String ilrd = customInterstitialAdapter.getILRD();
            if (!TextUtils.isEmpty(ilrd)) {
                nVarA.d(ilrd);
            }
            com.anythink.core.common.u.d.a().a(nVarA, customInterstitialAdapter.getUnitGroupInfo(), 6);
            aa.a(nVarA, i.s.c, i.s.m, "");
            com.anythink.core.common.u.d.a().a(customInterstitialAdapter, fVar.new AnonymousClass2(nVarA, customInterstitialAdapter));
            com.anythink.core.common.f fVarA = nVarA.a();
            if (fVarA != null) {
                fVarA.a(kVarA);
            }
            fVar.a(nVarA.aQ(), 6);
        }
        if (fVar.a != null) {
            if (kVarA.getNetworkFirmId() == -1) {
                g.a(i.o.d, customInterstitialAdapter, null);
            }
            fVar.a.onInterstitialAdShow(kVarA);
        }
    }
}
