package com.byazt.ca;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 730, 5})
public class q extends com.byazt.nf.w.n {
    public final com.byazt.tmn.qg n;

    public q(com.byazt.tmn.qg qgVar) {
        this.n = qgVar;
    }

    @Override // com.byazt.nf.w
    public Bundle n(int i) {
        com.byazt.tmn.qg qgVar = this.n;
        final Bundle bundle = new Bundle();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (qgVar != null) {
            qgVar.n(i, new com.byazt.vpa.n() { // from class: com.byazt.ca.q.1
                @Override // com.byazt.vpa.n
                public void n(Bundle bundle2) {
                    bundle.putAll(bundle2);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
        }
        return bundle;
    }
}
