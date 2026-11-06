package com.byazt.far;

import android.content.Context;
import android.graphics.Color;
import com.byazt.ih.s;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1219, 19})
public class n extends s<UGRatingBar> {
    public float dm;
    public float ei;
    public int n;
    public int sq;
    public float vo;
    public static final int o = Color.parseColor("#FFC642");
    public static final int nk = Color.parseColor("#e3e3e4");

    public n(Context context) {
        super(context);
        this.n = o;
        this.sq = nk;
        this.ei = 4.0f;
        this.dm = 20.0f;
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public UGRatingBar n() {
        UGRatingBar uGRatingBar = new UGRatingBar(this.qg);
        uGRatingBar.n(this);
        return uGRatingBar;
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        if (ln()) {
            ((UGRatingBar) this.l).n(this.ei, this.n, this.sq, this.dm, (int) this.vo);
        } else {
            ((UGRatingBar) this.l).n(this.ei, this.n, this.sq, this.dm, 5);
        }
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "highLightColor":
            case "highlightColor":
                this.n = com.byazt.hb.n.n(str2);
                break;
            case "lowLightColor":
            case "lowlightColor":
                this.sq = com.byazt.hb.n.n(str2, nk);
                break;
            case "gap":
                this.vo = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case "size":
                this.dm = com.byazt.hb.s.n(str2, 20.0f);
                break;
            case "score":
                this.ei = com.byazt.hb.s.n(str2, 4.0f);
                break;
        }
    }
}
