package com.byazt.kdu;

import android.util.Pair;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1307, 26})
public class qg {
    public static com.byazt.ujk.qg n(com.byazt.iip.qg qgVar) throws com.byazt.ujk.n, IOException {
        Pair<ByteBuffer, Long> pairN = com.byazt.iw.n.n(qgVar);
        if (pairN == null) {
            throw new com.byazt.ujk.n("ZIP End of Central Directory record not found");
        }
        ByteBuffer byteBuffer = (ByteBuffer) pairN.first;
        long jLongValue = ((Long) pairN.second).longValue();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        long jN = com.byazt.iw.n.n(byteBuffer);
        if (jN > jLongValue) {
            throw new com.byazt.ujk.n("ZIP Central Directory start offset out of range: " + jN + ". ZIP End of Central Directory offset: " + jLongValue);
        }
        long jQg = com.byazt.iw.n.qg(byteBuffer);
        long j = jN + jQg;
        if (j > jLongValue) {
            throw new com.byazt.ujk.n("ZIP Central Directory overlaps with End of Central Directory. CD end: " + j + ", EoCD start: " + jLongValue);
        }
        return new com.byazt.ujk.qg(jN, jQg, com.byazt.iw.n.s(byteBuffer), jLongValue, byteBuffer);
    }

    public static n n(com.byazt.iip.qg qgVar, com.byazt.ujk.qg qgVar2) throws Exception {
        long jN = qgVar2.n();
        long jQg = qgVar2.qg() + jN;
        long jQ = qgVar2.q();
        if (jQg != jQ) {
            throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: " + jQg + ", EoCD start: " + jQ);
        }
        if (jN < 32) {
            throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(jN)));
        }
        ByteBuffer byteBufferN = qgVar.n(jN - 24, 24);
        byteBufferN.order(ByteOrder.LITTLE_ENDIAN);
        if (byteBufferN.getLong(8) != 2334950737559900225L || byteBufferN.getLong(16) != 3617552046287187010L) {
            throw new Exception("No APK Signing Block before ZIP Central Directory");
        }
        long j = byteBufferN.getLong(0);
        if (j < byteBufferN.capacity() || j > 2147483639) {
            throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j)));
        }
        long j2 = (int) (8 + j);
        long j3 = jN - j2;
        if (j3 < 0) {
            throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        ByteBuffer byteBufferN2 = qgVar.n(j3, 8);
        byteBufferN2.order(ByteOrder.LITTLE_ENDIAN);
        long j4 = byteBufferN2.getLong(0);
        if (j4 != j) {
            throw new Exception("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j);
        }
        return new n(j3, qgVar.n(j3, j2));
    }

    @com.byazt.cp.n(n = {0, 1, 1307, 48})
    public static class n {
        public final long n;
        public final com.byazt.iip.qg qg;

        public n(long j, com.byazt.iip.qg qgVar) {
            this.n = j;
            this.qg = qgVar;
        }

        public long n() {
            return this.n;
        }

        public com.byazt.iip.qg qg() {
            return this.qg;
        }
    }
}
