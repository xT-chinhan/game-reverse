package com.byazt.sqs;

import com.byazt.hf.k;
import com.byazt.pq.a;
import com.byazt.pq.cy;
import com.byazt.pq.lh;
import com.byazt.pq.tj;
import com.byazt.pq.wm;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 707, 21})
public final class x {
    public static final /* synthetic */ boolean q = true;
    public s cp;
    public boolean d;
    public final Object fs;
    public com.byazt.cri.s k;
    public w.n l;
    public final com.byazt.pq.n n;
    public boolean oa;
    public final com.byazt.pq.l qg;
    public final w rv;
    public final cy s;
    public boolean sz;
    public int tj;
    public lh w;
    public final tj x;

    public x(tj tjVar, com.byazt.pq.n nVar, com.byazt.pq.l lVar, cy cyVar, Object obj) throws IOException {
        this.x = tjVar;
        this.n = nVar;
        this.qg = lVar;
        this.s = cyVar;
        this.rv = new w(nVar, fs(), lVar, cyVar);
        this.fs = obj;
    }

    public com.byazt.cri.s n(wm wmVar, a.n nVar, boolean z) {
        try {
            com.byazt.cri.s sVarN = n(nVar.qg(), nVar.s(), nVar.q(), wmVar.cd(), z).n(wmVar, nVar, this);
            synchronized (this.x) {
                this.k = sVarN;
            }
            return sVarN;
        } catch (IOException e) {
            throw new l(e);
        }
    }

    private s n(int i, int i2, int i3, boolean z, boolean z2) throws Throwable {
        while (true) {
            s sVarN = n(i, i2, i3, z);
            synchronized (this.x) {
                if (sVarN.qg == 0) {
                    return sVarN;
                }
                if (sVarN.n(z2)) {
                    return sVarN;
                }
                q();
            }
        }
    }

