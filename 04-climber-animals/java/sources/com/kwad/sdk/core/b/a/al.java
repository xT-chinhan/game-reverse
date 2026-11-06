package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class al implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.a.C0447a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.a.C0447a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.a.C0447a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.a.C0447a c0447a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0447a.NN = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(c0447a.NN)) {
            c0447a.NN = "";
        }
        c0447a.acf = jSONObject.optString("targetMethod");
        if (JSONObject.NULL.toString().equals(c0447a.acf)) {
            c0447a.acf = "";
        }
        c0447a.acg = jSONObject.optString("methodParams");
        if (JSONObject.NULL.toString().equals(c0447a.acg)) {
            c0447a.acg = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.a.C0447a c0447a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0447a.NN != null && !c0447a.NN.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", c0447a.NN);
        }
        if (c0447a.acf != null && !c0447a.acf.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "targetMethod", c0447a.acf);
        }
        if (c0447a.acg != null && !c0447a.acg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "methodParams", c0447a.acg);
        }
        return jSONObject;
    }
}
