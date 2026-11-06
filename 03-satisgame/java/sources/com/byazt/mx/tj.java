package com.byazt.mx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1149, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj implements rv {
    @Override // com.byazt.mx.rv
    public boolean n(com.byazt.h.qg qgVar, int i, fs fsVar) {
        if (qgVar == null || !qg(qgVar.um())) {
            return false;
        }
        if (System.currentTimeMillis() - qgVar.rf() > n(qgVar.um())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (JSONException unused) {
        }
        com.byazt.vj.n.n().n("pause_optimise", jSONObject, qgVar);
        return true;
    }

    private long n(int i) {
        return com.byazt.f.n.n(i).n("pause_optimise_mistake_click_interval", TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
    }

    private boolean qg(int i) {
        return com.byazt.f.n.n(i).n("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }
}
