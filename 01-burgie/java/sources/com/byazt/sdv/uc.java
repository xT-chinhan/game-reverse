package com.byazt.sdv;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 5})
public class uc {
    public static void pr(ProgressBar progressBar, Drawable drawable) {
        pr(progressBar, "mIndeterminateOnly", Boolean.FALSE);
        progressBar.setIndeterminate(false);
        progressBar.setProgressDrawable(drawable);
        progressBar.setIndeterminateDrawable(null);
    }

    private static void pr(Object obj, String str, Object obj2) {
        try {
            Field fieldPr = pr(obj, str);
            if (fieldPr == null) {
                throw new IllegalArgumentException("Could not find field [" + str + "] on target [" + obj + "]");
            }
            pr(fieldPr);
            fieldPr.set(obj, obj2);
        } catch (Throwable th) {
        }
    }

    private static Field pr(Object obj, String str) {
        return pr((Class) obj.getClass(), str);
    }

    private static Field pr(Class cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static void pr(Field field) {
        if (!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            field.setAccessible(true);
        }
    }

    public static void pr(AlertDialog alertDialog) {
        Window window;
        if (alertDialog != null && (window = alertDialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            alertDialog.requestWindowFeature(1);
            window.setDimAmount(0.5f);
        }
    }

    public static void hw(AlertDialog alertDialog) {
        Window window;
        if (alertDialog != null && (window = alertDialog.getWindow()) != null) {
            window.setFlags(1024, 1024);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
            window.clearFlags(2);
            alertDialog.setCanceledOnTouchOutside(true);
        }
    }

    public static void pr(Activity activity) {
        Window window;
        if (activity != null && (window = activity.getWindow()) != null) {
            activity.requestWindowFeature(1);
            window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
            window.clearFlags(134217728);
            window.setBackgroundDrawable(new ColorDrawable(-1));
            window.setStatusBarColor(ViewCompat.MEASURED_STATE_MASK);
            window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        }
    }

    public static void hw(Activity activity) {
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
