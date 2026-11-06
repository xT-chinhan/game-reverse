package com.volcengine.mobsecBiz.metasec.ml;

import android.content.Context;
import com.volcengine.mobsecBiz.matrix.pgla;
import ms.bz.bd.c.Pgl.i0;
import ms.bz.bd.c.Pgl.j0;
import ms.bz.bd.c.Pgl.pbls;

/* JADX INFO: loaded from: classes3.dex */
public final class PglMSManagerUtils {
    private PglMSManagerUtils() {
    }

    public static synchronized PglMSManager get(String str) {
        i0 i0VarQg;
        i0VarQg = j0.qg(str);
        return i0VarQg != null ? new PglMSManager(i0VarQg) : null;
    }

    public static synchronized boolean init(Context context, PglMSConfig pglMSConfig) {
        return j0.n(context, pglMSConfig.a());
    }

    public static synchronized void initToken(String str) {
        j0.n(str);
    }

    public static void pause() {
        int i = j0.n;
        int i2 = pbls.n;
        pgla.a(67108868, 0, 0L, null, null);
    }

    public static void resume() {
        int i = j0.n;
        int i2 = pbls.n;
        pgla.a(67108869, 0, 0L, null, null);
    }

    public static String versionInfo() {
        int i = j0.n;
        int i2 = pbls.n;
        return (String) pgla.a(67108867, 0, 0L, null, null);
    }
}
