package com.byazt.iaw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 507, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class c extends RuntimeException {
    public static final Method pr;
    public IOException hw;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception e) {
            declaredMethod = null;
        }
        pr = declaredMethod;
    }

    public c(IOException iOException) {
        super(iOException);
        this.hw = iOException;
    }

    public IOException pr() {
        return this.hw;
    }

    public void pr(IOException iOException) {
        pr(iOException, this.hw);
        this.hw = iOException;
    }

    private void pr(IOException iOException, IOException iOException2) {
        Method method = pr;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
            }
        }
    }
}
