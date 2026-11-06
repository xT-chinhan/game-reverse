package com.anythink.nativead.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdCreateConfig;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATRequestingInfo;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import com.anythink.core.common.d.a;
import com.anythink.core.common.d.c;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.n;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.o;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ATNative {
    private final String TAG;
    a adLoadListener;
    public ATAdMultipleLoadedListener adMultipleLoadedListener;
    WeakReference<Activity> mActivityRef;
    com.anythink.nativead.a.a mAdLoadManager;
    c mAdSourceEventListener;
    Context mContext;
    ATAdSourceStatusListener mDeveloperStatusListener;
    ATNativeNetworkListener mListener;
    ATAdMultipleLoadedListener mMultipleLoadedListener;
    String mPlacementId;
    Map<String, Object> mTKExtraMap;

    public ATNative(Context context, String str, ATNativeNetworkListener aTNativeNetworkListener) {
        this(context, str, aTNativeNetworkListener, null);
    }

    public ATNative(Context context, String str, ATNativeNetworkListener aTNativeNetworkListener, ATAdCreateConfig aTAdCreateConfig) {
        this.TAG = "ATNative";
        this.adLoadListener = new a() { // from class: com.anythink.nativead.api.ATNative.1
            @Override // com.anythink.core.common.d.a
            public void onAdLoaded() {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.nativead.api.ATNative.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            s.b();
                            com.anythink.core.common.u.c.a();
                            com.anythink.core.common.u.c.a(ATNative.this.getNativeCache());
                        } catch (Throwable unused) {
                        }
                        if (ATNative.this.mListener != null) {
                            ATNative.this.mListener.onNativeAdLoaded();
                        }
                    }
                });
            }

            @Override // com.anythink.core.common.d.a
            public void onAdLoadFail(final AdError adError) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.nativead.api.ATNative.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATNative.this.mListener != null) {
                            ATNative.this.mListener.onNativeAdLoadFail(adError);
                        }
                    }
                });
            }
        };
        this.adMultipleLoadedListener = new ATAdMultipleLoadedListener() { // from class: com.anythink.nativead.api.ATNative.2
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                s.b();
                s.b(new Runnable() { // from class: com.anythink.nativead.api.ATNative.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (ATNative.this.mMultipleLoadedListener != null) {
                            ATNative.this.mMultipleLoadedListener.onAdMultipleLoaded(aTRequestingInfo);
                        }
                    }
                });
            }
        };
        this.mContext = context.getApplicationContext();
        if (context instanceof Activity) {
            this.mActivityRef = new WeakReference<>((Activity) context);
        }
        this.mPlacementId = str;
        this.mListener = aTNativeNetworkListener;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mAdLoadManager = new com.anythink.nativead.a.a(context, str, aTAdCreateConfig);
    }

    public void setAdListener(ATNativeNetworkListener aTNativeNetworkListener) {
        this.mListener = aTNativeNetworkListener;
    }

    public void setAdMultipleLoadedListener(ATAdMultipleLoadedListener aTAdMultipleLoadedListener) {
        this.mMultipleLoadedListener = aTAdMultipleLoadedListener;
    }

    public void entryAdScenario(String str) {
        if (this.mAdLoadManager != null) {
            s.b().a(this.mAdLoadManager.b(), str, "0", (Map<String, Object>) null);
        }
    }

    public void entryAdScenario(String str, Map<String, Object> map) {
        if (this.mAdLoadManager != null) {
            s.b().a(this.mAdLoadManager.b(), str, "0", map);
        }
    }

    public void makeAdRequest() {
        makeAdRequest((ATAdRequest) null);
    }

    @Deprecated
    public void makeAdRequest(ATAdxBidFloorInfo aTAdxBidFloorInfo) {
        makeAdRequest(aTAdxBidFloorInfo != null ? new ATAdRequest.Builder().setATAdxBidFloorInfo(aTAdxBidFloorInfo).build() : null);
    }

    public void makeAdRequest(ATAdRequest aTAdRequest) {
        String str = this.mPlacementId;
        String str2 = i.s.s;
        String str3 = i.s.y;
        String str4 = i.s.o;
        com.anythink.nativead.a.a aVar = this.mAdLoadManager;
        aa.a(str, str2, str3, str4, "", aVar != null ? aVar.b() : null);
        com.anythink.nativead.a.a aVar2 = this.mAdLoadManager;
        if (aVar2 != null) {
            aVar2.a(getContext(), this.adLoadListener, this.mAdSourceEventListener, this.adMultipleLoadedListener, this.mTKExtraMap, aTAdRequest);
            return;
        }
        ATNativeNetworkListener aTNativeNetworkListener = this.mListener;
        if (aTNativeNetworkListener != null) {
            aTNativeNetworkListener.onNativeAdLoadFail(ErrorCode.getErrorCode(ErrorCode.exception, "", "placementId maybe is null"));
        }
    }

    public void setLocalExtra(Map<String, Object> map) {
        if (TextUtils.isEmpty(this.mPlacementId)) {
            Log.e(this.TAG, "You must set unit Id first.");
            return;
        }
        com.anythink.nativead.a.a aVar = this.mAdLoadManager;
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

    public NativeAd getNativeAd() {
        return getNativeAd((ATShowConfig) null);
    }

    @Deprecated
    public NativeAd getNativeAd(String str) {
        return getNativeAd(o.e(str));
    }

    public NativeAd getNativeAd(ATShowConfig aTShowConfig) {
        com.anythink.core.common.h.c cVarA;
        n nVarI;
        com.anythink.nativead.a.a aVar = this.mAdLoadManager;
        if (aVar == null || (cVarA = aVar.a(aTShowConfig, this.mTKExtraMap)) == null || (nVarI = cVarA.i()) == null || nVarI.a() == null) {
            return null;
        }
        return new NativeAd(getContext(), this.mPlacementId, cVarA, nVarI.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.anythink.core.common.h.c getNativeCache() {
        com.anythink.nativead.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            return aVar.a(this.mTKExtraMap);
        }
        return null;
    }

    public ATAdStatusInfo checkAdStatus() {
        if (s.b().g() == null || TextUtils.isEmpty(s.b().p()) || TextUtils.isEmpty(s.b().q())) {
            Log.e(this.TAG, "SDK init error!");
            return new ATAdStatusInfo(false, false, null);
        }
        com.anythink.nativead.a.a aVar = this.mAdLoadManager;
        if (aVar == null) {
            Log.e(this.TAG, "PlacementId is empty!");
            return new ATAdStatusInfo(false, false, null);
        }
        ATAdStatusInfo aTAdStatusInfoA = aVar.a(getContext(), this.mTKExtraMap);
        aa.b(this.mPlacementId, i.s.s, i.s.C, aTAdStatusInfoA.toString(), "");
        return aTAdStatusInfoA;
    }

    public List<ATAdInfo> checkValidAdCaches() {
        com.anythink.nativead.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            return aVar.a(getContext());
        }
        return null;
    }

    private Context getContext() {
        Activity activity;
        WeakReference<Activity> weakReference = this.mActivityRef;
        return (weakReference == null || (activity = weakReference.get()) == null) ? this.mContext : activity;
    }

    public void setAdSourceStatusListener(ATAdSourceStatusListener aTAdSourceStatusListener) {
        if (this.mAdSourceEventListener == null) {
            this.mAdSourceEventListener = new c();
        }
        this.mDeveloperStatusListener = aTAdSourceStatusListener;
        this.mAdSourceEventListener.setAdSourceStatusListener(aTAdSourceStatusListener);
    }

    public void clearCache(int i) {
        com.anythink.nativead.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void clearCache(List<ATAdInfo> list) {
        com.anythink.nativead.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.a(list);
        }
    }

    public void sendEvent(Map<String, Object> map) {
        com.anythink.nativead.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.b(map);
        }
    }

    public boolean isMultiton() {
        com.anythink.nativead.a.a aVar = this.mAdLoadManager;
        return aVar != null && aVar.a();
    }

    public void destroyAd() {
        com.anythink.nativead.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            aVar.c();
        }
    }
}
