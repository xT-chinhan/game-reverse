package com.byazt.oaa;

import com.anythink.china.a.c;
import com.anythink.core.common.l.b;
import com.byazt.cri.cp;
import com.byazt.cri.fs;
import com.byazt.cri.rv;
import com.byazt.pq.bb;
import com.byazt.pq.h;
import com.byazt.pq.ln;
import com.byazt.pq.wm;
import com.byazt.sqs.x;
import com.byazt.wa.a;
import com.byazt.wa.cd;
import com.byazt.wa.d;
import com.byazt.wa.um;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1850, 19})
public final class n implements com.byazt.cri.s {
    public final wm n;
    public final com.byazt.wa.q q;
    public final x qg;
    public final com.byazt.wa.l s;
    public int l = 0;
    public long w = c.s;

    public n(wm wmVar, x xVar, com.byazt.wa.l lVar, com.byazt.wa.q qVar) {
        this.n = wmVar;
        this.qg = xVar;
        this.s = lVar;
        this.q = qVar;
    }

    @Override // com.byazt.cri.s
    public cd n(h hVar, long j) {
        if ("chunked".equalsIgnoreCase(hVar.n("Transfer-Encoding"))) {
            return l();
        }
        if (j != -1) {
            return n(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.byazt.cri.s
    public void s() {
        com.byazt.sqs.s sVarQg = this.qg.qg();
        if (sVarQg != null) {
            sVarQg.qg();
        }
    }

    @Override // com.byazt.cri.s
    public void n(h hVar) throws IOException {
        n(hVar.s(), rv.n(hVar, this.qg.qg().n().qg().type()));
    }

    @Override // com.byazt.cri.s
    public ln n(bb bbVar) throws IOException {
        String strQg = bbVar.qg(b.g);
        if (!com.byazt.cri.l.s(bbVar)) {
            return new fs(strQg, 0L, d.n(qg(0L)));
        }
        if ("chunked".equalsIgnoreCase(bbVar.qg("Transfer-Encoding"))) {
            return new fs(strQg, -1L, d.n(n(bbVar.qg().n())));
        }
        long jN = com.byazt.cri.l.n(bbVar);
        if (jN != -1) {
            return new fs(strQg, jN, d.n(qg(jN)));
        }
        return new fs(strQg, -1L, d.n(w()));
    }

    @Override // com.byazt.cri.s
    public void n() throws IOException {
        this.q.flush();
    }

    @Override // com.byazt.cri.s
    public void qg() throws IOException {
        this.q.flush();
    }

    public void n(com.byazt.pq.cd cdVar, String str) throws IOException {
        if (this.l != 0) {
            throw new IllegalStateException("state: " + this.l);
        }
        this.q.qg(str).qg("\r\n");
        int iN = cdVar.n();
        for (int i = 0; i < iN; i++) {
            this.q.qg(cdVar.n(i)).qg(": ").qg(cdVar.qg(i)).qg("\r\n");
        }
        this.q.qg("\r\n");
        this.l = 1;
    }

    @Override // com.byazt.cri.s
    public bb.n n(boolean z) throws IOException {
        int i = this.l;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.l);
        }
        try {
            cp cpVarN = cp.n(x());
            bb.n nVarN = new bb.n().n(cpVarN.n).n(cpVarN.qg).n(cpVarN.s).n(q());
            if (z && cpVarN.qg == 100) {
                return null;
            }
            this.l = 4;
            return nVarN;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.qg);
            iOException.initCause(e);
            throw iOException;
        }
    }

    private String x() throws IOException {
        String strL = this.s.l(this.w);
        this.w -= (long) strL.length();
        return strL;
    }

    public com.byazt.pq.cd q() throws IOException {
        com.byazt.pq.cd.n nVar = new com.byazt.pq.cd.n();
        while (true) {
            String strX = x();
            if (strX.length() != 0) {
                com.byazt.zho.n.n.n(nVar, strX);
            } else {
                return nVar.n();
            }
        }
    }

    public cd l() {
        if (this.l != 1) {
            throw new IllegalStateException("state: " + this.l);
        }
        this.l = 2;
        return new qg();
    }

    public cd n(long j) {
        if (this.l != 1) {
            throw new IllegalStateException("state: " + this.l);
        }
        this.l = 2;
        return new q(j);
    }

    public um qg(long j) throws IOException {
        if (this.l != 4) {
            throw new IllegalStateException("state: " + this.l);
        }
        this.l = 5;
        return new l(j);
    }

    public um n(com.byazt.pq.um umVar) throws IOException {
        if (this.l != 4) {
            throw new IllegalStateException("state: " + this.l);
        }
        this.l = 5;
        return new s(umVar);
    }

    public um w() throws IOException {
        if (this.l != 4) {
            throw new IllegalStateException("state: " + this.l);
        }
        x xVar = this.qg;
        if (xVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.l = 5;
        xVar.q();
        return new w();
    }

    public void n(com.byazt.wa.rv rvVar) {
        a aVarN = rvVar.n();
        rvVar.n(a.s);
        aVarN.w();
        aVarN.l();
    }

    @com.byazt.cp.n(n = {0, 1, 1850, 1125})
    private final class q implements cd {
        public long q;
        public final com.byazt.wa.rv qg;
        public boolean s;

        public q(long j) {
            this.qg = new com.byazt.wa.rv(n.this.q.n());
            this.q = j;
        }

        @Override // com.byazt.wa.cd
        public a n() {
            return this.qg;
        }

        @Override // com.byazt.wa.cd
        public void a_(com.byazt.wa.s sVar, long j) throws IOException {
            if (this.s) {
                throw new IllegalStateException("closed");
            }
            com.byazt.zho.s.n(sVar.qg(), 0L, j);
            if (j > this.q) {
                throw new ProtocolException("expected " + this.q + " bytes but received " + j);
            }
            n.this.q.a_(sVar, j);
            this.q -= j;
        }

        @Override // com.byazt.wa.cd, java.io.Flushable
        public void flush() throws IOException {
            if (this.s) {
                return;
            }
            n.this.q.flush();
        }

        @Override // com.byazt.wa.cd, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.s) {
                return;
            }
            this.s = true;
            if (this.q > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            n.this.n(this.qg);
            n.this.l = 3;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1850, 226})
    private final class qg implements cd {
        public final com.byazt.wa.rv qg;
        public boolean s;

