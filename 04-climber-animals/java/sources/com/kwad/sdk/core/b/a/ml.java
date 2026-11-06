package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ml implements com.kwad.sdk.core.d<com.kwad.sdk.o.l.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.o.l.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.o.l.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.o.l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bee = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("c_cns");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                aVar.bee.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        aVar.bef = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("s_cns");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                com.kwad.sdk.o.l.a.C0518a c0518a = new com.kwad.sdk.o.l.a.C0518a();
                c0518a.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                aVar.bef.add(c0518a);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.o.l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "c_cns", aVar.bee);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "s_cns", aVar.bef);
        return jSONObject;
    }
}
