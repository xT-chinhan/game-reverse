package com.byazt.jx;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 508, 5})
public class q extends n {
    public int nk;
    public String o;
    public String vo;

    public q(Context context) {
        super(context);
    }

    @Override // com.byazt.jx.n
    public void n(int i, int i2, int i3) {
        if (i3 <= 0 && !TextUtils.isEmpty(this.dm)) {
            this.n = this.dm;
            d(this.n);
            return;
        }
        int i4 = this.nk;
        int i5 = i4 - i2;
        if (i4 > 0 && i5 > 0) {
            this.n = this.vo;
        } else {
            this.n = this.o;
        }
        this.n = this.n.replace("${_countdownTime_}", String.valueOf(i5)).replace("${_remainTime_}", String.valueOf(i3));
        d(this.n);
    }

    @Override // com.byazt.jx.n, com.byazt.ud.qg, com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "text1":
                this.vo = str2;
                break;
            case "text2":
                this.o = str2;
                break;
            case "startCountDown":
                this.nk = com.byazt.hb.s.n(str2, -1);
                break;
        }
    }
}
