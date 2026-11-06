package com.byazt.ys;

import android.content.Context;
import android.view.View;
import com.byazt.gct.pk;
import com.byazt.gct.tj;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 122, 13})
public abstract class w extends n {
    public w(Context context, pk pkVar, String str, int i) {
        super(context, pkVar, str, i);
    }

    @Override // com.byazt.ys.qg, com.byazt.ys.l
    public void n(View view, tj tjVar) {
        if (pk.w(this.n)) {
            return;
        }
        super.n(view, tjVar);
    }
}
