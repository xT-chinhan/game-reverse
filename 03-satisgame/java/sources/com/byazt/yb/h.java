package com.byazt.yb;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 878})
public final class h implements hd {
    public static Object n;
    public static Class<?> qg;
    public static Method s;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            qg = cls;
            n = cls.newInstance();
            s = qg.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            com.byazt.km.cp.n("Api#static reflect exception! " + e.getMessage());
        }
    }

    public static boolean n() {
        return (qg == null || n == null || s == null) ? false : true;
    }

    @Override // com.byazt.yb.hd
    public boolean qg(Context context) {
        return n();
    }

    @Override // com.byazt.yb.hd
    public hd.n s(Context context) {
        try {
            hd.n nVar = new hd.n();
            nVar.qg = n(context, s);
            return nVar;
        } catch (Exception e) {
            com.byazt.km.cp.n(e);
            return null;
        }
    }

    private static String n(Context context, Method method) {
        Object obj = n;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
