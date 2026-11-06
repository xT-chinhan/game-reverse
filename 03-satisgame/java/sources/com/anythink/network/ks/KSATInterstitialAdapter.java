package com.anythink.network.ks;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Window;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.d.i;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener;
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
    private Map<String, Object> j;
    private WeakReference<Activity> k;
    int d = 1;
    boolean h = false;
    boolean l = false;

    class a implements MediationInitCallback {
        a() {
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            KSATInterstitialAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            KSATInterstitialAdapter.this.b();
        }
    }

    class b implements KsLoadManager.InterstitialAdListener {
        b() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onError(int i, String str) {
            KSATInterstitialAdapter.this.notifyATLoadFail(i + "", str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onInterstitialAdLoad(List<KsInterstitialAd> list) {
            double ecpm;
            KSATInterstitialAdapter.this.g = (list == null || list.size() <= 0) ? null : list.get(0);
            KSATInterstitialAdapter kSATInterstitialAdapter = KSATInterstitialAdapter.this;
            KsInterstitialAd ksInterstitialAd = kSATInterstitialAdapter.g;
            if (ksInterstitialAd == null) {
                kSATInterstitialAdapter.notifyATLoadFail("", "KuaiShou: List<KsInterstitialAd> is empty.");
                return;
            }
            kSATInterstitialAdapter.a(ksInterstitialAd.getMediaExtraInfo());
            KSATInterstitialAdapter kSATInterstitialAdapter2 = KSATInterstitialAdapter.this;
            if (!kSATInterstitialAdapter2.h) {
                if (((CustomInterstitialAdapter) kSATInterstitialAdapter2).mLoadListener != null) {
                    ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else {
                if (kSATInterstitialAdapter2.mBiddingListener == null) {
                    kSATInterstitialAdapter2.notifyATLoadFail("", "KuaiShou: KsInterstitialAd had been destroyed.");
                    return;
                }
                try {
                    ecpm = kSATInterstitialAdapter2.g.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                    ecpm = 0.0d;
                }
                if (ecpm <= 0.0d) {
                    KSATInterstitialAdapter.this.mBiddingListener.onC2SBidResult(ATBiddingResult.fail("error price: " + ecpm));
                } else {
                    KSATInterstitialAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, System.currentTimeMillis() + "", new KSATBiddingNotice(KSATInterstitialAdapter.this.g), ATAdConst.CURRENCY.RMB_CENT), null);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onRequestResult(int i) {
            if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mLoadListener != null) {
                ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }
    }

    class c implements KsLoadManager.FullScreenVideoAdListener {
        c() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onError(int i, String str) {
            KSATInterstitialAdapter.this.notifyATLoadFail(i + "", str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list) {
            double ecpm;
            KSATInterstitialAdapter.this.f = (list == null || list.size() <= 0) ? null : list.get(0);
            KSATInterstitialAdapter kSATInterstitialAdapter = KSATInterstitialAdapter.this;
            KsFullScreenVideoAd ksFullScreenVideoAd = kSATInterstitialAdapter.f;
            if (ksFullScreenVideoAd == null) {
                kSATInterstitialAdapter.notifyATLoadFail("", "KuaiShou: List<KsFullScreenVideoAd> is empty.");
                return;
            }
            kSATInterstitialAdapter.a(ksFullScreenVideoAd.getMediaExtraInfo());
            KSATInterstitialAdapter kSATInterstitialAdapter2 = KSATInterstitialAdapter.this;
            if (!kSATInterstitialAdapter2.h) {
                if (((CustomInterstitialAdapter) kSATInterstitialAdapter2).mLoadListener != null) {
                    ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else {
                if (kSATInterstitialAdapter2.mBiddingListener == null) {
                    kSATInterstitialAdapter2.notifyATLoadFail("", "KuaiShou: KsFullScreenVideoAd had been destroyed.");
                    return;
                }
                try {
                    ecpm = kSATInterstitialAdapter2.f.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                    ecpm = 0.0d;
                }
                if (ecpm <= 0.0d) {
                    KSATInterstitialAdapter.this.mBiddingListener.onC2SBidResult(ATBiddingResult.fail("error price: " + ecpm));
                } else {
                    KSATInterstitialAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, System.currentTimeMillis() + "", new KSATBiddingNotice(KSATInterstitialAdapter.this.f), ATAdConst.CURRENCY.RMB_CENT), null);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onFullScreenVideoResult(List<KsFullScreenVideoAd> list) {
            if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mLoadListener != null) {
                ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }
    }

    class d implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        d() {
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClicked() {
            String str = KSATInterstitialAdapter.TAG;
            if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onPageDismiss() {
            String str = KSATInterstitialAdapter.TAG;
            KSATInterstitialAdapter.this.a();
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
            ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mDismissType = 2;
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayEnd() {
            if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoEnd();
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayError(int i, int i2) {
            if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoError(i + "", i2 + "");
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayStart() {
            String str = KSATInterstitialAdapter.TAG;
            try {
                KSATInitManager.getInstance().a(KSATInterstitialAdapter.this.getShowId(), new WeakReference(KSATInterstitialAdapter.this.f));
            } catch (Throwable unused) {
            }
            if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
                ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoStart();
            }
        }
    }

    class e implements KsInterstitialAd.AdInteractionListener {
        e() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdClicked() {
            String str = KSATInterstitialAdapter.TAG;
            if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdClosed() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdShow() {
            String str = KSATInterstitialAdapter.TAG;
            try {
                KSATInitManager.getInstance().a(KSATInterstitialAdapter.this.getShowId(), new WeakReference(KSATInterstitialAdapter.this.g));
            } catch (Throwable unused) {
            }
            if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onPageDismiss() {
            String str = KSATInterstitialAdapter.TAG;
            KSATInterstitialAdapter.this.a();
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onSkippedAd() {
            ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mDismissType = 2;
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayEnd() {
            if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoEnd();
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayError(int i, int i2) {
            if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoError(i + "", i2 + "");
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayStart() {
            if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoStart();
            }
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return KSATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public String closeAd() {
        try {
            if (this.d == 1) {
                WeakReference<Activity> weakReference = this.k;
                if (weakReference == null || weakReference.get() == null) {
                    return "showingActivity is null";
                }
                this.k.get().getClass().getName();
                this.k.get().finish();
                a();
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
            a();
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return th.getMessage() != null ? th.getMessage() : th.getClass().getName();
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        try {
            super.destory();
            KsFullScreenVideoAd ksFullScreenVideoAd = this.f;
            if (ksFullScreenVideoAd != null) {
                ksFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
                this.f = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.a = ATInitMediation.getLongFromMap(map, "position_id");
        KSATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, 3);
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdInternalAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, KSATAdapter.class);
        map.put(4, KSATSplashAdapter.class);
        return map;
    }

    public Window getMixInterstitialShowingWindow() {
        WeakReference<Activity> weakReference = this.k;
        Activity activity = weakReference != null ? weakReference.get() : null;
        if (activity != null && !activity.isFinishing()) {
            return activity.getWindow();
        }
        KsInterstitialAd ksInterstitialAd = this.g;
        if (ksInterstitialAd == null) {
            return null;
        }
        Object objA = a(ksInterstitialAd);
        if (!(objA instanceof AlertDialog)) {
            return null;
        }
        AlertDialog alertDialog = (AlertDialog) objA;
        if (alertDialog.isShowing()) {
            return alertDialog.getWindow();
        }
        return null;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.j;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkName() {
        return KSATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        try {
            return String.valueOf(this.a);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return KSATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean isAdReady() {
        if (this.d == 0) {
            return this.g != null;
        }
        KsFullScreenVideoAd ksFullScreenVideoAd = this.f;
        return ksFullScreenVideoAd != null && ksFullScreenVideoAd.isAdEnable();
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    protected boolean isSupportAdCarousel() {
        return true;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (a(map, map2)) {
            KSATInitManager.getInstance().initSDK(context, map, new a());
        } else {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onCreate(Activity activity) {
        KsFullScreenVideoAd ksFullScreenVideoAd;
        try {
            activity.getClass().getName();
            if (this.d != 1 || (ksFullScreenVideoAd = this.f) == null) {
                return;
            }
            String[] strArrSplit = ksFullScreenVideoAd.getClass().getName().split("\\.");
            if (strArrSplit.length >= 2) {
                if (activity.getClass().getName().startsWith(strArrSplit[0] + i.E + strArrSplit[1]) && this.k == null) {
                    this.k = new WeakReference<>(activity);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onDestroy(Activity activity) {
        try {
            activity.getClass().getName();
            WeakReference<Activity> weakReference = this.k;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.k.clear();
            this.k = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onPause(Activity activity) {
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onResume(Activity activity) {
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        this.l = false;
        KsVideoPlayConfig ksVideoPlayConfigBuild = new KsVideoPlayConfig.Builder().showLandscape(this.b == 2).skipThirtySecond(false).videoSoundEnable(this.c).build();
        this.k = null;
        KsFullScreenVideoAd ksFullScreenVideoAd = this.f;
        if (ksFullScreenVideoAd != null && activity != null) {
            ksFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new d());
            this.f.showFullScreenVideoAd(activity, ksVideoPlayConfigBuild);
        }
        KsInterstitialAd ksInterstitialAd = this.g;
        if (ksInterstitialAd == null || activity == null) {
            return;
        }
        ksInterstitialAd.setAdInteractionListener(new e());
        this.g.showInterstitialAd(activity, ksVideoPlayConfigBuild);
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.l = false;
        KsScene.Builder builderScreenOrientation = new KsScene.Builder(this.a).adNum(1).screenOrientation(this.b == 2 ? 2 : 1);
        if (!TextUtils.isEmpty(this.e)) {
            builderScreenOrientation.setBidResponseV2(this.e);
        }
        KsScene ksSceneBuild = builderScreenOrientation.build();
        if (this.d == 0) {
            KsAdSDK.getLoadManager().loadInterstitialAd(ksSceneBuild, new b());
        } else {
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(ksSceneBuild, new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map) {
        if (map != null) {
            this.j = KSATInitManager.getInstance().a(map, this.j);
        }
    }

    private boolean a(Map<String, Object> map, Map<String, Object> map2) {
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
        Boolean bool = ATSDKGlobalSetting.isGlobalMute;
        if (bool != null) {
            this.c = !bool.booleanValue();
        }
        if (map.containsKey("orientation")) {
            this.b = ATInitMediation.getIntFromMap(map, "orientation");
        }
        if (map.containsKey("is_video")) {
            this.d = ATInitMediation.getIntFromMap(map, "is_video", 1);
        }
        if (map.containsKey("anythink_gsp")) {
            this.i = ATInitMediation.getDoubleFromMap(map, "anythink_gsp");
        }
        if (map.containsKey("payload")) {
            this.e = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.i);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.l) {
            return;
        }
        this.l = true;
        CustomInterstitialEventListener customInterstitialEventListener = this.mImpressListener;
        if (customInterstitialEventListener != null) {
            customInterstitialEventListener.onInterstitialAdClose();
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
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
