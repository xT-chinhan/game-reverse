package com.byazt.xs;

import android.content.Context;
import com.byazt.om.UGFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2485, 19})
public abstract class n extends com.byazt.ih.n<UGFrameLayout> {
    public n(Context context) {
        super(context);
    }

    @Override // com.byazt.ih.n, com.byazt.ih.s
    public void qg() {
        super.qg();
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "onVideoProgress":
            case "onVideoFinish":
            case "onVideoPlay":
            case "onVideoResume":
            case "onVideoPause":
                qg(str, str2);
                break;
        }
    }
}
