package com.bytedance.sdk.openadsdk.sl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.anythink.basead.ui.GuideToClickView;
import com.baidu.mobads.sdk.internal.ca;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.c;
import com.bytedance.sdk.component.xr.ms.ch;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.re.ka;
import com.tapsdk.tapad.e.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d implements ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final AtomicInteger f4094ms = new AtomicInteger(0);
    private String c;
    private List<com.bytedance.sdk.openadsdk.sl.ms.ms> d = new ArrayList();
    private HashMap<String, HashMap<String, byte[]>> ka = new HashMap<>();
    public AtomicInteger xr = new AtomicInteger(0);
    final ExecutorService ah = ab.ms();

    public static boolean ah() {
        return true;
    }

    private String ms(int i) {
        if (i == 100) {
            return "Continue";
        }
        if (i == 101) {
            return "Switching Protocols";
        }
        switch (i) {
            case 200:
                return ca.k;
            case 201:
                return "Created";
            case 202:
                return "Accepted";
            case 203:
                return "Non-Authoritative Information";
            case 204:
                return "No Content";
            case 205:
                return "Reset Content";
            case 206:
                return "Partial Content";
            default:
                switch (i) {
                    case 400:
                        return "Bad Request";
                    case 401:
                        return "Unauthorized";
                    case 402:
                        return "Payment Required";
                    case 403:
                        return "Forbidden";
                    case 404:
                        return "Not Found";
                    case 405:
                        return "Method Not Allowed";
                    case 406:
                        return "Not Acceptable";
                    case 407:
                        return "Proxy Authentication Required";
                    case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                        return "Request Time-out";
                    case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                        return "Conflict";
                    case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                        return "Gone";
                    case TTAdConstant.IMAGE_CODE /* 411 */:
                        return "Length Required";
                    case TTAdConstant.IMAGE_URL_CODE /* 412 */:
                        return "Precondition Failed";
                    case TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                        return "Request Entity Too Large";
                    case TTAdConstant.VIDEO_URL_CODE /* 414 */:
                        return "Request-URI Too Large";
                    case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                        return "Unsupported Media Type";
                    case 416:
                        return "Requested range not satisfiable";
                    case TTAdConstant.LIVE_FEED_URL_CODE /* 417 */:
                        return "Expectation Failed";
                    default:
                        switch (i) {
                            case 500:
                                return "Internal Server Error";
                            case 501:
                                return "Not Implemented";
                            case 502:
                                return "Bad Gateway";
                            case GuideToClickView.a.c /* 503 */:
                                return "Service Unavailable";
                            case 504:
                                return "Gateway Time-out";
                            case 505:
                                return "HTTP Version not supported";
                            default:
                                return "";
                        }
                }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms
    public AtomicInteger xr() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms
    public HashMap<String, HashMap<String, byte[]>> ms() {
        return this.ka;
    }

    public static ah ms(lm lmVar, Context context) {
        boolean z = false;
        boolean z2 = lmVar.sk() == 1;
        boolean zMs = com.bytedance.sdk.openadsdk.core.c.xr.ms(lmVar.xr() / 100.0f, false);
        boolean z3 = re.xr().e() == 1;
        boolean z4 = u.d(context) || !(re.xr().qf() == 1);
        boolean zAh = ah();
        boolean z5 = z2 && z3 && z4 && zAh;
        if (zMs && z3 && zAh) {
            z = true;
        }
        ah ahVar = new ah();
        ahVar.ms(z5);
        ahVar.xr(z);
        return ahVar;
    }

    public static d ms(Context context, lm lmVar, String str) {
        JSONObject jSONObjectIt;
        ah ahVarMs = ms(lmVar, context);
        if ((!ahVarMs.ms() && !ahVarMs.xr()) || (jSONObjectIt = lmVar.it()) == null) {
            return null;
        }
        String strOptString = jSONObjectIt.optString("cid");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        String strOptString2 = jSONObjectIt.optString("req_id");
        if (TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new d(ahVarMs, strOptString, strOptString2, jSONObjectIt, lmVar.lx(), str);
    }

    private d(ah ahVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        if (ahVar != null) {
            if (ahVar.ms()) {
                com.bytedance.sdk.openadsdk.sl.ms.xr xrVar = new com.bytedance.sdk.openadsdk.sl.ms.xr(this, str, str2, jSONObject, str3, str4);
                xrVar.xr();
                this.d.add(xrVar);
            }
            if (ahVar.xr()) {
                com.bytedance.sdk.openadsdk.sl.ms.ah ahVar2 = new com.bytedance.sdk.openadsdk.sl.ms.ah(this, str, str2, jSONObject, str3, str4);
                ahVar2.xr();
                this.d.add(ahVar2);
            }
            this.c = str4;
            f4094ms.incrementAndGet();
            ms((WebView) null, this.c);
        }
    }

    public WebResourceResponse ms(WebView webView, xr xrVar, WebResourceResponse webResourceResponse) {
        Iterator<com.bytedance.sdk.openadsdk.sl.ms.ms> it = this.d.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().ms(webView)) {
                z = true;
            }
        }
        return !z ? webResourceResponse : xr(webView, xrVar, webResourceResponse);
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms
    public void ms(final Runnable runnable) {
        this.ah.submit(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sl.d.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (d.this.ah) {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        sl.ms(th);
                    }
                }
            }
        });
    }

    public WebResourceResponse xr(WebView webView, final xr xrVar, WebResourceResponse webResourceResponse) {
        String strXr;
        if (xrVar != null && (strXr = xrVar.xr()) != null && TextUtils.equals(strXr, "get")) {
            if (re.xr().eg() == 1) {
                WebResourceResponse webResourceResponseMs = ms(re.getContext(), this.c, xrVar);
                if (webResourceResponseMs != null) {
                    webResourceResponseMs.getResponseHeaders().put("Access-Control-Allow-Origin", "*");
                    return webResourceResponseMs;
                }
            } else {
                ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sl.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.ms(re.getContext(), d.this.c, xrVar);
                    }
                });
            }
        }
        return webResourceResponse;
    }

    protected WebResourceResponse ms(final Context context, final String str, final xr xrVar) {
        WebResourceResponse webResourceResponse;
        final Pair<WebResourceResponse, WebResourceResponse> pairMs;
        final Pair<WebResourceResponse, ch> pairMs2 = ms(xrVar);
        if (pairMs2 == null || (webResourceResponse = (WebResourceResponse) pairMs2.first) == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.openadsdk.sl.ms.ms> it = this.d.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().ms((ch) pairMs2.second)) {
                z = true;
            }
        }
        if (!z || (pairMs = ms(webResourceResponse)) == null) {
            return null;
        }
        for (final com.bytedance.sdk.openadsdk.sl.ms.ms msVar : this.d) {
            msVar.ms(xrVar, (WebResourceResponse) pairMs.second, (ch) pairMs2.second, new com.bytedance.sdk.openadsdk.sl.ms.ms.InterfaceC0337ms() { // from class: com.bytedance.sdk.openadsdk.sl.d.3
                @Override // com.bytedance.sdk.openadsdk.sl.ms.ms.InterfaceC0337ms
                public void ms(boolean z2, final Map<String, Object> map) {
                    if (z2) {
                        d.this.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sl.d.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (msVar.ka == null || msVar.ka.get()) {
                                        return;
                                    }
                                    d.this.ms(context, str, xrVar, (WebResourceResponse) pairMs.second, (ch) pairMs2.second, map, msVar);
                                } catch (Throwable th) {
                                    sl.ms(th);
                                }
                            }
                        });
                    }
                }
            });
        }
        return (WebResourceResponse) pairMs.first;
    }

    protected void ms(Context context, String str, xr xrVar, WebResourceResponse webResourceResponse, ch chVar, Map<String, Object> map, com.bytedance.sdk.openadsdk.sl.ms.ms msVar) {
        if (msVar.ms(chVar)) {
            re.xr().am();
            if (re.xr().am() == 1) {
                msVar.ms(context, str, xrVar, webResourceResponse, chVar, map);
            } else {
                msVar.xr(context, str, xrVar, webResourceResponse, chVar, map);
            }
        }
    }

    private Pair<WebResourceResponse, WebResourceResponse> ms(WebResourceResponse webResourceResponse) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            if (com.bytedance.sdk.openadsdk.sl.xr.xr.ms(webResourceResponse.getData(), byteArrayOutputStream) != -1) {
                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                try {
                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                } catch (Exception e) {
                    e = e;
                    sl.ms(e);
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        sl.ms(th);
                    }
                    byteArrayInputStream2 = null;
                }
            } else {
                byteArrayInputStream2 = null;
                byteArrayInputStream = null;
            }
        } catch (Exception e2) {
            e = e2;
            byteArrayInputStream = null;
        }
        if (!ah()) {
            return null;
        }
        String mimeType = webResourceResponse.getMimeType();
        String encoding = webResourceResponse.getEncoding();
        int statusCode = webResourceResponse.getStatusCode();
        String reasonPhrase = webResourceResponse.getReasonPhrase();
        Map<String, String> responseHeaders = webResourceResponse.getResponseHeaders();
        if (byteArrayInputStream == null) {
            byteArrayInputStream = new ByteArrayInputStream(new byte[0]);
        }
        WebResourceResponse webResourceResponse2 = new WebResourceResponse(mimeType, encoding, statusCode, reasonPhrase, responseHeaders, byteArrayInputStream);
        String mimeType2 = webResourceResponse.getMimeType();
        String encoding2 = webResourceResponse.getEncoding();
        int statusCode2 = webResourceResponse.getStatusCode();
        String reasonPhrase2 = webResourceResponse.getReasonPhrase();
        Map<String, String> responseHeaders2 = webResourceResponse.getResponseHeaders();
        if (byteArrayInputStream2 == null) {
            byteArrayInputStream2 = new ByteArrayInputStream(new byte[0]);
        }
        return new Pair<>(webResourceResponse2, new WebResourceResponse(mimeType2, encoding2, statusCode2, reasonPhrase2, responseHeaders2, byteArrayInputStream2));
    }

    private Pair<WebResourceResponse, ch> ms(xr xrVar) {
        if (ah() && xrVar != null) {
            try {
                com.bytedance.sdk.component.xr.ms.sl slVarC = ka.ms().xr().c();
                com.bytedance.sdk.component.xr.ms.u.ms msVar = new com.bytedance.sdk.component.xr.ms.u.ms();
                Map<String, String> mapAh = xrVar.ah();
                if (mapAh != null) {
                    for (String str : mapAh.keySet()) {
                        msVar.xr(str, mapAh.get(str));
                    }
                }
                msVar.ms(xrVar.ms().toString());
                ao aoVarMs = slVarC.ms(msVar.xr()).ms();
                int iAh = aoVarMs.ah();
                if (iAh == 200) {
                    HashMap map = new HashMap();
                    c cVarAb = aoVarMs.ab();
                    if (cVarAb != null) {
                        for (int i = 0; i < cVarAb.ms(); i++) {
                            map.put(cVarAb.ms(i), cVarAb.xr(i));
                        }
                    }
                    InputStream inputStreamAh = aoVarMs.c().ah();
                    ch chVarMs = ms(map);
                    return new Pair<>(new WebResourceResponse(chVarMs.ms() + "/" + chVarMs.xr(), chVarMs.ah() == null ? null : chVarMs.ah().toString(), iAh, ms(iAh), map, inputStreamAh), chVarMs);
                }
            } catch (Throwable th) {
                sl.ms(th);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002f  */
    private ch ms(Map<String, String> map) {
        String str;
        if (map == null) {
            str = null;
        } else if (map.containsKey("Content-Type")) {
            str = map.get("Content-Type");
        } else if (map.containsKey("content-type")) {
            str = map.get("content-type");
        } else if (map.containsKey("CONTENT-TYPE")) {
            str = map.get("CONTENT-TYPE");
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "text/html; charset=UTF-8";
        }
        return ch.ms(str);
    }

    public static void ms(Context context) {
        if (ah()) {
            try {
                File file = new File(xr(context));
                if (System.currentTimeMillis() - file.lastModified() <= a.f || !file.exists()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.sl.xr.ms.xr(xr(context));
            } catch (Throwable th) {
                sl.ms(th);
            }
        }
    }

    public static String xr(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context).getAbsolutePath() + File.separator + ".lp_cache";
    }

    public void d() {
        if (!this.d.isEmpty()) {
            Iterator<com.bytedance.sdk.openadsdk.sl.ms.ms> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().ah();
            }
        }
        this.d.clear();
    }

    public void ms(WebView webView, String str) {
        if (u.ms(str)) {
            this.xr.incrementAndGet();
            this.xr.get();
            Iterator<com.bytedance.sdk.openadsdk.sl.ms.ms> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().ms(str);
            }
        }
    }
}
