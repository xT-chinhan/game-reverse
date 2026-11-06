package ms.bz.bd.c.Pgl;

import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
final class h0 extends pbls.pgla {
    h0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(long j, String str, Object obj) throws Throwable {
        String str2;
        try {
            Locale locale = pblp.pr().hw().getResources().getConfiguration().locale;
            str2 = locale.getLanguage() + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b8b1f2", new byte[]{76})) + locale.getCountry();
        } catch (Throwable th) {
            str2 = null;
        }
        return k1.pr(str2);
    }
}
