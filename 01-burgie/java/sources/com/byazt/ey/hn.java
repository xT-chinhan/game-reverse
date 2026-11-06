package com.byazt.ey;

import android.content.Context;
import com.byazt.se.c;
import com.byazt.wf.x;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1650, 20})
public class hn implements hw {
    public Context pr;

    @Override // com.byazt.ey.hw
    public void pr(long j, Thread thread, Throwable th) throws Throwable {
        com.byazt.lee.pr prVarPr = com.byazt.lee.pr.pr(j, this.pr, thread, th);
        x.pr(this.pr, com.byazt.vlj.hn.JAVA.pr(), Thread.currentThread().getName());
        com.byazt.tv.pr.pr().pr(c.pr().pr(com.byazt.vlj.hn.JAVA, prVarPr).pr());
    }

    @Override // com.byazt.ey.hw
    public boolean pr(Throwable th) {
        return true;
    }

    public hn(Context context) {
        this.pr = context;
    }
}
