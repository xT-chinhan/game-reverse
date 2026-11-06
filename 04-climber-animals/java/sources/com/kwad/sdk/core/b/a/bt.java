package com.kwad.sdk.core.b.a;

import com.taptap.sdk.db.constant.Common;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bt implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.k.m.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.k.m.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.k.m.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.k.m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.name = jSONObject.optString(Common.System.NAME);
        if (JSONObject.NULL.toString().equals(aVar.name)) {
            aVar.name = "";
        }
    }

    private static JSONObject b(com.kwad.components.ad.reward.k.m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.name != null && !aVar.name.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, Common.System.NAME, aVar.name);
        }
        return jSONObject;
    }
}
