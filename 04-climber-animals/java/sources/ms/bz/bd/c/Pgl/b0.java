package ms.bz.bd.c.Pgl;

import android.net.ConnectivityManager;
import com.umeng.analytics.pro.ek;

/* JADX INFO: loaded from: classes4.dex */
final class b0 extends pbly.pgla {
    b0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object ms(long j, String str, Object obj) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) pblv.ms().xr().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "40f944", new byte[]{38, 61, 27, 67, ek.l, 32, 35, 24, 33, 96, 49, 43}));
            return (String) (connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasTransport(4) ? com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "02fe15", new byte[]{112}) : com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3baef6", new byte[]{114}));
        } catch (Throwable unused) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4f0501", new byte[]{117});
        }
    }
}
