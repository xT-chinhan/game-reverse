package com.anythink.network.ks;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEventListener;
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
    long b;
    KsSplashScreenAd c;
    View e;
    boolean f;
    Context g;
    String h;
    double i;
    private Map<String, Object> k;
    private final String a = getClass().getSimpleName();
    private boolean d = false;
    boolean j = false;

    class a implements MediationInitCallback {
        a() {
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            KSATSplashAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            KSATSplashAdapter.this.b();
        }
    }

    class b implements KsLoadManager.SplashScreenAdListener {
        b() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onError(int i, String str) {
            KSATSplashAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onRequestResult(int i) {
            if (((CustomSplashAdapter) KSATSplashAdapter.this).mLoadListener != null) {
                ((CustomSplashAdapter) KSATSplashAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
            double ecpm;
            KSATSplashAdapter.this.c = ksSplashScreenAd;
            if (ksSplashScreenAd != null) {
                KSATSplashAdapter.this.k = KSATInitManager.getInstance().a(ksSplashScreenAd.getMediaExtraInfo(), KSATSplashAdapter.this.k);
            }
            KSATSplashAdapter kSATSplashAdapter = KSATSplashAdapter.this;
            if (!kSATSplashAdapter.j) {
                if (((CustomSplashAdapter) kSATSplashAdapter).mLoadListener != null) {
                    ((CustomSplashAdapter) KSATSplashAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (kSATSplashAdapter.mBiddingListener != null) {
                try {
                    ecpm = ksSplashScreenAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                    ecpm = 0.0d;
                }
                if (ecpm <= 0.0d) {
                    KSATSplashAdapter.this.mBiddingListener.onC2SBidResult(ATBiddingResult.fail("error price: " + ecpm));
                } else {
                    KSATSplashAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, System.currentTimeMillis() + "", new KSATBiddingNotice(ksSplashScreenAd), ATAdConst.CURRENCY.RMB_CENT), null);
                }
            }
        }
    }

    class c implements KsSplashScreenAd.SplashScreenAdInteractionListener {
        c() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdClicked() {
            if (((CustomSplashAdapter) KSATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) KSATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowEnd() {
            ((CustomSplashAdapter) KSATSplashAdapter.this).mDismissType = 3;
            KSATSplashAdapter kSATSplashAdapter = KSATSplashAdapter.this;
            if (kSATSplashAdapter.f || ((CustomSplashAdapter) kSATSplashAdapter).mImpressionListener == null) {
                return;
            }
            KSATSplashAdapter kSATSplashAdapter2 = KSATSplashAdapter.this;
            kSATSplashAdapter2.f = true;
            ((CustomSplashAdapter) kSATSplashAdapter2).mImpressionListener.onSplashAdDismiss();
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowError(int i, String str) {
            Log.e(KSATSplashAdapter.this.a, "onAdShowError: " + i + ", " + str);
            ((CustomSplashAdapter) KSATSplashAdapter.this).mDismissType = 99;
            KSATSplashAdapter kSATSplashAdapter = KSATSplashAdapter.this;
            if (kSATSplashAdapter.f || ((CustomSplashAdapter) kSATSplashAdapter).mImpressionListener == null) {
                return;
            }
            KSATSplashAdapter kSATSplashAdapter2 = KSATSplashAdapter.this;
            kSATSplashAdapter2.f = true;
            ((CustomSplashAdapter) kSATSplashAdapter2).mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "" + i, str));
            ((CustomSplashAdapter) KSATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowStart() {
            try {
                KSATInitManager.getInstance().a(KSATSplashAdapter.this.getShowId(), new WeakReference(KSATSplashAdapter.this.c));
            } catch (Throwable unused) {
            }
            if (((CustomSplashAdapter) KSATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) KSATSplashAdapter.this).mImpressionListener.onSplashAdShow();
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogCancel() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogShow() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onSkippedAd() {
            ((CustomSplashAdapter) KSATSplashAdapter.this).mDismissType = 2;
            KSATSplashAdapter kSATSplashAdapter = KSATSplashAdapter.this;
            if (kSATSplashAdapter.f || ((CustomSplashAdapter) kSATSplashAdapter).mImpressionListener == null) {
                return;
            }
            KSATSplashAdapter kSATSplashAdapter2 = KSATSplashAdapter.this;
            kSATSplashAdapter2.f = true;
            ((CustomSplashAdapter) kSATSplashAdapter2).mImpressionListener.onSplashAdDismiss();
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return KSATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        this.c = null;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.b = ATInitMediation.getLongFromMap(map, "position_id");
        KSATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, 4);
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdInternalAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, KSATAdapter.class);
        map.put(3, KSATInterstitialAdapter.class);
        return map;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.k;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkName() {
        return KSATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        try {
            return String.valueOf(this.b);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return KSATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean isAdReady() {
        KsSplashScreenAd ksSplashScreenAd = this.c;
        return ksSplashScreenAd != null && ksSplashScreenAd.isAdEnable();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (!a(map, map2)) {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        } else {
            this.g = context.getApplicationContext();
            KSATInitManager.getInstance().initSDK(this.g, map, new a());
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        KsSplashScreenAd ksSplashScreenAd = this.c;
        if (ksSplashScreenAd != null) {
            try {
                View view = ksSplashScreenAd.getView(viewGroup.getContext().getApplicationContext(), new c());
                if (this.d) {
                    this.e = view;
                    viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.j = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        b bVar = new b();
        KsScene.Builder builderAdNum = new KsScene.Builder(this.b).adNum(1);
        Boolean boolIsShakeEnabled = ATSDKGlobalSetting.isShakeEnabled(28);
        if (boolIsShakeEnabled != null) {
            SplashAdExtraData splashAdExtraData = new SplashAdExtraData();
            splashAdExtraData.setDisableRotateStatus(!boolIsShakeEnabled.booleanValue());
            splashAdExtraData.setDisableShakeStatus(!boolIsShakeEnabled.booleanValue());
            splashAdExtraData.setDisableSlideStatus(true ^ boolIsShakeEnabled.booleanValue());
            builderAdNum.setSplashExtraData(splashAdExtraData);
        }
        if (!TextUtils.isEmpty(this.h)) {
            builderAdNum.setBidResponseV2(this.h);
        }
        KsAdSDK.getLoadManager().loadSplashScreenAd(builderAdNum.build(), bVar);
    }

    protected void a() {
        CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdClicked();
        }
    }

    private boolean a(Map<String, Object> map, Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        String stringFromMap2 = ATInitMediation.getStringFromMap(map, "position_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(stringFromMap2)) {
            return false;
        }
        try {
            this.b = Long.parseLong(stringFromMap2);
        } catch (NumberFormatException unused) {
        }
        if (map.containsKey("zoomoutad_sw")) {
            this.d = TextUtils.equals("2", ATInitMediation.getStringFromMap(map, "zoomoutad_sw"));
        }
        if (map.containsKey("anythink_gsp")) {
            this.i = ATInitMediation.getDoubleFromMap(map, "anythink_gsp");
        }
        if (!map.containsKey("payload")) {
            return true;
        }
        this.h = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.i);
        return true;
    }
}
