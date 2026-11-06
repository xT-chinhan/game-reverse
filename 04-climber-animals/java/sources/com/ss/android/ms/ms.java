package com.ss.android.ms;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes3.dex */
public class ms implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final RandomAccessFile f4546ms;

    public ms(File file) throws FileNotFoundException {
        this.f4546ms = new RandomAccessFile(file, t.k);
    }

    @Override // com.ss.android.ms.xr
    public long ms() throws IOException {
        return this.f4546ms.length();
    }

    @Override // com.ss.android.ms.xr
    public int ms(byte[] bArr, int i, int i2) throws IOException {
        return this.f4546ms.read(bArr, i, i2);
    }

    @Override // com.ss.android.ms.xr
    public void ms(long j, long j2) throws IOException {
        this.f4546ms.seek(j);
    }

    @Override // com.ss.android.ms.xr
    public void xr() throws IOException {
        this.f4546ms.close();
    }
}
