package com.anythink.core.d;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private final int a;

    public a(b bVar) {
        this.a = bVar != null ? bVar.aT() : 2;
    }

    public final void a(com.anythink.core.common.m.q qVar) {
        getClass().getSimpleName();
        Object[] objArr = new Object[1];
        Integer.valueOf(this.a);
        int i = this.a;
        if (i == 1) {
            new com.anythink.core.common.m.k().a(0, qVar);
        } else {
            if (i == 2) {
                new com.anythink.core.common.m.d.b().a(qVar);
                return;
            }
            com.anythink.core.common.m.n nVar = new com.anythink.core.common.m.n(qVar);
            new com.anythink.core.common.m.k().a(0, (com.anythink.core.common.m.q) nVar);
            new com.anythink.core.common.m.d.b().a(nVar);
        }
    }

    public final int a() {
        return this.a;
    }
}
