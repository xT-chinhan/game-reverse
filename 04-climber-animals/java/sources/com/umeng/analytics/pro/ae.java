package com.umeng.analytics.pro;

import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: AplAction.java */
/* JADX INFO: loaded from: classes4.dex */
public class ae extends ac {
    private String a;
    private String b;

    public String d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public void c(String str) {
        this.a = str;
    }

    public void d(String str) {
        this.b = str;
    }

    public ae(String str, ArrayList<ad> arrayList) {
        super(str, arrayList);
        this.a = "";
        this.b = "";
    }

    @Override // com.umeng.analytics.pro.ac, com.umeng.analytics.pro.ak
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObjectA = super.a(str, jSONObject);
        if (jSONObjectA != null) {
            try {
                jSONObjectA.put(com.umeng.ccg.a.y, this.a);
                jSONObjectA.put(com.umeng.ccg.a.z, this.b);
            } catch (Throwable unused) {
            }
        }
        return jSONObjectA;
    }

    @Override // com.umeng.analytics.pro.ac, com.umeng.analytics.pro.ak
    public void b(String str, JSONObject jSONObject) {
        super.b(str, jSONObject);
        if (jSONObject.has(com.umeng.ccg.a.z)) {
            d(jSONObject.optString(com.umeng.ccg.a.z));
        }
        if (jSONObject.has(com.umeng.ccg.a.y)) {
            c(jSONObject.optString(com.umeng.ccg.a.y));
        }
    }
}
