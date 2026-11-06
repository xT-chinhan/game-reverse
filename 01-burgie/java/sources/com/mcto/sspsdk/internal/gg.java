package com.mcto.sspsdk.internal;

import com.mcto.unionsdk.QiAd;
import com.mcto.unionsdk.QiClient;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class gg implements QiClient.AdListener {
    public final /* synthetic */ p a;
    public final /* synthetic */ ng b;
    public final /* synthetic */ long c;
    public final /* synthetic */ ig d;

    public gg(ig igVar, p pVar, ng ngVar, long j) {
        this.d = igVar;
        this.a = pVar;
        this.b = ngVar;
        this.c = j;
    }

    public final void onAdLoad(List list) {
        r9.a("ssp_reward", "loadTemplateAd(): success. adId: " + this.a.a, null);
        if (list == null || list.isEmpty()) {
            return;
        }
        this.d.e = (QiAd) list.get(0);
        ig igVar = this.d;
        igVar.e.setInteractionListener(igVar.i);
        this.b.a(this.d);
        za zaVarD = za.d();
        p pVar = this.d.b;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
        zaVarD.getClass();
        za.a(pVar, jCurrentTimeMillis, "", 0, true);
    }

    public final void onError(int i, String str) {
        String strA = gj.a(str, this.a.g, i);
        r9.a("ssp_reward", "loadTemplateAd(): error, adId:" + this.a.a + ";" + strA, null);
        ng ngVar = this.b;
        vh vhVar = this.d.b.c;
        ngVar.a(12, strA);
        za zaVarD = za.d();
        p pVar = this.d.b;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
        zaVarD.getClass();
        za.a(pVar, jCurrentTimeMillis, str, i, false);
    }
}
