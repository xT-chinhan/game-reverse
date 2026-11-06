package ms.bz.bd.c.Pgl;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.lang.reflect.Method;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 {

    final class pblb extends pbls.pgla {
        pblb() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object pr(long j, String str, Object obj) throws Throwable {
            return u0.pr();
        }
    }

    final class pblc extends pbls.pgla {
        pblc() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object pr(long j, String str, Object obj) throws Throwable {
            return b1.hw(pblp.pr().hw());
        }
    }

    final class pbld extends pbls.pgla {
        pbld() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object pr(long j, String str, Object obj) throws Throwable {
            return a1.pr(pblp.pr().hw());
        }
    }

    final class pble extends pbls.pgla {
        pble() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object pr(long j, String str, Object obj) throws Throwable {
            return "np";
        }
    }

    final class pblf extends pbls.pgla {
        pblf() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object pr(long j, String str, Object obj) throws Throwable {
            return "np";
        }
    }

    final class pblg extends pbls.pgla {
        pblg() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object pr(long j, String str, Object obj) throws Throwable {
            return z0.pr(pblp.pr().hw());
        }
    }

    final class pblh extends pbls.pgla {
        pblh() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object pr(long j, String str, Object obj) throws Throwable {
            return z0.hw(pblp.pr().hw());
        }
    }

    final class pbli extends pbls.pgla {
        pbli() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object pr(long j, String str, Object obj) throws Throwable {
            return ms.bz.bd.c.Pgl.pblf.pr();
        }
    }

    final class pblj extends pbls.pgla {
        pblj() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object pr(long j, String str, Object obj) throws Throwable {
            return c1.pr(pblp.pr().hw());
        }
    }

    final class pblk extends pbls.pgla {
        pblk() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object pr(long j, String str, Object obj) throws Throwable {
            String str2;
            String str3;
            StringBuilder sbAppend;
            String strTrim = "0";
            String strTrim2 = AbstractJsonLexerKt.NULL;
            try {
                WifiInfo connectionInfo = ((WifiManager) pblp.pr().hw().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo();
                Class<?> cls = connectionInfo.getClass();
                Method declaredMethod = cls.getDeclaredMethod(new String(pblm.pr("6765744253534944")), new Class[0]);
                declaredMethod.setAccessible(true);
                str2 = (String) declaredMethod.invoke(connectionInfo, new Object[0]);
                try {
                    Method declaredMethod2 = cls.getDeclaredMethod(new String(pblm.pr("67657453534944")), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    str3 = (String) declaredMethod2.invoke(connectionInfo, new Object[0]);
                    try {
                        Method declaredMethod3 = cls.getDeclaredMethod(new String(pblm.pr("676574497041646472657373")), new Class[0]);
                        declaredMethod3.setAccessible(true);
                        String string = Integer.toString(((Integer) declaredMethod3.invoke(connectionInfo, new Object[0])).intValue());
                        String strPr = k1.pr(str3);
                        String strPr2 = k1.pr(str2);
                        String strPr3 = k1.pr(string);
                        StringBuilder sbAppend2 = new StringBuilder().append((strPr2 == null || strPr2.length() <= 0) ? AbstractJsonLexerKt.NULL : strPr2.trim()).append("[<!>]");
                        if (strPr != null && strPr.length() > 0) {
                            strTrim2 = strPr.trim();
                        }
                        sbAppend = sbAppend2.append(strTrim2).append("[<!>]");
                        if (strPr3 != null && strPr3.length() > 0) {
                            strTrim = strPr3.trim();
                        }
                    } catch (Throwable th) {
                        String strPr4 = k1.pr(str3);
                        String strPr5 = k1.pr(str2);
                        String strPr6 = k1.pr(null);
                        StringBuilder sbAppend3 = new StringBuilder().append((strPr5 == null || strPr5.length() <= 0) ? AbstractJsonLexerKt.NULL : strPr5.trim()).append("[<!>]");
                        if (strPr4 != null && strPr4.length() > 0) {
                            strTrim2 = strPr4.trim();
                        }
                        sbAppend = sbAppend3.append(strTrim2).append("[<!>]");
                        if (strPr6 != null && strPr6.length() > 0) {
                            strTrim = strPr6.trim();
                        }
                    }
                } catch (Throwable th2) {
                    str3 = null;
                }
            } catch (Throwable th3) {
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
        public final Object pr(long j, String str, Object obj) throws Throwable {
            return b1.pr(pblp.pr().hw());
        }
    }

    final class pgla extends pbls.pgla {
        pgla() {
        }

        @Override // ms.bz.bd.c.Pgl.pbls.pgla
        public final Object pr(long j, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static void pr() {
        pbls.pr(268435457, new pbld());
        pbls.pr(268435458, new pble());
        pbls.pr(268435459, new pblf());
        pbls.pr(268435460, new pblg());
        pbls.pr(268435461, new pblh());
        pbls.pr(268435462, new pbli());
        pbls.pr(268435463, new pblj());
        pbls.pr(268435464, new pblk());
        pbls.pr(268435465, new pbll());
        pbls.pr(268435466, new pgla());
        pbls.pr(268435468, new pblb());
        pbls.pr(268435469, new pblc());
    }
}
