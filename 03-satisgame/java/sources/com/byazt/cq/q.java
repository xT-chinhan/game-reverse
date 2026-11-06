package com.byazt.cq;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 883, 5})
public class q {
    public static Drawable n(Context context, com.byazt.lh.x xVar) {
        if (context == null || xVar == null) {
            return null;
        }
        return n(context, (int) fs.n(context, xVar.hd()), xVar.cy(), xVar.ur());
    }

    public static Drawable n(Context context, int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (context != null) {
            gradientDrawable.setStroke(i, i2);
        }
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }
}
