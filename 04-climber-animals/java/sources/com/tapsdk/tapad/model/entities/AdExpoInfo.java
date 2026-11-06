package com.tapsdk.tapad.model.entities;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AdExpoInfo {
    public int expoStatus;
    public String trackId;

    public AdExpoInfo(JSONObject jSONObject) {
        this.trackId = jSONObject.optString("track_id");
        this.expoStatus = jSONObject.optInt("expo_status");
    }

    public String toString() {
        return "AdExpoInfo{trackId='" + this.trackId + "', expoStatus=" + this.expoStatus + AbstractJsonLexerKt.END_OBJ;
    }
}
