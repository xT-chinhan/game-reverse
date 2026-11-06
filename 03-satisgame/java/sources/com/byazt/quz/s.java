package com.byazt.quz;

import com.byazt.pq.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND, 8})
public class s extends l {
    public final Class<?> l;
    public final Method n;
    public final Class<?> q;
    public final Method qg;
    public final Method s;

    public s(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.n = method;
        this.qg = method2;
        this.s = method3;
        this.q = cls;
        this.l = cls2;
    }

    @Override // com.byazt.quz.l
    public void n(SSLSocket sSLSocket, String str, List<m> list) {
        try {
            this.n.invoke(null, sSLSocket, Proxy.newProxyInstance(l.class.getClassLoader(), new Class[]{this.q, this.l}, new n(n(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.zho.s.n("unable to set alpn", (Exception) e);
        }
    }

    @Override // com.byazt.quz.l
    public void qg(SSLSocket sSLSocket) {
        try {
            this.s.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.zho.s.n("unable to remove alpn", (Exception) e);
        }
    }

    @Override // com.byazt.quz.l
    public String n(SSLSocket sSLSocket) {
        try {
            n nVar = (n) Proxy.getInvocationHandler(this.qg.invoke(null, sSLSocket));
            if (!nVar.n && nVar.qg == null) {
                qg().n(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (nVar.n) {
                return null;
            }
            return nVar.qg;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.zho.s.n("unable to get selected protocol", (Exception) e);
        }
    }

    public static l n() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new s(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND, 546})
    private static class n implements InvocationHandler {
        public boolean n;
        public String qg;
        public final List<String> s;

        public n(List<String> list) {
            this.s = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.byazt.zho.s.qg;
            }
            if ("supports".equals(name) && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if ("unsupported".equals(name) && Void.TYPE == returnType) {
                this.n = true;
                return null;
            }
            if ("protocols".equals(name) && objArr.length == 0) {
                return this.s;
            }
            if ("selectProtocol".equals(name) || ("select".equals(name) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List))) {
                List list = (List) objArr[0];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (this.s.contains(list.get(i))) {
                        String str = (String) list.get(i);
                        this.qg = str;
                        return str;
                    }
                }
                String str2 = this.s.get(0);
                this.qg = str2;
                return str2;
            }
            if ("protocolSelected".equals(name) || ("selected".equals(name) && objArr.length == 1)) {
                this.qg = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }
}
