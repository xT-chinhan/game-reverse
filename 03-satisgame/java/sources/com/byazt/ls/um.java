package com.byazt.ls;

import android.util.Pair;
import androidx.core.internal.view.SupportMenu;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 32, 33})
public abstract class um {
    public static Pair<ByteBuffer, Long> n(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> pairN = n(randomAccessFile, 0);
        return pairN != null ? pairN : n(randomAccessFile, SupportMenu.USER_MASK);
    }

    private static Pair<ByteBuffer, Long> n(RandomAccessFile randomAccessFile, int i) throws IOException {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(((int) Math.min(i, length - 22)) + 22);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long jCapacity = length - ((long) byteBufferAllocate.capacity());
        randomAccessFile.seek(jCapacity);
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        int iS = s(byteBufferAllocate);
        if (iS == -1) {
            return null;
        }
        byteBufferAllocate.position(iS);
        ByteBuffer byteBufferSlice = byteBufferAllocate.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(byteBufferSlice, Long.valueOf(jCapacity + ((long) iS)));
    }

    private static int s(ByteBuffer byteBuffer) {
        q(byteBuffer);
        int iCapacity = byteBuffer.capacity();
        if (iCapacity < 22) {
            return -1;
        }
        int i = iCapacity - 22;
        int iMin = Math.min(i, SupportMenu.USER_MASK);
        for (int i2 = 0; i2 <= iMin; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && n(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static final boolean n(RandomAccessFile randomAccessFile, long j) throws IOException {
        long j2 = j - 20;
        if (j2 < 0) {
            return false;
        }
        randomAccessFile.seek(j2);
        return randomAccessFile.readInt() == 1347094023;
    }

    public static long n(ByteBuffer byteBuffer) {
        q(byteBuffer);
        return qg(byteBuffer, byteBuffer.position() + 16);
    }

    public static void n(ByteBuffer byteBuffer, long j) {
        q(byteBuffer);
        n(byteBuffer, byteBuffer.position() + 16, j);
    }

    public static long qg(ByteBuffer byteBuffer) {
        q(byteBuffer);
        return qg(byteBuffer, byteBuffer.position() + 12);
    }

    private static void q(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int n(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & UShort.MAX_VALUE;
    }

    private static long qg(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    private static void n(ByteBuffer byteBuffer, int i, long j) {
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j)));
        }
        byteBuffer.putInt(byteBuffer.position() + i, (int) j);
    }
}
