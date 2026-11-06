package com.onevcat.uniwebview;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class Y1 {
    public final String a;
    public final String b;
    public final String c;
    public final JSONObject d;

    public Y1(String identifier, String resultCode, String data, Map map) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(resultCode, "resultCode");
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = identifier;
        this.b = resultCode;
        this.c = data;
        if (map != null) {
            this.d = new JSONObject(map);
        }
    }

    public final String toString() {
        HashMap map = new HashMap();
        map.put("identifier", this.a);
        map.put("resultCode", this.b);
        map.put("data", this.c);
        JSONObject jSONObject = this.d;
        if (jSONObject != null) {
            map.put("extra", String.valueOf(jSONObject));
        }
        String string = new JSONObject(map).toString();
        Intrinsics.checkNotNullExpressionValue(string, "obj.toString()");
        return string;
    }
}
