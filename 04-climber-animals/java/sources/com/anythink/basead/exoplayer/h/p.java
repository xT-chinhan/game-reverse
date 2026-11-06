package com.anythink.basead.exoplayer.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class p extends com.anythink.basead.exoplayer.ae {
    protected final com.anythink.basead.exoplayer.ae b;

    public p(com.anythink.basead.exoplayer.ae aeVar) {
        this.b = aeVar;
    }

    @Override // com.anythink.basead.exoplayer.ae
    public final int b() {
        return this.b.b();
    }

    @Override // com.anythink.basead.exoplayer.ae
    public int a(int i, int i2, boolean z) {
        return this.b.a(i, i2, z);
    }

    @Override // com.anythink.basead.exoplayer.ae
    public int b(int i, int i2, boolean z) {
        return this.b.b(i, i2, z);
    }

    @Override // com.anythink.basead.exoplayer.ae
    public final int a(boolean z) {
        return this.b.a(z);
    }

    @Override // com.anythink.basead.exoplayer.ae
    public final int b(boolean z) {
        return this.b.b(z);
    }

    @Override // com.anythink.basead.exoplayer.ae
    public com.anythink.basead.exoplayer.ae.b a(int i, com.anythink.basead.exoplayer.ae.b bVar, boolean z, long j) {
        return this.b.a(i, bVar, z, j);
    }

    @Override // com.anythink.basead.exoplayer.ae
    public final int c() {
        return this.b.c();
    }

    @Override // com.anythink.basead.exoplayer.ae
    public com.anythink.basead.exoplayer.ae.a a(int i, com.anythink.basead.exoplayer.ae.a aVar, boolean z) {
        return this.b.a(i, aVar, z);
    }

    @Override // com.anythink.basead.exoplayer.ae
    public int a(Object obj) {
        return this.b.a(obj);
    }
}
