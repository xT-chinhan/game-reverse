package com.anythink.core.common.s.b;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private final c a;
    private final f b;
    private boolean c;

    public a(c cVar, f fVar) {
        this.a = cVar;
        this.b = fVar;
    }

    public final void a() {
        if (this.c) {
            return;
        }
        c cVar = this.a;
        if (cVar == null || !cVar.c()) {
            this.c = true;
            f fVar = this.b;
            if (fVar == null || this.a == null) {
                return;
            }
            Map<String, Object> mapA = fVar.a();
            if (mapA == null || mapA.isEmpty()) {
                this.a.d();
                return;
            }
            getClass().getSimpleName();
            Object[] objArr = new Object[1];
            this.b.c();
            for (String str : mapA.keySet()) {
                com.anythink.core.common.s.b.a();
                if ((!com.anythink.core.common.s.b.a(str)) && !this.a.a(str)) {
                    this.a.a(str, mapA.get(str));
                }
            }
            this.a.d();
            this.b.b();
        }
    }
}
