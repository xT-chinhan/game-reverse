package com.byazt.nc;

import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS, 8})
public class s {
    public static Function<SparseArray<Object>, Object> n;

    public static void n(Function<SparseArray<Object>, Object> function) {
        n = function;
    }

    public static void n(JSONObject jSONObject) {
        if (jSONObject != null && com.byazt.vyf.s.cy().sh()) {
            qg(s(jSONObject));
        }
    }

    private static void qg(JSONObject jSONObject) {
        if (n != null) {
            com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
            qgVarN.n(10002).n(Void.class);
            qgVarN.n(20003, jSONObject.toString());
            n.apply(qgVarN.qg());
        }
    }

    private static JSONObject s(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, jSONObject);
        } catch (Throwable unused) {
        }
        return jSONObject2;
    }
}
