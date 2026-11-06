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
import com.anythink.core.common.d.j;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BaiduATInterstitialAdapter extends CustomInterstitialAdapter {
    private static final String i = "BaiduATInterstitialAdapter";
    FullScreenVideoAd a;
    ExpressInterstitialAd b;
    FullScreenVideoAd.FullScreenVideoAdListener c;
    private Map<String, Object> o;
    private WeakReference<Activity> p;
    private String j = "";
    private String k = "";
    private String l = "";
    private String m = "";
    private double n = 0.0d;
    boolean d = false;
    boolean e = false;
    boolean f = false;
    boolean g = false;
    boolean h = false;

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    protected boolean isSupportAdCarousel() {
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onPause(Activity activity) {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onResume(Activity activity) {
    }

    static /* synthetic */ int j(BaiduATInterstitialAdapter baiduATInterstitialAdapter) {
        baiduATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0026  */
    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        byte b;
        this.h = false;
        String str = this.m;
        int iHashCode = str.hashCode();
        if (iHashCode != 49) {
            if (iHashCode == 50 && str.equals("2")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("1")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            this.c = new AnonymousClass1();
            this.a = new FullScreenVideoAd(context, this.k, this.c, false);
            if (this.e && this.n > 0.0d) {
                if (ATSDK.isNetworkLogDebug()) {
                    Log.i("BaiduATInterstitial", "setBidFloor:" + ((int) this.n));
                }
                this.a.setBidFloor((int) this.n);
            }
            RequestParameters.Builder builder = new RequestParameters.Builder();
            BaiduATInitManager.getInstance();
            BaiduATInitManager.a(this.k, builder, map, map2);
            this.a.setRequestParameters(builder.build());
            this.a.setAppSid(BaiduATInitManager.getInstance().getApp_id());
            this.a.load();
            return;
        }
        this.b = new ExpressInterstitialAd(context.getApplicationContext(), this.k);
        if (this.e && this.n > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATInterstitial", "setBidFloor:" + ((int) this.n));
            }
            this.b.setBidFloor((int) this.n);
        }
        this.b.setLoadListener(new AnonymousClass2());
        this.b.setDownloadListener(new AnonymousClass3());
        this.b.setDialogFrame(this.d);
        RequestParameters.Builder builder2 = new RequestParameters.Builder();
        BaiduATInitManager.getInstance();
        BaiduATInitManager.a(this.k, builder2, map, map2);
        this.b.setRequestParameters(builder2.build());
        this.b.setAppSid(BaiduATInitManager.getInstance().getApp_id());
        this.b.load();
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements FullScreenVideoAd.FullScreenVideoAdListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdShow() {
            String unused = BaiduATInterstitialAdapter.i;
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClick() {
            String unused = BaiduATInterstitialAdapter.i;
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClose(float f) {
            String unused = BaiduATInterstitialAdapter.i;
            BaiduATInterstitialAdapter.this.d();
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdFailed(String str) {
            String unused = BaiduATInterstitialAdapter.i;
            BaiduATInterstitialAdapter.this.notifyATLoadFail("", "Baidu: ".concat(String.valueOf(str)), new BaiduATBiddingNotice(BaiduATInterstitialAdapter.this.a), ATAdConst.CURRENCY.RMB_CENT);
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadSuccess() {
            String unused = BaiduATInterstitialAdapter.i;
            BaiduATInterstitialAdapter.g(BaiduATInterstitialAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadFailed() {
            String unused = BaiduATInterstitialAdapter.i;
            BaiduATInterstitialAdapter.this.notifyATLoadFail("", "Baidu: onVideoDownloadFailed");
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void playCompletion() {
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdSkip(float f) {
            BaiduATInterstitialAdapter.j(BaiduATInterstitialAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdLoaded() {
            if (BaiduATInterstitialAdapter.this.g) {
                BaiduATInterstitialAdapter.this.f = true;
            }
            BaiduATInitManager.getInstance();
            BaiduATInitManager.a(BaiduATInterstitialAdapter.this.e, BaiduATInterstitialAdapter.this.a, BaiduATInterstitialAdapter.this.mLoadListener, BaiduATInterstitialAdapter.this.mBiddingListener);
        }
    }

    private void b(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.c = new AnonymousClass1();
        this.a = new FullScreenVideoAd(context, this.k, this.c, false);
        if (this.e && this.n > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATInterstitial", "setBidFloor:" + ((int) this.n));
            }
            this.a.setBidFloor((int) this.n);
        }
        RequestParameters.Builder builder = new RequestParameters.Builder();
        BaiduATInitManager.getInstance();
        BaiduATInitManager.a(this.k, builder, map, map2);
        this.a.setRequestParameters(builder.build());
        this.a.setAppSid(BaiduATInitManager.getInstance().getApp_id());
        this.a.load();
    }

    private void b() {
        double d;
        if (this.e) {
            if (this.mBiddingListener != null) {
                FullScreenVideoAd fullScreenVideoAd = this.a;
                if (fullScreenVideoAd != null) {
                    String pecpm = fullScreenVideoAd.getPECPM();
                    if (this.o == null) {
                        this.o = new HashMap();
                    }
                    this.o.put(BaiduATConst.EN_P_KEY, pecpm);
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
                    if (this.mBiddingListener != null) {
                        if (d <= 0.0d) {
                            notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(String.valueOf(d)));
                            return;
                        }
                        ATBiddingResult aTBiddingResultSuccess = ATBiddingResult.success(d, new StringBuilder().append(System.currentTimeMillis()).toString(), new BaiduATBiddingNotice(this.a), ATAdConst.CURRENCY.RMB_CENT);
                        aTBiddingResultSuccess.setExtra(pecpm);
                        this.mBiddingListener.onC2SBiddingResultWithCache(aTBiddingResultSuccess, null);
                        return;
                    }
                    return;
                }
                notifyATLoadFail("", "Baidu: FullScreenVideoAd had been destroyed.");
                return;
            }
            return;
        }
        if (this.mLoadListener != null) {
            this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
        }
    }

    private void c(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.b = new ExpressInterstitialAd(context, this.k);
        if (this.e && this.n > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATInterstitial", "setBidFloor:" + ((int) this.n));
            }
            this.b.setBidFloor((int) this.n);
        }
        this.b.setLoadListener(new AnonymousClass2());
        this.b.setDownloadListener(new AnonymousClass3());
        this.b.setDialogFrame(this.d);
        RequestParameters.Builder builder = new RequestParameters.Builder();
        BaiduATInitManager.getInstance();
        BaiduATInitManager.a(this.k, builder, map, map2);
        this.b.setRequestParameters(builder.build());
        this.b.setAppSid(BaiduATInitManager.getInstance().getApp_id());
        this.b.load();
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements ExpressInterstitialListener {
        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onLpClosed() {
        }

        public final void onVideoDownloadFailed() {
        }

        public final void onVideoDownloadSuccess() {
        }

        AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onADLoaded() {
            Log.e(BaiduATInterstitialAdapter.i, "onADLoaded:  isReady = " + BaiduATInterstitialAdapter.this.b.isReady() + BaiduATInterstitialAdapter.this.k);
            if (BaiduATInterstitialAdapter.this.g) {
                BaiduATInterstitialAdapter.this.f = true;
            }
            BaiduATInitManager.getInstance();
            BaiduATInitManager.a(BaiduATInterstitialAdapter.this.e, BaiduATInterstitialAdapter.this.b, BaiduATInterstitialAdapter.this.mLoadListener, BaiduATInterstitialAdapter.this.mBiddingListener);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdClick() {
            String unused = BaiduATInterstitialAdapter.i;
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdClose() {
            String unused = BaiduATInterstitialAdapter.i;
            BaiduATInterstitialAdapter.this.d();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdFailed(int i, String str) {
            BaiduATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i), str, new BaiduATBiddingNotice(BaiduATInterstitialAdapter.this.b), ATAdConst.CURRENCY.RMB_CENT);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onNoAd(int i, String str) {
            BaiduATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i), "onNoAd:".concat(String.valueOf(str)), new BaiduATBiddingNotice(BaiduATInterstitialAdapter.this.b), ATAdConst.CURRENCY.RMB_CENT);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onADExposed() {
            String unused = BaiduATInterstitialAdapter.i;
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onADExposureFailed() {
            String unused = BaiduATInterstitialAdapter.i;
            if (BaiduATInterstitialAdapter.this.mImpressListener != null) {
                BaiduATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError("", "Baidu: onADExposureFailed()");
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdCacheSuccess() {
            BaiduATInterstitialAdapter.t(BaiduATInterstitialAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdCacheFailed() {
            BaiduATInterstitialAdapter.this.notifyATLoadFail("", "Baidu: onAdCacheFailed");
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements ExpressInterstitialAd.InterAdDownloadWindowListener {
        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void adDownloadWindowClose() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void adDownloadWindowShow() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPermissionClose() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPermissionShow() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPrivacyClick() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPrivacyClose() {
        }

        AnonymousClass3() {
        }
    }

    private void c() {
        double d;
        if (this.e) {
            if (this.mBiddingListener != null) {
                ExpressInterstitialAd expressInterstitialAd = this.b;
                if (expressInterstitialAd != null) {
                    String pecpm = expressInterstitialAd.getPECPM();
                    if (this.o == null) {
                        this.o = new HashMap();
                    }
                    this.o.put(BaiduATConst.EN_P_KEY, pecpm);
                    String eCPMLevel = this.b.getECPMLevel();
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
                    ATBiddingResult aTBiddingResultSuccess = ATBiddingResult.success(d, new StringBuilder().append(System.currentTimeMillis()).toString(), new BaiduATBiddingNotice(this.b), ATAdConst.CURRENCY.RMB_CENT);
                    aTBiddingResultSuccess.setExtra(pecpm);
                    this.mBiddingListener.onC2SBiddingResultWithCache(aTBiddingResultSuccess, null);
                    return;
                }
                notifyATLoadFail("", "Baidu: ExpressInterstitialAd had been destroyed.");
                return;
            }
            return;
        }
        if (this.mLoadListener != null) {
            this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
        }
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.j = ATInitMediation.getStringFromMap(map, "app_id");
        this.k = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.m = ATInitMediation.getStringFromMap(map, "unit_type");
        try {
            if (map.containsKey("bid_floor")) {
                this.n = Double.parseDouble(map.get("bid_floor").toString());
            }
        } catch (Throwable unused) {
        }
        if (map2 != null) {
            try {
                if (map2.containsKey(ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS)) {
                    this.d = Boolean.parseBoolean(map2.get(ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS).toString());
                }
            } catch (Exception unused2) {
            }
        }
        this.l = ATInitMediation.getStringFromMap(map, "payload");
        this.g = ATInitMediation.getIntFromMap(map, "ad_s_reqf_mode") == 2;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0025  */
    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        byte b;
        String str = this.m;
        int iHashCode = str.hashCode();
        if (iHashCode != 49) {
            if (iHashCode == 50 && str.equals("2")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("1")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            FullScreenVideoAd fullScreenVideoAd = this.a;
            if (fullScreenVideoAd != null) {
                if (this.g && this.f) {
                    return true;
                }
                return fullScreenVideoAd.isReady();
            }
        } else {
            ExpressInterstitialAd expressInterstitialAd = this.b;
            if (expressInterstitialAd != null) {
                if (this.g && this.f) {
                    return true;
                }
                return expressInterstitialAd.isReady();
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002b  */
    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(final Activity activity) {
        byte b = 0;
        this.h = false;
        this.f = false;
        this.p = null;
        try {
            String str = this.m;
            int iHashCode = str.hashCode();
            if (iHashCode != 49) {
                if (iHashCode == 50 && str.equals("2")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (!str.equals("1")) {
                b = -1;
            }
            if (b == 0) {
                if (this.carouselShowType == 1) {
                    postOnMainThreadDelayed(new Runnable() { // from class: com.anythink.network.baidu.BaiduATInterstitialAdapter.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (BaiduATInterstitialAdapter.this.a != null) {
                                BaiduATInterstitialAdapter.this.a.show(activity);
                            }
                        }
                    }, 500L);
                    return;
                }
                FullScreenVideoAd fullScreenVideoAd = this.a;
                if (fullScreenVideoAd != null) {
                    fullScreenVideoAd.show(activity);
                    return;
                }
                return;
            }
            ExpressInterstitialAd expressInterstitialAd = this.b;
            if (expressInterstitialAd != null) {
                expressInterstitialAd.show(activity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return BaiduATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        try {
            super.destory();
            if (this.a != null) {
                this.a = null;
                this.c = null;
            }
            ExpressInterstitialAd expressInterstitialAd = this.b;
            if (expressInterstitialAd != null) {
                expressInterstitialAd.destroy();
                this.b = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.k;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return BaiduATInitManager.getInstance().getNetworkVersion();
    }

    public void setDismissType(int i2) {
        this.mDismissType = i2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.e = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdInternalAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, BaiduATAdapter.class);
        map.put(4, BaiduATSplashAdapter.class);
        return map;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.o;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onCreate(Activity activity) {
        Object obj;
        try {
            activity.getClass().getName();
            try {
                if (this.m.equals("1")) {
                    obj = this.a;
                } else {
                    obj = this.b;
                }
                if (obj != null) {
                    String[] strArrSplit = obj.getClass().getName().split("\\.");
                    if (strArrSplit.length >= 3) {
                        if (activity.getClass().getName().startsWith(strArrSplit[0] + j.z + strArrSplit[1] + j.z + strArrSplit[2]) && this.p == null) {
                            this.p = new WeakReference<>(activity);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.common.d.b.a
    public void onDestroy(Activity activity) {
        try {
            activity.getClass().getName();
            WeakReference<Activity> weakReference = this.p;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.p.clear();
            this.p = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.h) {
            return;
        }
        this.h = true;
        if (this.mImpressListener != null) {
            this.mImpressListener.onInterstitialAdClose();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String closeAd() {
        try {
            WeakReference<Activity> weakReference = this.p;
            if (weakReference == null || weakReference.get() == null) {
                return "showingActivity is null";
            }
            this.p.get().getClass().getName();
            this.p.get().finish();
            d();
            return "";
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.j = ATInitMediation.getStringFromMap(map, "app_id");
        this.k = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.m = ATInitMediation.getStringFromMap(map, "unit_type");
        try {
            if (map.containsKey("bid_floor")) {
                this.n = Double.parseDouble(map.get("bid_floor").toString());
            }
        } catch (Throwable unused) {
        }
        if (map2 != null) {
            try {
                if (map2.containsKey(ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS)) {
                    this.d = Boolean.parseBoolean(map2.get(ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS).toString());
                }
            } catch (Exception unused2) {
            }
        }
        this.l = ATInitMediation.getStringFromMap(map, "payload");
        this.g = ATInitMediation.getIntFromMap(map, "ad_s_reqf_mode") == 2;
        if (TextUtils.isEmpty(this.j) || TextUtils.isEmpty(this.k)) {
            notifyATLoadFail("", " app_id ,ad_place_id is empty.");
        } else if (TextUtils.isEmpty(this.m) || this.m.equals("0")) {
            notifyATLoadFail("", "Baidu InterstitialAd not support: " + this.m);
        } else {
            BaiduATInitManager.getInstance().initSDK(context.getApplicationContext(), map, TextUtils.equals("0", this.m), new MediationInitCallback() { // from class: com.anythink.network.baidu.BaiduATInterstitialAdapter.5
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        BaiduATInterstitialAdapter.a(BaiduATInterstitialAdapter.this, context, map, map2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        if (BaiduATInterstitialAdapter.this.mLoadListener != null) {
                            BaiduATInterstitialAdapter.this.mLoadListener.onAdLoadError("", "Baidu: init error, " + th.getMessage());
                        }
                    }
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    if (BaiduATInterstitialAdapter.this.mLoadListener != null) {
                        BaiduATInterstitialAdapter.this.mLoadListener.onAdLoadError("", str);
                    }
                }
            });
        }
    }

    static /* synthetic */ void g(BaiduATInterstitialAdapter baiduATInterstitialAdapter) {
        double d;
        if (baiduATInterstitialAdapter.e) {
            if (baiduATInterstitialAdapter.mBiddingListener != null) {
                FullScreenVideoAd fullScreenVideoAd = baiduATInterstitialAdapter.a;
                if (fullScreenVideoAd != null) {
                    String pecpm = fullScreenVideoAd.getPECPM();
                    if (baiduATInterstitialAdapter.o == null) {
                        baiduATInterstitialAdapter.o = new HashMap();
                    }
                    baiduATInterstitialAdapter.o.put(BaiduATConst.EN_P_KEY, pecpm);
                    String eCPMLevel = baiduATInterstitialAdapter.a.getECPMLevel();
                    if (TextUtils.isEmpty(eCPMLevel)) {
                        eCPMLevel = "0";
                    }
                    try {
                        d = Double.parseDouble(eCPMLevel);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        d = 0.0d;
                    }
                    if (baiduATInterstitialAdapter.mBiddingListener != null) {
                        if (d <= 0.0d) {
                            baiduATInterstitialAdapter.notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(String.valueOf(d)));
                            return;
                        }
                        ATBiddingResult aTBiddingResultSuccess = ATBiddingResult.success(d, new StringBuilder().append(System.currentTimeMillis()).toString(), new BaiduATBiddingNotice(baiduATInterstitialAdapter.a), ATAdConst.CURRENCY.RMB_CENT);
                        aTBiddingResultSuccess.setExtra(pecpm);
                        baiduATInterstitialAdapter.mBiddingListener.onC2SBiddingResultWithCache(aTBiddingResultSuccess, null);
                        return;
                    }
                    return;
                }
                baiduATInterstitialAdapter.notifyATLoadFail("", "Baidu: FullScreenVideoAd had been destroyed.");
                return;
            }
            return;
        }
        if (baiduATInterstitialAdapter.mLoadListener != null) {
            baiduATInterstitialAdapter.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
        }
    }

    static /* synthetic */ void t(BaiduATInterstitialAdapter baiduATInterstitialAdapter) {
        double d;
        if (baiduATInterstitialAdapter.e) {
            if (baiduATInterstitialAdapter.mBiddingListener != null) {
                ExpressInterstitialAd expressInterstitialAd = baiduATInterstitialAdapter.b;
                if (expressInterstitialAd != null) {
                    String pecpm = expressInterstitialAd.getPECPM();
                    if (baiduATInterstitialAdapter.o == null) {
                        baiduATInterstitialAdapter.o = new HashMap();
                    }
                    baiduATInterstitialAdapter.o.put(BaiduATConst.EN_P_KEY, pecpm);
                    String eCPMLevel = baiduATInterstitialAdapter.b.getECPMLevel();
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
                        baiduATInterstitialAdapter.notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(String.valueOf(d)));
                        return;
                    }
                    ATBiddingResult aTBiddingResultSuccess = ATBiddingResult.success(d, new StringBuilder().append(System.currentTimeMillis()).toString(), new BaiduATBiddingNotice(baiduATInterstitialAdapter.b), ATAdConst.CURRENCY.RMB_CENT);
                    aTBiddingResultSuccess.setExtra(pecpm);
                    baiduATInterstitialAdapter.mBiddingListener.onC2SBiddingResultWithCache(aTBiddingResultSuccess, null);
                    return;
                }
                baiduATInterstitialAdapter.notifyATLoadFail("", "Baidu: ExpressInterstitialAd had been destroyed.");
                return;
            }
            return;
        }
        if (baiduATInterstitialAdapter.mLoadListener != null) {
            baiduATInterstitialAdapter.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0026  */
    static /* synthetic */ void a(BaiduATInterstitialAdapter baiduATInterstitialAdapter, Context context, Map map, Map map2) {
        byte b;
        baiduATInterstitialAdapter.h = false;
        String str = baiduATInterstitialAdapter.m;
        int iHashCode = str.hashCode();
        if (iHashCode != 49) {
            if (iHashCode == 50 && str.equals("2")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("1")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            baiduATInterstitialAdapter.c = baiduATInterstitialAdapter.new AnonymousClass1();
            baiduATInterstitialAdapter.a = new FullScreenVideoAd(context, baiduATInterstitialAdapter.k, baiduATInterstitialAdapter.c, false);
            if (baiduATInterstitialAdapter.e && baiduATInterstitialAdapter.n > 0.0d) {
                if (ATSDK.isNetworkLogDebug()) {
                    Log.i("BaiduATInterstitial", "setBidFloor:" + ((int) baiduATInterstitialAdapter.n));
                }
                baiduATInterstitialAdapter.a.setBidFloor((int) baiduATInterstitialAdapter.n);
            }
            RequestParameters.Builder builder = new RequestParameters.Builder();
            BaiduATInitManager.getInstance();
            BaiduATInitManager.a(baiduATInterstitialAdapter.k, builder, (Map<String, Object>) map, (Map<String, Object>) map2);
            baiduATInterstitialAdapter.a.setRequestParameters(builder.build());
            baiduATInterstitialAdapter.a.setAppSid(BaiduATInitManager.getInstance().getApp_id());
            baiduATInterstitialAdapter.a.load();
            return;
        }
        baiduATInterstitialAdapter.b = new ExpressInterstitialAd(context.getApplicationContext(), baiduATInterstitialAdapter.k);
        if (baiduATInterstitialAdapter.e && baiduATInterstitialAdapter.n > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATInterstitial", "setBidFloor:" + ((int) baiduATInterstitialAdapter.n));
            }
            baiduATInterstitialAdapter.b.setBidFloor((int) baiduATInterstitialAdapter.n);
        }
        baiduATInterstitialAdapter.b.setLoadListener(baiduATInterstitialAdapter.new AnonymousClass2());
        baiduATInterstitialAdapter.b.setDownloadListener(baiduATInterstitialAdapter.new AnonymousClass3());
        baiduATInterstitialAdapter.b.setDialogFrame(baiduATInterstitialAdapter.d);
        RequestParameters.Builder builder2 = new RequestParameters.Builder();
        BaiduATInitManager.getInstance();
        BaiduATInitManager.a(baiduATInterstitialAdapter.k, builder2, (Map<String, Object>) map, (Map<String, Object>) map2);
        baiduATInterstitialAdapter.b.setRequestParameters(builder2.build());
        baiduATInterstitialAdapter.b.setAppSid(BaiduATInitManager.getInstance().getApp_id());
        baiduATInterstitialAdapter.b.load();
    }
}
