package com.byazt.quz;

import com.byazt.pq.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND, 26})
public final class qg extends l {
    public final Method n;
    public final Method qg;

    public qg(Method method, Method method2) {
        this.n = method;
        this.qg = method2;
    }

    @Override // com.byazt.quz.l
    public void n(SSLSocket sSLSocket, String str, List<m> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listN = n(list);
            this.n.invoke(sSLParameters, listN.toArray(new String[listN.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.zho.s.n("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // com.byazt.quz.l
    public String n(SSLSocket sSLSocket) {
        try {
            String str = (String) this.qg.invoke(sSLSocket, new Object[0]);
            if (str == null || str.isEmpty()) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.zho.s.n("unable to get selected protocols", (Exception) e);
        }
    }

    public static qg n() {
        try {
            return new qg(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
