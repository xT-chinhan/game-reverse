package com.byazt.zy;

import android.content.Context;
import com.byazt.hb.fs;
import com.byazt.ih.s;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1601, 19})
public class n extends s<UGProgressBar> {
    public int dm;
    public String ei;
    public int n;
    public float o;
    public int sq;
    public float vo;

    public n(Context context) {
        super(context);
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public UGProgressBar n() {
        UGProgressBar uGProgressBar = new UGProgressBar(this.qg);
        uGProgressBar.n(this);
        return uGProgressBar;
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        ((UGProgressBar) this.l).setBackgroundColor(this.sq);
        ((UGProgressBar) this.l).setText(this.ei);
        ((UGProgressBar) this.l).setProgressBgColor(this.sq);
        ((UGProgressBar) this.l).setProgressColor(this.n);
        ((UGProgressBar) this.l).setTextColor(this.dm);
    }

    public void w(int i) {
        ((UGProgressBar) this.l).setTextColor(i);
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "progressBgColor":
                this.sq = com.byazt.hb.n.n(str2);
                break;
            case "textColor":
                this.dm = com.byazt.hb.n.n(str2);
                break;
            case "textSize":
                this.vo = fs.n(this.qg, str2);
                break;
            case "progress":
                this.o = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case "text":
                this.ei = str2;
                break;
            case "progressColor":
                this.n = com.byazt.hb.n.n(str2);
                break;
        }
    }
}
