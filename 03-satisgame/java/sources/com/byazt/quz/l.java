package com.byazt.quz;

import com.byazt.pq.m;
import com.byazt.pq.wm;
import com.byazt.vw.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND, 18})
public class l {
    public static final l n = n();
    public static final Logger qg = Logger.getLogger(wm.class.getName());

    public String n(SSLSocket sSLSocket) {
        return null;
    }

    public void n(SSLSocket sSLSocket, String str, List<m> list) {
    }

    public void qg(SSLSocket sSLSocket) {
    }

    public boolean qg(String str) {
        return true;
    }

    public String s() {
        return "OkHttp";
    }

    public static l qg() {
        return n;
    }

    public void n(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void n(int i, String str, Throwable th) {
        qg.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object n(String str) {
        if (qg.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void n(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        n(5, str, (Throwable) obj);
    }

    public static List<String> n(List<m> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m mVar = list.get(i);
            if (mVar != m.HTTP_1_0) {
                arrayList.add(mVar.toString());
            }
        }
        return arrayList;
    }

    public com.byazt.vw.s n(X509TrustManager x509TrustManager) {
        return new com.byazt.vw.n(qg(x509TrustManager));
    }

    private static l n() {
        l lVarN = n.n();
        if (lVarN != null) {
            return lVarN;
        }
        qg qgVarN = qg.n();
        if (qgVarN != null) {
            return qgVarN;
        }
        l lVarN2 = s.n();
        return lVarN2 != null ? lVarN2 : new l();
    }

    public static byte[] qg(List<m> list) {
        com.byazt.wa.s sVar = new com.byazt.wa.s();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m mVar = list.get(i);
            if (mVar != m.HTTP_1_0) {
                sVar.rv(mVar.toString().length());
                sVar.qg(mVar.toString());
            }
        }
        try {
            return sVar.hd();
        } catch (IOException unused) {
            return null;
        }
    }

    public w qg(X509TrustManager x509TrustManager) {
        return new com.byazt.vw.qg(x509TrustManager.getAcceptedIssuers());
    }
}
