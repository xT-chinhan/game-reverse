package com.smartdigimkt.f1;

import android.text.TextUtils;
import com.smartdigimkt.e1.e;
import com.smartdigimkt.z.e0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ com.smartdigimkt.a3.a a;
    public final /* synthetic */ com.smartdigimkt.d3.c b;
    public final /* synthetic */ e c;
    public final /* synthetic */ com.smartdigimkt.e1.c d;
    public final /* synthetic */ d e;

    public a(d dVar, com.smartdigimkt.a3.a aVar, com.smartdigimkt.d3.c cVar, e eVar, com.smartdigimkt.e1.c cVar2) {
        this.e = dVar;
        this.a = aVar;
        this.b = cVar;
        this.c = eVar;
        this.d = cVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.b3.b bVarA;
        d dVar = this.e;
        com.smartdigimkt.a3.a aVar = this.a;
        com.smartdigimkt.d3.c cVar = this.b;
        e eVar = this.c;
        com.smartdigimkt.e1.c cVar2 = this.d;
        dVar.getClass();
        com.smartdigimkt.b3.b bVarA2 = null;
        if (cVar != null) {
            try {
                if (TextUtils.isEmpty(cVar.y)) {
                    bVarA = null;
                } else {
                    JSONObject jSONObject = cVar.R;
                    if (jSONObject == null) {
                        jSONObject = new JSONObject(cVar.y);
                    }
                    bVarA = d.a(aVar, jSONObject, cVar.y, true);
                    try {
                        bVarA.g0 = aVar.o;
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable unused2) {
            }
            if (bVarA != null) {
                try {
                    dVar.a(bVarA, aVar);
                } catch (Throwable unused3) {
                }
            }
            bVarA2 = bVarA;
        }
        if (bVarA2 == null) {
            try {
                bVarA2 = dVar.a(aVar);
            } catch (Throwable unused4) {
            }
        }
        if (bVarA2 == null) {
            new com.smartdigimkt.f4.c(aVar).a(0, (com.smartdigimkt.a4.b) new b(dVar, aVar, cVar2, eVar));
            return;
        }
        if (dVar.a(bVarA2, aVar, cVar2)) {
            return;
        }
        if (cVar2 != null) {
            cVar2.a(bVarA2);
        }
        com.smartdigimkt.i1.a.a(aVar, bVarA2, eVar);
        e0 e0VarA = e0.a();
        String str = aVar.b;
        c cVar3 = new c(dVar, aVar, cVar2, bVarA2);
        e0VarA.getClass();
        e0.a(str, false, bVarA2, aVar, cVar3);
    }
}
