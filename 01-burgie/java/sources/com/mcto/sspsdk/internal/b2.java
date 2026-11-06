package com.mcto.sspsdk.internal;

import android.content.Context;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.unionsdk.QiClientFactory;
import com.mcto.unionsdk.QiSlot;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class b2 implements f7 {
    public final /* synthetic */ yd a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ QyAdSlot c;

    public b2(yd ydVar, Context context, QyAdSlot qyAdSlot) {
        this.a = ydVar;
        this.b = context;
        this.c = qyAdSlot;
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar, int i, String str) {
        try {
            this.a.onError(i, str);
        } catch (Throwable th) {
            r9.a("ssp_Banner", "onError: ", th);
        }
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar) {
        try {
            ArrayList arrayList = vhVar.b;
            if (arrayList != null && !arrayList.isEmpty()) {
                p pVar = (p) arrayList.get(0);
                if (pVar.n()) {
                    QiClientFactory.getQiClient(pVar.g, this.b).loadAd(new QiSlot.Builder().codeId(pVar.u0).count(1).adType(ik.a().a(this.c.getCodeId(), pVar.u0)).token(pVar.e()).build(), new a2(this, pVar, System.currentTimeMillis()));
                    return;
                }
                z1 z1Var = new z1(this.b, this.c, pVar);
                if (z1Var.b != null) {
                    this.a.onBannerAdLoad(z1Var);
                    return;
                } else {
                    this.a.onError(4, "create ad view error.");
                    return;
                }
            }
            this.a.onError(5, "has empty ad.");
        } catch (Exception e) {
            r9.a("ssp_Banner", "getBannerAd onSuccess: ", e);
            this.a.onError(2, e.getMessage());
        }
    }
}
