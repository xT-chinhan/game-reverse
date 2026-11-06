package com.anythink.basead.f.f;

import android.text.TextUtils;
import com.anythink.basead.b.e;
import com.anythink.basead.f.d;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.bk;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static void a(bk bkVar, d dVar, boolean z) {
        if (bkVar == null || dVar == null) {
            return;
        }
        bkVar.x(dVar.a());
        if (!z) {
            bkVar.y(dVar.b());
        }
        bkVar.e(dVar.d());
        bkVar.r(dVar.c());
        bkVar.q(dVar.e());
        bkVar.b(dVar.f());
        bkVar.p(dVar.g());
        bkVar.c(dVar.h());
        bkVar.d(dVar.i());
        bkVar.f(dVar.j());
        bkVar.f(dVar.k());
        bkVar.aD(dVar.l());
    }

    public static void a(x xVar, bj bjVar) {
        y yVar;
        if (xVar == null || bjVar == null || (yVar = xVar.o) == null || !(xVar.o instanceof bk)) {
            return;
        }
        y yVarR = bjVar.r();
        if (yVarR != null) {
            yVarR.x(yVar.I());
            if (xVar.f != 66) {
                yVarR.y(yVar.J());
            }
            yVarR.r(yVar.C());
            yVarR.e(yVar.B());
            yVarR.s(yVar.D());
            yVarR.q(yVar.A());
            yVarR.b(yVar.x());
            yVarR.p(yVar.z());
            yVarR.d(yVar.l());
            yVarR.c(yVar.k());
            yVarR.f(yVar.O());
            yVarR.f(yVar.aG());
            yVarR.aD(yVar.bG());
            xVar.o = yVarR;
        } else {
            bjVar.c(xVar.o);
        }
        if (!bjVar.L() && xVar.j == 1) {
            xVar.o.a(xVar.o.am());
            xVar.o.ao(1);
        }
        boolean z = !(bjVar instanceof r) || TextUtils.isEmpty(((r) bjVar).d());
        if (!e.a(bjVar, xVar)) {
            xVar.o.j(2);
        }
        if (z && TextUtils.isEmpty(bjVar.H())) {
            xVar.o.t(0);
            xVar.o.v(0);
            xVar.o.J(2);
            xVar.o.j(2);
            xVar.o.C(1);
            xVar.o.u(-2);
            xVar.o.c(false);
            xVar.o.d(false);
            xVar.o.e(false);
            xVar.o.W(2);
            if (bjVar.n()) {
                xVar.o.w(1);
            }
            xVar.o.m(0L);
            xVar.o.k(0L);
            xVar.o.ai(1);
            xVar.o.as(1);
        }
        if (xVar.j != 3 || e.a(bjVar, xVar) || bjVar.n()) {
            xVar.o.V(0);
        }
        if (TextUtils.isEmpty(bjVar.H())) {
            xVar.o.U(1);
        }
        if (bjVar.ae()) {
            com.anythink.basead.b.a().updateOfferInfoWithDataInfo(bjVar);
        }
        if (bjVar.n()) {
            xVar.o.k(0L);
        }
        if (xVar.o.aB() > 0) {
            xVar.o.ad(2);
        }
        if (xVar.o.bj() == 2) {
            xVar.o.u(0);
            xVar.o.v(-1);
            if (TextUtils.isEmpty(bjVar.x())) {
                if (xVar.j == 1 || xVar.j == 3) {
                    bjVar.m(t.b().g().getString(q.a(t.b().g(), "myoffer_sub_close_default_title", "string")));
                }
            }
        }
    }
}
