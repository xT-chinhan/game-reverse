package com.byazt.js;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 756, 121})
public class x {
    public static Drawable pr(Context context, com.byazt.rk.fw fwVar) {
        if (context != null && fwVar != null) {
            return pr(context, (int) zo.pr(context, fwVar.yb()), fwVar.nt(), fwVar.ve());
        }
        return null;
    }

    public static Drawable pr(Context context, int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (context != null) {
            gradientDrawable.setStroke(i, i2);
        }
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }
}
