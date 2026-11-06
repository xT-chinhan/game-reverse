package com.mcto.sspsdk.internal;

import com.mcto.unionsdk.QiAdnAd;
import com.mcto.unionsdk.QiClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class il implements QiClient.AdListener {
    public final /* synthetic */ cl a;
    public final /* synthetic */ CountDownLatch b;
    public final /* synthetic */ long c;
    public final /* synthetic */ ArrayList d;
    public final /* synthetic */ jl e;

    public il(jl jlVar, cl clVar, CountDownLatch countDownLatch, long j, ArrayList arrayList) {
        this.e = jlVar;
        this.a = clVar;
        this.b = countDownLatch;
        this.c = j;
        this.d = arrayList;
    }

    public final void onAdLoad(List list) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            QiAdnAd qiAdnAd = (QiAdnAd) list.get(0);
            this.d.add(new bl(this.a, qiAdnAd, new JSONObject(qiAdnAd.getCreativeString()), jCurrentTimeMillis));
            cl clVar = this.a;
            String str = clVar.f;
            jl.a(this.e, clVar, jCurrentTimeMillis - this.c, "", 0, true);
            this.b.countDown();
        } catch (Exception e) {
            r9.a("ssp_water_fs", "loadCodeId() error.", e);
            onError(-999, e.toString());
        }
    }

    public final void onError(int i, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str2 = this.a.f;
        this.b.countDown();
        jl.a(this.e, this.a, jCurrentTimeMillis - this.c, str, i, false);
    }
}
