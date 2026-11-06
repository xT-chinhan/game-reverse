package com.byazt.qp;

import android.app.Application;
import android.content.Context;
import android.util.SparseArray;
import com.byazt.vf.oj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.reflect.Method;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 525, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa implements oj, Function {
    public volatile Context n;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return getContext();
        }
        if (iIntValue == 2) {
            n((Context) sparseArray.get(1));
            return null;
        }
        if (iIntValue != 3) {
            return null;
        }
        return n();
    }

    @Override // com.byazt.vf.oj
    public Context getContext() {
        if (this.n == null) {
            this.n = n.n();
        }
        return this.n;
    }

    @Override // com.byazt.vf.oj
    public void n(Context context) {
        if (this.n != null || context == null) {
            return;
        }
        this.n = context.getApplicationContext();
    }

    @Override // com.byazt.vf.oj
    public Application n() {
        return n.n();
    }

    @com.byazt.cp.n(n = {0, 1, 525, TTAdConstant.IMAGE_URL_CODE})
    private static class n {
        public static volatile Application n;

        public static Application n() {
            return n;
        }

        static {
            try {
                Object objQg = qg();
                n = (Application) objQg.getClass().getMethod("getApplication", new Class[0]).invoke(objQg, new Object[0]);
            } catch (Throwable unused) {
            }
        }

        private static Object qg() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
