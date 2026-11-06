package com.bytedance.sdk.component.widget.recycler.ms.ah;

import android.R;
import android.content.Context;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.component.utils.sl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ab {
    private static boolean ah;
    private static Field d;
    private static boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Field f1420ms;
    private static Method xr;

    public static int ms(View view) {
        return view.getLayoutDirection();
    }

    public static void ms(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void ms(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static float ms(ViewConfiguration viewConfiguration, Context context) {
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    public static float xr(ViewConfiguration viewConfiguration, Context context) {
        return viewConfiguration.getScaledVerticalScrollFactor();
    }

    private static float ah(ViewConfiguration viewConfiguration, Context context) {
        Method method = xr;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
                sl.ms("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static int xr(View view) {
        return view.getImportantForAccessibility();
    }

    public static void ms(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void ah(View view) {
        view.postInvalidateOnAnimation();
    }

    public static int d(View view) {
        return view.getMinimumWidth();
    }

    public static int ka(View view) {
        return view.getMinimumHeight();
    }

    public static boolean c(View view) {
        return view.hasTransientState();
    }

    public static Display ab(View view) {
        return view.getDisplay();
    }

    public static boolean x(View view) {
        return view.isAttachedToWindow();
    }

    public static int ny(View view) {
        return view.getImportantForAutofill();
    }

    public static void xr(View view, int i) {
        view.setImportantForAutofill(i);
    }

    public static boolean ms(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }

    public static void ch(View view) {
        view.stopNestedScroll();
    }
}
