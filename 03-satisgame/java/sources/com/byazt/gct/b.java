package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 225})
public class b {
    public int n;

    public b(JSONObject jSONObject) {
        this.n = 0;
        if (jSONObject == null) {
            return;
        }
        this.n = jSONObject.optInt("playable_reward_type", 0);
    }

    public void n(JSONObject jSONObject) {
        try {
            jSONObject.put("playable_reward_type", this.n);
        } catch (JSONException unused) {
        }
    }

    private static b s(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.o();
    }

    public static int n(pk pkVar) {
        int i;
        b bVarS = s(pkVar);
        if (bVarS == null || (i = bVarS.n) < 0 || i > 1) {
            return 0;
        }
        if (!TextUtils.isEmpty(com.byazt.nf.rv.qg().dn()) || cd.oa(pkVar)) {
            return bVarS.n;
        }
        return 1;
    }

    public static int qg(pk pkVar) {
        com.byazt.zsl.s sVarSz = ta.sz(pkVar);
        String strRv = sVarSz != null ? sVarSz.rv() : null;
        try {
            if (TextUtils.isEmpty(strRv)) {
                return 0;
            }
            String[] strArrSplit = strRv.split(com.byazt.af.x.n);
            if (strArrSplit.length >= 2 && Integer.parseInt(strArrSplit[0]) > Integer.parseInt(strArrSplit[1])) {
                return 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }
}
