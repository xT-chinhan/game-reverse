package com.byazt.ki;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.byazt.af.x;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.cx;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.tk.k;
import com.byazt.udb.sz;
import com.byazt.uv.l;
import com.byazt.vgn.w;
import com.byazt.yyw.AbstractEndCardFrameLayout;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 715, 26})
public class qg extends n {
    public double bb;
    public final l h;
    public final Map<String, Bitmap> hu;
    public boolean j;
    public double lh;
    public double ln;
    public final com.byazt.uv.qg t;
    public double ur;
    public String v;

    @Override // com.byazt.ki.n
    public String m() {
        return "endcard";
    }

    public qg(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, String str, int i, int i2, boolean z, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, pkVar, str, i, i2, z);
        this.hu = new HashMap();
        this.h = new l() { // from class: com.byazt.ki.qg.1
            @Override // com.byazt.uv.l
            public void n() {
                qg.this.n.fs(1);
            }
        };
        this.t = new com.byazt.uv.qg() { // from class: com.byazt.ki.qg.2
            @Override // com.byazt.uv.qg
            public void n(boolean z2, int i3, String str2) {
                if (z2) {
                    qg.this.cy = true;
                    if (qg.this.j) {
                        qg qgVar = qg.this;
                        qgVar.n(qgVar.ur, qg.this.bb, qg.this.ln, qg.this.lh, qg.this.v);
                        qg.this.j = false;
                    }
                }
                if (ta.cp(qg.this.qg)) {
                    qg.this.n(z2, i3, str2);
                }
                if (qg.this.x != null) {
                    if (qg.this.x.getVisibility() == 0) {
                        qg.this.fs.w(true);
                        qg.this.n(true);
                        qg.this.n(false, true);
                    } else {
                        qg.this.fs.w(false);
                        qg.this.n(false);
                        qg.this.n(true, false);
                    }
                }
            }
        };
        this.x = abstractEndCardFrameLayout.getEndCardWebView();
        n();
    }

    @Override // com.byazt.ki.n
    public void n(boolean z, Map<String, Object> map, View view) {
        String str;
        if (this.x == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        this.rv = new w(this.s, this.qg, jSONObject, null);
        this.rv.n(jSONObject, "webview_source", (Object) 2);
        this.d = new com.byazt.hm.s(this.qg, this.x).qg(true);
        this.d.n(true);
        bb();
        com.byazt.hm.s sVar = this.d;
        if (t()) {
            str = "landingpage_endcard";
        } else {
            str = z ? "reward_endcard" : "fullscreen_endcard";
        }
        sVar.n(str);
        this.fs = new com.byazt.gcl.s(this.n);
        this.fs.qg(this.x).n(this.qg).qg(this.qg.q()).q(this.qg.F_()).s(z ? 7 : 5).n(this.wm).l(com.byazt.vgx.w.wm(this.qg)).n(this.x).qg(com.byazt.oh.l.n(this.qg)).n(this.rv).n(this.s).n(map).n(this.m).n(view).s(this.n.n()).n(this.h);
        this.fs.n(this.t);
    }

    private void bb() {
        float fSl = this.qg.sl();
        this.tj = ta.rv(this.qg);
        if (TextUtils.isEmpty(this.tj)) {
            return;
        }
        this.tj = this.tj.trim();
        Uri.Builder builderBuildUpon = Uri.parse(this.tj).buildUpon();
        if (this.um == 1) {
            builderBuildUpon.appendQueryParameter("orientation", "portrait");
        }
        this.tj = builderBuildUpon.appendQueryParameter("height", String.valueOf(this.py)).appendQueryParameter("width", String.valueOf(this.a)).appendQueryParameter("aspect_ratio", String.valueOf(fSl)).toString();
        this.tj = com.byazt.ce.n.n(this.tj);
        this.tj = com.byazt.lq.l.s(this.tj);
    }

    @Override // com.byazt.ki.n
    public void n(DownloadListener downloadListener, com.byazt.ys.qg qgVar) {
        if (this.x == null) {
            return;
        }
        this.cp = new com.byazt.dho.s(this.n, this.fs, this.qg.q(), this.d) { // from class: com.byazt.ki.qg.3
            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse webResourceResponseN = qg.this.n(str);
                return webResourceResponseN != null ? webResourceResponseN : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    if (qg.this.qg != null) {
                        WebResourceResponse webResourceResponseN = qg.this.n(string);
                        if (webResourceResponseN != null) {
                            return webResourceResponseN;
                        }
                        if (TextUtils.isEmpty(qg.this.qg.s())) {
                            return super.shouldInterceptRequest(webView, string);
                        }
                        qg.this.l++;
                        return super.shouldInterceptRequest(webView, string);
                    }
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable th) {
                    k.n("CommonEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                qg.this.hd.set(false);
                qg.this.cd = this.fs;
                qg.this.oa = i;
                qg.this.sz = str;
                if (qg.this.rv != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", i);
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                        qg.this.rv.q(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    qg.this.hd.set(false);
                    qg.this.cd = this.fs;
                }
                if (qg.this.rv != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceError.getErrorCode());
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                        qg.this.rv.q(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                qg.this.oa = webResourceError.getErrorCode();
                qg.this.sz = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (qg.this.rv != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                        qg.this.rv.q(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (qg.this.tj.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        qg.this.hd.set(false);
                        qg.this.cd = this.fs;
                    }
                    if (webResourceResponse != null) {
                        qg.this.oa = webResourceResponse.getStatusCode();
                        qg.this.sz = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (qg.this.rv != null) {
                    qg.this.rv.tj();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (qg.this.rv != null) {
                    qg.this.rv.rv();
                }
                super.onPageStarted(webView, str, bitmap);
            }
        };
        this.x.setWebViewClient(this.cp);
        n(this.x);
        this.x.setBackgroundColor(-1);
        this.x.setDisplayZoomControls(false);
        this.x.setWebChromeClient(new com.byazt.dho.qg(this.fs, this.d) { // from class: com.byazt.ki.qg.4
            @Override // com.byazt.dho.qg, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        this.x.setDownloadListener(downloadListener);
    }

    public boolean t() {
        if (this.tj == null) {
            return false;
        }
        try {
            return Uri.parse(this.tj).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void ur() {
        if (this.k || this.x == null || this.x.getWebView() == null) {
            return;
        }
        this.x.loadUrl(this.tj);
        this.k = true;
    }

    @Override // com.byazt.ki.n
    public void n(int i) {
        super.n(i);
        n(true);
        s(true);
        n(false, true);
    }

    public void n(double d, double d2, double d3, double d4, String str) {
        if (this.fs == null || this.n.isFinishing()) {
            return;
        }
        if (!this.cy) {
            this.ur = d;
            this.bb = d2;
            this.lh = d4;
            this.ln = d3;
            this.v = str;
            this.j = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(x.n, d);
            jSONObject.put("y", d2);
            jSONObject.put("width", d3);
            jSONObject.put("height", d4);
            jSONObject.put("videoFrameKey", str);
            this.fs.qg("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void n(sz szVar) {
        double dFs;
        double dRv;
        double d;
        double dX;
        if (cx.m(this.qg)) {
            double d2 = this.a;
            double d3 = this.py;
            if (szVar == null || !this.n.nf().x() || (szVar.fs() == 0.0d && szVar.rv() == 0.0d)) {
                dFs = d2;
                dRv = d3;
                d = 0.0d;
                dX = 0.0d;
            } else {
                double dW = szVar.w();
                d = dW;
                dX = szVar.x();
                dFs = szVar.fs();
                dRv = szVar.rv();
            }
            n(d, dX, dFs, dRv, null);
            if (this.n.nf() instanceof com.byazt.has.l) {
                return;
            }
            final double d4 = d;
            final double d5 = dX;
            final double d6 = dFs;
            final double d7 = dRv;
            com.byazt.udy.qg.n(2147483647L, ta.n(this.qg), new com.byazt.udy.qg.InterfaceC0363qg() { // from class: com.byazt.ki.qg.5
                @Override // com.byazt.udy.qg.InterfaceC0363qg
                public void n(Bitmap bitmap) {
                    if (bitmap != null) {
                        String strValueOf = String.valueOf(bitmap.hashCode());
                        qg.this.hu.put(strValueOf, bitmap);
                        qg.this.n(d4, d5, d6, d7, strValueOf);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse n(String str) {
        if (!str.startsWith("csjclientimg://")) {
            return null;
        }
        Bitmap bitmap = this.hu.get(str.replace("csjclientimg://", ""));
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }

    @Override // com.byazt.ki.n
    public void k() {
        super.k();
        this.hu.clear();
    }
}
