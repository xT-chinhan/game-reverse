package com.mar.sdk.gg;

import com.mar.sdk.IPlugin;

/* JADX INFO: loaded from: classes2.dex */
public interface IMgg extends IPlugin {
    public static final int PLUGIN_TYPE = 7;

    void checkBannerNative();

    void checkBigNative();

    boolean getBigNativeFlag();

    boolean getFloatIconFlag();

    boolean getIntersFlag();

    boolean getIntersVideoFlag();

    boolean getNativeIntersFlag();

    boolean getNativeLucencyFlag();

    boolean getNativeSplashFlag();

    boolean getNavigatePasterFlag();

    boolean getVideoFlag();

    void hideBanner();

    void hideBigNative();

    void hideFloatIcon();

    void hideNativeBanner();

    void hideNativeLucency();

    void hideNavigatePaster();

    void reportNavigatePasterClick();

    void setListener(IAdListener iAdListener);

    void showBanner(int i);

    void showBigNative();

    void showFloatIcon(double d, double d2);

    void showInters();

    void showIntersVideo();

    void showNativeBanner();

    void showNativeInters();

    void showNativeLucency(double d, double d2);

    void showNativeSplash();

    void showNavigatePaster();

    void showSplash();

    void showVideo();
}
