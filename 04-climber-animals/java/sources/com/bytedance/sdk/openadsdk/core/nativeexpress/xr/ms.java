package com.bytedance.sdk.openadsdk.core.nativeexpress.xr;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.d.ch;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ms {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.xr.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0297ms {
        com.bytedance.sdk.component.adexpress.ms.xr.ms ms(String str, ch.ms msVar, String str2);

        boolean ms();
    }

    public static com.bytedance.sdk.component.adexpress.ms.xr.ms ms(WebView webView, lm lmVar, String str, InterfaceC0297ms interfaceC0297ms) {
        g next;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ch.ms msVarMs = ch.ms(str);
        boolean z = interfaceC0297ms != null && interfaceC0297ms.ms();
        if (msVarMs != ch.ms.IMAGE && z && lmVar != null) {
            Iterator<g> it = lmVar.fk().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (!TextUtils.isEmpty(next.ms()) && !TextUtils.isEmpty(str)) {
                    String strMs = next.ms();
                    if (strMs.startsWith("https")) {
                        strMs = strMs.replaceFirst("https", "http");
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", "http") : str).equals(strMs)) {
                        break;
                    }
                }
            }
        } else {
            next = null;
            break;
        }
        if (msVarMs == ch.ms.IMAGE) {
            com.bytedance.sdk.component.adexpress.ms.xr.ms msVar = new com.bytedance.sdk.component.adexpress.ms.xr.ms();
            msVar.ms(5);
            msVar.ms(ms(str, xr.ms(lmVar, str)));
            return msVar;
        }
        if (next == null) {
            if (interfaceC0297ms == null) {
                return null;
            }
            return interfaceC0297ms.ms(str, msVarMs, "");
        }
        com.bytedance.sdk.component.adexpress.ms.xr.ms msVar2 = new com.bytedance.sdk.component.adexpress.ms.xr.ms();
        msVar2.ms(ms(str, next.ab()));
        msVar2.ms(5);
        return msVar2;
    }

    private static WebResourceResponse ms(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream inputStreamMs = com.bytedance.sdk.openadsdk.x.xr.ms(str, str2);
            if (inputStreamMs == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(ch.ms.IMAGE.getType(), "utf-8", inputStreamMs);
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
        sl.ah("CacheInterceptUtil", "get image WebResourceResponse error", th);
        return webResourceResponse;
    }
}
