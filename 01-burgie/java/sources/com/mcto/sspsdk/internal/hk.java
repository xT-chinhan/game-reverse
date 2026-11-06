package com.mcto.sspsdk.internal;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class hk {
    public static int a;

    public static int a(Context context) {
        try {
            return context.getResources().getDisplayMetrics().densityDpi;
        } catch (Exception e) {
            Log.e("ssp_sdk", "getDensityDpi ex:", e);
            return 0;
        }
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Pair c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return new Pair(0, 0);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return new Pair(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    public static boolean d(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static Activity e(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return e(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(AppCompatActivity appCompatActivity, boolean z) {
        WindowInsetsController insetsController;
        Window window = appCompatActivity.getWindow();
        window.getDecorView().setSystemUiVisibility(z ? 5894 : 1792);
        window.clearFlags(201326592);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        if (i < 30 || (insetsController = window.getInsetsController()) == null) {
            return;
        }
        insetsController.setSystemBarsBehavior(2);
    }

    public static int a(AppCompatActivity appCompatActivity) {
        int i = a;
        if (i > 0) {
            return i;
        }
        int identifier = appCompatActivity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            a = appCompatActivity.getResources().getDimensionPixelSize(identifier);
        }
        if (a <= 0) {
            a = (int) ((appCompatActivity.getResources().getDisplayMetrics().density * 25.0f) + 0.5f);
        }
        return a;
    }

    public static void a(View view) {
        view.setOutlineProvider(new ck());
        view.setClipToOutline(true);
    }

    public static void a(View view, float f) {
        view.setOutlineProvider(new dk(f));
        view.setClipToOutline(true);
    }

    public static void a(View view, float f, int i) {
        view.setOutlineProvider(new ek(i, f));
        view.setClipToOutline(true);
    }

    public static void a(ArrayList arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (view != null && (view.getTag() instanceof AnimatorSet)) {
                AnimatorSet animatorSet = (AnimatorSet) view.getTag();
                if (animatorSet.isRunning()) {
                    animatorSet.cancel();
                }
            }
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
        }
    }

    public static void a(View view, int i) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                a(viewGroup.getChildAt(i2), i);
            }
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(i);
        }
    }
}
