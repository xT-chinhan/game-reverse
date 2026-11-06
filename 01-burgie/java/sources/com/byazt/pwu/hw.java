package com.byazt.pwu;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1002, 13})
public class hw {
    public static final void pr(x xVar, int i) throws IOException {
        int iHw = xVar.hw();
        if (iHw != i) {
            throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(iHw) + ".");
        }
    }
}
