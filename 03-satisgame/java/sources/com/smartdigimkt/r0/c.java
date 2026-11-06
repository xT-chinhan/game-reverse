package com.smartdigimkt.r0;

import com.bykv.vk.component.ttvideo.player.C;
import com.smartdigimkt.q0.d;
import com.smartdigimkt.q0.f;
import com.smartdigimkt.z0.m;
import com.smartdigimkt.z0.u;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements d {
    @Override // com.smartdigimkt.q0.d
    public final com.smartdigimkt.q0.c a(f fVar) {
        ByteBuffer byteBuffer = fVar.b;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        m mVar = new m(iLimit, bArrArray);
        String strC = mVar.c();
        String strC2 = mVar.c();
        long jF = mVar.f();
        return new com.smartdigimkt.q0.c(new b(strC, strC2, u.a(mVar.f(), 1000L, jF), mVar.f(), Arrays.copyOfRange(bArrArray, mVar.b, iLimit), u.a(mVar.f(), C.MICROS_PER_SECOND, jF)));
    }
}
