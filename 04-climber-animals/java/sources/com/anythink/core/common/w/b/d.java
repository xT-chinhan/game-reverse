package com.anythink.core.common.w.b;

import com.anythink.core.d.l;

/* JADX INFO: loaded from: classes.dex */
public final class d implements c {
    @Override // com.anythink.core.common.w.b.c
    public final void a(a aVar) {
        getClass().getSimpleName();
        h hVarA = aVar.a();
        l lVar = hVarA.c;
        if (lVar != null) {
            a(aVar, hVarA, !lVar.aR() && lVar.bl());
        } else {
            a(aVar, hVarA, true);
        }
    }

    private void a(final a aVar, final h hVar, boolean z) {
        com.anythink.core.common.g.c.a().a(new com.anythink.core.common.g.d() { // from class: com.anythink.core.common.w.b.d.1
            @Override // com.anythink.core.common.g.d
            public final void a(String str) {
                aVar.a(hVar);
            }
        }, z);
    }
}
