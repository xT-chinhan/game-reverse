package com.mcto.sspsdk.internal;

import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class sa extends ra {
    public sa() {
    }

    @Override // com.mcto.sspsdk.internal.ra
    public final wa a() {
        this.b = "com.qiyi.video.lite";
        wa waVarA = super.a();
        if (waVarA != null) {
            return waVarA;
        }
        wa waVar = new wa();
        Collections.addAll(waVar.a, "qc_105312_101329");
        waVar.b = "iqiyilite://mobile/register_business/qyvideolite";
        waVar.c = "2010";
        waVar.d = "1";
        waVar.e = "com.qiyi.video.lite";
        return waVar;
    }

    @Override // com.mcto.sspsdk.internal.ra
    public final String b(String str, String str2) {
        return "";
    }

    public sa(wa waVar) {
        super(waVar);
    }

    @Override // com.mcto.sspsdk.internal.ra
    public final String a(String str, String str2) {
        return "tvId=" + str + "&albumId=" + str2;
    }
}
