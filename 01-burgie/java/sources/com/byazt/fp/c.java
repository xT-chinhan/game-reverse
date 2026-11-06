package com.byazt.fp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class c {
    public static Method hn;
    public static Method hw;
    public static Method pr;

    static {
        try {
            pr = Class.class.getDeclaredMethod("forName", String.class);
            hw = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            hn = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException e) {
        } catch (NullPointerException e2) {
        }
    }

    public static Object pr(Object obj, String str, String str2, Object obj2) {
        try {
            Field fieldPr = pr(str, str2);
            if (fieldPr == null) {
                return obj2;
            }
            fieldPr.setAccessible(true);
            return fieldPr.get(obj);
        } catch (IllegalAccessException e) {
            return obj2;
        }
    }

    public static Field pr(String str, String str2) {
        if (!pr()) {
            return null;
        }
        try {
            Field field = (Field) hn.invoke((Class) pr.invoke(null, str), str2);
            try {
                field.setAccessible(true);
                return field;
            } catch (Throwable th) {
                return field;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    private static boolean pr() {
        return (pr == null || hw == null || hn == null) ? false : true;
    }
}
