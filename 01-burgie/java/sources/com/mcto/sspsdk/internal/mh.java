package com.mcto.sspsdk.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class mh {
    public final int d;
    public int e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public JSONObject m;
    public HashMap o;
    public ConcurrentHashMap p;
    public String q;
    public String r;
    public String s;
    public JSONObject u;
    public JSONObject v;
    public int a = 1;
    public final AtomicBoolean b = new AtomicBoolean(false);
    public boolean c = false;
    public HashMap n = new HashMap(0);
    public int t = 0;

    public mh(int i, String str, String str2) {
        this.d = -1;
        this.g = str;
        this.f = str2;
        this.d = i;
    }

    public final String a(String str, String str2) {
        JSONObject jSONObject;
        if (lj.b(str) || (jSONObject = this.m) == null) {
            return "";
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String strValueOf = String.valueOf(itKeys.next());
                if (str.startsWith(strValueOf)) {
                    JSONObject jSONObjectOptJSONObject = this.m.optJSONObject(strValueOf);
                    if (jSONObjectOptJSONObject == null) {
                        break;
                    }
                    return jSONObjectOptJSONObject.optString(str2);
                }
            }
        } catch (Exception e) {
            r9.a("ssp_sdk", "getPbpValue(): ", e);
        }
        return "";
    }
}
