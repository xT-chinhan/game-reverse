package com.smartdigimkt.k2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message", str);
            jSONObject.put(com.anythink.core.common.l.f.R, new JSONObject());
            com.smartdigimkt.o2.a.a().a(obj, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    public static void b(Object obj, String str) {
        try {
            com.smartdigimkt.o2.a.a().b(obj, str);
        } catch (Exception e) {
            a(obj, e.getMessage());
        }
    }

    public static void a(Object obj, JSONObject jSONObject) {
        try {
            new JSONObject().put(com.anythink.core.common.l.f.R, jSONObject);
            com.smartdigimkt.o2.a.a().b(obj, jSONObject.toString());
        } catch (Exception e) {
            a(obj, e.getMessage());
        }
    }
}
