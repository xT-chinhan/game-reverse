package com.anythink.core.common.w.a.a;

import android.content.Context;
import com.anythink.core.common.h.ai;
import com.anythink.core.common.h.aj;
import com.anythink.core.d.l;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.anythink.core.common.w.a.b.e {
    private static final String a = "e";
    private final String b;
    private final com.anythink.core.common.w.a.b.c c;
    private final com.anythink.core.common.w.a.b.d d;
    private long e;
    private boolean f;

    public e(String str, com.anythink.core.common.w.a.b.c cVar, com.anythink.core.common.w.a.b.d dVar) {
        this.b = str;
        this.c = cVar;
        this.d = dVar;
    }

    @Override // com.anythink.core.common.w.a.b.e
    public final void a(final Context context, final l lVar, final com.anythink.core.common.w.a.b.a aVar) {
        if (lVar == null) {
            aVar.a();
            return;
        }
        final ai aiVarBy = lVar.by();
        boolean z = aiVarBy == null || aiVarBy.a();
        boolean z2 = aiVarBy != null && aiVarBy.a(this.e);
        Object[] objArr = new Object[4];
        Boolean.valueOf(z);
        Boolean.valueOf(z2);
        Boolean.valueOf(this.f);
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
        com.anythink.core.common.w.a.b.c cVar = this.c;
        if (cVar != null) {
            cVar.a(aiVarBy);
        }
        final boolean zC = aiVarBy.c();
        Object[] objArr2 = new Object[1];
        Boolean.valueOf(zC);
        if (!zC) {
            aVar.a();
        }
        com.anythink.core.common.v.b.b.a().c(new Runnable() { // from class: com.anythink.core.common.w.a.a.e.1
            @Override // java.lang.Runnable
            public final void run() {
                e.a(e.this, context, lVar, aVar, aiVarBy).a(zC);
            }
        }, 13);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.w.a.a.e$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.core.common.w.a.c.a.InterfaceC0107a {
        final /* synthetic */ ai a;
        final /* synthetic */ com.anythink.core.common.w.a.b.a b;

        AnonymousClass2(ai aiVar, com.anythink.core.common.w.a.b.a aVar) {
            this.a = aiVar;
            this.b = aVar;
        }

        @Override // com.anythink.core.common.w.a.c.a.InterfaceC0107a
        public final void a(List<aj> list, boolean z) {
            this.a.a(list);
            com.anythink.core.common.w.a.b.a aVar = this.b;
            if (aVar == null || !z) {
                return;
            }
            aVar.a();
        }

        @Override // com.anythink.core.common.w.a.c.a.InterfaceC0107a
        public final void a(boolean z) {
            com.anythink.core.common.w.a.b.a aVar = this.b;
            if (aVar == null || !z) {
                return;
            }
            aVar.a();
        }
    }

    private com.anythink.core.common.w.a.c.a a(Context context, l lVar, com.anythink.core.common.w.a.b.a aVar, ai aiVar) {
        com.anythink.core.common.w.a.c.a aVar2 = new com.anythink.core.common.w.a.c.a(context, lVar, aiVar, this.d);
        aVar2.a(new AnonymousClass2(aiVar, aVar));
        return aVar2;
    }

    @Override // com.anythink.core.common.w.a.b.b
    public final void b() {
        this.f = false;
        this.e = 0L;
    }

    static /* synthetic */ com.anythink.core.common.w.a.c.a a(e eVar, Context context, l lVar, com.anythink.core.common.w.a.b.a aVar, ai aiVar) {
        com.anythink.core.common.w.a.c.a aVar2 = new com.anythink.core.common.w.a.c.a(context, lVar, aiVar, eVar.d);
        aVar2.a(eVar.new AnonymousClass2(aiVar, aVar));
        return aVar2;
    }
}
