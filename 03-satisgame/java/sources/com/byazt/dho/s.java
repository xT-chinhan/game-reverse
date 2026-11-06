package com.byazt.dho;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.byakv.z.SoftDecTool;
import com.byazt.gct.ae;
import com.byazt.gct.ln;
import com.byazt.gct.pk;
import com.byazt.hm.l;
import com.byazt.kfh.SSWebView;
import com.byazt.lew.q;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.tk.hd;
import com.byazt.tk.k;
import com.byazt.tk.oa;
import com.byazt.tk.w;
import com.byazt.vf.x;
import com.byazt.za.fs;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1479, 8})
public class s extends WebViewClient implements SSWebView.s {
    public static final HashSet<String> cp;
    public com.byazt.hm.s l;
    public q n;
    public final String q;
    public final com.byazt.gcl.s qg;
    public final Context s;
    public boolean w = true;
    public boolean x = true;
    public volatile AtomicInteger fs = new AtomicInteger(0);
    public long rv = -1;
    public boolean tj = false;

    public s(Context context, com.byazt.gcl.s sVar, String str) {
        this.s = context;
        this.qg = sVar;
        this.q = str;
    }

    public s(Context context, com.byazt.gcl.s sVar, String str, com.byazt.hm.s sVar2) {
        this.s = context;
        this.qg = sVar;
        this.q = str;
        this.l = sVar2;
    }

    public s(Context context, com.byazt.gcl.s sVar, String str, com.byazt.hm.s sVar2, q qVar) {
        this.s = context;
        this.qg = sVar;
        this.q = str;
        this.l = sVar2;
        this.n = qVar;
    }

