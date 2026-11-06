package com.bytedance.sdk.component.ms;

import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private sl f1271ms;

    static x ms(sl slVar) {
        return new x(slVar);
    }

    private x(sl slVar) {
        this.f1271ms = slVar;
    }

    <T> T ms(String str, Type type) throws JSONException {
        ms(str);
        if (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) {
            return (T) new JSONObject(str);
        }
        return (T) this.f1271ms.ms(str, type);
    }

    <T> String ms(T t) {
        String string;
        if (t == null) {
            return "{}";
        }
        if ((t instanceof JSONObject) || (t instanceof JSONArray)) {
            string = t.toString();
        } else {
            string = this.f1271ms.ms(t);
        }
        ms(string);
        return string;
    }

    private static void ms(String str) {
        if (str.startsWith("{") && str.endsWith("}")) {
            return;
        }
        ny.ms(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(String.valueOf(str))));
    }
}
