package com.byazt.ath;

import android.content.Context;
import com.byazt.far.UGRatingBar;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2254, 19})
public class n extends com.byazt.far.n {
    public n(Context context) {
        super(context);
    }

    @Override // com.byazt.far.n, com.byazt.ih.s
    /* JADX INFO: renamed from: x */
    public UGRatingBar n() {
        UGNewRatingBar uGNewRatingBar = new UGNewRatingBar(this.qg);
        uGNewRatingBar.n(this);
        return uGNewRatingBar;
    }
}
