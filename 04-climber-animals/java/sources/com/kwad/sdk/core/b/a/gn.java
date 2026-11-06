package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gn implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.bi.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.bi.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.bi.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.bi.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.mI = jSONObject.optInt("itemClickType");
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.bi.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.mI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemClickType", aVar.mI);
        }
        return jSONObject;
    }
}
