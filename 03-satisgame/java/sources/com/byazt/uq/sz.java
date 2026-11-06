package com.byazt.uq;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 110})
public final class sz {
    public static Object n(Context context) {
        Object obj;
        if (context != null) {
            try {
                if (context.getClass() == PluginActivityWrapper.class) {
                    obj = ((PluginActivityWrapper) context).mOriginActivity;
                } else {
                    obj = context.getClass() == PluginApplicationWrapper.class ? ((PluginApplicationWrapper) context).mOriginApplication : null;
                }
                if (obj != null) {
                    return obj;
                }
            } catch (Throwable unused) {
            }
        }
        return context;
    }

    public static void n(JSONObject jSONObject, Activity activity) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (activity == null) {
                com.byazt.ot.n nVarS = com.byazt.vyf.s.cy().s();
                WeakReference<Activity> weakReferenceN = nVarS != null ? nVarS.n() : null;
                Activity activity2 = weakReferenceN != null ? weakReferenceN.get() : null;
                if (activity2 == null) {
                    return;
                }
                n(activity2, jSONObject);
                return;
            }
            n(activity, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void n(Activity activity, JSONObject jSONObject) {
        try {
            n(activity);
            jSONObject.put("t_name", n.s(q.w()));
            CharSequence title = activity.getTitle();
            jSONObject.put("top_page_title", n.s(title != null ? title.toString() : null));
            jSONObject.put("has_window_focus", activity.hasWindowFocus());
            jSONObject.put("top_page_name", n.s(activity.getClass().getName()));
        } catch (Throwable unused) {
        }
    }
}
