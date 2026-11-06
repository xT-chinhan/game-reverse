package com.mcto.sspsdk.internal;

import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class ta extends ra {
    public ta(wa waVar) {
        super(waVar);
    }

    @Override // com.mcto.sspsdk.internal.ra
    public final wa a() {
        this.b = "com.qiyi.video";
        wa waVarA = super.a();
        if (waVarA != null) {
            return waVarA;
        }
        wa waVar = new wa();
        Collections.addAll(waVar.a, "qc_100001_100086");
        waVar.b = "iqiyi://mobile/register_business/qyclient";
        waVar.c = "102";
        waVar.d = "101";
        waVar.e = "com.qiyi.video";
        return waVar;
    }

    public ta() {
    }
}
