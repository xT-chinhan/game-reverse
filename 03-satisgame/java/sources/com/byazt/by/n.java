package com.byazt.by;

import android.view.View;
import com.byazt.gp.w;
import com.byazt.sg.s;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2172, 19})
public class n {
    public static View n(s sVar, View view) {
        if (view != null) {
            w.n(view);
            return view;
        }
        View viewRv = (sVar == null || !sVar.kc()) ? null : sVar.rv();
        w.n(viewRv);
        return viewRv;
    }
}
