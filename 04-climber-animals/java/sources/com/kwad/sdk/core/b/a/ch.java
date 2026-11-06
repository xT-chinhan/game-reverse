package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ch implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.a.C0485a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.a.C0485a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.a.C0485a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.a.C0485a c0485a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0485a.awU = jSONObject.optInt("ad_retry_type");
        c0485a.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(c0485a.templateId)) {
            c0485a.templateId = "";
        }
        c0485a.awV = jSONObject.optString("template_sub_id");
        if (JSONObject.NULL.toString().equals(c0485a.awV)) {
            c0485a.awV = "";
        }
        c0485a.awW = jSONObject.optString("default_type");
        if (JSONObject.NULL.toString().equals(c0485a.awW)) {
            c0485a.awW = "";
        }
        c0485a.awY = jSONObject.optString("template_show_type");
        if (JSONObject.NULL.toString().equals(c0485a.awY)) {
            c0485a.awY = "";
        }
        c0485a.awZ = jSONObject.optInt("network_download_status", new Integer("3").intValue());
        c0485a.axa = jSONObject.optInt("award_task_name");
        c0485a.axb = jSONObject.optInt("jumps_liveroom_type");
        c0485a.axc = jSONObject.optInt("universe_feature_freg");
        c0485a.axd = jSONObject.optInt("replace_url_succ");
        c0485a.axe = jSONObject.optBoolean("is_dp_opt");
        c0485a.axf = jSONObject.optString("component_module");
        if (JSONObject.NULL.toString().equals(c0485a.axf)) {
            c0485a.axf = "";
        }
        c0485a.axh = jSONObject.optInt("is_carousel");
        c0485a.axi = jSONObject.optInt("is_special_preload");
        c0485a.axj = jSONObject.optInt("card_type");
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.a.C0485a c0485a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0485a.awU != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_retry_type", c0485a.awU);
        }
        if (c0485a.templateId != null && !c0485a.templateId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_id", c0485a.templateId);
        }
        if (c0485a.awV != null && !c0485a.awV.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_sub_id", c0485a.awV);
        }
        if (c0485a.awW != null && !c0485a.awW.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "default_type", c0485a.awW);
        }
        if (c0485a.awY != null && !c0485a.awY.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_show_type", c0485a.awY);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "network_download_status", c0485a.awZ);
        if (c0485a.axa != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "award_task_name", c0485a.axa);
        }
        if (c0485a.axb != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jumps_liveroom_type", c0485a.axb);
        }
        if (c0485a.axc != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "universe_feature_freg", c0485a.axc);
        }
        if (c0485a.axd != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "replace_url_succ", c0485a.axd);
        }
        if (c0485a.axe) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_dp_opt", c0485a.axe);
        }
        if (c0485a.axf != null && !c0485a.axf.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "component_module", c0485a.axf);
        }
        if (c0485a.axh != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_carousel", c0485a.axh);
        }
        if (c0485a.axi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_special_preload", c0485a.axi);
        }
        if (c0485a.axj != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "card_type", c0485a.axj);
        }
        return jSONObject;
    }
}
