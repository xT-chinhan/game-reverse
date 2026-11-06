package com.mcto.sspsdk.internal;

import android.app.Activity;
import com.mcto.unionsdk.QiClientFactory;
import com.mcto.unionsdk.QiSlot;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class jl {
    public final int a;
    public final int b;
    public int c = -1;

    public jl(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public static bl a(jl jlVar, cl clVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ArrayList arrayList = new ArrayList(1);
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            WeakReference weakReference = jd.g;
            Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
            (activity != null ? QiClientFactory.getQiClient(clVar.c, activity) : QiClientFactory.getQiClient(clVar.c, jd.a)).loadTemplateAd(new QiSlot.Builder().codeId(clVar.f).count(1).adType(6).build(), new il(jlVar, clVar, countDownLatch, jCurrentTimeMillis, arrayList));
            countDownLatch.await(clVar.e, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (bl) arrayList.get(0);
    }

    public static void a(jl jlVar, cl clVar, long j, String str, int i, boolean z) {
        String str2;
        if (z) {
            str2 = "";
        } else {
            str2 = "errCode:" + i + ";errMsg:" + gj.f(str);
        }
        String str3 = "codeId:" + clVar.f + ";adnType:" + clVar.c + ";priority:" + clVar.a + ";price:" + clVar.b + ";time:" + j + (z ? ";s:1" : ";s:0") + ";";
        za.d().getClass();
        za.a(52, (p) null, "", str2, str3);
    }
}
