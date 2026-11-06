package com.bytedance.sdk.openadsdk.core.widget.ms;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.hi;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.hi.ah.x;
import com.bytedance.sdk.openadsdk.core.hi.ka;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.lm;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.jw.t;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ab;
import com.bytedance.sdk.openadsdk.core.nw.cv;
import com.bytedance.sdk.openadsdk.core.nw.p;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.zb.c;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class d extends WebViewClient implements SSWebView.ah {
    private static final HashSet<String> hi;
    protected final Context ah;
    protected final String d;
    protected com.bytedance.sdk.openadsdk.core.zb.d ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.sl.d f3729ms;
    protected final pc xr;
    protected boolean c = true;
    protected boolean ab = true;
    protected volatile AtomicInteger x = new AtomicInteger(0);
    private long ny = -1;
    private boolean ch = false;

    public d(Context context, pc pcVar, String str) {
        this.ah = context;
        this.xr = pcVar;
        this.d = str;
    }

    public d(Context context, pc pcVar, String str, com.bytedance.sdk.openadsdk.core.zb.d dVar) {
        this.ah = context;
        this.xr = pcVar;
        this.d = str;
        this.ka = dVar;
    }

    public d(Context context, pc pcVar, String str, com.bytedance.sdk.openadsdk.core.zb.d dVar, com.bytedance.sdk.openadsdk.sl.d dVar2) {
        this.ah = context;
        this.xr = pcVar;
        this.d = str;
        this.ka = dVar;
        this.f3729ms = dVar2;
    }

    private boolean ms(Uri uri) {
        File fileXr = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(re.getContext());
        if (uri == null) {
            return false;
        }
        try {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment == null) {
                return false;
            }
            File canonicalFile = new File(fileXr, lastPathSegment).getCanonicalFile();
            return canonicalFile.exists() && !canonicalFile.getPath().startsWith(fileXr.toString());
        } catch (Exception e) {
            sl.ms(e);
            return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null && ms(webResourceRequest.getUrl())) {
            return null;
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
        if (this.f3729ms != null) {
            webResourceResponseShouldInterceptRequest = this.f3729ms.ms(webView, new com.bytedance.sdk.openadsdk.sl.xr(webResourceRequest, null), webResourceResponseShouldInterceptRequest);
        }
        if (ms(webView, webResourceRequest)) {
            return new WebResourceResponse("", "", null);
        }
        List<cv.ah> listMs = lm.ms().ms(webResourceRequest.getUrl().toString());
        if (listMs == null || listMs.isEmpty()) {
            return webResourceResponseShouldInterceptRequest;
        }
        lm lmVarMs = lm.ms();
        String string = webResourceRequest.getUrl().toString();
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.ka;
        return lmVarMs.ms(webResourceResponseShouldInterceptRequest, string, listMs, dVar != null ? dVar.x() : null);
    }

    protected boolean ms(WebView webView, WebResourceRequest webResourceRequest) {
        return p.ms(webView, this.x, this.xr, webResourceRequest, false, xr()) && !(this instanceof ab);
    }

    public boolean ms(WebView webView, String str) {
        return p.ms(webView, this.x, this.xr, str, false, xr()) && !(this instanceof ab);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str != null && ms(Uri.parse(str))) {
            return null;
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, str);
        if (this.f3729ms != null) {
            webResourceResponseShouldInterceptRequest = this.f3729ms.ms(webView, new com.bytedance.sdk.openadsdk.sl.xr(null, str), webResourceResponseShouldInterceptRequest);
        }
        if (ms(webView, str)) {
            return new WebResourceResponse("", "", null);
        }
        List<cv.ah> listMs = lm.ms().ms(str);
        if (listMs == null || listMs.isEmpty()) {
            return webResourceResponseShouldInterceptRequest;
        }
        lm lmVarMs = lm.ms();
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.ka;
        return lmVarMs.ms(webResourceResponseShouldInterceptRequest, str, listMs, dVar != null ? dVar.x() : null);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    private void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ((str.contains("weixin://wap/pay") || str.contains("weixin://dl/business/?ticket")) || str.contains("alipays://platformapi/startapp?appId")) {
            com.bytedance.sdk.openadsdk.core.zb.ah.ah(this.xr.x(), "landingpage", "lp_pay");
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        pc pcVar;
        ms(str);
        try {
            if (ms(webView, str)) {
                return true;
            }
            com.bytedance.sdk.openadsdk.sl.d dVar = this.f3729ms;
            if (dVar != null) {
                dVar.ms(webView, str);
            }
            Uri uri = Uri.parse(str);
            String lowerCase = uri.getScheme().toLowerCase();
            if ("bytedance".equals(lowerCase)) {
                t.ms(uri, this.xr);
                return true;
            }
            if (ch.ub().ul() != null) {
                boolean zMs = false;
                if (((Boolean) ch.ub().ul().call(15, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms("uri", uri)).xr(), Boolean.class)).booleanValue()) {
                    pc pcVar2 = this.xr;
                    if (pcVar2 != null && pcVar2.x() != null) {
                        if (com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(str)) {
                            com.bytedance.sdk.openadsdk.core.nw.lm lmVarX = this.xr.x();
                            com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarXr = ka.xr(this.ah, lmVarX, this.xr.w(), true);
                            if (ahVarXr instanceof x) {
                                ((x) ahVarXr).ah(true);
                            }
                            ahVarXr.ms(lmVarX, false);
                            zMs = true;
                        } else if (ka.ms()) {
                            zMs = com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(uri, this.xr.x(), this.ah, this.xr.w(), hashCode());
                        } else {
                            zMs = com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(uri, this.xr.x(), this.ah, this.xr.w());
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.xr.ms().ms("is_landing_page_open_market", true);
                    if (zMs) {
                        return true;
                    }
                }
            }
            if (!u.ms(str) && (pcVar = this.xr) != null && pcVar.x() != null) {
                final String strW = this.xr.w();
                final com.bytedance.sdk.openadsdk.core.nw.lm lmVarX2 = this.xr.x();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
                com.bytedance.sdk.openadsdk.core.zb.ah.xr(lmVarX2, strW, "lp_open_dpl", lowerCase);
                if (f.xr(this.ah)) {
                    if (f.ms(this.ah, intent)) {
                        com.bytedance.sdk.component.utils.xr.ms(this.ah, intent, new com.bytedance.sdk.component.utils.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.widget.ms.d.1
                            @Override // com.bytedance.sdk.component.utils.xr.ms
                            public void ms() {
                                com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVarX2, strW, "lp_openurl", (Throwable) null);
                                com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVarX2, strW, "lp_deeplink_success_realtime", (Throwable) null);
                            }

                            @Override // com.bytedance.sdk.component.utils.xr.ms
                            public void ms(Throwable th) {
                                com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVarX2, strW, "lp_openurl_failed", th);
                                com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVarX2, strW, "lp_deeplink_fail_realtime", th);
                            }
                        }, TextUtils.equals("main", UMModuleRegister.INNER));
                        c.ms().ms(lmVarX2, strW, true);
                    } else {
                        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVarX2, strW, "lp_openurl_failed", (Throwable) null);
                        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVarX2, strW, "lp_deeplink_fail_realtime", (Throwable) null);
                    }
                } else {
                    try {
                        ms(this.ah, intent);
                        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVarX2, strW, "lp_openurl", (Throwable) null);
                        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVarX2, strW, "lp_deeplink_success_realtime", (Throwable) null);
                        c.ms().ms(lmVarX2, strW, true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVarX2, strW, "lp_openurl_failed", th);
                        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVarX2, strW, "lp_deeplink_fail_realtime", th);
                    }
                }
                return true;
            }
        } catch (Exception e) {
            sl.xr("WebChromeClient", "shouldOverrideUrlLoading", e);
            pc pcVar3 = this.xr;
            if (pcVar3 != null && pcVar3.ny()) {
                return true;
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    private void ms(Context context, Intent intent) {
        if (intent != null) {
            try {
                ComponentName componentNameResolveActivity = intent.resolveActivity(context.getPackageManager());
                if ((componentNameResolveActivity == null || !componentNameResolveActivity.getPackageName().equals(context.getPackageName())) && (intent.getFlags() & MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO) == 0) {
                    com.bytedance.sdk.component.utils.xr.ms(context, intent, null, TextUtils.equals("main", UMModuleRegister.INNER));
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.ka;
        if (dVar != null) {
            dVar.ms(webView);
        }
        if (webView != null && this.c) {
            try {
                String strMs = xr.ms(re.xr().ul(), this.d);
                if (!TextUtils.isEmpty(strMs)) {
                    hi.ms(webView, strMs);
                }
            } catch (Throwable unused) {
            }
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.ka;
        if (dVar != null) {
            dVar.ms(webView, str, bitmap);
        }
        if (this.ab) {
            xr.ms(this.ah).ms(true).ms(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.ka;
        if (dVar != null) {
            dVar.ms(i, str, str2, xr(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.ka == null || webResourceError == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey("Accept")) {
            str = requestHeaders.get("Accept");
        } else if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        this.ka.ms(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), string, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.ka == null || webResourceResponse == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey("Accept")) {
            str = requestHeaders.get("Accept");
        } else if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        this.ka.ms(webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), string, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.ka != null) {
            int primaryError = 0;
            String str = "SslError: unknown";
            String url = null;
            if (sslError != null) {
                try {
                    primaryError = sslError.getPrimaryError();
                    str = "SslError: " + String.valueOf(sslError);
                    url = sslError.getUrl();
                } catch (Throwable unused2) {
                }
            }
            this.ka.ms(primaryError, str, url, xr(url));
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        hi = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add("gif");
        hashSet.add("svg");
        hashSet.add("jpeg");
    }

    private static String xr(String str) {
        int iLastIndexOf;
        String strSubstring;
        if (str == null || (iLastIndexOf = str.lastIndexOf(46)) < 0 || iLastIndexOf == str.length() - 1 || (strSubstring = str.substring(iLastIndexOf)) == null || !hi.contains(strSubstring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/" + strSubstring;
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (!renderProcessGoneDetail.didCrash()) {
            sl.d("WebChromeClient", "System killed the WebView rendering process to reclaim memory. Recreating...");
            if (webView != null) {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                webView.destroy();
                com.bytedance.sdk.component.adexpress.ka.ka.ms().xr();
            }
            return true;
        }
        sl.d("WebChromeClient", "The WebView rendering process crashed!");
        if (webView != null) {
            ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(webView);
            }
            webView.destroy();
            com.bytedance.sdk.component.adexpress.ka.ka.ms().xr();
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView.ah
    public void ms(boolean z) {
        pc pcVar = this.xr;
        if (pcVar != null) {
            pcVar.ah(z);
        }
    }

    public boolean xr() {
        return System.currentTimeMillis() - this.ny < 1000;
    }

    public void xr(boolean z) {
        if (!z || this.ch) {
            this.ny = System.currentTimeMillis();
        }
    }

    public void ah() {
        this.ch = true;
    }
}
