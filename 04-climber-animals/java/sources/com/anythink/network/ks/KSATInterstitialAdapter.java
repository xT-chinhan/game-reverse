package com.anythink.network.ks;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.d.j;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.anythink.network.tap.TapATInitManager;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class KSATInterstitialAdapter extends CustomInterstitialAdapter {
    public static String TAG = "KSATInterstitialAdapter";
    long a;
    int b;
    boolean c;
    String e;
    KsFullScreenVideoAd f;
    KsInterstitialAd g;
    double i;
    private WeakReference<Activity> k;
    int d = 1;
    boolean h = false;
    boolean j = false;

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    protected boolean isSupportAdCarousel() {
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onPause(Activity activity) {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onResume(Activity activity) {
    }

    static /* synthetic */ int E(KSATInterstitialAdapter kSATInterstitialAdapter) {
        kSATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    static /* synthetic */ int t(KSATInterstitialAdapter kSATInterstitialAdapter) {
        kSATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (!a(map)) {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        } else {
            KSATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATInterstitialAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    KSATInterstitialAdapter.a(KSATInterstitialAdapter.this);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    KSATInterstitialAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    private void a() {
        this.j = false;
        KsScene.Builder builderScreenOrientation = new KsScene.Builder(this.a).adNum(1).screenOrientation(this.b == 2 ? 2 : 1);
        if (!TextUtils.isEmpty(this.e)) {
            builderScreenOrientation.setBidResponseV2(this.e);
        }
        KsScene ksSceneBuild = builderScreenOrientation.build();
        if (this.d == 0) {
            KsAdSDK.getLoadManager().loadInterstitialAd(ksSceneBuild, new AnonymousClass2());
        } else {
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(ksSceneBuild, new AnonymousClass3());
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATInterstitialAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements KsLoadManager.InterstitialAdListener {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onError(int i, String str) {
            KSATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onRequestResult(int i) {
            if (KSATInterstitialAdapter.this.mLoadListener != null) {
                KSATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onInterstitialAdLoad(List<KsInterstitialAd> list) {
            double ecpm;
            KSATInterstitialAdapter.this.g = (list == null || list.size() <= 0) ? null : list.get(0);
            if (KSATInterstitialAdapter.this.g == null) {
                KSATInterstitialAdapter.this.notifyATLoadFail("", "KuaiShou: List<KsInterstitialAd> is empty.");
                return;
            }
            if (!KSATInterstitialAdapter.this.h) {
                if (KSATInterstitialAdapter.this.mLoadListener != null) {
                    KSATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else {
                if (KSATInterstitialAdapter.this.mBiddingListener != null) {
                    try {
                        ecpm = KSATInterstitialAdapter.this.g.getECPM();
                    } catch (Throwable th) {
                        th.printStackTrace();
                        ecpm = 0.0d;
                    }
                    if (ecpm <= 0.0d) {
                        KSATInterstitialAdapter.this.mBiddingListener.onC2SBidResult(ATBiddingResult.fail("error price: ".concat(String.valueOf(ecpm))));
                        return;
                    } else {
                        KSATInterstitialAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, new StringBuilder().append(System.currentTimeMillis()).toString(), new KSATBiddingNotice(KSATInterstitialAdapter.this.g), ATAdConst.CURRENCY.RMB_CENT), null);
                        return;
                    }
                }
                KSATInterstitialAdapter.this.notifyATLoadFail("", "KuaiShou: KsInterstitialAd had been destroyed.");
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATInterstitialAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements KsLoadManager.FullScreenVideoAdListener {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public final void onError(int i, String str) {
            KSATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public final void onFullScreenVideoResult(List<KsFullScreenVideoAd> list) {
            if (KSATInterstitialAdapter.this.mLoadListener != null) {
                KSATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public final void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list) {
            double ecpm;
            KSATInterstitialAdapter.this.f = (list == null || list.size() <= 0) ? null : list.get(0);
            if (KSATInterstitialAdapter.this.f == null) {
                KSATInterstitialAdapter.this.notifyATLoadFail("", "KuaiShou: List<KsFullScreenVideoAd> is empty.");
                return;
            }
            if (!KSATInterstitialAdapter.this.h) {
                if (KSATInterstitialAdapter.this.mLoadListener != null) {
                    KSATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else {
                if (KSATInterstitialAdapter.this.mBiddingListener != null) {
                    try {
                        ecpm = KSATInterstitialAdapter.this.f.getECPM();
                    } catch (Throwable th) {
                        th.printStackTrace();
                        ecpm = 0.0d;
                    }
                    if (ecpm <= 0.0d) {
                        KSATInterstitialAdapter.this.mBiddingListener.onC2SBidResult(ATBiddingResult.fail("error price: ".concat(String.valueOf(ecpm))));
                        return;
                    } else {
                        KSATInterstitialAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, new StringBuilder().append(System.currentTimeMillis()).toString(), new KSATBiddingNotice(KSATInterstitialAdapter.this.f), ATAdConst.CURRENCY.RMB_CENT), null);
                        return;
                    }
                }
                KSATInterstitialAdapter.this.notifyATLoadFail("", "KuaiShou: KsFullScreenVideoAd had been destroyed.");
            }
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        this.j = false;
        KsVideoPlayConfig ksVideoPlayConfigBuild = new KsVideoPlayConfig.Builder().showLandscape(this.b == 2).skipThirtySecond(false).videoSoundEnable(this.c).build();
        this.k = null;
        KsFullScreenVideoAd ksFullScreenVideoAd = this.f;
        if (ksFullScreenVideoAd != null && activity != null) {
            ksFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new KsFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.anythink.network.ks.KSATInterstitialAdapter.4
                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onAdClicked() {
                    String str = KSATInterstitialAdapter.TAG;
                    if (KSATInterstitialAdapter.this.mImpressListener != null) {
                        KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onPageDismiss() {
                    String str = KSATInterstitialAdapter.TAG;
                    KSATInterstitialAdapter.this.b();
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayError(int i, int i2) {
                    if (KSATInterstitialAdapter.this.mImpressListener != null) {
                        KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError(String.valueOf(i), String.valueOf(i2));
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayEnd() {
                    if (KSATInterstitialAdapter.this.mImpressListener != null) {
                        KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayStart() {
                    String str = KSATInterstitialAdapter.TAG;
                    try {
                        KSATInitManager.getInstance().a(KSATInterstitialAdapter.this.getTrackingInfo().z(), new WeakReference(KSATInterstitialAdapter.this.f));
                    } catch (Throwable unused) {
                    }
                    if (KSATInterstitialAdapter.this.mImpressListener != null) {
                        KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                        KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onSkippedVideo() {
                    KSATInterstitialAdapter.t(KSATInterstitialAdapter.this);
                }
            });
            this.f.showFullScreenVideoAd(activity, ksVideoPlayConfigBuild);
        }
        KsInterstitialAd ksInterstitialAd = this.g;
        if (ksInterstitialAd == null || activity == null) {
            return;
        }
        ksInterstitialAd.setAdInteractionListener(new KsInterstitialAd.AdInteractionListener() { // from class: com.anythink.network.ks.KSATInterstitialAdapter.5
            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onAdClosed() {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onAdClicked() {
                String str = KSATInterstitialAdapter.TAG;
                if (KSATInterstitialAdapter.this.mImpressListener != null) {
                    KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onAdShow() {
                String str = KSATInterstitialAdapter.TAG;
                try {
                    KSATInitManager.getInstance().a(KSATInterstitialAdapter.this.getTrackingInfo().z(), new WeakReference(KSATInterstitialAdapter.this.g));
                } catch (Throwable unused) {
                }
                if (KSATInterstitialAdapter.this.mImpressListener != null) {
                    KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onPageDismiss() {
                String str = KSATInterstitialAdapter.TAG;
                KSATInterstitialAdapter.this.b();
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onVideoPlayError(int i, int i2) {
                if (KSATInterstitialAdapter.this.mImpressListener != null) {
                    KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError(String.valueOf(i), String.valueOf(i2));
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onVideoPlayEnd() {
                if (KSATInterstitialAdapter.this.mImpressListener != null) {
                    KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onVideoPlayStart() {
                if (KSATInterstitialAdapter.this.mImpressListener != null) {
                    KSATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onSkippedAd() {
                KSATInterstitialAdapter.E(KSATInterstitialAdapter.this);
            }
        });
        this.g.showInterstitialAd(activity, ksVideoPlayConfigBuild);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        if (this.d == 0) {
            return this.g != null;
        }
        KsFullScreenVideoAd ksFullScreenVideoAd = this.f;
        return ksFullScreenVideoAd != null && ksFullScreenVideoAd.isAdEnable();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return KSATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        try {
            super.destory();
            KsFullScreenVideoAd ksFullScreenVideoAd = this.f;
            if (ksFullScreenVideoAd != null) {
                ksFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
                this.f = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        try {
            return String.valueOf(this.a);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return KSATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdInternalAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, KSATAdapter.class);
        map.put(4, KSATSplashAdapter.class);
        return map;
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        String stringFromMap2 = ATInitMediation.getStringFromMap(map, "position_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(stringFromMap2)) {
            return false;
        }
        try {
            this.a = Long.parseLong(stringFromMap2);
        } catch (NumberFormatException unused) {
        }
        this.c = true;
        if (map.containsKey("video_muted")) {
            this.c = TextUtils.equals("0", ATInitMediation.getStringFromMap(map, "video_muted"));
        }
        if (map.containsKey(TapATInitManager.ORIENTATION_KEY)) {
            this.b = ATInitMediation.getIntFromMap(map, TapATInitManager.ORIENTATION_KEY);
        }
        if (map.containsKey("is_video")) {
            this.d = ATInitMediation.getIntFromMap(map, "is_video", 1);
        }
        if (map.containsKey(j.w.m)) {
            this.i = ATInitMediation.getDoubleFromMap(map, j.w.m);
        }
        if (map.containsKey("payload")) {
            this.e = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.i);
        }
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.a = ATInitMediation.getLongFromMap(map, "position_id");
        KSATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, 3);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onCreate(Activity activity) {
        KsFullScreenVideoAd ksFullScreenVideoAd;
        try {
            activity.getClass().getName();
            if (this.d != 1 || (ksFullScreenVideoAd = this.f) == null) {
                return;
            }
            String[] strArrSplit = ksFullScreenVideoAd.getClass().getName().split("\\.");
            if (strArrSplit.length >= 2) {
                if (activity.getClass().getName().startsWith(strArrSplit[0] + j.z + strArrSplit[1]) && this.k == null) {
                    this.k = new WeakReference<>(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onDestroy(Activity activity) {
        try {
            activity.getClass().getName();
            WeakReference<Activity> weakReference = this.k;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.k.clear();
            this.k = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.j) {
            return;
        }
        this.j = true;
        if (this.mImpressListener != null) {
            this.mImpressListener.onInterstitialAdClose();
        }
    }

    private Object a(KsInterstitialAd ksInterstitialAd) {
        try {
            ksInterstitialAd.getClass().getName();
            Class<?> cls = ksInterstitialAd.getClass();
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Field declaredField = cls.getDeclaredField(field.getName());
                declaredField.setAccessible(true);
                Object obj = declaredField.get(ksInterstitialAd);
                if (obj != null) {
                    if (obj instanceof AlertDialog) {
                        return obj;
                    }
                    if (obj instanceof KsInterstitialAd) {
                        return a((KsInterstitialAd) obj);
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String closeAd() {
        try {
            if (this.d == 1) {
                WeakReference<Activity> weakReference = this.k;
                if (weakReference == null || weakReference.get() == null) {
                    return "showingActivity is null";
                }
                this.k.get().getClass().getName();
                this.k.get().finish();
                b();
                return "";
            }
            KsInterstitialAd ksInterstitialAd = this.g;
            if (ksInterstitialAd == null) {
                return "mKsInterstitialAd is null";
            }
            Object objA = a(ksInterstitialAd);
            if (objA == null) {
                return "dialog object is not find";
            }
            if (!(objA instanceof AlertDialog)) {
                return "find object is not dialog";
            }
            objA.getClass().getName();
            Method method = objA.getClass().getMethod("dismiss", new Class[0]);
            method.setAccessible(true);
            method.invoke(objA, new Object[0]);
            b();
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return th.getMessage();
        }
    }

    static /* synthetic */ void a(KSATInterstitialAdapter kSATInterstitialAdapter) {
        kSATInterstitialAdapter.j = false;
        KsScene.Builder builderScreenOrientation = new KsScene.Builder(kSATInterstitialAdapter.a).adNum(1).screenOrientation(kSATInterstitialAdapter.b == 2 ? 2 : 1);
        if (!TextUtils.isEmpty(kSATInterstitialAdapter.e)) {
            builderScreenOrientation.setBidResponseV2(kSATInterstitialAdapter.e);
        }
        KsScene ksSceneBuild = builderScreenOrientation.build();
        if (kSATInterstitialAdapter.d == 0) {
            KsAdSDK.getLoadManager().loadInterstitialAd(ksSceneBuild, kSATInterstitialAdapter.new AnonymousClass2());
        } else {
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(ksSceneBuild, kSATInterstitialAdapter.new AnonymousClass3());
        }
    }
}
