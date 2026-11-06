package com.anythink.basead.webtemplet;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "a";

    public static void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            com.anythink.basead.webtemplet.a.c.a().b(obj, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    public static void b(Object obj, String str) {
        try {
            com.anythink.basead.webtemplet.a.c.a().a(obj, str);
        } catch (Exception e) {
            a(obj, e.getMessage());
        }
    }

    public static void a(Object obj, JSONObject jSONObject) {
        try {
            new JSONObject().put("data", jSONObject);
            com.anythink.basead.webtemplet.a.c.a().a(obj, jSONObject.toString());
        } catch (Exception e) {
            a(obj, e.getMessage());
        }
    }
}
