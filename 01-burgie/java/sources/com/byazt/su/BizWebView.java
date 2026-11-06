package com.byazt.su;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.byazt.ca.aj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 2096})
public class BizWebView extends MultiWebview implements com.byazt.son.x {
    public BizWebView(Context context) {
        super(context);
    }

    @Override // com.byazt.su.MultiWebview
    public void S_() {
        super.S_();
    }

    @Override // com.byazt.son.x
    public void setNetworkAvailable(final boolean z) {
        if (this.hw != null) {
            this.hw.setNetworkAvailable(z);
        } else if (this.pr != null && this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setNetworkAvailable(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void loadUrl(final String str) {
        if (this.hw != null) {
            this.hw.loadUrl(str);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.22
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.loadUrl(str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public boolean canGoBack() {
        if (this.hw != null) {
            if (this.hw.canGoBack()) {
                return true;
            }
            return getWebViewCount() > 1 && pr() != null;
        }
        return false;
    }

    @Override // com.byazt.son.x
    public void goBack() {
        if (this.hw != null) {
            this.hw.goBack();
        }
    }

    @Override // com.byazt.son.x
    public String getUrl() {
        if (this.hw != null) {
            return this.hw.getUrl();
        }
        return "";
    }

    @Override // com.byazt.son.x
    public int getProgress() {
        if (this.hw != null) {
            return this.hw.getProgress();
        }
        return 0;
    }

    @Override // com.byazt.son.x
    public int getContentHeight() {
        if (this.hw != null) {
            return this.hw.getContentHeight();
        }
        return 0;
    }

    @Override // com.byazt.son.x
    public String getUserAgentString() {
        if (this.hw != null) {
            return this.hw.getUserAgentString();
        }
        return "";
    }

    @Override // com.byazt.son.x
    public void setUserAgentString(final String str) {
        if (this.hw != null) {
            this.hw.setUserAgentString(str);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.35
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setUserAgentString(str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void onResume() {
        if (this.hw != null) {
            this.hw.onResume();
        }
    }

    @Override // com.byazt.son.x
    public void clearCache(boolean z) {
        if (this.hw != null) {
            this.hw.clearCache(z);
        }
    }

    public void setWebViewClient(final WebViewClient webViewClient) {
        if (this.hw != null) {
            this.hw.setWebViewClient(webViewClient);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.36
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setWebViewClient(webViewClient);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setDownloadListener(final DownloadListener downloadListener) {
        if (this.hw != null) {
            this.hw.setDownloadListener(downloadListener);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.37
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setDownloadListener(downloadListener);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        if (this.hw != null) {
            this.hw.setWebChromeClient(webChromeClient);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setWebChromeClient(webChromeClient);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void addJavascriptInterface(final Object obj, final String str) {
        if (this.hw != null) {
            this.hw.addJavascriptInterface(obj, str);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.addJavascriptInterface(obj, str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setJavaScriptEnabled(final boolean z) {
        if (this.hw != null) {
            this.hw.setJavaScriptEnabled(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setJavaScriptEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setDisplayZoomControls(final boolean z) {
        if (this.hw != null) {
            this.hw.setDisplayZoomControls(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setDisplayZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setCacheMode(final int i) {
        if (this.hw != null) {
            this.hw.setCacheMode(i);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setCacheMode(i);
                    }
                }
            });
        }
    }

    public void onPause() {
        if (this.hw != null) {
            this.hw.onPause();
        }
    }

    @Override // com.byazt.son.x
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        if (this.hw != null) {
            this.hw.evaluateJavascript(str, valueCallback);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.evaluateJavascript(str, valueCallback);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public WebView getWebView() {
        if (this.hw != null) {
            return this.hw.getWebView();
        }
        if (c()) {
            return null;
        }
        long j = 500;
        while (this.pr.get() < 3 && j > 0) {
            try {
                Thread.sleep(10L);
                j -= 10;
            } catch (Exception e) {
            }
        }
        if (this.hw != null) {
            return this.hw.getWebView();
        }
        return null;
    }

    @Override // com.byazt.son.x
    public View getView() {
        return this;
    }

    @Override // com.byazt.su.MultiWebview, com.byazt.son.x
    public void destroy() {
        super.destroy();
    }

    @Override // com.byazt.son.x
    public void removeJavascriptInterface(String str) {
        com.byazt.son.x xVar = this.hw;
        if (xVar != null) {
            xVar.removeJavascriptInterface(str);
        }
    }

    @Override // com.byazt.son.x
    public void setAppCacheEnabled(final boolean z) {
        if (this.hw != null) {
            this.hw.setAppCacheEnabled(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.8
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setAppCacheEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setSupportZoom(final boolean z) {
        if (this.hw != null) {
            this.hw.setSupportZoom(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setSupportZoom(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setUseWideViewPort(final boolean z) {
        if (this.hw != null) {
            this.hw.setUseWideViewPort(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.10
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setUseWideViewPort(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z) {
        if (this.hw != null) {
            this.hw.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.11
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setJavaScriptCanOpenWindowsAutomatically(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setDomStorageEnabled(final boolean z) {
        if (this.hw != null) {
            this.hw.setDomStorageEnabled(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.12
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setDomStorageEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setBuiltInZoomControls(final boolean z) {
        if (this.hw != null) {
            this.hw.setBuiltInZoomControls(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.13
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setBuiltInZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        if (this.hw != null) {
            this.hw.setLayoutAlgorithm(layoutAlgorithm);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.14
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setLayoutAlgorithm(layoutAlgorithm);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setLoadWithOverviewMode(final boolean z) {
        if (this.hw != null) {
            this.hw.setLoadWithOverviewMode(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.15
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setLoadWithOverviewMode(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setDefaultTextEncodingName(final String str) {
        if (this.hw != null) {
            this.hw.setDefaultTextEncodingName(str);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.16
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setDefaultTextEncodingName(str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setDefaultFontSize(final int i) {
        if (this.hw != null) {
            this.hw.setDefaultFontSize(i);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.17
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setDefaultFontSize(i);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setMixedContentMode(final int i) {
        if (this.hw != null) {
            this.hw.setMixedContentMode(i);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.18
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setMixedContentMode(i);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setDatabaseEnabled(final boolean z) {
        if (this.hw != null) {
            this.hw.setDatabaseEnabled(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.19
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setDatabaseEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setAllowFileAccess(final boolean z) {
        if (this.hw != null) {
            this.hw.setAllowFileAccess(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.20
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setAllowFileAccess(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void clearView() {
        if (this.hw != null) {
            this.hw.clearView();
        }
    }

    @Override // com.byazt.son.x
    public void pauseTimers() {
        if (this.hw != null) {
            this.hw.pauseTimers();
        }
    }

    @Override // com.byazt.son.x
    public void resumeTimers() {
        if (this.hw != null) {
            this.hw.resumeTimers();
        }
    }

    @Override // com.byazt.son.x
    public void setBlockNetworkImage(final boolean z) {
        if (this.hw != null) {
            this.hw.setBlockNetworkImage(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.21
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setBlockNetworkImage(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setAllowFileAccessFromFileURLs(final boolean z) {
        if (this.hw != null) {
            this.hw.setAllowFileAccessFromFileURLs(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.23
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setAllowUniversalAccessFromFileURLs(final boolean z) {
        if (this.hw != null) {
            this.hw.setAllowUniversalAccessFromFileURLs(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.24
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setSavePassword(final boolean z) {
        if (this.hw != null) {
            this.hw.setSavePassword(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.25
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setSavePassword(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void setMediaPlaybackRequiresUserGesture(final boolean z) {
        if (this.hw != null) {
            this.hw.setMediaPlaybackRequiresUserGesture(z);
        } else if (this.pr.get() < 3) {
            hw(new Runnable() { // from class: com.byazt.su.BizWebView.26
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setMediaPlaybackRequiresUserGesture(z);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.son.x
    public void setBackgroundColor(final int i) {
        super.setBackgroundColor(i);
        if (this.hw != null) {
            this.hw.setBackgroundColor(i);
        } else if (this.pr != null && this.pr.get() < 3) {
            post(new Runnable() { // from class: com.byazt.su.BizWebView.27
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setBackgroundColor(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.son.x
    public void computeScroll() {
        if (this.hw != null) {
            this.hw.computeScroll();
        } else if (this.pr != null && this.pr.get() < 3) {
            post(new Runnable() { // from class: com.byazt.su.BizWebView.28
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.computeScroll();
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.son.x
    public void setLayerType(final int i, final Paint paint) {
        if (this.hw != null) {
            this.hw.setLayerType(i, paint);
        } else if (this.pr != null && this.pr.get() < 3) {
            post(new Runnable() { // from class: com.byazt.su.BizWebView.29
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setLayerType(i, paint);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.son.x
    public void setOverScrollMode(final int i) {
        super.setOverScrollMode(i);
        if (this.hw != null) {
            this.hw.setOverScrollMode(i);
        } else if (this.pr != null && this.pr.get() < 3) {
            post(new Runnable() { // from class: com.byazt.su.BizWebView.30
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setOverScrollMode(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.son.x
    public void setVisibility(final int i) {
        super.setVisibility(i);
        if (this.hw != null) {
            this.hw.setVisibility(i);
        } else if (this.pr != null && this.pr.get() < 3) {
            post(new Runnable() { // from class: com.byazt.su.BizWebView.31
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setVisibility(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.son.x
    public void setAlpha(final float f) {
        super.setAlpha(f);
        if (this.hw != null) {
            this.hw.setAlpha(f);
        } else if (this.pr != null && this.pr.get() < 3) {
            post(new Runnable() { // from class: com.byazt.su.BizWebView.32
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setAlpha(f);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.son.x
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        if (this.hw != null) {
            this.hw.setOnScrollChangeListener(onScrollChangeListener);
        } else if (this.pr != null && this.pr.get() < 3) {
            post(new Runnable() { // from class: com.byazt.su.BizWebView.33
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setOnScrollChangeListener(onScrollChangeListener);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.hn
    public void setTouchEventListener(final com.byazt.son.hn.pr prVar) {
        if (this.hw != null) {
            this.hw.setTouchEventListener(prVar);
        } else if (this.pr != null && this.pr.get() < 3) {
            post(new Runnable() { // from class: com.byazt.su.BizWebView.34
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hw != null) {
                        BizWebView.this.hw.setTouchEventListener(prVar);
                    }
                }
            });
        }
    }

    @Override // com.byazt.son.x
    public void pr(String str, String str2, Object obj) {
        if (this.hw != null) {
            this.hw.pr(str, str2, obj);
        }
    }

    private void hw(Runnable runnable) {
        aj.hw().post(runnable);
    }
}
