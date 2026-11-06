package com.anythink.network.ks;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDKUtils;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.d.j;
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
    static final String a = "KSATBannerAdapter";
    long b;
    String c;
    int d;
    KsLoadManager.BannerAdListener e;
    KsBannerAd.BannerAdInteractionListener f;
    View g;
    boolean h;
    String i;
    double j;

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.g;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (!a(context, map, map2)) {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        } else {
            final Context applicationContext = context.getApplicationContext();
            KSATInitManager.getInstance().initSDK(applicationContext, map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATBannerAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    KSATBannerAdapter.a(KSATBannerAdapter.this, applicationContext);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    KSATBannerAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    private void a(Context context) {
        KsScene.Builder builder = new KsScene.Builder(this.b);
        if (this.d > 0) {
            builder.width(this.d);
        }
        if (!TextUtils.isEmpty(this.i)) {
            builder.setBidResponseV2(this.i);
        }
        KsScene ksSceneBuild = builder.build();
        this.e = new AnonymousClass2(context);
        KsAdSDK.getLoadManager().loadBannerAd(ksSceneBuild, this.e);
    }

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATBannerAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements KsLoadManager.BannerAdListener {
        final /* synthetic */ Context a;

        AnonymousClass2(Context context) {
            this.a = context;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.BannerAdListener
        public final void onError(int i, String str) {
            KSATBannerAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.BannerAdListener
        public final void onBannerAdLoad(KsBannerAd ksBannerAd) {
            double ecpm;
            if (ksBannerAd == null) {
                KSATBannerAdapter.this.notifyATLoadFail("", "Kuaishou banner ad is null");
                return;
            }
            KsAdVideoPlayConfig ksAdVideoPlayConfigBuild = new KsAdVideoPlayConfig.Builder().build();
            KSATBannerAdapter.this.f = new KsBannerAd.BannerAdInteractionListener() { // from class: com.anythink.network.ks.KSATBannerAdapter.2.1
                @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
                public final void onAdClicked() {
                    if (KSATBannerAdapter.this.mImpressionEventListener != null) {
                        KSATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
                public final void onAdShow() {
                    if (KSATBannerAdapter.this.mImpressionEventListener != null) {
                        KSATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
                    }
                }

                @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
                public final void onAdClose() {
                    if (KSATBannerAdapter.this.mImpressionEventListener != null) {
                        KSATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
                    }
                }

                @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
                public final void onAdShowError(int i, String str) {
                    Log.e(KSATBannerAdapter.a, "onAdShowError: " + i + ", " + str);
                }
            };
            KSATBannerAdapter kSATBannerAdapter = KSATBannerAdapter.this;
            kSATBannerAdapter.g = ksBannerAd.getView(this.a, kSATBannerAdapter.f, ksAdVideoPlayConfigBuild);
            if (KSATBannerAdapter.this.g == null) {
                KSATBannerAdapter.this.notifyATLoadFail("", "Kuaishou: banner view is null");
                return;
            }
            KSATBannerAdapter.this.g.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            if (!KSATBannerAdapter.this.h) {
                if (KSATBannerAdapter.this.mLoadListener != null) {
                    KSATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (KSATBannerAdapter.this.mBiddingListener != null) {
                try {
                    ecpm = ksBannerAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                    ecpm = 0.0d;
                }
                if (ecpm <= 0.0d) {
                    KSATBannerAdapter.this.mBiddingListener.onC2SBidResult(ATBiddingResult.fail("error price: ".concat(String.valueOf(ecpm))));
                } else {
                    KSATBannerAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, new StringBuilder().append(System.currentTimeMillis()).toString(), new KSATBiddingNotice(ksBannerAd), ATAdConst.CURRENCY.RMB_CENT), null);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0057  */
    private boolean a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        String stringFromMap2 = ATInitMediation.getStringFromMap(map, "position_id");
        byte b = 0;
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(stringFromMap2)) {
            return false;
        }
        try {
            this.b = Long.parseLong(stringFromMap2);
        } catch (NumberFormatException unused) {
        }
        int intFromMap = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_WIDTH, 0);
        if (intFromMap > 0) {
            this.d = intFromMap;
        } else {
            String stringFromMap3 = ATInitMediation.getStringFromMap(map, "size", y.a);
            int iHashCode = stringFromMap3.hashCode();
            if (iHashCode != 1505962662) {
                if (iHashCode == 1507809704 && stringFromMap3.equals("320x45")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (!stringFromMap3.equals("300x45")) {
                b = -1;
            }
            if (b == 0) {
                this.d = ATSDKUtils.dip2px(context, 300.0f);
            } else {
                this.d = ATSDKUtils.dip2px(context, 320.0f);
            }
        }
        if (map.containsKey(j.w.m)) {
            this.j = ATInitMediation.getDoubleFromMap(map, j.w.m);
        }
        if (map.containsKey("payload")) {
            this.i = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.j);
        }
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        KSATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, 2);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        this.e = null;
        this.f = null;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        try {
            return String.valueOf(this.b);
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

    @Override // com.anythink.core.api.ATBaseAdInternalAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, KSATAdapter.class);
        return map;
    }

    static /* synthetic */ void a(KSATBannerAdapter kSATBannerAdapter, Context context) {
        KsScene.Builder builder = new KsScene.Builder(kSATBannerAdapter.b);
        if (kSATBannerAdapter.d > 0) {
            builder.width(kSATBannerAdapter.d);
        }
        if (!TextUtils.isEmpty(kSATBannerAdapter.i)) {
            builder.setBidResponseV2(kSATBannerAdapter.i);
        }
        KsScene ksSceneBuild = builder.build();
        kSATBannerAdapter.e = kSATBannerAdapter.new AnonymousClass2(context);
        KsAdSDK.getLoadManager().loadBannerAd(ksSceneBuild, kSATBannerAdapter.e);
    }
}
