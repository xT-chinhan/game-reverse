package com.byazt.rg;

import android.R;
import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.byazt.gct.pk;
import com.byazt.kfh.SSWebView;
import com.byazt.tk.k;
import com.byazt.vh.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 1585})
public class InteractWebView extends SSWebView {
    public pk fs;
    public Context l;
    public sz rv;
    public com.byazt.gcl.s w;
    public Map<String, Object> x;

    public InteractWebView(Context context) {
        super(context);
        this.l = context;
    }

    public void setUGenExtraMap(Map<String, Object> map) {
        this.x = map;
    }

    public void setUGenContext(sz szVar) {
        this.rv = szVar;
    }

    public sz getUGenContext() {
        return this.rv;
    }

    public void w() {
        Map<String, Object> map = this.x;
        if (map == null || map.size() <= 0 || !this.x.containsKey("key_material")) {
            return;
        }
        Object obj = this.x.get("key_material");
        if (obj instanceof pk) {
            this.fs = (pk) obj;
            this.w = (com.byazt.gcl.s) this.x.get("key_js_object");
            if (this.x.containsKey("key_data_list") && (this.x.get("key_data_list") instanceof List)) {
                this.w.qg((List<JSONObject>) this.x.get("key_data_list"));
            }
            this.w.qg(this).n(this.fs).n(com.byazt.vgx.w.qg(this.fs)).qg(this.fs.q()).q(this.fs.F_()).l(com.byazt.vgx.w.wm(this.fs)).n((SSWebView) this);
        }
    }

    public void x() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        n((SSWebView) this);
        if (this.fs != null) {
            Context context = this.l;
            com.byazt.gcl.s sVar = this.w;
            pk pkVar = this.fs;
            setWebViewClient(new n(context, sVar, pkVar, pkVar.q()));
        } else {
            setWebViewClient(new SSWebView.n());
        }
        com.byazt.gjp.l.n().n(this, this.w);
        setWebChromeClient(new com.byazt.dho.qg(this.w));
    }

    @Override // com.byazt.kfh.SSWebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    private void n(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.byazt.dho.n.n(this.l).n(false).n(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            com.byazt.qq.n.n(sSWebView, com.byazt.nf.tj.l, pk.l(this.fs));
            sSWebView.setMixedContentMode(0);
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
            k.qg("InteractWebView", e.toString());
        }
    }

    @Override // com.byazt.qza.BizWebView, com.byazt.uad.q
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 1820})
    public static class n extends com.byazt.dho.s {
        public pk n;

        public n(Context context, com.byazt.gcl.s sVar, pk pkVar, String str) {
            super(context, sVar, str);
            this.n = pkVar;
        }

        @Override // com.byazt.dho.s, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.byazt.mzw.n nVarN = com.byazt.lu.n.n(webView, this.n, str, new com.byazt.lu.n.InterfaceC0242n() { // from class: com.byazt.rg.InteractWebView.n.1
                    @Override // com.byazt.lu.n.InterfaceC0242n
                    public boolean n() {
                        return false;
                    }

                    @Override // com.byazt.lu.n.InterfaceC0242n
                    public com.byazt.mzw.n n(String str2, com.byazt.cq.tj.n nVar, String str3) {
                        com.byazt.mzw.n nVar2 = new com.byazt.mzw.n();
                        nVar2.n(5);
                        nVar2.n(com.byazt.cr.qg.qg().n(webView, nVar, str2));
                        return nVar2;
                    }
                });
                if (nVarN != null && nVarN.n() != null) {
                    return nVarN.n();
                }
            } catch (Throwable unused) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // com.byazt.dho.s, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                k.n("InteractWebView", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }
}
