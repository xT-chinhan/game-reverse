package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ef implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.c.e.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.c.e.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.c.e.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.c.e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.uo = jSONObject.optString("dialogEvent");
        if (JSONObject.NULL.toString().equals(aVar.uo)) {
            aVar.uo = "";
        }
    }

    private static JSONObject b(com.kwad.components.ad.reward.c.e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.uo != null && !aVar.uo.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dialogEvent", aVar.uo);
        }
        return jSONObject;
    }
}
