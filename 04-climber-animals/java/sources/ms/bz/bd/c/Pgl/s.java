package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
final class s extends pbly.pgla {
    s() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object ms(long j, String str, Object obj) throws Throwable {
        Context contextXr = pblv.ms().xr();
        if (contextXr != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) contextXr.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eff3d7", new byte[]{119, 107, 27, 73, 94, 35, 114, 78, 33, 106, 96, 125}));
                Method declaredMethod = connectivityManager.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "df9ce1", new byte[]{114, 97, 94, 54, 89, 50, 110, 81, 109, 29, 112, 112, 93, 24, 72, 45, 78, 73, 110, 60}), new Class[0]);
                declaredMethod.setAccessible(true);
                NetworkInfo networkInfo = (NetworkInfo) declaredMethod.invoke(connectivityManager, new Object[0]);
                if (networkInfo != null) {
                    Method declaredMethod2 = networkInfo.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8efaad", new byte[]{32, 116, 52, 3, 95, 122, 55, 69, 53, 61, 44}), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    return Boolean.valueOf(((Boolean) declaredMethod2.invoke(networkInfo, new Object[0])).booleanValue());
                }
            } catch (Throwable unused) {
            }
        }
        return Boolean.FALSE;
    }
}
