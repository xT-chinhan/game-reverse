package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class kp implements com.kwad.sdk.core.d<com.kwad.sdk.o.l.a.C0518a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.o.l.a.C0518a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.o.l.a.C0518a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.o.l.a.C0518a c0518a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0518a.beg = jSONObject.optString("s_cn");
        if (JSONObject.NULL.toString().equals(c0518a.beg)) {
            c0518a.beg = "";
        }
        c0518a.beh = jSONObject.optString("s_mn");
        if (JSONObject.NULL.toString().equals(c0518a.beh)) {
            c0518a.beh = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.o.l.a.C0518a c0518a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0518a.beg != null && !c0518a.beg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "s_cn", c0518a.beg);
        }
        if (c0518a.beh != null && !c0518a.beh.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "s_mn", c0518a.beh);
        }
        return jSONObject;
    }
}
