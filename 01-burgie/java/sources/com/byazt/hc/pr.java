package com.byazt.hc;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.ca.ho;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.of;
import com.byazt.hg.y;
import com.byazt.js.vk;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2027, 37})
public final class pr {

    /* JADX INFO: renamed from: com.byazt.hc.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0083pr {
        com.byazt.ce.pr pr(String str, vk.pr prVar, String str2);

        boolean pr();
    }

    public static com.byazt.ce.pr pr(WebView webView, of ofVar, String str, InterfaceC0083pr interfaceC0083pr) {
        y next;
        String strReplaceFirst;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        vk.pr prVarPr = vk.pr(str);
        boolean z = interfaceC0083pr != null && interfaceC0083pr.pr();
        if (prVarPr != vk.pr.IMAGE && z && ofVar != null) {
            Iterator<y> it = ofVar.de().iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (!TextUtils.isEmpty(next.pr()) && !TextUtils.isEmpty(str)) {
                        String strPr = next.pr();
                        if (strPr.startsWith(BaseConstants.SCHEME_HTTPS)) {
                            strPr = strPr.replaceFirst(BaseConstants.SCHEME_HTTPS, "http");
                        }
                        if (!str.startsWith(BaseConstants.SCHEME_HTTPS)) {
                            strReplaceFirst = str;
                        } else {
                            strReplaceFirst = str.replaceFirst(BaseConstants.SCHEME_HTTPS, "http");
                        }
                        if (strReplaceFirst.equals(strPr)) {
                            break;
                        }
                    }
                } else {
                    next = null;
                    break;
                }
            }
        } else {
            next = null;
            break;
        }
        if (prVarPr == vk.pr.IMAGE) {
            com.byazt.ce.pr prVar = new com.byazt.ce.pr();
            prVar.pr(5);
            prVar.pr(pr(str, hw.hw(ofVar, str)));
            return prVar;
        }
        if (next != null) {
            com.byazt.ce.pr prVar2 = new com.byazt.ce.pr();
            prVar2.pr(pr(str, next.fw()));
            prVar2.pr(5);
            return prVar2;
        }
        if (interfaceC0083pr == null) {
            return null;
        }
        return interfaceC0083pr.pr(str, prVarPr, "");
    }

    private static WebResourceResponse pr(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream inputStreamPr = com.byazt.ub.hw.pr(str, str2);
            if (inputStreamPr == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(vk.pr.IMAGE.getType(), "utf-8", inputStreamPr);
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    Map<String, String> responseHeaders = webResourceResponse2.getResponseHeaders();
                    if (responseHeaders == null) {
                        responseHeaders = new HashMap<>();
                    }
                    responseHeaders.put("Access-Control-Allow-Origin", "*");
                    webResourceResponse2.setResponseHeaders(responseHeaders);
                }
                return webResourceResponse2;
            } catch (Throwable th) {
                th = th;
                webResourceResponse = webResourceResponse2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        ho.pr("CacheInterceptUtil", "get image WebResourceResponse error", th);
        return webResourceResponse;
    }
}
