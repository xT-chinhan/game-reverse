package com.anythink.core.common.q;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {
    private final int a = 16;
    private final h b;
    private final a c;

    public f(h hVar, a aVar) {
        this.b = hVar;
        this.c = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(this.a, this.b);
        }
    }
}
