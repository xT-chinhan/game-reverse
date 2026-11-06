package com.anythink.core.common;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static String a = "e";
    public static final String b = "cp_event_callback_info";
    public static final String c = "type_start_load";

    private static JSONObject a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.anythink.core.d.l.a.T, str);
                jSONObject.put("request_id", str2);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static void a(Object obj, String str, String str2, String str3, String str4) {
        if (obj == null) {
            return;
        }
        new StringBuilder("sendEventCallbackInfo------ enter: placementId: ").append(str2).append(", \neventType: ").append(str).append(", cpEventMap: ").append(obj);
        try {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                JSONObject jSONObjectA = a(str3, str4);
                if (jSONObjectA != null) {
                    map.put(str, jSONObjectA);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Object obj, String str, com.anythink.core.common.h.n nVar) {
        if (nVar == null) {
            return;
        }
        a(obj, str, nVar.aI(), nVar.aB(), nVar.aJ());
    }

    public static void a(Map<String, Object> map, String str, String str2, String str3, String str4) {
        if (map == null) {
            return;
        }
        a(map.get(b), str, str2, str3, str4);
    }
}
