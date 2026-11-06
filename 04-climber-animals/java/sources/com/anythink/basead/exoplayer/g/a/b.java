package com.anythink.basead.exoplayer.g.a;

import com.anythink.basead.exoplayer.g.e;
import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.k.s;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b implements com.anythink.basead.exoplayer.g.b {
    @Override // com.anythink.basead.exoplayer.g.b
    public final com.anythink.basead.exoplayer.g.a a(e eVar) {
        ByteBuffer byteBuffer = eVar.e;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        s sVar = new s(bArrArray, iLimit);
        String strP = sVar.p();
        String strP2 = sVar.p();
        long jH = sVar.h();
        return new com.anythink.basead.exoplayer.g.a(new a(strP, strP2, af.a(sVar.h(), 1000L, jH), sVar.h(), Arrays.copyOfRange(bArrArray, sVar.c(), iLimit), af.a(sVar.h(), 1000000L, jH)));
    }
}
