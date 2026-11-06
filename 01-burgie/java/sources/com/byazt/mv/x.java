package com.byazt.mv;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.ca.yb;
import com.byazt.hg.of;
import com.byazt.nzn.g;
import com.byazt.nzn.k;
import com.byazt.nzn.nt;
import com.byazt.nzn.vk;
import com.byazt.pk.uc;
import com.byazt.sd.a;
import com.byazt.xlm.c;
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
@com.byazt.vzx.pr(pr = {0, 1, 1166, 121})
public class x implements pr {
    public static final AtomicInteger pr = new AtomicInteger(0);
    public String uc;
    public List<com.byazt.xm.pr> x = new CopyOnWriteArrayList();
    public HashMap<String, HashMap<String, byte[]>> c = new HashMap<>();
    public AtomicInteger hw = new AtomicInteger(0);
    public final ExecutorService hn = c.pr();

    public static boolean hn() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // com.byazt.mv.pr
    public AtomicInteger hw() {
        return this.hw;
    }

    @Override // com.byazt.mv.pr
    public HashMap<String, HashMap<String, byte[]>> pr() {
        return this.c;
    }

    public static hn pr(of ofVar, Context context) {
        boolean z = false;
        boolean z2 = ofVar.xg() == 1;
        boolean zPr = com.byazt.ip.hw.pr(ofVar.ve() / 100.0f, false);
        boolean z3 = a.hw().pq() == 1;
        boolean z4 = yb.x(context) || !(a.hw().j() == 1);
        boolean zHn = hn();
        boolean z5 = z2 && z3 && z4 && zHn;
        if (zPr && z3 && zHn) {
            z = true;
        }
        hn hnVar = new hn();
        hnVar.pr(z5);
        hnVar.hw(z);
        return hnVar;
    }

