package com.byazt.js;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.byazt.ca.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 756, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static boolean pr;

    public static float pr(Context context, float f) {
        if (context == null) {
            context = com.byazt.bg.pr.pr().hn().getContext();
        }
        return (f * c(context)) + 0.5f;
    }

    public static int hw(Context context, float f) {
        if (context == null) {
            context = com.byazt.bg.pr.pr().hn().getContext();
        }
        float fC = c(context);
        if (fC <= 0.0f) {
            fC = 1.0f;
        }
        return (int) ((f / fC) + 0.5f);
    }

    public static float hn(Context context, float f) {
        if (context == null) {
            context = com.byazt.bg.pr.pr().hn().getContext();
        }
        return f * c(context);
    }

    private static float c(Context context) {
        try {
            if (pr) {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.DisplayMetrics");
                Method declaredMethod = clsLoadClass.getDeclaredMethod("getDeviceDensity", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(clsLoadClass, new Object[0])).intValue() / 160.0f;
            }
        } catch (Exception e) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int pr(Context context) {
        if (context == null) {
            context = com.byazt.bg.pr.pr().hn().getContext();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int hw(Context context) {
        if (context == null) {
            context = com.byazt.bg.pr.pr().hn().getContext();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int hn(Context context) {
        if (context == null) {
            context = com.byazt.bg.pr.pr().hn().getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static int pr(float f, float f2, float f3, float f4) {
        return (((int) ((f * 255.0f) + 0.5f)) << 24) | (((int) ((f2 * 255.0f) + 0.5f)) << 16) | (((int) ((f3 * 255.0f) + 0.5f)) << 8) | ((int) ((f4 * 255.0f) + 0.5f));
    }

    public static String x(Context context) {
        String language;
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = a.pr(context).getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            language = locale.getLanguage();
            try {
                if (locale.getCountry().equals("TW")) {
                    language = "zhHant";
                }
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            language = "";
        }
        return pr(language);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003a  */
    private static String pr(String str) {
        switch (str) {
            case "ja":
                return "japan";
            case "ko":
                return "korea";
            case "zh":
                return "cn";
            case "ar":
                return "aa";
            case "ms":
                return "my";
            default:
                return str;
        }
    }
}
