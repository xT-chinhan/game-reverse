package com.bytedance.sdk.component.adexpress.d;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.t;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static boolean f757ms;

    public static int ms(float f, float f2, float f3, float f4) {
        return (((int) ((f * 255.0f) + 0.5f)) << 24) | (((int) ((f2 * 255.0f) + 0.5f)) << 16) | (((int) ((f3 * 255.0f) + 0.5f)) << 8) | ((int) ((f4 * 255.0f) + 0.5f));
    }

    public static float ms(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().getContext();
        }
        return (f * ka(context)) + 0.5f;
    }

    public static int xr(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().getContext();
        }
        float fKa = ka(context);
        if (fKa <= 0.0f) {
            fKa = 1.0f;
        }
        return (int) ((f / fKa) + 0.5f);
    }

    public static float ah(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().getContext();
        }
        return f * ka(context);
    }

    private static float ka(Context context) {
        try {
            if (f757ms) {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.DisplayMetrics");
                Method declaredMethod = clsLoadClass.getDeclaredMethod("getDeviceDensity", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(clsLoadClass, new Object[0])).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int ms(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().getContext();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int xr(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().getContext();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int ah(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static String d(Context context) {
        String language;
        try {
            Locale locale = t.ms(context).getConfiguration().getLocales().get(0);
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
        return ms(language);
    }

    private static String ms(String str) {
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