    private s n(int i, int i2, int i3, boolean z) throws Throwable {
        Socket socketX;
        s sVar;
        Socket socketN;
        lh lhVarQg;
        boolean z2;
        boolean z3;
        w.n nVar;
        synchronized (this.x) {
            if (this.oa) {
                throw new IllegalStateException("released");
            }
            if (this.k != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.sz) {
                throw new IOException("Canceled");
            }
            socketX = x();
            sVar = this.cp;
            socketN = null;
            if (sVar == null) {
                sVar = null;
            }
            if (sVar == null) {
                com.byazt.zho.n.n.n(this.x, this.n, this, null);
                s sVar2 = this.cp;
                if (sVar2 != null) {
                    z2 = true;
                    sVar = sVar2;
                    lhVarQg = null;
                } else {
                    lhVarQg = this.w;
                }
            } else {
                lhVarQg = null;
            }
            z2 = false;
        }
        com.byazt.zho.s.n(socketX);
        if (z2) {
            this.s.n(this.qg, sVar);
        }
        if (sVar != null) {
            return sVar;
        }
        if (lhVarQg != null || ((nVar = this.l) != null && nVar.n())) {
            z3 = false;
        } else {
            this.l = this.rv.qg();
            z3 = true;
        }
        synchronized (this.x) {
            if (this.sz) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<lh> listS = this.l.s();
                int size = listS.size();
                for (int i4 = 0; i4 < size; i4++) {
                    lh lhVar = listS.get(i4);
                    com.byazt.zho.n.n.n(this.x, this.n, this, lhVar);
                    s sVar3 = this.cp;
                    if (sVar3 != null) {
                        this.w = lhVar;
                        z2 = true;
                        sVar = sVar3;
                        break;
                    }
                }
            }
            if (!z2) {
                if (lhVarQg == null) {
                    lhVarQg = this.l.qg();
                }
                this.w = lhVarQg;
                this.tj = 0;
                sVar = new s(this.x, lhVarQg);
                n(sVar, false);
            }
        }
        if (z2) {
            this.s.n(this.qg, sVar);
            return sVar;
        }
        sVar.n(i, i2, i3, z, this.qg, this.s);
        fs().qg(sVar.n());
        synchronized (this.x) {
            this.d = true;
            com.byazt.zho.n.n.qg(this.x, sVar);
            if (sVar.l()) {
                socketN = com.byazt.zho.n.n.n(this.x, this.n, this);
                sVar = this.cp;
            }
        }
        com.byazt.zho.s.n(socketN);
        this.s.n(this.qg, sVar);
        return sVar;
    }

    private Socket x() {
        if (!q && !Thread.holdsLock(this.x)) {
            throw new AssertionError();
        }
        s sVar = this.cp;
        if (sVar == null || !sVar.n) {
            return null;
        }
        return n(false, false, true);
    }

    public void n(boolean z, com.byazt.cri.s sVar, long j, IOException iOException) {
        Socket socketN;
        synchronized (this.x) {
            if (sVar != null) {
                if (sVar == this.k) {
                    if (!z) {
                        this.cp.qg++;
                    }
                    socketN = n(z, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.k + " but was " + sVar);
        }
        com.byazt.zho.s.n(socketN);
        if (iOException != null) {
            this.s.n(this.qg, iOException);
        }
    }

    public com.byazt.cri.s n() {
        com.byazt.cri.s sVar;
        synchronized (this.x) {
            sVar = this.k;
        }
        return sVar;
    }

    private q fs() {
        return com.byazt.zho.n.n.n(this.x);
    }

    public synchronized s qg() {
        return this.cp;
    }

    public void s() {
        Socket socketN;
        synchronized (this.x) {
            socketN = n(false, true, false);
        }
        com.byazt.zho.s.n(socketN);
    }

    public void q() {
        Socket socketN;
        synchronized (this.x) {
            socketN = n(true, false, false);
        }
        com.byazt.zho.s.n(socketN);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    private Socket n(boolean z, boolean z2, boolean z3) {
        Socket socketS;
        if (!q && !Thread.holdsLock(this.x)) {
            throw new AssertionError();
        }
        if (z3) {
            this.k = null;
        }
        if (z2) {
            this.oa = true;
        }
        s sVar = this.cp;
        if (sVar == null) {
            return null;
        }
        if (z) {
            sVar.n = true;
        }
        if (this.k != null) {
            return null;
        }
        if (!this.oa && !this.cp.n) {
            return null;
        }
        qg(this.cp);
        if (this.cp.q.isEmpty()) {
            this.cp.l = System.nanoTime();
            if (com.byazt.zho.n.n.n(this.x, this.cp)) {
                socketS = this.cp.s();
            } else {
                socketS = null;
            }
        } else {
            socketS = null;
        }
        this.cp = null;
        return socketS;
    }

    public void l() {
        com.byazt.cri.s sVar;
        s sVar2;
        synchronized (this.x) {
            this.sz = true;
            sVar = this.k;
            sVar2 = this.cp;
        }
        if (sVar != null) {
            sVar.s();
        } else if (sVar2 != null) {
            sVar2.qg();
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0047  */
    public void n(IOException iOException) {
        boolean z;
        Socket socketN;
        synchronized (this.x) {
            if (iOException instanceof k) {
                k kVar = (k) iOException;
                if (kVar.n == com.byazt.hf.qg.REFUSED_STREAM) {
                    this.tj++;
                }
                if (kVar.n != com.byazt.hf.qg.REFUSED_STREAM || this.tj > 1) {
                    this.w = null;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                s sVar = this.cp;
                if (sVar == null || (sVar.l() && !(iOException instanceof com.byazt.hf.n))) {
                    z = false;
                } else {
                    if (this.cp.qg == 0) {
                        lh lhVar = this.w;
                        if (lhVar != null && iOException != null) {
                            this.rv.n(lhVar, iOException);
                        }
                        this.w = null;
                    }
                    z = true;
                }
            }
            socketN = n(z, false, true);
        }
        com.byazt.zho.s.n(socketN);
    }

    public void n(s sVar, boolean z) {
        if (!q && !Thread.holdsLock(this.x)) {
            throw new AssertionError();
        }
        if (this.cp != null) {
            throw new IllegalStateException();
        }
        this.cp = sVar;
        this.d = z;
        sVar.q.add(new n(this, this.fs));
    }

    private void qg(s sVar) {
        int size = sVar.q.size();
        for (int i = 0; i < size; i++) {
            if (sVar.q.get(i).get() == this) {
                sVar.q.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket n(s sVar) {
        if (!q && !Thread.holdsLock(this.x)) {
            throw new AssertionError();
        }
        if (this.k != null || this.cp.q.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<x> reference = this.cp.q.get(0);
        Socket socketN = n(true, false, false);
        this.cp = sVar;
        sVar.q.add(reference);
        return socketN;
    }

    public boolean w() {
        if (this.w != null) {
            return true;
        }
        w.n nVar = this.l;
        return (nVar != null && nVar.n()) || this.rv.n();
    }

    public String toString() {
        s sVarQg = qg();
        return sVarQg != null ? sVarQg.toString() : this.n.toString();
    }

    @com.byazt.cp.n(n = {0, 1, 707, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    public static final class n extends WeakReference<x> {
        public final Object n;

        public n(x xVar, Object obj) {
            super(xVar);
            this.n = obj;
        }
    }
}
