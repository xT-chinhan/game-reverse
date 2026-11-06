package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.R;
import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.t;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.pc;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class InteractWebView extends SSWebView {
    private Map<String, Object> ab;
    private pc c;
    private Context ka;
    private com.bytedance.adsdk.ugeno.ah.hi ny;
    private lm x;

    public InteractWebView(Context context) {
        super(context);
        this.ka = context;
    }

    public void setUGenExtraMap(Map<String, Object> map) {
        this.ab = map;
    }

    public void setUGenContext(com.bytedance.adsdk.ugeno.ah.hi hiVar) {
        this.ny = hiVar;
    }

    public com.bytedance.adsdk.ugeno.ah.hi getUGenContext() {
        return this.ny;
    }

    public void c() {
        Map<String, Object> map = this.ab;
        if (map == null || map.size() <= 0 || !this.ab.containsKey("key_material")) {
            return;
        }
        Object obj = this.ab.get("key_material");
        if (obj instanceof lm) {
            this.x = (lm) obj;
            this.c = (pc) this.ab.get("key_js_object");
            if (this.ab.containsKey("key_data_list") && (this.ab.get("key_data_list") instanceof List)) {
                this.c.xr((List<JSONObject>) this.ab.get("key_data_list"));
            }
            this.c.xr(this).ms(this.x).ms(f.xr(this.x)).xr(this.x.df()).ah(this.x.lx()).d(f.ao(this.x)).ms((SSWebView) this);
        }
    }

    public void ab() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        ms((SSWebView) this);
        if (this.x != null) {
            Context context = this.ka;
            pc pcVar = this.c;
            lm lmVar = this.x;
            setWebViewClient(new ms(context, pcVar, lmVar, lmVar.df()));
        } else {
            setWebViewClient(new SSWebView.ms());
        }
        com.bytedance.sdk.component.adexpress.ka.ka.ms().ms(this, this.c);
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.ms.ah(this.c));
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    private void ms(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.ms.xr.ms(this.ka).ms(false).ms(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            t.ms(sSWebView, g.xr, lm.d(this.x));
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
            com.bytedance.sdk.component.utils.sl.d("InteractWebView", e.toString());
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.zb.ah
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    public static class ms extends com.bytedance.sdk.openadsdk.core.widget.ms.d {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private lm f3435ms;

        public ms(Context context, pc pcVar, lm lmVar, String str) {
            super(context, pcVar, str);
            this.f3435ms = lmVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.bytedance.sdk.component.adexpress.ms.xr.ms msVarMs = com.bytedance.sdk.openadsdk.core.nativeexpress.xr.ms.ms(webView, this.f3435ms, str, new com.bytedance.sdk.openadsdk.core.nativeexpress.xr.ms.InterfaceC0297ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.InteractWebView.ms.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr.ms.InterfaceC0297ms
                    public boolean ms() {
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr.ms.InterfaceC0297ms
                    public com.bytedance.sdk.component.adexpress.ms.xr.ms ms(String str2, com.bytedance.sdk.component.adexpress.d.ch.ms msVar, String str3) {
                        com.bytedance.sdk.component.adexpress.ms.xr.ms msVar2 = new com.bytedance.sdk.component.adexpress.ms.xr.ms();
                        msVar2.ms(5);
                        msVar2.ms(com.bytedance.sdk.openadsdk.core.ugeno.ka.ms.xr().ms(webView, msVar, str2));
                        return msVar2;
                    }
                });
                if (msVarMs != null && msVarMs.ms() != null) {
                    return msVarMs.ms();
                }
            } catch (Throwable unused) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.ah("InteractWebView", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }
}
