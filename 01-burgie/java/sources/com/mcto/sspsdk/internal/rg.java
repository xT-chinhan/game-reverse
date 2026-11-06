package com.mcto.sspsdk.internal;

import android.content.Context;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.unionsdk.QiClient;
import com.mcto.unionsdk.QiClientFactory;
import com.mcto.unionsdk.QiNativeAd;
import com.mcto.unionsdk.QiSlot;

/* JADX INFO: loaded from: classes2.dex */
public final class rg {
    public final p a;
    public volatile QiNativeAd b;
    public volatile boolean c = false;
    public final Object d = new Object();
    public lc e;

    public rg(Context context, QyAdSlot qyAdSlot, p pVar) {
        this.a = pVar;
        if (!pVar.n()) {
            a(true);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            QiClient qiClient = QiClientFactory.getQiClient(pVar.g, context);
            QiSlot qiSlotBuild = new QiSlot.Builder().codeId(pVar.u0).count(1).adType(2).token(pVar.e()).build();
            qiSlotBuild.setMute(qyAdSlot.isMute());
            r9.a("ssp_reward", pVar, "loadTemplateAd(): loading, adn :" + pVar.g);
            qiClient.loadAd(qiSlotBuild, new qg(this, jCurrentTimeMillis));
        } catch (Throwable th) {
            a(false);
            r9.a("ssp_reward", "load():", th);
            za zaVarD = za.d();
            p pVar2 = this.a;
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            zaVarD.getClass();
            za.a(pVar2, jCurrentTimeMillis2, "adn type not support!", -999, false);
        }
    }

    public final void a(boolean z) {
        lc lcVar;
        synchronized (this.d) {
            this.c = true;
            lcVar = this.e;
            this.e = null;
        }
        if (lcVar != null) {
            lcVar.a(Boolean.valueOf(z));
        }
    }
}
