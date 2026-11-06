package com.byazt.jd;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 93, 121})
public class x extends pr {
    public String sr;
    public String wz;
    public int xb;

    public x(Context context) {
        super(context);
    }

    @Override // com.byazt.jd.pr
    public void pr(int i, int i2, int i3) {
        if (i3 <= 0 && !TextUtils.isEmpty(this.ks)) {
            this.pr = this.ks;
            w(this.pr);
            return;
        }
        int i4 = this.xb;
        int i5 = i4 - i2;
        if (i4 > 0 && i5 > 0) {
            this.pr = this.sr;
        } else {
            this.pr = this.wz;
        }
        this.pr = this.pr.replace("${_countdownTime_}", String.valueOf(i5)).replace("${_remainTime_}", String.valueOf(i3));
        w(this.pr);
    }

    @Override // com.byazt.jd.pr, com.byazt.id.hw, com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        switch (str) {
            case "text1":
                this.sr = str2;
                break;
            case "text2":
                this.wz = str2;
                break;
            case "startCountDown":
                this.xb = com.byazt.aa.hn.pr(str2, -1);
                break;
        }
    }
}
