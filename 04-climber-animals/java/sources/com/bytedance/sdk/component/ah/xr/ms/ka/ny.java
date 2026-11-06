package com.bytedance.sdk.component.ah.xr.ms.ka;

import com.bytedance.sdk.component.ah.ms.qv;
import com.bytedance.sdk.component.ah.ms.t;
import com.bytedance.sdk.component.ah.ms.y;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ny {
    static final /* synthetic */ boolean ny = true;
    final int ah;
    private final List<com.bytedance.sdk.component.ah.xr.ms.ka.ah> ch;
    final ab d;
    private List<com.bytedance.sdk.component.ah.xr.ms.ka.ah> hi;
    final ms ka;
    private boolean sl;
    long xr;
    private final xr zb;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    long f1096ms = 0;
    final ah c = new ah();
    final ah ab = new ah();
    com.bytedance.sdk.component.ah.xr.ms.ka.xr x = null;

    ny(int i, ab abVar, boolean z, boolean z2, List<com.bytedance.sdk.component.ah.xr.ms.ka.ah> list) {
        if (abVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.ah = i;
        this.d = abVar;
        this.xr = abVar.zb.d();
        xr xrVar = new xr(abVar.sl.d());
        this.zb = xrVar;
        ms msVar = new ms();
        this.ka = msVar;
        xrVar.xr = z2;
        msVar.xr = z;
        this.ch = list;
    }

    public int ms() {
        return this.ah;
    }

    public synchronized boolean xr() {
        if (this.x != null) {
            return false;
        }
        return ((this.zb.xr || this.zb.f1098ms) && (this.ka.xr || this.ka.f1097ms) && this.sl) ? false : true;
    }

    public boolean ah() {
        return this.d.xr == ((this.ah & 1) == 1);
    }

    public synchronized List<com.bytedance.sdk.component.ah.xr.ms.ka.ah> d() throws IOException {
        List<com.bytedance.sdk.component.ah.xr.ms.ka.ah> list;
        if (!ah()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.c.ms();
        while (this.hi == null && this.x == null) {
            try {
                sl();
            } catch (Throwable th) {
                this.c.x();
                throw th;
            }
        }
        this.c.x();
        list = this.hi;
        if (list != null) {
            this.hi = null;
        } else {
            throw new ub(this.x);
        }
        return list;
    }

    public t ka() {
        return this.c;
    }

    public t c() {
        return this.ab;
    }

    public y ab() {
        return this.zb;
    }

    public qv x() {
        synchronized (this) {
            if (!this.sl && !ah()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.ka;
    }

    public void ms(com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar) throws IOException {
        if (d(xrVar)) {
            this.d.xr(this.ah, xrVar);
        }
    }

    public void xr(com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar) {
        if (d(xrVar)) {
            this.d.ms(this.ah, xrVar);
        }
    }

    private boolean d(com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar) {
        if (!ny && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.x != null) {
                return false;
            }
            if (this.zb.xr && this.ka.xr) {
                return false;
            }
            this.x = xrVar;
            notifyAll();
            this.d.xr(this.ah);
            return true;
        }
    }

    void ms(List<com.bytedance.sdk.component.ah.xr.ms.ka.ah> list) {
        boolean zXr;
        if (!ny && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            zXr = true;
            this.sl = true;
            if (this.hi == null) {
                this.hi = list;
                zXr = xr();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.hi);
                arrayList.add(null);
                arrayList.addAll(list);
                this.hi = arrayList;
            }
        }
        if (zXr) {
            return;
        }
        this.d.xr(this.ah);
    }

    void ms(com.bytedance.sdk.component.ah.ms.ka kaVar, int i) throws IOException {
        if (!ny && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.zb.ms(kaVar, i);
    }

    void ny() {
        boolean zXr;
        if (!ny && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.zb.xr = true;
            zXr = xr();
            notifyAll();
        }
        if (zXr) {
            return;
        }
        this.d.xr(this.ah);
    }

    synchronized void ah(com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar) {
        if (this.x == null) {
            this.x = xrVar;
            notifyAll();
        }
    }

    private final class xr implements y {
        static final /* synthetic */ boolean ah = true;
        private final long ab;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        boolean f1098ms;
        boolean xr;
        private final com.bytedance.sdk.component.ah.ms.ah ka = new com.bytedance.sdk.component.ah.ms.ah();
        private final com.bytedance.sdk.component.ah.ms.ah c = new com.bytedance.sdk.component.ah.ms.ah();

        xr(long j) {
            this.ab = j;
        }

        @Override // com.bytedance.sdk.component.ah.ms.y
        public long ms(com.bytedance.sdk.component.ah.ms.ah ahVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            synchronized (ny.this) {
                xr();
                ah();
                if (this.c.xr() == 0) {
                    return -1L;
                }
                com.bytedance.sdk.component.ah.ms.ah ahVar2 = this.c;
                long jMs = ahVar2.ms(ahVar, Math.min(j, ahVar2.xr()));
                ny.this.f1096ms += jMs;
                if (ny.this.f1096ms >= ny.this.d.sl.d() / 2) {
                    ny.this.d.ms(ny.this.ah, ny.this.f1096ms);
                    ny.this.f1096ms = 0L;
                }
                synchronized (ny.this.d) {
                    ny.this.d.ch += jMs;
                    if (ny.this.d.ch >= ny.this.d.sl.d() / 2) {
                        ny.this.d.ms(0, ny.this.d.ch);
                        ny.this.d.ch = 0L;
                    }
                }
                return jMs;
            }
        }

        private void xr() throws IOException {
            ny.this.c.ms();
            while (this.c.xr() == 0 && !this.xr && !this.f1098ms && ny.this.x == null) {
                try {
                    ny.this.sl();
                } catch (Throwable th) {
                    ny.this.c.x();
                    throw th;
                }
            }
            ny.this.c.x();
        }

        void ms(com.bytedance.sdk.component.ah.ms.ka kaVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (!ah && Thread.holdsLock(ny.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (ny.this) {
                    z = this.xr;
                    z2 = true;
                    z3 = this.c.xr() + j > this.ab;
                }
                if (z3) {
                    kaVar.x(j);
                    ny.this.xr(com.bytedance.sdk.component.ah.xr.ms.ka.xr.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    kaVar.x(j);
                    return;
                }
                long jMs = kaVar.ms(this.ka, j);
                if (jMs == -1) {
                    throw new EOFException();
                }
                j -= jMs;
                synchronized (ny.this) {
                    if (this.c.xr() != 0) {
                        z2 = false;
                    }
                    this.c.ms(this.ka);
                    if (z2) {
                        ny.this.notifyAll();
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.component.ah.ms.y
        public t ms() {
            return ny.this.c;
        }

        @Override // com.bytedance.sdk.component.ah.ms.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (ny.this) {
                this.f1098ms = true;
                this.c.qv();
                ny.this.notifyAll();
            }
            ny.this.ch();
        }

        private void ah() throws IOException {
            if (this.f1098ms) {
                throw new IOException("stream closed");
            }
            if (ny.this.x != null) {
                throw new ub(ny.this.x);
            }
        }
    }

    void ch() throws IOException {
        boolean z;
        boolean zXr;
        if (!ny && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.zb.xr && this.zb.f1098ms && (this.ka.xr || this.ka.f1097ms);
            zXr = xr();
        }
        if (z) {
            ms(com.bytedance.sdk.component.ah.xr.ms.ka.xr.CANCEL);
        } else {
            if (zXr) {
                return;
            }
            this.d.xr(this.ah);
        }
    }

    final class ms implements qv {
        static final /* synthetic */ boolean ah = true;
        private final com.bytedance.sdk.component.ah.ms.ah ka = new com.bytedance.sdk.component.ah.ms.ah();

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        boolean f1097ms;
        boolean xr;

        ms() {
        }

        @Override // com.bytedance.sdk.component.ah.ms.qv
        public void a_(com.bytedance.sdk.component.ah.ms.ah ahVar, long j) throws IOException {
            if (!ah && Thread.holdsLock(ny.this)) {
                throw new AssertionError();
            }
            this.ka.a_(ahVar, j);
            while (this.ka.xr() >= 16384) {
                ms(false);
            }
        }

        private void ms(boolean z) throws IOException {
            long jMin;
            synchronized (ny.this) {
                ny.this.ab.ms();
                while (ny.this.xr <= 0 && !this.xr && !this.f1097ms && ny.this.x == null) {
                    try {
                        ny.this.sl();
                    } catch (Throwable th) {
                        ny.this.ab.x();
                        throw th;
                    }
                }
                ny.this.ab.x();
                ny.this.hi();
                jMin = Math.min(ny.this.xr, this.ka.xr());
                ny.this.xr -= jMin;
            }
            ny.this.ab.ms();
            try {
                ny.this.d.ms(ny.this.ah, z && jMin == this.ka.xr(), this.ka, jMin);
            } finally {
                ny.this.ab.x();
            }
        }

        @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Flushable
        public void flush() throws IOException {
            if (!ah && Thread.holdsLock(ny.this)) {
                throw new AssertionError();
            }
            synchronized (ny.this) {
                ny.this.hi();
            }
            while (this.ka.xr() > 0) {
                ms(false);
                ny.this.d.xr();
            }
        }

        @Override // com.bytedance.sdk.component.ah.ms.qv
        public t ms() {
            return ny.this.ab;
        }

        @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!ah && Thread.holdsLock(ny.this)) {
                throw new AssertionError();
            }
            synchronized (ny.this) {
                if (this.f1097ms) {
                    return;
                }
                if (!ny.this.ka.xr) {
                    if (this.ka.xr() > 0) {
                        while (this.ka.xr() > 0) {
                            ms(true);
                        }
                    } else {
                        ny.this.d.ms(ny.this.ah, true, (com.bytedance.sdk.component.ah.ms.ah) null, 0L);
                    }
                }
                synchronized (ny.this) {
                    this.f1097ms = true;
                }
                ny.this.d.xr();
                ny.this.ch();
            }
        }
    }

    void ms(long j) {
        this.xr += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void hi() throws IOException {
        if (this.ka.f1097ms) {
            throw new IOException("stream closed");
        }
        if (this.ka.xr) {
            throw new IOException("stream finished");
        }
        if (this.x != null) {
            throw new ub(this.x);
        }
    }

    void sl() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    class ah extends com.bytedance.sdk.component.ah.ms.ms {
        ah() {
        }

        @Override // com.bytedance.sdk.component.ah.ms.ms
        protected void e_() {
            ny.this.xr(com.bytedance.sdk.component.ah.xr.ms.ka.xr.CANCEL);
        }

        @Override // com.bytedance.sdk.component.ah.ms.ms
        protected IOException xr(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void x() throws IOException {
            if (xr()) {
                throw xr((IOException) null);
            }
        }
    }
}
