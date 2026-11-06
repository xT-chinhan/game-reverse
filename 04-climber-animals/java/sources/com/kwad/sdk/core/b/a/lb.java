package com.kwad.sdk.core.b.a;

import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class lb implements com.kwad.sdk.core.d<com.kwad.sdk.n.a.b.C0516b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.a.b.C0516b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.a.b.C0516b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.a.b.C0516b c0516b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0516b.name = jSONObject.optString(Common.System.NAME);
        if (JSONObject.NULL.toString().equals(c0516b.name)) {
            c0516b.name = "";
        }
        c0516b.aXE = jSONObject.optBoolean("isStatic");
        c0516b.aXF = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("paramList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                com.kwad.sdk.n.a.b.a aVar = new com.kwad.sdk.n.a.b.a();
                aVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                c0516b.aXF.add(aVar);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.n.a.b.C0516b c0516b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0516b.name != null && !c0516b.name.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, Common.System.NAME, c0516b.name);
        }
        if (c0516b.aXE) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isStatic", c0516b.aXE);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "paramList", c0516b.aXF);
        return jSONObject;
    }
}
