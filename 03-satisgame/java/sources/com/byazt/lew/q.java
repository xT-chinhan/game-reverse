package com.byazt.lew;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.anythink.core.common.l.b;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.qit.l;
import com.byazt.tbt.cy;
import com.byazt.tbt.d;
import com.byazt.tbt.sz;
import com.byazt.tbt.tj;
import com.byazt.tbt.w;
import com.byazt.tk.hd;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 423, 5})
public class q implements n {
    public static final AtomicInteger n = new AtomicInteger(0);
    public String w;
    public List<com.byazt.nrq.n> q = new CopyOnWriteArrayList();
    public HashMap<String, HashMap<String, byte[]>> l = new HashMap<>();
    public AtomicInteger qg = new AtomicInteger(0);
    public final ExecutorService s = l.n();

    private String n(int i) {
        if (i == 100) {
            return "Continue";
        }
        if (i == 101) {
            return "Switching Protocols";
        }
        switch (i) {
            case 200:
                return "OK";
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
                    case MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL /* 400 */:
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
                    case TTAdConstant.LIVE_AD_CODE /* 416 */:
                        return "Requested range not satisfiable";
                    case TTAdConstant.LIVE_FEED_URL_CODE /* 417 */:
                        return "Expectation Failed";
                    default:
                        switch (i) {
                            case 500:
                                return "Internal Server Error";
                            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE /* 501 */:
                                return "Not Implemented";
                            case 502:
                                return "Bad Gateway";
                            case 503:
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

    public static boolean s() {
        return true;
    }

    @Override // com.byazt.lew.n
    public AtomicInteger qg() {
        return this.qg;
    }

    @Override // com.byazt.lew.n
    public HashMap<String, HashMap<String, byte[]>> n() {
        return this.l;
    }

    public static s n(pk pkVar, Context context) {
        boolean z = false;
        boolean z2 = pkVar.lg() == 1;
        boolean zN = com.byazt.wz.qg.n(pkVar.ln() / 100.0f, false);
        boolean z3 = rv.qg().fl() == 1;
        boolean z4 = hd.q(context) || !(rv.qg().ry() == 1);
        boolean zS = s();
        boolean z5 = z2 && z3 && z4 && zS;
        if (zN && z3 && zS) {
            z = true;
        }
        s sVar = new s();
        sVar.n(z5);
        sVar.qg(z);
        return sVar;
    }

    public static q n(Context context, pk pkVar, String str) {
        JSONObject jSONObjectA_;
        s sVarN = n(pkVar, context);
        if ((!sVarN.n() && !sVarN.qg()) || (jSONObjectA_ = pkVar.A_()) == null) {
            return null;
        }
        String strOptString = jSONObjectA_.optString("cid");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        String strOptString2 = jSONObjectA_.optString("req_id");
        if (TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new q(sVarN, strOptString, strOptString2, jSONObjectA_, pkVar.F_(), str);
    }

    private q(s sVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        if (sVar != null) {
            if (sVar.n()) {
                com.byazt.nrq.qg qgVar = new com.byazt.nrq.qg(this, str, str2, jSONObject, str3, str4);
                qgVar.qg();
                this.q.add(qgVar);
            }
            if (sVar.qg()) {
                com.byazt.nrq.s sVar2 = new com.byazt.nrq.s(this, str, str2, jSONObject, str3, str4);
                sVar2.qg();
                this.q.add(sVar2);
            }
            this.w = str4;
            n.incrementAndGet();
            n((WebView) null, this.w);
        }
    }

    public WebResourceResponse n(WebView webView, qg qgVar, WebResourceResponse webResourceResponse) {
        Iterator<com.byazt.nrq.n> it = this.q.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().n(webView)) {
                z = true;
            }
        }
        return !z ? webResourceResponse : qg(webView, qgVar, webResourceResponse);
    }

    @Override // com.byazt.lew.n
    public void n(final Runnable runnable) {
        this.s.submit(new Runnable() { // from class: com.byazt.lew.q.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (q.this.s) {
                    try {
                        runnable.run();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public WebResourceResponse qg(WebView webView, final qg qgVar, WebResourceResponse webResourceResponse) {
        String strQg;
        if (qgVar != null && (strQg = qgVar.qg()) != null && TextUtils.equals(strQg, "get")) {
            if (rv.qg().dw() == 1) {
                WebResourceResponse webResourceResponseN = n(rv.getContext(), this.w, qgVar);
                if (webResourceResponseN != null) {
                    webResourceResponseN.getResponseHeaders().put("Access-Control-Allow-Origin", "*");
                    return webResourceResponseN;
                }
            } else {
                n(new Runnable() { // from class: com.byazt.lew.q.2
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.n(rv.getContext(), q.this.w, qgVar);
                    }
                });
            }
        }
        return webResourceResponse;
    }

    public WebResourceResponse n(final Context context, final String str, final qg qgVar) {
        WebResourceResponse webResourceResponse;
        final Pair<WebResourceResponse, WebResourceResponse> pairN;
        final Pair<WebResourceResponse, tj> pairN2 = n(qgVar);
        if (pairN2 == null || (webResourceResponse = (WebResourceResponse) pairN2.first) == null) {
            return null;
        }
        Iterator<com.byazt.nrq.n> it = this.q.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().n((tj) pairN2.second)) {
                z = true;
            }
        }
        if (!z || (pairN = n(webResourceResponse)) == null) {
            return null;
        }
        for (final com.byazt.nrq.n nVar : this.q) {
            nVar.n(qgVar, (WebResourceResponse) pairN.second, (tj) pairN2.second, new com.byazt.nrq.n.InterfaceC0272n() { // from class: com.byazt.lew.q.3
                @Override // com.byazt.nrq.n.InterfaceC0272n
                public void n(boolean z2, final Map<String, Object> map) {
                    if (z2) {
                        q.this.n(new Runnable() { // from class: com.byazt.lew.q.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (nVar.l == null || nVar.l.get()) {
                                        return;
                                    }
                                    q.this.n(context, str, qgVar, (WebResourceResponse) pairN.second, (tj) pairN2.second, map, nVar);
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    }
                }
            });
        }
        return (WebResourceResponse) pairN.first;
    }

    public void n(Context context, String str, qg qgVar, WebResourceResponse webResourceResponse, tj tjVar, Map<String, Object> map, com.byazt.nrq.n nVar) {
        if (nVar.n(tjVar)) {
            rv.qg().ta();
            if (rv.qg().ta() == 1) {
                nVar.n(context, str, qgVar, webResourceResponse, tjVar, map);
            } else {
                nVar.qg(context, str, qgVar, webResourceResponse, tjVar, map);
            }
        }
    }

    private Pair<WebResourceResponse, WebResourceResponse> n(WebResourceResponse webResourceResponse) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            if (com.byazt.euy.qg.n(webResourceResponse.getData(), byteArrayOutputStream) != -1) {
                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                try {
                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                } catch (Exception unused) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                    byteArrayInputStream2 = null;
                }
            } else {
                byteArrayInputStream = null;
                byteArrayInputStream2 = null;
            }
        } catch (Exception unused3) {
            byteArrayInputStream = null;
        }
        if (!s()) {
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

    private Pair<WebResourceResponse, tj> n(qg qgVar) {
        if (s() && qgVar != null) {
            try {
                d dVarN = com.byazt.mw.s.n().qg().n();
                sz.n nVar = new sz.n();
                Map<String, String> mapS = qgVar.s();
                if (mapS != null) {
                    for (String str : mapS.keySet()) {
                        nVar.qg(str, mapS.get(str));
                    }
                }
                nVar.qg(qgVar.n().toString());
                cy cyVarQg = dVarN.n(nVar.qg()).qg();
                int iQ = cyVarQg.q();
                if (iQ == 200) {
                    HashMap map = new HashMap();
                    w wVarFs = cyVarQg.fs();
                    if (wVarFs != null) {
                        for (int i = 0; i < wVarFs.n(); i++) {
                            map.put(wVarFs.n(i), wVarFs.qg(i));
                        }
                    }
                    InputStream inputStreamS = cyVarQg.x().s();
                    tj tjVarN = n(map);
                    return new Pair<>(new WebResourceResponse(tjVarN.n() + "/" + tjVarN.qg(), tjVarN.s() == null ? null : tjVarN.s().toString(), iQ, n(iQ), map, inputStreamS), tjVarN);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002f  */
    private tj n(Map<String, String> map) {
        String str;
        if (map == null) {
            str = null;
        } else if (map.containsKey(b.g)) {
            str = map.get(b.g);
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
        return tj.n(str);
    }

    public static void n(Context context) {
        if (s()) {
            try {
                File file = new File(qg(context));
                if (System.currentTimeMillis() - file.lastModified() <= 3000 || !file.exists()) {
                    return;
                }
                com.byazt.euy.n.qg(qg(context));
            } catch (Throwable unused) {
            }
        }
    }

    public static String qg(Context context) {
        return com.byazt.tk.w.qg(context, false, null).getAbsolutePath() + File.separator + ".lp_cache";
    }

    public void q() {
        if (!this.q.isEmpty()) {
            Iterator<com.byazt.nrq.n> it = this.q.iterator();
            while (it.hasNext()) {
                it.next().s();
            }
        }
        this.q.clear();
    }

    public void n(WebView webView, String str) {
        if (hd.n(str)) {
            this.qg.incrementAndGet();
            this.qg.get();
            Iterator<com.byazt.nrq.n> it = this.q.iterator();
            while (it.hasNext()) {
                it.next().n(str);
            }
        }
    }
}
