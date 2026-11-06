package com.anythink.core.common.b;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private int[] a;
    private c b;

    public final int[] a() {
        return this.a;
    }

    private void a(int[] iArr) {
        this.a = iArr;
    }

    public final c b() {
        return this.b;
    }

    private void a(c cVar) {
        this.b = cVar;
    }

    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("range");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() >= 2) {
            dVar.a = new int[]{jSONArrayOptJSONArray.optInt(0, 0), jSONArrayOptJSONArray.optInt(1, 0)};
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.anythink.core.e.b.a.C);
        if (jSONObjectOptJSONObject != null) {
            dVar.b = c.a(jSONObjectOptJSONObject);
        }
        return dVar;
    }

    public final String toString() {
        return "AnrDynaStrategyItem{range=" + Arrays.toString(this.a) + ", strategy=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
