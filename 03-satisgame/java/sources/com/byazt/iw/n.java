package com.byazt.iw;

import android.util.Pair;
import androidx.core.internal.view.SupportMenu;
import com.byazt.iip.qg;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1255, 19})
public abstract class n {
    public static long n(ByteBuffer byteBuffer) {
        q(byteBuffer);
        return qg(byteBuffer, byteBuffer.position() + 16);
    }

    public static long qg(ByteBuffer byteBuffer) {
        q(byteBuffer);
        return qg(byteBuffer, byteBuffer.position() + 12);
    }

    public static int s(ByteBuffer byteBuffer) {
        q(byteBuffer);
        return n(byteBuffer, byteBuffer.position() + 10);
    }

    public static Pair<ByteBuffer, Long> n(qg qgVar) throws IOException {
        if (qgVar.n() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> pairN = n(qgVar, 0);
        return pairN != null ? pairN : n(qgVar, SupportMenu.USER_MASK);
    }

    private static Pair<ByteBuffer, Long> n(qg qgVar, int i) throws IOException {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
        }
        long jN = qgVar.n();
        if (jN < 22) {
            return null;
        }
        int iMin = ((int) Math.min(i, jN - 22)) + 22;
        long j = jN - ((long) iMin);
        ByteBuffer byteBufferN = qgVar.n(j, iMin);
        byteBufferN.order(ByteOrder.LITTLE_ENDIAN);
        int iL = l(byteBufferN);
        if (iL == -1) {
            return null;
        }
        byteBufferN.position(iL);
        ByteBuffer byteBufferSlice = byteBufferN.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return new Pair<>(byteBufferSlice, Long.valueOf(j + ((long) iL)));
    }

    private static int l(ByteBuffer byteBuffer) {
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

    public static void q(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static int n(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & UShort.MAX_VALUE;
    }

    public static long qg(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }
}
