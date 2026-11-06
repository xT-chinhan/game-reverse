package com.anythink.core.common.v.a.a;

import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.f.f;
import com.anythink.core.common.h.aj;
import com.anythink.core.common.h.al;
import com.anythink.core.common.h.am;
import com.anythink.core.common.h.an;
import com.anythink.core.common.h.n;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.anythink.core.common.v.a.b.d {
    private static final String a = "b";
    private final String b;
    private final com.anythink.core.common.v.a.b.c c;
    private final c d = new c();
    private f e;

    public b(String str, com.anythink.core.common.v.a.b.c cVar) {
        this.b = str;
        this.c = cVar;
        try {
            this.e = f.a(s.b().g());
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.common.v.a.b.d
    public final an a(String str) {
        f fVar = this.e;
        if (fVar != null) {
            return fVar.a(str);
        }
        return null;
    }

    @Override // com.anythink.core.common.v.a.b.d
    public final void b(String str) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.b(str);
        }
    }

    @Override // com.anythink.core.common.v.a.b.d
    public final void a(final am amVar) {
        c cVar;
        Map<Integer, al> mapE;
        n nVarI;
        com.anythink.core.common.v.a.b.c cVar2 = this.c;
        al alVar = null;
        aj ajVarA = cVar2 != null ? cVar2.a() : null;
        if (ajVarA == null || ajVarA.a() || amVar == null || !amVar.b().equals(this.b)) {
            return;
        }
        if (amVar != null && amVar.d() == com.anythink.core.common.v.a.a.b.c && (nVarI = amVar.i()) != null) {
            String strA = (ajVarA == null || ajVarA.e() == null) ? "" : com.anythink.core.common.v.a.d.a.a(amVar.e(), ajVarA.e().get(Integer.valueOf(amVar.c())));
            boolean zJ = amVar.j();
            if (!TextUtils.isEmpty(strA)) {
                com.anythink.core.common.u.b.c.a().g(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aO, new AnonymousClass2(nVarI, zJ, strA)));
            }
        }
        if (amVar != null && ajVarA != null && (mapE = ajVarA.e()) != null) {
            alVar = mapE.get(Integer.valueOf(amVar.c()));
        }
        if (alVar == null) {
            return;
        }
        amVar.a(alVar.b());
        if (ajVarA.b() && (cVar = this.d) != null) {
            cVar.a(amVar, alVar, ajVarA);
        }
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aP, new Runnable() { // from class: com.anythink.core.common.v.a.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.e != null) {
                    b.this.e.a(amVar);
                }
            }
        }));
    }

    @Override // com.anythink.core.common.v.a.b.b
    public final void b() {
        c cVar = this.d;
        if (cVar != null) {
            cVar.a();
        }
    }

    private void a(am amVar, aj ajVar) {
        n nVarI;
        if (amVar == null || amVar.d() != com.anythink.core.common.v.a.a.b.c || (nVarI = amVar.i()) == null) {
            return;
        }
        String strA = (ajVar == null || ajVar.e() == null) ? "" : com.anythink.core.common.v.a.d.a.a(amVar.e(), ajVar.e().get(Integer.valueOf(amVar.c())));
        boolean zJ = amVar.j();
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        com.anythink.core.common.u.b.c.a().g(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aO, new AnonymousClass2(nVarI, zJ, strA)));
    }

    /* JADX INFO: renamed from: com.anythink.core.common.v.a.a.b$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ n a;
        final /* synthetic */ boolean b;
        final /* synthetic */ String c;

        AnonymousClass2(n nVar, boolean z, String str) {
            this.a = nVar;
            this.b = z;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.ad(this.b ? 1 : 2);
            this.a.z(this.c);
            com.anythink.core.common.t.e.a(s.b().g());
            com.anythink.core.common.t.e.a(3, this.a);
        }
    }
}
