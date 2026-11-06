package com.byazt.wq;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.byazt.gjp.l;
import com.byazt.kfh.SSWebView;
import com.byazt.nf.rv;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1099, 2018})
public class EcBackUpWebView extends SSWebView {
    public EcBackUpWebView(Context context) {
        super(context);
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.wq.EcBackUpWebView.1
            @Override // java.lang.Runnable
            public void run() {
                EcBackUpWebView.this.w();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        setWebViewClient(new WebViewClient() { // from class: com.byazt.wq.EcBackUpWebView.2
            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (Build.VERSION.SDK_INT < 26) {
                    return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                if (renderProcessGoneDetail.didCrash()) {
                    if (webView != null) {
                        ViewGroup viewGroup = (ViewGroup) webView.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView);
                        }
                        webView.destroy();
                        l.n().qg();
                    }
                    return true;
                }
                if (webView != null) {
                    ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(webView);
                    }
                    webView.destroy();
                    l.n().qg();
                }
                return true;
            }
        });
        setWebChromeClient(new WebChromeClient());
        com.byazt.pnm.qg qgVarYv = rv.qg().yv();
        if (qgVarYv != null) {
            String strQ = qgVarYv.q();
            if (!TextUtils.isEmpty(strQ)) {
                loadUrl(com.byazt.lq.l.s(strQ));
                return;
            }
        }
        loadUrl(com.byazt.lq.l.s("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/pattern-aggregation/pattern-aggregation-eCommerce-abtest/shoppingMall-defaultPage/index.html"));
    }

    @Override // com.byazt.kfh.SSWebView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        super.destroy();
    }
}
