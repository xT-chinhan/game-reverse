package com.byazt.bak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1704, 37})
public class pr implements hw {
    public final RandomAccessFile pr;

    public pr(File file) throws FileNotFoundException {
        this.pr = new RandomAccessFile(file, "r");
    }

    @Override // com.byazt.bak.hw
    public long pr() throws IOException {
        return this.pr.length();
    }

    @Override // com.byazt.bak.hw
    public int pr(byte[] bArr, int i, int i2) throws IOException {
        return this.pr.read(bArr, i, i2);
    }

    @Override // com.byazt.bak.hw
    public void pr(long j, long j2) throws IOException {
        this.pr.seek(j);
    }

    @Override // com.byazt.bak.hw
    public void hw() throws IOException {
        this.pr.close();
    }
}
