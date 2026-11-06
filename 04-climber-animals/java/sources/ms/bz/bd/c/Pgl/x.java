package ms.bz.bd.c.Pgl;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.umeng.analytics.pro.ek;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
final class x extends pbly.pgla {
    x() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object ms(long j, String str, Object obj) throws Throwable {
        String string;
        try {
            WifiInfo connectionInfo = ((WifiManager) pblv.ms().xr().getApplicationContext().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "25475d", new byte[]{52, 62, 65, 74}))).getConnectionInfo();
            Method declaredMethod = connectionInfo.getClass().getDeclaredMethod(new String(pbla.ms((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4be020", new byte[]{115, 55, com.anythink.core.common.s.a.c.b, 17, 90, 115, 99, 26, 99, 48, 113, 49, com.anythink.core.common.s.a.c.b, ek.n, 91, 115, 96, 17, 98, 53, 114, 51, 65, 23}))), new Class[0]);
            declaredMethod.setAccessible(true);
            string = Integer.toString(((Integer) declaredMethod.invoke(connectionInfo, new Object[0])).intValue());
        } catch (Throwable unused) {
            string = null;
        }
        return TextUtils.isEmpty(string) ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f995b4", new byte[]{39}) : string.trim();
    }
}
