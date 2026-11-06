package com.anythink.network.toutiao;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDKUtils;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.k;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTClientBidding;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.taptap.sdk.compliance.constants.ComplianceMessage;
import com.uc.crashsdk.export.LogType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TTATAdapter extends CustomNativeAdapter {
    String a;
    String b;
    String c;
    private final String h = getClass().getSimpleName();
    int d = 0;
    String e = "";
    boolean f = false;
    boolean g = false;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        if (!a(map)) {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        } else {
            final Context applicationContext = context.getApplicationContext();
            TTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    TTATAdapter tTATAdapter = TTATAdapter.this;
                    TTATAdapter.a(tTATAdapter, applicationContext, map, map2, tTATAdapter.f ? 1 : TTATAdapter.this.mRequestNum);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TTATAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2, int i) {
        if (TextUtils.isEmpty(this.c)) {
            notifyATLoadFail("", "nativeType is empty");
        } else {
            runOnNetworkRequestThread(new AnonymousClass2(context, map2, map, i));
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;
        final /* synthetic */ Map c;
        final /* synthetic */ int d;

        AnonymousClass2(Context context, Map map, Map map2, int i) {
            this.a = context;
            this.b = map;
            this.c = map2;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            final boolean z;
            final int i;
            final Bitmap bitmap;
            Object obj;
            int i2;
            int i3;
            TTAdManager adManager = TTAdSdk.getAdManager();
            int i4 = this.a.getResources().getDisplayMetrics().widthPixels;
            int i5 = this.a.getResources().getDisplayMetrics().heightPixels;
            Map map = this.b;
            if (map != null) {
                Object obj2 = map.containsKey(ATAdConst.KEY.AD_WIDTH) ? this.b.get(ATAdConst.KEY.AD_WIDTH) : null;
                if (this.b.containsKey(TTATConst.NATIVE_AD_IMAGE_HEIGHT)) {
                    obj = this.b.get(TTATConst.NATIVE_AD_IMAGE_HEIGHT);
                } else {
                    obj = this.b.containsKey(ATAdConst.KEY.AD_HEIGHT) ? this.b.get(ATAdConst.KEY.AD_HEIGHT) : null;
                }
                Object obj3 = this.b.get(TTATConst.NATIVE_AD_INTERRUPT_VIDEOPLAY);
                Object obj4 = this.b.get(TTATConst.NATIVE_AD_VIDEOPLAY_BTN_BITMAP);
                Object obj5 = this.b.get(TTATConst.NATIVE_AD_VIDEOPLAY_BTN_SIZE);
                if (obj2 != null && obj != null) {
                    try {
                        i4 = (int) Double.parseDouble(obj2.toString());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    try {
                        i5 = (int) Double.parseDouble(obj.toString());
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                } else {
                    if (TTATAdapter.this.d == 1) {
                        i2 = 690;
                        i3 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT;
                    } else if (TTATAdapter.this.d == 2) {
                        i2 = 228;
                        i3 = 150;
                    } else if (TTATAdapter.this.d == 3) {
                        i2 = LogType.UNEXP_ANR;
                        i3 = 720;
                    } else if (TTATAdapter.this.d == 4) {
                        i2 = ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR;
                        i3 = MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME;
                    } else if (TTATAdapter.this.d == 5) {
                        i4 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
                        i5 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
                    }
                    i5 = i3;
                    i4 = i2;
                }
                z = obj3 instanceof Boolean ? Boolean.parseBoolean(obj3.toString()) : true;
                Bitmap bitmap2 = obj4 instanceof Bitmap ? (Bitmap) obj4 : null;
                i = obj5 instanceof Integer ? Integer.parseInt(obj5.toString()) : 0;
                bitmap = bitmap2;
            } else {
                z = true;
                i = 0;
                bitmap = null;
            }
            TTAdNative tTAdNativeCreateAdNative = adManager.createAdNative(this.a);
            TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new TTATCustomAdSlotBuilder(TTATAdapter.this.a, this.c, this.b);
            tTATCustomAdSlotBuilder.setAdCount(Math.min(this.d, 3));
            tTATCustomAdSlotBuilder.setSupportDeepLink(true);
            if (TextUtils.equals("0", TTATAdapter.this.c) && TextUtils.equals("0", TTATAdapter.this.b)) {
                Log.i(TTATAdapter.this.h, "load Native Express Ad");
                if (TTATAdapter.this.isNativeMixToBanner()) {
                    Pair pairB = TTATAdapter.b(this.a, (Map<String, Object>) this.c);
                    int iIntValue = ((Integer) pairB.first).intValue();
                    int iIntValue2 = ((Integer) pairB.second).intValue();
                    String unused = TTATAdapter.this.h;
                    i5 = iIntValue2;
                    i4 = iIntValue;
                }
                tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(ATSDKUtils.px2dip(this.a, i4), ATSDKUtils.px2dip(this.a, i5));
                tTAdNativeCreateAdNative.loadNativeExpressAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.1
                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                    public final void onError(int i6, String str) {
                        TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                    public final void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                        TTATAdapter.a(TTATAdapter.this, AnonymousClass2.this.a, (List) list, z, false);
                    }
                });
            }
            if (TextUtils.equals("1", TTATAdapter.this.c) && TextUtils.equals("0", TTATAdapter.this.b)) {
                Log.i(TTATAdapter.this.h, "load Native Express Video");
                if (TTATAdapter.this.isNativeMixToBanner()) {
                    Pair pairB2 = TTATAdapter.b(this.a, (Map<String, Object>) this.c);
                    int iIntValue3 = ((Integer) pairB2.first).intValue();
                    int iIntValue4 = ((Integer) pairB2.second).intValue();
                    String unused2 = TTATAdapter.this.h;
                    i5 = iIntValue4;
                    i4 = iIntValue3;
                }
                tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(ATSDKUtils.px2dip(this.a, i4), ATSDKUtils.px2dip(this.a, i5));
                tTAdNativeCreateAdNative.loadExpressDrawFeedAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.2
                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                    public final void onError(int i6, String str) {
                        TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                    public final void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                        TTATAdapter.a(TTATAdapter.this, AnonymousClass2.this.a, (List) list, z, true);
                    }
                });
                return;
            }
            if (i4 > 0 && i5 > 0) {
                tTATCustomAdSlotBuilder.setImageAcceptedSize(i4, i5);
            } else {
                tTATCustomAdSlotBuilder.setImageAcceptedSize(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
            String str = TTATAdapter.this.c;
            str.hashCode();
            switch (str) {
                case "0":
                    tTAdNativeCreateAdNative.loadFeedAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.FeedAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.3
                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                        public final void onError(int i6, String str2) {
                            TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                        public final void onFeedAdLoad(List<TTFeedAd> list) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<TTFeedAd> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(new TTATNativeAd(AnonymousClass2.this.a, TTATAdapter.this.a, it.next(), z, bitmap, i, TTATAdapter.this.g));
                            }
                            TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                        }
                    });
                    break;
                case "1":
                    tTAdNativeCreateAdNative.loadDrawFeedAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.DrawFeedAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.4
                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
                        public final void onError(int i6, String str2) {
                            TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
                        public final void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<TTDrawFeedAd> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(new TTATNativeAd(AnonymousClass2.this.a, TTATAdapter.this.a, it.next(), z, bitmap, i, TTATAdapter.this.g));
                            }
                            TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                        }
                    });
                    break;
                case "2":
                    tTATCustomAdSlotBuilder.setNativeAdType(1);
                    tTAdNativeCreateAdNative.loadNativeAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.NativeAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.5
                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
                        public final void onError(int i6, String str2) {
                            TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
                        public final void onNativeAdLoad(List<TTNativeAd> list) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<TTNativeAd> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(new TTATNativeAd(AnonymousClass2.this.a, TTATAdapter.this.a, it.next(), z, bitmap, i, TTATAdapter.this.g));
                            }
                            TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                        }
                    });
                    break;
                case "3":
                    tTATCustomAdSlotBuilder.setNativeAdType(2);
                    tTAdNativeCreateAdNative.loadNativeAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.NativeAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.6
                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
                        public final void onError(int i6, String str2) {
                            TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
                        public final void onNativeAdLoad(List<TTNativeAd> list) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<TTNativeAd> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(new TTATNativeAd(AnonymousClass2.this.a, TTATAdapter.this.a, it.next(), z, bitmap, i, TTATAdapter.this.g));
                            }
                            TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                        }
                    });
                    break;
                case "4":
                    tTAdNativeCreateAdNative.loadStream(tTATCustomAdSlotBuilder.build(), new TTAdNative.FeedAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.7
                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                        public final void onError(int i6, String str2) {
                            TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                        public final void onFeedAdLoad(List<TTFeedAd> list) {
                            if (list == null || list.isEmpty()) {
                                TTATAdapter.this.notifyATLoadFail("", "Ad list is empty.");
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            Iterator<TTFeedAd> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(new TTATNativePatchAd(AnonymousClass2.this.a, TTATAdapter.this.a, it.next(), z, bitmap, i, TTATAdapter.this.g));
                            }
                            TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                        }
                    });
                    break;
                default:
                    TTATAdapter.this.notifyATLoadFail("", "The Native type is not exit.");
                    break;
            }
        }
    }

    private void a(Context context, List<TTNativeExpressAd> list, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        Iterator<TTNativeExpressAd> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new TTATNativeExpressAd(context, this.a, it.next(), z, z2));
        }
        CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
        if (list.size() == 0 || customNativeAdArr.length == 0) {
            notifyATLoadFail("", "Ad list is empty.");
        } else {
            TTATInitManager.getInstance().notifyAdDataLoad(this.f, a(list), list.get(0), this.mLoadListener, this.mBiddingListener, customNativeAdArr);
        }
        new TTATNativeExpressHandler(list).startRender(new AnonymousClass3(context, z, z2));
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements TTATNativeExpressHandler.RenderCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;

        AnonymousClass3(Context context, boolean z, boolean z2) {
            this.a = context;
            this.b = z;
            this.c = z2;
        }

        @Override // com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback
        public final void onRenderSuccess(List<TTATNativeExpressHandler.TTNativeExpressAdWrapper> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (TTATNativeExpressHandler.TTNativeExpressAdWrapper tTNativeExpressAdWrapper : list) {
                arrayList.add(new TTATNativeExpressAd(this.a, TTATAdapter.this.a, tTNativeExpressAdWrapper.ttNativeExpressAd, this.b, this.c, tTNativeExpressAdWrapper.expressWidth, tTNativeExpressAdWrapper.expressHeight));
                arrayList2.add(tTNativeExpressAdWrapper.ttNativeExpressAd);
            }
            TTATAdapter.a(TTATAdapter.this, arrayList2, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
        }

        @Override // com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback
        public final void onRenderFail(String str, int i) {
            TTATAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return TTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.a;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return TTATInitManager.getInstance().getNetworkVersion();
    }

    private void a(List<? extends TTClientBidding> list, CustomNativeAd... customNativeAdArr) {
        if (list.size() == 0 || customNativeAdArr.length == 0) {
            notifyATLoadFail("", "Ad list is empty.");
        } else {
            TTATInitManager.getInstance().notifyAdDataLoad(this.f, a(list), list.get(0), this.mLoadListener, this.mBiddingListener, customNativeAdArr);
        }
    }

    private void b(List<? extends TTClientBidding> list, CustomNativeAd... customNativeAdArr) {
        if (list.size() == 0 || customNativeAdArr.length == 0) {
            notifyATLoadFail("", "Ad list is empty.");
            return;
        }
        if (this.f) {
            if (this.mBiddingListener != null) {
                TTATInitManager.getInstance().a(a(list), customNativeAdArr[0], list.get(0), this.mBiddingListener);
                this.mBiddingListener = null;
                return;
            }
            return;
        }
        if (this.mLoadListener != null) {
            this.mLoadListener.onAdCacheLoaded(customNativeAdArr);
        }
    }

    private static Map<String, Object> a(List<? extends TTClientBidding> list) {
        TTClientBidding tTClientBidding = list.get(0);
        HashMap map = new HashMap(3);
        if (tTClientBidding instanceof TTNativeAd) {
            try {
                Map<String, Object> mediaExtraInfo = ((TTNativeAd) tTClientBidding).getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    map.putAll(mediaExtraInfo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (tTClientBidding instanceof TTNativeExpressAd) {
            try {
                Map<String, Object> mediaExtraInfo2 = ((TTNativeExpressAd) tTClientBidding).getMediaExtraInfo();
                if (mediaExtraInfo2 != null) {
                    map.putAll(mediaExtraInfo2);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return map;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private boolean a(Map<String, Object> map) {
        String str = (String) map.get("app_id");
        this.a = (String) map.get("slot_id");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.a)) {
            return false;
        }
        this.b = "1";
        if (map.containsKey("layout_type")) {
            this.b = (String) map.get("layout_type");
        } else {
            this.b = "0";
        }
        if (map.containsKey("is_video")) {
            this.c = map.get("is_video").toString();
        }
        try {
            if (map.containsKey("media_size")) {
                this.d = Integer.parseInt(map.get("media_size").toString());
            }
        } catch (Exception unused) {
        }
        if (map.containsKey("payload")) {
            this.e = map.get("payload").toString();
        }
        this.g = ATInitMediation.getIntFromMap(map, k.aJ, 2) == 2;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Pair<Integer, Integer> b(Context context, Map<String, Object> map) {
        try {
            String stringFromMap = ATInitMediation.getStringFromMap(map, "size");
            if (!TextUtils.isEmpty(stringFromMap)) {
                String[] strArrSplit = stringFromMap.split("x");
                if (strArrSplit.length == 2) {
                    return new Pair<>(Integer.valueOf(ATSDKUtils.dip2px(context, Integer.parseInt(strArrSplit[0]))), Integer.valueOf(ATSDKUtils.dip2px(context, Integer.parseInt(strArrSplit[1]))));
                }
            }
        } catch (Throwable unused) {
        }
        return new Pair<>(Integer.valueOf(ATSDKUtils.dip2px(context, 300.0f)), Integer.valueOf(ATSDKUtils.dip2px(context, 250.0f)));
    }

    static /* synthetic */ void a(TTATAdapter tTATAdapter, Context context, Map map, Map map2, int i) {
        if (TextUtils.isEmpty(tTATAdapter.c)) {
            tTATAdapter.notifyATLoadFail("", "nativeType is empty");
        } else {
            tTATAdapter.runOnNetworkRequestThread(tTATAdapter.new AnonymousClass2(context, map2, map, i));
        }
    }

    static /* synthetic */ void a(TTATAdapter tTATAdapter, Context context, List list, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new TTATNativeExpressAd(context, tTATAdapter.a, (TTNativeExpressAd) it.next(), z, z2));
        }
        CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
        if (list.size() == 0 || customNativeAdArr.length == 0) {
            tTATAdapter.notifyATLoadFail("", "Ad list is empty.");
        } else {
            TTATInitManager.getInstance().notifyAdDataLoad(tTATAdapter.f, a((List<? extends TTClientBidding>) list), (TTClientBidding) list.get(0), tTATAdapter.mLoadListener, tTATAdapter.mBiddingListener, customNativeAdArr);
        }
        new TTATNativeExpressHandler(list).startRender(tTATAdapter.new AnonymousClass3(context, z, z2));
    }

    static /* synthetic */ void a(TTATAdapter tTATAdapter, List list, CustomNativeAd[] customNativeAdArr) {
        if (list.size() == 0 || customNativeAdArr.length == 0) {
            tTATAdapter.notifyATLoadFail("", "Ad list is empty.");
            return;
        }
        if (tTATAdapter.f) {
            if (tTATAdapter.mBiddingListener != null) {
                TTATInitManager.getInstance().a(a((List<? extends TTClientBidding>) list), customNativeAdArr[0], (TTClientBidding) list.get(0), tTATAdapter.mBiddingListener);
                tTATAdapter.mBiddingListener = null;
                return;
            }
            return;
        }
        if (tTATAdapter.mLoadListener != null) {
            tTATAdapter.mLoadListener.onAdCacheLoaded(customNativeAdArr);
        }
    }
}
