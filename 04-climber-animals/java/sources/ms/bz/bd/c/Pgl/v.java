package ms.bz.bd.c.Pgl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
final class v extends pbly.pgla {
    v() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object ms(long j, String str, Object obj) throws Throwable {
        Throwable thXr = p1.ms().xr();
        return thXr != null ? Arrays.toString(thXr.getStackTrace()) : "";
    }
}
