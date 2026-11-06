package com.anythink.basead.mixad;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a a;
    private final Map<String, com.anythink.basead.mixad.c.a.a> b = new HashMap(2);
    private final Map<String, com.anythink.core.common.l.f.a.a.InterfaceC0087a> c = new HashMap(2);
    private final Map<String, com.anythink.core.common.l.e.a.a.InterfaceC0086a> d = new HashMap(2);

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public final void a(String str, com.anythink.basead.mixad.c.a.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, aVar);
    }

    public final com.anythink.basead.mixad.c.a.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.b.remove(str);
    }

    public final void a(String str, com.anythink.core.common.l.e.a.a.InterfaceC0086a interfaceC0086a) {
        if (interfaceC0086a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.d.put(str, interfaceC0086a);
    }

    public final com.anythink.core.common.l.e.a.a.InterfaceC0086a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.d.remove(str);
    }

    public final void a(String str, com.anythink.core.common.l.f.a.a.InterfaceC0087a interfaceC0087a) {
        if (interfaceC0087a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.c.put(str, interfaceC0087a);
    }

    public final com.anythink.core.common.l.f.a.a.InterfaceC0087a c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.c.remove(str);
    }
}
