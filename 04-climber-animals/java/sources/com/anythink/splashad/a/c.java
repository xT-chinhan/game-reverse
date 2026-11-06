package com.anythink.splashad.a;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.IATBaseAdAdapter;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.g;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.ar;
import com.anythink.core.common.h.n;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.p;
import com.anythink.core.common.v.r;
import com.anythink.splashad.api.ATSplashSkipAdListener;
import com.anythink.splashad.api.ATSplashSkipInfo;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static Map<String, c> d = new ConcurrentHashMap(3);
    private Context a;
    private String b;
    private com.anythink.core.common.f c;

    public static c a(Context context, String str) {
        c cVar = d.get(str);
        if (cVar == null) {
            synchronized (c.class) {
                if (cVar == null) {
                    cVar = new c(context, str);
                    d.put(str, cVar);
                }
            }
        }
        return cVar;
    }

    private c(Context context, String str) {
        this.a = context.getApplicationContext();
        this.b = str;
        com.anythink.core.common.f fVarA = com.anythink.core.common.f.a(context, str, "4");
        this.c = fVarA;
        fVarA.a(new d());
    }

    public final void a(Context context, b bVar, ATAdMultipleLoadedListener aTAdMultipleLoadedListener, int i, boolean z, int i2, com.anythink.core.common.d.c cVar, Map<String, Object> map, ATAdRequest aTAdRequest, long j, long j2) {
        ar arVar = new ar();
        arVar.a(context);
        arVar.a(aTAdRequest);
        arVar.n = j;
        arVar.o = j2;
        arVar.h = i;
        arVar.j = z;
        arVar.c = i2;
        arVar.d = cVar;
        arVar.f = aTAdMultipleLoadedListener;
        if (map != null) {
            try {
                arVar.g = new HashMap(map);
            } catch (Throwable unused) {
            }
        }
        if (aTAdRequest != null) {
            arVar.l = aTAdRequest.getATAdxBidFloorInfo();
        }
        com.anythink.core.common.f fVar = this.c;
        if (fVar != null) {
            fVar.b(this.a, "4", this.b, arVar, bVar);
        }
    }

    public final void a() {
        com.anythink.core.common.f fVar = this.c;
        if (fVar != null) {
            fVar.j();
        }
    }

    public final synchronized void a(final Activity activity, final ViewGroup viewGroup, final a aVar, final ATEventInterface aTEventInterface, final ATSplashSkipInfo aTSplashSkipInfo, final ATShowConfig aTShowConfig, final Map<String, Object> map, final ATNativeAdCustomRender aTNativeAdCustomRender) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        ae aeVar = new ae();
        aeVar.a(map);
        if (aTShowConfig != null) {
            aeVar.a(aTShowConfig.getATAdInfo());
        }
        com.anythink.core.common.f fVar = this.c;
        if (fVar != null) {
            aeVar.a(fVar.i());
        }
        final com.anythink.core.common.h.c cVarB = this.c.b((Context) activity, false, true, aeVar);
        if (cVarB == null) {
            Log.e("anythink", "Splash No Cache.");
            return;
        }
        if (cVarB != null && (cVarB.e() instanceof CustomSplashAdapter)) {
            this.c.a(cVarB);
            cVarB.a(cVarB.c() + 1);
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.splashad.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    String scenarioId;
                    String showCustomExt;
                    final CustomSplashAdapter customSplashAdapter = (CustomSplashAdapter) cVarB.e();
                    Activity activity2 = activity;
                    if (activity2 != null) {
                        customSplashAdapter.refreshActivityContext(activity2);
                    }
                    final n trackingInfo = cVarB.e().getTrackingInfo();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    ATShowConfig aTShowConfig2 = aTShowConfig;
                    if (aTShowConfig2 != null) {
                        scenarioId = aTShowConfig2.getScenarioId();
                        showCustomExt = aTShowConfig.getShowCustomExt();
                        r.a(aTShowConfig.getATCustomContentResult(), trackingInfo);
                    } else {
                        scenarioId = "";
                        showCustomExt = "";
                    }
                    if (trackingInfo != null) {
                        trackingInfo.F = scenarioId;
                        trackingInfo.z(showCustomExt);
                        trackingInfo.n(p.a(trackingInfo.aJ(), trackingInfo.M(), jCurrentTimeMillis));
                        aj.a(c.this.a, trackingInfo);
                        aj.a((Map<String, Object>) map, trackingInfo);
                        aj.a(c.this.b, trackingInfo);
                    }
                    com.anythink.core.common.a.a().a(c.this.a, cVarB);
                    com.anythink.core.common.u.c.a(c.this.a).a(13, trackingInfo, customSplashAdapter.getUnitGroupInfo(), jCurrentTimeMillis);
                    com.anythink.core.common.v.d.a().a(trackingInfo, customSplashAdapter.getUnitGroupInfo(), com.anythink.core.common.v.d.b);
                    t.b().b(new Runnable() { // from class: com.anythink.splashad.a.c.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            s sVarC = t.b().c();
                            if (sVarC != null) {
                                CustomSplashAdapter customSplashAdapter2 = customSplashAdapter;
                                customSplashAdapter2.setAdDownloadListener(sVarC.createDataFetchListener(customSplashAdapter2, null, aTEventInterface));
                            }
                            boolean z = aTSplashSkipInfo != null && aTSplashSkipInfo.canUseCustomSkipView();
                            boolean zIsSupportCustomSkipView = customSplashAdapter.isSupportCustomSkipView();
                            if (z && zIsSupportCustomSkipView) {
                                aTSplashSkipInfo.setContainer(viewGroup);
                                customSplashAdapter.setSplashSkipInfo(aTSplashSkipInfo);
                            }
                            final f fVar2 = new f(customSplashAdapter, aVar);
                            if (customSplashAdapter.isMixNative()) {
                                c.a(c.this, customSplashAdapter, activity, viewGroup, fVar2, z, cVarB, trackingInfo, aTNativeAdCustomRender);
                            } else if (customSplashAdapter.isMixBanner()) {
                                c.a(c.this, customSplashAdapter, activity, viewGroup, fVar2, z, trackingInfo);
                            } else {
                                customSplashAdapter.internalShow(activity, viewGroup, new e(fVar2));
                            }
                            n trackingInfo2 = customSplashAdapter.getTrackingInfo();
                            com.anythink.core.common.u.e.a("4", trackingInfo2, trackingInfo2.aJ(), trackingInfo2.aI(), trackingInfo2.M(), trackingInfo2.Y(), 4, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            if (z) {
                                ATSplashSkipAdListener aTSplashSkipAdListener = aTSplashSkipInfo.getATSplashSkipAdListener();
                                if (aTSplashSkipAdListener != null) {
                                    aTSplashSkipAdListener.isSupportCustomSkipView(zIsSupportCustomSkipView);
                                }
                                if (zIsSupportCustomSkipView) {
                                    aTSplashSkipInfo.getSkipView().setOnClickListener(new View.OnClickListener() { // from class: com.anythink.splashad.a.c.1.1.1
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            f fVar3 = fVar2;
                                            if (fVar3 != null) {
                                                fVar3.a(2);
                                                fVar2.onSplashAdDismiss();
                                            }
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if (aTSplashSkipInfo != null) {
                                Log.e("anythink", "This AdSource does't support 'Custom SkipView' or 'SkipView' is null.");
                            }
                        }
                    });
                }
            });
        }
    }

    private ae a(ATShowConfig aTShowConfig, Map<String, Object> map) {
        ae aeVar = new ae();
        aeVar.a(map);
        if (aTShowConfig != null) {
            aeVar.a(aTShowConfig.getATAdInfo());
        }
        com.anythink.core.common.f fVar = this.c;
        if (fVar != null) {
            aeVar.a(fVar.i());
        }
        return aeVar;
    }

    public final List<ATAdInfo> a(Context context) {
        return this.c.a(context);
    }

    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        return this.c.a(context, map);
    }

    private boolean a(ATAdStatusInfo aTAdStatusInfo, int i) {
        return this.c.a(aTAdStatusInfo, i);
    }

    public final g a(String str) {
        return this.c.b(str);
    }

    public final com.anythink.core.common.h.c a(Context context, ae aeVar) {
        return this.c.b(context, false, false, aeVar);
    }

    private void a(CustomSplashAdapter customSplashAdapter, Activity activity, ViewGroup viewGroup, f fVar, boolean z, com.anythink.core.common.h.c cVar, n nVar, ATNativeAdCustomRender aTNativeAdCustomRender) {
        ViewGroup viewGroup2;
        BaseAd baseAdF = cVar.f();
        if (baseAdF == null) {
            if (fVar != null) {
                fVar.a(99);
                fVar.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", "showThirdPartyNativeSplash fail, no ad cache."));
                fVar.onSplashAdDismiss();
                return;
            }
            return;
        }
        try {
            com.anythink.core.common.l.c.a.a aVarA = com.anythink.basead.mixad.b.b.a(customSplashAdapter, new com.anythink.core.common.l.d.a.C0085a().a(activity).a(nVar).a(baseAdF).a(z).a(aTNativeAdCustomRender).a(new AnonymousClass2(fVar, new boolean[]{false})).a());
            if (aVarA instanceof com.anythink.core.common.l.c.a.f) {
                Object objA = ((com.anythink.core.common.l.c.a.f) aVarA).a();
                if (objA instanceof View) {
                    View view = (View) objA;
                    am.a(view);
                    ViewGroup customAdContainer = baseAdF.getCustomAdContainer();
                    if (customAdContainer != null) {
                        viewGroup2 = view;
                        am.a(customAdContainer);
                        customAdContainer.addView(view);
                        viewGroup2 = customAdContainer;
                    }
                    viewGroup2 = view;
                    viewGroup.addView(viewGroup2);
                    if (objA instanceof com.anythink.core.common.l.e.a.f) {
                        ((com.anythink.core.common.l.e.a.f) objA).registerNativeAdContainer(viewGroup);
                        ((com.anythink.core.common.l.e.a.f) objA).handleFullScreenClick(customAdContainer);
                        return;
                    }
                    return;
                }
                a(fVar, null, "", "Failed to show mixed native splash ad: failed to create splash view.");
                return;
            }
            a(fVar, null, "", "Failed to show mixed native splash ad：create splash bridge with an unknown error.");
        } catch (Throwable th) {
            a(fVar, null, "", "Failed to show mixed native splash ad： ".concat(String.valueOf(th)));
        }
    }

    /* JADX INFO: renamed from: com.anythink.splashad.a.c$2, reason: invalid class name */
    final class AnonymousClass2 extends com.anythink.core.common.l.e.a {
        final /* synthetic */ f a;
        final /* synthetic */ boolean[] b;

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onAdVideoEnd() {
        }

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onAdVideoStart() {
        }

        AnonymousClass2(f fVar, boolean[] zArr) {
            this.a = fVar;
            this.b = zArr;
        }

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onClose() {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onSplashAdDismiss();
            }
        }

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onAdImpressed() {
            boolean[] zArr = this.b;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            f fVar = this.a;
            if (fVar != null) {
                fVar.onSplashAdShow();
            }
        }

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onAdClicked(View view) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onSplashAdClicked();
            }
        }

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onVideoError(String str, String str2) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.a(99);
                this.a.onSplashAdShowFail(ErrorCode.getErrorCode("", str, str2));
                this.a.onSplashAdDismiss();
            }
        }

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onDeeplinkCallback(boolean z) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
        public final void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onDownloadConfirm(context, aTNetworkConfirmInfo);
            }
        }
    }

    private void a(CustomSplashAdapter customSplashAdapter, Activity activity, ViewGroup viewGroup, f fVar, boolean z, n nVar) {
        e eVar = new e(fVar);
        try {
            customSplashAdapter.internalShow(activity, viewGroup, eVar);
            com.anythink.core.common.l.d.a aVarA = new com.anythink.core.common.l.d.a.C0085a().a(activity.getApplicationContext()).a(nVar).a(z).a(new AnonymousClass3(eVar)).a();
            com.anythink.core.common.l.c.a.a aVarA2 = com.anythink.basead.mixad.b.b.a(customSplashAdapter, aVarA);
            if (aVarA2 instanceof com.anythink.core.common.l.c.a.f) {
                Object objB = ((com.anythink.core.common.l.c.a.f) aVarA2).b();
                if (objB instanceof View) {
                    View view = (View) objB;
                    am.a(view);
                    viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
                    IATBaseAdAdapter iATBaseAdAdapterF = aVarA.f();
                    if (iATBaseAdAdapterF == null || iATBaseAdAdapterF.supportImpressionCallback()) {
                        return;
                    }
                    view.post(new AnonymousClass4(eVar));
                    return;
                }
                a(null, eVar, "", "Failed to show mixed banner splash ad: failed to get banner view.");
                return;
            }
            a(null, eVar, "", "Failed to show mixed banner splash ad: create splash bridge with unknow error.");
        } catch (Throwable th) {
            a(null, eVar, "", "Failed to show mixed banner splash ad: ".concat(String.valueOf(th)));
        }
    }

    /* JADX INFO: renamed from: com.anythink.splashad.a.c$3, reason: invalid class name */
    final class AnonymousClass3 implements com.anythink.core.common.l.b.a.b {
        final /* synthetic */ e a;

        AnonymousClass3(e eVar) {
            this.a = eVar;
        }

        @Override // com.anythink.core.common.l.b.a.b
        public final void a(int i) {
            this.a.a(i);
            this.a.onAdDismiss();
        }
    }

    /* JADX INFO: renamed from: com.anythink.splashad.a.c$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ e a;

        AnonymousClass4(e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.onAdImpression();
        }
    }

    private static void a(f fVar, e eVar, String str, String str2) {
        if (fVar != null) {
            fVar.a(99);
            fVar.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, str, str2));
            fVar.onSplashAdDismiss();
        }
        if (eVar != null) {
            eVar.a(99);
            eVar.onAdShowFail(str, str2);
            eVar.onAdDismiss();
        }
    }

    static /* synthetic */ void a(c cVar, CustomSplashAdapter customSplashAdapter, Activity activity, ViewGroup viewGroup, f fVar, boolean z, com.anythink.core.common.h.c cVar2, n nVar, ATNativeAdCustomRender aTNativeAdCustomRender) {
        ViewGroup viewGroup2;
        BaseAd baseAdF = cVar2.f();
        if (baseAdF == null) {
            fVar.a(99);
            fVar.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", "showThirdPartyNativeSplash fail, no ad cache."));
            fVar.onSplashAdDismiss();
            return;
        }
        try {
            com.anythink.core.common.l.c.a.a aVarA = com.anythink.basead.mixad.b.b.a(customSplashAdapter, new com.anythink.core.common.l.d.a.C0085a().a(activity).a(nVar).a(baseAdF).a(z).a(aTNativeAdCustomRender).a(cVar.new AnonymousClass2(fVar, new boolean[]{false})).a());
            if (aVarA instanceof com.anythink.core.common.l.c.a.f) {
                Object objA = ((com.anythink.core.common.l.c.a.f) aVarA).a();
                if (objA instanceof View) {
                    View view = (View) objA;
                    am.a(view);
                    ViewGroup customAdContainer = baseAdF.getCustomAdContainer();
                    if (customAdContainer != null) {
                        viewGroup2 = view;
                        am.a(customAdContainer);
                        customAdContainer.addView(view);
                        viewGroup2 = customAdContainer;
                    }
                    viewGroup2 = view;
                    viewGroup.addView(viewGroup2);
                    if (objA instanceof com.anythink.core.common.l.e.a.f) {
                        ((com.anythink.core.common.l.e.a.f) objA).registerNativeAdContainer(viewGroup);
                        ((com.anythink.core.common.l.e.a.f) objA).handleFullScreenClick(customAdContainer);
                        return;
                    }
                    return;
                }
                a(fVar, null, "", "Failed to show mixed native splash ad: failed to create splash view.");
                return;
            }
            a(fVar, null, "", "Failed to show mixed native splash ad：create splash bridge with an unknown error.");
        } catch (Throwable th) {
            a(fVar, null, "", "Failed to show mixed native splash ad： ".concat(String.valueOf(th)));
        }
    }

    static /* synthetic */ void a(c cVar, CustomSplashAdapter customSplashAdapter, Activity activity, ViewGroup viewGroup, f fVar, boolean z, n nVar) {
        e eVar = new e(fVar);
        try {
            customSplashAdapter.internalShow(activity, viewGroup, eVar);
            com.anythink.core.common.l.d.a aVarA = new com.anythink.core.common.l.d.a.C0085a().a(activity.getApplicationContext()).a(nVar).a(z).a(cVar.new AnonymousClass3(eVar)).a();
            com.anythink.core.common.l.c.a.a aVarA2 = com.anythink.basead.mixad.b.b.a(customSplashAdapter, aVarA);
            if (aVarA2 instanceof com.anythink.core.common.l.c.a.f) {
                Object objB = ((com.anythink.core.common.l.c.a.f) aVarA2).b();
                if (objB instanceof View) {
                    View view = (View) objB;
                    am.a(view);
                    viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
                    IATBaseAdAdapter iATBaseAdAdapterF = aVarA.f();
                    if (iATBaseAdAdapterF == null || iATBaseAdAdapterF.supportImpressionCallback()) {
                        return;
                    }
                    view.post(cVar.new AnonymousClass4(eVar));
                    return;
                }
                a(null, eVar, "", "Failed to show mixed banner splash ad: failed to get banner view.");
                return;
            }
            a(null, eVar, "", "Failed to show mixed banner splash ad: create splash bridge with unknow error.");
        } catch (Throwable th) {
            a(null, eVar, "", "Failed to show mixed banner splash ad: ".concat(String.valueOf(th)));
        }
    }
}
