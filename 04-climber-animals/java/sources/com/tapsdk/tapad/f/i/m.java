package com.tapsdk.tapad.f.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
class m {
    private static String c = "TapAD_OAID";
    private static String d = "TapAD_OAID_Manufacturer_SP_NAME";
    private static String e = "TapAD_OAID_ERROR";
    private static String f = "TapAD_OAID_UNSUPPORTED_MSG";
    private static String g = "TapAD_OAID_UNSUPPORTED_IS_PUSH";
    private static String h = "TapAD_OAID_ERROR_IS_PUSH";
    final SharedPreferences a;
    private com.tapsdk.tapad.internal.o.a.a b = com.tapsdk.tapad.internal.o.a.a.a();

    class a implements Runnable {
        final /* synthetic */ HashMap a;
        final /* synthetic */ String b;

        a(HashMap map, String str) {
            this.a = map;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.b.a(this.a)) {
                m.this.a.edit().putBoolean(m.g, true).apply();
                m.this.a.edit().putString(m.f, this.b).apply();
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ HashMap a;
        final /* synthetic */ String b;

        b(HashMap map, String str) {
            this.a = map;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.b.a(this.a)) {
                m.this.a.edit().putBoolean(m.h, true).apply();
                m.this.a.edit().putString(m.e, this.b).apply();
            }
        }
    }

    m(Context context) {
        this.a = context.getSharedPreferences(d, 0);
    }

    public void a(String str) {
        String str2 = "oaid error: " + str;
        if (this.a.getBoolean(h, false) && TextUtils.equals(this.a.getString(e, ""), str2)) {
            return;
        }
        this.a.edit().putBoolean(h, false).apply();
        this.a.edit().putString(e, "").apply();
        HashMap map = new HashMap();
        map.put("oaid_error", str2);
        if (this.b == null) {
            return;
        }
        new Thread(new b(map, str2)).start();
    }

    public void b(String str) {
        String str2 = "oaid unsupported: " + str;
        if (this.a.getBoolean(g, false) && TextUtils.equals(this.a.getString(f, ""), str2)) {
            return;
        }
        this.a.edit().putBoolean(g, false).apply();
        this.a.edit().putString(f, str2).apply();
        if (this.b == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("oaid_unsupported: ", str2);
        new Thread(new a(map, str2)).start();
    }

    void c(String str) {
        this.a.edit().putString(c, str).apply();
    }

    String e() {
        return this.a.getString(c, "");
    }
}
