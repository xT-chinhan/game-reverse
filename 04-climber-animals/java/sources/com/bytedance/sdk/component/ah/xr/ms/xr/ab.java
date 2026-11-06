package com.bytedance.sdk.component.ah.xr.ms.xr;

import com.bytedance.sdk.component.ah.xr.ao;
import com.bytedance.sdk.component.ah.xr.ch;
import com.bytedance.sdk.component.ah.xr.ms.ka.ub;
import com.bytedance.sdk.component.ah.xr.of;
import com.bytedance.sdk.component.ah.xr.re;
import com.bytedance.sdk.component.ah.xr.t;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ab {
    static final /* synthetic */ boolean d = true;
    private final ch ab;
    public final ao ah;
    private of c;
    private int ch;
    private ah hi;
    private c.ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final com.bytedance.sdk.component.ah.xr.ms f1123ms;
    private final c ny;
    private boolean sl;
    private boolean u;
    private com.bytedance.sdk.component.ah.xr.ms.ah.ah ub;
    private final Object x;
    public final com.bytedance.sdk.component.ah.xr.ka xr;
    private boolean zb;

    public ab(ch chVar, com.bytedance.sdk.component.ah.xr.ms msVar, com.bytedance.sdk.component.ah.xr.ka kaVar, ao aoVar, Object obj) throws IOException {
        this.ab = chVar;
        this.f1123ms = msVar;
        this.xr = kaVar;
        this.ah = aoVar;
        this.ny = new c(msVar, x(), kaVar, aoVar);
        this.x = obj;
    }

    public com.bytedance.sdk.component.ah.xr.ms.ah.ah ms(re reVar, t.ms msVar, boolean z) {
        try {
            com.bytedance.sdk.component.ah.xr.ms.ah.ah ahVarMs = ms(msVar.xr(), msVar.ah(), msVar.d(), reVar.qv(), z).ms(reVar, msVar, this);
            synchronized (this.ab) {
                this.ub = ahVarMs;
            }
            return ahVarMs;
        } catch (IOException e) {
            throw new ka(e);
        }
    }

    private ah ms(int i, int i2, int i3, boolean z, boolean z2) throws IOException {
        while (true) {
            ah ahVarMs = ms(i, i2, i3, z);
            synchronized (this.ab) {
                if (ahVarMs.xr == 0) {
                    return ahVarMs;
                }
                if (ahVarMs.ms(z2)) {
                    return ahVarMs;
                }
                d();
            }
        }
    }

    private ah ms(int i, int i2, int i3, boolean z) throws IOException {
        Socket socketAb;
        ah ahVar;
        Socket socketMs;
        of ofVarXr;
        boolean z2;
        boolean z3;
        c.ms msVar;
        synchronized (this.ab) {
            if (this.zb) {
                throw new IllegalStateException("released");
            }
            if (this.ub != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.u) {
                throw new IOException("Canceled");
            }
            socketAb = ab();
            ahVar = this.hi;
            socketMs = null;
            if (ahVar == null) {
                ahVar = null;
            }
            if (ahVar == null) {
                com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms.ms(this.ab, this.f1123ms, this, null);
                ah ahVar2 = this.hi;
                if (ahVar2 != null) {
                    z2 = true;
                    ahVar = ahVar2;
                    ofVarXr = null;
                } else {
                    ofVarXr = this.c;
                }
            } else {
                ofVarXr = null;
            }
            z2 = false;
        }
        com.bytedance.sdk.component.ah.xr.ms.ah.ms(socketAb);
        if (ahVar != null) {
            return ahVar;
        }
        if (ofVarXr != null || ((msVar = this.ka) != null && msVar.ms())) {
            z3 = false;
        } else {
            this.ka = this.ny.xr();
            z3 = true;
        }
        synchronized (this.ab) {
            if (this.u) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<of> listAh = this.ka.ah();
                int size = listAh.size();
                for (int i4 = 0; i4 < size; i4++) {
                    of ofVar = listAh.get(i4);
                    com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms.ms(this.ab, this.f1123ms, this, ofVar);
                    ah ahVar3 = this.hi;
                    if (ahVar3 != null) {
                        this.c = ofVar;
                        z2 = true;
                        ahVar = ahVar3;
                        break;
                    }
                }
            }
            if (!z2) {
                if (ofVarXr == null) {
                    ofVarXr = this.ka.xr();
                }
                this.c = ofVarXr;
                this.ch = 0;
                ahVar = new ah(this.ab, ofVarXr);
                ms(ahVar, false);
            }
        }
        if (z2) {
            return ahVar;
        }
        ahVar.ms(i, i2, i3, z, this.xr, this.ah);
        x().xr(ahVar.ms());
        synchronized (this.ab) {
            this.sl = true;
            com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms.xr(this.ab, ahVar);
            if (ahVar.ka()) {
                socketMs = com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms.ms(this.ab, this.f1123ms, this);
                ahVar = this.hi;
            }
        }
        com.bytedance.sdk.component.ah.xr.ms.ah.ms(socketMs);
        return ahVar;
    }

    private Socket ab() {
        if (!d && !Thread.holdsLock(this.ab)) {
            throw new AssertionError();
        }
        ah ahVar = this.hi;
        if (ahVar == null || !ahVar.f1125ms) {
            return null;
        }
        return ms(false, false, true);
    }

    public void ms(boolean z, com.bytedance.sdk.component.ah.xr.ms.ah.ah ahVar, long j, IOException iOException) {
        Socket socketMs;
        synchronized (this.ab) {
            if (ahVar != null) {
                if (ahVar == this.ub) {
                    if (!z) {
                        this.hi.xr++;
                    }
                    socketMs = ms(z, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.ub + " but was " + ahVar);
        }
        com.bytedance.sdk.component.ah.xr.ms.ah.ms(socketMs);
        if (iOException != null) {
            this.ah.ms(this.xr, iOException);
        }
    }

    public com.bytedance.sdk.component.ah.xr.ms.ah.ah ms() {
        com.bytedance.sdk.component.ah.xr.ms.ah.ah ahVar;
        synchronized (this.ab) {
            ahVar = this.ub;
        }
        return ahVar;
    }

    private d x() {
        return com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms.ms(this.ab);
    }

    public synchronized ah xr() {
        return this.hi;
    }

    public void ah() {
        Socket socketMs;
        synchronized (this.ab) {
            socketMs = ms(false, true, false);
        }
        com.bytedance.sdk.component.ah.xr.ms.ah.ms(socketMs);
    }

    public void d() {
        Socket socketMs;
        synchronized (this.ab) {
            socketMs = ms(true, false, false);
        }
        com.bytedance.sdk.component.ah.xr.ms.ah.ms(socketMs);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    private Socket ms(boolean z, boolean z2, boolean z3) {
        Socket socketAh;
        if (!d && !Thread.holdsLock(this.ab)) {
            throw new AssertionError();
        }
        if (z3) {
            this.ub = null;
        }
        if (z2) {
            this.zb = true;
        }
        ah ahVar = this.hi;
        if (ahVar == null) {
            return null;
        }
        if (z) {
            ahVar.f1125ms = true;
        }
        if (this.ub != null) {
            return null;
        }
        if (!this.zb && !this.hi.f1125ms) {
            return null;
        }
        xr(this.hi);
        if (this.hi.d.isEmpty()) {
            this.hi.ka = System.nanoTime();
            if (com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms.ms(this.ab, this.hi)) {
                socketAh = this.hi.ah();
            } else {
                socketAh = null;
            }
        } else {
            socketAh = null;
        }
        this.hi = null;
        return socketAh;
    }

    public void ka() {
        com.bytedance.sdk.component.ah.xr.ms.ah.ah ahVar;
        ah ahVar2;
        synchronized (this.ab) {
            this.u = true;
            ahVar = this.ub;
            ahVar2 = this.hi;
        }
        if (ahVar != null) {
            ahVar.ah();
        } else if (ahVar2 != null) {
            ahVar2.xr();
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0047  */
    public void ms(IOException iOException) {
        boolean z;
        Socket socketMs;
        synchronized (this.ab) {
            if (iOException instanceof ub) {
                ub ubVar = (ub) iOException;
                if (ubVar.f1101ms == com.bytedance.sdk.component.ah.xr.ms.ka.xr.REFUSED_STREAM) {
                    this.ch++;
                }
                if (ubVar.f1101ms != com.bytedance.sdk.component.ah.xr.ms.ka.xr.REFUSED_STREAM || this.ch > 1) {
                    this.c = null;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                ah ahVar = this.hi;
                if (ahVar == null || (ahVar.ka() && !(iOException instanceof com.bytedance.sdk.component.ah.xr.ms.ka.ms))) {
                    z = false;
                } else {
                    if (this.hi.xr == 0) {
                        of ofVar = this.c;
                        if (ofVar != null && iOException != null) {
                            this.ny.ms(ofVar, iOException);
                        }
                        this.c = null;
                    }
                    z = true;
                }
            }
            socketMs = ms(z, false, true);
        }
        com.bytedance.sdk.component.ah.xr.ms.ah.ms(socketMs);
    }

    public void ms(ah ahVar, boolean z) {
        if (!d && !Thread.holdsLock(this.ab)) {
            throw new AssertionError();
        }
        if (this.hi != null) {
            throw new IllegalStateException();
        }
        this.hi = ahVar;
        this.sl = z;
        ahVar.d.add(new ms(this, this.x));
    }

    private void xr(ah ahVar) {
        int size = ahVar.d.size();
        for (int i = 0; i < size; i++) {
            if (ahVar.d.get(i).get() == this) {
                ahVar.d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket ms(ah ahVar) {
        if (!d && !Thread.holdsLock(this.ab)) {
            throw new AssertionError();
        }
        if (this.ub != null || this.hi.d.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<ab> reference = this.hi.d.get(0);
        Socket socketMs = ms(true, false, false);
        this.hi = ahVar;
        ahVar.d.add(reference);
        return socketMs;
    }

    public boolean c() {
        if (this.c != null) {
            return true;
        }
        c.ms msVar = this.ka;
        return (msVar != null && msVar.ms()) || this.ny.ms();
    }

    public String toString() {
        ah ahVarXr = xr();
        return ahVarXr != null ? ahVarXr.toString() : this.f1123ms.toString();
    }

    public static final class ms extends WeakReference<ab> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final Object f1124ms;

        ms(ab abVar, Object obj) {
            super(abVar);
            this.f1124ms = obj;
        }
    }
}
