package com.byazt.dj;

import android.content.Context;
import android.view.View;
import com.byazt.gct.pk;
import com.byazt.gct.tj;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1976, 19})
public abstract class n {
    public pk n;
    public View q;
    public Context qg;
    public tj s;

    public abstract int n(Map<String, Object> map, s sVar);

    public void n(tj tjVar) {
        this.s = tjVar;
    }

    public void n(View view) {
        this.q = view;
    }
}
