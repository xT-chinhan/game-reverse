package com.byazt.yr;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bumptech.glide.load.Key;
import com.byazt.ca.ho;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.jn;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.mg.PluginConstants;
import com.byazt.mq.g;
import com.byazt.pj.zo;
import com.byazt.ri.c;
import com.byazt.sd.nl;
import com.byazt.wt.ls;
import com.byazt.wt.s;
import com.byazt.xz.AbstractEndCardFrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN, 13})
public class hw extends pr {
    public final com.byazt.oy.pr b;
    public double gz;
    public final com.byazt.ap.hw iu;
    public boolean n;
    public double nl;
    public double ve;
    public String ww;
    public double y;
    public final Map<String, Bitmap> z;

    public hw(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, String str, int i, int i2, boolean z, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, ofVar, str, i, i2, z);
        this.z = new HashMap();
        this.b = new com.byazt.oy.pr() { // from class: com.byazt.yr.hw.1
            @Override // com.byazt.oy.pr
            public void pr() {
                hw.this.pr.zo(1);
            }
        };
        this.iu = new com.byazt.ap.hw() { // from class: com.byazt.yr.hw.2
            @Override // com.byazt.ap.hw
            public void pr(boolean z2, int i3, String str2) {
                if (z2) {
                    hw.this.nt = true;
                    if (hw.this.n) {
                        hw hwVar = hw.this;
                        hwVar.pr(hwVar.ve, hw.this.gz, hw.this.nl, hw.this.y, hw.this.ww);
                        hw.this.n = false;
                    }
                }
                if (qv.w(hw.this.hw)) {
                    hw.this.pr(z2, i3, str2);
                }
                if (hw.this.fw != null) {
                    if (hw.this.fw.getVisibility() == 0) {
                        hw.this.zo.uc(true);
                        hw.this.pr(true);
                        hw.this.pr(false, true);
                    } else {
                        hw.this.zo.uc(false);
                        hw.this.pr(false);
                        hw.this.pr(true, false);
                    }
                }
            }
        };
        this.fw = abstractEndCardFrameLayout.getEndCardWebView();
        pr();
    }

    @Override // com.byazt.yr.pr
    public void pr(boolean z, Map<String, Object> map, View view) {
        String str;
        if (this.fw == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        this.aj = new zo(this.hn, this.hw, jSONObject, null);
        this.aj.pr(jSONObject, "webview_source", (Object) 2);
        this.k = new com.byazt.pj.hn(this.hw, this.fw).hw(true);
        this.k.pr(true);
        gz();
        com.byazt.pj.hn hnVar = this.k;
        if (iu()) {
            str = "landingpage_endcard";
        } else {
            str = z ? "reward_endcard" : "fullscreen_endcard";
        }
        hnVar.pr(str);
        this.zo = new nl(this.pr);
        this.zo.hw(this.fw).pr(this.hw).hw(this.hw.x()).x(this.hw.B_()).hn(z ? 7 : 5).pr(this.fo).c(ls.a(this.hw)).pr(this.fw).hw(c.pr(this.hw)).pr(this.aj).pr(this.hn).pr(map).pr(this.rc).pr(view).hn(this.pr.pr()).pr(this.b);
        this.zo.pr(this.iu);
    }

    private void gz() {
        float fOq = this.hw.oq();
        this.vk = qv.aj(this.hw);
        if (TextUtils.isEmpty(this.vk)) {
            return;
        }
        this.vk = this.vk.trim();
        Uri.Builder builderBuildUpon = Uri.parse(this.vk).buildUpon();
        if (this.qa == 1) {
            builderBuildUpon.appendQueryParameter("orientation", "portrait");
        }
        this.vk = builderBuildUpon.appendQueryParameter("height", String.valueOf(this.cz)).appendQueryParameter("width", String.valueOf(this.a)).appendQueryParameter("aspect_ratio", String.valueOf(fOq)).toString();
        this.vk = com.byazt.hf.pr.pr(this.vk);
        this.vk = s.hn(this.vk);
    }

    @Override // com.byazt.yr.pr
    public void pr(DownloadListener downloadListener, com.byazt.az.hw hwVar) {
        if (this.fw == null) {
            return;
        }
        this.w = new com.byazt.lz.x(this.pr, this.zo, this.hw.x(), this.k) { // from class: com.byazt.yr.hw.3
            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse webResourceResponsePr = hw.this.pr(str);
                if (webResourceResponsePr != null) {
                    return webResourceResponsePr;
                }
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    if (hw.this.hw != null) {
                        WebResourceResponse webResourceResponsePr = hw.this.pr(string);
                        if (webResourceResponsePr != null) {
                            return webResourceResponsePr;
                        }
                        if (TextUtils.isEmpty(hw.this.hw.hn())) {
                            return super.shouldInterceptRequest(webView, string);
                        }
                        hw.this.c++;
                        return super.shouldInterceptRequest(webView, string);
                    }
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable th) {
                    ho.pr("CommonEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                hw.this.yb.set(false);
                hw.this.lb = this.zo;
                hw.this.m = i;
                hw.this.g = str;
                if (hw.this.aj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                        }
                        hw.this.aj.hw(jSONObject);
                    } catch (JSONException e) {
                    }
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    hw.this.yb.set(false);
                    hw.this.lb = this.zo;
                }
                if (hw.this.aj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put(PluginConstants.KEY_ERROR_CODE, webResourceError.getErrorCode());
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                        }
                        hw.this.aj.hw(jSONObject);
                    } catch (JSONException e) {
                    }
                }
                hw.this.m = webResourceError.getErrorCode();
                hw.this.g = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (hw.this.aj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 21) {
                            jSONObject.put(PluginConstants.KEY_ERROR_CODE, webResourceResponse.getStatusCode());
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                        }
                        hw.this.aj.hw(jSONObject);
                    } catch (JSONException e) {
                    }
                }
                if (hw.this.vk.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        hw.this.yb.set(false);
                        hw.this.lb = this.zo;
                    }
                    if (webResourceResponse != null) {
                        hw.this.m = webResourceResponse.getStatusCode();
                        hw.this.g = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (hw.this.aj != null) {
                    hw.this.aj.fw();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (hw.this.aj != null) {
                    hw.this.aj.uc();
                }
                super.onPageStarted(webView, str, bitmap);
            }
        };
        this.fw.setWebViewClient(this.w);
        pr(this.fw);
        this.fw.setBackgroundColor(-1);
        this.fw.setDisplayZoomControls(false);
        this.fw.setWebChromeClient(new com.byazt.lz.hn(this.zo, this.k) { // from class: com.byazt.yr.hw.4
            @Override // com.byazt.lz.hn, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        this.fw.setDownloadListener(downloadListener);
    }

    public boolean iu() {
        if (this.vk == null) {
            return false;
        }
        try {
            return Uri.parse(this.vk).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception e) {
            return false;
        }
    }

    public void ve() {
        if (!this.ho && this.fw != null && this.fw.getWebView() != null) {
            this.fw.loadUrl(this.vk);
            this.ho = true;
        }
    }

    @Override // com.byazt.yr.pr
    public String rc() {
        return "endcard";
    }

    @Override // com.byazt.yr.pr
    public void pr(int i) {
        super.pr(i);
        pr(true);
        hn(true);
        pr(false, true);
    }

    public void pr(double d, double d2, double d3, double d4, String str) {
        if (this.zo == null || this.pr.isFinishing()) {
            return;
        }
        if (!this.nt) {
            this.ve = d;
            this.gz = d2;
            this.y = d4;
            this.nl = d3;
            this.ww = str;
            this.n = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d);
            jSONObject.put("y", d2);
            jSONObject.put("width", d3);
            jSONObject.put("height", d4);
            jSONObject.put("videoFrameKey", str);
            this.zo.hw("endcardTransform", jSONObject);
        } catch (JSONException e) {
        }
    }

    public void pr(g gVar) {
        double dZo;
        double dAj;
        double d;
        double dFw;
        if (!jn.rc(this.hw)) {
            return;
        }
        double d2 = this.a;
        double d3 = this.cz;
        if (gVar != null && this.pr.bm().fw() && (gVar.zo() != 0.0d || gVar.aj() != 0.0d)) {
            double dUc = gVar.uc();
            d = dUc;
            dFw = gVar.fw();
            dZo = gVar.zo();
            dAj = gVar.aj();
        } else {
            dZo = d2;
            dAj = d3;
            d = 0.0d;
            dFw = 0.0d;
        }
        pr(d, dFw, dZo, dAj, null);
        if (this.pr.bm() instanceof com.byazt.lu.c) {
            return;
        }
        final double d4 = d;
        final double d5 = dFw;
        final double d6 = dZo;
        final double d7 = dAj;
        com.byazt.t.hw.pr(2147483647L, qv.pr(this.hw), new com.byazt.t.hw.InterfaceC0192hw() { // from class: com.byazt.yr.hw.5
            @Override // com.byazt.t.hw.InterfaceC0192hw
            public void pr(Bitmap bitmap) {
                if (bitmap != null) {
                    String strValueOf = String.valueOf(bitmap.hashCode());
                    hw.this.z.put(strValueOf, bitmap);
                    hw.this.pr(d4, d5, d6, d7, strValueOf);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse pr(String str) {
        if (str.startsWith("csjclientimg://")) {
            Bitmap bitmap = this.z.get(str.replace("csjclientimg://", ""));
            if (bitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                return new WebResourceResponse("text/html", Key.STRING_CHARSET_NAME, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            }
            return null;
        }
        return null;
    }

    @Override // com.byazt.yr.pr
    public void ho() {
        super.ho();
        this.z.clear();
    }
}
