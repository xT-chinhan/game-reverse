package com.tapsdk.tapad.internal.q.g;

/* JADX INFO: loaded from: classes3.dex */
public class b implements c {
    private final a a;
    private int b = 0;

    public interface a {
        void a(long j);
    }

    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.tapsdk.tapad.internal.q.g.c
    public void a() {
        this.a.a(this.b);
    }

    @Override // com.tapsdk.tapad.internal.q.g.c
    public void a(int i) {
        this.b += i;
    }
}
