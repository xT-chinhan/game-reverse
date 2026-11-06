package com.byazt.kd;

import com.byazt.iy.rv;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 810, 19})
public class n extends s<com.byazt.iy.qg> {
    public n(com.byazt.zv.qg qgVar) {
        super(qgVar);
    }

    @Override // com.byazt.kd.s
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public com.byazt.iy.qg qg(com.byazt.zv.qg qgVar, rv.n nVar) {
        return new com.byazt.iy.qg(qgVar, nVar);
    }

    public static n n(final ByteBuffer byteBuffer) {
        return new n(new com.byazt.zv.n() { // from class: com.byazt.kd.n.1
            @Override // com.byazt.zv.n
            public ByteBuffer n() {
                byteBuffer.position(0);
                return byteBuffer;
            }
        });
    }
}
