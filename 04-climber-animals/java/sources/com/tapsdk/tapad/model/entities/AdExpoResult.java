package com.tapsdk.tapad.model.entities;

import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AdExpoResult {
    public final List<AdExpoInfo> expoInfoList = new ArrayList();

    public AdExpoResult(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("AdsConf");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    this.expoInfoList.add(new AdExpoInfo(jSONObject2));
                }
            }
        }
    }

    public String toString() {
        return "AdExpoResult{expoInfoList=" + this.expoInfoList + AbstractJsonLexerKt.END_OBJ;
    }
}
