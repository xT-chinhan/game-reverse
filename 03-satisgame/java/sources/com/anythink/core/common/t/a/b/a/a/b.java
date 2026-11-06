package com.anythink.core.common.t.a.b.a.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final String h = "business_type";
    public static final int i = 1000;
    public static final int j = 1001;
    public String a;
    public int b;
    public String c;
    public String d;
    public String e;
    public long f;
    public String g;

    private static String a(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("business_type", i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    private String a() {
        return "content: " + this.e;
    }
}
