package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.banner.unitgroup.api.CustomBannerEventListener;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GDTATBannerAdapter extends CustomBannerAdapter {
    String b;
    String c;
    String d;
    UnifiedBannerView e;
    int g;
    boolean h;
    boolean i;
    private Map<String, Object> j;
    private final String a = "GDTATBannerAdapter";
    int f = 0;
    DownloadConfirmListener k = new a();

    class a implements DownloadConfirmListener {
        a() {
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmListener
        public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
            if (GDTATBannerAdapter.this.mImpressionEventListener != null) {
                GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                gDTDownloadFirmInfo.appInfoUrl = str;
                gDTDownloadFirmInfo.scenes = i;
                gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                GDTATBannerAdapter.this.mImpressionEventListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
            }
        }
    }

    class b implements UnifiedBannerADListener {
        b() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            CustomBannerEventListener customBannerEventListener = GDTATBannerAdapter.this.mImpressionEventListener;
            if (customBannerEventListener != null) {
                customBannerEventListener.onBannerAdClicked();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            CustomBannerEventListener customBannerEventListener = GDTATBannerAdapter.this.mImpressionEventListener;
            if (customBannerEventListener != null) {
                customBannerEventListener.onBannerAdClose();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            try {
                GDTATInitManager.getInstance().a(GDTATBannerAdapter.this.getShowId(), new WeakReference(GDTATBannerAdapter.this.e));
            } catch (Throwable unused) {
            }
            CustomBannerEventListener customBannerEventListener = GDTATBannerAdapter.this.mImpressionEventListener;
            if (customBannerEventListener != null) {
                customBannerEventListener.onBannerAdShow();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            UnifiedBannerView unifiedBannerView;
            GDTATBannerAdapter gDTATBannerAdapter = GDTATBannerAdapter.this;
            if (gDTATBannerAdapter.h && (unifiedBannerView = gDTATBannerAdapter.e) != null) {
                unifiedBannerView.setDownloadConfirmListener(gDTATBannerAdapter.k);
            }
            GDTATBannerAdapter gDTATBannerAdapter2 = GDTATBannerAdapter.this;
            if (gDTATBannerAdapter2.e != null) {
                gDTATBannerAdapter2.j = GDTATInitManager.getInstance().a(GDTATBannerAdapter.this.e.getExtraInfo(), GDTATBannerAdapter.this.j);
            }
            GDTATBannerAdapter gDTATBannerAdapter3 = GDTATBannerAdapter.this;
            if (!gDTATBannerAdapter3.i) {
                if (((CustomBannerAdapter) gDTATBannerAdapter3).mLoadListener != null) {
                    ((CustomBannerAdapter) GDTATBannerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (gDTATBannerAdapter3.mBiddingListener != null) {
                UnifiedBannerView unifiedBannerView2 = gDTATBannerAdapter3.e;
                if (unifiedBannerView2 != null) {
                    GDTATBannerAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(unifiedBannerView2.getECPM(), System.currentTimeMillis() + "", new GDTATBiddingNotice(GDTATBannerAdapter.this.e), ATAdConst.CURRENCY.RMB_CENT), null);
                } else {
                    gDTATBannerAdapter3.notifyATLoadFail("", "GDT: Offer had been destroy.");
                }
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            GDTATBannerAdapter gDTATBannerAdapter = GDTATBannerAdapter.this;
            gDTATBannerAdapter.e = null;
            gDTATBannerAdapter.notifyATLoadFail(String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }
    }

    class c implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;
        final /* synthetic */ Map c;

        class a implements MediationInitCallback {
            a() {
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public void onFail(String str) {
                GDTATBannerAdapter.this.notifyATLoadFail("", str);
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public void onSuccess() {
                c cVar = c.this;
                GDTATBannerAdapter.this.a((Activity) cVar.a, cVar.b, cVar.c);
            }
        }

        c(Context context, Map map, Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        @Override // java.lang.Runnable
        public void run() {
            GDTATInitManager.getInstance().initSDK(this.a, this.b, new a());
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public int baseOnAdapterBridgeVersion() {
        return GDTATInitManager.getInstance().getAdapterBridgeVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void destory() {
        UnifiedBannerView unifiedBannerView = this.e;
        if (unifiedBannerView != null) {
            if (unifiedBannerView instanceof UnifiedBannerView) {
                unifiedBannerView.destroy();
            }
            this.e = null;
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.e;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.c = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdInternalAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, GDTATAdapter.class);
        return map;
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter
    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.j;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.c;
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.bridge.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(map, map2);
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else if (context instanceof Activity) {
            runOnNetworkRequestThread(new c(context, map, map2));
        } else {
            notifyATLoadFail("", "Context must be activity.");
        }
    }

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.i = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, Map<String, Object> map, Map<String, Object> map2) {
        UnifiedBannerView unifiedBannerView;
        GDTATInitManager.getInstance().setExtraUserData(map2);
        b bVar = new b();
        if (!TextUtils.isEmpty(this.d) && !this.i) {
            unifiedBannerView = new UnifiedBannerView(activity, this.c, bVar, null, this.d);
        } else {
            UnifiedBannerView unifiedBannerView2 = new UnifiedBannerView(activity, this.c, bVar);
            LoadAdParams loadAdParamsA = GDTATInitManager.getInstance().a(map);
            if (loadAdParamsA != null) {
                unifiedBannerView2.setLoadAdParams(loadAdParamsA);
            }
            unifiedBannerView = unifiedBannerView2;
        }
        int i = this.g;
        if (i > 0) {
            unifiedBannerView.setRefresh(i);
        } else {
            unifiedBannerView.setRefresh(0);
        }
        int intFromMap = -2;
        int intFromMap2 = -1;
        if (map2 != null) {
            try {
                intFromMap2 = map2.containsKey(ATAdConst.KEY.AD_WIDTH) ? ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_WIDTH, -1) : -1;
                if (map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
                    intFromMap = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_HEIGHT, -2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        unifiedBannerView.setLayoutParams(new FrameLayout.LayoutParams(intFromMap2, intFromMap));
        this.e = unifiedBannerView;
        unifiedBannerView.loadAD();
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.b = ATInitMediation.getStringFromMap(map, "app_id");
        this.c = ATInitMediation.getStringFromMap(map, "unit_id");
        this.f = ATInitMediation.getIntFromMap(map, "unit_version");
        this.d = ATInitMediation.getStringFromMap(map, "payload");
        this.h = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        this.g = 0;
        try {
            if (map.containsKey("nw_rft")) {
                this.g = (int) (ATInitMediation.getIntFromMap(map, "nw_rft") / 1000.0f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
