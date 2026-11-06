package ms.bz.bd.c.Pgl;

import android.telephony.TelephonyManager;
import com.umeng.analytics.pro.ek;

/* JADX INFO: loaded from: classes4.dex */
final class k extends pbly.pgla {
    k() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        TelephonyManager telephonyManager = (TelephonyManager) pblv.ms().xr().getApplicationContext().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "61347a", new byte[]{55, 59, 79, 78, ek.k}));
        return (telephonyManager == null || telephonyManager.getSimState() != 5) ? bool : Boolean.TRUE;
    }
}
