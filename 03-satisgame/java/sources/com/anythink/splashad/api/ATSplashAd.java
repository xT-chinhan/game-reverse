package com.anythink.splashad.api;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
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
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.s;
import com.anythink.core.common.g;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.t.f;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.al;
import com.anythink.core.common.u.b.d;
import com.anythink.core.common.u.b.e;
import com.anythink.core.common.u.o;
import com.anythink.core.e.l;
import com.anythink.core.e.n;
import com.anythink.splashad.a.a;
import com.anythink.splashad.a.b;
import com.anythink.splashad.a.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ATSplashAd {
    public static final int DEFAULT_SPLASH_TIMEOUT_TIME = 5000;
    final String TAG;
    public ATAdMultipleLoadedListener adMultipleLoadedListener;
    private ATAdRequest adRequest;
    WeakReference<Activity> mActivityWeakRef;
    c mAdLoadManager;
    ATAdRevenueListener mAdRevenueListener;
    com.anythink.core.common.d.c mAdSourceEventListener;
    Context mContext;
    ATAdSourceStatusListener mDeveloperStatusListener;
    ATEventInterface mDownloadListener;
    int mFetchAdTimeout;
    ATSplashAdListener mListener;
    ATAdMultipleLoadedListener mMultipleLoadedListener;
    private ATNativeAdCustomRender mNativeAdCustomRender;
    String mPlacementId;
    Map<String, Object> mTKExtraMap;

    @Deprecated
    public void onDestory() {
    }

    public ATSplashAd(Context context, String str, ATSplashAdListener aTSplashAdListener) {
        this(context, str, aTSplashAdListener, 0);
    }

    public ATSplashAd(Context context, String str, ATSplashAdListener aTSplashAdListener, ATAdCreateConfig aTAdCreateConfig) {
        this(context, str, aTSplashAdListener, 0, aTAdCreateConfig);
    }

    public ATSplashAd(Context context, String str, ATSplashAdListener aTSplashAdListener, int i) {
        this(context, str, aTSplashAdListener, i, null);
    }

    public ATSplashAd(Context context, String str, ATSplashAdListener aTSplashAdListener, int i, ATAdCreateConfig aTAdCreateConfig) {
        this.TAG = getClass().getSimpleName();
        this.adMultipleLoadedListener = new ATAdMultipleLoadedListener() { // from class: com.anythink.splashad.api.ATSplashAd.1
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mMultipleLoadedListener != null) {
                            ATSplashAd.this.mMultipleLoadedListener.onAdMultipleLoaded(aTRequestingInfo);
                        }
                    }
                });
            }
        };
        this.mContext = context.getApplicationContext();
        this.mPlacementId = str;
        this.mListener = aTSplashAdListener;
        this.mFetchAdTimeout = i;
        if (context instanceof Activity) {
            this.mActivityWeakRef = new WeakReference<>((Activity) context);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mAdLoadManager = new c(context, str, aTAdCreateConfig);
    }

    public void setAdListener(ATSplashAdListener aTSplashAdListener) {
        this.mListener = aTSplashAdListener;
    }

    public void setAdRevenueListener(ATAdRevenueListener aTAdRevenueListener) {
        this.mAdRevenueListener = aTAdRevenueListener;
    }

    public void setAdMultipleLoadedListener(ATAdMultipleLoadedListener aTAdMultipleLoadedListener) {
        this.mMultipleLoadedListener = aTAdMultipleLoadedListener;
    }

    public void entryAdScenario(String str) {
        if (this.mAdLoadManager != null) {
            s.b().a(this.mAdLoadManager.b(), str, "4", (Map<String, Object>) null);
        }
    }

    public void entryAdScenario(String str, Map<String, Object> map) {
        if (this.mAdLoadManager != null) {
            s.b().a(this.mAdLoadManager.b(), str, "4", map);
        }
    }

    public void setLocalExtra(Map<String, Object> map) {
        if (TextUtils.isEmpty(this.mPlacementId)) {
            Log.e(this.TAG, "You must set unit Id first.");
            return;
        }
        c cVar = this.mAdLoadManager;
        if (cVar != null) {
            cVar.c(map);
        }
    }

    public void setTKExtra(Map<String, Object> map) {
        if (this.mTKExtraMap == null) {
            this.mTKExtraMap = new ConcurrentHashMap();
        }
        this.mTKExtraMap.clear();
        this.mTKExtraMap.putAll(map);
    }

    public void loadAd() {
        loadAd((ATAdRequest) null);
    }

    @Deprecated
    public void loadAd(ATAdxBidFloorInfo aTAdxBidFloorInfo) {
        loadAd(aTAdxBidFloorInfo != null ? new ATAdRequest.Builder().setATAdxBidFloorInfo(aTAdxBidFloorInfo).build() : null);
    }

    public void loadAd(ATAdRequest aTAdRequest) {
        loadAd(aTAdRequest, 0);
    }

    private void loadAd(ATAdRequest aTAdRequest, int i) {
        HashMap map;
        if (TextUtils.isEmpty(this.mPlacementId)) {
            ATSplashAdListener aTSplashAdListener = this.mListener;
            if (aTSplashAdListener != null) {
                aTSplashAdListener.onNoAdError(ErrorCode.getErrorCode(ErrorCode.exception, "", "placementId maybe is null"));
                return;
            }
            return;
        }
        String str = this.mPlacementId;
        String str2 = i.s.t;
        String str3 = i.s.y;
        String str4 = i.s.o;
        c cVar = this.mAdLoadManager;
        aa.a(str, str2, str3, str4, "", cVar != null ? cVar.b() : null);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.adRequest = aTAdRequest;
        if (this.mTKExtraMap != null) {
            map = new HashMap(this.mTKExtraMap);
        } else {
            map = new HashMap();
        }
        HashMap map2 = map;
        c cVar2 = this.mAdLoadManager;
        if (cVar2 != null) {
            cVar2.c();
        }
        com.anythink.core.common.u.b.c.a().b(new d(e.ak, new AnonymousClass2(i, map2, aTAdRequest, jElapsedRealtime)));
    }

    /* JADX INFO: renamed from: com.anythink.splashad.api.ATSplashAd$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ATAdRequest val$adRequest;
        final /* synthetic */ Map val$finalTkExtraMap;
        final /* synthetic */ int val$loadType;
        final /* synthetic */ long val$startLoadTime;

        AnonymousClass2(int i, Map map, ATAdRequest aTAdRequest, long j) {
            this.val$loadType = i;
            this.val$finalTkExtraMap = map;
            this.val$adRequest = aTAdRequest;
            this.val$startLoadTime = j;
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0047  */
        /* JADX WARN: Code duplicated, block: B:19:0x004b  */
        /* JADX WARN: Code duplicated, block: B:22:0x0053  */
        /* JADX WARN: Code duplicated, block: B:23:0x005e  */
        /* JADX WARN: Code duplicated, block: B:26:0x0063  */
        /* JADX WARN: Code duplicated, block: B:29:0x0072  */
        /* JADX WARN: Code duplicated, block: B:32:0x0079  */
        /* JADX WARN: Code duplicated, block: B:35:0x00a8  */
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            boolean z2;
            AnonymousClass1 anonymousClass1;
            Activity activity;
            AnonymousClass1 anonymousClass2;
            int i = ATSplashAd.this.mFetchAdTimeout;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            l lVarA = n.a(ATSplashAd.this.mContext).a(ATSplashAd.this.mPlacementId);
            if (lVarA == null) {
                lVarA = n.a(ATSplashAd.this.mContext).g(ATSplashAd.this.mPlacementId);
            }
            l lVar = lVarA;
            int iBq = lVar != null ? lVar.bq() : -1;
            if (i <= 0) {
                if (iBq <= 0) {
                    z = false;
                }
                if (i <= 0) {
                    i = 5000;
                    z2 = false;
                } else {
                    z2 = z;
                }
                anonymousClass1 = null;
                if (ATSplashAd.this.mActivityWeakRef != null) {
                    activity = ATSplashAd.this.mActivityWeakRef.get();
                } else {
                    activity = null;
                }
                if (this.val$loadType == 0) {
                    anonymousClass1 = new AnonymousClass1(i);
                    anonymousClass1.startCountDown(i);
                }
                anonymousClass2 = anonymousClass1;
                if (ATSplashAd.this.mAdLoadManager != null) {
                    c cVar = ATSplashAd.this.mAdLoadManager;
                    if (activity == null) {
                        activity = ATSplashAd.this.mContext;
                    }
                    cVar.a(activity, anonymousClass2, ATSplashAd.this.adMultipleLoadedListener, i, z2, this.val$loadType, ATSplashAd.this.mAdSourceEventListener, this.val$finalTkExtraMap, this.val$adRequest, this.val$startLoadTime, jElapsedRealtime);
                    f.a(ATSplashAd.this.mPlacementId, lVar, ATSplashAd.this.mFetchAdTimeout, iBq, i, this.val$adRequest);
                    return;
                }
                s.b();
                s.b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener != null) {
                            ATSplashAd.this.mListener.onNoAdError(ErrorCode.getErrorCode(ErrorCode.exception, "", "adLoadManager is null"));
                        }
                    }
                });
            }
            if (iBq > 0) {
            }
            z = true;
            if (i <= 0) {
                i = 5000;
                z2 = false;
            } else {
                z2 = z;
            }
            anonymousClass1 = null;
            if (ATSplashAd.this.mActivityWeakRef != null) {
                activity = ATSplashAd.this.mActivityWeakRef.get();
            } else {
                activity = null;
            }
            if (this.val$loadType == 0) {
                anonymousClass1 = new AnonymousClass1(i);
                anonymousClass1.startCountDown(i);
            }
            anonymousClass2 = anonymousClass1;
            if (ATSplashAd.this.mAdLoadManager != null) {
                c cVar2 = ATSplashAd.this.mAdLoadManager;
                if (activity == null) {
                    activity = ATSplashAd.this.mContext;
                }
                cVar2.a(activity, anonymousClass2, ATSplashAd.this.adMultipleLoadedListener, i, z2, this.val$loadType, ATSplashAd.this.mAdSourceEventListener, this.val$finalTkExtraMap, this.val$adRequest, this.val$startLoadTime, jElapsedRealtime);
                f.a(ATSplashAd.this.mPlacementId, lVar, ATSplashAd.this.mFetchAdTimeout, iBq, i, this.val$adRequest);
                return;
            }
            s.b();
            s.b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATSplashAd.this.mListener != null) {
                        ATSplashAd.this.mListener.onNoAdError(ErrorCode.getErrorCode(ErrorCode.exception, "", "adLoadManager is null"));
                    }
                }
            });
            i = iBq;
            z = true;
            if (i <= 0) {
                i = 5000;
                z2 = false;
            } else {
                z2 = z;
            }
            anonymousClass1 = null;
            if (ATSplashAd.this.mActivityWeakRef != null) {
                activity = ATSplashAd.this.mActivityWeakRef.get();
            } else {
                activity = null;
            }
            if (this.val$loadType == 0) {
                anonymousClass1 = new AnonymousClass1(i);
                anonymousClass1.startCountDown(i);
            }
            anonymousClass2 = anonymousClass1;
            if (ATSplashAd.this.mAdLoadManager != null) {
                c cVar3 = ATSplashAd.this.mAdLoadManager;
                if (activity == null) {
                    activity = ATSplashAd.this.mContext;
                }
                cVar3.a(activity, anonymousClass2, ATSplashAd.this.adMultipleLoadedListener, i, z2, this.val$loadType, ATSplashAd.this.mAdSourceEventListener, this.val$finalTkExtraMap, this.val$adRequest, this.val$startLoadTime, jElapsedRealtime);
                f.a(ATSplashAd.this.mPlacementId, lVar, ATSplashAd.this.mFetchAdTimeout, iBq, i, this.val$adRequest);
                return;
            }
            s.b();
            s.b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (ATSplashAd.this.mListener != null) {
                        ATSplashAd.this.mListener.onNoAdError(ErrorCode.getErrorCode(ErrorCode.exception, "", "adLoadManager is null"));
                    }
                }
            });
        }

        /* JADX INFO: renamed from: com.anythink.splashad.api.ATSplashAd$2$1, reason: invalid class name */
        class AnonymousClass1 extends b {
            boolean hasCacheWhenTimeout = false;
            final /* synthetic */ int val$finalTimeout;

            AnonymousClass1(int i) {
                this.val$finalTimeout = i;
            }

            @Override // com.anythink.splashad.a.b
            public void onAdLoaded(String str, final boolean z) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            s.b();
                            com.anythink.core.common.u.c.a();
                            com.anythink.core.common.u.c.a(ATSplashAd.this.getSplashCache());
                        } catch (Throwable unused) {
                        }
                        if (ATSplashAd.this.mListener != null) {
                            ATSplashAd.this.mListener.onAdLoaded(!AnonymousClass1.this.hasCacheWhenTimeout && z);
                        }
                    }
                });
            }

            @Override // com.anythink.splashad.a.b
            public void onNoAdError(String str, final AdError adError) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener != null) {
                            ATSplashAd.this.mListener.onNoAdError(adError);
                        }
                    }
                });
            }

            @Override // com.anythink.splashad.a.b
            public void onTimeout(final String str) {
                if (ATSplashAd.this.mAdLoadManager != null) {
                    final g gVarA = ATSplashAd.this.mAdLoadManager.a(str);
                    com.anythink.core.common.a.c.a aVarI = gVarA != null ? gVarA.i() : null;
                    if (aVarI != null) {
                        aVarI.b();
                    }
                    ae aeVar = new ae();
                    aeVar.a(AnonymousClass2.this.val$finalTkExtraMap);
                    aeVar.a(AnonymousClass2.this.val$adRequest);
                    com.anythink.core.common.h.c cVarA = ATSplashAd.this.mAdLoadManager.a(ATSplashAd.this.mContext, aeVar);
                    if (cVarA != null) {
                        this.hasCacheWhenTimeout = true;
                        if (gVarA != null) {
                            if (aVarI != null && aVarI.e() == cVarA) {
                                gVarA.a(11, cVarA.o());
                            } else {
                                gVarA.a(9, cVarA.o());
                            }
                            f.a(ATSplashAd.this.mPlacementId, str, gVarA.j(), "1", cVarA, this.val$finalTimeout, AnonymousClass2.this.val$adRequest);
                            return;
                        }
                    }
                    s.b();
                    s.b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.1.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            String str2 = ATSplashAd.this.mPlacementId;
                            String str3 = str;
                            g gVar = gVarA;
                            f.a(str2, str3, gVar != null ? gVar.j() : null, "2", (com.anythink.core.common.h.c) null, AnonymousClass1.this.val$finalTimeout, AnonymousClass2.this.val$adRequest);
                            if (ATSplashAd.this.mListener != null) {
                                ATSplashAd.this.mListener.onAdLoadTimeout();
                            }
                        }
                    });
                }
            }
        }
    }

    public boolean isAdReady() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return false;
        }
        boolean zIsReady = adStatus.isReady();
        aa.b(this.mPlacementId, i.s.t, i.s.B, String.valueOf(zIsReady), "");
        return zIsReady;
    }

    public ATAdStatusInfo checkAdStatus() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return new ATAdStatusInfo(false, false, null);
        }
        aa.b(this.mPlacementId, i.s.t, i.s.C, adStatus.toString(), "");
        return adStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.anythink.core.common.h.c getSplashCache() {
        c cVar = this.mAdLoadManager;
        if (cVar != null) {
            return cVar.a(this.mTKExtraMap);
        }
        return null;
    }

    private ATAdStatusInfo getAdStatus() {
        if (s.b().g() == null || TextUtils.isEmpty(s.b().p()) || TextUtils.isEmpty(s.b().q())) {
            Log.e(this.TAG, "SDK init error!");
            return null;
        }
        c cVar = this.mAdLoadManager;
        if (cVar == null) {
            Log.e(this.TAG, "PlacementId is empty!");
            return new ATAdStatusInfo(false, false, null);
        }
        return cVar.a(this.mContext, this.mTKExtraMap);
    }

    public List<ATAdInfo> checkValidAdCaches() {
        c cVar = this.mAdLoadManager;
        if (cVar != null) {
            return cVar.a(this.mContext);
        }
        return null;
    }

    public void show(Activity activity, ViewGroup viewGroup) {
        show(activity, viewGroup, "");
    }

    @Deprecated
    public void show(Activity activity, ViewGroup viewGroup, String str) {
        show(activity, viewGroup, (ATSplashSkipInfo) null, o.e(str));
    }

    public void show(Activity activity, ViewGroup viewGroup, ATSplashSkipInfo aTSplashSkipInfo) {
        show(activity, viewGroup, aTSplashSkipInfo, (ATShowConfig) null);
    }

    @Deprecated
    public void show(Activity activity, ViewGroup viewGroup, ATSplashSkipInfo aTSplashSkipInfo, String str) {
        show(activity, viewGroup, aTSplashSkipInfo, o.e(str));
    }

    public void show(Activity activity, ViewGroup viewGroup, ATSplashSkipInfo aTSplashSkipInfo, ATShowConfig aTShowConfig) {
        aa.b(this.mPlacementId, i.s.t, i.s.A, i.s.o, "");
        if (s.b().g() == null || TextUtils.isEmpty(s.b().p()) || TextUtils.isEmpty(s.b().q())) {
            Log.e(this.TAG, "SDK init error!");
            return;
        }
        if (activity == null) {
            Log.e(this.TAG, "Splash Activity is null.");
        }
        if (viewGroup == null) {
            Log.e(this.TAG, "Splash Container is null.");
            return;
        }
        if (ATSDK.isNetworkLogDebug()) {
            al.a(viewGroup);
        }
        a aVar = new a() { // from class: com.anythink.splashad.api.ATSplashAd.3
            @Override // com.anythink.splashad.a.a
            public void onAdReward(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener == null || !(ATSplashAd.this.mListener instanceof ATSplashExListener)) {
                            return;
                        }
                        ((ATSplashExListener) ATSplashAd.this.mListener).onSplashAdReward(aTAdInfo);
                    }
                });
            }

            @Override // com.anythink.splashad.a.a
            public void onDeeplinkCallback(final ATAdInfo aTAdInfo, final boolean z) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.3.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener == null || !(ATSplashAd.this.mListener instanceof ATSplashExListener)) {
                            return;
                        }
                        ((ATSplashExListener) ATSplashAd.this.mListener).onDeeplinkCallback(aTAdInfo, z);
                    }
                });
            }

            @Override // com.anythink.splashad.a.a
            public void onDownloadConfirm(final Context context, final ATAdInfo aTAdInfo, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.3.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener == null || !(ATSplashAd.this.mListener instanceof ATSplashExListener)) {
                            return;
                        }
                        ATSplashExListener aTSplashExListener = (ATSplashExListener) ATSplashAd.this.mListener;
                        Context context2 = context;
                        if (context2 == null) {
                            context2 = ATSplashAd.this.mContext;
                        }
                        aTSplashExListener.onDownloadConfirm(context2, aTAdInfo, aTNetworkConfirmInfo);
                    }
                });
            }

            @Override // com.anythink.splashad.a.a
            public void onAdShow(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.3.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mAdRevenueListener != null) {
                            ATSplashAd.this.mAdRevenueListener.onAdRevenuePaid(aTAdInfo);
                        }
                        if (ATSplashAd.this.mListener != null) {
                            ATSplashAd.this.mListener.onAdShow(aTAdInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.splashad.a.a
            public void onAdClick(final ATAdInfo aTAdInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.3.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener != null) {
                            ATSplashAd.this.mListener.onAdClick(aTAdInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.splashad.a.a
            public void onAdDismiss(final ATAdInfo aTAdInfo, final ATSplashAdExtraInfo aTSplashAdExtraInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.3.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener != null) {
                            ATSplashAd.this.mListener.onAdDismiss(aTAdInfo, aTSplashAdExtraInfo);
                        }
                    }
                });
            }
        };
        c cVar = this.mAdLoadManager;
        if (cVar != null) {
            cVar.a(activity, viewGroup, aVar, this.mDownloadListener, aTSplashSkipInfo, aTShowConfig, this.mTKExtraMap, this.mNativeAdCustomRender);
        }
    }

    public void setAdDownloadListener(ATEventInterface aTEventInterface) {
        this.mDownloadListener = aTEventInterface;
    }

    public void setAdSourceStatusListener(ATAdSourceStatusListener aTAdSourceStatusListener) {
        if (this.mAdSourceEventListener == null) {
            this.mAdSourceEventListener = new com.anythink.core.common.d.c();
        }
        this.mDeveloperStatusListener = aTAdSourceStatusListener;
        this.mAdSourceEventListener.setAdSourceStatusListener(aTAdSourceStatusListener);
    }

    public void setNativeAdCustomRender(ATNativeAdCustomRender aTNativeAdCustomRender) {
        this.mNativeAdCustomRender = aTNativeAdCustomRender;
    }

    public void clearCache(int i) {
        c cVar = this.mAdLoadManager;
        if (cVar != null) {
            cVar.a(i);
        }
    }

    public void clearCache(List<ATAdInfo> list) {
        c cVar = this.mAdLoadManager;
        if (cVar != null) {
            cVar.a(list);
        }
    }

    public void sendEvent(Map<String, Object> map) {
        c cVar = this.mAdLoadManager;
        if (cVar != null) {
            cVar.b(map);
        }
    }

    public boolean isMultiton() {
        c cVar = this.mAdLoadManager;
        return cVar != null && cVar.a();
    }

    public void destroyAd() {
        c cVar = this.mAdLoadManager;
        if (cVar != null) {
            cVar.d();
        }
        cleanListener();
    }

    private void cleanListener() {
        try {
            this.mListener = null;
            this.mAdRevenueListener = null;
            this.mMultipleLoadedListener = null;
            this.mDownloadListener = null;
            this.mDeveloperStatusListener = null;
            this.mAdSourceEventListener = null;
        } catch (Throwable unused) {
        }
    }
}
