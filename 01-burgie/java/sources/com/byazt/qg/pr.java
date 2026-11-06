package com.byazt.qg;

import android.content.Context;
import android.graphics.Color;
import com.byazt.ik.hn;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 591, 37})
public class pr extends hn<UGRatingBar> {
    public static final int wz = Color.parseColor("#FFC642");
    public static final int xb = Color.parseColor("#e3e3e4");
    public float fe;
    public float ks;
    public int pr;
    public int qx;
    public float sr;

    public pr(Context context) {
        super(context);
        this.pr = wz;
        this.qx = xb;
        this.fe = 4.0f;
        this.ks = 20.0f;
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public UGRatingBar pr() {
        UGRatingBar uGRatingBar = new UGRatingBar(this.hw);
        uGRatingBar.pr(this);
        return uGRatingBar;
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        if (nl()) {
            ((UGRatingBar) this.c).pr(this.fe, this.pr, this.qx, this.ks, (int) this.sr);
        } else {
            ((UGRatingBar) this.c).pr(this.fe, this.pr, this.qx, this.ks, 5);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        switch (str) {
            case "highLightColor":
            case "highlightColor":
                this.pr = com.byazt.aa.pr.pr(str2);
                break;
            case "lowLightColor":
            case "lowlightColor":
                this.qx = com.byazt.aa.pr.pr(str2, xb);
                break;
            case "score":
                this.fe = com.byazt.aa.hn.pr(str2, 4.0f);
                break;
            case "gap":
                this.sr = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case "size":
                this.ks = com.byazt.aa.hn.pr(str2, 20.0f);
                break;
        }
    }
}
