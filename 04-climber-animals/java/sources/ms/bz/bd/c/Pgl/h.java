package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.umeng.analytics.pro.ek;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes4.dex */
final class h extends pbly.pgla {
    h() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    String name = networkInterfaceNextElement.getName();
                    if (!TextUtils.isEmpty(name) && !inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address) && name.startsWith((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a81941", new byte[]{98, 55, 76, 72, 31}))) {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3cab7f", new byte[]{43, 111, 23, 2, 41, 117, 52, 80, 53, 33, 49, 33, 28, 23, 5, 116, 106});
                        networkInterfaceNextElement.getName();
                        return networkInterfaceNextElement.getName();
                    }
                }
            }
            return "";
        } catch (SocketException unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8f59f0", new byte[]{46, 97, 82, ek.k, 112, 55, 26, 67, 96, 123, 44, 119, 85, ek.k, 95, 38, 50, 75, 62});
            return "";
        }
    }
}
