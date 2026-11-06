package com.anythink.core.common.t;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile c a;
    private final Map<String, a> b = new ConcurrentHashMap(2);

    public interface a {
        void a(String str);
    }

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

    public final void a(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, aVar);
    }

    public final void a(String str) {
        a aVarRemove;
        if (TextUtils.isEmpty(str) || (aVarRemove = this.b.remove(str)) == null) {
            return;
        }
        aVarRemove.a(str);
    }
}
