package com.mar.sdk.taptap.ad;

import android.widget.FrameLayout;
import com.mar.sdk.MARSDK;
import com.mar.sdk.gg.AdInst;
import com.mar.sdk.log.Log;
import com.tapsdk.tapad.group.DirichletAdManager;
import com.tapsdk.tapad.group.DirichletAdNative;
import com.tapsdk.tapad.group.DirichletAdRequest;

/* JADX INFO: loaded from: classes2.dex */
public class AutoBannerAd extends AdInst {
    private static AutoBannerAd instance;
    private String adId;
    private DirichletAdNative adNative;
    private FrameLayout parentLayout;

    public static synchronized AutoBannerAd getInstance() {
        if (instance == null) {
            instance = new AutoBannerAd();
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
        this.adId = adId;
        onLoad(true, "");
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doShow() {
        int spaceId = 0;
        try {
            spaceId = Integer.parseInt(this.adId);
        } catch (Exception e) {
            Log.d("MARSDK-AD", "BannerAd spaceId:0 Exception:" + e.toString());
        }
        DirichletAdRequest request = new DirichletAdRequest.Builder().withSpaceId(spaceId).withSlideInternal(30).build();
        this.adNative.showBannerAutoAd(request, this.parentLayout, new DirichletAdNative.BannerAutoAdListener() { // from class: com.mar.sdk.taptap.ad.AutoBannerAd.1
            @Override // com.tapsdk.tapad.group.CommonListener
            public void onError(int code, String message) {
                Log.e("MARSDK-AD", "Banner 自动加载失败: " + code + ", " + message);
                AutoBannerAd.this.onShow(false, code + "==" + message);
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletBannerAd.BannerInteractionListener
            public void onAdShow() {
                Log.d("MARSDK-AD", "Banner 展示");
                AutoBannerAd.this.onShow(true, null);
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletBannerAd.BannerInteractionListener
            public void onAdClick() {
                Log.d("MARSDK-AD", "Banner 点击");
                AutoBannerAd.this.onClick();
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletBannerAd.BannerInteractionListener
            public void onAdClose() {
                Log.d("MARSDK-AD", "Banner 关闭");
                AutoBannerAd.this.doHide();
            }
        });
    }

    @Override // com.mar.sdk.gg.AdInst
    protected void doHide() {
        FrameLayout frameLayout = this.parentLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        onHide();
    }
}
