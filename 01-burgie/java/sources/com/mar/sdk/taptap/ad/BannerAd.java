package com.mar.sdk.taptap.ad;

import android.widget.FrameLayout;
import com.mar.sdk.MARSDK;
import com.mar.sdk.gg.AdInst;
import com.mar.sdk.log.Log;
import com.tapsdk.tapad.group.DirichletAdManager;
import com.tapsdk.tapad.group.DirichletAdNative;
import com.tapsdk.tapad.group.DirichletAdRequest;
import com.tapsdk.tapad.group.ads.DirichletBannerAd;

/* JADX INFO: loaded from: classes2.dex */
public class BannerAd extends AdInst {
    private static BannerAd instance;
    private DirichletAdNative adNative;
    private FrameLayout parentLayout;
    private DirichletBannerAd tapBannerAd;

    public static synchronized BannerAd getInstance() {
        if (instance == null) {
            instance = new BannerAd();
        }
        return instance;
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doInit() {
        if (this.parentLayout == null) {
            this.parentLayout = new FrameLayout(MARSDK.getInstance().getContext());
            FrameLayout.LayoutParams frameparams = new FrameLayout.LayoutParams(-1, -2);
            frameparams.gravity = this.showPos == 0 ? 80 : 48;
            MARSDK.getInstance().getContext().addContentView(this.parentLayout, frameparams);
        }
        this.adNative = DirichletAdManager.get().createAdNative(MARSDK.getInstance().getContext());
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doLoad(String adId) {
        long spaceId = 0;
        try {
            spaceId = Long.parseLong(adId);
        } catch (Exception e) {
            Log.d("MARSDK-AD", "BannerAd spaceId:0 Exception:" + e.toString());
        }
        DirichletAdRequest request = new DirichletAdRequest.Builder().withSpaceId(spaceId).build();
        this.adNative.loadBannerAd(request, new DirichletAdNative.BannerAdListener() { // from class: com.mar.sdk.taptap.ad.BannerAd.1
            @Override // com.tapsdk.tapad.group.DirichletAdNative.BannerAdListener
            public void onBannerAdLoad(DirichletBannerAd dirichletBannerAd) {
                Log.d("MARSDK-AD", "Banner 广告加载成功");
                BannerAd.this.tapBannerAd = dirichletBannerAd;
                BannerAd.this.onLoad(true, null);
            }

            @Override // com.tapsdk.tapad.group.CommonListener
            public void onError(int code, String message) {
                Log.e("MARSDK-AD", "Banner 广告加载失败: " + code + ", " + message);
                BannerAd.this.onLoad(false, code + "==" + message);
            }
        });
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doShow() {
        DirichletBannerAd dirichletBannerAd = this.tapBannerAd;
        if (dirichletBannerAd == null) {
            Log.d("MARSDK-AD", "BannerAd tapBannerAd is null");
            onShow(false, null);
        } else {
            dirichletBannerAd.setBannerInteractionListener(new DirichletBannerAd.BannerInteractionListener() { // from class: com.mar.sdk.taptap.ad.BannerAd.2
                @Override // com.tapsdk.tapad.group.ads.DirichletBannerAd.BannerInteractionListener
                public void onAdShow() {
                }

                @Override // com.tapsdk.tapad.group.ads.DirichletBannerAd.BannerInteractionListener
                public void onAdClose() {
                    Log.d("MARSDK-AD", "BannerAd onAdClosel");
                    BannerAd.this.doHide();
                }

                @Override // com.tapsdk.tapad.group.ads.DirichletBannerAd.BannerInteractionListener
                public void onAdClick() {
                    Log.d("MARSDK-AD", "BannerAd onAdClick");
                    BannerAd.this.onClick();
                }
            });
            this.parentLayout.addView(this.tapBannerAd.getBannerView());
            onShow(true, null);
            Log.d("MARSDK-AD", "BannerAd onShow");
        }
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doHide() {
        FrameLayout frameLayout = this.parentLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        DirichletBannerAd dirichletBannerAd = this.tapBannerAd;
        if (dirichletBannerAd != null) {
            dirichletBannerAd.destroy();
        }
        this.tapBannerAd = null;
        onHide();
    }
}
