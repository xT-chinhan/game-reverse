package com.anythink.rewardvideo.api;

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
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import com.anythink.core.common.d.a;
import com.anythink.core.common.d.c;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.k;
import com.anythink.core.common.d.s;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.h;
import com.anythink.core.common.u.o;
import com.anythink.core.e.l;
import com.anythink.core.e.n;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ATRewardVideoAd {
    final String TAG;
    a adLoadListener;
    public ATAdMultipleLoadedListener adMultipleLoadedListener;
    WeakReference<Activity> mActivityWef;
    com.anythink.rewardvideo.a.a mAdLoadManager;
    ATAdRevenueListener mAdRevenueListener;
    c mAdSourceEventListener;
    Context mContext;
    ATAdSourceStatusListener mDeveloperStatusListener;
    ATEventInterface mDownloadListener;
    private ATRewardVideoExListener mInterListener;
    ATRewardVideoListener mListener;
    ATAdMultipleLoadedListener mMultipleLoadedListener;
    private ATNativeAdCustomRender mNativeAdCustomRender;
    String mPlacementId;
    Map<String, Object> mTKExtraMap;

    public ATRewardVideoAd(Context context, String str) {
        this(context, str, null);
    }

    public ATRewardVideoAd(Context context, String str, ATAdCreateConfig aTAdCreateConfig) {
        this.TAG = getClass().getSimpleName();
        this.mInterListener = new ATRewardVideoExListener() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1
            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdFailed(AdError adError) {
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdLoaded() {
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onDeeplinkCallback(final ATAdInfo aTAdInfo, final boolean z) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                            return;
                        }
                        ((ATRewardVideoExListener) ATRewardVideoAd.this.mListener).onDeeplinkCallback(aTAdInfo, z);
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onDownloadConfirm(final Context context2, final ATAdInfo aTAdInfo, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                            return;
                        }
                        ATRewardVideoExListener aTRewardVideoExListener = (ATRewardVideoExListener) ATRewardVideoAd.this.mListener;
                        Context context3 = context2;
                        if (context3 == null) {
                            context3 = ATRewardVideoAd.this.mContext;
                        }
                        aTRewardVideoExListener.onDownloadConfirm(context3, aTAdInfo, aTNetworkConfirmInfo);
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onRewardedVideoAdAgainPlayStart(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATRewardVideoAd.this.mAdRevenueListener != null) {
                            ATRewardVideoAd.this.mAdRevenueListener.onAdRevenuePaid(aTAdInfo);
                        }
                        if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                            return;
                        }
                        ((ATRewardVideoExListener) ATRewardVideoAd.this.mListener).onRewardedVideoAdAgainPlayStart(aTAdInfo);
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onRewardedVideoAdAgainPlayEnd(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.10
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                            return;
                        }
                        ((ATRewardVideoExListener) ATRewardVideoAd.this.mListener).onRewardedVideoAdAgainPlayEnd(aTAdInfo);
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onRewardedVideoAdAgainPlayFailed(final AdError adError, final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.11
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                            return;
                        }
                        ((ATRewardVideoExListener) ATRewardVideoAd.this.mListener).onRewardedVideoAdAgainPlayFailed(adError, aTAdInfo);
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onRewardedVideoAdAgainPlayClicked(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.12
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                            return;
                        }
                        ((ATRewardVideoExListener) ATRewardVideoAd.this.mListener).onRewardedVideoAdAgainPlayClicked(aTAdInfo);
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onAgainReward(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.13
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                            return;
                        }
                        ((ATRewardVideoExListener) ATRewardVideoAd.this.mListener).onAgainReward(aTAdInfo);
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onAgainRewardFailed(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.14
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                                return;
                            }
                            ((ATRewardVideoExListener) ATRewardVideoAd.this.mListener).onAgainRewardFailed(aTAdInfo);
                        } catch (Throwable th) {
                            Log.w("anythink", "onAgainRewardFailed: " + th.getMessage());
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onRewardFailed(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.15
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                                return;
                            }
                            ((ATRewardVideoExListener) ATRewardVideoAd.this.mListener).onRewardFailed(aTAdInfo);
                        } catch (Throwable th) {
                            Log.w("anythink", "onRewardFailed: " + th.getMessage());
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdPlayStart(final ATAdInfo aTAdInfo) {
                final boolean z = aTAdInfo == null;
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.a(ATRewardVideoAd.this.mPlacementId, "onRewardedVideoAdPlayStart", aTAdInfo, z);
                        if (ATRewardVideoAd.this.mAdRevenueListener != null) {
                            ATRewardVideoAd.this.mAdRevenueListener.onAdRevenuePaid(aTAdInfo);
                        }
                        if (ATRewardVideoAd.this.mListener != null) {
                            ATRewardVideoAd.this.mListener.onRewardedVideoAdPlayStart(aTAdInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdPlayEnd(final ATAdInfo aTAdInfo) {
                final boolean z = aTAdInfo == null;
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.a(ATRewardVideoAd.this.mPlacementId, "onRewardedVideoAdPlayEnd", aTAdInfo, z);
                        if (ATRewardVideoAd.this.mListener != null) {
                            ATRewardVideoAd.this.mListener.onRewardedVideoAdPlayEnd(aTAdInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdPlayFailed(final AdError adError, final ATAdInfo aTAdInfo) {
                final boolean z = aTAdInfo == null;
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.a(ATRewardVideoAd.this.mPlacementId, "onRewardedVideoAdPlayFailed", aTAdInfo, z);
                        if (ATRewardVideoAd.this.mListener != null) {
                            ATRewardVideoAd.this.mListener.onRewardedVideoAdPlayFailed(adError, aTAdInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdClosed(final ATAdInfo aTAdInfo) {
                final boolean z = aTAdInfo == null;
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.a(ATRewardVideoAd.this.mPlacementId, "onRewardedVideoAdClosed", aTAdInfo, z);
                        if (ATRewardVideoAd.this.mListener != null) {
                            ATRewardVideoAd.this.mListener.onRewardedVideoAdClosed(aTAdInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdPlayClicked(final ATAdInfo aTAdInfo) {
                final boolean z = aTAdInfo == null;
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.a(ATRewardVideoAd.this.mPlacementId, "onRewardedVideoAdPlayClicked", aTAdInfo, z);
                        if (ATRewardVideoAd.this.mListener != null) {
                            ATRewardVideoAd.this.mListener.onRewardedVideoAdPlayClicked(aTAdInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onReward(final ATAdInfo aTAdInfo) {
                final boolean z = aTAdInfo == null;
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.7
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.a(ATRewardVideoAd.this.mPlacementId, "onReward", aTAdInfo, z);
                        if (ATRewardVideoAd.this.mListener != null) {
                            ATRewardVideoAd.this.mListener.onReward(aTAdInfo);
                        }
                    }
                });
            }
        };
        this.adLoadListener = new a() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.2
            @Override // com.anythink.core.common.d.a
            public void onAdLoaded() {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            s.b();
                            com.anythink.core.common.u.c.a();
                            com.anythink.core.common.u.c.a(ATRewardVideoAd.this.getRewardCache());
                        } catch (Throwable unused) {
                        }
                        if (ATRewardVideoAd.this.mListener != null) {
                            ATRewardVideoAd.this.mListener.onRewardedVideoAdLoaded();
                        }
                    }
                });
            }

            @Override // com.anythink.core.common.d.a
            public void onAdLoadFail(final AdError adError) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATRewardVideoAd.this.mListener != null) {
                            ATRewardVideoAd.this.mListener.onRewardedVideoAdFailed(adError);
                        }
                    }
                });
            }
        };
        this.adMultipleLoadedListener = new ATAdMultipleLoadedListener() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.3
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATRewardVideoAd.this.mMultipleLoadedListener != null) {
                            ATRewardVideoAd.this.mMultipleLoadedListener.onAdMultipleLoaded(aTRequestingInfo);
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
        this.mAdLoadManager = new com.anythink.rewardvideo.a.a(context, str, aTAdCreateConfig);
    }

    public void load() {
        load(null);
    }

    public void load(Context context) {
        load(context, (ATAdRequest) null);
    }

    @Deprecated
    public void load(Context context, ATAdxBidFloorInfo aTAdxBidFloorInfo) {
        ATAdRequest aTAdRequestBuild = aTAdxBidFloorInfo != null ? new ATAdRequest.Builder().setATAdxBidFloorInfo(aTAdxBidFloorInfo).build() : null;
        if (context == null) {
            context = getRequestContext();
        }
        load(context, aTAdRequestBuild, 0);
    }

    public void load(Context context, ATAdRequest aTAdRequest) {
        if (context == null) {
            context = getRequestContext();
        }
        load(context, aTAdRequest, 0);
    }

    private void load(Context context, ATAdRequest aTAdRequest, int i) {
        String str = this.mPlacementId;
        String str2 = i.s.r;
        String str3 = i.s.y;
        String str4 = i.s.o;
        com.anythink.rewardvideo.a.a aVar = this.mAdLoadManager;
        aa.a(str, str2, str3, str4, "", aVar != null ? aVar.b() : null);
        com.anythink.rewardvideo.a.a aVar2 = this.mAdLoadManager;
        if (aVar2 != null) {
            aVar2.a(context, i, this.adLoadListener, this.mAdSourceEventListener, this.adMultipleLoadedListener, this.mTKExtraMap, aTAdRequest);
            return;
        }
        ATRewardVideoListener aTRewardVideoListener = this.mListener;
        if (aTRewardVideoListener != null) {
            aTRewardVideoListener.onRewardedVideoAdFailed(ErrorCode.getErrorCode(ErrorCode.exception, "", "placementId maybe is null"));
        }
    }

    public void entryAdScenario(String str) {
        if (this.mAdLoadManager != null) {
            s.b().a(this.mAdLoadManager.b(), str, "1", (Map<String, Object>) null);
        }
    }

    public void entryAdScenario(String str, Map<String, Object> map) {
        if (this.mAdLoadManager != null) {
            s.b().a(this.mAdLoadManager.b(), str, "1", map);
        }
    }

    private Context getRequestContext() {
        WeakReference<Activity> weakReference = this.mActivityWef;
        Activity activity = weakReference != null ? weakReference.get() : null;
        return activity != null ? activity : this.mContext;
    }

    private boolean isPlaceStrategyNeedAutoLoad() {
        if (TextUtils.isEmpty(this.mPlacementId)) {
            Log.e(this.TAG, "You must set unit Id first.");
            return false;
        }
        l lVarA = n.a(s.b().g()).a(this.mPlacementId);
        return lVarA != null && lVarA.an() == 1;
    }

    public void setLocalExtra(Map<String, Object> map) {
        if (TextUtils.isEmpty(this.mPlacementId)) {
            Log.e(this.TAG, "You must set unit Id first.");
            return;
        }
        com.anythink.rewardvideo.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.c(map);
        }
    }

    public void setTKExtra(Map<String, Object> map) {
        if (this.mTKExtraMap == null) {
            this.mTKExtraMap = new ConcurrentHashMap();
        }
        this.mTKExtraMap.clear();
        this.mTKExtraMap.putAll(map);
    }

    public void setAdListener(ATRewardVideoListener aTRewardVideoListener) {
        this.mListener = aTRewardVideoListener;
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
        aa.b(this.mPlacementId, i.s.r, i.s.B, String.valueOf(zIsReady), "");
        return zIsReady;
    }

    public ATAdStatusInfo checkAdStatus() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return new ATAdStatusInfo(false, false, null);
        }
        aa.b(this.mPlacementId, i.s.r, i.s.C, adStatus.toString(), "");
        return adStatus;
    }

    private ATAdStatusInfo getAdStatus() {
        if (s.b().g() == null || TextUtils.isEmpty(s.b().p()) || TextUtils.isEmpty(s.b().q())) {
            Log.e(this.TAG, "SDK init error!");
            return null;
        }
        com.anythink.rewardvideo.a.a aVar = this.mAdLoadManager;
        if (aVar == null) {
            Log.e(this.TAG, "PlacementId is empty!");
            return new ATAdStatusInfo(false, false, null);
        }
        return aVar.a(this.mContext, this.mTKExtraMap);
    }

    public List<ATAdInfo> checkValidAdCaches() {
        com.anythink.rewardvideo.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            return aVar.a(this.mContext);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.anythink.core.common.h.c getRewardCache() {
        com.anythink.rewardvideo.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            return aVar.a(this.mTKExtraMap);
        }
        return null;
    }

    @Deprecated
    public void show(Activity activity, String str) {
        controlShow(activity, o.e(str));
    }

    public void show(Activity activity) {
        show(activity, (ATShowConfig) null);
    }

    public void show(Activity activity, ATShowConfig aTShowConfig) {
        controlShow(activity, aTShowConfig);
    }

    private void controlShow(Activity activity, ATShowConfig aTShowConfig) {
        aa.b(this.mPlacementId, i.s.r, i.s.A, i.s.o, "");
        if (s.b().g() == null || TextUtils.isEmpty(s.b().p()) || TextUtils.isEmpty(s.b().q())) {
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.exception, "", "sdk init error");
            ATRewardVideoListener aTRewardVideoListener = this.mListener;
            if (aTRewardVideoListener != null) {
                aTRewardVideoListener.onRewardedVideoAdPlayFailed(errorCode, k.a((ATBaseAdAdapter) null));
            }
            Log.e(this.TAG, "SDK init error!");
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
            Log.e(this.TAG, "RewardedVideo Show Activity is null.");
        }
        com.anythink.rewardvideo.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.a(activity2, aTShowConfig, this.mInterListener, this.mDownloadListener, this.mTKExtraMap, this.mNativeAdCustomRender);
            return;
        }
        ATRewardVideoListener aTRewardVideoListener2 = this.mListener;
        if (aTRewardVideoListener2 != null) {
            aTRewardVideoListener2.onRewardedVideoAdPlayFailed(ErrorCode.getErrorCode(ErrorCode.exception, "", "adLoadManager is null"), k.a((ATBaseAdAdapter) null));
        }
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

    public void setNativeAdCustomRender(ATNativeAdCustomRender aTNativeAdCustomRender) {
        this.mNativeAdCustomRender = aTNativeAdCustomRender;
    }

    public void clearCache(int i) {
        com.anythink.rewardvideo.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void clearCache(List<ATAdInfo> list) {
        com.anythink.rewardvideo.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.a(list);
        }
    }

    public void sendEvent(Map<String, Object> map) {
        com.anythink.rewardvideo.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.b(map);
        }
    }

    public boolean isMultiton() {
        com.anythink.rewardvideo.a.a aVar = this.mAdLoadManager;
        return aVar != null && aVar.a();
    }

    public void destroyAd() {
        com.anythink.rewardvideo.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.c();
        }
    }
}
