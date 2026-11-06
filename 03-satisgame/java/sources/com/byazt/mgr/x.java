package com.byazt.mgr;

import android.R;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2431, 21})
public class x {
    public static boolean l;
    public static Field n;
    public static Field q;
    public static Method qg;
    public static boolean s;

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                qg = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
            }
        }
    }

    public static int n(View view) {
        return view.getLayoutDirection();
    }

    public static void n(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void n(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static float n(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledHorizontalScrollFactor() : s(viewConfiguration, context);
    }

    public static float qg(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledVerticalScrollFactor() : s(viewConfiguration, context);
    }

    private static float s(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = qg) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static int qg(View view) {
        return view.getImportantForAccessibility();
    }

    public static void n(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void s(View view) {
        view.postInvalidateOnAnimation();
    }

    public static int q(View view) {
        return view.getMinimumWidth();
    }

    public static int l(View view) {
        return view.getMinimumHeight();
    }

    public static boolean w(View view) {
        return view.hasTransientState();
    }

    public static Display x(View view) {
        return view.getDisplay();
    }

    public static boolean fs(View view) {
        return view.isAttachedToWindow();
    }

    public static int rv(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void qg(View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    public static boolean n(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }

    public static void tj(View view) {
        view.stopNestedScroll();
    }
}
