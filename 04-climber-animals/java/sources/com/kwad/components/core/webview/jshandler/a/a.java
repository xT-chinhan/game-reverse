package com.kwad.components.core.webview.jshandler.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.core.webview.jshandler.e {

    /* JADX INFO: renamed from: com.kwad.components.core.webview.jshandler.a.a$a, reason: collision with other inner class name */
    public static class C0448a extends com.kwad.sdk.core.response.a.a {
        public String aeH;
    }

    @Override // com.kwad.components.core.webview.jshandler.e, com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "checkAppInstalled";
    }

    @Override // com.kwad.components.core.webview.jshandler.e
    public final String aS(String str) {
        try {
            C0448a c0448a = new C0448a();
            c0448a.parseJson(new JSONObject(str));
            return c0448a.aeH;
        } catch (Throwable unused) {
            return null;
        }
    }
}
