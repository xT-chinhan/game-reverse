package com.bytedance.sdk.component.panglearmor.ms.ms.ms;

import android.util.Pair;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static com.bytedance.sdk.component.panglearmor.ms.ms.ah.xr ms(com.bytedance.sdk.component.panglearmor.ms.xr.xr xrVar) throws com.bytedance.sdk.component.panglearmor.ms.ms.ah.ms, IOException {
        Pair<ByteBuffer, Long> pairMs = com.bytedance.sdk.component.panglearmor.ms.ms.xr.xr.ms.ms(xrVar);
        if (pairMs == null) {
            throw new com.bytedance.sdk.component.panglearmor.ms.ms.ah.ms("ZIP End of Central Directory record not found");
        }
        ByteBuffer byteBuffer = (ByteBuffer) pairMs.first;
        long jLongValue = ((Long) pairMs.second).longValue();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        long jMs = com.bytedance.sdk.component.panglearmor.ms.ms.xr.xr.ms.ms(byteBuffer);
        if (jMs > jLongValue) {
            throw new com.bytedance.sdk.component.panglearmor.ms.ms.ah.ms("ZIP Central Directory start offset out of range: " + jMs + ". ZIP End of Central Directory offset: " + jLongValue);
        }
        long jXr = com.bytedance.sdk.component.panglearmor.ms.ms.xr.xr.ms.xr(byteBuffer);
        long j = jMs + jXr;
        if (j > jLongValue) {
            throw new com.bytedance.sdk.component.panglearmor.ms.ms.ah.ms("ZIP Central Directory overlaps with End of Central Directory. CD end: " + j + ", EoCD start: " + jLongValue);
        }
        return new com.bytedance.sdk.component.panglearmor.ms.ms.ah.xr(jMs, jXr, com.bytedance.sdk.component.panglearmor.ms.ms.xr.xr.ms.ah(byteBuffer), jLongValue, byteBuffer);
    }

    public static ms ms(com.bytedance.sdk.component.panglearmor.ms.xr.xr xrVar, com.bytedance.sdk.component.panglearmor.ms.ms.ah.xr xrVar2) throws Exception {
        long jMs = xrVar2.ms();
        long jXr = xrVar2.xr() + jMs;
        long jD = xrVar2.d();
        if (jXr != jD) {
            throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: " + jXr + ", EoCD start: " + jD);
        }
        if (jMs < 32) {
            throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(jMs)));
        }
        ByteBuffer byteBufferMs = xrVar.ms(jMs - 24, 24);
        byteBufferMs.order(ByteOrder.LITTLE_ENDIAN);
        if (byteBufferMs.getLong(8) != 2334950737559900225L || byteBufferMs.getLong(16) != 3617552046287187010L) {
            throw new Exception("No APK Signing Block before ZIP Central Directory");
        }
        long j = byteBufferMs.getLong(0);
        if (j < byteBufferMs.capacity() || j > 2147483639) {
            throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j)));
        }
        long j2 = (int) (8 + j);
        long j3 = jMs - j2;
        if (j3 < 0) {
            throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        ByteBuffer byteBufferMs2 = xrVar.ms(j3, 8);
        byteBufferMs2.order(ByteOrder.LITTLE_ENDIAN);
        long j4 = byteBufferMs2.getLong(0);
        if (j4 != j) {
            throw new Exception("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j);
        }
        return new ms(j3, xrVar.ms(j3, j2));
    }

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final long f1313ms;
        private final com.bytedance.sdk.component.panglearmor.ms.xr.xr xr;

        public ms(long j, com.bytedance.sdk.component.panglearmor.ms.xr.xr xrVar) {
            this.f1313ms = j;
            this.xr = xrVar;
        }

        public long ms() {
            return this.f1313ms;
        }

        public com.bytedance.sdk.component.panglearmor.ms.xr.xr xr() {
            return this.xr;
        }
    }
}
