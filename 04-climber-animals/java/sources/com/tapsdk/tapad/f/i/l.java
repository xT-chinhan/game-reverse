package com.tapsdk.tapad.f.i;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class l {
    public static String c = "";
    com.tapsdk.tapad.f.b a;
    m b;

    public l(Context context) {
        m mVar = new m(context);
        this.b = mVar;
        String strE = mVar.e();
        c = strE;
        if (TextUtils.isEmpty(strE)) {
            a(context);
        }
    }

    private com.tapsdk.tapad.f.b a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        com.tapsdk.tapad.f.b bVar = this.a;
        if (bVar != null) {
            return bVar;
        }
        com.tapsdk.tapad.f.b bVarD = d(context);
        this.a = bVarD;
        try {
            bVarD.a();
            com.tapsdk.tapad.f.d.a("Manufacturer interface has been found: " + this.a.l());
            return this.a;
        } catch (Exception e) {
            String str = this.a != null ? e.getMessage() + ":" + this.a.l() : "Manufacturer interface has not been found";
            com.tapsdk.tapad.f.d.a(str);
            this.b.b(str);
            com.tapsdk.tapad.f.b bVarE = e(context);
            this.a = bVarE;
            return bVarE;
        }
    }

    private com.tapsdk.tapad.f.b b(Context context) {
        e eVar = new e(context);
        this.a = eVar;
        try {
            eVar.a();
            com.tapsdk.tapad.f.d.a("Google Play Service has been found: " + this.a.l());
            return this.a;
        } catch (Exception unused) {
            com.tapsdk.tapad.f.d.a("Google Play Service has not been found: " + this.a.l());
            return null;
        }
    }

    private com.tapsdk.tapad.f.b c(Context context) {
        j jVar = new j(context);
        try {
            jVar.a();
            com.tapsdk.tapad.f.d.a("Mobile Security Alliance has been found: " + jVar.l());
            return jVar;
        } catch (Exception unused) {
            com.tapsdk.tapad.f.d.a("Mobile Security Alliance has not been found: " + jVar.l());
            return null;
        }
    }

    private com.tapsdk.tapad.f.b d(Context context) {
        if (com.tapsdk.tapad.f.e.i() || com.tapsdk.tapad.f.e.l()) {
            return new h(context);
        }
        if (com.tapsdk.tapad.f.e.j()) {
            return new i(context);
        }
        if (com.tapsdk.tapad.f.e.m()) {
            return new k(context);
        }
        if (com.tapsdk.tapad.f.e.s() || com.tapsdk.tapad.f.e.k() || com.tapsdk.tapad.f.e.c()) {
            return new s(context);
        }
        if (com.tapsdk.tapad.f.e.q()) {
            return new q(context);
        }
        if (com.tapsdk.tapad.f.e.r()) {
            return new r(context);
        }
        if (com.tapsdk.tapad.f.e.b()) {
            return new a(context);
        }
        if (com.tapsdk.tapad.f.e.g()) {
            f fVar = new f(context);
            try {
                fVar.a();
                return fVar;
            } catch (Exception unused) {
            }
        }
        if (com.tapsdk.tapad.f.e.h() || com.tapsdk.tapad.f.e.e()) {
            return new g(context);
        }
        if (com.tapsdk.tapad.f.e.o() || com.tapsdk.tapad.f.e.n()) {
            o oVar = new o(context);
            try {
                oVar.a();
                return oVar;
            } catch (Exception unused2) {
                return new n(context);
            }
        }
        if (com.tapsdk.tapad.f.e.a(context)) {
            return new b(context);
        }
        if (com.tapsdk.tapad.f.e.d()) {
            return new c(context);
        }
        if (com.tapsdk.tapad.f.e.f()) {
            return new d(context);
        }
        if (com.tapsdk.tapad.f.e.a()) {
            return new p(context);
        }
        return null;
    }

    private com.tapsdk.tapad.f.b e(Context context) {
        com.tapsdk.tapad.f.b bVarC = c(context);
        if (bVarC != null) {
            return bVarC;
        }
        com.tapsdk.tapad.f.b bVarB = b(context);
        if (bVarB != null) {
            return bVarB;
        }
        com.tapsdk.tapad.f.d.a("OAID/AAID was not supported on UniversalImp");
        return null;
    }

    public com.tapsdk.tapad.f.b a() {
        return this.a;
    }

    public void a(Exception exc) {
        com.tapsdk.tapad.f.d.a(exc.getMessage());
        this.b.a(exc.getMessage());
    }

    public void a(String str) {
        c = str;
        com.tapsdk.tapad.f.d.a("OAID query success: " + str);
        this.b.c(str);
    }

    public String b() {
        return c;
    }
}
