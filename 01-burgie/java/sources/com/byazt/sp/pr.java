package com.byazt.sp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, 37})
public class pr {
    public static Map<String, Field> pr = new HashMap();

    private static String hw(Class<?> cls, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString()).append("#").append(str);
        return sb.toString();
    }

    public static Field pr(Class<?> cls, String str) {
        Field field;
        String strHw = hw(cls, str);
        synchronized (pr) {
            field = pr.get(strHw);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                synchronized (pr) {
                    pr.put(strHw, declaredField);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Object pr(Field field, Object obj) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static Object pr(Object obj, String str) throws IllegalAccessException {
        Field fieldPr = pr(obj.getClass(), str);
        if (fieldPr != null) {
            return pr(fieldPr, obj);
        }
        return null;
    }
}
