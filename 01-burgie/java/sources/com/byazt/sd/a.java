package com.byazt.sd;

import android.app.Application;
import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD})
public class a {
    public static final AtomicBoolean hn = new AtomicBoolean(false);
    public static volatile com.byazt.is.w hw;
    public static volatile fo pr;
    public static volatile Context x;

    public static Context getContext() {
        if (x == null) {
            x = pr.pr();
        }
        return x;
    }

    public static synchronized void pr(Context context) {
        if (x == null && context != null) {
            x = context.getApplicationContext();
        }
    }

    public static fo pr() {
        if (pr == null) {
            synchronized (a.class) {
                if (pr == null) {
                    pr = new rc(getContext());
                }
            }
        }
        return pr;
    }

    public static com.byazt.is.w hw() {
        if (hw == null) {
            synchronized (com.byazt.is.w.class) {
                if (hw == null) {
                    hw = new com.byazt.is.w();
                }
            }
        }
        return hw;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 23, 1365})
    private static class pr {
        public static volatile Application pr;

        public static Application pr() {
            return pr;
        }

        static {
            try {
                Object objHw = hw();
                pr = (Application) objHw.getClass().getMethod("getApplication", new Class[0]).invoke(objHw, new Object[0]);
            } catch (Throwable th) {
            }
        }

        private static Object hw() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                return null;
            }
        }
    }
}
