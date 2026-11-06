package com.byazt.qza;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TIME_BAR_PERCENTAGE, 431})
public class BaseWebView extends WebView {
    public Boolean a;
    public com.byazt.uad.s.n bb;
    public WebSettings.LayoutAlgorithm cd;
    public Boolean cp;
    public String cy;
    public Boolean d;
    public Boolean fs;
    public Boolean h;
    public Boolean hd;
    public Integer hu;
    public Integer k;
    public Integer l;
    public Boolean m;
    public Map<String, n> n;
    public Boolean oa;
    public Boolean ou;
    public Boolean py;
    public DownloadListener q;
    public com.byazt.kfh.qg qg;
    public Boolean rv;
    public WebChromeClient s;
    public Integer sz;
    public Boolean t;
    public Boolean tj;
    public Boolean um;
    public Boolean ur;
    public View.OnScrollChangeListener w;
    public Boolean wm;
    public Boolean x;

    public com.byazt.uad.s.n getOnTouchEventListener() {
        return this.bb;
    }

    public Map<String, n> getJavascriptInterfaces() {
        return this.n;
    }

    public com.byazt.kfh.qg getClient() {
        return this.qg;
    }

    public WebChromeClient getChromeClient() {
        return this.s;
    }

    public View.OnScrollChangeListener getOnScrollChangeListener() {
        return this.w;
    }

    public Boolean getMediaPlaybackRequiresUserGesture() {
        return this.x;
    }

    public Boolean getSavePassword() {
        return this.fs;
    }

    public Boolean getAllowUniversalAccessFromFileURLs() {
        return this.rv;
    }

    public Boolean getAllowFileAccessFromFileURLs() {
        return this.tj;
    }

    public Boolean getBlockNetworkImage() {
        return this.cp;
    }

    public Boolean getAllowFileAccess() {
        return this.d;
    }

    public Boolean getDatabaseEnabled() {
        return this.oa;
    }

    public Integer getMixedContentMode() {
        return this.sz;
    }

    public Integer getDefaultFontSize() {
        return this.k;
    }

    public String getDefaultTextEncodingName() {
        return this.cy;
    }

    public Boolean getLoadWithOverviewMod() {
        return this.hd;
    }

    public WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return this.cd;
    }

    public Boolean getBuiltInZoomControls() {
        return this.um;
    }

    public Boolean getDomStorageEnabled() {
        return this.a;
    }

    public Boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.py;
    }

    public Boolean getSupportZoom() {
        return this.ou;
    }

    public Boolean getUseWideViewPort() {
        return this.wm;
    }

    public Boolean getAppCacheEnabled() {
        return this.m;
    }

    public Integer getCacheMode() {
        return this.hu;
    }

    public Boolean getDisplayZoomControls() {
        return this.h;
    }

    public Boolean getJavaScriptEnabled() {
        return this.t;
    }

    public Boolean getNetworkAvailable() {
        return this.ur;
    }

    public BaseWebView(Context context) {
        super(context);
        this.w = null;
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = null;
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = null;
    }

    public void n(Runnable runnable) {
        if (n()) {
            runnable.run();
        } else {
            rv.qg().post(runnable);
        }
    }

    public boolean n() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public DownloadListener getDownloadListener() {
        return this.q;
    }

    public Integer getBackgroundColor() {
        return this.l;
    }

    public void qg() {
        this.n = null;
        this.qg = null;
        this.s = null;
        this.q = null;
        this.w = null;
        this.l = null;
        this.x = null;
        this.fs = null;
        this.rv = null;
        this.tj = null;
        this.cp = null;
        this.d = null;
        this.oa = null;
        this.sz = null;
        this.k = null;
        this.cy = null;
        this.hd = null;
        this.cd = null;
        this.um = null;
        this.a = null;
        this.py = null;
        this.ou = null;
        this.wm = null;
        this.m = null;
        this.hu = null;
        this.h = null;
        this.t = null;
        this.ur = null;
        this.bb = null;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        qg();
        super.destroy();
    }

    public void n(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", "callback");
            jSONObject2.putOpt("__callback_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            n(str, jSONObject2);
        } catch (Throwable unused) {
        }
    }

    public void qg(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", NotificationCompat.CATEGORY_EVENT);
            jSONObject2.putOpt("__event_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            n(str, jSONObject2);
        } catch (Throwable unused) {
        }
    }

    private void n(String str, JSONObject jSONObject) {
        evaluateJavascript("javascript:" + str + "._handleMessageFromToutiao(" + jSONObject + ")", null);
    }
}
