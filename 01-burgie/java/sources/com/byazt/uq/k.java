package com.byazt.uq;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 209, 250})
public class k extends com.byazt.ajv.pr {
    public final float[] fe;
    public String qx;

    public k(Context context) {
        super(context);
        this.fe = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        if (TextUtils.equals(str, "clickableInteract")) {
            this.qx = str2;
        } else {
            super.pr(str, str2);
        }
    }

    @Override // com.byazt.ajv.pr, com.byazt.ik.pr, com.byazt.ik.hn
    public void hw() {
        w(this.qx);
        super.hw();
    }

    private void w(String str) {
        String[] strArrSplit;
        if (!TextUtils.isEmpty(str)) {
            String strTrim = str.trim();
            if (strTrim.length() <= 2 || (strArrSplit = strTrim.substring(1, strTrim.length() - 1).split(",")) == null || strArrSplit.length != 4) {
                return;
            }
            for (int i = 0; i < strArrSplit.length; i++) {
                String str2 = strArrSplit[i];
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        this.fe[i] = Float.parseFloat(com.byazt.rhv.pr.pr(str2.trim(), this.x));
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
    }

    public float[] od() {
        return this.fe;
    }
}
