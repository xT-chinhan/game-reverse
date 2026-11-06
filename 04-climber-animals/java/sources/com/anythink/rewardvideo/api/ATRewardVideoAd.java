package com.anythink.rewardvideo.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.ATRequestingInfo;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import com.anythink.core.common.d.c;
import com.anythink.core.common.d.f;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.t;
import com.anythink.core.common.u;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.v.i;
import com.anythink.core.common.v.p;
import com.anythink.core.d.l;
import com.anythink.core.d.n;
import com.anythink.rewardvideo.a.a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ATRewardVideoAd {
    WeakReference<Activity> mActivityWef;
    a mAdLoadManager;
    ATAdRevenueListener mAdRevenueListener;
    c mAdSourceEventListener;
    Context mContext;
    ATAdSourceStatusListener mDeveloperStatusListener;
    ATEventInterface mDownloadListener;
    ATRewardVideoListener mListener;
    ATAdMultipleLoadedListener mMultipleLoadedListener;
    String mPlacementId;
    Map<String, Object> mTKExtraMap;
    final String TAG = getClass().getSimpleName();
    private ATRewardVideoExListener mInterListener = new ATRewardVideoExListener() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1
        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdFailed(AdError adError) {
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdLoaded() {
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
        public void onDeeplinkCallback(final ATAdInfo aTAdInfo, final boolean z) {
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.1
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
        public void onDownloadConfirm(final Context context, final ATAdInfo aTAdInfo, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.8
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener == null || !(ATRewardVideoAd.this.mListener instanceof ATRewardVideoExListener)) {
                        return;
                    }
                    ATRewardVideoExListener aTRewardVideoExListener = (ATRewardVideoExListener) ATRewardVideoAd.this.mListener;
                    Context context2 = context;
                    if (context2 == null) {
                        context2 = ATRewardVideoAd.this.mContext;
                    }
                    aTRewardVideoExListener.onDownloadConfirm(context2, aTAdInfo, aTNetworkConfirmInfo);
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
        public void onRewardedVideoAdAgainPlayStart(final ATAdInfo aTAdInfo) {
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.9
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
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.10
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
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.11
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
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.12
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
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.13
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
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.14
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
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.15
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
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    i.a(ATRewardVideoAd.this.mPlacementId, "onRewardedVideoAdPlayStart", aTAdInfo, z);
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
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.3
                @Override // java.lang.Runnable
                public final void run() {
                    i.a(ATRewardVideoAd.this.mPlacementId, "onRewardedVideoAdPlayEnd", aTAdInfo, z);
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onRewardedVideoAdPlayEnd(aTAdInfo);
                    }
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdPlayFailed(final AdError adError, final ATAdInfo aTAdInfo) {
            final boolean z = aTAdInfo == null;
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.4
                @Override // java.lang.Runnable
                public final void run() {
                    i.a(ATRewardVideoAd.this.mPlacementId, "onRewardedVideoAdPlayFailed", aTAdInfo, z);
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onRewardedVideoAdPlayFailed(adError, aTAdInfo);
                    }
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdClosed(final ATAdInfo aTAdInfo) {
            final boolean z = aTAdInfo == null;
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.5
                @Override // java.lang.Runnable
                public final void run() {
                    i.a(ATRewardVideoAd.this.mPlacementId, "onRewardedVideoAdClosed", aTAdInfo, z);
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onRewardedVideoAdClosed(aTAdInfo);
                    }
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onRewardedVideoAdPlayClicked(final ATAdInfo aTAdInfo) {
            final boolean z = aTAdInfo == null;
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.6
                @Override // java.lang.Runnable
                public final void run() {
                    i.a(ATRewardVideoAd.this.mPlacementId, "onRewardedVideoAdPlayClicked", aTAdInfo, z);
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onRewardedVideoAdPlayClicked(aTAdInfo);
                    }
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
        public void onReward(final ATAdInfo aTAdInfo) {
            final boolean z = aTAdInfo == null;
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.1.7
                @Override // java.lang.Runnable
                public final void run() {
                    i.a(ATRewardVideoAd.this.mPlacementId, "onReward", aTAdInfo, z);
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onReward(aTAdInfo);
                    }
                }
            });
        }
    };
    com.anythink.core.common.d.a adLoadListener = new com.anythink.core.common.d.a() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.2
        @Override // com.anythink.core.common.d.a
        public void onAdLoaded() {
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onRewardedVideoAdLoaded();
                    }
                }
            });
        }

        @Override // com.anythink.core.common.d.a
        public void onAdLoadFail(final AdError adError) {
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.2.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mListener != null) {
                        ATRewardVideoAd.this.mListener.onRewardedVideoAdFailed(adError);
                    }
                }
            });
        }
    };
    public ATAdMultipleLoadedListener adMultipleLoadedListener = new ATAdMultipleLoadedListener() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.3
        @Override // com.anythink.core.api.ATAdMultipleLoadedListener
        public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.api.ATRewardVideoAd.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATRewardVideoAd.this.mMultipleLoadedListener != null) {
                        ATRewardVideoAd.this.mMultipleLoadedListener.onAdMultipleLoaded(aTRequestingInfo);
                    }
                }
            });
        }
    };

    public ATRewardVideoAd(Context context, String str) {
        this.mPlacementId = str;
        this.mContext = context.getApplicationContext();
        if (context instanceof Activity) {
            this.mActivityWef = new WeakReference<>((Activity) context);
        }
        this.mAdLoadManager = a.a(context, str);
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
        ab.a(this.mPlacementId, j.r.r, j.r.y, j.r.o, "", true);
        this.mAdLoadManager.a(context, i, this.adLoadListener, this.mAdSourceEventListener, this.adMultipleLoadedListener, this.mTKExtraMap, aTAdRequest);
    }

    public static void entryAdScenario(String str, String str2) {
        t.b().a(str, str2, "1", (Map<String, Object>) null);
    }

    public static void entryAdScenario(String str, String str2, Map<String, Object> map) {
        t.b().a(str, str2, "1", map);
    }

    private Context getRequestContext() {
        WeakReference<Activity> weakReference = this.mActivityWef;
        Activity activity = weakReference != null ? weakReference.get() : null;
        return activity != null ? activity : this.mContext;
    }

    private boolean isPlaceStrategyNeedAutoLoad() {
        l lVarA = n.a(t.b().g()).a(this.mPlacementId);
        return lVarA != null && lVarA.ao() == 1;
    }

    public void setLocalExtra(Map<String, Object> map) {
        u.a().a(this.mPlacementId, map);
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
        ab.b(this.mPlacementId, j.r.r, j.r.B, String.valueOf(zIsReady), "");
        return zIsReady;
    }

    public ATAdStatusInfo checkAdStatus() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return new ATAdStatusInfo(false, false, null);
        }
        ab.b(this.mPlacementId, j.r.r, j.r.C, adStatus.toString(), "");
        return adStatus;
    }

    private ATAdStatusInfo getAdStatus() {
        if (t.b().g() == null || TextUtils.isEmpty(t.b().p()) || TextUtils.isEmpty(t.b().q())) {
            Log.e(this.TAG, "SDK init error!");
            return null;
        }
        return this.mAdLoadManager.a(this.mContext, this.mTKExtraMap);
    }

    public List<ATAdInfo> checkValidAdCaches() {
        a aVar = this.mAdLoadManager;
        if (aVar != null) {
            return aVar.a(this.mContext);
        }
        return null;
    }

    @Deprecated
    public void show(Activity activity, String str) {
        controlShow(activity, p.e(str));
    }

    public void show(Activity activity) {
        show(activity, (ATShowConfig) null);
    }

    public void show(Activity activity, ATShowConfig aTShowConfig) {
        controlShow(activity, aTShowConfig);
    }

    private void controlShow(Activity activity, ATShowConfig aTShowConfig) {
        ab.b(this.mPlacementId, j.r.r, j.r.A, j.r.o, "");
        if (t.b().g() == null || TextUtils.isEmpty(t.b().p()) || TextUtils.isEmpty(t.b().q())) {
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.exception, "", "sdk init error");
            ATRewardVideoListener aTRewardVideoListener = this.mListener;
            if (aTRewardVideoListener != null) {
                aTRewardVideoListener.onRewardedVideoAdPlayFailed(errorCode, com.anythink.core.common.d.l.a((f) null));
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
        this.mAdLoadManager.a(activity2, aTShowConfig, this.mInterListener, this.mDownloadListener, this.mTKExtraMap);
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
}
