package com.bytedance.sdk.component.ah.xr.ms.xr;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.component.ah.ms.sl;
import com.bytedance.sdk.component.ah.xr.ao;
import com.bytedance.sdk.component.ah.xr.ch;
import com.bytedance.sdk.component.ah.xr.cv;
import com.bytedance.sdk.component.ah.xr.h;
import com.bytedance.sdk.component.ah.xr.hi;
import com.bytedance.sdk.component.ah.xr.i;
import com.bytedance.sdk.component.ah.xr.ny;
import com.bytedance.sdk.component.ah.xr.of;
import com.bytedance.sdk.component.ah.xr.re;
import com.bytedance.sdk.component.ah.xr.t;
import com.bytedance.sdk.component.ah.xr.y;
import com.bytedance.sdk.component.ah.xr.yu;
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
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public final class ah extends com.bytedance.sdk.component.ah.xr.ms.ka.ab.xr implements ny {
    private final ch ab;
    private Socket ch;
    private h hi;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public boolean f1125ms;
    private Socket ny;
    private i sl;
    private com.bytedance.sdk.component.ah.ms.ka u;
    private com.bytedance.sdk.component.ah.ms.d ub;
    private final of x;
    public int xr;
    private com.bytedance.sdk.component.ah.xr.ms.ka.ab zb;
    public int ah = 1;
    public final List<Reference<ab>> d = new ArrayList();
    public long ka = Long.MAX_VALUE;

    public ah(ch chVar, of ofVar) {
        this.ab = chVar;
        this.x = ofVar;
    }

    public void ms(int i, int i2, int i3, boolean z, com.bytedance.sdk.component.ah.xr.ka kaVar, ao aoVar) {
        if (this.sl != null) {
            throw new IllegalStateException("already connected");
        }
        List<hi> listC = this.x.ms().c();
        xr xrVar = new xr(listC);
        if (this.x.ms().ny() == null) {
            if (!listC.contains(hi.ah)) {
                throw new ka(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strAb = this.x.ms().ms().ab();
            if (!com.bytedance.sdk.component.ah.xr.ms.ab.ka.xr().xr(strAb)) {
                throw new ka(new UnknownServiceException("CLEARTEXT communication to " + strAb + " not permitted by network security policy"));
            }
        }
        ka kaVar2 = null;
        while (true) {
            try {
                if (this.x.d()) {
                    ms(i, i2, i3, kaVar, aoVar);
                    if (this.ny == null) {
                        break;
                    }
                } else {
                    try {
                        ms(i, i2, kaVar, aoVar);
                    } catch (IOException e) {
                        e = e;
                        com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.ch);
                        com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.ny);
                        this.ch = null;
                        this.ny = null;
                        this.u = null;
                        this.ub = null;
                        this.hi = null;
                        this.sl = null;
                        this.zb = null;
                        aoVar.ms(kaVar, this.x.ah(), this.x.xr(), null, e);
                        if (kaVar2 == null) {
                            kaVar2 = new ka(e);
                        } else {
                            kaVar2.ms(e);
                        }
                        if (z) {
                            if (!xrVar.ms(e)) {
                                throw kaVar2;
                            }
                        } else {
                            throw kaVar2;
                        }
                    }
                }
                ms(xrVar, kaVar, aoVar);
                break;
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (this.x.d() && this.ny == null) {
            throw new ka(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        if (this.zb != null) {
            synchronized (this.ab) {
                this.ah = this.zb.ms();
            }
        }
    }

    private void ms(int i, int i2, int i3, com.bytedance.sdk.component.ah.xr.ka kaVar, ao aoVar) throws IOException {
        yu yuVarC = c();
        y yVarMs = yuVarC.ms();
        for (int i4 = 0; i4 < 21; i4++) {
            ms(i, i2, kaVar, aoVar);
            yuVarC = ms(i2, i3, yuVarC, yVarMs);
            if (yuVarC == null) {
                return;
            }
            com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.ny);
            this.ny = null;
            this.ub = null;
            this.u = null;
        }
    }

    private void ms(int i, int i2, com.bytedance.sdk.component.ah.xr.ka kaVar, ao aoVar) throws IOException {
        Proxy proxyXr = this.x.xr();
        Socket socketCreateSocket = (proxyXr.type() == Proxy.Type.DIRECT || proxyXr.type() == Proxy.Type.HTTP) ? this.x.ms().ah().createSocket() : new Socket(proxyXr);
        this.ny = socketCreateSocket;
        socketCreateSocket.setSoTimeout(i2);
        try {
            com.bytedance.sdk.component.ah.xr.ms.ab.ka.xr().ms(this.ny, this.x.ah(), i);
            try {
                this.u = sl.ms(sl.xr(this.ny));
                this.ub = sl.ms(sl.ms(this.ny));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.x.ah());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void ms(xr xrVar, com.bytedance.sdk.component.ah.xr.ka kaVar, ao aoVar) throws Throwable {
        if (this.x.ms().ny() == null) {
            this.sl = i.HTTP_1_1;
            this.ch = this.ny;
            return;
        }
        ms(xrVar);
        try {
            if (this.sl == i.HTTP_2) {
                this.ch.setSoTimeout(0);
                com.bytedance.sdk.component.ah.xr.ms.ka.ab abVarMs = new com.bytedance.sdk.component.ah.xr.ms.ka.ab.ms(true).ms(this.ch, this.x.ms().ms().ab(), this.u, this.ub).ms(this).ms();
                this.zb = abVarMs;
                abVarMs.ah();
            }
        } catch (Throwable unused) {
        }
    }

    private void ms(xr xrVar) throws Throwable {
        com.bytedance.sdk.component.ah.xr.ms msVarMs = this.x.ms();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) msVarMs.ny().createSocket(this.ny, msVarMs.ms().ab(), msVarMs.ms().x(), true);
                try {
                    hi hiVarMs = xrVar.ms(sSLSocket2);
                    if (hiVarMs.d()) {
                        com.bytedance.sdk.component.ah.xr.ms.ab.ka.xr().ms(sSLSocket2, msVarMs.ms().ab(), msVarMs.ka());
                    }
                    try {
                        sSLSocket2.startHandshake();
                    } catch (Throwable unused) {
                    }
                    h hVarMs = h.ms(sSLSocket2.getSession());
                    if (!msVarMs.ch().verify(msVarMs.ms().ab(), sSLSocket2.getSession())) {
                        X509Certificate x509Certificate = (X509Certificate) hVarMs.ah().get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + msVarMs.ms().ab() + " not verified:\n    certificate: " + com.bytedance.sdk.component.ah.xr.ab.ms((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.component.ah.xr.ms.ny.ka.ms(x509Certificate));
                    }
                    msVarMs.hi().ms(msVarMs.ms().ab(), hVarMs.ah());
                    String strMs = hiVarMs.d() ? com.bytedance.sdk.component.ah.xr.ms.ab.ka.xr().ms(sSLSocket2) : null;
                    this.ch = sSLSocket2;
                    this.u = sl.ms(sl.xr(sSLSocket2));
                    this.ub = sl.ms(sl.ms(this.ch));
                    this.hi = hVarMs;
                    this.sl = strMs != null ? i.ms(strMs) : i.HTTP_1_1;
                    if (sSLSocket2 != null) {
                        com.bytedance.sdk.component.ah.xr.ms.ab.ka.xr().xr(sSLSocket2);
                    }
                } catch (AssertionError e) {
                    e = e;
                    if (!com.bytedance.sdk.component.ah.xr.ms.ah.ms(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        com.bytedance.sdk.component.ah.xr.ms.ab.ka.xr().xr(sSLSocket);
                    }
                    com.bytedance.sdk.component.ah.xr.ms.ah.ms((Socket) sSLSocket);
                    throw th;
                }
            } catch (AssertionError e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private yu ms(int i, int i2, yu yuVar, y yVar) throws IOException {
        String str = "CONNECT " + com.bytedance.sdk.component.ah.xr.ms.ah.ms(yVar, true) + " HTTP/1.1";
        while (true) {
            com.bytedance.sdk.component.ah.xr.ms.d.ms msVar = new com.bytedance.sdk.component.ah.xr.ms.d.ms(null, null, this.u, this.ub);
            this.u.ms().ms(i, TimeUnit.MILLISECONDS);
            this.ub.ms().ms(i2, TimeUnit.MILLISECONDS);
            msVar.ms(yuVar.ah(), str);
            msVar.xr();
            cv cvVarMs = msVar.ms(false).ms(yuVar).ms();
            long jMs = com.bytedance.sdk.component.ah.xr.ms.ah.ka.ms(cvVarMs);
            if (jMs == -1) {
                jMs = 0;
            }
            com.bytedance.sdk.component.ah.ms.y yVarXr = msVar.xr(jMs);
            com.bytedance.sdk.component.ah.xr.ms.ah.xr(yVarXr, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            yVarXr.close();
            int iAh = cvVarMs.ah();
            if (iAh == 200) {
                if (this.u.ah().ka() && this.ub.ah().ka()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iAh == 407) {
                yu yuVarMs = this.x.ms().d().ms(this.x, cvVarMs);
                if (yuVarMs == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if (ILivePush.ClickType.CLOSE.equalsIgnoreCase(cvVarMs.ms("Connection"))) {
                    return yuVarMs;
                }
                yuVar = yuVarMs;
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + cvVarMs.ah());
            }
        }
    }

    private yu c() {
        return new yu.ms().ms(this.x.ms().ms()).ms("Host", com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.x.ms().ms(), true)).ms("Proxy-Connection", "Keep-Alive").ms("User-Agent", com.bytedance.sdk.component.ah.xr.ms.d.ms()).ms();
    }

    public boolean ms(com.bytedance.sdk.component.ah.xr.ms msVar, of ofVar) {
        if (this.d.size() >= this.ah || this.f1125ms || !com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms.ms(this.x.ms(), msVar)) {
            return false;
        }
        if (msVar.ms().ab().equals(ms().ms().ms().ab())) {
            return true;
        }
        if (this.zb == null || ofVar == null || ofVar.xr().type() != Proxy.Type.DIRECT || this.x.xr().type() != Proxy.Type.DIRECT || !this.x.ah().equals(ofVar.ah()) || ofVar.ms().ch() != com.bytedance.sdk.component.ah.xr.ms.ny.ka.f1119ms || !ms(msVar.ms())) {
            return false;
        }
        try {
            msVar.hi().ms(msVar.ms().ab(), d().ah());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean ms(y yVar) {
        if (yVar.x() != this.x.ms().ms().x()) {
            return false;
        }
        if (yVar.ab().equals(this.x.ms().ms().ab())) {
            return true;
        }
        return this.hi != null && com.bytedance.sdk.component.ah.xr.ms.ny.ka.f1119ms.ms(yVar.ab(), (X509Certificate) this.hi.ah().get(0));
    }

    public com.bytedance.sdk.component.ah.xr.ms.ah.ah ms(re reVar, t.ms msVar, ab abVar) throws SocketException {
        if (this.zb != null) {
            return new com.bytedance.sdk.component.ah.xr.ms.ka.c(reVar, msVar, abVar, this.zb);
        }
        this.ch.setSoTimeout(msVar.ah());
        this.u.ms().ms(msVar.ah(), TimeUnit.MILLISECONDS);
        this.ub.ms().ms(msVar.d(), TimeUnit.MILLISECONDS);
        return new com.bytedance.sdk.component.ah.xr.ms.d.ms(reVar, abVar, this.u, this.ub);
    }

    @Override // com.bytedance.sdk.component.ah.xr.ny
    public of ms() {
        return this.x;
    }

    public void xr() {
        com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.ny);
    }

    public Socket ah() {
        return this.ch;
    }

    public boolean ms(boolean z) {
        if (this.ch.isClosed() || this.ch.isInputShutdown() || this.ch.isOutputShutdown()) {
            return false;
        }
        com.bytedance.sdk.component.ah.xr.ms.ka.ab abVar = this.zb;
        if (abVar != null) {
            return !abVar.d();
        }
        if (z) {
            try {
                int soTimeout = this.ch.getSoTimeout();
                try {
                    this.ch.setSoTimeout(1);
                    if (this.u.ka()) {
                        this.ch.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.ch.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.ch.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ka.ab.xr
    public void ms(com.bytedance.sdk.component.ah.xr.ms.ka.ny nyVar) throws IOException {
        nyVar.ms(com.bytedance.sdk.component.ah.xr.ms.ka.xr.REFUSED_STREAM);
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ka.ab.xr
    public void ms(com.bytedance.sdk.component.ah.xr.ms.ka.ab abVar) {
        synchronized (this.ab) {
            this.ah = abVar.ms();
        }
    }

    public h d() {
        return this.hi;
    }

    public boolean ka() {
        return this.zb != null;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Connection{").append(this.x.ms().ms().ab()).append(":").append(this.x.ms().ms().x()).append(", proxy=").append(this.x.xr()).append(" hostAddress=").append(this.x.ah()).append(" cipherSuite=");
        h hVar = this.hi;
        return sbAppend.append(hVar != null ? hVar.xr() : "none").append(" protocol=").append(this.sl).append(AbstractJsonLexerKt.END_OBJ).toString();
    }
}
