package com.smartdigimkt.f1;

import android.content.Context;
import com.smartdigimkt.e1.e;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.z.e0;
import com.smartdigimkt.z2.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.smartdigimkt.a4.b {
    public final /* synthetic */ com.smartdigimkt.a3.a a;
    public final /* synthetic */ com.smartdigimkt.e1.c b;
    public final /* synthetic */ e c;
    public final /* synthetic */ d d;

    public b(d dVar, com.smartdigimkt.a3.a aVar, com.smartdigimkt.e1.c cVar, e eVar) {
        this.d = dVar;
        this.a = aVar;
        this.b = cVar;
        this.c = eVar;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i) {
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, Object obj) {
        com.smartdigimkt.b3.b bVarA;
        try {
            d dVar = this.d;
            com.smartdigimkt.a3.a aVar = this.a;
            dVar.getClass();
            bVarA = d.a(aVar, (JSONObject) obj, "", false);
        } catch (Exception unused) {
            bVarA = null;
        }
        if (bVarA == null) {
            this.d.b(this.a);
            com.smartdigimkt.e1.c cVar = this.b;
            if (cVar != null) {
                cVar.a(null, new g(com.anythink.core.common.inner.b.b.i, obj != null ? obj.toString() : "No Ad Return."));
                return;
            }
            return;
        }
        com.smartdigimkt.a3.a aVar2 = this.a;
        bVarA.g0 = aVar2.o;
        if (this.d.a(bVarA, aVar2, this.b)) {
            return;
        }
        this.d.a(bVarA, this.a);
        com.smartdigimkt.t2.e eVarA = com.smartdigimkt.t2.e.a();
        Context context = this.d.a;
        com.smartdigimkt.a3.a aVar3 = this.a;
        String str = aVar3.b;
        String str2 = aVar3.f;
        String str3 = aVar3.j;
        String string = obj.toString();
        if (eVarA.a == null) {
            eVarA.a = q.a(com.smartdigimkt.z2.d.a(context.getApplicationContext()));
        }
        f.a().c(new com.smartdigimkt.t2.b(eVarA, str, str2, str3, string));
        com.smartdigimkt.e1.c cVar2 = this.b;
        if (cVar2 != null) {
            cVar2.a(bVarA);
        }
        d dVar2 = this.d;
        com.smartdigimkt.a3.a aVar4 = this.a;
        e eVar = this.c;
        com.smartdigimkt.e1.c cVar3 = this.b;
        dVar2.getClass();
        com.smartdigimkt.i1.a.a(aVar4, bVarA, eVar);
        e0 e0VarA = e0.a();
        String str4 = aVar4.b;
        c cVar4 = new c(dVar2, aVar4, cVar3, bVarA);
        e0VarA.getClass();
        e0.a(str4, false, bVarA, aVar4, cVar4);
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, String str, AdError adError) {
        this.d.b(this.a);
        com.smartdigimkt.e1.c cVar = this.b;
        if (cVar != null) {
            cVar.a(null, new g(com.anythink.core.common.inner.b.b.i, str));
        }
    }
}
