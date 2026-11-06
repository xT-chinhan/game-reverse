package com.mcto.sspsdk.internal;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class f5 implements Closeable {
    public static final Pattern o = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final a5 p = new a5();
    public final File a;
    public final File b;
    public final File c;
    public final File d;
    public BufferedWriter i;
    public int k;
    public long h = 0;
    public final LinkedHashMap j = new LinkedHashMap(0, 0.75f, true);
    public long l = 0;
    public final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final z4 n = new z4(this);
    public final int e = 1;
    public final int g = 1;
    public final long f = 31457280;

    public f5(File file) {
        this.a = file;
        this.b = new File(file, "ssp_journal");
        this.c = new File(file, "ssp_journal.tmp");
        this.d = new File(file, "ssp_journal.bkp");
    }

    public static void a(f5 f5Var, c5 c5Var, boolean z) {
        synchronized (f5Var) {
            d5 d5Var = c5Var.a;
            if (d5Var.d != c5Var) {
                throw new IllegalStateException();
            }
            boolean z2 = false;
            if (z && !d5Var.c) {
                for (int i = 0; i < f5Var.g; i++) {
                    if (!c5Var.b[i]) {
                        a(c5Var.d, c5Var, false);
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!d5Var.b(i).exists()) {
                        a(c5Var.d, c5Var, false);
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < f5Var.g; i2++) {
                File fileB = d5Var.b(i2);
                if (z) {
                    if (fileB.exists()) {
                        File fileA = d5Var.a(i2);
                        fileB.renameTo(fileA);
                        long j = d5Var.b[i2];
                        long length = fileA.length();
                        d5Var.b[i2] = length;
                        f5Var.h = (f5Var.h - j) + length;
                    }
                } else if (fileB.exists() && !fileB.delete()) {
                    throw new IOException();
                }
            }
            f5Var.k++;
            d5Var.d = null;
            if (d5Var.c || z) {
                d5Var.c = true;
                BufferedWriter bufferedWriter = f5Var.i;
                StringBuilder sbAppend = new StringBuilder("CLEAN ").append(d5Var.a);
                StringBuilder sb = new StringBuilder();
                for (long j2 : d5Var.b) {
                    sb.append(' ').append(j2);
                }
                bufferedWriter.write(sbAppend.append(sb.toString()).append('\n').toString());
                if (z) {
                    f5Var.l++;
                }
            } else {
                f5Var.j.remove(d5Var.a);
                f5Var.i.write("REMOVE " + d5Var.a + '\n');
            }
            f5Var.i.flush();
            if (f5Var.h <= f5Var.f) {
                int i3 = f5Var.k;
                if (i3 >= 1000 && i3 >= f5Var.j.size()) {
                    z2 = true;
                }
                if (!z2) {
                    return;
                }
            }
            f5Var.m.submit(f5Var.n);
        }
    }

    public final void b() throws IOException {
        File file = this.c;
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            d5 d5Var = (d5) it.next();
            int i = 0;
            if (d5Var.d == null) {
                while (i < this.g) {
                    this.h += d5Var.b[i];
                    i++;
                }
            } else {
                d5Var.d = null;
                while (i < this.g) {
                    File fileA = d5Var.a(i);
                    if (fileA.exists() && !fileA.delete()) {
                        throw new IOException();
                    }
                    File fileB = d5Var.b(i);
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
        kj kjVar = new kj(new FileInputStream(this.b), mk.a);
        try {
            String strA = kjVar.a();
            String strA2 = kjVar.a();
            String strA3 = kjVar.a();
            String strA4 = kjVar.a();
            String strA5 = kjVar.a();
            if (!"ssp.io.DiskLruCache".equals(strA) || !"1".equals(strA2) || !Integer.toString(this.e).equals(strA3) || !Integer.toString(this.g).equals(strA4) || !"".equals(strA5)) {
                throw new IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    c(kjVar.a());
                    i++;
                } catch (EOFException e) {
                    this.k = i - this.j.size();
                    if (kjVar.e == -1) {
                        d();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), mk.a));
                    }
                    try {
                        kjVar.close();
                        return;
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                kjVar.close();
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception e5) {
            }
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.i == null) {
            return;
        }
        Iterator it = new ArrayList(this.j.values()).iterator();
        while (it.hasNext()) {
            c5 c5Var = ((d5) it.next()).d;
            if (c5Var != null) {
                a(c5Var.d, c5Var, false);
            }
        }
        e();
        this.i.close();
        this.i = null;
    }

    public final synchronized void d() {
        BufferedWriter bufferedWriter = this.i;
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), mk.a));
        try {
            bufferedWriter2.write("ssp.io.DiskLruCache");
            bufferedWriter2.write("\n");
            bufferedWriter2.write("1");
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.e));
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.g));
            bufferedWriter2.write("\n");
            bufferedWriter2.write("\n");
            for (d5 d5Var : this.j.values()) {
                if (d5Var.d != null) {
                    bufferedWriter2.write("DIRTY " + d5Var.a + '\n');
                } else {
                    StringBuilder sbAppend = new StringBuilder().append("CLEAN ").append(d5Var.a);
                    StringBuilder sb = new StringBuilder();
                    for (long j : d5Var.b) {
                        sb.append(' ').append(j);
                    }
                    bufferedWriter2.write(sbAppend.append(sb.toString()).append('\n').toString());
                }
            }
            bufferedWriter2.close();
            if (this.b.exists()) {
                File file = this.b;
                File file2 = this.d;
                if (file2.exists() && !file2.delete()) {
                    throw new IOException();
                }
                if (!file.renameTo(file2)) {
                    throw new IOException();
                }
            }
            if (!this.c.renameTo(this.b)) {
                throw new IOException();
            }
            this.d.delete();
            this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), mk.a));
        } catch (Throwable th) {
            bufferedWriter2.close();
            throw th;
        }
    }

    public final void e() {
        while (this.h > this.f) {
            d((String) ((Map.Entry) this.j.entrySet().iterator().next()).getKey());
        }
    }

    public final synchronized e5 b(String str) {
        InputStream inputStream;
        a();
        if (o.matcher(str).matches()) {
            d5 d5Var = (d5) this.j.get(str);
            if (d5Var == null) {
                return null;
            }
            if (!d5Var.c) {
                return null;
            }
            InputStream[] inputStreamArr = new InputStream[this.g];
            for (int i = 0; i < this.g; i++) {
                try {
                    inputStreamArr[i] = new FileInputStream(d5Var.a(i));
                } catch (FileNotFoundException e) {
                    for (int i2 = 0; i2 < this.g && (inputStream = inputStreamArr[i2]) != null; i2++) {
                        Charset charset = mk.a;
                        try {
                            inputStream.close();
                        } catch (RuntimeException e2) {
                            throw e2;
                        } catch (Exception e3) {
                        }
                    }
                    return null;
                }
            }
            this.k++;
            this.i.append((CharSequence) ("READ " + str + '\n'));
            int i3 = this.k;
            if (i3 >= 1000 && i3 >= this.j.size()) {
                this.m.submit(this.n);
            }
            return new e5(inputStreamArr);
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public final void c(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf != -1) {
            int i = iIndexOf + 1;
            int iIndexOf2 = str.indexOf(32, i);
            if (iIndexOf2 == -1) {
                strSubstring = str.substring(i);
                if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                    this.j.remove(strSubstring);
                    return;
                }
            } else {
                strSubstring = str.substring(i, iIndexOf2);
            }
            d5 d5Var = (d5) this.j.get(strSubstring);
            if (d5Var == null) {
                d5Var = new d5(this, strSubstring);
                this.j.put(strSubstring, d5Var);
            }
            if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
                String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
                d5Var.c = true;
                d5Var.d = null;
                if (strArrSplit.length == d5Var.e.g) {
                    for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                        try {
                            d5Var.b[i2] = Long.parseLong(strArrSplit[i2]);
                        } catch (NumberFormatException e) {
                            throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
                        }
                    }
                    return;
                }
                throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
            }
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                d5Var.d = new c5(this, d5Var);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    public final synchronized void d(String str) {
        a();
        if (o.matcher(str).matches()) {
            d5 d5Var = (d5) this.j.get(str);
            if (d5Var != null && d5Var.d == null) {
                for (int i = 0; i < this.g; i++) {
                    File fileA = d5Var.a(i);
                    if (fileA.exists() && !fileA.delete()) {
                        throw new IOException("failed to delete " + fileA);
                    }
                    long j = this.h;
                    long[] jArr = d5Var.b;
                    this.h = j - jArr[i];
                    jArr[i] = 0;
                }
                this.k++;
                this.i.append((CharSequence) ("REMOVE " + str + '\n'));
                this.j.remove(str);
                int i2 = this.k;
                if (i2 >= 1000 && i2 >= this.j.size()) {
                    this.m.submit(this.n);
                }
            }
        } else {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public static f5 a(File file) throws IOException {
        File file2 = new File(file, "ssp_journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "ssp_journal");
            if (file3.exists()) {
                file2.delete();
            } else if (!file2.renameTo(file3)) {
                throw new IOException();
            }
        }
        f5 f5Var = new f5(file);
        if (f5Var.b.exists()) {
            try {
                f5Var.c();
                f5Var.b();
                return f5Var;
            } catch (IOException e) {
                file.toString();
                e.getMessage();
                f5Var.close();
                mk.a(f5Var.a);
            }
        }
        file.mkdirs();
        f5 f5Var2 = new f5(file);
        f5Var2.d();
        return f5Var2;
    }

    public final c5 a(String str) {
        synchronized (this) {
            a();
            if (o.matcher(str).matches()) {
                d5 d5Var = (d5) this.j.get(str);
                if (d5Var == null) {
                    d5Var = new d5(this, str);
                    this.j.put(str, d5Var);
                } else if (d5Var.d != null) {
                    return null;
                }
                c5 c5Var = new c5(this, d5Var);
                d5Var.d = c5Var;
                this.i.write("DIRTY " + str + '\n');
                this.i.flush();
                return c5Var;
            }
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final void a() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }
}
