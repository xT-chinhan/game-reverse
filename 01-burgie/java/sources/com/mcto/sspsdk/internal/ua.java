package com.mcto.sspsdk.internal;

import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class ua extends ra {
    public ua() {
    }

    @Override // com.mcto.sspsdk.internal.ra
    public final wa a() {
        this.b = "tv.pps.mobile";
        wa waVarA = super.a();
        if (waVarA != null) {
            return waVarA;
        }
        wa waVar = new wa();
        Collections.addAll(waVar.a, "qc_100001_100134");
        waVar.b = "iqiyipps://tv.pps.mobile/register_business/qyclient";
        waVar.c = "102";
        waVar.d = "101";
        waVar.e = "tv.pps.mobile";
        return waVar;
    }

    public ua(wa waVar) {
        super(waVar);
    }
}
