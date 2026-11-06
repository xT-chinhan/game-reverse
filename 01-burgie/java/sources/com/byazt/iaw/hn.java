package com.byazt.iaw;

import com.byazt.du.k;
import com.byazt.jv.a;
import com.byazt.jv.aj;
import com.byazt.jv.b;
import com.byazt.jv.fo;
import com.byazt.jv.gz;
import com.byazt.jv.nt;
import com.byazt.jv.qa;
import com.byazt.jv.rc;
import com.byazt.jv.vk;
import com.byazt.jv.w;
import com.byazt.jv.y;
import com.byazt.jv.yb;
import com.bytedance.android.live.base.api.push.ILivePush;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 507, 20})
public final class hn extends com.byazt.cpq.fw.hw implements aj {
    public Socket aj;
    public final vk fw;
    public com.byazt.du.c g;
    public com.byazt.du.x ho;
    public int hw;
    public rc k;
    public com.byazt.cpq.fw m;
    public boolean pr;
    public Socket vk;
    public yb w;
    public final y zo;
    public int hn = 1;
    public final List<Reference<fw>> x = new ArrayList();
    public long c = LongCompanionObject.MAX_VALUE;

    public hn(vk vkVar, y yVar) {
        this.fw = vkVar;
        this.zo = yVar;
    }

