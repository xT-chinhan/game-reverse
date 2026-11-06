package com.byazt.tk;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 878})
public class h {
    public static SoftReference<Toast> n;

    private static Toast n(Context context) {
        if (context == null) {
            SoftReference<Toast> softReference = n;
            if (softReference != null) {
                return softReference.get();
            }
            return null;
        }
        SoftReference<Toast> softReference2 = new SoftReference<>(Toast.makeText(context.getApplicationContext(), "", 0));
        n = softReference2;
        return softReference2.get();
    }

    public static Toast n(Context context, String str, int i, int i2, int i3, int i4) {
        Toast toast = new Toast(context);
        toast.setDuration(i);
        toast.setGravity(i2, i3, i4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(n(context, 10.0f));
        gradientDrawable.setColor(Color.parseColor("#CC161823"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(n(context, 20.0f), n(context, 12.0f), n(context, 20.0f), n(context, 12.0f));
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setText(str);
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        return toast;
    }

    public static void n(Context context, String str, int i) {
        qg(context, str, i, 80, 0, n(context, 40.0f));
    }

    public static void qg(Context context, String str, int i, int i2, int i3, int i4) {
        Toast toastN = n(context);
        if (toastN != null) {
            toastN.setDuration(i);
            toastN.setGravity(i2, i3, i4);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(n(context, 10.0f));
            gradientDrawable.setColor(Color.parseColor("#CC161823"));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setBackground(gradientDrawable);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(n(context, 20.0f), n(context, 12.0f), n(context, 20.0f), n(context, 12.0f));
            TextView textView = new TextView(context);
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextSize(2, 14.0f);
            linearLayout.addView(textView);
            toastN.setView(linearLayout);
            toastN.show();
        }
    }

    private static int n(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
