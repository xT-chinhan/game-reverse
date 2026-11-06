package com.byazt.cb;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1206, 8})
public class s {
    public static void n(ProgressBar progressBar, Drawable drawable) {
        n(progressBar, "mIndeterminateOnly", Boolean.FALSE);
        progressBar.setIndeterminate(false);
        progressBar.setProgressDrawable(drawable);
        progressBar.setIndeterminateDrawable(null);
    }

    private static void n(Object obj, String str, Object obj2) {
        try {
            Field fieldN = n(obj, str);
            if (fieldN == null) {
                throw new IllegalArgumentException("Could not find field [" + str + "] on target [" + obj + "]");
            }
            n(fieldN);
            fieldN.set(obj, obj2);
        } catch (Throwable unused) {
        }
    }

    private static Field n(Object obj, String str) {
        return n((Class) obj.getClass(), str);
    }

    private static Field n(Class cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static void n(Field field) {
        if (Modifier.isPublic(field.getModifiers()) && Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            return;
        }
        field.setAccessible(true);
    }

    public static void n(AlertDialog alertDialog) {
        Window window;
        if (alertDialog == null || (window = alertDialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        alertDialog.requestWindowFeature(1);
        window.setDimAmount(0.5f);
    }

    public static void qg(AlertDialog alertDialog) {
        Window window;
        if (alertDialog == null || (window = alertDialog.getWindow()) == null) {
            return;
        }
        window.setFlags(1024, 1024);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -1);
        window.clearFlags(2);
        alertDialog.setCanceledOnTouchOutside(true);
    }

    public static void n(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        activity.requestWindowFeature(1);
        window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        window.clearFlags(134217728);
        window.setBackgroundDrawable(new ColorDrawable(-1));
        window.setStatusBarColor(ViewCompat.MEASURED_STATE_MASK);
        window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
    }

    public static void qg(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        activity.requestWindowFeature(1);
        window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        window.clearFlags(134217728);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.type = 2;
        window.setAttributes(attributes);
        window.setStatusBarColor(Color.parseColor("#000000"));
        window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        window.setWindowAnimations(0);
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#88000000")));
    }
}
