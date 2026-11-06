package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ll implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.j.a.C0483a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.j.a.C0483a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.j.a.C0483a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.j.a.C0483a c0483a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0483a.aww = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("blackList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                c0483a.aww.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.j.a.C0483a c0483a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "blackList", c0483a.aww);
        return jSONObject;
    }
}
