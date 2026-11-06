package com.tapsdk.tapad.model.entities;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public final String a;
    public final ApkInfoDetails b;

    private a() throws JSONException {
        this.a = "";
        this.b = new ApkInfoDetails(new JSONObject(""));
    }

    public a(JSONObject jSONObject) throws JSONException {
        this.a = jSONObject.optString("track_id");
        this.b = new ApkInfoDetails(jSONObject.getJSONObject("apk_info"));
    }
}
