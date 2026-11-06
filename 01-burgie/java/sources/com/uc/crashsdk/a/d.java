package com.uc.crashsdk.a;

import android.os.Process;
import com.bykv.vk.component.ttvideo.player.C;
import com.taptap.sdk.kit.internal.time.TapTime;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.Locale;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    static final /* synthetic */ boolean a = true;
    private static boolean b = true;
    private static final Object c = new Object();
    private static boolean d = false;
    private static String e = "hsdk";
    private static String f = "alid ";
    private static String g = null;
    private static final Object h = new Object();
    private static String i = null;

    public static void a() {
        long j;
        if (com.uc.crashsdk.b.H()) {
            j = TapTime.MAX_SKEW_MS;
        } else {
            j = 90000;
        }
        f.a(0, new e(500), j);
    }

    public static void a(int i2) {
        if (i2 == 500) {
            synchronized (c) {
                g = null;
                a(!com.uc.crashsdk.b.F());
                if (g.b(g)) {
                    h.a(g);
                }
            }
            return;
        }
        if (!a) {
            throw new AssertionError();
        }
    }

    public static String b() {
        try {
            return "inv" + f + "cras" + e;
        } catch (Throwable th) {
            g.b(th);
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0053  */
    private static boolean a(boolean z) throws Throwable {
        int iC;
        boolean z2;
        String str;
        if (d) {
            return false;
        }
        d = !z;
        if ((com.uc.crashsdk.a.b.equals("2.0") && com.uc.crashsdk.b.c(C.ENCODING_PCM_A_LAW)) || !com.uc.crashsdk.b.A()) {
            return false;
        }
        String strN = com.uc.crashsdk.b.n();
        String strA = b.a(strN);
        String str2 = null;
        long jC = 0;
        if (g.b(strA)) {
            String[] strArrSplit = strA.split(" ", 4);
            if (strArrSplit.length == 3) {
                str2 = strArrSplit[0];
                jC = g.c(strArrSplit[1]);
                iC = (int) g.c(strArrSplit[2]);
            } else {
                iC = 0;
            }
        } else {
            iC = 0;
        }
        b = true;
        if (System.currentTimeMillis() - jC < 259200000) {
            if (!"o".equals(str2)) {
                if ("2".equals(str2)) {
                    b = false;
                } else {
                    if ("1".equals(str2)) {
                        b = false;
                    }
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 || z) {
            return true;
        }
        if (iC == Process.myPid()) {
            return false;
        }
        g = "per";
        String strG = g();
        if (strG != null && strG.contains("retcode=")) {
            if (strG.contains("retcode=0")) {
                b = true;
                str = "o";
                g = "aus";
            } else {
                b = false;
                if ("1".equals(str2)) {
                    str = "2";
                    g = "auf2";
                } else {
                    str = "1";
                    g = "auf1";
                }
            }
            b.a(strN, String.format(Locale.US, "%s %d %d", str, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid())));
            if (g.b(strG)) {
                for (String str3 : strG.split("`", 30)) {
                    String[] strArrSplit2 = str3.split("=", 2);
                    if (strArrSplit2.length == 2) {
                        String strTrim = strArrSplit2[0].trim();
                        String strTrim2 = strArrSplit2[1].trim();
                        boolean z3 = g.b(strTrim2) && strTrim2.startsWith("http");
                        if ("logurl".equals(strTrim)) {
                            if (z3) {
                                com.uc.crashsdk.e.b(strTrim2);
                            }
                        } else if ("staturl".equals(strTrim)) {
                            if (z3) {
                                h.b(strTrim2);
                            }
                        } else if ("policyurl".equals(strTrim)) {
                            if (z3) {
                                synchronized (h) {
                                    i = strTrim2;
                                    b.a(com.uc.crashsdk.b.j(), strTrim2 + "\n");
                                }
                            } else {
                                continue;
                            }
                        } else if ("logpolicy".equals(strTrim)) {
                            com.uc.crashsdk.e.c(strTrim2);
                        }
                    }
                }
            }
            return true;
        }
        if (strG == null) {
            g = "ner";
        } else {
            g = "ser";
        }
        return false;
    }

    private static String f() {
        String strA = i;
        if (g.a(strA)) {
            synchronized (h) {
                String str = "https://errlog.umeng.com";
                if (com.uc.crashsdk.g.R()) {
                    str = "https://errlogos.umeng.com";
                }
                strA = g.a(com.uc.crashsdk.b.j(), str + "/api/crashsdk/validate", true);
                i = strA;
            }
        }
        return strA;
    }

    public static void c() {
        synchronized (h) {
            i = null;
        }
    }

    static byte[] d() {
        return new byte[]{6, 0, 23, 8};
    }

    private static String g() {
        byte[] bArrA;
        String strF;
        byte[] bArrA2;
        byte[] bArrA3;
        StringBuilder sb = new StringBuilder();
        a(sb, "platform", com.uc.crashsdk.g.e());
        a(sb, "pkgname", com.uc.crashsdk.a.a);
        a(sb, UMModuleRegister.PROCESS, com.uc.crashsdk.e.h());
        a(sb, "version", com.uc.crashsdk.a.a());
        a(sb, "cver", "3.3.2.2");
        a(sb, "ctag", "release");
        a(sb, "inter", com.uc.crashsdk.g.R() ? "true" : "false");
        a(sb, "os", "android");
        String string = sb.toString();
        byte[] bArr = new byte[16];
        c.a(bArr, 0, h.j());
        c.a(bArr, 4, c.a());
        c.a(bArr, 8, d());
        c.a(bArr, 12, com.uc.crashsdk.a.f());
        try {
            bArrA = c.a(string.getBytes(), bArr, true);
        } catch (Throwable th) {
            g.a(th);
            bArrA = null;
        }
        if (bArrA == null || (strF = f()) == null || (bArrA2 = c.a(strF, bArrA)) == null) {
            return null;
        }
        try {
            bArrA3 = c.a(bArrA2, bArr, false);
        } catch (Throwable th2) {
            g.a(th2);
            bArrA3 = null;
        }
        if (bArrA3 == null) {
            return null;
        }
        return new String(bArrA3);
    }

    private static StringBuilder a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb;
    }

    public static boolean e() {
        try {
            if (!com.uc.crashsdk.e.F() && !com.uc.crashsdk.b.L()) {
                a(true);
                return b;
            }
            return true;
        } catch (Throwable th) {
        }
    }
}
