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
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GDTATInterstitialAdapter extends CustomInterstitialAdapter implements UnifiedInterstitialMediaListener {
    public static String TAG = "GDTATInterstitialAdapter";
    UnifiedInterstitialAD a;
    String b;
    String c;
    String d;
    String f;
    boolean g;
    boolean h;
    private Map<String, Object> i;
    int e = 0;
    private boolean j = false;

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

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.j = false;
        this.f = ATInitMediation.getStringFromMap(map, "is_fullscreen", "0");
        this.g = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        GDTATInitManager.getInstance().setExtraUserData(map2);
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        if (TextUtils.isEmpty(this.d) || this.h) {
            this.a = new UnifiedInterstitialAD((Activity) context, this.c, anonymousClass1);
            GDTATInitManager.getInstance();
            this.a.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.a = new UnifiedInterstitialAD((Activity) context, this.c, anonymousClass1, null, this.d);
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.a != null) {
            this.a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1).setDetailPageMuted(intFromMap == 1).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (TextUtils.equals("1", this.f)) {
            this.a.loadFullScreenAD();
        } else {
            this.a.loadAD();
        }
    }

    private void a(Context context, Map<String, Object> map) {
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        if (TextUtils.isEmpty(this.d) || this.h) {
            this.a = new UnifiedInterstitialAD((Activity) context, this.c, anonymousClass1);
            GDTATInitManager.getInstance();
            this.a.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.a = new UnifiedInterstitialAD((Activity) context, this.c, anonymousClass1, null, this.d);
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.a != null) {
            this.a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1).setDetailPageMuted(intFromMap == 1).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (TextUtils.equals("1", this.f)) {
            this.a.loadFullScreenAD();
        } else {
            this.a.loadAD();
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATInterstitialAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements UnifiedInterstitialADListener {
        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onVideoCached() {
        }

        AnonymousClass1() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADReceive() {
            if (GDTATInterstitialAdapter.this.a != null && GDTATInterstitialAdapter.this.g) {
                GDTATInterstitialAdapter.this.a.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATInterstitialAdapter.1.1
                    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                    public final void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                        if (GDTATInterstitialAdapter.this.mImpressListener != null) {
                            GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                            gDTDownloadFirmInfo.appInfoUrl = str;
                            gDTDownloadFirmInfo.scenes = i;
                            gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                            GDTATInterstitialAdapter.this.mImpressListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                        }
                    }
                });
            }
            if (!GDTATInterstitialAdapter.this.h) {
                if (GDTATInterstitialAdapter.this.mLoadListener instanceof ATCustomLoadListenerExt) {
                    ((ATCustomLoadListenerExt) GDTATInterstitialAdapter.this.mLoadListener).onAdDataLoadedWithAds(new BaseAd[0]);
                }
            } else {
                if (!(GDTATInterstitialAdapter.this.mBiddingListener instanceof ATBiddingListenerExt) || GDTATInterstitialAdapter.this.a == null) {
                    return;
                }
                ((ATBiddingListenerExt) GDTATInterstitialAdapter.this.mBiddingListener).onC2SBiddingResultWithData(ATBiddingResult.success(GDTATInterstitialAdapter.this.a.getECPM(), new StringBuilder().append(System.currentTimeMillis()).toString(), new GDTATBiddingNotice(GDTATInterstitialAdapter.this.a), ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onNoAD(AdError adError) {
            GDTATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADExposure() {
            String str = GDTATInterstitialAdapter.TAG;
            try {
                GDTATInitManager.getInstance().a(GDTATInterstitialAdapter.this.getTrackingInfo().z(), new WeakReference(GDTATInterstitialAdapter.this.a));
            } catch (Throwable unused) {
            }
            if (GDTATInterstitialAdapter.this.mImpressListener != null) {
                GDTATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClicked() {
            String str = GDTATInterstitialAdapter.TAG;
            if (GDTATInterstitialAdapter.this.mImpressListener != null) {
                GDTATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClosed() {
            String str = GDTATInterstitialAdapter.TAG;
            GDTATInitManager.getInstance().b();
            GDTATInterstitialAdapter.this.a();
            if (GDTATInterstitialAdapter.this.a != null) {
                GDTATInterstitialAdapter.this.a.destroy();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderSuccess() {
            if (GDTATInterstitialAdapter.this.a != null) {
                try {
                    Map<String, Object> extraInfo = GDTATInterstitialAdapter.this.a.getExtraInfo();
                    if (extraInfo != null) {
                        if (GDTATInterstitialAdapter.this.i == null) {
                            GDTATInterstitialAdapter.this.i = new HashMap();
                        }
                        GDTATInterstitialAdapter.this.i.putAll(extraInfo);
                    }
                } catch (Throwable unused) {
                }
                if (!GDTATInterstitialAdapter.this.h) {
                    if (GDTATInterstitialAdapter.this.mLoadListener != null) {
                        GDTATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                        return;
                    }
                    return;
                } else {
                    if (GDTATInterstitialAdapter.this.mBiddingListener != null) {
                        GDTATInterstitialAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(GDTATInterstitialAdapter.this.a.getECPM(), new StringBuilder().append(System.currentTimeMillis()).toString(), new GDTATBiddingNotice(GDTATInterstitialAdapter.this.a), ATAdConst.CURRENCY.RMB_CENT), null);
                        return;
                    }
                    return;
                }
            }
            GDTATInterstitialAdapter.this.notifyATLoadFail("", "onRenderSuccess mUnifiedInterstitialAd is null");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderFail() {
            GDTATInterstitialAdapter.this.notifyATLoadFail("", "GDT: onRenderFail()");
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.a;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.isValid();
        }
        return false;
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.a;
        if (unifiedInterstitialAD != null) {
            this.j = false;
            unifiedInterstitialAD.setMediaListener(this);
            if (TextUtils.equals("1", this.f)) {
                if (activity != null) {
                    GDTATInitManager.getInstance().a(this.c, this.a);
                    this.a.showFullScreenAD(activity);
                    return;
                } else {
                    Log.e(TAG, "Gdt (Full Screen) show fail: context need be Activity");
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

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    private void a(Map<String, Object> map) {
        this.b = ATInitMediation.getStringFromMap(map, "app_id");
        this.c = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.d = ATInitMediation.getStringFromMap(map, "payload");
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(null);
            this.a.destroy();
            this.a = null;
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.c;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    private void b(Map<String, Object> map) {
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.a != null) {
            this.a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1).setDetailPageMuted(intFromMap == 1).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.a.setMaxVideoDuration(intFromMap3);
            }
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoStart() {
        if (this.mImpressListener != null) {
            this.mImpressListener.onInterstitialAdVideoStart();
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoComplete() {
        if (this.mImpressListener != null) {
            this.mImpressListener.onInterstitialAdVideoEnd();
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoError(AdError adError) {
        GDTATInitManager.getInstance().b();
        if (this.mImpressListener != null) {
            this.mImpressListener.onInterstitialAdVideoError(new StringBuilder().append(adError.getErrorCode()).toString(), adError.getErrorMsg());
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.c = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
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
        map.put(0, GDTATAdapter.class);
        map.put(4, GDTATSplashAdapter.class);
        return map;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.j) {
            return;
        }
        this.j = true;
        if (this.mImpressListener != null) {
            this.mImpressListener.onInterstitialAdClose();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String closeAd() {
        try {
            UnifiedInterstitialAD unifiedInterstitialAD = this.a;
            if (unifiedInterstitialAD == null) {
                return "mUnifiedInterstitialAd is null";
            }
            unifiedInterstitialAD.close();
            a();
            return "";
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.b = ATInitMediation.getStringFromMap(map, "app_id");
        this.c = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.d = ATInitMediation.getStringFromMap(map, "payload");
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) {
            notifyATLoadFail("", "GDT appid or unitId is empty.");
        } else {
            GDTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATInterstitialAdapter.2
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    GDTATInterstitialAdapter.a(GDTATInterstitialAdapter.this, context, map, map2);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    GDTATInterstitialAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    static /* synthetic */ void a(GDTATInterstitialAdapter gDTATInterstitialAdapter, Context context, Map map, Map map2) {
        gDTATInterstitialAdapter.j = false;
        gDTATInterstitialAdapter.f = ATInitMediation.getStringFromMap(map, "is_fullscreen", "0");
        gDTATInterstitialAdapter.g = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        GDTATInitManager.getInstance().setExtraUserData(map2);
        if (!(context instanceof Activity)) {
            gDTATInterstitialAdapter.notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        AnonymousClass1 anonymousClass1 = gDTATInterstitialAdapter.new AnonymousClass1();
        if (TextUtils.isEmpty(gDTATInterstitialAdapter.d) || gDTATInterstitialAdapter.h) {
            gDTATInterstitialAdapter.a = new UnifiedInterstitialAD((Activity) context, gDTATInterstitialAdapter.c, anonymousClass1);
            GDTATInitManager.getInstance();
            gDTATInterstitialAdapter.a.setLoadAdParams(GDTATInitManager.a((Map<String, Object>) map));
        } else {
            gDTATInterstitialAdapter.a = new UnifiedInterstitialAD((Activity) context, gDTATInterstitialAdapter.c, anonymousClass1, null, gDTATInterstitialAdapter.d);
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (gDTATInterstitialAdapter.a != null) {
            gDTATInterstitialAdapter.a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1).setDetailPageMuted(intFromMap == 1).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                gDTATInterstitialAdapter.a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (TextUtils.equals("1", gDTATInterstitialAdapter.f)) {
            gDTATInterstitialAdapter.a.loadFullScreenAD();
        } else {
            gDTATInterstitialAdapter.a.loadAD();
        }
    }
}
