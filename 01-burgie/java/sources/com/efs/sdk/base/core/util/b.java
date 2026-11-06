package com.efs.sdk.base.core.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final Random a = new Random();

    public static boolean a(File file, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    a(fileOutputStream2);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    Log.e("efs.util.file", "write file error, filename is " + file.getName(), th);
                    a(fileOutputStream);
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean a(File file, String str) {
        return a(file, str.getBytes());
    }

    public static String a(File file) {
        return e(file);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable, java.io.FileInputStream] */
    private static String e(File file) throws Throwable {
        ?? fileInputStream;
        String string;
        if (!file.exists()) {
            return "";
        }
        ?? r1 = 0;
        ?? r2 = 0;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        sb.append(new String(bArr, 0, i));
                    }
                    string = sb.toString();
                    a((Closeable) fileInputStream);
                    r1 = sb;
                } catch (Throwable th) {
                    th = th;
                    r2 = fileInputStream;
                    Log.e("efs.util.file", "read file error", th);
                    a((Closeable) r2);
                    string = "";
                    r1 = r2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = r1;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return string;
    }

    public static byte[] a(String str) throws Throwable {
        byte[] bArr = new byte[0];
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    try {
                        byte[] bArr2 = new byte[fileInputStream2.available()];
                        try {
                            fileInputStream2.read(bArr2);
                            a(fileInputStream2);
                            return bArr2;
                        } catch (Exception e) {
                            fileInputStream = fileInputStream2;
                            bArr = bArr2;
                            e = e;
                            Log.e("efs.util.file", "read data error", e);
                            a(fileInputStream);
                            return bArr;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static void b(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                b(file2);
            }
        }
        file.delete();
    }

    public static void a(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    try {
                        int i = fileInputStream2.read(bArr);
                        if (i == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i);
                        }
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            Log.e("efs.util.file", "error when copy", e);
                            a(fileInputStream);
                        } catch (Throwable th) {
                            th = th;
                            a(fileInputStream);
                            a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        a(fileInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                }
                a(fileInputStream2);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        a(fileOutputStream);
        b(file);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                Log.e("efs.util.file", "safe close error", th);
            }
        }
    }

    public static long c(File file) {
        long j = 0;
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return 0L;
            }
            int length = fileArrListFiles.length;
            int i = 0;
            while (i < length) {
                long jC = j + c(fileArrListFiles[i]);
                i++;
                j = jC;
            }
            return j;
        }
        return file.length() + 0;
    }

    public static List<File> d(File file) {
        if (file.isFile()) {
            return Collections.emptyList();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                arrayList.add(file2);
            } else {
                arrayList.addAll(d(file2));
            }
        }
        return arrayList;
    }

    public static String a(com.efs.sdk.base.core.d.b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.a.a);
        sb.append("_");
        sb.append(bVar.a.d);
        sb.append("_");
        sb.append(bVar.a.e);
        sb.append("_");
        sb.append((int) bVar.a.b);
        sb.append("_");
        sb.append(ProcessUtil.myPid());
        sb.append("_");
        sb.append(a.nextInt(10000));
        sb.append("_");
        com.efs.sdk.base.core.a.a.a();
        sb.append(com.efs.sdk.base.core.a.a.b());
        return sb.toString();
    }

    public static com.efs.sdk.base.core.d.b b(String str) {
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length != 7) {
            Log.w("efs.util.file", "File name error, name is ".concat(String.valueOf(str)));
            return null;
        }
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        byte bByteValue = Byte.valueOf(strArrSplit[2]).byteValue();
        com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b(str2, Byte.valueOf(strArrSplit[3]).byteValue());
        bVar.a(str3);
        bVar.a(bByteValue);
        return bVar;
    }
}
