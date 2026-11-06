package com.mcto.sspsdk.internal;

import com.mar.sdk.IAction;
import com.mcto.sspsdk.QyAdSlot;
import com.qq.e.comm.pi.IBidding;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class lk {
    public final j6 a;
    public p b;
    public vh c;
    public bl d;
    public int e;
    public String f;
    public String g;
    public QyAdSlot k;
    public int l;
    public boolean h = false;
    public int i = -1;
    public int j = -1;
    public final AtomicInteger m = new AtomicInteger(2);

    public lk(j6 j6Var) {
        this.a = j6Var;
    }

    public final void a() {
        bl blVar;
        this.m.get();
        if (this.m.decrementAndGet() == 0) {
            p pVar = this.b;
            if (pVar == null) {
                String str = this.f;
                boolean z = this.h;
                if (!z || (blVar = this.d) == null) {
                    this.i = 3;
                    this.j = z ? 3 : 2;
                    this.a.c.a(this.e, str);
                } else {
                    this.i = 2;
                    this.j = 3;
                    blVar.n = this.g;
                    this.a.c.a(new uk(blVar, this.c));
                }
            } else {
                bl blVar2 = this.d;
                if (blVar2 == null || !this.h) {
                    boolean z2 = this.h;
                    this.i = 1;
                    this.j = z2 ? 3 : 2;
                    j6 j6Var = this.a;
                    m6.a(j6Var.a, pVar, j6Var.b, j6Var.c);
                } else if (pVar.N0 == 0) {
                    int i = pVar.w0;
                    this.j = 2;
                    this.i = 2;
                    blVar2.m = i;
                    blVar2.n = this.g;
                    this.a.c.a(new uk(blVar2, this.c));
                    HashMap map = new HashMap();
                    map.put(IAction.PurchaseKey.Price, Double.valueOf(this.d.c));
                    map.put(IBidding.ADN_ID, Integer.valueOf(this.d.d));
                    this.b.a(map);
                } else {
                    pVar.k();
                    HashMap map2 = new HashMap();
                    map2.put(IAction.PurchaseKey.Price, Double.valueOf(this.d.c));
                    map2.put(IBidding.ADN_ID, Integer.valueOf(this.d.d));
                    this.j = 1;
                    if (Double.compare(this.b.k().doubleValue(), this.d.c) >= 0) {
                        this.i = 1;
                        this.b.b(map2);
                        j6 j6Var2 = this.a;
                        m6.a(j6Var2.a, this.b, j6Var2.b, j6Var2.c);
                    } else {
                        this.i = 2;
                        int i2 = this.b.w0;
                        bl blVar3 = this.d;
                        blVar3.m = i2;
                        blVar3.n = this.g;
                        this.a.c.a(new uk(blVar3, this.c));
                        this.b.a(map2);
                    }
                }
            }
            int i3 = this.i;
            if (i3 == -1) {
                return;
            }
            if (i3 != 2 && this.d != null) {
                xk xkVarA = xk.a();
                bl blVar4 = this.d;
                xkVarA.a.a(blVar4.b, blVar4);
            }
            StringBuilder sbAppend = new StringBuilder("reason:").append(this.j).append(";");
            if (this.k != null) {
                sbAppend.append("azId:").append(this.k.getCodeId()).append(";adt:");
                sbAppend.append(f0.b(this.l)).append(";");
            }
            if (this.b != null) {
                sbAppend.append("impi:").append(this.b.n0).append(";np:");
                sbAppend.append(String.format(Locale.CHINA, "%.1f", this.b.k())).append(";no:");
                sbAppend.append(this.b.g).append(";nName:");
                sbAppend.append(this.b.P).append(";");
            }
            bl blVar5 = this.d;
            if (blVar5 != null) {
                sbAppend.append(blVar5.b());
            }
            int i4 = this.i;
            if (i4 == 1) {
                za zaVarD = za.d();
                p pVar2 = this.b;
                String str2 = this.g;
                String string = sbAppend.toString();
                zaVarD.getClass();
                za.a(57, pVar2, str2, "", string);
                return;
            }
            if (i4 == 2) {
                za zaVarD2 = za.d();
                p pVar3 = this.b;
                String str3 = this.g;
                String string2 = sbAppend.toString();
                zaVarD2.getClass();
                za.a(58, pVar3, str3, "", string2);
                return;
            }
            if (i4 == 3) {
                za zaVarD3 = za.d();
                p pVar4 = this.b;
                String str4 = this.g;
                String string3 = sbAppend.toString();
                zaVarD3.getClass();
                za.a(59, pVar4, str4, "", string3);
            }
        }
    }
}
