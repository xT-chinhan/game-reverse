package com.anythink.unitybridge.banner;

import com.anythink.unitybridge.base.BaseAdListener;

/* JADX INFO: loaded from: classes.dex */
public interface BannerListener extends BaseAdListener {
    void onBannerAutoRefreshFail(String str, String str2, String str3);

    void onBannerAutoRefreshed(String str, String str2);

    void onBannerClicked(String str, String str2);

    void onBannerClose(String str, String str2);

    void onBannerFailed(String str, String str2, String str3);

    void onBannerLoaded(String str);

    void onBannerShow(String str, String str2);
}
