package com.byazt.gjp;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2040, 8})
public class s {
    public WeakReference<qg> n;

    public s(qg qgVar) {
        this.n = new WeakReference<>(qgVar);
    }

    public void n(qg qgVar) {
        if (qgVar == null) {
            this.n = null;
        } else {
            this.n = new WeakReference<>(qgVar);
        }
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<qg> weakReference = this.n;
        return (weakReference == null || weakReference.get() == null) ? "" : this.n.get().adInfo();
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<qg> weakReference = this.n;
        return (weakReference == null || weakReference.get() == null) ? "" : this.n.get().appInfo();
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<qg> weakReference = this.n;
        return (weakReference == null || weakReference.get() == null) ? "" : this.n.get().getTemplateInfo();
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<qg> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.n.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<qg> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.n.get().adAnalysisData(str);
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<qg> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.n.get().muteVideo(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<qg> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.n.get().dynamicTrack(str);
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<qg> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.n.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<qg> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.n.get().clickEvent(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<qg> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.n.get().skipVideo();
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<qg> weakReference = this.n;
        return (weakReference == null || weakReference.get() == null) ? "" : this.n.get().getCurrentVideoState();
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<qg> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.n.get().initRenderFinish();
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<qg> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.n.get().requestPauseVideo(str);
    }

    @JavascriptInterface
    public String getData(String str) {
        WeakReference<qg> weakReference = this.n;
        return (weakReference == null || weakReference.get() == null) ? "" : this.n.get().getData(str);
    }
}
