package com.byazt.iip;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 4, 5})
public class q implements qg {
    public final FileChannel n;
    public final long qg;
    public final long s;

    public q(FileChannel fileChannel, long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j2)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        this.n = fileChannel;
        this.qg = j;
        this.s = j2;
    }

    @Override // com.byazt.iip.qg
    public long n() {
        long j = this.s;
        if (j != -1) {
            return j;
        }
        try {
            return this.n.size();
        } catch (IOException unused) {
            return 0L;
        }
    }

    @Override // com.byazt.iip.qg
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public q n(long j, long j2) {
        long jN = n();
        n(j, j2, jN);
        return (j == 0 && j2 == jN) ? this : new q(this.n, this.qg + j, j2);
    }

    public void n(long j, int i, ByteBuffer byteBuffer) throws IOException {
        int i2;
        n(j, i, n());
        if (i == 0) {
            return;
        }
        if (i > byteBuffer.remaining()) {
            throw new BufferOverflowException();
        }
        long j2 = this.qg + j;
        int iLimit = byteBuffer.limit();
        try {
            byteBuffer.limit(byteBuffer.position() + i);
            while (i > 0) {
                synchronized (this.n) {
                    this.n.position(j2);
                    i2 = this.n.read(byteBuffer);
                }
                j2 += (long) i2;
                i -= i2;
            }
            byteBuffer.limit(iLimit);
        } catch (Throwable th) {
            byteBuffer.limit(iLimit);
            throw th;
        }
    }

    @Override // com.byazt.iip.qg
    public ByteBuffer n(long j, int i) throws IOException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(i)));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        n(j, i, byteBufferAllocate);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private static void n(long j, long j2, long j3) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        if (j > j3) {
            throw new IndexOutOfBoundsException("offset (" + j + ") > source size (" + j3 + ")");
        }
        long j4 = j + j2;
        if (j4 < j) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") overflow");
        }
        if (j4 > j3) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") > source size (" + j3 + ")");
        }
    }
}
