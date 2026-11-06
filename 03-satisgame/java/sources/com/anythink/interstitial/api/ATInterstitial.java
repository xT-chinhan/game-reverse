package com.anythink.interstitial.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdCreateConfig;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.ATRequestingInfo;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import com.anythink.core.common.d.a;
import com.anythink.core.common.d.c;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.s;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.o;
import com.anythink.interstitial.a.b;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ATInterstitial {
    public static final String TAG = "ATInterstitial";
    a adLoadListener;
    public ATAdMultipleLoadedListener adMultipleLoadedListener;
    WeakReference<Activity> mActivityWef;
    b mAdLoadManager;
    private ATAdRevenueListener mAdRevenueListener;
    c mAdSourceEventListener;
    public Context mContext;
    ATAdSourceStatusListener mDeveloperStatusListener;
    ATEventInterface mDownloadListener;
    private ATInterstitialExListener mInterListener;
    public ATInterstitialListener mInterstitialListener;
    ATAdMultipleLoadedListener mMultipleLoadedListener;
    public String mPlacementId;
    Map<String, Object> mTKExtraMap;
    private ATNativeAdCustomRender mixNativeAdListener;

    public ATInterstitial(Context context, String str) {
        this(context, str, null);
    }

    public ATInterstitial(Context context, String str, ATAdCreateConfig aTAdCreateConfig) {
        this.mInterListener = new ATInterstitialExListener() { // from class: com.anythink.interstitial.api.ATInterstitial.1
            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdLoadFail(AdError adError) {
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdLoaded() {
            }

            @Override // com.anythink.interstitial.api.ATInterstitialExListener
            public void onDeeplinkCallback(final ATAdInfo aTAdInfo, final boolean z) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATInterstitial.this.mInterstitialListener == null || !(ATInterstitial.this.mInterstitialListener instanceof ATInterstitialExListener)) {
                            return;
                        }
                        ((ATInterstitialExListener) ATInterstitial.this.mInterstitialListener).onDeeplinkCallback(aTAdInfo, z);
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialExListener
            public void onDownloadConfirm(final Context context2, final ATAdInfo aTAdInfo, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATInterstitial.this.mInterstitialListener == null || !(ATInterstitial.this.mInterstitialListener instanceof ATInterstitialExListener)) {
                            return;
                        }
                        ATInterstitialExListener aTInterstitialExListener = (ATInterstitialExListener) ATInterstitial.this.mInterstitialListener;
                        Context context3 = context2;
                        if (context3 == null) {
                            context3 = ATInterstitial.this.mContext;
                        }
                        aTInterstitialExListener.onDownloadConfirm(context3, aTAdInfo, aTNetworkConfirmInfo);
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialExListener
            public void onInterstitialAdReward(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATInterstitial.this.mInterstitialListener == null || !(ATInterstitial.this.mInterstitialListener instanceof ATInterstitialExListener)) {
                            return;
                        }
                        ((ATInterstitialExListener) ATInterstitial.this.mInterstitialListener).onInterstitialAdReward(aTAdInfo);
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdVideoStart(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATInterstitial.this.mInterstitialListener != null) {
                            ATInterstitial.this.mInterstitialListener.onInterstitialAdVideoStart(aTAdInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdVideoEnd(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATInterstitial.this.mInterstitialListener != null) {
                            ATInterstitial.this.mInterstitialListener.onInterstitialAdVideoEnd(aTAdInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdVideoError(final AdError adError) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATInterstitial.this.mInterstitialListener != null) {
                            ATInterstitial.this.mInterstitialListener.onInterstitialAdVideoError(adError);
                        }
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdClose(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.7
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATInterstitial.this.mInterstitialListener != null) {
                            ATInterstitial.this.mInterstitialListener.onInterstitialAdClose(aTAdInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdClicked(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATInterstitial.this.mInterstitialListener != null) {
                            ATInterstitial.this.mInterstitialListener.onInterstitialAdClicked(aTAdInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdShow(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.1.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATInterstitial.this.mAdRevenueListener != null) {
                            ATInterstitial.this.mAdRevenueListener.onAdRevenuePaid(aTAdInfo);
                        }
                        if (ATInterstitial.this.mInterstitialListener != null) {
                            ATInterstitial.this.mInterstitialListener.onInterstitialAdShow(aTAdInfo);
                        }
                    }
                });
            }
        };
        this.adLoadListener = new a() { // from class: com.anythink.interstitial.api.ATInterstitial.2
            @Override // com.anythink.core.common.d.a
            public void onAdLoaded() {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            s.b();
                            com.anythink.core.common.u.c.a();
                            com.anythink.core.common.u.c.a(ATInterstitial.this.getInterstitialCache());
                        } catch (Throwable unused) {
                        }
                        if (ATInterstitial.this.mInterstitialListener != null) {
                            ATInterstitial.this.mInterstitialListener.onInterstitialAdLoaded();
                        }
                    }
                });
            }

            @Override // com.anythink.core.common.d.a
            public void onAdLoadFail(final AdError adError) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATInterstitial.this.mInterstitialListener != null) {
                            ATInterstitial.this.mInterstitialListener.onInterstitialAdLoadFail(adError);
                        }
                    }
                });
            }
        };
        this.adMultipleLoadedListener = new ATAdMultipleLoadedListener() { // from class: com.anythink.interstitial.api.ATInterstitial.3
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.interstitial.api.ATInterstitial.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATInterstitial.this.mMultipleLoadedListener != null) {
                            ATInterstitial.this.mMultipleLoadedListener.onAdMultipleLoaded(aTRequestingInfo);
                        }
                    }
                });
            }
        };
        this.mPlacementId = str;
        this.mContext = context.getApplicationContext();
        if (context instanceof Activity) {
            this.mActivityWef = new WeakReference<>((Activity) context);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mAdLoadManager = new b(context, str, aTAdCreateConfig);
    }

    private Context getRequestContext() {
        WeakReference<Activity> weakReference = this.mActivityWef;
        Activity activity = weakReference != null ? weakReference.get() : null;
        return activity != null ? activity : this.mContext;
    }

    public void setLocalExtra(Map<String, Object> map) {
        if (TextUtils.isEmpty(this.mPlacementId)) {
            Log.e(TAG, "You must set unit Id first.");
            return;
        }
        b bVar = this.mAdLoadManager;
        if (bVar != null) {
            bVar.c(map);
        }
    }

    public void load() {
        load(null);
    }

    public void load(Context context) {
        load(context, (ATAdRequest) null);
    }

    public void load(Context context, ATAdRequest aTAdRequest) {
        if (context == null) {
            context = getRequestContext();
        }
        load(context, aTAdRequest, 0);
    }

    @Deprecated
    public void load(Context context, ATAdxBidFloorInfo aTAdxBidFloorInfo) {
        ATAdRequest aTAdRequestBuild = aTAdxBidFloorInfo != null ? new ATAdRequest.Builder().setATAdxBidFloorInfo(aTAdxBidFloorInfo).build() : null;
        if (context == null) {
            context = getRequestContext();
        }
        load(context, aTAdRequestBuild, 0);
    }

    private void load(Context context, ATAdRequest aTAdRequest, int i) {
        String str = this.mPlacementId;
        String str2 = i.s.q;
        String str3 = i.s.y;
        String str4 = i.s.o;
        b bVar = this.mAdLoadManager;
        aa.a(str, str2, str3, str4, "", bVar != null ? bVar.b() : null);
        b bVar2 = this.mAdLoadManager;
        if (bVar2 != null) {
            bVar2.a(context, i, this.adLoadListener, this.mAdSourceEventListener, this.adMultipleLoadedListener, this.mTKExtraMap, aTAdRequest);
            return;
        }
        ATInterstitialListener aTInterstitialListener = this.mInterstitialListener;
        if (aTInterstitialListener != null) {
            aTInterstitialListener.onInterstitialAdLoadFail(ErrorCode.getErrorCode(ErrorCode.exception, "", "placementId maybe is null"));
        }
    }

    public void setAdListener(ATInterstitialListener aTInterstitialListener) {
        this.mInterstitialListener = aTInterstitialListener;
    }

    public void setAdRevenueListener(ATAdRevenueListener aTAdRevenueListener) {
        this.mAdRevenueListener = aTAdRevenueListener;
    }

    public void setAdMultipleLoadedListener(ATAdMultipleLoadedListener aTAdMultipleLoadedListener) {
        this.mMultipleLoadedListener = aTAdMultipleLoadedListener;
    }

    public boolean isAdReady() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return false;
        }
        boolean zIsReady = adStatus.isReady();
        aa.b(this.mPlacementId, i.s.q, i.s.B, String.valueOf(zIsReady), "");
        return zIsReady;
    }

    public void entryAdScenario(String str) {
        if (this.mAdLoadManager != null) {
            s.b().a(this.mAdLoadManager.b(), str, "3", (Map<String, Object>) null);
        }
    }

    public void entryAdScenario(String str, Map<String, Object> map) {
        if (this.mAdLoadManager != null) {
            s.b().a(this.mAdLoadManager.b(), str, "3", map);
        }
    }

    public ATAdStatusInfo checkAdStatus() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return new ATAdStatusInfo(false, false, null);
        }
        aa.b(this.mPlacementId, i.s.q, i.s.C, adStatus.toString(), "");
        return adStatus;
    }

    private ATAdStatusInfo getAdStatus() {
        if (s.b().g() == null || TextUtils.isEmpty(s.b().p()) || TextUtils.isEmpty(s.b().q())) {
            Log.e(TAG, "SDK init error!");
            return null;
        }
        b bVar = this.mAdLoadManager;
        if (bVar == null) {
            Log.e(TAG, "PlacementId is empty!");
            return new ATAdStatusInfo(false, false, null);
        }
        return bVar.a(this.mContext, this.mTKExtraMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.anythink.core.common.h.c getInterstitialCache() {
        b bVar = this.mAdLoadManager;
        if (bVar != null) {
            return bVar.a(this.mTKExtraMap);
        }
        return null;
    }

    public List<ATAdInfo> checkValidAdCaches() {
        b bVar = this.mAdLoadManager;
        if (bVar != null) {
            return bVar.a(this.mContext);
        }
        return null;
    }

    @Deprecated
    public void show(Activity activity, String str) {
        controlShow(activity, o.e(str));
    }

    public void setTKExtra(Map<String, Object> map) {
        if (this.mTKExtraMap == null) {
            this.mTKExtraMap = new ConcurrentHashMap();
        }
        this.mTKExtraMap.clear();
        this.mTKExtraMap.putAll(map);
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        this.mDownloadListener = aTEventInterface;
    }

    public void setAdSourceStatusListener(ATAdSourceStatusListener aTAdSourceStatusListener) {
        if (this.mAdSourceEventListener == null) {
            this.mAdSourceEventListener = new c();
        }
        this.mDeveloperStatusListener = aTAdSourceStatusListener;
        this.mAdSourceEventListener.setAdSourceStatusListener(aTAdSourceStatusListener);
    }

    public void show(Activity activity) {
        show(activity, "");
    }

    public void show(Activity activity, ATShowConfig aTShowConfig) {
        controlShow(activity, aTShowConfig);
    }

    public void setNativeAdCustomRender(ATNativeAdCustomRender aTNativeAdCustomRender) {
        this.mixNativeAdListener = aTNativeAdCustomRender;
    }

    private void controlShow(Activity activity, ATShowConfig aTShowConfig) {
        aa.b(this.mPlacementId, i.s.q, i.s.A, i.s.o, "");
        if (s.b().g() == null || TextUtils.isEmpty(s.b().p()) || TextUtils.isEmpty(s.b().q())) {
            Log.e(TAG, "Show error: SDK init error!");
            return;
        }
        if (activity == null) {
            Context context = this.mContext;
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
        }
        Activity activity2 = activity;
        if (activity2 == null) {
            Log.e(TAG, "Interstitial Show Activity is null.");
        }
        b bVar = this.mAdLoadManager;
        if (bVar != null) {
            bVar.a(activity2, aTShowConfig, this.mInterListener, this.mDownloadListener, this.mTKExtraMap, this.mixNativeAdListener);
            return;
        }
        ATInterstitialListener aTInterstitialListener = this.mInterstitialListener;
        if (aTInterstitialListener != null) {
            aTInterstitialListener.onInterstitialAdVideoError(ErrorCode.getErrorCode(ErrorCode.exception, "", "adLoadManager is null"));
        }
    }

    public void clearCache(int i) {
        b bVar = this.mAdLoadManager;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    public void clearCache(List<ATAdInfo> list) {
        b bVar = this.mAdLoadManager;
        if (bVar != null) {
            bVar.a(list);
        }
    }

    public void sendEvent(Map<String, Object> map) {
        b bVar = this.mAdLoadManager;
        if (bVar != null) {
            bVar.b(map);
        }
    }

    public boolean isMultiton() {
        b bVar = this.mAdLoadManager;
        return bVar != null && bVar.a();
    }

    public void destroyAd() {
        b bVar = this.mAdLoadManager;
        if (bVar != null) {
            bVar.c();
        }
    }
}
