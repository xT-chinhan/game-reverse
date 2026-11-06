package com.byazt.lp;

import com.byazt.di.uc;
import com.byazt.jv.fo;
import com.byazt.jv.rc;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static final c pr = pr();
    public static final Logger hw = Logger.getLogger(fo.class.getName());

    public static c hw() {
        return pr;
    }

    public String hn() {
        return "OkHttp";
    }

    public void pr(SSLSocket sSLSocket, String str, List<rc> list) {
    }

    public void hw(SSLSocket sSLSocket) {
    }

    public String pr(SSLSocket sSLSocket) {
        return null;
    }

    public void pr(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void pr(int i, String str, Throwable th) {
        hw.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public boolean hw(String str) {
        return true;
    }

    public Object pr(String str) {
        if (hw.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void pr(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        pr(5, str, (Throwable) obj);
    }

    public static List<String> pr(List<rc> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            rc rcVar = list.get(i);
            if (rcVar != rc.HTTP_1_0) {
                arrayList.add(rcVar.toString());
            }
        }
        return arrayList;
    }

    public com.byazt.di.hn pr(X509TrustManager x509TrustManager) {
        return new com.byazt.di.pr(hw(x509TrustManager));
    }

    private static c pr() {
        c cVarPr = pr.pr();
        if (cVarPr != null) {
            return cVarPr;
        }
        hw hwVarPr = hw.pr();
        if (hwVarPr != null) {
            return hwVarPr;
        }
        c cVarPr2 = hn.pr();
        if (cVarPr2 != null) {
            return cVarPr2;
        }
        return new c();
    }

    public static byte[] hw(List<rc> list) {
        com.byazt.du.hn hnVar = new com.byazt.du.hn();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            rc rcVar = list.get(i);
            if (rcVar != rc.HTTP_1_0) {
                hnVar.aj(rcVar.toString().length());
                hnVar.hw(rcVar.toString());
            }
        }
        try {
            return hnVar.yb();
        } catch (IOException e) {
            return null;
        }
    }

    public uc hw(X509TrustManager x509TrustManager) {
        return new com.byazt.di.hw(x509TrustManager.getAcceptedIssuers());
    }
}
