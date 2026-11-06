package com.smartdigimkt.p0;

import android.media.MediaCodec;
import com.smartdigimkt.i0.s;
import com.smartdigimkt.z0.u;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends Exception {
    public b(s sVar, f fVar, int i) {
        super("Decoder init failed: [" + i + "], " + sVar, fVar);
        String str = sVar.f;
        Math.abs(i);
    }

    public b(s sVar, Exception exc, String str) {
        super("Decoder init failed: " + str + ", " + sVar, exc);
        String str2 = sVar.f;
        if (u.a < 21 || !(exc instanceof MediaCodec.CodecException)) {
            return;
        }
        ((MediaCodec.CodecException) exc).getDiagnosticInfo();
    }
}
