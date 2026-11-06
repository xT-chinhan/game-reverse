package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.xr.u;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.d.ka;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.hi.ah.ub;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.core.zb.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms {
    private double cv;
    private double g;
    private double le;
    private double of;
    private final com.bytedance.sdk.openadsdk.core.qv.xr op;
    private String p;
    private boolean pc;
    private final Map<String, Bitmap> w;
    private final com.bytedance.sdk.openadsdk.ch.ms yu;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public String i() {
        return "endcard";
    }

    public xr(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, String str, int i, int i2, boolean z, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, lmVar, str, i, i2, z);
        this.w = new HashMap();
        this.yu = new com.bytedance.sdk.openadsdk.ch.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr.1
            @Override // com.bytedance.sdk.openadsdk.ch.ms
            public void ms() {
                xr.this.f2177ms.x(1);
            }
        };
        this.op = new com.bytedance.sdk.openadsdk.core.qv.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr.2
            @Override // com.bytedance.sdk.openadsdk.core.qv.xr
            public void ms(boolean z2, int i3, String str2) {
                if (z2) {
                    xr.this.ao = true;
                    if (xr.this.pc) {
                        xr xrVar = xr.this;
                        xrVar.ms(xrVar.le, xr.this.cv, xr.this.g, xr.this.of, xr.this.p);
                        xr.this.pc = false;
                    }
                }
                if (qr.ch(xr.this.xr)) {
                    xr.this.ms(z2, i3, str2);
                }
            }
        };
        this.ab = abstractEndCardFrameLayout.getEndCardWebView();
        ms();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void ms(boolean z, Map<String, Object> map, View view) {
        String str;
        if (this.ab == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        this.ny = new x(this.ah, this.xr, jSONObject);
        this.ny.ms(jSONObject, "webview_source", (Object) 2);
        this.sl = new com.bytedance.sdk.openadsdk.core.zb.d(this.xr, this.ab).xr(true);
        this.sl.ms(true);
        cv();
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.sl;
        if (op()) {
            str = "landingpage_endcard";
        } else {
            str = z ? "reward_endcard" : "fullscreen_endcard";
        }
        dVar.ms(str);
        this.x = new pc(this.f2177ms);
        this.x.xr(this.ab).ms(this.xr).xr(this.xr.df()).ah(this.xr.lx()).ah(z ? 7 : 5).ms(this.re).d(f.ao(this.xr)).ms(this.ab).xr(ub.ms(this.xr)).ms(this.ny).ms(this.ah).ms(map).ms(this.i).ms(view).ms(this.yu);
        this.x.ms(this.op);
    }

    private void cv() {
        this.ch = qr.x(this.xr);
        float fLd = this.xr.ld();
        if (TextUtils.isEmpty(this.ch)) {
            return;
        }
        if (this.y == 1) {
            if (this.ch.contains("?")) {
                this.ch += "&orientation=portrait";
            } else {
                this.ch += "?orientation=portrait";
            }
        }
        if (this.ch.contains("?")) {
            this.ch += "&height=" + this.nw + "&width=" + this.t + "&aspect_ratio=" + fLd;
        } else {
            this.ch += "?height=" + this.nw + "&width=" + this.t + "&aspect_ratio=" + fLd;
        }
        this.ch = com.bytedance.sdk.openadsdk.core.component.reward.ka.ms.ms(this.ch);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void ms(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.xr.xr xrVar) {
        if (this.ab == null) {
            return;
        }
        this.hi = new com.bytedance.sdk.openadsdk.core.widget.ms.d(this.f2177ms, this.x, this.xr.df(), this.sl) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr.3
            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse webResourceResponseMs = xr.this.ms(str);
                return webResourceResponseMs != null ? webResourceResponseMs : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    if (xr.this.xr != null) {
                        WebResourceResponse webResourceResponseMs = xr.this.ms(string);
                        if (webResourceResponseMs != null) {
                            return webResourceResponseMs;
                        }
                        if (TextUtils.isEmpty(xr.this.xr.so())) {
                            return super.shouldInterceptRequest(webView, string);
                        }
                        xr.this.ka++;
                        return super.shouldInterceptRequest(webView, string);
                    }
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable th) {
                    sl.ah("CommonEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                xr.this.h.set(false);
                xr.this.qv = this.x;
                xr.this.zb = i;
                xr.this.u = str;
                if (xr.this.ny != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", i);
                        jSONObject.put("msg", str);
                        xr.this.ny.xr(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    xr.this.h.set(false);
                    xr.this.qv = this.x;
                }
                if (xr.this.ny != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceError.getErrorCode());
                        jSONObject.put("msg", webResourceError.getDescription());
                        xr.this.ny.xr(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                xr.this.zb = webResourceError.getErrorCode();
                xr.this.u = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (xr.this.ny != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                        xr.this.ny.xr(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (xr.this.ch.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        xr.this.h.set(false);
                        xr.this.qv = this.x;
                    }
                    if (webResourceResponse != null) {
                        xr.this.zb = webResourceResponse.getStatusCode();
                        xr.this.u = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (xr.this.ny != null) {
                    xr.this.ny.ab();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (xr.this.ny != null) {
                    xr.this.ny.c();
                }
                super.onPageStarted(webView, str, bitmap);
            }
        };
        this.ab.setWebViewClient(this.hi);
        ms(this.ab);
        this.ab.setBackgroundColor(-1);
        this.ab.setDisplayZoomControls(false);
        this.ab.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.ms.ah(this.x, this.sl) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.ah, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        this.ab.setDownloadListener(downloadListener);
    }

    protected boolean op() {
        if (this.ch == null) {
            return false;
        }
        try {
            return Uri.parse(this.ch).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void le() {
        if (this.ub || this.ab == null || this.ab.getWebView() == null) {
            return;
        }
        this.ab.loadUrl(this.ch);
        this.ub = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void ms(int i) {
        super.ms(i);
        ms(true);
        ah(true);
        ms(false, true);
    }

    public void ms(double d, double d2, double d3, double d4, String str) {
        if (this.x == null || this.f2177ms.isFinishing()) {
            return;
        }
        if (!this.ao) {
            this.le = d;
            this.cv = d2;
            this.of = d4;
            this.g = d3;
            this.p = str;
            this.pc = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d);
            jSONObject.put("y", d2);
            jSONObject.put("width", d3);
            jSONObject.put("height", d4);
            jSONObject.put("videoFrameKey", str);
            this.x.ms("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void ms(u uVar) {
        double dX;
        double dNy;
        double d;
        double dAb;
        if (qf.i(this.xr)) {
            double d2 = this.t;
            double d3 = this.nw;
            if (uVar == null || !this.f2177ms.sa().ab() || (uVar.x() == 0.0d && uVar.ny() == 0.0d)) {
                dX = d2;
                dNy = d3;
                d = 0.0d;
                dAb = 0.0d;
            } else {
                double dC = uVar.c();
                d = dC;
                dAb = uVar.ab();
                dX = uVar.x();
                dNy = uVar.ny();
            }
            ms(d, dAb, dX, dNy, null);
            if (this.f2177ms.sa() instanceof ka) {
                return;
            }
            final double d4 = d;
            final double d5 = dAb;
            final double d6 = dX;
            final double d7 = dNy;
            com.bykv.vk.openvk.component.video.ms.ka.xr.ms(2147483647L, qr.ms(this.xr), new com.bykv.vk.openvk.component.video.ms.ka.xr.InterfaceC0181xr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr.5
                @Override // com.bykv.vk.openvk.component.video.ms.ka.xr.InterfaceC0181xr
                public void ms(Bitmap bitmap) {
                    if (bitmap != null) {
                        String strValueOf = String.valueOf(bitmap.hashCode());
                        xr.this.w.put(strValueOf, bitmap);
                        xr.this.ms(d4, d5, d6, d7, strValueOf);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse ms(String str) {
        if (!str.startsWith("csjclientimg://")) {
            return null;
        }
        Bitmap bitmap = this.w.get(str.replace("csjclientimg://", ""));
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms
    public void ub() {
        super.ub();
        this.w.clear();
    }
}
