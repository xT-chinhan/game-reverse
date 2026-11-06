package com.smartdigimkt.f3;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public String a;
    public int b;
    public String c;
    public String d;
    public String e;
    public long f;
    public String g;

    public static String a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("business_type", i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }
}
