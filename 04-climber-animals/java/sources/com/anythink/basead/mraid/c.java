package com.anythink.basead.mraid;

import android.util.Base64;
import android.webkit.WebView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.q;
import com.anythink.core.express.web.BaseWebView;
import com.anythink.network.tap.TapATInitManager;
import com.tencent.bugly.Bugly;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private static final String a = "FormatViewCallJS";

    private static void a(WebView webView) {
        f.a();
        f.a(webView);
    }

    private static void a(WebView webView, float f, float f2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startX", f);
            jSONObject.put("startY", f2);
            jSONObject.put("scale", q.h(t.b().g()));
            String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            f.a();
            f.a(webView, "webviewshow", strEncodeToString);
        } catch (Throwable unused) {
        }
    }

    private static void a(WebView webView, int i, int i2) {
        try {
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.a(webView, i, i2);
        } catch (Throwable unused) {
        }
    }

    public static void a(BaseWebView baseWebView, boolean z) {
        try {
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.b(baseWebView, z ? "true" : Bugly.SDK_IS_DEV);
        } catch (Throwable unused) {
        }
    }

    private static void a(WebView webView, int i, int i2, int i3, int i4) {
        String str;
        try {
            int i5 = t.b().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            if (i5 == 2) {
                str = "landscape";
            } else {
                str = i5 == 1 ? "portrait" : "undefined";
            }
            jSONObject.put(TapATInitManager.ORIENTATION_KEY, str);
            jSONObject.put("locked", "true");
            float fE = q.e(t.b().g());
            float f = q.f(t.b().g());
            HashMap mapG = q.g(t.b().g());
            int iIntValue = ((Integer) mapG.get("width")).intValue();
            int iIntValue2 = ((Integer) mapG.get("height")).intValue();
            HashMap map = new HashMap();
            map.put(com.anythink.core.express.b.a.a, com.anythink.core.express.b.a.k);
            map.put("state", com.anythink.core.express.b.a.f);
            map.put(com.anythink.core.express.b.a.c, "true");
            map.put(com.anythink.core.express.b.a.d, jSONObject);
            com.anythink.core.express.b.a.a();
            float f2 = i;
            float f3 = i2;
            float f4 = i3;
            float f5 = i4;
            com.anythink.core.express.b.a.a(webView, f2, f3, f4, f5);
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.b(webView, f2, f3, f4, f5);
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.b(webView, fE, f);
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.c(webView, iIntValue, iIntValue2);
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.a(webView, map);
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.a(webView);
        } catch (Throwable unused) {
        }
    }
}
