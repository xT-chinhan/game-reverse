package com.anythink.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.h.ac;
import com.anythink.core.common.h.by;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String a = "d";
    private static volatile d e;
    private Context b;
    private final Map<String, ac> c = new ConcurrentHashMap(8);
    private Map<String, String> d;

    public static d a() {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    private d() {
    }

    public final void a(String str, ac acVar) {
        this.c.put(str, acVar);
    }

    public final void a(String str, String str2, String str3) {
        by byVarB;
        ac acVar = this.c.get(str);
        if (acVar == null || (byVarB = acVar.b()) == null || !TextUtils.equals(byVarB.G(), str3) || !TextUtils.equals(acVar.d(), str2)) {
            return;
        }
        acVar.e();
    }

    public final void b(String str, String str2, String str3) {
        by byVarB;
        ac acVar = this.c.get(str);
        if (acVar == null || (byVarB = acVar.b()) == null || !TextUtils.equals(byVarB.G(), str3) || !TextUtils.equals(acVar.d(), str2)) {
            return;
        }
        acVar.f();
    }

    public final ac a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.c.remove(str);
    }

    public final synchronized void a(String str, String str2) {
        if (this.d == null) {
            this.d = new ConcurrentHashMap();
        }
        this.d.put(str, str2);
    }

    public final synchronized String b(String str) {
        Map<String, String> map = this.d;
        if (map == null) {
            return null;
        }
        return map.remove(str);
    }
}
