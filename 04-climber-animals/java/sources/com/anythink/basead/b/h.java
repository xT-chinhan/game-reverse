package com.anythink.basead.b;

import android.content.Context;
import android.content.IntentFilter;
import com.anythink.core.common.h.w;
import com.anythink.core.common.l;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private static volatile h b;
    g a;
    private Context c;
    private ConcurrentHashMap<String, w> d = new ConcurrentHashMap<>();

    private h(Context context) {
        this.c = context;
    }

    public static h a(Context context) {
        if (b == null) {
            synchronized (h.class) {
                if (b == null) {
                    b = new h(context);
                }
            }
        }
        return b;
    }

    public final void a() {
        if (this.c != null && this.a == null) {
            this.a = new g();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.anythink.dlopt.common.b.b);
            intentFilter.addAction(com.anythink.dlopt.common.b.c);
            intentFilter.addAction(com.anythink.dlopt.common.b.d);
            intentFilter.addAction(com.anythink.dlopt.common.b.e);
            l.a(this.c).a(this.a, intentFilter);
        }
    }

    private void b() {
        if (this.a != null) {
            l.a(this.c).a(this.a);
            this.a = null;
        }
    }

    public final void a(String str, w wVar) {
        this.d.put(str, wVar);
    }

    public final void a(String str, String str2) {
        w wVar = this.d.get(str);
        if (wVar != null) {
            com.anythink.basead.d.j jVar = new com.anythink.basead.d.j("", "");
            jVar.k = new com.anythink.basead.d.b();
            jVar.k.a = str2;
            b.a(18, wVar, jVar);
        }
    }

    public final void b(String str, String str2) {
        w wVar = this.d.get(str);
        if (wVar != null) {
            com.anythink.basead.d.j jVar = new com.anythink.basead.d.j("", "");
            jVar.k = new com.anythink.basead.d.b();
            jVar.k.a = str2;
            b.a(19, wVar, jVar);
        }
    }

    public final void c(String str, String str2) {
        w wVar = this.d.get(str);
        if (wVar != null) {
            com.anythink.basead.d.j jVar = new com.anythink.basead.d.j("", "");
            jVar.k = new com.anythink.basead.d.b();
            jVar.k.a = str2;
            b.a(20, wVar, jVar);
        }
    }

    public final void d(String str, String str2) {
        w wVarRemove = this.d.remove(str);
        if (wVarRemove != null) {
            com.anythink.basead.d.j jVar = new com.anythink.basead.d.j("", "");
            jVar.k = new com.anythink.basead.d.b();
            jVar.k.a = str2;
            b.a(21, wVarRemove, jVar);
        }
        if (this.d.size() != 0 || this.a == null) {
            return;
        }
        l.a(this.c).a(this.a);
        this.a = null;
    }
}
