package com.anythink.network.ks;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.rewardvideo.api.ATRewardRetryTaskManager;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.KSAdInfoData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class KSATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    private static final String k = "KSATRewardedVideoAdapter";
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

    class a implements KsRewardVideoAd.RewardAdInteractionListener {
        a() {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onAdClicked() {
            if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onExtraRewardVerify(int i) {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onPageDismiss() {
            KSATRewardedVideoAdapter kSATRewardedVideoAdapter = KSATRewardedVideoAdapter.this;
            if (kSATRewardedVideoAdapter.i) {
                return;
            }
            kSATRewardedVideoAdapter.i = true;
            if (((CustomRewardVideoAdapter) kSATRewardedVideoAdapter).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onRewardStepVerify(int i, int i2) {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onRewardVerify(Map<String, Object> map) {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoPlayEnd() {
            if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoPlayError(int i, int i2) {
            if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayFailed(i + "", "");
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoPlayStart() {
            KSATRewardedVideoAdapter.this.c();
            try {
                KSATInitManager.getInstance().a(KSATRewardedVideoAdapter.this.getShowId(), new WeakReference(KSATRewardedVideoAdapter.this.g));
            } catch (Throwable unused) {
            }
            if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoSkipToEnd(long j) {
            ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mDismissType = 2;
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onRewardVerify() {
            KSATRewardedVideoAdapter.this.c();
            if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onReward();
            }
        }
    }

    class b implements MediationInitCallback {
        b() {
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            KSATRewardedVideoAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            KSATRewardedVideoAdapter.this.d();
        }
    }

    class c implements KsLoadManager.RewardVideoAdListener {
        c() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onError(int i, String str) {
            KSATRewardedVideoAdapter.this.notifyATLoadFail(i + "", str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
            double ecpm;
            KSATRewardedVideoAdapter.this.g = (list == null || list.size() <= 0) ? null : list.get(0);
            KSATRewardedVideoAdapter kSATRewardedVideoAdapter = KSATRewardedVideoAdapter.this;
            if (kSATRewardedVideoAdapter.g == null) {
                kSATRewardedVideoAdapter.notifyATLoadFail("", "KuaiShou: List<KsRewardVideoAd> is empty");
                return;
            }
            kSATRewardedVideoAdapter.b();
            KSATRewardedVideoAdapter.this.j = KSATInitManager.getInstance().a(KSATRewardedVideoAdapter.this.g.getMediaExtraInfo(), KSATRewardedVideoAdapter.this.j);
            KSATRewardedVideoAdapter kSATRewardedVideoAdapter2 = KSATRewardedVideoAdapter.this;
            if (!kSATRewardedVideoAdapter2.h) {
                if (((CustomRewardVideoAdapter) kSATRewardedVideoAdapter2).mLoadListener != null) {
                    ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (kSATRewardedVideoAdapter2.mBiddingListener != null) {
                try {
                    ecpm = kSATRewardedVideoAdapter2.g.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                    ecpm = 0.0d;
                }
                if (ecpm <= 0.0d) {
                    KSATRewardedVideoAdapter.this.mBiddingListener.onC2SBidResult(ATBiddingResult.fail("error price: " + ecpm));
                } else {
                    KSATRewardedVideoAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, System.currentTimeMillis() + "", new KSATBiddingNotice(KSATRewardedVideoAdapter.this.g), ATAdConst.CURRENCY.RMB_CENT), null);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoResult(List<KsRewardVideoAd> list) {
            if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mLoadListener != null) {
                ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }
    }

    class d implements KsRewardVideoAd.KSAdRewardRetryTaskListener {
        d() {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.KSAdRewardRetryTaskListener
        public void onAdRewardRetryTaskNotify(KSAdInfoData kSAdInfoData) {
            try {
                ATRewardRetryTaskManager.getInstance().notifyATRewardRetryTask(KSATInfoReversion.convertFromKSAdInfoData(kSAdInfoData));
            } catch (Throwable unused) {
                String unused2 = KSATRewardedVideoAdapter.k;
            }
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return KSATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        KsRewardVideoAd ksRewardVideoAd = this.g;
        if (ksRewardVideoAd != null) {
            ksRewardVideoAd.setRewardAdInteractionListener(null);
            this.g = null;
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.a = ATInitMediation.getLongFromMap(map, "position_id");
        KSATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, 1);
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdInternalAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(3, KSATInterstitialAdapter.class);
        map.put(4, KSATSplashAdapter.class);
        map.put(0, KSATAdapter.class);
        return map;
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
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return KSATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean isAdReady() {
        KsRewardVideoAd ksRewardVideoAd = this.g;
        return ksRewardVideoAd != null && ksRewardVideoAd.isAdEnable();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (a(map, map2)) {
            KSATInitManager.getInstance().initSDK(context.getApplicationContext(), map, new b());
        } else {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        KsRewardVideoAd ksRewardVideoAd = this.g;
        if (ksRewardVideoAd == null || activity == null) {
            return;
        }
        try {
            ksRewardVideoAd.setRewardAdInteractionListener(new a());
            KsVideoPlayConfig ksVideoPlayConfigBuild = new KsVideoPlayConfig.Builder().showLandscape(this.b == 2).skipThirtySecond(this.c).videoSoundEnable(this.d).build();
            this.i = false;
            this.g.showRewardVideoAd(activity, ksVideoPlayConfigBuild);
        } catch (Exception e) {
            e.printStackTrace();
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
        KsRewardVideoAd ksRewardVideoAd = this.g;
        if (ksRewardVideoAd != null) {
            try {
                ksRewardVideoAd.setRewardAdRetryTaskCallback(new d());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Map<String, Object> mediaExtraInfo;
        Object obj;
        KsRewardVideoAd ksRewardVideoAd = this.g;
        if (ksRewardVideoAd == null || (mediaExtraInfo = ksRewardVideoAd.getMediaExtraInfo()) == null || (obj = mediaExtraInfo.get(KSATConst.KS_LLS_ID)) == null) {
            return;
        }
        if (this.j == null) {
            this.j = new HashMap();
        }
        this.j.put("third_trans_id", obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        HashMap map = new HashMap();
        map.put("thirdUserId", this.mUserId);
        if (!TextUtils.isEmpty(this.mUserData) && this.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
            this.mUserData = this.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, this.a + "");
        }
        map.put("extraData", this.mUserData);
        KsScene.Builder builderRewardCallbackExtraData = new KsScene.Builder(this.a).adNum(1).screenOrientation(this.b == 2 ? 2 : 1).rewardCallbackExtraData(map);
        if (!TextUtils.isEmpty(this.e)) {
            builderRewardCallbackExtraData.setBidResponseV2(this.e);
        }
        KsAdSDK.getLoadManager().loadRewardVideoAd(builderRewardCallbackExtraData.build(), new c());
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
        if (map.containsKey("orientation")) {
            this.b = ATInitMediation.getIntFromMap(map, "orientation");
        }
        this.d = true;
        if (map.containsKey("video_muted")) {
            this.d = TextUtils.equals("0", ATInitMediation.getStringFromMap(map, "video_muted"));
        }
        Boolean bool = ATSDKGlobalSetting.isGlobalMute;
        if (bool != null) {
            this.d = !bool.booleanValue();
        }
        if (map2.containsKey(KSATConst.REWARDEDVIDEO_SKIP_AFTER_THIRTY_SECOND)) {
            this.c = ATInitMediation.getBooleanFromMap(map2, KSATConst.REWARDEDVIDEO_SKIP_AFTER_THIRTY_SECOND);
        }
        if (map.containsKey("anythink_gsp")) {
            this.f = ATInitMediation.getDoubleFromMap(map, "anythink_gsp");
        }
        if (map.containsKey("payload")) {
            this.e = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.f);
        }
        return true;
    }
}
