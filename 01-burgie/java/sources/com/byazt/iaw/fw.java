package com.byazt.iaw;

import com.byazt.cpq.ho;
import com.byazt.jv.a;
import com.byazt.jv.fo;
import com.byazt.jv.nt;
import com.byazt.jv.vk;
import com.byazt.jv.y;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 507, 62})
public final class fw {
    public static final /* synthetic */ boolean x = true;
    public final uc aj;
    public uc.pr c;
    public final vk fw;
    public boolean g;
    public final nt hn;
    public com.byazt.osx.hn ho;
    public final com.byazt.jv.c hw;
    public boolean k;
    public boolean m;
    public final com.byazt.jv.pr pr;
    public y uc;
    public int vk;
    public hn w;
    public final Object zo;

    public fw(vk vkVar, com.byazt.jv.pr prVar, com.byazt.jv.c cVar, nt ntVar, Object obj) throws IOException {
        this.fw = vkVar;
        this.pr = prVar;
        this.hw = cVar;
        this.hn = ntVar;
        this.aj = new uc(prVar, zo(), cVar, ntVar);
        this.zo = obj;
    }

    public com.byazt.osx.hn pr(fo foVar, a.pr prVar, boolean z) {
        try {
            com.byazt.osx.hn hnVarPr = pr(prVar.hw(), prVar.hn(), prVar.x(), foVar.lb(), z).pr(foVar, prVar, this);
            synchronized (this.fw) {
                this.ho = hnVarPr;
            }
            return hnVarPr;
        } catch (IOException e) {
            throw new c(e);
        }
    }

    private hn pr(int i, int i2, int i3, boolean z, boolean z2) throws IOException {
        while (true) {
            hn hnVarPr = pr(i, i2, i3, z);
            synchronized (this.fw) {
                if (hnVarPr.hw == 0) {
                    return hnVarPr;
                }
                if (!hnVarPr.pr(z2)) {
                    x();
                } else {
                    return hnVarPr;
                }
            }
        }
    }

