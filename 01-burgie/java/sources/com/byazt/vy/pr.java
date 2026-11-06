package com.byazt.vy;

import android.content.Context;
import com.byazt.qg.UGRatingBar;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2007, 37})
public class pr extends com.byazt.qg.pr {
    public pr(Context context) {
        super(context);
    }

    @Override // com.byazt.qg.pr, com.byazt.ik.hn
    /* JADX INFO: renamed from: fw */
    public UGRatingBar pr() {
        UGNewRatingBar uGNewRatingBar = new UGNewRatingBar(this.hw);
        uGNewRatingBar.pr(this);
        return uGNewRatingBar;
    }
}
