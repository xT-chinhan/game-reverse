package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class la implements com.kwad.sdk.core.d<com.kwad.sdk.core.h.a.C0497a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.h.a.C0497a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.h.a.C0497a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.h.a.C0497a c0497a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0497a.aJY = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sdk_version");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                c0497a.aJY.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        c0497a.aJZ = jSONObject.optInt(com.umeng.analytics.pro.bv.y);
        c0497a.aKa = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("abi");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                c0497a.aKa.add((String) jSONArrayOptJSONArray2.opt(i2));
            }
        }
        c0497a.aKb = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("brand");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                c0497a.aKb.add((String) jSONArrayOptJSONArray3.opt(i3));
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.core.h.a.C0497a c0497a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdk_version", c0497a.aJY);
        if (c0497a.aJZ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.umeng.analytics.pro.bv.y, c0497a.aJZ);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "abi", c0497a.aKa);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "brand", c0497a.aKb);
        return jSONObject;
    }
}
