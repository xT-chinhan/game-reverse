package com.tapsdk.tapad.internal.u;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static Map<String, a> b = new ConcurrentHashMap();
    private static volatile Context c;
    private volatile SharedPreferences a;

    private a(String str) {
        this.a = c.getApplicationContext().getSharedPreferences(str, 0);
    }

    public static synchronized void a(Context context) {
        if (b()) {
            TapADLogger.w("no need to reinitialize");
        } else {
            if (context != null) {
                c = context.getApplicationContext();
            }
        }
    }

    public static a b(String str) {
        if (c == null) {
            return null;
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("sp name empty");
        }
        if (b.containsKey(str)) {
            return b.get(str);
        }
        a aVar = new a(str);
        b.put(str, aVar);
        return aVar;
    }

    public static boolean b() {
        return c != null;
    }

    public int a(String str, int i) {
        if (b()) {
            return this.a.getInt(str, i);
        }
        return 0;
    }

    public Long a(String str, long j) {
        return Long.valueOf(b() ? this.a.getLong(str, j) : 0L);
    }

    public String a(String str, String str2) {
        return b() ? this.a.getString(str, str2) : "";
    }

    public Set<String> a(String str, Set<String> set) {
        return b() ? this.a.getStringSet(str, set) : new HashSet();
    }

    public void a() {
        if (b()) {
            this.a.edit().clear().apply();
        }
    }

    public boolean a(String str) {
        if (b()) {
            return this.a.contains(str);
        }
        return false;
    }

    public void b(String str, int i) {
        if (b()) {
            this.a.edit().putInt(str, i).apply();
        }
    }

    public void b(String str, long j) {
        if (b()) {
            this.a.edit().putLong(str, j).apply();
        }
    }

    public void b(String str, String str2) {
        if (b()) {
            this.a.edit().putString(str, str2).apply();
        }
    }

    public void b(String str, Set<String> set) {
        if (b()) {
            this.a.edit().putStringSet(str, set).apply();
        }
    }

    public void c(String str) {
        if (b()) {
            this.a.edit().remove(str).apply();
        }
    }
}
