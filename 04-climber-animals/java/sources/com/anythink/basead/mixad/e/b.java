package com.anythink.basead.mixad.e;

import com.anythink.core.common.h.n;
import com.anythink.core.common.h.x;
import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class b extends x implements Serializable {
    public b(com.anythink.core.common.l.g.a aVar, n nVar, int i) {
        this.a = nVar.x();
        this.b = nVar.aI();
        this.c = nVar.M();
        this.d = nVar.aJ();
        this.f = nVar.Y();
        this.g = nVar.aF();
        this.h = nVar.aG();
        this.i = nVar.Z();
        this.j = i;
        this.k = -1;
        this.l = nVar.o();
        this.o = new c(aVar);
    }

    public final String toString() {
        return "ThirdPartyAdRequestInfo{bidId='" + this.a + "', placementId='" + this.b + "', adsourceId='" + this.c + "', requestId='" + this.d + "', requestAdNum=" + this.e + ", networkFirmId=" + this.f + ", networkName='" + this.g + "', trafficGroupId=" + this.h + ", groupId=" + this.i + ", format=" + this.j + ", tpBidId='" + this.l + "', requestUrl='" + this.m + "', bidResultOutDateTime=" + this.n + ", baseAdSetting=" + this.o + ", isTemplate=" + this.p + ", isGetMainImageSizeSwitch=" + this.q + AbstractJsonLexerKt.END_OBJ;
    }
}
