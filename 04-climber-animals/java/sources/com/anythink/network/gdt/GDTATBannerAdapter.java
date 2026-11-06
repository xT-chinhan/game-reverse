package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GDTATBannerAdapter extends CustomBannerAdapter {
    String a;
    String b;
    String c;
    UnifiedBannerView d;
    int f;
    boolean g;
    boolean h;
    private Map<String, Object> k;
    private final String j = "GDTATBannerAdapter";
    int e = 0;
    DownloadConfirmListener i = new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATBannerAdapter.1
        @Override // com.qq.e.comm.compliance.DownloadConfirmListener
        public final void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
            if (GDTATBannerAdapter.this.mImpressionEventListener != null) {
                GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                gDTDownloadFirmInfo.appInfoUrl = str;
                gDTDownloadFirmInfo.scenes = i;
                gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                GDTATBannerAdapter.this.mImpressionEventListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
            }
        }
    };

    private void a(Activity activity, Map<String, Object> map, Map<String, Object> map2) {
        UnifiedBannerView unifiedBannerView;
        GDTATInitManager.getInstance().setExtraUserData(map2);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        if (TextUtils.isEmpty(this.c) || this.h) {
            UnifiedBannerView unifiedBannerView2 = new UnifiedBannerView(activity, this.b, anonymousClass2);
            GDTATInitManager.getInstance();
            unifiedBannerView2.setLoadAdParams(GDTATInitManager.a(map));
            unifiedBannerView = unifiedBannerView2;
        } else {
            unifiedBannerView = new UnifiedBannerView(activity, this.b, anonymousClass2, null, this.c);
        }
        int i = this.f;
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
        this.d = unifiedBannerView;
        unifiedBannerView.loadAD();
    }

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATBannerAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements UnifiedBannerADListener {
        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADLeftApplication() {
        }

        AnonymousClass2() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onNoAD(AdError adError) {
            GDTATBannerAdapter.this.d = null;
            GDTATBannerAdapter.this.notifyATLoadFail(String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADReceive() {
            if (GDTATBannerAdapter.this.g && GDTATBannerAdapter.this.d != null) {
                GDTATBannerAdapter.this.d.setDownloadConfirmListener(GDTATBannerAdapter.this.i);
            }
            if (GDTATBannerAdapter.this.d != null) {
                try {
                    Map<String, Object> extraInfo = GDTATBannerAdapter.this.d.getExtraInfo();
                    if (extraInfo != null) {
                        if (GDTATBannerAdapter.this.k == null) {
                            GDTATBannerAdapter.this.k = new HashMap();
                        }
                        GDTATBannerAdapter.this.k.putAll(extraInfo);
                    }
                } catch (Throwable unused) {
                }
            }
            if (!GDTATBannerAdapter.this.h) {
                if (GDTATBannerAdapter.this.mLoadListener != null) {
                    GDTATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (GDTATBannerAdapter.this.mBiddingListener != null) {
                if (GDTATBannerAdapter.this.d != null) {
                    GDTATBannerAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(GDTATBannerAdapter.this.d.getECPM(), new StringBuilder().append(System.currentTimeMillis()).toString(), new GDTATBiddingNotice(GDTATBannerAdapter.this.d), ATAdConst.CURRENCY.RMB_CENT), null);
                    return;
                }
                GDTATBannerAdapter.this.notifyATLoadFail("", "GDT: Offer had been destroy.");
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADExposure() {
            try {
                GDTATInitManager.getInstance().a(GDTATBannerAdapter.this.getTrackingInfo().z(), new WeakReference(GDTATBannerAdapter.this.d));
            } catch (Throwable unused) {
            }
            if (GDTATBannerAdapter.this.mImpressionEventListener != null) {
                GDTATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADClosed() {
            if (GDTATBannerAdapter.this.mImpressionEventListener != null) {
                GDTATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADClicked() {
            if (GDTATBannerAdapter.this.mImpressionEventListener != null) {
                GDTATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
            }
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.d;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.c = ATInitMediation.getStringFromMap(map, "payload");
        this.g = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        this.f = 0;
        try {
            if (map.containsKey("nw_rft")) {
                this.f = (int) (ATInitMediation.getIntFromMap(map, "nw_rft") / 1000.0f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        UnifiedBannerView unifiedBannerView = this.d;
        if (unifiedBannerView != null) {
            if (unifiedBannerView instanceof UnifiedBannerView) {
                unifiedBannerView.destroy();
            }
            this.d = null;
        }
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
        this.h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdInternalAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, GDTATAdapter.class);
        return map;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.k;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        this.e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.c = ATInitMediation.getStringFromMap(map, "payload");
        this.g = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        this.f = 0;
        try {
            if (map.containsKey("nw_rft")) {
                this.f = (int) (ATInitMediation.getIntFromMap(map, "nw_rft") / 1000.0f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else if (!(context instanceof Activity)) {
            notifyATLoadFail("", "Context must be activity.");
        } else {
            runOnNetworkRequestThread(new Runnable() { // from class: com.anythink.network.gdt.GDTATBannerAdapter.3
                @Override // java.lang.Runnable
                public final void run() {
                    GDTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATBannerAdapter.3.1
                        @Override // com.anythink.core.api.MediationInitCallback
                        public final void onSuccess() {
                            GDTATBannerAdapter.a(GDTATBannerAdapter.this, (Activity) context, map, map2);
                        }

                        @Override // com.anythink.core.api.MediationInitCallback
                        public final void onFail(String str) {
                            GDTATBannerAdapter.this.notifyATLoadFail("", str);
                        }
                    });
                }
            });
        }
    }

    static /* synthetic */ void a(GDTATBannerAdapter gDTATBannerAdapter, Activity activity, Map map, Map map2) {
        UnifiedBannerView unifiedBannerView;
        GDTATInitManager.getInstance().setExtraUserData(map2);
        AnonymousClass2 anonymousClass2 = gDTATBannerAdapter.new AnonymousClass2();
        if (TextUtils.isEmpty(gDTATBannerAdapter.c) || gDTATBannerAdapter.h) {
            UnifiedBannerView unifiedBannerView2 = new UnifiedBannerView(activity, gDTATBannerAdapter.b, anonymousClass2);
            GDTATInitManager.getInstance();
            unifiedBannerView2.setLoadAdParams(GDTATInitManager.a((Map<String, Object>) map));
            unifiedBannerView = unifiedBannerView2;
        } else {
            unifiedBannerView = new UnifiedBannerView(activity, gDTATBannerAdapter.b, anonymousClass2, null, gDTATBannerAdapter.c);
        }
        int i = gDTATBannerAdapter.f;
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
        gDTATBannerAdapter.d = unifiedBannerView;
        unifiedBannerView.loadAD();
    }
}
