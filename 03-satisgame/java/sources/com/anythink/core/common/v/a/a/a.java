package com.anythink.core.common.v.a.a;

import com.anythink.core.common.h.aj;
import com.anythink.core.common.h.ak;
import com.anythink.core.common.h.by;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.anythink.core.common.v.a.b.c {
    private static final String a = "a";
    private aj b;

    @Override // com.anythink.core.common.v.a.b.c
    public final void a(aj ajVar) {
        this.b = ajVar;
    }

    @Override // com.anythink.core.common.v.a.b.c
    public final aj a() {
        return this.b;
    }

    @Override // com.anythink.core.common.v.a.b.c
    public final ak a(by byVar) {
        aj ajVar = this.b;
        if (ajVar == null || byVar == null) {
            return null;
        }
        List<ak> listD = ajVar.d();
        List<ak> listF = this.b.f();
        ak akVarA = a(byVar.G(), listD);
        return (akVarA == null && this.b.b()) ? a(byVar.G(), listF) : akVarA;
    }

    @Override // com.anythink.core.common.v.a.b.b
    public final void b() {
        this.b = null;
    }

    private static ak a(String str, List<ak> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<ak> it = list.iterator();
            while (it.hasNext()) {
                ak next = it.next();
                if (str.equals(next.c())) {
                    if (next.d() != com.anythink.core.common.v.a.a.C0054a.b || System.currentTimeMillis() <= next.a()) {
                        return next;
                    }
                    return null;
                }
            }
        }
        return null;
    }
}
