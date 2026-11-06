package com.byazt.iy;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1124, 113})
public class d extends l {
    public static final int n = l.n("IHDR");
    public byte[] fs = new byte[5];
    public int qg;
    public int s;

    @Override // com.byazt.iy.l
    public void n(com.byazt.gq.n nVar) throws IOException {
        this.qg = nVar.qg();
        this.s = nVar.qg();
        byte[] bArr = this.fs;
        nVar.n(bArr, 0, bArr.length);
    }
}
