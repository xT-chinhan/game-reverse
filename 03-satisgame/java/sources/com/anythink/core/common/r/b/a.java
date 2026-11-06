package com.anythink.core.common.r.b;

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
        if (cVar == null || !cVar.d()) {
            this.c = true;
            f fVar = this.b;
            if (fVar == null || this.a == null) {
                return;
            }
            Map<String, Object> mapA = fVar.a();
            if (mapA == null || mapA.isEmpty()) {
                this.a.e();
                return;
            }
            for (String str : mapA.keySet()) {
                com.anythink.core.common.r.b.a();
                if ((!com.anythink.core.common.r.b.a(str)) && !this.a.a(str)) {
                    this.a.a(str, mapA.get(str));
                }
            }
            this.a.e();
            this.b.b();
        }
    }
}
