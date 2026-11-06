package com.byazt.at;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.hb.fs;
import com.byazt.ih.s;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 887, 19})
public class n extends s<DislikeView> {
    public int ei;
    public int n;
    public int sq;

    public n(Context context) {
        super(context);
        this.n = 0;
        this.ei = 0;
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public DislikeView n() {
        DislikeView dislikeView = new DislikeView(this.qg);
        dislikeView.n(this);
        return dislikeView;
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        ((DislikeView) this.l).setRadius(this.pk);
        ((DislikeView) this.l).setStrokeWidth((int) this.pe);
        ((DislikeView) this.l).setDislikeColor(this.n);
        ((DislikeView) this.l).setStrokeColor(this.e);
        ((DislikeView) this.l).setDislikeWidth(this.sq);
        ((DislikeView) this.l).setBgColor(this.ei);
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "dislikeColor":
                this.n = com.byazt.hb.n.n(str2);
                break;
            case "dislikeWidth":
                this.sq = (int) fs.n(this.qg, Integer.parseInt(str2));
                break;
            case "dislikeFillColor":
                this.ei = com.byazt.hb.n.n(str2);
                break;
        }
    }
}
