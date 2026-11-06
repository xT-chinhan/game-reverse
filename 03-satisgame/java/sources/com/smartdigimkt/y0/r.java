package com.smartdigimkt.y0;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements i {
    public RandomAccessFile a;
    public Uri b;
    public long c;
    public boolean d;

    @Override // com.smartdigimkt.y0.i
    public final long a(k kVar) throws q {
        try {
            this.b = kVar.a;
            RandomAccessFile randomAccessFile = new RandomAccessFile(kVar.a.getPath(), "r");
            this.a = randomAccessFile;
            randomAccessFile.seek(kVar.c);
            long length = this.a.length() - kVar.c;
            this.c = length;
            if (length < 0) {
                throw new EOFException();
            }
            this.d = true;
            return length;
        } catch (IOException e) {
            throw new q(e);
        }
    }

    @Override // com.smartdigimkt.y0.i
    public final void close() {
        this.b = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.a;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.a = null;
                if (this.d) {
                    this.d = false;
                }
            } catch (IOException e) {
                throw new q(e);
            }
        } catch (Throwable th) {
            this.a = null;
            if (this.d) {
                this.d = false;
            }
            throw th;
        }
    }

    @Override // com.smartdigimkt.y0.i
    public final int a(byte[] bArr, int i, int i2) throws q {
        if (i2 == 0) {
            return 0;
        }
        long j = this.c;
        if (j == 0) {
            return -1;
        }
        try {
            int i3 = this.a.read(bArr, i, (int) Math.min(j, i2));
            if (i3 > 0) {
                this.c -= (long) i3;
            }
            return i3;
        } catch (IOException e) {
            throw new q(e);
        }
    }

    @Override // com.smartdigimkt.y0.i
    public final Uri a() {
        return this.b;
    }
}
