package com.byazt.lp;

import android.net.ssl.SSLSockets;
import android.os.Build;
import android.util.Log;
import com.byazt.di.uc;
import com.byazt.jv.rc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mar.sdk.MARCode;
import com.mar.sdk.utils.RSAUtils;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, 37})
public class pr extends c {
    public final x<Socket> c;
    public final x<Socket> hn;
    public final x<Socket> hw;
    public final Class<?> pr;
    public final hn uc = hn.pr();
    public final x<Socket> x;

    public pr(Class<?> cls, x<Socket> xVar, x<Socket> xVar2, x<Socket> xVar3, x<Socket> xVar4) {
        this.pr = cls;
        this.hw = xVar;
        this.hn = xVar2;
        this.x = xVar3;
        this.c = xVar4;
    }

    @Override // com.byazt.lp.c
    public void pr(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!com.byazt.xx.hn.pr(e)) {
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
        } catch (Exception e4) {
        }
    }

    @Override // com.byazt.lp.c
    public void pr(SSLSocket sSLSocket, String str, List<rc> list) {
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    SSLSockets.setUseSessionTickets(sSLSocket, true);
                    SNIHostName sNIHostName = new SNIHostName(str);
                    SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                    sSLParameters.setServerNames(Collections.singletonList(sNIHostName));
                    sSLSocket.setSSLParameters(sSLParameters);
                } catch (Throwable th) {
                }
            } else {
                this.hw.hw(sSLSocket, Boolean.TRUE);
                this.hn.hw(sSLSocket, str);
            }
        }
        x<Socket> xVar = this.c;
        if (xVar != null && xVar.pr(sSLSocket)) {
            this.c.x(sSLSocket, hw(list));
        }
    }

    @Override // com.byazt.lp.c
    public String pr(SSLSocket sSLSocket) {
        byte[] bArr;
        x<Socket> xVar = this.x;
        if (xVar == null || !xVar.pr(sSLSocket) || (bArr = (byte[]) this.x.x(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, com.byazt.xx.hn.c);
    }

    @Override // com.byazt.lp.c
    public void pr(int i, String str, Throwable th) {
        int iMin;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i2 = 0;
        int length = str.length();
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

    @Override // com.byazt.lp.c
    public Object pr(String str) {
        return this.uc.pr(str);
    }

    @Override // com.byazt.lp.c
    public void pr(String str, Object obj) {
        if (!this.uc.pr(obj)) {
            pr(5, str, (Throwable) null);
        }
    }

    @Override // com.byazt.lp.c
    public boolean hw(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return pr(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException e) {
            return super.hw(str);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw com.byazt.xx.hn.pr("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw com.byazt.xx.hn.pr("unable to determine cleartext support", e);
        } catch (NoClassDefFoundError e4) {
            if (Build.VERSION.SDK_INT >= 23) {
                return false;
            }
            return super.hw(str);
        } catch (NoSuchMethodException e5) {
            return super.hw(str);
        } catch (InvocationTargetException e6) {
            e = e6;
            throw com.byazt.xx.hn.pr("unable to determine cleartext support", e);
        }
    }

    private boolean pr(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException e) {
            return hw(str, cls, obj);
        }
    }

    private boolean hw(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException e) {
            return super.hw(str);
        }
    }

    private static boolean x() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    @Override // com.byazt.lp.c
    public com.byazt.di.hn pr(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0124pr(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception e) {
            return super.pr(x509TrustManager);
        }
    }

    public static c pr() {
        Class<?> cls;
        x xVar;
        x xVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException e) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            x xVar3 = new x(null, "setUseSessionTickets", Boolean.TYPE);
            x xVar4 = new x(null, "setHostname", String.class);
            if (!x()) {
                xVar = null;
                xVar2 = null;
            } else {
                x xVar5 = new x(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                xVar2 = new x(null, "setAlpnProtocols", byte[].class);
                xVar = xVar5;
            }
            return new pr(cls, xVar3, xVar4, xVar, xVar2);
        } catch (ClassNotFoundException e2) {
            return null;
        }
    }

    @Override // com.byazt.lp.c
    public uc hw(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new hw(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException e) {
            return super.hw(x509TrustManager);
        }
    }

    /* JADX INFO: renamed from: com.byazt.lp.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    static final class C0124pr extends com.byazt.di.hn {
        public final Method hw;
        public final Object pr;

        public C0124pr(Object obj, Method method) {
            this.pr = obj;
            this.hw = method;
        }

        @Override // com.byazt.di.hn
        public List<Certificate> pr(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.hw.invoke(this.pr, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), RSAUtils.KEY_ALGORITHM, str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0124pr;
        }

        public int hashCode() {
            return 0;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, MediaPlayer.MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END})
    static final class hn {
        public final Method hn;
        public final Method hw;
        public final Method pr;

        public hn(Method method, Method method2, Method method3) {
            this.pr = method;
            this.hw = method2;
            this.hn = method3;
        }

        public Object pr(String str) {
            Method method = this.pr;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.hw.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception e) {
                }
            }
            return null;
        }

        public boolean pr(Object obj) {
            if (obj != null) {
                try {
                    this.hn.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
            return false;
        }

        public static hn pr() throws NoSuchMethodException {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception e) {
                method = null;
                method2 = null;
            }
            return new hn(method3, method2, method);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    static final class hw implements uc {
        public final Method hw;
        public final X509TrustManager pr;

        public hw(X509TrustManager x509TrustManager, Method method) {
            this.hw = method;
            this.pr = x509TrustManager;
        }

        @Override // com.byazt.di.uc
        public X509Certificate pr(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.hw.invoke(this.pr, x509Certificate);
                if (trustAnchor == null) {
                    return null;
                }
                return trustAnchor.getTrustedCert();
            } catch (IllegalAccessException e) {
                throw com.byazt.xx.hn.pr("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException e2) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof hw)) {
                return false;
            }
            hw hwVar = (hw) obj;
            return this.pr.equals(hwVar.pr) && this.hw.equals(hwVar.hw);
        }

        public int hashCode() {
            return this.pr.hashCode() + (this.hw.hashCode() * 31);
        }
    }
}
