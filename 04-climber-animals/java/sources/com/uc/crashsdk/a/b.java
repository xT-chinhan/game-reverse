package com.uc.crashsdk.a;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final int[] a = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_TOAST, 147, 115, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 101, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 134};
    private static final int[] b = {125, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 233, 226, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA, 142, 151, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD};
    private static final int[] c = {238, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 233, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA, 142, 151, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION};

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

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        r1 = com.uc.crashsdk.a.g.e(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7, java.lang.String r8, boolean r9) {
        /*
            if (r9 != 0) goto L3
            return r7
        L3:
            boolean r0 = com.uc.crashsdk.a.g.a(r7)
            if (r0 == 0) goto La
            return r7
        La:
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r1 = r0.exists()
            if (r1 == 0) goto Lc7
            long r1 = r0.length()
            r3 = 3145728(0x300000, double:1.554196E-317)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L22
            goto Lc7
        L22:
            byte[] r1 = com.uc.crashsdk.a.g.e(r0)
            if (r1 == 0) goto Lc7
            int r2 = r1.length
            if (r2 > 0) goto L2d
            goto Lc7
        L2d:
            r2 = 1
            r3 = 0
            if (r9 == 0) goto L8a
            r9 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L50
            r4.<init>()     // Catch: java.lang.Throwable -> L50
            java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L4b
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L4b
            r5.write(r1)     // Catch: java.lang.Throwable -> L49
            r4.flush()     // Catch: java.lang.Throwable -> L49
            com.uc.crashsdk.a.g.a(r4)
        L45:
            com.uc.crashsdk.a.g.a(r5)
            goto L5b
        L49:
            r9 = move-exception
            goto L54
        L4b:
            r5 = move-exception
            r6 = r5
            r5 = r9
            r9 = r6
            goto L54
        L50:
            r4 = move-exception
            r5 = r9
            r9 = r4
            r4 = r5
        L54:
            com.uc.crashsdk.a.g.a(r9)     // Catch: java.lang.Throwable -> L82
            com.uc.crashsdk.a.g.a(r4)
            goto L45
        L5b:
            byte[] r1 = r4.toByteArray()     // Catch: java.lang.Throwable -> L61
            r9 = r2
            goto L66
        L61:
            r9 = move-exception
            com.uc.crashsdk.a.g.a(r9)
            r9 = r3
        L66:
            if (r9 == 0) goto L81
            if (r1 == 0) goto L81
            int r9 = r1.length
            if (r9 > 0) goto L6e
            goto L81
        L6e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r9 = r9.append(r7)
            java.lang.StringBuilder r8 = r9.append(r8)
            java.lang.String r8 = r8.toString()
            r9 = r2
            goto L8c
        L81:
            return r7
        L82:
            r7 = move-exception
            com.uc.crashsdk.a.g.a(r4)
            com.uc.crashsdk.a.g.a(r5)
            throw r7
        L8a:
            r8 = r7
            r9 = r3
        L8c:
            if (r9 == 0) goto Lc7
            java.lang.String r9 = r0.getName()
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto Lad
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r9 = r9.append(r8)
            java.lang.String r4 = ".tmp"
            java.lang.StringBuilder r9 = r9.append(r4)
            java.lang.String r9 = r9.toString()
            r4 = r2
            goto Laf
        Lad:
            r9 = r8
            r4 = r3
        Laf:
            java.io.File r5 = new java.io.File
            r5.<init>(r9)
            boolean r9 = com.uc.crashsdk.a.g.a(r5, r1)
            if (r9 != 0) goto Lbc
            r2 = r3
            goto Lc4
        Lbc:
            if (r4 == 0) goto Lc4
            r0.delete()
            r5.renameTo(r0)
        Lc4:
            if (r2 == 0) goto Lc7
            return r8
        Lc7:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr.length - 0 >= 2 && iArr != null && iArr.length == 8) {
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
            }
        }
        return null;
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (bArr != null && iArr != null && iArr.length == 8) {
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
            }
        }
        return null;
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
        if (fileOutputStream == null) {
            return false;
        }
        byte[] bArrB = b(str2.getBytes(), a);
        if (bArrB == null) {
            g.a(fileOutputStream);
            return false;
        }
        try {
            fileOutputStream.write(bArrB);
            g.a(fileOutputStream);
            return true;
        } catch (Throwable th2) {
            try {
                g.a(th2);
                return false;
            } finally {
                g.a(fileOutputStream);
            }
        }
    }
}
