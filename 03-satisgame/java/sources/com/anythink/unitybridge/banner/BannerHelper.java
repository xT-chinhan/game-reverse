package com.anythink.unitybridge.banner;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.banner.api.ATBannerListener;
import com.anythink.banner.api.ATBannerView;
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
import com.anythink.unitybridge.MsgTools;
import com.anythink.unitybridge.UnityPluginUtils;
import com.anythink.unitybridge.utils.CommonUtil;
import com.anythink.unitybridge.utils.Const;
import com.anythink.unitybridge.utils.JsonMapUtil;
import com.anythink.unitybridge.utils.ScenarioShowConfigFactory;
import com.anythink.unitybridge.utils.TaskManager;
import com.byazt.af.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BannerHelper {
    private static final String kATBannerAdShowingPisitionBottom = "bottom";
    private static final String kATBannerAdShowingPisitionTop = "top";
    private final String TAG = getClass().getSimpleName();
    Activity mActivity;
    ATBannerView mBannerView;
    BannerListener mListener;
    String mPlacementId;

    public BannerHelper(BannerListener bannerListener) {
        MsgTools.printMsg("BannerHelper: " + this);
        if (bannerListener == null) {
            MsgTools.printMsg("Listener == null");
        }
        this.mListener = bannerListener;
        this.mActivity = UnityPluginUtils.getActivity("BannerHelper");
        this.mPlacementId = "";
    }

    public void initBanner(String str) {
        MsgTools.printMsg("initBanner 1: " + str);
        this.mPlacementId = str;
        ATBannerView aTBannerView = new ATBannerView(this.mActivity);
        this.mBannerView = aTBannerView;
        aTBannerView.setPlacementId(this.mPlacementId);
        MsgTools.printMsg("initBanner 2: " + this.mPlacementId);
        this.mBannerView.setBannerAdListener(new ATBannerListener() { // from class: com.anythink.unitybridge.banner.BannerHelper.1
            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerLoaded() {
                MsgTools.printMsg("onBannerLoaded: " + BannerHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onBannerLoaded(BannerHelper.this.mPlacementId);
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerFailed(final AdError adError) {
                MsgTools.printMsg("onBannerFailed: " + BannerHelper.this.mPlacementId + ", " + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onBannerFailed(BannerHelper.this.mPlacementId, adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerClicked(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onBannerClicked: " + BannerHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onBannerClicked(BannerHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerShow(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onBannerShow: " + BannerHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onBannerShow(BannerHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerClose(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onBannerClose: " + BannerHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onBannerClose(BannerHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerAutoRefreshed(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onBannerAutoRefreshed: " + BannerHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onBannerAutoRefreshed(BannerHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerAutoRefreshFail(final AdError adError) {
                MsgTools.printMsg("onBannerAutoRefreshFail: " + BannerHelper.this.mPlacementId + ", " + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onBannerAutoRefreshFail(BannerHelper.this.mPlacementId, adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }
        });
        this.mBannerView.setAdSourceStatusListener(new ATAdSourceStatusListener() { // from class: com.anythink.unitybridge.banner.BannerHelper.2
            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingAttempt(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceBiddingAttempt: " + BannerHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onAdSourceBiddingAttempt(BannerHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingFilled(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceBiddingFilled: " + BannerHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onAdSourceBiddingFilled(BannerHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceBiddingFail(final ATAdInfo aTAdInfo, final AdError adError) {
                MsgTools.printMsg("onAdSourceBiddingFail: " + BannerHelper.this.mPlacementId + "," + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onAdSourceBiddingFail(BannerHelper.this.mPlacementId, aTAdInfo.toString(), adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceAttempt(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceAttemp: " + BannerHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onAdSourceAttempt(BannerHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceLoadFilled(final ATAdInfo aTAdInfo) {
                MsgTools.printMsg("onAdSourceLoadFilled: " + BannerHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.2.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onAdSourceLoadFilled(BannerHelper.this.mPlacementId, aTAdInfo.toString());
                            }
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.ATAdSourceStatusListener
            public void onAdSourceLoadFail(final ATAdInfo aTAdInfo, final AdError adError) {
                MsgTools.printMsg("onAdSourceLoadFail: " + BannerHelper.this.mPlacementId + "," + adError.getFullErrorInfo());
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.2.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onAdSourceLoadFail(BannerHelper.this.mPlacementId, aTAdInfo.toString(), adError.getCode(), adError.getFullErrorInfo());
                            }
                        }
                    }
                });
            }
        });
        this.mBannerView.setAdMultipleLoadedListener(new ATAdMultipleLoadedListener() { // from class: com.anythink.unitybridge.banner.BannerHelper.3
            @Override // com.anythink.core.api.ATAdMultipleLoadedListener
            public void onAdMultipleLoaded(final ATRequestingInfo aTRequestingInfo) {
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onAdMultipleLoaded(BannerHelper.this.mPlacementId, JsonMapUtil.requestingInfoToJson(aTRequestingInfo));
                            }
                        }
                    }
                });
            }
        });
        MsgTools.printMsg("initBanner 3: " + this.mPlacementId);
    }

    public void loadBannerAd(final String str) {
        MsgTools.printMsg("loadBanner: " + this.mPlacementId + ", jsonMap: " + str);
        final ATAdRequest[] aTAdRequestArr = new ATAdRequest[1];
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (BannerHelper.this.mBannerView != null) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("atAdRequest")) {
                                aTAdRequestArr[0] = JsonMapUtil.atAdRequestFromJson(jSONObject.optJSONObject("atAdRequest"));
                                jSONObject.remove("atAdRequest");
                            }
                            if (jSONObject.has("banner_ad_size")) {
                                String string = jSONObject.getString("banner_ad_size");
                                MsgTools.printMsg("banner_ad_size----> " + string);
                                boolean z = jSONObject.has("uses_pixel") ? jSONObject.getBoolean("uses_pixel") : true;
                                MsgTools.printMsg("usePixel----> " + z);
                                if (BannerHelper.this.mBannerView != null && !TextUtils.isEmpty(string)) {
                                    String[] strArrSplit = string.split(x.n);
                                    try {
                                        int iDip2px = Integer.parseInt(strArrSplit[0]);
                                        int iDip2px2 = Integer.parseInt(strArrSplit[1]);
                                        MsgTools.printMsg("loadBannerAd, banner_ad_size" + string);
                                        if (!z) {
                                            iDip2px = CommonUtil.dip2px(BannerHelper.this.mBannerView.getContext(), iDip2px);
                                            iDip2px2 = CommonUtil.dip2px(BannerHelper.this.mBannerView.getContext(), iDip2px2);
                                        }
                                        if (BannerHelper.this.mBannerView.getLayoutParams() == null) {
                                            BannerHelper.this.mBannerView.setLayoutParams(new FrameLayout.LayoutParams(iDip2px, iDip2px2));
                                        } else {
                                            BannerHelper.this.mBannerView.getLayoutParams().width = iDip2px;
                                            BannerHelper.this.mBannerView.getLayoutParams().height = iDip2px2;
                                        }
                                        if (iDip2px > 0 && !jSONObject.has(ATAdConst.KEY.AD_WIDTH)) {
                                            jSONObject.put(ATAdConst.KEY.AD_WIDTH, iDip2px);
                                        }
                                        if (iDip2px2 > 0 && !jSONObject.has(ATAdConst.KEY.AD_HEIGHT)) {
                                            jSONObject.put(ATAdConst.KEY.AD_HEIGHT, iDip2px2);
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            }
                            if (jSONObject.has("inline_adaptive_width")) {
                                String string2 = jSONObject.getString("inline_adaptive_width");
                                MsgTools.printMsg("inline_adaptive_width----> " + string2);
                                jSONObject.put("adaptive_width", string2);
                            }
                            if (jSONObject.has("inline_adaptive_orientation")) {
                                int i = jSONObject.getInt("inline_adaptive_orientation");
                                MsgTools.printMsg("inline_adaptive_orientation----> " + i);
                                jSONObject.put("adaptive_orientation", i);
                            }
                            if (!jSONObject.has("adaptive_type")) {
                                jSONObject.put("adaptive_type", 0);
                            }
                            HashMap map = new HashMap();
                            Const.fillMapFromJsonObject(map, jSONObject);
                            BannerHelper.this.mBannerView.setLocalExtra(map);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    BannerHelper.this.mBannerView.loadAd(aTAdRequestArr[0]);
                    return;
                }
                MsgTools.printMsg("loadBannerAd error, you must call initBanner first " + BannerHelper.this.mPlacementId);
                TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BannerHelper.this.mListener != null) {
                            synchronized (BannerHelper.this) {
                                BannerHelper.this.mListener.onBannerFailed(BannerHelper.this.mPlacementId, "-1", "you must call initBanner first");
                            }
                        }
                    }
                });
            }
        });
    }

    public void loadBannerAd() {
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.5
            @Override // java.lang.Runnable
            public void run() {
                if (BannerHelper.this.mBannerView != null) {
                    BannerHelper.this.mBannerView.loadAd(null);
                } else {
                    MsgTools.printMsg("loadBannerAd error, you must call initBanner first " + BannerHelper.this.mPlacementId);
                    TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (BannerHelper.this.mListener != null) {
                                synchronized (BannerHelper.this) {
                                    BannerHelper.this.mListener.onBannerFailed(BannerHelper.this.mPlacementId, "-1", "you must call initBanner first");
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    public void showBannerAd(int i, int i2, int i3, int i4, String str) {
        showBannerAd(i, i2, i3, i4, str, true);
    }

    public void showBannerAd(final int i, final int i2, final int i3, final int i4, final String str, final boolean z) {
        MsgTools.printMsg("showBanner: " + this.mPlacementId + ", jsonMap: " + str);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.6
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams;
                if (BannerHelper.this.mBannerView != null) {
                    if (z) {
                        layoutParams = new FrameLayout.LayoutParams(i3, i4);
                        layoutParams.leftMargin = i;
                        layoutParams.topMargin = i2;
                    } else {
                        layoutParams = new FrameLayout.LayoutParams(CommonUtil.dip2px(BannerHelper.this.mActivity, i3), CommonUtil.dip2px(BannerHelper.this.mActivity, i4));
                        layoutParams.leftMargin = CommonUtil.dip2px(BannerHelper.this.mActivity, i);
                        layoutParams.topMargin = CommonUtil.dip2px(BannerHelper.this.mActivity, i2);
                    }
                    if (BannerHelper.this.mBannerView.getParent() != null) {
                        ((ViewGroup) BannerHelper.this.mBannerView.getParent()).removeView(BannerHelper.this.mBannerView);
                    }
                    BannerHelper.this.setConfig(str);
                    BannerHelper.this.mBannerView.setVisibility(0);
                    BannerHelper.this.mActivity.addContentView(BannerHelper.this.mBannerView, layoutParams);
                    return;
                }
                MsgTools.printMsg("show error, you must call initBanner first " + BannerHelper.this.mPlacementId);
            }
        });
    }

    public void showBannerAd(final String str, final String str2) {
        MsgTools.printMsg("showBanner by position: " + this.mPlacementId + ", jsonMap: " + str2);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.7
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2;
                if (BannerHelper.this.mBannerView != null) {
                    if (BannerHelper.this.mBannerView.getLayoutParams() != null) {
                        i = BannerHelper.this.mBannerView.getLayoutParams().width;
                        i2 = BannerHelper.this.mBannerView.getLayoutParams().height;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
                    if (BannerHelper.kATBannerAdShowingPisitionTop.equals(str)) {
                        layoutParams.gravity = 49;
                    } else {
                        layoutParams.gravity = 81;
                    }
                    if (BannerHelper.this.mBannerView.getParent() != null) {
                        ((ViewGroup) BannerHelper.this.mBannerView.getParent()).removeView(BannerHelper.this.mBannerView);
                    }
                    BannerHelper.this.setConfig(str2);
                    BannerHelper.this.mBannerView.setVisibility(0);
                    BannerHelper.this.mActivity.addContentView(BannerHelper.this.mBannerView, layoutParams);
                    return;
                }
                MsgTools.printMsg("show error, you must call initBanner first " + BannerHelper.this.mPlacementId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfig(String str) {
        ATShowConfig aTShowConfigFromJsonMap = ScenarioShowConfigFactory.fromJsonMap(str);
        MsgTools.printMsg("showBanner: " + this.mPlacementId + ", showConfig: " + (aTShowConfigFromJsonMap != null));
        if (aTShowConfigFromJsonMap != null) {
            this.mBannerView.setShowConfig(aTShowConfigFromJsonMap);
        }
    }

    public void showBannerAd() {
        MsgTools.printMsg("showBanner without ATRect: " + this.mPlacementId);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.8
            @Override // java.lang.Runnable
            public void run() {
                if (BannerHelper.this.mBannerView != null) {
                    BannerHelper.this.mBannerView.setVisibility(0);
                } else {
                    MsgTools.printMsg("show error, you must call initBanner first " + BannerHelper.this.mPlacementId);
                }
            }
        });
    }

    public void hideBannerAd() {
        MsgTools.printMsg("hideBannerAd: " + this.mPlacementId);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.9
            @Override // java.lang.Runnable
            public void run() {
                if (BannerHelper.this.mBannerView != null) {
                    BannerHelper.this.mBannerView.setVisibility(8);
                } else {
                    MsgTools.printMsg("hideBannerAd error, you must call initBanner first " + BannerHelper.this.mPlacementId);
                }
            }
        });
    }

    public void cleanBannerAd() {
        MsgTools.printMsg("clean: " + this.mPlacementId);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.10
            @Override // java.lang.Runnable
            public void run() {
                if (BannerHelper.this.mBannerView != null && BannerHelper.this.mBannerView.getParent() != null) {
                    MsgTools.printMsg("clean2: " + BannerHelper.this.mPlacementId);
                    ((ViewGroup) BannerHelper.this.mBannerView.getParent()).removeView(BannerHelper.this.mBannerView);
                } else {
                    MsgTools.printMsg("clean3: no banner clean " + BannerHelper.this.mPlacementId);
                }
            }
        });
    }

    public String checkAdStatus() {
        MsgTools.printMsg("checkAdStatus: " + this.mPlacementId);
        ATBannerView aTBannerView = this.mBannerView;
        if (aTBannerView == null) {
            return "";
        }
        ATAdStatusInfo aTAdStatusInfoCheckAdStatus = aTBannerView.checkAdStatus();
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
        if (this.mBannerView == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        List<ATAdInfo> listCheckValidAdCaches = this.mBannerView.checkValidAdCaches();
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
        MsgTools.printMsg("entryAdScenario: " + this.mPlacementId + " scenario=" + str);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.11
            @Override // java.lang.Runnable
            public void run() {
                if (BannerHelper.this.mBannerView == null) {
                    MsgTools.printMsg("entryAdScenario error, init banner first");
                } else {
                    BannerHelper.this.mBannerView.entryAdScenario(str);
                }
            }
        });
    }

    public void entryAdScenario(final String str, String str2) {
        final Map<String, Object> mapStringObjectMapFromJson = JsonMapUtil.stringObjectMapFromJson(str2);
        MsgTools.printMsg("entryAdScenario (tkExtra) " + this.mPlacementId);
        UnityPluginUtils.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.12
            @Override // java.lang.Runnable
            public void run() {
                if (BannerHelper.this.mBannerView == null) {
                    MsgTools.printMsg("entryAdScenario error, init banner first");
                } else if (mapStringObjectMapFromJson == null) {
                    BannerHelper.this.mBannerView.entryAdScenario(str);
                } else {
                    BannerHelper.this.mBannerView.entryAdScenario(str, mapStringObjectMapFromJson);
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.anythink.unitybridge.banner.BannerHelper$13, reason: invalid class name */
    class AnonymousClass13 implements Runnable {
        AnonymousClass13() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BannerHelper.this.mBannerView == null) {
                MsgTools.printMsg("setAdRevenueListener error, init banner first: " + BannerHelper.this.mPlacementId);
            } else {
                BannerHelper.this.mBannerView.setAdRevenueListener(new ATAdRevenueListener() { // from class: com.anythink.unitybridge.banner.BannerHelper.13.1
                    @Override // com.anythink.core.api.ATAdRevenueListener
                    public void onAdRevenuePaid(ATAdInfo aTAdInfo) {
                        final String string = aTAdInfo != null ? aTAdInfo.toString() : "";
                        TaskManager.getInstance().run_proxy(new Runnable() { // from class: com.anythink.unitybridge.banner.BannerHelper.13.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (BannerHelper.this.mListener != null) {
                                    BannerHelper.this.mListener.onAdRevenuePaid(BannerHelper.this.mPlacementId, string);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    public void setAdRevenueListener() {
        UnityPluginUtils.runOnUiThread(new AnonymousClass13());
    }
}
