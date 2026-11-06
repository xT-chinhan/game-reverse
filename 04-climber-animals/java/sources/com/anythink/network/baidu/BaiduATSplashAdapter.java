package com.anythink.network.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.d.j;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BaiduATSplashAdapter extends CustomSplashAdapter {
    SplashAd c;
    String d;
    private Map<String, Object> k;
    private final String i = "BaiduATSplashAdapter";
    String a = "";
    String b = "2";
    private double j = 0.0d;
    boolean e = false;
    boolean f = false;
    boolean g = false;
    boolean h = false;

    static /* synthetic */ int c(BaiduATSplashAdapter baiduATSplashAdapter) {
        baiduATSplashAdapter.mDismissType = 2;
        return 2;
    }

    static /* synthetic */ int f(BaiduATSplashAdapter baiduATSplashAdapter) {
        baiduATSplashAdapter.mDismissType = 99;
        return 99;
    }

    private void a(Context context, boolean z, Map<String, Object> map, Map<String, Object> map2) {
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.addExtra("timeout", String.valueOf(this.mFetchAdTimeout));
        builder.addExtra(SplashAd.KEY_DISPLAY_DOWNLOADINFO, "true");
        builder.addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, String.valueOf(z));
        int intFromMap = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_WIDTH, 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_HEIGHT, 0);
        if (intFromMap > 0 && intFromMap2 > 0) {
            builder.setWidth(a(context, intFromMap));
            builder.setHeight(a(context, intFromMap2));
        }
        BaiduATInitManager.getInstance();
        BaiduATInitManager.a(this.a, builder, map, map2);
        this.c = new SplashAd(context.getApplicationContext(), this.a, builder.build(), new AnonymousClass1());
        if (this.g && this.j > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATSplashAdapter", "setBidFloor:" + ((int) this.j));
            }
            this.c.setBidFloor((int) this.j);
        }
        this.c.setAppSid(BaiduATInitManager.getInstance().getApp_id());
        this.c.load();
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATSplashAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements SplashInteractionListener {
        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onLpClosed() {
        }

        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdDismissed() {
            if (BaiduATSplashAdapter.this.mImpressionListener != null) {
                BaiduATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdSkip() {
            BaiduATSplashAdapter.c(BaiduATSplashAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public final void onADLoaded() {
            if (BaiduATSplashAdapter.this.h) {
                BaiduATSplashAdapter.this.f = true;
            }
            BaiduATInitManager.getInstance();
            BaiduATInitManager.a(BaiduATSplashAdapter.this.g, BaiduATSplashAdapter.this.c, BaiduATSplashAdapter.this.mLoadListener, BaiduATSplashAdapter.this.mBiddingListener);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public final void onAdFailed(String str) {
            if (BaiduATSplashAdapter.this.f) {
                Log.e(BaiduATSplashAdapter.this.i, "onAdFailed: ".concat(String.valueOf(str)));
                BaiduATSplashAdapter.f(BaiduATSplashAdapter.this);
                if (BaiduATSplashAdapter.this.mImpressionListener != null) {
                    BaiduATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", str));
                    BaiduATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                    return;
                }
                return;
            }
            BaiduATSplashAdapter.this.notifyATLoadFail("", str, new BaiduATBiddingNotice(BaiduATSplashAdapter.this.c), ATAdConst.CURRENCY.RMB_CENT);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdPresent() {
            String unused = BaiduATSplashAdapter.this.i;
            if (!BaiduATSplashAdapter.this.b.equals("1") || BaiduATSplashAdapter.this.mImpressionListener == null) {
                return;
            }
            BaiduATSplashAdapter.this.mImpressionListener.onSplashAdShow();
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdExposed() {
            String unused = BaiduATSplashAdapter.this.i;
            if (!BaiduATSplashAdapter.this.b.equals("2") || BaiduATSplashAdapter.this.mImpressionListener == null) {
                return;
            }
            BaiduATSplashAdapter.this.mImpressionListener.onSplashAdShow();
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdClick() {
            if (BaiduATSplashAdapter.this.mImpressionListener != null) {
                BaiduATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdCacheSuccess() {
            BaiduATSplashAdapter.this.f = true;
            BaiduATSplashAdapter.p(BaiduATSplashAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdCacheFailed() {
            if (BaiduATSplashAdapter.this.f) {
                return;
            }
            BaiduATSplashAdapter.this.notifyATLoadFail("", "onAdCacheFailed");
        }
    }

    private void a() {
        double d;
        if (this.g) {
            if (this.mBiddingListener != null) {
                SplashAd splashAd = this.c;
                if (splashAd != null) {
                    String pecpm = splashAd.getPECPM();
                    if (this.k == null) {
                        this.k = new HashMap();
                    }
                    this.k.put(BaiduATConst.EN_P_KEY, pecpm);
                    String eCPMLevel = this.c.getECPMLevel();
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
                    ATBiddingResult aTBiddingResultSuccess = ATBiddingResult.success(d, new StringBuilder().append(System.currentTimeMillis()).toString(), new BaiduATBiddingNotice(this.c), ATAdConst.CURRENCY.RMB_CENT);
                    aTBiddingResultSuccess.setExtra(pecpm);
                    this.mBiddingListener.onC2SBiddingResultWithCache(aTBiddingResultSuccess, null);
                    return;
                }
                notifyATLoadFail("", "Baidu: SplashAd had been destroyed.");
                return;
            }
            return;
        }
        if (this.mLoadListener != null) {
            this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return BaiduATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        SplashAd splashAd = this.c;
        if (splashAd == null) {
            return false;
        }
        if (this.h && this.f) {
            return true;
        }
        return splashAd.isReady();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.f = false;
        this.d = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.b = ATInitMediation.getStringFromMap(map, j.w.K, "2");
        this.j = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        this.e = ATInitMediation.getBooleanFromMap(map, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS);
        this.h = ATInitMediation.getIntFromMap(map, "ad_s_reqf_mode") == 2;
        if (TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.a)) {
            notifyATLoadFail("", " app_id ,ad_place_id is empty.");
        } else {
            final Context applicationContext = context.getApplicationContext();
            BaiduATInitManager.getInstance().initSDK(applicationContext, map, new MediationInitCallback() { // from class: com.anythink.network.baidu.BaiduATSplashAdapter.2
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    BaiduATSplashAdapter baiduATSplashAdapter = BaiduATSplashAdapter.this;
                    BaiduATSplashAdapter.a(baiduATSplashAdapter, applicationContext, baiduATSplashAdapter.e, map, map2);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    if (BaiduATSplashAdapter.this.mLoadListener != null) {
                        BaiduATSplashAdapter.this.mLoadListener.onAdLoadError("", str);
                    }
                }
            });
        }
    }

    private void a(Map<String, Object> map) {
        this.d = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.b = ATInitMediation.getStringFromMap(map, j.w.K, "2");
        this.j = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        this.e = ATInitMediation.getBooleanFromMap(map, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS);
        this.h = ATInitMediation.getIntFromMap(map, "ad_s_reqf_mode") == 2;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        SplashAd splashAd = this.c;
        if (splashAd != null) {
            splashAd.destroy();
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.a;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return BaiduATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        this.f = false;
        SplashAd splashAd = this.c;
        if (splashAd != null) {
            splashAd.show(viewGroup);
            return;
        }
        this.mDismissType = 99;
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", "Baidu Splash show fail: mSplashAd = null"));
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.g = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdInternalAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, BaiduATAdapter.class);
        map.put(3, BaiduATInterstitialAdapter.class);
        return map;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.k;
    }

    public void setDismissType(int i) {
        this.mDismissType = i;
    }

    private static int a(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    static /* synthetic */ void p(BaiduATSplashAdapter baiduATSplashAdapter) {
        double d;
        if (baiduATSplashAdapter.g) {
            if (baiduATSplashAdapter.mBiddingListener != null) {
                SplashAd splashAd = baiduATSplashAdapter.c;
                if (splashAd != null) {
                    String pecpm = splashAd.getPECPM();
                    if (baiduATSplashAdapter.k == null) {
                        baiduATSplashAdapter.k = new HashMap();
                    }
                    baiduATSplashAdapter.k.put(BaiduATConst.EN_P_KEY, pecpm);
                    String eCPMLevel = baiduATSplashAdapter.c.getECPMLevel();
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
                        baiduATSplashAdapter.notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(String.valueOf(d)));
                        return;
                    }
                    ATBiddingResult aTBiddingResultSuccess = ATBiddingResult.success(d, new StringBuilder().append(System.currentTimeMillis()).toString(), new BaiduATBiddingNotice(baiduATSplashAdapter.c), ATAdConst.CURRENCY.RMB_CENT);
                    aTBiddingResultSuccess.setExtra(pecpm);
                    baiduATSplashAdapter.mBiddingListener.onC2SBiddingResultWithCache(aTBiddingResultSuccess, null);
                    return;
                }
                baiduATSplashAdapter.notifyATLoadFail("", "Baidu: SplashAd had been destroyed.");
                return;
            }
            return;
        }
        if (baiduATSplashAdapter.mLoadListener != null) {
            baiduATSplashAdapter.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
        }
    }

    static /* synthetic */ void a(BaiduATSplashAdapter baiduATSplashAdapter, Context context, boolean z, Map map, Map map2) {
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.addExtra("timeout", String.valueOf(baiduATSplashAdapter.mFetchAdTimeout));
        builder.addExtra(SplashAd.KEY_DISPLAY_DOWNLOADINFO, "true");
        builder.addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, String.valueOf(z));
        int intFromMap = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_WIDTH, 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_HEIGHT, 0);
        if (intFromMap > 0 && intFromMap2 > 0) {
            builder.setWidth(a(context, intFromMap));
            builder.setHeight(a(context, intFromMap2));
        }
        BaiduATInitManager.getInstance();
        BaiduATInitManager.a(baiduATSplashAdapter.a, builder, (Map<String, Object>) map, (Map<String, Object>) map2);
        baiduATSplashAdapter.c = new SplashAd(context.getApplicationContext(), baiduATSplashAdapter.a, builder.build(), baiduATSplashAdapter.new AnonymousClass1());
        if (baiduATSplashAdapter.g && baiduATSplashAdapter.j > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATSplashAdapter", "setBidFloor:" + ((int) baiduATSplashAdapter.j));
            }
            baiduATSplashAdapter.c.setBidFloor((int) baiduATSplashAdapter.j);
        }
        baiduATSplashAdapter.c.setAppSid(BaiduATInitManager.getInstance().getApp_id());
        baiduATSplashAdapter.c.load();
    }
}
