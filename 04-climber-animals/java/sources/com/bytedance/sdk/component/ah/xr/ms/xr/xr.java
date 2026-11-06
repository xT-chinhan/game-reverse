package com.bytedance.sdk.component.ah.xr.ms.xr;

import com.bytedance.sdk.component.ah.xr.hi;
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
public final class xr {
    private boolean ah;
    private boolean d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final List<hi> f1131ms;
    private int xr = 0;

    public xr(List<hi> list) {
        this.f1131ms = list;
    }

    public hi ms(SSLSocket sSLSocket) throws IOException {
        hi hiVar;
        int i = this.xr;
        int size = this.f1131ms.size();
        while (true) {
            if (i >= size) {
                hiVar = null;
                break;
            }
            hiVar = this.f1131ms.get(i);
            if (hiVar.ms(sSLSocket)) {
                this.xr = i + 1;
                break;
            }
            i++;
        }
        if (hiVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.f1131ms + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.ah = xr(sSLSocket);
        com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms.ms(hiVar, sSLSocket, this.d);
        return hiVar;
    }

    public boolean ms(IOException iOException) {
        this.d = true;
        if (!this.ah || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }

    private boolean xr(SSLSocket sSLSocket) {
        for (int i = this.xr; i < this.f1131ms.size(); i++) {
            if (this.f1131ms.get(i).ms(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
