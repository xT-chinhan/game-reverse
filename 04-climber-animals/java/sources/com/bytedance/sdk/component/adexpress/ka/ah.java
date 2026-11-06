package com.bytedance.sdk.component.adexpress.ka;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<xr> f880ms;

    public ah(xr xrVar) {
        this.f880ms = new WeakReference<>(xrVar);
    }

    public void ms(xr xrVar) {
        if (xrVar == null) {
            this.f880ms = null;
        } else {
            this.f880ms = new WeakReference<>(xrVar);
        }
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<xr> weakReference = this.f880ms;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f880ms.get().adInfo();
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<xr> weakReference = this.f880ms;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f880ms.get().appInfo();
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<xr> weakReference = this.f880ms;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f880ms.get().getTemplateInfo();
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<xr> weakReference = this.f880ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f880ms.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<xr> weakReference = this.f880ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f880ms.get().adAnalysisData(str);
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<xr> weakReference = this.f880ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f880ms.get().muteVideo(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<xr> weakReference = this.f880ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f880ms.get().dynamicTrack(str);
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<xr> weakReference = this.f880ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f880ms.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<xr> weakReference = this.f880ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f880ms.get().clickEvent(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<xr> weakReference = this.f880ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f880ms.get().skipVideo();
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<xr> weakReference = this.f880ms;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f880ms.get().getCurrentVideoState();
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<xr> weakReference = this.f880ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f880ms.get().initRenderFinish();
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<xr> weakReference = this.f880ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f880ms.get().requestPauseVideo(str);
    }

    @JavascriptInterface
    public String getData(String str) {
        WeakReference<xr> weakReference = this.f880ms;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f880ms.get().getData(str);
    }
}
