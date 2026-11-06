package com.anythink.network.ks;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.k;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.NativeAdExtraData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class KSATAdapter extends CustomNativeAdapter {
    long a;
    String e;
    Context f;
    boolean g;
    double h;
    String b = "0";
    boolean c = false;
    String d = "0";
    boolean i = false;
    boolean j = false;
    int k = -1;
    int l = -1;

    class a implements MediationInitCallback {
        final /* synthetic */ Map a;

        a(Map map) {
            this.a = map;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            KSATAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            KSATAdapter kSATAdapter = KSATAdapter.this;
            kSATAdapter.a(kSATAdapter.f, this.a, ((CustomNativeAdapter) kSATAdapter).mRequestNum);
        }
    }

    class b implements KsLoadManager.DrawAdListener {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onDrawAdLoad(List<KsDrawAd> list) {
            double ecpm;
            if (list == null || list.isEmpty()) {
                KSATAdapter.this.notifyATLoadFail("", "kuaishou no fill");
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<KsDrawAd> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new KSATDrawAd(this.a, it.next(), KSATAdapter.this.c));
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            KSATAdapter kSATAdapter = KSATAdapter.this;
            if (!kSATAdapter.g) {
                if (((CustomNativeAdapter) kSATAdapter).mLoadListener != null) {
                    ((CustomNativeAdapter) KSATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            KsDrawAd ksDrawAd = list.get(0);
            if (KSATAdapter.this.mBiddingListener != null) {
                try {
                    ecpm = ksDrawAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                    ecpm = 0.0d;
                }
                if (ecpm <= 0.0d) {
                    KSATAdapter.this.mBiddingListener.onC2SBidResult(ATBiddingResult.fail("error price: " + ecpm));
                } else {
                    KSATAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, System.currentTimeMillis() + "", new KSATBiddingNotice(ksDrawAd), ATAdConst.CURRENCY.RMB_CENT), customNativeAdArr[0]);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onError(int i, String str) {
            KSATAdapter.this.notifyATLoadFail(i + "", str);
        }
    }

    class c implements KsLoadManager.FeedAdListener {
        final /* synthetic */ Context a;

        c(Context context) {
            this.a = context;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i, String str) {
            KSATAdapter.this.notifyATLoadFail(i + "", str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(List<KsFeedAd> list) {
            double ecpm;
            if (list == null || list.size() == 0) {
                KSATAdapter.this.notifyATLoadFail("", "kuaishou no fill");
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<KsFeedAd> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new KSATFeedAd(this.a, it.next(), KSATAdapter.this.c));
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            KSATAdapter kSATAdapter = KSATAdapter.this;
            if (!kSATAdapter.g) {
                if (((CustomNativeAdapter) kSATAdapter).mLoadListener != null) {
                    ((CustomNativeAdapter) KSATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            KsFeedAd ksFeedAd = list.get(0);
            if (KSATAdapter.this.mBiddingListener != null) {
                try {
                    ecpm = ksFeedAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                    ecpm = 0.0d;
                }
                if (ecpm <= 0.0d) {
                    KSATAdapter.this.mBiddingListener.onC2SBidResult(ATBiddingResult.fail("error price: " + ecpm));
                } else {
                    KSATAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, System.currentTimeMillis() + "", new KSATBiddingNotice(ksFeedAd), ATAdConst.CURRENCY.RMB_CENT), customNativeAdArr[0]);
                }
            }
        }
    }

    class d implements KsLoadManager.NativeAdListener {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;

        d(Context context, Map map) {
            this.a = context;
            this.b = map;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i, String str) {
            KSATAdapter.this.notifyATLoadFail(i + "", str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(List<KsNativeAd> list) {
            double ecpm;
            if (list == null || list.size() == 0) {
                KSATAdapter.this.notifyATLoadFail("", "kuaishou no fill");
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<KsNativeAd> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new KSATNativeAd(this.a, it.next(), KSATAdapter.this.c, this.b));
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            KSATAdapter kSATAdapter = KSATAdapter.this;
            if (!kSATAdapter.g) {
                if (((CustomNativeAdapter) kSATAdapter).mLoadListener != null) {
                    ((CustomNativeAdapter) KSATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            KsNativeAd ksNativeAd = list.get(0);
            if (KSATAdapter.this.mBiddingListener != null) {
                try {
                    ecpm = ksNativeAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                    ecpm = 0.0d;
                }
                if (ecpm <= 0.0d) {
                    KSATAdapter.this.mBiddingListener.onC2SBidResult(ATBiddingResult.fail("error price: " + ecpm));
                } else {
                    KSATAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, System.currentTimeMillis() + "", new KSATBiddingNotice(ksNativeAd), ATAdConst.CURRENCY.RMB_CENT), customNativeAdArr[0]);
                }
            }
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return KSATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.a = ATInitMediation.getLongFromMap(map, "position_id");
        KSATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener, 0);
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
        if (!a(map, map2)) {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        } else {
            this.f = context.getApplicationContext();
            KSATInitManager.getInstance().initSDK(context, map, new a(map2));
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.g = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Map<String, Object> map, int i) {
        int i2;
        Object obj = map.containsKey(ATAdConst.KEY.AD_WIDTH) ? map.get(ATAdConst.KEY.AD_WIDTH) : null;
        Object obj2 = map.containsKey(ATAdConst.KEY.AD_HEIGHT) ? map.get(ATAdConst.KEY.AD_HEIGHT) : null;
        KsScene.Builder builderAdNum = new KsScene.Builder(this.a).adNum(this.g ? 1 : Math.min(i, 5));
        NativeAdExtraData nativeAdExtraData = new NativeAdExtraData();
        Boolean boolIsShakeEnabled = ATSDKGlobalSetting.isShakeEnabled(28);
        if (boolIsShakeEnabled != null) {
            nativeAdExtraData.setEnableShake(boolIsShakeEnabled.booleanValue());
            nativeAdExtraData.setEnableRotate(boolIsShakeEnabled.booleanValue());
        } else {
            nativeAdExtraData.setEnableShake(this.i);
            nativeAdExtraData.setEnableRotate(this.j);
        }
        if (TextUtils.equals("0", this.d) && TextUtils.equals("0", this.b) && ((i2 = this.k) >= 0 || this.l >= 0)) {
            if (i2 >= 0) {
                nativeAdExtraData.setShowLiveStatus(i2);
            }
            int i3 = this.l;
            if (i3 >= 0) {
                nativeAdExtraData.setShowLiveStyle(i3);
            }
        }
        builderAdNum.setNativeAdExtraData(nativeAdExtraData);
        if (obj != null) {
            try {
                int i4 = (int) Double.parseDouble(obj.toString());
                if (i4 > 0) {
                    builderAdNum.width(i4);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (obj2 != null) {
            try {
                int i5 = (int) Double.parseDouble(obj2.toString());
                if (i5 > 0) {
                    builderAdNum.height(i5);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.e)) {
            builderAdNum.setBidResponseV2(this.e);
            builderAdNum.adNum(1);
        }
        KsScene ksSceneBuild = builderAdNum.build();
        if (TextUtils.equals("1", this.d)) {
            KsAdSDK.getLoadManager().loadDrawAd(ksSceneBuild, new b(context));
        } else if (TextUtils.equals("1", this.b)) {
            KsAdSDK.getLoadManager().loadConfigFeedAd(ksSceneBuild, new c(context));
        } else {
            KsAdSDK.getLoadManager().loadNativeAd(ksSceneBuild, new d(context, map));
        }
    }

    private boolean a(Map<String, Object> map, Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        String stringFromMap2 = ATInitMediation.getStringFromMap(map, "position_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(stringFromMap2)) {
            return false;
        }
        try {
            this.a = Long.parseLong(stringFromMap2);
        } catch (NumberFormatException unused) {
        }
        this.b = ATInitMediation.getStringFromMap(map, "layout_type", "0");
        if (map.containsKey("video_sound")) {
            this.c = TextUtils.equals("1", ATInitMediation.getStringFromMap(map, "video_sound"));
        }
        Boolean bool = ATSDKGlobalSetting.isGlobalMute;
        if (bool != null) {
            this.c = !bool.booleanValue();
        }
        this.d = ATInitMediation.getStringFromMap(map, "unit_type", "0");
        this.h = ATInitMediation.getDoubleFromMap(map, "anythink_gsp");
        if (map.containsKey("payload")) {
            this.e = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.h);
        }
        this.i = ATInitMediation.getIntFromMap(map, k.aH) == 1;
        this.j = ATInitMediation.getIntFromMap(map, "rotate_type") == 1;
        this.k = ATInitMediation.getIntFromMap(map2, KSATConst.NATIVE_SHOW_LIVE_STATUS, -1);
        this.l = ATInitMediation.getIntFromMap(map2, KSATConst.NATIVE_SHOW_LIVE_STYLE, -1);
        return true;
    }
}
