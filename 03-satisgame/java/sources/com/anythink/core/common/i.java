package com.anythink.core.common;

import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.h.ap;

/* JADX INFO: loaded from: classes.dex */
public class i {
    private static volatile i a;

    private static String a(String str) {
        return str;
    }

    private i() {
    }

    public static i a() {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = new i();
                }
            }
        }
        return a;
    }

    public static String a(boolean z) {
        String str;
        if (z) {
            str = h() ? com.anythink.core.common.d.i.e.B : com.anythink.core.common.d.i.e.f;
        } else {
            str = h() ? com.anythink.core.common.d.i.e.C : com.anythink.core.common.d.i.e.g;
        }
        String strAK = "";
        if (ATSDK.isCnSDK()) {
            com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
            if (bVarB != null) {
                strAK = z ? bVarB.aK() : bVarB.aL();
            }
            com.anythink.core.common.g.c.a();
            return com.anythink.core.common.g.c.b(str, strAK);
        }
        return com.anythink.core.common.g.c.a().a(str, "", z);
    }

    public static String b(boolean z) {
        String str;
        if (z) {
            str = h() ? com.anythink.core.common.d.i.e.D : com.anythink.core.common.d.i.e.h;
        } else {
            str = h() ? com.anythink.core.common.d.i.e.E : com.anythink.core.common.d.i.e.i;
        }
        String strAK = "";
        if (ATSDK.isCnSDK()) {
            com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
            if (bVarB != null) {
                strAK = z ? bVarB.aK() : bVarB.aL();
            }
            com.anythink.core.common.g.c.a();
            return com.anythink.core.common.g.c.b(str, strAK);
        }
        return com.anythink.core.common.g.c.a().a(str, "", z);
    }

    public static String b() {
        return h() ? com.anythink.core.common.d.i.e.J : com.anythink.core.common.d.i.e.n;
    }

    private static String o() {
        return com.anythink.core.common.g.c.a().a(h() ? com.anythink.core.common.d.i.e.P : com.anythink.core.common.d.i.e.u, "");
    }

    public static String a(com.anythink.core.e.l lVar, boolean z) {
        if (z) {
            String strS = lVar.S();
            lVar.aG();
            if (!TextUtils.isEmpty(strS)) {
                return strS;
            }
        }
        ap apVarU = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p()).u();
        String strA = com.anythink.core.common.g.c.a().a(h() ? com.anythink.core.common.d.i.e.K : com.anythink.core.common.d.i.e.o, "bid");
        return apVarU != null ? a(apVarU.c(), strA) : strA;
    }

    public static String a(com.anythink.core.e.l lVar) {
        String strO = lVar.O();
        return TextUtils.isEmpty(strO) ? "" : strO;
    }

    public static String b(com.anythink.core.e.l lVar) {
        return lVar.N();
    }

    private static String p() {
        ap apVarU = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p()).u();
        String strA = com.anythink.core.common.g.c.a().a(h() ? com.anythink.core.common.d.i.e.L : com.anythink.core.common.d.i.e.p, "bid");
        return apVarU != null ? a(apVarU.b(), strA) : strA;
    }

    private static String q() {
        ap apVarU = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p()).u();
        String strA = com.anythink.core.common.g.c.a().a(h() ? com.anythink.core.common.d.i.e.M : com.anythink.core.common.d.i.e.q, "tracking");
        return apVarU != null ? a(apVarU.d(), strA) : strA;
    }

    private static String r() {
        ap apVarU = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p()).u();
        String strA = com.anythink.core.common.g.c.a().a(h() ? com.anythink.core.common.d.i.e.N : com.anythink.core.common.d.i.e.r, "bid");
        return apVarU != null ? a(apVarU.a(), strA) : strA;
    }

    public static String c() {
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
        String strA = com.anythink.core.common.g.c.a().a(h() ? com.anythink.core.common.d.i.e.O : com.anythink.core.common.d.i.e.t, "tracking");
        return bVarB != null ? a(bVarB.r(), strA) : strA;
    }

    public static String d() {
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
        String strA = com.anythink.core.common.g.c.a().a(h() ? com.anythink.core.common.d.i.e.I : com.anythink.core.common.d.i.e.m, "tracking");
        return bVarB != null ? a(bVarB.ab(), strA) : strA;
    }

    public static String e() {
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
        String strA = com.anythink.core.common.g.c.a().a(h() ? com.anythink.core.common.d.i.e.G : com.anythink.core.common.d.i.e.k, "agent");
        return bVarB != null ? a(bVarB.ag(), strA) : strA;
    }

    private static String s() {
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
        String strA = com.anythink.core.common.g.c.a().a(h() ? com.anythink.core.common.d.i.e.H : com.anythink.core.common.d.i.e.l, "tracking");
        if (bVarB != null) {
            String strAU = bVarB.aU();
            if (!TextUtils.isEmpty(strAU)) {
                if (strAU.startsWith("http")) {
                    return strAU + "/v2/open/anr";
                }
                return com.anythink.core.common.u.p.a(strA, strAU);
            }
        }
        return strA;
    }

    public static String f() {
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
        if (bVarB != null) {
            return a(bVarB.X(), "https:///gdpr/PrivacyPolicySetting.html");
        }
        com.anythink.core.common.d.r rVarC = com.anythink.core.common.d.s.b().c();
        String gdprUrl = rVarC != null ? rVarC.getGdprUrl() : "";
        return !TextUtils.isEmpty(gdprUrl) ? gdprUrl : "https:///gdpr/PrivacyPolicySetting.html";
    }

    public static String g() {
        return com.anythink.core.common.d.i.e.w;
    }

    private static String a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public static boolean h() {
        return com.anythink.core.common.d.s.b().L() && com.anythink.core.common.d.s.b().K();
    }

    private static String t() {
        return com.anythink.core.common.g.c.a().a(h() ? com.anythink.core.common.d.i.e.Q : com.anythink.core.common.d.i.e.z, "");
    }

    public static String i() {
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
        String strA = com.anythink.core.common.g.c.a().a(h() ? com.anythink.core.common.d.i.e.F : com.anythink.core.common.d.i.e.j, "smart_wf");
        return bVarB != null ? a(bVarB.ar(), strA) : strA;
    }

    public static String j() {
        com.anythink.core.common.d.r rVarC = com.anythink.core.common.d.s.b().c();
        String cdnUrl = rVarC != null ? rVarC.getCdnUrl() : "";
        if (TextUtils.isEmpty(cdnUrl)) {
            cdnUrl = "https://se.anythinktech.com/v2/open/ns";
        }
        com.anythink.core.e.b bVarA = com.anythink.core.e.d.a();
        if (bVarA == null) {
            return cdnUrl;
        }
        String strQ = bVarA.Q();
        if (TextUtils.isEmpty(strQ)) {
            return cdnUrl;
        }
        if (strQ.startsWith("http")) {
            return strQ + "/v2/open/ns";
        }
        return com.anythink.core.common.u.p.a(cdnUrl, strQ);
    }

    public static String k() {
        com.anythink.core.e.b bVarA = com.anythink.core.e.d.a();
        com.anythink.core.common.d.r rVarC = com.anythink.core.common.d.s.b().c();
        String cdnTcpDm = (rVarC == null || rVarC.getOsDmEntity() == null) ? "" : rVarC.getOsDmEntity().getCdnTcpDm();
        if (TextUtils.isEmpty(cdnTcpDm)) {
            cdnTcpDm = com.anythink.core.common.d.i.g.b.c;
        }
        if (bVarA == null) {
            return cdnTcpDm;
        }
        String strAv = bVarA.av();
        return !TextUtils.isEmpty(strAv) ? strAv : cdnTcpDm;
    }

    public static int l() {
        int iAw;
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
        return (bVarB == null || (iAw = bVarB.aw()) <= 0) ? com.anythink.core.common.d.i.g.b.a : iAw;
    }

    public static String m() {
        String str = h() ? com.anythink.core.common.d.i.e.R : com.anythink.core.common.d.i.e.A;
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
        if (bVarB != null && !TextUtils.isEmpty(bVarB.az())) {
            return bVarB.az();
        }
        return com.anythink.core.common.g.c.a().a(str, "");
    }

    public static String n() {
        com.anythink.core.common.d.r rVarC = com.anythink.core.common.d.s.b().c();
        String cdnUrl = rVarC != null ? rVarC.getCdnUrl() : "";
        String strReplace = TextUtils.isEmpty(cdnUrl) ? "https://se.anythinktech.com/v2/open/api_hb" : cdnUrl.replace("/v2/open/ns", "/v2/open/api_hb");
        com.anythink.core.e.b bVarA = com.anythink.core.e.d.a();
        if (bVarA == null) {
            return strReplace;
        }
        String strQ = bVarA.Q();
        if (TextUtils.isEmpty(strQ)) {
            return strReplace;
        }
        if (strQ.startsWith("http")) {
            return strQ + "/v2/open/api_hb";
        }
        return "https://" + strQ + "/v2/open/api_hb";
    }

    private static String u() {
        return k();
    }

    private static int v() {
        return l();
    }
}