    public void pr(int i, int i2, int i3, boolean z, com.byazt.jv.c cVar, nt ntVar) {
        if (this.k != null) {
            throw new IllegalStateException("already connected");
        }
        List<w> listUc = this.zo.pr().uc();
        hw hwVar = new hw(listUc);
        if (this.zo.pr().aj() == null) {
            if (!listUc.contains(w.hn)) {
                throw new c(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strUc = this.zo.pr().pr().uc();
            if (!com.byazt.lp.c.hw().hw(strUc)) {
                throw new c(new UnknownServiceException("CLEARTEXT communication to " + strUc + " not permitted by network security policy"));
            }
        }
        c cVar2 = null;
        while (true) {
            try {
                if (this.zo.x()) {
                    pr(i, i2, i3, cVar, ntVar);
                    if (this.aj == null) {
                        break;
                    }
                } else {
                    try {
                        pr(i, i2, cVar, ntVar);
                    } catch (IOException e) {
                        e = e;
                        com.byazt.xx.hn.pr(this.vk);
                        com.byazt.xx.hn.pr(this.aj);
                        this.vk = null;
                        this.aj = null;
                        this.g = null;
                        this.ho = null;
                        this.w = null;
                        this.k = null;
                        this.m = null;
                        ntVar.pr(cVar, this.zo.hn(), this.zo.hw(), null, e);
                        if (cVar2 == null) {
                            cVar2 = new c(e);
                        } else {
                            cVar2.pr(e);
                        }
                        if (!z) {
                            throw cVar2;
                        }
                        if (!hwVar.pr(e)) {
                            throw cVar2;
                        }
                    }
                }
                pr(hwVar, cVar, ntVar);
                ntVar.pr(cVar, this.zo.hn(), this.zo.hw(), this.k);
                break;
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (this.zo.x() && this.aj == null) {
            throw new c(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        if (this.m != null) {
            synchronized (this.fw) {
                this.hn = this.m.pr();
            }
        }
    }

    private void pr(int i, int i2, int i3, com.byazt.jv.c cVar, nt ntVar) throws IOException {
        b bVarUc = uc();
        qa qaVarPr = bVarUc.pr();
        for (int i4 = 0; i4 < 21; i4++) {
            pr(i, i2, cVar, ntVar);
            bVarUc = pr(i2, i3, bVarUc, qaVarPr);
            if (bVarUc != null) {
                com.byazt.xx.hn.pr(this.aj);
                this.aj = null;
                this.ho = null;
                this.g = null;
                ntVar.pr(cVar, this.zo.hn(), this.zo.hw(), null);
            } else {
                return;
            }
        }
    }

    private void pr(int i, int i2, com.byazt.jv.c cVar, nt ntVar) throws IOException {
        Proxy proxyHw = this.zo.hw();
        Socket socketCreateSocket = (proxyHw.type() == Proxy.Type.DIRECT || proxyHw.type() == Proxy.Type.HTTP) ? this.zo.pr().hn().createSocket() : new Socket(proxyHw);
        this.aj = socketCreateSocket;
        socketCreateSocket.setSoTimeout(i2);
        try {
            com.byazt.lp.c.hw().pr(this.aj, this.zo.hn(), i);
            try {
                this.g = k.pr(k.hw(this.aj));
                this.ho = k.pr(k.pr(this.aj));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.zo.hn());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void pr(hw hwVar, com.byazt.jv.c cVar, nt ntVar) throws Throwable {
        if (this.zo.pr().aj() == null) {
            this.k = rc.HTTP_1_1;
            this.vk = this.aj;
            return;
        }
        pr(hwVar);
        try {
            if (this.k == rc.HTTP_2) {
                this.vk.setSoTimeout(0);
                com.byazt.cpq.fw fwVarPr = new com.byazt.cpq.fw.pr(true).pr(this.vk, this.zo.pr().pr().uc(), this.g, this.ho).pr(this).pr();
                this.m = fwVarPr;
                fwVarPr.hn();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Throwable] */
    private void pr(hw hwVar) throws Throwable {
        com.byazt.jv.pr prVarPr = this.zo.pr();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) prVarPr.aj().createSocket(this.aj, prVarPr.pr().uc(), prVarPr.pr().fw(), true);
                try {
                    w wVarPr = hwVar.pr(sSLSocket2);
                    if (wVarPr.x()) {
                        com.byazt.lp.c.hw().pr(sSLSocket2, prVarPr.pr().uc(), prVarPr.c());
                    }
                    try {
                        sSLSocket2.startHandshake();
                    } catch (Throwable th) {
                    }
                    yb ybVarPr = yb.pr(sSLSocket2.getSession());
                    if (!prVarPr.vk().verify(prVarPr.pr().uc(), sSLSocket2.getSession())) {
                        X509Certificate x509Certificate = (X509Certificate) ybVarPr.hn().get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + prVarPr.pr().uc() + " not verified:\n    certificate: " + com.byazt.jv.fw.pr((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.byazt.di.c.pr(x509Certificate));
                    }
                    prVarPr.w().pr(prVarPr.pr().uc(), ybVarPr.hn());
                    String strPr = wVarPr.x() ? com.byazt.lp.c.hw().pr(sSLSocket2) : null;
                    this.vk = sSLSocket2;
                    this.g = k.pr(k.hw(sSLSocket2));
                    this.ho = k.pr(k.pr(this.vk));
                    this.w = ybVarPr;
                    this.k = strPr != null ? rc.pr(strPr) : rc.HTTP_1_1;
                    if (sSLSocket2 != null) {
                        com.byazt.lp.c.hw().hw(sSLSocket2);
                    }
                } catch (AssertionError e) {
                    e = e;
                    if (!com.byazt.xx.hn.pr(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th2) {
                    th = th2;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        com.byazt.lp.c.hw().hw(sSLSocket);
                    }
                    com.byazt.xx.hn.pr((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (AssertionError e2) {
            e = e2;
        }
    }

    /* JADX WARN: Switch 'out' block B:3:0x001a for B:7:0x0072 already processed. Defaulting to fallback option. */
    private b pr(int i, int i2, b bVar, qa qaVar) throws IOException {
        String str = "CONNECT " + com.byazt.xx.hn.pr(qaVar, true) + " HTTP/1.1";
        while (true) {
            com.byazt.px.pr prVar = new com.byazt.px.pr(null, null, this.g, this.ho);
            this.g.pr().pr(i, TimeUnit.MILLISECONDS);
            this.ho.pr().pr(i2, TimeUnit.MILLISECONDS);
            prVar.pr(bVar.hn(), str);
            prVar.hw();
            gz gzVarPr = prVar.pr(false).pr(bVar).pr();
            long jPr = com.byazt.osx.c.pr(gzVarPr);
            if (jPr == -1) {
                jPr = 0;
            }
            com.byazt.du.qa qaVarHw = prVar.hw(jPr);
            com.byazt.xx.hn.hw(qaVarHw, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            qaVarHw.close();
            switch (gzVarPr.x()) {
                case 200:
                    if (this.g.hn().c() && this.ho.hn().c()) {
                        return null;
                    }
                    throw new IOException("TLS tunnel buffered too many bytes!");
                case 407:
                    b bVarPr = this.zo.pr().x().pr(this.zo, gzVarPr);
                    if (bVarPr == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                    if (ILivePush.ClickType.CLOSE.equalsIgnoreCase(gzVarPr.hw("Connection"))) {
                        return bVarPr;
                    }
                    bVar = bVarPr;
                    break;
                    break;
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + gzVarPr.x());
            }
        }
    }

    private b uc() {
        return new b.pr().pr(this.zo.pr().pr()).pr("Host", com.byazt.xx.hn.pr(this.zo.pr().pr(), true)).pr("Proxy-Connection", "Keep-Alive").pr("User-Agent", com.byazt.xx.x.pr()).pr();
    }

    public boolean pr(com.byazt.jv.pr prVar, y yVar) {
        if (this.x.size() >= this.hn || this.pr || !com.byazt.xx.pr.pr.pr(this.zo.pr(), prVar)) {
            return false;
        }
        if (prVar.pr().uc().equals(pr().pr().pr().uc())) {
            return true;
        }
        if (this.m == null || yVar == null || yVar.hw().type() != Proxy.Type.DIRECT || this.zo.hw().type() != Proxy.Type.DIRECT || !this.zo.hn().equals(yVar.hn()) || yVar.pr().vk() != com.byazt.di.c.pr || !pr(prVar.pr())) {
            return false;
        }
        try {
            prVar.w().pr(prVar.pr().uc(), x().hn());
            return true;
        } catch (SSLPeerUnverifiedException e) {
            return false;
        }
    }

    public boolean pr(qa qaVar) {
        if (qaVar.fw() != this.zo.pr().pr().fw()) {
            return false;
        }
        if (qaVar.uc().equals(this.zo.pr().pr().uc())) {
            return true;
        }
        return this.w != null && com.byazt.di.c.pr.pr(qaVar.uc(), (X509Certificate) this.w.hn().get(0));
    }

    public com.byazt.osx.hn pr(fo foVar, a.pr prVar, fw fwVar) throws SocketException {
        if (this.m != null) {
            return new com.byazt.cpq.uc(foVar, prVar, fwVar, this.m);
        }
        this.vk.setSoTimeout(prVar.hn());
        this.g.pr().pr(prVar.hn(), TimeUnit.MILLISECONDS);
        this.ho.pr().pr(prVar.x(), TimeUnit.MILLISECONDS);
        return new com.byazt.px.pr(foVar, fwVar, this.g, this.ho);
    }

    @Override // com.byazt.jv.aj
    public y pr() {
        return this.zo;
    }

    public void hw() {
        com.byazt.xx.hn.pr(this.aj);
    }

    public Socket hn() {
        return this.vk;
    }

    public boolean pr(boolean z) {
        if (this.vk.isClosed() || this.vk.isInputShutdown() || this.vk.isOutputShutdown()) {
            return false;
        }
        com.byazt.cpq.fw fwVar = this.m;
        if (fwVar != null) {
            return !fwVar.x();
        }
        if (z) {
            try {
                int soTimeout = this.vk.getSoTimeout();
                try {
                    this.vk.setSoTimeout(1);
                    if (this.g.c()) {
                        this.vk.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.vk.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.vk.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException e) {
            } catch (IOException e2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.byazt.cpq.fw.hw
    public void pr(com.byazt.cpq.aj ajVar) throws IOException {
        ajVar.pr(com.byazt.cpq.hw.REFUSED_STREAM);
    }

    @Override // com.byazt.cpq.fw.hw
    public void pr(com.byazt.cpq.fw fwVar) {
        synchronized (this.fw) {
            this.hn = fwVar.pr();
        }
    }

    public yb x() {
        return this.w;
    }

    public boolean c() {
        return this.m != null;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Connection{").append(this.zo.pr().pr().uc()).append(":").append(this.zo.pr().pr().fw()).append(", proxy=").append(this.zo.hw()).append(" hostAddress=").append(this.zo.hn()).append(" cipherSuite=");
        yb ybVar = this.w;
        return sbAppend.append(ybVar != null ? ybVar.hw() : "none").append(" protocol=").append(this.k).append(AbstractJsonLexerKt.END_OBJ).toString();
    }
}
