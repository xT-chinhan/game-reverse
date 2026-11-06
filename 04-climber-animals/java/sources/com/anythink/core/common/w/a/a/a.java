package com.anythink.core.common.w.a.a;

import com.anythink.core.common.h.ai;
import com.anythink.core.common.h.aj;
import com.anythink.core.common.h.bv;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.anythink.core.common.w.a.b.c {
    private static final String a = "a";
    private ai b;

    @Override // com.anythink.core.common.w.a.b.c
    public final void a(ai aiVar) {
        this.b = aiVar;
    }

    @Override // com.anythink.core.common.w.a.b.c
    public final ai a() {
        return this.b;
    }

    @Override // com.anythink.core.common.w.a.b.c
    public final aj a(bv bvVar) {
        ai aiVar = this.b;
        if (aiVar == null || bvVar == null) {
            return null;
        }
        List<aj> listD = aiVar.d();
        List<aj> listF = this.b.f();
        aj ajVarA = a(bvVar.z(), listD);
        if (ajVarA == null && this.b.b()) {
            ajVarA = a(bvVar.z(), listF);
        }
        Object[] objArr = new Object[1];
        return ajVarA;
    }

    @Override // com.anythink.core.common.w.a.b.b
    public final void b() {
        this.b = null;
    }

    private static aj a(String str, List<aj> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<aj> it = list.iterator();
            while (it.hasNext()) {
                aj next = it.next();
                if (str.equals(next.c())) {
                    if (next.d() != com.anythink.core.common.w.a.a.C0106a.b || System.currentTimeMillis() <= next.a()) {
                        return next;
                    }
                    return null;
                }
            }
        }
        return null;
    }
}
