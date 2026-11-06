package com.tapsdk.tapad.internal.download.core.breakpoint;

/* JADX INFO: loaded from: classes3.dex */
class m {
    private final l a;
    long b;

    m(l.a aVar) {
        this(new l(aVar));
    }

    m(l lVar) {
        this.a = lVar;
        this.b = 1500L;
    }

    void a() {
        this.a.a();
    }

    void a(int i) {
        this.a.e(i);
        this.a.c(i);
    }

    void b(int i) {
        this.a.e(i);
        try {
            if (!this.a.a(i)) {
                this.a.d(i);
            }
        } finally {
            this.a.b(i);
        }
    }

    boolean c(int i) {
        return !this.a.a(i);
    }

    void d(int i) {
        this.a.e(i);
        this.a.a(i, this.b);
    }
}
