package com.byazt.su;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.byazt.ca.aj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_PROBESIZE})
public class BaseWebView extends WebView {
    public Boolean a;
    public Boolean aj;
    public Boolean b;
    public Integer c;
    public Boolean cz;
    public Boolean fo;
    public Boolean fw;
    public Integer g;
    public com.byazt.son.hn.pr gz;
    public WebChromeClient hn;
    public Integer ho;
    public com.byazt.fj.hw hw;
    public Boolean iu;
    public Boolean k;
    public WebSettings.LayoutAlgorithm lb;
    public Boolean m;
    public String nt;
    public Boolean ny;
    public Map<String, pr> pr;
    public Boolean qa;
    public Boolean rc;
    public View.OnScrollChangeListener uc;
    public Boolean ve;
    public Boolean vk;
    public Boolean w;
    public DownloadListener x;
    public Boolean yb;
    public Integer z;
    public Boolean zo;

    public com.byazt.son.hn.pr getOnTouchEventListener() {
        return this.gz;
    }

    public Map<String, pr> getJavascriptInterfaces() {
        return this.pr;
    }

    public com.byazt.fj.hw getClient() {
        return this.hw;
    }

    public WebChromeClient getChromeClient() {
        return this.hn;
    }

    public View.OnScrollChangeListener getOnScrollChangeListener() {
        return this.uc;
    }

    public Boolean getMediaPlaybackRequiresUserGesture() {
        return this.fw;
    }

    public Boolean getSavePassword() {
        return this.zo;
    }

    public Boolean getAllowUniversalAccessFromFileURLs() {
        return this.aj;
    }

    public Boolean getAllowFileAccessFromFileURLs() {
        return this.vk;
    }

    public Boolean getBlockNetworkImage() {
        return this.w;
    }

    public Boolean getAllowFileAccess() {
        return this.k;
    }

    public Boolean getDatabaseEnabled() {
        return this.m;
    }

    public Integer getMixedContentMode() {
        return this.g;
    }

    public Integer getDefaultFontSize() {
        return this.ho;
    }

    public String getDefaultTextEncodingName() {
        return this.nt;
    }

    public Boolean getLoadWithOverviewMod() {
        return this.yb;
    }

    public WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return this.lb;
    }

    public Boolean getBuiltInZoomControls() {
        return this.qa;
    }

    public Boolean getDomStorageEnabled() {
        return this.a;
    }

    public Boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.cz;
    }

    public Boolean getSupportZoom() {
        return this.ny;
    }

    public Boolean getUseWideViewPort() {
        return this.fo;
    }

    public Boolean getAppCacheEnabled() {
        return this.rc;
    }

    public Integer getCacheMode() {
        return this.z;
    }

    public Boolean getDisplayZoomControls() {
        return this.b;
    }

    public Boolean getJavaScriptEnabled() {
        return this.iu;
    }

    public Boolean getNetworkAvailable() {
        return this.ve;
    }

    public BaseWebView(Context context) {
        super(context);
        this.uc = null;
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.uc = null;
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uc = null;
    }

    public void pr(Runnable runnable) {
        if (pr()) {
            runnable.run();
        } else {
            aj.hw().post(runnable);
        }
    }

    public boolean pr() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public DownloadListener getDownloadListener() {
        return this.x;
    }

    public Integer getBackgroundColor() {
        return this.c;
    }

    public void hw() {
        this.pr = null;
        this.hw = null;
        this.hn = null;
        this.x = null;
        this.uc = null;
        this.c = null;
        this.fw = null;
        this.zo = null;
        this.aj = null;
        this.vk = null;
        this.w = null;
        this.k = null;
        this.m = null;
        this.g = null;
        this.ho = null;
        this.nt = null;
        this.yb = null;
        this.lb = null;
        this.qa = null;
        this.a = null;
        this.cz = null;
        this.ny = null;
        this.fo = null;
        this.rc = null;
        this.z = null;
        this.b = null;
        this.iu = null;
        this.ve = null;
        this.gz = null;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        hw();
        super.destroy();
    }

    public void pr(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", "callback");
            jSONObject2.putOpt("__callback_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            pr(str, jSONObject2);
        } catch (Throwable th) {
        }
    }

    public void hw(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", NotificationCompat.CATEGORY_EVENT);
            jSONObject2.putOpt("__event_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            pr(str, jSONObject2);
        } catch (Throwable th) {
        }
    }

    private void pr(String str, JSONObject jSONObject) {
        String str2 = "javascript:" + str + "._handleMessageFromToutiao(" + jSONObject + ")";
        if (Build.VERSION.SDK_INT >= 19) {
            evaluateJavascript(str2, null);
        } else {
            loadUrl(str2);
        }
    }
}
