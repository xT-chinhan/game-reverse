package com.bytedance.sdk.component.ah.xr.ms.ab;

import com.bytedance.sdk.component.ah.xr.i;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
class ah extends ka {
    private final Method ah;
    private final Class<?> d;
    private final Class<?> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Method f1048ms;
    private final Method xr;

    ah(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f1048ms = method;
        this.xr = method2;
        this.ah = method3;
        this.d = cls;
        this.ka = cls2;
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ab.ka
    public void ms(SSLSocket sSLSocket, String str, List<i> list) {
        try {
            this.f1048ms.invoke(null, sSLSocket, Proxy.newProxyInstance(ka.class.getClassLoader(), new Class[]{this.d, this.ka}, new ms(ms(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.ah.xr.ms.ah.ms("unable to set alpn", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ab.ka
    public void xr(SSLSocket sSLSocket) {
        try {
            this.ah.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.ah.xr.ms.ah.ms("unable to remove alpn", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ab.ka
    public String ms(SSLSocket sSLSocket) {
        try {
            ms msVar = (ms) Proxy.getInvocationHandler(this.xr.invoke(null, sSLSocket));
            if (!msVar.f1049ms && msVar.xr == null) {
                xr().ms(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (msVar.f1049ms) {
                return null;
            }
            return msVar.xr;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.ah.xr.ms.ah.ms("unable to get selected protocol", (Exception) e);
        }
    }

    public static ka ms() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new ah(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    private static class ms implements InvocationHandler {
        private final List<String> ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        boolean f1049ms;
        String xr;

        ms(List<String> list) {
            this.ah = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.bytedance.sdk.component.ah.xr.ms.ah.xr;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f1049ms = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.ah;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.ah.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.xr = str;
                            return str;
                        }
                    }
                    String str2 = this.ah.get(0);
                    this.xr = str2;
                    return str2;
                }
            }
            if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                this.xr = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }
}
