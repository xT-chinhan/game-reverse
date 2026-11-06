package com.anythink.core.common.n.b.a.b;

import com.anythink.core.common.n.b.ah;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class g {
    private final Set<ah> a = new LinkedHashSet();

    g() {
    }

    public final synchronized void a(ah ahVar) {
        this.a.add(ahVar);
    }

    public final synchronized void b(ah ahVar) {
        this.a.remove(ahVar);
    }

    public final synchronized boolean c(ah ahVar) {
        return this.a.contains(ahVar);
    }
}
