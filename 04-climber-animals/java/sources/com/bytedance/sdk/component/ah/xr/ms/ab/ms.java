package com.bytedance.sdk.component.ah.xr.ms.ab;

import android.net.ssl.SSLSockets;
import android.os.Build;
import android.util.Log;
import com.bytedance.sdk.component.ah.xr.i;
import com.bytedance.sdk.component.ah.xr.ms.ny.c;
import com.bytedance.sdk.component.utils.sl;
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
class ms extends ka {
    private final d<Socket> ah;
    private final ah c = ah.ms();
    private final d<Socket> d;
    private final d<Socket> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Class<?> f1052ms;
    private final d<Socket> xr;

    ms(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        this.f1052ms = cls;
        this.xr = dVar;
        this.ah = dVar2;
        this.d = dVar3;
        this.ka = dVar4;
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ab.ka
    public void ms(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!com.bytedance.sdk.component.ah.xr.ms.ah.ms(e)) {
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

    @Override // com.bytedance.sdk.component.ah.xr.ms.ab.ka
    public void ms(SSLSocket sSLSocket, String str, List<i> list) {
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
                this.xr.xr(sSLSocket, Boolean.TRUE);
                this.ah.xr(sSLSocket, str);
            }
        }
        d<Socket> dVar = this.ka;
        if (dVar == null || !dVar.ms(sSLSocket)) {
            return;
        }
        this.ka.d(sSLSocket, xr(list));
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ab.ka
    public String ms(SSLSocket sSLSocket) {
        byte[] bArr;
        d<Socket> dVar = this.d;
        if (dVar == null || !dVar.ms(sSLSocket) || (bArr = (byte[]) this.d.d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, com.bytedance.sdk.component.ah.xr.ms.ah.ka);
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ab.ka
    public void ms(int i, String str, Throwable th) {
        int iMin;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int iIndexOf = str.indexOf(10, i3);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i3 + TTAdConstant.INIT_LOCAL_FAIL_CODE);
                sl.ms(i2, "OkHttp", str.substring(i3, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i3 = iMin;
                }
            }
            i3 = iMin + 1;
        }
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ab.ka
    public Object ms(String str) {
        return this.c.ms(str);
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ab.ka
    public void ms(String str, Object obj) {
        if (this.c.ms(obj)) {
            return;
        }
        ms(5, str, (Throwable) null);
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ab.ka
    public boolean xr(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return ms(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.xr(str);
        } catch (IllegalAccessException e) {
            e = e;
            throw com.bytedance.sdk.component.ah.xr.ms.ah.ms("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw com.bytedance.sdk.component.ah.xr.ms.ah.ms("unable to determine cleartext support", e);
        } catch (NoClassDefFoundError unused2) {
            return false;
        } catch (InvocationTargetException e3) {
            e = e3;
            throw com.bytedance.sdk.component.ah.xr.ms.ah.ms("unable to determine cleartext support", e);
        }
    }

    private boolean ms(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return xr(str, cls, obj);
        }
    }

    private boolean xr(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.xr(str);
        }
    }

    private static boolean d() {
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

    @Override // com.bytedance.sdk.component.ah.xr.ms.ab.ka
    public com.bytedance.sdk.component.ah.xr.ms.ny.ah ms(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0240ms(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.ms(x509TrustManager);
        }
    }

    public static ka ms() {
        Class<?> cls;
        d dVar;
        d dVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            d dVar3 = new d(null, "setUseSessionTickets", Boolean.TYPE);
            d dVar4 = new d(null, "setHostname", String.class);
            if (d()) {
                d dVar5 = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                dVar2 = new d(null, "setAlpnProtocols", byte[].class);
                dVar = dVar5;
            } else {
                dVar = null;
                dVar2 = null;
            }
            return new ms(cls2, dVar3, dVar4, dVar, dVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ab.ka
    public c xr(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new xr(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.xr(x509TrustManager);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.ah.xr.ms.ab.ms$ms, reason: collision with other inner class name */
    static final class C0240ms extends com.bytedance.sdk.component.ah.xr.ms.ny.ah {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final Object f1054ms;
        private final Method xr;

        public int hashCode() {
            return 0;
        }

        C0240ms(Object obj, Method method) {
            this.f1054ms = obj;
            this.xr = method;
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.ny.ah
        public List<Certificate> ms(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.xr.invoke(this.f1054ms, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0240ms;
        }
    }

    static final class ah {
        private final Method ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final Method f1053ms;
        private final Method xr;

        ah(Method method, Method method2, Method method3) {
            this.f1053ms = method;
            this.xr = method2;
            this.ah = method3;
        }

        Object ms(String str) {
            Method method = this.f1053ms;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.xr.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean ms(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.ah.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        static ah ms() {
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
            return new ah(method, method3, method2);
        }
    }

    static final class xr implements c {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final X509TrustManager f1055ms;
        private final Method xr;

        xr(X509TrustManager x509TrustManager, Method method) {
            this.xr = method;
            this.f1055ms = x509TrustManager;
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.ny.c
        public X509Certificate ms(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.xr.invoke(this.f1055ms, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e) {
                throw com.bytedance.sdk.component.ah.xr.ms.ah.ms("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof xr)) {
                return false;
            }
            xr xrVar = (xr) obj;
            return this.f1055ms.equals(xrVar.f1055ms) && this.xr.equals(xrVar.xr);
        }

        public int hashCode() {
            return this.f1055ms.hashCode() + (this.xr.hashCode() * 31);
        }
    }
}