        public qg() {
            this.qg = new com.byazt.wa.rv(n.this.q.n());
        }

        @Override // com.byazt.wa.cd
        public a n() {
            return this.qg;
        }

        @Override // com.byazt.wa.cd
        public void a_(com.byazt.wa.s sVar, long j) throws IOException {
            if (this.s) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            n.this.q.cp(j);
            n.this.q.qg("\r\n");
            n.this.q.a_(sVar, j);
            n.this.q.qg("\r\n");
        }

        @Override // com.byazt.wa.cd, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.s) {
                return;
            }
            n.this.q.flush();
        }

        @Override // com.byazt.wa.cd, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.s) {
                return;
            }
            this.s = true;
            n.this.q.qg("0\r\n\r\n");
            n.this.n(this.qg);
            n.this.l = 3;
        }
    }

    /* JADX INFO: renamed from: com.byazt.oaa.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1850, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private abstract class AbstractC0278n implements um {
        public final com.byazt.wa.rv n;
        public boolean qg;
        public long s;

        private AbstractC0278n() {
            this.n = new com.byazt.wa.rv(n.this.s.n());
            this.s = 0L;
        }

        @Override // com.byazt.wa.um
        public a n() {
            return this.n;
        }

        @Override // com.byazt.wa.um
        public long n(com.byazt.wa.s sVar, long j) throws IOException {
            try {
                long jN = n.this.s.n(sVar, j);
                if (jN > 0) {
                    this.s += jN;
                }
                return jN;
            } catch (IOException e) {
                n(false, e);
                throw e;
            }
        }

        public final void n(boolean z, IOException iOException) throws IOException {
            if (n.this.l == 6) {
                return;
            }
            if (n.this.l != 5) {
                throw new IllegalStateException("state: " + n.this.l);
            }
            n.this.n(this.n);
            n.this.l = 6;
            if (n.this.qg != null) {
                n.this.qg.n(!z, n.this, this.s, iOException);
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1850, 1705})
    private class l extends AbstractC0278n {
        public long w;

        public l(long j) throws IOException {
            super();
            this.w = j;
            if (j == 0) {
                n(true, (IOException) null);
            }
        }

        @Override // com.byazt.oaa.n.AbstractC0278n, com.byazt.wa.um
        public long n(com.byazt.wa.s sVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.qg) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.w;
            if (j2 == 0) {
                return -1L;
            }
            long jN = super.n(sVar, Math.min(j2, j));
            if (jN == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                n(false, (IOException) protocolException);
                throw protocolException;
            }
            long j3 = this.w - jN;
            this.w = j3;
            if (j3 == 0) {
                n(true, (IOException) null);
            }
            return jN;
        }

        @Override // com.byazt.wa.um, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.qg) {
                return;
            }
            if (this.w != 0 && !com.byazt.zho.s.n(this, 100, TimeUnit.MILLISECONDS)) {
                n(false, (IOException) null);
            }
            this.qg = true;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1850, 829})
    private class s extends AbstractC0278n {
        public boolean fs;
        public final com.byazt.pq.um w;
        public long x;

        public s(com.byazt.pq.um umVar) {
            super();
            this.x = -1L;
            this.fs = true;
            this.w = umVar;
        }

        @Override // com.byazt.oaa.n.AbstractC0278n, com.byazt.wa.um
        public long n(com.byazt.wa.s sVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.qg) {
                throw new IllegalStateException("closed");
            }
            if (!this.fs) {
                return -1L;
            }
            long j2 = this.x;
            if (j2 == 0 || j2 == -1) {
                qg();
                if (!this.fs) {
                    return -1L;
                }
            }
            long jN = super.n(sVar, Math.min(j, this.x));
            if (jN == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                n(false, (IOException) protocolException);
                throw protocolException;
            }
            this.x -= jN;
            return jN;
        }

        private void qg() throws IOException {
            if (this.x != -1) {
                n.this.s.cy();
            }
            try {
                this.x = n.this.s.oa();
                String strTrim = n.this.s.cy().trim();
                if (this.x < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.x + strTrim + "\"");
                }
                if (this.x == 0) {
                    this.fs = false;
                    com.byazt.cri.l.n(n.this.n.w(), this.w, n.this.q());
                    n(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // com.byazt.wa.um, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.qg) {
                return;
            }
            if (this.fs && !com.byazt.zho.s.n(this, 100, TimeUnit.MILLISECONDS)) {
                n(false, (IOException) null);
            }
            this.qg = true;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1850, 1860})
    private class w extends AbstractC0278n {
        public boolean w;

        public w() {
            super();
        }

        @Override // com.byazt.oaa.n.AbstractC0278n, com.byazt.wa.um
        public long n(com.byazt.wa.s sVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.qg) {
                throw new IllegalStateException("closed");
            }
            if (this.w) {
                return -1L;
            }
            long jN = super.n(sVar, j);
            if (jN != -1) {
                return jN;
            }
            this.w = true;
            n(true, (IOException) null);
            return -1L;
        }

        @Override // com.byazt.wa.um, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.qg) {
                return;
            }
            if (!this.w) {
                n(false, (IOException) null);
            }
            this.qg = true;
        }
    }
}
