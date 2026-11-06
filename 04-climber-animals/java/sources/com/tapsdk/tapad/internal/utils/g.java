package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static void a(Context context, ImageView imageView) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        Drawable drawable = imageView.getDrawable();
        float f = i;
        float f2 = i2;
        float f3 = f / f2;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float f4 = intrinsicWidth / intrinsicHeight;
        if (f3 > f4) {
            i = (int) (intrinsicWidth * (intrinsicHeight / f2));
        } else if (f3 < f4) {
            i2 = (int) (intrinsicHeight / (intrinsicWidth / f));
        }
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
    }
}
