package com.mcto.sspsdk.internal;

import com.mcto.unionsdk.QiClient;
import com.mcto.unionsdk.QiNativeAd;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class qg implements QiClient.NativeAdListener {
    public final /* synthetic */ long a;
    public final /* synthetic */ rg b;

    public qg(rg rgVar, long j) {
        this.b = rgVar;
        this.a = j;
    }

    public final void onError(int i, String str) {
        this.b.a(false);
        r9.a("ssp_reward", "loadTemplateAd(): error, adId:" + this.b.a.a + ";" + gj.a(str, this.b.a.g, i), null);
        za zaVarD = za.d();
        p pVar = this.b.a;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.a;
        zaVarD.getClass();
        za.a(pVar, jCurrentTimeMillis, str, i, false);
    }

    public final void onNativeAdLoad(List list) {
        r9.a("ssp_reward", "loadTemplateAd(): success. adId: " + this.b.a.a, null);
        if (list == null || list.isEmpty()) {
            return;
        }
        this.b.b = (QiNativeAd) list.get(0);
        this.b.a(true);
        za zaVarD = za.d();
        p pVar = this.b.a;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.a;
        zaVarD.getClass();
        za.a(pVar, jCurrentTimeMillis, "", 0, true);
    }
}
