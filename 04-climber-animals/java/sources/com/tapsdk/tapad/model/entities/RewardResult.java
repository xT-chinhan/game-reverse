package com.tapsdk.tapad.model.entities;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class RewardResult {
    boolean isValid;

    public RewardResult(JSONObject jSONObject) {
        this.isValid = jSONObject.optBoolean("isValid", false);
    }
}
