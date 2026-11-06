package com.mcto.sspsdk.internal;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class jc extends TextView {
    public static final /* synthetic */ int c = 0;
    public Drawable a;
    public String b;

    public jc(Context context) {
        super(context);
        this.b = "广告";
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(hk.a(getContext(), 2.0f));
        gradientDrawable.setColor(1275068416);
        setBackground(gradientDrawable);
        setGravity(17);
        setTextColor(-1);
        setIncludeFontPadding(false);
        setPadding(6, 2, 6, 2);
        setClickable(false);
    }

    public final void a() {
        float textSize = getTextSize() * 0.85f;
        Drawable drawable = this.a;
        if (drawable == null) {
            setText(this.b);
            return;
        }
        int i = (int) textSize;
        drawable.setBounds(0, 0, i, i);
        SpannableString spannableString = new SpannableString("  " + this.b);
        x3 x3Var = new x3(this.a);
        ColorDrawable colorDrawable = new ColorDrawable(0);
        colorDrawable.setBounds(0, 0, 3, i);
        ImageSpan imageSpan = new ImageSpan(colorDrawable, 1);
        spannableString.setSpan(x3Var, 0, 1, 33);
        spannableString.setSpan(imageSpan, 1, 2, 33);
        setText(spannableString);
    }

    public final void a(int i, String str, String str2) {
        if (i == 1) {
            int i2 = R.drawable.qy_ic_ad_logo;
            this.b = "广告";
            this.a = ContextCompat.getDrawable(getContext(), i2);
            a();
            return;
        }
        if (i == 2) {
            if (TextUtils.isEmpty(str2)) {
                this.b = "广告";
                a();
                return;
            }
            this.b = "广告";
            setVisibility(4);
            a8 a8VarA = a8.a(getContext());
            ic icVar = new ic(this);
            a8VarA.getClass();
            zg.a.a(new v7(a8VarA, str2, icVar, 60, 60));
            return;
        }
        this.b = str != null ? str.concat("广告") : "广告";
        a();
    }
}
