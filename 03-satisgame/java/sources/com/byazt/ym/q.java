package com.byazt.ym;

import com.byazt.wa.cd;
import com.byazt.wa.d;
import com.byazt.wa.um;
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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1223, 5})
public final class q implements Closeable, Flushable {
    public static final Pattern n = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final /* synthetic */ boolean oa = true;
    public long a;
    public long cd;
    public boolean cp;
    public final File cy;
    public boolean d;
    public boolean fs;
    public final int hd;
    public final File k;
    public com.byazt.wa.q l;
    public final Runnable ou;
    public final Executor py;
    public final int q;
    public final com.byazt.hmw.n qg;
    public boolean rv;
    public final File s;
    public final File sz;
    public boolean tj;
    public long um;
    public final LinkedHashMap<String, qg> w;
    public int x;

    public synchronized void n() throws IOException {
        if (!oa && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.rv) {
            return;
        }
        if (this.qg.q(this.cy)) {
            if (this.qg.q(this.sz)) {
                this.qg.delete(this.cy);
            } else {
                this.qg.n(this.cy, this.sz);
            }
        }
        if (this.qg.q(this.sz)) {
            try {
                w();
                fs();
                this.rv = true;
                return;
            } catch (IOException e) {
                com.byazt.quz.l.qg().n(5, "DiskLruCache " + this.s + " is corrupt: " + e.getMessage() + ", removing", e);
                try {
                    delete();
                    this.tj = false;
                    qg();
                    this.rv = true;
                } catch (Throwable th) {
                    this.tj = false;
                    throw th;
                }
            }
        }
        qg();
        this.rv = true;
    }

    private void w() throws IOException {
        com.byazt.wa.l lVarN = d.n(this.qg.n(this.sz));
        try {
            String strCy = lVarN.cy();
            String strCy2 = lVarN.cy();
            String strCy3 = lVarN.cy();
            String strCy4 = lVarN.cy();
            String strCy5 = lVarN.cy();
            if (!"libcore.io.DiskLruCache".equals(strCy) || !"1".equals(strCy2) || !Integer.toString(this.hd).equals(strCy3) || !Integer.toString(this.q).equals(strCy4) || !"".equals(strCy5)) {
                throw new IOException("unexpected journal header: [" + strCy + ", " + strCy2 + ", " + strCy4 + ", " + strCy5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    n(lVarN.cy());
                    i++;
                } catch (EOFException unused) {
                    this.x = i - this.w.size();
                    if (!lVarN.l()) {
                        qg();
                    } else {
                        this.l = x();
                    }
                    com.byazt.zho.s.n(lVarN);
                    return;
                }
            }
        } catch (Throwable th) {
            com.byazt.zho.s.n(lVarN);
            throw th;
        }
    }

    private com.byazt.wa.q x() throws FileNotFoundException {
        return d.n(new l(this.qg.s(this.sz)) { // from class: com.byazt.ym.q.1
            public static final /* synthetic */ boolean n = true;

            @Override // com.byazt.ym.l
            public void n(IOException iOException) {
                if (!n && !Thread.holdsLock(q.this)) {
                    throw new AssertionError();
                }
                q.this.fs = true;
            }
        });
    }

