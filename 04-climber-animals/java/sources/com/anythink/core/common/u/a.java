package com.anythink.core.common.u;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a a;
    private final Map<String, InterfaceC0102a> b = new ConcurrentHashMap(2);

    /* JADX INFO: renamed from: com.anythink.core.common.u.a$a, reason: collision with other inner class name */
    public interface InterfaceC0102a {
        void a(String str);
    }

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

    public final void a(String str, InterfaceC0102a interfaceC0102a) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, interfaceC0102a);
    }

    public final void a(String str) {
        InterfaceC0102a interfaceC0102aRemove;
        if (TextUtils.isEmpty(str) || (interfaceC0102aRemove = this.b.remove(str)) == null) {
            return;
        }
        interfaceC0102aRemove.a(str);
    }
}
