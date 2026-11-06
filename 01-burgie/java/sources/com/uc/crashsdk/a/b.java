package com.uc.crashsdk.a;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final int[] a = {126, 147, 115, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 101, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS};
    private static final int[] b = {125, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 233, 226, 129, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD};
    private static final int[] c = {238, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 233, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 129, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION};

    public static String a(String str) throws Throwable {
        FileInputStream fileInputStream;
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[(int) file.length()];
                fileInputStream3.read(bArr);
                g.a(fileInputStream3);
                byte[] bArrA = a(bArr, a);
                if (bArrA == null || bArrA.length <= 0) {
                    g.a((Closeable) null);
                    return null;
                }
                int length = bArrA.length - 1;
                String str2 = bArrA[length] == 10 ? new String(bArrA, 0, length) : new String(bArrA);
                g.a((Closeable) null);
                return str2;
            } catch (Exception e) {
                fileInputStream = fileInputStream3;
                e = e;
                try {
                    g.a(e);
                    g.a(fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    g.a(fileInputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                fileInputStream2 = fileInputStream3;
                th = th2;
                g.a(fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.Closeable] */
    public static String a(String str, String str2, boolean z) throws Throwable {
        ?? r5;
        byte[] bArrE;
        String str3;
        boolean z2;
        String str4;
        boolean z3;
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z4;
        if (!z || g.a(str)) {
            return str;
        }
        File file = new File(str);
        if (!file.exists() || file.length() > 3145728 || (bArrE = g.e(file)) == null || bArrE.length <= 0) {
            return str;
        }
        boolean z5 = true;
        if (z) {
            ?? r9 = 0;
            r9 = 0;
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream.write(bArrE);
                            byteArrayOutputStream.flush();
                            r5 = gZIPOutputStream;
                        } catch (Throwable th2) {
                            th = th2;
                            g.a(th);
                            r5 = gZIPOutputStream;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        g.a(byteArrayOutputStream);
                        g.a((Closeable) r9);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    r9 = r5;
                }
            } catch (Throwable th5) {
                gZIPOutputStream = null;
                th = th5;
                byteArrayOutputStream = null;
            }
            g.a(byteArrayOutputStream);
            g.a((Closeable) r5);
            try {
                bArrE = byteArrayOutputStream.toByteArray();
                z4 = true;
            } catch (Throwable th6) {
                g.a(th6);
                z4 = false;
            }
            if (!z4 || bArrE == null || bArrE.length <= 0) {
                return str;
            }
            str3 = str + str2;
            z2 = true;
        } else {
            str3 = str;
            z2 = false;
        }
        if (z2) {
            if (str3.equals(file.getName())) {
                str4 = str3 + ".tmp";
                z3 = true;
            } else {
                str4 = str3;
                z3 = false;
            }
            File file2 = new File(str4);
            if (!g.a(file2, bArrE)) {
                z5 = false;
            } else if (z3) {
                file.delete();
                file2.renameTo(file);
            }
            if (z5) {
                return str3;
            }
        }
        return str;
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr.length - 0 < 2 || iArr == null || iArr.length != 8) {
            return null;
        }
        int length = (bArr.length - 2) - 0;
        try {
            byte[] bArr2 = new byte[length];
            byte b2 = 0;
            for (int i = 0; i < length; i++) {
                byte b3 = (byte) (bArr[i + 0] ^ iArr[i % 8]);
                bArr2[i] = b3;
                b2 = (byte) (b2 ^ b3);
            }
            if (bArr[length + 0] == ((byte) ((iArr[0] ^ b2) & 255)) && bArr[length + 1 + 0] == ((byte) ((iArr[1] ^ b2) & 255))) {
                return bArr2;
            }
            return null;
        } catch (Exception e) {
            g.a(e);
            return null;
        }
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (bArr == null || iArr == null || iArr.length != 8) {
            return null;
        }
        int length = bArr.length;
        try {
            byte[] bArr2 = new byte[length + 2];
            byte b2 = 0;
            for (int i = 0; i < length; i++) {
                byte b3 = bArr[i];
                bArr2[i] = (byte) (iArr[i % 8] ^ b3);
                b2 = (byte) (b2 ^ b3);
            }
            bArr2[length] = (byte) (iArr[0] ^ b2);
            bArr2[length + 1] = (byte) (iArr[1] ^ b2);
            return bArr2;
        } catch (Exception e) {
            g.a(e);
            return null;
        }
    }

    public static boolean a(String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            g.a(th);
            fileOutputStream = null;
        }
        boolean z = false;
        if (fileOutputStream == null) {
            return false;
        }
        byte[] bArrB = b(str2.getBytes(), a);
        try {
            if (bArrB == null) {
                g.a(fileOutputStream);
                return false;
            }
            fileOutputStream.write(bArrB);
            z = true;
            return z;
        } catch (Throwable th2) {
            g.a(th2);
        } finally {
            g.a(fileOutputStream);
        }
    }
}
