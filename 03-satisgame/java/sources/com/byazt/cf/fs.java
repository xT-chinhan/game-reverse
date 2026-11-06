package com.byazt.cf;

import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 93, 101})
public final class fs {
    public d n;

    public static fs n(d dVar) {
        return new fs(dVar);
    }

    private fs(d dVar) {
        this.n = dVar;
    }

    public <T> T n(String str, Type type) throws JSONException {
        n(str);
        if (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) {
            return (T) new JSONObject(str);
        }
        return (T) this.n.n(str, type);
    }

    public <T> String n(T t) {
        String string;
        if (t == null) {
            return "{}";
        }
        if ((t instanceof JSONObject) || (t instanceof JSONArray)) {
            string = t.toString();
        } else {
            string = this.n.n(t);
        }
        n(string);
        return string;
    }

    private static void n(String str) {
        if (str.startsWith("{") && str.endsWith("}")) {
            return;
        }
        rv.n(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(String.valueOf(str))));
    }
}
