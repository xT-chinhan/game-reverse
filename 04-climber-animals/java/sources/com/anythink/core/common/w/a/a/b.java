package com.anythink.core.common.w.a.a;

import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.e.j;
import com.anythink.core.common.h.ai;
import com.anythink.core.common.h.ak;
import com.anythink.core.common.h.al;
import com.anythink.core.common.h.am;
import com.anythink.core.common.h.n;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.anythink.core.common.w.a.b.d {
    private static final String a = "b";
    private final String b;
    private final com.anythink.core.common.w.a.b.c c;
    private final c d = new c();
    private j e;

    public b(String str, com.anythink.core.common.w.a.b.c cVar) {
        this.b = str;
        this.c = cVar;
        try {
            this.e = j.a(t.b().g());
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.common.w.a.b.d
    public final am a(String str) {
        j jVar = this.e;
        if (jVar != null) {
            return jVar.a(str);
        }
        return null;
    }

    @Override // com.anythink.core.common.w.a.b.d
    public final void b(String str) {
        j jVar = this.e;
        if (jVar != null) {
            jVar.b(str);
        }
    }

    @Override // com.anythink.core.common.w.a.b.d
    public final void a(final al alVar) {
        c cVar;
        Map<Integer, ak> mapE;
        n nVarI;
        com.anythink.core.common.w.a.b.c cVar2 = this.c;
        ak akVar = null;
        ai aiVarA = cVar2 != null ? cVar2.a() : null;
        if (aiVarA == null || aiVarA.a() || alVar == null || !alVar.b().equals(this.b)) {
            Object[] objArr = new Object[1];
            return;
        }
        if (alVar != null && alVar.d() == com.anythink.core.common.w.a.a.b.c && (nVarI = alVar.i()) != null) {
            String strA = (aiVarA == null || aiVarA.e() == null) ? "" : com.anythink.core.common.w.a.d.a.a(alVar.e(), aiVarA.e().get(Integer.valueOf(alVar.c())));
            Object[] objArr2 = new Object[1];
            boolean zJ = alVar.j();
            if (!TextUtils.isEmpty(strA)) {
                com.anythink.core.common.v.b.b.a().a(new AnonymousClass2(nVarI, zJ, strA));
            }
        }
        if (alVar != null && aiVarA != null && (mapE = aiVarA.e()) != null) {
            akVar = mapE.get(Integer.valueOf(alVar.c()));
        }
        if (akVar == null) {
            Object[] objArr3 = new Object[2];
            alVar.a();
            Integer.valueOf(alVar.c());
        } else {
            Object[] objArr4 = new Object[1];
            alVar.a(akVar.b());
            if (aiVarA.b() && (cVar = this.d) != null) {
                cVar.a(alVar, akVar, aiVarA);
            }
            com.anythink.core.common.v.b.b.a().c(new Runnable() { // from class: com.anythink.core.common.w.a.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.e != null) {
                        b.this.e.a(alVar);
                    }
                }
            }, 13);
        }
    }

    @Override // com.anythink.core.common.w.a.b.b
    public final void b() {
        c cVar = this.d;
        if (cVar != null) {
            cVar.a();
        }
    }

    private void a(al alVar, ai aiVar) {
        n nVarI;
        if (alVar == null || alVar.d() != com.anythink.core.common.w.a.a.b.c || (nVarI = alVar.i()) == null) {
            return;
        }
        String strA = (aiVar == null || aiVar.e() == null) ? "" : com.anythink.core.common.w.a.d.a.a(alVar.e(), aiVar.e().get(Integer.valueOf(alVar.c())));
        Object[] objArr = new Object[1];
        boolean zJ = alVar.j();
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        com.anythink.core.common.v.b.b.a().a(new AnonymousClass2(nVarI, zJ, strA));
    }

    /* JADX INFO: renamed from: com.anythink.core.common.w.a.a.b$2, reason: invalid class name */
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
            this.a.ac(this.b ? 1 : 2);
            this.a.A(this.c);
            com.anythink.core.common.u.c.a(t.b().g()).a(3, this.a);
        }
    }
}
