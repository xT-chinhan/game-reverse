package com.anythink.core.common.inner.ui.d;

import android.text.TextUtils;
import com.anythink.core.basead.b.c;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a a;
    private Map<String, c> b = new HashMap();

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

    public final void a(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        this.b.put(str, cVar);
    }

    public final c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.b.remove(str);
    }
}
