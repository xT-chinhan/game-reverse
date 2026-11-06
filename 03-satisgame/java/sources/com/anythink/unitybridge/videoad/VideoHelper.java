package com.anythink.unitybridge.videoad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
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
import com.anythink.rewardvideo.api.ATRewardVideoAd;
import com.anythink.rewardvideo.api.ATRewardVideoExListener;
import com.anythink.unitybridge.MsgTools;
import com.anythink.unitybridge.UnityPluginUtils;
import com.anythink.unitybridge.utils.Const;
import com.anythink.unitybridge.utils.JsonMapUtil;
import com.anythink.unitybridge.utils.ScenarioShowConfigFactory;
import com.anythink.unitybridge.utils.TaskManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class VideoHelper {
    public static final String TAG = "AT_android_unity3d";
    boolean isReady = false;
    boolean isReward = false;
    Activity mActivity;
    VideoListener mListener;
    String mPlacementId;
    ATRewardVideoAd mRewardVideoAd;

    public VideoHelper(VideoListener videoListener) {
        MsgTools.printMsg("VideoHelper: " + this);
        if (videoListener == null) {
            MsgTools.printMsg("Listener == null: ");
        }
        this.mListener = videoListener;
        this.mActivity = UnityPluginUtils.getActivity("VideoHelper");
    }

    public void initVideo(String str) {
        MsgTools.printMsg("initVideo 1: " + str);
        this.mRewardVideoAd = new ATRewardVideoAd(this.mActivity, str);
        this.mPlacementId = str;
        MsgTools.printMsg("initVideo 2: " + str);
        this.mRewardVideoAd.setAdListener(new ATRewardVideoExListener() { // from class: com.anythink.unitybridge.videoad.VideoHelper.1
            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onAgainRewardFailed(ATAdInfo aTAdInfo) {
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onDeeplinkCallback(ATAdInfo aTAdInfo, boolean z) {
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onRewardFailed(ATAdInfo aTAdInfo) {
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onRewardedVideoAdAgainPlayStart(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onRewardedVideoAdAgainPlayStart: " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onRewardedVideoAdAgainPlayStart(VideoHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onRewardedVideoAdAgainPlayEnd(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onRewardedVideoAdAgainPlayEnd: " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onRewardedVideoAdAgainPlayEnd(VideoHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onRewardedVideoAdAgainPlayFailed(final AdError adError, ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onRewardedVideoAdAgainPlayFailed: " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onRewardedVideoAdAgainPlayFailed(VideoHelper.this.mPlacementId, adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onRewardedVideoAdAgainPlayClicked(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onRewardedVideoAdAgainPlayClicked: " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onRewardedVideoAdAgainPlayClicked(VideoHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoExListener
            public void onAgainReward(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAgainReward: " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onAgainReward(VideoHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdLoaded() {
                MsgTools.printMsg("onRewardedVideoAdLoaded: " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoHelper.this.isReady = true;
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onRewardedVideoAdLoaded(VideoHelper.this.mPlacementId);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdFailed(final AdError adError) {
                MsgTools.printMsg("onRewardedVideoAdFailed: " + VideoHelper.this.mPlacementId + ", " + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onRewardedVideoAdFailed(VideoHelper.this.mPlacementId, adError.getCode(), adError.getFullErrorInfo());
                            }
                            return;
                        }
                        MsgTools.printMsg("onRewardedVideoAdFailed callnoback: " + adError.getFullErrorInfo());
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdPlayStart(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onRewardedVideoAdPlayStart: " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onRewardedVideoAdPlayStart(VideoHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdPlayEnd(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onRewardedVideoAdPlayEnd: " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onRewardedVideoAdPlayEnd(VideoHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdPlayFailed(final AdError adError, ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onRewardedVideoAdPlayFailed: " + VideoHelper.this.mPlacementId + ", " + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.1.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onRewardedVideoAdPlayFailed(VideoHelper.this.mPlacementId, adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdClosed(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onRewardedVideoAdClosed: " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.1.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onRewardedVideoAdClosed(VideoHelper.this.mPlacementId, VideoHelper.this.isReward, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onRewardedVideoAdPlayClicked(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onRewardedVideoAdPlayClicked: " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.1.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onRewardedVideoAdPlayClicked(VideoHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoListener
            public void onReward(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onReward: " + VideoHelper.this.mPlacementId);
                VideoHelper.this.isReward = true;
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.1.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onReward(VideoHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }
        });
        this.mRewardVideoAd.setAdSourceStatusListener(new ATAdSourceStatusListener() { // from class: com.anythink.unitybridge.videoad.VideoHelper.2
            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingAttempt(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceBiddingAttempt: " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onAdSourceBiddingAttempt(VideoHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingFilled(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceBiddingFilled: " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onAdSourceBiddingFilled(VideoHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingFail(final ATAdInfo aTAdInfo, final AdError adError) {
                MsgTools.printMsg("onAdSourceBiddingFail: " + VideoHelper.this.mPlacementId + "," + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onAdSourceBiddingFail(VideoHelper.this.mPlacementId, aTAdInfo.toString(), adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceAttempt(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceAttemp: " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onAdSourceAttempt(VideoHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceLoadFilled(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceLoadFilled: " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.2.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onAdSourceLoadFilled(VideoHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceLoadFail(final ATAdInfo aTAdInfo, final AdError adError) {
                MsgTools.printMsg("onAdSourceLoadFail: " + VideoHelper.this.mPlacementId + "," + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.2.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onAdSourceLoadFail(VideoHelper.this.mPlacementId, aTAdInfo.toString(), adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }
        });
        this.mRewardVideoAd.setAdMultipleLoadedListener(new ATAdMultipleLoadedListener() { // from class: com.anythink.unitybridge.videoad.VideoHelper.3
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onAdMultipleLoaded(VideoHelper.this.mPlacementId, JsonMapUtil.requestingInfoToJson(aTRequestingInfo));
                            }
                        }
                    }
                });
            }
        });
        MsgTools.printMsg("initVideo 3: " + this.mPlacementId);
    }

    public void fillVideo(final String str) {
        MsgTools.printMsg("fillVideo start: " + this.mPlacementId + ", jsonMap: " + str);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.4
            @Override // java.lang.Runnable
            public void run() {
                String strOptString;
                String strOptString2;
                String str2 = "";
                HashMap map = new HashMap();
                ATAdRequest aTAdRequestAtAdRequestFromJson = null;
                try {
                    if (TextUtils.isEmpty(str)) {
                        strOptString2 = "";
                    } else {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("atAdRequest")) {
                            aTAdRequestAtAdRequestFromJson = JsonMapUtil.atAdRequestFromJson(jSONObject.optJSONObject("atAdRequest"));
                            jSONObject.remove("atAdRequest");
                        }
                        Const.fillMapFromJsonObject(map, jSONObject);
                        strOptString = jSONObject.has("UserId") ? jSONObject.optString("UserId") : "";
                        try {
                            strOptString2 = jSONObject.has("UserExtraData") ? jSONObject.optString("UserExtraData") : "";
                        } catch (Exception unused) {
                        }
                        str2 = strOptString;
                    }
                } catch (Exception unused2) {
                    strOptString = "";
                }
                if (VideoHelper.this.mRewardVideoAd != null) {
                    if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(strOptString2)) {
                        map.put("user_id", str2);
                        map.put(ATAdConst.KEY.USER_CUSTOM_DATA, strOptString2);
                        MsgTools.printMsg("fillVideo: " + VideoHelper.this.mPlacementId + ", userId:" + str2 + ", userExtraData:" + strOptString2);
                    }
                    VideoHelper.this.mRewardVideoAd.setLocalExtra(map);
                    VideoHelper.this.mRewardVideoAd.load(VideoHelper.this.mActivity, aTAdRequestAtAdRequestFromJson);
                    return;
                }
                MsgTools.printMsg("fillVideo error, you must call initVideo first " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onRewardedVideoAdFailed(VideoHelper.this.mPlacementId, "-1", "you must call initVideo first");
                            }
                        }
                    }
                });
            }
        });
    }

    public void showVideo(final String str) {
        MsgTools.printMsg("showVideo: " + this.mPlacementId + ", jsonMap: " + str);
        this.isReward = false;
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.5
            @Override // java.lang.Runnable
            public void run() {
                if (VideoHelper.this.mRewardVideoAd != null) {
                    VideoHelper.this.isReady = false;
                    ATShowConfig aTShowConfigFromJsonMap = ScenarioShowConfigFactory.fromJsonMap(str);
                    MsgTools.printMsg("showVideo: " + VideoHelper.this.mPlacementId + ", showConfig: " + (aTShowConfigFromJsonMap != null));
                    if (aTShowConfigFromJsonMap != null) {
                        VideoHelper.this.mRewardVideoAd.show(VideoHelper.this.mActivity, aTShowConfigFromJsonMap);
                        return;
                    } else {
                        VideoHelper.this.mRewardVideoAd.show(VideoHelper.this.mActivity);
                        return;
                    }
                }
                MsgTools.printMsg("showVideo error, you must call initVideo first " + VideoHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoHelper.this.mListener != null) {
                            synchronized (VideoHelper.this) {
                                VideoHelper.this.mListener.onRewardedVideoAdFailed(VideoHelper.this.mPlacementId, "-1", "you must call initVideo first");
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
            ATRewardVideoAd aTRewardVideoAd = this.mRewardVideoAd;
            if (aTRewardVideoAd != null) {
                boolean zIsAdReady = aTRewardVideoAd.isAdReady();
                MsgTools.printMsg("isAdReady: " + this.mPlacementId + zIsAdReady);
                return zIsAdReady;
            }
            MsgTools.printMsg("isAdReady error, you must call initVideo first ");
            MsgTools.printMsg("isAdReady end: " + this.mPlacementId);
            return this.isReady;
        } catch (Exception e) {
            MsgTools.printMsg("isAdReady Exception: " + e.getMessage());
            return this.isReady;
        } catch (Throwable th) {
            MsgTools.printMsg("isAdReady Throwable:" + th.getMessage());
            return this.isReady;
        }
    }

    public String checkAdStatus() {
        MsgTools.printMsg("checkAdStatus: " + this.mPlacementId);
        ATRewardVideoAd aTRewardVideoAd = this.mRewardVideoAd;
        if (aTRewardVideoAd == null) {
            return "";
        }
        ATAdStatusInfo aTAdStatusInfoCheckAdStatus = aTRewardVideoAd.checkAdStatus();
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
        if (this.mRewardVideoAd == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        List<ATAdInfo> listCheckValidAdCaches = this.mRewardVideoAd.checkValidAdCaches();
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
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.6
            @Override // java.lang.Runnable
            public void run() {
                if (VideoHelper.this.mRewardVideoAd != null) {
                    VideoHelper.this.mRewardVideoAd.entryAdScenario(str);
                } else {
                    MsgTools.printMsg("entryAdScenario error, you must call initVideo first " + VideoHelper.this.mPlacementId);
                }
            }
        });
    }

    public void entryAdScenario(final String str, String str2) {
        final Map<String, Object> mapStringObjectMapFromJson = JsonMapUtil.stringObjectMapFromJson(str2);
        MsgTools.printMsg("entryAdScenario (tkExtra) " + this.mPlacementId + " scenario=" + str);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.7
            @Override // java.lang.Runnable
            public void run() {
                if (VideoHelper.this.mRewardVideoAd == null) {
                    MsgTools.printMsg("entryAdScenario error, you must call initVideo first " + VideoHelper.this.mPlacementId);
                } else if (mapStringObjectMapFromJson == null) {
                    VideoHelper.this.mRewardVideoAd.entryAdScenario(str);
                } else {
                    VideoHelper.this.mRewardVideoAd.entryAdScenario(str, mapStringObjectMapFromJson);
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.anythink.unitybridge.videoad.VideoHelper$8, reason: invalid class name */
    class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoHelper.this.mRewardVideoAd == null) {
                MsgTools.printMsg("setAdRevenueListener error, init video first: " + VideoHelper.this.mPlacementId);
            } else {
                VideoHelper.this.mRewardVideoAd.setAdRevenueListener(new ATAdRevenueListener() { // from class: com.anythink.unitybridge.videoad.VideoHelper.8.1
                    @Override // com.anythink.core.api.ATAdRevenueListener
                    public void onAdRevenuePaid(ATAdInfo aTAdInfo) {
                        final String string = aTAdInfo != null ? aTAdInfo.toString() : "";
                        TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoHelper.8.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (VideoHelper.this.mListener != null) {
                                    VideoHelper.this.mListener.onAdRevenuePaid(VideoHelper.this.mPlacementId, string);
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
