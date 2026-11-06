package com.mar.sdk.taptap.ad;

import com.mar.sdk.MARSDK;
import com.mar.sdk.gg.AdInst;
import com.mar.sdk.log.Log;
import com.tapsdk.tapad.group.DirichletAdManager;
import com.tapsdk.tapad.group.DirichletAdNative;
import com.tapsdk.tapad.group.DirichletAdRequest;

/* JADX INFO: loaded from: classes2.dex */
public class AutoInterstitalAd extends AdInst {
    private static AutoInterstitalAd instance;
    private String adId;
    private DirichletAdNative adNative;

    public static synchronized AutoInterstitalAd getInstance() {
        if (instance == null) {
            instance = new AutoInterstitalAd();
        }
        return instance;
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doInit() {
        this.adNative = DirichletAdManager.get().createAdNative(MARSDK.getInstance().getContext());
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doLoad(String adId) {
        this.adId = adId;
        onLoad(true, "");
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doShow() {
        long spaceId = 0;
        try {
            spaceId = Long.parseLong(this.adId);
        } catch (Exception e) {
            Log.d("MARSDK-AD", "InterstitalAd spaceId:0 Exception:" + e.toString());
        }
        DirichletAdRequest request = new DirichletAdRequest.Builder().withSpaceId(spaceId).build();
        this.adNative.showInterstitialAutoAd(request, MARSDK.getInstance().getContext(), new DirichletAdNative.InterstitialAutoAdListener() { // from class: com.mar.sdk.taptap.ad.AutoInterstitalAd.1
            @Override // com.tapsdk.tapad.group.CommonListener
            public void onError(int code, String message) {
                Log.e("MARSDK-AD", "插屏自动加载失败: " + code + ", " + message);
                AutoInterstitalAd.this.onShow(false, code + "==" + message);
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletInterstitialAd.InterstitialAdInteractionListener
            public void onAdShow() {
                Log.d("MARSDK-AD", "插屏展示");
                AutoInterstitalAd.this.onShow(true, null);
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletInterstitialAd.InterstitialAdInteractionListener
            public void onAdClick() {
                Log.d("MARSDK-AD", "插屏点击");
                AutoInterstitalAd.this.onClick();
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletInterstitialAd.InterstitialAdInteractionListener
            public void onAdClose() {
                Log.d("MARSDK-AD", "插屏关闭");
                AutoInterstitalAd.this.doHide();
            }
        });
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doHide() {
        this.adNative = null;
        onHide();
    }
}
