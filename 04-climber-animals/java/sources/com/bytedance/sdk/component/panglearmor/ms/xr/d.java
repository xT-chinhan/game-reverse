package com.bytedance.sdk.component.panglearmor.ms.xr;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
public class d implements xr {
    private final long ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final FileChannel f1315ms;
    private final long xr;

    public d(FileChannel fileChannel, long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j2)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        this.f1315ms = fileChannel;
        this.xr = j;
        this.ah = j2;
    }

    @Override // com.bytedance.sdk.component.panglearmor.ms.xr.xr
    public long ms() {
        long j = this.ah;
        if (j != -1) {
            return j;
        }
        try {
            return this.f1315ms.size();
        } catch (IOException unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.panglearmor.ms.xr.xr
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public d ms(long j, long j2) {
        long jMs = ms();
        ms(j, j2, jMs);
        return (j == 0 && j2 == jMs) ? this : new d(this.f1315ms, this.xr + j, j2);
    }

    public void ms(long j, int i, ByteBuffer byteBuffer) throws IOException {
        int i2;
        ms(j, i, ms());
        if (i == 0) {
            return;
        }
        if (i > byteBuffer.remaining()) {
            throw new BufferOverflowException();
        }
        long j2 = this.xr + j;
        int iLimit = byteBuffer.limit();
        try {
            byteBuffer.limit(byteBuffer.position() + i);
            while (i > 0) {
                synchronized (this.f1315ms) {
                    this.f1315ms.position(j2);
                    i2 = this.f1315ms.read(byteBuffer);
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

    @Override // com.bytedance.sdk.component.panglearmor.ms.xr.xr
    public ByteBuffer ms(long j, int i) throws IOException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(i)));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        ms(j, i, byteBufferAllocate);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private static void ms(long j, long j2, long j3) {
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
