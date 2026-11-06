package com.smartdigimkt.r4;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    public static String a() {
        return TextUtils.isEmpty("UA_6.5.90") ? "UA_0.0.0" : "UA_6.5.90";
    }

    public static void a(WebView webView) {
        if (webView == null) {
            return;
        }
        webView.removeJavascriptInterface("searchBoxjavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setAllowFileAccessFromFileURLs(false);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        webView.getSettings().setSavePassword(false);
    }

    public static String a(com.smartdigimkt.b3.c cVar) {
        com.smartdigimkt.b3.e eVar;
        String str = cVar.m + cVar.a;
        boolean z = cVar instanceof com.smartdigimkt.b3.l;
        if (z && (eVar = cVar.w) != null) {
            if (eVar.w0 != 2) {
                str = (z ? ((com.smartdigimkt.b3.l) cVar).c0 : "") + cVar.m + cVar.a;
            } else {
                str = (z ? ((com.smartdigimkt.b3.l) cVar).c0 : "") + cVar.m;
            }
        }
        return i.b(str + (SDKContext.getInstance().d() != null ? SDKContext.getInstance().d().getPackageName() : ""));
    }

    public static String a(Context context) {
        String strH = SDKContext.getInstance().h();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(h.b(context));
        stringBuffer.append("&");
        stringBuffer.append(strH);
        stringBuffer.append("&");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("&");
        stringBuffer.append(new Random().nextInt(10000));
        return i.b(stringBuffer.toString());
    }

    public static String a(String str) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "0":
                return com.anythink.core.common.d.i.o.a;
            case "1":
                return com.anythink.core.common.d.i.o.b;
            case "2":
                return com.anythink.core.common.d.i.o.c;
            case "3":
                return com.anythink.core.common.d.i.o.d;
            case "4":
                return com.anythink.core.common.d.i.o.e;
            default:
                return "";
        }
    }
}
