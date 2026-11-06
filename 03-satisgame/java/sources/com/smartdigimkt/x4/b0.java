package com.smartdigimkt.x4;

import android.text.TextUtils;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.SDMSDK;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements com.smartdigimkt.o4.n {
    public final /* synthetic */ com.smartdigimkt.v4.a a;
    public final /* synthetic */ com.smartdigimkt.h3.b b;
    public final /* synthetic */ com.smartdigimkt.p4.e c;
    public final /* synthetic */ d0 d;

    public b0(d0 d0Var, com.smartdigimkt.v4.a aVar, com.smartdigimkt.h3.b bVar, com.smartdigimkt.p4.e eVar) {
        this.d = d0Var;
        this.a = aVar;
        this.b = bVar;
        this.c = eVar;
    }

    @Override // com.smartdigimkt.o4.n
    public final void a() {
    }

    @Override // com.smartdigimkt.o4.n
    public final void a(com.smartdigimkt.p4.e eVar) {
    }

    @Override // com.smartdigimkt.o4.n
    public final void b() {
    }

    @Override // com.smartdigimkt.o4.n
    public final void a(AdError adError) {
        ThreadPoolExecutor threadPoolExecutor;
        com.smartdigimkt.h3.b bVar = this.b;
        if (bVar != null) {
            bVar.a("strategy");
        }
        if (adError != null) {
            com.smartdigimkt.v4.a aVar = this.a;
            String str = aVar.e;
            String strA = com.smartdigimkt.r4.j.a(String.valueOf(aVar.c));
            String errorInfo = adError.getErrorInfo();
            ThreadPoolExecutor threadPoolExecutor2 = com.smartdigimkt.r4.w.a;
            if (SDMSDK.getInstance().isNetworkLogDebug() && (threadPoolExecutor = com.smartdigimkt.r4.w.a) != null) {
                threadPoolExecutor.execute(new com.smartdigimkt.r4.t(str, strA, errorInfo));
            }
            this.a.a(com.smartdigimkt.z3.b.a("10006", adError.getErrorInfo()));
        } else {
            this.a.a(com.smartdigimkt.z3.b.a("10006", ""));
        }
        com.smartdigimkt.v4.a aVar2 = this.a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.smartdigimkt.w4.a aVar3 = aVar2.i;
        if (aVar3 != null) {
            aVar3.c = jCurrentTimeMillis;
        }
        com.smartdigimkt.r4.b0.a(this.a.v, this.c);
        this.d.a(this.a);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00b6  */
    @Override // com.smartdigimkt.o4.n
    public final void b(com.smartdigimkt.p4.e eVar) {
        com.smartdigimkt.z3.a aVarA;
        int i;
        int i2;
        long j;
        d0 d0Var = this.d;
        com.smartdigimkt.v4.a aVar = this.a;
        d0Var.getClass();
        if (eVar == null) {
            aVarA = com.smartdigimkt.z3.b.a("10006", "The placeStrategy is null.");
        } else {
            com.smartdigimkt.p4.g gVarA = eVar.a();
            String str = gVarA == null ? "The placeStrategy does not has ADX ad source." : "";
            if (TextUtils.isEmpty(str) && (i = aVar.c) != (i2 = eVar.m)) {
                str = "Format corresponding to API: " + com.smartdigimkt.r4.j.a(String.valueOf(i)) + ", Format corresponding to placement strategy: " + com.smartdigimkt.r4.j.a(String.valueOf(i2));
            }
            if (TextUtils.isEmpty(str) && eVar.j != 1) {
                str = "Placement Ads switch is close.";
            }
            aVar.o = gVarA;
            aVar.n = eVar;
            aVarA = !TextUtils.isEmpty(str) ? com.smartdigimkt.z3.b.a("10006", str) : null;
        }
        com.smartdigimkt.h3.b bVar = this.b;
        if (bVar != null) {
            bVar.a("strategy");
        }
        if (aVarA != null) {
            this.a.a(aVarA);
            this.d.a(this.a);
            return;
        }
        com.smartdigimkt.v4.a aVar2 = this.a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.smartdigimkt.w4.a aVar3 = aVar2.i;
        if (aVar3 != null) {
            aVar3.c = jCurrentTimeMillis;
        }
        com.smartdigimkt.r4.b0.a(this.a.v, eVar);
        if (this.a.z) {
            x xVar = new x();
            com.smartdigimkt.v4.a aVar4 = this.a;
            x.f(aVar4);
            if (eVar != null) {
                j = eVar.k;
                if (j <= 0) {
                    j = 60000;
                }
            } else {
                j = 60000;
            }
            v vVar = new v(xVar, aVar4);
            aVar4.l = vVar;
            com.smartdigimkt.m3.g.a().a.a(vVar, j);
        }
        this.d.a(this.a);
    }
}
