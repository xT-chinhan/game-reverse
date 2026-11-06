package com.smartdigimkt.l4;

import android.system.Os;
import android.system.OsConstants;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e0 {
    public static void b(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                b(file2);
            }
        }
        file.delete();
    }

    public static byte[] c(File file) {
        if (!file.isFile()) {
            return null;
        }
        long length = file.length();
        if ((length >> 32) != 0) {
            throw new IllegalArgumentException("file too large, path:" + file.getPath());
        }
        int i = (int) length;
        byte[] bArr = new byte[i];
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        int i2 = 0;
        while (i2 < i) {
            try {
                int i3 = randomAccessFile.read(bArr, i2, i - i2);
                if (i3 < 0) {
                    break;
                }
                i2 += i3;
            } finally {
                a(randomAccessFile);
            }
        }
        return bArr;
    }

    public static boolean d(File file) {
        if (file.isFile()) {
            return true;
        }
        File parentFile = file.getParentFile();
        return parentFile != null && (parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile();
    }

    public static int a() {
        try {
            long jSysconf = Os.sysconf(OsConstants._SC_PAGESIZE);
            if (jSysconf <= 0 || jSysconf > 2147483647L) {
                return 16384;
            }
            return (int) jSysconf;
        } catch (Throwable th) {
            Objects.toString(th.fillInStackTrace());
            return 16384;
        }
    }

    public static boolean a(File file, byte[] bArr, AtomicBoolean atomicBoolean) throws Throwable {
        File file2;
        boolean z = false;
        File file3 = null;
        try {
            try {
                int length = bArr.length;
                file2 = new File(file.getParent(), file.getName() + ".tmp");
                try {
                    if (!d(file2)) {
                        Exception exc = new Exception("create file failed");
                        com.smartdigimkt.m4.a aVar = u.a;
                        if (aVar != null) {
                            aVar.a(exc);
                        }
                        if (atomicBoolean != null && atomicBoolean.get()) {
                            a(file2);
                            a(file);
                        }
                        return false;
                    }
                    if (atomicBoolean != null && atomicBoolean.get()) {
                        if (atomicBoolean.get()) {
                            a(file2);
                            a(file);
                        }
                        return false;
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                    try {
                        randomAccessFile.setLength(length);
                        randomAccessFile.write(bArr, 0, length);
                        if (atomicBoolean != null && atomicBoolean.get()) {
                            randomAccessFile.close();
                            if (atomicBoolean.get()) {
                                a(file2);
                                a(file);
                            }
                            return false;
                        }
                        randomAccessFile.getFD().sync();
                        randomAccessFile.close();
                        if (file2.renameTo(file) || ((!file.exists() || file.delete()) && file2.renameTo(file))) {
                            z = true;
                        }
                        if (atomicBoolean != null && atomicBoolean.get()) {
                            a(file2);
                            a(file);
                        }
                        return z;
                    } catch (Throwable th) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                    e = e;
                    file3 = file2;
                    Exception exc2 = new Exception("save bytes failed", e);
                    com.smartdigimkt.m4.a aVar2 = u.a;
                    if (aVar2 != null) {
                        aVar2.a(exc2);
                    }
                    if (atomicBoolean != null && atomicBoolean.get()) {
                        a(file3);
                        a(file);
                    }
                    return false;
                } catch (Exception e) {
                    e = e;
                    file3 = file2;
                } catch (Throwable th3) {
                    th = th3;
                    if (atomicBoolean != null && atomicBoolean.get()) {
                        a(file2);
                        a(file);
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                file2 = null;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(File file) {
        try {
            if (file.exists()) {
                b(file);
            }
        } catch (Throwable unused) {
        }
    }
}
