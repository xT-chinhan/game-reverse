package com.bytedance.sdk.component.ah.xr.ms.ka;

import android.os.SystemClock;
import androidx.core.internal.view.SupportMenu;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class ab implements Closeable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final ExecutorService f1073ms = new com.bytedance.sdk.component.ch.d.d(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.ah.xr.ms.ah.ms("OkHttp Http2Connection", true));
    static final /* synthetic */ boolean y = true;
    int ab;
    final xr ah;
    final ch ao;
    private int b;
    int c;
    final ah h;
    long hi;
    final String ka;
    private Map<Integer, sl> nw;
    final zb ny;
    final Set<Integer> qv;
    private final ExecutorService t;
    boolean u;
    final Socket ub;
    boolean x;
    final boolean xr;
    final u zb;
    final Map<Integer, ny> d = new LinkedHashMap();
    long ch = 0;
    u sl = new u();

    public static abstract class xr {
        public static final xr c = new xr() { // from class: com.bytedance.sdk.component.ah.xr.ms.ka.ab.xr.1
            @Override // com.bytedance.sdk.component.ah.xr.ms.ka.ab.xr
            public void ms(ny nyVar) throws IOException {
                nyVar.ms(com.bytedance.sdk.component.ah.xr.ms.ka.xr.REFUSED_STREAM);
            }
        };

        public void ms(ab abVar) {
        }

        public abstract void ms(ny nyVar) throws IOException;
    }

    boolean d(int i) {
        return i != 0 && (i & 1) == 0;
    }

    ab(ms msVar) {
        u uVar = new u();
        this.zb = uVar;
        this.u = false;
        this.qv = new LinkedHashSet();
        this.ny = msVar.c;
        boolean z = msVar.ab;
        this.xr = z;
        this.ah = msVar.ka;
        this.ab = msVar.ab ? 1 : 2;
        if (msVar.ab) {
            this.ab += 2;
        }
        this.b = msVar.ab ? 1 : 2;
        if (msVar.ab) {
            this.sl.ms(7, 16777216);
        }
        String str = msVar.xr;
        this.ka = str;
        this.t = new com.bytedance.sdk.component.ch.d.d(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.component.ah.xr.ms.ah.ms(com.bytedance.sdk.component.ah.xr.ms.ah.ms("OkHttp %s Push Observer", str), true));
        uVar.ms(7, SupportMenu.USER_MASK);
        uVar.ms(5, 16384);
        this.hi = uVar.d();
        this.ub = msVar.f1085ms;
        this.ao = new ch(msVar.d, z);
        this.h = new ah(new x(msVar.ah, z));
    }

    synchronized ny ms(int i) {
        return this.d.get(Integer.valueOf(i));
    }

    synchronized ny xr(int i) {
        ny nyVarRemove;
        nyVarRemove = this.d.remove(Integer.valueOf(i));
        notifyAll();
        return nyVarRemove;
    }

    public synchronized int ms() {
        return this.zb.ah(Integer.MAX_VALUE);
    }

    public ny ms(List<com.bytedance.sdk.component.ah.xr.ms.ka.ah> list, boolean z) throws IOException {
        return xr(0, list, z);
    }

    private ny xr(int i, List<com.bytedance.sdk.component.ah.xr.ms.ka.ah> list, boolean z) throws IOException {
        int i2;
        ny nyVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.ao) {
            synchronized (this) {
                if (this.x) {
                    throw new com.bytedance.sdk.component.ah.xr.ms.ka.ms();
                }
                i2 = this.ab;
                this.ab = i2 + 2;
                nyVar = new ny(i2, this, z3, false, list);
                z2 = !z || this.hi == 0 || nyVar.xr == 0;
                if (nyVar.xr()) {
                    this.d.put(Integer.valueOf(i2), nyVar);
                }
            }
            if (i == 0) {
                this.ao.ms(z3, i2, i, list);
            } else {
                if (this.xr) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.ao.ms(i, i2, list);
            }
        }
        if (z2) {
            this.ao.xr();
        }
        return nyVar;
    }

    public void ms(int i, boolean z, com.bytedance.sdk.component.ah.ms.ah ahVar, long j) throws IOException {
        long j2;
        int iMin;
        long j3;
        if (j == 0) {
            this.ao.ms(z, i, ahVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        j2 = this.hi;
                        if (j2 <= 0) {
                            if (!this.d.containsKey(Integer.valueOf(i))) {
                                throw new IOException("stream closed");
                            }
                            wait();
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j, j2), this.ao.ah());
                j3 = iMin;
                this.hi -= j3;
            }
            j -= j3;
            this.ao.ms(z && j == 0, i, ahVar, iMin);
        }
    }

    void ms(long j) {
        this.hi += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void ms(final int i, final com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar) {
        try {
            f1073ms.execute(new com.bytedance.sdk.component.ah.xr.ms.xr("OkHttp %s stream %d", new Object[]{this.ka, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.ah.xr.ms.ka.ab.1
                @Override // com.bytedance.sdk.component.ah.xr.ms.xr
                public void ah() {
                    try {
                        ab.this.xr(i, xrVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    void xr(int i, com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar) throws IOException {
        this.ao.ms(i, xrVar);
    }

    void ms(final int i, final long j) {
        try {
            f1073ms.execute(new com.bytedance.sdk.component.ah.xr.ms.xr("OkHttp Window Update %s stream %d", new Object[]{this.ka, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.ah.xr.ms.ka.ab.2
                @Override // com.bytedance.sdk.component.ah.xr.ms.xr
                public void ah() {
                    try {
                        ab.this.ao.ms(i, j);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    void ms(final boolean z, final int i, final int i2, final sl slVar) {
        try {
            f1073ms.execute(new com.bytedance.sdk.component.ah.xr.ms.xr("OkHttp %s ping %08x%08x", new Object[]{this.ka, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.component.ah.xr.ms.ka.ab.3
                @Override // com.bytedance.sdk.component.ah.xr.ms.xr
                public void ah() {
                    try {
                        ab.this.xr(z, i, i2, slVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    void xr(boolean z, int i, int i2, sl slVar) throws IOException {
        synchronized (this.ao) {
            if (slVar != null) {
                slVar.ms();
                this.ao.ms(z, i, i2);
            } else {
                this.ao.ms(z, i, i2);
            }
            throw th;
        }
    }

    synchronized sl ah(int i) {
        Map<Integer, sl> map = this.nw;
        if (map == null) {
            return null;
        }
        return map.remove(Integer.valueOf(i));
    }

    public void xr() throws IOException {
        this.ao.xr();
    }

    public void ms(com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar) throws IOException {
        synchronized (this.ao) {
            synchronized (this) {
                if (this.x) {
                    return;
                }
                this.x = true;
                this.ao.ms(this.c, xrVar, com.bytedance.sdk.component.ah.xr.ms.ah.f1057ms);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ms(com.bytedance.sdk.component.ah.xr.ms.ka.xr.NO_ERROR, com.bytedance.sdk.component.ah.xr.ms.ka.xr.CANCEL);
    }

    void ms(com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar, com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar2) throws IOException {
        ny[] nyVarArr;
        if (!y && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        sl[] slVarArr = null;
        try {
            ms(xrVar);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (this.d.isEmpty()) {
                nyVarArr = null;
            } else {
                nyVarArr = (ny[]) this.d.values().toArray(new ny[this.d.size()]);
                this.d.clear();
            }
            Map<Integer, sl> map = this.nw;
            if (map != null) {
                sl[] slVarArr2 = (sl[]) map.values().toArray(new sl[this.nw.size()]);
                this.nw = null;
                slVarArr = slVarArr2;
            }
        }
        if (nyVarArr != null) {
            for (ny nyVar : nyVarArr) {
                try {
                    nyVar.ms(xrVar2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        if (slVarArr != null) {
            for (sl slVar : slVarArr) {
                slVar.ah();
            }
        }
        try {
            this.ao.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.ub.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    public void ah() throws IOException {
        ms(true);
    }

    void ms(boolean z) throws IOException {
        if (z) {
            this.ao.ms();
            this.ao.xr(this.sl);
            int iD = this.sl.d();
            if (iD != 65535) {
                this.ao.ms(0, iD - SupportMenu.USER_MASK);
            }
        }
        com.bytedance.sdk.component.ch.d.ah ahVar = new com.bytedance.sdk.component.ch.d.ah(this.h, "Http2Connection");
        ahVar.setName("csj_http2_connection" + SystemClock.uptimeMillis());
        ahVar.start();
    }

    public synchronized boolean d() {
        return this.x;
    }

    public static class ms {
        boolean ab;
        com.bytedance.sdk.component.ah.ms.ka ah;
        com.bytedance.sdk.component.ah.ms.d d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        Socket f1085ms;
        String xr;
        xr ka = xr.c;
        zb c = zb.f1105ms;

        public ms(boolean z) {
            this.ab = z;
        }

        public ms ms(Socket socket, String str, com.bytedance.sdk.component.ah.ms.ka kaVar, com.bytedance.sdk.component.ah.ms.d dVar) {
            this.f1085ms = socket;
            this.xr = str;
            this.ah = kaVar;
            this.d = dVar;
            return this;
        }

        public ms ms(xr xrVar) {
            this.ka = xrVar;
            return this;
        }

        public ab ms() {
            return new ab(this);
        }
    }

    class ah extends com.bytedance.sdk.component.ah.xr.ms.xr implements x.xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final x f1081ms;

        ah(x xVar) {
            super("OkHttp %s", ab.this.ka);
            this.f1081ms = xVar;
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.xr
        protected void ah() {
            ab abVar;
            com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar = com.bytedance.sdk.component.ah.xr.ms.ka.xr.INTERNAL_ERROR;
            com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar2 = com.bytedance.sdk.component.ah.xr.ms.ka.xr.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.f1081ms.ms(this);
                        while (this.f1081ms.ms(false, (x.xr) this)) {
                        }
                        xrVar = com.bytedance.sdk.component.ah.xr.ms.ka.xr.NO_ERROR;
                        xrVar2 = com.bytedance.sdk.component.ah.xr.ms.ka.xr.CANCEL;
                        abVar = ab.this;
                    } catch (Throwable th) {
                        try {
                            ab.this.ms(xrVar, xrVar2);
                        } catch (Exception unused) {
                        }
                        com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.f1081ms);
                        throw th;
                    }
                } catch (IOException unused2) {
                    xrVar = com.bytedance.sdk.component.ah.xr.ms.ka.xr.PROTOCOL_ERROR;
                    xrVar2 = com.bytedance.sdk.component.ah.xr.ms.ka.xr.PROTOCOL_ERROR;
                    abVar = ab.this;
                } catch (NullPointerException unused3) {
                    xrVar2 = com.bytedance.sdk.component.ah.xr.ms.ka.xr.PROTOCOL_ERROR;
                    xrVar = com.bytedance.sdk.component.ah.xr.ms.ka.xr.PROTOCOL_ERROR;
                    abVar = ab.this;
                }
                abVar.ms(xrVar, xrVar2);
            } catch (Exception unused4) {
            }
            com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.f1081ms);
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.ka.x.xr
        public void ms(boolean z, int i, com.bytedance.sdk.component.ah.ms.ka kaVar, int i2) throws IOException {
            if (ab.this.d(i)) {
                ab.this.ms(i, kaVar, i2, z);
                return;
            }
            ny nyVarMs = ab.this.ms(i);
            if (nyVarMs == null) {
                ab.this.ms(i, com.bytedance.sdk.component.ah.xr.ms.ka.xr.PROTOCOL_ERROR);
                kaVar.x(i2);
            } else {
                nyVarMs.ms(kaVar, i2);
                if (z) {
                    nyVarMs.ny();
                }
            }
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.ka.x.xr
        public void ms(boolean z, int i, int i2, List<com.bytedance.sdk.component.ah.xr.ms.ka.ah> list) {
            if (ab.this.d(i)) {
                ab.this.ms(i, list, z);
                return;
            }
            synchronized (ab.this) {
                ny nyVarMs = ab.this.ms(i);
                if (nyVarMs == null) {
                    if (ab.this.x) {
                        return;
                    }
                    if (i <= ab.this.c) {
                        return;
                    }
                    if (i % 2 == ab.this.ab % 2) {
                        return;
                    }
                    final ny nyVar = new ny(i, ab.this, false, z, list);
                    ab.this.c = i;
                    ab.this.d.put(Integer.valueOf(i), nyVar);
                    try {
                        ab.f1073ms.execute(new com.bytedance.sdk.component.ah.xr.ms.xr("OkHttp %s stream %d", new Object[]{ab.this.ka, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.ah.xr.ms.ka.ab.ah.1
                            @Override // com.bytedance.sdk.component.ah.xr.ms.xr
                            public void ah() {
                                try {
                                    ab.this.ah.ms(nyVar);
                                } catch (IOException e) {
                                    com.bytedance.sdk.component.ah.xr.ms.ab.ka.xr().ms(4, "Http2Connection.Listener failure for " + ab.this.ka, e);
                                    try {
                                        nyVar.ms(com.bytedance.sdk.component.ah.xr.ms.ka.xr.PROTOCOL_ERROR);
                                    } catch (IOException unused) {
                                    }
                                }
                            }
                        });
                    } catch (Throwable unused) {
                    }
                    return;
                }
                nyVarMs.ms(list);
                if (z) {
                    nyVarMs.ny();
                }
            }
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.ka.x.xr
        public void ms(int i, com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar) {
            if (ab.this.d(i)) {
                ab.this.ah(i, xrVar);
                return;
            }
            ny nyVarXr = ab.this.xr(i);
            if (nyVarXr != null) {
                nyVarXr.ah(xrVar);
            }
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.ka.x.xr
        public void ms(boolean z, u uVar) {
            ny[] nyVarArr;
            long j;
            int i;
            synchronized (ab.this) {
                int iD = ab.this.zb.d();
                if (z) {
                    ab.this.zb.ms();
                }
                ab.this.zb.ms(uVar);
                ms(uVar);
                int iD2 = ab.this.zb.d();
                nyVarArr = null;
                if (iD2 == -1 || iD2 == iD) {
                    j = 0;
                } else {
                    j = iD2 - iD;
                    if (!ab.this.u) {
                        ab.this.ms(j);
                        ab.this.u = true;
                    }
                    if (!ab.this.d.isEmpty()) {
                        nyVarArr = (ny[]) ab.this.d.values().toArray(new ny[ab.this.d.size()]);
                    }
                }
                try {
                    ab.f1073ms.execute(new com.bytedance.sdk.component.ah.xr.ms.xr("OkHttp %s settings", ab.this.ka) { // from class: com.bytedance.sdk.component.ah.xr.ms.ka.ab.ah.2
                        @Override // com.bytedance.sdk.component.ah.xr.ms.xr
                        public void ah() {
                            ab.this.ah.ms(ab.this);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
            if (nyVarArr == null || j == 0) {
                return;
            }
            for (ny nyVar : nyVarArr) {
                synchronized (nyVar) {
                    nyVar.ms(j);
                }
            }
        }

        private void ms(final u uVar) {
            try {
                ab.f1073ms.execute(new com.bytedance.sdk.component.ah.xr.ms.xr("OkHttp %s ACK Settings", new Object[]{ab.this.ka}) { // from class: com.bytedance.sdk.component.ah.xr.ms.ka.ab.ah.3
                    @Override // com.bytedance.sdk.component.ah.xr.ms.xr
                    public void ah() {
                        try {
                            ab.this.ao.ms(uVar);
                        } catch (IOException unused) {
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.ka.x.xr
        public void ms(boolean z, int i, int i2) {
            if (z) {
                sl slVarAh = ab.this.ah(i);
                if (slVarAh != null) {
                    slVarAh.xr();
                    return;
                }
                return;
            }
            ab.this.ms(true, i, i2, (sl) null);
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.ka.x.xr
        public void ms(int i, com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar, com.bytedance.sdk.component.ah.ms.c cVar) {
            ny[] nyVarArr;
            synchronized (ab.this) {
                nyVarArr = (ny[]) ab.this.d.values().toArray(new ny[ab.this.d.size()]);
                ab.this.x = true;
            }
            for (ny nyVar : nyVarArr) {
                if (nyVar.ms() > i && nyVar.ah()) {
                    nyVar.ah(com.bytedance.sdk.component.ah.xr.ms.ka.xr.REFUSED_STREAM);
                    ab.this.xr(nyVar.ms());
                }
            }
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.ka.x.xr
        public void ms(int i, long j) {
            if (i == 0) {
                synchronized (ab.this) {
                    ab.this.hi += j;
                    ab.this.notifyAll();
                }
                return;
            }
            ny nyVarMs = ab.this.ms(i);
            if (nyVarMs != null) {
                synchronized (nyVarMs) {
                    nyVarMs.ms(j);
                }
            }
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.ka.x.xr
        public void ms(int i, int i2, List<com.bytedance.sdk.component.ah.xr.ms.ka.ah> list) {
            ab.this.ms(i2, list);
        }
    }

    void ms(final int i, final List<com.bytedance.sdk.component.ah.xr.ms.ka.ah> list) {
        synchronized (this) {
            if (this.qv.contains(Integer.valueOf(i))) {
                ms(i, com.bytedance.sdk.component.ah.xr.ms.ka.xr.PROTOCOL_ERROR);
            } else {
                this.qv.add(Integer.valueOf(i));
                this.t.execute(new com.bytedance.sdk.component.ah.xr.ms.xr("OkHttp %s Push Request[%s]", new Object[]{this.ka, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.ah.xr.ms.ka.ab.4
                    @Override // com.bytedance.sdk.component.ah.xr.ms.xr
                    public void ah() {
                        if (ab.this.ny.ms(i, list)) {
                            try {
                                ab.this.ao.ms(i, com.bytedance.sdk.component.ah.xr.ms.ka.xr.CANCEL);
                                synchronized (ab.this) {
                                    try {
                                        ab.this.qv.remove(Integer.valueOf(i));
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    void ms(final int i, final List<com.bytedance.sdk.component.ah.xr.ms.ka.ah> list, final boolean z) {
        this.t.execute(new com.bytedance.sdk.component.ah.xr.ms.xr("OkHttp %s Push Headers[%s]", new Object[]{this.ka, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.ah.xr.ms.ka.ab.5
            @Override // com.bytedance.sdk.component.ah.xr.ms.xr
            public void ah() {
                boolean zMs = ab.this.ny.ms(i, list, z);
                if (zMs) {
                    try {
                        ab.this.ao.ms(i, com.bytedance.sdk.component.ah.xr.ms.ka.xr.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (!zMs && !z) {
                    return;
                }
                synchronized (ab.this) {
                    ab.this.qv.remove(Integer.valueOf(i));
                }
            }
        });
    }

    void ms(final int i, com.bytedance.sdk.component.ah.ms.ka kaVar, final int i2, final boolean z) throws IOException {
        final com.bytedance.sdk.component.ah.ms.ah ahVar = new com.bytedance.sdk.component.ah.ms.ah();
        long j = i2;
        kaVar.ms(j);
        kaVar.ms(ahVar, j);
        if (ahVar.xr() != j) {
            throw new IOException(ahVar.xr() + " != " + i2);
        }
        this.t.execute(new com.bytedance.sdk.component.ah.xr.ms.xr("OkHttp %s Push Data[%s]", new Object[]{this.ka, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.ah.xr.ms.ka.ab.6
            @Override // com.bytedance.sdk.component.ah.xr.ms.xr
            public void ah() {
                try {
                    boolean zMs = ab.this.ny.ms(i, ahVar, i2, z);
                    if (zMs) {
                        ab.this.ao.ms(i, com.bytedance.sdk.component.ah.xr.ms.ka.xr.CANCEL);
                    }
                    if (!zMs && !z) {
                        return;
                    }
                    synchronized (ab.this) {
                        ab.this.qv.remove(Integer.valueOf(i));
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    void ah(final int i, final com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar) {
        this.t.execute(new com.bytedance.sdk.component.ah.xr.ms.xr("OkHttp %s Push Reset[%s]", new Object[]{this.ka, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.ah.xr.ms.ka.ab.7
            @Override // com.bytedance.sdk.component.ah.xr.ms.xr
            public void ah() {
                synchronized (ab.this) {
                    ab.this.qv.remove(Integer.valueOf(i));
                }
            }
        });
    }
}
