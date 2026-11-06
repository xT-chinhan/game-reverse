package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class pgla {

    public static class pblb extends Exception {
        public pblb(String str) {
            super(str);
        }
    }

    /* JADX INFO: renamed from: ms.bz.bd.c.Pgl.pgla$pgla, reason: collision with other inner class name */
    static final class C0451pgla<A, B> {
        private final A n;
        private final B qg;

        /* JADX WARN: Multi-variable type inference failed */
        private C0451pgla(ByteBuffer byteBuffer, Long l) {
            this.n = byteBuffer;
            this.qg = l;
        }

        public static C0451pgla n(ByteBuffer byteBuffer, Long l) {
            return new C0451pgla(byteBuffer, l);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0451pgla.class != obj.getClass()) {
                return false;
            }
            C0451pgla c0451pgla = (C0451pgla) obj;
            A a = this.n;
            if (a == null) {
                if (c0451pgla.n != null) {
                    return false;
                }
            } else if (!a.equals(c0451pgla.n)) {
                return false;
            }
            B b = this.qg;
            B b2 = c0451pgla.qg;
            if (b == null) {
                return b2 == null;
            }
            return b.equals(b2);
        }

        public final int hashCode() {
            A a = this.n;
            int iHashCode = ((a == null ? 0 : a.hashCode()) + 31) * 31;
            B b = this.qg;
            return iHashCode + (b != null ? b.hashCode() : 0);
        }

        public final A n() {
            return this.n;
        }
    }

    public static HashMap n(String str) {
        RandomAccessFile randomAccessFile = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "339bd8", new byte[]{48}));
                try {
                    for (Map.Entry entry : n(n(randomAccessFile2.getChannel()).n()).entrySet()) {
                        if (entry != null && entry.getKey() != null && ((Integer) entry.getKey()).intValue() != 1896449818) {
                            try {
                                ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
                                byte[] bArrArray = byteBuffer.array();
                                int iArrayOffset = byteBuffer.arrayOffset();
                                map.put((Integer) entry.getKey(), new String(Arrays.copyOfRange(bArrArray, byteBuffer.position() + iArrayOffset, byteBuffer.limit() + iArrayOffset)));
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    randomAccessFile2.close();
                } catch (Throwable unused2) {
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    return map;
                }
            } catch (Throwable unused3) {
            }
        } catch (Throwable unused4) {
        }
        return map;
    }

    public static C0451pgla<ByteBuffer, Long> n(FileChannel fileChannel) throws pblb, IOException {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1cf626", new byte[]{113, 48}));
        }
        long j = size - 22;
        long jMin = Math.min(j, 65535L);
        int i = 0;
        while (true) {
            long j2 = i;
            if (j2 > jMin) {
                throw new IOException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a06371", new byte[]{33, 98}));
            }
            long j3 = j - j2;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            fileChannel.position(j3);
            fileChannel.read(byteBufferAllocate);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            if (byteBufferAllocate.getInt(0) == 101010256) {
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(2);
                fileChannel.position(j3 + 20);
                fileChannel.read(byteBufferAllocate2);
                byteBufferAllocate2.order(byteOrder);
                short s = byteBufferAllocate2.getShort(0);
                if (s == i) {
                    ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(4);
                    byteBufferAllocate3.order(byteOrder);
                    fileChannel.position((fileChannel.size() - ((long) s)) - 6);
                    fileChannel.read(byteBufferAllocate3);
                    long j4 = byteBufferAllocate3.getInt(0);
                    if (j4 < 32) {
                        throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a03d54", new byte[]{41}));
                    }
                    fileChannel.position(j4 - 24);
                    ByteBuffer byteBufferAllocate4 = ByteBuffer.allocate(24);
                    fileChannel.read(byteBufferAllocate4);
                    byteBufferAllocate4.order(byteOrder);
                    if (byteBufferAllocate4.getLong(8) != 2334950737559900225L || byteBufferAllocate4.getLong(16) != 3617552046287187010L) {
                        return null;
                    }
                    long j5 = byteBufferAllocate4.getLong(0);
                    if (j5 < byteBufferAllocate4.capacity() || j5 > 2147483639) {
                        return null;
                    }
                    int i2 = (int) (8 + j5);
                    long j6 = j4 - ((long) i2);
                    if (j6 < 0) {
                        return null;
                    }
                    fileChannel.position(j6);
                    ByteBuffer byteBufferAllocate5 = ByteBuffer.allocate(i2);
                    fileChannel.read(byteBufferAllocate5);
                    byteBufferAllocate5.order(byteOrder);
                    if (byteBufferAllocate5.getLong(0) == j5) {
                        return C0451pgla.n(byteBufferAllocate5, Long.valueOf(j6));
                    }
                    return null;
                }
            }
            i++;
        }
    }

    public static LinkedHashMap n(ByteBuffer byteBuffer) throws pblb {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
            int iCapacity = byteBuffer.capacity() - 24;
            if (iCapacity < 8) {
                throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "61f40e", new byte[]{115}));
            }
            byteBuffer.capacity();
            if (iCapacity > byteBuffer.capacity()) {
                throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a542e4", new byte[]{37}));
            }
            int iLimit = byteBuffer.limit();
            int iPosition = byteBuffer.position();
            try {
                byteBuffer.position(0);
                byteBuffer.limit(iCapacity);
                byteBuffer.position(8);
                ByteBuffer byteBufferSlice = byteBuffer.slice();
                byteBufferSlice.order(byteBuffer.order());
                byteBuffer.position(0);
                byteBuffer.limit(iLimit);
                byteBuffer.position(iPosition);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (byteBufferSlice.hasRemaining()) {
                    if (byteBufferSlice.remaining() < 8) {
                        throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c60056", new byte[]{36}));
                    }
                    long j = byteBufferSlice.getLong();
                    if (j < 4 || j > 2147483647L) {
                        throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "90bd7e", new byte[]{127}));
                    }
                    int i = (int) j;
                    int iPosition2 = byteBufferSlice.position() + i;
                    if (i > byteBufferSlice.remaining()) {
                        throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e2db05", new byte[]{44}));
                    }
                    Integer numValueOf = Integer.valueOf(byteBufferSlice.getInt());
                    int i2 = i - 4;
                    if (i2 < 0) {
                        throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2ae5b8", new byte[]{113}));
                    }
                    int iLimit2 = byteBufferSlice.limit();
                    int iPosition3 = byteBufferSlice.position();
                    int i3 = i2 + iPosition3;
                    if (i3 < iPosition3 || i3 > iLimit2) {
                        throw new BufferUnderflowException();
                    }
                    byteBufferSlice.limit(i3);
                    try {
                        ByteBuffer byteBufferSlice2 = byteBufferSlice.slice();
                        byteBufferSlice2.order(byteBufferSlice.order());
                        byteBufferSlice.position(i3);
                        byteBufferSlice.limit(iLimit2);
                        linkedHashMap.put(numValueOf, byteBufferSlice2);
                        byteBufferSlice.position(iPosition2);
                    } catch (Throwable th) {
                        byteBufferSlice.limit(iLimit2);
                        throw th;
                    }
                }
                return linkedHashMap;
            } catch (Throwable th2) {
                byteBuffer.position(0);
                byteBuffer.limit(iLimit);
                byteBuffer.position(iPosition);
                throw th2;
            }
        }
        throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "17508b", new byte[]{113}));
    }
}
