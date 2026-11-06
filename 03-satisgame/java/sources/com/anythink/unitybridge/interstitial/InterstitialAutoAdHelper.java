package com.anythink.unitybridge.interstitial;

import android.app.Activity;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.AdError;
import com.anythink.interstitial.api.ATInterstitialAutoAd;
import com.anythink.interstitial.api.ATInterstitialAutoEventListener;
import com.anythink.interstitial.api.ATInterstitialAutoLoadListener;
import com.anythink.unitybridge.MsgTools;
import com.anythink.unitybridge.UnityPluginUtils;
import com.anythink.unitybridge.utils.Const;
import com.anythink.unitybridge.utils.JsonMapUtil;
import com.anythink.unitybridge.utils.ScenarioShowConfigFactory;
import com.anythink.unitybridge.utils.TaskManager;
import com.byazt.af.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class InterstitialAutoAdHelper {
    public final String LOG_PRE = "interstitial_autoad ";
    Activity mActivity;
    List<String> mAddedPlacementIds;
    InterstitialListener mListener;
    private boolean mWantsRevenue;

    public InterstitialAutoAdHelper(InterstitialListener interstitialListener) {
        MsgTools.printMsg("interstitial_autoad ", "InterstitialAutoAdHelper: " + this);
        if (interstitialListener == null) {
            MsgTools.printMsg("interstitial_autoad ", "Listener == null: ");
        }
        this.mListener = interstitialListener;
        this.mActivity = UnityPluginUtils.getActivity("InterstitialAutoAdHelper");
        this.mAddedPlacementIds = new ArrayList();
        ATInterstitialAutoAd.init(this.mActivity, null, new ATInterstitialAutoLoadListener() { // from class: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper.1
            @Override // com.anythink.interstitial.api.ATInterstitialAutoLoadListener
            public void onInterstitialAutoLoaded(final String str) {
                MsgTools.printMsg("interstitial_autoad ", "onInterstitialAutoLoaded: " + str);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialAutoAdHelper.this.mListener != null) {
                            synchronized (InterstitialAutoAdHelper.this) {
                                InterstitialAutoAdHelper.this.mListener.onInterstitialAdLoaded(str);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.interstitial.api.ATInterstitialAutoLoadListener
            public void onInterstitialAutoLoadFail(final String str, final AdError adError) {
                MsgTools.printMsg("interstitial_autoad ", "onRewardVideoAutoLoadFail: " + str + ", " + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialAutoAdHelper.this.mListener != null) {
                            synchronized (InterstitialAutoAdHelper.this) {
                                InterstitialAutoAdHelper.this.mListener.onInterstitialAdLoadFail(str, adError.getCode(), adError.getFullErrorInfo());
                            }
                            return;
                        }
                        MsgTools.printMsg("interstitial_autoad ", "onRewardVideoAutoLoadFail callnoback: " + adError.getFullErrorInfo());
                    }
                });
            }
        });
        MsgTools.printMsg("interstitial_autoad ", "InterstitialAutoAdHelper: init success");
    }

    public void addPlacementIds(String str) {
        if (TextUtils.isEmpty(str)) {
            MsgTools.printMsg("interstitial_autoad ", "addPlacementIds warn: not set placementIds");
            return;
        }
        try {
            MsgTools.printMsg("interstitial_autoad ", "addPlacementIds: " + str);
            JSONArray jSONArray = new JSONArray(str);
            final String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = jSONArray.getString(i);
            }
            this.mAddedPlacementIds.addAll(Arrays.asList(strArr));
            UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    ATInterstitialAutoAd.addPlacementId(strArr);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            MsgTools.printMsg("interstitial_autoad ", "addPlacementIds error,please check your placementIds:\"" + str + "\"");
        }
    }

    public void removePlacementIds(String str) {
        if (TextUtils.isEmpty(str)) {
            MsgTools.printMsg("interstitial_autoad ", "removePlacementIds warn: not set placementId");
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            final String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = jSONArray.getString(i);
            }
            this.mAddedPlacementIds.removeAll(Arrays.asList(strArr));
            MsgTools.printMsg("interstitial_autoad ", "removePlacementIds: " + str);
            UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    ATInterstitialAutoAd.removePlacementId(strArr);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            MsgTools.printMsg("interstitial_autoad ", "removePlacementIds error,please check your placementIds:\"" + str + "\"");
        }
    }

    public void show(String str, String str2) {
        if (this.mListener == null) {
            MsgTools.printMsg("interstitial_autoad ", "show warn:please init before show");
        }
        if (!this.mAddedPlacementIds.contains(str)) {
            MsgTools.printMsg("interstitial_autoad ", "show warn:please addPlacementIds first: " + str);
        }
        if (!ATInterstitialAutoAd.isAdReady(str)) {
            MsgTools.printMsg("interstitial_autoad ", "show fail:this placementId(" + str + ") is not ready to show");
        } else {
            MsgTools.printMsg("interstitial_autoad ", "show placementId:" + str + ", jsonMap:" + str2);
            UnityPluginUtils.runOnUiThread(new AnonymousClass4(str2, str));
        }
    }

    /* JADX INFO: renamed from: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ String val$jsonMap;
        final /* synthetic */ String val$placementId;

        AnonymousClass4(String str, String str2) {
            this.val$jsonMap = str;
            this.val$placementId = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ATInterstitialAutoAd.show(InterstitialAutoAdHelper.this.mActivity, this.val$placementId, ScenarioShowConfigFactory.fromJsonMap(this.val$jsonMap), new ATInterstitialAutoEventListener() { // from class: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper.4.2
                @Override // com.anythink.interstitial.api.ATInterstitialAutoEventListener
                public void onInterstitialAdClicked(final ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onInterstitialAdClicked: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper.4.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (InterstitialAutoAdHelper.this.mListener != null) {
                                synchronized (InterstitialAutoAdHelper.this) {
                                    InterstitialAutoAdHelper.this.mListener.onInterstitialAdClicked(AnonymousClass4.this.val$placementId, aTAdInfo.toString());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.interstitial.api.ATInterstitialAutoEventListener
                public void onInterstitialAdShow(final ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onInterstitialAdShow: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper.4.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (InterstitialAutoAdHelper.this.mListener != null) {
                                synchronized (InterstitialAutoAdHelper.this) {
                                    InterstitialAutoAdHelper.this.mListener.onInterstitialAdShow(AnonymousClass4.this.val$placementId, aTAdInfo.toString());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.interstitial.api.ATInterstitialAutoEventListener
                public void onInterstitialAdClose(final ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onInterstitialAdClose: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper.4.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (InterstitialAutoAdHelper.this.mListener != null) {
                                synchronized (InterstitialAutoAdHelper.this) {
                                    InterstitialAutoAdHelper.this.mListener.onInterstitialAdClose(AnonymousClass4.this.val$placementId, aTAdInfo.toString());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.interstitial.api.ATInterstitialAutoEventListener
                public void onInterstitialAdVideoStart(final ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onInterstitialAdVideoStart: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper.4.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (InterstitialAutoAdHelper.this.mListener != null) {
                                synchronized (InterstitialAutoAdHelper.this) {
                                    InterstitialAutoAdHelper.this.mListener.onInterstitialAdVideoStart(AnonymousClass4.this.val$placementId, aTAdInfo.toString());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.interstitial.api.ATInterstitialAutoEventListener
                public void onInterstitialAdVideoEnd(final ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onInterstitialAdVideoEnd: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper.4.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (InterstitialAutoAdHelper.this.mListener != null) {
                                synchronized (InterstitialAutoAdHelper.this) {
                                    InterstitialAutoAdHelper.this.mListener.onInterstitialAdVideoEnd(AnonymousClass4.this.val$placementId, aTAdInfo.toString());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.interstitial.api.ATInterstitialAutoEventListener
                public void onInterstitialAdVideoError(final AdError adError) {
                    MsgTools.printMsg("onInterstitialAdVideoError: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper.4.2.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (InterstitialAutoAdHelper.this.mListener != null) {
                                synchronized (InterstitialAutoAdHelper.this) {
                                    InterstitialAutoAdHelper.this.mListener.onInterstitialAdVideoError(AnonymousClass4.this.val$placementId, adError.getCode(), adError.getFullErrorInfo());
                                }
                            }
                        }
                    });
                }
            }, InterstitialAutoAdHelper.this.mWantsRevenue ? new ATAdRevenueListener() { // from class: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper.4.1
                @Override // com.anythink.core.api.ATAdRevenueListener
                public void onAdRevenuePaid(ATAdInfo aTAdInfo) {
                    final String string = aTAdInfo != null ? aTAdInfo.toString() : "";
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.interstitial.InterstitialAutoAdHelper.4.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (InterstitialAutoAdHelper.this.mListener != null) {
                                InterstitialAutoAdHelper.this.mListener.onAdRevenuePaid(AnonymousClass4.this.val$placementId, string);
                            }
                        }
                    });
                }
            } : null);
        }
    }

    public void setAdRevenueListener() {
        this.mWantsRevenue = true;
    }

    public void setAdExtraData(String str, String str2) {
        MsgTools.printMsg("interstitial_autoad ", "setAdExtraData start: " + str + ", jsonMap: " + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            try {
                String str3 = (String) jSONObject.get(Const.Interstital.UseRewardedVideoAsInterstitial);
                if (str3 != null && TextUtils.equals("1", str3)) {
                    map.put("is_use_rewarded_video_as_interstitial", true);
                }
            } catch (Throwable unused) {
            }
            try {
                String str4 = (String) jSONObject.get(Const.Interstital.interstitial_ad_size);
                if (!TextUtils.isEmpty(str4)) {
                    String[] strArrSplit = str4.split(x.n);
                    MsgTools.printMsg("loadInterstitialAd, inter_ad_size" + str4);
                    map.put(ATAdConst.KEY.AD_WIDTH, strArrSplit[0]);
                    map.put(ATAdConst.KEY.AD_HEIGHT, strArrSplit[1]);
                }
            } catch (Throwable unused2) {
            }
            Const.fillMapFromJsonObject(map, jSONObject);
            ATInterstitialAutoAd.setLocalExtra(str, map);
        } catch (Throwable unused3) {
        }
    }

    public boolean isAdReady(String str) {
        if (!this.mAddedPlacementIds.contains(str)) {
            MsgTools.printMsg("interstitial_autoad ", "isAdReady please addPlacementIds first: " + str);
        }
        boolean zIsAdReady = ATInterstitialAutoAd.isAdReady(str);
        MsgTools.printMsg("interstitial_autoad ", "isAdReady: " + str + ", " + zIsAdReady);
        return zIsAdReady;
    }

    public String checkAdStatus(String str) {
        if (!this.mAddedPlacementIds.contains(str)) {
            MsgTools.printMsg("interstitial_autoad ", "checkAdStatus please addPlacementIds first: " + str);
        }
        ATAdStatusInfo aTAdStatusInfoCheckAdStatus = ATInterstitialAutoAd.checkAdStatus(str);
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

    public String getValidAdCaches(String str) {
        MsgTools.printMsg("interstitial_autoad ", "getValidAdCaches:" + str);
        JSONArray jSONArray = new JSONArray();
        List<ATAdInfo> listCheckValidAdCaches = ATInterstitialAutoAd.checkValidAdCaches(str);
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

    public void entryAdScenario(String str, String str2) {
        MsgTools.printMsg("interstitial_autoad ", "entryAdScenario... " + str + "," + str2);
        ATInterstitialAutoAd.entryAdScenario(str, str2);
    }

    public void entryAdScenario(String str, String str2, String str3) {
        Map<String, Object> mapStringObjectMapFromJson = JsonMapUtil.stringObjectMapFromJson(str3);
        if (mapStringObjectMapFromJson == null) {
            ATInterstitialAutoAd.entryAdScenario(str, str2);
        } else {
            ATInterstitialAutoAd.entryAdScenario(str, str2, mapStringObjectMapFromJson);
        }
    }
}
