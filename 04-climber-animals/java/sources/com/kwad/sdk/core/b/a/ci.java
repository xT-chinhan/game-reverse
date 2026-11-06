package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ci implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.n.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.report.n.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.report.n.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.report.n.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aHN = jSONObject.optInt("posIdWidth");
        aVar.aHO = jSONObject.optInt("posIdHeight");
    }

    private static JSONObject b(com.kwad.sdk.core.report.n.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aHN != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posIdWidth", aVar.aHN);
        }
        if (aVar.aHO != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posIdHeight", aVar.aHO);
        }
        return jSONObject;
    }
}
