package com.byazt.ca;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 110})
public final class z {
    public static Method pr(String str, String str2, Class<?>... clsArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Class<?> clsPr = pr(str);
            if (clsPr != null) {
                return clsPr.getMethod(str2, clsArr);
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Class<?> pr(String str) {
        try {
            return Class.forName(str, true, pr());
        } catch (ClassNotFoundException e) {
            try {
                return Class.forName(str, true, z.class.getClassLoader());
            } catch (ClassNotFoundException e2) {
                try {
                    return Class.forName(str);
                } catch (ClassNotFoundException e3) {
                    return null;
                }
            }
        }
    }

    private static ClassLoader pr() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            return z.class.getClassLoader();
        }
        return contextClassLoader;
    }
}
