package com.byazt.sqs;

import com.byazt.pq.a;
import com.byazt.pq.bb;
import com.byazt.pq.cp;
import com.byazt.pq.cy;
import com.byazt.pq.h;
import com.byazt.pq.hd;
import com.byazt.pq.lh;
import com.byazt.pq.m;
import com.byazt.pq.rv;
import com.byazt.pq.tj;
import com.byazt.pq.um;
import com.byazt.pq.wm;
import com.byazt.wa.d;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.kwad.sdk.api.core.RequestParamsUtils;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 707, 8})
public final class s extends com.byazt.hf.x.qg implements rv {
    public hd cp;
    public m d;
    public final lh fs;
    public com.byazt.wa.q k;
    public boolean n;
    public com.byazt.hf.x oa;
    public int qg;
    public Socket rv;
    public com.byazt.wa.l sz;
    public Socket tj;
    public final tj x;
    public int s = 1;
    public final List<Reference<x>> q = new ArrayList();
    public long l = LongCompanionObject.MAX_VALUE;

    public s(tj tjVar, lh lhVar) {
        this.x = tjVar;
        this.fs = lhVar;
    }

    public void n(int i, int i2, int i3, boolean z, com.byazt.pq.l lVar, cy cyVar) throws Throwable {
        if (this.d != null) {
            throw new IllegalStateException("already connected");
        }
        List<cp> listW = this.fs.n().w();
        qg qgVar = new qg(listW);
        if (this.fs.n().rv() == null) {
            if (!listW.contains(cp.s)) {
                throw new l(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strW = this.fs.n().n().w();
            if (!com.byazt.quz.l.qg().qg(strW)) {
                throw new l(new UnknownServiceException("CLEARTEXT communication to " + strW + " not permitted by network security policy"));
            }
        }
        l lVar2 = null;
        while (true) {
            try {
                if (this.fs.q()) {
                    n(i, i2, i3, lVar, cyVar);
                    if (this.rv == null) {
                        break;
                    }
                } else {
                    try {
                        n(i, i2, lVar, cyVar);
                    } catch (IOException e) {
                        e = e;
                        com.byazt.zho.s.n(this.tj);
                        com.byazt.zho.s.n(this.rv);
                        this.tj = null;
                        this.rv = null;
                        this.sz = null;
                        this.k = null;
                        this.cp = null;
                        this.d = null;
                        this.oa = null;
                        cyVar.n(lVar, this.fs.s(), this.fs.qg(), null, e);
                        if (lVar2 == null) {
                            lVar2 = new l(e);
                        } else {
                            lVar2.n(e);
                        }
                        if (z) {
                            if (!qgVar.n(e)) {
                                throw lVar2;
                            }
                        } else {
                            throw lVar2;
                        }
                    }
                }
                n(qgVar, lVar, cyVar);
                cyVar.n(lVar, this.fs.s(), this.fs.qg(), this.d);
                break;
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (this.fs.q() && this.rv == null) {
            throw new l(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        if (this.oa != null) {
            synchronized (this.x) {
                this.s = this.oa.n();
            }
        }
    }

    private void n(int i, int i2, int i3, com.byazt.pq.l lVar, cy cyVar) throws IOException {
        h hVarW = w();
        um umVarN = hVarW.n();
        for (int i4 = 0; i4 < 21; i4++) {
            n(i, i2, lVar, cyVar);
            hVarW = n(i2, i3, hVarW, umVarN);
            if (hVarW == null) {
                return;
            }
            com.byazt.zho.s.n(this.rv);
            this.rv = null;
            this.k = null;
            this.sz = null;
            cyVar.n(lVar, this.fs.s(), this.fs.qg(), null);
        }
    }

    private void n(int i, int i2, com.byazt.pq.l lVar, cy cyVar) throws IOException {
        Proxy proxyQg = this.fs.qg();
        Socket socketCreateSocket = (proxyQg.type() == Proxy.Type.DIRECT || proxyQg.type() == Proxy.Type.HTTP) ? this.fs.n().s().createSocket() : new Socket(proxyQg);
        this.rv = socketCreateSocket;
        socketCreateSocket.setSoTimeout(i2);
        try {
            com.byazt.quz.l.qg().n(this.rv, this.fs.s(), i);
            try {
                this.sz = d.n(d.qg(this.rv));
                this.k = d.n(d.n(this.rv));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.fs.s());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void n(qg qgVar, com.byazt.pq.l lVar, cy cyVar) throws Throwable {
        if (this.fs.n().rv() == null) {
            this.d = m.HTTP_1_1;
            this.tj = this.rv;
            return;
        }
        n(qgVar);
        try {
            if (this.d == m.HTTP_2) {
                this.tj.setSoTimeout(0);
                com.byazt.hf.x xVarN = new com.byazt.hf.x.n(true).n(this.tj, this.fs.n().n().w(), this.sz, this.k).n(this).n();
                this.oa = xVarN;
                xVarN.s();
            }
        } catch (Throwable unused) {
        }
    }

    private void n(qg qgVar) throws Throwable {
        com.byazt.pq.n nVarN = this.fs.n();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) nVarN.rv().createSocket(this.rv, nVarN.n().w(), nVarN.n().x(), true);
                try {
                    cp cpVarN = qgVar.n(sSLSocket2);
                    if (cpVarN.q()) {
                        com.byazt.quz.l.qg().n(sSLSocket2, nVarN.n().w(), nVarN.l());
                    }
                    try {
                        sSLSocket2.startHandshake();
                    } catch (Throwable unused) {
                    }
                    hd hdVarN = hd.n(sSLSocket2.getSession());
                    if (!nVarN.tj().verify(nVarN.n().w(), sSLSocket2.getSession())) {
                        X509Certificate x509Certificate = (X509Certificate) hdVarN.s().get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + nVarN.n().w() + " not verified:\n    certificate: " + com.byazt.pq.x.n((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.byazt.vw.l.n(x509Certificate));
                    }
                    nVarN.cp().n(nVarN.n().w(), hdVarN.s());
                    String strN = cpVarN.q() ? com.byazt.quz.l.qg().n(sSLSocket2) : null;
                    this.tj = sSLSocket2;
                    this.sz = d.n(d.qg(sSLSocket2));
                    this.k = d.n(d.n(this.tj));
                    this.cp = hdVarN;
                    this.d = strN != null ? m.n(strN) : m.HTTP_1_1;
                    if (sSLSocket2 != null) {
                        com.byazt.quz.l.qg().qg(sSLSocket2);
                    }
                } catch (AssertionError e) {
                    e = e;
                    if (!com.byazt.zho.s.n(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (LinkageError e2) {
                    e = e2;
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        com.byazt.quz.l.qg().qg(sSLSocket);
                    }
                    com.byazt.zho.s.n((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e3) {
            e = e3;
        } catch (LinkageError e4) {
            e = e4;
        }
    }

    private h n(int i, int i2, h hVar, um umVar) throws IOException {
        String str = "CONNECT " + com.byazt.zho.s.n(umVar, true) + " HTTP/1.1";
        while (true) {
            com.byazt.oaa.n nVar = new com.byazt.oaa.n(null, null, this.sz, this.k);
            this.sz.n().n(i, TimeUnit.MILLISECONDS);
            this.k.n().n(i2, TimeUnit.MILLISECONDS);
            nVar.n(hVar.s(), str);
            nVar.qg();
            bb bbVarN = nVar.n(false).n(hVar).n();
            long jN = com.byazt.cri.l.n(bbVarN);
            if (jN == -1) {
                jN = 0;
            }
            com.byazt.wa.um umVarQg = nVar.qg(jN);
            com.byazt.zho.s.qg(umVarQg, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            umVarQg.close();
            int iQ = bbVarN.q();
            if (iQ == 200) {
                if (this.sz.s().l() && this.k.s().l()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iQ == 407) {
                h hVarN = this.fs.n().q().n(this.fs, bbVarN);
                if (hVarN == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if (ILivePush.ClickType.CLOSE.equalsIgnoreCase(bbVarN.qg("Connection"))) {
                    return hVarN;
                }
                hVar = hVarN;
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + bbVarN.q());
            }
        }
    }

    private h w() {
        return new h.n().n(this.fs.n().n()).n("Host", com.byazt.zho.s.n(this.fs.n().n(), true)).n("Proxy-Connection", "Keep-Alive").n(RequestParamsUtils.USER_AGENT_KEY, com.byazt.zho.q.n()).n();
    }

    public boolean n(com.byazt.pq.n nVar, lh lhVar) {
        if (this.q.size() >= this.s || this.n || !com.byazt.zho.n.n.n(this.fs.n(), nVar)) {
            return false;
        }
        if (nVar.n().w().equals(n().n().n().w())) {
            return true;
        }
        if (this.oa == null || lhVar == null || lhVar.qg().type() != Proxy.Type.DIRECT || this.fs.qg().type() != Proxy.Type.DIRECT || !this.fs.s().equals(lhVar.s()) || lhVar.n().tj() != com.byazt.vw.l.n || !n(nVar.n())) {
            return false;
        }
        try {
            nVar.cp().n(nVar.n().w(), q().s());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean n(um umVar) {
        if (umVar.x() != this.fs.n().n().x()) {
            return false;
        }
        if (umVar.w().equals(this.fs.n().n().w())) {
            return true;
        }
        return this.cp != null && com.byazt.vw.l.n.n(umVar.w(), (X509Certificate) this.cp.s().get(0));
    }

    public com.byazt.cri.s n(wm wmVar, a.n nVar, x xVar) throws SocketException {
        if (this.oa != null) {
            return new com.byazt.hf.w(wmVar, nVar, xVar, this.oa);
        }
        this.tj.setSoTimeout(nVar.s());
        this.sz.n().n(nVar.s(), TimeUnit.MILLISECONDS);
        this.k.n().n(nVar.q(), TimeUnit.MILLISECONDS);
        return new com.byazt.oaa.n(wmVar, xVar, this.sz, this.k);
    }

    @Override // com.byazt.pq.rv
    public lh n() {
        return this.fs;
    }

    public void qg() {
        com.byazt.zho.s.n(this.rv);
    }

    public Socket s() {
        return this.tj;
    }

    public boolean n(boolean z) {
        if (this.tj.isClosed() || this.tj.isInputShutdown() || this.tj.isOutputShutdown()) {
            return false;
        }
        com.byazt.hf.x xVar = this.oa;
        if (xVar != null) {
            return !xVar.q();
        }
        if (z) {
            try {
                int soTimeout = this.tj.getSoTimeout();
                try {
                    this.tj.setSoTimeout(1);
                    if (this.sz.l()) {
                        this.tj.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.tj.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.tj.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.byazt.hf.x.qg
    public void n(com.byazt.hf.rv rvVar) throws IOException {
        rvVar.n(com.byazt.hf.qg.REFUSED_STREAM);
    }

    @Override // com.byazt.hf.x.qg
    public void n(com.byazt.hf.x xVar) {
        synchronized (this.x) {
            this.s = xVar.n();
        }
    }

    public hd q() {
        return this.cp;
    }

    public boolean l() {
        return this.oa != null;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Connection{").append(this.fs.n().n().w()).append(":").append(this.fs.n().n().x()).append(", proxy=").append(this.fs.qg()).append(" hostAddress=").append(this.fs.s()).append(" cipherSuite=");
        hd hdVar = this.cp;
        return sbAppend.append(hdVar != null ? hdVar.qg() : LiveConfigKey.NONE).append(" protocol=").append(this.d).append(AbstractJsonLexerKt.END_OBJ).toString();
    }
}
