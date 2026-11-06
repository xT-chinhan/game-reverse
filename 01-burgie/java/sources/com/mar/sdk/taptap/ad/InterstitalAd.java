package com.mar.sdk.taptap.ad;

import android.util.Log;
import com.mar.sdk.MARSDK;
import com.mar.sdk.gg.AdInst;
import com.tapsdk.tapad.group.DirichletAdManager;
import com.tapsdk.tapad.group.DirichletAdNative;
import com.tapsdk.tapad.group.DirichletAdRequest;
import com.tapsdk.tapad.group.ads.DirichletInterstitialAd;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitalAd extends AdInst {
    private static InterstitalAd instance;
    private DirichletAdNative adNative;
    private DirichletInterstitialAd intersAd;

    public static synchronized InterstitalAd getInstance() {
        if (instance == null) {
            instance = new InterstitalAd();
        }
        return instance;
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doInit() {
        this.adNative = DirichletAdManager.get().createAdNative(MARSDK.getInstance().getContext());
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doLoad(String adId) {
        long spaceId = 0;
        try {
            spaceId = Long.parseLong(adId);
        } catch (Exception e) {
            Log.d("MARSDK-AD", "InterstitalAd spaceId:0 Exception:" + e.toString());
        }
        DirichletAdRequest request = new DirichletAdRequest.Builder().withSpaceId(spaceId).build();
        this.adNative.loadInterstitialAd(request, new DirichletAdNative.InterstitialAdListener() { // from class: com.mar.sdk.taptap.ad.InterstitalAd.1
            @Override // com.tapsdk.tapad.group.DirichletAdNative.InterstitialAdListener
            public void onInterstitialAdLoad(DirichletInterstitialAd interstitialAd) {
                Log.d("MARSDK-AD", "插屏广告加载成功");
                InterstitalAd.this.intersAd = interstitialAd;
                InterstitalAd.this.onLoad(true, null);
            }

            @Override // com.tapsdk.tapad.group.CommonListener
            public void onError(int code, String message) {
                Log.e("MARSDK-AD", "插屏广告加载失败: " + code + ", " + message);
                InterstitalAd.this.onLoad(false, code + "==" + message);
            }
        });
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doShow() {
        DirichletInterstitialAd dirichletInterstitialAd = this.intersAd;
        if (dirichletInterstitialAd == null) {
            Log.d("MARSDK-AD", "InterstitalAd interstitialAd is null");
            onShow(false, null);
        } else {
            dirichletInterstitialAd.setInteractionListener(new DirichletInterstitialAd.InterstitialAdInteractionListener() { // from class: com.mar.sdk.taptap.ad.InterstitalAd.2
                @Override // com.tapsdk.tapad.group.ads.DirichletInterstitialAd.InterstitialAdInteractionListener
                public void onAdShow() {
                    Log.d("MARSDK-AD", "InterstitalAd onShow");
                    InterstitalAd.this.onShow(true, null);
                }

                @Override // com.tapsdk.tapad.group.ads.DirichletInterstitialAd.InterstitialAdInteractionListener
                public void onAdClose() {
                    Log.d("MARSDK-AD", "InterstitalAd onAdClosel");
                    InterstitalAd.this.doHide();
                }

                @Override // com.tapsdk.tapad.group.ads.DirichletInterstitialAd.InterstitialAdInteractionListener
                public void onAdClick() {
                    InterstitalAd.this.onClick();
                }
            });
            this.intersAd.show(MARSDK.getInstance().getContext());
        }
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doHide() {
        DirichletInterstitialAd dirichletInterstitialAd = this.intersAd;
        if (dirichletInterstitialAd != null) {
            dirichletInterstitialAd.destroy();
        }
        this.intersAd = null;
        onHide();
    }
}
