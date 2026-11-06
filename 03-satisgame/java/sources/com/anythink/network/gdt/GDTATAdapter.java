package com.anythink.network.gdt;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.k;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GDTATAdapter extends CustomNativeAdapter {
    String a;
    String b;
    int c;
    String d;
    int g;
    int h;
    int i;
    int j;
    private int e = -1;
    private int f = -2;
    boolean k = false;
    boolean l = false;

    class a implements com.anythink.network.gdt.a {
        a() {
        }

        @Override // com.anythink.network.gdt.a
        public void notifyError(String str, String str2) {
            GDTATAdapter.this.notifyATLoadFail(str, str2);
        }

        @Override // com.anythink.network.gdt.a
        public void notifyLoaded(CustomNativeAd... customNativeAdArr) {
            GDTATAdapter gDTATAdapter = GDTATAdapter.this;
            if (gDTATAdapter.k) {
                CustomNativeAd customNativeAd = customNativeAdArr[0];
                if (customNativeAd instanceof GDTATNativeExpressAd) {
                    GDTATNativeExpressAd gDTATNativeExpressAd = (GDTATNativeExpressAd) customNativeAd;
                    if (gDTATAdapter.mBiddingListener != null) {
                        GDTATAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(gDTATNativeExpressAd.b.getECPM(), System.currentTimeMillis() + "", new GDTATBiddingNotice(gDTATNativeExpressAd), ATAdConst.CURRENCY.RMB_CENT), gDTATNativeExpressAd);
                        return;
                    }
                    return;
                }
            }
            if (((CustomNativeAdapter) gDTATAdapter).mLoadListener != null) {
                ((CustomNativeAdapter) GDTATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
            }
        }
    }

    class b implements NativeADUnifiedListener {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            ArrayList arrayList = new ArrayList();
            if (list == null || list.size() <= 0) {
                GDTATAdapter.this.notifyATLoadFail("", "Ad list is empty");
                return;
            }
            GDTATNativePatchAd gDTATNativePatchAd = null;
            GDTATNativeAd gDTATNativeAd = null;
            for (NativeUnifiedADData nativeUnifiedADData : list) {
                if (GDTATAdapter.this.g == 4) {
                    Context context = this.a;
                    GDTATAdapter gDTATAdapter = GDTATAdapter.this;
                    gDTATNativePatchAd = new GDTATNativePatchAd(context, nativeUnifiedADData, gDTATAdapter.h, gDTATAdapter.i, gDTATAdapter.j, gDTATAdapter.l);
                    arrayList.add(gDTATNativePatchAd);
                } else {
                    Context context2 = this.a;
                    GDTATAdapter gDTATAdapter2 = GDTATAdapter.this;
                    gDTATNativeAd = new GDTATNativeAd(context2, nativeUnifiedADData, gDTATAdapter2.h, gDTATAdapter2.i, gDTATAdapter2.j, gDTATAdapter2.l);
                    arrayList.add(gDTATNativeAd);
                }
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            GDTATAdapter gDTATAdapter3 = GDTATAdapter.this;
            if (!gDTATAdapter3.k) {
                if (((CustomNativeAdapter) gDTATAdapter3).mLoadListener != null) {
                    ((CustomNativeAdapter) GDTATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
                }
            } else if (gDTATAdapter3.mBiddingListener != null) {
                if (gDTATAdapter3.g == 4 && gDTATNativePatchAd != null) {
                    GDTATAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(gDTATNativePatchAd.c.getECPM(), System.currentTimeMillis() + "", new GDTATBiddingNotice(gDTATNativePatchAd), ATAdConst.CURRENCY.RMB_CENT), gDTATNativePatchAd);
                } else if (gDTATNativeAd != null) {
                    GDTATAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(gDTATNativeAd.c.getECPM(), System.currentTimeMillis() + "", new GDTATBiddingNotice(gDTATNativeAd), ATAdConst.CURRENCY.RMB_CENT), gDTATNativeAd);
                }
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            GDTATAdapter.this.notifyATLoadFail(adError.getErrorCode() + "", adError.getErrorMsg());
        }
    }

    class c implements MediationInitCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;
        final /* synthetic */ Map c;

        c(Context context, Map map, Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            GDTATAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            GDTATAdapter.this.a(this.a, this.b, this.c);
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return GDTATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter
    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(map, map2);
        if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else {
            GDTATInitManager.getInstance().initSDK(context, map, new c(context, map, map2));
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.k = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        try {
            GDTATInitManager.getInstance().setExtraUserData(map2);
            int i = this.g;
            if (i != 2 && i != 4) {
                a aVar = new a();
                if (this.g == 3) {
                    new GDTATNativeExpressPatchAd(context, this.b, this.e, this.f, this.h, this.i, this.j, this.d).a(aVar, GDTATInitManager.getInstance().a(map));
                } else {
                    new GDTATNativeExpressAd(context, this.b, this.e, this.f, this.h, this.i, this.j, this.d).a(aVar, GDTATInitManager.getInstance().a(map));
                }
            } else {
                a(context.getApplicationContext(), map);
            }
        } catch (Throwable th) {
            notifyATLoadFail("", th.getMessage());
        }
    }

    private void a(Context context, Map<String, Object> map) {
        NativeUnifiedAD nativeUnifiedAD;
        b bVar = new b(context);
        if (TextUtils.isEmpty(this.d)) {
            nativeUnifiedAD = new NativeUnifiedAD(context, this.b, bVar);
        } else {
            nativeUnifiedAD = new NativeUnifiedAD(context, this.b, bVar, this.d);
        }
        int i = this.j;
        if (i != -1) {
            nativeUnifiedAD.setMaxVideoDuration(i);
        }
        if (TextUtils.isEmpty(this.d)) {
            LoadAdParams loadAdParamsA = GDTATInitManager.getInstance().a(map);
            if (loadAdParamsA != null) {
                nativeUnifiedAD.loadData(this.c, loadAdParamsA);
                return;
            } else {
                nativeUnifiedAD.loadData(this.c);
                return;
            }
        }
        nativeUnifiedAD.loadData(this.c);
    }

    void a(Map<String, Object> map, Map<String, Object> map2) {
        this.a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        this.g = ATInitMediation.getIntFromMap(map, "unit_type");
        this.d = ATInitMediation.getStringFromMap(map, "payload");
        this.c = this.k ? 1 : this.mRequestNum;
        try {
            this.e = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_WIDTH, -1);
            if (map2.containsKey(GDTATConst.AD_HEIGHT)) {
                this.f = ATInitMediation.getIntFromMap(map2, GDTATConst.AD_HEIGHT, -2);
            } else if (map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
                this.f = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_HEIGHT, -2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        this.h = intFromMap;
        this.i = intFromMap2;
        this.j = intFromMap3;
        this.l = ATInitMediation.getIntFromMap(map, k.aK, -1) == 2;
    }
}
