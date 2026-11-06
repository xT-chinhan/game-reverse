package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class jn implements com.kwad.sdk.core.d<com.kwad.sdk.j.a.C0512a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.j.a.C0512a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.j.a.C0512a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.j.a.C0512a c0512a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0512a.aTs = jSONObject.optInt("ds");
        c0512a.sdkVersion = jSONObject.optString("sv");
        if (JSONObject.NULL.toString().equals(c0512a.sdkVersion)) {
            c0512a.sdkVersion = "";
        }
        c0512a.aOu = jSONObject.optString("spv");
        if (JSONObject.NULL.toString().equals(c0512a.aOu)) {
            c0512a.aOu = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.j.a.C0512a c0512a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0512a.aTs != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ds", c0512a.aTs);
        }
        if (c0512a.sdkVersion != null && !c0512a.sdkVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sv", c0512a.sdkVersion);
        }
        if (c0512a.aOu != null && !c0512a.aOu.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "spv", c0512a.aOu);
        }
        return jSONObject;
    }
}
