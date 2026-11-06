package com.byazt.lz;

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
import com.byazt.ca.aj;
import com.byazt.ca.ho;
import com.byazt.ca.m;
import com.byazt.ca.uc;
import com.byazt.ca.yb;
import com.byazt.fj.SSWebView;
import com.byazt.hg.e;
import com.byazt.hg.gz;
import com.byazt.hg.of;
import com.byazt.pj.c;
import com.byazt.qx.fw;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.nl;
import com.byazt.sd.zo;
import com.byazt.wt.cz;
import com.byazt.wt.ls;
import com.byazt.wt.qn;
import com.byazt.wt.rc;
import com.byazt.wt.ww;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1266, 121})
public class x extends WebViewClient implements SSWebView.hn {
    public static final HashSet<String> w;
    public com.byazt.pj.hn c;
    public final Context hn;
    public final nl hw;
    public com.byazt.mv.x pr;
    public final String x;
    public boolean uc = true;
    public boolean fw = true;
    public volatile AtomicInteger zo = new AtomicInteger(0);
    public long aj = -1;
    public boolean vk = false;

    public x(Context context, nl nlVar, String str) {
        this.hn = context;
        this.hw = nlVar;
        this.x = str;
    }

    public x(Context context, nl nlVar, String str, com.byazt.pj.hn hnVar) {
        this.hn = context;
        this.hw = nlVar;
        this.x = str;
        this.c = hnVar;
    }

    public x(Context context, nl nlVar, String str, com.byazt.pj.hn hnVar, com.byazt.mv.x xVar) {
        this.hn = context;
        this.hw = nlVar;
        this.x = str;
        this.c = hnVar;
        this.pr = xVar;
    }

