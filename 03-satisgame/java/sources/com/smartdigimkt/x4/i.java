package com.smartdigimkt.x4;

import com.smartdigimkt.sdk.api.AdError;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements com.smartdigimkt.o4.n {
    public final /* synthetic */ com.smartdigimkt.v4.a a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ com.smartdigimkt.d3.c c;
    public final /* synthetic */ String d;
    public final /* synthetic */ k e;

    public i(k kVar, com.smartdigimkt.v4.a aVar, JSONObject jSONObject, com.smartdigimkt.d3.c cVar, String str) {
        this.e = kVar;
        this.a = aVar;
        this.b = jSONObject;
        this.c = cVar;
        this.d = str;
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
        if (this.a.f.get()) {
            return;
        }
        this.a.a(com.smartdigimkt.z3.b.a("10006", adError != null ? adError.getErrorInfo() : "S2S place strategy request failed."));
        this.e.d(this.a);
    }

    @Override // com.smartdigimkt.o4.n
    public final void b(com.smartdigimkt.p4.e eVar) {
        if (this.a.f.get()) {
            return;
        }
        k kVar = this.e;
        com.smartdigimkt.v4.a aVar = this.a;
        JSONObject jSONObject = this.b;
        com.smartdigimkt.d3.c cVar = this.c;
        String str = this.d;
        kVar.getClass();
        if (k.a(aVar, jSONObject, cVar, str, eVar)) {
            this.e.a(this.a);
        } else {
            this.e.d(this.a);
        }
    }
}
