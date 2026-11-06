package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEventListener;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GDTATSplashAdapter extends CustomSplashAdapter implements SplashADListener {
    private String b;
    private String c;
    private boolean d;
    private SplashAD e;
    private boolean f;
    String g;
    private Map<String, Object> i;
    final String a = "GDTATSplashAdapter";
    boolean h = false;

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
            GDTATSplashAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            GDTATSplashAdapter.this.a(this.a, this.b, this.c);
        }
    }

    class b implements Runnable {
        final /* synthetic */ ViewGroup a;

        b(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (GDTATSplashAdapter.this.e == null || this.a == null) {
                    return;
                }
                GDTATSplashAdapter.this.e.showAd(this.a);
            } catch (Throwable unused) {
                if (((CustomSplashAdapter) GDTATSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) GDTATSplashAdapter.this).mDismissType = 99;
                    ((CustomSplashAdapter) GDTATSplashAdapter.this).mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", "GDT Splash show with exception"));
                    ((CustomSplashAdapter) GDTATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
                }
            }
        }
    }

    class c implements DownloadConfirmListener {
        c() {
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmListener
        public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
            if (((CustomSplashAdapter) GDTATSplashAdapter.this).mImpressionListener != null) {
                GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                gDTDownloadFirmInfo.appInfoUrl = str;
                gDTDownloadFirmInfo.scenes = i;
                gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                ((CustomSplashAdapter) GDTATSplashAdapter.this).mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
            }
        }
    }

    class d implements ADRewardListener {
        d() {
        }

        @Override // com.qq.e.comm.listeners.ADRewardListener
        public void onReward(Map<String, Object> map) {
            String str = GDTATSplashAdapter.this.a;
            new StringBuilder("onReward: ").append(map);
            if (GDTATSplashAdapter.this.i == null) {
                GDTATSplashAdapter.this.i = new HashMap();
            }
            GDTATSplashAdapter.this.i.put(ATAdConst.REWARD_EXTRA.REWARD_INFO, map);
            try {
                if (((CustomSplashAdapter) GDTATSplashAdapter.this).mImpressionListener != null) {
                    ((CustomSplashAdapter) GDTATSplashAdapter.this).mImpressionListener.onSplashAdReward();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return GDTATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        this.e = null;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.c = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdInternalAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, GDTATAdapter.class);
        map.put(3, GDTATInterstitialAdapter.class);
        return map;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter
    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.i;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.c;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean isAdReady() {
        return this.d;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(map, map2);
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else {
            GDTATInitManager.getInstance().initSDK(context, map, new a(context.getApplicationContext(), map, map2));
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdClicked();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdDismiss();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
        try {
            GDTATInitManager.getInstance().a(getShowId(), new WeakReference(this.e));
        } catch (Throwable unused) {
        }
        CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdShow();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADLoaded(long j) {
        this.d = true;
        SplashAD splashAD = this.e;
        if (splashAD != null && this.f) {
            splashAD.setDownloadConfirmListener(new c());
        }
        SplashAD splashAD2 = this.e;
        if (splashAD2 != null) {
            this.i = GDTATInitManager.getInstance().a(splashAD2.getExtraInfo(), this.i);
        }
        try {
            SplashAD splashAD3 = this.e;
            if (splashAD3 != null) {
                splashAD3.setRewardListener(new d());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!this.h) {
            ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(new BaseAd[0]);
                return;
            }
            return;
        }
        if (this.mBiddingListener != null) {
            SplashAD splashAD4 = this.e;
            if (splashAD4 == null) {
                notifyATLoadFail("", "GDT: SplashAD had been destroy.");
                return;
            }
            this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(splashAD4.getECPM(), System.currentTimeMillis() + "", new GDTATBiddingNotice(this.e), ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j) {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(AdError adError) {
        if (adError == null) {
            notifyATLoadFail("", "GDT Splash show fail");
            CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
            if (customSplashEventListener != null) {
                customSplashEventListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", "GDT Splash show fail"));
                this.mImpressionListener.onSplashAdDismiss();
                return;
            }
            return;
        }
        notifyATLoadFail(adError.getErrorCode() + "", adError.getErrorMsg());
        if (this.mImpressionListener != null) {
            Log.e(this.a, "GDT Splash show fail:[errorCode:" + adError.getErrorCode() + ",errorMsg:" + adError.getErrorMsg() + "]");
            this.mDismissType = 99;
            this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "" + adError.getErrorCode(), adError.getErrorMsg()));
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (!this.d || this.e == null) {
                return;
            }
            viewGroup.post(new b(viewGroup));
            return;
        }
        CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            this.mDismissType = 99;
            customSplashEventListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", "Container is null"));
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        GDTATInitManager.getInstance().setExtraUserData(map2);
        if (!TextUtils.isEmpty(this.g) && !this.h) {
            this.e = new SplashAD(context, this.c, this, this.mFetchAdTimeout, this.g);
        } else {
            this.e = new SplashAD(context, this.c, this, this.mFetchAdTimeout);
            LoadAdParams loadAdParamsA = GDTATInitManager.getInstance().a(map);
            if (loadAdParamsA != null) {
                this.e.setLoadAdParams(loadAdParamsA);
            }
        }
        this.e.fetchAdOnly();
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.b = ATInitMediation.getStringFromMap(map, "app_id");
        this.c = ATInitMediation.getStringFromMap(map, "unit_id");
        this.g = ATInitMediation.getStringFromMap(map, "payload");
        this.d = false;
        this.f = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
    }
}
