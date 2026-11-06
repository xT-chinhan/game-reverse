package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.d.j;
import com.anythink.dlopt.api.CustomAdapterDownloadListener;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TTATInterstitialAdapter extends CustomInterstitialAdapter {
    private TTFullScreenVideoAd j;
    private Map<String, Object> k;
    private WeakReference<Activity> m;
    private final String i = getClass().getSimpleName();
    String a = "";
    int b = 1;
    String c = "";
    boolean d = false;
    TTAdNative.FullScreenVideoAdListener e = new TTAdNative.FullScreenVideoAdListener() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.1
        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public final void onFullScreenVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public final void onError(int i, String str) {
            TTATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public final void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            TTATInterstitialAdapter.this.j = tTFullScreenVideoAd;
            try {
                Map<String, Object> mediaExtraInfo = tTFullScreenVideoAd.getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    if (TTATInterstitialAdapter.this.k == null) {
                        TTATInterstitialAdapter.this.k = new HashMap(3);
                    }
                    TTATInterstitialAdapter.this.k.putAll(mediaExtraInfo);
                }
            } catch (Throwable unused) {
            }
            TTATInitManager.getInstance().notifyAdDataLoad(TTATInterstitialAdapter.this.d, TTATInterstitialAdapter.this.k, tTFullScreenVideoAd, TTATInterstitialAdapter.this.mLoadListener, TTATInterstitialAdapter.this.mBiddingListener, new BaseAd[0]);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public final void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
            TTATInterstitialAdapter.this.j = tTFullScreenVideoAd;
            if (TTATInterstitialAdapter.this.d) {
                try {
                    TTATInitManager.getInstance().a(TTATInterstitialAdapter.this.k, TTATInterstitialAdapter.this.j, TTATInterstitialAdapter.this.mBiddingListener);
                } catch (Throwable unused) {
                }
            } else {
                try {
                    if (TTATInterstitialAdapter.this.mLoadListener != null) {
                        TTATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    };
    TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f = new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.2
        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onAdShow() {
            String unused = TTATInterstitialAdapter.this.i;
            if (TTATInterstitialAdapter.this.mImpressListener != null) {
                TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onAdVideoBarClick() {
            String unused = TTATInterstitialAdapter.this.i;
            if (TTATInterstitialAdapter.this.mImpressListener != null) {
                TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onAdClose() {
            String unused = TTATInterstitialAdapter.this.i;
            TTATInterstitialAdapter.this.a();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onVideoComplete() {
            if (TTATInterstitialAdapter.this.mImpressListener != null) {
                TTATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onSkippedVideo() {
            TTATInterstitialAdapter.o(TTATInterstitialAdapter.this);
        }
    };
    private boolean l = false;
    TTAppDownloadListener g = new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.5
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j, long j2, String str, String str2) {
            if (TTATInterstitialAdapter.this.l) {
                if (TTATInterstitialAdapter.this.mDownloadListener == null || !(TTATInterstitialAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATInterstitialAdapter.this.mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                return;
            }
            TTATInterstitialAdapter.q(TTATInterstitialAdapter.this);
            if (TTATInterstitialAdapter.this.mDownloadListener == null || !(TTATInterstitialAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATInterstitialAdapter.this.mDownloadListener).onDownloadStart(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j, long j2, String str, String str2) {
            if (TTATInterstitialAdapter.this.mDownloadListener == null || !(TTATInterstitialAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATInterstitialAdapter.this.mDownloadListener).onDownloadPause(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j, long j2, String str, String str2) {
            if (TTATInterstitialAdapter.this.mDownloadListener == null || !(TTATInterstitialAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATInterstitialAdapter.this.mDownloadListener).onDownloadFail(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j, String str, String str2) {
            if (TTATInterstitialAdapter.this.mDownloadListener == null || !(TTATInterstitialAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATInterstitialAdapter.this.mDownloadListener).onDownloadFinish(j, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(String str, String str2) {
            if (TTATInterstitialAdapter.this.mDownloadListener == null || !(TTATInterstitialAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATInterstitialAdapter.this.mDownloadListener).onInstalled(str, str2);
        }
    };
    boolean h = false;

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

    static /* synthetic */ int o(TTATInterstitialAdapter tTATInterstitialAdapter) {
        tTATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    static /* synthetic */ boolean q(TTATInterstitialAdapter tTATInterstitialAdapter) {
        tTATInterstitialAdapter.l = true;
        return true;
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.h = false;
        runOnNetworkRequestThread(new AnonymousClass3(context.getApplicationContext(), map, map2));
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATInterstitialAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;
        final /* synthetic */ Map c;

        AnonymousClass3(Context context, Map map, Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(this.a);
            TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new TTATCustomAdSlotBuilder(TTATInterstitialAdapter.this.a, this.b, this.c);
            tTATCustomAdSlotBuilder.setAdCount(1);
            tTATCustomAdSlotBuilder.setOrientation(TTATInterstitialAdapter.this.b);
            tTAdNativeCreateAdNative.loadFullScreenVideoAd(tTATCustomAdSlotBuilder.build(), TTATInterstitialAdapter.this.e);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        return this.j != null;
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        try {
            this.h = false;
            this.m = null;
            TTFullScreenVideoAd tTFullScreenVideoAd = this.j;
            if (tTFullScreenVideoAd == null || activity == null) {
                return;
            }
            tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(this.f);
            this.j.setDownloadListener(this.g);
            this.j.showFullScreenVideoAd(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return TTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        if (!a(map, map2)) {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        } else {
            TTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.4
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        TTATInterstitialAdapter.a(TTATInterstitialAdapter.this, context, map, map2);
                    } catch (Throwable th) {
                        TTATInterstitialAdapter.this.notifyATLoadFail("", th.getMessage());
                    }
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TTATInterstitialAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        try {
            super.destory();
            TTFullScreenVideoAd tTFullScreenVideoAd = this.j;
            if (tTFullScreenVideoAd != null) {
                tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
                this.j = null;
            }
            this.f = null;
            this.e = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.a;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return TTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.k;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.d = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdInternalAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, TTATAdapter.class);
        map.put(4, TTATSplashAdapter.class);
        return map;
    }

    private boolean a(Map<String, Object> map, Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.a)) {
            return false;
        }
        try {
            int intFromMap = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_ORIENTATION, 1);
            if (intFromMap == 1) {
                this.b = 1;
            } else if (intFromMap == 2) {
                this.b = 2;
            }
        } catch (Exception unused) {
        }
        this.c = ATInitMediation.getStringFromMap(map, "payload");
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onCreate(Activity activity) {
        try {
            activity.getClass().getName();
            TTFullScreenVideoAd tTFullScreenVideoAd = this.j;
            if (tTFullScreenVideoAd != null) {
                String[] strArrSplit = tTFullScreenVideoAd.getClass().getName().split("\\.");
                if (strArrSplit.length >= 3) {
                    if (activity.getClass().getName().startsWith(strArrSplit[0] + j.z + strArrSplit[1] + j.z + strArrSplit[2]) && this.m == null) {
                        this.m = new WeakReference<>(activity);
                    }
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
            WeakReference<Activity> weakReference = this.m;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.m.clear();
            this.m = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.h) {
            return;
        }
        this.h = true;
        if (this.mImpressListener != null) {
            this.mImpressListener.onInterstitialAdClose();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String closeAd() {
        try {
            WeakReference<Activity> weakReference = this.m;
            if (weakReference == null || weakReference.get() == null) {
                return "showingActivity is null";
            }
            this.m.get().getClass().getName();
            this.m.get().finish();
            a();
            return "";
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    static /* synthetic */ void a(TTATInterstitialAdapter tTATInterstitialAdapter, Context context, Map map, Map map2) {
        tTATInterstitialAdapter.h = false;
        tTATInterstitialAdapter.runOnNetworkRequestThread(tTATInterstitialAdapter.new AnonymousClass3(context.getApplicationContext(), map, map2));
    }
}
