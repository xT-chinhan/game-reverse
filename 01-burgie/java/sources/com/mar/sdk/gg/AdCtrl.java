package com.mar.sdk.gg;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.ActivityCallbackAdapter;
import com.mar.sdk.MARSDK;
import com.mar.sdk.gg.control.MggControl;
import com.mar.sdk.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class AdCtrl {
    private static final String TAG = "MARSDK-AD";
    protected AdInst bannerAd;
    protected String[] bannerIdList;
    protected AdInst floatIconAd;
    protected String[] floatIconIdList;
    protected AdInst intersAd;
    protected String[] intersIdList;
    protected AdInst intersVideoAd;
    protected String[] intersVideoIdList;
    protected AdInst nativeBannerAd;
    protected String[] nativeBannerIdList;
    protected AdInst nativeBigAd;
    protected String[] nativeBigIdList;
    protected AdInst nativeIntersAd;
    protected String[] nativeIntersIdList;
    protected AdInst nativeLucencyAd;
    protected String[] nativeLucencyIdList;
    protected AdInst nativeSplashAd;
    protected String[] nativeSplashIdList;
    protected AdInst nativeTmpBannerAd;
    protected String[] nativeTmpBannerIdList;
    protected AdInst nativeTmpBigAd;
    protected String[] nativeTmpBigIdList;
    protected AdInst nativeTmpIntersAd;
    protected String[] nativeTmpIntersIdList;
    protected AdInst nativeTmpLucencyAd;
    protected String[] nativeTmpLucencyIdList;
    protected AdTickCounter tickCounter;
    protected AdInst videoAd;
    protected String[] videoIdList;
    protected List<AdInst> bannerTypeList = new ArrayList();
    protected List<AdInst> intersTypeList = new ArrayList();
    protected List<AdInst> sysBannerShowings = new ArrayList();
    protected List<AdInst> nativeBannerShowings = new ArrayList();
    protected List<AdInst> nativeBigShowings = new ArrayList();
    protected List<AdInst> showingList = null;
    protected List<AdInst> allAdList = new ArrayList();
    protected boolean isInoutControllerPass = false;
    protected AdInst bannerShowing = null;
    protected long lastBannerShowTime = 0;
    Map<AdEvent.AdType, String> AdGameEvensMap = new HashMap();

    private void shuffleIds(String[] ids) {
        if (ids.length > 1) {
            for (int i = 0; i < ids.length; i++) {
                int r = new Random().nextInt(ids.length);
                String t = ids[i];
                ids[i] = ids[r];
                ids[r] = t;
            }
        }
    }

    private AdInst createAdWithType(AdEvent.AdType type, AdEvent.InstType instType, String[] idList) {
        AdInst ad = genAd(instType);
        if (ad != null) {
            ad.init(type, instType, idList);
        }
        return ad;
    }

    protected AdInst genAd(AdEvent.InstType type) {
        return null;
    }

    public void initAd() {
        initActivityCallback();
        if (this.bannerIdList != null && this.bannerIdList.length > 0) {
            shuffleIds(this.bannerIdList);
            this.bannerAd = createAdWithType(AdEvent.AdType.AdTypeBanner, AdEvent.InstType.banner, this.bannerIdList);
            if (this.bannerAd != null) {
                this.allAdList.add(this.bannerAd);
                this.bannerTypeList.add(this.bannerAd);
            }
        }
        if (this.nativeBannerIdList != null && this.nativeBannerIdList.length > 0) {
            shuffleIds(this.nativeBannerIdList);
            this.nativeBannerAd = createAdWithType(AdEvent.AdType.AdTypeBanner, AdEvent.InstType.nativeBanner, this.nativeBannerIdList);
            if (this.nativeBannerAd != null) {
                this.allAdList.add(this.nativeBannerAd);
                this.bannerTypeList.add(this.nativeBannerAd);
            }
        }
        if (this.nativeTmpBannerIdList != null && this.nativeTmpBannerIdList.length > 0) {
            shuffleIds(this.nativeTmpBannerIdList);
            this.nativeTmpBannerAd = createAdWithType(AdEvent.AdType.AdTypeBanner, AdEvent.InstType.nativeTmpBanner, this.nativeTmpBannerIdList);
            if (this.nativeTmpBannerAd != null) {
                this.allAdList.add(this.nativeTmpBannerAd);
                this.bannerTypeList.add(this.nativeTmpBannerAd);
            }
        }
        if (this.intersIdList != null && this.intersIdList.length > 0) {
            shuffleIds(this.intersIdList);
            this.intersAd = createAdWithType(AdEvent.AdType.AdTypeInters, AdEvent.InstType.inters, this.intersIdList);
            if (this.intersAd != null) {
                this.allAdList.add(this.intersAd);
                this.intersTypeList.add(this.intersAd);
            }
        }
        if (this.nativeIntersIdList != null && this.nativeIntersIdList.length > 0) {
            shuffleIds(this.nativeIntersIdList);
            this.nativeIntersAd = createAdWithType(AdEvent.AdType.AdTypeInters, AdEvent.InstType.nativeInters, this.nativeIntersIdList);
            if (this.nativeIntersAd != null) {
                this.allAdList.add(this.nativeIntersAd);
                this.intersTypeList.add(this.nativeIntersAd);
            }
        }
        if (this.nativeTmpIntersIdList != null && this.nativeTmpIntersIdList.length > 0) {
            shuffleIds(this.nativeTmpIntersIdList);
            this.nativeTmpIntersAd = createAdWithType(AdEvent.AdType.AdTypeInters, AdEvent.InstType.nativeTmpInters, this.nativeTmpIntersIdList);
            if (this.nativeTmpIntersAd != null) {
                this.allAdList.add(this.nativeTmpIntersAd);
                this.intersTypeList.add(this.nativeTmpIntersAd);
            }
        }
        if (this.intersVideoIdList != null && this.intersVideoIdList.length > 0) {
            shuffleIds(this.intersVideoIdList);
            this.intersVideoAd = createAdWithType(AdEvent.AdType.AdTypeInters, AdEvent.InstType.intersVideo, this.intersVideoIdList);
            if (this.intersVideoAd != null) {
                this.allAdList.add(this.intersVideoAd);
                this.intersTypeList.add(this.intersVideoAd);
            }
        }
        if (this.videoIdList != null && this.videoIdList.length > 0) {
            shuffleIds(this.videoIdList);
            this.videoAd = createAdWithType(AdEvent.AdType.AdTypeVideo, AdEvent.InstType.video, this.videoIdList);
            if (this.videoAd != null) {
                this.allAdList.add(this.videoAd);
            }
        }
        if (this.nativeTmpBigIdList != null && this.nativeTmpBigIdList.length > 0) {
            shuffleIds(this.nativeTmpBigIdList);
            this.nativeTmpBigAd = createAdWithType(AdEvent.AdType.AdTypeNativeBig, AdEvent.InstType.nativeTmpBig, this.nativeTmpBigIdList);
            if (this.nativeTmpBigAd != null) {
                this.allAdList.add(this.nativeTmpBigAd);
                this.bannerTypeList.add(this.nativeTmpBigAd);
            }
        }
        if (this.nativeBigIdList != null && this.nativeBigIdList.length > 0) {
            shuffleIds(this.nativeBigIdList);
            this.nativeBigAd = createAdWithType(AdEvent.AdType.AdTypeNativeBig, AdEvent.InstType.nativeBig, this.nativeBigIdList);
            if (this.nativeBigAd != null) {
                this.allAdList.add(this.nativeBigAd);
                this.bannerTypeList.add(this.nativeBigAd);
            }
        }
        if (this.floatIconIdList != null && this.floatIconIdList.length > 0) {
            shuffleIds(this.floatIconIdList);
            this.floatIconAd = createAdWithType(AdEvent.AdType.AdTypeFolatIcon, AdEvent.InstType.floatIcon, this.floatIconIdList);
            if (this.floatIconAd != null) {
                this.allAdList.add(this.floatIconAd);
            }
        }
        if (this.nativeLucencyIdList != null && this.nativeLucencyIdList.length > 0) {
            shuffleIds(this.nativeLucencyIdList);
            this.nativeLucencyAd = createAdWithType(AdEvent.AdType.AdTypeLucency, AdEvent.InstType.nativeLucency, this.nativeLucencyIdList);
            if (this.nativeLucencyAd != null) {
                this.allAdList.add(this.nativeLucencyAd);
            }
        }
        if (this.nativeTmpLucencyIdList != null && this.nativeTmpLucencyIdList.length > 0) {
            shuffleIds(this.nativeTmpLucencyIdList);
            this.nativeTmpLucencyAd = createAdWithType(AdEvent.AdType.AdTypeLucency, AdEvent.InstType.nativeTmpLucency, this.nativeTmpLucencyIdList);
            if (this.nativeTmpLucencyAd != null) {
                this.allAdList.add(this.nativeTmpLucencyAd);
            }
        }
        if (this.nativeSplashIdList != null && this.nativeSplashIdList.length > 0) {
            shuffleIds(this.nativeSplashIdList);
            this.nativeSplashAd = createAdWithType(AdEvent.AdType.AdTypeSplash, AdEvent.InstType.nativeSplash, this.nativeSplashIdList);
            if (this.nativeSplashAd != null) {
                this.allAdList.add(this.nativeSplashAd);
            }
        }
        AdInst.Listener listener = new AdInst.Listener() { // from class: com.mar.sdk.gg.AdCtrl.1
            @Override // com.mar.sdk.gg.AdInst.Listener
            public boolean show(AdInst ad) {
                if (AdCtrl.this.intersTypeList.indexOf(ad) != -1 && AdCtrl.this.bannerShowing != null) {
                    AdCtrl.this.bannerShowing.hide();
                }
                if (AdCtrl.this.bannerTypeList.indexOf(ad) != -1) {
                    AdCtrl.this.bannerShowing = ad;
                    for (AdInst banner : AdCtrl.this.bannerTypeList) {
                        if (banner != ad) {
                            banner.hide();
                        }
                    }
                    for (AdInst inters : AdCtrl.this.intersTypeList) {
                        if (inters.isShow) {
                            return false;
                        }
                    }
                }
                if (ad.instType != AdEvent.InstType.video && ad.instType != AdEvent.InstType.intersVideo) {
                    return true;
                }
                AdCtrl.this.isInoutControllerPass = true;
                return true;
            }

            @Override // com.mar.sdk.gg.AdInst.Listener
            public void onShow(AdInst ad, boolean suc) {
                if (AdCtrl.this.bannerTypeList.indexOf(ad) != -1 && suc) {
                    AdCtrl.this.lastBannerShowTime = System.currentTimeMillis();
                }
            }

            @Override // com.mar.sdk.gg.AdInst.Listener
            public void hide(AdInst ad) {
            }

            @Override // com.mar.sdk.gg.AdInst.Listener
            public void onHide(AdInst ad) {
                if (AdCtrl.this.intersTypeList.indexOf(ad) != -1) {
                    if (AdCtrl.this.bannerShowing != null) {
                        AdCtrl.this.bannerShowing.tick();
                        AdCtrl.this.bannerShowing.show(AdCtrl.this.AdGameEvensMap.get(AdEvent.AdType.AdTypeBanner));
                    }
                    MARSDK.getInstance().onResult(101, "0");
                }
            }
        };
        for (AdInst inst : this.allAdList) {
            inst.setListener(listener);
        }
        MARSDK.getInstance().setADGameEvens(new IAdGameEvent() { // from class: com.mar.sdk.gg.AdCtrl.2
            @Override // com.mar.sdk.gg.IAdGameEvent
            public void onAdGameEvent(AdEvent.AdType adType, String json) {
                Log.d(AdCtrl.TAG, "setADGameEvens :" + adType.name() + "==" + json);
                AdCtrl.this.AdGameEvensMap.put(adType, json);
            }
        });
        this.tickCounter = new AdTickCounter(999999999L, 5000L);
        this.tickCounter.start();
    }

    public void showSplash() {
        MARGg.getInstance().showSplash();
    }

    public void showBanner(int pos) {
        if (this.bannerShowing != null) {
            if (this.showingList != this.sysBannerShowings) {
                this.bannerShowing.hide();
                this.bannerShowing = null;
            } else {
                return;
            }
        }
        this.sysBannerShowings = new ArrayList();
        this.sysBannerShowings.add(this.bannerAd);
        this.sysBannerShowings.add(MggControl.getInstance().getNativeBannerEable() ? this.nativeBannerAd : null);
        this.sysBannerShowings.add(MggControl.getInstance().getNativeBannerEable() ? this.nativeTmpBannerAd : null);
        smartShowBanner(pos, this.sysBannerShowings, AdEvent.AdType.AdTypeBanner);
    }

    public void showNativeBanner() {
        if (this.bannerShowing != null) {
            if (this.showingList != this.nativeBannerShowings) {
                this.bannerShowing.hide();
                this.bannerShowing = null;
            } else {
                return;
            }
        }
        this.nativeBannerShowings = new ArrayList();
        this.nativeBannerShowings.add(MggControl.getInstance().getNativeBannerEable() ? this.nativeBannerAd : null);
        this.nativeBannerShowings.add(MggControl.getInstance().getNativeBannerEable() ? this.nativeTmpBannerAd : null);
        this.nativeBannerShowings.add(MggControl.getInstance().getBannerEable() ? this.bannerAd : null);
        smartShowBanner(0, this.nativeBannerShowings, AdEvent.AdType.AdTypeBanner);
    }

    public void hideBanner() {
        smartHideBanner(this.sysBannerShowings);
    }

    public void hideNativeBanner() {
        smartHideBanner(this.nativeBannerShowings);
    }

    private void smartShowBanner(int pos, List<AdInst> showList, AdEvent.AdType adType) {
        AdInst showing = null;
        this.showingList = showList;
        for (AdInst ad : showList) {
            if (ad != null && ad.getFlag()) {
                showing = ad;
                break;
            }
        }
        if (showing != null) {
            showing.showWithPos(pos, this.AdGameEvensMap.get(adType));
        }
    }

    private void smartHideBanner(List<AdInst> showList) {
        if (this.bannerShowing != null && showList == this.showingList) {
            this.bannerShowing.hide();
            this.bannerShowing = null;
        }
    }

    public boolean getVideoFlag() {
        return this.videoAd != null && this.videoAd.getFlag();
    }

    public void showVideo() {
        if (getVideoFlag()) {
            this.videoAd.show(this.AdGameEvensMap.get(AdEvent.AdType.AdTypeVideo));
        } else {
            MARSDK.getInstance().onResult(100, "0");
        }
    }

    public void showEcpmVideo() {
        double videoEcpm = 0.0d;
        double intersEcpm = 0.0d;
        if (getVideoFlag() || getIntersFlag()) {
            if (this.videoAd != null && this.videoAd.genAdEvent() != null) {
                videoEcpm = this.videoAd.genAdEvent().ecpm;
            }
            if (this.intersAd != null && this.intersAd.genAdEvent() != null) {
                intersEcpm = this.intersAd.genAdEvent().ecpm;
            }
            Log.d(TAG, "videoEcpm：" + videoEcpm + "  ==  intersEcpm：" + intersEcpm);
            if (intersEcpm > videoEcpm) {
                if (this.intersAd != null) {
                    this.intersAd.isMixReward = true;
                    this.intersAd.show(this.AdGameEvensMap.get(AdEvent.AdType.AdTypeVideo));
                    return;
                }
                return;
            }
            if (this.videoAd != null) {
                this.videoAd.show(this.AdGameEvensMap.get(AdEvent.AdType.AdTypeVideo));
                return;
            }
            return;
        }
        MARSDK.getInstance().onResult(100, "0");
    }

    public boolean getIntersFlag() {
        return this.intersAd != null && this.intersAd.getFlag();
    }

    public void showInters() {
        if (getIntersFlag()) {
            this.intersAd.show(this.AdGameEvensMap.get(AdEvent.AdType.AdTypeInters));
        }
    }

    public boolean getIntersVideoFlag() {
        return this.intersVideoAd != null && this.intersVideoAd.getFlag();
    }

    public void showIntersVideo() {
        if (getIntersVideoFlag()) {
            this.intersVideoAd.show(this.AdGameEvensMap.get(AdEvent.AdType.AdTypeInters));
        }
    }

    public boolean getNativeIntersFlag() {
        return (this.nativeIntersAd != null && this.nativeIntersAd.getFlag()) || (this.nativeTmpIntersAd != null && this.nativeTmpIntersAd.getFlag());
    }

    public void showNativeInters() {
        if (getNativeIntersFlag()) {
            if (this.nativeIntersAd != null && this.nativeIntersAd.getFlag()) {
                this.nativeIntersAd.show(this.AdGameEvensMap.get(AdEvent.AdType.AdTypeInters));
            } else if (this.nativeTmpIntersAd != null && this.nativeTmpIntersAd.getFlag()) {
                this.nativeTmpIntersAd.show(this.AdGameEvensMap.get(AdEvent.AdType.AdTypeInters));
            }
        }
    }

    public boolean getNativeBigFlag() {
        return (this.nativeBigAd != null && this.nativeBigAd.getFlag()) || (this.nativeTmpBigAd != null && this.nativeTmpBigAd.getFlag());
    }

    public void hideNativeBig() {
        smartHideBanner(this.nativeBigShowings);
    }

    public void showNativeBig() {
        if (this.bannerShowing != null) {
            if (this.showingList != this.nativeBigShowings) {
                this.bannerShowing.hide();
                this.bannerShowing = null;
            } else {
                return;
            }
        }
        this.nativeBigShowings = new ArrayList();
        this.nativeBigShowings.add(this.nativeBigAd);
        this.nativeBigShowings.add(this.nativeTmpBigAd);
        smartShowBanner(0, this.nativeBigShowings, AdEvent.AdType.AdTypeNativeBig);
    }

    public boolean getFloatIconFlag() {
        return this.floatIconAd != null && this.floatIconAd.getFlag();
    }

    public void showFloatIcon(double x, double y) {
        if (getFloatIconFlag()) {
            this.floatIconAd.setShowfloat(x, y, this.AdGameEvensMap.get(AdEvent.AdType.AdTypeFolatIcon));
        }
    }

    public void hideFloatIcon() {
        if (this.floatIconAd != null) {
            this.floatIconAd.hide();
        }
    }

    public boolean getNativeLucencyFlag() {
        return (this.nativeLucencyAd != null && this.nativeLucencyAd.getFlag()) || (this.nativeTmpLucencyAd != null && this.nativeTmpLucencyAd.getFlag());
    }

    public void showNativeLucency(double x, double y) {
        if (this.nativeLucencyAd != null && this.nativeLucencyAd.getFlag()) {
            this.nativeLucencyAd.setShowLucency(x, y, this.AdGameEvensMap.get(AdEvent.AdType.AdTypeLucency));
        } else if (this.nativeTmpLucencyAd != null && this.nativeTmpLucencyAd.getFlag()) {
            this.nativeTmpLucencyAd.setShowLucency(x, y, this.AdGameEvensMap.get(AdEvent.AdType.AdTypeLucency));
        }
    }

    public void hideNativeLucency() {
        if (this.nativeLucencyAd != null) {
            this.nativeLucencyAd.hide();
        }
        if (this.nativeTmpLucencyAd != null) {
            this.nativeTmpLucencyAd.hide();
        }
    }

    public boolean getNativeSplashFlag() {
        return this.nativeSplashAd != null && this.nativeSplashAd.getFlag();
    }

    public void showNativeSplash() {
        if (getNativeSplashFlag()) {
            this.nativeSplashAd.show(this.AdGameEvensMap.get(AdEvent.AdType.AdTypeSplash));
        }
    }

    class AdTickCounter extends CountDownTimer {
        public AdTickCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long l) {
            for (AdInst inst : AdCtrl.this.allAdList) {
                inst.tick();
            }
            int bannerUpdate = MggControl.getInstance().getBannerUpdate();
            if (bannerUpdate > 0 && AdCtrl.this.lastBannerShowTime > 0 && AdCtrl.this.bannerShowing != null) {
                long now = System.currentTimeMillis();
                if (Math.abs(now - AdCtrl.this.lastBannerShowTime) >= bannerUpdate * 1000) {
                    AdCtrl.this.lastBannerShowTime = now;
                    Log.d(AdCtrl.TAG, "tick refresh banner:" + AdCtrl.this.bannerShowing.instType);
                    MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.gg.AdCtrl.AdTickCounter.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AdCtrl.this.bannerShowing.hide();
                            AdCtrl.this.bannerShowing.tick();
                            AdCtrl.this.bannerShowing.show(AdCtrl.this.AdGameEvensMap.get(AdCtrl.this.nativeBigShowings.contains(AdCtrl.this.bannerShowing) ? AdEvent.AdType.AdTypeNativeBig : AdEvent.AdType.AdTypeBanner));
                        }
                    });
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            AdCtrl.this.tickCounter = AdCtrl.this.new AdTickCounter(999999999L, 5000L);
            AdCtrl.this.tickCounter.start();
        }
    }

    public void inoutControllerPass() {
        byte b = 0;
        Log.d(TAG, " inoutControllerPass=========" + this.isInoutControllerPass);
        if (this.isInoutControllerPass) {
            Log.d(TAG, " back type not allow ");
            this.isInoutControllerPass = false;
        }
        if (!MggControl.getInstance().getInOutControlPass()) {
            Log.d(TAG, "inout not limit ");
            return;
        }
        this.isInoutControllerPass = true;
        String inOutControlRadio = MggControl.getInstance().getInOutControlRadio();
        switch (inOutControlRadio.hashCode()) {
            case -1896564386:
                b = !inOutControlRadio.equals("nativeSplash") ? (byte) -1 : (byte) 2;
                break;
            case -1183762665:
                if (!inOutControlRadio.equals("inters")) {
                    b = -1;
                }
                break;
            case -895866265:
                b = !inOutControlRadio.equals(MediationConstant.RIT_TYPE_SPLASH) ? (byte) -1 : (byte) 3;
                break;
            case 2110506510:
                b = !inOutControlRadio.equals("nativeInters") ? (byte) -1 : (byte) 1;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                if (MggControl.getInstance().getIntersEable() && MARGg.getInstance().getIntersFlag()) {
                    showInters();
                    break;
                }
                break;
            case 1:
                if (MggControl.getInstance().getNativeIntersEable() && MARGg.getInstance().getNativeIntersFlag()) {
                    showNativeInters();
                    break;
                }
                break;
            case 2:
                if (MggControl.getInstance().getNativeSplashEable() && MARGg.getInstance().getNativeSplashFlag()) {
                    showNativeSplash();
                    break;
                }
                break;
            case 3:
                if (MggControl.getInstance().getSplashEable()) {
                    showSplash();
                }
                break;
        }
    }

    private void initActivityCallback() {
        MARSDK.getInstance().setActivityCallback(new ActivityCallbackAdapter() { // from class: com.mar.sdk.gg.AdCtrl.3
            @Override // com.mar.sdk.ActivityCallbackAdapter, com.mar.sdk.base.IActivityCallback
            public void onCreate() {
                super.onCreate();
            }

            @Override // com.mar.sdk.ActivityCallbackAdapter, com.mar.sdk.base.IActivityCallback
            public void onPause() {
                super.onPause();
            }

            @Override // com.mar.sdk.ActivityCallbackAdapter, com.mar.sdk.base.IActivityCallback
            public void onResume() {
                super.onResume();
                new Handler().postDelayed(new Runnable() { // from class: com.mar.sdk.gg.AdCtrl.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdCtrl.this.inoutControllerPass();
                    }
                }, 200L);
            }

            @Override // com.mar.sdk.ActivityCallbackAdapter, com.mar.sdk.base.IActivityCallback
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
            }
        });
    }
}
