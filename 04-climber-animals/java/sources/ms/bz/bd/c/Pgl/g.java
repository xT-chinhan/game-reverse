package ms.bz.bd.c.Pgl;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
final class g extends pbly.pgla {
    g() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        String str2;
        try {
            Locale locale = pblv.ms().xr().getResources().getConfiguration().locale;
            str2 = locale.getLanguage() + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "410bc2", new byte[]{26})) + locale.getCountry();
        } catch (Throwable unused) {
            str2 = null;
        }
        return q1.ms(str2);
    }
}
