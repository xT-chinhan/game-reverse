package com.anythink.core.common.n.b.a.b;

import com.anythink.core.common.n.b.l;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
final class b {
    private final List<l> a;
    private int b = 0;
    private boolean c;
    private boolean d;

    b(List<l> list) {
        this.a = list;
    }

    final l a(SSLSocket sSLSocket) throws UnknownServiceException {
        l lVar;
        int i = this.b;
        int size = this.a.size();
        while (true) {
            if (i >= size) {
                lVar = null;
                break;
            }
            lVar = this.a.get(i);
            if (lVar.a(sSLSocket)) {
                this.b = i + 1;
                break;
            }
            i++;
        }
        if (lVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.c = b(sSLSocket);
        com.anythink.core.common.n.b.a.a.a.a(lVar, sSLSocket, this.d);
        return lVar;
    }

    final boolean a(IOException iOException) {
        this.d = true;
        if (!this.c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return iOException instanceof SSLException;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.b; i < this.a.size(); i++) {
            if (this.a.get(i).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