    private boolean pr(Uri uri) {
        File fileHw = uc.hw(a.getContext(), false, null);
        if (uri != null) {
            try {
                String lastPathSegment = uri.getLastPathSegment();
                if (lastPathSegment != null) {
                    File canonicalFile = new File(fileHw, lastPathSegment).getCanonicalFile();
                    if (canonicalFile.exists() && !canonicalFile.getPath().startsWith(fileHw.toString())) {
                        return true;
                    }
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null && pr(webResourceRequest.getUrl())) {
            return null;
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
        if (this.pr != null) {
            webResourceResponseShouldInterceptRequest = this.pr.pr(webView, new com.byazt.mv.hw(webResourceRequest, null), webResourceResponseShouldInterceptRequest);
        }
        if (pr(webView, webResourceRequest)) {
            return new WebResourceResponse("", "", null);
        }
        Set<gz.hn> setPr = qn.pr().pr(webResourceRequest.getUrl().toString());
        if (setPr != null && !setPr.isEmpty()) {
            qn qnVarPr = qn.pr();
            String string = webResourceRequest.getUrl().toString();
            com.byazt.pj.hn hnVar = this.c;
            return qnVarPr.pr(webResourceResponseShouldInterceptRequest, string, setPr, hnVar != null ? hnVar.zo() : null);
        }
        return webResourceResponseShouldInterceptRequest;
    }

    public boolean pr(WebView webView, WebResourceRequest webResourceRequest) {
        return e.pr(webView, this.zo, this.hw, webResourceRequest, false, hw()) && !(this instanceof fw);
    }

    public boolean pr(WebView webView, String str) {
        return e.pr(webView, this.zo, this.hw, str, false, hw()) && !(this instanceof fw);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str != null && pr(Uri.parse(str))) {
            return null;
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, str);
        if (this.pr != null) {
            webResourceResponseShouldInterceptRequest = this.pr.pr(webView, new com.byazt.mv.hw(null, str), webResourceResponseShouldInterceptRequest);
        }
        if (pr(webView, str)) {
            return new WebResourceResponse("", "", null);
        }
        Set<gz.hn> setPr = qn.pr().pr(str);
        if (setPr != null && !setPr.isEmpty()) {
            qn qnVarPr = qn.pr();
            com.byazt.pj.hn hnVar = this.c;
            return qnVarPr.pr(webResourceResponseShouldInterceptRequest, str, setPr, hnVar != null ? hnVar.zo() : null);
        }
        return webResourceResponseShouldInterceptRequest;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    private void pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ((str.contains("weixin://wap/pay") || str.contains("weixin://dl/business/?ticket")) || str.contains("alipays://platformapi/startapp?appId")) {
            com.byazt.pj.pr.hn(this.hw.zo(), "landingpage", "lp_pay");
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        nl nlVar;
        boolean zPr;
        pr(str);
        try {
            if (pr(webView, str)) {
                return true;
            }
            com.byazt.mv.x xVar = this.pr;
            if (xVar != null) {
                xVar.pr(webView, str);
            }
            Uri uri = Uri.parse(str);
            String lowerCase = uri.getScheme().toLowerCase();
            if ("bytedance".equals(lowerCase)) {
                cz.pr(uri, this.hw);
                return true;
            }
            if (zo.nt().ls() != null && ((Boolean) zo.nt().ls().apply(com.byazt.xi.hw.pr().pr(15).pr(Boolean.class).pr(0, new ww().pr(ContentProviderManager.PROVIDER_URI, uri)).hw())).booleanValue()) {
                if (com.byazt.vo.hn.pr(str)) {
                    if (a.hw().gd()) {
                        pr(str, false);
                    } else {
                        pr(str, true);
                        return true;
                    }
                }
                nl nlVar2 = this.hw;
                if (nlVar2 != null && nlVar2.zo() != null) {
                    zPr = com.byazt.vo.hn.pr(uri, this.hw.zo(), this.hn, this.hw.ve(), hashCode());
                } else {
                    zPr = false;
                }
                com.byazt.sd.hw.pr().pr("is_landing_page_open_market", true);
                if (zPr) {
                    return true;
                }
            }
            if (!yb.pr(str) && (nlVar = this.hw) != null && nlVar.zo() != null) {
                String strVe = this.hw.ve();
                of ofVarZo = this.hw.zo();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
                HashMap map = new HashMap();
                map.put("source", "TTWebViewClient");
                map.put("scheme", lowerCase);
                com.byazt.pj.pr.pr(ofVarZo, strVe, (Map<String, Object>) map, true);
                if (ls.b()) {
                    if (!ls.pr(intent)) {
                        com.byazt.pj.pr.pr(ofVarZo, strVe, (Throwable) new RuntimeException("query is true,install is false"), true, false);
                    } else {
                        pr(this.hn, intent, ofVarZo, strVe);
                    }
                } else {
                    try {
                        ComponentName componentNameResolveActivity = intent.resolveActivity(this.hn.getPackageManager());
                        if (componentNameResolveActivity == null || !componentNameResolveActivity.getPackageName().equals(this.hn.getPackageName())) {
                            if ((intent.getFlags() & MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO) != 0) {
                                com.byazt.pj.pr.pr(ofVarZo, strVe, (Throwable) new RuntimeException("webview client intent flag error"), true, false);
                            } else {
                                pr(this.hn, intent, ofVarZo, strVe);
                            }
                        }
                    } catch (Throwable th) {
                        com.byazt.pj.pr.pr(ofVarZo, strVe, th, true, false);
                    }
                }
                return true;
            }
        } catch (Exception e) {
            com.byazt.xk.hw.pr().pr("wb_loading", e);
            nl nlVar3 = this.hw;
            if (nlVar3 != null && nlVar3.aj()) {
                return true;
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    private void pr(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(BreakpointSQLiteKey.URL, str);
            jSONObject.putOpt("intercept", Boolean.valueOf(z));
            nl nlVar = this.hw;
            if (nlVar != null && nlVar.zo() != null) {
                of ofVarZo = this.hw.zo();
                jSONObject.putOpt("rit", ls.pr(ofVarZo, ""));
                jSONObject.putOpt("cid", ofVarZo.x());
                jSONObject.putOpt("ad_package_name", ls.iu(ofVarZo));
                jSONObject.putOpt("req_id", ofVarZo.ny());
            }
            com.byazt.xk.hw.pr().pr("xiaomi_market_jump", jSONObject, (Throwable) null);
        } catch (Throwable th) {
        }
    }

    private void pr(Context context, Intent intent, final of ofVar, final String str) {
        com.byazt.ca.pr.pr(context, intent, new com.byazt.ca.pr.InterfaceC0030pr() { // from class: com.byazt.lz.x.1
            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr() {
                com.byazt.pj.pr.pr(ofVar, str, (Throwable) null, true, true);
                c.pr().pr(ofVar, str, true, false, null);
            }

            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr(Throwable th) {
                com.byazt.pj.pr.pr(ofVar, str, th, true, false);
            }
        }, TextUtils.equals(iu.zo, UMModuleRegister.INNER));
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        com.byazt.pj.hn hnVar = this.c;
        if (hnVar != null) {
            hnVar.pr(webView);
        }
        if (webView != null && this.uc) {
            try {
                String strPr = hw.pr(a.hw().mw(), this.x);
                if (!TextUtils.isEmpty(strPr)) {
                    m.pr(webView, strPr);
                }
            } catch (Throwable th) {
            }
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.byazt.pj.hn hnVar = this.c;
        if (hnVar != null) {
            hnVar.pr(webView, str, bitmap);
        }
        if (this.fw) {
            hw.pr(this.hn).pr(Build.VERSION.SDK_INT >= 19).pr(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        com.byazt.pj.hn hnVar = this.c;
        if (hnVar != null) {
            hnVar.pr(i, str, str2, hw(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.c != null && webResourceError != null) {
            Uri url = webResourceRequest.getUrl();
            String str = "";
            String string = url != null ? url.toString() : "";
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders.containsKey("Accept")) {
                str = requestHeaders.get("Accept");
            } else if (requestHeaders.containsKey("accept")) {
                str = requestHeaders.get("accept");
            }
            this.c.pr(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), string, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.c != null && webResourceResponse != null) {
            Uri url = webResourceRequest.getUrl();
            String str = "";
            String string = url != null ? url.toString() : "";
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders.containsKey("Accept")) {
                str = requestHeaders.get("Accept");
            } else if (requestHeaders.containsKey("accept")) {
                str = requestHeaders.get("accept");
            }
            this.c.pr(webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), string, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable th) {
            }
        }
        if (this.c != null) {
            int primaryError = 0;
            String str = "SslError: unknown";
            String url = null;
            if (sslError != null) {
                try {
                    primaryError = sslError.getPrimaryError();
                    str = "SslError: " + String.valueOf(sslError);
                    url = sslError.getUrl();
                } catch (Throwable th2) {
                }
            }
            this.c.pr(primaryError, str, url, hw(url));
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        w = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add("gif");
        hashSet.add("svg");
        hashSet.add("jpeg");
    }

    private static String hw(String str) {
        int iLastIndexOf;
        String strSubstring;
        if (str == null || (iLastIndexOf = str.lastIndexOf(46)) < 0 || iLastIndexOf == str.length() - 1 || (strSubstring = str.substring(iLastIndexOf)) == null || !w.contains(strSubstring.toLowerCase(Locale.getDefault()))) {
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
            ho.hw("WebChromeClient", "System killed the WebView rendering process to reclaim memory. Recreating...");
            if (webView != null) {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                webView.destroy();
                com.byazt.kq.c.pr().hw();
            }
            return true;
        }
        ho.hw("WebChromeClient", "The WebView rendering process crashed!");
        if (webView != null) {
            ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(webView);
            }
            webView.destroy();
            com.byazt.kq.c.pr().hw();
        }
        return true;
    }

    @Override // com.byazt.fj.SSWebView.hn
    public void pr(boolean z) {
        nl nlVar = this.hw;
        if (nlVar != null) {
            nlVar.hn(z);
        }
    }

    @Override // com.byazt.fj.SSWebView.hn
    public void pr(MotionEvent motionEvent) {
        of ofVarZo;
        JSONObject jSONObjectV_;
        nl nlVar = this.hw;
        if (nlVar != null && (ofVarZo = nlVar.zo()) != null && (jSONObjectV_ = ofVarZo.v_()) != null) {
            final int iOptInt = jSONObjectV_.optInt("rit", 0);
            int toolType = motionEvent.getToolType(0);
            if (motionEvent.getActionMasked() == 0) {
                rc.pr(motionEvent);
                if (toolType == 0) {
                    aj.pr().post(new Runnable() { // from class: com.byazt.lz.x.2
                        @Override // java.lang.Runnable
                        public void run() {
                            SoftDecTool.codeIdCountMap.put(Integer.valueOf(iOptInt), Integer.valueOf(SoftDecTool.codeIdCountMap.getOrDefault(Integer.valueOf(iOptInt), 0).intValue() + 1));
                        }
                    });
                }
            }
        }
    }

    public boolean hw() {
        return System.currentTimeMillis() - this.aj < ((long) a.hw().ds());
    }

    public void hw(boolean z) {
        if (!z || this.vk) {
            this.aj = System.currentTimeMillis();
        }
    }

    public void hn() {
        this.vk = true;
    }
}
