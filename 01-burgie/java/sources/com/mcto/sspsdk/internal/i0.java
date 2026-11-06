package com.mcto.sspsdk.internal;

import android.content.Context;
import android.os.SystemClock;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.mcto.unionsdk.QiAd;
import com.mcto.unionsdk.QiClient;
import com.mcto.unionsdk.QiClientFactory;
import com.mcto.unionsdk.QiNativeAd;
import com.mcto.unionsdk.QiSlot;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 implements QiClient.AdListener, QiClient.NativeAdListener {
    public final Long a = Long.valueOf(SystemClock.elapsedRealtime());
    public final p b;
    public final k6 c;
    public final Context d;
    public final QyAdSlot e;

    public i0(int i, p pVar, QyAdSlot qyAdSlot, Context context, k6 k6Var) {
        this.c = k6Var;
        this.b = pVar;
        this.d = context;
        this.e = qyAdSlot;
        try {
            QiClient qiClient = QiClientFactory.getQiClient(pVar.g, context);
            QiSlot qiSlotBuild = new QiSlot.Builder().codeId(pVar.u0).count(1).adType(i).token(pVar.e()).build();
            if (6 == i) {
                qiClient.loadTemplateAd(qiSlotBuild, this);
            } else {
                qiClient.loadAd(qiSlotBuild, this);
            }
        } catch (Throwable th) {
            onError(-999, "adn type not support!");
        }
    }

    public final void onAdLoad(List list) {
        p pVar = this.b;
        int i = pVar.a;
        k6 k6Var = this.c;
        tj tjVar = new tj(pVar, (QiAd) list.get(0));
        k6Var.getClass();
        k6Var.a.a(tjVar);
        za zaVarD = za.d();
        p pVar2 = this.b;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.a.longValue();
        zaVarD.getClass();
        za.a(pVar2, jElapsedRealtime, "", 0, true);
    }

    public final void onError(int i, String str) {
        String strA = gj.a(str, this.b.g, i);
        r9.a("ssp_fullscreen", "loadTemplateAd(): error, adId:" + this.b.a + ";" + strA, null);
        this.c.onError(12, strA);
        za zaVarD = za.d();
        p pVar = this.b;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.a.longValue();
        zaVarD.getClass();
        za.a(pVar, jElapsedRealtime, str, i, false);
    }

    public final void onNativeAdLoad(List list) {
        int i = this.b.a;
        QiNativeAd qiNativeAd = (QiNativeAd) list.get(0);
        p pVar = this.b;
        QyAdSlot qyAdSlot = this.e;
        Context context = this.d;
        fa faVar = new fa(pVar, qyAdSlot, qiNativeAd, context, new o(pVar, qiNativeAd));
        h0 h0Var = new h0(this, faVar);
        QYNiceImageView qYNiceImageView = new QYNiceImageView(context);
        qYNiceImageView.a(new da(faVar, qYNiceImageView, h0Var));
        qYNiceImageView.a(pVar.h());
        faVar.f = qYNiceImageView;
        za zaVarD = za.d();
        p pVar2 = this.b;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.a.longValue();
        zaVarD.getClass();
        za.a(pVar2, jElapsedRealtime, "", 0, true);
    }
}
