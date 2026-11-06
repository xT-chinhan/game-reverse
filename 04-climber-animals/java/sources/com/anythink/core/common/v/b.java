package com.anythink.core.common.v;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    private boolean a;
    private final com.anythink.core.common.t.a b = com.anythink.core.common.t.d.a();
    private final com.anythink.core.common.t.b c = new com.anythink.core.common.t.b() { // from class: com.anythink.core.common.v.b.1
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.a) {
                return;
            }
            b.b(b.this);
            b.this.b();
        }
    };

    protected abstract void b();

    static /* synthetic */ boolean b(b bVar) {
        bVar.a = true;
        return true;
    }

    protected final synchronized void a(long j) {
        this.b.a(this.c, j, false);
    }

    public final synchronized void a() {
        this.b.b(this.c);
    }

    private boolean c() {
        return this.a;
    }
}
