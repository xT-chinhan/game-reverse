package com.smartdigimkt.o4;

import java.util.ArrayList;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public j a;
    public ArrayList b;

    public static m a(JSONObject jSONObject) {
        j jVar = null;
        if (jSONObject == null) {
            return null;
        }
        m mVar = new m();
        if (jSONObject.has("interaction_global")) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("interaction_global");
                if (jSONObject2 != null) {
                    jVar = new j();
                    jVar.a = jSONObject2.optInt("sw", 2);
                    jVar.b = jSONObject2.optLong("triggers_time", 20L);
                    jVar.c = jSONObject2.optInt("daily_trigger_times", 200);
                }
                mVar.a = jVar;
                Objects.toString(jVar);
            } catch (JSONException unused) {
            }
        }
        if (jSONObject.has("interaction_list")) {
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("interaction_list");
                mVar.b = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        i iVar = new i();
                        iVar.a = jSONObjectOptJSONObject.optInt("interaction_type", 1);
                        iVar.b = jSONObjectOptJSONObject.optInt("trigger_rate", 50);
                        iVar.c = jSONObjectOptJSONObject.optLong("triggers_time", 30L);
                        iVar.d = jSONObjectOptJSONObject.optInt("daily_trigger_times", 100);
                        mVar.b.add(iVar);
                        Objects.toString(iVar);
                    }
                }
                mVar.b.size();
            } catch (Exception unused2) {
            }
        }
        mVar.toString();
        return mVar;
    }

    public final String toString() {
        return "InteractionStrategyConfig{cross=" + this.a + ", types=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
