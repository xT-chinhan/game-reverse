package com.byazt.sqs;

import com.byazt.pq.cp;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 707, 26})
public final class qg {
    public final List<cp> n;
    public boolean q;
    public int qg = 0;
    public boolean s;

    public qg(List<cp> list) {
        this.n = list;
    }

    public cp n(SSLSocket sSLSocket) throws IOException {
        cp cpVar;
        int i = this.qg;
        int size = this.n.size();
        while (true) {
            if (i >= size) {
                cpVar = null;
                break;
            }
            cpVar = this.n.get(i);
            if (cpVar.n(sSLSocket)) {
                this.qg = i + 1;
                break;
            }
            i++;
        }
        if (cpVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.q + ", modes=" + this.n + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.s = qg(sSLSocket);
        com.byazt.zho.n.n.n(cpVar, sSLSocket, this.q);
        return cpVar;
    }

    public boolean n(IOException iOException) {
        this.q = true;
        if (!this.s || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }

    private boolean qg(SSLSocket sSLSocket) {
        for (int i = this.qg; i < this.n.size(); i++) {
            if (this.n.get(i).n(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
