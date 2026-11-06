package com.byazt.su;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bumptech.glide.load.Key;
import com.byazt.ca.aj;
import com.byazt.fj.SSWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 1645})
public class WebViewImpl extends BaseWebView implements com.byazt.son.x {
    public static boolean nl = false;
    public final com.byazt.son.hw n;
    public volatile boolean ww;
    public Map<String, pr> y;

    public WebViewImpl(com.byazt.son.hw hwVar, Context context) {
        super(pr(context));
        this.ww = false;
        this.n = hwVar;
        hw(context);
    }

    public WebViewImpl(com.byazt.son.hw hwVar, Context context, AttributeSet attributeSet) {
        super(pr(context), attributeSet);
        this.ww = false;
        this.n = hwVar;
        hw(context);
    }

    public WebViewImpl(com.byazt.son.hw hwVar, Context context, AttributeSet attributeSet, int i) {
        super(pr(context), attributeSet, i);
        this.ww = false;
        this.n = hwVar;
        hw(context);
    }

    private static Context pr(Context context) {
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 23) {
            return context.createConfigurationContext(new Configuration());
        }
        return context;
    }

    private void hw(Context context) {
        hn(context);
        x();
        hn();
    }

    @Override // com.byazt.su.BaseWebView
    public Map<String, pr> getJavascriptInterfaces() {
        return this.y;
    }

    @Override // com.byazt.su.BaseWebView
    public com.byazt.fj.hw getClient() {
        return this.hw;
    }

    @Override // com.byazt.su.BaseWebView
    public WebChromeClient getChromeClient() {
        return this.hn;
    }

    @Override // com.byazt.su.BaseWebView
    public void hw() {
        super.hw();
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.1
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
                    settings.setDefaultTextEncodingName(Key.STRING_CHARSET_NAME);
                    settings.setDefaultFontSize(16);
                    if (WebViewImpl.this.y != null) {
                        Iterator it = WebViewImpl.this.y.keySet().iterator();
                        while (it.hasNext()) {
                            WebViewImpl.this.removeJavascriptInterface((String) it.next());
                        }
                        WebViewImpl.this.y = null;
                    }
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void setNetworkAvailable(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ve = Boolean.valueOf(z);
                    WebViewImpl.super.setNetworkAvailable(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String str, final Map<String, String> map) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.23
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadUrl(str, map);
                    if (WebViewImpl.this.hw != null) {
                        WebViewImpl.this.hw.pr(str);
                    }
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void loadUrl(final String str) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.34
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadUrl(str);
                    if (WebViewImpl.this.hw != null) {
                        WebViewImpl.this.hw.pr(str);
                    }
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void postUrl(final String str, final byte[] bArr) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.45
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.postUrl(str, bArr);
                    if (WebViewImpl.this.hw != null) {
                        WebViewImpl.this.hw.pr(str);
                    }
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadData(final String str, final String str2, final String str3) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.56
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.loadData(str, str2, str3);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.58
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadDataWithBaseURL(str, str2, str3, str4, str5);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.59
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.stopLoading();
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void reload() {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.60
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.reload();
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public boolean canGoBack() {
        if (pr()) {
            try {
                return super.canGoBack();
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void goBack() {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goBack();
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public boolean canGoForward() {
        try {
            return super.canGoForward();
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public void goForward() {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goForward();
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void onResume() {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.4
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
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(final int i) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goBackOrForward(i);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public String getUrl() {
        if (pr()) {
            try {
                return super.getUrl();
            } catch (Throwable th) {
            }
        }
        if (this.hw != null) {
            return this.hw.hw();
        }
        return null;
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public int getProgress() {
        if (pr()) {
            try {
                return super.getProgress();
            } catch (Throwable th) {
                return 100;
            }
        }
        final Object obj = new Object();
        final int[] iArr = {-1};
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.6
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
        } catch (InterruptedException e) {
        }
        return iArr[0];
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public int getContentHeight() {
        if (pr()) {
            try {
                return super.getContentHeight();
            } catch (Throwable th) {
                return 1;
            }
        }
        final Object obj = new Object();
        final int[] iArr = {-1};
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.7
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
        } catch (InterruptedException e) {
        }
        return iArr[0];
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void clearCache(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearCache(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void clearFormData() {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearFormData();
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void clearHistory() {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearHistory();
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void setWebViewClient(final WebViewClient webViewClient) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewClient webViewClientPr = webViewClient;
                    if (webViewClientPr == null) {
                        webViewClientPr = new SSWebView.pr();
                    } else if (webViewClientPr instanceof com.byazt.fj.hw) {
                        webViewClientPr = ((com.byazt.fj.hw) webViewClientPr).pr();
                    }
                    WebViewImpl.this.hw = new com.byazt.fj.hw(webViewClientPr);
                    WebViewImpl webViewImpl = WebViewImpl.this;
                    WebViewImpl.super.setWebViewClient(webViewImpl.hw);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void setDownloadListener(final DownloadListener downloadListener) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.x = downloadListener;
                    WebViewImpl.super.setDownloadListener(downloadListener);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.hn = webChromeClient;
                    WebViewImpl.super.setWebChromeClient(webChromeClient);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.byazt.son.x
    public void setBackgroundColor(final int i) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.c = Integer.valueOf(i);
                    WebViewImpl.super.setBackgroundColor(i);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.byazt.son.x
    public void computeScroll() {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.computeScroll();
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.byazt.son.x
    public void setLayerType(final int i, final Paint paint) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setLayerType(i, paint);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.byazt.son.x
    public void setOverScrollMode(final int i) {
        super.setOverScrollMode(i);
        aj.hw().post(new Runnable() { // from class: com.byazt.su.WebViewImpl.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setOverScrollMode(i);
                } catch (Throwable th) {
                }
            }
        });
    }

    private void hn(Context context) {
        if (Build.VERSION.SDK_INT == 17 && context != null) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                    Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(accessibilityManager, 0);
                }
            } catch (Throwable th) {
            }
        }
    }

    private void hn() {
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
        }
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void addJavascriptInterface(final Object obj, final String str) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.y == null) {
                        WebViewImpl.this.y = new HashMap();
                    }
                    hw hwVar = new hw(obj, str, WebViewImpl.this.n, WebViewImpl.this);
                    WebViewImpl.this.hashCode();
                    WebViewImpl.super.addJavascriptInterface(hwVar, str);
                    WebViewImpl.this.y.put(str, hwVar);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setJavaScriptEnabled(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.iu = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setJavaScriptEnabled(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setDisplayZoomControls(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.21
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.b = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setDisplayZoomControls(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setCacheMode(final int i) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.22
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.z = Integer.valueOf(i);
                    WebViewImpl.this.getSettings().setCacheMode(i);
                } catch (Throwable th) {
                }
            }
        });
    }

    private void x() {
        try {
            WebSettings settings = getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (TextUtils.isEmpty(str) || (settings = getSettings()) == null || nl) {
                return;
            }
            if (Uri.parse(str).getScheme().equals("file")) {
                settings.setJavaScriptEnabled(false);
            } else {
                settings.setJavaScriptEnabled(true);
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void onPause() {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.24
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.onPause();
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public String getUserAgentString() {
        if (pr()) {
            try {
                return getSettings().getUserAgentString();
            } catch (Throwable th) {
                return "";
            }
        }
        final Object obj = new Object();
        final String[] strArr = {""};
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.25
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
        } catch (InterruptedException e) {
        }
        return strArr[0];
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.26
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.evaluateJavascript(str, valueCallback);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public WebView getWebView() {
        return this;
    }

    @Override // com.byazt.son.x
    public View getView() {
        return this;
    }

    @Override // com.byazt.su.BaseWebView, android.webkit.WebView
    public void destroy() {
        if (this.ww) {
            return;
        }
        com.byazt.son.pr.pr(this);
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.27
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.ww) {
                        return;
                    }
                    WebViewImpl.this.hw();
                    if (WebViewImpl.this.y != null) {
                        Iterator it = WebViewImpl.this.y.keySet().iterator();
                        while (it.hasNext()) {
                            WebViewImpl.super.removeJavascriptInterface((String) it.next());
                        }
                        WebViewImpl.this.y = null;
                    }
                    WebViewImpl.super.destroy();
                    WebViewImpl.this.hashCode();
                    WebViewImpl.this.n.hashCode();
                    WebViewImpl.this.ww = true;
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void removeJavascriptInterface(final String str) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.28
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.ww) {
                        return;
                    }
                    WebViewImpl.this.hashCode();
                    WebViewImpl.super.removeJavascriptInterface(str);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setAppCacheEnabled(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.29
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.rc = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAppCacheEnabled(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setSupportZoom(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.30
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ny = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setSupportZoom(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setUseWideViewPort(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.31
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.fo = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setUseWideViewPort(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.32
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.cz = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setDomStorageEnabled(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.33
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.a = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setDomStorageEnabled(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setBuiltInZoomControls(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.35
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.qa = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setBuiltInZoomControls(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.36
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.lb = layoutAlgorithm;
                    WebViewImpl.this.getSettings().setLayoutAlgorithm(layoutAlgorithm);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setLoadWithOverviewMode(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.37
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.yb = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setLoadWithOverviewMode(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setUserAgentString(final String str) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.38
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.getSettings().setUserAgentString(str);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setDefaultTextEncodingName(final String str) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.39
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.nt = str;
                    WebViewImpl.this.getSettings().setDefaultTextEncodingName(str);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setDefaultFontSize(final int i) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.40
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ho = Integer.valueOf(i);
                    WebViewImpl.this.getSettings().setDefaultFontSize(i);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setMixedContentMode(final int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.41
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WebViewImpl.this.g = Integer.valueOf(i);
                        WebViewImpl.this.getSettings().setMixedContentMode(i);
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setDatabaseEnabled(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.42
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.m = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setDatabaseEnabled(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.view.View, com.byazt.son.x
    public void setVisibility(final int i) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.43
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setVisibility(i);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.view.View, com.byazt.son.x
    public void setAlpha(final float f) {
        super.setAlpha(f);
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.44
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setAlpha(f);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setAllowFileAccess(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.46
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.k = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAllowFileAccess(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void clearView() {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.47
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearView();
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void pauseTimers() {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.48
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.pauseTimers();
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.byazt.son.x
    public void resumeTimers() {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.49
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.resumeTimers();
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.view.ViewGroup, com.byazt.son.x
    public void removeAllViews() {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.50
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.removeAllViews();
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setBlockNetworkImage(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.51
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.w = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setBlockNetworkImage(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setAllowFileAccessFromFileURLs(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.52
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.vk = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAllowFileAccessFromFileURLs(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setAllowUniversalAccessFromFileURLs(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.53
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.aj = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAllowUniversalAccessFromFileURLs(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setSavePassword(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.54
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.zo = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setSavePassword(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void setMediaPlaybackRequiresUserGesture(final boolean z) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.55
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.fw = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setMediaPlaybackRequiresUserGesture(z);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.view.View, com.byazt.son.x
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        pr(new Runnable() { // from class: com.byazt.su.WebViewImpl.57
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        WebViewImpl.this.uc = onScrollChangeListener;
                        WebViewImpl.super.setOnScrollChangeListener(onScrollChangeListener);
                    }
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.byazt.son.x
    public void pr(String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, str2);
            jSONObject.putOpt("param", obj);
            hw(str, "csjEventListener", jSONObject);
        } catch (JSONException e) {
        }
    }

    @Override // com.byazt.son.hn
    public void setTouchEventListener(com.byazt.son.hn.pr prVar) {
        this.gz = prVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Pair<Boolean, Boolean> pairPr;
        if (this.gz != null && (pairPr = this.gz.pr(this, motionEvent)) != null && ((Boolean) pairPr.first).booleanValue()) {
            return ((Boolean) pairPr.second).booleanValue();
        }
        return super.onTouchEvent(motionEvent);
    }
}
