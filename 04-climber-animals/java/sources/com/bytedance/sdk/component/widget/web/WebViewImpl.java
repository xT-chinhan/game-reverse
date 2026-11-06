package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.zb.ah;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class WebViewImpl extends BaseWebView implements ah {
    private static boolean g = false;
    private Map<String, ms> of;
    private volatile boolean p;
    private final com.bytedance.sdk.component.zb.ms pc;

    private void ah(Context context) {
    }

    private static Context ms(Context context) {
        return context;
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public View getView() {
        return this;
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public WebView getWebView() {
        return this;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public WebViewImpl(com.bytedance.sdk.component.zb.ms msVar, Context context) {
        super(ms(context));
        this.p = false;
        this.pc = msVar;
        xr(context);
    }

    public WebViewImpl(com.bytedance.sdk.component.zb.ms msVar, Context context, AttributeSet attributeSet) {
        super(ms(context), attributeSet);
        this.p = false;
        this.pc = msVar;
        xr(context);
    }

    public WebViewImpl(com.bytedance.sdk.component.zb.ms msVar, Context context, AttributeSet attributeSet, int i) {
        super(ms(context), attributeSet, i);
        this.p = false;
        this.pc = msVar;
        xr(context);
    }

    private void xr(Context context) {
        ah(context);
        d();
        ah();
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public Map<String, ms> getJavascriptInterfaces() {
        return this.of;
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public com.bytedance.sdk.component.widget.xr getClient() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public WebChromeClient getChromeClient() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public void xr() {
        super.xr();
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebSettings settings = WebViewImpl.this.getSettings();
                    WebViewImpl.this.removeAllViews();
                    WebViewImpl.this.stopLoading();
                    WebViewImpl.this.setWebChromeClient(null);
                    WebViewImpl.this.setWebViewClient(null);
                    WebViewImpl.this.setDownloadListener(null);
                    settings.setJavaScriptEnabled(true);
                    settings.setAppCacheEnabled(false);
                    settings.setSupportZoom(false);
                    settings.setUseWideViewPort(true);
                    settings.setJavaScriptCanOpenWindowsAutomatically(true);
                    settings.setDomStorageEnabled(true);
                    settings.setBuiltInZoomControls(false);
                    settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
                    settings.setLoadWithOverviewMode(false);
                    settings.setDefaultTextEncodingName("UTF-8");
                    settings.setDefaultFontSize(16);
                    if (WebViewImpl.this.of != null) {
                        Iterator it = WebViewImpl.this.of.keySet().iterator();
                        while (it.hasNext()) {
                            WebViewImpl.this.removeJavascriptInterface((String) it.next());
                        }
                        WebViewImpl.this.of = null;
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void setNetworkAvailable(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.le = Boolean.valueOf(z);
                    WebViewImpl.super.setNetworkAvailable(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String str, final Map<String, String> map) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.23
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadUrl(str, map);
                    if (WebViewImpl.this.xr != null) {
                        WebViewImpl.this.xr.ms(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void loadUrl(final String str) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.34
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadUrl(str);
                    if (WebViewImpl.this.xr != null) {
                        WebViewImpl.this.xr.ms(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void postUrl(final String str, final byte[] bArr) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.45
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.postUrl(str, bArr);
                    if (WebViewImpl.this.xr != null) {
                        WebViewImpl.this.xr.ms(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadData(final String str, final String str2, final String str3) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.56
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.loadData(str, str2, str3);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.58
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadDataWithBaseURL(str, str2, str3, str4, str5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.59
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.stopLoading();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void reload() {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.60
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.reload();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public boolean canGoBack() {
        if (!ms()) {
            return false;
        }
        try {
            return super.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void goBack() {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goBack();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public boolean canGoForward() {
        try {
            return super.canGoForward();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public void goForward() {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goForward();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void onResume() {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.4
            @Override // java.lang.Runnable
            public void run() {
                WebViewImpl.super.onResume();
            }
        });
    }

    @Override // android.webkit.WebView
    public boolean canGoBackOrForward(int i) {
        try {
            return super.canGoBackOrForward(i);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(final int i) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goBackOrForward(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public String getUrl() {
        if (ms()) {
            try {
                return super.getUrl();
            } catch (Throwable unused) {
            }
        }
        if (this.xr != null) {
            return this.xr.xr();
        }
        return null;
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public int getProgress() {
        if (ms()) {
            try {
                return super.getProgress();
            } catch (Throwable unused) {
                return 100;
            }
        }
        final Object obj = new Object();
        final int[] iArr = {-1};
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.6
            @Override // java.lang.Runnable
            public void run() {
                iArr[0] = WebViewImpl.super.getProgress();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (iArr[0] < 0) {
                synchronized (obj) {
                    obj.wait(5000L);
                }
            }
        } catch (InterruptedException unused2) {
        }
        return iArr[0];
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public int getContentHeight() {
        if (ms()) {
            try {
                return super.getContentHeight();
            } catch (Throwable unused) {
                return 1;
            }
        }
        final Object obj = new Object();
        final int[] iArr = {-1};
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.7
            @Override // java.lang.Runnable
            public void run() {
                iArr[0] = WebViewImpl.super.getContentHeight();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (iArr[0] < 0) {
                synchronized (obj) {
                    obj.wait(5000L);
                }
            }
        } catch (InterruptedException unused2) {
        }
        return iArr[0];
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void clearCache(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearCache(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void clearFormData() {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearFormData();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void clearHistory() {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearHistory();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void setWebViewClient(final WebViewClient webViewClient) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewClient webViewClientMs = webViewClient;
                    if (webViewClientMs == null) {
                        webViewClientMs = new SSWebView.ms();
                    } else if (webViewClientMs instanceof com.bytedance.sdk.component.widget.xr) {
                        webViewClientMs = ((com.bytedance.sdk.component.widget.xr) webViewClientMs).ms();
                    }
                    WebViewImpl.this.xr = new com.bytedance.sdk.component.widget.xr(webViewClientMs);
                    WebViewImpl webViewImpl = WebViewImpl.this;
                    WebViewImpl.super.setWebViewClient(webViewImpl.xr);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void setDownloadListener(final DownloadListener downloadListener) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.d = downloadListener;
                    WebViewImpl.super.setDownloadListener(downloadListener);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ah = webChromeClient;
                    WebViewImpl.super.setWebChromeClient(webChromeClient);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.zb.ah
    public void setBackgroundColor(final int i) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ka = Integer.valueOf(i);
                    WebViewImpl.super.setBackgroundColor(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.zb.ah
    public void computeScroll() {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.computeScroll();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.zb.ah
    public void setLayerType(final int i, final Paint paint) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setLayerType(i, paint);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.zb.ah
    public void setOverScrollMode(final int i) {
        super.setOverScrollMode(i);
        x.xr().post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setOverScrollMode(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void ah() {
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void addJavascriptInterface(final Object obj, final String str) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.of == null) {
                        WebViewImpl.this.of = new HashMap();
                    }
                    xr xrVar = new xr(obj, str, WebViewImpl.this.pc, WebViewImpl.this);
                    WebViewImpl.this.hashCode();
                    WebViewImpl.super.addJavascriptInterface(xrVar, str);
                    WebViewImpl.this.of.put(str, xrVar);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setJavaScriptEnabled(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.op = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setJavaScriptEnabled(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setDisplayZoomControls(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.21
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.yu = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setDisplayZoomControls(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setCacheMode(final int i) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.22
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.w = Integer.valueOf(i);
                    WebViewImpl.this.getSettings().setCacheMode(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void d() {
        try {
            WebSettings settings = getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (TextUtils.isEmpty(str) || (settings = getSettings()) == null || g) {
                return;
            }
            if (Uri.parse(str).getScheme().equals("file")) {
                settings.setJavaScriptEnabled(false);
            } else {
                settings.setJavaScriptEnabled(true);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void onPause() {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.24
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.onPause();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public String getUserAgentString() {
        if (ms()) {
            try {
                return getSettings().getUserAgentString();
            } catch (Throwable unused) {
                return "";
            }
        }
        final Object obj = new Object();
        final String[] strArr = {""};
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.25
            @Override // java.lang.Runnable
            public void run() {
                strArr[0] = WebViewImpl.this.getSettings().getUserAgentString();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            String str = strArr[0];
            if (str == null || str.length() == 0) {
                synchronized (obj) {
                    obj.wait(5000L);
                }
            }
        } catch (InterruptedException unused2) {
        }
        return strArr[0];
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.26
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.evaluateJavascript(str, valueCallback);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView, android.webkit.WebView
    public void destroy() {
        if (this.p) {
            return;
        }
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.27
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.p) {
                        return;
                    }
                    WebViewImpl.this.xr();
                    if (WebViewImpl.this.of != null) {
                        Iterator it = WebViewImpl.this.of.keySet().iterator();
                        while (it.hasNext()) {
                            WebViewImpl.super.removeJavascriptInterface((String) it.next());
                        }
                        WebViewImpl.this.of = null;
                    }
                    WebViewImpl.super.destroy();
                    WebViewImpl.this.hashCode();
                    WebViewImpl.this.pc.hashCode();
                    WebViewImpl.this.p = true;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void removeJavascriptInterface(final String str) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.28
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.p) {
                        return;
                    }
                    WebViewImpl.this.hashCode();
                    WebViewImpl.super.removeJavascriptInterface(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setAppCacheEnabled(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.29
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.i = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAppCacheEnabled(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setSupportZoom(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.30
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.b = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setSupportZoom(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setUseWideViewPort(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.31
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.re = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setUseWideViewPort(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.32
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.nw = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setDomStorageEnabled(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.33
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.t = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setDomStorageEnabled(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setBuiltInZoomControls(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.35
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.y = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setBuiltInZoomControls(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.36
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.qv = layoutAlgorithm;
                    WebViewImpl.this.getSettings().setLayoutAlgorithm(layoutAlgorithm);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setLoadWithOverviewMode(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.37
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.h = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setLoadWithOverviewMode(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setUserAgentString(final String str) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.38
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.getSettings().setUserAgentString(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setDefaultTextEncodingName(final String str) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.39
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ao = str;
                    WebViewImpl.this.getSettings().setDefaultTextEncodingName(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setDefaultFontSize(final int i) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.40
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ub = Integer.valueOf(i);
                    WebViewImpl.this.getSettings().setDefaultFontSize(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setMixedContentMode(final int i) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.41
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.u = Integer.valueOf(i);
                    WebViewImpl.this.getSettings().setMixedContentMode(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setDatabaseEnabled(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.42
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.zb = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setDatabaseEnabled(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.zb.ah
    public void setVisibility(final int i) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.43
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setVisibility(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.zb.ah
    public void setAlpha(final float f) {
        super.setAlpha(f);
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.44
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setAlpha(f);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setAllowFileAccess(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.46
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.sl = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAllowFileAccess(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void clearView() {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.47
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearView();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void pauseTimers() {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.48
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.pauseTimers();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.zb.ah
    public void resumeTimers() {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.49
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.resumeTimers();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.ViewGroup, com.bytedance.sdk.component.zb.ah
    public void removeAllViews() {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.50
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.removeAllViews();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setBlockNetworkImage(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.51
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.hi = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setBlockNetworkImage(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setAllowFileAccessFromFileURLs(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.52
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ch = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAllowFileAccessFromFileURLs(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setAllowUniversalAccessFromFileURLs(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.53
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ny = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAllowUniversalAccessFromFileURLs(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setSavePassword(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.54
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.x = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setSavePassword(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setMediaPlaybackRequiresUserGesture(final boolean z) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.55
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ab = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setMediaPlaybackRequiresUserGesture(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.zb.ah
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.57
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.c = onScrollChangeListener;
                    WebViewImpl.super.setOnScrollChangeListener(onScrollChangeListener);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void ms(String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, str2);
            jSONObject.putOpt("param", obj);
            xr(str, "csjEventListener", jSONObject);
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.sdk.component.zb.xr
    public void setTouchEventListener(com.bytedance.sdk.component.zb.xr.ms msVar) {
        this.cv = msVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Pair<Boolean, Boolean> pairMs;
        if (this.cv != null && (pairMs = this.cv.ms(this, motionEvent)) != null && ((Boolean) pairMs.first).booleanValue()) {
            return ((Boolean) pairMs.second).booleanValue();
        }
        return super.onTouchEvent(motionEvent);
    }
}
