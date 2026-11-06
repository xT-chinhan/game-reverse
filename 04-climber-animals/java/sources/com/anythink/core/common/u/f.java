package com.anythink.core.common.u;

import android.content.Context;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.u;
import com.anythink.core.common.m;
import com.anythink.core.common.m.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f extends m<u> {
    private static volatile f g;

    private f(Context context) {
        super(context);
    }

    public static f a(Context context) {
        if (g == null) {
            synchronized (f.class) {
                if (g == null) {
                    g = new f(context);
                }
            }
        }
        return g;
    }

    @Override // com.anythink.core.common.m
    protected final void a(List<u> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<u> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a().toString());
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
        if (bVarB != null) {
            if (bVarB.F() == 1) {
                com.anythink.core.common.m.d.a aVar = new com.anythink.core.common.m.d.a(arrayList);
                aVar.a(1, bVarB.E());
                aVar.a();
                aVar.a((com.anythink.core.common.m.d.d.a) null);
                return;
            }
            com.anythink.core.common.m.d dVar = new com.anythink.core.common.m.d(this.d, bVarB.F(), arrayList);
            dVar.s();
            dVar.a(0, (q) null);
            return;
        }
        com.anythink.core.common.m.d dVar2 = new com.anythink.core.common.m.d(this.d, 0, arrayList);
        dVar2.s();
        dVar2.a(0, (q) null);
    }
}
