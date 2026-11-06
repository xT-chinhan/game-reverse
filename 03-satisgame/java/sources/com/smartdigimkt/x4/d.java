package com.smartdigimkt.x4;

import com.smartdigimkt.sdk.api.format.SDMLossInfo;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.smartdigimkt.o4.f {
    public final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

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
    @Override // com.smartdigimkt.o4.f
    public final void a(List list) {
        com.smartdigimkt.d3.c cVar;
        this.a.a.a(System.currentTimeMillis());
        com.smartdigimkt.m3.g.a().a(this.a.g.f);
        if (!this.a.g.d.compareAndSet(false, true)) {
            e eVar = this.a;
            h hVar = eVar.g;
            com.smartdigimkt.v4.a aVar = eVar.a;
            if (!hVar.e.get() || list == null || list.isEmpty() || (cVar = (com.smartdigimkt.d3.c) list.get(0)) == null || !hVar.e.compareAndSet(true, false)) {
                return;
            }
            com.smartdigimkt.t4.d0.a(cVar, SDMLossInfo.newInternalLossInfo(2), aVar.v);
            return;
        }
        com.smartdigimkt.h3.b bVar = this.a.c;
        if (bVar != null) {
            bVar.a("bid");
        }
        if (list != null && !list.isEmpty()) {
            e eVar2 = this.a;
            com.smartdigimkt.p4.e eVar3 = eVar2.f;
            JSONObject jSONObject = eVar2.a.s;
            if (!list.isEmpty()) {
                if (jSONObject != null) {
                    if (!list.isEmpty()) {
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("placement_strategy");
                        com.smartdigimkt.o4.v.a(list, jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject(com.anythink.core.e.l.a.h) : null);
                    }
                } else if (eVar3 != null && !list.isEmpty()) {
                    JSONObject jSONObject2 = eVar3.a;
                    com.smartdigimkt.o4.v.a(list, jSONObject2 != null ? jSONObject2.optJSONObject(com.anythink.core.e.l.a.h) : null);
                }
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("m_t", 60000L);
                    com.smartdigimkt.o4.v.a(list, jSONObject3);
                } catch (Throwable unused) {
                }
            }
            e eVar4 = this.a;
            String str = eVar4.g.c;
            String str2 = eVar4.a.e;
            com.smartdigimkt.d3.c cVar2 = (com.smartdigimkt.d3.c) list.get(0);
            e eVar5 = this.a;
            eVar5.a.r = cVar2;
            com.smartdigimkt.p4.g gVar = eVar5.b;
            gVar.a = cVar2;
            boolean z = cVar2.a;
            gVar.a(cVar2, z ? 0 : -1, z ? 1 : 0);
            e eVar6 = this.a;
            com.smartdigimkt.a3.a aVarA = com.smartdigimkt.a3.a.a(eVar6.e, eVar6.f, eVar6.b);
            e eVar7 = this.a;
            com.smartdigimkt.v4.a aVar2 = eVar7.a;
            aVar2.p = aVarA;
            aVarA.z = aVar2.x;
            h hVar2 = eVar7.g;
            com.smartdigimkt.p4.g gVar2 = eVar7.b;
            hVar2.getClass();
            if (aVar2 != null) {
                com.smartdigimkt.q3.f.a().c(new f(hVar2, aVar2, gVar2));
            }
            if (!cVar2.a) {
                com.smartdigimkt.t4.d0.a(cVar2, SDMLossInfo.newInternalLossInfo(3), this.a.a.v);
            }
        }
        e eVar8 = this.a;
        h hVar3 = eVar8.g;
        com.smartdigimkt.v4.a aVar3 = eVar8.a;
        hVar3.getClass();
        h.a("success", aVar3);
        e eVar9 = this.a;
        eVar9.g.a(eVar9.a);
    }

    @Override // com.smartdigimkt.o4.f
    public final void a(com.smartdigimkt.z3.a aVar) {
        this.a.a.a(System.currentTimeMillis());
        com.smartdigimkt.m3.g.a().a(this.a.g.f);
        if (this.a.g.d.compareAndSet(false, true)) {
            com.smartdigimkt.h3.b bVar = this.a.c;
            if (bVar != null) {
                bVar.a("bid");
            }
            this.a.a.a(aVar);
            e eVar = this.a;
            h hVar = eVar.g;
            com.smartdigimkt.v4.a aVar2 = eVar.a;
            hVar.getClass();
            h.a("fail", aVar2);
            e eVar2 = this.a;
            eVar2.g.a(eVar2.a, eVar2.b, -4);
            e eVar3 = this.a;
            eVar3.g.a(eVar3.a);
        }
    }
}
