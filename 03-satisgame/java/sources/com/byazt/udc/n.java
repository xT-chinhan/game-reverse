package com.byazt.udc;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ph.q;
import com.byazt.vyf.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY, 19})
public final class n {
    public static final AtomicBoolean n = new AtomicBoolean(false);

    public static void n() {
        qg();
        if (n.compareAndSet(false, true)) {
            com.byazt.phf.n.n(new com.byazt.phf.n.s() { // from class: com.byazt.udc.n.1
                @Override // com.byazt.phf.n.s
                public void n(com.byazt.phf.n.qg qgVar) {
                    n.qg(qgVar);
                }
            });
        }
    }

    public static void n(String str) {
        if (TextUtils.isEmpty(str) || !q.cy()) {
            return;
        }
        try {
            n();
            int iN = com.byazt.phf.n.n(str);
            if (iN <= 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rit", str);
            jSONObject.put("same_rit_queue_count", iN);
            com.byazt.eji.s.n().n("get_ads_queue_freq_hit", jSONObject);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(com.byazt.phf.n.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start2report_time", SystemClock.elapsedRealtime() - l.l);
            jSONObject.put("total_calls", qgVar.n);
            jSONObject.put("ready_calls_count", qgVar.qg);
            jSONObject.put("request_window_duration_ms", s(qgVar));
            jSONObject.put("ready_rit", n(qgVar.l));
            jSONObject.put("running_calls_count", qgVar.w);
            jSONObject.put("running_rit", n(qgVar.x));
            jSONObject.put("uuid", com.byazt.ehw.n.s());
            com.byazt.eji.s.n().n("get_ads_queue_observe", jSONObject);
        } catch (Exception unused) {
        }
    }

    private static void qg() {
        JSONObject jSONObjectK = q.k();
        if (jSONObjectK == null || !q.cy()) {
            com.byazt.phf.n.n(0, 0L, false);
        } else {
            com.byazt.phf.n.n(jSONObjectK.optInt("ready_threshold", 500), jSONObjectK.optLong("report_interval", 60000L), true);
        }
    }

    private static long s(com.byazt.phf.n.qg qgVar) {
        return Math.max(qgVar.q - qgVar.s, 0L);
    }

    private static JSONObject n(Map<String, Integer> map) throws JSONException {
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
