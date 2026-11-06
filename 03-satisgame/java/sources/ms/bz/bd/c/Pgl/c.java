package ms.bz.bd.c.Pgl;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
final class c extends pbls.pgla {
    c() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object n(long j, String str, Object obj) throws Throwable {
        JSONArray jSONArray = new JSONArray();
        try {
            DhcpInfo dhcpInfo = ((WifiManager) pblp.n().qg().getApplicationContext().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5c9410", new byte[]{51, 104, 76, 73}))).getDhcpInfo();
            jSONArray.put((dhcpInfo.dns1 & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "61424c", new byte[]{105})) + ((dhcpInfo.dns1 >> 8) & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3442dc", new byte[]{108})) + ((dhcpInfo.dns1 >> 16) & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9dc872", new byte[]{102})) + ((dhcpInfo.dns1 >> 24) & 255));
            jSONArray.put((dhcpInfo.dns2 & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "81688f", new byte[]{103})) + ((dhcpInfo.dns2 >> 8) & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "430b09", new byte[]{107})) + ((dhcpInfo.dns2 >> 16) & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "afbf75", new byte[]{62})) + ((dhcpInfo.dns2 >> 24) & 255));
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "22da8c", new byte[]{46, 57, 31, 42, 3, 120});
        }
        return jSONArray.toString();
    }
}
