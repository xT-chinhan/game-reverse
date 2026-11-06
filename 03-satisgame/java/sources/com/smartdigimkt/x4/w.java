package com.smartdigimkt.x4;

import android.text.TextUtils;
import com.smartdigimkt.sdk.api.format.SDMLossInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements com.smartdigimkt.o4.f {
    public final com.smartdigimkt.v4.a a;
    public final /* synthetic */ x b;

    public w(x xVar, com.smartdigimkt.v4.a aVar) {
        this.b = xVar;
        this.a = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:66:0x013e  */
    @Override // com.smartdigimkt.o4.f
    public final void a(List list, JSONObject jSONObject) {
        com.smartdigimkt.p4.e eVarB;
        JSONObject jSONObjectOptJSONObject;
        com.smartdigimkt.d3.c cVar;
        JSONObject jSONObjectOptJSONObject2;
        int iOptInt = (jSONObject == null || (jSONObjectOptJSONObject2 = jSONObject.optJSONObject("placement_strategy")) == null) ? 0 : jSONObjectOptJSONObject2.optInt("error_code", 0);
        if (iOptInt == 40006) {
            x xVar = this.b;
            com.smartdigimkt.v4.a aVar = this.a;
            if (xVar.c.compareAndSet(false, true)) {
                com.smartdigimkt.h3.b bVar = aVar.x;
                if (bVar != null) {
                    boolean zA = bVar.a("bidToken");
                    boolean zA2 = bVar.a("bid");
                    if (zA && !zA2) {
                        bVar.b("bid");
                    }
                }
                com.smartdigimkt.m3.b bVar2 = aVar.l;
                if (bVar2 != null) {
                    com.smartdigimkt.m3.g.a().a(bVar2);
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.smartdigimkt.w4.a aVar2 = aVar.i;
                if (aVar2 != null) {
                    aVar2.c = jCurrentTimeMillis;
                }
                aVar.a(System.currentTimeMillis());
                aVar.z = true;
                aVar.s = jSONObject;
                String str = aVar.e;
                String strValueOf = String.valueOf(aVar.c);
                String str2 = aVar.g;
                int i = aVar.A;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(strValueOf, String.valueOf(66));
                cVar2.a = "3000021";
                if (!TextUtils.isEmpty(str)) {
                    cVar2.c = str;
                }
                if (!TextUtils.isEmpty(str2)) {
                    cVar2.b = str2;
                }
                cVar2.l = String.valueOf(i);
                cVar2.m = String.valueOf(iOptInt);
                cVar2.n = String.valueOf(jCurrentTimeMillis2);
                com.smartdigimkt.n3.k.a(cVar2);
                xVar.a(aVar);
                return;
            }
            return;
        }
        if (!this.b.c.compareAndSet(false, true)) {
            x xVar2 = this.b;
            com.smartdigimkt.v4.a aVar3 = this.a;
            if (!xVar2.d.get() || list == null || list.isEmpty() || (cVar = (com.smartdigimkt.d3.c) list.get(0)) == null || !xVar2.d.compareAndSet(true, false)) {
                return;
            }
            TextUtils.isEmpty(cVar.h);
            com.smartdigimkt.t4.d0.a(cVar, SDMLossInfo.newInternalLossInfo(2), aVar3.v);
            return;
        }
        com.smartdigimkt.v4.a aVar4 = this.a;
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        com.smartdigimkt.w4.a aVar5 = aVar4.i;
        if (aVar5 != null) {
            aVar5.c = jCurrentTimeMillis3;
        }
        this.a.a(System.currentTimeMillis());
        com.smartdigimkt.v4.a aVar6 = this.a;
        aVar6.s = jSONObject;
        this.b.getClass();
        boolean[] zArr = {false};
        String str3 = aVar6.e;
        int i2 = aVar6.c;
        com.smartdigimkt.p4.g gVar = null;
        gVar = null;
        gVar = null;
        gVar = null;
        gVar = null;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("placement_strategy")) == null) {
            eVarB = null;
        } else {
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject.toString());
                jSONObject2.put(com.anythink.core.e.l.a.ac, System.currentTimeMillis());
                eVarB = com.smartdigimkt.p4.e.a(str3, jSONObject2);
                if (eVarB.j != 1 || eVarB.m != i2) {
                    eVarB = null;
                }
            } catch (Throwable unused) {
            }
        }
        if (eVarB == null || eVarB.j != 1 || eVarB.m != i2 || eVarB.a() == null) {
            if (aVar6.A == 2 && (eVarB = com.smartdigimkt.o4.o.a().b(str3)) != null && eVarB.j == 1 && eVarB.m == i2 && eVarB.a() != null) {
                zArr[0] = true;
            } else {
                eVarB = null;
            }
        }
        boolean z = zArr[0];
        if (eVarB == null) {
            x xVar3 = this.b;
            com.smartdigimkt.v4.a aVar7 = this.a;
            xVar3.getClass();
            x.f(aVar7);
            x xVar4 = this.b;
            com.smartdigimkt.v4.a aVar8 = this.a;
            xVar4.getClass();
            com.smartdigimkt.h3.b bVar3 = aVar8.x;
            if (bVar3 != null) {
                bVar3.a("bid");
            }
            this.a.a(com.smartdigimkt.z3.b.a("10006", "Bid response placement strategy is invalid."));
            x xVar5 = this.b;
            com.smartdigimkt.v4.a aVar9 = this.a;
            xVar5.getClass();
            x.a(aVar9, x.a(), -4);
            this.b.d(this.a);
            return;
        }
        if (list == null || list.isEmpty()) {
            x xVar6 = this.b;
            com.smartdigimkt.v4.a aVar10 = this.a;
            xVar6.getClass();
            x.f(aVar10);
            x xVar7 = this.b;
            com.smartdigimkt.v4.a aVar11 = this.a;
            xVar7.getClass();
            com.smartdigimkt.h3.b bVar4 = aVar11.x;
            if (bVar4 != null) {
                bVar4.a("bid");
            }
            this.a.a(com.smartdigimkt.z3.b.a("10008", "Bid response bidding result is empty."));
            x xVar8 = this.b;
            com.smartdigimkt.v4.a aVar12 = this.a;
            xVar8.getClass();
            x.a(aVar12, x.a(), -4);
            this.b.d(this.a);
            return;
        }
        this.b.getClass();
        if (z || jSONObject.optJSONObject("placement_strategy") == null) {
            if (!list.isEmpty()) {
                JSONObject jSONObject3 = eVarB.a;
                com.smartdigimkt.o4.v.a(list, jSONObject3 != null ? jSONObject3.optJSONObject(com.anythink.core.e.l.a.h) : null);
            }
        } else if (!list.isEmpty()) {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("placement_strategy");
            com.smartdigimkt.o4.v.a(list, jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optJSONObject(com.anythink.core.e.l.a.h) : null);
        }
        com.smartdigimkt.d3.c cVar3 = (com.smartdigimkt.d3.c) list.get(0);
        x xVar9 = this.b;
        com.smartdigimkt.v4.a aVar13 = this.a;
        xVar9.getClass();
        if (cVar3 != null && !TextUtils.isEmpty(cVar3.A) && TextUtils.equals(cVar3.A, cVar3.o) && cVar3.p == 66) {
            com.smartdigimkt.p4.g gVarA = eVarB.a();
            if (gVarA == null || TextUtils.isEmpty(gVarA.r) || TextUtils.equals(cVar3.A, gVarA.r)) {
                gVar = new com.smartdigimkt.p4.g(4);
                gVar.b = cVar3.p;
                gVar.r = cVar3.A;
                gVar.n = 1;
                gVar.m = cVar3.c;
                gVar.d = "";
                gVar.e = new HashMap();
                if (gVarA != null) {
                    if (!TextUtils.isEmpty(gVarA.d)) {
                        gVar.d = gVarA.d;
                    }
                    Map map = gVarA.e;
                    if (map != null && !map.isEmpty()) {
                        gVar.e = new HashMap(gVarA.e);
                    }
                    com.smartdigimkt.p4.f fVar = gVarA.f;
                    if (fVar != null) {
                        gVar.f = fVar;
                    }
                }
            } else {
                aVar13.a(com.smartdigimkt.z3.b.a("10008", "Bid response bidding ad source is invalid. strategy=" + gVarA.r + " offer=" + cVar3.A));
            }
        }
        if (gVar == null) {
            x xVar10 = this.b;
            com.smartdigimkt.v4.a aVar14 = this.a;
            xVar10.getClass();
            x.f(aVar14);
            x xVar11 = this.b;
            com.smartdigimkt.v4.a aVar15 = this.a;
            xVar11.getClass();
            com.smartdigimkt.h3.b bVar5 = aVar15.x;
            if (bVar5 != null) {
                bVar5.a("bid");
            }
            com.smartdigimkt.v4.a aVar16 = this.a;
            if (aVar16.t == null) {
                aVar16.a(com.smartdigimkt.z3.b.a("10008", "Bid response bidding ad source is invalid."));
            }
            x xVar12 = this.b;
            com.smartdigimkt.v4.a aVar17 = this.a;
            xVar12.getClass();
            x.a(aVar17, x.a(), -4);
            this.b.d(this.a);
            return;
        }
        gVar.a = cVar3;
        gVar.a(cVar3, 0, cVar3.a ? 1 : 0);
        if (!cVar3.a) {
            com.smartdigimkt.t4.d0.a(cVar3, SDMLossInfo.newInternalLossInfo(3), this.a.v);
        }
        com.smartdigimkt.v4.a aVar18 = this.a;
        aVar18.n = eVarB;
        aVar18.o = gVar;
        aVar18.r = cVar3;
        com.smartdigimkt.a3.a aVarA = com.smartdigimkt.a3.a.a(aVar18.g, eVarB, gVar);
        aVar18.p = aVarA;
        aVarA.z = aVar18.x;
        if (!z) {
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("placement_strategy");
            if (jSONObjectOptJSONObject4 != null) {
                try {
                    JSONObject jSONObject4 = new JSONObject(jSONObjectOptJSONObject4.toString());
                    jSONObject4.put(com.anythink.core.e.l.a.ac, System.currentTimeMillis());
                    jSONObjectOptJSONObject4 = jSONObject4;
                } catch (Throwable unused2) {
                    jSONObjectOptJSONObject4 = jSONObject.optJSONObject("placement_strategy");
                }
            }
            com.smartdigimkt.o4.o.a().a(this.a.e, eVarB, jSONObjectOptJSONObject4);
        }
        com.smartdigimkt.r4.b0.a(this.a.v, eVarB);
        com.smartdigimkt.v4.a aVar19 = this.a;
        aVar19.y = true;
        com.smartdigimkt.h3.b bVar6 = aVar19.x;
        if (bVar6 != null) {
            synchronized (bVar6) {
            }
        }
        x xVar13 = this.b;
        com.smartdigimkt.v4.a aVar20 = this.a;
        xVar13.getClass();
        com.smartdigimkt.h3.b bVar7 = aVar20.x;
        if (bVar7 != null) {
            bVar7.a("bid");
        }
        x xVar14 = this.b;
        com.smartdigimkt.v4.a aVar21 = this.a;
        xVar14.getClass();
        x.f(aVar21);
        long j = eVarB.k;
        if (j <= 0) {
            j = 60000;
        }
        com.smartdigimkt.w4.a aVar22 = aVar21.i;
        long j2 = aVar22 != null ? aVar22.c - (aVar22 != null ? aVar22.a : 0L) : 0L;
        if (j2 <= 0) {
            j2 = 0;
        }
        long j3 = j - j2;
        if (j3 <= 0) {
            xVar14.g(aVar21);
        } else {
            u uVar = new u(xVar14, aVar21);
            aVar21.l = uVar;
            com.smartdigimkt.m3.g.a().a.a(uVar, j3);
        }
        com.smartdigimkt.v4.a aVar23 = this.a;
        String str4 = aVar23.e;
        this.b.getClass();
        x.a(aVar23, gVar, 0);
        this.b.a(this.a);
    }

    @Override // com.smartdigimkt.o4.f
    public final void a(List list) {
        x.a(this.b, this.a, com.smartdigimkt.z3.b.a("10008", "Bid response does not include result data."), -4);
    }

    @Override // com.smartdigimkt.o4.f
    public final void a(com.smartdigimkt.z3.a aVar) {
        x.a(this.b, this.a, aVar, -4);
    }
}
