package com.smartdigimkt.o4;

import com.smartdigimkt.sdk.api.AdError;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements com.smartdigimkt.a4.b, n {
    public final o a;
    public final com.smartdigimkt.y3.b b;
    public final n c;
    public com.smartdigimkt.m3.f d;
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final AtomicBoolean f = new AtomicBoolean(false);
    public p g;

    public q(o oVar, com.smartdigimkt.y3.b bVar) {
        this.a = oVar;
        this.b = bVar;
        this.c = bVar != null ? bVar.c : null;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i) {
        a();
    }

    @Override // com.smartdigimkt.o4.n
    public final void b() {
        n nVar = this.c;
        if (nVar != null) {
            nVar.b();
        }
    }

    @Override // com.smartdigimkt.o4.n
    public final void a() {
        n nVar = this.c;
        if (nVar != null) {
            nVar.a();
        }
    }

    @Override // com.smartdigimkt.o4.n
    public final void b(com.smartdigimkt.p4.e eVar) {
        n nVar;
        if (this.f.getAndSet(true) || (nVar = this.c) == null) {
            return;
        }
        nVar.b(eVar);
    }

    @Override // com.smartdigimkt.o4.n
    public final void a(AdError adError) {
        n nVar;
        if (this.f.getAndSet(true) || (nVar = this.c) == null) {
            return;
        }
        nVar.a(adError);
    }

    @Override // com.smartdigimkt.o4.n
    public final void a(com.smartdigimkt.p4.e eVar) {
        n nVar = this.c;
        if (nVar != null) {
            nVar.a(eVar);
        }
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, String str, AdError adError) {
        String str2;
        com.smartdigimkt.p4.e eVar;
        p pVar;
        com.smartdigimkt.m3.f fVar = this.d;
        if (fVar != null && (pVar = this.g) != null) {
            fVar.a(pVar);
        }
        com.smartdigimkt.y3.b bVar = this.b;
        if (bVar != null) {
            try {
                str2 = bVar.a;
                eVar = bVar.b;
            } catch (Throwable th) {
                a(com.smartdigimkt.z3.b.a(com.anythink.core.common.inner.b.b.i, th + ""));
                return;
            }
        } else {
            eVar = null;
            str2 = "";
        }
        if (String.valueOf(com.anythink.core.common.l.b.d).equals(adError.getCode())) {
            this.a.a(str2, eVar);
            a(adError);
            return;
        }
        if (eVar != null && !eVar.b()) {
            b(eVar);
            return;
        }
        a(adError);
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, Object obj) {
        p pVar;
        com.smartdigimkt.m3.f fVar = this.d;
        if (fVar != null && (pVar = this.g) != null) {
            fVar.a(pVar);
        }
        b();
        com.smartdigimkt.y3.b bVar = this.b;
        boolean z = this.e.get();
        if (bVar == null || obj == null) {
            return;
        }
        String str = bVar.a;
        com.smartdigimkt.p4.e eVar = bVar.b;
        try {
            JSONObject jSONObject = (JSONObject) obj;
            jSONObject.put(com.anythink.core.e.l.a.ac, System.currentTimeMillis());
            jSONObject.optInt(com.anythink.core.e.l.a.av, 0);
            com.smartdigimkt.p4.e eVarA = com.smartdigimkt.p4.e.a(str, jSONObject);
            this.a.a(str, eVarA, jSONObject);
            if (z) {
                a(eVarA);
            } else {
                b(eVarA);
            }
        } catch (Throwable th) {
            if (eVar != null && !eVar.b()) {
                b(eVar);
            } else {
                a(com.smartdigimkt.z3.b.a(com.anythink.core.common.inner.b.b.i, th + ""));
            }
        }
    }
}
