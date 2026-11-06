package com.bytedance.sdk.component.adexpress.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static Drawable ms(Context context, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        if (context == null || abVar == null) {
            return null;
        }
        return ms(context, (int) x.ms(context, abVar.h()), abVar.ao(), abVar.le());
    }

    public static Drawable ms(Context context, int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (context != null) {
            gradientDrawable.setStroke(i, i2);
        }
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }
}
