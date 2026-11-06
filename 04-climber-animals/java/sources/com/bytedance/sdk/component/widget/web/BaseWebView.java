package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.x;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BaseWebView extends WebView {
    protected Boolean ab;
    protected WebChromeClient ah;
    protected String ao;
    protected Boolean b;
    protected View.OnScrollChangeListener c;
    protected Boolean ch;
    protected com.bytedance.sdk.component.zb.xr.ms cv;
    protected DownloadListener d;
    protected Boolean h;
    protected Boolean hi;
    protected Boolean i;
    protected Integer ka;
    protected Boolean le;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Map<String, ms> f1435ms;
    protected Boolean nw;
    protected Boolean ny;
    protected Boolean op;
    protected WebSettings.LayoutAlgorithm qv;
    protected Boolean re;
    protected Boolean sl;
    protected Boolean t;
    protected Integer u;
    protected Integer ub;
    protected Integer w;
    protected Boolean x;
    protected com.bytedance.sdk.component.widget.xr xr;
    protected Boolean y;
    protected Boolean yu;
    protected Boolean zb;

    public com.bytedance.sdk.component.zb.xr.ms getOnTouchEventListener() {
        return this.cv;
    }

    public Map<String, ms> getJavascriptInterfaces() {
        return this.f1435ms;
    }

    public com.bytedance.sdk.component.widget.xr getClient() {
        return this.xr;
    }

    public WebChromeClient getChromeClient() {
        return this.ah;
    }

    public View.OnScrollChangeListener getOnScrollChangeListener() {
        return this.c;
    }

    public Boolean getMediaPlaybackRequiresUserGesture() {
        return this.ab;
    }

    public Boolean getSavePassword() {
        return this.x;
    }

    public Boolean getAllowUniversalAccessFromFileURLs() {
        return this.ny;
    }

    public Boolean getAllowFileAccessFromFileURLs() {
        return this.ch;
    }

    public Boolean getBlockNetworkImage() {
        return this.hi;
    }

    public Boolean getAllowFileAccess() {
        return this.sl;
    }

    public Boolean getDatabaseEnabled() {
        return this.zb;
    }

    public Integer getMixedContentMode() {
        return this.u;
    }

    public Integer getDefaultFontSize() {
        return this.ub;
    }

    public String getDefaultTextEncodingName() {
        return this.ao;
    }

    public Boolean getLoadWithOverviewMod() {
        return this.h;
    }

    public WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return this.qv;
    }

    public Boolean getBuiltInZoomControls() {
        return this.y;
    }

    public Boolean getDomStorageEnabled() {
        return this.t;
    }

    public Boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.nw;
    }

    public Boolean getSupportZoom() {
        return this.b;
    }

    public Boolean getUseWideViewPort() {
        return this.re;
    }

    public Boolean getAppCacheEnabled() {
        return this.i;
    }

    public Integer getCacheMode() {
        return this.w;
    }

    public Boolean getDisplayZoomControls() {
        return this.yu;
    }

    public Boolean getJavaScriptEnabled() {
        return this.op;
    }

    public Boolean getNetworkAvailable() {
        return this.le;
    }

    public BaseWebView(Context context) {
        super(context);
        this.c = null;
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = null;
    }

    protected void ms(Runnable runnable) {
        if (ms()) {
            runnable.run();
        } else {
            x.xr().post(runnable);
        }
    }

    protected boolean ms() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public DownloadListener getDownloadListener() {
        return this.d;
    }

    public Integer getBackgroundColor() {
        return this.ka;
    }

    public void xr() {
        this.f1435ms = null;
        this.xr = null;
        this.ah = null;
        this.d = null;
        this.c = null;
        this.ka = null;
        this.ab = null;
        this.x = null;
        this.ny = null;
        this.ch = null;
        this.hi = null;
        this.sl = null;
        this.zb = null;
        this.u = null;
        this.ub = null;
        this.ao = null;
        this.h = null;
        this.qv = null;
        this.y = null;
        this.t = null;
        this.nw = null;
        this.b = null;
        this.re = null;
        this.i = null;
        this.w = null;
        this.yu = null;
        this.op = null;
        this.le = null;
        this.cv = null;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        xr();
        super.destroy();
    }

    public void ms(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", "callback");
            jSONObject2.putOpt("__callback_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            ms(str, jSONObject2);
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    public void xr(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", NotificationCompat.CATEGORY_EVENT);
            jSONObject2.putOpt("__event_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            ms(str, jSONObject2);
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    private void ms(String str, JSONObject jSONObject) {
        evaluateJavascript("javascript:" + str + "._handleMessageFromToutiao(" + jSONObject + ")", null);
    }
}
