package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.splashad.api.ATSplashEyeAdListener;
import com.anythink.splashad.api.IATSplashEyeAd;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADZoomOutListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GDTATSplashAdapter extends CustomSplashAdapter implements SplashADZoomOutListener {
    boolean b;
    GDTATSplashEyeAd c;
    ViewGroup d;
    String e;
    private String g;
    private String h;
    private boolean i;
    private SplashAD j;
    private boolean k;
    private Map<String, Object> m;
    final String a = "GDTATSplashAdapter";
    private boolean l = false;
    boolean f = false;

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j) {
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public void onZoomOutPlayFinish() {
    }

    static /* synthetic */ int c(GDTATSplashAdapter gDTATSplashAdapter) {
        gDTATSplashAdapter.mDismissType = 99;
        return 99;
    }

    static /* synthetic */ int g(GDTATSplashAdapter gDTATSplashAdapter) {
        gDTATSplashAdapter.mDismissType = 99;
        return 99;
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        GDTATInitManager.getInstance().setExtraUserData(map2);
        if (TextUtils.isEmpty(this.e) || this.f) {
            this.j = new SplashAD(context, this.h, this, this.mFetchAdTimeout);
            GDTATInitManager.getInstance();
            this.j.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.j = new SplashAD(context, this.h, this, this.mFetchAdTimeout, this.e);
        }
        this.j.fetchAdOnly();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        return this.i;
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.g = ATInitMediation.getStringFromMap(map, "app_id");
        this.h = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getStringFromMap(map, "payload");
        this.i = false;
        this.k = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (map.containsKey("zoomoutad_sw")) {
            this.l = TextUtils.equals("2", ATInitMediation.getStringFromMap(map, "zoomoutad_sw"));
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, final ViewGroup viewGroup) {
        if (viewGroup == null) {
            if (this.mImpressionListener != null) {
                this.mDismissType = 99;
                this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", "Container is null"));
                this.mImpressionListener.onSplashAdDismiss();
                return;
            }
            return;
        }
        if (!this.i || this.j == null) {
            return;
        }
        if (this.l) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            this.d = frameLayout;
            viewGroup.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            this.d.post(new Runnable() { // from class: com.anythink.network.gdt.GDTATSplashAdapter.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (GDTATSplashAdapter.this.j == null || GDTATSplashAdapter.this.d == null) {
                            return;
                        }
                        GDTATSplashAdapter.this.j.showAd(GDTATSplashAdapter.this.d);
                    } catch (Throwable unused) {
                        if (GDTATSplashAdapter.this.mImpressionListener != null) {
                            GDTATSplashAdapter.c(GDTATSplashAdapter.this);
                            GDTATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", "GDT Splash show with exception"));
                            GDTATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                        }
                    }
                }
            });
            return;
        }
        viewGroup.post(new Runnable() { // from class: com.anythink.network.gdt.GDTATSplashAdapter.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (GDTATSplashAdapter.this.j == null || viewGroup == null) {
                        return;
                    }
                    GDTATSplashAdapter.this.j.showAd(viewGroup);
                } catch (Throwable unused) {
                    if (GDTATSplashAdapter.this.mImpressionListener != null) {
                        GDTATSplashAdapter.g(GDTATSplashAdapter.this);
                        GDTATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", "GDT Splash show with exception"));
                        GDTATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                    }
                }
            }
        });
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        this.j = null;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.h;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        ATSplashEyeAdListener splashEyeAdListener;
        if (this.l && this.b) {
            GDTATSplashEyeAd gDTATSplashEyeAd = this.c;
            if (gDTATSplashEyeAd == null || (splashEyeAdListener = gDTATSplashEyeAd.getSplashEyeAdListener()) == null) {
                return;
            }
            splashEyeAdListener.onAdDismiss(true, "");
            return;
        }
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(AdError adError) {
        if (adError != null) {
            notifyATLoadFail(new StringBuilder().append(adError.getErrorCode()).toString(), adError.getErrorMsg());
            if (this.mImpressionListener != null) {
                Log.e(this.a, "GDT Splash show fail:[errorCode:" + adError.getErrorCode() + ",errorMsg:" + adError.getErrorMsg() + "]");
                this.mDismissType = 99;
                this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, new StringBuilder().append(adError.getErrorCode()).toString(), adError.getErrorMsg()));
                this.mImpressionListener.onSplashAdDismiss();
                return;
            }
            return;
        }
        notifyATLoadFail("", "GDT Splash show fail");
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", "GDT Splash show fail"));
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdClicked();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
        try {
            GDTATInitManager.getInstance().a(getTrackingInfo().z(), new WeakReference(this.j));
        } catch (Throwable unused) {
        }
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdShow();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADLoaded(long j) {
        this.i = true;
        SplashAD splashAD = this.j;
        if (splashAD != null && this.k) {
            splashAD.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATSplashAdapter.4
                @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                public final void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                    if (GDTATSplashAdapter.this.mImpressionListener != null) {
                        GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                        gDTDownloadFirmInfo.appInfoUrl = str;
                        gDTDownloadFirmInfo.scenes = i;
                        gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                        GDTATSplashAdapter.this.mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                    }
                }
            });
        }
        SplashAD splashAD2 = this.j;
        if (splashAD2 != null) {
            try {
                Map<String, Object> extraInfo = splashAD2.getExtraInfo();
                if (extraInfo != null) {
                    if (this.m == null) {
                        this.m = new HashMap();
                    }
                    this.m.putAll(extraInfo);
                }
            } catch (Throwable unused) {
            }
        }
        if (this.f) {
            if (this.mBiddingListener != null) {
                SplashAD splashAD3 = this.j;
                if (splashAD3 != null) {
                    this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(splashAD3.getECPM(), new StringBuilder().append(System.currentTimeMillis()).toString(), new GDTATBiddingNotice(this.j), ATAdConst.CURRENCY.RMB_CENT), null);
                    return;
                }
                notifyATLoadFail("", "GDT: SplashAD had been destroy.");
                return;
            }
            return;
        }
        if (this.mLoadListener != null) {
            this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public IATSplashEyeAd getSplashEyeAd() {
        return this.c;
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public void onZoomOut() {
        this.b = true;
        if (this.l) {
            GDTATSplashEyeAd gDTATSplashEyeAd = new GDTATSplashEyeAd(this, this.j);
            this.c = gDTATSplashEyeAd;
            gDTATSplashEyeAd.setSplashView(this.d);
            if (this.mImpressionListener != null) {
                this.mImpressionListener.onSplashAdDismiss();
            }
        }
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public boolean isSupportZoomOut() {
        return this.l;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.h = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdInternalAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, GDTATAdapter.class);
        map.put(3, GDTATInterstitialAdapter.class);
        return map;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.m;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.g = ATInitMediation.getStringFromMap(map, "app_id");
        this.h = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getStringFromMap(map, "payload");
        this.i = false;
        this.k = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (map.containsKey("zoomoutad_sw")) {
            this.l = TextUtils.equals("2", ATInitMediation.getStringFromMap(map, "zoomoutad_sw"));
        }
        if (TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.h)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else {
            final Context applicationContext = context.getApplicationContext();
            GDTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATSplashAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    GDTATSplashAdapter.a(GDTATSplashAdapter.this, applicationContext, map, map2);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    GDTATSplashAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    static /* synthetic */ void a(GDTATSplashAdapter gDTATSplashAdapter, Context context, Map map, Map map2) {
        GDTATInitManager.getInstance().setExtraUserData(map2);
        if (TextUtils.isEmpty(gDTATSplashAdapter.e) || gDTATSplashAdapter.f) {
            gDTATSplashAdapter.j = new SplashAD(context, gDTATSplashAdapter.h, gDTATSplashAdapter, gDTATSplashAdapter.mFetchAdTimeout);
            GDTATInitManager.getInstance();
            gDTATSplashAdapter.j.setLoadAdParams(GDTATInitManager.a((Map<String, Object>) map));
        } else {
            gDTATSplashAdapter.j = new SplashAD(context, gDTATSplashAdapter.h, gDTATSplashAdapter, gDTATSplashAdapter.mFetchAdTimeout, gDTATSplashAdapter.e);
        }
        gDTATSplashAdapter.j.fetchAdOnly();
    }
}
