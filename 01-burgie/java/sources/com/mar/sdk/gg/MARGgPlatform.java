package com.mar.sdk.gg;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.MARSDK;
import com.mar.sdk.SDKTools;
import com.mar.sdk.gg.control.MggControl;
import com.mar.sdk.log.Log;
import com.mar.sdk.platform.MARPlatform;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MARGgPlatform {
    private static final String TAG = "MARSDK-MARGgPlatform";
    private static MARGgPlatform instance;
    private boolean israndom = false;

    private MARGgPlatform() {
    }

    public static MARGgPlatform getInstance() {
        if (instance == null) {
            instance = new MARGgPlatform();
        }
        return instance;
    }

    public void setListener(final IAdListener listener) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.1
            @Override // java.lang.Runnable
            public void run() {
                MARGg.getInstance().setListener(listener);
            }
        });
    }

    public void showBanner(int pos, String data) {
        if (!SDKTools.isNullOrEmpty(data)) {
            getInstance().setADGameEvens(AdEvent.AdType.AdTypeBanner, data);
        }
        showBanner(pos);
    }

    public void showBanner(final int pos) {
        Log.d(TAG, "showBanner ================= " + pos);
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.2
            @Override // java.lang.Runnable
            public void run() {
                if (MggControl.getInstance().getNativeBannerEable() && MggControl.getInstance().getBannerpriority().equals("nativeBanner")) {
                    MARGg.getInstance().showNativeBanner();
                } else if (MggControl.getInstance().getBannerEable()) {
                    MARGg.getInstance().showBanner(pos);
                }
            }
        });
    }

    public void hideBanner() {
        Log.d(TAG, "hideBanner ================= ");
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.3
            @Override // java.lang.Runnable
            public void run() {
                if (MggControl.getInstance().getNativeBannerEable() && MggControl.getInstance().getBannerpriority().equals("nativeBanner")) {
                    MARGg.getInstance().hideNativeBanner();
                } else if (MggControl.getInstance().getBannerEable()) {
                    MARGg.getInstance().hideBanner();
                }
            }
        });
    }

    public void showSplash(String data) {
        if (!SDKTools.isNullOrEmpty(data)) {
            getInstance().setADGameEvens(AdEvent.AdType.AdTypeSplash, data);
        }
        showSplash();
    }

    public void showSplash() {
        Log.d(TAG, "showSplash ================= ");
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.4
            @Override // java.lang.Runnable
            public void run() {
                if (MggControl.getInstance().getSplashEable()) {
                    MARGg.getInstance().showSplash();
                }
            }
        });
    }

    public boolean getIntersFlag() {
        int ret = MggControl.getInstance().getTypeForIntersTurn();
        this.israndom = true;
        boolean isBack = false;
        if (ret == 4) {
            if (MggControl.getInstance().getVideoEable()) {
                isBack = MARGg.getInstance().getVideoFlag();
            }
        } else if (ret == 3) {
            if (MggControl.getInstance().getSplashEable()) {
                isBack = true;
            }
        } else if (ret == 2) {
            if (MggControl.getInstance().getIntersVideoEable()) {
                isBack = MARGg.getInstance().getIntersVideoFlag();
            }
        } else if (ret == 1) {
            if (MggControl.getInstance().getNativeIntersEable()) {
                isBack = MARGg.getInstance().getNativeIntersFlag() ? true : MARGg.getInstance().getIntersFlag();
            }
        } else if (MggControl.getInstance().getIntersEable()) {
            isBack = MARGg.getInstance().getIntersFlag();
        }
        Log.d(TAG, "getIntersFlag ================= " + isBack);
        return isBack;
    }

    public void showInters(String data) {
        if (!SDKTools.isNullOrEmpty(data)) {
            getInstance().setADGameEvens(AdEvent.AdType.AdTypeInters, data);
        }
        showInters();
    }

    public void showInters() {
        if (!this.israndom) {
            getIntersFlag();
        }
        this.israndom = false;
        Log.d(TAG, "showInters=================");
        if (!MggControl.getInstance().getInterControlPass()) {
            Log.d(TAG, "=============== Inters Control not pass");
            AdEvent adEvent = new AdEvent();
            adEvent.type = AdEvent.AdType.AdTypeInters;
            adEvent.instType = AdEvent.InstType.unknow;
            adEvent.error = "Inters Control not pass";
            MARSDK.getInstance().onAdResult(1009, adEvent);
            MARSDK.getInstance().onResult(101, "0");
            return;
        }
        final int ret = MggControl.getInstance().getSaveFlagType();
        Log.d(TAG, "getSaveFlagType ret ================= " + ret);
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.5
            @Override // java.lang.Runnable
            public void run() {
                int delayTimes = MggControl.getInstance().getShowDelayTimes();
                if (!MggControl.getInstance().getDelayShowControlPass()) {
                    delayTimes = 0;
                }
                if (ret == 4) {
                    if (MggControl.getInstance().getVideoEable()) {
                        MARGg.getInstance().showVideo();
                        return;
                    }
                    return;
                }
                if (ret == 3) {
                    if (MggControl.getInstance().getSplashEable()) {
                        MARGg.getInstance().showSplash();
                        return;
                    }
                    return;
                }
                if (ret == 2) {
                    if (MggControl.getInstance().getIntersVideoEable() && MARGg.getInstance().getIntersVideoFlag()) {
                        MARGg.getInstance().showIntersVideo();
                        return;
                    }
                    return;
                }
                if (ret == 1) {
                    if (MggControl.getInstance().getNativeIntersEable()) {
                        if (delayTimes > 0) {
                            MARGgPlatform.this.showDelayInters(delayTimes, 1);
                            return;
                        } else if (MARGg.getInstance().getNativeIntersFlag()) {
                            MARGg.getInstance().showNativeInters();
                            return;
                        } else {
                            if (MARGg.getInstance().getIntersFlag()) {
                                MARGg.getInstance().showInters();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (MggControl.getInstance().getIntersEable()) {
                    if (delayTimes > 0) {
                        MARGgPlatform.this.showDelayInters(delayTimes, 0);
                    } else {
                        MARGg.getInstance().showInters();
                    }
                }
            }
        });
    }

    public void showDelayInters(int delay, final int type) {
        Log.d("ASCSDK_AD", "showDelayInters =============== delay : " + delay);
        new Handler();
        new Handler().postDelayed(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.6
            @Override // java.lang.Runnable
            public void run() {
                if (type == 1) {
                    if (MARGg.getInstance().getNativeIntersFlag()) {
                        MARGg.getInstance().showNativeInters();
                        return;
                    } else {
                        if (MARGg.getInstance().getIntersFlag()) {
                            MARGg.getInstance().showInters();
                            return;
                        }
                        return;
                    }
                }
                MARGg.getInstance().showInters();
            }
        }, delay);
    }

    public boolean getIntersVideoFlag() {
        Log.d(TAG, "getIntersVideoFlag ================= ");
        if (MggControl.getInstance().getIntersVideoEable()) {
            return MARGg.getInstance().getIntersVideoFlag();
        }
        return false;
    }

    public void showIntersVideo(String data) {
        if (!SDKTools.isNullOrEmpty(data)) {
            getInstance().setADGameEvens(AdEvent.AdType.AdTypeInters, data);
        }
        showIntersVideo();
    }

    public void showIntersVideo() {
        Log.d(TAG, "showIntersVideo ================= ");
        if (MggControl.getInstance().getIntersVideoEable()) {
            MARGg.getInstance().showIntersVideo();
        }
    }

    public boolean getVideoFlag() {
        Log.d(TAG, "getVideoFlag ================= ");
        if (MggControl.getInstance().getVideoEable()) {
            return MARGg.getInstance().getVideoFlag();
        }
        return false;
    }

    public void showVideo(String data) {
        if (!SDKTools.isNullOrEmpty(data)) {
            getInstance().setADGameEvens(AdEvent.AdType.AdTypeVideo, data);
        }
        showVideo();
    }

    public void showVideo() {
        Log.d(TAG, "showVideo ================= ");
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.7
            @Override // java.lang.Runnable
            public void run() {
                if (MggControl.getInstance().getVideoEable()) {
                    MARGg.getInstance().showVideo();
                }
            }
        });
    }

    public boolean getHiddenVideoFlag() {
        Log.d(TAG, "getVideoHiddenFlag================");
        if (MggControl.getInstance().getVideoControlEnable()) {
            return MARGg.getInstance().getVideoFlag();
        }
        return false;
    }

    public void showHiddenVideo(String data) {
        if (!SDKTools.isNullOrEmpty(data)) {
            getInstance().setADGameEvens(AdEvent.AdType.AdTypeVideo, data);
        }
        showHiddenVideo();
    }

    public void showHiddenVideo() {
        Log.d(TAG, "showVideoHidden ================= ");
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.8
            @Override // java.lang.Runnable
            public void run() {
                if (MggControl.getInstance().getVideoEable()) {
                    MARGg.getInstance().showVideo();
                }
            }
        });
    }

    public boolean getBigNativeFlag() {
        Log.d(TAG, "getBigNativeFlag ================= ");
        if (MggControl.getInstance().getNativeBigEable()) {
            return MARGg.getInstance().getBigNativeFlag();
        }
        return false;
    }

    public void showBigNative(String data) {
        if (!SDKTools.isNullOrEmpty(data)) {
            getInstance().setADGameEvens(AdEvent.AdType.AdTypeNativeBig, data);
        }
        showBigNative();
    }

    public void showBigNative() {
        Log.d(TAG, "showBigNative ================= ");
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.9
            @Override // java.lang.Runnable
            public void run() {
                if (MggControl.getInstance().getNativeBigEable()) {
                    MARGg.getInstance().showBigNative();
                }
            }
        });
    }

    public void hideBigNative() {
        Log.d(TAG, "hideBigNative ================= ");
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.10
            @Override // java.lang.Runnable
            public void run() {
                if (MggControl.getInstance().getNativeBigEable()) {
                    MARGg.getInstance().hideBigNative();
                }
            }
        });
    }

    public void checkBigNative() {
        Log.d(TAG, "checkBigNative ================= ");
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.11
            @Override // java.lang.Runnable
            public void run() {
                if (MggControl.getInstance().getNativeBigEable()) {
                    MARGg.getInstance().checkBigNative();
                }
            }
        });
    }

    public boolean getNativeIntersFlag() {
        Log.d(TAG, "getNativeFlag ================= ");
        if (MggControl.getInstance().getNativeIntersEable()) {
            return MARGg.getInstance().getNativeIntersFlag();
        }
        return false;
    }

    public void showNativeInters(String data) {
        if (!SDKTools.isNullOrEmpty(data)) {
            getInstance().setADGameEvens(AdEvent.AdType.AdTypeInters, data);
        }
        showNativeInters();
    }

    public void showNativeInters() {
        Log.d(TAG, "showNative ================= ");
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.12
            @Override // java.lang.Runnable
            public void run() {
                if (MggControl.getInstance().getNativeIntersEable()) {
                    MARGg.getInstance().showNativeInters();
                }
            }
        });
    }

    public boolean getFloatIconFlag() {
        Log.d(TAG, "getFloatIconFlag ================= ");
        if (MggControl.getInstance().getFloatIconEable()) {
            return MARGg.getInstance().getFloatIconFlag();
        }
        return false;
    }

    public void showFloatIcon(double x, double y, String data) {
        if (!SDKTools.isNullOrEmpty(data)) {
            getInstance().setADGameEvens(AdEvent.AdType.AdTypeFolatIcon, data);
        }
        showFloatIcon(x, y);
    }

    public void showFloatIcon(final double x, final double y) {
        Log.d(TAG, "showFloatIcon ================= ");
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.13
            @Override // java.lang.Runnable
            public void run() {
                if (MggControl.getInstance().getFloatIconEable()) {
                    MARGg.getInstance().showFloatIcon(x, y);
                }
            }
        });
    }

    public void hideFloatIcon() {
        Log.d(TAG, "hideFloatIcon ================= ");
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.14
            @Override // java.lang.Runnable
            public void run() {
                MARGg.getInstance().hideFloatIcon();
            }
        });
    }

    public boolean getNativeLucencyFlag() {
        Log.d(TAG, "showNativeLucency ================= ");
        if (MggControl.getInstance().getNativeLucencyEable()) {
            return MARGg.getInstance().getNativeLucencyFlag();
        }
        return false;
    }

    public void showNativeLucency(double x, double y, String data) {
        if (!SDKTools.isNullOrEmpty(data)) {
            getInstance().setADGameEvens(AdEvent.AdType.AdTypeLucency, data);
        }
        showNativeLucency(x, y);
    }

    public void showNativeLucency(final double x, final double y) {
        Log.d(TAG, "showNativeLucency =================x:" + x + "&&y:" + y);
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.15
            @Override // java.lang.Runnable
            public void run() {
                if (MggControl.getInstance().getNativeLucencyEable()) {
                    MARGg.getInstance().showNativeLucency(x, y);
                }
            }
        });
    }

    public void hideNativeLucency() {
        Log.d(TAG, "HideNativeLucency ================= ");
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.16
            @Override // java.lang.Runnable
            public void run() {
                MARGg.getInstance().hideNativeLucency();
            }
        });
    }

    public void showNativeSplash(String data) {
        if (!SDKTools.isNullOrEmpty(data)) {
            getInstance().setADGameEvens(AdEvent.AdType.AdTypeSplash, data);
        }
        showNativeSplash();
    }

    public void showNativeSplash() {
        Log.d(TAG, "showNativeSplash ================= ");
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.17
            @Override // java.lang.Runnable
            public void run() {
                if (MggControl.getInstance().getNativeSplashEable()) {
                    MARGg.getInstance().showNativeSplash();
                }
            }
        });
    }

    public void setADGameEvens(final AdEvent.AdType adType, final String json) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.18
            @Override // java.lang.Runnable
            public void run() {
                MARSDK.getInstance().onADGameEvens(adType, json);
            }
        });
    }

    public boolean getCustomSwitch() {
        boolean customSwitch = MggControl.getInstance().getCustomSwitch();
        Log.d(TAG, "getCustomSwitch ================= " + customSwitch);
        return customSwitch;
    }

    public void checkBannerNative() {
        Log.d(TAG, "checkBannerNative ================= ");
        if (!MggControl.getInstance().getAndroidKeyEable()) {
            Log.d(TAG, " android key false");
        } else if (!MggControl.getInstance().getAndroidKeyClickFlag()) {
            Log.d(TAG, " android key false 1");
        } else {
            MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.MARGgPlatform.19
                @Override // java.lang.Runnable
                public void run() {
                    if (MggControl.getInstance().getNativeBannerEable()) {
                        MARGg.getInstance().checkBannerNative();
                    }
                }
            });
        }
    }

    public void backKeyShowSplash() {
        if (isAndroidKeyBackFlag()) {
            if (MggControl.getInstance().getAndroidKeyBackShowType().equals(MediationConstant.RIT_TYPE_SPLASH) && MggControl.getInstance().getSplashEable()) {
                showSplash();
                return;
            }
            if (MggControl.getInstance().getAndroidKeyBackShowType().equals("inters")) {
                if (MggControl.getInstance().getIntersEable() && MARGg.getInstance().getIntersFlag()) {
                    MARGg.getInstance().showInters();
                    return;
                }
                return;
            }
            if (MggControl.getInstance().getAndroidKeyBackShowType().equals("nativeInters")) {
                if (MggControl.getInstance().getNativeIntersEable() && MARGg.getInstance().getNativeIntersFlag()) {
                    MARGg.getInstance().showNativeInters();
                    return;
                }
                return;
            }
            if (MggControl.getInstance().getAndroidKeyBackShowType().equals("video") && MggControl.getInstance().getVideoEable() && MARGg.getInstance().getVideoFlag()) {
                MARGg.getInstance().showVideo();
            }
        }
    }

    public boolean isAndroidKeyBackFlag() {
        if (!MggControl.getInstance().getAndroidKeyBackEable()) {
            Log.d(TAG, " android back key false");
            return false;
        }
        if (!MggControl.getInstance().getAndroidKeyBackFlag()) {
            Log.d(TAG, " android back key false 1 ");
            return false;
        }
        if (TextUtils.isEmpty(MggControl.getInstance().getAndroidKeyBackShowType())) {
            Log.d(TAG, " android back key type empty ");
            return false;
        }
        return true;
    }

    public boolean getNavigatePasterFlag() {
        return false;
    }

    public void showNavigatePaster() {
    }

    public void hideNavigatePaster() {
    }

    public void reportNavigatePasterClick() {
    }

    public void setUserProperty(String params) {
        if (params == null || params.equals("")) {
            Log.e(TAG, "reportPlugin params is null.");
        } else {
            MARPlatform.getInstance().setUserProperty(params);
        }
    }

    public void reqRemoteConfig(MggControl.ReqResult req) {
        MggControl.getInstance().reqRemoteConfig(req);
    }

    public String getRemoteConfig(String name) {
        return MggControl.getInstance().getRemoteConfig(name);
    }

    public JSONObject getAllRemoteConfig() {
        return MggControl.getInstance().getAllRemoteConfig();
    }
}
