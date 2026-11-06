package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingListenerExt;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListenerExt;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.ADRewardListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GDTATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    private static final String m = "GDTATRewardedVideoAdapter";
    RewardVideoAD a;
    UnifiedInterstitialAD b;
    String c;
    String d;
    String f;
    private Map<String, Object> g;
    private boolean h;
    private int e = 0;
    private int i = 1;
    private boolean j = false;
    private int k = 0;
    private int l = 0;

    class a implements MediationInitCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;
        final /* synthetic */ Map c;

        a(Context context, Map map, Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            GDTATRewardedVideoAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            GDTATRewardedVideoAdapter.this.a(this.a, this.b, this.c);
        }
    }

    class c implements UnifiedInterstitialADListener {

        class a implements DownloadConfirmListener {
            a() {
            }

            @Override // com.qq.e.comm.compliance.DownloadConfirmListener
            public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                    GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                    gDTDownloadFirmInfo.appInfoUrl = str;
                    gDTDownloadFirmInfo.scenes = i;
                    gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                    ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                }
            }
        }

        class b implements ADRewardListener {
            b() {
            }

            @Override // com.qq.e.comm.listeners.ADRewardListener
            public void onReward(Map<String, Object> map) {
                if (GDTATRewardedVideoAdapter.this.g == null) {
                    GDTATRewardedVideoAdapter.this.g = new HashMap();
                }
                GDTATRewardedVideoAdapter.this.g.put("gdt_trans_id", map.get("transId"));
                GDTATRewardedVideoAdapter.this.g.put("third_trans_id", map.get("transId"));
                if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onReward();
                }
            }
        }

        c() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            GDTATInitManager.getInstance().b();
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            try {
                GDTATInitManager.getInstance().a(GDTATRewardedVideoAdapter.this.getShowId(), new WeakReference(GDTATRewardedVideoAdapter.this.b));
            } catch (Throwable unused) {
            }
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
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
            try {
                Map<String, Object> extraInfo = GDTATRewardedVideoAdapter.this.b.getExtraInfo();
                if (extraInfo != null) {
                    if (GDTATRewardedVideoAdapter.this.g == null) {
                        GDTATRewardedVideoAdapter.this.g = new HashMap();
                    }
                    GDTATInitManager.getInstance().a(extraInfo, GDTATRewardedVideoAdapter.this.g);
                }
            } catch (Throwable unused) {
            }
            GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter = GDTATRewardedVideoAdapter.this;
            if (gDTATRewardedVideoAdapter.b != null && gDTATRewardedVideoAdapter.h) {
                GDTATRewardedVideoAdapter.this.b.setDownloadConfirmListener(new a());
            }
            UnifiedInterstitialAD unifiedInterstitialAD2 = GDTATRewardedVideoAdapter.this.b;
            if (unifiedInterstitialAD2 != null) {
                unifiedInterstitialAD2.setRewardListener(new b());
            }
            if (!GDTATRewardedVideoAdapter.this.j) {
                if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mLoadListener instanceof ATCustomLoadListenerExt) {
                    ((ATCustomLoadListenerExt) ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mLoadListener).onAdDataLoadedWithAds(new BaseAd[0]);
                }
            } else {
                GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter2 = GDTATRewardedVideoAdapter.this;
                if (!(gDTATRewardedVideoAdapter2.mBiddingListener instanceof ATBiddingListenerExt) || (unifiedInterstitialAD = gDTATRewardedVideoAdapter2.b) == null) {
                    return;
                }
                ((ATBiddingListenerExt) GDTATRewardedVideoAdapter.this.mBiddingListener).onC2SBiddingResultWithData(ATBiddingResult.success(unifiedInterstitialAD.getECPM(), System.currentTimeMillis() + "", new GDTATBiddingNotice(GDTATRewardedVideoAdapter.this.b), ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            GDTATRewardedVideoAdapter.this.notifyATLoadFail(String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
            GDTATRewardedVideoAdapter.this.notifyATLoadFail("", "GDT: onRenderFail()");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
            if (!GDTATRewardedVideoAdapter.this.j) {
                if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    return;
                }
                return;
            }
            GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter = GDTATRewardedVideoAdapter.this;
            if (gDTATRewardedVideoAdapter.mBiddingListener != null) {
                UnifiedInterstitialAD unifiedInterstitialAD = gDTATRewardedVideoAdapter.b;
                if (unifiedInterstitialAD == null) {
                    gDTATRewardedVideoAdapter.notifyATLoadFail("", "GDT : UnifiedInterstitialAD had been destroyed.");
                    return;
                }
                GDTATRewardedVideoAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(unifiedInterstitialAD.getECPM(), System.currentTimeMillis() + "", new GDTATBiddingNotice(GDTATRewardedVideoAdapter.this.b), ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
        }
    }

    class d implements UnifiedInterstitialMediaListener {
        d() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoComplete() {
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoError(AdError adError) {
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayFailed(adError.getErrorCode() + "", adError.getErrorMsg());
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
        }
    }

    static /* synthetic */ int W(GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter) {
        int i = gDTATRewardedVideoAdapter.k;
        gDTATRewardedVideoAdapter.k = i + 1;
        return i;
    }

    static /* synthetic */ int g(GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter) {
        int i = gDTATRewardedVideoAdapter.l;
        gDTATRewardedVideoAdapter.l = i + 1;
        return i;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return GDTATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        if (this.a != null) {
            this.a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
        this.k = 0;
        this.l = 0;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.d = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdInternalAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(4, GDTATSplashAdapter.class);
        map.put(3, GDTATInterstitialAdapter.class);
        map.put(0, GDTATAdapter.class);
        return map;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter
    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.g;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.d;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean isAdReady() {
        RewardVideoAD rewardVideoAD = this.a;
        if (rewardVideoAD != null) {
            return rewardVideoAD.isValid();
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.b;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.isValid();
        }
        return false;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(map, map2);
        if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else {
            GDTATInitManager.getInstance().initSDK(context.getApplicationContext(), map, new a(context, map, map2));
        }
    }

    public void setDismissType(int i) {
        this.mDismissType = i;
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        if (this.a != null) {
            try {
                GDTATInitManager.getInstance().a(this.d, this.a);
                if (activity != null) {
                    this.a.showAD(activity);
                } else {
                    this.a.showAD();
                }
            } catch (Throwable th) {
                GDTATInitManager.getInstance().c();
                th.printStackTrace();
            }
        }
        if (this.b != null) {
            try {
                GDTATInitManager.getInstance().a(this.d, this.b);
                this.b.showFullScreenAD(activity);
            } catch (Throwable th2) {
                GDTATInitManager.getInstance().b();
                th2.printStackTrace();
            }
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.j = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private void b(Context context, Map<String, Object> map) {
        b bVar = new b();
        boolean zIsPlayMute = GDTATInitManager.getInstance().isPlayMute(this.e);
        if (TextUtils.isEmpty(this.f) || this.j) {
            this.a = new RewardVideoAD(context.getApplicationContext(), this.d, bVar, !zIsPlayMute);
            LoadAdParams loadAdParamsA = GDTATInitManager.getInstance().a(map);
            if (loadAdParamsA != null) {
                this.a.setLoadAdParams(loadAdParamsA);
            }
        } else {
            this.a = new RewardVideoAD(context.getApplicationContext(), this.d, bVar, !zIsPlayMute, this.f);
        }
        try {
            ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
            builder.setUserId(this.mUserId);
            if (!TextUtils.isEmpty(this.mUserData) && this.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                this.mUserData = this.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, this.d);
            }
            builder.setCustomData(this.mUserData);
            ServerSideVerificationOptions serverSideVerificationOptionsBuild = builder.build();
            if (serverSideVerificationOptionsBuild != null && ATSDK.isNetworkLogDebug()) {
                Log.i(m, "ServerSideVerificationOptions: userId:" + serverSideVerificationOptionsBuild.getUserId() + "||userCustomData:" + serverSideVerificationOptionsBuild.getCustomData());
            }
            this.a.setServerSideVerificationOptions(serverSideVerificationOptionsBuild);
        } catch (Throwable unused) {
        }
        this.k = 0;
        this.l = 0;
        this.a.loadAD();
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.c = ATInitMediation.getStringFromMap(map, "app_id");
        this.d = ATInitMediation.getStringFromMap(map, "unit_id");
        this.f = ATInitMediation.getStringFromMap(map, "payload");
        this.e = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        this.i = ATInitMediation.getIntFromMap(map, "unit_type", 1);
        this.h = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        GDTATInitManager.getInstance().setExtraUserData(map2);
        if (this.i == 2) {
            a(context, map);
        } else {
            b(context, map);
        }
    }

    class b implements RewardVideoADListener {

        class a implements DownloadConfirmListener {
            a() {
            }

            @Override // com.qq.e.comm.compliance.DownloadConfirmListener
            public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                    GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                    gDTDownloadFirmInfo.appInfoUrl = str;
                    gDTDownloadFirmInfo.scenes = i;
                    gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                    ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                }
            }
        }

        b() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            String unused = GDTATRewardedVideoAdapter.m;
            int unused2 = GDTATRewardedVideoAdapter.this.k;
            if (GDTATRewardedVideoAdapter.this.k <= 1) {
                if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
                }
            } else if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdAgainPlayClicked();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            GDTATInitManager.getInstance().c();
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
            try {
                GDTATInitManager.getInstance().a(GDTATRewardedVideoAdapter.this.getShowId(), new WeakReference(GDTATRewardedVideoAdapter.this.a));
            } catch (Throwable unused) {
            }
            GDTATRewardedVideoAdapter.W(GDTATRewardedVideoAdapter.this);
            String unused2 = GDTATRewardedVideoAdapter.m;
            int unused3 = GDTATRewardedVideoAdapter.this.k;
            if (GDTATRewardedVideoAdapter.this.k <= 1) {
                if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
                }
            } else if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdAgainPlayStart();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            RewardVideoAD rewardVideoAD;
            RewardVideoAD rewardVideoAD2 = GDTATRewardedVideoAdapter.this.a;
            if (rewardVideoAD2 != null) {
                GDTATRewardedVideoAdapter.this.g = GDTATInitManager.getInstance().a(rewardVideoAD2.getExtraInfo(), GDTATRewardedVideoAdapter.this.g);
            }
            GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter = GDTATRewardedVideoAdapter.this;
            if (gDTATRewardedVideoAdapter.a != null && gDTATRewardedVideoAdapter.h) {
                GDTATRewardedVideoAdapter.this.a.setDownloadConfirmListener(new a());
            }
            if (!GDTATRewardedVideoAdapter.this.j) {
                if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else {
                GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter2 = GDTATRewardedVideoAdapter.this;
                if (gDTATRewardedVideoAdapter2.mBiddingListener == null || (rewardVideoAD = gDTATRewardedVideoAdapter2.a) == null) {
                    return;
                }
                GDTATRewardedVideoAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(rewardVideoAD.getECPM(), System.currentTimeMillis() + "", new GDTATBiddingNotice(GDTATRewardedVideoAdapter.this.a), ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            GDTATRewardedVideoAdapter.this.notifyATLoadFail(adError.getErrorCode() + "", adError.getErrorMsg());
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayFailed(adError.getErrorCode() + "", adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward(Map<String, Object> map) {
            if (GDTATRewardedVideoAdapter.this.g == null) {
                GDTATRewardedVideoAdapter.this.g = new HashMap();
            }
            GDTATRewardedVideoAdapter.this.g.put("gdt_trans_id", map.get("transId"));
            GDTATRewardedVideoAdapter.this.g.put("third_trans_id", map.get("transId"));
            GDTATRewardedVideoAdapter.g(GDTATRewardedVideoAdapter.this);
            String unused = GDTATRewardedVideoAdapter.m;
            int unused2 = GDTATRewardedVideoAdapter.this.l;
            if (GDTATRewardedVideoAdapter.this.l <= 1) {
                if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onReward();
                }
            } else if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onAgainReward();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }

        public void onReward() {
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onReward();
            }
        }
    }

    private void a(Context context, Map<String, Object> map) {
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        c cVar = new c();
        if (!TextUtils.isEmpty(this.f) && !this.j) {
            this.b = new UnifiedInterstitialAD((Activity) context, this.d, cVar, null, this.f);
        } else {
            this.b = new UnifiedInterstitialAD((Activity) context, this.d, cVar);
            LoadAdParams loadAdParamsA = GDTATInitManager.getInstance().a(map);
            if (loadAdParamsA != null) {
                this.b.setLoadAdParams(loadAdParamsA);
            }
        }
        a(this.b, map);
        ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
        if (!TextUtils.isEmpty(this.mUserId)) {
            builder.setUserId(this.mUserId);
        }
        if (!TextUtils.isEmpty(this.mUserData)) {
            builder.setCustomData(this.mUserData);
        }
        ServerSideVerificationOptions serverSideVerificationOptionsBuild = builder.build();
        if (serverSideVerificationOptionsBuild != null && ATSDK.isNetworkLogDebug()) {
            Log.i(m, "ServerSideVerificationOptions: userId:" + serverSideVerificationOptionsBuild.getUserId() + "||userCustomData:" + serverSideVerificationOptionsBuild.getCustomData());
        }
        this.b.setServerSideVerificationOptions(serverSideVerificationOptionsBuild);
        this.b.setMediaListener(new d());
        this.b.loadFullScreenAD();
    }

    private void a(UnifiedInterstitialAD unifiedInterstitialAD, Map<String, Object> map) {
        int i = map.containsKey("video_muted") ? Integer.parseInt(map.get("video_muted").toString()) : 0;
        int i2 = map.containsKey("video_autoplay") ? Integer.parseInt(map.get("video_autoplay").toString()) : 1;
        int i3 = map.containsKey("video_duration") ? Integer.parseInt(map.get("video_duration").toString()) : -1;
        boolean zIsPlayMute = GDTATInitManager.getInstance().isPlayMute(i);
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(zIsPlayMute).setDetailPageMuted(zIsPlayMute).setAutoPlayPolicy(i2).build());
            if (i3 != -1) {
                unifiedInterstitialAD.setMaxVideoDuration(i3);
            }
        }
    }
}
