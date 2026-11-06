package com.anythink.core.common.w.b;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g implements a {
    private final List<c> a;
    private final h b;
    private final int c;
    private volatile boolean d;

    public g(List<c> list, h hVar, int i) {
        this.a = list;
        this.b = hVar;
        this.c = i;
    }

    @Override // com.anythink.core.common.w.b.a
    public final h a() {
        return this.b;
    }

    @Override // com.anythink.core.common.w.b.a
    public final void a(h hVar) {
        try {
            List<c> list = this.a;
            if (list != null && this.c >= list.size()) {
                b(hVar);
            } else {
                this.a.get(this.c).a(new g(this.a, hVar, this.c + 1));
            }
        } catch (Throwable unused) {
            b(hVar);
        }
    }

    private void b(h hVar) {
        if (this.d || hVar == null || hVar.d == null) {
            return;
        }
        this.d = true;
        hVar.d.a();
    }
}
