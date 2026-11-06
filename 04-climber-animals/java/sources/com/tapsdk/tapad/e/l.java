package com.tapsdk.tapad.e;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class l {

    static class b {
        public static l a = new l();

        b() {
        }
    }

    private l() {
    }

    public static l a() {
        return b.a;
    }

    private String a(String str) {
        try {
            return new JSONObject(str).optString("openid");
        } catch (Throwable unused) {
            return "";
        }
    }

    public String b() {
        String string;
        try {
            JSONObject jSONObject = new JSONObject(k.a());
            string = jSONObject.has("openid") ? jSONObject.getString("openid") : "";
        } catch (JSONException unused) {
        }
        if (string != null && string.length() != 0) {
            return string;
        }
        try {
            return a(com.tapsdk.tapad.c.a.getSharedPreferences("taptap_sharepreference", 0).getString("taptap_account", ""));
        } catch (Throwable unused2) {
            return string;
        }
    }
}
