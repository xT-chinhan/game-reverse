package ms.bz.bd.c.Pgl;

import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
final class g0 extends pbls.pgla {
    g0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(long j, String str, Object obj) throws Throwable {
        String id;
        int rawOffset;
        try {
            TimeZone timeZone = TimeZone.getDefault();
            id = timeZone.getID();
            try {
                rawOffset = ((timeZone.getRawOffset() / 60) / 60) / 1000;
            } catch (Throwable th) {
                rawOffset = 0;
            }
        } catch (Throwable th2) {
            id = null;
        }
        return id + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "844e3f", new byte[]{101})) + rawOffset;
    }
}
