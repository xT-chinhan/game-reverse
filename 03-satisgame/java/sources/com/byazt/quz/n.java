package com.byazt.quz;

import android.net.ssl.SSLSockets;
import android.os.Build;
import android.util.Log;
import com.byazt.pq.m;
import com.byazt.vw.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND, 19})
public class n extends l {
    public final q<Socket> l;
    public final Class<?> n;
    public final q<Socket> q;
    public final q<Socket> qg;
    public final q<Socket> s;
    public final s w = s.n();

    public n(Class<?> cls, q<Socket> qVar, q<Socket> qVar2, q<Socket> qVar3, q<Socket> qVar4) {
        this.n = cls;
        this.qg = qVar;
        this.s = qVar2;
        this.q = qVar3;
        this.l = qVar4;
    }

    @Override // com.byazt.quz.l
    public void n(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!com.byazt.zho.s.n(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e2);
                throw iOException;
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.quz.l
    public void n(SSLSocket sSLSocket, String str, List<m> list) {
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    SSLSockets.setUseSessionTickets(sSLSocket, true);
                    SNIHostName sNIHostName = new SNIHostName(str);
                    SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                    sSLParameters.setServerNames(Collections.singletonList(sNIHostName));
                    sSLSocket.setSSLParameters(sSLParameters);
                } catch (Throwable unused) {
                }
            } else {
                this.qg.qg(sSLSocket, Boolean.TRUE);
                this.s.qg(sSLSocket, str);
            }
        }
        q<Socket> qVar = this.l;
        if (qVar == null || !qVar.n(sSLSocket)) {
            return;
        }
        this.l.q(sSLSocket, qg(list));
    }

    @Override // com.byazt.quz.l
    public String n(SSLSocket sSLSocket) {
        byte[] bArr;
        q<Socket> qVar = this.q;
        if (qVar == null || !qVar.n(sSLSocket) || (bArr = (byte[]) this.q.q(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, com.byazt.zho.s.l);
    }

    @Override // com.byazt.quz.l
    public void n(int i, String str, Throwable th) {
        int iMin;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int iIndexOf = str.indexOf(10, i2);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i2 + TTAdConstant.INIT_LOCAL_FAIL_CODE);
                str.substring(i2, iMin);
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i2 = iMin;
                }
            }
            i2 = iMin + 1;
        }
    }

    @Override // com.byazt.quz.l
    public Object n(String str) {
        return this.w.n(str);
    }

    @Override // com.byazt.quz.l
    public void n(String str, Object obj) {
        if (this.w.n(obj)) {
            return;
        }
        n(5, str, (Throwable) null);
    }

    @Override // com.byazt.quz.l
    public boolean qg(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return n(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.qg(str);
        } catch (IllegalAccessException e) {
            e = e;
            throw com.byazt.zho.s.n("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw com.byazt.zho.s.n("unable to determine cleartext support", e);
        } catch (NoClassDefFoundError unused2) {
            return false;
        } catch (InvocationTargetException e3) {
            e = e3;
            throw com.byazt.zho.s.n("unable to determine cleartext support", e);
        }
    }

    private boolean n(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return qg(str, cls, obj);
        }
    }

    private boolean qg(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.qg(str);
        }
    }

    private static boolean q() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.byazt.quz.l
    public com.byazt.vw.s n(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0316n(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.n(x509TrustManager);
        }
    }

    public static l n() {
        Class<?> cls;
        q qVar;
        q qVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            q qVar3 = new q(null, "setUseSessionTickets", Boolean.TYPE);
            q qVar4 = new q(null, "setHostname", String.class);
            if (q()) {
                q qVar5 = new q(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                qVar2 = new q(null, "setAlpnProtocols", byte[].class);
                qVar = qVar5;
            } else {
                qVar = null;
                qVar2 = null;
            }
            return new n(cls2, qVar3, qVar4, qVar, qVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    @Override // com.byazt.quz.l
    public w qg(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new qg(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.qg(x509TrustManager);
        }
    }

    /* JADX INFO: renamed from: com.byazt.quz.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    static final class C0316n extends com.byazt.vw.s {
        public final Object n;
        public final Method qg;

        public int hashCode() {
            return 0;
        }

        public C0316n(Object obj, Method method) {
            this.n = obj;
            this.qg = method;
        }

        @Override // com.byazt.vw.s
        public List<Certificate> n(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.qg.invoke(this.n, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0316n;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND, 829})
    static final class s {
        public final Method n;
        public final Method qg;
        public final Method s;

        public s(Method method, Method method2, Method method3) {
            this.n = method;
            this.qg = method2;
            this.s = method3;
        }

        public Object n(String str) {
            Method method = this.n;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.qg.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public boolean n(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.s.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public static s n() {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod("get", new Class[0]);
                method3 = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new s(method, method3, method2);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND, 226})
    static final class qg implements w {
        public final X509TrustManager n;
        public final Method qg;

        public qg(X509TrustManager x509TrustManager, Method method) {
            this.qg = method;
            this.n = x509TrustManager;
        }

        @Override // com.byazt.vw.w
        public X509Certificate n(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.qg.invoke(this.n, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e) {
                throw com.byazt.zho.s.n("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof qg)) {
                return false;
            }
            qg qgVar = (qg) obj;
            return this.n.equals(qgVar.n) && this.qg.equals(qgVar.qg);
        }

        public int hashCode() {
            return this.n.hashCode() + (this.qg.hashCode() * 31);
        }
    }
}
