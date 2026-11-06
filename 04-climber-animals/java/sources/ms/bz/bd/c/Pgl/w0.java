package ms.bz.bd.c.Pgl;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.lang.reflect.Method;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class w0 {

    final class pblb extends pbly.pgla {
        pblb() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object ms(long j, String str, Object obj) throws Throwable {
            a1.ms(pblv.ms().xr());
            return null;
        }
    }

    final class pblc extends pbly.pgla {
        pblc() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object ms(long j, String str, Object obj) throws Throwable {
            return a1.ms(pblv.ms().xr()).ms();
        }
    }

    final class pbld extends pbly.pgla {
        pbld() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object ms(long j, String str, Object obj) throws Throwable {
            return j1.xr(pblv.ms().xr());
        }
    }

    final class pble extends pbly.pgla {
        pble() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object ms(long j, String str, Object obj) throws Throwable {
            return i1.ms(pblv.ms().xr());
        }
    }

    final class pblf extends pbly.pgla {
        pblf() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object ms(long j, String str, Object obj) throws Throwable {
            return "np";
        }
    }

    final class pblg extends pbly.pgla {
        pblg() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object ms(long j, String str, Object obj) throws Throwable {
            return "np";
        }
    }

    final class pblh extends pbly.pgla {
        pblh() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object ms(long j, String str, Object obj) throws Throwable {
            return h1.ms(pblv.ms().xr());
        }
    }

    final class pbli extends pbly.pgla {
        pbli() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object ms(long j, String str, Object obj) throws Throwable {
            return h1.xr(pblv.ms().xr());
        }
    }

    final class pblj extends pbly.pgla {
        pblj() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object ms(long j, String str, Object obj) throws Throwable {
            return ms.bz.bd.c.Pgl.pblh.ms();
        }
    }

    final class pblk extends pbly.pgla {
        pblk() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object ms(long j, String str, Object obj) throws Throwable {
            return k1.ms(pblv.ms().xr());
        }
    }

    final class pbll extends pbly.pgla {
        pbll() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object ms(long j, String str, Object obj) throws Throwable {
            String str2;
            String str3;
            StringBuilder sbAppend;
            String strTrim = "0";
            String strTrim2 = AbstractJsonLexerKt.NULL;
            try {
                WifiInfo connectionInfo = ((WifiManager) pblv.ms().xr().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo();
                Class<?> cls = connectionInfo.getClass();
                Method declaredMethod = cls.getDeclaredMethod(new String(pbla.ms("6765744253534944")), new Class[0]);
                declaredMethod.setAccessible(true);
                str2 = (String) declaredMethod.invoke(connectionInfo, new Object[0]);
                try {
                    Method declaredMethod2 = cls.getDeclaredMethod(new String(pbla.ms("67657453534944")), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    str3 = (String) declaredMethod2.invoke(connectionInfo, new Object[0]);
                    try {
                        Method declaredMethod3 = cls.getDeclaredMethod(new String(pbla.ms("676574497041646472657373")), new Class[0]);
                        declaredMethod3.setAccessible(true);
                        String string = Integer.toString(((Integer) declaredMethod3.invoke(connectionInfo, new Object[0])).intValue());
                        String strMs = q1.ms(str3);
                        String strMs2 = q1.ms(str2);
                        String strMs3 = q1.ms(string);
                        StringBuilder sbAppend2 = new StringBuilder().append((strMs2 == null || strMs2.length() <= 0) ? AbstractJsonLexerKt.NULL : strMs2.trim()).append("[<!>]");
                        if (strMs != null && strMs.length() > 0) {
                            strTrim2 = strMs.trim();
                        }
                        sbAppend = sbAppend2.append(strTrim2).append("[<!>]");
                        if (strMs3 != null && strMs3.length() > 0) {
                            strTrim = strMs3.trim();
                        }
                    } catch (Throwable unused) {
                        String strMs4 = q1.ms(str3);
                        String strMs5 = q1.ms(str2);
                        String strMs6 = q1.ms(null);
                        StringBuilder sbAppend3 = new StringBuilder().append((strMs5 == null || strMs5.length() <= 0) ? AbstractJsonLexerKt.NULL : strMs5.trim()).append("[<!>]");
                        if (strMs4 != null && strMs4.length() > 0) {
                            strTrim2 = strMs4.trim();
                        }
                        sbAppend = sbAppend3.append(strTrim2).append("[<!>]");
                        if (strMs6 != null && strMs6.length() > 0) {
                            strTrim = strMs6.trim();
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

    final class pblm extends pbly.pgla {
        pblm() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object ms(long j, String str, Object obj) throws Throwable {
            return j1.ms(pblv.ms().xr());
        }
    }

    final class pgla extends pbly.pgla {
        pgla() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object ms(long j, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static void ms() {
        pbly.ms(268435457, new pble());
        pbly.ms(268435458, new pblf());
        pbly.ms(268435459, new pblg());
        pbly.ms(268435460, new pblh());
        pbly.ms(268435461, new pbli());
        pbly.ms(268435462, new pblj());
        pbly.ms(268435463, new pblk());
        pbly.ms(268435464, new pbll());
        pbly.ms(268435465, new pblm());
        pbly.ms(268435466, new pgla());
        pbly.ms(268435467, new pblb());
        pbly.ms(268435468, new pblc());
        pbly.ms(268435469, new pbld());
    }
}
