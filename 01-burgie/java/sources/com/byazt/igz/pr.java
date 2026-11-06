package com.byazt.igz;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.hl.RoundImageView;
import com.byazt.hl.hw;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1740, 37})
public abstract class pr extends hw {
    public int sr;

    public abstract String w(String str);

    public pr(Context context) {
        super(context);
        this.sr = ViewCompat.MEASURED_STATE_MASK;
    }

    @Override // com.byazt.hl.hw, com.byazt.ik.hn
    public void hw() {
        this.pr = m(this.pr);
        super.hw();
        ((RoundImageView) this.c).setColorFilter(this.sr);
        ((RoundImageView) this.c).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private String m(String str) {
        String strW = w(str);
        if (TextUtils.isEmpty(strW)) {
            return "";
        }
        return "local://".concat(String.valueOf(strW));
    }

    @Override // com.byazt.hl.hw, com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        switch (str) {
            case "textColor":
                this.sr = com.byazt.aa.pr.pr(str2);
                break;
        }
    }

    @Override // com.byazt.hl.hw
    public String fw() {
        return "drawable";
    }
}
