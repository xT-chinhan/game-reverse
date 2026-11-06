package com.mar.sdk.gg;

import com.mar.sdk.base.PluginFactory;
import com.mar.sdk.log.Log;

/* JADX INFO: loaded from: classes2.dex */
public class MARGg {
    private static final String TAG = "MARSDK";
    private static MARGg instance;
    private IMgg ggPlugin;

    private MARGg() {
    }

    public static MARGg getInstance() {
        if (instance == null) {
            instance = new MARGg();
        }
        return instance;
    }

    public void init() {
        this.ggPlugin = (IMgg) PluginFactory.getInstance().initPlugin(7);
    }

    public void setListener(IAdListener listener) {
        if (isPluginInited()) {
            this.ggPlugin.setListener(listener);
        }
    }

    public void showBanner(int pos) {
        if (isPluginInited()) {
            this.ggPlugin.showBanner(pos);
        }
    }

    public void hideBanner() {
        if (isPluginInited()) {
            this.ggPlugin.hideBanner();
        }
    }

    public void showSplash() {
        if (isPluginInited()) {
            this.ggPlugin.showSplash();
        }
    }

    public boolean getIntersFlag() {
        if (isPluginInited()) {
            return this.ggPlugin.getIntersFlag();
        }
        return false;
    }

    public void showInters() {
        if (isPluginInited()) {
            this.ggPlugin.showInters();
        }
    }

    public boolean getIntersVideoFlag() {
        if (isPluginInited()) {
            return this.ggPlugin.getIntersVideoFlag();
        }
        return false;
    }

    public void showIntersVideo() {
        if (isPluginInited()) {
            this.ggPlugin.showIntersVideo();
        }
    }

    public boolean getVideoFlag() {
        if (isPluginInited()) {
            return this.ggPlugin.getVideoFlag();
        }
        return false;
    }

    public void showVideo() {
        if (isPluginInited()) {
            this.ggPlugin.showVideo();
        }
    }

    public boolean getBigNativeFlag() {
        if (isPluginInited()) {
            return this.ggPlugin.getBigNativeFlag();
        }
        return false;
    }

    public void showBigNative() {
        if (isPluginInited()) {
            this.ggPlugin.showBigNative();
        }
    }

    public void hideBigNative() {
        if (isPluginInited()) {
            this.ggPlugin.hideBigNative();
        }
    }

    public void checkBigNative() {
        if (isPluginInited()) {
            this.ggPlugin.checkBigNative();
        }
    }

    public boolean getNativeIntersFlag() {
        if (isPluginInited()) {
            return this.ggPlugin.getNativeIntersFlag();
        }
        return false;
    }

    public void showNativeInters() {
        if (isPluginInited()) {
            this.ggPlugin.showNativeInters();
        }
    }

    public void showNativeBanner() {
        if (isPluginInited()) {
            this.ggPlugin.showNativeBanner();
        }
    }

    public void hideNativeBanner() {
        if (isPluginInited()) {
            this.ggPlugin.hideNativeBanner();
        }
    }

    public boolean getFloatIconFlag() {
        if (isPluginInited()) {
            return this.ggPlugin.getFloatIconFlag();
        }
        return false;
    }

    public void showFloatIcon(double x, double y) {
        if (isPluginInited()) {
            this.ggPlugin.showFloatIcon(x, y);
        }
    }

    public void hideFloatIcon() {
        if (isPluginInited()) {
            this.ggPlugin.hideFloatIcon();
        }
    }

    public boolean getNativeLucencyFlag() {
        if (isPluginInited()) {
            return this.ggPlugin.getNativeLucencyFlag();
        }
        return false;
    }

    public void showNativeLucency(double x, double y) {
        if (isPluginInited()) {
            this.ggPlugin.showNativeLucency(x, y);
        }
    }

    public void hideNativeLucency() {
        if (isPluginInited()) {
            this.ggPlugin.hideNativeLucency();
        }
    }

    public boolean getNativeSplashFlag() {
        if (isPluginInited()) {
            return this.ggPlugin.getNativeSplashFlag();
        }
        return false;
    }

    public void showNativeSplash() {
        if (isPluginInited()) {
            this.ggPlugin.showNativeSplash();
        }
    }

    public void checkBannerNative() {
        if (isPluginInited()) {
            this.ggPlugin.checkBannerNative();
        }
    }

    private boolean isPluginInited() {
        if (this.ggPlugin != null) {
            return true;
        }
        Log.e(TAG, "The ad plugin is not inited or inited failed.");
        return false;
    }
}
