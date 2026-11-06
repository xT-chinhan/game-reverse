package com.anythink.unitybridge.interstitial;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.ATRequestingInfo;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.AdError;
import com.anythink.interstitial.api.ATInterstitial;
import com.anythink.interstitial.api.ATInterstitialExListener;
import com.anythink.unitybridge.MsgTools;
import com.anythink.unitybridge.UnityPluginUtils;
import com.anythink.unitybridge.utils.Const;
import com.anythink.unitybridge.utils.JsonMapUtil;
import com.anythink.unitybridge.utils.ScenarioShowConfigFactory;
import com.anythink.unitybridge.utils.TaskManager;
import com.byazt.af.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class InterstitialHelper {
    public static final String TAG = "AT_android_unity3d";
    boolean isReady = false;
    Activity mActivity;
    ATInterstitial mInterstitialAd;
    InterstitialListener mListener;
    String mPlacementId;

    public InterstitialHelper(InterstitialListener interstitialListener) {
        MsgTools.printMsg("InterstitialHelper: " + this);
        if (interstitialListener == null) {
            Log.e("AT_android_unity3d", "Listener == null ..");
        }
        this.mListener = interstitialListener;
        this.mActivity = UnityPluginUtils.getActivity("InterstitialHelper");
    }

    public void initInterstitial(String str) {
        MsgTools.printMsg("initInterstitial 1: " + str);
        this.mInterstitialAd = new ATInterstitial(this.mActivity, str);
        this.mPlacementId = str;
        MsgTools.printMsg("initInterstitial 2: " + str);
        this.mInterstitialAd.setAdListener(new ATInterstitialExListener() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.1
            @Override // com.anythink.interstitial.api.ATInterstitialExListener
            public void onDeeplinkCallback(ATAdInfo aTAdInfo, boolean z) {
            }

            @Override // com.anythink.interstitial.api.ATInterstitialExListener
            public void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            }

            @Override // com.anythink.interstitial.api.ATInterstitialExListener
            public void onInterstitialAdReward(ATAdInfo aTAdInfo) {
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdLoaded() {
                MsgTools.printMsg("onInterstitialAdLoaded: " + InterstitialHelper.this.mPlacementId);
                InterstitialHelper.this.isReady = true;
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onInterstitialAdLoaded(InterstitialHelper.this.mPlacementId);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdLoadFail(final AdError adError) {
                MsgTools.printMsg("onInterstitialAdLoadFail: " + InterstitialHelper.this.mPlacementId + ", " + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onInterstitialAdLoadFail(InterstitialHelper.this.mPlacementId, adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdClicked(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onInterstitialAdClicked: " + InterstitialHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onInterstitialAdClicked(InterstitialHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdShow(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onInterstitialAdShow: " + InterstitialHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onInterstitialAdShow(InterstitialHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdClose(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onInterstitialAdClose: " + InterstitialHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onInterstitialAdClose(InterstitialHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdVideoStart(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onInterstitialAdVideoStart: " + InterstitialHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onInterstitialAdVideoStart(InterstitialHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdVideoEnd(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onInterstitialAdVideoEnd: " + InterstitialHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onInterstitialAdVideoEnd(InterstitialHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialListener
            public void onInterstitialAdVideoError(final AdError adError) {
                MsgTools.printMsg("onInterstitialAdVideoError: " + InterstitialHelper.this.mPlacementId + ", " + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onInterstitialAdVideoError(InterstitialHelper.this.mPlacementId, adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }
        });
        this.mInterstitialAd.setAdSourceStatusListener(new ATAdSourceStatusListener() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.2
            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingAttempt(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceBiddingAttempt: " + InterstitialHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onAdSourceBiddingAttempt(InterstitialHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingFilled(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceBiddingFilled: " + InterstitialHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onAdSourceBiddingFilled(InterstitialHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingFail(final ATAdInfo aTAdInfo, final AdError adError) {
                MsgTools.printMsg("onAdSourceBiddingFail: " + InterstitialHelper.this.mPlacementId + "," + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onAdSourceBiddingFail(InterstitialHelper.this.mPlacementId, aTAdInfo.toString(), adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceAttempt(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceAttemp: " + InterstitialHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onAdSourceAttempt(InterstitialHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceLoadFilled(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceLoadFilled: " + InterstitialHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.2.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onAdSourceLoadFilled(InterstitialHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceLoadFail(final ATAdInfo aTAdInfo, final AdError adError) {
                MsgTools.printMsg("onAdSourceLoadFail: " + InterstitialHelper.this.mPlacementId + "," + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.2.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onAdSourceLoadFail(InterstitialHelper.this.mPlacementId, aTAdInfo.toString(), adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }
        });
        this.mInterstitialAd.setAdMultipleLoadedListener(new ATAdMultipleLoadedListener() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.3
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onAdMultipleLoaded(InterstitialHelper.this.mPlacementId, JsonMapUtil.requestingInfoToJson(aTRequestingInfo));
                            }
                        }
                    }
                });
            }
        });
        MsgTools.printMsg("initInterstitial 3: " + str);
    }

    public void loadInterstitialAd(String str) {
        MsgTools.printMsg("loadInterstitialAd: " + this.mPlacementId + ", jsonMap: " + str);
        final ATAdRequest[] aTAdRequestArr = new ATAdRequest[1];
        if (!TextUtils.isEmpty(str)) {
            HashMap map = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("atAdRequest")) {
                    aTAdRequestArr[0] = JsonMapUtil.atAdRequestFromJson(jSONObject.optJSONObject("atAdRequest"));
                    jSONObject.remove("atAdRequest");
                }
                try {
                    String str2 = (String) jSONObject.get(Const.Interstital.UseRewardedVideoAsInterstitial);
                    if (str2 != null && TextUtils.equals("1", str2)) {
                        map.put("is_use_rewarded_video_as_interstitial", true);
                    }
                } catch (Throwable unused) {
                }
                try {
                    String str3 = (String) jSONObject.get(Const.Interstital.interstitial_ad_size);
                    if (!TextUtils.isEmpty(str3)) {
                        String[] strArrSplit = str3.split(x.n);
                        MsgTools.printMsg("loadInterstitialAd, inter_ad_size" + str3);
                        map.put(ATAdConst.KEY.AD_WIDTH, strArrSplit[0]);
                        map.put(ATAdConst.KEY.AD_HEIGHT, strArrSplit[1]);
                    }
                } catch (Throwable unused2) {
                }
                Const.fillMapFromJsonObject(map, jSONObject);
                ATInterstitial aTInterstitial = this.mInterstitialAd;
                if (aTInterstitial != null) {
                    aTInterstitial.setLocalExtra(map);
                }
            } catch (Throwable unused3) {
            }
        }
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (InterstitialHelper.this.mInterstitialAd != null) {
                    InterstitialHelper.this.mInterstitialAd.load(InterstitialHelper.this.mActivity, aTAdRequestArr[0]);
                } else {
                    Log.e("AT_android_unity3d", "loadInterstitialAd error, you must call initInterstitial first " + this);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (InterstitialHelper.this.mListener != null) {
                                synchronized (InterstitialHelper.this) {
                                    InterstitialHelper.this.mListener.onInterstitialAdLoadFail(InterstitialHelper.this.mPlacementId, "-1", "you must call initInterstitial first ..");
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    public void showInterstitialAd(final String str) {
        MsgTools.printMsg("showInterstitial: " + this + ", jsonMap: " + str);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.5
            @Override // java.lang.Runnable
            public void run() {
                if (InterstitialHelper.this.mInterstitialAd != null) {
                    InterstitialHelper.this.isReady = false;
                    ATShowConfig aTShowConfigFromJsonMap = ScenarioShowConfigFactory.fromJsonMap(str);
                    MsgTools.printMsg("showInterstitialAd: " + this + ", showConfig: " + (aTShowConfigFromJsonMap != null));
                    if (aTShowConfigFromJsonMap != null) {
                        InterstitialHelper.this.mInterstitialAd.show(InterstitialHelper.this.mActivity, aTShowConfigFromJsonMap);
                        return;
                    } else {
                        InterstitialHelper.this.mInterstitialAd.show(InterstitialHelper.this.mActivity);
                        return;
                    }
                }
                Log.e("AT_android_unity3d", "showInterstitial error, you must call initInterstitial first " + this);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialHelper.this.mListener != null) {
                            synchronized (InterstitialHelper.this) {
                                InterstitialHelper.this.mListener.onInterstitialAdLoadFail(InterstitialHelper.this.mPlacementId, "-1", "you must call initInterstitial first ..");
                            }
                        }
                    }
                });
            }
        });
    }

    public boolean isAdReady() {
        MsgTools.printMsg("isAdReady start: " + this.mPlacementId);
        try {
            ATInterstitial aTInterstitial = this.mInterstitialAd;
            if (aTInterstitial != null) {
                boolean zIsAdReady = aTInterstitial.isAdReady();
                MsgTools.printMsg("isAdReady: " + zIsAdReady);
                return zIsAdReady;
            }
            Log.e("AT_android_unity3d", "isAdReady error, you must call initInterstitial first ");
            MsgTools.printMsg("isAdReady end: " + this.mPlacementId);
            return this.isReady;
        } catch (Exception e) {
            MsgTools.printMsg("isAdReady Exception: " + e.getMessage());
            return this.isReady;
        } catch (Throwable th) {
            MsgTools.printMsg("isAdReady Throwable: " + th.getMessage());
            return this.isReady;
        }
    }

    public String checkAdStatus() {
        MsgTools.printMsg("checkAdStatus: " + this.mPlacementId);
        ATInterstitial aTInterstitial = this.mInterstitialAd;
        if (aTInterstitial == null) {
            return "";
        }
        ATAdStatusInfo aTAdStatusInfoCheckAdStatus = aTInterstitial.checkAdStatus();
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
        if (this.mInterstitialAd == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        List<ATAdInfo> listCheckValidAdCaches = this.mInterstitialAd.checkValidAdCaches();
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
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.6
            @Override // java.lang.Runnable
            public void run() {
                if (InterstitialHelper.this.mInterstitialAd != null) {
                    InterstitialHelper.this.mInterstitialAd.entryAdScenario(str);
                } else {
                    MsgTools.printMsg("entryAdScenario error, you must call initInterstitial first " + InterstitialHelper.this.mPlacementId);
                }
            }
        });
    }

    public void entryAdScenario(final String str, String str2) {
        final Map<String, Object> mapStringObjectMapFromJson = JsonMapUtil.stringObjectMapFromJson(str2);
        MsgTools.printMsg("entryAdScenario (tkExtra) " + this.mPlacementId);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.7
            @Override // java.lang.Runnable
            public void run() {
                if (InterstitialHelper.this.mInterstitialAd == null) {
                    MsgTools.printMsg("entryAdScenario error, you must call initInterstitial first " + InterstitialHelper.this.mPlacementId);
                } else if (mapStringObjectMapFromJson == null) {
                    InterstitialHelper.this.mInterstitialAd.entryAdScenario(str);
                } else {
                    InterstitialHelper.this.mInterstitialAd.entryAdScenario(str, mapStringObjectMapFromJson);
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.anythink.unitybridge.interstitial.InterstitialHelper$8, reason: invalid class name */
    class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (InterstitialHelper.this.mInterstitialAd == null) {
                MsgTools.printMsg("setAdRevenueListener error, init interstitial first: " + InterstitialHelper.this.mPlacementId);
            } else {
                InterstitialHelper.this.mInterstitialAd.setAdRevenueListener(new ATAdRevenueListener() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.8.1
                    @Override // com.anythink.core.api.ATAdRevenueListener
                    public void onAdRevenuePaid(ATAdInfo aTAdInfo) {
                        final String string = aTAdInfo != null ? aTAdInfo.toString() : "";
                        TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialHelper.8.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (InterstitialHelper.this.mListener != null) {
                                    InterstitialHelper.this.mListener.onAdRevenuePaid(InterstitialHelper.this.mPlacementId, string);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    public void setAdRevenueListener() {
        UnityPluginUtils.runOnUiThread(new AnonymousClass8());
    }
}
