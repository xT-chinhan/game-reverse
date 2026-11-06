package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public class op {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static SoftReference<Toast> f1364ms;

    private static Toast ms(Context context) {
        if (context == null) {
            SoftReference<Toast> softReference = f1364ms;
            if (softReference != null) {
                return softReference.get();
            }
            return null;
        }
        SoftReference<Toast> softReference2 = new SoftReference<>(Toast.makeText(context.getApplicationContext(), "", 0));
        f1364ms = softReference2;
        return softReference2.get();
    }

    public static Toast ms(Context context, String str, int i, int i2, int i3, int i4) {
        Toast toast = new Toast(context);
        toast.setDuration(i);
        toast.setGravity(i2, i3, i4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(ms(context, 10.0f));
        gradientDrawable.setColor(Color.parseColor("#CC161823"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(ms(context, 20.0f), ms(context, 12.0f), ms(context, 20.0f), ms(context, 12.0f));
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setText(str);
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        return toast;
    }

    public static void ms(Context context, String str, int i) {
        xr(context, str, i, 80, 0, ms(context, 40.0f));
    }

    public static void xr(Context context, String str, int i, int i2, int i3, int i4) {
        Toast toastMs = ms(context);
        if (toastMs != null) {
            toastMs.setDuration(i);
            toastMs.setGravity(i2, i3, i4);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(ms(context, 10.0f));
            gradientDrawable.setColor(Color.parseColor("#CC161823"));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setBackground(gradientDrawable);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(ms(context, 20.0f), ms(context, 12.0f), ms(context, 20.0f), ms(context, 12.0f));
            TextView textView = new TextView(context);
            textView.setTextColor(-1);
            textView.setText(str);
            textView.setTextSize(2, 14.0f);
            linearLayout.addView(textView);
            toastMs.setView(linearLayout);
            toastMs.show();
            return;
        }
        sl.ms("TToast", "toast msg: ".concat(String.valueOf(str)));
    }

    private static int ms(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