    private boolean n(Uri uri) {
        File fileQg = w.qg(rv.getContext(), false, null);
        if (uri != null) {
            try {
                String lastPathSegment = uri.getLastPathSegment();
                if (lastPathSegment != null) {
                    File canonicalFile = new File(fileQg, lastPathSegment).getCanonicalFile();
                    if (canonicalFile.exists() && !canonicalFile.getPath().startsWith(fileQg.toString())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null && n(webResourceRequest.getUrl())) {
            return null;
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
        if (this.n != null) {
            webResourceResponseShouldInterceptRequest = this.n.n(webView, new com.byazt.lew.qg(webResourceRequest, null), webResourceResponseShouldInterceptRequest);
        }
        if (n(webView, webResourceRequest)) {
            return new WebResourceResponse("", "", null);
        }
        Set<ln.s> setN = com.byazt.qq.s.n().n(webResourceRequest.getUrl().toString());
        if (setN == null || setN.isEmpty()) {
            return webResourceResponseShouldInterceptRequest;
        }
        com.byazt.qq.s sVarN = com.byazt.qq.s.n();
        String string = webResourceRequest.getUrl().toString();
        com.byazt.hm.s sVar = this.l;
        return sVarN.n(webResourceResponseShouldInterceptRequest, string, setN, sVar != null ? sVar.fs() : null);
    }

    public boolean n(WebView webView, WebResourceRequest webResourceRequest) {
        return ae.n(webView, this.fs, this.qg, webResourceRequest, false, qg()) && !(this instanceof fs);
    }

    public boolean n(WebView webView, String str) {
        return ae.n(webView, this.fs, this.qg, str, false, qg()) && !(this instanceof fs);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str != null && n(Uri.parse(str))) {
            return null;
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, str);
        if (this.n != null) {
            webResourceResponseShouldInterceptRequest = this.n.n(webView, new com.byazt.lew.qg(null, str), webResourceResponseShouldInterceptRequest);
        }
        if (n(webView, str)) {
            return new WebResourceResponse("", "", null);
        }
        Set<ln.s> setN = com.byazt.qq.s.n().n(str);
        if (setN == null || setN.isEmpty()) {
            return webResourceResponseShouldInterceptRequest;
        }
        com.byazt.qq.s sVarN = com.byazt.qq.s.n();
        com.byazt.hm.s sVar = this.l;
        return sVarN.n(webResourceResponseShouldInterceptRequest, str, setN, sVar != null ? sVar.fs() : null);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    private void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ((str.contains("weixin://wap/pay") || str.contains("weixin://dl/business/?ticket")) || str.contains("alipays://platformapi/startapp?appId")) {
            com.byazt.hm.n.s(this.qg.fs(), "landingpage", "lp_pay");
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.byazt.gcl.s sVar;
        n(str);
        try {
            if (n(webView, str)) {
                return true;
            }
            q qVar = this.n;
            if (qVar != null) {
                qVar.n(webView, str);
            }
            Uri uri = Uri.parse(str);
            String lowerCase = uri.getScheme().toLowerCase();
            if ("bytedance".equals(lowerCase)) {
                com.byazt.qq.n.n(uri, this.qg);
                return true;
            }
            if (com.byazt.vyf.s.cy().fi() != null && ((Boolean) com.byazt.vyf.s.cy().fi().apply(com.byazt.of.qg.n().n(15).n(Boolean.class).n(0, new com.byazt.ikv.s().n(ContentProviderManager.PROVIDER_URI, uri)).qg())).booleanValue()) {
                if (com.byazt.esa.s.n(str)) {
                    if (rv.qg().cs()) {
                        n(str, false);
                    } else {
                        n(str, true);
                        return true;
                    }
                }
                com.byazt.gcl.s sVar2 = this.qg;
                boolean zN = (sVar2 == null || sVar2.fs() == null) ? false : com.byazt.esa.s.n(uri, this.qg.fs(), this.s, this.qg.ur(), hashCode());
                com.byazt.ikv.n.n().n("is_landing_page_open_market", true);
                if (zN) {
                    return true;
                }
            }
            if (!hd.n(str) && (sVar = this.qg) != null && sVar.fs() != null) {
                String strUr = this.qg.ur();
                pk pkVarFs = this.qg.fs();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
                HashMap map = new HashMap();
                map.put("source", "TTWebViewClient");
                map.put("scheme", lowerCase);
                com.byazt.hm.n.n(pkVarFs, strUr, (Map<String, Object>) map, true);
                if (com.byazt.vgx.w.h()) {
                    if (com.byazt.vgx.w.n(intent)) {
                        n(this.s, intent, pkVarFs, strUr);
                    } else {
                        com.byazt.hm.n.n(pkVarFs, strUr, (Throwable) new RuntimeException("query is true,install is false"), true, false);
                    }
                } else {
                    try {
                        ComponentName componentNameResolveActivity = intent.resolveActivity(this.s.getPackageManager());
                        if (componentNameResolveActivity == null || !componentNameResolveActivity.getPackageName().equals(this.s.getPackageName())) {
                            if ((intent.getFlags() & MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO) == 0) {
                                n(this.s, intent, pkVarFs, strUr);
                            } else {
                                com.byazt.hm.n.n(pkVarFs, strUr, (Throwable) new RuntimeException("webview client intent flag error"), true, false);
                            }
                        }
                    } catch (Throwable th) {
                        com.byazt.hm.n.n(pkVarFs, strUr, th, true, false);
                    }
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } catch (Exception e) {
            com.byazt.eji.s.n().n("wb_loading", e);
            com.byazt.gcl.s sVar3 = this.qg;
            if (sVar3 != null && sVar3.rv()) {
                return true;
            }
        }
    }

    private void n(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(ImagesContract.URL, str);
            jSONObject.putOpt("intercept", Boolean.valueOf(z));
            com.byazt.gcl.s sVar = this.qg;
            if (sVar != null && sVar.fs() != null) {
                pk pkVarFs = this.qg.fs();
                jSONObject.putOpt("rit", com.byazt.vgx.w.n(pkVarFs, ""));
                jSONObject.putOpt("cid", pkVarFs.q());
                jSONObject.putOpt("ad_package_name", com.byazt.vgx.w.ln(pkVarFs));
                jSONObject.putOpt("req_id", pkVarFs.ou());
            }
            com.byazt.eji.s.n().n("xiaomi_market_jump", jSONObject, (Throwable) null);
        } catch (Throwable unused) {
        }
    }

    private void n(Context context, Intent intent, final pk pkVar, final String str) {
        com.byazt.tk.n.n(context, intent, new com.byazt.tk.n.InterfaceC0352n() { // from class: com.byazt.dho.s.1
            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n() {
                com.byazt.hm.n.n(pkVar, str, (Throwable) null, true, true);
                l.n().n(pkVar, str, true, false, null);
            }

            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n(Throwable th) {
                com.byazt.hm.n.n(pkVar, str, th, true, false);
            }
        }, TextUtils.equals(tj.rv, "internal"));
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        com.byazt.hm.s sVar = this.l;
        if (sVar != null) {
            sVar.n(webView);
        }
        if (webView != null && this.w) {
            try {
                String strN = n.n(rv.qg().dn(), this.q);
                if (!TextUtils.isEmpty(strN)) {
                    oa.n(webView, strN);
                }
            } catch (Throwable unused) {
            }
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.byazt.hm.s sVar = this.l;
        if (sVar != null) {
            sVar.n(webView, str, bitmap);
        }
        if (this.x) {
            n.n(this.s).n(true).n(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        com.byazt.hm.s sVar = this.l;
        if (sVar != null) {
            sVar.n(i, str, str2, qg(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.l == null || webResourceError == null) {
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
        this.l.n(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), string, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.l == null || webResourceResponse == null) {
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
        this.l.n(webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), string, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.l != null) {
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
            this.l.n(primaryError, str, url, qg(url));
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        cp = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add("gif");
        hashSet.add("svg");
        hashSet.add("jpeg");
    }

    private static String qg(String str) {
        int iLastIndexOf;
        String strSubstring;
        if (str == null || (iLastIndexOf = str.lastIndexOf(46)) < 0 || iLastIndexOf == str.length() - 1 || (strSubstring = str.substring(iLastIndexOf)) == null || !cp.contains(strSubstring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/" + strSubstring;
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        if (!renderProcessGoneDetail.didCrash()) {
            k.qg("WebChromeClient", "System killed the WebView rendering process to reclaim memory. Recreating...");
            if (webView != null) {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                webView.destroy();
                com.byazt.gjp.l.n().qg();
            }
            return true;
        }
        k.qg("WebChromeClient", "The WebView rendering process crashed!");
        if (webView != null) {
            ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(webView);
            }
            webView.destroy();
            com.byazt.gjp.l.n().qg();
        }
        return true;
    }

    @Override // com.byazt.kfh.SSWebView.s
    public void n(boolean z) {
        com.byazt.gcl.s sVar = this.qg;
        if (sVar != null) {
            sVar.s(z);
        }
    }

    @Override // com.byazt.kfh.SSWebView.s
    public void n(MotionEvent motionEvent) {
        pk pkVarFs;
        JSONObject jSONObjectA_;
        com.byazt.gcl.s sVar = this.qg;
        if (sVar == null || (pkVarFs = sVar.fs()) == null || (jSONObjectA_ = pkVarFs.A_()) == null) {
            return;
        }
        final int iOptInt = jSONObjectA_.optInt("rit", 0);
        int toolType = motionEvent.getToolType(0);
        if (motionEvent.getActionMasked() == 0) {
            x xVar = (x) com.byazt.qp.q.n("armor_service");
            if (xVar != null) {
                xVar.n(motionEvent);
            }
            if (toolType == 0) {
                com.byazt.tk.rv.n().post(new Runnable() { // from class: com.byazt.dho.s.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SoftDecTool.codeIdCountMap.put(Integer.valueOf(iOptInt), Integer.valueOf(SoftDecTool.codeIdCountMap.getOrDefault(Integer.valueOf(iOptInt), 0).intValue() + 1));
                    }
                });
            }
        }
    }

    public boolean qg() {
        return System.currentTimeMillis() - this.rv < ((long) rv.qg().cj());
    }

    public void qg(boolean z) {
        if (!z || this.tj) {
            this.rv = System.currentTimeMillis();
        }
    }

    public void s() {
        this.tj = true;
    }
}
