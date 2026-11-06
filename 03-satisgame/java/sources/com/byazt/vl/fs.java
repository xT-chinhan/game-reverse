package com.byazt.vl;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 101})
public class fs {
    public static volatile fs n;

    private fs() {
    }

    public static fs n() {
        if (n == null) {
            synchronized (q.class) {
                if (n == null) {
                    n = new fs();
                }
            }
        }
        return n;
    }

    public void n(int i, int i2, com.byazt.h.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        com.byazt.f.n nVarN = com.byazt.f.n.n(qgVar.um());
        if (nVarN.n("report_api_hijack", 0) == 0) {
            return;
        }
        int i3 = i2 - i;
        if (i <= 0 || i3 <= nVarN.n("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i3);
            jSONObject.put("installed_version_code", i2);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException unused) {
        }
        com.byazt.vj.n.n().qg("api_hijack", jSONObject, qgVar);
    }
}
