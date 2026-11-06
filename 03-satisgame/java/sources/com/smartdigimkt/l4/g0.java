package com.smartdigimkt.l4;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 {
    public final HashMap a = new HashMap();
    public final ReferenceQueue b = new ReferenceQueue();

    public final synchronized Object a(String str) {
        f0 f0Var;
        a();
        f0Var = (f0) this.a.get(str);
        return f0Var != null ? f0Var.get() : null;
    }

    public final synchronized void b(String str) {
        this.a.remove(str);
    }

    public final synchronized void b() {
        this.a.clear();
        a();
    }

    public final synchronized void a(Object obj, String str) {
        f0 f0Var;
        a();
        if (obj != null && ((f0Var = (f0) this.a.get(str)) == null || f0Var.get() != obj)) {
            this.a.put(str, new f0(str, obj, this.b));
        }
    }

    public final void a() {
        f0 f0Var = (f0) this.b.poll();
        while (f0Var != null) {
            f0 f0Var2 = (f0) this.a.get(f0Var.a);
            if (f0Var2 != null && f0Var2.get() == 0) {
                this.a.remove(f0Var.a);
            }
            f0Var = (f0) this.b.poll();
        }
    }
}
