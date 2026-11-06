package com.bytedance.pangle.util;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ab {
    static int ah = 8192;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static String f697ms;
    static String xr;

    public static void ms(String str) {
        ms(new File(str));
    }

    public static void ms(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                ms(file2);
            }
        }
        file.delete();
    }

    public static void ms(InputStream inputStream, OutputStream outputStream) throws IOException {
        ms(inputStream, outputStream, 0L, 1048576);
    }

    private static void ms(InputStream inputStream, OutputStream outputStream, long j, int i) throws IOException {
        if (inputStream == null || outputStream == null) {
            return;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        try {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (true) {
                int i3 = bufferedInputStream.read(bArr);
                if (i3 == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, i3);
                i2 += i3;
            }
            bufferedOutputStream.flush();
            if (j > 0 && i2 != j) {
                throw new IOException("copy is not completed");
            }
        } finally {
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }
    }

    public static void ms(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void ms(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String ms(Context context) {
        File parentFile;
        if (f697ms == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            f697ms = parentFile.getAbsolutePath();
        }
        return f697ms;
    }

    public static String xr(Context context) {
        File parentFile;
        if (xr == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            try {
                xr = parentFile.getCanonicalPath();
            } catch (IOException e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
        return xr;
    }

    public static void ms(String str, String str2) throws Exception {
        File file = new File(str);
        File file2 = new File(str2);
        if (!file.exists()) {
            throw new Exception("文件夹不存在");
        }
        if (!file.isDirectory()) {
            throw new Exception("源文件夹不是目录");
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (!file2.isDirectory()) {
            throw new Exception("目标文件夹不是目录");
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file3 : fileArrListFiles) {
            String str3 = file2 + File.separator + file3.getName();
            if (file3.isDirectory()) {
                ms(file3.getAbsolutePath(), str3);
            } else if (!new File(str3).exists()) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file3));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                byte[] bArr = new byte[ah];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, i);
                    }
                }
                bufferedOutputStream.close();
                bufferedInputStream.close();
            }
        }
    }

    public static void ms(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j, long j2, String str) throws IOException {
        byte[] bArr;
        long j3 = 0;
        if (j < 0 || j2 < 0 || j > j2) {
            throw new IOException("invalid offsets  ".concat(String.valueOf(str)));
        }
        if (j == j2) {
            return;
        }
        randomAccessFile.seek(j);
        long j4 = j2 - j;
        int i = ah;
        if (j4 < i) {
            bArr = new byte[(int) j4];
        } else {
            bArr = new byte[i];
        }
        while (true) {
            int i2 = randomAccessFile.read(bArr);
            if (i2 == -1) {
                return;
            }
            randomAccessFile2.write(bArr, 0, i2);
            j3 += (long) i2;
            if (j3 == j4) {
                return;
            }
            if (((long) bArr.length) + j3 > j4) {
                bArr = new byte[(int) (j4 - j3)];
            }
        }
    }

    public static void xr(String str, String str2) throws Exception {
        ZipInputStream zipInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.contains("..")) {
                            if (nextEntry.isDirectory()) {
                                new File(str2 + File.separator + name).mkdirs();
                            } else {
                                File file = new File(str2 + File.separator + name);
                                if (file.exists()) {
                                    file.delete();
                                } else {
                                    file.getParentFile().mkdirs();
                                }
                                file.createNewFile();
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                                try {
                                    byte[] bArr = new byte[2048];
                                    while (true) {
                                        int i = zipInputStream.read(bArr);
                                        if (i == -1) {
                                            break;
                                        } else {
                                            bufferedOutputStream2.write(bArr, 0, i);
                                        }
                                    }
                                    bufferedOutputStream2.flush();
                                    bufferedOutputStream2.close();
                                    bufferedOutputStream = bufferedOutputStream2;
                                } catch (Exception e) {
                                    e = e;
                                    bufferedOutputStream = bufferedOutputStream2;
                                }
                            }
                        }
                    } else {
                        zipInputStream.close();
                        return;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                ms(bufferedOutputStream);
                ms(zipInputStream);
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            zipInputStream = null;
        }
    }

    public static boolean xr(File file) {
        FileInputStream fileInputStream = null;
        if (file != null) {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[6];
                    if (fileInputStream2.read(bArr) != 6) {
                        ms(fileInputStream2);
                        return false;
                    }
                    byte[] bArr2 = {80, 75, 3, 4};
                    for (int i = 0; i < 4; i++) {
                        if (bArr2[i] != bArr[i]) {
                            ms(fileInputStream2);
                            return false;
                        }
                    }
                    byte b = bArr[4];
                    if (b == 0 && bArr[5] == 0) {
                        ms(fileInputStream2);
                        return false;
                    }
                    if (b == 20 && bArr[5] == 3) {
                        ms(fileInputStream2);
                        return true;
                    }
                    ms(fileInputStream2);
                    return false;
                } catch (Throwable unused) {
                    fileInputStream = fileInputStream2;
                    ms(fileInputStream);
                    return false;
                }
            } catch (Throwable unused2) {
            }
        } else {
            ms((Closeable) null);
            return false;
        }
    }
}
