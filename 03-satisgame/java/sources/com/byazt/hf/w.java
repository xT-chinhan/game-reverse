package com.byazt.hf;

import com.anythink.core.common.l.b;
import com.anythink.core.common.l.f;
import com.byazt.pq.a;
import com.byazt.pq.bb;
import com.byazt.pq.h;
import com.byazt.pq.ln;
import com.byazt.pq.m;
import com.byazt.pq.wm;
import com.byazt.wa.cd;
import com.byazt.wa.um;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 938, 13})
public final class w implements com.byazt.cri.s {
    public static final List<com.byazt.wa.w> cp;
    public static final com.byazt.wa.w fs;
    public static final com.byazt.wa.w l;
    public static final com.byazt.wa.w q;
    public static final com.byazt.wa.w qg;
    public static final com.byazt.wa.w rv;
    public static final com.byazt.wa.w s;
    public static final List<com.byazt.wa.w> tj;
    public static final com.byazt.wa.w w;
    public static final com.byazt.wa.w x;
    public final wm d;
    public rv k;
    public final com.byazt.sqs.x n;
    public final a.n oa;
    public final x sz;

    static {
        com.byazt.wa.w wVarN = com.byazt.wa.w.n("connection");
        qg = wVarN;
        com.byazt.wa.w wVarN2 = com.byazt.wa.w.n(f.bU);
        s = wVarN2;
        com.byazt.wa.w wVarN3 = com.byazt.wa.w.n("keep-alive");
        q = wVarN3;
        com.byazt.wa.w wVarN4 = com.byazt.wa.w.n("proxy-connection");
        l = wVarN4;
        com.byazt.wa.w wVarN5 = com.byazt.wa.w.n("transfer-encoding");
        w = wVarN5;
        com.byazt.wa.w wVarN6 = com.byazt.wa.w.n("te");
        x = wVarN6;
        com.byazt.wa.w wVarN7 = com.byazt.wa.w.n("encoding");
        fs = wVarN7;
        com.byazt.wa.w wVarN8 = com.byazt.wa.w.n("upgrade");
        rv = wVarN8;
        tj = com.byazt.zho.s.n(wVarN, wVarN2, wVarN3, wVarN4, wVarN6, wVarN5, wVarN7, wVarN8, s.s, s.q, s.l, s.w);
        cp = com.byazt.zho.s.n(wVarN, wVarN2, wVarN3, wVarN4, wVarN6, wVarN5, wVarN7, wVarN8);
    }

    public w(wm wmVar, a.n nVar, com.byazt.sqs.x xVar, x xVar2) {
        this.d = wmVar;
        this.oa = nVar;
        this.n = xVar;
        this.sz = xVar2;
    }

    @Override // com.byazt.cri.s
    public cd n(h hVar, long j) {
        return this.k.fs();
    }

    @Override // com.byazt.cri.s
    public void n(h hVar) throws IOException {
        if (this.k != null) {
            return;
        }
        rv rvVarN = this.sz.n(qg(hVar), hVar.q() != null);
        this.k = rvVarN;
        rvVarN.l().n(this.oa.s(), TimeUnit.MILLISECONDS);
        this.k.w().n(this.oa.q(), TimeUnit.MILLISECONDS);
    }

    @Override // com.byazt.cri.s
    public void n() throws IOException {
        this.sz.qg();
    }

    @Override // com.byazt.cri.s
    public void qg() throws IOException {
        this.k.fs().close();
    }

    @Override // com.byazt.cri.s
    public bb.n n(boolean z) throws IOException {
        bb.n nVarN = n(this.k.q());
        if (z && com.byazt.zho.n.n.n(nVarN) == 100) {
            return null;
        }
        return nVarN;
    }

    public static List<s> qg(h hVar) {
        com.byazt.pq.cd cdVarS = hVar.s();
        ArrayList arrayList = new ArrayList(cdVarS.n() + 4);
        arrayList.add(new s(s.s, hVar.qg()));
        arrayList.add(new s(s.q, com.byazt.cri.rv.n(hVar.n())));
        String strN = hVar.n("Host");
        if (strN != null) {
            arrayList.add(new s(s.w, strN));
        }
        arrayList.add(new s(s.l, hVar.n().qg()));
        int iN = cdVarS.n();
        for (int i = 0; i < iN; i++) {
            com.byazt.wa.w wVarN = com.byazt.wa.w.n(cdVarS.n(i).toLowerCase(Locale.US));
            if (!tj.contains(wVarN)) {
                arrayList.add(new s(wVarN, cdVarS.qg(i)));
            }
        }
        return arrayList;
    }

    public static bb.n n(List<s> list) throws IOException {
        int size = list.size();
        com.byazt.cri.cp cpVarN = null;
        com.byazt.pq.cd.n nVar = null;
        for (int i = 0; i < size; i++) {
            s sVar = list.get(i);
            if (sVar == null) {
                if (cpVarN != null && cpVarN.qg == 100) {
                    cpVarN = null;
                    nVar = null;
                }
            } else {
                com.byazt.wa.w wVar = sVar.x;
                if (wVar.equals(s.qg)) {
                    cpVarN = com.byazt.cri.cp.n("HTTP/1.1 ".concat(String.valueOf(sVar.fs.n())));
                } else if (!cp.contains(wVar)) {
                    if (nVar == null) {
                        nVar = new com.byazt.pq.cd.n();
                    }
                    com.byazt.zho.n.n.n(nVar, wVar.n(), sVar.fs.n());
                }
            }
        }
        if (cpVarN == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        return new bb.n().n(m.HTTP_2).n(cpVarN.qg).n(cpVarN.s).n(nVar != null ? nVar.n() : com.byazt.pq.cd.n(new String[0]));
    }

    @Override // com.byazt.cri.s
    public ln n(bb bbVar) throws IOException {
        return new com.byazt.cri.fs(bbVar.qg(b.g), com.byazt.cri.l.n(bbVar), com.byazt.wa.d.n(new n(this.k.x())));
    }

    @Override // com.byazt.cri.s
    public void s() {
        rv rvVar = this.k;
        if (rvVar != null) {
            rvVar.qg(qg.CANCEL);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 938, 108})
    class n extends com.byazt.wa.fs {
        public boolean n;
        public long qg;

        public n(um umVar) {
            super(umVar);
            this.n = false;
            this.qg = 0L;
        }

        @Override // com.byazt.wa.fs, com.byazt.wa.um
        public long n(com.byazt.wa.s sVar, long j) throws IOException {
            try {
                long jN = qg().n(sVar, j);
                if (jN > 0) {
                    this.qg += jN;
                }
                return jN;
            } catch (IOException e) {
                n(e);
                throw e;
            }
        }

        @Override // com.byazt.wa.fs, com.byazt.wa.um, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            n(null);
        }

        private void n(IOException iOException) {
            if (this.n) {
                return;
            }
            this.n = true;
            w.this.n.n(false, (com.byazt.cri.s) w.this, this.qg, iOException);
        }
    }
}
