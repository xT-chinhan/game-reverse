package com.smartdigimkt.j2;

import android.webkit.WebView;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public final JSONObject a;
    public final HashMap b = new HashMap(3);

    public e(com.smartdigimkt.b3.c cVar) {
        JSONObject jSONObject;
        if (cVar != null) {
            try {
                jSONObject = new JSONObject(cVar.y);
            } catch (Throwable unused) {
                return;
            }
        } else {
            jSONObject = null;
        }
        this.a = jSONObject;
    }

    public final void a(WebView webView, String str) {
        JSONObject jSONObject = this.a;
        if (jSONObject == null) {
            return;
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && str != null && str.contains(next) && this.b.get(next) == null) {
                    this.b.put(next, Boolean.TRUE);
                    webView.loadUrl(this.a.optString(next));
                }
            }
        } catch (Throwable unused) {
        }
    }
}
