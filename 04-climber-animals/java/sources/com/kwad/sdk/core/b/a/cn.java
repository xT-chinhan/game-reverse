package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cn implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.k.f.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.k.f.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.k.f.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.k.f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.AC = jSONObject.optBoolean("forceClose");
    }

    private static JSONObject b(com.kwad.components.ad.reward.k.f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.AC) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "forceClose", aVar.AC);
        }
        return jSONObject;
    }
}
