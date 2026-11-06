package com.anythink.core.common.t.a.b.a.b;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.f.j;
import com.anythink.core.common.l.e;
import com.anythink.core.common.l.e.i;
import com.anythink.core.common.l.s;
import com.anythink.core.e.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    List<com.anythink.core.common.t.a.b.a.a.a> a;
    private final String b = "b";
    private i.a d = new i.a() { // from class: com.anythink.core.common.t.a.b.a.b.b.1
        @Override // com.anythink.core.common.l.e.i.a
        public final void a(Object obj) {
            if (b.this.a != null) {
                com.anythink.core.common.t.a.a.a.a(j.a(b.this.c)).a(b.this.a);
            }
            com.anythink.core.common.t.a.b.a().b("da");
        }

        @Override // com.anythink.core.common.l.e.i.a
        public final void a(Throwable th) {
            if (b.this.a != null) {
                com.anythink.core.common.t.a.a.a.a(j.a(b.this.c)).b(b.this.a);
                com.anythink.core.common.t.a.b.a().a("da");
            }
        }
    };
    private s e = new s() { // from class: com.anythink.core.common.t.a.b.a.b.b.2
        @Override // com.anythink.core.common.l.s
        public final void onLoadCanceled(int i) {
        }

        @Override // com.anythink.core.common.l.s
        public final void onLoadStart(int i) {
        }

        @Override // com.anythink.core.common.l.s
        public final void onLoadFinish(int i, Object obj) {
            if (b.this.a != null) {
                com.anythink.core.common.t.a.a.a.a(j.a(b.this.c)).a(b.this.a);
            }
            com.anythink.core.common.t.a.b.a().b("da");
        }

        @Override // com.anythink.core.common.l.s
        public final void onLoadError(int i, String str, AdError adError) {
            if (b.this.a != null) {
                com.anythink.core.common.t.a.a.a.a(j.a(b.this.c)).b(b.this.a);
                com.anythink.core.common.t.a.b.a().a("da");
            }
        }
    };
    private Context c = com.anythink.core.common.d.s.b().g();

    public final void a(boolean z) {
        if (com.anythink.core.common.d.s.b().a()) {
            com.anythink.core.common.t.a.a.a aVarA = com.anythink.core.common.t.a.a.a.a(j.a(this.c));
            com.anythink.core.common.t.a.a.a();
            List<com.anythink.core.common.t.a.b.a.a.a> listA = aVarA.a(com.anythink.core.common.t.a.a.i().b(), z);
            this.a = listA;
            if (listA == null || listA.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<com.anythink.core.common.t.a.b.a.a.a> it = this.a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().e);
            }
            com.anythink.core.e.b bVarB = d.a(this.c).b(com.anythink.core.common.d.s.b().p());
            if (bVarB != null) {
                if (bVarB.x() == 1) {
                    com.anythink.core.common.l.e.b bVar = new com.anythink.core.common.l.e.b(arrayList);
                    bVar.a(1, bVarB.w());
                    bVar.g();
                    bVar.a(this.d);
                    return;
                }
                e eVar = new e(this.c, bVarB.x(), arrayList);
                eVar.t();
                eVar.a(0, this.e);
                return;
            }
            e eVar2 = new e(this.c, 0, arrayList);
            eVar2.t();
            eVar2.a(0, this.e);
        }
    }
}
