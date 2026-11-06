package com.anythink.core.common.v.a.a;

import android.content.Context;
import com.anythink.core.common.h.aj;
import com.anythink.core.common.h.ak;
import com.anythink.core.e.l;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.anythink.core.common.v.a.b.e {
    private static final String a = "e";
    private final String b;
    private final com.anythink.core.common.v.a.b.c c;
    private final com.anythink.core.common.v.a.b.d d;
    private long e;
    private boolean f;

    public e(String str, com.anythink.core.common.v.a.b.c cVar, com.anythink.core.common.v.a.b.d dVar) {
        this.b = str;
        this.c = cVar;
        this.d = dVar;
    }

    @Override // com.anythink.core.common.v.a.b.e
    public final void a(final Context context, final l lVar, final com.anythink.core.common.v.a.b.a aVar) {
        if (lVar == null) {
            aVar.a();
            return;
        }
        final aj ajVarBy = lVar.by();
        boolean z = ajVarBy == null || ajVarBy.a();
        boolean z2 = ajVarBy != null && ajVarBy.a(this.e);
        if (z || z2) {
            if (z && this.f) {
                this.f = false;
                d.a(this.b);
            }
            aVar.a();
            return;
        }
        this.f = true;
        this.e = System.currentTimeMillis();
        com.anythink.core.common.v.a.b.c cVar = this.c;
        if (cVar != null) {
            cVar.a(ajVarBy);
        }
        final boolean zC = ajVarBy.c();
        if (!zC) {
            aVar.a();
        }
        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aQ, new Runnable() { // from class: com.anythink.core.common.v.a.a.e.1
            @Override // java.lang.Runnable
            public final void run() {
                e.a(e.this, context, lVar, aVar, ajVarBy).a(zC);
            }
        }));
    }

    /* JADX INFO: renamed from: com.anythink.core.common.v.a.a.e$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.core.common.v.a.c.a.InterfaceC0055a {
        final /* synthetic */ aj a;
        final /* synthetic */ com.anythink.core.common.v.a.b.a b;

        AnonymousClass2(aj ajVar, com.anythink.core.common.v.a.b.a aVar) {
            this.a = ajVar;
            this.b = aVar;
        }

        @Override // com.anythink.core.common.v.a.c.a.InterfaceC0055a
        public final void a(List<ak> list, boolean z) {
            this.a.a(list);
            com.anythink.core.common.v.a.b.a aVar = this.b;
            if (aVar == null || !z) {
                return;
            }
            aVar.a();
        }

        @Override // com.anythink.core.common.v.a.c.a.InterfaceC0055a
        public final void a(boolean z) {
            com.anythink.core.common.v.a.b.a aVar = this.b;
            if (aVar == null || !z) {
                return;
            }
            aVar.a();
        }
    }

    private com.anythink.core.common.v.a.c.a a(Context context, l lVar, com.anythink.core.common.v.a.b.a aVar, aj ajVar) {
        com.anythink.core.common.v.a.c.a aVar2 = new com.anythink.core.common.v.a.c.a(context, lVar, ajVar, this.d);
        aVar2.a(new AnonymousClass2(ajVar, aVar));
        return aVar2;
    }

    @Override // com.anythink.core.common.v.a.b.b
    public final void b() {
        this.f = false;
        this.e = 0L;
    }

    static /* synthetic */ com.anythink.core.common.v.a.c.a a(e eVar, Context context, l lVar, com.anythink.core.common.v.a.b.a aVar, aj ajVar) {
        com.anythink.core.common.v.a.c.a aVar2 = new com.anythink.core.common.v.a.c.a(context, lVar, ajVar, eVar.d);
        aVar2.a(eVar.new AnonymousClass2(ajVar, aVar));
        return aVar2;
    }
}
