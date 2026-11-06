package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.dlopt.api.CustomAdapterDownloadListener;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TTATSplashAdapter extends CustomSplashAdapter implements CSJSplashAd.SplashAdListener {
    CSJSplashAd d;
    View e;
    private Map<String, Object> j;
    private final String i = getClass().getSimpleName();
    String a = "";
    String b = "";
    String c = "";
    String f = "";
    boolean g = false;
    private boolean k = false;
    TTAppDownloadListener h = new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATSplashAdapter.3
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j, long j2, String str, String str2) {
            if (TTATSplashAdapter.this.k) {
                if (TTATSplashAdapter.this.mDownloadListener == null || !(TTATSplashAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATSplashAdapter.this.mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                return;
            }
            TTATSplashAdapter.h(TTATSplashAdapter.this);
            if (TTATSplashAdapter.this.mDownloadListener == null || !(TTATSplashAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATSplashAdapter.this.mDownloadListener).onDownloadStart(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j, long j2, String str, String str2) {
            if (TTATSplashAdapter.this.mDownloadListener == null || !(TTATSplashAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATSplashAdapter.this.mDownloadListener).onDownloadPause(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j, long j2, String str, String str2) {
            if (TTATSplashAdapter.this.mDownloadListener == null || !(TTATSplashAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATSplashAdapter.this.mDownloadListener).onDownloadFail(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j, String str, String str2) {
            if (TTATSplashAdapter.this.mDownloadListener == null || !(TTATSplashAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATSplashAdapter.this.mDownloadListener).onDownloadFinish(j, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(String str, String str2) {
            if (TTATSplashAdapter.this.mDownloadListener == null || !(TTATSplashAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATSplashAdapter.this.mDownloadListener).onInstalled(str, str2);
        }
    };

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        return true;
    }

    static /* synthetic */ boolean h(TTATSplashAdapter tTATSplashAdapter) {
        tTATSplashAdapter.k = true;
        return true;
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        int i;
        TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(context);
        TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new TTATCustomAdSlotBuilder(this.b, map, map2);
        int i2 = 0;
        try {
            i = map2.containsKey(ATAdConst.KEY.AD_WIDTH) ? Integer.parseInt(map2.get(ATAdConst.KEY.AD_WIDTH).toString()) : 0;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
                i2 = Integer.parseInt(map2.get(ATAdConst.KEY.AD_HEIGHT).toString());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (i <= 0) {
            i = context.getResources().getDisplayMetrics().widthPixels;
        }
        if (i2 <= 0) {
            i2 = context.getResources().getDisplayMetrics().heightPixels;
        }
        tTATCustomAdSlotBuilder.setImageAcceptedSize(i, i2);
        tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(a(context, i), a(context, i2));
        runOnNetworkRequestThread(new AnonymousClass2(tTATCustomAdSlotBuilder, tTAdNativeCreateAdNative));
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATSplashAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ AdSlot.Builder a;
        final /* synthetic */ TTAdNative b;

        AnonymousClass2(AdSlot.Builder builder, TTAdNative tTAdNative) {
            this.a = builder;
            this.b = tTAdNative;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.b.loadSplashAd(this.a.build(), new TTAdNative.CSJSplashAdListener() { // from class: com.anythink.network.toutiao.TTATSplashAdapter.2.1
                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                    public final void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
                        if (TTATSplashAdapter.this.mLoadListener != null) {
                            TTATSplashAdapter.this.mLoadListener.onAdDataLoaded();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                    public final void onSplashLoadFail(CSJAdError cSJAdError) {
                        TTATSplashAdapter.this.notifyATLoadFail(new StringBuilder().append(cSJAdError.getCode()).toString(), cSJAdError.getMsg());
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                    public final void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
                        TTATSplashAdapter.this.d = cSJSplashAd;
                        try {
                            Map<String, Object> mediaExtraInfo = TTATSplashAdapter.this.d.getMediaExtraInfo();
                            if (mediaExtraInfo != null) {
                                if (TTATSplashAdapter.this.j == null) {
                                    TTATSplashAdapter.this.j = new HashMap(3);
                                }
                                TTATSplashAdapter.this.j.putAll(mediaExtraInfo);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (TTATSplashAdapter.this.g) {
                            try {
                                TTATInitManager.getInstance().a(TTATSplashAdapter.this.j, TTATSplashAdapter.this.d, TTATSplashAdapter.this.mBiddingListener);
                            } catch (Throwable unused) {
                            }
                        } else if (TTATSplashAdapter.this.mLoadListener != null) {
                            TTATSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                    public final void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
                        TTATSplashAdapter.this.notifyATLoadFail(new StringBuilder().append(cSJAdError.getCode()).toString(), cSJAdError.getMsg());
                    }
                }, TTATSplashAdapter.this.mFetchAdTimeout);
            } catch (Exception e) {
                TTATSplashAdapter.this.notifyATLoadFail("", e.getMessage());
            }
        }
    }

    private static int a(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        return this.d != null;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (this.d != null) {
            if (isCustomSkipView()) {
                this.d.hideSkipButton();
            }
            this.d.setDownloadListener(this.h);
            this.d.setSplashAdListener(this);
            View splashView = this.d.getSplashView();
            if (splashView != null) {
                try {
                    viewGroup.addView(splashView, new ViewGroup.LayoutParams(-1, -1));
                    return;
                } catch (Throwable th) {
                    a("SplashAd.getSplashView show fail with exception:" + th.getMessage());
                    return;
                }
            }
            a("SplashAd.getSplashView return null");
        }
    }

    private void a(String str) {
        this.mDismissType = 99;
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", str));
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return TTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return TTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.j;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.g = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.b)) {
            return false;
        }
        this.f = ATInitMediation.getStringFromMap(map, "payload");
        this.c = ATInitMediation.getStringFromMap(map, "personalized_template", "0");
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdShow(CSJSplashAd cSJSplashAd) {
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdShow();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdClick(CSJSplashAd cSJSplashAd) {
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdClose(CSJSplashAd cSJSplashAd, int i) {
        if (i == 1) {
            this.mDismissType = 2;
        } else if (i == 2) {
            this.mDismissType = 3;
        } else if (i == 3) {
            this.mDismissType = 4;
        }
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdInternalAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, TTATAdapter.class);
        map.put(3, TTATInterstitialAdapter.class);
        return map;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        boolean z;
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.b)) {
            z = false;
        } else {
            this.f = ATInitMediation.getStringFromMap(map, "payload");
            this.c = ATInitMediation.getStringFromMap(map, "personalized_template", "0");
            z = true;
        }
        if (!z) {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        } else {
            final Context applicationContext = context.getApplicationContext();
            TTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATSplashAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        TTATSplashAdapter.a(TTATSplashAdapter.this, applicationContext, map, map2);
                    } catch (Throwable th) {
                        TTATSplashAdapter.this.notifyATLoadFail("", th.getMessage());
                    }
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TTATSplashAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    static /* synthetic */ void a(TTATSplashAdapter tTATSplashAdapter, Context context, Map map, Map map2) {
        int i;
        TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(context);
        TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new TTATCustomAdSlotBuilder(tTATSplashAdapter.b, map, map2);
        int i2 = 0;
        try {
            i = map2.containsKey(ATAdConst.KEY.AD_WIDTH) ? Integer.parseInt(map2.get(ATAdConst.KEY.AD_WIDTH).toString()) : 0;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
                i2 = Integer.parseInt(map2.get(ATAdConst.KEY.AD_HEIGHT).toString());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (i <= 0) {
            i = context.getResources().getDisplayMetrics().widthPixels;
        }
        if (i2 <= 0) {
            i2 = context.getResources().getDisplayMetrics().heightPixels;
        }
        tTATCustomAdSlotBuilder.setImageAcceptedSize(i, i2);
        tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(a(context, i), a(context, i2));
        tTATSplashAdapter.runOnNetworkRequestThread(tTATSplashAdapter.new AnonymousClass2(tTATCustomAdSlotBuilder, tTAdNativeCreateAdNative));
    }
}
