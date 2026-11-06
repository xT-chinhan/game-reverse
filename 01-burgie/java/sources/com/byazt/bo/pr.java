package com.byazt.bo;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 508, 37})
public final class pr implements Closeable {
    public long aj;
    public final File c;
    public final File fw;
    public int g;
    public final ExecutorService hw;
    public Writer k;
    public final File uc;
    public final int vk;
    public final File x;
    public final int zo;
    public static final Pattern pr = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream hn = new OutputStream() { // from class: com.byazt.bo.pr.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    public long w = 0;
    public final LinkedHashMap<String, hw> m = new LinkedHashMap<>(0, 0.75f, true);
    public long ho = -1;
    public long nt = 0;
    public final Callable<Void> yb = new Callable<Void>() { // from class: com.byazt.bo.pr.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (pr.this) {
                if (pr.this.k == null) {
                    return null;
                }
                pr.this.fw();
                if (pr.this.c()) {
                    pr.this.x();
                    pr.this.g = 0;
                }
                return null;
            }
        }
    };

    private pr(File file, int i, int i2, long j, ExecutorService executorService) {
        this.x = file;
        this.zo = i;
        this.c = new File(file, "journal");
        this.uc = new File(file, "journal.tmp");
        this.fw = new File(file, "journal.bkp");
        this.vk = i2;
        this.aj = j;
        this.hw = executorService;
    }

    public static pr pr(File file, int i, int i2, long j, ExecutorService executorService) throws IOException {
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
                pr(file2, file3, false);
            }
        }
        pr prVar = new pr(file, i, i2, j, executorService);
        if (prVar.c.exists()) {
            try {
                prVar.hw();
                prVar.hn();
                return prVar;
            } catch (IOException e) {
                e.getMessage();
                prVar.delete();
            }
        }
        file.mkdirs();
        pr prVar2 = new pr(file, i, i2, j, executorService);
        prVar2.x();
        return prVar2;
    }

    private void hw() throws IOException {
        com.byazt.bo.hn hnVar = new com.byazt.bo.hn(new FileInputStream(this.c), x.pr);
        try {
            String strPr = hnVar.pr();
            String strPr2 = hnVar.pr();
            String strPr3 = hnVar.pr();
            String strPr4 = hnVar.pr();
            String strPr5 = hnVar.pr();
            if (!"libcore.io.DiskLruCache".equals(strPr) || !"1".equals(strPr2) || !Integer.toString(this.zo).equals(strPr3) || !Integer.toString(this.vk).equals(strPr4) || !"".equals(strPr5)) {
                throw new IOException("unexpected journal header: [" + strPr + ", " + strPr2 + ", " + strPr4 + ", " + strPr5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    x(hnVar.pr());
                    i++;
                } catch (EOFException e) {
                    this.g = i - this.m.size();
                    if (hnVar.hw()) {
                        x();
                    } else {
                        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), x.pr));
                    }
                    com.byazt.cb.hw.pr(hnVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.byazt.cb.hw.pr(hnVar);
            throw th;
        }
    }

    private void x(String str) throws IOException {
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
                this.m.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        hw hwVar = this.m.get(strSubstring);
        if (hwVar == null) {
            hwVar = new hw(strSubstring);
            this.m.put(strSubstring, hwVar);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 != -1 || iIndexOf != 5 || !str.startsWith("DIRTY")) {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
                }
                return;
            }
            hwVar.c = new C0025pr(hwVar);
            return;
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
        hwVar.x = true;
        hwVar.c = null;
        hwVar.pr(strArrSplit);
    }

    private void hn() throws IOException {
        pr(this.uc);
        Iterator<hw> it = this.m.values().iterator();
        while (it.hasNext()) {
            hw next = it.next();
            int i = 0;
            if (next.c == null) {
                while (i < this.vk) {
                    this.w += next.hn[i];
                    i++;
                }
            } else {
                next.c = null;
                while (i < this.vk) {
                    pr(next.pr(i));
                    pr(next.hw(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void x() throws IOException {
        try {
            Writer writer = this.k;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.uc), x.pr));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.zo));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.vk));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (hw hwVar : this.m.values()) {
                    if (hwVar.c != null) {
                        bufferedWriter.write("DIRTY " + hwVar.hw + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + hwVar.hw + hwVar.pr() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.c.exists()) {
                    pr(this.c, this.fw, true);
                }
                pr(this.uc, this.c, false);
                this.fw.delete();
                this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), x.pr));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static void pr(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void pr(File file, File file2, boolean z) throws IOException {
        if (z) {
            pr(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized hn pr(String str) throws IOException {
        InputStream inputStream;
        uc();
        c(str);
        hw hwVar = this.m.get(str);
        if (hwVar == null) {
            return null;
        }
        if (!hwVar.x) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.vk];
        for (int i = 0; i < this.vk; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(hwVar.pr(i));
            } catch (FileNotFoundException e) {
                for (int i2 = 0; i2 < this.vk && (inputStream = inputStreamArr[i2]) != null; i2++) {
                    com.byazt.cb.hw.pr(inputStream);
                }
                return null;
            }
        }
        this.g++;
        this.k.append((CharSequence) ("READ " + str + '\n'));
        if (c()) {
            this.hw.submit(this.yb);
        }
        return new hn(str, hwVar.uc, inputStreamArr, hwVar.hn);
    }

    public C0025pr hw(String str) throws IOException {
        return pr(str, -1L);
    }

    private synchronized C0025pr pr(String str, long j) throws IOException {
        uc();
        c(str);
        hw hwVar = this.m.get(str);
        if (j != -1 && (hwVar == null || hwVar.uc != j)) {
            return null;
        }
        if (hwVar == null) {
            hwVar = new hw(str);
            this.m.put(str, hwVar);
        } else if (hwVar.c != null) {
            return null;
        }
        C0025pr c0025pr = new C0025pr(hwVar);
        hwVar.c = c0025pr;
        this.k.write("DIRTY " + str + '\n');
        this.k.flush();
        return c0025pr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pr(C0025pr c0025pr, boolean z) throws IOException {
        hw hwVar = c0025pr.hw;
        if (hwVar.c != c0025pr) {
            throw new IllegalStateException();
        }
        if (z && !hwVar.x) {
            for (int i = 0; i < this.vk; i++) {
                if (!c0025pr.hn[i]) {
                    c0025pr.hw();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!hwVar.hw(i).exists()) {
                    c0025pr.hw();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.vk; i2++) {
            File fileHw = hwVar.hw(i2);
            if (z) {
                if (fileHw.exists()) {
                    File filePr = hwVar.pr(i2);
                    fileHw.renameTo(filePr);
                    long j = hwVar.hn[i2];
                    long length = filePr.length();
                    hwVar.hn[i2] = length;
                    this.w = (this.w - j) + length;
                }
            } else {
                pr(fileHw);
            }
        }
        this.g++;
        hwVar.c = null;
        if (hwVar.x | z) {
            hwVar.x = true;
            this.k.write("CLEAN " + hwVar.hw + hwVar.pr() + '\n');
            if (z) {
                long j2 = this.nt;
                this.nt = 1 + j2;
                hwVar.uc = j2;
            }
        } else {
            this.m.remove(hwVar.hw);
            this.k.write("REMOVE " + hwVar.hw + '\n');
        }
        this.k.flush();
        if (this.w > this.aj || c()) {
            this.hw.submit(this.yb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        int i = this.g;
        return i >= 2000 && i >= this.m.size();
    }

    public synchronized boolean hn(String str) throws IOException {
        uc();
        c(str);
        hw hwVar = this.m.get(str);
        if (hwVar != null && hwVar.c == null) {
            for (int i = 0; i < this.vk; i++) {
                File filePr = hwVar.pr(i);
                if (filePr.exists() && !filePr.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(filePr)));
                }
                this.w -= hwVar.hn[i];
                hwVar.hn[i] = 0;
            }
            this.g++;
            this.k.append((CharSequence) ("REMOVE " + str + '\n'));
            this.m.remove(str);
            if (c()) {
                this.hw.submit(this.yb);
            }
            return true;
        }
        return false;
    }

    private void uc() {
        if (this.k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void pr() throws IOException {
        uc();
        fw();
        this.k.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.k == null) {
            return;
        }
        for (hw hwVar : new ArrayList(this.m.values())) {
            if (hwVar.c != null) {
                hwVar.c.hw();
            }
        }
        fw();
        this.k.close();
        this.k = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw() throws IOException {
        long j = this.aj;
        long j2 = this.ho;
        if (j2 >= 0) {
            j = j2;
        }
        while (this.w > j) {
            hn(this.m.entrySet().iterator().next().getKey());
        }
        this.ho = -1L;
    }

    public void pr(long j) {
        this.ho = j;
        this.hw.submit(this.yb);
    }

    public void delete() throws IOException {
        close();
        x.pr(this.x);
    }

    private void c(String str) {
        if (!pr.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 508, MediaPlayer.MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END})
    public final class hn implements Closeable {
        public final long[] c;
        public final long hn;
        public final String hw;
        public final InputStream[] x;

        private hn(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.hw = str;
            this.hn = j;
            this.x = inputStreamArr;
            this.c = jArr;
        }

        public InputStream pr(int i) {
            return this.x[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.x) {
                com.byazt.cb.hw.pr(inputStream);
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.bo.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 508, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public final class C0025pr {
        public boolean c;
        public final boolean[] hn;
        public final hw hw;
        public boolean x;

        private C0025pr(hw hwVar) {
            this.hw = hwVar;
            this.hn = hwVar.x ? null : new boolean[pr.this.vk];
        }

        public OutputStream pr(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C0026pr c0026pr;
            if (i < 0 || i >= pr.this.vk) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + pr.this.vk);
            }
            synchronized (pr.this) {
                if (this.hw.c != this) {
                    throw new IllegalStateException();
                }
                if (!this.hw.x) {
                    this.hn[i] = true;
                }
                File fileHw = this.hw.hw(i);
                try {
                    fileOutputStream = new FileOutputStream(fileHw);
                } catch (FileNotFoundException e) {
                    pr.this.x.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileHw);
                    } catch (FileNotFoundException e2) {
                        return pr.hn;
                    }
                }
                c0026pr = new C0026pr(fileOutputStream);
            }
            return c0026pr;
        }

        public void pr() throws IOException {
            if (this.x) {
                pr.this.pr(this, false);
                pr.this.hn(this.hw.hw);
            } else {
                pr.this.pr(this, true);
            }
            this.c = true;
        }

        public void hw() throws IOException {
            pr.this.pr(this, false);
        }

        /* JADX INFO: renamed from: com.byazt.bo.pr$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 508, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL})
        private final class C0026pr extends FilterOutputStream {
            private C0026pr(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    C0025pr.this.x = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    C0025pr.this.x = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    C0025pr.this.x = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    C0025pr.this.x = true;
                }
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 508, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    private final class hw {
        public C0025pr c;
        public final long[] hn;
        public final String hw;
        public long uc;
        public boolean x;

        private hw(String str) {
            this.hw = str;
            this.hn = new long[pr.this.vk];
        }

        public String pr() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.hn) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pr(String[] strArr) throws IOException {
            if (strArr.length != pr.this.vk) {
                throw hw(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.hn[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw hw(strArr);
                }
            }
        }

        private IOException hw(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File pr(int i) {
            return new File(pr.this.x, this.hw + "." + i);
        }

        public File hw(int i) {
            return new File(pr.this.x, this.hw + "." + i + ".tmp");
        }
    }
}
