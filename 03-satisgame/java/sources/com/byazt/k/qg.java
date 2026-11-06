package com.byazt.k;

import com.anythink.core.common.d.i;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 210, 26})
public class qg {
    public static final void n(q qVar, int i) throws IOException {
        int iQg = qVar.qg();
        if (iQg != i) {
            throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(iQg) + i.E);
        }
    }
}
