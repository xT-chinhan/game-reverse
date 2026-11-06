package com.bytedance.sdk.component.panglearmor.ms.ms.xr.xr;

import android.util.Pair;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.panglearmor.ms.xr.xr;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {
    public static long ms(ByteBuffer byteBuffer) {
        d(byteBuffer);
        return xr(byteBuffer, byteBuffer.position() + 16);
    }

    public static long xr(ByteBuffer byteBuffer) {
        d(byteBuffer);
        return xr(byteBuffer, byteBuffer.position() + 12);
    }

    public static int ah(ByteBuffer byteBuffer) {
        d(byteBuffer);
        return ms(byteBuffer, byteBuffer.position() + 10);
    }

    public static Pair<ByteBuffer, Long> ms(xr xrVar) throws IOException {
        if (xrVar.ms() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> pairMs = ms(xrVar, 0);
        return pairMs != null ? pairMs : ms(xrVar, SupportMenu.USER_MASK);
    }

    private static Pair<ByteBuffer, Long> ms(xr xrVar, int i) throws IOException {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
        }
        long jMs = xrVar.ms();
        if (jMs < 22) {
            return null;
        }
        int iMin = ((int) Math.min(i, jMs - 22)) + 22;
        long j = jMs - ((long) iMin);
        ByteBuffer byteBufferMs = xrVar.ms(j, iMin);
        byteBufferMs.order(ByteOrder.LITTLE_ENDIAN);
        int iKa = ka(byteBufferMs);
        if (iKa == -1) {
            return null;
        }
        byteBufferMs.position(iKa);
        ByteBuffer byteBufferSlice = byteBufferMs.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return new Pair<>(byteBufferSlice, Long.valueOf(j + ((long) iKa)));
    }

    private static int ka(ByteBuffer byteBuffer) {
        d(byteBuffer);
        int iCapacity = byteBuffer.capacity();
        if (iCapacity < 22) {
            return -1;
        }
        int i = iCapacity - 22;
        int iMin = Math.min(i, SupportMenu.USER_MASK);
        for (int i2 = 0; i2 <= iMin; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && ms(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    static void d(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static int ms(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & UShort.MAX_VALUE;
    }

    static long xr(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }
}
