package ms.bz.bd.c.Pgl;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
final class i extends pbly.pgla {
    i() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        JSONArray jSONArray = new JSONArray();
        try {
            DhcpInfo dhcpInfo = ((WifiManager) pblv.ms().xr().getApplicationContext().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4904f2", new byte[]{50, 50, 69, 73}))).getDhcpInfo();
            jSONArray.put((dhcpInfo.dns1 & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "718395", new byte[]{104})) + ((dhcpInfo.dns1 >> 8) & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c48631", new byte[]{60})) + ((dhcpInfo.dns1 >> 16) & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "71c0bd", new byte[]{104})) + ((dhcpInfo.dns1 >> 24) & 255));
            jSONArray.put((dhcpInfo.dns2 & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7d8ed8", new byte[]{104})) + ((dhcpInfo.dns2 >> 8) & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "464350", new byte[]{107})) + ((dhcpInfo.dns2 >> 16) & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9d8be2", new byte[]{102})) + ((dhcpInfo.dns2 >> 24) & 255));
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "aa792d", new byte[]{125, 106, 76, 114, 9, 127});
        }
        return jSONArray.toString();
    }
}
