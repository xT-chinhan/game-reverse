package com.byazt.ez;

import android.app.Activity;
import com.byazt.aqe.tj;
import com.byazt.gct.pk;
import com.byazt.gct.ry;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1378, 19})
public abstract class n extends com.byazt.aqe.qg {
    public String n;

    public void n(String str) {
        this.n = str;
    }

    public n(Activity activity, pk pkVar) {
        super(activity, pkVar);
    }

    public n(Activity activity, pk pkVar, ry ryVar) {
        super(activity, pkVar, ryVar);
    }

    @Override // com.byazt.aqe.qg
    public com.byazt.aqe.qg.n n(tj tjVar) {
        q qVar = new q(this.fs, this.x);
        qVar.q(this.cp);
        qVar.s(this.d);
        qVar.qg(this.k);
        qVar.n(this.n);
        return qVar.n(tjVar);
    }
}
