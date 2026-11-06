package com.byazt.v;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 984, 19})
public class n implements qg {
    public final RandomAccessFile n;

    public n(File file) throws FileNotFoundException {
        this.n = new RandomAccessFile(file, "r");
    }

    @Override // com.byazt.v.qg
    public long n() throws IOException {
        return this.n.length();
    }

    @Override // com.byazt.v.qg
    public int n(byte[] bArr, int i, int i2) throws IOException {
        return this.n.read(bArr, i, i2);
    }

    @Override // com.byazt.v.qg
    public void n(long j, long j2) throws IOException {
        this.n.seek(j);
    }

    @Override // com.byazt.v.qg
    public void qg() throws IOException {
        this.n.close();
    }
}
