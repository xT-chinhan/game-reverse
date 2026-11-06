package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.umeng.analytics.pro.cc;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes3.dex */
final class b extends pbls.pgla {
    b() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(long j, String str, Object obj) throws Throwable {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    String name = networkInterfaceNextElement.getName();
                    if (!TextUtils.isEmpty(name) && !inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address) && name.startsWith((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d53174", new byte[]{103, 58, 78, 64, 28}))) {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "573a9f", new byte[]{45, 59, 69, 1, 39, 117, 50, 4, 103, 34, 55, 117, 78, 20, 11, 116, 108});
                        networkInterfaceNextElement.getName();
                        return networkInterfaceNextElement.getName();
                    }
                }
            }
            return "";
        } catch (SocketException e) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8ce926", new byte[]{46, 100, 2, cc.k, 36, 49, 26, 70, 48, 123, 44, 114, 5, cc.k, 11, 32, 50, 78, 110});
            return "";
        }
    }
}
