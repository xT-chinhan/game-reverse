package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.zb.ah;

/* JADX INFO: loaded from: classes2.dex */
public class BizWebView extends MultiWebview implements ah {
    @Override // com.bytedance.sdk.component.zb.ah
    public View getView() {
        return this;
    }

    public BizWebView(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.component.widget.web.MultiWebview
    public void H_() {
        super.H_();
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setNetworkAvailable(final boolean z) {
        if (this.xr != null) {
            this.xr.setNetworkAvailable(z);
        } else {
            if (this.f1473ms == null || this.f1473ms.get() >= 3) {
                return;
            }
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setNetworkAvailable(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void loadUrl(final String str) {
        if (this.xr != null) {
            this.xr.loadUrl(str);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.22
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.loadUrl(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public boolean canGoBack() {
        if (this.xr != null) {
            if (this.xr.canGoBack()) {
                return true;
            }
            if (getWebViewCount() > 1 && ms() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void goBack() {
        if (this.xr != null) {
            this.xr.goBack();
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public String getUrl() {
        return this.xr != null ? this.xr.getUrl() : "";
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public int getProgress() {
        if (this.xr != null) {
            return this.xr.getProgress();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public int getContentHeight() {
        if (this.xr != null) {
            return this.xr.getContentHeight();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public String getUserAgentString() {
        return this.xr != null ? this.xr.getUserAgentString() : "";
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setUserAgentString(final String str) {
        if (this.xr != null) {
            this.xr.setUserAgentString(str);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.35
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setUserAgentString(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void onResume() {
        if (this.xr != null) {
            this.xr.onResume();
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void clearCache(boolean z) {
        if (this.xr != null) {
            this.xr.clearCache(z);
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void clearHistory() {
        if (this.xr != null) {
            this.xr.clearHistory();
        }
    }

    public void setWebViewClient(final WebViewClient webViewClient) {
        if (this.xr != null) {
            this.xr.setWebViewClient(webViewClient);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.36
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setWebViewClient(webViewClient);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setDownloadListener(final DownloadListener downloadListener) {
        if (this.xr != null) {
            this.xr.setDownloadListener(downloadListener);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.37
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setDownloadListener(downloadListener);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        if (this.xr != null) {
            this.xr.setWebChromeClient(webChromeClient);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setWebChromeClient(webChromeClient);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void addJavascriptInterface(final Object obj, final String str) {
        if (this.xr != null) {
            this.xr.addJavascriptInterface(obj, str);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.addJavascriptInterface(obj, str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setJavaScriptEnabled(final boolean z) {
        if (this.xr != null) {
            this.xr.setJavaScriptEnabled(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setJavaScriptEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setDisplayZoomControls(final boolean z) {
        if (this.xr != null) {
            this.xr.setDisplayZoomControls(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setDisplayZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setCacheMode(final int i) {
        if (this.xr != null) {
            this.xr.setCacheMode(i);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setCacheMode(i);
                    }
                }
            });
        }
    }

    public void onPause() {
        if (this.xr != null) {
            this.xr.onPause();
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        if (this.xr != null) {
            this.xr.evaluateJavascript(str, valueCallback);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.evaluateJavascript(str, valueCallback);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public WebView getWebView() {
        if (this.xr != null) {
            return this.xr.getWebView();
        }
        if (ka()) {
            return null;
        }
        long j = 500;
        while (this.f1473ms.get() < 3 && j > 0) {
            try {
                Thread.sleep(10L);
                j -= 10;
            } catch (Exception unused) {
            }
        }
        if (this.xr != null) {
            return this.xr.getWebView();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.zb.ah
    public void destroy() {
        super.destroy();
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void removeJavascriptInterface(String str) {
        ah ahVar = this.xr;
        if (ahVar != null) {
            ahVar.removeJavascriptInterface(str);
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setAppCacheEnabled(final boolean z) {
        if (this.xr != null) {
            this.xr.setAppCacheEnabled(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.8
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setAppCacheEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setSupportZoom(final boolean z) {
        if (this.xr != null) {
            this.xr.setSupportZoom(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setSupportZoom(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setUseWideViewPort(final boolean z) {
        if (this.xr != null) {
            this.xr.setUseWideViewPort(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.10
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setUseWideViewPort(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z) {
        if (this.xr != null) {
            this.xr.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.11
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setJavaScriptCanOpenWindowsAutomatically(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setDomStorageEnabled(final boolean z) {
        if (this.xr != null) {
            this.xr.setDomStorageEnabled(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.12
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setDomStorageEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setBuiltInZoomControls(final boolean z) {
        if (this.xr != null) {
            this.xr.setBuiltInZoomControls(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.13
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setBuiltInZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        if (this.xr != null) {
            this.xr.setLayoutAlgorithm(layoutAlgorithm);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.14
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setLayoutAlgorithm(layoutAlgorithm);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setLoadWithOverviewMode(final boolean z) {
        if (this.xr != null) {
            this.xr.setLoadWithOverviewMode(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.15
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setLoadWithOverviewMode(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setDefaultTextEncodingName(final String str) {
        if (this.xr != null) {
            this.xr.setDefaultTextEncodingName(str);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.16
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setDefaultTextEncodingName(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setDefaultFontSize(final int i) {
        if (this.xr != null) {
            this.xr.setDefaultFontSize(i);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.17
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setDefaultFontSize(i);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setMixedContentMode(final int i) {
        if (this.xr != null) {
            this.xr.setMixedContentMode(i);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.18
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setMixedContentMode(i);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setDatabaseEnabled(final boolean z) {
        if (this.xr != null) {
            this.xr.setDatabaseEnabled(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.19
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setDatabaseEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setAllowFileAccess(final boolean z) {
        if (this.xr != null) {
            this.xr.setAllowFileAccess(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.20
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setAllowFileAccess(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void clearView() {
        if (this.xr != null) {
            this.xr.clearView();
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void pauseTimers() {
        if (this.xr != null) {
            this.xr.pauseTimers();
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void resumeTimers() {
        if (this.xr != null) {
            this.xr.resumeTimers();
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setBlockNetworkImage(final boolean z) {
        if (this.xr != null) {
            this.xr.setBlockNetworkImage(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.21
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setBlockNetworkImage(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setAllowFileAccessFromFileURLs(final boolean z) {
        if (this.xr != null) {
            this.xr.setAllowFileAccessFromFileURLs(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.23
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setAllowUniversalAccessFromFileURLs(final boolean z) {
        if (this.xr != null) {
            this.xr.setAllowUniversalAccessFromFileURLs(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.24
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setSavePassword(final boolean z) {
        if (this.xr != null) {
            this.xr.setSavePassword(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.25
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setSavePassword(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void setMediaPlaybackRequiresUserGesture(final boolean z) {
        if (this.xr != null) {
            this.xr.setMediaPlaybackRequiresUserGesture(z);
        } else if (this.f1473ms.get() < 3) {
            xr(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.26
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setMediaPlaybackRequiresUserGesture(z);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.zb.ah
    public void setBackgroundColor(final int i) {
        super.setBackgroundColor(i);
        if (this.xr != null) {
            this.xr.setBackgroundColor(i);
        } else {
            if (this.f1473ms == null || this.f1473ms.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.27
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setBackgroundColor(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.zb.ah
    public void computeScroll() {
        if (this.xr != null) {
            this.xr.computeScroll();
        } else {
            if (this.f1473ms == null || this.f1473ms.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.28
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.computeScroll();
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.zb.ah
    public void setLayerType(final int i, final Paint paint) {
        if (this.xr != null) {
            this.xr.setLayerType(i, paint);
        } else {
            if (this.f1473ms == null || this.f1473ms.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.29
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setLayerType(i, paint);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.zb.ah
    public void setOverScrollMode(final int i) {
        super.setOverScrollMode(i);
        if (this.xr != null) {
            this.xr.setOverScrollMode(i);
        } else {
            if (this.f1473ms == null || this.f1473ms.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.30
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setOverScrollMode(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.zb.ah
    public void setVisibility(final int i) {
        super.setVisibility(i);
        if (this.xr != null) {
            this.xr.setVisibility(i);
        } else {
            if (this.f1473ms == null || this.f1473ms.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.31
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setVisibility(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.zb.ah
    public void setAlpha(final float f) {
        super.setAlpha(f);
        if (this.xr != null) {
            this.xr.setAlpha(f);
        } else {
            if (this.f1473ms == null || this.f1473ms.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.32
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setAlpha(f);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.zb.ah
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        if (this.xr != null) {
            this.xr.setOnScrollChangeListener(onScrollChangeListener);
        } else {
            if (this.f1473ms == null || this.f1473ms.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.33
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setOnScrollChangeListener(onScrollChangeListener);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.xr
    public void setTouchEventListener(final com.bytedance.sdk.component.zb.xr.ms msVar) {
        if (this.xr != null) {
            this.xr.setTouchEventListener(msVar);
        } else {
            if (this.f1473ms == null || this.f1473ms.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.34
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xr != null) {
                        BizWebView.this.xr.setTouchEventListener(msVar);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.zb.ah
    public void ms(String str, String str2, Object obj) {
        if (this.xr != null) {
            this.xr.ms(str, str2, obj);
        }
    }

    private void xr(Runnable runnable) {
        x.xr().post(runnable);
    }
}
