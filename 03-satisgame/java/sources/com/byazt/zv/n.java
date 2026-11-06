package com.byazt.zv;

import com.byazt.gq.s;
import com.byazt.gq.w;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1422, 19})
public abstract class n implements qg {
    public abstract ByteBuffer n();

    @Override // com.byazt.zv.qg
    public w qg() throws IOException {
        return new s(n());
    }
}
