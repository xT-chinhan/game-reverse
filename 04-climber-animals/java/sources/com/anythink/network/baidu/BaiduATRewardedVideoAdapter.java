package com.anythink.network.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BaiduATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    private static final String e = "BaiduATRewardedVideoAdapter";
    RewardVideoAd a;
    private Map<String, Object> i;
    private String f = "";
    private String g = "";
    private double h = 0.0d;
    boolean b = false;
    boolean c = false;
    boolean d = false;

    static /* synthetic */ int j(BaiduATRewardedVideoAdapter baiduATRewardedVideoAdapter) {
        baiduATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATRewardedVideoAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements RewardVideoAd.RewardVideoAdListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdShow() {
            if (BaiduATRewardedVideoAdapter.this.mImpressionListener != null) {
                BaiduATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClick() {
            if (BaiduATRewardedVideoAdapter.this.mImpressionListener != null) {
                BaiduATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClose(float f) {
            if (BaiduATRewardedVideoAdapter.this.mImpressionListener != null) {
                BaiduATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdFailed(String str) {
            BaiduATRewardedVideoAdapter.this.notifyATLoadFail("", str, new BaiduATBiddingNotice(BaiduATRewardedVideoAdapter.this.a), ATAdConst.CURRENCY.RMB_CENT);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadSuccess() {
            BaiduATRewardedVideoAdapter.g(BaiduATRewardedVideoAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadFailed() {
            BaiduATRewardedVideoAdapter.this.notifyATLoadFail("", "BaiduRewardedVideo: onVideoDownloadFailed");
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void playCompletion() {
            if (BaiduATRewardedVideoAdapter.this.mImpressionListener != null) {
                BaiduATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdSkip(float f) {
            BaiduATRewardedVideoAdapter.j(BaiduATRewardedVideoAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
        public final void onRewardVerify(boolean z) {
            BaiduATRewardedVideoAdapter.this.b();
            if (BaiduATRewardedVideoAdapter.this.mImpressionListener != null) {
                if (z) {
                    BaiduATRewardedVideoAdapter.this.mImpressionListener.onReward();
                } else {
                    BaiduATRewardedVideoAdapter.this.mImpressionListener.onRewardFailed();
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdLoaded() {
            if (BaiduATRewardedVideoAdapter.this.d) {
                BaiduATRewardedVideoAdapter.this.c = true;
            }
            BaiduATInitManager.getInstance();
            BaiduATInitManager.a(BaiduATRewardedVideoAdapter.this.b, BaiduATRewardedVideoAdapter.this.a, BaiduATRewardedVideoAdapter.this.mLoadListener, BaiduATRewardedVideoAdapter.this.mBiddingListener);
        }
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.a = new RewardVideoAd(context.getApplicationContext(), this.f, new AnonymousClass1());
        if (this.b && this.h > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATRewardedVideo", "setBidFloor:" + ((int) this.h));
            }
            this.a.setBidFloor((int) this.h);
        }
        if (!TextUtils.isEmpty(this.mUserId)) {
            this.a.setUserId(this.mUserId);
        }
        if (!TextUtils.isEmpty(this.mUserData)) {
            if (this.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                this.mUserData = this.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, this.f);
            }
            this.a.setExtraInfo(this.mUserData);
        }
        RequestParameters.Builder builder = new RequestParameters.Builder();
        BaiduATInitManager.getInstance();
        BaiduATInitManager.a(this.f, builder, map, map2);
        this.a.setRequestParameters(builder.build());
        this.a.setAppSid(BaiduATInitManager.getInstance().getApp_id());
        this.a.load();
    }

    private void a() {
        double d;
        b();
        if (this.b) {
            if (this.mBiddingListener != null) {
                RewardVideoAd rewardVideoAd = this.a;
                if (rewardVideoAd != null) {
                    String pecpm = rewardVideoAd.getPECPM();
                    if (this.i == null) {
                        this.i = new HashMap();
                    }
                    this.i.put(BaiduATConst.EN_P_KEY, pecpm);
                    String eCPMLevel = this.a.getECPMLevel();
                    if (TextUtils.isEmpty(eCPMLevel)) {
                        eCPMLevel = "0";
                    }
                    try {
                        d = Double.parseDouble(eCPMLevel);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        d = 0.0d;
                    }
                    if (d <= 0.0d) {
                        notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(String.valueOf(d)));
                        return;
                    }
                    ATBiddingResult aTBiddingResultSuccess = ATBiddingResult.success(d, new StringBuilder().append(System.currentTimeMillis()).toString(), new BaiduATBiddingNotice(this.a), ATAdConst.CURRENCY.RMB_CENT);
                    aTBiddingResultSuccess.setExtra(pecpm);
                    this.mBiddingListener.onC2SBiddingResultWithCache(aTBiddingResultSuccess, null);
                    return;
                }
                notifyATLoadFail("", "Baidu: RewardVideoAd had been destroyed.");
                return;
            }
            return;
        }
        if (this.mLoadListener != null) {
            this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        RewardVideoAd rewardVideoAd = this.a;
        if (rewardVideoAd == null) {
            return false;
        }
        if (this.d && this.c) {
            return true;
        }
        return rewardVideoAd.isReady();
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        this.c = false;
        try {
            this.a.show(activity);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return BaiduATInitManager.getInstance().getNetworkName();
    }

    private void a(Map<String, Object> map) {
        this.g = ATInitMediation.getStringFromMap(map, "app_id");
        this.f = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.h = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        this.d = ATInitMediation.getIntFromMap(map, "ad_s_reqf_mode") == 2;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        this.a = null;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return BaiduATInitManager.getInstance().getNetworkVersion();
    }

    public void setDismissType(int i) {
        this.mDismissType = i;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.b = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdInternalAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(4, BaiduATSplashAdapter.class);
        map.put(3, BaiduATInterstitialAdapter.class);
        return map;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Object adDataForKey;
        RewardVideoAd rewardVideoAd = this.a;
        if (rewardVideoAd == null || (adDataForKey = rewardVideoAd.getAdDataForKey("request_id")) == null) {
            return;
        }
        if (this.i == null) {
            this.i = new HashMap();
        }
        this.i.put("third_trans_id", adDataForKey.toString());
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.g = ATInitMediation.getStringFromMap(map, "app_id");
        this.f = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.h = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        this.d = ATInitMediation.getIntFromMap(map, "ad_s_reqf_mode") == 2;
        if (TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.f)) {
            notifyATLoadFail("", " app_id ,ad_place_id is empty.");
        } else {
            final Context applicationContext = context.getApplicationContext();
            BaiduATInitManager.getInstance().initSDK(applicationContext, map, new MediationInitCallback() { // from class: com.anythink.network.baidu.BaiduATRewardedVideoAdapter.2
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    if (BaiduATRewardedVideoAdapter.this.mLoadListener != null) {
                        BaiduATRewardedVideoAdapter.this.mLoadListener.onAdLoadError("", str);
                    }
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        BaiduATRewardedVideoAdapter.a(BaiduATRewardedVideoAdapter.this, applicationContext, map, map2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        if (BaiduATRewardedVideoAdapter.this.mLoadListener != null) {
                            BaiduATRewardedVideoAdapter.this.mLoadListener.onAdLoadError("", "Baidu: init error, " + th.getMessage());
                        }
                    }
                }
            });
        }
    }

    static /* synthetic */ void g(BaiduATRewardedVideoAdapter baiduATRewardedVideoAdapter) {
        double d;
        baiduATRewardedVideoAdapter.b();
        if (baiduATRewardedVideoAdapter.b) {
            if (baiduATRewardedVideoAdapter.mBiddingListener != null) {
                RewardVideoAd rewardVideoAd = baiduATRewardedVideoAdapter.a;
                if (rewardVideoAd != null) {
                    String pecpm = rewardVideoAd.getPECPM();
                    if (baiduATRewardedVideoAdapter.i == null) {
                        baiduATRewardedVideoAdapter.i = new HashMap();
                    }
                    baiduATRewardedVideoAdapter.i.put(BaiduATConst.EN_P_KEY, pecpm);
                    String eCPMLevel = baiduATRewardedVideoAdapter.a.getECPMLevel();
                    if (TextUtils.isEmpty(eCPMLevel)) {
                        eCPMLevel = "0";
                    }
                    try {
                        d = Double.parseDouble(eCPMLevel);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        d = 0.0d;
                    }
                    if (d <= 0.0d) {
                        baiduATRewardedVideoAdapter.notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(String.valueOf(d)));
                        return;
                    }
                    ATBiddingResult aTBiddingResultSuccess = ATBiddingResult.success(d, new StringBuilder().append(System.currentTimeMillis()).toString(), new BaiduATBiddingNotice(baiduATRewardedVideoAdapter.a), ATAdConst.CURRENCY.RMB_CENT);
                    aTBiddingResultSuccess.setExtra(pecpm);
                    baiduATRewardedVideoAdapter.mBiddingListener.onC2SBiddingResultWithCache(aTBiddingResultSuccess, null);
                    return;
                }
                baiduATRewardedVideoAdapter.notifyATLoadFail("", "Baidu: RewardVideoAd had been destroyed.");
                return;
            }
            return;
        }
        if (baiduATRewardedVideoAdapter.mLoadListener != null) {
            baiduATRewardedVideoAdapter.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
        }
    }

    static /* synthetic */ void a(BaiduATRewardedVideoAdapter baiduATRewardedVideoAdapter, Context context, Map map, Map map2) {
        baiduATRewardedVideoAdapter.a = new RewardVideoAd(context.getApplicationContext(), baiduATRewardedVideoAdapter.f, baiduATRewardedVideoAdapter.new AnonymousClass1());
        if (baiduATRewardedVideoAdapter.b && baiduATRewardedVideoAdapter.h > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATRewardedVideo", "setBidFloor:" + ((int) baiduATRewardedVideoAdapter.h));
            }
            baiduATRewardedVideoAdapter.a.setBidFloor((int) baiduATRewardedVideoAdapter.h);
        }
        if (!TextUtils.isEmpty(baiduATRewardedVideoAdapter.mUserId)) {
            baiduATRewardedVideoAdapter.a.setUserId(baiduATRewardedVideoAdapter.mUserId);
        }
        if (!TextUtils.isEmpty(baiduATRewardedVideoAdapter.mUserData)) {
            if (baiduATRewardedVideoAdapter.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                baiduATRewardedVideoAdapter.mUserData = baiduATRewardedVideoAdapter.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, baiduATRewardedVideoAdapter.f);
            }
            baiduATRewardedVideoAdapter.a.setExtraInfo(baiduATRewardedVideoAdapter.mUserData);
        }
        RequestParameters.Builder builder = new RequestParameters.Builder();
        BaiduATInitManager.getInstance();
        BaiduATInitManager.a(baiduATRewardedVideoAdapter.f, builder, (Map<String, Object>) map, (Map<String, Object>) map2);
        baiduATRewardedVideoAdapter.a.setRequestParameters(builder.build());
        baiduATRewardedVideoAdapter.a.setAppSid(BaiduATInitManager.getInstance().getApp_id());
        baiduATRewardedVideoAdapter.a.load();
    }
}
