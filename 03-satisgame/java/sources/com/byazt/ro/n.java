package com.byazt.ro;

import android.content.Context;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1987, 19})
public class n extends com.byazt.ih.n<ScrollView> {
    public n(Context context) {
        super(context);
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: cx, reason: merged with bridge method [inline-methods] */
    public ScrollView n() {
        UGScrollView uGScrollView = new UGScrollView(this.qg);
        uGScrollView.n(this);
        return uGScrollView;
    }

    @Override // com.byazt.ih.n
    public com.byazt.ih.n.C0202n fs() {
        return new com.byazt.om.n.C0283n(this);
    }
}
