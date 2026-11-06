package com.umeng.crash;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: UCrash */
/* JADX INFO: loaded from: classes4.dex */
final class c {
    private static final c r = new c();
    Application a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    long k;
    int o;
    int p;
    int l = 300;
    int m = 100;
    int n = 100;
    final Map<String, String> q = new LinkedHashMap();

    static void a(final Context context) {
        final c cVar = r;
        cVar.k = System.currentTimeMillis();
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "unknown";
        }
        cVar.a = (Application) context;
        cVar.e = packageName;
        cVar.b = m.c(context);
        cVar.g = m.d(context);
        cVar.h = m.e(context);
        cVar.f = m.a(context);
        cVar.i = m.b(context);
        cVar.j = context.getApplicationInfo().nativeLibraryDir;
        cVar.c = k.a(context).getPath();
        b.a(new Runnable() { // from class: com.umeng.crash.c.1
            @Override // java.lang.Runnable
            public final void run() {
                String strA = j.a(context, cVar.f);
                if (!TextUtils.equals(strA, cVar.g)) {
                    Context context2 = context;
                    String str = cVar.f;
                    String str2 = cVar.g;
                    try {
                        SharedPreferences sharedPreferences = context2.getSharedPreferences("um_crash_cfg", 0);
                        String str3 = "k_ver";
                        if (!TextUtils.isEmpty(str)) {
                            String[] strArrSplit = str.split(":");
                            if (strArrSplit.length > 1) {
                                str3 = "k_ver_" + strArrSplit[1];
                            }
                        }
                        sharedPreferences.edit().putString(str3, str2).apply();
                    } catch (Exception e) {
                        UCrash.a().a("UCrash", "save app ver failed", e);
                    }
                }
                cVar.d = strA;
            }
        });
    }

    static c a() {
        return r;
    }

    private c() {
    }

    public final Map<String, String> b() {
        LinkedHashMap linkedHashMap;
        synchronized (this.q) {
            linkedHashMap = new LinkedHashMap(this.q);
        }
        return linkedHashMap;
    }
}
