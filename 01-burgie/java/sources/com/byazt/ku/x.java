package com.byazt.ku;

import android.os.Bundle;
import com.byazt.sd.ho;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 67, 121})
public class x extends ho.pr {
    public final com.byazt.yg.hw pr;

    public x(com.byazt.yg.hw hwVar) {
        this.pr = hwVar;
    }

    @Override // com.byazt.sd.ho
    public Bundle pr(int i) {
        com.byazt.yg.hw hwVar = this.pr;
        final Bundle bundle = new Bundle();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (hwVar != null) {
            hwVar.pr(i, new com.byazt.xl.pr() { // from class: com.byazt.ku.x.1
                @Override // com.byazt.xl.pr
                public void pr(Bundle bundle2) {
                    bundle.putAll(bundle2);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        return bundle;
    }
}
