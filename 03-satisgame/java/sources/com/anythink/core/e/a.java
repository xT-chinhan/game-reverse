package com.anythink.core.e;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private final int a;

    public a(b bVar) {
        this.a = bVar != null ? bVar.aI() : 2;
    }

    public final void a(com.anythink.core.common.l.s sVar) {
        int i = this.a;
        if (i == 1) {
            new com.anythink.core.common.l.l().a(0, sVar);
        } else {
            if (i == 2) {
                new com.anythink.core.common.l.e.e().a(sVar);
                return;
            }
            com.anythink.core.common.l.p pVar = new com.anythink.core.common.l.p(sVar);
            new com.anythink.core.common.l.l().a(0, (com.anythink.core.common.l.s) pVar);
            new com.anythink.core.common.l.e.e().a(pVar);
        }
    }

    public final int a() {
        return this.a;
    }
}
