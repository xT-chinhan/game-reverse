package com.bytedance.sdk.openadsdk.core.p;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends ms {
    private static final String[] xr = {"TLSv1.2"};
    private final xr ah;

    public String toString() {
        return "Tls12SocketFactory";
    }

    public ab(SSLSocketFactory sSLSocketFactory, xr xrVar) {
        this.f3245ms = sSLSocketFactory;
        this.ah = xrVar;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f3245ms.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f3245ms.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return ms(this.f3245ms.createSocket());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return ms(this.f3245ms.createSocket(socket, str, i, z));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return ms(this.f3245ms.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return ms(this.f3245ms.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return ms(this.f3245ms.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return ms(this.f3245ms.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private Socket ms(Socket socket) {
        boolean z = socket instanceof SSLSocket;
        this.ah.ms("socketip", socket.getLocalAddress().getHostAddress());
        return socket;
    }
}
