package com.byazt.pq;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 8})
public final class s implements Closeable, Flushable {
    public final com.byazt.ym.w n;
    public final com.byazt.ym.q qg;

    public void update(bb bbVar, bb bbVar2) {
        com.byazt.ym.q.n nVarN;
        qg qgVar = new qg(bbVar2);
        try {
            nVarN = ((n) bbVar.rv()).n.n();
            if (nVarN != null) {
                try {
                    qgVar.n(nVarN);
                    nVarN.qg();
                } catch (IOException unused) {
                    n(nVarN);
                }
            }
        } catch (IOException unused2) {
            nVarN = null;
        }
    }

    private void n(com.byazt.ym.q.n nVar) {
        if (nVar != null) {
            try {
                nVar.s();
            } catch (IOException unused) {
            }
        }
    }

    public void delete() throws IOException {
        this.qg.delete();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.qg.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.qg.close();
    }

    @com.byazt.cp.n(n = {0, 1, 109, 782})
    private static final class qg {
        public static final String n = com.byazt.quz.l.qg().s() + "-Sent-Millis";
        public static final String qg = com.byazt.quz.l.qg().s() + "-Received-Millis";
        public final long cp;
        public final long d;
        public final String fs;
        public final String l;
        public final cd q;
        public final cd rv;
        public final String s;
        public final hd tj;
        public final m w;
        public final int x;

        public qg(bb bbVar) {
            this.s = bbVar.qg().n().toString();
            this.q = com.byazt.cri.l.qg(bbVar);
            this.l = bbVar.qg().qg();
            this.w = bbVar.s();
            this.x = bbVar.q();
            this.fs = bbVar.w();
            this.rv = bbVar.fs();
            this.tj = bbVar.x();
            this.cp = bbVar.sz();
            this.d = bbVar.k();
        }

        public void n(com.byazt.ym.q.n nVar) throws IOException {
            com.byazt.wa.q qVarN = com.byazt.wa.d.n(nVar.n(0));
            qVarN.qg(this.s).rv(10);
            qVarN.qg(this.l).rv(10);
            qVarN.d(this.q.n()).rv(10);
            int iN = this.q.n();
            for (int i = 0; i < iN; i++) {
                qVarN.qg(this.q.n(i)).qg(": ").qg(this.q.qg(i)).rv(10);
            }
            qVarN.qg(new com.byazt.cri.cp(this.w, this.x, this.fs).toString()).rv(10);
            qVarN.d(this.rv.n() + 2).rv(10);
            int iN2 = this.rv.n();
            for (int i2 = 0; i2 < iN2; i2++) {
                qVarN.qg(this.rv.n(i2)).qg(": ").qg(this.rv.qg(i2)).rv(10);
            }
            qVarN.qg(n).qg(": ").d(this.cp).rv(10);
            qVarN.qg(qg).qg(": ").d(this.d).rv(10);
            if (n()) {
                qVarN.rv(10);
                qVarN.qg(this.tj.qg().n()).rv(10);
                n(qVarN, this.tj.s());
                n(qVarN, this.tj.q());
                qVarN.qg(this.tj.n().n()).rv(10);
            }
            qVarN.close();
        }

        private boolean n() {
            return this.s.startsWith("https://");
        }

        private void n(com.byazt.wa.q qVar, List<Certificate> list) throws IOException {
            try {
                qVar.d(list.size()).rv(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    qVar.qg(com.byazt.wa.w.n(list.get(i).getEncoded()).qg()).rv(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 109, 546})
    private static class n extends ln {
        public final com.byazt.ym.q.s n;
        public final String q;
        public final com.byazt.wa.l qg;
        public final String s;

        @Override // com.byazt.pq.ln
        public py n() {
            String str = this.s;
            if (str != null) {
                return py.n(str);
            }
            return null;
        }

        @Override // com.byazt.pq.ln
        public long qg() {
            try {
                String str = this.q;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // com.byazt.pq.ln
        public com.byazt.wa.l s() {
            return this.qg;
        }
    }
}
