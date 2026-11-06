package com.anythink.core.common.inner.mixad;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a a;
    private final Map<String, com.anythink.core.common.inner.mixad.c.a.a> b = new HashMap(2);
    private final Map<String, com.anythink.core.common.k.f.a.a.InterfaceC0030a> c = new HashMap(2);
    private final Map<String, com.anythink.core.common.k.e.a.a.InterfaceC0029a> d = new HashMap(2);

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

    public final void a(String str, com.anythink.core.common.inner.mixad.c.a.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, aVar);
    }

    public final com.anythink.core.common.inner.mixad.c.a.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.b.remove(str);
    }

    public final void a(String str, com.anythink.core.common.k.e.a.a.InterfaceC0029a interfaceC0029a) {
        if (interfaceC0029a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.d.put(str, interfaceC0029a);
    }

    public final com.anythink.core.common.k.e.a.a.InterfaceC0029a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.d.remove(str);
    }

    public final void a(String str, com.anythink.core.common.k.f.a.a.InterfaceC0030a interfaceC0030a) {
        if (interfaceC0030a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.c.put(str, interfaceC0030a);
    }

    public final com.anythink.core.common.k.f.a.a.InterfaceC0030a c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.c.remove(str);
    }
}
