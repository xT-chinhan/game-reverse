package com.byazt.uo;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.ud.UGTextView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1609, 26})
public class qg extends com.byazt.ud.qg {
    public qg(Context context) {
        super(context);
    }

    @Override // com.byazt.ud.qg, com.byazt.ih.s
    public void qg() {
        super.qg();
        if (TextUtils.isEmpty(this.n)) {
            ((UGTextView) this.l).setText("跳过");
        }
    }

    public void q(boolean z) {
        if (z) {
            qg(0);
            n(true, true);
        } else {
            q(0);
            l(0);
        }
    }
}
