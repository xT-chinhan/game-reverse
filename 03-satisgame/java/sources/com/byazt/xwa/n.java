package com.byazt.xwa;

import com.anythink.core.common.d.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, 19})
public final class n implements Closeable {
    public static final Pattern n = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream s = new OutputStream() { // from class: com.byazt.xwa.n.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    public Writer d;
    public final int fs;
    public final File l;
    public final File q;
    public final ExecutorService qg;
    public long rv;
    public int sz;
    public final int tj;
    public final File w;
    public final File x;
    public long cp = 0;
    public final LinkedHashMap<String, qg> oa = new LinkedHashMap<>(0, 0.75f, true);
    public long k = -1;
    public long cy = 0;
    public final Callable<Void> hd = new Callable<Void>() { // from class: com.byazt.xwa.n.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (n.this) {
                if (n.this.d == null) {
                    return null;
                }
                n.this.rv();
                if (n.this.x()) {
                    n.this.w();
                    n.this.sz = 0;
                }
                return null;
            }
        }
    };

    private n(File file, int i, int i2, long j, ExecutorService executorService) {
        this.q = file;
        this.fs = i;
        this.l = new File(file, "journal");
        this.w = new File(file, "journal.tmp");
        this.x = new File(file, "journal.bkp");
        this.tj = i2;
        this.rv = j;
        this.qg = executorService;
    }

    public static n n(File file, int i, int i2, long j, ExecutorService executorService) throws IOException {
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
                n(file2, file3, false);
            }
        }
        n nVar = new n(file, i, i2, j, executorService);
        if (nVar.l.exists()) {
            try {
                nVar.q();
                nVar.l();
                return nVar;
            } catch (IOException e) {
                e.getMessage();
                nVar.delete();
            }
        }
        file.mkdirs();
        n nVar2 = new n(file, i, i2, j, executorService);
        nVar2.w();
        return nVar2;
    }

    private void q() throws IOException {
        com.byazt.xwa.s sVar = new com.byazt.xwa.s(new FileInputStream(this.l), q.n);
        try {
            String strN = sVar.n();
            String strN2 = sVar.n();
            String strN3 = sVar.n();
            String strN4 = sVar.n();
            String strN5 = sVar.n();
            if (!"libcore.io.DiskLruCache".equals(strN) || !"1".equals(strN2) || !Integer.toString(this.fs).equals(strN3) || !Integer.toString(this.tj).equals(strN4) || !"".equals(strN5)) {
                throw new IOException("unexpected journal header: [" + strN + ", " + strN2 + ", " + strN4 + ", " + strN5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(sVar.n());
                    i++;
                } catch (EOFException unused) {
                    this.sz = i - this.oa.size();
                    if (sVar.qg()) {
                        w();
                    } else {
                        this.d = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.l, true), q.n));
                    }
                    com.byazt.pn.n.n(sVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.byazt.pn.n.n(sVar);
            throw th;
        }
    }

    private void q(String str) throws IOException {
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
                this.oa.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        qg qgVar = this.oa.get(strSubstring);
        if (qgVar == null) {
            qgVar = new qg(strSubstring);
            this.oa.put(strSubstring, qgVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            qgVar.q = true;
            qgVar.l = null;
            qgVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 != -1 || iIndexOf != 5 || !str.startsWith("DIRTY")) {
            if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
            }
            return;
        }
        qgVar.l = new C0398n(qgVar);
    }

    private void l() throws IOException {
        n(this.w);
        Iterator<qg> it = this.oa.values().iterator();
        while (it.hasNext()) {
            qg next = it.next();
            int i = 0;
            if (next.l == null) {
                while (i < this.tj) {
                    this.cp += next.s[i];
                    i++;
                }
            } else {
                next.l = null;
                while (i < this.tj) {
                    n(next.n(i));
                    n(next.qg(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void w() throws IOException {
        try {
            Writer writer = this.d;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.w), q.n));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.fs));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.tj));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (qg qgVar : this.oa.values()) {
                    if (qgVar.l != null) {
                        bufferedWriter.write("DIRTY " + qgVar.qg + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + qgVar.qg + qgVar.n() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.l.exists()) {
                    n(this.l, this.x, true);
                }
                n(this.w, this.l, false);
                this.x.delete();
                this.d = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.l, true), q.n));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static void n(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void n(File file, File file2, boolean z) throws IOException {
        if (z) {
            n(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized s n(String str) throws IOException {
        InputStream inputStream;
        fs();
        l(str);
        qg qgVar = this.oa.get(str);
        if (qgVar == null) {
            return null;
        }
        if (!qgVar.q) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.tj];
        for (int i = 0; i < this.tj; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(qgVar.n(i));
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.tj && (inputStream = inputStreamArr[i2]) != null; i2++) {
                    com.byazt.pn.n.n(inputStream);
                }
                return null;
            }
        }
        this.sz++;
        this.d.append((CharSequence) ("READ " + str + '\n'));
        if (x()) {
            this.qg.submit(this.hd);
        }
        return new s(str, qgVar.w, inputStreamArr, qgVar.s);
    }

    public C0398n qg(String str) throws IOException {
        return n(str, -1L);
    }

    private synchronized C0398n n(String str, long j) throws IOException {
        fs();
        l(str);
        qg qgVar = this.oa.get(str);
        if (j != -1 && (qgVar == null || qgVar.w != j)) {
            return null;
        }
        if (qgVar == null) {
            qgVar = new qg(str);
            this.oa.put(str, qgVar);
        } else if (qgVar.l != null) {
            return null;
        }
        C0398n c0398n = new C0398n(qgVar);
        qgVar.l = c0398n;
        this.d.write("DIRTY " + str + '\n');
        this.d.flush();
        return c0398n;
    }

    public synchronized long n() {
        return this.cp;
    }

    public int qg() {
        return this.oa.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(C0398n c0398n, boolean z) throws IOException {
        qg qgVar = c0398n.qg;
        if (qgVar.l != c0398n) {
            throw new IllegalStateException();
        }
        if (z && !qgVar.q) {
            for (int i = 0; i < this.tj; i++) {
                if (!c0398n.s[i]) {
                    c0398n.qg();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!qgVar.qg(i).exists()) {
                    c0398n.qg();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.tj; i2++) {
            File fileQg = qgVar.qg(i2);
            if (z) {
                if (fileQg.exists()) {
                    File fileN = qgVar.n(i2);
                    fileQg.renameTo(fileN);
                    long j = qgVar.s[i2];
                    long length = fileN.length();
                    qgVar.s[i2] = length;
                    this.cp = (this.cp - j) + length;
                }
            } else {
                n(fileQg);
            }
        }
        this.sz++;
        qgVar.l = null;
        if (qgVar.q | z) {
            qgVar.q = true;
            this.d.write("CLEAN " + qgVar.qg + qgVar.n() + '\n');
            if (z) {
                long j2 = this.cy;
                this.cy = 1 + j2;
                qgVar.w = j2;
            }
        } else {
            this.oa.remove(qgVar.qg);
            this.d.write("REMOVE " + qgVar.qg + '\n');
        }
        this.d.flush();
        if (this.cp > this.rv || x()) {
            this.qg.submit(this.hd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        int i = this.sz;
        return i >= 2000 && i >= this.oa.size();
    }

    public synchronized boolean s(String str) throws IOException {
        fs();
        l(str);
        qg qgVar = this.oa.get(str);
        if (qgVar != null && qgVar.l == null) {
            for (int i = 0; i < this.tj; i++) {
                File fileN = qgVar.n(i);
                if (fileN.exists() && !fileN.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(fileN)));
                }
                this.cp -= qgVar.s[i];
                qgVar.s[i] = 0;
            }
            this.sz++;
            this.d.append((CharSequence) ("REMOVE " + str + '\n'));
            this.oa.remove(str);
            if (x()) {
                this.qg.submit(this.hd);
            }
            return true;
        }
        return false;
    }

    private void fs() {
        if (this.d == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void s() throws IOException {
        fs();
        rv();
        this.d.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.d == null) {
            return;
        }
        for (qg qgVar : new ArrayList(this.oa.values())) {
            if (qgVar.l != null) {
                qgVar.l.qg();
            }
        }
        rv();
        this.d.close();
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() throws IOException {
        long j = this.rv;
        long j2 = this.k;
        if (j2 >= 0) {
            j = j2;
        }
        while (this.cp > j) {
            s(this.oa.entrySet().iterator().next().getKey());
        }
        this.k = -1L;
    }

    public void n(long j) {
        this.k = j;
        this.qg.submit(this.hd);
    }

    public void delete() throws IOException {
        close();
        q.n(this.q);
    }

    private void l(String str) {
        if (!n.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, 829})
    public final class s implements Closeable {
        public final long[] l;
        public final InputStream[] q;
        public final String qg;
        public final long s;

        private s(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.qg = str;
            this.s = j;
            this.q = inputStreamArr;
            this.l = jArr;
        }

        public InputStream n(int i) {
            return this.q[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.q) {
                com.byazt.pn.n.n(inputStream);
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.xwa.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public final class C0398n {
        public boolean l;
        public boolean q;
        public final qg qg;
        public final boolean[] s;

        private C0398n(qg qgVar) {
            this.qg = qgVar;
            this.s = qgVar.q ? null : new boolean[n.this.tj];
        }

        public OutputStream n(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C0399n c0399n;
            if (i < 0 || i >= n.this.tj) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + n.this.tj);
            }
            synchronized (n.this) {
                if (this.qg.l != this) {
                    throw new IllegalStateException();
                }
                if (!this.qg.q) {
                    this.s[i] = true;
                }
                File fileQg = this.qg.qg(i);
                try {
                    fileOutputStream = new FileOutputStream(fileQg);
                } catch (FileNotFoundException unused) {
                    n.this.q.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileQg);
                    } catch (FileNotFoundException unused2) {
                        return n.s;
                    }
                }
                c0399n = new C0399n(fileOutputStream);
            }
            return c0399n;
        }

        public void n() throws IOException {
            if (this.q) {
                n.this.n(this, false);
                n.this.s(this.qg.qg);
            } else {
                n.this.n(this, true);
            }
            this.l = true;
        }

        public void qg() throws IOException {
            n.this.n(this, false);
        }

        /* JADX INFO: renamed from: com.byazt.xwa.n$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, 512})
        private final class C0399n extends FilterOutputStream {
            private C0399n(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    C0398n.this.q = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0398n.this.q = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    C0398n.this.q = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    C0398n.this.q = true;
                }
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, 226})
    private final class qg {
        public C0398n l;
        public boolean q;
        public final String qg;
        public final long[] s;
        public long w;

        private qg(String str) {
            this.qg = str;
            this.s = new long[n.this.tj];
        }

        public String n() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.s) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length != n.this.tj) {
                throw qg(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.s[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw qg(strArr);
                }
            }
        }

        private IOException qg(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File n(int i) {
            return new File(n.this.q, this.qg + i.E + i);
        }

        public File qg(int i) {
            return new File(n.this.q, this.qg + i.E + i + ".tmp");
        }
    }
}
