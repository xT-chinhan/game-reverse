package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
final class m extends pbls.pgla {
    m() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    protected final Object n(long j, String str, Object obj) throws Throwable {
        Context contextQg = pblp.n().qg();
        if (contextQg != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) contextQg.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e6ad54", new byte[]{119, 59, 28, 30, 15, 32, 114, 30, 38, 61, 96, 45}));
                Method declaredMethod = connectivityManager.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8c2d4e", new byte[]{46, 100, 85, 49, 8, 102, 50, 84, 102, 26, 44, 117, 86, 31, 25, 121, 18, 76, 101, 59}), new Class[0]);
                declaredMethod.setAccessible(true);
                NetworkInfo networkInfo = (NetworkInfo) declaredMethod.invoke(connectivityManager, new Object[0]);
                if (networkInfo != null) {
                    Method declaredMethod2 = networkInfo.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "524836", new byte[]{45, 35, 102, 90, 13, 40, 58, 18, 103, 100, 33}), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    return Boolean.valueOf(((Boolean) declaredMethod2.invoke(networkInfo, new Object[0])).booleanValue());
                }
            } catch (Throwable unused) {
            }
        }
        return Boolean.FALSE;
    }
}
