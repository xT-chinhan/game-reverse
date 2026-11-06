package com.smartdigimkt.k1;

import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.smartdigimkt.d0.p {
    public final /* synthetic */ com.smartdigimkt.j1.f a;
    public final /* synthetic */ d b;

    public b(d dVar, com.smartdigimkt.x4.l lVar) {
        this.b = dVar;
        this.a = lVar;
    }

    @Override // com.smartdigimkt.d0.p
    public final void a() {
        com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
        if (bVarE != null && bVarE.a()) {
            d dVar = this.b;
            bVarE.fillDataFetchStatus(dVar.a, dVar.e, dVar.b);
        }
        com.smartdigimkt.j1.f fVar = this.a;
        if (fVar != null) {
            fVar.b();
        }
    }

    @Override // com.smartdigimkt.d0.p
    public final void a(com.smartdigimkt.h0.g gVar) {
        com.smartdigimkt.j1.f fVar = this.a;
        if (fVar != null) {
            fVar.a(gVar);
        }
    }
}
