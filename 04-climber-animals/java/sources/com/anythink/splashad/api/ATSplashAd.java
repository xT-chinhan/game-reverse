package com.anythink.splashad.api;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
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
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.t;
import com.anythink.core.common.g;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.u;
import com.anythink.core.common.u.e;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.v.b.b;
import com.anythink.core.common.v.p;
import com.anythink.core.d.l;
import com.anythink.core.d.n;
import com.anythink.splashad.a.a;
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

    @Deprecated
    public ATSplashAd(Context context, String str, ATSplashAdListener aTSplashAdListener, int i, String str2) {
        this(context, str, aTSplashAdListener, i);
    }

    public ATSplashAd(Context context, String str, ATSplashAdListener aTSplashAdListener, int i) {
        this.TAG = getClass().getSimpleName();
        this.adMultipleLoadedListener = new ATAdMultipleLoadedListener() { // from class: com.anythink.splashad.api.ATSplashAd.1
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                t.b().b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.1.1
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
        this.mAdLoadManager = c.a(context, str);
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

    public static void entryAdScenario(String str, String str2) {
        t.b().a(str, str2, "4", (Map<String, Object>) null);
    }

    public static void entryAdScenario(String str, String str2, Map<String, Object> map) {
        t.b().a(str, str2, "4", map);
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
        ab.a(this.mPlacementId, j.r.t, j.r.y, j.r.o, "", true);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.adRequest = aTAdRequest;
        if (this.mTKExtraMap != null) {
            map = new HashMap(this.mTKExtraMap);
        } else {
            map = new HashMap();
        }
        this.mAdLoadManager.a();
        b.a().a(new AnonymousClass2(i, map, aTAdRequest, jElapsedRealtime));
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
        /* JADX WARN: Code duplicated, block: B:30:0x0073  */
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            boolean z2;
            AnonymousClass1 anonymousClass1;
            Activity activity;
            int i = ATSplashAd.this.mFetchAdTimeout;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            l lVarA = n.a(ATSplashAd.this.mContext).a(ATSplashAd.this.mPlacementId);
            if (lVarA == null) {
                lVarA = n.a(ATSplashAd.this.mContext).f(ATSplashAd.this.mPlacementId);
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
                AnonymousClass1 anonymousClass2 = anonymousClass1;
                c cVar = ATSplashAd.this.mAdLoadManager;
                if (activity == null) {
                    activity = ATSplashAd.this.mContext;
                }
                cVar.a(activity, anonymousClass2, ATSplashAd.this.adMultipleLoadedListener, i, z2, this.val$loadType, ATSplashAd.this.mAdSourceEventListener, this.val$finalTkExtraMap, this.val$adRequest, this.val$startLoadTime, jElapsedRealtime);
                e.a(ATSplashAd.this.mPlacementId, lVar, ATSplashAd.this.mFetchAdTimeout, iBq, i, this.val$adRequest);
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
            AnonymousClass1 anonymousClass3 = anonymousClass1;
            c cVar2 = ATSplashAd.this.mAdLoadManager;
            if (activity == null) {
                activity = ATSplashAd.this.mContext;
            }
            cVar2.a(activity, anonymousClass3, ATSplashAd.this.adMultipleLoadedListener, i, z2, this.val$loadType, ATSplashAd.this.mAdSourceEventListener, this.val$finalTkExtraMap, this.val$adRequest, this.val$startLoadTime, jElapsedRealtime);
            e.a(ATSplashAd.this.mPlacementId, lVar, ATSplashAd.this.mFetchAdTimeout, iBq, i, this.val$adRequest);
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
            AnonymousClass1 anonymousClass4 = anonymousClass1;
            c cVar3 = ATSplashAd.this.mAdLoadManager;
            if (activity == null) {
                activity = ATSplashAd.this.mContext;
            }
            cVar3.a(activity, anonymousClass4, ATSplashAd.this.adMultipleLoadedListener, i, z2, this.val$loadType, ATSplashAd.this.mAdSourceEventListener, this.val$finalTkExtraMap, this.val$adRequest, this.val$startLoadTime, jElapsedRealtime);
            e.a(ATSplashAd.this.mPlacementId, lVar, ATSplashAd.this.mFetchAdTimeout, iBq, i, this.val$adRequest);
        }

        /* JADX INFO: renamed from: com.anythink.splashad.api.ATSplashAd$2$1, reason: invalid class name */
        class AnonymousClass1 extends com.anythink.splashad.a.b {
            boolean hasCacheWhenTimeout = false;
            final /* synthetic */ int val$finalTimeout;

            AnonymousClass1(int i) {
                this.val$finalTimeout = i;
            }

            @Override // com.anythink.splashad.a.b
            public void onAdLoaded(String str, final boolean z) {
                t.b().b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATSplashAd.this.mListener != null) {
                            ATSplashAd.this.mListener.onAdLoaded(!AnonymousClass1.this.hasCacheWhenTimeout && z);
                        }
                    }
                });
            }

            @Override // com.anythink.splashad.a.b
            public void onNoAdError(String str, final AdError adError) {
                t.b().b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.1.2
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
                final g gVarA = ATSplashAd.this.mAdLoadManager.a(str);
                com.anythink.core.common.a.c.a aVarH = gVarA != null ? gVarA.h() : null;
                if (aVarH != null) {
                    aVarH.b();
                }
                ae aeVar = new ae();
                aeVar.a(AnonymousClass2.this.val$finalTkExtraMap);
                aeVar.a(AnonymousClass2.this.val$adRequest);
                com.anythink.core.common.h.c cVarA = ATSplashAd.this.mAdLoadManager.a(ATSplashAd.this.mContext, aeVar);
                if (cVarA != null) {
                    this.hasCacheWhenTimeout = true;
                    if (gVarA != null) {
                        if (aVarH != null && aVarH.e() == cVarA) {
                            String str2 = ATSplashAd.this.mPlacementId;
                            gVarA.a(11, cVarA.o());
                        } else {
                            String str3 = ATSplashAd.this.mPlacementId;
                            gVarA.a(9, cVarA.o());
                        }
                        e.a(ATSplashAd.this.mPlacementId, str, gVarA.i(), "1", cVarA, this.val$finalTimeout, AnonymousClass2.this.val$adRequest);
                        return;
                    }
                }
                t.b().b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.2.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str4 = ATSplashAd.this.mPlacementId;
                        String str5 = str;
                        g gVar = gVarA;
                        e.a(str4, str5, gVar != null ? gVar.i() : null, "2", (com.anythink.core.common.h.c) null, AnonymousClass1.this.val$finalTimeout, AnonymousClass2.this.val$adRequest);
                        if (ATSplashAd.this.mListener != null) {
                            ATSplashAd.this.mListener.onAdLoadTimeout();
                        }
                    }
                });
            }
        }
    }

    public boolean isAdReady() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return false;
        }
        boolean zIsReady = adStatus.isReady();
        ab.b(this.mPlacementId, j.r.t, j.r.B, String.valueOf(zIsReady), "");
        return zIsReady;
    }

    public ATAdStatusInfo checkAdStatus() {
        ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return new ATAdStatusInfo(false, false, null);
        }
        ab.b(this.mPlacementId, j.r.t, j.r.C, adStatus.toString(), "");
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
        show(activity, viewGroup, (ATSplashSkipInfo) null, p.e(str));
    }

    public void show(Activity activity, ViewGroup viewGroup, ATSplashSkipInfo aTSplashSkipInfo) {
        show(activity, viewGroup, aTSplashSkipInfo, (ATShowConfig) null);
    }

    @Deprecated
    public void show(Activity activity, ViewGroup viewGroup, ATSplashSkipInfo aTSplashSkipInfo, String str) {
        show(activity, viewGroup, aTSplashSkipInfo, p.e(str));
    }

    public void show(Activity activity, ViewGroup viewGroup, ATSplashSkipInfo aTSplashSkipInfo, ATShowConfig aTShowConfig) {
        ab.b(this.mPlacementId, j.r.t, j.r.A, j.r.o, "");
        if (t.b().g() == null || TextUtils.isEmpty(t.b().p()) || TextUtils.isEmpty(t.b().q())) {
            Log.e(this.TAG, "SDK init error!");
            return;
        }
        if (activity == null) {
            Log.e(this.TAG, "Splash Activity is null.");
        }
        if (viewGroup == null) {
            Log.e(this.TAG, "Splash Container is null.");
        } else {
            this.mAdLoadManager.a(activity, viewGroup, new a() { // from class: com.anythink.splashad.api.ATSplashAd.3
                @Override // com.anythink.splashad.a.a
                public void onDeeplinkCallback(final ATAdInfo aTAdInfo, final boolean z) {
                    t.b().b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.3.1
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
                    t.b().b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.3.2
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
                    t.b().b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.3.3
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
                    t.b().b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.3.4
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
                    t.b().b(new Runnable() { // from class: com.anythink.splashad.api.ATSplashAd.3.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (ATSplashAd.this.mListener != null) {
                                ATSplashAd.this.mListener.onAdDismiss(aTAdInfo, aTSplashAdExtraInfo);
                            }
                        }
                    });
                }
            }, this.mDownloadListener, aTSplashSkipInfo, aTShowConfig, this.mTKExtraMap, this.mNativeAdCustomRender);
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
}
