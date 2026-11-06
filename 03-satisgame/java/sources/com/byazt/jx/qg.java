package com.byazt.jx;

import android.content.Context;
import android.graphics.Bitmap;
import com.byazt.gu.w;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 508, 26})
public class qg extends com.byazt.ih.s<CycleCountDownView> {
    public String dm;
    public String ei;
    public String n;
    public String sq;

    public qg(Context context) {
        super(context);
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public CycleCountDownView n() {
        return new CycleCountDownView(this.qg);
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "boxImage":
                ((CycleCountDownView) this.l).setBoxImage(null);
                w.n().qg().n(this.rv, str2, new com.byazt.gu.qg.n() { // from class: com.byazt.jx.qg.1
                    @Override // com.byazt.gu.qg.n
                    public void n(Bitmap bitmap) {
                        ((CycleCountDownView) qg.this.l).setBoxImage(bitmap);
                    }
                });
                break;
            case "before":
                this.n = str2;
                break;
            case "finish":
                this.dm = str2;
                break;
            case "text":
                this.ei = str2;
                break;
            case "after":
                this.sq = str2;
                break;
            case "boxFinishImage":
                w.n().qg().n(this.rv, str2, new com.byazt.gu.qg.n() { // from class: com.byazt.jx.qg.2
                    @Override // com.byazt.gu.qg.n
                    public void n(Bitmap bitmap) {
                        ((CycleCountDownView) qg.this.l).setBoxFinish(bitmap);
                    }
                });
                break;
        }
        ((CycleCountDownView) this.l).n(this.n, this.sq, this.ei, this.dm);
    }

    public void n(int i, int i2, int i3, boolean z) {
        if (this.l != 0) {
            ((CycleCountDownView) this.l).n(i, i2, i3);
            ((CycleCountDownView) this.l).setCanSkip(z);
            ((CycleCountDownView) this.l).setClickable(z);
            ((CycleCountDownView) this.l).setEnabled(z);
        }
    }
}
