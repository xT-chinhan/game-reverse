package com.anythink.unitybridge.nativead;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATRequestingInfo;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.AdError;
import com.anythink.nativead.api.ATNative;
import com.anythink.nativead.api.ATNativeAdView;
import com.anythink.nativead.api.ATNativeDislikeListener;
import com.anythink.nativead.api.ATNativeEventExListener;
import com.anythink.nativead.api.ATNativeNetworkListener;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.api.NativeAd;
import com.anythink.network.gdt.GDTATConst;
import com.anythink.unitybridge.MsgTools;
import com.anythink.unitybridge.UnityPluginUtils;
import com.anythink.unitybridge.utils.CommonUtil;
import com.anythink.unitybridge.utils.Const;
import com.anythink.unitybridge.utils.JsonMapUtil;
import com.anythink.unitybridge.utils.ScenarioShowConfigFactory;
import com.anythink.unitybridge.utils.TaskManager;
import com.byazt.af.x;
import com.byazt.wg.qg;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NativeHelper {
    public static final String TAG = "AT_android_unity3d";
    static List<ViewInfo> currViewInfo = new ArrayList();
    ATNative mATNative;
    ATNativeAdView mATNativeAdView;
    Activity mActivity;
    ImageView mDislikeView;
    NativeListener mListener;
    NativeAd mNativeAd;
    ATNativePrepareInfo mNativePrepareInfo;
    String mPlacementId;
    private boolean mWantsRevenue;
    ViewInfo pViewInfo;

    public void clean() {
    }

    public NativeHelper(NativeListener nativeListener) {
        if (nativeListener == null) {
            Log.e("AT_android_unity3d", "Listener == null");
        }
        this.mListener = nativeListener;
        this.mActivity = UnityPluginUtils.getActivity("NativeHelper");
        this.mPlacementId = "";
    }

    public void initNative(String str) {
        MsgTools.printMsg("initNative " + str);
        this.mPlacementId = str;
        ATNative aTNative = new ATNative(this.mActivity, str, new ATNativeNetworkListener() { // from class: com.anythink.unitybridge.nativead.NativeHelper.1
            @Override // com.anythink.nativead.api.ATNativeNetworkListener
            public void onNativeAdLoaded() {
                MsgTools.printMsg("onNativeAdLoaded: " + NativeHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeHelper.this.mListener != null) {
                            synchronized (NativeHelper.this) {
                                NativeHelper.this.mListener.onNativeAdLoaded(NativeHelper.this.mPlacementId);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.nativead.api.ATNativeNetworkListener
            public void onNativeAdLoadFail(final AdError adError) {
                MsgTools.printMsg("onNativeAdLoadFail: " + NativeHelper.this.mPlacementId + ", " + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeHelper.this.mListener != null) {
                            synchronized (NativeHelper.this) {
                                NativeHelper.this.mListener.onNativeAdLoadFail(NativeHelper.this.mPlacementId, adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }
        });
        this.mATNative = aTNative;
        aTNative.setAdSourceStatusListener(new ATAdSourceStatusListener() { // from class: com.anythink.unitybridge.nativead.NativeHelper.2
            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingAttempt(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceBiddingAttempt: " + NativeHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeHelper.this.mListener != null) {
                            synchronized (NativeHelper.this) {
                                NativeHelper.this.mListener.onAdSourceBiddingAttempt(NativeHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingFilled(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceBiddingFilled: " + NativeHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeHelper.this.mListener != null) {
                            synchronized (NativeHelper.this) {
                                NativeHelper.this.mListener.onAdSourceBiddingFilled(NativeHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingFail(final ATAdInfo aTAdInfo, final AdError adError) {
                MsgTools.printMsg("onAdSourceBiddingFail: " + NativeHelper.this.mPlacementId + "," + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeHelper.this.mListener != null) {
                            synchronized (NativeHelper.this) {
                                NativeHelper.this.mListener.onAdSourceBiddingFail(NativeHelper.this.mPlacementId, aTAdInfo.toString(), adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceAttempt(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceAttemp: " + NativeHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeHelper.this.mListener != null) {
                            synchronized (NativeHelper.this) {
                                NativeHelper.this.mListener.onAdSourceAttempt(NativeHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceLoadFilled(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceLoadFilled: " + NativeHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.2.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeHelper.this.mListener != null) {
                            synchronized (NativeHelper.this) {
                                NativeHelper.this.mListener.onAdSourceLoadFilled(NativeHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceLoadFail(final ATAdInfo aTAdInfo, final AdError adError) {
                MsgTools.printMsg("onAdSourceLoadFail: " + NativeHelper.this.mPlacementId + "," + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.2.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeHelper.this.mListener != null) {
                            synchronized (NativeHelper.this) {
                                NativeHelper.this.mListener.onAdSourceLoadFail(NativeHelper.this.mPlacementId, aTAdInfo.toString(), adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }
        });
        this.mATNative.setAdMultipleLoadedListener(new ATAdMultipleLoadedListener() { // from class: com.anythink.unitybridge.nativead.NativeHelper.3
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeHelper.this.mListener != null) {
                            synchronized (NativeHelper.this) {
                                NativeHelper.this.mListener.onAdMultipleLoaded(NativeHelper.this.mPlacementId, JsonMapUtil.requestingInfoToJson(aTRequestingInfo));
                            }
                        }
                    }
                });
            }
        });
        MsgTools.printMsg("initNative 2 " + this.mPlacementId);
    }

    public void loadNative(final String str) {
        MsgTools.printMsg("loadNative: " + this.mPlacementId + ".localExtra: " + str);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (NativeHelper.this.mATNative == null) {
                    Log.e("AT_android_unity3d", "you must call initNative first");
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NativeHelper.this.mListener != null) {
                                synchronized (NativeHelper.this) {
                                    NativeHelper.this.mListener.onNativeAdLoadFail(NativeHelper.this.mPlacementId, "-1", "you must call initNative first");
                                }
                            }
                        }
                    });
                    return;
                }
                HashMap map = new HashMap();
                ATAdRequest aTAdRequestAtAdRequestFromJson = null;
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("atAdRequest")) {
                        aTAdRequestAtAdRequestFromJson = JsonMapUtil.atAdRequestFromJson(jSONObject.optJSONObject("atAdRequest"));
                        jSONObject.remove("atAdRequest");
                    }
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObject.get(next));
                        if (TextUtils.equals(Const.Native.native_ad_size, next)) {
                            String strOptString = jSONObject.optString(next);
                            if (!TextUtils.isEmpty(strOptString)) {
                                String[] strArrSplit = strOptString.split(x.n);
                                map.put(ATAdConst.KEY.AD_WIDTH, strArrSplit[0]);
                                map.put(ATAdConst.KEY.AD_HEIGHT, strArrSplit[1]);
                            }
                        }
                        if (TextUtils.equals(Const.Native.ADAPTIVE_HEIGHT, next) && TextUtils.equals("1", jSONObject.optString(next))) {
                            map.put("tt_image_height", 0);
                            map.put(GDTATConst.AD_HEIGHT, -2);
                        }
                    }
                    NativeHelper.this.mATNative.setLocalExtra(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                NativeHelper.this.mATNative.makeAdRequest(aTAdRequestAtAdRequestFromJson);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewInfo parseViewInfo(String str) {
        this.pViewInfo = new ViewInfo();
        if (TextUtils.isEmpty(str)) {
            Log.e("AT_android_unity3d", "showConfig is null ,user defult");
            this.pViewInfo = ViewInfo.createDefualtView(this.mActivity);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("parent")) {
                String string = jSONObject.getString("parent");
                MsgTools.printMsg("parent----> " + string);
                ViewInfo viewInfo = this.pViewInfo;
                viewInfo.rootView = viewInfo.parseINFO(string, "parent", 0, 0);
            }
            if (jSONObject.has("appIcon")) {
                String string2 = jSONObject.getString("appIcon");
                MsgTools.printMsg("appIcon----> " + string2);
                ViewInfo viewInfo2 = this.pViewInfo;
                viewInfo2.IconView = viewInfo2.parseINFO(string2, "appIcon", 0, 0);
            }
            if (jSONObject.has("mainImage")) {
                String string3 = jSONObject.getString("mainImage");
                MsgTools.printMsg("mainImage----> " + string3);
                ViewInfo viewInfo3 = this.pViewInfo;
                viewInfo3.imgMainView = viewInfo3.parseINFO(string3, "mainImage", 0, 0);
            }
            if (jSONObject.has("title")) {
                String string4 = jSONObject.getString("title");
                MsgTools.printMsg("title----> " + string4);
                ViewInfo viewInfo4 = this.pViewInfo;
                viewInfo4.titleView = viewInfo4.parseINFO(string4, "title", 0, 0);
            }
            if (jSONObject.has(SDMAdConst.NETWORK_CUSTOM_KEY.DESC)) {
                String string5 = jSONObject.getString(SDMAdConst.NETWORK_CUSTOM_KEY.DESC);
                MsgTools.printMsg("desc----> " + string5);
                ViewInfo viewInfo5 = this.pViewInfo;
                viewInfo5.descView = viewInfo5.parseINFO(string5, SDMAdConst.NETWORK_CUSTOM_KEY.DESC, 0, 0);
            }
            if (jSONObject.has("adLogo")) {
                String string6 = jSONObject.getString("adLogo");
                MsgTools.printMsg("adLogo----> " + string6);
                ViewInfo viewInfo6 = this.pViewInfo;
                viewInfo6.adLogoView = viewInfo6.parseINFO(string6, "adLogo", 0, 0);
            }
            if (jSONObject.has("cta")) {
                String string7 = jSONObject.getString("cta");
                MsgTools.printMsg("cta----> " + string7);
                ViewInfo viewInfo7 = this.pViewInfo;
                viewInfo7.ctaView = viewInfo7.parseINFO(string7, "cta", 0, 0);
            }
            if (jSONObject.has(qg.AD_TAG_DISLIKE)) {
                String string8 = jSONObject.getString(qg.AD_TAG_DISLIKE);
                MsgTools.printMsg("dislike----> " + string8);
                ViewInfo viewInfo8 = this.pViewInfo;
                viewInfo8.dislikeView = viewInfo8.parseINFO(string8, qg.AD_TAG_DISLIKE, 0, 0);
            }
            if (jSONObject.has("elements")) {
                String string9 = jSONObject.getString("elements");
                MsgTools.printMsg("elements----> " + string9);
                ViewInfo viewInfo9 = this.pViewInfo;
                viewInfo9.elementsView = viewInfo9.parseINFO(string9, "elements", 0, 0);
            } else {
                ViewInfo viewInfo10 = this.pViewInfo;
                ViewInfo.INFO defaultViewInfoForElements = viewInfo10.getDefaultViewInfoForElements(viewInfo10.rootView);
                MsgTools.printMsg("elements----> default config: " + defaultViewInfoForElements);
                this.pViewInfo.elementsView = defaultViewInfoForElements;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.pViewInfo;
    }

    public void show(String str, String str2) {
        MsgTools.printMsg("show: " + this.mPlacementId + ", showConfig: " + str + ", jsonMap: " + str2);
        UnityPluginUtils.runOnUiThread(new AnonymousClass5(str2, str));
    }

    /* JADX INFO: renamed from: com.anythink.unitybridge.nativead.NativeHelper$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ String val$jsonMap;
        final /* synthetic */ String val$showConfig;

        AnonymousClass5(String str, String str2) {
            this.val$jsonMap = str;
            this.val$showConfig = str2;
        }

        /* JADX WARN: Code duplicated, block: B:40:0x007e  */
        /* JADX WARN: Code duplicated, block: B:41:0x0087  */
        /* JADX WARN: Code duplicated, block: B:43:0x008d  */
        /* JADX WARN: Code duplicated, block: B:44:0x0096  */
        /* JADX WARN: Code duplicated, block: B:46:0x00a0  */
        /* JADX WARN: Code duplicated, block: B:48:0x00f3  */
        /* JADX WARN: Code duplicated, block: B:56:0x0126  */
        /* JADX WARN: Code duplicated, block: B:57:0x0134  */
        /* JADX WARN: Code duplicated, block: B:61:0x0145 A[Catch: all -> 0x018e, TryCatch #3 {all -> 0x018e, blocks: (B:59:0x013f, B:61:0x0145, B:62:0x014d), top: B:77:0x013f }] */
        /* JADX WARN: Code duplicated, block: B:62:0x014d A[Catch: all -> 0x018e, TRY_LEAVE, TryCatch #3 {all -> 0x018e, blocks: (B:59:0x013f, B:61:0x0145, B:62:0x014d), top: B:77:0x013f }] */
        /* JADX WARN: Code duplicated, block: B:65:0x01af  */
        /* JADX WARN: Code duplicated, block: B:67:0x01b4  */
        @Override // java.lang.Runnable
        public void run() {
            String str;
            int i;
            ATShowConfig aTShowConfigFromJsonMap;
            NativeAd nativeAd;
            String str2 = "";
            boolean zEquals = false;
            if (!TextUtils.isEmpty(this.val$jsonMap)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.val$jsonMap);
                    String strOptString = jSONObject.has(Const.SCENARIO) ? jSONObject.optString(Const.SCENARIO) : "";
                    try {
                        zEquals = jSONObject.has(Const.Native.ADAPTIVE_HEIGHT) ? TextUtils.equals(jSONObject.optString(Const.Native.ADAPTIVE_HEIGHT), "1") : false;
                        if (jSONObject.has(Const.Native.POSITION)) {
                            String strOptString2 = jSONObject.optString(Const.Native.POSITION);
                            try {
                                if (TextUtils.equals(Const.Native.POSITION_BOTTOM, strOptString2)) {
                                    i = 81;
                                } else if (TextUtils.equals(Const.Native.POSITION_TOP, strOptString2)) {
                                    i = 49;
                                } else {
                                    str2 = strOptString2;
                                    i = -1;
                                }
                                str2 = strOptString2;
                            } catch (Exception e) {
                                str2 = strOptString;
                                str = strOptString2;
                                e = e;
                                i = -1;
                                e.printStackTrace();
                                aTShowConfigFromJsonMap = null;
                            }
                        } else {
                            i = -1;
                        }
                        try {
                            aTShowConfigFromJsonMap = ScenarioShowConfigFactory.fromJsonMap(this.val$jsonMap);
                            String str3 = str2;
                            str2 = strOptString;
                            str = str3;
                        } catch (Exception e2) {
                            e = e2;
                            String str4 = str2;
                            str2 = strOptString;
                            str = str4;
                            e.printStackTrace();
                            aTShowConfigFromJsonMap = null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        i = -1;
                    }
                } catch (Exception e4) {
                    e = e4;
                    str = "";
                }
                if (aTShowConfigFromJsonMap != null) {
                    nativeAd = NativeHelper.this.mATNative.getNativeAd(aTShowConfigFromJsonMap);
                } else if (!TextUtils.isEmpty(str2)) {
                    nativeAd = NativeHelper.this.mATNative.getNativeAd(str2);
                } else {
                    nativeAd = NativeHelper.this.mATNative.getNativeAd();
                }
                if (nativeAd != null) {
                    MsgTools.printMsg("nativeAd:" + NativeHelper.this.mPlacementId + ", scenario: " + str2 + ", isExpressAdaptiveHeight: " + zEquals + ", position: " + str);
                    NativeHelper nativeHelper = NativeHelper.this;
                    nativeHelper.pViewInfo = nativeHelper.parseViewInfo(this.val$showConfig);
                    NativeHelper.currViewInfo.add(NativeHelper.this.pViewInfo);
                    NativeHelper.this.mNativeAd = nativeAd;
                    if (NativeHelper.this.mWantsRevenue) {
                        NativeHelper.this.bindRevenueToNativeAd();
                    }
                    nativeAd.setNativeEventListener(new ATNativeEventExListener() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.1
                        @Override // com.anythink.nativead.api.ATNativeEventExListener
                        public void onAdActReward(ATAdInfo aTAdInfo, int i2) {
                        }

                        @Override // com.anythink.nativead.api.ATNativeEventExListener
                        public void onAdActRewardSuccess(ATAdInfo aTAdInfo) {
                        }

                        @Override // com.anythink.nativead.api.ATNativeEventExListener
                        public void onDeeplinkCallback(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo, boolean z) {
                        }

                        @Override // com.anythink.nativead.api.ATNativeEventListener
                        public void onAdImpressed(ATNativeAdView aTNativeAdView, final ATAdInfo aTAdInfo) {
                            MsgTools.printMsg("onAdImpressed: " + NativeHelper.this.mPlacementId);
                            TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (NativeHelper.this.mListener != null) {
                                        synchronized (NativeHelper.this) {
                                            NativeHelper.this.mListener.onAdImpressed(NativeHelper.this.mPlacementId, aTAdInfo.toString());
                                        }
                                    }
                                }
                            });
                        }

                        @Override // com.anythink.nativead.api.ATNativeEventListener
                        public void onAdClicked(ATNativeAdView aTNativeAdView, final ATAdInfo aTAdInfo) {
                            MsgTools.printMsg("onAdClicked: " + NativeHelper.this.mPlacementId);
                            TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (NativeHelper.this.mListener != null) {
                                        synchronized (NativeHelper.this) {
                                            NativeHelper.this.mListener.onAdClicked(NativeHelper.this.mPlacementId, aTAdInfo.toString());
                                        }
                                    }
                                }
                            });
                        }

                        @Override // com.anythink.nativead.api.ATNativeEventListener
                        public void onAdVideoStart(ATNativeAdView aTNativeAdView) {
                            MsgTools.printMsg("onAdVideoStart: " + NativeHelper.this.mPlacementId);
                            TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (NativeHelper.this.mListener != null) {
                                        synchronized (NativeHelper.this) {
                                            NativeHelper.this.mListener.onAdVideoStart(NativeHelper.this.mPlacementId);
                                        }
                                    }
                                }
                            });
                        }

                        @Override // com.anythink.nativead.api.ATNativeEventListener
                        public void onAdVideoEnd(ATNativeAdView aTNativeAdView) {
                            MsgTools.printMsg("onAdVideoEnd: " + NativeHelper.this.mPlacementId);
                            TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.1.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (NativeHelper.this.mListener != null) {
                                        synchronized (NativeHelper.this) {
                                            NativeHelper.this.mListener.onAdVideoEnd(NativeHelper.this.mPlacementId);
                                        }
                                    }
                                }
                            });
                        }

                        @Override // com.anythink.nativead.api.ATNativeEventListener
                        public void onAdVideoProgress(ATNativeAdView aTNativeAdView, final int i2) {
                            MsgTools.printMsg("onAdVideoProgress: " + NativeHelper.this.mPlacementId);
                            TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.1.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (NativeHelper.this.mListener != null) {
                                        synchronized (NativeHelper.this) {
                                            NativeHelper.this.mListener.onAdVideoProgress(NativeHelper.this.mPlacementId, i2);
                                        }
                                    }
                                }
                            });
                        }
                    });
                    nativeAd.setDislikeCallbackListener(new ATNativeDislikeListener() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.2
                        @Override // com.anythink.nativead.api.ATNativeDislikeListener
                        public void onAdCloseButtonClick(ATNativeAdView aTNativeAdView, final ATAdInfo aTAdInfo) {
                            MsgTools.printMsg("onAdCloseButtonClick: " + NativeHelper.this.mPlacementId);
                            TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (NativeHelper.this.mListener != null) {
                                        synchronized (NativeHelper.this) {
                                            NativeHelper.this.mListener.onAdCloseButtonClicked(NativeHelper.this.mPlacementId, aTAdInfo.toString());
                                        }
                                    }
                                }
                            });
                        }
                    });
                    if (zEquals && NativeHelper.this.pViewInfo.rootView != null) {
                        MsgTools.printMsg("nativeAd: rootView, use adaptive height for express");
                        NativeHelper.this.pViewInfo.rootView.mHeight = -2;
                    }
                    if (NativeHelper.this.mATNativeAdView == null) {
                        NativeHelper.this.mATNativeAdView = new ATNativeAdView(NativeHelper.this.mActivity);
                    } else {
                        NativeHelper.this.mATNativeAdView.removeAllViews();
                    }
                    NativeHelper.this.mNativePrepareInfo = null;
                    try {
                        if (nativeAd.isNativeExpress()) {
                            nativeAd.renderAdContainer(NativeHelper.this.mATNativeAdView, null);
                        } else {
                            SelfRenderViewUtil selfRenderViewUtil = new SelfRenderViewUtil(NativeHelper.this.mActivity, NativeHelper.this.pViewInfo, NativeHelper.this.mNativeAd.getAdInfo().getNetworkFirmId());
                            NativeHelper.this.mNativePrepareInfo = new ATNativePrepareExInfo();
                            NativeHelper.this.mNativeAd.renderAdContainer(NativeHelper.this.mATNativeAdView, selfRenderViewUtil.bindSelfRenderView(NativeHelper.this.mNativeAd.getAdMaterial(), NativeHelper.this.mNativePrepareInfo, NativeHelper.this.pViewInfo));
                        }
                    } catch (Throwable unused) {
                    }
                    NativeHelper.this.mNativeAd.prepare(NativeHelper.this.mATNativeAdView, NativeHelper.this.mNativePrepareInfo);
                    ViewInfo.addNativeAdView2Activity(NativeHelper.this.mActivity, NativeHelper.this.pViewInfo, NativeHelper.this.mATNativeAdView, nativeAd.isNativeExpress() ? i : -1);
                    return;
                }
                MsgTools.printMsg("No Cache:" + NativeHelper.this.mPlacementId);
            }
            str = "";
            i = -1;
            aTShowConfigFromJsonMap = null;
            if (aTShowConfigFromJsonMap != null) {
                nativeAd = NativeHelper.this.mATNative.getNativeAd(aTShowConfigFromJsonMap);
            } else if (!TextUtils.isEmpty(str2)) {
                nativeAd = NativeHelper.this.mATNative.getNativeAd(str2);
            } else {
                nativeAd = NativeHelper.this.mATNative.getNativeAd();
            }
            if (nativeAd != null) {
                MsgTools.printMsg("nativeAd:" + NativeHelper.this.mPlacementId + ", scenario: " + str2 + ", isExpressAdaptiveHeight: " + zEquals + ", position: " + str);
                NativeHelper nativeHelper2 = NativeHelper.this;
                nativeHelper2.pViewInfo = nativeHelper2.parseViewInfo(this.val$showConfig);
                NativeHelper.currViewInfo.add(NativeHelper.this.pViewInfo);
                NativeHelper.this.mNativeAd = nativeAd;
                if (NativeHelper.this.mWantsRevenue) {
                    NativeHelper.this.bindRevenueToNativeAd();
                }
                nativeAd.setNativeEventListener(new ATNativeEventExListener() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.1
                    @Override // com.anythink.nativead.api.ATNativeEventExListener
                    public void onAdActReward(ATAdInfo aTAdInfo, int i2) {
                    }

                    @Override // com.anythink.nativead.api.ATNativeEventExListener
                    public void onAdActRewardSuccess(ATAdInfo aTAdInfo) {
                    }

                    @Override // com.anythink.nativead.api.ATNativeEventExListener
                    public void onDeeplinkCallback(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo, boolean z) {
                    }

                    @Override // com.anythink.nativead.api.ATNativeEventListener
                    public void onAdImpressed(ATNativeAdView aTNativeAdView, final ATAdInfo aTAdInfo) {
                        MsgTools.printMsg("onAdImpressed: " + NativeHelper.this.mPlacementId);
                        TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (NativeHelper.this.mListener != null) {
                                    synchronized (NativeHelper.this) {
                                        NativeHelper.this.mListener.onAdImpressed(NativeHelper.this.mPlacementId, aTAdInfo.toString());
                                    }
                                }
                            }
                        });
                    }

                    @Override // com.anythink.nativead.api.ATNativeEventListener
                    public void onAdClicked(ATNativeAdView aTNativeAdView, final ATAdInfo aTAdInfo) {
                        MsgTools.printMsg("onAdClicked: " + NativeHelper.this.mPlacementId);
                        TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (NativeHelper.this.mListener != null) {
                                    synchronized (NativeHelper.this) {
                                        NativeHelper.this.mListener.onAdClicked(NativeHelper.this.mPlacementId, aTAdInfo.toString());
                                    }
                                }
                            }
                        });
                    }

                    @Override // com.anythink.nativead.api.ATNativeEventListener
                    public void onAdVideoStart(ATNativeAdView aTNativeAdView) {
                        MsgTools.printMsg("onAdVideoStart: " + NativeHelper.this.mPlacementId);
                        TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.1.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (NativeHelper.this.mListener != null) {
                                    synchronized (NativeHelper.this) {
                                        NativeHelper.this.mListener.onAdVideoStart(NativeHelper.this.mPlacementId);
                                    }
                                }
                            }
                        });
                    }

                    @Override // com.anythink.nativead.api.ATNativeEventListener
                    public void onAdVideoEnd(ATNativeAdView aTNativeAdView) {
                        MsgTools.printMsg("onAdVideoEnd: " + NativeHelper.this.mPlacementId);
                        TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.1.4
                            @Override // java.lang.Runnable
                            public void run() {
                                if (NativeHelper.this.mListener != null) {
                                    synchronized (NativeHelper.this) {
                                        NativeHelper.this.mListener.onAdVideoEnd(NativeHelper.this.mPlacementId);
                                    }
                                }
                            }
                        });
                    }

                    @Override // com.anythink.nativead.api.ATNativeEventListener
                    public void onAdVideoProgress(ATNativeAdView aTNativeAdView, final int i2) {
                        MsgTools.printMsg("onAdVideoProgress: " + NativeHelper.this.mPlacementId);
                        TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.1.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (NativeHelper.this.mListener != null) {
                                    synchronized (NativeHelper.this) {
                                        NativeHelper.this.mListener.onAdVideoProgress(NativeHelper.this.mPlacementId, i2);
                                    }
                                }
                            }
                        });
                    }
                });
                nativeAd.setDislikeCallbackListener(new ATNativeDislikeListener() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.2
                    @Override // com.anythink.nativead.api.ATNativeDislikeListener
                    public void onAdCloseButtonClick(ATNativeAdView aTNativeAdView, final ATAdInfo aTAdInfo) {
                        MsgTools.printMsg("onAdCloseButtonClick: " + NativeHelper.this.mPlacementId);
                        TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.5.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (NativeHelper.this.mListener != null) {
                                    synchronized (NativeHelper.this) {
                                        NativeHelper.this.mListener.onAdCloseButtonClicked(NativeHelper.this.mPlacementId, aTAdInfo.toString());
                                    }
                                }
                            }
                        });
                    }
                });
                if (zEquals) {
                    MsgTools.printMsg("nativeAd: rootView, use adaptive height for express");
                    NativeHelper.this.pViewInfo.rootView.mHeight = -2;
                }
                if (NativeHelper.this.mATNativeAdView == null) {
                    NativeHelper.this.mATNativeAdView = new ATNativeAdView(NativeHelper.this.mActivity);
                } else {
                    NativeHelper.this.mATNativeAdView.removeAllViews();
                }
                NativeHelper.this.mNativePrepareInfo = null;
                if (nativeAd.isNativeExpress()) {
                    nativeAd.renderAdContainer(NativeHelper.this.mATNativeAdView, null);
                } else {
                    SelfRenderViewUtil selfRenderViewUtil2 = new SelfRenderViewUtil(NativeHelper.this.mActivity, NativeHelper.this.pViewInfo, NativeHelper.this.mNativeAd.getAdInfo().getNetworkFirmId());
                    NativeHelper.this.mNativePrepareInfo = new ATNativePrepareExInfo();
                    NativeHelper.this.mNativeAd.renderAdContainer(NativeHelper.this.mATNativeAdView, selfRenderViewUtil2.bindSelfRenderView(NativeHelper.this.mNativeAd.getAdMaterial(), NativeHelper.this.mNativePrepareInfo, NativeHelper.this.pViewInfo));
                }
                NativeHelper.this.mNativeAd.prepare(NativeHelper.this.mATNativeAdView, NativeHelper.this.mNativePrepareInfo);
                ViewInfo.addNativeAdView2Activity(NativeHelper.this.mActivity, NativeHelper.this.pViewInfo, NativeHelper.this.mATNativeAdView, nativeAd.isNativeExpress() ? i : -1);
                return;
            }
            MsgTools.printMsg("No Cache:" + NativeHelper.this.mPlacementId);
        }
    }

    private void initDislikeView(ViewInfo.INFO info) {
        if (this.mDislikeView == null) {
            ImageView imageView = new ImageView(this.mActivity);
            this.mDislikeView = imageView;
            imageView.setImageResource(CommonUtil.getResId(this.mActivity, "btn_close", "drawable"));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(info.mWidth, info.mHeight);
        layoutParams.leftMargin = info.mX;
        layoutParams.topMargin = info.mY;
        if (!TextUtils.isEmpty(info.bgcolor)) {
            this.mDislikeView.setBackgroundColor(Color.parseColor(info.bgcolor));
        }
        this.mDislikeView.setLayoutParams(layoutParams);
    }

    public boolean isAdReady() {
        MsgTools.printMsg("isAdReady:" + this.mPlacementId);
        boolean zIsReady = this.mATNative.checkAdStatus().isReady();
        MsgTools.printMsg("isAdReady:" + this.mPlacementId + ", " + zIsReady);
        return zIsReady;
    }

    public void cleanView() {
        MsgTools.printMsg("cleanView:" + this.mPlacementId);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.6
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup;
                try {
                    for (ViewInfo viewInfo : NativeHelper.currViewInfo) {
                        if (NativeHelper.this.mATNativeAdView != null && (viewGroup = (ViewGroup) NativeHelper.this.mATNativeAdView.getParent()) != null) {
                            viewGroup.removeView(NativeHelper.this.mATNativeAdView);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void onPause() {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.onPause();
        }
    }

    public void onResume() {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.onResume();
        }
    }

    public String checkAdStatus() {
        MsgTools.printMsg("checkAdStatus:" + this.mPlacementId);
        ATNative aTNative = this.mATNative;
        if (aTNative == null) {
            return "";
        }
        ATAdStatusInfo aTAdStatusInfoCheckAdStatus = aTNative.checkAdStatus();
        boolean zIsLoading = aTAdStatusInfoCheckAdStatus.isLoading();
        boolean zIsReady = aTAdStatusInfoCheckAdStatus.isReady();
        ATAdInfo aTTopAdInfo = aTAdStatusInfoCheckAdStatus.getATTopAdInfo();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isLoading", zIsLoading);
            jSONObject.put("isReady", zIsReady);
            if (aTTopAdInfo != null) {
                try {
                    jSONObject.put("adInfo", new JSONObject(aTTopAdInfo.toString()));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            MsgTools.printMsg("checkAdStatus: result = " + jSONObject);
            return jSONObject.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public String getValidAdCaches() {
        MsgTools.printMsg("getValidAdCaches:" + this.mPlacementId);
        if (this.mATNative == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        List<ATAdInfo> listCheckValidAdCaches = this.mATNative.checkValidAdCaches();
        if (listCheckValidAdCaches == null) {
            return "";
        }
        int size = listCheckValidAdCaches.size();
        for (int i = 0; i < size; i++) {
            try {
                jSONArray.put(new JSONObject(listCheckValidAdCaches.get(i).toString()));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public void entryAdScenario(final String str) {
        MsgTools.printMsg("entryAdScenario start: " + this.mPlacementId + ", scenarioId: " + str);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.7
            @Override // java.lang.Runnable
            public void run() {
                if (NativeHelper.this.mATNative != null) {
                    NativeHelper.this.mATNative.entryAdScenario(str);
                } else {
                    MsgTools.printMsg("entryAdScenario error, you must call initNative first " + NativeHelper.this.mPlacementId);
                }
            }
        });
    }

    public void entryAdScenario(final String str, String str2) {
        final Map<String, Object> mapStringObjectMapFromJson = JsonMapUtil.stringObjectMapFromJson(str2);
        MsgTools.printMsg("entryAdScenario (tkExtra) " + this.mPlacementId);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.8
            @Override // java.lang.Runnable
            public void run() {
                if (NativeHelper.this.mATNative == null) {
                    MsgTools.printMsg("entryAdScenario error, you must call initNative first " + NativeHelper.this.mPlacementId);
                } else if (mapStringObjectMapFromJson == null) {
                    NativeHelper.this.mATNative.entryAdScenario(str);
                } else {
                    NativeHelper.this.mATNative.entryAdScenario(str, mapStringObjectMapFromJson);
                }
            }
        });
    }

    public void setAdRevenueListener() {
        this.mWantsRevenue = true;
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.9
            @Override // java.lang.Runnable
            public void run() {
                if (NativeHelper.this.mNativeAd != null) {
                    NativeHelper.this.bindRevenueToNativeAd();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindRevenueToNativeAd() {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd == null) {
            return;
        }
        nativeAd.setAdRevenueListener(new ATAdRevenueListener() { // from class: com.anythink.unitybridge.nativead.NativeHelper.10
            @Override // com.anythink.core.api.ATAdRevenueListener
            public void onAdRevenuePaid(ATAdInfo aTAdInfo) {
                final String string = aTAdInfo != null ? aTAdInfo.toString() : "";
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.nativead.NativeHelper.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeHelper.this.mListener != null) {
                            NativeHelper.this.mListener.onAdRevenuePaid(NativeHelper.this.mPlacementId, string);
                        }
                    }
                });
            }
        });
    }
}
