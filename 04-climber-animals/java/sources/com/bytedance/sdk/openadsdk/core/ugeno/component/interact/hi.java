package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class hi extends com.bytedance.adsdk.ugeno.widget.frame.ms {
    private final float[] kl;
    private String vf;

    public hi(Context context) {
        super(context);
        this.kl = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        if (TextUtils.equals(str, "clickableInteract")) {
            this.vf = str2;
        } else {
            super.ms(str, str2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.frame.ms, com.bytedance.adsdk.ugeno.xr.ms, com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        x(this.vf);
        super.xr();
    }

    private void x(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strTrim = str.trim();
        if (strTrim.length() <= 2 || (strArrSplit = strTrim.substring(1, strTrim.length() - 1).split(",")) == null || strArrSplit.length != 4) {
            return;
        }
        for (int i = 0; i < strArrSplit.length; i++) {
            String str2 = strArrSplit[i];
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.kl[i] = Float.parseFloat(com.bytedance.sdk.openadsdk.upie.ms.ms.ms(str2.trim(), this.d));
                } catch (NumberFormatException e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
            }
        }
    }

    public float[] sa() {
        return this.kl;
    }
}
