package com.anythink.core.common.s;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.u;
import com.anythink.core.common.s.b.d;
import com.anythink.core.common.s.b.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final int a = 1;
    public static final int b = 1;
    private static volatile b c;
    private final Map<String, a> d = new ConcurrentHashMap();

    private b() {
    }

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    public final a b(Context context, String str) {
        return c(context, str);
    }

    private a c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new com.anythink.core.common.s.b.b();
        }
        if (context instanceof Activity) {
            context = context.getApplicationContext();
        }
        a aVar = this.d.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVarD = d(context, str);
        this.d.put(str, aVarD);
        return aVarD;
    }

    private static a d(Context context, String str) {
        return d.c(new c.a().a(context).a(str).b(1).a(1).a());
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith(u.a.m) || str.endsWith(u.a.l);
    }

    private static boolean b(String str) {
        return !a(str);
    }

    private void a(Context context) {
        String[] strArr = {u.b.a, u.b.b, u.b.c, u.b.e, u.b.g, u.b.h, u.b.i, u.b.j, u.b.k, u.b.l, u.b.m, u.b.n, u.b.o, "anythink_app_pl_cl_retry"};
        for (int i = 0; i < 14; i++) {
            a aVarC = c(context, strArr[i]);
            if (aVarC instanceof e) {
                ((e) aVarC).c();
            }
        }
    }

    public final a a(Context context, String str) {
        return c(context, str);
    }
}
