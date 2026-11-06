package com.smartdigimkt.z;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.smartdigimkt.sdk.core.SDKContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {
    public final com.smartdigimkt.b3.c b;
    public final Context d;
    public final com.smartdigimkt.a3.a e;
    public final com.smartdigimkt.a0.r f;
    public com.smartdigimkt.a0.e g;
    public final com.smartdigimkt.a0.o h;
    public final com.smartdigimkt.a0.k i;
    public final com.smartdigimkt.a0.g j;
    public final com.smartdigimkt.a0.p k;
    public final com.smartdigimkt.a0.t l;
    public final com.smartdigimkt.a0.n m;
    public final boolean n;
    public final com.smartdigimkt.w2.b o;
    public final String a = "a0";
    public boolean c = false;

    public a0(Context context, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, View view) {
        boolean z = false;
        this.n = false;
        this.b = cVar;
        this.e = aVar;
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        cVar.x = aVar.g;
        com.smartdigimkt.d1.e eVar = new com.smartdigimkt.d1.e();
        com.smartdigimkt.a0.r rVar = new com.smartdigimkt.a0.r(cVar, aVar);
        this.f = rVar;
        com.smartdigimkt.a0.e eVar2 = new com.smartdigimkt.a0.e();
        this.g = eVar2;
        com.smartdigimkt.a0.a aVar2 = new com.smartdigimkt.a0.a();
        aVar2.a = applicationContext;
        aVar2.b = cVar;
        aVar2.c = aVar;
        aVar2.d = rVar;
        aVar2.e = eVar2;
        aVar2.f = eVar;
        this.h = new com.smartdigimkt.a0.o(aVar2);
        com.smartdigimkt.a0.k kVar = new com.smartdigimkt.a0.k(aVar2);
        this.i = kVar;
        com.smartdigimkt.a0.g gVar = new com.smartdigimkt.a0.g(aVar2);
        this.j = gVar;
        this.k = new com.smartdigimkt.a0.p(aVar2);
        this.l = new com.smartdigimkt.a0.t(aVar2);
        this.m = new com.smartdigimkt.a0.n(aVar2);
        if (view != null) {
            kVar.j = new WeakReference(view);
        }
        kVar.k = gVar;
        gVar.k = kVar;
        com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
        this.o = bVarE;
        if (bVarE != null && bVarE.a()) {
            z = true;
        }
        this.n = z;
    }

    public final void a(com.smartdigimkt.h0.m mVar) {
        if (this.c) {
            return;
        }
        com.smartdigimkt.a0.e eVar = this.g;
        if (eVar == null || !eVar.e.get()) {
            com.smartdigimkt.a0.r rVar = this.f;
            if (rVar != null) {
                rVar.b = mVar;
            }
            com.smartdigimkt.a0.e eVar2 = this.g;
            if (eVar2 != null) {
                eVar2.e.set(true);
                eVar2.b = false;
                eVar2.c = false;
                eVar2.d = false;
            }
            com.smartdigimkt.q3.f.a().c(new v(this, mVar));
        }
    }

    public static void a(a0 a0Var, com.smartdigimkt.h0.m mVar, boolean z) {
        int i;
        int i2;
        int i3 = a0Var.e.s.r;
        if (i3 != 0 && i3 == 2) {
            i = 1;
        } else {
            i = (z || !a0Var.i.b().a) ? 3 : 2;
        }
        if (i == 2 && ((i2 = a0Var.e.s.r) == 0 || i2 == 1 || k.a(a0Var.b.k))) {
            com.smartdigimkt.a0.e eVar = a0Var.g;
            if (eVar != null) {
                eVar.c();
                return;
            }
            return;
        }
        if (!mVar.k && a0Var.n && i != 2 && c0.a(a0Var.b, a0Var.e.s, mVar, 4)) {
            a0Var.o.openDataConfirmDialog(a0Var.d, a0Var.b, a0Var.e, new x(a0Var, i));
        } else {
            a0Var.a(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01bb A[PHI: r6
      0x01bb: PHI (r6v3 com.smartdigimkt.a0.s) = (r6v1 com.smartdigimkt.a0.s), (r6v4 com.smartdigimkt.a0.s), (r6v6 com.smartdigimkt.a0.s), (r6v12 com.smartdigimkt.a0.s) binds: [B:100:0x01b8, B:92:0x0195, B:86:0x0180, B:40:0x009f] A[DONT_GENERATE, DONT_INLINE]] */
    public final void a(int i) {
        com.smartdigimkt.a0.s sVarA;
        com.smartdigimkt.a0.s sVar;
        com.smartdigimkt.a0.s sVar2;
        int i2 = this.b.o;
        String strB = this.j.b();
        com.smartdigimkt.a0.s sVarB = null;
        if (i2 == 1) {
            sVarB = i != 2 ? this.k.b() : null;
            if (sVarB == null || !sVarB.a) {
                sVarA = this.j.a(i, strB);
            } else {
                sVarA = sVarB;
            }
        } else if (i2 == 2 || i2 == 3) {
            sVarA = this.j.a(i, strB);
        } else if (i2 == 4) {
            sVarB = i != 2 ? this.k.b() : null;
            if (sVarB == null || !sVarB.a) {
                sVarA = this.j.a(i, strB);
            } else {
                sVarA = sVarB;
            }
        } else if (i2 == 6) {
            if (i != 2) {
                com.smartdigimkt.a0.t tVar = this.l;
                com.smartdigimkt.a0.e eVar = tVar.f;
                if (eVar != null) {
                    eVar.b();
                    tVar.f.a();
                }
                com.smartdigimkt.b3.c cVar = tVar.c;
                com.smartdigimkt.a3.a aVar = tVar.d;
                if (cVar != null && aVar != null) {
                    com.smartdigimkt.a3.d dVarW = com.smartdigimkt.r4.h.w();
                    boolean z = dVarW.b == 1;
                    boolean z2 = dVarW.a == 1;
                    String strX = com.smartdigimkt.r4.h.x();
                    if (TextUtils.isEmpty(strX)) {
                        com.smartdigimkt.n3.k.c(5, aVar, cVar);
                    } else if (!z) {
                        com.smartdigimkt.n3.k.c(3, aVar, cVar);
                    } else if (!z2) {
                        com.smartdigimkt.n3.k.c(1, aVar, cVar);
                    } else {
                        String str = cVar.A;
                        String str2 = cVar.B;
                        if (TextUtils.isEmpty(str)) {
                            com.smartdigimkt.n3.k.c(4, aVar, cVar);
                        } else {
                            try {
                                Object objB = com.smartdigimkt.r4.h.b(strX);
                                Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
                                Object objNewInstance = cls.newInstance();
                                cls.getField("userName").set(objNewInstance, str);
                                if (!TextUtils.isEmpty(str2)) {
                                    cls.getField("path").set(objNewInstance, str2);
                                }
                                cls.getField("miniprogramType").set(objNewInstance, cls.getField("MINIPTOGRAM_TYPE_RELEASE").get(null));
                                Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("sendReq", Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq")).invoke(objB, objNewInstance);
                                com.smartdigimkt.n3.k.c(0, aVar, cVar);
                                com.smartdigimkt.a0.r rVar = tVar.e;
                                if (rVar != null) {
                                    rVar.a();
                                }
                                com.smartdigimkt.a0.e eVar2 = tVar.f;
                                if (eVar2 != null) {
                                    eVar2.c();
                                }
                                sVar = new com.smartdigimkt.a0.s(true);
                            } catch (Throwable th) {
                                th.getMessage();
                                com.smartdigimkt.n3.k.c(2, aVar, cVar);
                                sVar = new com.smartdigimkt.a0.s(false);
                            }
                        }
                    }
                    sVar = new com.smartdigimkt.a0.s(false);
                } else {
                    sVar = new com.smartdigimkt.a0.s(false);
                }
                sVarB = sVar;
            }
            if (sVarB == null || !sVarB.a) {
                sVarA = this.j.a(i, strB);
            } else {
                sVarA = sVarB;
            }
        } else if (i2 != 7) {
            sVarA = this.j.a(i, strB);
        } else {
            if (i != 2) {
                com.smartdigimkt.a0.n nVar = this.m;
                com.smartdigimkt.b3.c cVar2 = nVar.c;
                String str3 = cVar2 != null ? cVar2.O : "";
                if (TextUtils.isEmpty(str3)) {
                    sVar2 = new com.smartdigimkt.a0.s(false);
                } else {
                    com.smartdigimkt.a0.e eVar3 = nVar.f;
                    if (eVar3 != null) {
                        eVar3.b();
                        nVar.f.a();
                    }
                    int i3 = com.smartdigimkt.c0.h.a(nVar.b, nVar.d, nVar.c, str3).a;
                    if (i3 != 0 && i3 != 5) {
                        com.smartdigimkt.n3.k.a(nVar.d, nVar.c, str3, "0", 3, 0, "");
                        sVar2 = new com.smartdigimkt.a0.s(false);
                    } else {
                        com.smartdigimkt.a0.r rVar2 = nVar.e;
                        if (rVar2 != null) {
                            rVar2.a();
                        }
                        com.smartdigimkt.a0.e eVar4 = nVar.f;
                        if (eVar4 != null) {
                            eVar4.c();
                        }
                        com.smartdigimkt.n3.k.a(nVar.d, nVar.c, str3, "1", 3, 0, "");
                        sVar2 = new com.smartdigimkt.a0.s(true);
                    }
                }
                sVarB = sVar2;
            }
            if (sVarB == null || !sVarB.a) {
                sVarA = this.j.a(i, strB);
            } else {
                sVarA = sVarB;
            }
        }
        com.smartdigimkt.a0.e eVar5 = this.g;
        if (eVar5 != null) {
            eVar5.c();
        }
        if (sVarA.a) {
            return;
        }
        com.smartdigimkt.q3.f.a().a(new y());
    }

    public final void a() {
        com.smartdigimkt.p3.i iVar;
        this.c = true;
        com.smartdigimkt.a0.e eVar = this.g;
        if (eVar != null) {
            eVar.a = null;
            eVar.e.set(false);
            eVar.f = true;
            this.g = null;
        }
        com.smartdigimkt.a0.k kVar = this.i;
        if (kVar == null || (iVar = kVar.h) == null) {
            return;
        }
        iVar.a();
        kVar.h = null;
    }
}
