package com.tapsdk.tapad.internal.network;

import com.tapsdk.tapad.internal.network.c.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ResponseBean<T> {
    public final T data;
    public final boolean success;

    ResponseBean(JSONObject jSONObject, Class<T> cls) throws JSONException {
        this.success = jSONObject.optBoolean("success");
        this.data = jSONObject.has("data") ? (T) b.a(jSONObject.getJSONObject("data"), cls) : null;
    }
}
