package com.byazt.cq;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.byazt.tk.a;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 883, 101})
public class fs {
    public static boolean n;

    public static int n(float f, float f2, float f3, float f4) {
        return (((int) ((f * 255.0f) + 0.5f)) << 24) | (((int) ((f2 * 255.0f) + 0.5f)) << 16) | (((int) ((f3 * 255.0f) + 0.5f)) << 8) | ((int) ((f4 * 255.0f) + 0.5f));
    }

    public static float n(Context context, float f) {
        if (context == null) {
            context = com.byazt.gkj.n.n().s().getContext();
        }
        return (f * l(context)) + 0.5f;
    }

    public static int qg(Context context, float f) {
        if (context == null) {
            context = com.byazt.gkj.n.n().s().getContext();
        }
        float fL = l(context);
        if (fL <= 0.0f) {
            fL = 1.0f;
        }
        return (int) ((f / fL) + 0.5f);
    }

    public static float s(Context context, float f) {
        if (context == null) {
            context = com.byazt.gkj.n.n().s().getContext();
        }
        return f * l(context);
    }

    private static float l(Context context) {
        try {
            if (n) {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.DisplayMetrics");
                Method declaredMethod = clsLoadClass.getDeclaredMethod("getDeviceDensity", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(clsLoadClass, new Object[0])).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int n(Context context) {
        if (context == null) {
            context = com.byazt.gkj.n.n().s().getContext();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int qg(Context context) {
        if (context == null) {
            context = com.byazt.gkj.n.n().s().getContext();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int s(Context context) {
        if (context == null) {
            context = com.byazt.gkj.n.n().s().getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static String q(Context context) {
        String language;
        try {
            Locale locale = a.n(context).getConfiguration().getLocales().get(0);
            language = locale.getLanguage();
            try {
                if (locale.getCountry().equals("TW")) {
                    language = "zhHant";
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            language = "";
        }
        return n(language);
    }

    private static String n(String str) {
        str.hashCode();
        switch (str) {
            case "ar":
                return "aa";
            case "ja":
                return "japan";
            case "ko":
                return "korea";
            case "ms":
                return "my";
            case "zh":
                return "cn";
            default:
                return str;
        }
    }
}
