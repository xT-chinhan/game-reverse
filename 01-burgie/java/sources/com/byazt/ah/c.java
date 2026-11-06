package com.byazt.ah;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.byazt.wf.g;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1023, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static JSONObject pr(boolean z) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", g.pr(stackTrace));
        return jSONObject;
    }

    public static String pr(Context context, int i) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfoPr = com.byazt.wf.pr.pr(context, i);
        if (processErrorStateInfoPr != null && Process.myPid() == processErrorStateInfoPr.pid) {
            return hw.pr(processErrorStateInfoPr);
        }
        return null;
    }
}
