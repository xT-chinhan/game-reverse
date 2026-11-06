package com.anythink.splashad.a;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdCreateConfig;
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
import com.anythink.core.api.bridge.IATBaseAdAdapter;
import com.anythink.core.common.d.r;
import com.anythink.core.common.d.s;
import com.anythink.core.common.g;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.as;
import com.anythink.core.common.h.n;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.al;
import com.anythink.core.common.u.o;
import com.anythink.core.common.u.q;
import com.anythink.splashad.api.ATSplashSkipAdListener;
import com.anythink.splashad.api.ATSplashSkipInfo;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static Map<String, c> e = new ConcurrentHashMap(3);
    ATAdCreateConfig a;
    private Context b;
    private String c;
    private com.anythink.core.common.f d;

    private static c a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = e.get(str);
        if (cVar == null) {
            synchronized (c.class) {
                if (cVar == null) {
                    cVar = new c(context, str);
                    e.put(str, cVar);
                }
            }
        }
        return cVar;
    }

    private c(Context context, String str) {
        this(context, str, null);
    }

    public c(Context context, String str, ATAdCreateConfig aTAdCreateConfig) {
        this.b = context.getApplicationContext();
        this.c = str;
        this.a = aTAdCreateConfig;
        if (aTAdCreateConfig != null && aTAdCreateConfig.isMultiton()) {
            com.anythink.core.common.f fVar = new com.anythink.core.common.f(context, str, "4");
            this.d = fVar;
            fVar.u();
        } else {
            this.d = com.anythink.core.common.f.a(context, str, "4");
        }
        this.d.a(new d());
    }

    public final boolean a() {
        ATAdCreateConfig aTAdCreateConfig = this.a;
        return aTAdCreateConfig != null && aTAdCreateConfig.isMultiton();
    }

    public final com.anythink.core.common.f b() {
        return this.d;
    }

    public final void a(Context context, b bVar, ATAdMultipleLoadedListener aTAdMultipleLoadedListener, int i, boolean z, int i2, com.anythink.core.common.d.c cVar, Map<String, Object> map, ATAdRequest aTAdRequest, long j, long j2) {
        as asVar = new as();
        asVar.a(context);
        asVar.a(aTAdRequest);
        asVar.n = j;
        asVar.o = j2;
        asVar.h = i;
        asVar.j = z;
        asVar.c = i2;
        asVar.d = cVar;
        asVar.f = aTAdMultipleLoadedListener;
        if (map != null) {
            try {
                asVar.g = new HashMap(map);
            } catch (Throwable unused) {
            }
        }
        if (aTAdRequest != null) {
            asVar.l = aTAdRequest.getATAdxBidFloorInfo();
        }
        com.anythink.core.common.f fVar = this.d;
        if (fVar != null) {
            fVar.b(this.b, "4", this.c, asVar, bVar);
        }
    }

    public final void c() {
        com.anythink.core.common.f fVar = this.d;
        if (fVar != null) {
            fVar.o();
        }
    }

    public final com.anythink.core.common.h.c a(Map<String, Object> map) {
        ae aeVarA = a((ATShowConfig) null, map);
        aeVarA.f();
        com.anythink.core.common.f fVar = this.d;
        if (fVar != null) {
            return fVar.b(this.b, false, false, aeVarA);
        }
        return null;
    }

    public final synchronized void a(final Activity activity, final ViewGroup viewGroup, final a aVar, final ATEventInterface aTEventInterface, final ATSplashSkipInfo aTSplashSkipInfo, final ATShowConfig aTShowConfig, final Map<String, Object> map, final ATNativeAdCustomRender aTNativeAdCustomRender) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final com.anythink.core.common.h.c cVarB = this.d.b((Context) activity, false, true, a(aTShowConfig, map));
        if (cVarB == null) {
            Log.e("anythink", "Splash No Cache.");
            return;
        }
        if (cVarB != null && (cVarB.e() instanceof CustomSplashAdapter)) {
            this.d.a(cVarB);
            cVarB.a(cVarB.c() + 1);
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.u, new Runnable() { // from class: com.anythink.splashad.a.c.1
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
                        q.a(aTShowConfig.getATCustomContentResult(), trackingInfo);
                    } else {
                        scenarioId = "";
                        showCustomExt = "";
                    }
                    if (trackingInfo != null) {
                        ai.a(c.this.d.n(), trackingInfo);
                        com.anythink.core.common.f fVarA = trackingInfo.a();
                        if (fVarA != null) {
                            trackingInfo.z = fVarA.m();
                        }
                        trackingInfo.H = scenarioId;
                        trackingInfo.y(showCustomExt);
                        trackingInfo.n(o.a(trackingInfo.aR(), trackingInfo.N(), jCurrentTimeMillis));
                        ai.a(c.this.b, trackingInfo);
                        ai.a((Map<String, Object>) map, trackingInfo);
                        ai.a(c.this.c, trackingInfo);
                        if (fVarA != null && fVarA.e() != null) {
                            fVarA.e().a(c.this.b, cVarB);
                        }
                    }
                    com.anythink.core.common.t.e.a(c.this.b);
                    com.anythink.core.common.t.e.a(13, trackingInfo, customSplashAdapter.getUnitGroupInfo(), jCurrentTimeMillis);
                    com.anythink.core.common.u.d.a().a(trackingInfo, customSplashAdapter.getUnitGroupInfo(), com.anythink.core.common.u.d.b);
                    s.b();
                    s.b(new Runnable() { // from class: com.anythink.splashad.a.c.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            r rVarC = s.b().c();
                            if (rVarC != null) {
                                CustomSplashAdapter customSplashAdapter2 = customSplashAdapter;
                                customSplashAdapter2.setAdDownloadListener(rVarC.createDataFetchListener(customSplashAdapter2, null, aTEventInterface));
                            }
                            boolean z = aTSplashSkipInfo != null && aTSplashSkipInfo.canUseCustomSkipView();
                            boolean zIsSupportCustomSkipView = customSplashAdapter.isSupportCustomSkipView();
                            if (z && zIsSupportCustomSkipView) {
                                aTSplashSkipInfo.setContainer(viewGroup);
                                customSplashAdapter.setSplashSkipInfo(aTSplashSkipInfo);
                            }
                            final f fVar = new f(customSplashAdapter, aVar, c.this.d);
                            if (customSplashAdapter.isMixNative()) {
                                c.a(c.this, customSplashAdapter, activity, viewGroup, fVar, z, cVarB, trackingInfo, aTNativeAdCustomRender);
                            } else if (customSplashAdapter.isMixBanner()) {
                                c.a(c.this, customSplashAdapter, activity, viewGroup, fVar, z, trackingInfo);
                            } else {
                                customSplashAdapter.internalShow(activity, viewGroup, new e(fVar));
                            }
                            n trackingInfo2 = customSplashAdapter.getTrackingInfo();
                            com.anythink.core.common.t.f.a("4", trackingInfo2, trackingInfo2.aR(), trackingInfo2.aQ(), trackingInfo2.N(), trackingInfo2.Z(), 4, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            if (z) {
                                ATSplashSkipAdListener aTSplashSkipAdListener = aTSplashSkipInfo.getATSplashSkipAdListener();
                                if (aTSplashSkipAdListener != null) {
                                    aTSplashSkipAdListener.isSupportCustomSkipView(zIsSupportCustomSkipView);
                                }
                                if (zIsSupportCustomSkipView) {
                                    aTSplashSkipInfo.getSkipView().setOnClickListener(new View.OnClickListener() { // from class: com.anythink.splashad.a.c.1.1.1
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            f fVar2 = fVar;
                                            if (fVar2 != null) {
                                                fVar2.a(2);
                                                fVar.onSplashAdDismiss();
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
            }));
        }
    }

    private ae a(ATShowConfig aTShowConfig, Map<String, Object> map) {
        ae aeVar = new ae();
        aeVar.a(map);
        if (aTShowConfig != null) {
            aeVar.a(aTShowConfig.getATAdInfo());
        }
        com.anythink.core.common.f fVar = this.d;
        if (fVar != null) {
            aeVar.a(fVar.n());
        }
        return aeVar;
    }

    public final List<ATAdInfo> a(Context context) {
        return this.d.a(context);
    }

    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        return this.d.a(context, map);
    }

    private boolean a(ATAdStatusInfo aTAdStatusInfo, int i) {
        return this.d.a(aTAdStatusInfo, i);
    }

    public final g a(String str) {
        return this.d.b(str);
    }

    public final com.anythink.core.common.h.c a(Context context, ae aeVar) {
        return this.d.b(context, false, false, aeVar);
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
            com.anythink.core.common.k.c.a.a aVarA = com.anythink.core.common.inner.mixad.b.b.a(customSplashAdapter, new com.anythink.core.common.k.d.a.C0028a().a(activity).a(nVar).a(baseAdF).a(z).a(aTNativeAdCustomRender).a(new AnonymousClass2(cVar, fVar, new boolean[]{false})).a());
            if (aVarA instanceof com.anythink.core.common.k.c.a.f) {
                Object objA = ((com.anythink.core.common.k.c.a.f) aVarA).a();
                if (objA instanceof View) {
                    View view = (View) objA;
                    al.a(view);
                    ViewGroup customAdContainer = baseAdF.getCustomAdContainer();
                    if (customAdContainer != null) {
                        viewGroup2 = view;
                        al.a((View) customAdContainer);
                        customAdContainer.addView(view);
                        viewGroup2 = customAdContainer;
                    }
                    viewGroup2 = view;
                    viewGroup.addView(viewGroup2);
                    if (objA instanceof com.anythink.core.common.k.e.a.f) {
                        ((com.anythink.core.common.k.e.a.f) objA).registerNativeAdContainer(viewGroup);
                        ((com.anythink.core.common.k.e.a.f) objA).handleFullScreenClick(customAdContainer);
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
    final class AnonymousClass2 extends com.anythink.core.common.k.e.a {
        final /* synthetic */ f a;
        final /* synthetic */ boolean[] b;

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onAdVideoEnd() {
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onAdVideoStart() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(com.anythink.core.common.h.c cVar, f fVar, boolean[] zArr) {
            super(cVar);
            this.a = fVar;
            this.b = zArr;
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onClose() {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onSplashAdDismiss();
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
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

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onAdClicked(View view) {
            super.onAdClicked(view);
            f fVar = this.a;
            if (fVar != null) {
                fVar.onSplashAdClicked();
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onVideoError(String str, String str2) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.a(99);
                this.a.onSplashAdShowFail(ErrorCode.getErrorCode("", str, str2));
                this.a.onSplashAdDismiss();
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onDeeplinkCallback(boolean z) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
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
            com.anythink.core.common.k.d.a aVarA = new com.anythink.core.common.k.d.a.C0028a().a(activity.getApplicationContext()).a(nVar).a(z).a(new AnonymousClass3(eVar)).a();
            com.anythink.core.common.k.c.a.a aVarA2 = com.anythink.core.common.inner.mixad.b.b.a(customSplashAdapter, aVarA);
            if (aVarA2 instanceof com.anythink.core.common.k.c.a.f) {
                Object objB = ((com.anythink.core.common.k.c.a.f) aVarA2).b();
                if (objB instanceof View) {
                    View view = (View) objB;
                    al.a(view);
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
    final class AnonymousClass3 implements com.anythink.core.common.k.b.a.b {
        final /* synthetic */ e a;

        AnonymousClass3(e eVar) {
            this.a = eVar;
        }

        @Override // com.anythink.core.common.k.b.a.b
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

    public final void a(int i) {
        com.anythink.core.common.f fVar = this.d;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    public final void a(List<ATAdInfo> list) {
        com.anythink.core.common.f fVar = this.d;
        if (fVar != null) {
            fVar.a(list);
        }
    }

    public final void b(Map<String, Object> map) {
        com.anythink.core.common.f fVar = this.d;
        if (fVar != null) {
            fVar.a(map);
        }
    }

    public final void d() {
        com.anythink.core.common.f fVar;
        ATAdCreateConfig aTAdCreateConfig = this.a;
        if (aTAdCreateConfig == null || !aTAdCreateConfig.isMultiton() || (fVar = this.d) == null) {
            return;
        }
        fVar.p();
    }

    public final void c(Map<String, Object> map) {
        com.anythink.core.common.f fVar = this.d;
        if (fVar != null) {
            fVar.b(map);
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
            com.anythink.core.common.k.c.a.a aVarA = com.anythink.core.common.inner.mixad.b.b.a(customSplashAdapter, new com.anythink.core.common.k.d.a.C0028a().a(activity).a(nVar).a(baseAdF).a(z).a(aTNativeAdCustomRender).a(cVar.new AnonymousClass2(cVar2, fVar, new boolean[]{false})).a());
            if (aVarA instanceof com.anythink.core.common.k.c.a.f) {
                Object objA = ((com.anythink.core.common.k.c.a.f) aVarA).a();
                if (objA instanceof View) {
                    View view = (View) objA;
                    al.a(view);
                    ViewGroup customAdContainer = baseAdF.getCustomAdContainer();
                    if (customAdContainer != null) {
                        viewGroup2 = view;
                        al.a((View) customAdContainer);
                        customAdContainer.addView(view);
                        viewGroup2 = customAdContainer;
                    }
                    viewGroup2 = view;
                    viewGroup.addView(viewGroup2);
                    if (objA instanceof com.anythink.core.common.k.e.a.f) {
                        ((com.anythink.core.common.k.e.a.f) objA).registerNativeAdContainer(viewGroup);
                        ((com.anythink.core.common.k.e.a.f) objA).handleFullScreenClick(customAdContainer);
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
            com.anythink.core.common.k.d.a aVarA = new com.anythink.core.common.k.d.a.C0028a().a(activity.getApplicationContext()).a(nVar).a(z).a(cVar.new AnonymousClass3(eVar)).a();
            com.anythink.core.common.k.c.a.a aVarA2 = com.anythink.core.common.inner.mixad.b.b.a(customSplashAdapter, aVarA);
            if (aVarA2 instanceof com.anythink.core.common.k.c.a.f) {
                Object objB = ((com.anythink.core.common.k.c.a.f) aVarA2).b();
                if (objB instanceof View) {
                    View view = (View) objB;
                    al.a(view);
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
