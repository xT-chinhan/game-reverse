package com.byazt.oob;

import android.content.Context;
import com.byazt.ajv.UGFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 858, 37})
public abstract class pr extends com.byazt.ik.pr<UGFrameLayout> {
    public pr(Context context) {
        super(context);
    }

    @Override // com.byazt.ik.pr, com.byazt.ik.hn
    public void hw() {
        super.hw();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        switch (str) {
            case "onVideoFinish":
            case "onVideoPause":
            case "onVideoProgress":
            case "onVideoResume":
            case "onVideoPlay":
                hw(str, str2);
                break;
        }
    }
}
