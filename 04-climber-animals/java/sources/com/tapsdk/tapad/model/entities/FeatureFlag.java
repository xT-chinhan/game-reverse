package com.tapsdk.tapad.model.entities;

import com.anythink.core.common.e.f;
import com.taptap.sdk.db.constant.Common;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FeatureFlag {
    public final String name;
    public final String value;

    public FeatureFlag(JSONObject jSONObject) throws JSONException {
        this.name = jSONObject.optString(Common.System.NAME);
        this.value = jSONObject.optString(f.a.d);
    }

    public String toString() {
        return "FeatureFlag{name='" + this.name + "', value='" + this.value + "'}";
    }
}
