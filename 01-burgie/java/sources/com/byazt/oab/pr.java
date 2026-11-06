package com.byazt.oab;

import android.content.Context;
import com.byazt.aa.zo;
import com.byazt.ik.hn;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1251, 37})
public class pr extends hn<UGProgressBar> {
    public String fe;
    public int ks;
    public int pr;
    public int qx;
    public float sr;
    public float wz;

    public pr(Context context) {
        super(context);
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public UGProgressBar pr() {
        UGProgressBar uGProgressBar = new UGProgressBar(this.hw);
        uGProgressBar.pr(this);
        return uGProgressBar;
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        ((UGProgressBar) this.c).setBackgroundColor(this.qx);
        ((UGProgressBar) this.c).setText(this.fe);
        ((UGProgressBar) this.c).setProgressBgColor(this.qx);
        ((UGProgressBar) this.c).setProgressColor(this.pr);
        ((UGProgressBar) this.c).setTextColor(this.ks);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        switch (str) {
            case "text":
                this.fe = str2;
                break;
            case "textColor":
                this.ks = com.byazt.aa.pr.pr(str2);
                break;
            case "progressColor":
                this.pr = com.byazt.aa.pr.pr(str2);
                break;
            case "progressBgColor":
                this.qx = com.byazt.aa.pr.pr(str2);
                break;
            case "textSize":
                this.sr = zo.pr(this.hw, str2);
                break;
            case "progress":
                this.wz = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
        }
    }
}