    private void n(String str) throws IOException {
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
                this.w.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        qg qgVar = this.w.get(strSubstring);
        if (qgVar == null) {
            qgVar = new qg(strSubstring);
            this.w.put(strSubstring, qgVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            qgVar.l = true;
            qgVar.w = null;
            qgVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            qgVar.w = new n(qgVar);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
    }

    private void fs() throws IOException {
        this.qg.delete(this.k);
        Iterator<qg> it = this.w.values().iterator();
        while (it.hasNext()) {
            qg next = it.next();
            int i = 0;
            if (next.w == null) {
                while (i < this.q) {
                    this.um += next.qg[i];
                    i++;
                }
            } else {
                next.w = null;
                while (i < this.q) {
                    this.qg.delete(next.s[i]);
                    this.qg.delete(next.q[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    public synchronized void qg() throws IOException {
        try {
            com.byazt.wa.q qVar = this.l;
            if (qVar != null) {
                qVar.close();
            }
            com.byazt.wa.q qVarN = d.n(this.qg.qg(this.k));
            try {
                qVarN.qg("libcore.io.DiskLruCache").rv(10);
                qVarN.qg("1").rv(10);
                qVarN.d(this.hd).rv(10);
                qVarN.d(this.q).rv(10);
                qVarN.rv(10);
                for (qg qgVar : this.w.values()) {
                    if (qgVar.w != null) {
                        qVarN.qg("DIRTY").rv(32);
                        qVarN.qg(qgVar.n);
                        qVarN.rv(10);
                    } else {
                        qVarN.qg("CLEAN").rv(32);
                        qVarN.qg(qgVar.n);
                        qgVar.n(qVarN);
                        qVarN.rv(10);
                    }
                }
                qVarN.close();
                if (this.qg.q(this.sz)) {
                    this.qg.n(this.sz, this.cy);
                }
                this.qg.n(this.k, this.sz);
                this.qg.delete(this.cy);
                this.l = x();
                this.fs = false;
                this.d = false;
            } catch (Throwable th) {
                qVarN.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized n n(String str, long j) throws IOException {
        n();
        rv();
        qg(str);
        qg qgVar = this.w.get(str);
        if (j != -1 && (qgVar == null || qgVar.x != j)) {
            return null;
        }
        if (qgVar != null && qgVar.w != null) {
            return null;
        }
        if (!this.cp && !this.d) {
            this.l.qg("DIRTY").rv(32).qg(str).rv(10);
            this.l.flush();
            if (this.fs) {
                return null;
            }
            if (qgVar == null) {
                qgVar = new qg(str);
                this.w.put(str, qgVar);
            }
            n nVar = new n(qgVar);
            qgVar.w = nVar;
            return nVar;
        }
        this.py.execute(this.ou);
        return null;
    }

    public synchronized void n(n nVar, boolean z) throws IOException {
        qg qgVar = nVar.n;
        if (qgVar.w != nVar) {
            throw new IllegalStateException();
        }
        if (z && !qgVar.l) {
            for (int i = 0; i < this.q; i++) {
                if (!nVar.qg[i]) {
                    nVar.s();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!this.qg.q(qgVar.q[i])) {
                    nVar.s();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.q; i2++) {
            File file = qgVar.q[i2];
            if (z) {
                if (this.qg.q(file)) {
                    File file2 = qgVar.s[i2];
                    this.qg.n(file, file2);
                    long j = qgVar.qg[i2];
                    long jL = this.qg.l(file2);
                    qgVar.qg[i2] = jL;
                    this.um = (this.um - j) + jL;
                }
            } else {
                this.qg.delete(file);
            }
        }
        this.x++;
        qgVar.w = null;
        if (qgVar.l | z) {
            qgVar.l = true;
            this.l.qg("CLEAN").rv(32);
            this.l.qg(qgVar.n);
            qgVar.n(this.l);
            this.l.rv(10);
            if (z) {
                long j2 = this.a;
                this.a = 1 + j2;
                qgVar.x = j2;
            }
        } else {
            this.w.remove(qgVar.n);
            this.l.qg("REMOVE").rv(32);
            this.l.qg(qgVar.n);
            this.l.rv(10);
        }
        this.l.flush();
        if (this.um > this.cd || s()) {
            this.py.execute(this.ou);
        }
    }

    public boolean s() {
        int i = this.x;
        return i >= 2000 && i >= this.w.size();
    }

    public boolean n(qg qgVar) throws IOException {
        if (qgVar.w != null) {
            qgVar.w.n();
        }
        for (int i = 0; i < this.q; i++) {
            this.qg.delete(qgVar.s[i]);
            this.um -= qgVar.qg[i];
            qgVar.qg[i] = 0;
        }
        this.x++;
        this.l.qg("REMOVE").rv(32).qg(qgVar.n).rv(10);
        this.w.remove(qgVar.n);
        if (s()) {
            this.py.execute(this.ou);
        }
        return true;
    }

    public synchronized boolean q() {
        return this.tj;
    }

    private synchronized void rv() {
        if (q()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.rv) {
            rv();
            l();
            this.l.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.rv && !this.tj) {
            for (qg qgVar : (qg[]) this.w.values().toArray(new qg[this.w.size()])) {
                if (qgVar.w != null) {
                    qgVar.w.s();
                }
            }
            l();
            this.l.close();
            this.l = null;
            this.tj = true;
            return;
        }
        this.tj = true;
    }

    public void l() throws IOException {
        while (this.um > this.cd) {
            n(this.w.values().iterator().next());
        }
        this.cp = false;
    }

    public void delete() throws IOException {
        close();
        this.qg.w(this.s);
    }

    private void qg(String str) {
        if (!n.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1223, 1366})
    public final class s implements Closeable {
        public final /* synthetic */ q n;
        public final um[] q;
        public final String qg;
        public final long s;

        public n n() throws IOException {
            return this.n.n(this.qg, this.s);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (um umVar : this.q) {
                com.byazt.zho.s.n(umVar);
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1223, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public final class n {
        public final qg n;
        public boolean q;
        public final boolean[] qg;

        public n(qg qgVar) {
            this.n = qgVar;
            this.qg = qgVar.l ? null : new boolean[q.this.q];
        }

        public void n() {
            if (this.n.w == this) {
                for (int i = 0; i < q.this.q; i++) {
                    try {
                        q.this.qg.delete(this.n.q[i]);
                    } catch (IOException unused) {
                    }
                }
                this.n.w = null;
            }
        }

        public cd n(int i) {
            synchronized (q.this) {
                if (this.q) {
                    throw new IllegalStateException();
                }
                if (this.n.w != this) {
                    return d.n();
                }
                if (!this.n.l) {
                    this.qg[i] = true;
                }
                try {
                    return new l(q.this.qg.qg(this.n.q[i])) { // from class: com.byazt.ym.q.n.1
                        @Override // com.byazt.ym.l
                        public void n(IOException iOException) {
                            synchronized (q.this) {
                                n.this.n();
                            }
                        }
                    };
                } catch (FileNotFoundException unused) {
                    return d.n();
                }
            }
        }

        public void qg() throws IOException {
            synchronized (q.this) {
                if (this.q) {
                    throw new IllegalStateException();
                }
                if (this.n.w == this) {
                    q.this.n(this, true);
                }
                this.q = true;
            }
        }

        public void s() throws IOException {
            synchronized (q.this) {
                if (this.q) {
                    throw new IllegalStateException();
                }
                if (this.n.w == this) {
                    q.this.n(this, false);
                }
                this.q = true;
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1223, 524})
    private final class qg {
        public boolean l;
        public final String n;
        public final File[] q;
        public final long[] qg;
        public final File[] s;
        public n w;
        public long x;

        public qg(String str) {
            this.n = str;
            this.qg = new long[q.this.q];
            this.s = new File[q.this.q];
            this.q = new File[q.this.q];
            StringBuilder sbAppend = new StringBuilder(str).append('.');
            int length = sbAppend.length();
            for (int i = 0; i < q.this.q; i++) {
                sbAppend.append(i);
                this.s[i] = new File(q.this.s, sbAppend.toString());
                sbAppend.append(".tmp");
                this.q[i] = new File(q.this.s, sbAppend.toString());
                sbAppend.setLength(length);
            }
        }

        public void n(String[] strArr) throws IOException {
            if (strArr.length != q.this.q) {
                throw qg(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.qg[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw qg(strArr);
                }
            }
        }

        public void n(com.byazt.wa.q qVar) throws IOException {
            for (long j : this.qg) {
                qVar.rv(32).d(j);
            }
        }

        private IOException qg(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }
}
