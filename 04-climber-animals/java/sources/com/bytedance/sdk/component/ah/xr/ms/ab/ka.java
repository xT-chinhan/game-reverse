package com.bytedance.sdk.component.ah.xr.ms.ab;

import com.bytedance.sdk.component.ah.xr.i;
import com.bytedance.sdk.component.ah.xr.ms.ny.c;
import com.bytedance.sdk.component.ah.xr.re;
import com.bytedance.sdk.component.utils.sl;
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
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final ka f1051ms = ms();
    private static final Logger xr = Logger.getLogger(re.class.getName());

    public String ah() {
        return "OkHttp";
    }

    public String ms(SSLSocket sSLSocket) {
        return null;
    }

    public void ms(SSLSocket sSLSocket, String str, List<i> list) {
    }

    public void xr(SSLSocket sSLSocket) {
    }

    public boolean xr(String str) {
        return true;
    }

    public static ka xr() {
        return f1051ms;
    }

    public void ms(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void ms(int i, String str, Throwable th) {
        xr.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object ms(String str) {
        if (xr.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void ms(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        ms(5, str, (Throwable) obj);
    }

    public static List<String> ms(List<i> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            i iVar = list.get(i);
            if (iVar != i.HTTP_1_0) {
                arrayList.add(iVar.toString());
            }
        }
        return arrayList;
    }

    public com.bytedance.sdk.component.ah.xr.ms.ny.ah ms(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.component.ah.xr.ms.ny.ms(xr(x509TrustManager));
    }

    private static ka ms() {
        ka kaVarMs = ms.ms();
        if (kaVarMs != null) {
            return kaVarMs;
        }
        xr xrVarMs = xr.ms();
        if (xrVarMs != null) {
            return xrVarMs;
        }
        ka kaVarMs2 = ah.ms();
        return kaVarMs2 != null ? kaVarMs2 : new ka();
    }

    static byte[] xr(List<i> list) {
        com.bytedance.sdk.component.ah.ms.ah ahVar = new com.bytedance.sdk.component.ah.ms.ah();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            i iVar = list.get(i);
            if (iVar != i.HTTP_1_0) {
                ahVar.ny(iVar.toString().length());
                ahVar.xr(iVar.toString());
            }
        }
        try {
            return ahVar.h();
        } catch (IOException e) {
            sl.ms(e);
            return null;
        }
    }

    public c xr(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.component.ah.xr.ms.ny.xr(x509TrustManager.getAcceptedIssuers());
    }
}
