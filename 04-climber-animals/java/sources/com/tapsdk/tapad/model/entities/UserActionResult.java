package com.tapsdk.tapad.model.entities;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UserActionResult {
    public int code;
    public String message;

    public UserActionResult(JSONObject jSONObject) throws JSONException {
        this.code = jSONObject.optInt("code");
        this.message = jSONObject.optString("message");
    }
}
