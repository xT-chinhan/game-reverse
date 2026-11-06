package ms.bz.bd.c.Pgl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes3.dex */
final class n1 extends SSLSocketFactory {
    private static final String[] qg = {(String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "6aab08", new byte[]{19, 79, 33, 0, 94, 97, 103})};
    final SSLSocketFactory n;

    public n1(SSLSocketFactory sSLSocketFactory) {
        this.n = sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException {
        Socket socketCreateSocket = this.n.createSocket(str, i);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(qg);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.n.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.n.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Socket socketCreateSocket = this.n.createSocket(str, i, inetAddress, i2);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(qg);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket socketCreateSocket = this.n.createSocket(inetAddress, i);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(qg);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket socketCreateSocket = this.n.createSocket(inetAddress, i, inetAddress2, i2);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(qg);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket socketCreateSocket = this.n.createSocket(socket, str, i, z);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(qg);
        }
        return socketCreateSocket;
    }
}
