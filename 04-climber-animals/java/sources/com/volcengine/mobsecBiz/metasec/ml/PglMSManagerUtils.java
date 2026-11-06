package com.volcengine.mobsecBiz.metasec.ml;

import android.content.Context;
import com.volcengine.mobsecBiz.matrix.pgla;
import ms.bz.bd.c.Pgl.m0;
import ms.bz.bd.c.Pgl.n0;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
public final class PglMSManagerUtils {
    private PglMSManagerUtils() {
    }

    public static synchronized PglMSManager get(String str) {
        m0 m0VarXr;
        m0VarXr = n0.xr(str);
        return m0VarXr != null ? new PglMSManager(m0VarXr) : null;
    }

    public static synchronized boolean init(Context context, PglMSConfig pglMSConfig) {
        return n0.ms(context, pglMSConfig.a());
    }

    public static synchronized void initToken(String str) {
        n0.ms(str);
    }

    public static void pause() {
        int i = n0.f4839ms;
        int i2 = pbly.f4864ms;
        pgla.a(67108868, 0, 0L, null, null);
    }

    public static void resume() {
        int i = n0.f4839ms;
        int i2 = pbly.f4864ms;
        pgla.a(67108869, 0, 0L, null, null);
    }

    public static String versionInfo() {
        int i = n0.f4839ms;
        int i2 = pbly.f4864ms;
        return (String) pgla.a(67108867, 0, 0L, null, null);
    }
}
