package com.anythink.network.ks;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.banner.unitgroup.api.CustomBannerEventListener;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDKUtils;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.h.y;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class KSATBannerAdapter extends CustomBannerAdapter {
    static final String k = "KSATBannerAdapter";
    long a;
    String b;
    int c;
    KsLoadManager.BannerAdListener d;
    KsBannerAd.BannerAdInteractionListener e;
    View f;
    boolean g;
    String h;
    double i;
    private Map<String, Object> j;

    class a implements MediationInitCallback {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            KSATBannerAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            KSATBannerAdapter.this.a(this.a);
        }
    }

    class b implements KsLoadManager.BannerAdListener {
        final /* synthetic */ Context a;

        class a implements KsBannerAd.BannerAdInteractionListener {
            a() {
            }

            @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
            public void onAdClicked() {
                CustomBannerEventListener customBannerEventListener = KSATBannerAdapter.this.mImpressionEventListener;
                if (customBannerEventListener != null) {
                    customBannerEventListener.onBannerAdClicked();
                }
            }

            @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
            public void onAdClose() {
                CustomBannerEventListener customBannerEventListener = KSATBannerAdapter.this.mImpressionEventListener;
                if (customBannerEventListener != null) {
                    customBannerEventListener.onBannerAdClose();
                }
            }

            @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
            public void onAdShow() {
                CustomBannerEventListener customBannerEventListener = KSATBannerAdapter.this.mImpressionEventListener;
                if (customBannerEventListener != null) {
                    customBannerEventListener.onBannerAdShow();
                }
            }

            @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
            public void onAdShowError(int i, String str) {
                Log.e(KSATBannerAdapter.k, "onAdShowError: " + i + ", " + str);
            }
        }

        b(Context context) {
            this.a = context;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.BannerAdListener
        public void onBannerAdLoad(KsBannerAd ksBannerAd) {
            double ecpm;
            if (ksBannerAd == null) {
                KSATBannerAdapter.this.notifyATLoadFail("", "Kuaishou banner ad is null");
                return;
            }
            KSATBannerAdapter.this.j = KSATInitManager.getInstance().a(ksBannerAd.getMediaExtraInfo(), KSATBannerAdapter.this.j);
            KsAdVideoPlayConfig ksAdVideoPlayConfigBuild = new KsAdVideoPlayConfig.Builder().build();
            KSATBannerAdapter.this.e = new a();
            KSATBannerAdapter kSATBannerAdapter = KSATBannerAdapter.this;
            kSATBannerAdapter.f = ksBannerAd.getView(this.a, kSATBannerAdapter.e, ksAdVideoPlayConfigBuild);
            KSATBannerAdapter kSATBannerAdapter2 = KSATBannerAdapter.this;
            if (kSATBannerAdapter2.f == null) {
                kSATBannerAdapter2.notifyATLoadFail("", "Kuaishou: banner view is null");
                return;
            }
            KSATBannerAdapter.this.f.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            KSATBannerAdapter kSATBannerAdapter3 = KSATBannerAdapter.this;
            if (!kSATBannerAdapter3.g) {
                if (((CustomBannerAdapter) kSATBannerAdapter3).mLoadListener != null) {
                    ((CustomBannerAdapter) KSATBannerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (kSATBannerAdapter3.mBiddingListener != null) {
                try {
                    ecpm = ksBannerAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                    ecpm = 0.0d;
                }
                if (ecpm <= 0.0d) {
                    KSATBannerAdapter.this.mBiddingListener.onC2SBidResult(ATBiddingResult.fail("error price: " + ecpm));
                } else {
                    KSATBannerAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, System.currentTimeMillis() + "", new KSATBiddingNotice(ksBannerAd), ATAdConst.CURRENCY.RMB_CENT), null);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.BannerAdListener
        public void onError(int i, String str) {
            KSATBannerAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return KSATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        this.d = null;
        this.e = null;
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.f;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        KSATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, 2);
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdInternalAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, KSATAdapter.class);
        return map;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.j;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkName() {
        return KSATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        try {
            return String.valueOf(this.a);
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
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (!a(context, map, map2)) {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        } else {
            Context applicationContext = context.getApplicationContext();
            KSATInitManager.getInstance().initSDK(applicationContext, map, new a(applicationContext));
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.g = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        KsScene.Builder builder = new KsScene.Builder(this.a);
        if (this.c > 0) {
            builder.width(this.c);
        }
        if (!TextUtils.isEmpty(this.h)) {
            builder.setBidResponseV2(this.h);
        }
        KsScene ksSceneBuild = builder.build();
        this.d = new b(context);
        KsAdSDK.getLoadManager().loadBannerAd(ksSceneBuild, this.d);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0076  */
    private boolean a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        String stringFromMap2 = ATInitMediation.getStringFromMap(map, "position_id");
        byte b2 = 0;
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(stringFromMap2)) {
            return false;
        }
        try {
            this.a = Long.parseLong(stringFromMap2);
        } catch (NumberFormatException unused) {
        }
        int intFromMap = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_WIDTH, 0);
        if (intFromMap > 0) {
            this.c = intFromMap;
        } else {
            String stringFromMap3 = ATInitMediation.getStringFromMap(map, "size", y.a);
            int iHashCode = stringFromMap3.hashCode();
            if (iHashCode != -559800631) {
                if (iHashCode != 1505962662) {
                    if (iHashCode != 1505962755) {
                        if (iHashCode == 1507809704 && stringFromMap3.equals("320x45")) {
                            b2 = 3;
                        } else {
                            b2 = -1;
                        }
                    } else if (stringFromMap3.equals("300x75")) {
                        b2 = 1;
                    } else {
                        b2 = -1;
                    }
                } else if (!stringFromMap3.equals("300x45")) {
                    b2 = -1;
                }
            } else if (stringFromMap3.equals("300x130")) {
                b2 = 2;
            } else {
                b2 = -1;
            }
            if (b2 != 0 && b2 != 1 && b2 != 2) {
                this.c = ATSDKUtils.dip2px(context, 320.0f);
            } else {
                this.c = ATSDKUtils.dip2px(context, 300.0f);
            }
        }
        if (map.containsKey("anythink_gsp")) {
            this.i = ATInitMediation.getDoubleFromMap(map, "anythink_gsp");
        }
        if (map.containsKey("payload")) {
            this.h = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.i);
        }
        return true;
    }
}
