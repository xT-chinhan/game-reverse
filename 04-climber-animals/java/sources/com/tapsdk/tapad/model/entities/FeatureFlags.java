package com.tapsdk.tapad.model.entities;

import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public class FeatureFlags {
    public final List<FeatureFlag> flags = new ArrayList();

    public FeatureFlags(JSONArray jSONArray) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            this.flags.add(new FeatureFlag(jSONArray.getJSONObject(i)));
        }
    }

    public String toString() {
        return "FeatureFlags{flags=" + this.flags + AbstractJsonLexerKt.END_OBJ;
    }
}
