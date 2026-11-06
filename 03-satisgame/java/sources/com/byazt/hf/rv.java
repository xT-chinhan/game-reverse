package com.byazt.hf;

import com.anythink.china.a.c;
import com.byazt.wa.a;
import com.byazt.wa.cd;
import com.byazt.wa.um;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 938, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public final class rv {
    public static final /* synthetic */ boolean rv = true;
    public List<com.byazt.hf.s> cp;
    public boolean d;
    public final n l;
    public final qg oa;
    public final x q;
    public long qg;
    public final int s;
    public final List<com.byazt.hf.s> tj;
    public long n = 0;
    public final s w = new s();
    public final s x = new s();
    public com.byazt.hf.qg fs = null;

    public rv(int i, x xVar, boolean z, boolean z2, List<com.byazt.hf.s> list) {
        if (xVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.s = i;
        this.q = xVar;
        this.qg = xVar.oa.q();
        qg qgVar = new qg(xVar.d.q());
        this.oa = qgVar;
        n nVar = new n();
        this.l = nVar;
        qgVar.qg = z2;
        nVar.qg = z;
        this.tj = list;
    }

    public int n() {
        return this.s;
    }

    public synchronized boolean qg() {
        if (this.fs != null) {
            return false;
        }
        return ((this.oa.qg || this.oa.n) && (this.l.qg || this.l.n) && this.d) ? false : true;
    }

    public boolean s() {
        return this.q.qg == ((this.s & 1) == 1);
    }

    public synchronized List<com.byazt.hf.s> q() throws IOException {
        List<com.byazt.hf.s> list;
        if (!s()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.w.n();
        while (this.cp == null && this.fs == null) {
            try {
                d();
            } catch (Throwable th) {
                this.w.fs();
                throw th;
            }
        }
        this.w.fs();
        list = this.cp;
        if (list != null) {
            this.cp = null;
        } else {
            throw new k(this.fs);
        }
        return list;
    }

    public a l() {
        return this.w;
    }

    public a w() {
        return this.x;
    }

    public um x() {
        return this.oa;
    }

    public cd fs() {
        synchronized (this) {
            if (!this.d && !s()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.l;
    }

    public void n(com.byazt.hf.qg qgVar) throws IOException {
        if (q(qgVar)) {
            this.q.qg(this.s, qgVar);
        }
    }

    public void qg(com.byazt.hf.qg qgVar) {
        if (q(qgVar)) {
            this.q.n(this.s, qgVar);
        }
    }

    private boolean q(com.byazt.hf.qg qgVar) {
        if (!rv && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.fs != null) {
                return false;
            }
            if (this.oa.qg && this.l.qg) {
                return false;
            }
            this.fs = qgVar;
            notifyAll();
            this.q.qg(this.s);
            return true;
        }
    }

    public void n(List<com.byazt.hf.s> list) {
        boolean zQg;
        if (!rv && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            zQg = true;
            this.d = true;
            if (this.cp == null) {
                this.cp = list;
                zQg = qg();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.cp);
                arrayList.add(null);
                arrayList.addAll(list);
                this.cp = arrayList;
            }
        }
        if (zQg) {
            return;
        }
        this.q.qg(this.s);
    }

    public void n(com.byazt.wa.l lVar, int i) throws IOException {
        if (!rv && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.oa.n(lVar, i);
    }

    public void rv() {
        boolean zQg;
        if (!rv && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.oa.qg = true;
            zQg = qg();
            notifyAll();
        }
        if (zQg) {
            return;
        }
        this.q.qg(this.s);
    }

    public synchronized void s(com.byazt.hf.qg qgVar) {
        if (this.fs == null) {
            this.fs = qgVar;
            notifyAll();
        }
    }

    @com.byazt.cp.n(n = {0, 1, 938, 529})
    private final class qg implements um {
        public static final /* synthetic */ boolean s = true;
        public boolean n;
        public boolean qg;
        public final long x;
        public final com.byazt.wa.s l = new com.byazt.wa.s();
        public final com.byazt.wa.s w = new com.byazt.wa.s();

        public qg(long j) {
            this.x = j;
        }

        @Override // com.byazt.wa.um
        public long n(com.byazt.wa.s sVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            synchronized (rv.this) {
                qg();
                s();
                if (this.w.qg() == 0) {
                    return -1L;
                }
                com.byazt.wa.s sVar2 = this.w;
                long jN = sVar2.n(sVar, Math.min(j, sVar2.qg()));
                rv.this.n += jN;
                if (rv.this.n >= rv.this.q.d.q() / 2) {
                    rv.this.q.n(rv.this.s, rv.this.n);
                    rv.this.n = 0L;
                }
                synchronized (rv.this.q) {
                    rv.this.q.tj += jN;
                    if (rv.this.q.tj >= rv.this.q.d.q() / 2) {
                        rv.this.q.n(0, rv.this.q.tj);
                        rv.this.q.tj = 0L;
                    }
                }
                return jN;
            }
        }

        private void qg() throws IOException {
            rv.this.w.n();
            while (this.w.qg() == 0 && !this.qg && !this.n && rv.this.fs == null) {
                try {
                    rv.this.d();
                } catch (Throwable th) {
                    rv.this.w.fs();
                    throw th;
                }
            }
            rv.this.w.fs();
        }

        public void n(com.byazt.wa.l lVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (!s && Thread.holdsLock(rv.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (rv.this) {
                    z = this.qg;
                    z2 = true;
                    z3 = this.w.qg() + j > this.x;
                }
                if (z3) {
                    lVar.fs(j);
                    rv.this.qg(com.byazt.hf.qg.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    lVar.fs(j);
                    return;
                }
                long jN = lVar.n(this.l, j);
                if (jN == -1) {
                    throw new EOFException();
                }
                j -= jN;
                synchronized (rv.this) {
                    if (this.w.qg() != 0) {
                        z2 = false;
                    }
                    this.w.n(this.l);
                    if (z2) {
                        rv.this.notifyAll();
                    }
                }
            }
        }

        @Override // com.byazt.wa.um
        public a n() {
            return rv.this.w;
        }

        @Override // com.byazt.wa.um, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (rv.this) {
                this.n = true;
                this.w.cd();
                rv.this.notifyAll();
            }
            rv.this.tj();
        }

        private void s() throws IOException {
            if (this.n) {
                throw new IOException("stream closed");
            }
            if (rv.this.fs != null) {
                throw new k(rv.this.fs);
            }
        }
    }

    public void tj() throws IOException {
        boolean z;
        boolean zQg;
        if (!rv && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.oa.qg && this.oa.n && (this.l.qg || this.l.n);
            zQg = qg();
        }
        if (z) {
            n(com.byazt.hf.qg.CANCEL);
        } else {
            if (zQg) {
                return;
            }
            this.q.qg(this.s);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 938, 160})
    final class n implements cd {
        public static final /* synthetic */ boolean s = true;
        public final com.byazt.wa.s l = new com.byazt.wa.s();
        public boolean n;
        public boolean qg;

        public n() {
        }

        @Override // com.byazt.wa.cd
        public void a_(com.byazt.wa.s sVar, long j) throws IOException {
            if (!s && Thread.holdsLock(rv.this)) {
                throw new AssertionError();
            }
            this.l.a_(sVar, j);
            while (this.l.qg() >= c.o) {
                n(false);
            }
        }

        private void n(boolean z) throws IOException {
            long jMin;
            synchronized (rv.this) {
                rv.this.x.n();
                while (rv.this.qg <= 0 && !this.qg && !this.n && rv.this.fs == null) {
                    try {
                        rv.this.d();
                    } catch (Throwable th) {
                        rv.this.x.fs();
                        throw th;
                    }
                }
                rv.this.x.fs();
                rv.this.cp();
                jMin = Math.min(rv.this.qg, this.l.qg());
                rv.this.qg -= jMin;
            }
            rv.this.x.n();
            try {
                rv.this.q.n(rv.this.s, z && jMin == this.l.qg(), this.l, jMin);
            } finally {
                rv.this.x.fs();
            }
        }

        @Override // com.byazt.wa.cd, java.io.Flushable
        public void flush() throws IOException {
            if (!s && Thread.holdsLock(rv.this)) {
                throw new AssertionError();
            }
            synchronized (rv.this) {
                rv.this.cp();
            }
            while (this.l.qg() > 0) {
                n(false);
                rv.this.q.qg();
            }
        }

        @Override // com.byazt.wa.cd
        public a n() {
            return rv.this.x;
        }

        @Override // com.byazt.wa.cd, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!s && Thread.holdsLock(rv.this)) {
                throw new AssertionError();
            }
            synchronized (rv.this) {
                if (this.n) {
                    return;
                }
                if (!rv.this.l.qg) {
                    if (this.l.qg() > 0) {
                        while (this.l.qg() > 0) {
                            n(true);
                        }
                    } else {
                        rv.this.q.n(rv.this.s, true, (com.byazt.wa.s) null, 0L);
                    }
                }
                synchronized (rv.this) {
                    this.n = true;
                }
                rv.this.q.qg();
                rv.this.tj();
            }
        }
    }

    public void n(long j) {
        this.qg += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void cp() throws IOException {
        if (this.l.n) {
            throw new IOException("stream closed");
        }
        if (this.l.qg) {
            throw new IOException("stream finished");
        }
        if (this.fs != null) {
            throw new k(this.fs);
        }
    }

    public void d() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    @com.byazt.cp.n(n = {0, 1, 938, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPENED_TIME})
    class s extends com.byazt.wa.n {
        public s() {
        }

        @Override // com.byazt.wa.n
        public void m_() {
            rv.this.qg(com.byazt.hf.qg.CANCEL);
        }

        @Override // com.byazt.wa.n
        public IOException qg(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void fs() throws IOException {
            if (qg()) {
                throw qg((IOException) null);
            }
        }
    }
}
