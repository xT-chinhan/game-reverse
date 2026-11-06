package com.byazt.lp;

import com.byazt.jv.rc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, 20})
public class hn extends c {
    public final Class<?> c;
    public final Method hn;
    public final Method hw;
    public final Method pr;
    public final Class<?> x;

    public hn(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.pr = method;
        this.hw = method2;
        this.hn = method3;
        this.x = cls;
        this.c = cls2;
    }

    @Override // com.byazt.lp.c
    public void pr(SSLSocket sSLSocket, String str, List<rc> list) {
        try {
            this.pr.invoke(null, sSLSocket, Proxy.newProxyInstance(c.class.getClassLoader(), new Class[]{this.x, this.c}, new pr(pr(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.xx.hn.pr("unable to set alpn", (Exception) e);
        }
    }

    @Override // com.byazt.lp.c
    public void hw(SSLSocket sSLSocket) {
        try {
            this.hn.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.xx.hn.pr("unable to remove alpn", (Exception) e);
        }
    }

    @Override // com.byazt.lp.c
    public String pr(SSLSocket sSLSocket) {
        try {
            pr prVar = (pr) Proxy.getInvocationHandler(this.hw.invoke(null, sSLSocket));
            if (!prVar.pr && prVar.hw == null) {
                hw().pr(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (prVar.pr) {
                return null;
            }
            return prVar.hw;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.xx.hn.pr("unable to get selected protocol", (Exception) e);
        }
    }

    public static c pr() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            return new hn(cls.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            return null;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, 116})
    private static class pr implements InvocationHandler {
        public final List<String> hn;
        public String hw;
        public boolean pr;

        public pr(List<String> list) {
            this.hn = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.byazt.xx.hn.hw;
            }
            if ("supports".equals(name) && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if ("unsupported".equals(name) && Void.TYPE == returnType) {
                this.pr = true;
                return null;
            }
            if ("protocols".equals(name) && objArr.length == 0) {
                return this.hn;
            }
            if ("selectProtocol".equals(name) || ("select".equals(name) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List))) {
                List list = (List) objArr[0];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (this.hn.contains(list.get(i))) {
                        String str = (String) list.get(i);
                        this.hw = str;
                        return str;
                    }
                }
                String str2 = this.hn.get(0);
                this.hw = str2;
                return str2;
            }
            if ("protocolSelected".equals(name) || ("selected".equals(name) && objArr.length == 1)) {
                this.hw = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }
}
