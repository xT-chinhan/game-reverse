package com.byazt.gr;

import android.support.v4.view.PointerIconCompat;
import com.byazt.du.k;
import com.byazt.du.lb;
import com.byazt.du.qa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 691, 121})
public final class x implements Closeable, Flushable {
    public static final /* synthetic */ boolean m = true;
    public static final Pattern pr = Pattern.compile("[a-z0-9_-]{1,120}");
    public long a;
    public boolean aj;
    public com.byazt.du.x c;
    public final Executor cz;
    public int fw;
    public final File g;
    public final File hn;
    public final File ho;
    public final com.byazt.rn.pr hw;
    public boolean k;
    public long lb;
    public final File nt;
    public final Runnable ny;
    public long qa;
    public final LinkedHashMap<String, hw> uc;
    public boolean vk;
    public boolean w;
    public final int x;
    public final int yb;
    public boolean zo;

    public synchronized void pr() throws IOException {
        if (!m && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.aj) {
            return;
        }
        if (this.hw.x(this.nt)) {
            if (this.hw.x(this.g)) {
                this.hw.delete(this.nt);
            } else {
                this.hw.pr(this.nt, this.g);
            }
        }
        if (this.hw.x(this.g)) {
            try {
                uc();
                zo();
                this.aj = true;
                return;
            } catch (IOException e) {
                com.byazt.lp.c.hw().pr(5, "DiskLruCache " + this.hn + " is corrupt: " + e.getMessage() + ", removing", e);
                try {
                    delete();
                    this.vk = false;
                    hw();
                    this.aj = true;
                } catch (Throwable th) {
                    this.vk = false;
                    throw th;
                }
            }
        }
        hw();
        this.aj = true;
    }

    private void uc() throws IOException {
        com.byazt.du.c cVarPr = k.pr(this.hw.pr(this.g));
        try {
            String strNt = cVarPr.nt();
            String strNt2 = cVarPr.nt();
            String strNt3 = cVarPr.nt();
            String strNt4 = cVarPr.nt();
            String strNt5 = cVarPr.nt();
            if (!"libcore.io.DiskLruCache".equals(strNt) || !"1".equals(strNt2) || !Integer.toString(this.yb).equals(strNt3) || !Integer.toString(this.x).equals(strNt4) || !"".equals(strNt5)) {
                throw new IOException("unexpected journal header: [" + strNt + ", " + strNt2 + ", " + strNt4 + ", " + strNt5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    pr(cVarPr.nt());
                    i++;
                } catch (EOFException e) {
                    this.fw = i - this.uc.size();
                    if (!cVarPr.c()) {
                        hw();
                    } else {
                        this.c = fw();
                    }
                    com.byazt.xx.hn.pr(cVarPr);
                    return;
                }
            }
        } catch (Throwable th) {
            com.byazt.xx.hn.pr(cVarPr);
            throw th;
        }
    }

    private com.byazt.du.x fw() throws FileNotFoundException {
        return k.pr(new c(this.hw.hn(this.g)) { // from class: com.byazt.gr.x.1
            public static final /* synthetic */ boolean pr = true;

            @Override // com.byazt.gr.c
            public void pr(IOException iOException) {
                if (!pr && !Thread.holdsLock(x.this)) {
                    throw new AssertionError();
                }
                x.this.zo = true;
            }
        });
    }

