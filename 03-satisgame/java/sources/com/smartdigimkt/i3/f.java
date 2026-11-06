package com.smartdigimkt.i3;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Closeable {
    public final File a;
    public final File b;
    public final File c;
    public final long e;
    public BufferedWriter h;
    public int j;
    public long g = 0;
    public final LinkedHashMap i = new LinkedHashMap(0, 0.75f, true);
    public long k = 0;
    public final ThreadPoolExecutor l = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final a m = new a(this);
    public final int d = 1;
    public final int f = 1;

    static {
        Charset.forName("UTF-8");
    }

    public f(File file, long j) {
        this.a = file;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.e = j;
    }

    public static void a(f fVar, c cVar, boolean z) {
        synchronized (fVar) {
            d dVar = cVar.a;
            if (dVar.d != cVar) {
                throw new IllegalStateException();
            }
            if (z && !dVar.c) {
                for (int i = 0; i < fVar.f; i++) {
                    if (!dVar.b(i).exists()) {
                        a(cVar.c, cVar, false);
                        throw new IllegalStateException("edit didn't create file " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < fVar.f; i2++) {
                File fileB = dVar.b(i2);
                if (z) {
                    if (fileB.exists()) {
                        File fileA = dVar.a(i2);
                        fileB.renameTo(fileA);
                        long j = dVar.b[i2];
                        long length = fileA.length();
                        dVar.b[i2] = length;
                        fVar.g = (fVar.g - j) + length;
                    }
                } else if (fileB.exists() && !fileB.delete()) {
                    throw new IOException();
                }
            }
            fVar.j++;
            dVar.d = null;
            if (dVar.c || z) {
                dVar.c = true;
                BufferedWriter bufferedWriter = fVar.h;
                StringBuilder sbAppend = new StringBuilder("CLEAN ").append(dVar.a);
                StringBuilder sb = new StringBuilder();
                for (long j2 : dVar.b) {
                    sb.append(' ').append(j2);
                }
                bufferedWriter.write(sbAppend.append(sb.toString()).append('\n').toString());
                if (z) {
                    fVar.k++;
                    dVar.getClass();
                }
            } else {
                fVar.i.remove(dVar.a);
                fVar.h.write("REMOVE " + dVar.a + '\n');
            }
            fVar.h.flush();
            if (fVar.g > fVar.e || fVar.a()) {
                fVar.l.submit(fVar.m);
            }
        }
    }

    public static void e(String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    public final void b() throws IOException {
        File file = this.c;
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
        Iterator it = this.i.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i = 0;
            if (dVar.d == null) {
                while (i < this.f) {
                    this.g += dVar.b[i];
                    i++;
                }
            } else {
                dVar.d = null;
                while (i < this.f) {
                    File fileA = dVar.a(i);
                    if (fileA.exists() && !fileA.delete()) {
                        throw new IOException();
                    }
                    File fileB = dVar.b(i);
                    if (fileB.exists() && !fileB.delete()) {
                        throw new IOException();
                    }
                    i++;
                }
                it.remove();
            }
        }
    }

    public final void c() {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.b), 8192);
        try {
            String strA = a(bufferedInputStream);
            String strA2 = a(bufferedInputStream);
            String strA3 = a(bufferedInputStream);
            String strA4 = a(bufferedInputStream);
            String strA5 = a(bufferedInputStream);
            if (!"libcore.io.DiskLruCache".equals(strA) || !"1".equals(strA2) || !Integer.toString(this.d).equals(strA3) || !Integer.toString(this.f).equals(strA4) || !"".equals(strA5)) {
                throw new IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + "]");
            }
            while (true) {
                try {
                    try {
                        c(a(bufferedInputStream));
                    } catch (EOFException unused) {
                        bufferedInputStream.close();
                        return;
                    }
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused2) {
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.h == null) {
            return;
        }
        Iterator it = new ArrayList(this.i.values()).iterator();
        while (it.hasNext()) {
            c cVar = ((d) it.next()).d;
            if (cVar != null) {
                a(cVar.c, cVar, false);
            }
        }
        while (this.g > this.e) {
            d((String) ((Map.Entry) this.i.entrySet().iterator().next()).getKey());
        }
        this.h.close();
        this.h = null;
    }

    public final synchronized void d() {
        BufferedWriter bufferedWriter = this.h;
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(this.c), 8192);
        bufferedWriter2.write("libcore.io.DiskLruCache");
        bufferedWriter2.write("\n");
        bufferedWriter2.write("1");
        bufferedWriter2.write("\n");
        bufferedWriter2.write(Integer.toString(this.d));
        bufferedWriter2.write("\n");
        bufferedWriter2.write(Integer.toString(this.f));
        bufferedWriter2.write("\n");
        bufferedWriter2.write("\n");
        for (d dVar : this.i.values()) {
            if (dVar.d != null) {
                bufferedWriter2.write("DIRTY " + dVar.a + '\n');
            } else {
                StringBuilder sbAppend = new StringBuilder("CLEAN ").append(dVar.a);
                StringBuilder sb = new StringBuilder();
                for (long j : dVar.b) {
                    sb.append(' ').append(j);
                }
                bufferedWriter2.write(sbAppend.append(sb.toString()).append('\n').toString());
            }
        }
        bufferedWriter2.close();
        this.c.renameTo(this.b);
        this.h = new BufferedWriter(new FileWriter(this.b, true), 8192);
    }

    public final synchronized e b(String str) {
        if (this.h != null) {
            e(str);
            d dVar = (d) this.i.get(str);
            if (dVar == null) {
                return null;
            }
            if (!dVar.c) {
                return null;
            }
            InputStream[] inputStreamArr = new InputStream[this.f];
            for (int i = 0; i < this.f; i++) {
                try {
                    inputStreamArr[i] = new FileInputStream(dVar.a(i));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
            this.j++;
            this.h.append((CharSequence) ("READ " + str + '\n'));
            if (a()) {
                this.l.submit(this.m);
            }
            this.h.flush();
            return new e(inputStreamArr);
        }
        throw new IllegalStateException("cache is closed");
    }

    public final void c(String str) throws IOException {
        String[] strArrSplit = str.split(" ");
        if (strArrSplit.length >= 2) {
            String str2 = strArrSplit[1];
            if (strArrSplit[0].equals("REMOVE") && strArrSplit.length == 2) {
                this.i.remove(str2);
                return;
            }
            d dVar = (d) this.i.get(str2);
            if (dVar == null) {
                dVar = new d(this, str2);
                this.i.put(str2, dVar);
            }
            if (strArrSplit[0].equals("CLEAN") && strArrSplit.length == this.f + 2) {
                dVar.c = true;
                dVar.d = null;
                int length = strArrSplit.length;
                int length2 = strArrSplit.length;
                if (2 > length) {
                    throw new IllegalArgumentException();
                }
                if (2 <= length2) {
                    int i = length - 2;
                    int iMin = Math.min(i, length2 - 2);
                    Object[] objArr = (Object[]) Array.newInstance(strArrSplit.getClass().getComponentType(), i);
                    System.arraycopy(strArrSplit, 2, objArr, 0, iMin);
                    String[] strArr = (String[]) objArr;
                    if (strArr.length == dVar.e.f) {
                        for (int i2 = 0; i2 < strArr.length; i2++) {
                            try {
                                dVar.b[i2] = Long.parseLong(strArr[i2]);
                            } catch (NumberFormatException unused) {
                                throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
                            }
                        }
                        return;
                    }
                    throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            if (strArrSplit[0].equals("DIRTY") && strArrSplit.length == 2) {
                dVar.d = new c(this, dVar);
                return;
            } else {
                if (!strArrSplit[0].equals("READ") || strArrSplit.length != 2) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    public final synchronized void d(String str) {
        if (this.h != null) {
            e(str);
            d dVar = (d) this.i.get(str);
            if (dVar != null && dVar.d == null) {
                for (int i = 0; i < this.f; i++) {
                    File fileA = dVar.a(i);
                    if (fileA.delete()) {
                        long j = this.g;
                        long[] jArr = dVar.b;
                        this.g = j - jArr[i];
                        jArr[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + fileA);
                    }
                }
                this.j++;
                this.h.append((CharSequence) ("REMOVE " + str + '\n'));
                this.i.remove(str);
                if (a()) {
                    this.l.submit(this.m);
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("cache is closed");
    }

    public static String a(BufferedInputStream bufferedInputStream) throws IOException {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int i = bufferedInputStream.read();
            if (i == -1) {
                throw new EOFException();
            }
            if (i == 10) {
                int length = sb.length();
                if (length > 0) {
                    int i2 = length - 1;
                    if (sb.charAt(i2) == '\r') {
                        sb.setLength(i2);
                    }
                }
                return sb.toString();
            }
            sb.append((char) i);
        }
    }

    public static void a(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IllegalArgumentException("not a directory: " + file);
    }

    public static f a(File file, long j) throws IOException {
        if (j > 0) {
            f fVar = new f(file, j);
            if (fVar.b.exists()) {
                try {
                    fVar.c();
                    fVar.b();
                    fVar.h = new BufferedWriter(new FileWriter(fVar.b, true), 8192);
                    return fVar;
                } catch (IOException unused) {
                    fVar.close();
                    a(fVar.a);
                }
            }
            file.mkdirs();
            f fVar2 = new f(file, j);
            fVar2.d();
            return fVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final c a(String str) {
        synchronized (this) {
            if (this.h != null) {
                e(str);
                d dVar = (d) this.i.get(str);
                if (dVar == null) {
                    dVar = new d(this, str);
                    this.i.put(str, dVar);
                } else if (dVar.d != null) {
                    return null;
                }
                c cVar = new c(this, dVar);
                dVar.d = cVar;
                this.h.write("DIRTY " + str + '\n');
                this.h.flush();
                return cVar;
            }
            throw new IllegalStateException("cache is closed");
        }
    }

    public final boolean a() {
        int i = this.j;
        return i >= 2000 && i >= this.i.size();
    }
}
