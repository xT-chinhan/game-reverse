package com.byazt.is;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 62})
public class fw {
    public boolean pr = false;
    public boolean hw = false;
    public boolean hn = false;
    public boolean x = false;
    public boolean c = false;

    public static fw pr(String str) {
        fw fwVar = new fw();
        if (TextUtils.isEmpty(str)) {
            com.byazt.zp.fw.pr().delete();
            return fwVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            fwVar.pr = jSONObject.optBoolean("use_csj_main", false);
            fwVar.hw = jSONObject.optBoolean("use_layze_layout", false);
            fwVar.hn = jSONObject.optBoolean("create_ad_in_io", false);
            fwVar.x = jSONObject.optBoolean("opt_panel_view", false);
            boolean zOptBoolean = jSONObject.optBoolean("so_lock", false);
            fwVar.c = zOptBoolean;
            if (zOptBoolean) {
                com.byazt.zp.fw.pr().mkdirs();
            } else {
                com.byazt.zp.fw.pr().delete();
            }
            return fwVar;
        } catch (Throwable th) {
            return fwVar;
        }
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("use_csj_main", this.pr);
            jSONObject.put("use_layze_layout", this.hw);
            jSONObject.put("create_ad_in_io", this.hn);
            jSONObject.put("opt_panel_view", this.x);
            jSONObject.put("so_lock", this.c);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }
}
