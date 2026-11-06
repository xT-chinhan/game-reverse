package com.anythink.network.ks;

import android.app.Activity;
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
import com.anythink.network.tap.TapATInitManager;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class KSATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    long a;
    int b;
    boolean d;
    String e;
    double f;
    KsRewardVideoAd g;
    private Map<String, Object> j;
    boolean c = false;
    boolean h = false;
    boolean i = false;

    static /* synthetic */ int i(KSATRewardedVideoAdapter kSATRewardedVideoAdapter) {
        kSATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        KsRewardVideoAd ksRewardVideoAd = this.g;
        if (ksRewardVideoAd == null || activity == null) {
            return;
        }
        try {
            ksRewardVideoAd.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.anythink.network.ks.KSATRewardedVideoAdapter.1
                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onExtraRewardVerify(int i) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardStepVerify(int i, int i2) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardVerify(Map<String, Object> map) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onAdClicked() {
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                    if (KSATRewardedVideoAdapter.this.i) {
                        return;
                    }
                    KSATRewardedVideoAdapter.this.i = true;
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayError(int i, int i2) {
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayFailed(String.valueOf(i), "");
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayEnd() {
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoSkipToEnd(long j) {
                    KSATRewardedVideoAdapter.i(KSATRewardedVideoAdapter.this);
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                    KSATRewardedVideoAdapter.j(KSATRewardedVideoAdapter.this);
                    try {
                        KSATInitManager.getInstance().a(KSATRewardedVideoAdapter.this.getTrackingInfo().z(), new WeakReference(KSATRewardedVideoAdapter.this.g));
                    } catch (Throwable unused) {
                    }
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardVerify() {
                    KSATRewardedVideoAdapter.j(KSATRewardedVideoAdapter.this);
                    if (KSATRewardedVideoAdapter.this.mImpressionListener != null) {
                        KSATRewardedVideoAdapter.this.mImpressionListener.onReward();
                    }
                }
            });
            KsVideoPlayConfig ksVideoPlayConfigBuild = new KsVideoPlayConfig.Builder().showLandscape(this.b == 2).skipThirtySecond(this.c).videoSoundEnable(this.d).build();
            this.i = false;
            this.g.showRewardVideoAd(activity, ksVideoPlayConfigBuild);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        KsRewardVideoAd ksRewardVideoAd = this.g;
        return ksRewardVideoAd != null && ksRewardVideoAd.isAdEnable();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return KSATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (!a(map, map2)) {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        } else {
            KSATInitManager.getInstance().initSDK(context.getApplicationContext(), map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATRewardedVideoAdapter.2
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    KSATRewardedVideoAdapter.o(KSATRewardedVideoAdapter.this);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    KSATRewardedVideoAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
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
        map.put(3, KSATInterstitialAdapter.class);
        map.put(4, KSATSplashAdapter.class);
        return map;
    }

    private void a() {
        HashMap map = new HashMap();
        map.put("thirdUserId", this.mUserId);
        if (!TextUtils.isEmpty(this.mUserData) && this.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
            this.mUserData = this.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, new StringBuilder().append(this.a).toString());
        }
        map.put("extraData", this.mUserData);
        KsScene.Builder builderRewardCallbackExtraData = new KsScene.Builder(this.a).adNum(1).screenOrientation(this.b == 2 ? 2 : 1).rewardCallbackExtraData(map);
        if (!TextUtils.isEmpty(this.e)) {
            builderRewardCallbackExtraData.setBidResponseV2(this.e);
        }
        KsAdSDK.getLoadManager().loadRewardVideoAd(builderRewardCallbackExtraData.build(), new AnonymousClass3());
    }

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATRewardedVideoAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements KsLoadManager.RewardVideoAdListener {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onError(int i, String str) {
            KSATRewardedVideoAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onRewardVideoResult(List<KsRewardVideoAd> list) {
            if (KSATRewardedVideoAdapter.this.mLoadListener != null) {
                KSATRewardedVideoAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
            double ecpm;
            KSATRewardedVideoAdapter.this.g = (list == null || list.size() <= 0) ? null : list.get(0);
            if (KSATRewardedVideoAdapter.this.g == null) {
                KSATRewardedVideoAdapter.this.notifyATLoadFail("", "KuaiShou: List<KsRewardVideoAd> is empty");
                return;
            }
            if (!KSATRewardedVideoAdapter.this.h) {
                if (KSATRewardedVideoAdapter.this.mLoadListener != null) {
                    KSATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (KSATRewardedVideoAdapter.this.mBiddingListener != null) {
                try {
                    ecpm = KSATRewardedVideoAdapter.this.g.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                    ecpm = 0.0d;
                }
                if (ecpm <= 0.0d) {
                    KSATRewardedVideoAdapter.this.mBiddingListener.onC2SBidResult(ATBiddingResult.fail("error price: ".concat(String.valueOf(ecpm))));
                } else {
                    KSATRewardedVideoAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, new StringBuilder().append(System.currentTimeMillis()).toString(), new KSATBiddingNotice(KSATRewardedVideoAdapter.this.g), ATAdConst.CURRENCY.RMB_CENT), null);
                }
            }
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        KsRewardVideoAd ksRewardVideoAd = this.g;
        if (ksRewardVideoAd != null) {
            ksRewardVideoAd.setRewardAdInteractionListener(null);
            this.g = null;
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
        if (map.containsKey(TapATInitManager.ORIENTATION_KEY)) {
            this.b = ATInitMediation.getIntFromMap(map, TapATInitManager.ORIENTATION_KEY);
        }
        this.d = true;
        if (map.containsKey("video_muted")) {
            this.d = TextUtils.equals("0", ATInitMediation.getStringFromMap(map, "video_muted"));
        }
        if (map2.containsKey(KSATConst.REWARDEDVIDEO_SKIP_AFTER_THIRTY_SECOND)) {
            this.c = ATInitMediation.getBooleanFromMap(map2, KSATConst.REWARDEDVIDEO_SKIP_AFTER_THIRTY_SECOND);
        }
        if (map.containsKey(j.w.m)) {
            this.f = ATInitMediation.getDoubleFromMap(map, j.w.m);
        }
        if (map.containsKey("payload")) {
            this.e = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.f);
        }
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.a = ATInitMediation.getLongFromMap(map, "position_id");
        KSATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, 1);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.j;
    }

    private void b() {
        Map<String, Object> mediaExtraInfo;
        Object obj;
        KsRewardVideoAd ksRewardVideoAd = this.g;
        if (ksRewardVideoAd == null || (mediaExtraInfo = ksRewardVideoAd.getMediaExtraInfo()) == null || (obj = mediaExtraInfo.get("llsid")) == null) {
            return;
        }
        if (this.j == null) {
            this.j = new HashMap();
        }
        this.j.put("third_trans_id", obj.toString());
    }

    static /* synthetic */ void j(KSATRewardedVideoAdapter kSATRewardedVideoAdapter) {
        Map<String, Object> mediaExtraInfo;
        Object obj;
        KsRewardVideoAd ksRewardVideoAd = kSATRewardedVideoAdapter.g;
        if (ksRewardVideoAd == null || (mediaExtraInfo = ksRewardVideoAd.getMediaExtraInfo()) == null || (obj = mediaExtraInfo.get("llsid")) == null) {
            return;
        }
        if (kSATRewardedVideoAdapter.j == null) {
            kSATRewardedVideoAdapter.j = new HashMap();
        }
        kSATRewardedVideoAdapter.j.put("third_trans_id", obj.toString());
    }

    static /* synthetic */ void o(KSATRewardedVideoAdapter kSATRewardedVideoAdapter) {
        HashMap map = new HashMap();
        map.put("thirdUserId", kSATRewardedVideoAdapter.mUserId);
        if (!TextUtils.isEmpty(kSATRewardedVideoAdapter.mUserData) && kSATRewardedVideoAdapter.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
            kSATRewardedVideoAdapter.mUserData = kSATRewardedVideoAdapter.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, new StringBuilder().append(kSATRewardedVideoAdapter.a).toString());
        }
        map.put("extraData", kSATRewardedVideoAdapter.mUserData);
        KsScene.Builder builderRewardCallbackExtraData = new KsScene.Builder(kSATRewardedVideoAdapter.a).adNum(1).screenOrientation(kSATRewardedVideoAdapter.b == 2 ? 2 : 1).rewardCallbackExtraData(map);
        if (!TextUtils.isEmpty(kSATRewardedVideoAdapter.e)) {
            builderRewardCallbackExtraData.setBidResponseV2(kSATRewardedVideoAdapter.e);
        }
        KsAdSDK.getLoadManager().loadRewardVideoAd(builderRewardCallbackExtraData.build(), kSATRewardedVideoAdapter.new AnonymousClass3());
    }
}
