package com.anythink.core.common.m.b.a.g;

import com.anythink.core.common.m.b.a.j.f;
import com.anythink.core.common.m.b.ab;
import com.anythink.core.common.m.b.z;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final int a = 4;
    public static final int b = 5;
    private static final c c;
    private static final Logger d;

    private static void a() {
    }

    public static String f() {
        return "anythink";
    }

    private static void i() {
    }

    public String a(SSLSocket sSLSocket) {
        return null;
    }

    public void a(SSLSocket sSLSocket, String str, List<ab> list) {
    }

    public boolean b(String str) {
        return true;
    }

    public static c e() {
        return c;
    }

    protected X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        try {
            Object objA = a(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (objA == null) {
                return null;
            }
            return (X509TrustManager) a(objA, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(int i, String str, Throwable th) {
        d.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (d.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    private static List<String> a(List<ab> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ab abVar = list.get(i);
            if (abVar != ab.HTTP_1_0) {
                arrayList.add(abVar.toString());
            }
        }
        return arrayList;
    }

    public com.anythink.core.common.m.b.a.j.c a(X509TrustManager x509TrustManager) {
        return new com.anythink.core.common.m.b.a.j.a(b(x509TrustManager));
    }

    public final com.anythink.core.common.m.b.a.j.c b(SSLSocketFactory sSLSocketFactory) {
        X509TrustManager x509TrustManagerA = a(sSLSocketFactory);
        if (x509TrustManagerA == null) {
            throw new IllegalStateException("Unable to extract the trust manager on " + c + ", sslSocketFactory is " + sSLSocketFactory.getClass());
        }
        return a(x509TrustManagerA);
    }

    private static boolean b() {
        if ("conscrypt".equals(com.anythink.core.common.m.b.a.c.a("okhttp.platform", (String) null))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public static boolean g() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    private static c h() {
        c cVarA = a.a();
        if (cVarA != null) {
            return cVarA;
        }
        c cVarB = b.b();
        if (cVarB != null) {
            return cVarB;
        }
        throw new NullPointerException("No platform found on Android");
    }

    private static byte[] b(List<ab> list) {
        com.anythink.core.common.m.c.c cVar = new com.anythink.core.common.m.c.c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ab abVar = list.get(i);
            if (abVar != ab.HTTP_1_0) {
                cVar.l(abVar.toString().length());
                cVar.b(abVar.toString());
            }
        }
        return cVar.y();
    }

    static <T> T a(Object obj, Class<T> cls, String str) {
        do {
            for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
                try {
                    Field declaredField = superclass.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (cls.isInstance(obj2)) {
                        return cls.cast(obj2);
                    }
                    return null;
                } catch (IllegalAccessException unused) {
                    throw new AssertionError();
                } catch (NoSuchFieldException unused2) {
                }
            }
            if (str.equals("delegate")) {
                break;
            }
            obj = a(obj, (Class<Object>) Object.class, "delegate");
        } while (obj != null);
        return null;
    }

    public SSLContext c() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public f b(X509TrustManager x509TrustManager) {
        return new com.anythink.core.common.m.b.a.j.b(x509TrustManager.getAcceptedIssuers());
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    private static c d() {
        c cVarA = a.a();
        if (cVarA != null) {
            return cVarA;
        }
        c cVarB = b.b();
        if (cVarB != null) {
            return cVarB;
        }
        throw new NullPointerException("No platform found on Android");
    }

    static {
        c cVarA = a.a();
        if (cVarA != null || (cVarA = b.b()) != null) {
            c = cVarA;
            d = Logger.getLogger(z.class.getName());
            return;
        }
        throw new NullPointerException("No platform found on Android");
    }
}
