package com.smartdigimkt.t4;

import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.format.SDMAdEcpmInfo;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements SDMAdEcpmInfo {
    public final com.smartdigimkt.d3.c a;

    public j(com.smartdigimkt.e1.d dVar) {
        this.a = dVar != null ? dVar.k : null;
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdEcpmInfo
    public final double getEcpm(SDMAdConst.CURRENCY currency) {
        com.smartdigimkt.d3.c cVar;
        if (currency == null || (cVar = this.a) == null) {
            return 0.0d;
        }
        return com.smartdigimkt.r4.n.a(cVar.c, SDMAdConst.CURRENCY.USD, currency);
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdEcpmInfo
    public final int getSecretId() {
        com.smartdigimkt.d3.c cVar = this.a;
        if (cVar != null) {
            return cVar.J;
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SDMAdEcpmInfo{ecpm(USD)=");
        SDMAdConst.CURRENCY currency = SDMAdConst.CURRENCY.USD;
        StringBuilder sbAppend = sb.append(getEcpm(currency)).append(", ecpmEncInfo(USD)=").append(getEncEcpmInfo(currency)).append(", ecpm(RMB)=");
        SDMAdConst.CURRENCY currency2 = SDMAdConst.CURRENCY.RMB;
        return sbAppend.append(getEcpm(currency2)).append(", ecpmEncInfo(RMB)=").append(getEncEcpmInfo(currency2)).append(", secretId=").append(getSecretId()).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    @Override // com.smartdigimkt.sdk.api.format.SDMAdEcpmInfo
    public final String getEncEcpmInfo(SDMAdConst.CURRENCY currency) {
        String str;
        com.smartdigimkt.d3.c cVar = this.a;
        if (cVar == null) {
            str = "";
        } else if (currency == SDMAdConst.CURRENCY.USD) {
            str = cVar.I;
        } else {
            str = currency == SDMAdConst.CURRENCY.RMB ? cVar.K : "The currency(" + currency + ") is not supported.";
        }
        return str != null ? str : "";
    }
}
