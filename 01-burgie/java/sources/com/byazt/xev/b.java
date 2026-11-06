package com.byazt.xev;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME})
public final class b implements yb {
    public static Method hn;
    public static Class<?> hw;
    public static Object pr;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            hw = cls;
            pr = cls.newInstance();
            hn = hw.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            com.byazt.ec.w.pr("Api#static reflect exception! " + e.getMessage());
        }
    }

    public static boolean pr() {
        return (hw == null || pr == null || hn == null) ? false : true;
    }

    @Override // com.byazt.xev.yb
    public boolean hw(Context context) {
        return pr();
    }

    @Override // com.byazt.xev.yb
    public yb.pr hn(Context context) {
        try {
            yb.pr prVar = new yb.pr();
            prVar.hw = pr(context, hn);
            return prVar;
        } catch (Exception e) {
            com.byazt.ec.w.pr(e);
            return null;
        }
    }

    private static String pr(Context context, Method method) {
        Object obj = pr;
        if (obj != null && method != null) {
            try {
                Object objInvoke = method.invoke(obj, context);
                if (objInvoke != null) {
                    return (String) objInvoke;
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
