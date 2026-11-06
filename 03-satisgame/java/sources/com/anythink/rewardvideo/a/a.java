package com.anythink.rewardvideo.a;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdCreateConfig;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATCommonImpressionListener;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.d.k;
import com.anythink.core.common.d.r;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.as;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.n;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.l;
import com.anythink.core.common.u.o;
import com.anythink.core.common.u.q;
import com.anythink.rewardvideo.api.ATRewardVideoListener;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "a";
    private static Map<String, a> f = new ConcurrentHashMap(3);
    ATAdCreateConfig b;
    private Context c;
    private String d;
    private final com.anythink.core.common.f e;

    public static a a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = f.get(str);
        if (aVar == null) {
            synchronized (a.class) {
                if (aVar == null) {
                    aVar = new a(context, str);
                    f.put(str, aVar);
                }
            }
        }
        return aVar;
    }

    private a(Context context, String str) {
        this(context, str, null);
    }

    public a(Context context, String str, ATAdCreateConfig aTAdCreateConfig) {
        this.c = context.getApplicationContext();
        this.d = str;
        this.b = aTAdCreateConfig;
        if (aTAdCreateConfig != null) {
            if (aTAdCreateConfig.isMultiton()) {
                com.anythink.core.common.f fVar = new com.anythink.core.common.f(context, str, "1");
                this.e = fVar;
                fVar.u();
                return;
            }
            this.e = com.anythink.core.common.f.a(context, str, "1");
            return;
        }
        this.e = com.anythink.core.common.f.a(context, str, "1");
    }

    public final boolean a() {
        ATAdCreateConfig aTAdCreateConfig = this.b;
        return aTAdCreateConfig != null && aTAdCreateConfig.isMultiton();
    }

    public final com.anythink.core.common.f b() {
        return this.e;
    }

    public final synchronized void a(final Activity activity, final ATShowConfig aTShowConfig, final ATRewardVideoListener aTRewardVideoListener, final ATEventInterface aTEventInterface, final Map<String, Object> map, final ATNativeAdCustomRender aTNativeAdCustomRender) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final com.anythink.core.common.h.c cVarB = this.e.b((Context) activity, false, true, a(aTShowConfig, map));
        if (cVarB != null && (cVarB.e() instanceof CustomRewardVideoAdapter)) {
            this.e.a(cVarB);
            cVarB.a(cVarB.c() + 1);
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.s, new Runnable() { // from class: com.anythink.rewardvideo.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    final String scenarioId;
                    String showCustomExt;
                    n trackingInfo = cVarB.e().getTrackingInfo();
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
                        ai.a(a.this.e.n(), trackingInfo);
                        com.anythink.core.common.f fVarA = trackingInfo.a();
                        if (fVarA != null) {
                            trackingInfo.z = fVarA.m();
                        }
                        trackingInfo.H = scenarioId;
                        trackingInfo.y(showCustomExt);
                        trackingInfo.n(o.a(trackingInfo.aR(), trackingInfo.N(), jCurrentTimeMillis));
                        ai.a(a.this.c, trackingInfo);
                        ai.a((Map<String, Object>) map, trackingInfo);
                        ai.a(a.this.d, trackingInfo);
                        if (fVarA != null) {
                            fVarA.e().a(a.this.c, cVarB);
                        }
                    }
                    com.anythink.core.common.t.e.a(a.this.c);
                    com.anythink.core.common.t.e.a(13, trackingInfo, cVarB.e().getUnitGroupInfo(), jCurrentTimeMillis);
                    com.anythink.core.common.u.d.a().a(trackingInfo, cVarB.e().getUnitGroupInfo(), com.anythink.core.common.u.d.b);
                    final CustomRewardVideoAdapter customRewardVideoAdapter = (CustomRewardVideoAdapter) cVarB.e();
                    Activity activity2 = activity;
                    if (activity2 != null) {
                        customRewardVideoAdapter.refreshActivityContext(activity2);
                    }
                    s.b();
                    s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            customRewardVideoAdapter.setScenario(scenarioId);
                            r rVarC = s.b().c();
                            if (rVarC != null) {
                                CustomRewardVideoAdapter customRewardVideoAdapter2 = customRewardVideoAdapter;
                                customRewardVideoAdapter2.setAdDownloadListener(rVarC.createDataFetchListener(customRewardVideoAdapter2, null, aTEventInterface));
                            }
                            if (customRewardVideoAdapter.isMixSplash()) {
                                a.a(a.this, activity, customRewardVideoAdapter, aTRewardVideoListener);
                            } else if (customRewardVideoAdapter.isMixNative()) {
                                a.a(a.this, activity, cVarB, aTShowConfig, customRewardVideoAdapter, a.a(a.this, customRewardVideoAdapter, aTRewardVideoListener), aTNativeAdCustomRender);
                            } else {
                                customRewardVideoAdapter.internalShow(activity, null, a.a(a.this, customRewardVideoAdapter, aTRewardVideoListener));
                            }
                            n trackingInfo2 = customRewardVideoAdapter.getTrackingInfo();
                            com.anythink.core.common.t.f.a("4", trackingInfo2, trackingInfo2.aR(), trackingInfo2.aQ(), trackingInfo2.N(), trackingInfo2.Z(), 4, SystemClock.elapsedRealtime() - jElapsedRealtime);
                        }
                    });
                }
            }));
        } else {
            if (this.e.a((ATAdStatusInfo) null, 7)) {
                a(s.b().M(), 7, (com.anythink.core.common.d.a) null, (com.anythink.core.common.d.c) null, (ATAdMultipleLoadedListener) null, map, (ATAdRequest) null);
            }
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noADError, "", "No Cache.");
            if (aTRewardVideoListener != null) {
                aTRewardVideoListener.onRewardedVideoAdPlayFailed(errorCode, k.a((ATBaseAdAdapter) null));
            }
        }
    }

    private e a(CustomRewardVideoAdapter customRewardVideoAdapter, ATRewardVideoListener aTRewardVideoListener) {
        s.b();
        e eVar = new e(new f(customRewardVideoAdapter, s.a(this.e), aTRewardVideoListener, this.e), customRewardVideoAdapter.isMixFormatAd(), customRewardVideoAdapter.getAdRewardCallbackType());
        if (customRewardVideoAdapter.isMixInterstitial()) {
            eVar.a(3);
        } else if (customRewardVideoAdapter.isMixNative()) {
            eVar.a(0);
        }
        return eVar;
    }

    private ae a(ATShowConfig aTShowConfig, Map<String, Object> map) {
        ae aeVar = new ae();
        aeVar.a(map);
        if (aTShowConfig != null) {
            aeVar.a(aTShowConfig.getATAdInfo());
        }
        com.anythink.core.common.f fVar = this.e;
        if (fVar != null) {
            aeVar.a(fVar.n());
        }
        return aeVar;
    }

    public final void a(Context context, int i, com.anythink.core.common.d.a aVar, com.anythink.core.common.d.c cVar, ATAdMultipleLoadedListener aTAdMultipleLoadedListener, Map<String, Object> map, ATAdRequest aTAdRequest) {
        as asVar = new as();
        asVar.a(context);
        asVar.a(aTAdRequest);
        asVar.c = i;
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
        this.e.b(this.c, "1", this.d, asVar, aVar);
    }

    public final com.anythink.core.common.h.c a(Map<String, Object> map) {
        ae aeVarA = a((ATShowConfig) null, map);
        aeVarA.f();
        com.anythink.core.common.f fVar = this.e;
        if (fVar != null) {
            return fVar.b(this.c, false, false, aeVarA);
        }
        return null;
    }

    public final List<ATAdInfo> a(Context context) {
        com.anythink.core.common.f fVar = this.e;
        if (fVar != null) {
            return fVar.a(context);
        }
        return null;
    }

    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        com.anythink.core.common.f fVar = this.e;
        if (fVar != null) {
            return fVar.a(context, map);
        }
        return null;
    }

    private void a(Activity activity, CustomRewardVideoAdapter customRewardVideoAdapter, ATRewardVideoListener aTRewardVideoListener) {
        com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
        by unitGroupInfo = customRewardVideoAdapter.getUnitGroupInfo();
        if (unitGroupInfo == null) {
            return;
        }
        com.anythink.core.common.k.c.a.a aVarA = com.anythink.core.common.inner.mixad.b.b.a(customRewardVideoAdapter, null);
        if (!(aVarA instanceof com.anythink.core.common.k.c.a.e)) {
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adShowError, "", "create reward video bridge with unknow error.");
            if (aTRewardVideoListener != null) {
                aTRewardVideoListener.onRewardedVideoAdPlayFailed(errorCode, k.a((ATBaseAdAdapter) null));
                return;
            }
            return;
        }
        cVar.d = com.anythink.core.common.f.a(this.d, unitGroupInfo.G(), String.valueOf(unitGroupInfo.n()));
        ((com.anythink.core.common.k.c.a.e) aVarA).a(activity, cVar, new AnonymousClass2(customRewardVideoAdapter, aTRewardVideoListener, activity));
    }

    /* JADX INFO: renamed from: com.anythink.rewardvideo.a.a$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.core.common.k.f.a.a.InterfaceC0030a {
        final /* synthetic */ CustomRewardVideoAdapter a;
        final /* synthetic */ ATRewardVideoListener b;
        final /* synthetic */ Activity c;

        AnonymousClass2(CustomRewardVideoAdapter customRewardVideoAdapter, ATRewardVideoListener aTRewardVideoListener, Activity activity) {
            this.a = customRewardVideoAdapter;
            this.b = aTRewardVideoListener;
            this.c = activity;
        }

        @Override // com.anythink.core.common.k.f.a.a.InterfaceC0030a
        public final void a(final Activity activity, ViewGroup viewGroup) {
            CustomRewardVideoAdapter customRewardVideoAdapter = this.a;
            s.b();
            e eVar = new e(new f(customRewardVideoAdapter, s.a(a.this.e), this.b, a.this.e), this.a.isMixFormatAd(), this.a.getAdRewardCallbackType()) { // from class: com.anythink.rewardvideo.a.a.2.1
                @Override // com.anythink.rewardvideo.a.d, com.anythink.core.api.ATCommonImpressionListener
                public final void onAdDismiss() {
                    s.b();
                    s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.a.2.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (AnonymousClass2.this.c.isFinishing()) {
                                return;
                            }
                            activity.finish();
                        }
                    });
                    super.onAdDismiss();
                }
            };
            eVar.a(4);
            this.a.internalShow(activity, viewGroup, eVar);
        }
    }

    private void a(Activity activity, com.anythink.core.common.h.c cVar, ATShowConfig aTShowConfig, CustomRewardVideoAdapter customRewardVideoAdapter, ATCommonImpressionListener aTCommonImpressionListener, ATNativeAdCustomRender aTNativeAdCustomRender) {
        BaseAd baseAdF = cVar.f();
        if (baseAdF == null) {
            if (aTCommonImpressionListener != null) {
                aTCommonImpressionListener.onAdShowFail(ErrorCode.adShowError, "showThirdPartyNativeReward fail, no ad cache.");
                return;
            }
            return;
        }
        n nVarI = cVar.i();
        com.anythink.core.common.k.c.a.a aVarA = com.anythink.core.common.inner.mixad.b.b.a(customRewardVideoAdapter, new com.anythink.core.common.k.d.a.C0028a().a(activity).a(baseAdF).a(nVarI).a(aTNativeAdCustomRender).a(new AnonymousClass3(cVar, aTCommonImpressionListener)).a());
        if (!(aVarA instanceof com.anythink.core.common.k.c.a.e)) {
            if (aTCommonImpressionListener != null) {
                aTCommonImpressionListener.onAdShowFail(ErrorCode.adShowError, "create reward video bridge failed. adapterFormatBridge: ".concat(String.valueOf(aVarA)));
                return;
            }
            return;
        }
        com.anythink.core.basead.b.c cVar2 = new com.anythink.core.basead.b.c();
        String strA = (nVarI == null || this.e == null) ? "" : com.anythink.core.common.f.a(nVarI.aQ(), nVarI.N(), String.valueOf(nVarI.Z()));
        if (TextUtils.isEmpty(strA)) {
            if (aTCommonImpressionListener != null) {
                aTCommonImpressionListener.onAdShowFail(ErrorCode.adShowError, "create reward video bridge with error: eventId is empty.");
            }
        } else {
            cVar2.d = strA;
            cVar2.e = l.f(activity);
            cVar2.b = aTShowConfig != null ? aTShowConfig.getScenarioId() : "";
            cVar2.a = Integer.parseInt("1");
            ((com.anythink.core.common.k.c.a.e) aVarA).a(activity, cVar2, new AnonymousClass4());
        }
    }

    /* JADX INFO: renamed from: com.anythink.rewardvideo.a.a$3, reason: invalid class name */
    final class AnonymousClass3 extends com.anythink.core.common.k.e.a {
        final /* synthetic */ ATCommonImpressionListener a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(com.anythink.core.common.h.c cVar, ATCommonImpressionListener aTCommonImpressionListener) {
            super(cVar);
            this.a = aTCommonImpressionListener;
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onAdImpressed() {
            ATCommonImpressionListener aTCommonImpressionListener = this.a;
            if (aTCommonImpressionListener != null) {
                aTCommonImpressionListener.onAdImpression();
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onAdClicked(View view) {
            super.onAdClicked(view);
            ATCommonImpressionListener aTCommonImpressionListener = this.a;
            if (aTCommonImpressionListener != null) {
                aTCommonImpressionListener.onAdClick();
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onAdVideoStart() {
            ATCommonImpressionListener aTCommonImpressionListener = this.a;
            if (aTCommonImpressionListener != null) {
                aTCommonImpressionListener.onAdVideoPlayStart();
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onAdVideoEnd() {
            ATCommonImpressionListener aTCommonImpressionListener = this.a;
            if (aTCommonImpressionListener != null) {
                aTCommonImpressionListener.onAdVideoPlayEnd();
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onVideoError(String str, String str2) {
            ATCommonImpressionListener aTCommonImpressionListener = this.a;
            if (aTCommonImpressionListener != null) {
                aTCommonImpressionListener.onAdShowFail(ErrorCode.adShowError, "onVideoError, errorCode: " + str + ", errorMsg: " + str2);
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onClose() {
            ATCommonImpressionListener aTCommonImpressionListener = this.a;
            if (aTCommonImpressionListener != null) {
                aTCommonImpressionListener.onAdDismiss();
            }
        }

        @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
        public final void onDeeplinkCallback(boolean z) {
            ATCommonImpressionListener aTCommonImpressionListener = this.a;
            if (aTCommonImpressionListener != null) {
                aTCommonImpressionListener.onDeeplinkCallback(z);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.rewardvideo.a.a$4, reason: invalid class name */
    final class AnonymousClass4 implements com.anythink.core.common.k.e.a.a.InterfaceC0029a {
        @Override // com.anythink.core.common.k.e.a.a.InterfaceC0029a
        public final void a(Activity activity) {
        }

        AnonymousClass4() {
        }
    }

    public final void a(int i) {
        com.anythink.core.common.f fVar = this.e;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    public final void a(List<ATAdInfo> list) {
        com.anythink.core.common.f fVar = this.e;
        if (fVar != null) {
            fVar.a(list);
        }
    }

    public final void c() {
        com.anythink.core.common.f fVar;
        ATAdCreateConfig aTAdCreateConfig = this.b;
        if (aTAdCreateConfig == null || !aTAdCreateConfig.isMultiton() || (fVar = this.e) == null) {
            return;
        }
        fVar.p();
    }

    public final void b(Map<String, Object> map) {
        com.anythink.core.common.f fVar = this.e;
        if (fVar != null) {
            fVar.a(map);
        }
    }

    public final void c(Map<String, Object> map) {
        com.anythink.core.common.f fVar = this.e;
        if (fVar != null) {
            fVar.b(map);
        }
    }

    static /* synthetic */ void a(a aVar, Activity activity, CustomRewardVideoAdapter customRewardVideoAdapter, ATRewardVideoListener aTRewardVideoListener) {
        com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
        by unitGroupInfo = customRewardVideoAdapter.getUnitGroupInfo();
        if (unitGroupInfo != null) {
            com.anythink.core.common.k.c.a.a aVarA = com.anythink.core.common.inner.mixad.b.b.a(customRewardVideoAdapter, null);
            if (!(aVarA instanceof com.anythink.core.common.k.c.a.e)) {
                AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adShowError, "", "create reward video bridge with unknow error.");
                if (aTRewardVideoListener != null) {
                    aTRewardVideoListener.onRewardedVideoAdPlayFailed(errorCode, k.a((ATBaseAdAdapter) null));
                    return;
                }
                return;
            }
            cVar.d = com.anythink.core.common.f.a(aVar.d, unitGroupInfo.G(), String.valueOf(unitGroupInfo.n()));
            ((com.anythink.core.common.k.c.a.e) aVarA).a(activity, cVar, aVar.new AnonymousClass2(customRewardVideoAdapter, aTRewardVideoListener, activity));
        }
    }

    static /* synthetic */ e a(a aVar, CustomRewardVideoAdapter customRewardVideoAdapter, ATRewardVideoListener aTRewardVideoListener) {
        s.b();
        e eVar = new e(new f(customRewardVideoAdapter, s.a(aVar.e), aTRewardVideoListener, aVar.e), customRewardVideoAdapter.isMixFormatAd(), customRewardVideoAdapter.getAdRewardCallbackType());
        if (customRewardVideoAdapter.isMixInterstitial()) {
            eVar.a(3);
        } else if (customRewardVideoAdapter.isMixNative()) {
            eVar.a(0);
        }
        return eVar;
    }

    static /* synthetic */ void a(a aVar, Activity activity, com.anythink.core.common.h.c cVar, ATShowConfig aTShowConfig, CustomRewardVideoAdapter customRewardVideoAdapter, ATCommonImpressionListener aTCommonImpressionListener, ATNativeAdCustomRender aTNativeAdCustomRender) {
        BaseAd baseAdF = cVar.f();
        if (baseAdF == null) {
            if (aTCommonImpressionListener != null) {
                aTCommonImpressionListener.onAdShowFail(ErrorCode.adShowError, "showThirdPartyNativeReward fail, no ad cache.");
                return;
            }
            return;
        }
        n nVarI = cVar.i();
        com.anythink.core.common.k.c.a.a aVarA = com.anythink.core.common.inner.mixad.b.b.a(customRewardVideoAdapter, new com.anythink.core.common.k.d.a.C0028a().a(activity).a(baseAdF).a(nVarI).a(aTNativeAdCustomRender).a(aVar.new AnonymousClass3(cVar, aTCommonImpressionListener)).a());
        if (!(aVarA instanceof com.anythink.core.common.k.c.a.e)) {
            if (aTCommonImpressionListener != null) {
                aTCommonImpressionListener.onAdShowFail(ErrorCode.adShowError, "create reward video bridge failed. adapterFormatBridge: ".concat(String.valueOf(aVarA)));
                return;
            }
            return;
        }
        com.anythink.core.basead.b.c cVar2 = new com.anythink.core.basead.b.c();
        String strA = (nVarI == null || aVar.e == null) ? "" : com.anythink.core.common.f.a(nVarI.aQ(), nVarI.N(), String.valueOf(nVarI.Z()));
        if (TextUtils.isEmpty(strA)) {
            if (aTCommonImpressionListener != null) {
                aTCommonImpressionListener.onAdShowFail(ErrorCode.adShowError, "create reward video bridge with error: eventId is empty.");
            }
        } else {
            cVar2.d = strA;
            cVar2.e = l.f(activity);
            cVar2.b = aTShowConfig != null ? aTShowConfig.getScenarioId() : "";
            cVar2.a = Integer.parseInt("1");
            ((com.anythink.core.common.k.c.a.e) aVarA).a(activity, cVar2, aVar.new AnonymousClass4());
        }
    }
}
