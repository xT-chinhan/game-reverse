package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.dlopt.api.CustomAdapterDownloadListener;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TTATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    boolean b;
    private TTRewardVideoAd i;
    private Map<String, Object> j;
    private final String h = getClass().getSimpleName();
    String a = "";
    String c = "";
    boolean d = false;
    TTAdNative.RewardVideoAdListener e = new TTAdNative.RewardVideoAdListener() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.1
        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public final void onRewardVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public final void onError(int i, String str) {
            TTATRewardedVideoAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public final void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
            TTATRewardedVideoAdapter.this.i = tTRewardVideoAd;
            if (TTATRewardedVideoAdapter.this.d) {
                try {
                    TTATInitManager.getInstance().a(TTATRewardedVideoAdapter.this.j, TTATRewardedVideoAdapter.this.i, TTATRewardedVideoAdapter.this.mBiddingListener);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            try {
                if (TTATRewardedVideoAdapter.this.mLoadListener != null) {
                    TTATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public final void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            TTATRewardedVideoAdapter.this.i = tTRewardVideoAd;
            try {
                Map<String, Object> mediaExtraInfo = tTRewardVideoAd.getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    if (TTATRewardedVideoAdapter.this.j == null) {
                        TTATRewardedVideoAdapter.this.j = new HashMap(3);
                    }
                    TTATRewardedVideoAdapter.this.j.putAll(mediaExtraInfo);
                }
            } catch (Throwable th) {
                String unused = TTATRewardedVideoAdapter.this.h;
                th.getMessage();
            }
            TTATInitManager.getInstance().notifyAdDataLoad(TTATRewardedVideoAdapter.this.d, TTATRewardedVideoAdapter.this.j, tTRewardVideoAd, TTATRewardedVideoAdapter.this.mLoadListener, TTATRewardedVideoAdapter.this.mBiddingListener, new BaseAd[0]);
        }
    };
    TTRewardVideoAd.RewardAdInteractionListener f = new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.2
        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdShow() {
            if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdVideoBarClick() {
            if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdClose() {
            if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onVideoComplete() {
            if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onSkippedVideo() {
            TTATRewardedVideoAdapter.o(TTATRewardedVideoAdapter.this);
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onVideoError() {
            if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayFailed("", "Callback VideoError");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onRewardArrived(boolean z, int i, Bundle bundle) {
            Log.i(TTATRewardedVideoAdapter.this.h, "onRewardArrived(), rewardVerify: ".concat(String.valueOf(z)));
            TTATRewardedVideoAdapter.a(TTATRewardedVideoAdapter.this, z, i, bundle, false);
        }
    };
    private boolean k = false;
    TTAppDownloadListener g = new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.6
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j, long j2, String str, String str2) {
            if (TTATRewardedVideoAdapter.this.k) {
                if (TTATRewardedVideoAdapter.this.mDownloadListener == null || !(TTATRewardedVideoAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATRewardedVideoAdapter.this.mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                return;
            }
            TTATRewardedVideoAdapter.H(TTATRewardedVideoAdapter.this);
            if (TTATRewardedVideoAdapter.this.mDownloadListener == null || !(TTATRewardedVideoAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATRewardedVideoAdapter.this.mDownloadListener).onDownloadStart(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j, long j2, String str, String str2) {
            if (TTATRewardedVideoAdapter.this.mDownloadListener == null || !(TTATRewardedVideoAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATRewardedVideoAdapter.this.mDownloadListener).onDownloadPause(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j, long j2, String str, String str2) {
            if (TTATRewardedVideoAdapter.this.mDownloadListener == null || !(TTATRewardedVideoAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATRewardedVideoAdapter.this.mDownloadListener).onDownloadFail(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j, String str, String str2) {
            if (TTATRewardedVideoAdapter.this.mDownloadListener == null || !(TTATRewardedVideoAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATRewardedVideoAdapter.this.mDownloadListener).onDownloadFinish(j, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(String str, String str2) {
            if (TTATRewardedVideoAdapter.this.mDownloadListener == null || !(TTATRewardedVideoAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATRewardedVideoAdapter.this.mDownloadListener).onInstalled(str, str2);
        }
    };

    static /* synthetic */ int F(TTATRewardedVideoAdapter tTATRewardedVideoAdapter) {
        tTATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    static /* synthetic */ boolean H(TTATRewardedVideoAdapter tTATRewardedVideoAdapter) {
        tTATRewardedVideoAdapter.k = true;
        return true;
    }

    static /* synthetic */ int o(TTATRewardedVideoAdapter tTATRewardedVideoAdapter) {
        tTATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        runOnNetworkRequestThread(new AnonymousClass3(context.getApplicationContext(), map, map2));
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATRewardedVideoAdapter$3, reason: invalid class name */
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
            TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new TTATCustomAdSlotBuilder(TTATRewardedVideoAdapter.this.a, this.b, this.c);
            try {
                tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(TTATRewardedVideoAdapter.a(this.a, this.a.getResources().getDisplayMetrics().widthPixels), TTATRewardedVideoAdapter.a(this.a, this.a.getResources().getDisplayMetrics().heightPixels));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            Map map = this.c;
            if (map != null) {
                try {
                    tTATCustomAdSlotBuilder.setSupportDeepLink(((Boolean) map.get(ATAdConst.KEY.AD_IS_SUPPORT_DEEP_LINK)).booleanValue());
                } catch (Exception unused) {
                }
                try {
                    int i = Integer.parseInt(this.c.get(ATAdConst.KEY.AD_ORIENTATION).toString());
                    if (i == 1) {
                        tTATCustomAdSlotBuilder.setOrientation(1);
                    } else if (i == 2) {
                        tTATCustomAdSlotBuilder.setOrientation(2);
                    }
                } catch (Exception unused2) {
                }
            }
            if (!TextUtils.isEmpty(TTATRewardedVideoAdapter.this.mUserId)) {
                tTATCustomAdSlotBuilder.setUserID(TTATRewardedVideoAdapter.this.mUserId);
            }
            if (!TextUtils.isEmpty(TTATRewardedVideoAdapter.this.mUserData)) {
                if (TTATRewardedVideoAdapter.this.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                    TTATRewardedVideoAdapter tTATRewardedVideoAdapter = TTATRewardedVideoAdapter.this;
                    tTATRewardedVideoAdapter.mUserData = tTATRewardedVideoAdapter.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, TTATRewardedVideoAdapter.this.a);
                }
                tTATCustomAdSlotBuilder.setMediaExtra(TTATRewardedVideoAdapter.this.mUserData);
            }
            tTATCustomAdSlotBuilder.setAdCount(1);
            tTAdNativeCreateAdNative.loadRewardVideoAd(tTATCustomAdSlotBuilder.build(), TTATRewardedVideoAdapter.this.e);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        return this.i != null;
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        TTRewardVideoAd tTRewardVideoAd;
        if (activity == null || (tTRewardVideoAd = this.i) == null) {
            return;
        }
        tTRewardVideoAd.setRewardAdInteractionListener(this.f);
        this.i.setDownloadListener(this.g);
        this.i.setRewardPlayAgainInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.4
            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onAdClose() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onAdShow() {
                TTATRewardedVideoAdapter.this.b = false;
                try {
                    Map<String, Object> mediaExtraInfo = TTATRewardedVideoAdapter.this.i.getMediaExtraInfo();
                    if (mediaExtraInfo != null) {
                        if (TTATRewardedVideoAdapter.this.j == null) {
                            TTATRewardedVideoAdapter.this.j = new HashMap(3);
                        }
                        TTATRewardedVideoAdapter.this.j.clear();
                        TTATRewardedVideoAdapter.this.j.putAll(mediaExtraInfo);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                    TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayStart();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onAdVideoBarClick() {
                if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                    TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onVideoComplete() {
                if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                    TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayEnd();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onVideoError() {
                if (TTATRewardedVideoAdapter.this.mImpressionListener != null) {
                    TTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdAgainPlayFailed("", "Again AD, Callback VideoError");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onRewardArrived(boolean z, int i, Bundle bundle) {
                Log.i(TTATRewardedVideoAdapter.this.h, "Again AD, onRewardArrived(), rewardVerify: ".concat(String.valueOf(z)));
                TTATRewardedVideoAdapter.a(TTATRewardedVideoAdapter.this, z, i, bundle, true);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onSkippedVideo() {
                TTATRewardedVideoAdapter.F(TTATRewardedVideoAdapter.this);
            }
        });
        this.i.showRewardVideoAd(activity);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return TTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        TTRewardVideoAd tTRewardVideoAd = this.i;
        if (tTRewardVideoAd != null) {
            tTRewardVideoAd.setRewardAdInteractionListener(null);
            this.i.setRewardPlayAgainInteractionListener(null);
            this.i = null;
        }
        this.e = null;
        this.f = null;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.a;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return TTATInitManager.getInstance().getNetworkVersion();
    }

    private static int b(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.j;
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
        map.put(3, TTATInterstitialAdapter.class);
        map.put(4, TTATSplashAdapter.class);
        return map;
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.a)) {
            return false;
        }
        this.c = ATInitMediation.getStringFromMap(map, "payload");
        return true;
    }

    private void a(int i, Bundle bundle) {
        try {
            if (this.j == null) {
                this.j = new HashMap();
            }
            HashMap map = new HashMap(4);
            map.put(TTATConst.REWARD_EXTRA.REWARD_EXTRA_KEY_REWARD_TYPE, Integer.valueOf(i));
            if (bundle != null) {
                Object obj = bundle.get("transId");
                if (obj != null) {
                    this.j.put("transId", obj.toString());
                    this.j.put("third_trans_id", obj.toString());
                }
                map.put(TTATConst.REWARD_EXTRA.REWARD_EXTRA_KEY_BUNDLE, bundle);
            }
            this.j.put(ATAdConst.REWARD_EXTRA.REWARD_INFO, map);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        boolean z;
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.a)) {
            z = false;
        } else {
            this.c = ATInitMediation.getStringFromMap(map, "payload");
            z = true;
        }
        if (!z) {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        } else {
            TTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.5
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        TTATRewardedVideoAdapter.a(TTATRewardedVideoAdapter.this, context, map, map2);
                    } catch (Throwable th) {
                        TTATRewardedVideoAdapter.this.notifyATLoadFail("", th.getMessage());
                    }
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TTATRewardedVideoAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    private void a(boolean z, int i, Bundle bundle, boolean z2) {
        try {
            if (this.j == null) {
                this.j = new HashMap();
            }
            HashMap map = new HashMap(4);
            map.put(TTATConst.REWARD_EXTRA.REWARD_EXTRA_KEY_REWARD_TYPE, Integer.valueOf(i));
            if (bundle != null) {
                Object obj = bundle.get("transId");
                if (obj != null) {
                    this.j.put("transId", obj.toString());
                    this.j.put("third_trans_id", obj.toString());
                }
                map.put(TTATConst.REWARD_EXTRA.REWARD_EXTRA_KEY_BUNDLE, bundle);
            }
            this.j.put(ATAdConst.REWARD_EXTRA.REWARD_INFO, map);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.b) {
            return;
        }
        this.b = true;
        if (this.mImpressionListener != null) {
            if (z) {
                if (z2) {
                    this.mImpressionListener.onAgainReward();
                    return;
                } else {
                    this.mImpressionListener.onReward();
                    return;
                }
            }
            if (z2) {
                this.mImpressionListener.onAgainRewardFailed();
            } else {
                this.mImpressionListener.onRewardFailed();
            }
        }
    }

    static /* synthetic */ void a(TTATRewardedVideoAdapter tTATRewardedVideoAdapter, boolean z, int i, Bundle bundle, boolean z2) {
        try {
            if (tTATRewardedVideoAdapter.j == null) {
                tTATRewardedVideoAdapter.j = new HashMap();
            }
            HashMap map = new HashMap(4);
            map.put(TTATConst.REWARD_EXTRA.REWARD_EXTRA_KEY_REWARD_TYPE, Integer.valueOf(i));
            if (bundle != null) {
                Object obj = bundle.get("transId");
                if (obj != null) {
                    tTATRewardedVideoAdapter.j.put("transId", obj.toString());
                    tTATRewardedVideoAdapter.j.put("third_trans_id", obj.toString());
                }
                map.put(TTATConst.REWARD_EXTRA.REWARD_EXTRA_KEY_BUNDLE, bundle);
            }
            tTATRewardedVideoAdapter.j.put(ATAdConst.REWARD_EXTRA.REWARD_INFO, map);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (tTATRewardedVideoAdapter.b) {
            return;
        }
        tTATRewardedVideoAdapter.b = true;
        if (tTATRewardedVideoAdapter.mImpressionListener != null) {
            if (z) {
                if (z2) {
                    tTATRewardedVideoAdapter.mImpressionListener.onAgainReward();
                    return;
                } else {
                    tTATRewardedVideoAdapter.mImpressionListener.onReward();
                    return;
                }
            }
            if (z2) {
                tTATRewardedVideoAdapter.mImpressionListener.onAgainRewardFailed();
            } else {
                tTATRewardedVideoAdapter.mImpressionListener.onRewardFailed();
            }
        }
    }

    static /* synthetic */ int a(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    static /* synthetic */ void a(TTATRewardedVideoAdapter tTATRewardedVideoAdapter, Context context, Map map, Map map2) {
        tTATRewardedVideoAdapter.runOnNetworkRequestThread(tTATRewardedVideoAdapter.new AnonymousClass3(context.getApplicationContext(), map, map2));
    }
}
