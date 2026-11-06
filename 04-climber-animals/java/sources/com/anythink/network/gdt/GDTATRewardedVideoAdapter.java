package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingListenerExt;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListenerExt;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
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
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GDTATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    private static final String f = "GDTATRewardedVideoAdapter";
    RewardVideoAD a;
    UnifiedInterstitialAD b;
    String c;
    String d;
    String e;
    private Map<String, Object> h;
    private boolean i;
    private int g = 0;
    private int j = 1;
    private boolean k = false;

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.c = ATInitMediation.getStringFromMap(map, "app_id");
        this.d = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getStringFromMap(map, "payload");
        this.g = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        this.j = ATInitMediation.getIntFromMap(map, "unit_type", 1);
        this.i = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        GDTATInitManager.getInstance().setExtraUserData(map2);
        if (this.j == 2) {
            if (!(context instanceof Activity)) {
                notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
                return;
            }
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            if (TextUtils.isEmpty(this.e) || this.k) {
                this.b = new UnifiedInterstitialAD((Activity) context, this.d, anonymousClass3);
                GDTATInitManager.getInstance();
                this.b.setLoadAdParams(GDTATInitManager.a(map));
            } else {
                this.b = new UnifiedInterstitialAD((Activity) context, this.d, anonymousClass3, null, this.e);
            }
            UnifiedInterstitialAD unifiedInterstitialAD = this.b;
            int i = map.containsKey("video_muted") ? Integer.parseInt(map.get("video_muted").toString()) : 0;
            int i2 = map.containsKey("video_autoplay") ? Integer.parseInt(map.get("video_autoplay").toString()) : 1;
            int i3 = map.containsKey("video_duration") ? Integer.parseInt(map.get("video_duration").toString()) : -1;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(i == 1).setDetailPageMuted(i == 1).setAutoPlayPolicy(i2).build());
                if (i3 != -1) {
                    unifiedInterstitialAD.setMaxVideoDuration(i3);
                }
            }
            ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
            if (!TextUtils.isEmpty(this.mUserId)) {
                builder.setUserId(this.mUserId);
            }
            if (!TextUtils.isEmpty(this.mUserData)) {
                builder.setCustomData(this.mUserData);
            }
            ServerSideVerificationOptions serverSideVerificationOptionsBuild = builder.build();
            if (serverSideVerificationOptionsBuild != null && ATSDK.isNetworkLogDebug()) {
                Log.i(f, "ServerSideVerificationOptions: userId:" + serverSideVerificationOptionsBuild.getUserId() + "||userCustomData:" + serverSideVerificationOptionsBuild.getCustomData());
            }
            this.b.setServerSideVerificationOptions(serverSideVerificationOptionsBuild);
            this.b.setMediaListener(new AnonymousClass4());
            this.b.loadFullScreenAD();
            return;
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        if (TextUtils.isEmpty(this.e) || this.k) {
            this.a = new RewardVideoAD(context.getApplicationContext(), this.d, anonymousClass2, this.g != 1);
            GDTATInitManager.getInstance();
            this.a.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.a = new RewardVideoAD(context.getApplicationContext(), this.d, anonymousClass2, this.g != 1, this.e);
        }
        try {
            ServerSideVerificationOptions.Builder builder2 = new ServerSideVerificationOptions.Builder();
            builder2.setUserId(this.mUserId);
            if (!TextUtils.isEmpty(this.mUserData) && this.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                this.mUserData = this.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, this.d);
            }
            builder2.setCustomData(this.mUserData);
            ServerSideVerificationOptions serverSideVerificationOptionsBuild2 = builder2.build();
            if (serverSideVerificationOptionsBuild2 != null && ATSDK.isNetworkLogDebug()) {
                Log.i(f, "ServerSideVerificationOptions: userId:" + serverSideVerificationOptionsBuild2.getUserId() + "||userCustomData:" + serverSideVerificationOptionsBuild2.getCustomData());
            }
            this.a.setServerSideVerificationOptions(serverSideVerificationOptionsBuild2);
        } catch (Throwable unused) {
        }
        this.a.loadAD();
    }

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements RewardVideoADListener {
        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADShow() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onVideoCached() {
        }

        AnonymousClass2() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADLoad() {
            try {
                Map<String, Object> extraInfo = GDTATRewardedVideoAdapter.this.a.getExtraInfo();
                if (extraInfo != null) {
                    if (GDTATRewardedVideoAdapter.this.h == null) {
                        GDTATRewardedVideoAdapter.this.h = new HashMap();
                    }
                    GDTATRewardedVideoAdapter.this.h.putAll(extraInfo);
                }
            } catch (Throwable unused) {
            }
            if (GDTATRewardedVideoAdapter.this.a != null && GDTATRewardedVideoAdapter.this.i) {
                GDTATRewardedVideoAdapter.this.a.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATRewardedVideoAdapter.2.1
                    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                    public final void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                        if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                            GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                            gDTDownloadFirmInfo.appInfoUrl = str;
                            gDTDownloadFirmInfo.scenes = i;
                            gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                            GDTATRewardedVideoAdapter.this.mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                        }
                    }
                });
            }
            if (!GDTATRewardedVideoAdapter.this.k) {
                if (GDTATRewardedVideoAdapter.this.mLoadListener != null) {
                    GDTATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else {
                if (GDTATRewardedVideoAdapter.this.mBiddingListener == null || GDTATRewardedVideoAdapter.this.a == null) {
                    return;
                }
                GDTATRewardedVideoAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(GDTATRewardedVideoAdapter.this.a.getECPM(), new StringBuilder().append(System.currentTimeMillis()).toString(), new GDTATBiddingNotice(GDTATRewardedVideoAdapter.this.a), ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADExpose() {
            try {
                GDTATInitManager.getInstance().a(GDTATRewardedVideoAdapter.this.getTrackingInfo().z(), new WeakReference(GDTATRewardedVideoAdapter.this.a));
            } catch (Throwable unused) {
            }
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onReward(Map<String, Object> map) {
            if (GDTATRewardedVideoAdapter.this.h == null) {
                GDTATRewardedVideoAdapter.this.h = new HashMap();
            }
            GDTATRewardedVideoAdapter.this.h.put("gdt_trans_id", map.get("transId"));
            GDTATRewardedVideoAdapter.this.h.put("third_trans_id", map.get("transId"));
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onReward();
            }
        }

        public final void onReward() {
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onReward();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADClick() {
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onVideoComplete() {
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADClose() {
            GDTATInitManager.getInstance().a();
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onError(AdError adError) {
            GDTATRewardedVideoAdapter.this.notifyATLoadFail(new StringBuilder().append(adError.getErrorCode()).toString(), adError.getErrorMsg());
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayFailed(new StringBuilder().append(adError.getErrorCode()).toString(), adError.getErrorMsg());
            }
        }
    }

    private void a(Context context, Map<String, Object> map) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        if (TextUtils.isEmpty(this.e) || this.k) {
            this.a = new RewardVideoAD(context.getApplicationContext(), this.d, anonymousClass2, this.g != 1);
            GDTATInitManager.getInstance();
            this.a.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.a = new RewardVideoAD(context.getApplicationContext(), this.d, anonymousClass2, this.g != 1, this.e);
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
                Log.i(f, "ServerSideVerificationOptions: userId:" + serverSideVerificationOptionsBuild.getUserId() + "||userCustomData:" + serverSideVerificationOptionsBuild.getCustomData());
            }
            this.a.setServerSideVerificationOptions(serverSideVerificationOptionsBuild);
        } catch (Throwable unused) {
        }
        this.a.loadAD();
    }

    private void b(Context context, Map<String, Object> map) {
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        if (TextUtils.isEmpty(this.e) || this.k) {
            this.b = new UnifiedInterstitialAD((Activity) context, this.d, anonymousClass3);
            GDTATInitManager.getInstance();
            this.b.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.b = new UnifiedInterstitialAD((Activity) context, this.d, anonymousClass3, null, this.e);
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.b;
        int i = map.containsKey("video_muted") ? Integer.parseInt(map.get("video_muted").toString()) : 0;
        int i2 = map.containsKey("video_autoplay") ? Integer.parseInt(map.get("video_autoplay").toString()) : 1;
        int i3 = map.containsKey("video_duration") ? Integer.parseInt(map.get("video_duration").toString()) : -1;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(i == 1).setDetailPageMuted(i == 1).setAutoPlayPolicy(i2).build());
            if (i3 != -1) {
                unifiedInterstitialAD.setMaxVideoDuration(i3);
            }
        }
        ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
        if (!TextUtils.isEmpty(this.mUserId)) {
            builder.setUserId(this.mUserId);
        }
        if (!TextUtils.isEmpty(this.mUserData)) {
            builder.setCustomData(this.mUserData);
        }
        ServerSideVerificationOptions serverSideVerificationOptionsBuild = builder.build();
        if (serverSideVerificationOptionsBuild != null && ATSDK.isNetworkLogDebug()) {
            Log.i(f, "ServerSideVerificationOptions: userId:" + serverSideVerificationOptionsBuild.getUserId() + "||userCustomData:" + serverSideVerificationOptionsBuild.getCustomData());
        }
        this.b.setServerSideVerificationOptions(serverSideVerificationOptionsBuild);
        this.b.setMediaListener(new AnonymousClass4());
        this.b.loadFullScreenAD();
    }

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements UnifiedInterstitialADListener {
        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onVideoCached() {
        }

        AnonymousClass3() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADReceive() {
            try {
                Map<String, Object> extraInfo = GDTATRewardedVideoAdapter.this.b.getExtraInfo();
                if (extraInfo != null) {
                    if (GDTATRewardedVideoAdapter.this.h == null) {
                        GDTATRewardedVideoAdapter.this.h = new HashMap();
                    }
                    GDTATRewardedVideoAdapter.this.h.putAll(extraInfo);
                }
            } catch (Throwable unused) {
            }
            if (GDTATRewardedVideoAdapter.this.b != null && GDTATRewardedVideoAdapter.this.i) {
                GDTATRewardedVideoAdapter.this.b.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATRewardedVideoAdapter.3.1
                    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                    public final void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                        if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                            GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                            gDTDownloadFirmInfo.appInfoUrl = str;
                            gDTDownloadFirmInfo.scenes = i;
                            gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                            GDTATRewardedVideoAdapter.this.mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                        }
                    }
                });
            }
            if (GDTATRewardedVideoAdapter.this.b != null) {
                GDTATRewardedVideoAdapter.this.b.setRewardListener(new ADRewardListener() { // from class: com.anythink.network.gdt.GDTATRewardedVideoAdapter.3.2
                    @Override // com.qq.e.comm.listeners.ADRewardListener
                    public final void onReward(Map<String, Object> map) {
                        if (GDTATRewardedVideoAdapter.this.h == null) {
                            GDTATRewardedVideoAdapter.this.h = new HashMap();
                        }
                        GDTATRewardedVideoAdapter.this.h.put("gdt_trans_id", map.get("transId"));
                        GDTATRewardedVideoAdapter.this.h.put("third_trans_id", map.get("transId"));
                        if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                            GDTATRewardedVideoAdapter.this.mImpressionListener.onReward();
                        }
                    }
                });
            }
            if (!GDTATRewardedVideoAdapter.this.k) {
                if (GDTATRewardedVideoAdapter.this.mLoadListener instanceof ATCustomLoadListenerExt) {
                    ((ATCustomLoadListenerExt) GDTATRewardedVideoAdapter.this.mLoadListener).onAdDataLoadedWithAds(new BaseAd[0]);
                }
            } else {
                if (!(GDTATRewardedVideoAdapter.this.mBiddingListener instanceof ATBiddingListenerExt) || GDTATRewardedVideoAdapter.this.b == null) {
                    return;
                }
                ((ATBiddingListenerExt) GDTATRewardedVideoAdapter.this.mBiddingListener).onC2SBiddingResultWithData(ATBiddingResult.success(GDTATRewardedVideoAdapter.this.b.getECPM(), new StringBuilder().append(System.currentTimeMillis()).toString(), new GDTATBiddingNotice(GDTATRewardedVideoAdapter.this.b), ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onNoAD(AdError adError) {
            GDTATRewardedVideoAdapter.this.notifyATLoadFail(String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADExposure() {
            try {
                GDTATInitManager.getInstance().a(GDTATRewardedVideoAdapter.this.getTrackingInfo().z(), new WeakReference(GDTATRewardedVideoAdapter.this.b));
            } catch (Throwable unused) {
            }
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClicked() {
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClosed() {
            GDTATInitManager.getInstance().b();
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderSuccess() {
            if (!GDTATRewardedVideoAdapter.this.k) {
                if (GDTATRewardedVideoAdapter.this.mLoadListener != null) {
                    GDTATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (GDTATRewardedVideoAdapter.this.mBiddingListener != null) {
                if (GDTATRewardedVideoAdapter.this.b != null) {
                    GDTATRewardedVideoAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(GDTATRewardedVideoAdapter.this.b.getECPM(), new StringBuilder().append(System.currentTimeMillis()).toString(), new GDTATBiddingNotice(GDTATRewardedVideoAdapter.this.b), ATAdConst.CURRENCY.RMB_CENT), null);
                    return;
                }
                GDTATRewardedVideoAdapter.this.notifyATLoadFail("", "GDT : UnifiedInterstitialAD had been destroyed.");
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderFail() {
            GDTATRewardedVideoAdapter.this.notifyATLoadFail("", "GDT: onRenderFail()");
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$4, reason: invalid class name */
    final class AnonymousClass4 implements UnifiedInterstitialMediaListener {
        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoInit() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoLoading() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoPageClose() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoPageOpen() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoPause() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoReady(long j) {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoStart() {
        }

        AnonymousClass4() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoComplete() {
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoError(AdError adError) {
            if (GDTATRewardedVideoAdapter.this.mImpressionListener != null) {
                GDTATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayFailed(new StringBuilder().append(adError.getErrorCode()).toString(), adError.getErrorMsg());
            }
        }
    }

    private static void a(UnifiedInterstitialAD unifiedInterstitialAD, Map<String, Object> map) {
        int i = map.containsKey("video_muted") ? Integer.parseInt(map.get("video_muted").toString()) : 0;
        int i2 = map.containsKey("video_autoplay") ? Integer.parseInt(map.get("video_autoplay").toString()) : 1;
        int i3 = map.containsKey("video_duration") ? Integer.parseInt(map.get("video_duration").toString()) : -1;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(i == 1).setDetailPageMuted(i == 1).setAutoPlayPolicy(i2).build());
            if (i3 != -1) {
                unifiedInterstitialAD.setMaxVideoDuration(i3);
            }
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        if (this.a != null) {
            this.a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.d;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
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
                GDTATInitManager.getInstance().a();
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

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.h;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.d = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    public void setDismissType(int i) {
        this.mDismissType = i;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.k = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdInternalAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(4, GDTATSplashAdapter.class);
        map.put(3, GDTATInterstitialAdapter.class);
        return map;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.c = ATInitMediation.getStringFromMap(map, "app_id");
        this.d = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getStringFromMap(map, "payload");
        this.g = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        this.j = ATInitMediation.getIntFromMap(map, "unit_type", 1);
        this.i = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else {
            GDTATInitManager.getInstance().initSDK(context.getApplicationContext(), map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATRewardedVideoAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    GDTATRewardedVideoAdapter.a(GDTATRewardedVideoAdapter.this, context, map, map2);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    GDTATRewardedVideoAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    static /* synthetic */ void a(GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter, Context context, Map map, Map map2) {
        GDTATInitManager.getInstance().setExtraUserData(map2);
        if (gDTATRewardedVideoAdapter.j == 2) {
            if (!(context instanceof Activity)) {
                gDTATRewardedVideoAdapter.notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
                return;
            }
            AnonymousClass3 anonymousClass3 = gDTATRewardedVideoAdapter.new AnonymousClass3();
            if (TextUtils.isEmpty(gDTATRewardedVideoAdapter.e) || gDTATRewardedVideoAdapter.k) {
                gDTATRewardedVideoAdapter.b = new UnifiedInterstitialAD((Activity) context, gDTATRewardedVideoAdapter.d, anonymousClass3);
                GDTATInitManager.getInstance();
                gDTATRewardedVideoAdapter.b.setLoadAdParams(GDTATInitManager.a((Map<String, Object>) map));
            } else {
                gDTATRewardedVideoAdapter.b = new UnifiedInterstitialAD((Activity) context, gDTATRewardedVideoAdapter.d, anonymousClass3, null, gDTATRewardedVideoAdapter.e);
            }
            UnifiedInterstitialAD unifiedInterstitialAD = gDTATRewardedVideoAdapter.b;
            int i = map.containsKey("video_muted") ? Integer.parseInt(map.get("video_muted").toString()) : 0;
            int i2 = map.containsKey("video_autoplay") ? Integer.parseInt(map.get("video_autoplay").toString()) : 1;
            int i3 = map.containsKey("video_duration") ? Integer.parseInt(map.get("video_duration").toString()) : -1;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(i == 1).setDetailPageMuted(i == 1).setAutoPlayPolicy(i2).build());
                if (i3 != -1) {
                    unifiedInterstitialAD.setMaxVideoDuration(i3);
                }
            }
            ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
            if (!TextUtils.isEmpty(gDTATRewardedVideoAdapter.mUserId)) {
                builder.setUserId(gDTATRewardedVideoAdapter.mUserId);
            }
            if (!TextUtils.isEmpty(gDTATRewardedVideoAdapter.mUserData)) {
                builder.setCustomData(gDTATRewardedVideoAdapter.mUserData);
            }
            ServerSideVerificationOptions serverSideVerificationOptionsBuild = builder.build();
            if (serverSideVerificationOptionsBuild != null && ATSDK.isNetworkLogDebug()) {
                Log.i(f, "ServerSideVerificationOptions: userId:" + serverSideVerificationOptionsBuild.getUserId() + "||userCustomData:" + serverSideVerificationOptionsBuild.getCustomData());
            }
            gDTATRewardedVideoAdapter.b.setServerSideVerificationOptions(serverSideVerificationOptionsBuild);
            gDTATRewardedVideoAdapter.b.setMediaListener(gDTATRewardedVideoAdapter.new AnonymousClass4());
            gDTATRewardedVideoAdapter.b.loadFullScreenAD();
            return;
        }
        AnonymousClass2 anonymousClass2 = gDTATRewardedVideoAdapter.new AnonymousClass2();
        if (TextUtils.isEmpty(gDTATRewardedVideoAdapter.e) || gDTATRewardedVideoAdapter.k) {
            gDTATRewardedVideoAdapter.a = new RewardVideoAD(context.getApplicationContext(), gDTATRewardedVideoAdapter.d, anonymousClass2, gDTATRewardedVideoAdapter.g != 1);
            GDTATInitManager.getInstance();
            gDTATRewardedVideoAdapter.a.setLoadAdParams(GDTATInitManager.a((Map<String, Object>) map));
        } else {
            gDTATRewardedVideoAdapter.a = new RewardVideoAD(context.getApplicationContext(), gDTATRewardedVideoAdapter.d, anonymousClass2, gDTATRewardedVideoAdapter.g != 1, gDTATRewardedVideoAdapter.e);
        }
        try {
            ServerSideVerificationOptions.Builder builder2 = new ServerSideVerificationOptions.Builder();
            builder2.setUserId(gDTATRewardedVideoAdapter.mUserId);
            if (!TextUtils.isEmpty(gDTATRewardedVideoAdapter.mUserData) && gDTATRewardedVideoAdapter.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                gDTATRewardedVideoAdapter.mUserData = gDTATRewardedVideoAdapter.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, gDTATRewardedVideoAdapter.d);
            }
            builder2.setCustomData(gDTATRewardedVideoAdapter.mUserData);
            ServerSideVerificationOptions serverSideVerificationOptionsBuild2 = builder2.build();
            if (serverSideVerificationOptionsBuild2 != null && ATSDK.isNetworkLogDebug()) {
                Log.i(f, "ServerSideVerificationOptions: userId:" + serverSideVerificationOptionsBuild2.getUserId() + "||userCustomData:" + serverSideVerificationOptionsBuild2.getCustomData());
            }
            gDTATRewardedVideoAdapter.a.setServerSideVerificationOptions(serverSideVerificationOptionsBuild2);
        } catch (Throwable unused) {
        }
        gDTATRewardedVideoAdapter.a.loadAD();
    }
}
