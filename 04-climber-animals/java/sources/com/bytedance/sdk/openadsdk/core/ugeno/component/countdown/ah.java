package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms {
    private String gs;
    private int nl;
    private String r;

    public ah(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.ms
    public void ms(int i, int i2, int i3) {
        if (i3 <= 0 && !TextUtils.isEmpty(this.kl)) {
            this.f430ms = this.kl;
            ny(this.f430ms);
            return;
        }
        int i4 = this.nl;
        int i5 = i4 - i2;
        if (i4 > 0 && i5 > 0) {
            this.f430ms = this.gs;
        } else {
            this.f430ms = this.r;
        }
        this.f430ms = this.f430ms.replace("${_countdownTime_}", String.valueOf(i5)).replace("${_remainTime_}", String.valueOf(i3));
        ny(this.f430ms);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.ms, com.bytedance.adsdk.ugeno.widget.text.xr, com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "text1":
                this.gs = str2;
                break;
            case "text2":
                this.r = str2;
                break;
            case "startCountDown":
                this.nl = com.bytedance.adsdk.ugeno.c.ah.ms(str2, -1);
                break;
        }
    }
}
