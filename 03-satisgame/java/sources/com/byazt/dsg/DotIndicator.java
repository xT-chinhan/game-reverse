package com.byazt.dsg;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.byazt.cp.n;

/* JADX INFO: loaded from: classes.dex */
@n(n = {0, 1, 902, 903})
public class DotIndicator extends BaseIndicator {
    public DotIndicator(Context context) {
        super(context);
    }

    @Override // com.byazt.dsg.BaseIndicator
    public Drawable qg(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }
}
