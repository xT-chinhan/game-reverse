package com.anythink.core.common;

import android.text.TextUtils;
import com.anythink.core.common.h.ao;

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

    public static String b() {
        return com.anythink.core.common.g.c.a().a(l() ? com.anythink.core.common.d.j.e.x : com.anythink.core.common.d.j.e.f);
    }

    public static String c() {
        String str = l() ? com.anythink.core.common.d.j.e.y : com.anythink.core.common.d.j.e.g;
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
        if (bVarB != null && !TextUtils.isEmpty(bVarB.aG())) {
            return bVarB.aG();
        }
        return com.anythink.core.common.g.c.a().a(str);
    }

    private static String r() {
        return l() ? com.anythink.core.common.d.j.e.C : com.anythink.core.common.d.j.e.k;
    }

    private static String s() {
        return com.anythink.core.common.g.c.a().a(l() ? com.anythink.core.common.d.j.e.I : com.anythink.core.common.d.j.e.r);
    }

    public static String a(com.anythink.core.d.l lVar, boolean z) {
        if (z) {
            String strR = lVar.R();
            lVar.aH();
            if (!TextUtils.isEmpty(strR)) {
                return strR;
            }
        }
        ao aoVarC = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p()).C();
        String strA = com.anythink.core.common.g.c.a().a(l() ? com.anythink.core.common.d.j.e.D : com.anythink.core.common.d.j.e.l, com.anythink.core.common.m.b.g.i);
        return aoVarC != null ? a(aoVarC.c(), strA) : strA;
    }

    public static String a(com.anythink.core.d.l lVar) {
        String strN = lVar.N();
        return TextUtils.isEmpty(strN) ? "" : strN;
    }

    public static String b(com.anythink.core.d.l lVar) {
        return lVar.M();
    }

    public static String d() {
        ao aoVarC = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p()).C();
        String strA = com.anythink.core.common.g.c.a().a(l() ? com.anythink.core.common.d.j.e.E : com.anythink.core.common.d.j.e.m, com.anythink.core.common.m.b.g.i);
        return aoVarC != null ? a(aoVarC.b(), strA) : strA;
    }

    public static String e() {
        ao aoVarC = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p()).C();
        String strA = com.anythink.core.common.g.c.a().a(l() ? com.anythink.core.common.d.j.e.F : com.anythink.core.common.d.j.e.n, com.anythink.core.common.m.b.g.g);
        return aoVarC != null ? a(aoVarC.d(), strA) : strA;
    }

    public static String f() {
        ao aoVarC = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p()).C();
        String strA = com.anythink.core.common.g.c.a().a(l() ? com.anythink.core.common.d.j.e.G : com.anythink.core.common.d.j.e.o, com.anythink.core.common.m.b.g.i);
        return aoVarC != null ? a(aoVarC.a(), strA) : strA;
    }

    public static String g() {
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
        String strA = com.anythink.core.common.g.c.a().a(l() ? com.anythink.core.common.d.j.e.H : com.anythink.core.common.d.j.e.q, com.anythink.core.common.m.b.g.g);
        return bVarB != null ? a(bVarB.z(), strA) : strA;
    }

    public static String h() {
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
        String strA = com.anythink.core.common.g.c.a().a(l() ? com.anythink.core.common.d.j.e.B : com.anythink.core.common.d.j.e.j, com.anythink.core.common.m.b.g.g);
        return bVarB != null ? a(bVarB.al(), strA) : strA;
    }

    public static String i() {
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
        String strA = com.anythink.core.common.g.c.a().a(l() ? com.anythink.core.common.d.j.e.A : com.anythink.core.common.d.j.e.i, com.anythink.core.common.m.b.g.h);
        return bVarB != null ? a(bVarB.aq(), strA) : strA;
    }

    public static String j() {
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
        if (bVarB != null) {
            return a(bVarB.ai(), "https:///gdpr/PrivacyPolicySetting.html");
        }
        com.anythink.core.common.d.s sVarC = com.anythink.core.common.d.t.b().c();
        String gdprUrl = sVarC != null ? sVarC.getGdprUrl() : "";
        return !TextUtils.isEmpty(gdprUrl) ? gdprUrl : "https:///gdpr/PrivacyPolicySetting.html";
    }

    public static String k() {
        return com.anythink.core.common.d.j.e.t;
    }

    private static String a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public static boolean l() {
        return com.anythink.core.common.d.t.b().L() && com.anythink.core.common.d.t.b().K();
    }

    private static String t() {
        return com.anythink.core.common.g.c.a().a(l() ? com.anythink.core.common.d.j.e.J : com.anythink.core.common.d.j.e.v);
    }

    public static String m() {
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
        String strA = com.anythink.core.common.g.c.a().a(l() ? com.anythink.core.common.d.j.e.z : com.anythink.core.common.d.j.e.h, com.anythink.core.common.m.b.g.k);
        return bVarB != null ? a(bVarB.aF(), strA) : strA;
    }

    public static String n() {
        com.anythink.core.common.d.s sVarC = com.anythink.core.common.d.t.b().c();
        String cdnUrl = sVarC != null ? sVarC.getCdnUrl() : "";
        if (TextUtils.isEmpty(cdnUrl)) {
            cdnUrl = "https:///v2/open/ns";
        }
        com.anythink.core.d.b bVarA = com.anythink.core.d.d.a();
        if (bVarA == null) {
            return cdnUrl;
        }
        String strAa = bVarA.aa();
        if (TextUtils.isEmpty(strAa)) {
            return cdnUrl;
        }
        if (strAa.startsWith("http")) {
            return strAa + "/v2/open/ns";
        }
        return com.anythink.core.common.v.q.a(cdnUrl, strAa);
    }

    public static String o() {
        com.anythink.core.d.b bVarA = com.anythink.core.d.d.a();
        com.anythink.core.common.d.s sVarC = com.anythink.core.common.d.t.b().c();
        String cdnTcpDm = (sVarC == null || sVarC.getOsDmEntity() == null) ? "" : sVarC.getOsDmEntity().getCdnTcpDm();
        String str = TextUtils.isEmpty(cdnTcpDm) ? "" : cdnTcpDm;
        if (bVarA == null) {
            return str;
        }
        String strAM = bVarA.aM();
        return !TextUtils.isEmpty(strAM) ? strAM : str;
    }

    public static int p() {
        int iAN;
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
        return (bVarB == null || (iAN = bVarB.aN()) <= 0) ? com.anythink.core.common.d.j.g.b.a : iAN;
    }

    public static String q() {
        String str = l() ? com.anythink.core.common.d.j.e.K : com.anythink.core.common.d.j.e.w;
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
        if (bVarB != null && !TextUtils.isEmpty(bVarB.aO())) {
            return bVarB.aO();
        }
        return com.anythink.core.common.g.c.a().a(str);
    }
}
