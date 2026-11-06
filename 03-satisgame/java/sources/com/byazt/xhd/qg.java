package com.byazt.xhd;

import android.text.TextUtils;
import com.anythink.china.a.c;
import com.byazt.nf.rv;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.CRC32;
import kotlin.UShort;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 504, 26})
public class qg {
    public static final Map<String, Long> n;
    public static final Map<String, Long> qg;
    public static final ConcurrentHashMap<String, Boolean> s;

    /* JADX INFO: renamed from: com.byazt.xhd.qg$qg, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 504, 201})
    static class C0393qg {
        public long l;
        public boolean n;
        public long q;
        public boolean qg;
        public long s;
        public int w;
        public int x;
    }

    static {
        HashMap map = new HashMap();
        n = map;
        HashMap map2 = new HashMap();
        qg = map2;
        s = new ConcurrentHashMap<>();
        map.put("pangleflipped", 2108457691L);
        map2.put("pangleflipped", 1987010392L);
        map2.put("panglearmor", 3303383187L);
        map2.put("tt_ugen_layout", 4099492101L);
        map2.put("avmdl_lite", 2580523452L);
        map2.put("Pglbizssdk_ml", 3668187545L);
        map2.put("tobEmbedEncrypt", 3297452236L);
        map2.put("ttmplayer_lite", 2952398659L);
    }

    @com.byazt.cp.n(n = {0, 1, 504, 47})
    public static class s extends UnsatisfiedLinkError {
        public s(String str) {
            super(str);
        }
    }

    public static boolean n(String str) {
        Boolean bool = Boolean.TRUE;
        ConcurrentHashMap<String, Boolean> concurrentHashMap = s;
        if (bool.equals(concurrentHashMap.get(str))) {
            return true;
        }
        Map<String, Long> map = qg;
        if (map.get(str) == null) {
            return true;
        }
        try {
            File fileQg = qg(str);
            if (fileQg != null && fileQg.exists()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                C0393qg c0393qgQg = n.qg(fileQg);
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (!c0393qgQg.qg) {
                    map = n;
                }
                long jLongValue = map.get(str).longValue();
                if (c0393qgQg.l == jLongValue && c0393qgQg.l != 0) {
                    concurrentHashMap.put(str, Boolean.TRUE);
                    n(str, jCurrentTimeMillis2, c0393qgQg, jLongValue, 1);
                    return true;
                }
                if (c0393qgQg.l == 0) {
                    n(str, jCurrentTimeMillis2, c0393qgQg, jLongValue, -2);
                    return true;
                }
                n(str, jCurrentTimeMillis2, c0393qgQg, jLongValue, -1);
                return false;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    private static File qg(String str) {
        try {
            String strFindLibrary = ((BaseDexClassLoader) com.byazt.xhd.s.class.getClassLoader()).findLibrary(str);
            if (!TextUtils.isEmpty(strFindLibrary)) {
                return new File(strFindLibrary);
            }
            String str2 = rv.getContext().getApplicationInfo().nativeLibraryDir;
            if (!TextUtils.isEmpty(str2)) {
                File file = new File(str2, "lib" + str + ".so");
                if (file.exists()) {
                    return file;
                }
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    private static void n(String str, long j, C0393qg c0393qg, long j2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("lib", str);
            jSONObject.put("isV8", c0393qg.qg ? 1 : 0);
            jSONObject.put("phdrCrc", c0393qg.s);
            jSONObject.put("textCrc", c0393qg.q);
            jSONObject.put("finalCrc", c0393qg.l);
            jSONObject.put("expected", j2);
            jSONObject.put("loadCount", c0393qg.w);
            jSONObject.put("execCount", c0393qg.x);
            jSONObject.put("checkResult", i);
            jSONObject.put("cost", j);
        } catch (JSONException unused) {
        }
        com.byazt.eji.s.n().s("so_security_check", jSONObject);
    }

    @com.byazt.cp.n(n = {0, 1, 504, 48})
    private static class n {
        /* JADX INFO: Access modifiers changed from: private */
        public static C0393qg qg(File file) throws IOException {
            int iS;
            int iS2;
            int iS3;
            int iS4;
            int iS5;
            long jN;
            long jN2;
            long jQg;
            long j;
            long j2;
            int i;
            int i2;
            C0393qg c0393qg = new C0393qg();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] bArr = new byte[16];
                randomAccessFile.readFully(bArr);
                if (bArr[0] != 127 || bArr[1] != 69 || bArr[2] != 76 || bArr[3] != 70) {
                    throw new IOException("Not ELF");
                }
                boolean z = bArr[4] == 2;
                ByteOrder byteOrder = bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
                randomAccessFile.seek(18L);
                int iS6 = s(randomAccessFile, byteOrder);
                c0393qg.n = iS6 == 40;
                c0393qg.qg = iS6 == 183;
                if (z) {
                    randomAccessFile.seek(32L);
                    jN = n(randomAccessFile, byteOrder);
                    randomAccessFile.seek(40L);
                    jN2 = n(randomAccessFile, byteOrder);
                    randomAccessFile.seek(54L);
                    iS = s(randomAccessFile, byteOrder);
                    iS2 = s(randomAccessFile, byteOrder);
                    iS3 = s(randomAccessFile, byteOrder);
                    iS4 = s(randomAccessFile, byteOrder);
                    iS5 = s(randomAccessFile, byteOrder);
                } else {
                    randomAccessFile.seek(28L);
                    long jQg2 = qg(randomAccessFile, byteOrder);
                    randomAccessFile.seek(32L);
                    long jQg3 = qg(randomAccessFile, byteOrder);
                    randomAccessFile.seek(42L);
                    iS = s(randomAccessFile, byteOrder);
                    iS2 = s(randomAccessFile, byteOrder);
                    iS3 = s(randomAccessFile, byteOrder);
                    iS4 = s(randomAccessFile, byteOrder);
                    iS5 = s(randomAccessFile, byteOrder);
                    jN = jQg2;
                    jN2 = jQg3;
                }
                CRC32 crc32 = new CRC32();
                byte[] bArr2 = new byte[iS];
                int i3 = 0;
                while (i3 < iS2) {
                    long j3 = jN2;
                    int i4 = iS2;
                    int i5 = iS3;
                    randomAccessFile.seek((((long) i3) * ((long) iS)) + jN);
                    randomAccessFile.readFully(bArr2);
                    ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr2).order(byteOrder);
                    if (z) {
                        i = byteBufferOrder.getInt();
                        i2 = byteBufferOrder.getInt();
                    } else {
                        i = byteBufferOrder.getInt();
                        byteBufferOrder.getInt();
                        byteBufferOrder.position(byteBufferOrder.position() + 8);
                        byteBufferOrder.getInt();
                        byteBufferOrder.position(byteBufferOrder.position() + 4);
                        i2 = byteBufferOrder.getInt();
                    }
                    if (i == 1) {
                        c0393qg.w++;
                        if ((i2 & 1) != 0) {
                            c0393qg.x++;
                        }
                        n(crc32, i);
                        n(crc32, i2);
                    }
                    i3++;
                    jN2 = j3;
                    iS2 = i4;
                    iS3 = i5;
                }
                long j4 = jN2;
                int i6 = iS3;
                c0393qg.s = crc32.getValue();
                long j5 = i6;
                randomAccessFile.seek(j4 + (((long) iS5) * j5));
                if (z) {
                    randomAccessFile.skipBytes(24);
                    jQg = n(randomAccessFile, byteOrder);
                } else {
                    randomAccessFile.skipBytes(16);
                    jQg = qg(randomAccessFile, byteOrder);
                }
                byte[] bArr3 = new byte[i6];
                int i7 = 0;
                while (true) {
                    if (i7 >= iS4) {
                        j = -1;
                        j2 = -1;
                        break;
                    }
                    randomAccessFile.seek(j4 + (((long) i7) * j5));
                    randomAccessFile.readFully(bArr3);
                    ByteBuffer byteBufferOrder2 = ByteBuffer.wrap(bArr3).order(byteOrder);
                    int i8 = byteBufferOrder2.getInt();
                    byteBufferOrder2.position(byteBufferOrder2.position() + 4);
                    byteBufferOrder2.position(byteBufferOrder2.position() + (z ? 8 : 4));
                    byteBufferOrder2.position(byteBufferOrder2.position() + (z ? 8 : 4));
                    long j6 = z ? byteBufferOrder2.getLong() : ((long) byteBufferOrder2.getInt()) & 4294967295L;
                    j2 = z ? byteBufferOrder2.getLong() : 4294967295L & ((long) byteBufferOrder2.getInt());
                    if (".text".equals(n(randomAccessFile, ((long) i8) + jQg))) {
                        j = j6;
                        break;
                    }
                    i7++;
                    byteOrder = byteOrder;
                    bArr3 = bArr3;
                }
                if (j < 0) {
                    throw new IOException(".text not found");
                }
                c0393qg.q = n(randomAccessFile, j, j2);
                c0393qg.l = n(c0393qg.s, c0393qg.q);
                randomAccessFile.close();
                return c0393qg;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        randomAccessFile.close();
                        throw th2;
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                        throw th2;
                    }
                }
            }
        }

        private static long n(long j, long j2) {
            CRC32 crc32 = new CRC32();
            n(crc32, (int) j);
            n(crc32, (int) j2);
            return crc32.getValue();
        }

        private static long n(RandomAccessFile randomAccessFile, long j, long j2) throws IOException {
            int i;
            randomAccessFile.seek(j);
            CRC32 crc32 = new CRC32();
            byte[] bArr = new byte[8192];
            while (j2 > 0 && (i = randomAccessFile.read(bArr, 0, (int) Math.min(c.n, j2))) > 0) {
                crc32.update(bArr, 0, i);
                j2 -= (long) i;
            }
            return crc32.getValue();
        }

        private static void n(CRC32 crc32, int i) {
            crc32.update((i >>> 24) & 255);
            crc32.update((i >>> 16) & 255);
            crc32.update((i >>> 8) & 255);
            crc32.update(i & 255);
        }

        private static String n(RandomAccessFile randomAccessFile, long j) throws IOException {
            randomAccessFile.seek(j);
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i = randomAccessFile.read();
                if (i > 0) {
                    sb.append((char) i);
                } else {
                    return sb.toString();
                }
            }
        }

        private static long n(RandomAccessFile randomAccessFile, ByteOrder byteOrder) throws IOException {
            byte[] bArr = new byte[8];
            randomAccessFile.readFully(bArr);
            return ByteBuffer.wrap(bArr).order(byteOrder).getLong();
        }

        private static long qg(RandomAccessFile randomAccessFile, ByteOrder byteOrder) throws IOException {
            byte[] bArr = new byte[4];
            randomAccessFile.readFully(bArr);
            return ((long) ByteBuffer.wrap(bArr).order(byteOrder).getInt()) & 4294967295L;
        }

        private static int s(RandomAccessFile randomAccessFile, ByteOrder byteOrder) throws IOException {
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            return ByteBuffer.wrap(bArr).order(byteOrder).getShort() & UShort.MAX_VALUE;
        }
    }
}
