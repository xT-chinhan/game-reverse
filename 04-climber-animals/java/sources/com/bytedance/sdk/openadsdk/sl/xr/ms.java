package com.bytedance.sdk.openadsdk.sl.xr;

import com.bytedance.sdk.component.utils.sl;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.ek;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final byte[] f4107ms = {71, 73, 70, 56, 55, 97};
    private static final byte[] xr = {71, 73, 70, 56, 57, 97};
    private static final byte[] ah = {-1, -40, -1};
    private static final byte[] d = {-119, 80, 78, 71, ek.k, 10, 26, 10};

    public static byte[] ms(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            return ms(new FileInputStream(file));
        } catch (Exception e) {
            sl.ms(e);
            return null;
        }
    }

    public static boolean ms(InputStream inputStream, String str, String str2, long j) throws Throwable {
        File file;
        File file2;
        if (inputStream == null) {
            return false;
        }
        long j2 = j != -2147483648L ? j * BaseConstants.MB_VALUE : 1099511627776L;
        FileOutputStream fileOutputStream = null;
        long j3 = 0;
        try {
            File file3 = new File(str);
            if (!file3.exists() && !file3.mkdirs()) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        sl.ms(e);
                    }
                }
                return false;
            }
            file2 = new File(file3, str2);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                        j3 += (long) i;
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    inputStream.close();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            sl.ms(e2);
                            return true;
                        }
                    }
                    if (j == -2147483648L || j3 <= j2) {
                        return true;
                    }
                    file2.delete();
                    return false;
                } catch (Exception unused) {
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th) {
                    file = file2;
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            sl.ms(e3);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                            sl.ms(e4);
                            throw th;
                        }
                    }
                    if (j == -2147483648L || j3 <= j2 || file == null) {
                        throw th;
                    }
                    file.delete();
                    return false;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                file = file2;
                th = th2;
            }
        } catch (Exception unused3) {
            file2 = null;
        } catch (Throwable th3) {
            th = th3;
            file = null;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e5) {
                sl.ms(e5);
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
                if (j != -2147483648L && j3 > j2 && file2 != null) {
                    file2.delete();
                    return false;
                }
            } catch (Exception e6) {
                sl.ms(e6);
            }
        } else if (j != -2147483648L) {
            file2.delete();
            return false;
        }
        return false;
    }

    public static void xr(String str) throws Exception {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            int length = fileArrListFiles.length;
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    xr(fileArrListFiles[i].getAbsolutePath());
                } else {
                    fileArrListFiles[i].delete();
                }
            }
            file.delete();
        }
    }

    public static byte[] ms(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ms(bufferedInputStream, byteArrayOutputStream, 2048);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            sl.ms(e);
            return new byte[0];
        } finally {
            try {
                bufferedInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    private static long ms(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = inputStream.read(bArr);
        long j = 0;
        while (i2 >= 0) {
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
            i2 = inputStream.read(bArr);
        }
        return j;
    }
}