    public static x pr(Context context, of ofVar, String str) {
        JSONObject jSONObjectV_;
        hn hnVarPr = pr(ofVar, context);
        if ((!hnVarPr.pr() && !hnVarPr.hw()) || (jSONObjectV_ = ofVar.v_()) == null) {
            return null;
        }
        String strOptString = jSONObjectV_.optString("cid");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        String strOptString2 = jSONObjectV_.optString("req_id");
        if (TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new x(hnVarPr, strOptString, strOptString2, jSONObjectV_, ofVar.B_(), str);
    }

    private x(hn hnVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        if (hnVar != null) {
            if (hnVar.pr()) {
                com.byazt.xm.hw hwVar = new com.byazt.xm.hw(this, str, str2, jSONObject, str3, str4);
                hwVar.hw();
                this.x.add(hwVar);
            }
            if (hnVar.hw()) {
                com.byazt.xm.hn hnVar2 = new com.byazt.xm.hn(this, str, str2, jSONObject, str3, str4);
                hnVar2.hw();
                this.x.add(hnVar2);
            }
            this.uc = str4;
            pr.incrementAndGet();
            pr((WebView) null, this.uc);
        }
    }

    public WebResourceResponse pr(WebView webView, hw hwVar, WebResourceResponse webResourceResponse) {
        Iterator<com.byazt.xm.pr> it = this.x.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().pr(webView)) {
                z = true;
            }
        }
        if (!z) {
            return webResourceResponse;
        }
        return hw(webView, hwVar, webResourceResponse);
    }

    @Override // com.byazt.mv.pr
    public void pr(final Runnable runnable) {
        this.hn.submit(new Runnable() { // from class: com.byazt.mv.x.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (x.this.hn) {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                    }
                }
            }
        });
    }

    public WebResourceResponse hw(WebView webView, final hw hwVar, WebResourceResponse webResourceResponse) {
        String strHw;
        if (hwVar != null && (strHw = hwVar.hw()) != null && TextUtils.equals(strHw, "get")) {
            if (a.hw().wt() == 1) {
                WebResourceResponse webResourceResponsePr = pr(a.getContext(), this.uc, hwVar);
                if (webResourceResponsePr != null) {
                    webResourceResponsePr.getResponseHeaders().put("Access-Control-Allow-Origin", "*");
                    return webResourceResponsePr;
                }
            } else {
                pr(new Runnable() { // from class: com.byazt.mv.x.2
                    @Override // java.lang.Runnable
                    public void run() {
                        x.this.pr(a.getContext(), x.this.uc, hwVar);
                    }
                });
            }
        }
        return webResourceResponse;
    }

    public WebResourceResponse pr(final Context context, final String str, final hw hwVar) {
        WebResourceResponse webResourceResponse;
        final Pair<WebResourceResponse, WebResourceResponse> pairPr;
        final Pair<WebResourceResponse, vk> pairPr2 = pr(hwVar);
        if (pairPr2 == null || (webResourceResponse = (WebResourceResponse) pairPr2.first) == null) {
            return null;
        }
        boolean z = false;
        Iterator<com.byazt.xm.pr> it = this.x.iterator();
        while (it.hasNext()) {
            if (it.next().pr((vk) pairPr2.second)) {
                z = true;
            }
        }
        if (!z || (pairPr = pr(webResourceResponse)) == null) {
            return null;
        }
        for (final com.byazt.xm.pr prVar : this.x) {
            prVar.pr(hwVar, (WebResourceResponse) pairPr.second, (vk) pairPr2.second, new com.byazt.xm.pr.InterfaceC0235pr() { // from class: com.byazt.mv.x.3
                @Override // com.byazt.xm.pr.InterfaceC0235pr
                public void pr(boolean z2, final Map<String, Object> map) {
                    if (z2) {
                        x.this.pr(new Runnable() { // from class: com.byazt.mv.x.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (prVar.c != null && !prVar.c.get()) {
                                        x.this.pr(context, str, hwVar, (WebResourceResponse) pairPr.second, (vk) pairPr2.second, map, prVar);
                                    }
                                } catch (Throwable th) {
                                }
                            }
                        });
                    }
                }
            });
        }
        return (WebResourceResponse) pairPr.first;
    }

    public void pr(Context context, String str, hw hwVar, WebResourceResponse webResourceResponse, vk vkVar, Map<String, Object> map, com.byazt.xm.pr prVar) {
        if (!prVar.pr(vkVar)) {
            return;
        }
        a.hw().bh();
        if (a.hw().bh() == 1) {
            prVar.pr(context, str, hwVar, webResourceResponse, vkVar, map);
        } else {
            prVar.hw(context, str, hwVar, webResourceResponse, vkVar, map);
        }
    }

    private Pair<WebResourceResponse, WebResourceResponse> pr(WebResourceResponse webResourceResponse) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            if (com.byazt.ej.hw.pr(webResourceResponse.getData(), byteArrayOutputStream) == -1) {
                byteArrayInputStream2 = null;
                byteArrayInputStream = null;
            } else {
                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                try {
                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                } catch (Exception e) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                    }
                    byteArrayInputStream2 = null;
                }
            }
        } catch (Exception e2) {
            byteArrayInputStream = null;
        }
        if (!hn()) {
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

    private Pair<WebResourceResponse, vk> pr(hw hwVar) {
        if (hn() && hwVar != null) {
            try {
                k kVarPr = uc.pr().hw().pr();
                g.pr prVar = new g.pr();
                Map<String, String> mapHn = hwVar.hn();
                if (mapHn != null) {
                    for (String str : mapHn.keySet()) {
                        prVar.hw(str, mapHn.get(str));
                    }
                }
                prVar.pr(hwVar.pr().toString());
                nt ntVarHw = kVarPr.pr(prVar.hw()).hw();
                int iHn = ntVarHw.hn();
                if (iHn == 200) {
                    HashMap map = new HashMap();
                    com.byazt.nzn.uc ucVarFw = ntVarHw.fw();
                    if (ucVarFw != null) {
                        for (int i = 0; i < ucVarFw.pr(); i++) {
                            map.put(ucVarFw.pr(i), ucVarFw.hw(i));
                        }
                    }
                    InputStream inputStreamHn = ntVarHw.uc().hn();
                    vk vkVarPr = pr(map);
                    return new Pair<>(new WebResourceResponse(vkVarPr.pr() + "/" + vkVarPr.hw(), vkVarPr.hn() == null ? null : vkVarPr.hn().toString(), iHn, pr(iHn), map, inputStreamHn), vkVarPr);
                }
            } catch (Throwable th) {
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0030  */
    private vk pr(Map<String, String> map) {
        String str;
        if (map != null) {
            if (map.containsKey("Content-Type")) {
                str = map.get("Content-Type");
            } else if (map.containsKey("content-type")) {
                str = map.get("content-type");
            } else if (map.containsKey("CONTENT-TYPE")) {
                str = map.get("CONTENT-TYPE");
            } else {
                str = null;
            }
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "text/html; charset=UTF-8";
        }
        return vk.pr(str);
    }

    public static void pr(Context context) {
        if (!hn()) {
            return;
        }
        try {
            File file = new File(hw(context));
            if (System.currentTimeMillis() - file.lastModified() > 3000 && file.exists()) {
                com.byazt.ej.pr.hw(hw(context));
            }
        } catch (Throwable th) {
        }
    }

    public static String hw(Context context) {
        return com.byazt.ca.uc.hw(context, false, null).getAbsolutePath() + File.separator + ".lp_cache";
    }

    public void x() {
        if (!this.x.isEmpty()) {
            Iterator<com.byazt.xm.pr> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().hn();
            }
        }
        this.x.clear();
    }

    public void pr(WebView webView, String str) {
        if (yb.pr(str)) {
            this.hw.incrementAndGet();
            this.hw.get();
            Iterator<com.byazt.xm.pr> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().pr(str);
            }
        }
    }

    private String pr(int i) {
        switch (i) {
            case 100:
                return "Continue";
            case 101:
                return "Switching Protocols";
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
