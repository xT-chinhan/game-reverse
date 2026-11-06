package com.anythink.unitybridge.videoad;

import android.app.Activity;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.AdError;
import com.anythink.rewardvideo.api.ATRewardVideoAutoAd;
import com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener;
import com.anythink.rewardvideo.api.ATRewardVideoAutoLoadListener;
import com.anythink.unitybridge.MsgTools;
import com.anythink.unitybridge.UnityPluginUtils;
import com.anythink.unitybridge.utils.Const;
import com.anythink.unitybridge.utils.TaskManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class VideoAutoAdHelper {
    public final String LOG_PRE = "video_autoad ";
    Activity mActivity;
    List<String> mAddedPlacementIds;
    VideoListener mListener;

    public VideoAutoAdHelper(VideoListener videoListener) {
        MsgTools.printMsg("video_autoad ", "VideoAutoAdHelper: " + this);
        if (videoListener == null) {
            MsgTools.printMsg("video_autoad ", "Listener == null: ");
        }
        this.mListener = videoListener;
        this.mActivity = UnityPluginUtils.getActivity("VideoAutoAdHelper");
        this.mAddedPlacementIds = new ArrayList();
        ATRewardVideoAutoAd.init(this.mActivity, null, new ATRewardVideoAutoLoadListener() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.1
            @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoLoadListener
            public void onRewardVideoAutoLoaded(final String str) {
                MsgTools.printMsg("video_autoad ", "onRewardVideoAutoLoaded: " + str);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoAutoAdHelper.this.mListener != null) {
                            synchronized (VideoAutoAdHelper.this) {
                                VideoAutoAdHelper.this.mListener.onRewardedVideoAdLoaded(str);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoLoadListener
            public void onRewardVideoAutoLoadFail(final String str, final AdError adError) {
                MsgTools.printMsg("video_autoad ", "onRewardVideoAutoLoadFail: " + str + ", " + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoAutoAdHelper.this.mListener != null) {
                            synchronized (VideoAutoAdHelper.this) {
                                VideoAutoAdHelper.this.mListener.onRewardedVideoAdFailed(str, adError.getCode(), adError.getFullErrorInfo());
                            }
                            return;
                        }
                        MsgTools.printMsg("video_autoad ", "onRewardVideoAutoLoadFail callnoback: " + adError.getFullErrorInfo());
                    }
                });
            }
        });
        MsgTools.printMsg("video_autoad ", "VideoAutoAdHelper: init success");
    }

    public void addPlacementIds(String str) {
        if (TextUtils.isEmpty(str)) {
            MsgTools.printMsg("video_autoad ", "addPlacementIds warn: not set placementIds");
            return;
        }
        try {
            MsgTools.printMsg("video_autoad ", "addPlacementIds: " + str);
            JSONArray jSONArray = new JSONArray(str);
            final String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = jSONArray.getString(i);
            }
            this.mAddedPlacementIds.addAll(Arrays.asList(strArr));
            UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    ATRewardVideoAutoAd.addPlacementId(strArr);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            MsgTools.printMsg("video_autoad ", "addPlacementIds error,please check your placementIds:\"" + str + "\"");
        }
    }

    public void removePlacementIds(String str) {
        if (TextUtils.isEmpty(str)) {
            MsgTools.printMsg("video_autoad ", "removePlacementIds warn: not set placementId");
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            final String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = jSONArray.getString(i);
            }
            this.mAddedPlacementIds.removeAll(Arrays.asList(strArr));
            MsgTools.printMsg("video_autoad ", "removePlacementIds: " + str);
            UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    ATRewardVideoAutoAd.removePlacementId(strArr);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            MsgTools.printMsg("video_autoad ", "removePlacementIds error,please check your placementIds:\"" + str + "\"");
        }
    }

    public void show(String str, String str2) {
        if (this.mListener == null) {
            MsgTools.printMsg("video_autoad ", "show warn:please init before show");
        }
        if (!this.mAddedPlacementIds.contains(str)) {
            MsgTools.printMsg("video_autoad ", "show warn:please addPlacementIds first: " + str);
        }
        if (!ATRewardVideoAutoAd.isAdReady(str)) {
            MsgTools.printMsg("video_autoad ", "show fail:this placementId(" + str + ") is not ready to show");
            return;
        }
        String strOptString = "";
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has(Const.SCENARIO)) {
                    strOptString = jSONObject.optString(Const.SCENARIO);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        MsgTools.printMsg("video_autoad ", "show placementId:" + str + ", scenario:" + strOptString);
        UnityPluginUtils.runOnUiThread(new AnonymousClass4(str, strOptString));
    }

    /* JADX INFO: renamed from: com.anythink.unitybridge.videoad.VideoAutoAdHelper$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ String val$finalScenario;
        final /* synthetic */ String val$placementId;

        AnonymousClass4(String str, String str2) {
            this.val$placementId = str;
            this.val$finalScenario = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            final boolean[] zArr = {false};
            ATRewardVideoAutoAd.show(VideoAutoAdHelper.this.mActivity, this.val$placementId, this.val$finalScenario, new ATRewardVideoAutoEventListener() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.4.1
                @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener
                public void onRewardedVideoAdPlayStart(final ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onRewardedVideoAdPlayStart: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.4.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoAutoAdHelper.this.mListener != null) {
                                synchronized (VideoAutoAdHelper.this) {
                                    VideoAutoAdHelper.this.mListener.onRewardedVideoAdPlayStart(AnonymousClass4.this.val$placementId, aTAdInfo.toString());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener
                public void onRewardedVideoAdPlayEnd(final ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onRewardedVideoAdPlayEnd: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.4.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoAutoAdHelper.this.mListener != null) {
                                synchronized (VideoAutoAdHelper.this) {
                                    VideoAutoAdHelper.this.mListener.onRewardedVideoAdPlayEnd(AnonymousClass4.this.val$placementId, aTAdInfo.toString());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener
                public void onRewardedVideoAdPlayFailed(final AdError adError, ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onRewardedVideoAdPlayFailed: " + AnonymousClass4.this.val$placementId + ", " + adError.getFullErrorInfo());
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.4.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoAutoAdHelper.this.mListener != null) {
                                synchronized (VideoAutoAdHelper.this) {
                                    VideoAutoAdHelper.this.mListener.onRewardedVideoAdPlayFailed(AnonymousClass4.this.val$placementId, adError.getCode(), adError.getFullErrorInfo());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener
                public void onRewardedVideoAdClosed(final ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onRewardedVideoAdClosed: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.4.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoAutoAdHelper.this.mListener != null) {
                                synchronized (VideoAutoAdHelper.this) {
                                    VideoAutoAdHelper.this.mListener.onRewardedVideoAdClosed(AnonymousClass4.this.val$placementId, zArr[0], aTAdInfo.toString());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener
                public void onRewardedVideoAdPlayClicked(final ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onRewardedVideoAdPlayClicked: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.4.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoAutoAdHelper.this.mListener != null) {
                                synchronized (VideoAutoAdHelper.this) {
                                    VideoAutoAdHelper.this.mListener.onRewardedVideoAdPlayClicked(AnonymousClass4.this.val$placementId, aTAdInfo.toString());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener
                public void onReward(final ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onReward: " + AnonymousClass4.this.val$placementId);
                    zArr[0] = true;
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.4.1.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoAutoAdHelper.this.mListener != null) {
                                synchronized (VideoAutoAdHelper.this) {
                                    VideoAutoAdHelper.this.mListener.onReward(AnonymousClass4.this.val$placementId, aTAdInfo.toString());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener
                public void onRewardedVideoAdAgainPlayStart(final ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onRewardedVideoAdAgainPlayStart: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.4.1.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoAutoAdHelper.this.mListener != null) {
                                synchronized (VideoAutoAdHelper.this) {
                                    VideoAutoAdHelper.this.mListener.onRewardedVideoAdAgainPlayStart(AnonymousClass4.this.val$placementId, aTAdInfo.toString());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener
                public void onRewardedVideoAdAgainPlayEnd(final ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onRewardedVideoAdAgainPlayEnd: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.4.1.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoAutoAdHelper.this.mListener != null) {
                                synchronized (VideoAutoAdHelper.this) {
                                    VideoAutoAdHelper.this.mListener.onRewardedVideoAdAgainPlayEnd(AnonymousClass4.this.val$placementId, aTAdInfo.toString());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener
                public void onRewardedVideoAdAgainPlayFailed(final AdError adError, ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onRewardedVideoAdAgainPlayFailed: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.4.1.9
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoAutoAdHelper.this.mListener != null) {
                                synchronized (VideoAutoAdHelper.this) {
                                    VideoAutoAdHelper.this.mListener.onRewardedVideoAdAgainPlayFailed(AnonymousClass4.this.val$placementId, adError.getCode(), adError.getFullErrorInfo());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener
                public void onRewardedVideoAdAgainPlayClicked(final ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onRewardedVideoAdAgainPlayClicked: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.4.1.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoAutoAdHelper.this.mListener != null) {
                                synchronized (VideoAutoAdHelper.this) {
                                    VideoAutoAdHelper.this.mListener.onRewardedVideoAdAgainPlayClicked(AnonymousClass4.this.val$placementId, aTAdInfo.toString());
                                }
                            }
                        }
                    });
                }

                @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener
                public void onAgainReward(final ATAdInfo aTAdInfo) {
                    MsgTools.printMsg("onAgainReward: " + AnonymousClass4.this.val$placementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.4.1.11
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoAutoAdHelper.this.mListener != null) {
                                synchronized (VideoAutoAdHelper.this) {
                                    VideoAutoAdHelper.this.mListener.onAgainReward(AnonymousClass4.this.val$placementId, aTAdInfo.toString());
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    public void setAdExtraData(final String str, final String str2) {
        MsgTools.printMsg("video_autoad ", "setExtraData start: " + str + "," + str2);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.videoad.VideoAutoAdHelper.5
            @Override // java.lang.Runnable
            public void run() {
                String strOptString;
                String strOptString2;
                String str3 = "";
                HashMap map = new HashMap();
                try {
                    if (TextUtils.isEmpty(str2)) {
                        strOptString2 = "";
                    } else {
                        JSONObject jSONObject = new JSONObject(str2);
                        Const.fillMapFromJsonObject(map, jSONObject);
                        strOptString = jSONObject.has("UserId") ? jSONObject.optString("UserId") : "";
                        try {
                            strOptString2 = jSONObject.has("UserExtraData") ? jSONObject.optString("UserExtraData") : "";
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            MsgTools.printMsg("video_autoad ", "setExtraData failed: " + str + "," + str2);
                        }
                        str3 = strOptString;
                    }
                } catch (Exception e2) {
                    e = e2;
                    strOptString = "";
                }
                if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(strOptString2)) {
                    return;
                }
                map.put("user_id", str3);
                map.put(ATAdConst.KEY.USER_CUSTOM_DATA, strOptString2);
                ATRewardVideoAutoAd.setLocalExtra(str, map);
                MsgTools.printMsg("fillVideo: " + str + ", userId:" + str3 + ", userExtraData:" + strOptString2);
            }
        });
    }

    public boolean isAdReady(String str) {
        if (!this.mAddedPlacementIds.contains(str)) {
            MsgTools.printMsg("video_autoad ", "isAdReady please addPlacementIds first: " + str);
        }
        boolean zIsAdReady = ATRewardVideoAutoAd.isAdReady(str);
        MsgTools.printMsg("video_autoad ", "isAdReady: " + str + ", " + zIsAdReady);
        return zIsAdReady;
    }

    public String checkAdStatus(String str) {
        if (!this.mAddedPlacementIds.contains(str)) {
            MsgTools.printMsg("video_autoad ", "checkAdStatus please addPlacementIds first: " + str);
        }
        ATAdStatusInfo aTAdStatusInfoCheckAdStatus = ATRewardVideoAutoAd.checkAdStatus(str);
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
        MsgTools.printMsg("video_autoad ", "getValidAdCaches:" + str);
        JSONArray jSONArray = new JSONArray();
        List<ATAdInfo> listCheckValidAdCaches = ATRewardVideoAutoAd.checkValidAdCaches(str);
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
        MsgTools.printMsg("video_autoad ", "entryAdScenario... " + str + "," + str2);
        ATRewardVideoAutoAd.entryAdScenario(str, str2);
    }
}
