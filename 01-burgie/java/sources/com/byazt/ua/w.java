package com.byazt.ua;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 109})
public final class w {
    public static Object pr(Context context) {
        if (context != null) {
            Object obj = null;
            try {
                if (context.getClass() == PluginActivityWrapper.class) {
                    obj = ((PluginActivityWrapper) context).mOriginActivity;
                } else if (context.getClass() == PluginApplicationWrapper.class) {
                    obj = ((PluginApplicationWrapper) context).mOriginApplication;
                }
                if (obj != null) {
                    return obj;
                }
            } catch (Throwable th) {
            }
        }
        return context;
    }

    public static void pr(JSONObject jSONObject, Activity activity) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (activity == null) {
                com.byazt.wt.pr prVarHn = com.byazt.sd.zo.nt().hn();
                WeakReference<Activity> weakReferencePr = prVarHn != null ? prVarHn.pr() : null;
                Activity activity2 = weakReferencePr != null ? weakReferencePr.get() : null;
                if (activity2 == null) {
                    return;
                }
                pr(activity2, jSONObject);
                return;
            }
            pr(activity, jSONObject);
        } catch (Throwable th) {
        }
    }

    public static void pr(Activity activity, JSONObject jSONObject) {
        try {
            pr(activity);
            String strUc = x.uc();
            if (strUc == null || strUc.isEmpty()) {
                strUc = " ";
            }
            jSONObject.put("t_name", strUc);
            CharSequence title = activity.getTitle();
            jSONObject.put("top_page_title", title != null ? title.toString() : " ");
            jSONObject.put("has_window_focus", activity.hasWindowFocus());
            jSONObject.put("top_page_name", activity.getClass().getName());
        } catch (Throwable th) {
        }
    }
}
