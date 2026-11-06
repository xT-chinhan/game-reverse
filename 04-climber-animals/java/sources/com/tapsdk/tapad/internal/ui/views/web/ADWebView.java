package com.tapsdk.tapad.internal.ui.views.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tapsdk.tapad.internal.tracker.experiment.g;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ADWebView extends WebView {
    private static final String TAG = "ADWebView";
    private boolean enableSdkDebugLog;
    private List<String> monitorUrls;
    private int sampleRatio;
    private String trackId;
    d webChromeClientDelegate;
    e webViewClientDelegate;

    class a extends WebChromeClient {
        a() {
        }

        void a(ValueCallback<Uri> valueCallback, String str, String str2) {
            d dVar = ADWebView.this.webChromeClientDelegate;
            if (dVar != null) {
                dVar.a(valueCallback, str, str2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                ADWebView.this.webViewClientDelegate.a();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (ADWebView.this.getUrl().contains(str)) {
                return;
            }
            ADWebView.this.webViewClientDelegate.a(str);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            d dVar = ADWebView.this.webChromeClientDelegate;
            return dVar != null ? dVar.a(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }
    }

    class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            ADWebView.this.reportWebViewError("onReceivedError(WebView view, int errorCode, String description, String failingUrl)", i, str, str2, null);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            int errorCode;
            String strValueOf;
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceError != null) {
                errorCode = webResourceError.getErrorCode();
                strValueOf = String.valueOf(webResourceError.getDescription());
            } else {
                errorCode = Integer.MIN_VALUE;
                strValueOf = "";
            }
            ADWebView.this.reportWebViewError("onReceivedError(WebView view, WebResourceRequest request, WebResourceError error)", errorCode, strValueOf, webResourceRequest != null ? String.valueOf(webResourceRequest.getUrl()) : "", null);
            if (webResourceRequest == null || !webResourceRequest.isForMainFrame()) {
                return;
            }
            webView.loadUrl(com.anythink.core.common.res.d.a);
            Uri url = webResourceRequest.getUrl();
            ADWebView.this.webViewClientDelegate.c(url != null ? url.toString() : null);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            int statusCode;
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            Uri url = webResourceRequest != null ? webResourceRequest.getUrl() : null;
            String strValueOf = "";
            String string = url != null ? url.toString() : "";
            ADWebView.this.webViewClientDelegate.c(url != null ? url.toString() : null);
            if (webResourceResponse != null) {
                statusCode = webResourceResponse.getStatusCode();
                strValueOf = String.valueOf(webResourceResponse.getReasonPhrase());
            } else {
                statusCode = Integer.MIN_VALUE;
            }
            ADWebView.this.reportWebViewError("onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse)", statusCode, strValueOf, string, null);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int i;
            if (!ADWebView.this.monitorUrls.isEmpty()) {
                HashMap map = new HashMap();
                map.put("timestamp", String.valueOf(System.currentTimeMillis()));
                map.put("inner_browser_action_url", str);
                if (str.startsWith("https://") || str.startsWith("http://")) {
                    i = 3;
                } else {
                    i = str.startsWith(WebViewDialogFragment.WEIXIN) ? 4 : 2;
                }
                map.put("interaction_type", String.valueOf(i));
                com.tapsdk.tapad.internal.tracker.c.a().a(ADWebView.this.monitorUrls, map);
            }
            if (str.startsWith("https://") || str.startsWith("http://")) {
                webView.loadUrl(str);
                ADWebView.this.webViewClientDelegate.b(str);
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (str == null || !(str.startsWith("taptap") || str.startsWith(WebViewDialogFragment.WEIXIN))) {
                try {
                    ADWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception unused) {
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            try {
                Intent uri = Intent.parseUri(str, 1);
                uri.addFlags(270532608);
                com.tapsdk.tapad.internal.utils.a.a(ADWebView.this.getContext()).startActivityForResult(uri, 100);
                if (str.startsWith(WebViewDialogFragment.WEIXIN)) {
                    ADWebView.this.webViewClientDelegate.b(str);
                }
                return true;
            } catch (Exception unused2) {
                ADWebView.this.webViewClientDelegate.c(null);
                return true;
            }
        }
    }

    class c implements DownloadListener {
        c() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (!ADWebView.this.monitorUrls.isEmpty()) {
                HashMap map = new HashMap();
                map.put("timestamp", String.valueOf(System.currentTimeMillis()));
                map.put("inner_browser_action_url", str);
                map.put("interaction_type", String.valueOf(1));
                com.tapsdk.tapad.internal.tracker.c.a().a(ADWebView.this.monitorUrls, map);
            }
            TapADLogger.d("TAG: onDownloadStart: " + str + ", " + str2 + ", " + str3 + ", " + str4 + ", " + j);
            new com.tapsdk.tapad.internal.ui.views.web.a(ADWebView.this.getContext(), new com.tapsdk.tapad.internal.ui.views.web.b(str, str2, str3, str4, j), ADWebView.this.monitorUrls).show();
        }
    }

    public interface d {
        void a(ValueCallback<Uri> valueCallback, String str, String str2);

        boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams);
    }

    public interface e {
        void a();

        void a(String str);

        void b(String str);

        void c(String str);
    }

    public ADWebView(Context context) {
        this(context, null);
    }

    public ADWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.monitorUrls = new ArrayList();
        this.enableSdkDebugLog = false;
        this.trackId = "";
        this.sampleRatio = Integer.MAX_VALUE;
        setWebChromeClient(new a());
        b bVar = new b();
        setDownloadListener(new c());
        setWebViewClient(bVar);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebViewError(String str, int i, String str2, String str3, Map<String, String> map) {
        com.tapsdk.tapad.internal.tracker.experiment.f.b().a(g.b).a(new com.tapsdk.tapad.internal.tracker.experiment.h.g().c(str).a(i).e(str3).a(str2).d(this.trackId).b("1").b(this.sampleRatio));
    }

    @Override // android.webkit.WebView
    public void destroy() {
        removeAllViewsInLayout();
        super.destroy();
    }

    public void enableSdkDebugLog(boolean z) {
        this.enableSdkDebugLog = z;
    }

    public void setMonitorUrls(List<String> list) {
        if (list != null) {
            this.monitorUrls.clear();
            this.monitorUrls.addAll(list);
        }
    }

    public void setSampleRatio(int i) {
        this.sampleRatio = i;
    }

    public void setTrackId(String str) {
        this.trackId = str;
    }

    public void setWebChromeClientDelegate(d dVar) {
        this.webChromeClientDelegate = dVar;
    }

    public void setWebViewClientDelegate(e eVar) {
        this.webViewClientDelegate = eVar;
    }
}
