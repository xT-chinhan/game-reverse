package com.anythink.core.common.res.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile c a;
    private final Map<String, a> b = new HashMap();

    private c() {
    }

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    private synchronized a b(String str) {
        a aVar = this.b.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(str);
        this.b.put(str, aVar2);
        return aVar2;
    }

    public final synchronized void a(String str) {
        if (this.b != null && !TextUtils.isEmpty(str)) {
            this.b.remove(str);
        }
    }

    private synchronized void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a aVar = this.b.get(str);
        if (aVar != null) {
            aVar.e();
        }
    }

    private synchronized void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a aVar = this.b.get(str);
        if (aVar != null) {
            aVar.f();
        }
    }
}
