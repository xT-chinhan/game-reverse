package com.byazt.yb;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 21})
public final class x {
    public static qg<cy> n = new qg<cy>() { // from class: com.byazt.yb.x.1
        @Override // com.byazt.yb.qg
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public cy n(Object... objArr) {
            return new cy((Context) objArr[0]);
        }
    };

    public static void n(Context context) {
        n.qg(context).qg();
    }

    public static String n(SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        return q.n(sharedPreferences);
    }

    public static Map<String, String> n(Context context, SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        cy cyVarQg = n.qg(context);
        return cyVarQg.n(cyVarQg.n() instanceof d ? 200 : 100);
    }

    public static String n(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    public static void n(com.byazt.zve.s sVar) {
        cy.n(sVar);
    }

    public static void qg(com.byazt.zve.s sVar) {
        cy.qg(sVar);
    }
}
