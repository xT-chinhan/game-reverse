package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ha implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.b.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.b.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("Status");
        bVar.contentEncoding = jSONObject.optString("Content-Encoding");
        if (JSONObject.NULL.toString().equals(bVar.contentEncoding)) {
            bVar.contentEncoding = "";
        }
        bVar.aNx = jSONObject.optString("Cache-Control");
        if (JSONObject.NULL.toString().equals(bVar.aNx)) {
            bVar.aNx = "";
        }
        bVar.aNv = jSONObject.optString("Content-Type");
        if (JSONObject.NULL.toString().equals(bVar.aNv)) {
            bVar.aNv = "";
        }
        bVar.aNy = new com.kwad.sdk.core.webview.b.a.a();
        bVar.aNy.parseJson(jSONObject.optJSONObject(TTDownloadField.TT_HEADERS));
    }

    private static JSONObject b(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Status", bVar.status);
        }
        if (bVar.contentEncoding != null && !bVar.contentEncoding.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Content-Encoding", bVar.contentEncoding);
        }
        if (bVar.aNx != null && !bVar.aNx.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Cache-Control", bVar.aNx);
        }
        if (bVar.aNv != null && !bVar.aNv.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Content-Type", bVar.aNv);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, TTDownloadField.TT_HEADERS, bVar.aNy);
        return jSONObject;
    }
}
