package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes3.dex */
public class p {
    public static int a(Context context) {
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels * displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean a(Context context, Rect rect) {
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRectSize(rect);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
