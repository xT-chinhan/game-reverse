package com.anythink.network.ks;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.d.j;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.SplashAdExtraData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class KSATSplashAdapter extends CustomSplashAdapter {
    long a;
    KsSplashScreenAd b;
    View c;
    boolean d;
    Context e;
    String f;
    double g;
    private final String i = getClass().getSimpleName();
    private boolean j = false;
    boolean h = false;

    static /* synthetic */ int i(KSATSplashAdapter kSATSplashAdapter) {
        kSATSplashAdapter.mDismissType = 99;
        return 99;
    }

    static /* synthetic */ int m(KSATSplashAdapter kSATSplashAdapter) {
        kSATSplashAdapter.mDismissType = 3;
        return 3;
    }

    static /* synthetic */ int r(KSATSplashAdapter kSATSplashAdapter) {
        kSATSplashAdapter.mDismissType = 2;
        return 2;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (!a(map)) {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        } else {
            this.e = context.getApplicationContext();
            KSATInitManager.getInstance().initSDK(this.e, map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATSplashAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    KSATSplashAdapter.a(KSATSplashAdapter.this);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    KSATSplashAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATSplashAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements KsLoadManager.SplashScreenAdListener {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onError(int i, String str) {
            KSATSplashAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onRequestResult(int i) {
            if (KSATSplashAdapter.this.mLoadListener != null) {
                KSATSplashAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
            double ecpm;
            KSATSplashAdapter.this.b = ksSplashScreenAd;
            if (!KSATSplashAdapter.this.h) {
                if (KSATSplashAdapter.this.mLoadListener != null) {
                    KSATSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (KSATSplashAdapter.this.mBiddingListener != null) {
                try {
                    ecpm = ksSplashScreenAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                    ecpm = 0.0d;
                }
                if (ecpm <= 0.0d) {
                    KSATSplashAdapter.this.mBiddingListener.onC2SBidResult(ATBiddingResult.fail("error price: ".concat(String.valueOf(ecpm))));
                } else {
                    KSATSplashAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, new StringBuilder().append(System.currentTimeMillis()).toString(), new KSATBiddingNotice(ksSplashScreenAd), ATAdConst.CURRENCY.RMB_CENT), null);
                }
            }
        }
    }

    private void a() {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        KsScene.Builder builderAdNum = new KsScene.Builder(this.a).adNum(1);
        Boolean boolIsShakeEnabled = ATSDKGlobalSetting.isShakeEnabled(28);
        if (boolIsShakeEnabled != null) {
            SplashAdExtraData splashAdExtraData = new SplashAdExtraData();
            splashAdExtraData.setDisableRotateStatus(!boolIsShakeEnabled.booleanValue());
            splashAdExtraData.setDisableShakeStatus(!boolIsShakeEnabled.booleanValue());
            splashAdExtraData.setDisableSlideStatus(true ^ boolIsShakeEnabled.booleanValue());
            builderAdNum.setSplashExtraData(splashAdExtraData);
        }
        if (!TextUtils.isEmpty(this.f)) {
            builderAdNum.setBidResponseV2(this.f);
        }
        KsAdSDK.getLoadManager().loadSplashScreenAd(builderAdNum.build(), anonymousClass2);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        KsSplashScreenAd ksSplashScreenAd = this.b;
        return ksSplashScreenAd != null && ksSplashScreenAd.isAdEnable();
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        KsSplashScreenAd ksSplashScreenAd = this.b;
        if (ksSplashScreenAd != null) {
            try {
                View view = ksSplashScreenAd.getView(viewGroup.getContext().getApplicationContext(), new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: com.anythink.network.ks.KSATSplashAdapter.3
                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onDownloadTipsDialogCancel() {
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onDownloadTipsDialogDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onDownloadTipsDialogShow() {
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onAdClicked() {
                        if (KSATSplashAdapter.this.mImpressionListener != null) {
                            KSATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onAdShowError(int i, String str) {
                        Log.e(KSATSplashAdapter.this.i, "onAdShowError: " + i + ", " + str);
                        KSATSplashAdapter.i(KSATSplashAdapter.this);
                        if (KSATSplashAdapter.this.d || KSATSplashAdapter.this.mImpressionListener == null) {
                            return;
                        }
                        KSATSplashAdapter.this.d = true;
                        KSATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, String.valueOf(i), str));
                        KSATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onAdShowEnd() {
                        KSATSplashAdapter.m(KSATSplashAdapter.this);
                        if (KSATSplashAdapter.this.d || KSATSplashAdapter.this.mImpressionListener == null) {
                            return;
                        }
                        KSATSplashAdapter.this.d = true;
                        KSATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onAdShowStart() {
                        try {
                            KSATInitManager.getInstance().a(KSATSplashAdapter.this.getTrackingInfo().z(), new WeakReference(KSATSplashAdapter.this.b));
                        } catch (Throwable unused) {
                        }
                        if (KSATSplashAdapter.this.mImpressionListener != null) {
                            KSATSplashAdapter.this.mImpressionListener.onSplashAdShow();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onSkippedAd() {
                        KSATSplashAdapter.r(KSATSplashAdapter.this);
                        if (KSATSplashAdapter.this.d || KSATSplashAdapter.this.mImpressionListener == null) {
                            return;
                        }
                        KSATSplashAdapter.this.d = true;
                        KSATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                    }
                });
                if (this.j) {
                    this.c = view;
                    viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        this.b = null;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        try {
            return String.valueOf(this.a);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return KSATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return KSATInitManager.getInstance().getNetworkName();
    }

    private void b() {
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onSplashAdClicked();
        }
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        String stringFromMap2 = ATInitMediation.getStringFromMap(map, "position_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(stringFromMap2)) {
            return false;
        }
        try {
            this.a = Long.parseLong(stringFromMap2);
        } catch (NumberFormatException unused) {
        }
        if (map.containsKey("zoomoutad_sw")) {
            this.j = TextUtils.equals("2", ATInitMediation.getStringFromMap(map, "zoomoutad_sw"));
        }
        if (map.containsKey(j.w.m)) {
            this.g = ATInitMediation.getDoubleFromMap(map, j.w.m);
        }
        if (!map.containsKey("payload")) {
            return true;
        }
        this.f = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.g);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.a = ATInitMediation.getLongFromMap(map, "position_id");
        KSATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, 4);
    }

    @Override // com.anythink.core.api.ATBaseAdInternalAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, KSATAdapter.class);
        map.put(3, KSATInterstitialAdapter.class);
        return map;
    }

    static /* synthetic */ void a(KSATSplashAdapter kSATSplashAdapter) {
        AnonymousClass2 anonymousClass2 = kSATSplashAdapter.new AnonymousClass2();
        KsScene.Builder builderAdNum = new KsScene.Builder(kSATSplashAdapter.a).adNum(1);
        Boolean boolIsShakeEnabled = ATSDKGlobalSetting.isShakeEnabled(28);
        if (boolIsShakeEnabled != null) {
            SplashAdExtraData splashAdExtraData = new SplashAdExtraData();
            splashAdExtraData.setDisableRotateStatus(!boolIsShakeEnabled.booleanValue());
            splashAdExtraData.setDisableShakeStatus(!boolIsShakeEnabled.booleanValue());
            splashAdExtraData.setDisableSlideStatus(true ^ boolIsShakeEnabled.booleanValue());
            builderAdNum.setSplashExtraData(splashAdExtraData);
        }
        if (!TextUtils.isEmpty(kSATSplashAdapter.f)) {
            builderAdNum.setBidResponseV2(kSATSplashAdapter.f);
        }
        KsAdSDK.getLoadManager().loadSplashScreenAd(builderAdNum.build(), anonymousClass2);
    }
}
