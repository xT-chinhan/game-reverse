package com.byazt.lu;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.cq.tj;
import com.byazt.gct.pk;
import com.byazt.gct.v;
import com.byazt.ho.BaseConstants;
import com.byazt.imu.s;
import com.byazt.tk.k;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1843, 19})
public final class n {

    /* JADX INFO: renamed from: com.byazt.lu.n$n, reason: collision with other inner class name */
    public interface InterfaceC0242n {
        com.byazt.mzw.n n(String str, tj.n nVar, String str2);

        boolean n();
    }

    public static com.byazt.mzw.n n(WebView webView, pk pkVar, String str, InterfaceC0242n interfaceC0242n) {
        v next;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        tj.n nVarN = tj.n(str);
        boolean z = interfaceC0242n != null && interfaceC0242n.n();
        if (nVarN != tj.n.IMAGE && z && pkVar != null) {
            Iterator<v> it = pkVar.jo().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (!TextUtils.isEmpty(next.n()) && !TextUtils.isEmpty(str)) {
                    String strN = next.n();
                    if (strN.startsWith(BaseConstants.SCHEME_HTTPS)) {
                        strN = strN.replaceFirst(BaseConstants.SCHEME_HTTPS, "http");
                    }
                    if ((str.startsWith(BaseConstants.SCHEME_HTTPS) ? str.replaceFirst(BaseConstants.SCHEME_HTTPS, "http") : str).equals(strN)) {
                        break;
                    }
                }
            }
        } else {
            next = null;
            break;
        }
        if (nVarN == tj.n.IMAGE) {
            com.byazt.mzw.n nVar = new com.byazt.mzw.n();
            nVar.n(5);
            nVar.n(n(str, com.byazt.ns.qg.qg(pkVar, str)));
            return nVar;
        }
        if (next == null) {
            if (interfaceC0242n == null) {
                return null;
            }
            return interfaceC0242n.n(str, nVarN, "");
        }
        com.byazt.mzw.n nVar2 = new com.byazt.mzw.n();
        nVar2.n(n(str, next.x()));
        nVar2.n(5);
        return nVar2;
    }

    private static WebResourceResponse n(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream inputStreamN = s.n(str, str2);
            if (inputStreamN == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(tj.n.IMAGE.getType(), "utf-8", inputStreamN);
            try {
                Map<String, String> responseHeaders = webResourceResponse2.getResponseHeaders();
                if (responseHeaders == null) {
                    responseHeaders = new HashMap<>();
                }
                responseHeaders.put("Access-Control-Allow-Origin", "*");
                webResourceResponse2.setResponseHeaders(responseHeaders);
                return webResourceResponse2;
            } catch (Throwable th) {
                th = th;
                webResourceResponse = webResourceResponse2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        k.n("CacheInterceptUtil", "get image WebResourceResponse error", th);
        return webResourceResponse;
    }
}
