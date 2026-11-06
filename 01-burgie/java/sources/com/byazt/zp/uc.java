package com.byazt.zp;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.vzx.pr(pr = {0, 1, 1229, 5})
public class uc {
    public static final ConcurrentHashMap<String, Boolean> hn;
    public static final Map<String, Long> hw;
    public static final Map<String, Long> pr;

    @com.byazt.vzx.pr(pr = {0, 1, 1229, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED})
    static class hw {
        public long c;
        public int fw;
        public long hn;
        public boolean hw;
        public boolean pr;
        public int uc;
        public long x;
    }

    static {
        HashMap map = new HashMap();
        pr = map;
        HashMap map2 = new HashMap();
        hw = map2;
        hn = new ConcurrentHashMap<>();
        map.put("pangleflipped", 2108457691L);
        map2.put("pangleflipped", 1987010392L);
        map2.put("panglearmor", 2158905815L);
        map2.put("tt_ugen_layout", 4099492101L);
        map2.put("avmdl_lite", 2580523452L);
        map2.put("Pglbizssdk_ml", 3668187545L);
        map2.put("ttmplayer_lite", 2952398659L);
        map2.put("tobEmbedEncrypt", 3297452236L);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1229, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_VIDEO_WINDOW_SIZE})
    public static class hn extends UnsatisfiedLinkError {
        public hn(String str) {
            super(str);
        }
    }

    public static boolean pr(String str) {
        Boolean bool = Boolean.TRUE;
        ConcurrentHashMap<String, Boolean> concurrentHashMap = hn;
        if (bool.equals(concurrentHashMap.get(str))) {
            return true;
        }
        Map<String, Long> map = hw;
        if (map.get(str) == null) {
            return true;
        }
        try {
            File fileHw = hw(str);
            if (fileHw != null && fileHw.exists()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                hw hwVarHw = pr.hw(fileHw);
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                long jLongValue = (hwVarHw.hw ? map.get(str) : pr.get(str)).longValue();
                if (hwVarHw.c == jLongValue && hwVarHw.c != 0) {
                    concurrentHashMap.put(str, Boolean.TRUE);
                    pr(str, jCurrentTimeMillis2, hwVarHw, jLongValue, 1);
                    return true;
                }
                if (hwVarHw.c == 0) {
                    pr(str, jCurrentTimeMillis2, hwVarHw, jLongValue, -2);
                    return true;
                }
                pr(str, jCurrentTimeMillis2, hwVarHw, jLongValue, -1);
                return false;
            }
            return true;
        } catch (Throwable th) {
            return true;
        }
    }

    private static File hw(String str) {
        try {
            String strFindLibrary = ((BaseDexClassLoader) fw.class.getClassLoader()).findLibrary(str);
            if (!TextUtils.isEmpty(strFindLibrary)) {
                return new File(strFindLibrary);
            }
            String str2 = a.getContext().getApplicationInfo().nativeLibraryDir;
            if (!TextUtils.isEmpty(str2)) {
                File file = new File(str2, "lib" + str + ".so");
                if (file.exists()) {
                    return file;
                }
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private static void pr(String str, long j, hw hwVar, long j2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("lib", str);
            jSONObject.put("isV8", hwVar.hw ? 1 : 0);
            jSONObject.put("phdrCrc", hwVar.hn);
            jSONObject.put("textCrc", hwVar.x);
            jSONObject.put("finalCrc", hwVar.c);
            jSONObject.put("expected", j2);
            jSONObject.put("loadCount", hwVar.uc);
            jSONObject.put("execCount", hwVar.fw);
            jSONObject.put("checkResult", i);
            jSONObject.put("cost", j);
        } catch (JSONException e) {
        }
        com.byazt.xk.hw.pr().hn("so_security_check", jSONObject);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1229, 129})
    private static class pr {
        /* JADX INFO: Access modifiers changed from: private */
        public static hw hw(File file) throws IOException {
            int iHn;
            int iHn2;
            int iHn3;
            int iHn4;
            int iHn5;
            long jPr;
            long jPr2;
            long jHw;
            long j;
            long j2;
            int i;
            int i2;
            hw hwVar = new hw();
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
                int iHn6 = hn(randomAccessFile, byteOrder);
                hwVar.pr = iHn6 == 40;
                hwVar.hw = iHn6 == 183;
                if (z) {
                    randomAccessFile.seek(32L);
                    jPr = pr(randomAccessFile, byteOrder);
                    randomAccessFile.seek(40L);
                    jPr2 = pr(randomAccessFile, byteOrder);
                    randomAccessFile.seek(54L);
                    iHn = hn(randomAccessFile, byteOrder);
                    iHn2 = hn(randomAccessFile, byteOrder);
                    iHn3 = hn(randomAccessFile, byteOrder);
                    iHn4 = hn(randomAccessFile, byteOrder);
                    iHn5 = hn(randomAccessFile, byteOrder);
                } else {
                    randomAccessFile.seek(28L);
                    long jHw2 = hw(randomAccessFile, byteOrder);
                    randomAccessFile.seek(32L);
                    long jHw3 = hw(randomAccessFile, byteOrder);
                    randomAccessFile.seek(42L);
                    iHn = hn(randomAccessFile, byteOrder);
                    iHn2 = hn(randomAccessFile, byteOrder);
                    iHn3 = hn(randomAccessFile, byteOrder);
                    iHn4 = hn(randomAccessFile, byteOrder);
                    iHn5 = hn(randomAccessFile, byteOrder);
                    jPr = jHw2;
                    jPr2 = jHw3;
                }
                CRC32 crc32 = new CRC32();
                byte[] bArr2 = new byte[iHn];
                int i3 = 0;
                while (i3 < iHn2) {
                    long j3 = jPr2;
                    int i4 = iHn2;
                    int i5 = iHn3;
                    randomAccessFile.seek((((long) i3) * ((long) iHn)) + jPr);
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
                        hwVar.uc++;
                        if ((i2 & 1) != 0) {
                            hwVar.fw++;
                        }
                        pr(crc32, i);
                        pr(crc32, i2);
                    }
                    i3++;
                    jPr2 = j3;
                    iHn2 = i4;
                    iHn3 = i5;
                }
                long j4 = jPr2;
                int i6 = iHn3;
                hwVar.hn = crc32.getValue();
                long j5 = i6;
                randomAccessFile.seek(j4 + (((long) iHn5) * j5));
                if (z) {
                    randomAccessFile.skipBytes(24);
                    jHw = pr(randomAccessFile, byteOrder);
                } else {
                    randomAccessFile.skipBytes(16);
                    jHw = hw(randomAccessFile, byteOrder);
                }
                byte[] bArr3 = new byte[i6];
                int i7 = 0;
                while (true) {
                    j = -1;
                    if (i7 >= iHn4) {
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
                    j2 = z ? byteBufferOrder2.getLong() : ((long) byteBufferOrder2.getInt()) & 4294967295L;
                    if (!".text".equals(pr(randomAccessFile, ((long) i8) + jHw))) {
                        i7++;
                        byteOrder = byteOrder;
                        bArr3 = bArr3;
                    } else {
                        j = j6;
                        break;
                    }
                }
                if (j < 0) {
                    throw new IOException(".text not found");
                }
                hwVar.x = pr(randomAccessFile, j, j2);
                hwVar.c = pr(hwVar.hn, hwVar.x);
                randomAccessFile.close();
                return hwVar;
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

        private static long pr(long j, long j2) {
            CRC32 crc32 = new CRC32();
            pr(crc32, (int) j);
            pr(crc32, (int) j2);
            return crc32.getValue();
        }

        private static long pr(RandomAccessFile randomAccessFile, long j, long j2) throws IOException {
            int i;
            randomAccessFile.seek(j);
            CRC32 crc32 = new CRC32();
            byte[] bArr = new byte[8192];
            while (j2 > 0 && (i = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_URI, j2))) > 0) {
                crc32.update(bArr, 0, i);
                j2 -= (long) i;
            }
            return crc32.getValue();
        }

        private static void pr(CRC32 crc32, int i) {
            crc32.update((i >>> 24) & 255);
            crc32.update((i >>> 16) & 255);
            crc32.update((i >>> 8) & 255);
            crc32.update(i & 255);
        }

        private static String pr(RandomAccessFile randomAccessFile, long j) throws IOException {
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

        private static long pr(RandomAccessFile randomAccessFile, ByteOrder byteOrder) throws IOException {
            byte[] bArr = new byte[8];
            randomAccessFile.readFully(bArr);
            return ByteBuffer.wrap(bArr).order(byteOrder).getLong();
        }

        private static long hw(RandomAccessFile randomAccessFile, ByteOrder byteOrder) throws IOException {
            byte[] bArr = new byte[4];
            randomAccessFile.readFully(bArr);
            return ((long) ByteBuffer.wrap(bArr).order(byteOrder).getInt()) & 4294967295L;
        }

        private static int hn(RandomAccessFile randomAccessFile, ByteOrder byteOrder) throws IOException {
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            return ByteBuffer.wrap(bArr).order(byteOrder).getShort() & UShort.MAX_VALUE;
        }
    }
}
