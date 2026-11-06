package com.anythink.basead.j;

import android.text.TextUtils;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private static volatile f a;
    private c b;

    private f() {
    }

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    public final void a(c cVar) {
        this.b = cVar;
    }

    public final String a(String str, w wVar, x xVar) {
        return (b() && b(wVar, xVar)) ? this.b.c() : str;
    }

    public final boolean a(w wVar, x xVar) {
        return b() && !TextUtils.isEmpty(wVar.au()) && b(wVar, xVar);
    }

    public final boolean b() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.d();
        }
        return false;
    }

    public final b c() {
        if (b()) {
            return this.b.a();
        }
        return null;
    }

    public final b d() {
        if (b()) {
            return this.b.b();
        }
        return null;
    }

    public final String e() {
        return b() ? this.b.e() : "";
    }

    private static boolean b(w wVar, x xVar) {
        return !com.anythink.basead.b.e.a(wVar, xVar) && wVar.n();
    }
}
