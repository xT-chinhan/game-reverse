package com.byazt.ly;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 406, 121})
public class x implements hw {
    public final long hn;
    public final long hw;
    public final FileChannel pr;

    public x(FileChannel fileChannel, long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j2)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        this.pr = fileChannel;
        this.hw = j;
        this.hn = j2;
    }

    @Override // com.byazt.ly.hw
    public long pr() {
        long j = this.hn;
        if (j == -1) {
            try {
                return this.pr.size();
            } catch (IOException e) {
                return 0L;
            }
        }
        return j;
    }

    @Override // com.byazt.ly.hw
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public x pr(long j, long j2) {
        long jPr = pr();
        pr(j, j2, jPr);
        if (j == 0 && j2 == jPr) {
            return this;
        }
        return new x(this.pr, this.hw + j, j2);
    }

    public void pr(long j, int i, ByteBuffer byteBuffer) throws IOException {
        int i2;
        pr(j, i, pr());
        if (i == 0) {
            return;
        }
        if (i > byteBuffer.remaining()) {
            throw new BufferOverflowException();
        }
        long j2 = this.hw + j;
        int iLimit = byteBuffer.limit();
        try {
            byteBuffer.limit(byteBuffer.position() + i);
            while (i > 0) {
                synchronized (this.pr) {
                    this.pr.position(j2);
                    i2 = this.pr.read(byteBuffer);
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

    @Override // com.byazt.ly.hw
    public ByteBuffer pr(long j, int i) throws IOException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(i)));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        pr(j, i, byteBufferAllocate);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private static void pr(long j, long j2, long j3) {
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
