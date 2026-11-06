package com.byazt.eg;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.byazt.fj.SSWebView;
import com.byazt.kq.c;
import com.byazt.sd.a;
import com.byazt.wt.s;
import com.byazt.zp.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1609, 2175})
public class EcBackUpWebView extends SSWebView {
    public EcBackUpWebView(Context context) {
        super(context);
        zo.pr(new Runnable() { // from class: com.byazt.eg.EcBackUpWebView.1
            @Override // java.lang.Runnable
            public void run() {
                EcBackUpWebView.this.uc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc() {
        setWebViewClient(new WebViewClient() { // from class: com.byazt.eg.EcBackUpWebView.2
            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (Build.VERSION.SDK_INT < 26) {
                    return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                if (!renderProcessGoneDetail.didCrash()) {
                    if (webView != null) {
                        ViewGroup viewGroup = (ViewGroup) webView.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView);
                        }
                        webView.destroy();
                        c.pr().hw();
                    }
                    return true;
                }
                if (webView != null) {
                    ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(webView);
                    }
                    webView.destroy();
                    c.pr().hw();
                }
                return true;
            }
        });
        setWebChromeClient(new WebChromeClient());
        com.byazt.is.hw hwVarOc = a.hw().oc();
        if (hwVarOc != null) {
            String strX = hwVarOc.x();
            if (!TextUtils.isEmpty(strX)) {
                loadUrl(s.hn(strX));
                return;
            }
        }
        loadUrl(s.hn("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/pattern-aggregation/pattern-aggregation-eCommerce-abtest/shoppingMall-defaultPage/index.html"));
    }

    @Override // com.byazt.fj.SSWebView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        super.destroy();
    }
}
