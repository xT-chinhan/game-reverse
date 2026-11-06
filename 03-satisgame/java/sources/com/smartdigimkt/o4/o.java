package com.smartdigimkt.o4;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static volatile o c;
    public final u a = new u(SDKContext.getInstance().d());
    public final s b = new s();

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(com.smartdigimkt.y3.b bVar) {
        if (bVar == null) {
            return;
        }
        String str = bVar.a;
        try {
            com.smartdigimkt.p4.e eVar = bVar.b;
            com.smartdigimkt.g4.l lVar = new com.smartdigimkt.g4.l(str);
            lVar.a = bVar.d;
            lVar.b = "strategy";
            q qVar = new q(this, bVar);
            if (eVar == null) {
                this.b.a(lVar, qVar);
                return;
            }
            if (eVar.b()) {
                this.b.a(lVar, qVar);
                return;
            }
            if (System.currentTimeMillis() - eVar.v <= eVar.f) {
                qVar.b(eVar);
                return;
            }
            long j = eVar.h;
            if (j <= 0) {
                qVar.b(eVar);
            } else {
                com.smartdigimkt.m3.f fVar = com.smartdigimkt.m3.g.a().a;
                qVar.d = fVar;
                if (fVar != null) {
                    p pVar = new p(qVar, eVar);
                    qVar.g = pVar;
                    fVar.a(pVar, j);
                }
            }
            this.b.a(lVar, qVar);
        } catch (Throwable unused) {
        }
    }

    public final com.smartdigimkt.p4.e b(String str) {
        String strA = SDKContext.getInstance().a();
        u uVar = this.a;
        uVar.getClass();
        String str2 = strA + str;
        ConcurrentHashMap concurrentHashMap = uVar.b;
        com.smartdigimkt.p4.e eVar = (com.smartdigimkt.p4.e) concurrentHashMap.get(str2);
        if (eVar != null) {
            return eVar;
        }
        String strC = y.c(uVar.a, "sdm_adx_rp_sdk", str2 + "_PL_SY");
        if (!TextUtils.isEmpty(strC)) {
            try {
                com.smartdigimkt.p4.e eVarA = com.smartdigimkt.p4.e.a(str, new JSONObject(strC));
                concurrentHashMap.put(str2, eVarA);
                return eVarA;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static o a() {
        if (c == null) {
            synchronized (o.class) {
                if (c == null) {
                    c = new o();
                }
            }
        }
        return c;
    }

    public final void a(String str, com.smartdigimkt.p4.e eVar, JSONObject jSONObject) {
        String strA = SDKContext.getInstance().a();
        u uVar = this.a;
        if (uVar.a == null || TextUtils.isEmpty(strA) || TextUtils.isEmpty(str)) {
            return;
        }
        String strA2 = com.smartdigimkt.p.a.a(strA, str);
        uVar.b.put(strA2, eVar);
        boolean z = eVar.i == 1;
        boolean z2 = eVar.l == 1;
        if (!z || jSONObject == null || z2) {
            return;
        }
        com.smartdigimkt.q3.f.a().c(new t(uVar, jSONObject, strA2));
    }

    public final com.smartdigimkt.p4.e a(String str) {
        return b(str);
    }

    public final void a(String str, com.smartdigimkt.p4.e eVar) {
        if (eVar == null) {
            return;
        }
        u uVar = this.a;
        String strA = SDKContext.getInstance().a();
        uVar.getClass();
        String strA2 = com.smartdigimkt.p.a.a(strA, str);
        uVar.b.remove(strA2);
        Context context = uVar.a;
        String strA3 = com.smartdigimkt.p.a.a(strA2, "_PL_SY");
        if (context == null) {
            return;
        }
        try {
            com.smartdigimkt.k4.c.a().a(context, "sdm_adx_rp_sdk").remove(strA3);
        } catch (Throwable unused) {
        }
    }
}
