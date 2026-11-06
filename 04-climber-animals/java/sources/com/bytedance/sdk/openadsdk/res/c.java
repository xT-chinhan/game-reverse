package com.bytedance.sdk.openadsdk.res;

import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static void ms(ProgressBar progressBar, Drawable drawable) {
        ms(progressBar, "mIndeterminateOnly", Boolean.FALSE);
        progressBar.setIndeterminate(false);
        progressBar.setProgressDrawable(drawable);
        progressBar.setIndeterminateDrawable(null);
    }

    private static void ms(Object obj, String str, Object obj2) {
        try {
            Field fieldMs = ms(obj, str);
            if (fieldMs == null) {
                throw new IllegalArgumentException("Could not find field [" + str + "] on target [" + obj + "]");
            }
            ms(fieldMs);
            fieldMs.set(obj, obj2);
        } catch (Throwable unused) {
        }
    }

    private static Field ms(Object obj, String str) {
        return ms((Class) obj.getClass(), str);
    }

    private static Field ms(Class cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static void ms(Field field) {
        if (Modifier.isPublic(field.getModifiers()) && Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            return;
        }
        field.setAccessible(true);
    }
}
