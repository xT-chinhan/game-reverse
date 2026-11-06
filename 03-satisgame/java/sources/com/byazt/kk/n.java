package com.byazt.kk;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.byazt.jm.RoundImageView;
import com.byazt.jm.s;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2456, 19})
public abstract class n extends s {
    public int vo;

    public abstract String d(String str);

    @Override // com.byazt.jm.s
    public String x() {
        return "drawable";
    }

    public n(Context context) {
        super(context);
        this.vo = ViewCompat.MEASURED_STATE_MASK;
    }

    @Override // com.byazt.jm.s, com.byazt.ih.s
    public void qg() {
        this.n = sz(this.n);
        super.qg();
        ((RoundImageView) this.l).setColorFilter(this.vo);
        ((RoundImageView) this.l).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private String sz(String str) {
        String strD = d(str);
        return TextUtils.isEmpty(strD) ? "" : "local://".concat(String.valueOf(strD));
    }

    @Override // com.byazt.jm.s, com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        if (str.equals("textColor")) {
            this.vo = com.byazt.hb.n.n(str2);
        }
    }
}
