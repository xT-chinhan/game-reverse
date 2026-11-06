package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1088})
public class ur {
    public int n;
    public long qg;
    public int s;

    public static ur n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ur urVar = new ur();
        urVar.n = jSONObject.optInt("refresh_control", 0);
        urVar.qg = jSONObject.optLong("refresh_imp_max_time", 0L);
        urVar.s = jSONObject.optInt("refresh_num", 0);
        return urVar;
    }

    public void qg(JSONObject jSONObject) {
        try {
            jSONObject.put("refresh_control", this.n);
            jSONObject.put("refresh_imp_max_time", this.qg);
            jSONObject.put("refresh_num", this.s);
        } catch (JSONException unused) {
        }
    }

    public static boolean n(pk pkVar) {
        ur urVarNq;
        return (pkVar == null || (urVarNq = pkVar.nq()) == null || urVarNq.n() != 1) ? false : true;
    }

    public int n() {
        return this.n;
    }

    public long qg() {
        return this.qg;
    }

    public int s() {
        return this.s;
    }

    public static int qg(pk pkVar) {
        ur urVarNq;
        if (pkVar == null || (urVarNq = pkVar.nq()) == null) {
            return 0;
        }
        return urVarNq.s();
    }

    public static boolean n(List<pk> list) {
        Iterator<pk> it = list.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            if (it.next().sl() == 100.0f) {
                z = true;
            } else {
                z2 = true;
            }
        }
        return (z && z2) ? false : true;
    }

    public static boolean s(pk pkVar) {
        return com.byazt.nf.rv.qg().k(String.valueOf(com.byazt.vgx.w.cy(pkVar))) && n(pkVar) && !com.byazt.wd.x.n(String.valueOf(com.byazt.vgx.w.cy(pkVar)));
    }
}
