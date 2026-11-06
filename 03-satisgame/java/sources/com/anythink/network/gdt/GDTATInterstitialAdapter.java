package com.anythink.network.gdt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingListenerExt;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListenerExt;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class GDTATInterstitialAdapter extends CustomInterstitialAdapter implements UnifiedInterstitialMediaListener {
    public static String TAG = "GDTATInterstitialAdapter";
    private static final String m = "com.qq.e.ads.ADActivity";
    private static final String n = "com.qq.e.ads.PortraitADActivity";
    private static final String o = "com.qq.e.ads.LandscapeADActivity";
    private static final int p = 10;
    UnifiedInterstitialAD a;
    String b;
    String c;
    String d;
    String f;
    boolean g;
    boolean h;
    private Map<String, Object> i;
    private WeakReference<Activity> j;
    private WeakReference<Activity> k;
    int e = 0;
    private boolean l = false;

    class a implements UnifiedInterstitialADListener {

        /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATInterstitialAdapter$a$a, reason: collision with other inner class name */
        class C0068a implements DownloadConfirmListener {
            C0068a() {
            }

            @Override // com.qq.e.comm.compliance.DownloadConfirmListener
            public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                if (((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener != null) {
                    GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                    gDTDownloadFirmInfo.appInfoUrl = str;
                    gDTDownloadFirmInfo.scenes = i;
                    gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                    ((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                }
            }
        }

        class b implements ADRewardListener {
            b() {
            }

            @Override // com.qq.e.comm.listeners.ADRewardListener
            public void onReward(Map<String, Object> map) {
                String str = GDTATInterstitialAdapter.TAG;
                new StringBuilder("onReward: ").append(map);
                if (GDTATInterstitialAdapter.this.i == null) {
                    GDTATInterstitialAdapter.this.i = new HashMap();
                }
                GDTATInterstitialAdapter.this.i.put(ATAdConst.REWARD_EXTRA.REWARD_INFO, map);
                try {
                    if (((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener.onInterstitialAdReward();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        a() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            String str = GDTATInterstitialAdapter.TAG;
            if (((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            String str = GDTATInterstitialAdapter.TAG;
            GDTATInterstitialAdapter.this.b();
            GDTATInterstitialAdapter.this.a();
            GDTATInitManager.getInstance().b();
            GDTATInterstitialAdapter.this.d();
            UnifiedInterstitialAD unifiedInterstitialAD = GDTATInterstitialAdapter.this.a;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.destroy();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            String str = GDTATInterstitialAdapter.TAG;
            try {
                GDTATInitManager.getInstance().a(GDTATInterstitialAdapter.this.getShowId(), new WeakReference(GDTATInterstitialAdapter.this.a));
            } catch (Throwable unused) {
            }
            if (((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            UnifiedInterstitialAD unifiedInterstitialAD;
            GDTATInterstitialAdapter gDTATInterstitialAdapter = GDTATInterstitialAdapter.this;
            UnifiedInterstitialAD unifiedInterstitialAD2 = gDTATInterstitialAdapter.a;
            if (unifiedInterstitialAD2 != null && gDTATInterstitialAdapter.g) {
                unifiedInterstitialAD2.setDownloadConfirmListener(new C0068a());
            }
            GDTATInterstitialAdapter gDTATInterstitialAdapter2 = GDTATInterstitialAdapter.this;
            if (gDTATInterstitialAdapter2.a != null) {
                gDTATInterstitialAdapter2.e();
            }
            try {
                UnifiedInterstitialAD unifiedInterstitialAD3 = GDTATInterstitialAdapter.this.a;
                if (unifiedInterstitialAD3 != null) {
                    unifiedInterstitialAD3.setRewardListener(new b());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            GDTATInterstitialAdapter gDTATInterstitialAdapter3 = GDTATInterstitialAdapter.this;
            if (!gDTATInterstitialAdapter3.h) {
                if (((CustomInterstitialAdapter) gDTATInterstitialAdapter3).mLoadListener instanceof ATCustomLoadListenerExt) {
                    ((ATCustomLoadListenerExt) ((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mLoadListener).onAdDataLoadedWithAds(new BaseAd[0]);
                }
            } else {
                if (!(gDTATInterstitialAdapter3.mBiddingListener instanceof ATBiddingListenerExt) || (unifiedInterstitialAD = gDTATInterstitialAdapter3.a) == null) {
                    return;
                }
                ((ATBiddingListenerExt) GDTATInterstitialAdapter.this.mBiddingListener).onC2SBiddingResultWithData(ATBiddingResult.success(unifiedInterstitialAD.getECPM(), System.currentTimeMillis() + "", new GDTATBiddingNotice(GDTATInterstitialAdapter.this.a), ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            GDTATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
            GDTATInterstitialAdapter.this.notifyATLoadFail("", "GDT: onRenderFail()");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
            GDTATInterstitialAdapter gDTATInterstitialAdapter = GDTATInterstitialAdapter.this;
            if (gDTATInterstitialAdapter.a == null) {
                gDTATInterstitialAdapter.notifyATLoadFail("", "onRenderSuccess mUnifiedInterstitialAd is null");
                return;
            }
            gDTATInterstitialAdapter.e();
            GDTATInterstitialAdapter gDTATInterstitialAdapter2 = GDTATInterstitialAdapter.this;
            if (!gDTATInterstitialAdapter2.h) {
                if (((CustomInterstitialAdapter) gDTATInterstitialAdapter2).mLoadListener != null) {
                    ((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (gDTATInterstitialAdapter2.mBiddingListener != null) {
                GDTATInterstitialAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(gDTATInterstitialAdapter2.a.getECPM(), System.currentTimeMillis() + "", new GDTATBiddingNotice(GDTATInterstitialAdapter.this.a), ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
        }
    }

    class b implements MediationInitCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;
        final /* synthetic */ Map c;

        b(Context context, Map map, Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            GDTATInterstitialAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            GDTATInterstitialAdapter.this.a(this.a, this.b, this.c);
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return GDTATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public String closeAd() {
        try {
            UnifiedInterstitialAD unifiedInterstitialAD = this.a;
            if (unifiedInterstitialAD == null) {
                return "mUnifiedInterstitialAd is null";
            }
            unifiedInterstitialAD.close();
            d();
            return "";
        } catch (Throwable th) {
            return th.getMessage() != null ? th.getMessage() : th.getClass().getName();
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        super.destory();
        b();
        a();
        UnifiedInterstitialAD unifiedInterstitialAD = this.a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(null);
            this.a.destroy();
            this.a = null;
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.c = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdInternalAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, GDTATAdapter.class);
        map.put(4, GDTATSplashAdapter.class);
        return map;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter
    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    public Window getMixInterstitialShowingWindow() {
        Dialog dialogC;
        try {
            WeakReference<Activity> weakReference = this.j;
            Activity activity = weakReference != null ? weakReference.get() : null;
            if (activity != null && !activity.isFinishing()) {
                return activity.getWindow();
            }
            if (TextUtils.equals("1", this.f) || (dialogC = c()) == null) {
                return null;
            }
            return dialogC.getWindow();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.i;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.c;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean isAdReady() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.a;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.isValid();
        }
        return false;
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    protected boolean isSupportAdCarousel() {
        return true;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(map, map2);
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) {
            notifyATLoadFail("", "GDT appid or unitId is empty.");
        } else {
            GDTATInitManager.getInstance().initSDK(context, map, new b(context, map, map2));
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onCreate(Activity activity) {
        if (activity == null || !a(activity)) {
            return;
        }
        this.j = new WeakReference<>(activity);
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onDestroy(Activity activity) {
        WeakReference<Activity> weakReference = this.j;
        if (weakReference == null || weakReference.get() != activity) {
            return;
        }
        b();
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoComplete() {
        CustomInterstitialEventListener customInterstitialEventListener = this.mImpressListener;
        if (customInterstitialEventListener != null) {
            customInterstitialEventListener.onInterstitialAdVideoEnd();
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoError(AdError adError) {
        GDTATInitManager.getInstance().b();
        CustomInterstitialEventListener customInterstitialEventListener = this.mImpressListener;
        if (customInterstitialEventListener != null) {
            customInterstitialEventListener.onInterstitialAdVideoError(adError.getErrorCode() + "", adError.getErrorMsg());
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoInit() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoLoading() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageClose() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageOpen() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPause() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoReady(long j) {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoStart() {
        CustomInterstitialEventListener customInterstitialEventListener = this.mImpressListener;
        if (customInterstitialEventListener != null) {
            customInterstitialEventListener.onInterstitialAdVideoStart();
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        if (this.a != null) {
            this.l = false;
            b();
            if (activity != null) {
                b(activity);
            }
            this.a.setMediaListener(this);
            if (TextUtils.equals("1", this.f)) {
                if (activity == null) {
                    Log.e(TAG, "Gdt (Full Screen) show fail: context need be Activity");
                    return;
                } else {
                    GDTATInitManager.getInstance().a(this.c, this.a);
                    this.a.showFullScreenAD(activity);
                    return;
                }
            }
            GDTATInitManager.getInstance().a(this.c, this.a);
            if (activity != null) {
                this.a.show(activity);
            } else {
                this.a.show();
            }
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        WeakReference<Activity> weakReference = this.j;
        if (weakReference != null) {
            weakReference.clear();
            this.j = null;
        }
    }

    private Dialog c() {
        UnifiedInterstitialAD unifiedInterstitialAD;
        Object objA;
        try {
            WeakReference<Activity> weakReference = this.k;
            Activity activity = weakReference != null ? weakReference.get() : null;
            if (activity == null || activity.isFinishing() || (unifiedInterstitialAD = this.a) == null || (objA = a(unifiedInterstitialAD)) == null) {
                return null;
            }
            return a(objA, activity, Collections.newSetFromMap(new IdentityHashMap()), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.l) {
            return;
        }
        this.l = true;
        CustomInterstitialEventListener customInterstitialEventListener = this.mImpressListener;
        if (customInterstitialEventListener != null) {
            customInterstitialEventListener.onInterstitialAdClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.a;
        if (unifiedInterstitialAD != null) {
            this.i = GDTATInitManager.getInstance().a(unifiedInterstitialAD.getExtraInfo(), this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.l = false;
        this.f = ATInitMediation.getStringFromMap(map, "is_fullscreen", "0");
        this.g = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        GDTATInitManager.getInstance().setExtraUserData(map2);
        a(context, map);
    }

    private void b(Activity activity) {
        WeakReference<Activity> weakReference = this.k;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.k = new WeakReference<>(activity);
    }

    private boolean b(Object obj) {
        return obj != null && obj.getClass().getName().startsWith("com.qq.e.comm.plugin.");
    }

    private void b(Context context, Map<String, Object> map) {
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.a != null) {
            boolean zIsPlayMute = GDTATInitManager.getInstance().isPlayMute(intFromMap);
            this.a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(zIsPlayMute).setDetailPageMuted(zIsPlayMute).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.a.setMaxVideoDuration(intFromMap3);
            }
        }
    }

    private void a(Context context, Map<String, Object> map) {
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        Activity activity = (Activity) context;
        b(activity);
        a aVar = new a();
        if (!TextUtils.isEmpty(this.d) && !this.h) {
            this.a = new UnifiedInterstitialAD(activity, this.c, aVar, null, this.d);
        } else {
            this.a = new UnifiedInterstitialAD(activity, this.c, aVar);
            LoadAdParams loadAdParamsA = GDTATInitManager.getInstance().a(map);
            if (loadAdParamsA != null) {
                this.a.setLoadAdParams(loadAdParamsA);
            }
        }
        b(context, map);
        if (TextUtils.equals("1", this.f)) {
            this.a.loadFullScreenAD();
        } else {
            this.a.loadAD();
        }
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.b = ATInitMediation.getStringFromMap(map, "app_id");
        this.c = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.d = ATInitMediation.getStringFromMap(map, "payload");
    }

    private boolean a(Activity activity) {
        String name = activity.getClass().getName();
        return m.equals(name) || n.equals(name) || o.equals(name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        WeakReference<Activity> weakReference = this.k;
        if (weakReference != null) {
            weakReference.clear();
            this.k = null;
        }
    }

    private Object a(Object obj) {
        try {
            for (Class<?> superclass = obj.getClass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                for (Field field : superclass.getDeclaredFields()) {
                    try {
                        if (!Modifier.isStatic(field.getModifiers()) && !field.getType().isPrimitive()) {
                            field.setAccessible(true);
                            Object obj2 = field.get(obj);
                            if (b(obj2)) {
                                return obj2;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private Dialog a(Object obj, Activity activity, Set<Object> set, int i) {
        if (obj != null && i <= 10 && set.add(obj)) {
            if (obj instanceof Dialog) {
                Dialog dialog = (Dialog) obj;
                if (a(dialog, activity)) {
                    return dialog;
                }
                return null;
            }
            if (!b(obj)) {
                return null;
            }
            try {
                for (Class<?> superclass = obj.getClass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                    for (Field field : superclass.getDeclaredFields()) {
                        try {
                            if (!Modifier.isStatic(field.getModifiers()) && !field.getType().isPrimitive()) {
                                field.setAccessible(true);
                                Dialog dialogA = a(field.get(obj), activity, set, 1 + i);
                                if (dialogA != null) {
                                    return dialogA;
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        return null;
    }

    private boolean a(Dialog dialog, Activity activity) {
        if (dialog == null || !dialog.isShowing()) {
            return false;
        }
        Activity ownerActivity = dialog.getOwnerActivity();
        return (ownerActivity == null || ownerActivity == activity) && dialog.getWindow() != null;
    }
}
