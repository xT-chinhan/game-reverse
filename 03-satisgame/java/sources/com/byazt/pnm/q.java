package com.byazt.pnm;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 5})
public class q {
    public boolean n = false;
    public boolean qg = false;
    public boolean s = false;
    public boolean q = false;
    public boolean l = false;
    public boolean w = false;

    public static q n(String str) {
        q qVar = new q();
        if (TextUtils.isEmpty(str)) {
            com.byazt.xhd.s.n().delete();
            com.byazt.xhd.s.qg().delete();
            return qVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            qVar.n = jSONObject.optBoolean("use_csj_main", false);
            qVar.qg = jSONObject.optBoolean("use_layze_layout", false);
            qVar.s = jSONObject.optBoolean("create_ad_in_io", false);
            qVar.q = jSONObject.optBoolean("opt_panel_view", false);
            qVar.l = jSONObject.optBoolean("so_lock", false);
            qVar.w = jSONObject.optBoolean("use_cloud_so", false);
            if (qVar.l) {
                com.byazt.xhd.s.n().mkdirs();
            } else {
                com.byazt.xhd.s.n().delete();
            }
            if (qVar.w) {
                com.byazt.xhd.s.qg().mkdirs();
            } else {
                com.byazt.xhd.s.qg().delete();
            }
        } catch (Throwable unused) {
        }
        return qVar;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("use_csj_main", this.n);
            jSONObject.put("use_layze_layout", this.qg);
            jSONObject.put("create_ad_in_io", this.s);
            jSONObject.put("opt_panel_view", this.q);
            jSONObject.put("so_lock", this.l);
            jSONObject.put("use_cloud_so", this.w);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
