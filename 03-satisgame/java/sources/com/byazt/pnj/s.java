package com.byazt.pnj;

import com.byazt.gct.pk;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS, 8})
public class s {
    public static void n(pk pkVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("second_page_type", i);
        } catch (JSONException unused) {
        }
        com.byazt.hm.n.qg(pkVar, "second_page_jsb_invoke", jSONObject);
    }

    public static void n(pk pkVar, boolean z, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("second_page_type", i);
            jSONObject.put("origin_req_id", w.hd(pkVar));
            jSONObject.put("error_code", i2);
        } catch (JSONException unused) {
        }
        com.byazt.hm.n.qg(pkVar, "second_page_request", jSONObject);
    }

    public static void qg(pk pkVar, boolean z, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("second_page_type", i);
            jSONObject.put("origin_req_id", w.hd(pkVar));
            jSONObject.put("error_code", i2);
        } catch (JSONException unused) {
        }
        com.byazt.hm.n.qg(pkVar, "second_page_show", jSONObject);
    }
}
