package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.dlopt.api.CustomAdapterDownloadListener;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TTATBannerAdapter extends CustomBannerAdapter {
    Context b;
    View c;
    int d;
    int e;
    int f;
    String g;
    boolean h;
    private TTNativeExpressAd n;
    private Map<String, Object> o;
    private boolean p;
    private final String m = getClass().getSimpleName();
    String a = "";
    boolean i = false;
    TTAdNative.NativeExpressAdListener j = new TTAdNative.NativeExpressAdListener() { // from class: com.anythink.network.toutiao.TTATBannerAdapter.1
        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public final void onError(int i, String str) {
            TTATBannerAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public final void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list != null && list.size() > 0) {
                TTATBannerAdapter.this.n = list.get(0);
                if (TTATBannerAdapter.this.f > 0) {
                    TTATBannerAdapter.this.n.setSlideIntervalTime(TTATBannerAdapter.this.f);
                } else {
                    TTATBannerAdapter.this.n.setSlideIntervalTime(0);
                }
                TTATBannerAdapter.b(TTATBannerAdapter.this);
                try {
                    Map<String, Object> mediaExtraInfo = TTATBannerAdapter.this.n.getMediaExtraInfo();
                    if (mediaExtraInfo != null) {
                        if (TTATBannerAdapter.this.o == null) {
                            TTATBannerAdapter.this.o = new HashMap(3);
                        }
                        TTATBannerAdapter.this.o.putAll(mediaExtraInfo);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (TTATBannerAdapter.this.p) {
                    TTATBannerAdapter tTATBannerAdapter = TTATBannerAdapter.this;
                    tTATBannerAdapter.c = tTATBannerAdapter.n.getExpressAdView();
                    String unused = TTATBannerAdapter.this.m;
                    new StringBuilder("onNativeExpressAdLoad() >>> mBannerView: ").append(TTATBannerAdapter.this.c);
                    if (TTATBannerAdapter.this.c != null) {
                        TTATInitManager.getInstance().notifyAdDataLoad(TTATBannerAdapter.this.i, TTATBannerAdapter.this.o, TTATBannerAdapter.this.n, TTATBannerAdapter.this.mLoadListener, TTATBannerAdapter.this.mBiddingListener, new BaseAd[0]);
                    }
                }
                TTATBannerAdapter.this.n.render();
                return;
            }
            TTATBannerAdapter.this.notifyATLoadFail("", "Return Ad list is empty.");
        }
    };
    TTNativeExpressAd.ExpressAdInteractionListener k = new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATBannerAdapter.2
        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdClicked(View view, int i) {
            if (TTATBannerAdapter.this.mImpressionEventListener != null) {
                TTATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdShow(View view, int i) {
            try {
                ViewParent parent = TTATBannerAdapter.this.c.getParent();
                while (!(parent instanceof ViewGroup) && parent != null) {
                    parent = parent.getParent();
                }
                if (parent != null) {
                    Context context = ((ViewGroup) parent).getContext();
                    if (!(context instanceof Activity)) {
                        Log.d(TTATBannerAdapter.this.m, "bindDislike fail:ATBannerView is not instanceof Activity");
                    } else {
                        TTATBannerAdapter tTATBannerAdapter = TTATBannerAdapter.this;
                        TTATBannerAdapter.a(tTATBannerAdapter, (Activity) context, tTATBannerAdapter.n);
                    }
                } else if (view == null || !(view.getContext() instanceof Activity)) {
                    Log.d(TTATBannerAdapter.this.m, "bindDislike fail:mActivity is not instanceof Activity");
                } else {
                    TTATBannerAdapter.a(TTATBannerAdapter.this, (Activity) view.getContext(), TTATBannerAdapter.this.n);
                }
            } catch (Throwable th) {
                Log.e(TTATBannerAdapter.this.m, "bindDislike fail:" + th.getMessage());
            }
            if (TTATBannerAdapter.this.mImpressionEventListener == null || TTATBannerAdapter.this.h) {
                return;
            }
            TTATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
            TTATBannerAdapter.this.h = true;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderFail(View view, String str, int i) {
            TTATBannerAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderSuccess(View view, float f, float f2) {
            String unused = TTATBannerAdapter.this.m;
            new StringBuilder("onRenderSuccess() >>> view: ").append(view);
            TTATBannerAdapter.this.c = view;
            TTATBannerAdapter.this.h = false;
            if (TTATBannerAdapter.this.i) {
                try {
                    TTATInitManager.getInstance().a(TTATBannerAdapter.this.o, TTATBannerAdapter.this.n, TTATBannerAdapter.this.mBiddingListener);
                } catch (Throwable unused2) {
                }
            } else if (TTATBannerAdapter.this.mLoadListener != null) {
                TTATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }
    };
    private boolean q = false;
    TTAppDownloadListener l = new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATBannerAdapter.6
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j, long j2, String str, String str2) {
            if (TTATBannerAdapter.this.q) {
                if (TTATBannerAdapter.this.mDownloadListener == null || !(TTATBannerAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATBannerAdapter.this.mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                return;
            }
            TTATBannerAdapter.j(TTATBannerAdapter.this);
            if (TTATBannerAdapter.this.mDownloadListener == null || !(TTATBannerAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATBannerAdapter.this.mDownloadListener).onDownloadStart(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j, long j2, String str, String str2) {
            if (TTATBannerAdapter.this.mDownloadListener == null || !(TTATBannerAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATBannerAdapter.this.mDownloadListener).onDownloadPause(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j, long j2, String str, String str2) {
            if (TTATBannerAdapter.this.mDownloadListener == null || !(TTATBannerAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATBannerAdapter.this.mDownloadListener).onDownloadFail(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j, String str, String str2) {
            if (TTATBannerAdapter.this.mDownloadListener == null || !(TTATBannerAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATBannerAdapter.this.mDownloadListener).onDownloadFinish(j, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(String str, String str2) {
            if (TTATBannerAdapter.this.mDownloadListener == null || !(TTATBannerAdapter.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) TTATBannerAdapter.this.mDownloadListener).onInstalled(str, str2);
        }
    };

    static /* synthetic */ boolean j(TTATBannerAdapter tTATBannerAdapter) {
        tTATBannerAdapter.q = true;
        return true;
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        runOnNetworkRequestThread(new AnonymousClass3(map, map2, context.getApplicationContext()));
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATBannerAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Map a;
        final /* synthetic */ Map b;
        final /* synthetic */ Context c;

        AnonymousClass3(Map map, Map map2, Context context) {
            this.a = map;
            this.b = map2;
            this.c = context;
        }

        /* JADX WARN: Code duplicated, block: B:6:0x0029  */
        @Override // java.lang.Runnable
        public final void run() {
            int i;
            int i2;
            int i3;
            TTAdManager adManager = TTAdSdk.getAdManager();
            String stringFromMap = ATInitMediation.getStringFromMap(this.a, "size");
            int intFromMap = ATInitMediation.getIntFromMap(this.a, "layout_type", 1);
            int i4 = 0;
            int intFromMap2 = ATInitMediation.getIntFromMap(this.a, "media_size", 0);
            int i5 = 100;
            int i6 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
            if (intFromMap == 1) {
                i2 = 600;
                switch (intFromMap2) {
                    case 0:
                        i3 = 90;
                        break;
                    case 1:
                        i3 = 100;
                        i2 = 640;
                        break;
                    case 2:
                        i3 = 150;
                        break;
                    case 3:
                        i3 = MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME;
                        break;
                    case 4:
                        i3 = 300;
                        break;
                    case 5:
                        i3 = 200;
                        break;
                    case 6:
                        i2 = 690;
                        i3 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT;
                        break;
                    case 7:
                        i3 = 400;
                        break;
                    case 8:
                        i3 = 500;
                        break;
                    default:
                        i2 = 0;
                        i3 = 0;
                        break;
                }
            } else {
                try {
                    if (TextUtils.isEmpty(stringFromMap)) {
                        i2 = 0;
                        i3 = 0;
                    } else {
                        String[] strArrSplit = stringFromMap.split("x");
                        i = Integer.parseInt(strArrSplit[0]);
                        try {
                            i3 = Integer.parseInt(strArrSplit[1]);
                            i2 = i;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            i2 = i;
                            i3 = 0;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    i = 0;
                }
            }
            if (i2 != 0 && i3 != 0) {
                i6 = i2;
                i5 = i3;
            }
            TTATBannerAdapter.this.d = i6 / 2;
            TTATBannerAdapter.this.e = i5 / 2;
            Map map = this.b;
            if (map != null && map.containsKey(ATAdConst.KEY.AD_WIDTH)) {
                try {
                    i4 = (int) (Double.parseDouble(this.b.get(ATAdConst.KEY.AD_WIDTH).toString()) / ((double) this.c.getResources().getDisplayMetrics().density));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (i4 > 0) {
                    TTATBannerAdapter tTATBannerAdapter = TTATBannerAdapter.this;
                    tTATBannerAdapter.e = (i4 / tTATBannerAdapter.d) * TTATBannerAdapter.this.e;
                    TTATBannerAdapter.this.d = i4;
                }
            }
            TTAdNative tTAdNativeCreateAdNative = adManager.createAdNative(this.c);
            TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new TTATCustomAdSlotBuilder(TTATBannerAdapter.this.a, this.a, this.b);
            tTATCustomAdSlotBuilder.setAdCount(1);
            tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(TTATBannerAdapter.this.d, TTATBannerAdapter.this.e);
            tTAdNativeCreateAdNative.loadBannerExpressAd(tTATCustomAdSlotBuilder.build(), TTATBannerAdapter.this.j);
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATBannerAdapter$4, reason: invalid class name */
    final class AnonymousClass4 implements TTAdDislike.DislikeInteractionCallback {
        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onCancel() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onShow() {
        }

        AnonymousClass4() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onSelected(int i, String str, boolean z) {
            if (TTATBannerAdapter.this.mImpressionEventListener != null) {
                TTATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }
    }

    private void a(Activity activity, TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setDislikeCallback(activity, new AnonymousClass4());
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.c;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return TTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        this.c = null;
        TTNativeExpressAd tTNativeExpressAd = this.n;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
            this.n.destroy();
            this.n = null;
        }
        this.k = null;
        this.j = null;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.a;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return TTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.o;
    }

    private void a() {
        TTNativeExpressAd tTNativeExpressAd = this.n;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener(this.k);
            this.n.setDownloadListener(this.l);
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.i = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdInternalAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        HashMap map = new HashMap();
        map.put(0, TTATAdapter.class);
        return map;
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.a)) {
            return false;
        }
        this.f = ATInitMediation.getIntFromMap(map, "nw_rft", 0);
        this.g = ATInitMediation.getStringFromMap(map, "payload");
        return true;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        boolean z;
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.a)) {
            z = false;
        } else {
            this.f = ATInitMediation.getIntFromMap(map, "nw_rft", 0);
            this.g = ATInitMediation.getStringFromMap(map, "payload");
            z = true;
        }
        if (!z) {
            notifyATLoadFail("", "app_id or slot_id is empty!");
            return;
        }
        this.b = context.getApplicationContext();
        this.p = ATInitMediation.getIntFromMap(map, "ad_s_reqf_mode", -1) == 2;
        TTATInitManager.getInstance().initSDK(this.b, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATBannerAdapter.5
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                try {
                    TTATBannerAdapter tTATBannerAdapter = TTATBannerAdapter.this;
                    TTATBannerAdapter.a(tTATBannerAdapter, tTATBannerAdapter.b, map, map2);
                } catch (Throwable th) {
                    TTATBannerAdapter.this.notifyATLoadFail("", th.getMessage());
                }
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str) {
                TTATBannerAdapter.this.notifyATLoadFail("", str);
            }
        });
    }

    static /* synthetic */ void b(TTATBannerAdapter tTATBannerAdapter) {
        TTNativeExpressAd tTNativeExpressAd = tTATBannerAdapter.n;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener(tTATBannerAdapter.k);
            tTATBannerAdapter.n.setDownloadListener(tTATBannerAdapter.l);
        }
    }

    static /* synthetic */ void a(TTATBannerAdapter tTATBannerAdapter, Activity activity, TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setDislikeCallback(activity, tTATBannerAdapter.new AnonymousClass4());
    }

    static /* synthetic */ void a(TTATBannerAdapter tTATBannerAdapter, Context context, Map map, Map map2) {
        tTATBannerAdapter.runOnNetworkRequestThread(tTATBannerAdapter.new AnonymousClass3(map, map2, context.getApplicationContext()));
    }
}
