package com.byazt.jd;

import android.content.Context;
import android.graphics.Bitmap;
import com.byazt.llk.uc;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 93, 13})
public class hw extends com.byazt.ik.hn<CycleCountDownView> {
    public String fe;
    public String ks;
    public String pr;
    public String qx;

    public hw(Context context) {
        super(context);
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public CycleCountDownView pr() {
        return new CycleCountDownView(this.hw);
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        switch (str) {
            case "before":
                this.pr = str2;
                break;
            case "after":
                this.qx = str2;
                break;
            case "text":
                this.fe = str2;
                break;
            case "finish":
                this.ks = str2;
                break;
            case "boxImage":
                ((CycleCountDownView) this.c).setBoxImage(null);
                uc.pr().hw().pr(this.aj, str2, new com.byazt.llk.hw.pr() { // from class: com.byazt.jd.hw.1
                    @Override // com.byazt.llk.hw.pr
                    public void pr(Bitmap bitmap) {
                        ((CycleCountDownView) hw.this.c).setBoxImage(bitmap);
                    }
                });
                break;
            case "boxFinishImage":
                uc.pr().hw().pr(this.aj, str2, new com.byazt.llk.hw.pr() { // from class: com.byazt.jd.hw.2
                    @Override // com.byazt.llk.hw.pr
                    public void pr(Bitmap bitmap) {
                        ((CycleCountDownView) hw.this.c).setBoxFinish(bitmap);
                    }
                });
                break;
        }
        ((CycleCountDownView) this.c).pr(this.pr, this.qx, this.fe, this.ks);
    }

    public void pr(int i, int i2, int i3, boolean z) {
        if (this.c != 0) {
            ((CycleCountDownView) this.c).pr(i, i2, i3);
            ((CycleCountDownView) this.c).setCanSkip(z);
            ((CycleCountDownView) this.c).setClickable(z);
            ((CycleCountDownView) this.c).setEnabled(z);
        }
    }
}
