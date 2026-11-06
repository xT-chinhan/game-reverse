package com.anythink.basead.exoplayer.h.a;

import com.anythink.basead.exoplayer.ae;
import com.anythink.basead.exoplayer.h.p;

/* JADX INFO: loaded from: classes.dex */
final class d extends p {
    private final a c;

    public d(ae aeVar, a aVar) {
        super(aeVar);
        com.anythink.basead.exoplayer.k.a.b(aeVar.c() == 1);
        com.anythink.basead.exoplayer.k.a.b(aeVar.b() == 1);
        this.c = aVar;
    }

    @Override // com.anythink.basead.exoplayer.h.p, com.anythink.basead.exoplayer.ae
    public final ae.a a(int i, ae.a aVar, boolean z) {
        this.b.a(i, aVar, z);
        aVar.a(aVar.a, aVar.b, aVar.c, aVar.d, aVar.b(), this.c);
        return aVar;
    }

    @Override // com.anythink.basead.exoplayer.h.p, com.anythink.basead.exoplayer.ae
    public final ae.b a(int i, ae.b bVar, boolean z, long j) {
        ae.b bVarA = super.a(i, bVar, z, j);
        if (bVarA.i == -9223372036854775807L) {
            bVarA.i = this.c.k;
        }
        return bVarA;
    }
}
