package com.anythink.core.common.s.a;

import com.umeng.analytics.pro.ek;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class l {
    static final int a = 32;
    private static final int b = 16384;

    private static class a {
        static final SecureRandom a = new SecureRandom();
        static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        private a() {
        }
    }

    l() {
    }

    static String a() {
        byte[] bArr = new byte[16];
        a.a.nextBytes(bArr);
        char[] cArr = new char[32];
        for (int i = 0; i < 16; i++) {
            byte b2 = bArr[i];
            int i2 = i << 1;
            cArr[i2] = a.b[(b2 >> 4) & 15];
            cArr[i2 + 1] = a.b[b2 & ek.m];
        }
        return new String(cArr);
    }

    static int b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("pageSize", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(declaredField.get(null), new Object[0])).intValue();
        } catch (Throwable unused) {
            return 16384;
        }
    }

    static boolean a(File file) {
        if (file.isFile()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            return (parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile();
        }
        return false;
    }

    static byte[] b(File file) {
        if (!file.isFile()) {
            return null;
        }
        long length = file.length();
        if ((length >> 32) != 0) {
            throw new IllegalArgumentException("file too large, path:" + file.getPath());
        }
        int i = (int) length;
        byte[] bArr = new byte[i];
        a(file, bArr, i);
        return bArr;
    }

    static void a(File file, byte[] bArr, int i) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        int i2 = 0;
        while (i2 < i) {
            try {
                int i3 = randomAccessFile.read(bArr, i2, i - i2);
                if (i3 < 0) {
                    break;
                } else {
                    i2 += i3;
                }
            } finally {
                a(randomAccessFile);
            }
        }
    }

    static boolean a(File file, byte[] bArr, AtomicBoolean atomicBoolean) throws Throwable {
        File file2 = null;
        try {
            try {
                int length = bArr.length;
                File file3 = new File(file.getParent(), file.getName() + ".tmp");
                try {
                    if (!a(file3)) {
                        a(new Exception("create file failed"));
                        if (atomicBoolean != null && atomicBoolean.get()) {
                            c(file3);
                            c(file);
                        }
                        return false;
                    }
                    if (atomicBoolean != null && atomicBoolean.get()) {
                        if (atomicBoolean != null && atomicBoolean.get()) {
                            c(file3);
                            c(file);
                        }
                        return false;
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
                    try {
                        randomAccessFile.setLength(length);
                        randomAccessFile.write(bArr, 0, length);
                        if (atomicBoolean != null && atomicBoolean.get()) {
                            randomAccessFile.close();
                            if (atomicBoolean != null && atomicBoolean.get()) {
                                c(file3);
                                c(file);
                            }
                            return false;
                        }
                        randomAccessFile.getFD().sync();
                        randomAccessFile.close();
                        boolean zA = a(file3, file);
                        if (atomicBoolean != null && atomicBoolean.get()) {
                            c(file3);
                            c(file);
                        }
                        return zA;
                    } catch (Throwable th) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Exception e) {
                    e = e;
                    file2 = file3;
                    a(new Exception("save bytes failed", e));
                    if (atomicBoolean != null && atomicBoolean.get()) {
                        c(file2);
                        c(file);
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    file2 = file3;
                    if (atomicBoolean != null && atomicBoolean.get()) {
                        c(file2);
                        c(file);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    static boolean a(File file, File file2) {
        if (file.renameTo(file2)) {
            return true;
        }
        return (!file2.exists() || file2.delete()) && file.renameTo(file2);
    }

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    static void c(File file) {
        try {
            if (file.exists()) {
                d(file);
            }
        } catch (Throwable unused) {
        }
    }

    private static void d(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                d(file2);
            }
        }
        file.delete();
    }

    static void a(File file, String str) throws Throwable {
        File[] fileArrListFiles;
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            try {
                File file3 = new File(str, file2.getName());
                if (file2.exists() && !file3.exists() && !file2.renameTo(file3)) {
                    a(file3, b(file2), (AtomicBoolean) null);
                    c(file2);
                }
            } catch (Exception e) {
                a(e);
            }
        }
    }

    private static void b(File file, File file2) throws Throwable {
        if (!file.exists() || file2.exists() || file.renameTo(file2)) {
            return;
        }
        a(file2, b(file), (AtomicBoolean) null);
        c(file);
    }

    private static int a(int[] iArr, int i) {
        int length = iArr.length - 1;
        int i2 = 0;
        while (i2 <= length) {
            int i3 = (i2 + length) >>> 1;
            int i4 = iArr[i3];
            if (i4 < i) {
                i2 = i3 + 1;
            } else {
                if (i4 <= i) {
                    return i3;
                }
                length = i3 - 1;
            }
        }
        return length;
    }

    private static void a(Exception exc) {
        com.anythink.core.common.s.a.a.c cVar = h.a;
        if (cVar != null) {
            cVar.b("FastKV", exc);
        }
    }
}
