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
    int e;
    int f;
    int g;
    int h;
    private int k = -1;
    private int l = -2;
    boolean i = false;
    boolean j = false;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        NativeUnifiedAD nativeUnifiedAD;
        try {
            GDTATInitManager.getInstance().setExtraUserData(map2);
            int i = this.e;
            if (i == 2 || i == 4) {
                Context applicationContext = context.getApplicationContext();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(applicationContext);
                if (TextUtils.isEmpty(this.d)) {
                    nativeUnifiedAD = new NativeUnifiedAD(applicationContext, this.b, anonymousClass2);
                } else {
                    nativeUnifiedAD = new NativeUnifiedAD(applicationContext, this.b, anonymousClass2, this.d);
                }
                int i2 = this.h;
                if (i2 != -1) {
                    nativeUnifiedAD.setMaxVideoDuration(i2);
                }
                if (TextUtils.isEmpty(this.d)) {
                    GDTATInitManager.getInstance();
                    nativeUnifiedAD.loadData(this.c, GDTATInitManager.a(map));
                    return;
                }
                nativeUnifiedAD.loadData(this.c);
                return;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            if (this.e == 3) {
                GDTATNativeExpressPatchAd gDTATNativeExpressPatchAd = new GDTATNativeExpressPatchAd(context, this.b, this.k, this.l, this.f, this.g, this.h, this.d);
                GDTATInitManager.getInstance();
                gDTATNativeExpressPatchAd.a(anonymousClass1, GDTATInitManager.a(map));
            } else {
                GDTATNativeExpressAd gDTATNativeExpressAd = new GDTATNativeExpressAd(context, this.b, this.k, this.l, this.f, this.g, this.h, this.d);
                GDTATInitManager.getInstance();
                gDTATNativeExpressAd.a(anonymousClass1, GDTATInitManager.a(map));
            }
        } catch (Throwable th) {
            notifyATLoadFail("", th.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements a {
        AnonymousClass1() {
        }

        @Override // com.anythink.network.gdt.a
        public final void notifyLoaded(CustomNativeAd... customNativeAdArr) {
            if (GDTATAdapter.this.i) {
                CustomNativeAd customNativeAd = customNativeAdArr[0];
                if (customNativeAd instanceof GDTATNativeExpressAd) {
                    GDTATNativeExpressAd gDTATNativeExpressAd = (GDTATNativeExpressAd) customNativeAd;
                    if (GDTATAdapter.this.mBiddingListener != null) {
                        GDTATAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(gDTATNativeExpressAd.b.getECPM(), new StringBuilder().append(System.currentTimeMillis()).toString(), new GDTATBiddingNotice(gDTATNativeExpressAd), ATAdConst.CURRENCY.RMB_CENT), gDTATNativeExpressAd);
                        return;
                    }
                    return;
                }
            }
            if (GDTATAdapter.this.mLoadListener != null) {
                GDTATAdapter.this.mLoadListener.onAdCacheLoaded(customNativeAdArr);
            }
        }

        @Override // com.anythink.network.gdt.a
        public final void notifyError(String str, String str2) {
            GDTATAdapter.this.notifyATLoadFail(str, str2);
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements NativeADUnifiedListener {
        final /* synthetic */ Context a;

        AnonymousClass2(Context context) {
            this.a = context;
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public final void onADLoaded(List<NativeUnifiedADData> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                GDTATNativePatchAd gDTATNativePatchAd = null;
                GDTATNativeAd gDTATNativeAd = null;
                for (NativeUnifiedADData nativeUnifiedADData : list) {
                    if (GDTATAdapter.this.e == 4) {
                        gDTATNativePatchAd = new GDTATNativePatchAd(this.a, nativeUnifiedADData, GDTATAdapter.this.f, GDTATAdapter.this.g, GDTATAdapter.this.h, GDTATAdapter.this.j);
                        arrayList.add(gDTATNativePatchAd);
                    } else {
                        gDTATNativeAd = new GDTATNativeAd(this.a, nativeUnifiedADData, GDTATAdapter.this.f, GDTATAdapter.this.g, GDTATAdapter.this.h, GDTATAdapter.this.j);
                        arrayList.add(gDTATNativeAd);
                    }
                }
                CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
                if (!GDTATAdapter.this.i) {
                    if (GDTATAdapter.this.mLoadListener != null) {
                        GDTATAdapter.this.mLoadListener.onAdCacheLoaded(customNativeAdArr);
                        return;
                    }
                    return;
                } else {
                    if (GDTATAdapter.this.mBiddingListener != null) {
                        if (GDTATAdapter.this.e == 4 && gDTATNativePatchAd != null) {
                            GDTATAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(gDTATNativePatchAd.c.getECPM(), new StringBuilder().append(System.currentTimeMillis()).toString(), new GDTATBiddingNotice(gDTATNativePatchAd), ATAdConst.CURRENCY.RMB_CENT), gDTATNativePatchAd);
                            return;
                        } else {
                            if (gDTATNativeAd != null) {
                                GDTATAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(gDTATNativeAd.c.getECPM(), new StringBuilder().append(System.currentTimeMillis()).toString(), new GDTATBiddingNotice(gDTATNativeAd), ATAdConst.CURRENCY.RMB_CENT), gDTATNativeAd);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
            }
            GDTATAdapter.this.notifyATLoadFail("", "Ad list is empty");
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public final void onNoAD(AdError adError) {
            GDTATAdapter.this.notifyATLoadFail(new StringBuilder().append(adError.getErrorCode()).toString(), adError.getErrorMsg());
        }
    }

    private void a(Context context, Map<String, Object> map) {
        NativeUnifiedAD nativeUnifiedAD;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(context);
        if (TextUtils.isEmpty(this.d)) {
            nativeUnifiedAD = new NativeUnifiedAD(context, this.b, anonymousClass2);
        } else {
            nativeUnifiedAD = new NativeUnifiedAD(context, this.b, anonymousClass2, this.d);
        }
        int i = this.h;
        if (i != -1) {
            nativeUnifiedAD.setMaxVideoDuration(i);
        }
        if (TextUtils.isEmpty(this.d)) {
            GDTATInitManager.getInstance();
            nativeUnifiedAD.loadData(this.c, GDTATInitManager.a(map));
            return;
        }
        nativeUnifiedAD.loadData(this.c);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_type");
        this.d = ATInitMediation.getStringFromMap(map, "payload");
        this.c = this.i ? 1 : this.mRequestNum;
        try {
            this.k = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_WIDTH, -1);
            if (map2.containsKey(GDTATConst.AD_HEIGHT)) {
                this.l = ATInitMediation.getIntFromMap(map2, GDTATConst.AD_HEIGHT, -2);
            } else if (map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
                this.l = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_HEIGHT, -2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        this.f = intFromMap;
        this.g = intFromMap2;
        this.h = intFromMap3;
        this.j = ATInitMediation.getIntFromMap(map, k.aJ, -1) == 2;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.i = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_type");
        this.d = ATInitMediation.getStringFromMap(map, "payload");
        this.c = this.i ? 1 : this.mRequestNum;
        try {
            this.k = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_WIDTH, -1);
            if (map2.containsKey(GDTATConst.AD_HEIGHT)) {
                this.l = ATInitMediation.getIntFromMap(map2, GDTATConst.AD_HEIGHT, -2);
            } else if (map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
                this.l = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_HEIGHT, -2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        this.f = intFromMap;
        this.g = intFromMap2;
        this.h = intFromMap3;
        this.j = ATInitMediation.getIntFromMap(map, k.aJ, -1) == 2;
        if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else {
            GDTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATAdapter.3
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    GDTATAdapter.a(GDTATAdapter.this, context, map, map2);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    GDTATAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    static /* synthetic */ void a(GDTATAdapter gDTATAdapter, Context context, Map map, Map map2) {
        NativeUnifiedAD nativeUnifiedAD;
        try {
            GDTATInitManager.getInstance().setExtraUserData(map2);
            int i = gDTATAdapter.e;
            if (i == 2 || i == 4) {
                Context applicationContext = context.getApplicationContext();
                AnonymousClass2 anonymousClass2 = gDTATAdapter.new AnonymousClass2(applicationContext);
                if (TextUtils.isEmpty(gDTATAdapter.d)) {
                    nativeUnifiedAD = new NativeUnifiedAD(applicationContext, gDTATAdapter.b, anonymousClass2);
                } else {
                    nativeUnifiedAD = new NativeUnifiedAD(applicationContext, gDTATAdapter.b, anonymousClass2, gDTATAdapter.d);
                }
                int i2 = gDTATAdapter.h;
                if (i2 != -1) {
                    nativeUnifiedAD.setMaxVideoDuration(i2);
                }
                if (TextUtils.isEmpty(gDTATAdapter.d)) {
                    GDTATInitManager.getInstance();
                    nativeUnifiedAD.loadData(gDTATAdapter.c, GDTATInitManager.a((Map<String, Object>) map));
                    return;
                }
                nativeUnifiedAD.loadData(gDTATAdapter.c);
                return;
            }
            AnonymousClass1 anonymousClass1 = gDTATAdapter.new AnonymousClass1();
            if (gDTATAdapter.e == 3) {
                GDTATNativeExpressPatchAd gDTATNativeExpressPatchAd = new GDTATNativeExpressPatchAd(context, gDTATAdapter.b, gDTATAdapter.k, gDTATAdapter.l, gDTATAdapter.f, gDTATAdapter.g, gDTATAdapter.h, gDTATAdapter.d);
                GDTATInitManager.getInstance();
                gDTATNativeExpressPatchAd.a(anonymousClass1, GDTATInitManager.a((Map<String, Object>) map));
            } else {
                GDTATNativeExpressAd gDTATNativeExpressAd = new GDTATNativeExpressAd(context, gDTATAdapter.b, gDTATAdapter.k, gDTATAdapter.l, gDTATAdapter.f, gDTATAdapter.g, gDTATAdapter.h, gDTATAdapter.d);
                GDTATInitManager.getInstance();
                gDTATNativeExpressAd.a(anonymousClass1, GDTATInitManager.a((Map<String, Object>) map));
            }
        } catch (Throwable th) {
            gDTATAdapter.notifyATLoadFail("", th.getMessage());
        }
    }
}