    private void pr(String str) throws IOException {
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
                this.uc.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        hw hwVar = this.uc.get(strSubstring);
        if (hwVar == null) {
            hwVar = new hw(strSubstring);
            this.uc.put(strSubstring, hwVar);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                hwVar.uc = new pr(hwVar);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
                }
                return;
            }
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
        hwVar.c = true;
        hwVar.uc = null;
        hwVar.pr(strArrSplit);
    }

    private void zo() throws IOException {
        this.hw.delete(this.ho);
        Iterator<hw> it = this.uc.values().iterator();
        while (it.hasNext()) {
            hw next = it.next();
            int i = 0;
            if (next.uc == null) {
                while (i < this.x) {
                    this.qa += next.hw[i];
                    i++;
                }
            } else {
                next.uc = null;
                while (i < this.x) {
                    this.hw.delete(next.hn[i]);
                    this.hw.delete(next.x[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    public synchronized void hw() throws IOException {
        try {
            com.byazt.du.x xVar = this.c;
            if (xVar != null) {
                xVar.close();
            }
            com.byazt.du.x xVarPr = k.pr(this.hw.hw(this.ho));
            try {
                xVarPr.hw("libcore.io.DiskLruCache").aj(10);
                xVarPr.hw("1").aj(10);
                xVarPr.k(this.yb).aj(10);
                xVarPr.k(this.x).aj(10);
                xVarPr.aj(10);
                for (hw hwVar : this.uc.values()) {
                    if (hwVar.uc != null) {
                        xVarPr.hw("DIRTY").aj(32);
                        xVarPr.hw(hwVar.pr);
                        xVarPr.aj(10);
                    } else {
                        xVarPr.hw("CLEAN").aj(32);
                        xVarPr.hw(hwVar.pr);
                        hwVar.pr(xVarPr);
                        xVarPr.aj(10);
                    }
                }
                xVarPr.close();
                if (this.hw.x(this.g)) {
                    this.hw.pr(this.g, this.nt);
                }
                this.hw.pr(this.ho, this.g);
                this.hw.delete(this.nt);
                this.c = fw();
                this.zo = false;
                this.k = false;
            } catch (Throwable th) {
                xVarPr.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized pr pr(String str, long j) throws IOException {
        pr();
        aj();
        hw(str);
        hw hwVar = this.uc.get(str);
        if (j != -1 && (hwVar == null || hwVar.fw != j)) {
            return null;
        }
        if (hwVar != null && hwVar.uc != null) {
            return null;
        }
        if (!this.w && !this.k) {
            this.c.hw("DIRTY").aj(32).hw(str).aj(10);
            this.c.flush();
            if (this.zo) {
                return null;
            }
            if (hwVar == null) {
                hwVar = new hw(str);
                this.uc.put(str, hwVar);
            }
            pr prVar = new pr(hwVar);
            hwVar.uc = prVar;
            return prVar;
        }
        this.cz.execute(this.ny);
        return null;
    }

    public synchronized void pr(pr prVar, boolean z) throws IOException {
        hw hwVar = prVar.pr;
        if (hwVar.uc != prVar) {
            throw new IllegalStateException();
        }
        if (z && !hwVar.c) {
            for (int i = 0; i < this.x; i++) {
                if (!prVar.hw[i]) {
                    prVar.hn();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!this.hw.x(hwVar.x[i])) {
                    prVar.hn();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.x; i2++) {
            File file = hwVar.x[i2];
            if (z) {
                if (this.hw.x(file)) {
                    File file2 = hwVar.hn[i2];
                    this.hw.pr(file, file2);
                    long j = hwVar.hw[i2];
                    long jC = this.hw.c(file2);
                    hwVar.hw[i2] = jC;
                    this.qa = (this.qa - j) + jC;
                }
            } else {
                this.hw.delete(file);
            }
        }
        this.fw++;
        hwVar.uc = null;
        if (hwVar.c | z) {
            hwVar.c = true;
            this.c.hw("CLEAN").aj(32);
            this.c.hw(hwVar.pr);
            hwVar.pr(this.c);
            this.c.aj(10);
            if (z) {
                long j2 = this.a;
                this.a = 1 + j2;
                hwVar.fw = j2;
            }
        } else {
            this.uc.remove(hwVar.pr);
            this.c.hw("REMOVE").aj(32);
            this.c.hw(hwVar.pr);
            this.c.aj(10);
        }
        this.c.flush();
        if (this.qa > this.lb || hn()) {
            this.cz.execute(this.ny);
        }
    }

    public boolean hn() {
        int i = this.fw;
        return i >= 2000 && i >= this.uc.size();
    }

    public boolean pr(hw hwVar) throws IOException {
        if (hwVar.uc != null) {
            hwVar.uc.pr();
        }
        for (int i = 0; i < this.x; i++) {
            this.hw.delete(hwVar.hn[i]);
            this.qa -= hwVar.hw[i];
            hwVar.hw[i] = 0;
        }
        this.fw++;
        this.c.hw("REMOVE").aj(32).hw(hwVar.pr).aj(10);
        this.uc.remove(hwVar.pr);
        if (hn()) {
            this.cz.execute(this.ny);
        }
        return true;
    }

    public synchronized boolean x() {
        return this.vk;
    }

    private synchronized void aj() {
        if (x()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.aj) {
            aj();
            c();
            this.c.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.aj && !this.vk) {
            for (hw hwVar : (hw[]) this.uc.values().toArray(new hw[this.uc.size()])) {
                if (hwVar.uc != null) {
                    hwVar.uc.hn();
                }
            }
            c();
            this.c.close();
            this.c = null;
            this.vk = true;
            return;
        }
        this.vk = true;
    }

    public void c() throws IOException {
        while (this.qa > this.lb) {
            pr(this.uc.values().iterator().next());
        }
        this.w = false;
    }

    public void delete() throws IOException {
        close();
        this.hw.uc(this.hn);
    }

    private void hw(String str) {
        if (!pr.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 691, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW})
    public final class hn implements Closeable {
        public final long hn;
        public final String hw;
        public final /* synthetic */ x pr;
        public final qa[] x;

        public pr pr() throws IOException {
            return this.pr.pr(this.hw, this.hn);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (qa qaVar : this.x) {
                com.byazt.xx.hn.pr(qaVar);
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 691, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    public final class pr {
        public final boolean[] hw;
        public final hw pr;
        public boolean x;

        public pr(hw hwVar) {
            this.pr = hwVar;
            this.hw = hwVar.c ? null : new boolean[x.this.x];
        }

        public void pr() {
            if (this.pr.uc == this) {
                for (int i = 0; i < x.this.x; i++) {
                    try {
                        x.this.hw.delete(this.pr.x[i]);
                    } catch (IOException e) {
                    }
                }
                this.pr.uc = null;
            }
        }

        public lb pr(int i) {
            synchronized (x.this) {
                if (this.x) {
                    throw new IllegalStateException();
                }
                if (this.pr.uc != this) {
                    return k.pr();
                }
                if (!this.pr.c) {
                    this.hw[i] = true;
                }
                try {
                    return new c(x.this.hw.hw(this.pr.x[i])) { // from class: com.byazt.gr.x.pr.1
                        @Override // com.byazt.gr.c
                        public void pr(IOException iOException) {
                            synchronized (x.this) {
                                pr.this.pr();
                            }
                        }
                    };
                } catch (FileNotFoundException e) {
                    return k.pr();
                }
            }
        }

        public void hw() throws IOException {
            synchronized (x.this) {
                if (this.x) {
                    throw new IllegalStateException();
                }
                if (this.pr.uc == this) {
                    x.this.pr(this, true);
                }
                this.x = true;
            }
        }

        public void hn() throws IOException {
            synchronized (x.this) {
                if (this.x) {
                    throw new IllegalStateException();
                }
                if (this.pr.uc == this) {
                    x.this.pr(this, false);
                }
                this.x = true;
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 691, 759})
    private final class hw {
        public boolean c;
        public long fw;
        public final File[] hn;
        public final long[] hw;
        public final String pr;
        public pr uc;
        public final File[] x;

        public hw(String str) {
            this.pr = str;
            this.hw = new long[x.this.x];
            this.hn = new File[x.this.x];
            this.x = new File[x.this.x];
            StringBuilder sbAppend = new StringBuilder(str).append('.');
            int length = sbAppend.length();
            for (int i = 0; i < x.this.x; i++) {
                sbAppend.append(i);
                this.hn[i] = new File(x.this.hn, sbAppend.toString());
                sbAppend.append(".tmp");
                this.x[i] = new File(x.this.hn, sbAppend.toString());
                sbAppend.setLength(length);
            }
        }

        public void pr(String[] strArr) throws IOException {
            if (strArr.length != x.this.x) {
                throw hw(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.hw[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw hw(strArr);
                }
            }
        }

        public void pr(com.byazt.du.x xVar) throws IOException {
            for (long j : this.hw) {
                xVar.aj(32).k(j);
            }
        }

        private IOException hw(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }
}
