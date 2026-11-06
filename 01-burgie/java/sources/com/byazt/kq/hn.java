package com.byazt.kq;

import android.webkit.JavascriptInterface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 20})
public class hn {
    public WeakReference<hw> pr;

    public hn(hw hwVar) {
        this.pr = new WeakReference<>(hwVar);
    }

    public void pr(hw hwVar) {
        if (hwVar == null) {
            this.pr = null;
        } else {
            this.pr = new WeakReference<>(hwVar);
        }
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<hw> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            return this.pr.get().adInfo();
        }
        return "";
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<hw> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            return this.pr.get().appInfo();
        }
        return "";
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<hw> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            return this.pr.get().getTemplateInfo();
        }
        return "";
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<hw> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().renderDidFinish(str);
        }
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<hw> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().adAnalysisData(str);
        }
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<hw> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().muteVideo(str);
        }
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<hw> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().dynamicTrack(str);
        }
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<hw> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().changeVideoState(str);
        }
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<hw> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().clickEvent(str);
        }
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<hw> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().skipVideo();
        }
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<hw> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            return this.pr.get().getCurrentVideoState();
        }
        return "";
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<hw> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().initRenderFinish();
        }
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<hw> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().requestPauseVideo(str);
        }
    }

    @JavascriptInterface
    public String getData(String str) {
        WeakReference<hw> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            return this.pr.get().getData(str);
        }
        return "";
    }
}
