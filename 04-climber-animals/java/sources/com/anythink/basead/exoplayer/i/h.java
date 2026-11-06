package com.anythink.basead.exoplayer.i;

import com.anythink.basead.exoplayer.h.af;
import com.anythink.basead.exoplayer.z;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    private a a;

    public interface a {
        void c();
    }

    public abstract i a(z[] zVarArr, af afVar);

    public abstract void a(Object obj);

    public final void a(a aVar) {
        this.a = aVar;
    }

    protected final void b() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
