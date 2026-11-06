package com.uc.crashsdk.a;

import com.byazt.fi.BaseConstants;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.update.download.core.Util;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    static final /* synthetic */ boolean a = true;
    private static String b = "";

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, false);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        return a(bArr, bArr2, z, true);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, true);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, boolean z, boolean z2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(z ? 1 : 2, secretKeySpec, ivParameterSpec);
        if (z) {
            if (!z2) {
                bArr = a(bArr);
            }
            return cipher.doFinal(bArr);
        }
        return cipher.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 16];
        int length = bArr.length;
        bArr2[0] = (byte) ((length >> 0) & 255);
        bArr2[1] = (byte) ((length >> 8) & 255);
        bArr2[2] = (byte) ((length >> 16) & 255);
        bArr2[3] = (byte) ((length >> 24) & 255);
        for (int i = 4; i < 16; i++) {
            bArr2[i] = 0;
        }
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        return bArr2;
    }

    public static byte[] a() {
        return new byte[]{48, 25, 6, 55};
    }

    /* JADX WARN: Code duplicated, block: B:68:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static byte[] a(String str, byte[] bArr) throws Throwable {
        Throwable th;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        ?? r4;
        InputStream inputStream2;
        ?? outputStream;
        ?? byteArrayOutputStream;
        ?? r5;
        ?? r0 = 0;
        r0 = 0;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod(TapHttp.METHOD_POST);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty(Util.CONTENT_LENGTH, String.valueOf(bArr.length));
                outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(bArr);
                    if (httpURLConnection.getResponseCode() != 200) {
                        g.a((Closeable) outputStream);
                        g.a((Closeable) null);
                        g.a((Closeable) null);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th2) {
                            }
                        }
                        return null;
                    }
                    inputStream2 = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream(inputStream2.available());
                        while (true) {
                            try {
                                int i = inputStream2.read(bArr2);
                                if (i == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, i);
                            } catch (Throwable th3) {
                                g.a((Closeable) outputStream);
                                g.a(inputStream2);
                                g.a((Closeable) byteArrayOutputStream);
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Throwable th4) {
                                    }
                                }
                                return null;
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        g.a((Closeable) outputStream);
                        g.a(inputStream2);
                        g.a((Closeable) byteArrayOutputStream);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th5) {
                            }
                        }
                        return byteArray;
                    } catch (Throwable th6) {
                        r4 = 0;
                        r0 = outputStream;
                        httpURLConnection = httpURLConnection;
                        inputStream = inputStream2;
                        th = th6;
                    }
                } catch (Throwable th7) {
                    inputStream2 = null;
                    byteArrayOutputStream = 0;
                }
                r0 = outputStream;
                r4 = r5;
            } catch (Throwable th8) {
                inputStream2 = null;
                outputStream = inputStream2;
                byteArrayOutputStream = outputStream;
                g.a((Closeable) outputStream);
                g.a(inputStream2);
                g.a((Closeable) byteArrayOutputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
        } catch (Throwable th9) {
            th = th9;
            inputStream = null;
            httpURLConnection = null;
            r4 = 0;
        }
        g.a((Closeable) r0);
        g.a(inputStream);
        g.a((Closeable) r4);
        if (httpURLConnection == null) {
            throw th;
        }
        try {
            httpURLConnection.disconnect();
            throw th;
        } catch (Throwable th10) {
            throw th;
        }
    }

    public static void a(byte[] bArr, int i, byte[] bArr2) {
        if (!a && bArr2.length != 4) {
            throw new AssertionError();
        }
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2 + i] = bArr2[i2];
        }
    }

    private static byte[] a(File file) throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArr;
        BufferedInputStream bufferedInputStream = null;
        if (!file.isFile()) {
            return null;
        }
        try {
            int length = (int) file.length();
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                    try {
                        try {
                            bArr = new byte[length];
                            int i = 0;
                            while (i < length) {
                                try {
                                    int i2 = bufferedInputStream2.read(bArr, i, length - i);
                                    if (-1 == i2) {
                                        break;
                                    }
                                    i += i2;
                                } catch (Exception e) {
                                    e = e;
                                    bufferedInputStream = bufferedInputStream2;
                                    g.b(e);
                                    g.a(bufferedInputStream);
                                }
                            }
                            g.a(bufferedInputStream2);
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            g.a(bufferedInputStream);
                            g.a(fileInputStream);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bArr = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    bArr = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            bArr = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        g.a(fileInputStream);
        return bArr;
    }

    public static boolean a(File file, String str, String str2) {
        for (int i = 0; i < 2; i++) {
            if (b(file, str, str2)) {
                return true;
            }
            a.a("crashsdk", "upload try again: " + str);
        }
        return false;
    }

    private static boolean b(File file, String str, String str2) throws Throwable {
        try {
            byte[] bArrA = a(file);
            if (bArrA != null && bArrA.length != 0) {
                return a(bArrA, str, str2);
            }
            return false;
        } catch (Exception e) {
            g.a(e);
            return false;
        }
    }

    private static boolean a(byte[] bArr, String str, String str2) throws Throwable {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2;
        a.a("Uploading to " + str2);
        OutputStream outputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(BaseConstants.Time.MINUTE);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod(TapHttp.METHOD_POST);
                httpURLConnection.setUseCaches(false);
                StringBuilder sb = new StringBuilder();
                sb.append("------------izQ290kHh6g3Yn2IeyJCoc\r\n");
                sb.append("Content-Disposition: form-data; name=\"file\";");
                sb.append(" filename=\"");
                sb.append(str);
                sb.append("\"\r\n");
                sb.append("Content-Type: application/octet-stream\r\n");
                sb.append("\r\n");
                int length = sb.length() + "\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n".length() + bArr.length;
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----------izQ290kHh6g3Yn2IeyJCoc");
                httpURLConnection.setRequestProperty(Util.CONTENT_DISPOSITION, "form-data; name=\"file\"; filename=" + str);
                httpURLConnection.setRequestProperty(Util.CONTENT_LENGTH, String.valueOf(length));
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(sb.toString().getBytes());
                    outputStream2.write(bArr);
                    outputStream2.write("\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n".getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    a.a("crashsdk", "Response code: " + responseCode);
                    if (responseCode != 200) {
                        g.a(outputStream2);
                        g.a((Closeable) null);
                        g.a((Closeable) null);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th) {
                            }
                        }
                        return false;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                        while (true) {
                            try {
                                int i = inputStream.read(bArr2);
                                if (i == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, i);
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (byteArray == null) {
                            g.a(outputStream2);
                            g.a(inputStream);
                            g.a(byteArrayOutputStream);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable th3) {
                                }
                            }
                            return false;
                        }
                        a.a("crashsdk", "Log upload response: " + new String(byteArray));
                        g.a(outputStream2);
                        g.a(inputStream);
                        g.a(byteArrayOutputStream);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th4) {
                            }
                        }
                        return true;
                    } catch (Throwable th5) {
                        byteArrayOutputStream = null;
                        outputStream = outputStream2;
                        inputStream2 = inputStream;
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayOutputStream = null;
                    outputStream = outputStream2;
                    inputStream2 = null;
                }
                outputStream = outputStream2;
            } catch (Throwable th7) {
                th = th7;
                inputStream2 = null;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            httpURLConnection = null;
            byteArrayOutputStream = null;
        }
        g.a(outputStream);
        g.a(inputStream);
        g.a(byteArrayOutputStream);
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th9) {
            }
        }
        throw th;
    }
}
