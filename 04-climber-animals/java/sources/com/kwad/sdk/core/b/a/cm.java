package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cm implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.h.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.h.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.h.c) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.style = jSONObject.optInt("style");
        cVar.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(cVar.title)) {
            cVar.title = "";
        }
        cVar.sS = jSONObject.optString("closeBtnText");
        if (JSONObject.NULL.toString().equals(cVar.sS)) {
            cVar.sS = "";
        }
        cVar.sT = jSONObject.optString("continueBtnText");
        if (JSONObject.NULL.toString().equals(cVar.sT)) {
            cVar.sT = "";
        }
        cVar.sU = jSONObject.optString("viewDetailText");
        if (JSONObject.NULL.toString().equals(cVar.sU)) {
            cVar.sU = "";
        }
        cVar.sV = jSONObject.optString("unWatchedVideoTime");
        if (JSONObject.NULL.toString().equals(cVar.sV)) {
            cVar.sV = "";
        }
        cVar.sW = jSONObject.optString("iconUrl");
        if (JSONObject.NULL.toString().equals(cVar.sW)) {
            cVar.sW = "";
        }
        cVar.sX = jSONObject.optString(com.anythink.basead.c.b.a.f);
        if (JSONObject.NULL.toString().equals(cVar.sX)) {
            cVar.sX = "";
        }
        cVar.sY = jSONObject.optString("descTxt");
        if (JSONObject.NULL.toString().equals(cVar.sY)) {
            cVar.sY = "";
        }
        cVar.sZ = jSONObject.optString("currentPlayTime");
        if (JSONObject.NULL.toString().equals(cVar.sZ)) {
            cVar.sZ = "";
        }
    }

    private static JSONObject b(com.kwad.components.ad.reward.h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.style != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "style", cVar.style);
        }
        if (cVar.title != null && !cVar.title.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", cVar.title);
        }
        if (cVar.sS != null && !cVar.sS.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeBtnText", cVar.sS);
        }
        if (cVar.sT != null && !cVar.sT.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "continueBtnText", cVar.sT);
        }
        if (cVar.sU != null && !cVar.sU.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "viewDetailText", cVar.sU);
        }
        if (cVar.sV != null && !cVar.sV.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "unWatchedVideoTime", cVar.sV);
        }
        if (cVar.sW != null && !cVar.sW.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "iconUrl", cVar.sW);
        }
        if (cVar.sX != null && !cVar.sX.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.anythink.basead.c.b.a.f, cVar.sX);
        }
        if (cVar.sY != null && !cVar.sY.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "descTxt", cVar.sY);
        }
        if (cVar.sZ != null && !cVar.sZ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentPlayTime", cVar.sZ);
        }
        return jSONObject;
    }
}
