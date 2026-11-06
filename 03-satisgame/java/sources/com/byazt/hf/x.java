package com.byazt.hf;

import android.os.SystemClock;
import androidx.core.internal.view.SupportMenu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 938, 21})
public final class x implements Closeable {
    public static final ExecutorService n = new com.byazt.xis.q(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.byazt.zho.s.n("OkHttp Http2Connection", true));
    public static final /* synthetic */ boolean um = true;
    public final ExecutorService a;
    public final Set<Integer> cd;
    public long cp;
    public final tj cy;
    public boolean fs;
    public final s hd;
    public final Socket k;
    public final String l;
    public final sz oa;
    public int ou;
    public Map<Integer, d> py;
    public final boolean qg;
    public final oa rv;
    public final qg s;
    public boolean sz;
    public int w;
    public int x;
    public final Map<Integer, rv> q = new LinkedHashMap();
    public long tj = 0;
    public sz d = new sz();

    @com.byazt.cp.n(n = {0, 1, 938, 1181})
    public static abstract class qg {
        public static final qg w = new qg() { // from class: com.byazt.hf.x.qg.1
            @Override // com.byazt.hf.x.qg
            public void n(rv rvVar) throws IOException {
                rvVar.n(com.byazt.hf.qg.REFUSED_STREAM);
            }
        };

        public abstract void n(rv rvVar) throws IOException;

        public void n(x xVar) {
        }
    }

    public boolean q(int i) {
        return i != 0 && (i & 1) == 0;
    }

    public x(n nVar) {
        sz szVar = new sz();
        this.oa = szVar;
        this.sz = false;
        this.cd = new LinkedHashSet();
        this.rv = nVar.w;
        boolean z = nVar.x;
        this.qg = z;
        this.s = nVar.l;
        this.x = nVar.x ? 1 : 2;
        if (nVar.x) {
            this.x += 2;
        }
        this.ou = nVar.x ? 1 : 2;
        if (nVar.x) {
            this.d.n(7, 16777216);
        }
        String str = nVar.qg;
        this.l = str;
        this.a = new com.byazt.xis.q(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.byazt.zho.s.n(com.byazt.zho.s.n("OkHttp %s Push Observer", str), true));
        szVar.n(7, SupportMenu.USER_MASK);
        szVar.n(5, 16384);
        this.cp = szVar.q();
        this.k = nVar.n;
        this.cy = new tj(nVar.q, z);
        this.hd = new s(new fs(nVar.s, z));
    }

    public synchronized rv n(int i) {
        return this.q.get(Integer.valueOf(i));
    }

    public synchronized rv qg(int i) {
        rv rvVarRemove;
        rvVarRemove = this.q.remove(Integer.valueOf(i));
        notifyAll();
        return rvVarRemove;
    }

    public synchronized int n() {
        return this.oa.s(Integer.MAX_VALUE);
    }

    public rv n(List<com.byazt.hf.s> list, boolean z) throws IOException {
        return qg(0, list, z);
    }

