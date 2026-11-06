package com.bytedance.sdk.component.c.ah.ms.ms;

import com.anythink.core.common.d.j;
import com.bytedance.sdk.component.utils.sl;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class ms implements Closeable {
    private final File ab;
    private final File c;
    private final int ch;
    private final File d;
    private final File ka;
    private long ny;
    private Writer sl;
    private int u;
    private final int x;
    final ExecutorService xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final Pattern f1171ms = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream ah = new OutputStream() { // from class: com.bytedance.sdk.component.c.ah.ms.ms.ms.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    private long hi = 0;
    private final LinkedHashMap<String, xr> zb = new LinkedHashMap<>(0, 0.75f, true);
    private long ub = -1;
    private long ao = 0;
    private final Callable<Void> h = new Callable<Void>() { // from class: com.bytedance.sdk.component.c.ah.ms.ms.ms.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (ms.this) {
                if (ms.this.sl == null) {
                    return null;
                }
                ms.this.ab();
                if (ms.this.ka()) {
                    ms.this.d();
                    ms.this.u = 0;
                }
                return null;
            }
        }
    };

    private ms(File file, int i, int i2, long j, ExecutorService executorService) {
        this.d = file;
        this.x = i;
        this.ka = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.ab = new File(file, "journal.bkp");
        this.ch = i2;
        this.ny = j;
        this.xr = executorService;
    }

    public static ms ms(File file, int i, int i2, long j, ExecutorService executorService) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                ms(file2, file3, false);
            }
        }
        ms msVar = new ms(file, i, i2, j, executorService);
        if (msVar.ka.exists()) {
            try {
                msVar.xr();
                msVar.ah();
                return msVar;
            } catch (IOException e) {
                sl.xr("DiskLruCache ", file + " is corrupt: " + e.getMessage() + ", removing");
                msVar.delete();
            }
        }
        file.mkdirs();
        ms msVar2 = new ms(file, i, i2, j, executorService);
        msVar2.d();
        return msVar2;
    }

    private void xr() throws IOException {
        com.bytedance.sdk.component.c.ah.ms.ms.ah ahVar = new com.bytedance.sdk.component.c.ah.ms.ms.ah(new FileInputStream(this.ka), d.f1170ms);
        try {
            String strMs = ahVar.ms();
            String strMs2 = ahVar.ms();
            String strMs3 = ahVar.ms();
            String strMs4 = ahVar.ms();
            String strMs5 = ahVar.ms();
            if (!"libcore.io.DiskLruCache".equals(strMs) || !"1".equals(strMs2) || !Integer.toString(this.x).equals(strMs3) || !Integer.toString(this.ch).equals(strMs4) || !"".equals(strMs5)) {
                throw new IOException("unexpected journal header: [" + strMs + ", " + strMs2 + ", " + strMs4 + ", " + strMs5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    d(ahVar.ms());
                    i++;
                } catch (EOFException unused) {
                    this.u = i - this.zb.size();
                    if (ahVar.xr()) {
                        d();
                    } else {
                        this.sl = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.ka, true), d.f1170ms));
                    }
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(ahVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.c.ah.ah.xr.ms(ahVar);
            throw th;
        }
    }

    private void d(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.zb.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        xr xrVar = this.zb.get(strSubstring);
        if (xrVar == null) {
            xrVar = new xr(strSubstring);
            this.zb.put(strSubstring, xrVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            xrVar.d = true;
            xrVar.ka = null;
            xrVar.ms(strArrSplit);
            return;
        }
        if (iIndexOf2 != -1 || iIndexOf != 5 || !str.startsWith("DIRTY")) {
            if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
            }
            return;
        }
        xrVar.ka = new C0243ms(xrVar);
    }

    private void ah() throws IOException {
        ms(this.c);
        Iterator<xr> it = this.zb.values().iterator();
        while (it.hasNext()) {
            xr next = it.next();
            int i = 0;
            if (next.ka == null) {
                while (i < this.ch) {
                    this.hi += next.ah[i];
                    i++;
                }
            } else {
                next.ka = null;
                while (i < this.ch) {
                    ms(next.ms(i));
                    ms(next.xr(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() throws IOException {
        Writer writer = this.sl;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), d.f1170ms));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.x));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.ch));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (xr xrVar : this.zb.values()) {
                if (xrVar.ka != null) {
                    bufferedWriter.write("DIRTY " + xrVar.xr + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + xrVar.xr + xrVar.ms() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.ka.exists()) {
                ms(this.ka, this.ab, true);
            }
            ms(this.c, this.ka, false);
            this.ab.delete();
            this.sl = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.ka, true), d.f1170ms));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void ms(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void ms(File file, File file2, boolean z) throws IOException {
        if (z) {
            ms(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized ah ms(String str) throws IOException {
        InputStream inputStream;
        c();
        ka(str);
        xr xrVar = this.zb.get(str);
        if (xrVar == null) {
            return null;
        }
        if (!xrVar.d) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.ch];
        for (int i = 0; i < this.ch; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(xrVar.ms(i));
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.ch && (inputStream = inputStreamArr[i2]) != null; i2++) {
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStream);
                }
                return null;
            }
        }
        this.u++;
        this.sl.append((CharSequence) ("READ " + str + '\n'));
        if (ka()) {
            this.xr.submit(this.h);
        }
        return new ah(str, xrVar.c, inputStreamArr, xrVar.ah);
    }

    public C0243ms xr(String str) throws IOException {
        return ms(str, -1L);
    }

    private synchronized C0243ms ms(String str, long j) throws IOException {
        c();
        ka(str);
        xr xrVar = this.zb.get(str);
        if (j != -1 && (xrVar == null || xrVar.c != j)) {
            return null;
        }
        if (xrVar == null) {
            xrVar = new xr(str);
            this.zb.put(str, xrVar);
        } else if (xrVar.ka != null) {
            return null;
        }
        C0243ms c0243ms = new C0243ms(xrVar);
        xrVar.ka = c0243ms;
        this.sl.write("DIRTY " + str + '\n');
        this.sl.flush();
        return c0243ms;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ms(C0243ms c0243ms, boolean z) throws IOException {
        xr xrVar = c0243ms.xr;
        if (xrVar.ka != c0243ms) {
            throw new IllegalStateException();
        }
        if (z && !xrVar.d) {
            for (int i = 0; i < this.ch; i++) {
                if (!c0243ms.ah[i]) {
                    c0243ms.xr();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!xrVar.xr(i).exists()) {
                    c0243ms.xr();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.ch; i2++) {
            File fileXr = xrVar.xr(i2);
            if (z) {
                if (fileXr.exists()) {
                    File fileMs = xrVar.ms(i2);
                    fileXr.renameTo(fileMs);
                    long j = xrVar.ah[i2];
                    long length = fileMs.length();
                    xrVar.ah[i2] = length;
                    this.hi = (this.hi - j) + length;
                }
            } else {
                ms(fileXr);
            }
        }
        this.u++;
        xrVar.ka = null;
        if (xrVar.d | z) {
            xrVar.d = true;
            this.sl.write("CLEAN " + xrVar.xr + xrVar.ms() + '\n');
            if (z) {
                long j2 = this.ao;
                this.ao = 1 + j2;
                xrVar.c = j2;
            }
        } else {
            this.zb.remove(xrVar.xr);
            this.sl.write("REMOVE " + xrVar.xr + '\n');
        }
        this.sl.flush();
        if (this.hi > this.ny || ka()) {
            this.xr.submit(this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ka() {
        int i = this.u;
        return i >= 2000 && i >= this.zb.size();
    }

    public synchronized boolean ah(String str) throws IOException {
        c();
        ka(str);
        xr xrVar = this.zb.get(str);
        if (xrVar != null && xrVar.ka == null) {
            for (int i = 0; i < this.ch; i++) {
                File fileMs = xrVar.ms(i);
                if (fileMs.exists() && !fileMs.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(fileMs)));
                }
                this.hi -= xrVar.ah[i];
                xrVar.ah[i] = 0;
            }
            this.u++;
            this.sl.append((CharSequence) ("REMOVE " + str + '\n'));
            this.zb.remove(str);
            if (ka()) {
                this.xr.submit(this.h);
            }
            return true;
        }
        return false;
    }

    private void c() {
        if (this.sl == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void ms() throws IOException {
        c();
        ab();
        this.sl.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.sl == null) {
            return;
        }
        for (xr xrVar : new ArrayList(this.zb.values())) {
            if (xrVar.ka != null) {
                xrVar.ka.xr();
            }
        }
        ab();
        this.sl.close();
        this.sl = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab() throws IOException {
        long j = this.ny;
        long j2 = this.ub;
        if (j2 >= 0) {
            j = j2;
        }
        while (this.hi > j) {
            ah(this.zb.entrySet().iterator().next().getKey());
        }
        this.ub = -1L;
    }

    public void ms(long j) {
        this.ub = j;
        this.xr.submit(this.h);
    }

    public void delete() throws IOException {
        close();
        d.ms(this.d);
    }

    private void ka(String str) {
        if (!f1171ms.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final class ah implements Closeable {
        private final long ah;
        private final InputStream[] d;
        private final long[] ka;
        private final String xr;

        private ah(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.xr = str;
            this.ah = j;
            this.d = inputStreamArr;
            this.ka = jArr;
        }

        public InputStream ms(int i) {
            return this.d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.d) {
                com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStream);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.c.ah.ms.ms.ms$ms, reason: collision with other inner class name */
    public final class C0243ms {
        private final boolean[] ah;
        private boolean d;
        private boolean ka;
        private final xr xr;

        private C0243ms(xr xrVar) {
            this.xr = xrVar;
            this.ah = xrVar.d ? null : new boolean[ms.this.ch];
        }

        public OutputStream ms(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C0244ms c0244ms;
            if (i < 0 || i >= ms.this.ch) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + ms.this.ch);
            }
            synchronized (ms.this) {
                if (this.xr.ka != this) {
                    throw new IllegalStateException();
                }
                if (!this.xr.d) {
                    this.ah[i] = true;
                }
                File fileXr = this.xr.xr(i);
                try {
                    fileOutputStream = new FileOutputStream(fileXr);
                } catch (FileNotFoundException unused) {
                    ms.this.d.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileXr);
                    } catch (FileNotFoundException unused2) {
                        return ms.ah;
                    }
                }
                c0244ms = new C0244ms(fileOutputStream);
            }
            return c0244ms;
        }

        public void ms() throws IOException {
            if (this.d) {
                ms.this.ms(this, false);
                ms.this.ah(this.xr.xr);
            } else {
                ms.this.ms(this, true);
            }
            this.ka = true;
        }

        public void xr() throws IOException {
            ms.this.ms(this, false);
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.component.c.ah.ms.ms.ms$ms$ms, reason: collision with other inner class name */
        private class C0244ms extends FilterOutputStream {
            private C0244ms(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    C0243ms.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0243ms.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    C0243ms.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    C0243ms.this.d = true;
                }
            }
        }
    }

    private final class xr {
        private final long[] ah;
        private long c;
        private boolean d;
        private C0243ms ka;
        private final String xr;

        private xr(String str) {
            this.xr = str;
            this.ah = new long[ms.this.ch];
        }

        public String ms() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.ah) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ms(String[] strArr) throws IOException {
            if (strArr.length != ms.this.ch) {
                throw xr(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.ah[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw xr(strArr);
                }
            }
        }

        private IOException xr(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File ms(int i) {
            return new File(ms.this.d, this.xr + j.z + i);
        }

        public File xr(int i) {
            return new File(ms.this.d, this.xr + j.z + i + ".tmp");
        }
    }
}
