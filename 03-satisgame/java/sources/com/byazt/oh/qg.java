package com.byazt.oh;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_OPTIMIZE, 26})
public class qg {
    public static Activity n(View view) {
        if (view == null) {
            return null;
        }
        Activity activityN = n(view.getContext());
        if (activityN != null) {
            return activityN;
        }
        Object parent = view.getParent();
        if ((parent instanceof View) && (activityN = n((View) parent)) != null) {
            return activityN;
        }
        View rootView = view.getRootView();
        if (rootView == null) {
            return activityN;
        }
        Context context = rootView.getContext();
        Activity activityN2 = n(context);
        return activityN2 != null ? activityN2 : qg(context);
    }

    private static Activity n(Context context) {
        Context baseContext;
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context).getBaseContext()) == null || baseContext == context) {
            return null;
        }
        return n(baseContext);
    }

    private static Activity qg(Context context) {
        if (context != null && context.getClass().getName().contains("DecorContext")) {
            try {
                Field declaredField = context.getClass().getDeclaredField("mActivity");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                if (obj instanceof Activity) {
                    return (Activity) obj;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
