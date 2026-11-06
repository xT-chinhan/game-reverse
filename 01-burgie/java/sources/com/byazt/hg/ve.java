package com.byazt.hg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM})
public class ve {
    public int hn;
    public long hw;
    public int pr;

    public static ve pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ve veVar = new ve();
        veVar.pr = jSONObject.optInt("refresh_control", 0);
        veVar.hw = jSONObject.optLong("refresh_imp_max_time", 0L);
        veVar.hn = jSONObject.optInt("refresh_num", 0);
        return veVar;
    }

    public void hw(JSONObject jSONObject) {
        try {
            jSONObject.put("refresh_control", this.pr);
            jSONObject.put("refresh_imp_max_time", this.hw);
            jSONObject.put("refresh_num", this.hn);
        } catch (JSONException e) {
        }
    }

    public static boolean pr(of ofVar) {
        ve veVarSb;
        return (ofVar == null || (veVarSb = ofVar.sb()) == null || veVarSb.pr() != 1) ? false : true;
    }

    public int pr() {
        return this.pr;
    }

    public long hw() {
        return this.hw;
    }

    public int hn() {
        return this.hn;
    }

    public static int hw(of ofVar) {
        ve veVarSb;
        if (ofVar == null || (veVarSb = ofVar.sb()) == null) {
            return 0;
        }
        return veVarSb.hn();
    }

    public static boolean pr(List<of> list) {
        Iterator<of> it = list.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            if (it.next().oq() == 100.0f) {
                z = true;
            } else {
                z2 = true;
            }
        }
        return (z && z2) ? false : true;
    }

    public static boolean hn(of ofVar) {
        return com.byazt.sd.a.hw().ho(String.valueOf(com.byazt.wt.ls.m(ofVar))) && pr(ofVar) && !com.byazt.dt.fw.pr(String.valueOf(com.byazt.wt.ls.m(ofVar)));
    }
}
