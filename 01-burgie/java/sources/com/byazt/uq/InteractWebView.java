package com.byazt.uq;

import android.R;
import android.content.Context;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.byazt.ca.ho;
import com.byazt.ch.g;
import com.byazt.fj.SSWebView;
import com.byazt.hg.of;
import com.byazt.sd.iu;
import com.byazt.sd.nl;
import com.byazt.wt.cz;
import com.byazt.wt.ls;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 209, 1675})
public class InteractWebView extends SSWebView {
    public g aj;
    public Context c;
    public Map<String, Object> fw;
    public nl uc;
    public of zo;

    public InteractWebView(Context context) {
        super(context);
        this.c = context;
    }

    public void setUGenExtraMap(Map<String, Object> map) {
        this.fw = map;
    }

    public void setUGenContext(g gVar) {
        this.aj = gVar;
    }

    public g getUGenContext() {
        return this.aj;
    }

    public void uc() {
        Map<String, Object> map = this.fw;
        if (map != null && map.size() > 0 && this.fw.containsKey("key_material")) {
            Object obj = this.fw.get("key_material");
            if (obj instanceof of) {
                this.zo = (of) obj;
                this.uc = (nl) this.fw.get("key_js_object");
                if (this.fw.containsKey("key_data_list") && (this.fw.get("key_data_list") instanceof List)) {
                    this.uc.hw((List<JSONObject>) this.fw.get("key_data_list"));
                }
                this.uc.hw(this).pr(this.zo).pr(ls.hw(this.zo)).hw(this.zo.x()).x(this.zo.B_()).c(ls.a(this.zo)).pr((SSWebView) this);
            }
        }
    }

    public void fw() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        pr((SSWebView) this);
        if (this.zo != null) {
            Context context = this.c;
            nl nlVar = this.uc;
            of ofVar = this.zo;
            setWebViewClient(new pr(context, nlVar, ofVar, ofVar.x()));
        } else {
            setWebViewClient(new SSWebView.pr());
        }
        if (Build.VERSION.SDK_INT >= 17) {
            com.byazt.kq.c.pr().pr(this, this.uc);
        }
        setWebChromeClient(new com.byazt.lz.hn(this.uc));
    }

    @Override // com.byazt.fj.SSWebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    private void pr(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.byazt.lz.hw.pr(this.c).pr(false).pr(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            cz.pr(sSWebView, iu.x, of.c(this.zo));
            if (Build.VERSION.SDK_INT >= 21) {
                sSWebView.setMixedContentMode(0);
            }
            sSWebView.setJavaScriptEnabled(true);
            sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.setDomStorageEnabled(true);
            sSWebView.setDatabaseEnabled(true);
            sSWebView.setAppCacheEnabled(true);
            sSWebView.setAllowFileAccess(false);
            sSWebView.setSupportZoom(true);
            sSWebView.setBuiltInZoomControls(true);
            sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            sSWebView.setUseWideViewPort(true);
        } catch (Exception e) {
            ho.hw("InteractWebView", e.toString());
        }
    }

    @Override // com.byazt.su.BizWebView, com.byazt.son.x
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 209, 689})
    public static class pr extends com.byazt.lz.x {
        public of pr;

        public pr(Context context, nl nlVar, of ofVar, String str) {
            super(context, nlVar, str);
            this.pr = ofVar;
        }

        @Override // com.byazt.lz.x, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.byazt.ce.pr prVarPr = com.byazt.hc.pr.pr(webView, this.pr, str, new com.byazt.hc.pr.InterfaceC0083pr() { // from class: com.byazt.uq.InteractWebView.pr.1
                    @Override // com.byazt.hc.pr.InterfaceC0083pr
                    public com.byazt.ce.pr pr(String str2, com.byazt.js.vk.pr prVar, String str3) {
                        com.byazt.ce.pr prVar2 = new com.byazt.ce.pr();
                        prVar2.pr(5);
                        prVar2.pr(com.byazt.hn.hw.hw().pr(webView, prVar, str2));
                        return prVar2;
                    }

                    @Override // com.byazt.hc.pr.InterfaceC0083pr
                    public boolean pr() {
                        return false;
                    }
                });
                if (prVarPr != null && prVarPr.pr() != null) {
                    return prVarPr.pr();
                }
            } catch (Throwable th) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // com.byazt.lz.x, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                ho.pr("InteractWebView", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }
}
