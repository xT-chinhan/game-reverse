package com.anythink.network.baidu;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingListenerExt;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATCustomLoadListenerExt;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.k;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.StyleParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class BaiduATAdapter extends CustomNativeAdapter {
    String a;
    String b;
    String c;
    int i;
    int j;
    private BaiduNativeManager l;
    private double k = 0.0d;
    StyleParams.Builder d = new StyleParams.Builder();
    int e = 0;
    boolean f = false;
    boolean g = true;
    boolean h = false;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return BaiduATInitManager.getInstance().getNetworkName();
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.c = ATInitMediation.getStringFromMap(map, "payload");
        this.e = ATInitMediation.getIntFromMap(map, "unit_type");
        this.k = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        this.i = ATInitMediation.getIntFromMap(map2, BaiduATConst.EXPECTED_SIZE_WIDTH, 0);
        this.j = ATInitMediation.getIntFromMap(map2, BaiduATConst.EXPECTED_SIZE_HEIGHT, 0);
        try {
            if (map2.containsKey(BaiduATConst.STYLE_BUILDER)) {
                Object obj = map2.get(BaiduATConst.STYLE_BUILDER);
                if (obj instanceof StyleParams.Builder) {
                    this.d = (StyleParams.Builder) obj;
                }
            }
            if (map.containsKey("cta_button")) {
                this.d.setShowActionButton(ATInitMediation.getStringFromMap(map, "cta_button").equals("1"));
            }
            if (map.containsKey(k.aJ)) {
                this.d.setRegionClick(ATInitMediation.getStringFromMap(map, k.aJ).equals("2"));
            }
            if (map.containsKey("dl_type")) {
                this.d.setShowDialogFrame(ATInitMediation.getStringFromMap(map, "dl_type").equals("2"));
            }
            this.g = ATInitMediation.getIntFromMap(map, "video_autoplay", 1) == 1;
        } catch (Exception unused) {
        }
        this.h = ATInitMediation.getIntFromMap(map, k.aJ, -1) == 2;
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, this.b);
        this.l = baiduNativeManager;
        baiduNativeManager.setAppSid(BaiduATInitManager.getInstance().getApp_id());
        RequestParameters.Builder builder = new RequestParameters.Builder();
        BaiduATInitManager.getInstance();
        BaiduATInitManager.a(this.b, builder, map, map2);
        RequestParameters requestParametersBuild = builder.build();
        if (this.f && this.k > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATAdapter", "setBidFloor:" + ((int) this.k));
            }
            this.l.setBidFloor((int) this.k);
        }
        int i = this.e;
        if (i == 3) {
            new BaiduATNativePortraitVideoAd(context, this.l, requestParametersBuild, this.g).load(new AnonymousClass2(context));
        } else if (i == 2) {
            this.l.loadExpressAd(requestParametersBuild, new a(context, this.f, this, this.mBiddingListener, this.mLoadListener, this.i, this.j));
        } else {
            this.l.loadFeedAd(requestParametersBuild, new b(context));
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements BaiduATNativePortraitVideoAd.LoadCallbackListener {
        final /* synthetic */ Context a;

        AnonymousClass2(Context context) {
            this.a = context;
        }

        @Override // com.anythink.network.baidu.BaiduATNativePortraitVideoAd.LoadCallbackListener
        public final void onSuccess(NativeResponse nativeResponse, CustomNativeAd customNativeAd) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(nativeResponse);
            BaiduATAdapter.a(BaiduATAdapter.this, arrayList, this.a, customNativeAd);
        }

        @Override // com.anythink.network.baidu.BaiduATNativePortraitVideoAd.LoadCallbackListener
        public final void onFail(String str, String str2) {
            BaiduATAdapter.this.notifyATLoadFail(str, str2);
        }
    }

    private void a(List<NativeResponse> list, Context context, CustomNativeAd customNativeAd) {
        double d;
        ArrayList arrayList = new ArrayList();
        this.d.build();
        if (this.f) {
            NativeResponse nativeResponse = list.get(0);
            if (this.e != 3) {
                customNativeAd = new BaiduATNativeAd(context, nativeResponse, this.h, this.f);
            }
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(nativeResponse);
            try {
                d = Double.parseDouble(nativeResponse.getECPMLevel());
            } catch (Throwable th) {
                th.printStackTrace();
                d = 0.0d;
            }
            if (this.mBiddingListener != null) {
                if (d <= 0.0d) {
                    notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(String.valueOf(d)));
                    return;
                }
                ATBiddingResult aTBiddingResultSuccess = ATBiddingResult.success(d, new StringBuilder().append(nativeResponse.hashCode()).toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT);
                aTBiddingResultSuccess.setExtra(nativeResponse != null ? nativeResponse.getPECPM() : null);
                this.mBiddingListener.onC2SBiddingResultWithCache(aTBiddingResultSuccess, customNativeAd);
                return;
            }
            return;
        }
        if (this.e == 3) {
            arrayList.add(customNativeAd);
        } else {
            Iterator<NativeResponse> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new BaiduATNativeAd(context, it.next(), this.h, this.f));
            }
        }
        CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
        if (this.mLoadListener != null) {
            this.mLoadListener.onAdCacheLoaded(customNativeAdArr);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return BaiduATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private class b implements BaiduNativeManager.FeedAdListener {
        private final Context b;

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onVideoDownloadSuccess() {
        }

        public b(Context context) {
            this.b = context;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNativeLoad(List<NativeResponse> list) {
            if (list == null || list.size() == 0) {
                BaiduATAdapter.this.notifyATLoadFail("", "callback onNativeLoad but no ad");
            } else {
                BaiduATAdapter.a(BaiduATAdapter.this, list, this.b, (CustomNativeAd) null);
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNativeFail(int i, String str, NativeResponse nativeResponse) {
            BaiduATAdapter.this.notifyATLoadFail(String.valueOf(i), str, new BaiduATBiddingNotice(nativeResponse), ATAdConst.CURRENCY.RMB_CENT);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNoAd(int i, String str, NativeResponse nativeResponse) {
            BaiduATAdapter.this.notifyATLoadFail(String.valueOf(i), str, new BaiduATBiddingNotice(nativeResponse), ATAdConst.CURRENCY.RMB_CENT);
        }
    }

    private static class a implements BaiduNativeManager.ExpressAdListener {
        int a;
        int b;
        private final Context c;
        private final boolean d;
        private final BaiduATAdapter e;
        private final ATBiddingListener f;
        private final ATCustomLoadListener g;

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onVideoDownloadSuccess() {
        }

        public a(Context context, boolean z, BaiduATAdapter baiduATAdapter, ATBiddingListener aTBiddingListener, ATCustomLoadListener aTCustomLoadListener, int i, int i2) {
            this.c = context;
            this.d = z;
            this.e = baiduATAdapter;
            this.f = aTBiddingListener;
            this.g = aTCustomLoadListener;
            this.a = i;
            this.b = i2;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onNativeLoad(List<ExpressResponse> list) {
            double d;
            if (list == null || list.size() == 0) {
                this.e.notifyATLoadFail("", "Baidu ad return empty.");
                return;
            }
            if (this.d) {
                ExpressResponse expressResponse = list.get(0);
                BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(expressResponse);
                try {
                    d = Double.parseDouble(expressResponse.getECPMLevel());
                } catch (Throwable unused) {
                    d = 0.0d;
                }
                final ATBiddingResult aTBiddingResultSuccess = ATBiddingResult.success(d, new StringBuilder().append(expressResponse.hashCode()).toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT);
                aTBiddingResultSuccess.setExtra(expressResponse != null ? expressResponse.getPECPM() : null);
                BaiduATNativeExpressFeedAd baiduATNativeExpressFeedAd = new BaiduATNativeExpressFeedAd(this.c, expressResponse, this.a, this.b, this.d);
                baiduATNativeExpressFeedAd.setRenderCallback(new BaiduATNativeExpressFeedAd.RenderCallback() { // from class: com.anythink.network.baidu.BaiduATAdapter.a.1
                    @Override // com.anythink.network.baidu.BaiduATNativeExpressFeedAd.RenderCallback
                    public final void onAdRenderSuccess(CustomNativeAd customNativeAd) {
                        if (a.this.f != null) {
                            a.this.f.onC2SBiddingResultWithCache(aTBiddingResultSuccess, customNativeAd);
                        }
                    }

                    @Override // com.anythink.network.baidu.BaiduATNativeExpressFeedAd.RenderCallback
                    public final void onAdRenderFail() {
                        if (a.this.f != null) {
                            a.this.f.onC2SBidResult(ATBiddingResult.fail("BaiduATNativeExpressFeedAd Render Failed."));
                        }
                    }
                });
                baiduATNativeExpressFeedAd.startRender();
                ATBiddingListener aTBiddingListener = this.f;
                if (aTBiddingListener instanceof ATBiddingListenerExt) {
                    ((ATBiddingListenerExt) aTBiddingListener).onC2SBiddingResultWithData(aTBiddingResultSuccess, baiduATNativeExpressFeedAd);
                    return;
                }
                return;
            }
            final List listSynchronizedList = Collections.synchronizedList(new ArrayList());
            List listSynchronizedList2 = Collections.synchronizedList(new ArrayList());
            final AtomicInteger atomicInteger = new AtomicInteger(list.size());
            for (int i = 0; i < list.size(); i++) {
                BaiduATNativeExpressFeedAd baiduATNativeExpressFeedAd2 = new BaiduATNativeExpressFeedAd(this.c, list.get(i), this.a, this.b, this.d);
                listSynchronizedList2.add(baiduATNativeExpressFeedAd2);
                baiduATNativeExpressFeedAd2.setRenderCallback(new BaiduATNativeExpressFeedAd.RenderCallback() { // from class: com.anythink.network.baidu.BaiduATAdapter.a.2
                    @Override // com.anythink.network.baidu.BaiduATNativeExpressFeedAd.RenderCallback
                    public final void onAdRenderSuccess(CustomNativeAd customNativeAd) {
                        listSynchronizedList.add(customNativeAd);
                        if (atomicInteger.decrementAndGet() != 0 || a.this.g == null) {
                            return;
                        }
                        a.this.g.onAdCacheLoaded((CustomNativeAd[]) listSynchronizedList.toArray(new CustomNativeAd[listSynchronizedList.size()]));
                    }

                    @Override // com.anythink.network.baidu.BaiduATNativeExpressFeedAd.RenderCallback
                    public final void onAdRenderFail() {
                        if (atomicInteger.decrementAndGet() == 0 && listSynchronizedList.size() == 0 && a.this.g != null) {
                            a.this.g.onAdLoadError("", "All BaiduATNativeExpressFeedAd Render Failed.");
                        }
                    }
                });
                baiduATNativeExpressFeedAd2.startRender();
            }
            try {
                CustomNativeAd[] customNativeAdArr = new CustomNativeAd[listSynchronizedList2.size()];
                ATCustomLoadListener aTCustomLoadListener = this.g;
                if (aTCustomLoadListener instanceof ATCustomLoadListenerExt) {
                    ((ATCustomLoadListenerExt) aTCustomLoadListener).onAdDataLoadedWithAds((BaseAd[]) listSynchronizedList2.toArray(customNativeAdArr));
                }
            } catch (Throwable th) {
                Log.e("anythink_BaiduATAdapter", "onNativeLoad failed: " + th.getMessage());
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onNativeFail(int i, String str, ExpressResponse expressResponse) {
            this.e.notifyATLoadFail(String.valueOf(i), str, new BaiduATBiddingNotice(expressResponse), ATAdConst.CURRENCY.RMB_CENT);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onNoAd(int i, String str, ExpressResponse expressResponse) {
            this.e.notifyATLoadFail(String.valueOf(i), str, new BaiduATBiddingNotice(expressResponse), ATAdConst.CURRENCY.RMB_CENT);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.c = ATInitMediation.getStringFromMap(map, "payload");
        this.e = ATInitMediation.getIntFromMap(map, "unit_type");
        this.k = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        this.i = ATInitMediation.getIntFromMap(map2, BaiduATConst.EXPECTED_SIZE_WIDTH, 0);
        this.j = ATInitMediation.getIntFromMap(map2, BaiduATConst.EXPECTED_SIZE_HEIGHT, 0);
        try {
            if (map2.containsKey(BaiduATConst.STYLE_BUILDER)) {
                Object obj = map2.get(BaiduATConst.STYLE_BUILDER);
                if (obj instanceof StyleParams.Builder) {
                    this.d = (StyleParams.Builder) obj;
                }
            }
            if (map.containsKey("cta_button")) {
                this.d.setShowActionButton(ATInitMediation.getStringFromMap(map, "cta_button").equals("1"));
            }
            if (map.containsKey(k.aJ)) {
                this.d.setRegionClick(ATInitMediation.getStringFromMap(map, k.aJ).equals("2"));
            }
            if (map.containsKey("dl_type")) {
                this.d.setShowDialogFrame(ATInitMediation.getStringFromMap(map, "dl_type").equals("2"));
            }
            this.g = ATInitMediation.getIntFromMap(map, "video_autoplay", 1) == 1;
        } catch (Exception unused) {
        }
        this.h = ATInitMediation.getIntFromMap(map, k.aJ, -1) == 2;
        if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) {
            notifyATLoadFail("", "app_id or ad_place_id is empty.");
        } else {
            final Context applicationContext = context.getApplicationContext();
            BaiduATInitManager.getInstance().initSDK(applicationContext, map, new MediationInitCallback() { // from class: com.anythink.network.baidu.BaiduATAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        BaiduATAdapter.a(BaiduATAdapter.this, applicationContext, map, map2);
                    } catch (Throwable th) {
                        BaiduATAdapter.this.notifyATLoadFail("", "Baidu: init error, " + th.getMessage());
                    }
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    BaiduATAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    static /* synthetic */ void a(BaiduATAdapter baiduATAdapter, Context context, Map map, Map map2) {
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, baiduATAdapter.b);
        baiduATAdapter.l = baiduNativeManager;
        baiduNativeManager.setAppSid(BaiduATInitManager.getInstance().getApp_id());
        RequestParameters.Builder builder = new RequestParameters.Builder();
        BaiduATInitManager.getInstance();
        BaiduATInitManager.a(baiduATAdapter.b, builder, (Map<String, Object>) map, (Map<String, Object>) map2);
        RequestParameters requestParametersBuild = builder.build();
        if (baiduATAdapter.f && baiduATAdapter.k > 0.0d) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.i("BaiduATAdapter", "setBidFloor:" + ((int) baiduATAdapter.k));
            }
            baiduATAdapter.l.setBidFloor((int) baiduATAdapter.k);
        }
        int i = baiduATAdapter.e;
        if (i == 3) {
            new BaiduATNativePortraitVideoAd(context, baiduATAdapter.l, requestParametersBuild, baiduATAdapter.g).load(baiduATAdapter.new AnonymousClass2(context));
        } else if (i == 2) {
            baiduATAdapter.l.loadExpressAd(requestParametersBuild, new a(context, baiduATAdapter.f, baiduATAdapter, baiduATAdapter.mBiddingListener, baiduATAdapter.mLoadListener, baiduATAdapter.i, baiduATAdapter.j));
        } else {
            baiduATAdapter.l.loadFeedAd(requestParametersBuild, baiduATAdapter.new b(context));
        }
    }

    static /* synthetic */ void a(BaiduATAdapter baiduATAdapter, List list, Context context, CustomNativeAd customNativeAd) {
        double d;
        ArrayList arrayList = new ArrayList();
        baiduATAdapter.d.build();
        if (baiduATAdapter.f) {
            NativeResponse nativeResponse = (NativeResponse) list.get(0);
            if (baiduATAdapter.e != 3) {
                customNativeAd = new BaiduATNativeAd(context, nativeResponse, baiduATAdapter.h, baiduATAdapter.f);
            }
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(nativeResponse);
            try {
                d = Double.parseDouble(nativeResponse.getECPMLevel());
            } catch (Throwable th) {
                th.printStackTrace();
                d = 0.0d;
            }
            if (baiduATAdapter.mBiddingListener != null) {
                if (d <= 0.0d) {
                    baiduATAdapter.notifyATLoadFail("", "Price is less than or equal to 0. Price: ".concat(String.valueOf(d)));
                    return;
                }
                ATBiddingResult aTBiddingResultSuccess = ATBiddingResult.success(d, new StringBuilder().append(nativeResponse.hashCode()).toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT);
                aTBiddingResultSuccess.setExtra(nativeResponse != null ? nativeResponse.getPECPM() : null);
                baiduATAdapter.mBiddingListener.onC2SBiddingResultWithCache(aTBiddingResultSuccess, customNativeAd);
                return;
            }
            return;
        }
        if (baiduATAdapter.e == 3) {
            arrayList.add(customNativeAd);
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new BaiduATNativeAd(context, (NativeResponse) it.next(), baiduATAdapter.h, baiduATAdapter.f));
            }
        }
        CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
        if (baiduATAdapter.mLoadListener != null) {
            baiduATAdapter.mLoadListener.onAdCacheLoaded(customNativeAdArr);
        }
    }
}
