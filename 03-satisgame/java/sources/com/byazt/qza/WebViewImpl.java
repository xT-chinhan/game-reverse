package com.byazt.qza;

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
import com.byazt.kfh.SSWebView;
import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TIME_BAR_PERCENTAGE, 1802})
public class WebViewImpl extends BaseWebView implements com.byazt.uad.q {
    public static boolean ln = false;
    public final com.byazt.uad.qg j;
    public Map<String, n> lh;
    public volatile boolean v;

    private static Context n(Context context) {
        return context;
    }

    private void s(Context context) {
    }

    @Override // com.byazt.uad.q
    public View getView() {
        return this;
    }

    @Override // com.byazt.uad.q
    public WebView getWebView() {
        return this;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public WebViewImpl(com.byazt.uad.qg qgVar, Context context) {
        super(n(context));
        this.v = false;
        this.j = qgVar;
        qg(context);
    }

    public WebViewImpl(com.byazt.uad.qg qgVar, Context context, AttributeSet attributeSet) {
        super(n(context), attributeSet);
        this.v = false;
        this.j = qgVar;
        qg(context);
    }

    public WebViewImpl(com.byazt.uad.qg qgVar, Context context, AttributeSet attributeSet, int i) {
        super(n(context), attributeSet, i);
        this.v = false;
        this.j = qgVar;
        qg(context);
    }

    private void qg(Context context) {
        s(context);
        q();
        s();
    }

    @Override // com.byazt.qza.BaseWebView
    public Map<String, n> getJavascriptInterfaces() {
        return this.lh;
    }

    @Override // com.byazt.qza.BaseWebView
    public com.byazt.kfh.qg getClient() {
        return this.qg;
    }

    @Override // com.byazt.qza.BaseWebView
    public WebChromeClient getChromeClient() {
        return this.s;
    }

    @Override // com.byazt.qza.BaseWebView
    public void qg() {
        super.qg();
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.1
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
                    if (WebViewImpl.this.lh != null) {
                        Iterator it = WebViewImpl.this.lh.keySet().iterator();
                        while (it.hasNext()) {
                            WebViewImpl.this.removeJavascriptInterface((String) it.next());
                        }
                        WebViewImpl.this.lh = null;
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void setNetworkAvailable(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ur = Boolean.valueOf(z);
                    WebViewImpl.super.setNetworkAvailable(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String str, final Map<String, String> map) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.23
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadUrl(str, map);
                    if (WebViewImpl.this.qg != null) {
                        WebViewImpl.this.qg.n(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void loadUrl(final String str) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.34
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadUrl(str);
                    if (WebViewImpl.this.qg != null) {
                        WebViewImpl.this.qg.n(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void postUrl(final String str, final byte[] bArr) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.45
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.postUrl(str, bArr);
                    if (WebViewImpl.this.qg != null) {
                        WebViewImpl.this.qg.n(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadData(final String str, final String str2, final String str3) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.56
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
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.58
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
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.59
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
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.60
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.reload();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public boolean canGoBack() {
        if (!n()) {
            return false;
        }
        try {
            return super.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void goBack() {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.2
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
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goForward();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void onResume() {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.4
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
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goBackOrForward(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public String getUrl() {
        if (n()) {
            try {
                return super.getUrl();
            } catch (Throwable unused) {
            }
        }
        if (this.qg != null) {
            return this.qg.qg();
        }
        return null;
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public int getProgress() {
        if (n()) {
            try {
                return super.getProgress();
            } catch (Throwable unused) {
                return 100;
            }
        }
        final Object obj = new Object();
        final int[] iArr = {-1};
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.6
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

    @Override // android.webkit.WebView, com.byazt.uad.q
    public int getContentHeight() {
        if (n()) {
            try {
                return super.getContentHeight();
            } catch (Throwable unused) {
                return 1;
            }
        }
        final Object obj = new Object();
        final int[] iArr = {-1};
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.7
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

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void clearCache(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.8
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
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearFormData();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void clearHistory() {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearHistory();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void setWebViewClient(final WebViewClient webViewClient) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewClient webViewClientN = webViewClient;
                    if (webViewClientN == null) {
                        webViewClientN = new SSWebView.n();
                    } else if (webViewClientN instanceof com.byazt.kfh.qg) {
                        webViewClientN = ((com.byazt.kfh.qg) webViewClientN).n();
                    }
                    WebViewImpl.this.qg = new com.byazt.kfh.qg(webViewClientN);
                    WebViewImpl webViewImpl = WebViewImpl.this;
                    WebViewImpl.super.setWebViewClient(webViewImpl.qg);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void setDownloadListener(final DownloadListener downloadListener) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.q = downloadListener;
                    WebViewImpl.super.setDownloadListener(downloadListener);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.s = webChromeClient;
                    WebViewImpl.super.setWebChromeClient(webChromeClient);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.byazt.uad.q
    public void setBackgroundColor(final int i) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.l = Integer.valueOf(i);
                    WebViewImpl.super.setBackgroundColor(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.byazt.uad.q
    public void computeScroll() {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.computeScroll();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.byazt.uad.q
    public void setLayerType(final int i, final Paint paint) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setLayerType(i, paint);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.byazt.uad.q
    public void setOverScrollMode(final int i) {
        super.setOverScrollMode(i);
        rv.qg().post(new Runnable() { // from class: com.byazt.qza.WebViewImpl.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setOverScrollMode(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void s() {
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void addJavascriptInterface(final Object obj, final String str) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.lh == null) {
                        WebViewImpl.this.lh = new HashMap();
                    }
                    qg qgVar = new qg(obj, str, WebViewImpl.this.j, WebViewImpl.this);
                    WebViewImpl.this.hashCode();
                    WebViewImpl.super.addJavascriptInterface(qgVar, str);
                    WebViewImpl.this.lh.put(str, qgVar);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setJavaScriptEnabled(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.t = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setJavaScriptEnabled(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setDisplayZoomControls(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.21
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.h = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setDisplayZoomControls(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setCacheMode(final int i) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.22
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.hu = Integer.valueOf(i);
                    WebViewImpl.this.getSettings().setCacheMode(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void q() {
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
            if (TextUtils.isEmpty(str) || (settings = getSettings()) == null || ln) {
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

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void onPause() {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.24
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.onPause();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public String getUserAgentString() {
        if (n()) {
            try {
                return getSettings().getUserAgentString();
            } catch (Throwable unused) {
                return "";
            }
        }
        final Object obj = new Object();
        final String[] strArr = {""};
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.25
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

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.26
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.evaluateJavascript(str, valueCallback);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.qza.BaseWebView, android.webkit.WebView
    public void destroy() {
        if (this.v) {
            return;
        }
        com.byazt.uad.n.n(this);
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.27
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.v) {
                        return;
                    }
                    WebViewImpl.this.qg();
                    if (WebViewImpl.this.lh != null) {
                        Iterator it = WebViewImpl.this.lh.keySet().iterator();
                        while (it.hasNext()) {
                            WebViewImpl.super.removeJavascriptInterface((String) it.next());
                        }
                        WebViewImpl.this.lh = null;
                    }
                    WebViewImpl.super.destroy();
                    WebViewImpl.this.hashCode();
                    WebViewImpl.this.j.hashCode();
                    WebViewImpl.this.v = true;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void removeJavascriptInterface(final String str) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.28
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.v) {
                        return;
                    }
                    WebViewImpl.this.hashCode();
                    WebViewImpl.super.removeJavascriptInterface(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setAppCacheEnabled(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.29
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.m = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAppCacheEnabled(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setSupportZoom(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.30
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ou = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setSupportZoom(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setUseWideViewPort(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.31
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.wm = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setUseWideViewPort(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.32
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.py = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setDomStorageEnabled(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.33
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.a = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setDomStorageEnabled(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setBuiltInZoomControls(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.35
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.um = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setBuiltInZoomControls(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.36
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.cd = layoutAlgorithm;
                    WebViewImpl.this.getSettings().setLayoutAlgorithm(layoutAlgorithm);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setLoadWithOverviewMode(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.37
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.hd = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setLoadWithOverviewMode(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setUserAgentString(final String str) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.38
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.getSettings().setUserAgentString(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setDefaultTextEncodingName(final String str) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.39
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.cy = str;
                    WebViewImpl.this.getSettings().setDefaultTextEncodingName(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setDefaultFontSize(final int i) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.40
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.k = Integer.valueOf(i);
                    WebViewImpl.this.getSettings().setDefaultFontSize(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setMixedContentMode(final int i) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.41
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.sz = Integer.valueOf(i);
                    WebViewImpl.this.getSettings().setMixedContentMode(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setDatabaseEnabled(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.42
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.oa = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setDatabaseEnabled(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View, com.byazt.uad.q
    public void setVisibility(final int i) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.43
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setVisibility(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View, com.byazt.uad.q
    public void setAlpha(final float f) {
        super.setAlpha(f);
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.44
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setAlpha(f);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setAllowFileAccess(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.46
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.d = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAllowFileAccess(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void clearView() {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.47
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearView();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void pauseTimers() {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.48
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.pauseTimers();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.uad.q
    public void resumeTimers() {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.49
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.resumeTimers();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.ViewGroup, com.byazt.uad.q
    public void removeAllViews() {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.50
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.removeAllViews();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setBlockNetworkImage(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.51
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.cp = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setBlockNetworkImage(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setAllowFileAccessFromFileURLs(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.52
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.tj = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAllowFileAccessFromFileURLs(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setAllowUniversalAccessFromFileURLs(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.53
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.rv = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAllowUniversalAccessFromFileURLs(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setSavePassword(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.54
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.fs = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setSavePassword(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void setMediaPlaybackRequiresUserGesture(final boolean z) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.55
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.x = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setMediaPlaybackRequiresUserGesture(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View, com.byazt.uad.q
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        n(new Runnable() { // from class: com.byazt.qza.WebViewImpl.57
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.w = onScrollChangeListener;
                    WebViewImpl.super.setOnScrollChangeListener(onScrollChangeListener);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.byazt.uad.q
    public void n(String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, str2);
            jSONObject.putOpt("param", obj);
            qg(str, "csjEventListener", jSONObject);
        } catch (JSONException unused) {
        }
    }

    @Override // com.byazt.uad.s
    public void setTouchEventListener(com.byazt.uad.s.n nVar) {
        this.bb = nVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Pair<Boolean, Boolean> pairN;
        if (this.bb != null && (pairN = this.bb.n(this, motionEvent)) != null && ((Boolean) pairN.first).booleanValue()) {
            return ((Boolean) pairN.second).booleanValue();
        }
        return super.onTouchEvent(motionEvent);
    }
}