    private rv qg(int i, List<com.byazt.hf.s> list, boolean z) throws IOException {
        int i2;
        rv rvVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.cy) {
            synchronized (this) {
                if (this.fs) {
                    throw new com.byazt.hf.n();
                }
                i2 = this.x;
                this.x = i2 + 2;
                rvVar = new rv(i2, this, z3, false, list);
                z2 = !z || this.cp == 0 || rvVar.qg == 0;
                if (rvVar.qg()) {
                    this.q.put(Integer.valueOf(i2), rvVar);
                }
            }
            if (i == 0) {
                this.cy.n(z3, i2, i, list);
            } else {
                if (this.qg) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.cy.n(i, i2, list);
            }
        }
        if (z2) {
            this.cy.qg();
        }
        return rvVar;
    }

    public void n(int i, boolean z, com.byazt.wa.s sVar, long j) throws IOException {
        long j2;
        int iMin;
        long j3;
        if (j == 0) {
            this.cy.n(z, i, sVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        j2 = this.cp;
                        if (j2 <= 0) {
                            if (!this.q.containsKey(Integer.valueOf(i))) {
                                throw new IOException("stream closed");
                            }
                            wait();
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j, j2), this.cy.s());
                j3 = iMin;
                this.cp -= j3;
            }
            j -= j3;
            this.cy.n(z && j == 0, i, sVar, iMin);
        }
    }

    public void n(long j) {
        this.cp += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void n(final int i, final com.byazt.hf.qg qgVar) {
        try {
            n.execute(new com.byazt.zho.qg("OkHttp %s stream %d", new Object[]{this.l, Integer.valueOf(i)}) { // from class: com.byazt.hf.x.1
                @Override // com.byazt.zho.qg
                public void w() {
                    try {
                        x.this.qg(i, qgVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void qg(int i, com.byazt.hf.qg qgVar) throws IOException {
        this.cy.n(i, qgVar);
    }

    public void n(final int i, final long j) {
        try {
            n.execute(new com.byazt.zho.qg("OkHttp Window Update %s stream %d", new Object[]{this.l, Integer.valueOf(i)}) { // from class: com.byazt.hf.x.2
                @Override // com.byazt.zho.qg
                public void w() {
                    try {
                        x.this.cy.n(i, j);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void n(final boolean z, final int i, final int i2, final d dVar) {
        try {
            n.execute(new com.byazt.zho.qg("OkHttp %s ping %08x%08x", new Object[]{this.l, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.byazt.hf.x.3
                @Override // com.byazt.zho.qg
                public void w() {
                    try {
                        x.this.qg(z, i, i2, dVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void qg(boolean z, int i, int i2, d dVar) throws IOException {
        synchronized (this.cy) {
            if (dVar != null) {
                dVar.n();
                this.cy.n(z, i, i2);
            } else {
                this.cy.n(z, i, i2);
            }
            throw th;
        }
    }

    public synchronized d s(int i) {
        Map<Integer, d> map = this.py;
        if (map == null) {
            return null;
        }
        return map.remove(Integer.valueOf(i));
    }

    public void qg() throws IOException {
        this.cy.qg();
    }

    public void n(com.byazt.hf.qg qgVar) throws IOException {
        synchronized (this.cy) {
            synchronized (this) {
                if (this.fs) {
                    return;
                }
                this.fs = true;
                this.cy.n(this.w, qgVar, com.byazt.zho.s.n);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        n(com.byazt.hf.qg.NO_ERROR, com.byazt.hf.qg.CANCEL);
    }

    public void n(com.byazt.hf.qg qgVar, com.byazt.hf.qg qgVar2) throws IOException {
        rv[] rvVarArr;
        if (!um && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        d[] dVarArr = null;
        try {
            n(qgVar);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (this.q.isEmpty()) {
                rvVarArr = null;
            } else {
                rvVarArr = (rv[]) this.q.values().toArray(new rv[this.q.size()]);
                this.q.clear();
            }
            Map<Integer, d> map = this.py;
            if (map != null) {
                d[] dVarArr2 = (d[]) map.values().toArray(new d[this.py.size()]);
                this.py = null;
                dVarArr = dVarArr2;
            }
        }
        if (rvVarArr != null) {
            for (rv rvVar : rvVarArr) {
                try {
                    rvVar.n(qgVar2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        if (dVarArr != null) {
            for (d dVar : dVarArr) {
                dVar.s();
            }
        }
        try {
            this.cy.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.k.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    public void s() throws IOException {
        n(true);
    }

    public void n(boolean z) throws IOException {
        if (z) {
            this.cy.n();
            this.cy.qg(this.d);
            int iQ = this.d.q();
            if (iQ != 65535) {
                this.cy.n(0, iQ - SupportMenu.USER_MASK);
            }
        }
        com.byazt.xis.s sVar = new com.byazt.xis.s(this.hd, "Http2Connection");
        sVar.setName("csj_http2_connection" + SystemClock.uptimeMillis());
        sVar.start();
    }

    public synchronized boolean q() {
        return this.fs;
    }

    @com.byazt.cp.n(n = {0, 1, 938, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    public static class n {
        public Socket n;
        public com.byazt.wa.q q;
        public String qg;
        public com.byazt.wa.l s;
        public boolean x;
        public qg l = qg.w;
        public oa w = oa.n;

        public n(boolean z) {
            this.x = z;
        }

        public n n(Socket socket, String str, com.byazt.wa.l lVar, com.byazt.wa.q qVar) {
            this.n = socket;
            this.qg = str;
            this.s = lVar;
            this.q = qVar;
            return this;
        }

        public n n(qg qgVar) {
            this.l = qgVar;
            return this;
        }

        public x n() {
            return new x(this);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 938, 2351})
    class s extends com.byazt.zho.qg implements fs.qg {
        public final fs n;

        public s(fs fsVar) {
            super("OkHttp %s", x.this.l);
            this.n = fsVar;
        }

        @Override // com.byazt.zho.qg
        public void w() {
            x xVar;
            com.byazt.hf.qg qgVar = com.byazt.hf.qg.INTERNAL_ERROR;
            com.byazt.hf.qg qgVar2 = com.byazt.hf.qg.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.n.n(this);
                        while (this.n.n(false, (fs.qg) this)) {
                        }
                        qgVar = com.byazt.hf.qg.NO_ERROR;
                        qgVar2 = com.byazt.hf.qg.CANCEL;
                        xVar = x.this;
                    } catch (Throwable th) {
                        try {
                            x.this.n(qgVar, qgVar2);
                        } catch (Exception unused) {
                        }
                        com.byazt.zho.s.n(this.n);
                        throw th;
                    }
                } catch (IOException unused2) {
                    qgVar = com.byazt.hf.qg.PROTOCOL_ERROR;
                    qgVar2 = com.byazt.hf.qg.PROTOCOL_ERROR;
                    xVar = x.this;
                } catch (NullPointerException unused3) {
                    qgVar2 = com.byazt.hf.qg.PROTOCOL_ERROR;
                    qgVar = com.byazt.hf.qg.PROTOCOL_ERROR;
                    xVar = x.this;
                }
                xVar.n(qgVar, qgVar2);
            } catch (Exception unused4) {
            }
            com.byazt.zho.s.n(this.n);
        }

        @Override // com.byazt.hf.fs.qg
        public void n(boolean z, int i, com.byazt.wa.l lVar, int i2) throws IOException {
            if (x.this.q(i)) {
                x.this.n(i, lVar, i2, z);
                return;
            }
            rv rvVarN = x.this.n(i);
            if (rvVarN == null) {
                x.this.n(i, com.byazt.hf.qg.PROTOCOL_ERROR);
                lVar.fs(i2);
            } else {
                rvVarN.n(lVar, i2);
                if (z) {
                    rvVarN.rv();
                }
            }
        }

        @Override // com.byazt.hf.fs.qg
        public void n(boolean z, int i, int i2, List<com.byazt.hf.s> list) {
            if (x.this.q(i)) {
                x.this.n(i, list, z);
                return;
            }
            synchronized (x.this) {
                rv rvVarN = x.this.n(i);
                if (rvVarN == null) {
                    if (x.this.fs) {
                        return;
                    }
                    if (i <= x.this.w) {
                        return;
                    }
                    if (i % 2 == x.this.x % 2) {
                        return;
                    }
                    final rv rvVar = new rv(i, x.this, false, z, list);
                    x.this.w = i;
                    x.this.q.put(Integer.valueOf(i), rvVar);
                    try {
                        x.n.execute(new com.byazt.zho.qg("OkHttp %s stream %d", new Object[]{x.this.l, Integer.valueOf(i)}) { // from class: com.byazt.hf.x.s.1
                            @Override // com.byazt.zho.qg
                            public void w() {
                                try {
                                    x.this.s.n(rvVar);
                                } catch (IOException e) {
                                    com.byazt.quz.l.qg().n(4, "Http2Connection.Listener failure for " + x.this.l, e);
                                    try {
                                        rvVar.n(com.byazt.hf.qg.PROTOCOL_ERROR);
                                    } catch (IOException unused) {
                                    }
                                }
                            }
                        });
                    } catch (Throwable unused) {
                    }
                    return;
                }
                rvVarN.n(list);
                if (z) {
                    rvVarN.rv();
                }
            }
        }

        @Override // com.byazt.hf.fs.qg
        public void n(int i, com.byazt.hf.qg qgVar) {
            if (x.this.q(i)) {
                x.this.s(i, qgVar);
                return;
            }
            rv rvVarQg = x.this.qg(i);
            if (rvVarQg != null) {
                rvVarQg.s(qgVar);
            }
        }

        @Override // com.byazt.hf.fs.qg
        public void n(boolean z, sz szVar) {
            rv[] rvVarArr;
            long j;
            int i;
            synchronized (x.this) {
                int iQ = x.this.oa.q();
                if (z) {
                    x.this.oa.n();
                }
                x.this.oa.n(szVar);
                n(szVar);
                int iQ2 = x.this.oa.q();
                rvVarArr = null;
                if (iQ2 == -1 || iQ2 == iQ) {
                    j = 0;
                } else {
                    j = iQ2 - iQ;
                    if (!x.this.sz) {
                        x.this.n(j);
                        x.this.sz = true;
                    }
                    if (!x.this.q.isEmpty()) {
                        rvVarArr = (rv[]) x.this.q.values().toArray(new rv[x.this.q.size()]);
                    }
                }
                try {
                    x.n.execute(new com.byazt.zho.qg("OkHttp %s settings", x.this.l) { // from class: com.byazt.hf.x.s.2
                        @Override // com.byazt.zho.qg
                        public void w() {
                            x.this.s.n(x.this);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
            if (rvVarArr == null || j == 0) {
                return;
            }
            for (rv rvVar : rvVarArr) {
                synchronized (rvVar) {
                    rvVar.n(j);
                }
            }
        }

        private void n(final sz szVar) {
            try {
                x.n.execute(new com.byazt.zho.qg("OkHttp %s ACK Settings", new Object[]{x.this.l}) { // from class: com.byazt.hf.x.s.3
                    @Override // com.byazt.zho.qg
                    public void w() {
                        try {
                            x.this.cy.n(szVar);
                        } catch (IOException unused) {
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }

        @Override // com.byazt.hf.fs.qg
        public void n(boolean z, int i, int i2) {
            if (z) {
                d dVarS = x.this.s(i);
                if (dVarS != null) {
                    dVarS.qg();
                    return;
                }
                return;
            }
            x.this.n(true, i, i2, (d) null);
        }

        @Override // com.byazt.hf.fs.qg
        public void n(int i, com.byazt.hf.qg qgVar, com.byazt.wa.w wVar) {
            rv[] rvVarArr;
            synchronized (x.this) {
                rvVarArr = (rv[]) x.this.q.values().toArray(new rv[x.this.q.size()]);
                x.this.fs = true;
            }
            for (rv rvVar : rvVarArr) {
                if (rvVar.n() > i && rvVar.s()) {
                    rvVar.s(com.byazt.hf.qg.REFUSED_STREAM);
                    x.this.qg(rvVar.n());
                }
            }
        }

        @Override // com.byazt.hf.fs.qg
        public void n(int i, long j) {
            if (i == 0) {
                synchronized (x.this) {
                    x.this.cp += j;
                    x.this.notifyAll();
                }
                return;
            }
            rv rvVarN = x.this.n(i);
            if (rvVarN != null) {
                synchronized (rvVarN) {
                    rvVarN.n(j);
                }
            }
        }

        @Override // com.byazt.hf.fs.qg
        public void n(int i, int i2, List<com.byazt.hf.s> list) {
            x.this.n(i2, list);
        }
    }

    public void n(final int i, final List<com.byazt.hf.s> list) {
        synchronized (this) {
            if (this.cd.contains(Integer.valueOf(i))) {
                n(i, com.byazt.hf.qg.PROTOCOL_ERROR);
            } else {
                this.cd.add(Integer.valueOf(i));
                this.a.execute(new com.byazt.zho.qg("OkHttp %s Push Request[%s]", new Object[]{this.l, Integer.valueOf(i)}) { // from class: com.byazt.hf.x.4
                    @Override // com.byazt.zho.qg
                    public void w() {
                        if (x.this.rv.n(i, list)) {
                            try {
                                x.this.cy.n(i, com.byazt.hf.qg.CANCEL);
                                synchronized (x.this) {
                                    try {
                                        x.this.cd.remove(Integer.valueOf(i));
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

    public void n(final int i, final List<com.byazt.hf.s> list, final boolean z) {
        this.a.execute(new com.byazt.zho.qg("OkHttp %s Push Headers[%s]", new Object[]{this.l, Integer.valueOf(i)}) { // from class: com.byazt.hf.x.5
            @Override // com.byazt.zho.qg
            public void w() {
                boolean zN = x.this.rv.n(i, list, z);
                if (zN) {
                    try {
                        x.this.cy.n(i, com.byazt.hf.qg.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (!zN && !z) {
                    return;
                }
                synchronized (x.this) {
                    x.this.cd.remove(Integer.valueOf(i));
                }
            }
        });
    }

    public void n(final int i, com.byazt.wa.l lVar, final int i2, final boolean z) throws IOException {
        final com.byazt.wa.s sVar = new com.byazt.wa.s();
        long j = i2;
        lVar.n(j);
        lVar.n(sVar, j);
        if (sVar.qg() != j) {
            throw new IOException(sVar.qg() + " != " + i2);
        }
        this.a.execute(new com.byazt.zho.qg("OkHttp %s Push Data[%s]", new Object[]{this.l, Integer.valueOf(i)}) { // from class: com.byazt.hf.x.6
            @Override // com.byazt.zho.qg
            public void w() {
                try {
                    boolean zN = x.this.rv.n(i, sVar, i2, z);
                    if (zN) {
                        x.this.cy.n(i, com.byazt.hf.qg.CANCEL);
                    }
                    if (!zN && !z) {
                        return;
                    }
                    synchronized (x.this) {
                        x.this.cd.remove(Integer.valueOf(i));
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    public void s(final int i, final com.byazt.hf.qg qgVar) {
        this.a.execute(new com.byazt.zho.qg("OkHttp %s Push Reset[%s]", new Object[]{this.l, Integer.valueOf(i)}) { // from class: com.byazt.hf.x.7
            @Override // com.byazt.zho.qg
            public void w() {
                synchronized (x.this) {
                    x.this.cd.remove(Integer.valueOf(i));
                }
            }
        });
    }
}
