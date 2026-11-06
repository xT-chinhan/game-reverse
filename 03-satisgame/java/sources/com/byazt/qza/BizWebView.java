package com.byazt.qza;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TIME_BAR_PERCENTAGE, 2334})
public class BizWebView extends MultiWebview implements com.byazt.uad.q {
    @Override // com.byazt.uad.q
    public View getView() {
        return this;
    }

    public BizWebView(Context context) {
        super(context);
    }

    @Override // com.byazt.qza.MultiWebview
    public void S_() {
        super.S_();
    }

    @Override // com.byazt.uad.q
    public void setNetworkAvailable(final boolean z) {
        if (this.qg != null) {
            this.qg.setNetworkAvailable(z);
        } else {
            if (this.n == null || this.n.get() >= 3) {
                return;
            }
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setNetworkAvailable(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void loadUrl(final String str) {
        if (this.qg != null) {
            this.qg.loadUrl(str);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.22
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.loadUrl(str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public boolean canGoBack() {
        if (this.qg != null) {
            if (this.qg.canGoBack()) {
                return true;
            }
            if (getWebViewCount() > 1 && n() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.uad.q
    public void goBack() {
        if (this.qg != null) {
            this.qg.goBack();
        }
    }

    @Override // com.byazt.uad.q
    public String getUrl() {
        return this.qg != null ? this.qg.getUrl() : "";
    }

    @Override // com.byazt.uad.q
    public int getProgress() {
        if (this.qg != null) {
            return this.qg.getProgress();
        }
        return 0;
    }

    @Override // com.byazt.uad.q
    public int getContentHeight() {
        if (this.qg != null) {
            return this.qg.getContentHeight();
        }
        return 0;
    }

    @Override // com.byazt.uad.q
    public String getUserAgentString() {
        return this.qg != null ? this.qg.getUserAgentString() : "";
    }

    @Override // com.byazt.uad.q
    public void setUserAgentString(final String str) {
        if (this.qg != null) {
            this.qg.setUserAgentString(str);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.35
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setUserAgentString(str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void onResume() {
        if (this.qg != null) {
            this.qg.onResume();
        }
    }

    @Override // com.byazt.uad.q
    public void clearCache(boolean z) {
        if (this.qg != null) {
            this.qg.clearCache(z);
        }
    }

    public void setWebViewClient(final WebViewClient webViewClient) {
        if (this.qg != null) {
            this.qg.setWebViewClient(webViewClient);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.36
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setWebViewClient(webViewClient);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setDownloadListener(final DownloadListener downloadListener) {
        if (this.qg != null) {
            this.qg.setDownloadListener(downloadListener);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.37
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setDownloadListener(downloadListener);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        if (this.qg != null) {
            this.qg.setWebChromeClient(webChromeClient);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setWebChromeClient(webChromeClient);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void addJavascriptInterface(final Object obj, final String str) {
        if (this.qg != null) {
            this.qg.addJavascriptInterface(obj, str);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.addJavascriptInterface(obj, str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setJavaScriptEnabled(final boolean z) {
        if (this.qg != null) {
            this.qg.setJavaScriptEnabled(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setJavaScriptEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setDisplayZoomControls(final boolean z) {
        if (this.qg != null) {
            this.qg.setDisplayZoomControls(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setDisplayZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setCacheMode(final int i) {
        if (this.qg != null) {
            this.qg.setCacheMode(i);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setCacheMode(i);
                    }
                }
            });
        }
    }

    public void onPause() {
        if (this.qg != null) {
            this.qg.onPause();
        }
    }

    @Override // com.byazt.uad.q
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        if (this.qg != null) {
            this.qg.evaluateJavascript(str, valueCallback);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.evaluateJavascript(str, valueCallback);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public WebView getWebView() {
        if (this.qg != null) {
            return this.qg.getWebView();
        }
        if (l()) {
            return null;
        }
        long j = 500;
        while (this.n.get() < 3 && j > 0) {
            try {
                Thread.sleep(10L);
                j -= 10;
            } catch (Exception unused) {
            }
        }
        if (this.qg != null) {
            return this.qg.getWebView();
        }
        return null;
    }

    @Override // com.byazt.qza.MultiWebview, com.byazt.uad.q
    public void destroy() {
        super.destroy();
    }

    @Override // com.byazt.uad.q
    public void removeJavascriptInterface(String str) {
        com.byazt.uad.q qVar = this.qg;
        if (qVar != null) {
            qVar.removeJavascriptInterface(str);
        }
    }

    @Override // com.byazt.uad.q
    public void setAppCacheEnabled(final boolean z) {
        if (this.qg != null) {
            this.qg.setAppCacheEnabled(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.8
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setAppCacheEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setSupportZoom(final boolean z) {
        if (this.qg != null) {
            this.qg.setSupportZoom(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setSupportZoom(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setUseWideViewPort(final boolean z) {
        if (this.qg != null) {
            this.qg.setUseWideViewPort(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.10
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setUseWideViewPort(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z) {
        if (this.qg != null) {
            this.qg.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.11
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setJavaScriptCanOpenWindowsAutomatically(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setDomStorageEnabled(final boolean z) {
        if (this.qg != null) {
            this.qg.setDomStorageEnabled(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.12
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setDomStorageEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setBuiltInZoomControls(final boolean z) {
        if (this.qg != null) {
            this.qg.setBuiltInZoomControls(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.13
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setBuiltInZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        if (this.qg != null) {
            this.qg.setLayoutAlgorithm(layoutAlgorithm);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.14
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setLayoutAlgorithm(layoutAlgorithm);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setLoadWithOverviewMode(final boolean z) {
        if (this.qg != null) {
            this.qg.setLoadWithOverviewMode(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.15
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setLoadWithOverviewMode(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setDefaultTextEncodingName(final String str) {
        if (this.qg != null) {
            this.qg.setDefaultTextEncodingName(str);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.16
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setDefaultTextEncodingName(str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setDefaultFontSize(final int i) {
        if (this.qg != null) {
            this.qg.setDefaultFontSize(i);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.17
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setDefaultFontSize(i);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setMixedContentMode(final int i) {
        if (this.qg != null) {
            this.qg.setMixedContentMode(i);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.18
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setMixedContentMode(i);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setDatabaseEnabled(final boolean z) {
        if (this.qg != null) {
            this.qg.setDatabaseEnabled(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.19
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setDatabaseEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setAllowFileAccess(final boolean z) {
        if (this.qg != null) {
            this.qg.setAllowFileAccess(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.20
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setAllowFileAccess(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void clearView() {
        if (this.qg != null) {
            this.qg.clearView();
        }
    }

    @Override // com.byazt.uad.q
    public void pauseTimers() {
        if (this.qg != null) {
            this.qg.pauseTimers();
        }
    }

    @Override // com.byazt.uad.q
    public void resumeTimers() {
        if (this.qg != null) {
            this.qg.resumeTimers();
        }
    }

    @Override // com.byazt.uad.q
    public void setBlockNetworkImage(final boolean z) {
        if (this.qg != null) {
            this.qg.setBlockNetworkImage(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.21
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setBlockNetworkImage(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setAllowFileAccessFromFileURLs(final boolean z) {
        if (this.qg != null) {
            this.qg.setAllowFileAccessFromFileURLs(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.23
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setAllowUniversalAccessFromFileURLs(final boolean z) {
        if (this.qg != null) {
            this.qg.setAllowUniversalAccessFromFileURLs(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.24
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setSavePassword(final boolean z) {
        if (this.qg != null) {
            this.qg.setSavePassword(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.25
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setSavePassword(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void setMediaPlaybackRequiresUserGesture(final boolean z) {
        if (this.qg != null) {
            this.qg.setMediaPlaybackRequiresUserGesture(z);
        } else if (this.n.get() < 3) {
            qg(new Runnable() { // from class: com.byazt.qza.BizWebView.26
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setMediaPlaybackRequiresUserGesture(z);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.uad.q
    public void setBackgroundColor(final int i) {
        super.setBackgroundColor(i);
        if (this.qg != null) {
            this.qg.setBackgroundColor(i);
        } else {
            if (this.n == null || this.n.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.byazt.qza.BizWebView.27
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setBackgroundColor(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.uad.q
    public void computeScroll() {
        if (this.qg != null) {
            this.qg.computeScroll();
        } else {
            if (this.n == null || this.n.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.byazt.qza.BizWebView.28
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.computeScroll();
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.uad.q
    public void setLayerType(final int i, final Paint paint) {
        if (this.qg != null) {
            this.qg.setLayerType(i, paint);
        } else {
            if (this.n == null || this.n.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.byazt.qza.BizWebView.29
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setLayerType(i, paint);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.uad.q
    public void setOverScrollMode(final int i) {
        super.setOverScrollMode(i);
        if (this.qg != null) {
            this.qg.setOverScrollMode(i);
        } else {
            if (this.n == null || this.n.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.byazt.qza.BizWebView.30
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setOverScrollMode(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.uad.q
    public void setVisibility(final int i) {
        super.setVisibility(i);
        if (this.qg != null) {
            this.qg.setVisibility(i);
        } else {
            if (this.n == null || this.n.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.byazt.qza.BizWebView.31
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setVisibility(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.uad.q
    public void setAlpha(final float f) {
        super.setAlpha(f);
        if (this.qg != null) {
            this.qg.setAlpha(f);
        } else {
            if (this.n == null || this.n.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.byazt.qza.BizWebView.32
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setAlpha(f);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.uad.q
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        if (this.qg != null) {
            this.qg.setOnScrollChangeListener(onScrollChangeListener);
        } else {
            if (this.n == null || this.n.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.byazt.qza.BizWebView.33
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setOnScrollChangeListener(onScrollChangeListener);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.s
    public void setTouchEventListener(final com.byazt.uad.s.n nVar) {
        if (this.qg != null) {
            this.qg.setTouchEventListener(nVar);
        } else {
            if (this.n == null || this.n.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.byazt.qza.BizWebView.34
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.qg != null) {
                        BizWebView.this.qg.setTouchEventListener(nVar);
                    }
                }
            });
        }
    }

    @Override // com.byazt.uad.q
    public void n(String str, String str2, Object obj) {
        if (this.qg != null) {
            this.qg.n(str, str2, obj);
        }
    }

    private void qg(Runnable runnable) {
        rv.qg().post(runnable);
    }
}
