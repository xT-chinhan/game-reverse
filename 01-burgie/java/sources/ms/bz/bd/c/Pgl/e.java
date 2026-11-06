package ms.bz.bd.c.Pgl;

import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes3.dex */
final class e extends pbls.pgla {
    e() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(long j, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        TelephonyManager telephonyManager = (TelephonyManager) pblp.pr().hw().getApplicationContext().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "56ad8e", new byte[]{52, 60, 29, 30, 2}));
        return (telephonyManager == null || telephonyManager.getSimState() != 5) ? bool : Boolean.TRUE;
    }
}
