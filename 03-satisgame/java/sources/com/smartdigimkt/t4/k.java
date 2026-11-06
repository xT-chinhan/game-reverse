package com.smartdigimkt.t4;

import com.smartdigimkt.sdk.api.format.SDMAdPlaceInfo;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements SDMAdPlaceInfo {
    public final com.smartdigimkt.a3.a a;

    public k(com.smartdigimkt.e1.d dVar) {
        this.a = dVar != null ? dVar.c : null;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdPlaceInfo
    public final int getFormat() {
        com.smartdigimkt.a3.a aVar = this.a;
        if (aVar != null) {
            return aVar.c;
        }
        return 0;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdPlaceInfo
    public final String getPlacementId() {
        com.smartdigimkt.a3.a aVar = this.a;
        return aVar != null ? aVar.b : "";
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdPlaceInfo
    public final String getRequestId() {
        com.smartdigimkt.a3.a aVar = this.a;
        return aVar != null ? aVar.g : "";
    }

    public final String toString() {
        return "SDMAdPlaceInfo{placementId=" + getPlacementId() + ", requestId=" + getRequestId() + ", format=" + getFormat() + AbstractJsonLexerKt.END_OBJ;
    }
}
