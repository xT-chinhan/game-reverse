package com.anythink.unitybridge.splash;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.anythink.splashad.api.ATSplashAd;
import com.anythink.splashad.api.ATSplashAdExtraInfo;
import com.anythink.splashad.api.ATSplashExListener;
import com.anythink.splashad.api.ATSplashSkipInfo;
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
public class SplashHelper {
    private static final String TAG = "SplashHelper: ";
    private Activity mActivity;
    private ViewGroup mAdContainer;
    private ViewGroup mDecorView;
    private String mPlacementId;
    private Activity mShowActivity;
    private ATSplashAd mSplashAd;
    private SplashListener mSplashListener;

    public SplashHelper(SplashListener splashListener) {
        MsgTools.printMsg("SplashHelper: " + this);
        if (splashListener == null) {
            MsgTools.printMsg("Listener == null: ");
        }
        this.mSplashListener = new SynSplashListener(splashListener);
        this.mActivity = UnityPluginUtils.getActivity("SplashHelper");
    }

    public void initSplash(String str, int i, String str2) {
        this.mPlacementId = str;
        ATSplashAd aTSplashAd = new ATSplashAd(this.mActivity, str, new ATSplashExListener() { // from class: com.anythink.unitybridge.splash.SplashHelper.1
            @Override // com.anythink.splashad.api.ATSplashExListener
            public void onSplashAdReward(ATAdInfo aTAdInfo) {
            }

            @Override // com.anythink.splashad.api.ATSplashExListener
            public void onDeeplinkCallback(ATAdInfo aTAdInfo, boolean z) {
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onSplashAdDeeplinkCallback(SplashHelper.this.mPlacementId, SplashHelper.this.formatATAdInfo(aTAdInfo), z);
                }
            }

            @Override // com.anythink.splashad.api.ATSplashExListener
            public void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onSplashAdDownloadConfirm(SplashHelper.this.mPlacementId, SplashHelper.this.formatATAdInfo(aTAdInfo));
                }
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdLoaded(boolean z) {
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onSplashAdLoad(SplashHelper.this.mPlacementId, z);
                }
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdLoadTimeout() {
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onSplashAdLoadTimeOut(SplashHelper.this.mPlacementId);
                }
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onNoAdError(AdError adError) {
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onSplashAdLoadFailed(SplashHelper.this.mPlacementId, adError != null ? adError.getCode() : "", adError != null ? adError.toString() : "");
                }
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdShow(ATAdInfo aTAdInfo) {
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onSplashAdShow(SplashHelper.this.mPlacementId, SplashHelper.this.formatATAdInfo(aTAdInfo));
                }
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdClick(ATAdInfo aTAdInfo) {
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onSplashAdClick(SplashHelper.this.mPlacementId, SplashHelper.this.formatATAdInfo(aTAdInfo));
                }
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdDismiss(ATAdInfo aTAdInfo, ATSplashAdExtraInfo aTSplashAdExtraInfo) {
                if (SplashHelper.this.mDecorView != null && SplashHelper.this.mAdContainer != null) {
                    SplashHelper.this.mAdContainer.removeAllViews();
                    SplashHelper.this.mDecorView.removeView(SplashHelper.this.mAdContainer);
                }
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onSplashAdDismiss(SplashHelper.this.mPlacementId, SplashHelper.this.formatATAdInfo(aTAdInfo));
                }
            }
        }, i);
        this.mSplashAd = aTSplashAd;
        aTSplashAd.setAdSourceStatusListener(new ATAdSourceStatusListener() { // from class: com.anythink.unitybridge.splash.SplashHelper.2
            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingAttempt(ATAdInfo aTAdInfo) {
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onAdSourceBiddingAttempt(SplashHelper.this.mPlacementId, SplashHelper.this.formatATAdInfo(aTAdInfo));
                }
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingFilled(ATAdInfo aTAdInfo) {
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onAdSourceBiddingFilled(SplashHelper.this.mPlacementId, SplashHelper.this.formatATAdInfo(aTAdInfo));
                }
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingFail(ATAdInfo aTAdInfo, AdError adError) {
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onAdSourceBiddingFail(SplashHelper.this.mPlacementId, SplashHelper.this.formatATAdInfo(aTAdInfo), adError != null ? adError.getCode() : "", adError != null ? adError.getFullErrorInfo() : "");
                }
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceAttempt(ATAdInfo aTAdInfo) {
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onAdSourceAttempt(SplashHelper.this.mPlacementId, SplashHelper.this.formatATAdInfo(aTAdInfo));
                }
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceLoadFilled(ATAdInfo aTAdInfo) {
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onAdSourceLoadFilled(SplashHelper.this.mPlacementId, SplashHelper.this.formatATAdInfo(aTAdInfo));
                }
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceLoadFail(ATAdInfo aTAdInfo, AdError adError) {
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onAdSourceLoadFail(SplashHelper.this.mPlacementId, SplashHelper.this.formatATAdInfo(aTAdInfo), adError != null ? adError.getCode() : "", adError != null ? adError.getFullErrorInfo() : "");
                }
            }
        });
        this.mSplashAd.setAdMultipleLoadedListener(new ATAdMultipleLoadedListener() { // from class: com.anythink.unitybridge.splash.SplashHelper.3
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(ATRequestingInfo aTRequestingInfo) {
                if (SplashHelper.this.mSplashListener != null) {
                    SplashHelper.this.mSplashListener.onAdMultipleLoaded(SplashHelper.this.mPlacementId, JsonMapUtil.requestingInfoToJson(aTRequestingInfo));
                }
            }
        });
        MsgTools.printMsg(TAG + "initSplash() >>> called");
    }

    public void loadAd(String str) {
        MsgTools.printMsg(TAG + "loadAd() >>> mPlacementId: " + this.mPlacementId + ", jsonMap: " + str);
        final ATAdRequest[] aTAdRequestArr = new ATAdRequest[1];
        if (!TextUtils.isEmpty(str)) {
            try {
                HashMap map = new HashMap();
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("atAdRequest")) {
                    aTAdRequestArr[0] = JsonMapUtil.atAdRequestFromJson(jSONObject.optJSONObject("atAdRequest"));
                    jSONObject.remove("atAdRequest");
                }
                Const.fillMapFromJsonObject(map, jSONObject);
                ATSplashAd aTSplashAd = this.mSplashAd;
                if (aTSplashAd != null) {
                    aTSplashAd.setLocalExtra(map);
                }
            } catch (Exception e) {
                MsgTools.printMsg(TAG + "loadAd() >>> failed: " + e.getMessage());
            }
        }
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (SplashHelper.this.mSplashAd != null) {
                    SplashHelper.this.mSplashAd.loadAd(aTAdRequestArr[0]);
                } else {
                    Log.e(SplashHelper.TAG, "loadAd error, you must call initSplash first " + this);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SplashHelper.this.mSplashListener != null) {
                                synchronized (SplashHelper.this) {
                                    SplashHelper.this.mSplashListener.onSplashAdLoadFailed(SplashHelper.this.mPlacementId, "-1", "you must call initSplash first ..");
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    public void showAd(final String str) {
        StringBuilder sb = new StringBuilder();
        String str2 = TAG;
        MsgTools.printMsg(sb.append(str2).append("showAd() >>> jsonMap: ").append(str).append(" mShowActivity: ").append(this.mShowActivity).toString());
        if (this.mSplashAd == null) {
            MsgTools.printMsg(str2 + "showAd failed, you must call initSplash first.");
            TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.5
                @Override // java.lang.Runnable
                public void run() {
                    if (SplashHelper.this.mSplashListener != null) {
                        synchronized (SplashHelper.this) {
                            SplashHelper.this.mSplashListener.onSplashAdLoadFailed(SplashHelper.this.mPlacementId, "-1", "you must call initSplash first.");
                        }
                    }
                }
            });
        } else {
            UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.6
                @Override // java.lang.Runnable
                public void run() {
                    ATShowConfig aTShowConfigFromJsonMap = ScenarioShowConfigFactory.fromJsonMap(str);
                    MsgTools.printMsg(SplashHelper.TAG + "showAd showConfig: " + (aTShowConfigFromJsonMap != null));
                    try {
                        SplashHelper.this.mShowActivity = UnityPluginUtils.getActivity("SplashHelper");
                        SplashHelper splashHelper = SplashHelper.this;
                        splashHelper.mDecorView = (ViewGroup) splashHelper.mShowActivity.findViewById(R.id.content);
                        if (SplashHelper.this.mAdContainer == null) {
                            SplashHelper.this.mAdContainer = new FrameLayout(SplashHelper.this.mShowActivity);
                            SplashHelper.this.mAdContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        }
                        SplashHelper.this.mAdContainer.removeAllViews();
                        if (SplashHelper.this.mDecorView != null) {
                            SplashHelper.this.mDecorView.removeView(SplashHelper.this.mAdContainer);
                            SplashHelper.this.mDecorView.addView(SplashHelper.this.mAdContainer);
                        }
                        if (aTShowConfigFromJsonMap != null) {
                            SplashHelper.this.mSplashAd.show(SplashHelper.this.mShowActivity, SplashHelper.this.mAdContainer, (ATSplashSkipInfo) null, aTShowConfigFromJsonMap);
                        } else {
                            SplashHelper.this.mSplashAd.show(SplashHelper.this.mShowActivity, SplashHelper.this.mAdContainer);
                        }
                    } catch (Exception e) {
                        MsgTools.printMsg(SplashHelper.TAG + "showAd failed: " + e.getMessage());
                    }
                }
            });
        }
    }

    public boolean isAdReady() {
        ATSplashAd aTSplashAd = this.mSplashAd;
        boolean z = aTSplashAd != null && aTSplashAd.isAdReady();
        MsgTools.printMsg(TAG + "isAdReady() >>> mPlacementId: " + this.mPlacementId + " isAdReady: " + z);
        return z;
    }

    public String checkAdStatus() {
        MsgTools.printMsg(TAG + "checkAdStatus: " + this.mPlacementId);
        ATSplashAd aTSplashAd = this.mSplashAd;
        if (aTSplashAd == null) {
            return "";
        }
        ATAdStatusInfo aTAdStatusInfoCheckAdStatus = aTSplashAd.checkAdStatus();
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
        MsgTools.printMsg(TAG + "getValidAdCaches:" + this.mPlacementId);
        if (this.mSplashAd == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        List<ATAdInfo> listCheckValidAdCaches = this.mSplashAd.checkValidAdCaches();
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
        MsgTools.printMsg(TAG + "entryAdScenario mPlacementId: " + this.mPlacementId + ", scenarioId: " + str);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.7
            @Override // java.lang.Runnable
            public void run() {
                if (SplashHelper.this.mSplashAd != null) {
                    SplashHelper.this.mSplashAd.entryAdScenario(str);
                } else {
                    MsgTools.printMsg("entryAdScenario error, you must call initSplash first " + SplashHelper.this.mPlacementId);
                }
            }
        });
    }

    public void entryAdScenario(final String str, String str2) {
        final Map<String, Object> mapStringObjectMapFromJson = JsonMapUtil.stringObjectMapFromJson(str2);
        MsgTools.printMsg(TAG + "entryAdScenario (tkExtra) " + this.mPlacementId);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.8
            @Override // java.lang.Runnable
            public void run() {
                if (SplashHelper.this.mSplashAd == null) {
                    MsgTools.printMsg("entryAdScenario error, you must call initSplash first " + SplashHelper.this.mPlacementId);
                } else if (mapStringObjectMapFromJson == null) {
                    SplashHelper.this.mSplashAd.entryAdScenario(str);
                } else {
                    SplashHelper.this.mSplashAd.entryAdScenario(str, mapStringObjectMapFromJson);
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.anythink.unitybridge.splash.SplashHelper$9, reason: invalid class name */
    class AnonymousClass9 implements Runnable {
        AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SplashHelper.this.mSplashAd == null) {
                MsgTools.printMsg("setAdRevenueListener error, init splash first: " + SplashHelper.this.mPlacementId);
            } else {
                SplashHelper.this.mSplashAd.setAdRevenueListener(new ATAdRevenueListener() { // from class: com.anythink.unitybridge.splash.SplashHelper.9.1
                    @Override // com.anythink.core.api.ATAdRevenueListener
                    public void onAdRevenuePaid(ATAdInfo aTAdInfo) {
                        final String string = aTAdInfo != null ? aTAdInfo.toString() : "";
                        TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.9.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SplashHelper.this.mSplashListener != null) {
                                    SplashHelper.this.mSplashListener.onAdRevenuePaid(SplashHelper.this.mPlacementId, string);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    public void setAdRevenueListener() {
        UnityPluginUtils.runOnUiThread(new AnonymousClass9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatATAdInfo(ATAdInfo aTAdInfo) {
        return aTAdInfo != null ? aTAdInfo.toString() : "";
    }

    private static class SynSplashListener implements SplashListener {
        private final Object lockObj = new Object();
        private final SplashListener splashListener;

        public SynSplashListener(SplashListener splashListener) {
            this.splashListener = splashListener;
        }

        private void runOnThread(Runnable runnable) {
            TaskManager.getInstance().run_proxy(runnable);
        }

        @Override // com.anythink.unitybridge.splash.SplashListener
        public void onSplashAdLoad(final String str, final boolean z) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onSplashAdLoad(str, z);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.splash.SplashListener
        public void onSplashAdLoadTimeOut(final String str) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onSplashAdLoadTimeOut(str);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.splash.SplashListener
        public void onSplashAdLoadFailed(final String str, final String str2, final String str3) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onSplashAdLoadFailed(str, str2, str3);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.splash.SplashListener
        public void onSplashAdShow(final String str, final String str2) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onSplashAdShow(str, str2);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.splash.SplashListener
        public void onSplashAdClick(final String str, final String str2) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.5
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onSplashAdClick(str, str2);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.splash.SplashListener
        public void onSplashAdDismiss(final String str, final String str2) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.6
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onSplashAdDismiss(str, str2);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.splash.SplashListener
        public void onSplashAdDeeplinkCallback(final String str, final String str2, final boolean z) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.7
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onSplashAdDeeplinkCallback(str, str2, z);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.splash.SplashListener
        public void onSplashAdDownloadConfirm(final String str, final String str2) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.8
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onSplashAdDownloadConfirm(str, str2);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.base.BaseAdListener
        public void onAdSourceBiddingAttempt(final String str, final String str2) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.9
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onAdSourceBiddingAttempt(str, str2);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.base.BaseAdListener
        public void onAdSourceBiddingFilled(final String str, final String str2) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.10
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onAdSourceBiddingFilled(str, str2);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.base.BaseAdListener
        public void onAdSourceBiddingFail(final String str, final String str2, final String str3, final String str4) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.11
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onAdSourceBiddingFail(str, str2, str3, str4);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.base.BaseAdListener
        public void onAdSourceAttempt(final String str, final String str2) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.12
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onAdSourceAttempt(str, str2);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.base.BaseAdListener
        public void onAdSourceLoadFilled(final String str, final String str2) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.13
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onAdSourceLoadFilled(str, str2);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.base.BaseAdListener
        public void onAdSourceLoadFail(final String str, final String str2, final String str3, final String str4) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.14
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onAdSourceLoadFail(str, str2, str3, str4);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.base.BaseAdListener
        public void onAdMultipleLoaded(final String str, final String str2) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.15
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onAdMultipleLoaded(str, str2);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.unitybridge.splash.SplashListener
        public void onAdRevenuePaid(final String str, final String str2) {
            if (this.splashListener != null) {
                runOnThread(new Runnable() { // from class: com.anythink.unitybridge.splash.SplashHelper.SynSplashListener.16
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SynSplashListener.this.lockObj) {
                            SynSplashListener.this.splashListener.onAdRevenuePaid(str, str2);
                        }
                    }
                });
            }
        }
    }
}
