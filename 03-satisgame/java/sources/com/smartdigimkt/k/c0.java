package com.smartdigimkt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {
    public final /* synthetic */ d0 a;

    public c0(d0 d0Var) {
        this.a = d0Var;
    }

    public final void a(int i) {
        r rVar;
        r rVar2;
        r rVar3;
        int iA = u.a(i);
        if (iA == 2) {
            r rVar4 = this.a.a;
            if (rVar4 != null) {
                com.smartdigimkt.b3.c cVar = rVar4.j;
                if (cVar != null) {
                    cVar.D = 4;
                }
                rVar4.s = c.LOADING;
                return;
            }
            return;
        }
        if (iA == 3) {
            r rVar5 = this.a.a;
            if (rVar5 != null) {
                com.smartdigimkt.b3.c cVar2 = rVar5.j;
                if (cVar2 != null) {
                    cVar2.D = 7;
                }
                rVar5.s = c.PAUSE;
            }
            d0 d0Var = this.a;
            a aVar = d0Var.d;
            if (aVar == null || (rVar = d0Var.a) == null) {
                return;
            }
            aVar.a(rVar, rVar.g, rVar.h, 2);
            return;
        }
        if (iA == 4) {
            r rVar6 = this.a.a;
            if (rVar6 != null) {
                com.smartdigimkt.b3.c cVar3 = rVar6.j;
                if (cVar3 != null) {
                    cVar3.D = 7;
                }
                rVar6.s = c.STOP;
            }
            d0 d0Var2 = this.a;
            a aVar2 = d0Var2.d;
            if (aVar2 == null || (rVar2 = d0Var2.a) == null) {
                return;
            }
            aVar2.a(rVar2, rVar2.g, rVar2.h, 3);
            return;
        }
        if (iA != 5) {
            if (iA == 6 && (rVar3 = this.a.a) != null) {
                com.smartdigimkt.b3.c cVar4 = rVar3.j;
                if (cVar4 != null) {
                    cVar4.D = 6;
                }
                rVar3.s = c.FAIL;
                return;
            }
            return;
        }
        r rVar7 = this.a.a;
        if (rVar7 != null) {
            com.smartdigimkt.b3.c cVar5 = rVar7.j;
            if (cVar5 != null) {
                cVar5.D = 5;
            }
            rVar7.s = c.FINISH;
        }
    }

    public final void a(int i, String str) {
        String str2;
        d0 d0Var = this.a;
        a aVar = d0Var.d;
        if (aVar != null) {
            r rVar = d0Var.a;
            if (i == 1) {
                str2 = "10001";
            } else {
                str2 = i == 2 ? com.anythink.core.common.inner.b.b.d : com.anythink.core.common.inner.b.b.b;
            }
            aVar.a(rVar, "code[ " + str2 + " ],desc[ " + str + " ]");
        }
    }
}
