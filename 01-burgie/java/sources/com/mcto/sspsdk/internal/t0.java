package com.mcto.sspsdk.internal;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 {
    public int a;
    public long b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public String m;
    public String n;
    public int o;
    public String p;

    public final t0 a(String str) {
        this.f = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.j = jSONObject.optInt("downloadToolType", 0);
            this.l = jSONObject.optInt("firstDownloadType", 0);
            this.m = jSONObject.optString("downloadPackageName");
            this.n = jSONObject.optString("downloadDeepLink");
            return this;
        } catch (JSONException e) {
            e.printStackTrace();
            return this;
        }
    }
}
