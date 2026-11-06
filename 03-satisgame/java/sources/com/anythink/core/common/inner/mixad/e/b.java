package com.anythink.core.common.inner.mixad.e;

import com.anythink.core.common.h.n;
import com.anythink.core.common.h.x;
import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class b extends x implements Serializable {
    public b(com.anythink.core.common.k.g.a aVar, n nVar, int i) {
        this.i = nVar.y();
        this.a = nVar.aQ();
        this.e = nVar.N();
        this.f = nVar.aR();
        this.j = nVar.Z();
        this.k = nVar.aN();
        this.c = nVar.aO();
        this.d = nVar.aa();
        this.b = i;
        this.n = -1;
        this.l = nVar.p();
        this.t = new c(aVar);
        this.t.r(i);
    }

    public final String toString() {
        return "ThirdPartyAdRequestInfo{bidId='" + this.i + "', placementId='" + this.a + "', adsourceId='" + this.e + "', requestId='" + this.f + "', networkFirmId=" + this.j + ", networkName='" + this.k + "', trafficGroupId=" + this.c + ", groupId=" + this.d + ", format=" + this.b + ", tpBidId='" + this.l + "', requestUrl='" + this.q + "', bidResultOutDateTime=" + this.p + ", baseAdSetting=" + this.t + AbstractJsonLexerKt.END_OBJ;
    }
}
