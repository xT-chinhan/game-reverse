package com.anythink.basead.exoplayer.j;

/* JADX INFO: loaded from: classes.dex */
public final class x implements h.a {
    private final h.a a;
    private final com.anythink.basead.exoplayer.k.v b;
    private final int c;

    private x(h.a aVar, com.anythink.basead.exoplayer.k.v vVar, int i) {
        this.a = aVar;
        this.b = vVar;
        this.c = i;
    }

    private w b() {
        return new w(this.a.a(), this.b, this.c);
    }

    @Override // com.anythink.basead.exoplayer.j.h.a
    public final /* synthetic */ h a() {
        return new w(this.a.a(), this.b, this.c);
    }
}
