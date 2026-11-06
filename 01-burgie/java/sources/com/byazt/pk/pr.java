package com.byazt.pk;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.is.vk;
import com.byazt.sd.lb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, 37})
public final class pr {
    public static final AtomicBoolean pr = new AtomicBoolean(false);

    public static void pr() {
        hw();
        if (pr.compareAndSet(false, true)) {
            com.byazt.tf.pr.pr(new com.byazt.tf.pr.hn() { // from class: com.byazt.pk.pr.1
                @Override // com.byazt.tf.pr.hn
                public void pr(com.byazt.tf.pr.hw hwVar) {
                    pr.hw(hwVar);
                }
            });
        }
    }

    public static void pr(String str) {
        if (TextUtils.isEmpty(str) || !vk.m()) {
            return;
        }
        try {
            pr();
            int iPr = com.byazt.tf.pr.pr(str);
            if (iPr <= 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rit", str);
            jSONObject.put("same_rit_queue_count", iPr);
            com.byazt.xk.hw.pr().pr("get_ads_queue_freq_hit", jSONObject);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(com.byazt.tf.pr.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start2report_time", SystemClock.elapsedRealtime() - lb.c);
            jSONObject.put("total_calls", hwVar.pr);
            jSONObject.put("ready_calls_count", hwVar.hw);
            jSONObject.put("request_window_duration_ms", hn(hwVar));
            jSONObject.put("ready_rit", pr(hwVar.c));
            jSONObject.put("running_calls_count", hwVar.uc);
            jSONObject.put("running_rit", pr(hwVar.fw));
            jSONObject.put("uuid", com.byazt.mp.pr.hn());
            com.byazt.xk.hw.pr().pr("get_ads_queue_observe", jSONObject);
        } catch (Exception e) {
        }
    }

    private static void hw() {
        JSONObject jSONObjectK = vk.k();
        if (jSONObjectK == null || !vk.m()) {
            com.byazt.tf.pr.pr(0, 0L, false);
        } else {
            com.byazt.tf.pr.pr(jSONObjectK.optInt("ready_threshold", 500), jSONObjectK.optLong("report_interval", 60000L), true);
        }
    }

    private static long hn(com.byazt.tf.pr.hw hwVar) {
        return Math.max(hwVar.x - hwVar.hn, 0L);
    }

    private static JSONObject pr(Map<String, Integer> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (map == null) {
            return jSONObject;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }
}
