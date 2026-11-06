package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gb implements com.kwad.sdk.core.d<com.kwad.components.ad.j.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.j.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.j.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.j.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.LM = jSONObject.optString("device_model");
        if (JSONObject.NULL.toString().equals(aVar.LM)) {
            aVar.LM = "";
        }
        aVar.LN = jSONObject.optString(com.umeng.analytics.pro.bv.F);
        if (JSONObject.NULL.toString().equals(aVar.LN)) {
            aVar.LN = "";
        }
        aVar.LO = jSONObject.optString(com.umeng.analytics.pro.bv.y);
        if (JSONObject.NULL.toString().equals(aVar.LO)) {
            aVar.LO = "";
        }
        aVar.LP = jSONObject.optString("rom_name");
        if (JSONObject.NULL.toString().equals(aVar.LP)) {
            aVar.LP = "";
        }
        aVar.LQ = jSONObject.optString("device_id");
        if (JSONObject.NULL.toString().equals(aVar.LQ)) {
            aVar.LQ = "";
        }
        aVar.status = jSONObject.optInt("status");
        aVar.LR = jSONObject.optString("install_check_record");
        if (JSONObject.NULL.toString().equals(aVar.LR)) {
            aVar.LR = "";
        }
        aVar.LS = jSONObject.optString("local_installer_pkgs");
        if (JSONObject.NULL.toString().equals(aVar.LS)) {
            aVar.LS = "";
        }
    }

    private static JSONObject b(com.kwad.components.ad.j.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.LM != null && !aVar.LM.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "device_model", aVar.LM);
        }
        if (aVar.LN != null && !aVar.LN.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.umeng.analytics.pro.bv.F, aVar.LN);
        }
        if (aVar.LO != null && !aVar.LO.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.umeng.analytics.pro.bv.y, aVar.LO);
        }
        if (aVar.LP != null && !aVar.LP.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rom_name", aVar.LP);
        }
        if (aVar.LQ != null && !aVar.LQ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "device_id", aVar.LQ);
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", aVar.status);
        }
        if (aVar.LR != null && !aVar.LR.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "install_check_record", aVar.LR);
        }
        if (aVar.LS != null && !aVar.LS.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "local_installer_pkgs", aVar.LS);
        }
        return jSONObject;
    }
}
