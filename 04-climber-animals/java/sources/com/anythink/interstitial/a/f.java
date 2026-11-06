package com.anythink.interstitial.a;

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
import com.anythink.core.common.h.i;
import com.anythink.core.common.h.n;
import com.anythink.core.common.u;
import com.anythink.core.common.u.h;
import com.anythink.core.common.v.ab;
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

    public f(CustomInterstitialAdapter customInterstitialAdapter, ATInterstitialListener aTInterstitialListener, a aVar) {
        this.a = aTInterstitialListener;
        this.b = customInterstitialAdapter;
        this.h = aVar;
        if (aVar != null) {
            aVar.a(customInterstitialAdapter, this);
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdVideoStart() {
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            n trackingInfo = customInterstitialAdapter.getTrackingInfo();
            if (this.f) {
                com.anythink.core.common.u.c.a(t.b().g()).a(8, trackingInfo);
                ATInterstitialListener aTInterstitialListener = this.a;
                if (aTInterstitialListener != null) {
                    aTInterstitialListener.onInterstitialAdVideoStart(l.a(this.b));
                }
            }
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdVideoEnd() {
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            if (customInterstitialAdapter.getDismissType() == 0) {
                this.e = 3;
            }
            n trackingInfo = this.b.getTrackingInfo();
            com.anythink.core.common.u.c.a(t.b().g()).a(9, trackingInfo);
            ATInterstitialListener aTInterstitialListener = this.a;
            if (aTInterstitialListener != null) {
                aTInterstitialListener.onInterstitialAdVideoEnd(l.a(this.b));
            }
            ab.a(trackingInfo, j.r.g, j.r.m, "");
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdVideoError(String str, String str2) {
        String strAI;
        this.e = 99;
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adShowError, str, str2);
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            n trackingInfo = customInterstitialAdapter.getTrackingInfo();
            if (trackingInfo.Y() == 66) {
                this.f = false;
            }
            com.anythink.core.common.u.e.a(trackingInfo, errorCode, this.b.getInternalNetworkInfoMap());
            if (trackingInfo != null) {
                strAI = trackingInfo.aI();
                a(trackingInfo.aI());
            } else {
                strAI = "";
            }
            a(strAI, 7);
            ab.a(trackingInfo, j.r.h, j.r.n, str2);
        }
        ATInterstitialListener aTInterstitialListener = this.a;
        if (aTInterstitialListener != null) {
            aTInterstitialListener.onInterstitialAdVideoError(errorCode);
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdClose() {
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            a aVar = this.h;
            if (aVar != null) {
                aVar.c(customInterstitialAdapter);
            }
            n trackingInfo = this.b.getTrackingInfo();
            int dismissType = this.e;
            if (dismissType == 0) {
                dismissType = this.b.getDismissType();
            }
            if (dismissType == 0) {
                dismissType = 1;
            }
            trackingInfo.K(dismissType);
            a aVar2 = this.h;
            if (aVar2 != null) {
                trackingInfo.ai(aVar2.c());
                trackingInfo.ag(this.h.f());
                trackingInfo.ah(this.h.e());
            }
            ab.a(trackingInfo, j.r.e, j.r.m, "");
            long j = this.c;
            if (j != 0) {
                com.anythink.core.common.u.e.a(trackingInfo, false, j, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.d);
            }
            Map<String, Object> adExtraInfoMap = this.b.getAdExtraInfoMap();
            if (adExtraInfoMap != null) {
                Object obj = adExtraInfoMap.get(com.anythink.core.common.a.b.C0077b.a);
                if (obj instanceof Integer) {
                    trackingInfo.R(((Integer) obj).intValue());
                }
            }
            com.anythink.core.common.u.e.a(trackingInfo, false);
            try {
                com.anythink.core.common.v.d.a().d(this.b);
                this.b.clearImpressionListener();
                this.b.internalDestory();
            } catch (Throwable unused) {
            }
            a aVar3 = this.h;
            if (aVar3 != null) {
                if (aVar3.b() != 1) {
                    this.h.a();
                    ATInterstitialListener aTInterstitialListener = this.a;
                    if (aTInterstitialListener != null) {
                        aTInterstitialListener.onInterstitialAdClose(l.a(trackingInfo, this.b));
                    }
                }
            } else {
                ATInterstitialListener aTInterstitialListener2 = this.a;
                if (aTInterstitialListener2 != null) {
                    aTInterstitialListener2.onInterstitialAdClose(l.a(trackingInfo, this.b));
                }
            }
            if (trackingInfo != null) {
                a(trackingInfo.aI());
            }
            a(trackingInfo != null ? trackingInfo.aI() : "", 18);
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdClicked() {
        a aVar;
        if (this.b != null) {
            n nVarA = a();
            com.anythink.core.common.u.c.a(t.b().g()).a(6, nVarA);
            if (nVarA != null ? nVarA.aw() : false) {
                return;
            } else {
                ab.a(nVarA, j.r.d, j.r.m, "");
            }
        }
        com.anythink.core.common.v.c.a().b(this.b);
        ATInterstitialListener aTInterstitialListener = this.a;
        if (aTInterstitialListener != null) {
            aTInterstitialListener.onInterstitialAdClicked(l.a(this.b));
        }
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter == null || (aVar = this.h) == null) {
            return;
        }
        aVar.b(customInterstitialAdapter);
    }

    private n a() {
        a aVar;
        n trackingInfo = this.b.getTrackingInfo();
        if (trackingInfo != null && (aVar = this.h) != null) {
            if (aVar.b() == 0) {
                trackingInfo.ai(0);
                trackingInfo.aj(-1);
            } else {
                trackingInfo.ai(this.h.c());
                trackingInfo.aj(this.h.d());
            }
        }
        return trackingInfo;
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdShow() {
        a aVar;
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null && (aVar = this.h) != null) {
            aVar.a(customInterstitialAdapter);
        }
        if ((this.b == null || (com.anythink.core.common.v.d.a().a(this.b) && com.anythink.core.common.v.d.a().b(this.b))) && !this.g) {
            this.g = true;
            com.anythink.core.common.v.c.a().a(this.b);
            this.c = System.currentTimeMillis();
            this.d = SystemClock.elapsedRealtime();
            l lVarA = l.a(this.b);
            if (this.b != null) {
                final n nVarA = a();
                nVarA.a(this.b.getInternalNetworkInfoMap());
                String ilrd = this.b.getILRD();
                if (!TextUtils.isEmpty(ilrd)) {
                    nVarA.d(ilrd);
                }
                com.anythink.core.common.v.d.a().a(nVarA, this.b.getUnitGroupInfo(), 6);
                String strAI = "";
                ab.a(nVarA, j.r.c, j.r.m, "");
                com.anythink.core.common.v.d.a().a(this.b, new com.anythink.core.common.v.d.a() { // from class: com.anythink.interstitial.a.f.1
                    @Override // com.anythink.core.common.v.d.a
                    public final void b() {
                    }

                    @Override // com.anythink.core.common.v.d.a
                    public final void a() {
                        com.anythink.core.common.u.c.a(t.b().g()).a(4, nVarA, f.this.b.getUnitGroupInfo());
                    }
                });
                if (nVarA != null) {
                    strAI = nVarA.aI();
                    u.a().a(strAI, lVarA);
                }
                a(strAI, 6);
            }
            if (this.a != null) {
                if (lVarA.getNetworkFirmId() == -1) {
                    h.a("Interstitial", this.b, null);
                }
                this.a.onInterstitialAdShow(lVarA);
            }
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onDeeplinkCallback(boolean z) {
        ATInterstitialListener aTInterstitialListener = this.a;
        if (aTInterstitialListener != null && (aTInterstitialListener instanceof ATInterstitialExListener)) {
            ((ATInterstitialExListener) aTInterstitialListener).onDeeplinkCallback(l.a(this.b), z);
        }
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            ab.a(customInterstitialAdapter.getTrackingInfo(), j.r.j, z ? j.r.m : j.r.n, "");
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        ATInterstitialListener aTInterstitialListener = this.a;
        if (aTInterstitialListener != null && (aTInterstitialListener instanceof ATInterstitialExListener)) {
            ((ATInterstitialExListener) aTInterstitialListener).onDownloadConfirm(context, l.a(this.b), aTNetworkConfirmInfo);
        }
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            ab.a(customInterstitialAdapter.getTrackingInfo(), j.r.k, j.r.m, "");
        }
    }

    private static void a(String str) {
        i iVarC;
        if (TextUtils.isEmpty(str) || (iVarC = u.a().c(str)) == null) {
            return;
        }
        u.a().d(str);
        com.anythink.core.common.f.a(t.b().g(), str, "3").c(u.a().b(str, iVarC.a()));
    }

    private static void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.core.common.f fVarA = com.anythink.core.common.f.a(t.b().M(), str, "3");
        if (fVarA.a((ATAdStatusInfo) null, i)) {
            ar arVar = new ar();
            arVar.a(t.b().M());
            arVar.c = i;
            if (fVarA.i() != null) {
                arVar.a(fVarA.i());
            }
            fVarA.b(t.b().M(), "3", str, arVar, null);
        }
    }
}
