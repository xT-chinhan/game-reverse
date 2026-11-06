package ms.bz.bd.c.Pgl;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.lang.reflect.Method;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 {

    final class pblb extends pbls.pgla {
        pblb() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object n(long j, String str, Object obj) throws Throwable {
            return u0.n();
        }
    }

    final class pblc extends pbls.pgla {
        pblc() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object n(long j, String str, Object obj) throws Throwable {
            return b1.qg(pblp.n().qg());
        }
    }

    final class pbld extends pbls.pgla {
        pbld() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object n(long j, String str, Object obj) throws Throwable {
            return a1.n(pblp.n().qg());
        }
    }

    final class pble extends pbls.pgla {
        pble() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object n(long j, String str, Object obj) throws Throwable {
            return "np";
        }
    }

    final class pblf extends pbls.pgla {
        pblf() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object n(long j, String str, Object obj) throws Throwable {
            return "np";
        }
    }

    final class pblg extends pbls.pgla {
        pblg() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object n(long j, String str, Object obj) throws Throwable {
            return z0.n(pblp.n().qg());
        }
    }

    final class pblh extends pbls.pgla {
        pblh() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object n(long j, String str, Object obj) throws Throwable {
            return z0.qg(pblp.n().qg());
        }
    }

    final class pbli extends pbls.pgla {
        pbli() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object n(long j, String str, Object obj) throws Throwable {
            return ms.bz.bd.c.Pgl.pblf.n();
        }
    }

    final class pblj extends pbls.pgla {
        pblj() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object n(long j, String str, Object obj) throws Throwable {
            return c1.n(pblp.n().qg());
        }
    }

    final class pblk extends pbls.pgla {
        pblk() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object n(long j, String str, Object obj) throws Throwable {
            String str2;
            String str3;
            StringBuilder sbAppend;
            String strTrim = "0";
            String strTrim2 = AbstractJsonLexerKt.NULL;
            try {
                WifiInfo connectionInfo = ((WifiManager) pblp.n().qg().getSystemService("wifi")).getConnectionInfo();
                Class<?> cls = connectionInfo.getClass();
                Method declaredMethod = cls.getDeclaredMethod(new String(pblm.n("6765744253534944")), new Class[0]);
                declaredMethod.setAccessible(true);
                str2 = (String) declaredMethod.invoke(connectionInfo, new Object[0]);
                try {
                    Method declaredMethod2 = cls.getDeclaredMethod(new String(pblm.n("67657453534944")), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    str3 = (String) declaredMethod2.invoke(connectionInfo, new Object[0]);
                    try {
                        Method declaredMethod3 = cls.getDeclaredMethod(new String(pblm.n("676574497041646472657373")), new Class[0]);
                        declaredMethod3.setAccessible(true);
                        String string = Integer.toString(((Integer) declaredMethod3.invoke(connectionInfo, new Object[0])).intValue());
                        String strN = k1.n(str3);
                        String strN2 = k1.n(str2);
                        String strN3 = k1.n(string);
                        StringBuilder sbAppend2 = new StringBuilder().append((strN2 == null || strN2.length() <= 0) ? AbstractJsonLexerKt.NULL : strN2.trim()).append("[<!>]");
                        if (strN != null && strN.length() > 0) {
                            strTrim2 = strN.trim();
                        }
                        sbAppend = sbAppend2.append(strTrim2).append("[<!>]");
                        if (strN3 != null && strN3.length() > 0) {
                            strTrim = strN3.trim();
                        }
                    } catch (Throwable unused) {
                        String strN4 = k1.n(str3);
                        String strN5 = k1.n(str2);
                        String strN6 = k1.n(null);
                        StringBuilder sbAppend3 = new StringBuilder().append((strN5 == null || strN5.length() <= 0) ? AbstractJsonLexerKt.NULL : strN5.trim()).append("[<!>]");
                        if (strN4 != null && strN4.length() > 0) {
                            strTrim2 = strN4.trim();
                        }
                        sbAppend = sbAppend3.append(strTrim2).append("[<!>]");
                        if (strN6 != null && strN6.length() > 0) {
                            strTrim = strN6.trim();
                        }
                    }
                } catch (Throwable unused2) {
                    str3 = null;
                }
            } catch (Throwable unused3) {
                str2 = null;
                str3 = null;
            }
            return sbAppend.append(strTrim).append("[<!>]").toString().trim();
        }
    }

    final class pbll extends pbls.pgla {
        pbll() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object n(long j, String str, Object obj) throws Throwable {
            return b1.n(pblp.n().qg());
        }
    }

    final class pgla extends pbls.pgla {
        pgla() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object n(long j, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static void n() {
        pbls.n(268435457, new pbld());
        pbls.n(268435458, new pble());
        pbls.n(268435459, new pblf());
        pbls.n(268435460, new pblg());
        pbls.n(268435461, new pblh());
        pbls.n(268435462, new pbli());
        pbls.n(268435463, new pblj());
        pbls.n(268435464, new pblk());
        pbls.n(268435465, new pbll());
        pbls.n(268435466, new pgla());
        pbls.n(268435468, new pblb());
        pbls.n(268435469, new pblc());
    }
}
