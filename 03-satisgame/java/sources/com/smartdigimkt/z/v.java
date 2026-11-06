package com.smartdigimkt.z;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements Runnable {
    public final /* synthetic */ com.smartdigimkt.h0.m a;
    public final /* synthetic */ a0 b;

    public v(a0 a0Var, com.smartdigimkt.h0.m mVar) {
        this.b = a0Var;
        this.a = mVar;
    }

    /* JADX WARN: Code duplicated, block: B:64:0x0109  */
    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.h0.m mVar;
        com.smartdigimkt.a0.s sVar;
        boolean z;
        com.smartdigimkt.a0.o oVar = this.b.h;
        com.smartdigimkt.a0.r rVar = oVar.e;
        if (rVar == null || (mVar = rVar.b) == null) {
            sVar = new com.smartdigimkt.a0.s(false);
        } else {
            mVar.i = new com.smartdigimkt.h0.b();
            com.smartdigimkt.h0.f fVarA = oVar.a();
            mVar.i.a = fVarA != null ? fVarA.b : "";
            if (TextUtils.isEmpty(oVar.c.q)) {
                sVar = new com.smartdigimkt.a0.s(false);
            } else {
                String str = oVar.c.q;
                String str2 = oVar.d.g;
                String strReplaceAll = str.replaceAll("\\{req_id\\}", str2 != null ? str2 : "");
                int i = com.smartdigimkt.c0.h.a(oVar.b, oVar.d, oVar.c, strReplaceAll).a;
                if (i == 0 || i == 5) {
                    com.smartdigimkt.h0.a aVar = mVar.g;
                    if (aVar != null) {
                        aVar.i = true;
                    }
                    com.smartdigimkt.a0.r rVar2 = oVar.e;
                    if (rVar2 != null) {
                        rVar2.a();
                    }
                    com.smartdigimkt.n3.k.a(oVar.d, oVar.c, strReplaceAll, "1", 1, 0, "");
                    com.smartdigimkt.a0.e eVar = oVar.f;
                    if (eVar != null) {
                        eVar.b();
                        oVar.f.a();
                        oVar.f.a(true);
                        oVar.f.c();
                    }
                    sVar = new com.smartdigimkt.a0.s(true);
                } else {
                    com.smartdigimkt.n3.k.a(oVar.d, oVar.c, strReplaceAll, "0", 1, 0, "");
                    sVar = new com.smartdigimkt.a0.s(false);
                }
            }
        }
        if (sVar.a) {
            return;
        }
        a0 a0Var = this.b;
        com.smartdigimkt.b3.c cVar = a0Var.b;
        Context context = a0Var.d;
        String str3 = cVar.m;
        if (context == null || TextUtils.isEmpty(str3)) {
            z = false;
        } else {
            try {
                context.getPackageManager().getApplicationInfo(str3, 8192);
                int i2 = cVar.o;
                if (i2 == 1 || i2 == 3 || i2 == 4) {
                    String str4 = cVar.k;
                    if (TextUtils.isEmpty(str4) || k.a(str4)) {
                        a0 a0Var2 = this.b;
                        if (a0Var2.b.o == 4) {
                            a0Var2.j.b();
                        }
                        com.smartdigimkt.a0.s sVarB = this.b.i.b();
                        a0 a0Var3 = this.b;
                        String str5 = a0Var3.a;
                        if (sVarB.a) {
                            com.smartdigimkt.a0.e eVar2 = a0Var3.g;
                            if (eVar2 != null) {
                                eVar2.c();
                                return;
                            }
                            return;
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
            } catch (Throwable unused) {
            }
        }
        a0 a0Var4 = this.b;
        int iJ = c0.j(a0Var4.b, a0Var4.e);
        if (k.a(this.b.b.k) || z) {
            iJ = 0;
        }
        if (iJ == 1) {
            this.b.j.a(4, this.b.j.b());
            com.smartdigimkt.a0.s sVarB2 = this.b.i.b();
            a0 a0Var5 = this.b;
            com.smartdigimkt.n3.k.a(a0Var5.b, a0Var5.e, 1, sVarB2.a ? 1 : 2);
            return;
        }
        if (iJ > 1) {
            a0 a0Var6 = this.b;
            com.smartdigimkt.n3.k.a(a0Var6.b, a0Var6.e, iJ, 0);
        }
        com.smartdigimkt.h0.m mVar2 = this.a;
        if (!mVar2.k) {
            a0 a0Var7 = this.b;
            if (a0Var7.n && c0.a(a0Var7.b, a0Var7.e.s, mVar2, 1)) {
                a0 a0Var8 = this.b;
                a0Var8.o.openDataConfirmDialog(a0Var8.d, a0Var8.b, a0Var8.e, new u(this, z));
                return;
            }
        }
        a0.a(this.b, this.a, z);
    }
}
