package com.anythink.basead.exoplayer.g.c;

import com.anythink.basead.exoplayer.k.ac;
import com.anythink.basead.exoplayer.k.r;
import com.anythink.basead.exoplayer.k.s;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class c implements com.anythink.basead.exoplayer.g.b {
    private static final int a = 0;
    private static final int b = 4;
    private static final int c = 5;
    private static final int d = 6;
    private static final int e = 255;
    private final s f = new s();
    private final r g = new r();
    private ac h;

    @Override // com.anythink.basead.exoplayer.g.b
    public final com.anythink.basead.exoplayer.g.a a(com.anythink.basead.exoplayer.g.e eVar) {
        com.anythink.basead.exoplayer.g.a.InterfaceC0027a eVar2;
        if (this.h == null || eVar.g != this.h.a()) {
            ac acVar = new ac(eVar.f);
            this.h = acVar;
            acVar.b(eVar.f - eVar.g);
        }
        ByteBuffer byteBuffer = eVar.e;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f.a(bArrArray, iLimit);
        this.g.a(bArrArray, iLimit);
        this.g.b(39);
        long jC = (((long) this.g.c(1)) << 32) | ((long) this.g.c(32));
        this.g.b(20);
        int iC = this.g.c(12);
        int iC2 = this.g.c(8);
        this.f.d(14);
        if (iC2 == 0) {
            eVar2 = new e();
        } else if (iC2 == 255) {
            eVar2 = a.a(this.f, iC, jC);
        } else if (iC2 == 4) {
            eVar2 = f.a(this.f);
        } else if (iC2 == 5) {
            eVar2 = d.a(this.f, jC, this.h);
        } else {
            eVar2 = iC2 != 6 ? null : g.a(this.f, jC, this.h);
        }
        return eVar2 == null ? new com.anythink.basead.exoplayer.g.a(new com.anythink.basead.exoplayer.g.a.InterfaceC0027a[0]) : new com.anythink.basead.exoplayer.g.a(eVar2);
    }
}
