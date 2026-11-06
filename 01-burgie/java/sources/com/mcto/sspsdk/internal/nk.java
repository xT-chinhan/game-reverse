package com.mcto.sspsdk.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class nk {
    public static SpannableString a(Context context, String str) throws Throwable {
        if (!str.contains("\n")) {
            SpannableString spannableString = new SpannableString(str);
            if (!str.isEmpty()) {
                spannableString.setSpan(new x6(hk.a(context, 38.0f)), 0, str.length(), 33);
            }
            return spannableString;
        }
        String[] strArrSplit = str.split("\n", -1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArrSplit.length; i++) {
            sb.append(strArrSplit[i]);
            if (i == 0 && strArrSplit.length > 1) {
                sb.append(" \n");
            } else if (i < strArrSplit.length - 1) {
                sb.append("\n");
            }
        }
        SpannableString spannableString2 = new SpannableString(sb.toString());
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.qy_ic_gold_label);
        if (drawable != null) {
            drawable.setBounds(0, 0, hk.a(context, 63.0f), (int) ((context.getResources().getDisplayMetrics().density * 23.8f) + 0.5f));
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < strArrSplit.length) {
            String str2 = strArrSplit[i2];
            int length = str2.length() + i3;
            if (!str2.isEmpty()) {
                spannableString2.setSpan(new x6(hk.a(context, i2 == 0 ? 38 : 31)), i3, length, 33);
            }
            if (i2 == 0 && strArrSplit.length > 1 && drawable != null) {
                spannableString2.setSpan(new ImageSpan(drawable, 0), length, length + 1, 33);
            }
            if (i2 == 0 && strArrSplit.length > 1) {
                i3 = length + 2;
            } else if (i2 < strArrSplit.length - 1) {
                i3 = length + 1;
            }
            i2++;
        }
        return spannableString2;
    }
}
