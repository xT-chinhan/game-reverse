package com.anythink.core.common.t.a.b.a.b;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.f.j;
import com.anythink.core.common.l.e.i;
import com.anythink.core.common.l.e.l;
import com.anythink.core.common.l.s;
import com.anythink.core.common.l.y;
import com.anythink.core.e.d;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {
    List<com.anythink.core.common.t.a.b.a.a.c> a;
    private final String c = "c";
    private i.a d = new i.a() { // from class: com.anythink.core.common.t.a.b.a.b.c.1
        @Override // com.anythink.core.common.l.e.i.a
        public final void a(Object obj) {
            if (c.this.a != null) {
                com.anythink.core.common.t.a.a.b.a(j.a(c.this.b)).a(c.this.a);
                com.anythink.core.common.t.a.b.a().b("tk");
            }
        }

        @Override // com.anythink.core.common.l.e.i.a
        public final void a(Throwable th) {
            if (c.this.a != null) {
                com.anythink.core.common.t.a.a.b.a(j.a(c.this.b)).b(c.this.a);
                com.anythink.core.common.t.a.b.a().a("tk");
            }
        }
    };
    private s e = new s() { // from class: com.anythink.core.common.t.a.b.a.b.c.2
        @Override // com.anythink.core.common.l.s
        public final void onLoadCanceled(int i) {
        }

        @Override // com.anythink.core.common.l.s
        public final void onLoadStart(int i) {
        }

        @Override // com.anythink.core.common.l.s
        public final void onLoadFinish(int i, Object obj) {
            if (c.this.a != null) {
                com.anythink.core.common.t.a.a.b.a(j.a(c.this.b)).a(c.this.a);
                com.anythink.core.common.t.a.b.a().b("tk");
            }
        }

        @Override // com.anythink.core.common.l.s
        public final void onLoadError(int i, String str, AdError adError) {
            if (c.this.a != null) {
                com.anythink.core.common.t.a.a.b.a(j.a(c.this.b)).b(c.this.a);
                com.anythink.core.common.t.a.b.a().a("tk");
            }
        }
    };
    private Context b = com.anythink.core.common.d.s.b().g();

    public final void a(boolean z) {
        List<com.anythink.core.common.t.a.b.a.a.c> list;
        if (com.anythink.core.common.d.s.b().a()) {
            com.anythink.core.common.t.a.a.b bVarA = com.anythink.core.common.t.a.a.b.a(j.a(this.b));
            com.anythink.core.common.t.a.a.a();
            List<com.anythink.core.common.t.a.b.a.a.c> listA = bVarA.a(com.anythink.core.common.t.a.a.i().a(), z);
            this.a = listA;
            if (listA == null || listA.isEmpty() || (list = this.a) == null || list.isEmpty()) {
                return;
            }
            com.anythink.core.e.b bVarB = d.a(this.b).b(com.anythink.core.common.d.s.b().p());
            if (bVarB != null) {
                int iX = bVarB.x();
                if (iX == 1) {
                    l lVar = new l(this.a);
                    lVar.a(1, bVarB.w());
                    lVar.a(this.d);
                    return;
                } else {
                    if (iX == 2) {
                        new y(this.b, bVarB.x(), this.a).a(0, this.e);
                        l lVar2 = new l(this.a);
                        lVar2.a(2, bVarB.w());
                        lVar2.a(this.d);
                        return;
                    }
                    new y(this.b, bVarB.x(), this.a).a(0, this.e);
                    return;
                }
            }
            new y(this.b, 0, this.a).a(0, this.e);
        }
    }
}
