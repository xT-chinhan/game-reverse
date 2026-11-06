package com.mcto.sspsdk.internal;

import com.mcto.unionsdk.QiClient;
import com.mcto.unionsdk.QiNativeAd;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a2 implements QiClient.NativeAdListener {
    public final /* synthetic */ p a;
    public final /* synthetic */ long b;
    public final /* synthetic */ b2 c;

    public a2(b2 b2Var, p pVar, long j) {
        this.c = b2Var;
        this.a = pVar;
        this.b = j;
    }

    public final void onError(int i, String str) {
        String strA = gj.a(str, this.a.g, i);
        r9.a("ssp_Banner", "loadTemplateAd(): error, adId:" + this.a.a + ";" + strA, null);
        this.c.a.onError(12, strA);
        za zaVarD = za.d();
        p pVar = this.a;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.b;
        zaVarD.getClass();
        za.a(pVar, jCurrentTimeMillis, str, i, false);
    }

    public final void onNativeAdLoad(List list) {
        if (list == null || list.isEmpty()) {
            this.c.a.onError(12, gj.a("adn callback list is empty.", this.a.g, -999));
            return;
        }
        l2 l2Var = new l2(this.c.b, this.a, (QiNativeAd) list.get(0), this.c.c);
        if (l2Var.b != null) {
            this.c.a.onBannerAdLoad(l2Var);
        } else {
            this.c.a.onError(4, "create ad view error.");
        }
        za zaVarD = za.d();
        p pVar = this.a;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.b;
        zaVarD.getClass();
        za.a(pVar, jCurrentTimeMillis, "", 0, true);
    }
}