    private hn pr(int i, int i2, int i3, boolean z) throws IOException {
        Socket socketFw;
        hn hnVar;
        Socket socketPr;
        y yVarHw;
        boolean z2;
        boolean z3;
        uc.pr prVar;
        synchronized (this.fw) {
            if (this.m) {
                throw new IllegalStateException("released");
            }
            if (this.ho != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.g) {
                throw new IOException("Canceled");
            }
            socketFw = fw();
            hnVar = this.w;
            socketPr = null;
            if (hnVar == null) {
                hnVar = null;
            }
            if (hnVar == null) {
                com.byazt.xx.pr.pr.pr(this.fw, this.pr, this, null);
                hn hnVar2 = this.w;
                if (hnVar2 != null) {
                    z2 = true;
                    hnVar = hnVar2;
                    yVarHw = null;
                } else {
                    yVarHw = this.uc;
                    z2 = false;
                }
            } else {
                yVarHw = null;
                z2 = false;
            }
        }
        com.byazt.xx.hn.pr(socketFw);
        if (z2) {
            this.hn.pr(this.hw, hnVar);
        }
        if (hnVar != null) {
            return hnVar;
        }
        if (yVarHw == null && ((prVar = this.c) == null || !prVar.pr())) {
            this.c = this.aj.hw();
            z3 = true;
        } else {
            z3 = false;
        }
        synchronized (this.fw) {
            if (this.g) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<y> listHn = this.c.hn();
                int size = listHn.size();
                for (int i4 = 0; i4 < size; i4++) {
                    y yVar = listHn.get(i4);
                    com.byazt.xx.pr.pr.pr(this.fw, this.pr, this, yVar);
                    hn hnVar3 = this.w;
                    if (hnVar3 != null) {
                        this.uc = yVar;
                        z2 = true;
                        hnVar = hnVar3;
                        break;
                    }
                }
            }
            if (!z2) {
                if (yVarHw == null) {
                    yVarHw = this.c.hw();
                }
                this.uc = yVarHw;
                this.vk = 0;
                hnVar = new hn(this.fw, yVarHw);
                pr(hnVar, false);
            }
        }
        if (z2) {
            this.hn.pr(this.hw, hnVar);
            return hnVar;
        }
        hnVar.pr(i, i2, i3, z, this.hw, this.hn);
        zo().hw(hnVar.pr());
        synchronized (this.fw) {
            this.k = true;
            com.byazt.xx.pr.pr.hw(this.fw, hnVar);
            if (hnVar.c()) {
                socketPr = com.byazt.xx.pr.pr.pr(this.fw, this.pr, this);
                hnVar = this.w;
            }
        }
        com.byazt.xx.hn.pr(socketPr);
        this.hn.pr(this.hw, hnVar);
        return hnVar;
    }

    private Socket fw() {
        if (!x && !Thread.holdsLock(this.fw)) {
            throw new AssertionError();
        }
        hn hnVar = this.w;
        if (hnVar != null && hnVar.pr) {
            return pr(false, false, true);
        }
        return null;
    }

    public void pr(boolean z, com.byazt.osx.hn hnVar, long j, IOException iOException) {
        Socket socketPr;
        synchronized (this.fw) {
            if (hnVar != null) {
                if (hnVar == this.ho) {
                    if (!z) {
                        this.w.hw++;
                    }
                    socketPr = pr(z, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.ho + " but was " + hnVar);
        }
        com.byazt.xx.hn.pr(socketPr);
        if (iOException != null) {
            this.hn.pr(this.hw, iOException);
        }
    }

    public com.byazt.osx.hn pr() {
        com.byazt.osx.hn hnVar;
        synchronized (this.fw) {
            hnVar = this.ho;
        }
        return hnVar;
    }

    private x zo() {
        return com.byazt.xx.pr.pr.pr(this.fw);
    }

    public synchronized hn hw() {
        return this.w;
    }

    public void hn() {
        Socket socketPr;
        synchronized (this.fw) {
            socketPr = pr(false, true, false);
        }
        com.byazt.xx.hn.pr(socketPr);
    }

    public void x() {
        Socket socketPr;
        synchronized (this.fw) {
            socketPr = pr(true, false, false);
        }
        com.byazt.xx.hn.pr(socketPr);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005e  */
    private Socket pr(boolean z, boolean z2, boolean z3) {
        Socket socketHn;
        if (!x && !Thread.holdsLock(this.fw)) {
            throw new AssertionError();
        }
        if (z3) {
            this.ho = null;
        }
        if (z2) {
            this.m = true;
        }
        hn hnVar = this.w;
        if (hnVar == null) {
            return null;
        }
        if (z) {
            hnVar.pr = true;
        }
        if (this.ho != null) {
            return null;
        }
        if (!this.m && !this.w.pr) {
            return null;
        }
        hw(this.w);
        if (this.w.x.isEmpty()) {
            this.w.c = System.nanoTime();
            if (com.byazt.xx.pr.pr.pr(this.fw, this.w)) {
                socketHn = this.w.hn();
            } else {
                socketHn = null;
            }
        } else {
            socketHn = null;
        }
        this.w = null;
        return socketHn;
    }

    public void c() {
        com.byazt.osx.hn hnVar;
        hn hnVar2;
        synchronized (this.fw) {
            this.g = true;
            hnVar = this.ho;
            hnVar2 = this.w;
        }
        if (hnVar != null) {
            hnVar.hn();
        } else if (hnVar2 != null) {
            hnVar2.hw();
        }
    }

    public void pr(IOException iOException) {
        boolean z;
        Socket socketPr;
        synchronized (this.fw) {
            if (iOException instanceof ho) {
                ho hoVar = (ho) iOException;
                if (hoVar.pr == com.byazt.cpq.hw.REFUSED_STREAM) {
                    this.vk++;
                }
                if (hoVar.pr != com.byazt.cpq.hw.REFUSED_STREAM || this.vk > 1) {
                    this.uc = null;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                hn hnVar = this.w;
                if (hnVar == null || (hnVar.c() && !(iOException instanceof com.byazt.cpq.pr))) {
                    z = false;
                } else {
                    if (this.w.hw == 0) {
                        y yVar = this.uc;
                        if (yVar != null && iOException != null) {
                            this.aj.pr(yVar, iOException);
                        }
                        this.uc = null;
                    }
                    z = true;
                }
            }
            socketPr = pr(z, false, true);
        }
        com.byazt.xx.hn.pr(socketPr);
    }

    public void pr(hn hnVar, boolean z) {
        if (!x && !Thread.holdsLock(this.fw)) {
            throw new AssertionError();
        }
        if (this.w != null) {
            throw new IllegalStateException();
        }
        this.w = hnVar;
        this.k = z;
        hnVar.x.add(new pr(this, this.zo));
    }

    private void hw(hn hnVar) {
        int size = hnVar.x.size();
        for (int i = 0; i < size; i++) {
            if (hnVar.x.get(i).get() == this) {
                hnVar.x.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket pr(hn hnVar) {
        if (!x && !Thread.holdsLock(this.fw)) {
            throw new AssertionError();
        }
        if (this.ho != null || this.w.x.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<fw> reference = this.w.x.get(0);
        Socket socketPr = pr(true, false, false);
        this.w = hnVar;
        hnVar.x.add(reference);
        return socketPr;
    }

    public boolean uc() {
        if (this.uc != null) {
            return true;
        }
        uc.pr prVar = this.c;
        return (prVar != null && prVar.pr()) || this.aj.pr();
    }

    public String toString() {
        hn hnVarHw = hw();
        return hnVarHw != null ? hnVarHw.toString() : this.pr.toString();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 507, 766})
    public static final class pr extends WeakReference<fw> {
        public final Object pr;

        public pr(fw fwVar, Object obj) {
            super(fwVar);
            this.pr = obj;
        }
    }
}
