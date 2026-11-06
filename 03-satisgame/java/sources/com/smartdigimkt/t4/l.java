package com.smartdigimkt.t4;

import com.smartdigimkt.sdk.api.format.SDMAd;
import com.smartdigimkt.sdk.api.format.SDMAdEcpmInfo;
import com.smartdigimkt.sdk.api.format.SDMAdPlaceInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements SDMAd {
    public final com.smartdigimkt.e1.d a;

    public l(com.smartdigimkt.e1.d dVar) {
        this.a = dVar;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAd
    public final SDMAdEcpmInfo getEcpmInfo() {
        return new j(this.a);
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAd
    public final Map getExtraInfo() {
        com.smartdigimkt.e1.d dVar = this.a;
        if (dVar == null) {
            return null;
        }
        HashMap mapA = com.smartdigimkt.z.f.a(dVar.e);
        if (mapA == null) {
            mapA = new HashMap();
        }
        com.smartdigimkt.b3.b bVar = dVar.e;
        if (bVar == null || bVar.h0.isEmpty()) {
            return mapA;
        }
        mapA.putAll(bVar.h0);
        return mapA;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAd
    public final SDMAdPlaceInfo getPlaceInfo() {
        return new k(this.a);
    }
}
