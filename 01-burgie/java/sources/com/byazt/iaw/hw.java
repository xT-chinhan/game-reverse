package com.byazt.iaw;

import com.byazt.jv.w;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 507, 13})
public final class hw {
    public boolean hn;
    public int hw = 0;
    public final List<w> pr;
    public boolean x;

    public hw(List<w> list) {
        this.pr = list;
    }

    public w pr(SSLSocket sSLSocket) throws IOException {
        w wVar;
        int i = this.hw;
        int size = this.pr.size();
        while (true) {
            if (i >= size) {
                wVar = null;
                break;
            }
            wVar = this.pr.get(i);
            if (!wVar.pr(sSLSocket)) {
                i++;
            } else {
                this.hw = i + 1;
                break;
            }
        }
        if (wVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.x + ", modes=" + this.pr + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.hn = hw(sSLSocket);
        com.byazt.xx.pr.pr.pr(wVar, sSLSocket, this.x);
        return wVar;
    }

    public boolean pr(IOException iOException) {
        this.x = true;
        if (!this.hn || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }

    private boolean hw(SSLSocket sSLSocket) {
        for (int i = this.hw; i < this.pr.size(); i++) {
            if (this.pr.get(i).pr(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
