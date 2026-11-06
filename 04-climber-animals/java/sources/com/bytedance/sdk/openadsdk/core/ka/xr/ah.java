package com.bytedance.sdk.openadsdk.core.ka.xr;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public int f2818ms;
    public Map<String, Boolean> xr;

    public static ah ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("error_code");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        HashMap map = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, Boolean.valueOf(jSONObjectOptJSONObject.optBoolean(next)));
        }
        ah ahVar = new ah();
        ahVar.xr = map;
        ahVar.f2818ms = iOptInt;
        return ahVar;
    }
}
