package com.anythink.splashad.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.l;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ar;
import com.anythink.core.common.h.i;
import com.anythink.core.common.h.n;
import com.anythink.core.common.u;
import com.anythink.core.common.u.h;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.v.am;
import com.anythink.splashad.api.ATSplashAdExtraInfo;
import com.anythink.splashad.api.ATSplashSkipAdListener;
import com.anythink.splashad.api.ATSplashSkipInfo;
import com.anythink.splashad.api.IATSplashEyeAd;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEventListener;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public final class f implements CustomSplashEventListener {
    CustomSplashAdapter a;
    a b;
    boolean c;
    long d;
    private Timer e;
    private boolean f = false;
    private int g = 0;

    public f(CustomSplashAdapter customSplashAdapter, a aVar) {
        this.a = customSplashAdapter;
        this.b = aVar;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdShow() {
        if ((this.a == null || (com.anythink.core.common.v.d.a().a(this.a) && com.anythink.core.common.v.d.a().b(this.a))) && !this.c) {
            this.c = true;
            com.anythink.core.common.v.c.a().a(this.a);
            l lVarA = l.a(this.a);
            CustomSplashAdapter customSplashAdapter = this.a;
            if (customSplashAdapter != null) {
                final n trackingInfo = customSplashAdapter.getTrackingInfo();
                trackingInfo.a(this.a.getInternalNetworkInfoMap());
                com.anythink.core.common.v.d.a().a(trackingInfo, this.a.getUnitGroupInfo(), 6);
                com.anythink.core.common.v.d.a().a(this.a, new com.anythink.core.common.v.d.a() { // from class: com.anythink.splashad.a.f.1
                    @Override // com.anythink.core.common.v.d.a
                    public final void b() {
                    }

                    @Override // com.anythink.core.common.v.d.a
                    public final void a() {
                        com.anythink.core.common.u.c.a(t.b().g()).a(4, trackingInfo, f.this.a.getUnitGroupInfo());
                    }
                });
                ab.a(trackingInfo, j.r.c, j.r.m, "");
                ATSplashSkipInfo splashSkipInfo = this.a.getSplashSkipInfo();
                if (splashSkipInfo != null && splashSkipInfo.canUseCustomSkipView() && this.a.isSupportCustomSkipView() && this.e == null) {
                    long callbackInterval = splashSkipInfo.getCallbackInterval();
                    long countDownDuration = splashSkipInfo.getCountDownDuration();
                    ViewGroup container = splashSkipInfo.getContainer();
                    com.anythink.core.common.v.a.f.b bVar = new com.anythink.core.common.v.a.f.b(1);
                    ATSplashSkipAdListener aTSplashSkipAdListener = splashSkipInfo.getATSplashSkipAdListener();
                    this.d = countDownDuration;
                    Timer timer = new Timer();
                    this.e = timer;
                    timer.schedule(new AnonymousClass2(container, bVar, aTSplashSkipAdListener, countDownDuration, callbackInterval), callbackInterval, callbackInterval);
                    t.b().b(new AnonymousClass3(aTSplashSkipAdListener, countDownDuration, callbackInterval));
                }
                if (trackingInfo != null) {
                    u.a().a(trackingInfo.aI(), lVarA);
                }
                a(trackingInfo != null ? trackingInfo.aI() : "", 6);
            }
            if (this.b != null) {
                if (lVarA.getNetworkFirmId() == -1) {
                    h.a("Splash", this.a, null);
                }
                this.b.onAdShow(lVarA);
            }
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdClicked() {
        CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            n trackingInfo = customSplashAdapter.getTrackingInfo();
            com.anythink.core.common.u.c.a(t.b().g()).a(6, trackingInfo);
            if (trackingInfo != null ? trackingInfo.aw() : false) {
                return;
            } else {
                ab.a(trackingInfo, j.r.d, j.r.m, "");
            }
        }
        com.anythink.core.common.v.c.a().b(this.a);
        a aVar = this.b;
        if (aVar != null) {
            aVar.onAdClick(l.a(this.a));
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdDismiss() {
        boolean zBooleanValue;
        Timer timer = this.e;
        if (timer != null) {
            timer.cancel();
        }
        CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            n trackingInfo = customSplashAdapter.getTrackingInfo();
            int dismissType = this.g;
            if (dismissType != 0) {
                trackingInfo.K(dismissType);
            } else {
                dismissType = this.a.getDismissType();
                if (dismissType == 0) {
                    dismissType = 1;
                }
                trackingInfo.K(dismissType);
            }
            Map<String, Object> adExtraInfoMap = this.a.getAdExtraInfoMap();
            if (adExtraInfoMap != null) {
                Object objRemove = adExtraInfoMap.remove(com.anythink.core.common.a.b.C0077b.a);
                Object objRemove2 = adExtraInfoMap.remove(com.anythink.core.common.a.b.C0077b.b);
                if (objRemove instanceof Integer) {
                    trackingInfo.R(((Integer) objRemove).intValue());
                }
                zBooleanValue = objRemove2 instanceof Boolean ? ((Boolean) objRemove2).booleanValue() : true;
                Object objRemove3 = adExtraInfoMap.remove(com.anythink.core.common.a.b.C0077b.c);
                Object objRemove4 = adExtraInfoMap.remove(com.anythink.core.common.a.b.C0077b.d);
                if (objRemove3 instanceof Integer) {
                    trackingInfo.S(((Integer) objRemove3).intValue());
                } else {
                    trackingInfo.S(2);
                }
                if (objRemove4 instanceof Integer) {
                    trackingInfo.T(((Integer) objRemove4).intValue());
                } else {
                    trackingInfo.T(2);
                }
            } else {
                zBooleanValue = true;
            }
            com.anythink.core.common.u.e.a(trackingInfo, false);
            ATSplashSkipInfo splashSkipInfo = this.a.getSplashSkipInfo();
            if (splashSkipInfo != null && splashSkipInfo.canUseCustomSkipView()) {
                this.a.startSplashCustomSkipViewClickEye();
                Timer timer2 = this.e;
                if (timer2 != null) {
                    timer2.cancel();
                    this.e = null;
                }
                splashSkipInfo.destroy();
                this.a.setSplashSkipInfo(null);
            }
            ab.a(trackingInfo, j.r.e, j.r.m, "");
            a(trackingInfo.aI());
            CustomSplashAdapter customSplashAdapter2 = this.a;
            IATSplashEyeAd splashEyeAd = customSplashAdapter2 instanceof CustomSplashAdapter ? customSplashAdapter2.getSplashEyeAd() : null;
            if (this.b != null && !this.f) {
                this.f = true;
                if (trackingInfo.Y() != 66 || zBooleanValue) {
                    this.b.onCallbackAdDismiss(l.a(trackingInfo, this.a), new ATSplashAdExtraInfo(dismissType, splashEyeAd));
                }
            }
            if (splashEyeAd == null) {
                CustomSplashAdapter customSplashAdapter3 = this.a;
                if (customSplashAdapter3 != null) {
                    customSplashAdapter3.cleanImpressionListener();
                }
                if (this.a != null) {
                    com.anythink.core.common.v.d.a().d(this.a);
                    this.a.internalDestory();
                }
            }
            a(trackingInfo != null ? trackingInfo.aI() : "", 18);
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onDeeplinkCallback(boolean z) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.onDeeplinkCallback(l.a(this.a), z);
        }
        CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            ab.a(customSplashAdapter.getTrackingInfo(), j.r.j, z ? j.r.m : j.r.n, "");
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.onDownloadConfirm(context, l.a(this.a), aTNetworkConfirmInfo);
        }
        CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            ab.a(customSplashAdapter.getTrackingInfo(), j.r.k, j.r.m, "");
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdShowFail(AdError adError) {
        String strAI;
        CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            n trackingInfo = customSplashAdapter.getTrackingInfo();
            com.anythink.core.common.u.e.a(trackingInfo, adError, this.a.getInternalNetworkInfoMap());
            if (trackingInfo != null) {
                strAI = trackingInfo.aI();
                a(trackingInfo.aI());
            } else {
                strAI = "";
            }
            a(strAI, 7);
            ab.a(trackingInfo, j.r.l, j.r.n, adError != null ? adError.getFullErrorInfo() : "");
        }
    }

    private void a(ATSplashSkipInfo aTSplashSkipInfo) {
        if (this.e == null) {
            long callbackInterval = aTSplashSkipInfo.getCallbackInterval();
            long countDownDuration = aTSplashSkipInfo.getCountDownDuration();
            ViewGroup container = aTSplashSkipInfo.getContainer();
            com.anythink.core.common.v.a.f.b bVar = new com.anythink.core.common.v.a.f.b(1);
            ATSplashSkipAdListener aTSplashSkipAdListener = aTSplashSkipInfo.getATSplashSkipAdListener();
            this.d = countDownDuration;
            Timer timer = new Timer();
            this.e = timer;
            timer.schedule(new AnonymousClass2(container, bVar, aTSplashSkipAdListener, countDownDuration, callbackInterval), callbackInterval, callbackInterval);
            t.b().b(new AnonymousClass3(aTSplashSkipAdListener, countDownDuration, callbackInterval));
        }
    }

    /* JADX INFO: renamed from: com.anythink.splashad.a.f$2, reason: invalid class name */
    final class AnonymousClass2 extends TimerTask {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ com.anythink.core.common.v.a.f.b b;
        final /* synthetic */ ATSplashSkipAdListener c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;

        AnonymousClass2(ViewGroup viewGroup, com.anythink.core.common.v.a.f.b bVar, ATSplashSkipAdListener aTSplashSkipAdListener, long j, long j2) {
            this.a = viewGroup;
            this.b = bVar;
            this.c = aTSplashSkipAdListener;
            this.d = j;
            this.e = j2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            ViewGroup viewGroup = this.a;
            if (viewGroup == null || am.a(viewGroup, this.b)) {
                t.b().b(new Runnable() { // from class: com.anythink.splashad.a.f.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (f.this.d <= 0) {
                            f.this.a(3);
                            f.this.onSplashAdDismiss();
                        } else if (AnonymousClass2.this.c != null) {
                            AnonymousClass2.this.c.onAdTick(AnonymousClass2.this.d, f.this.d);
                        }
                        f.this.d -= AnonymousClass2.this.e;
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.splashad.a.f$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ ATSplashSkipAdListener a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        AnonymousClass3(ATSplashSkipAdListener aTSplashSkipAdListener, long j, long j2) {
            this.a = aTSplashSkipAdListener;
            this.b = j;
            this.c = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ATSplashSkipAdListener aTSplashSkipAdListener = this.a;
            if (aTSplashSkipAdListener != null) {
                aTSplashSkipAdListener.onAdTick(this.b, f.this.d);
                f.this.d -= this.c;
            }
        }
    }

    private void a() {
        Timer timer = this.e;
        if (timer != null) {
            timer.cancel();
            this.e = null;
        }
    }

    final void a(int i) {
        this.g = i;
    }

    private static void a(String str) {
        i iVarC;
        if (TextUtils.isEmpty(str) || (iVarC = u.a().c(str)) == null) {
            return;
        }
        u.a().d(str);
        com.anythink.core.common.f.a(t.b().g(), str, "4").c(u.a().b(str, iVarC.a()));
    }

    private static void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.core.common.f fVarA = com.anythink.core.common.f.a(t.b().M(), str, "4");
        if (fVarA.a((ATAdStatusInfo) null, i)) {
            ar arVar = new ar();
            arVar.a(t.b().M());
            arVar.c = i;
            fVarA.b(t.b().M(), "4", str, arVar, null);
        }
    }
}
