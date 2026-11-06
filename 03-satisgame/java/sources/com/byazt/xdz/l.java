package com.byazt.xdz;

import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.hls.x;
import com.byazt.qk.rv;
import com.byazt.vf.cp;
import com.byazt.vf.k;
import com.byazt.vf.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.api.core.RequestParamsUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS, 18})
public class l extends n {
    public l(com.byazt.vf.n nVar, com.byazt.vr.qg qgVar, cp cpVar, oa oaVar, com.byazt.vr.l lVar) {
        super(nVar, qgVar, cpVar, oaVar, lVar);
    }

    @Override // com.byazt.xdz.n
    public com.byazt.zad.n n(List<com.byazt.vr.n> list) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<com.byazt.vr.n> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().n());
            }
            jSONObject.put("stats_list", jSONArray);
        } catch (Exception e) {
            x.n("_error", "uploadEvent", e);
        }
        com.byazt.vr.s sVarN = this.s.n();
        if (sVarN == null || !sVarN.qg()) {
            return null;
        }
        rv rvVarW = com.byazt.hls.q.w(this.l.q());
        int iQg = qg();
        byte[] bArrN = n(jSONObject, iQg);
        if (bArrN == null) {
            JSONObject jSONObjectN = n(jSONObject.toString());
            if (jSONObjectN == null) {
                return null;
            }
            rvVarW.n(jSONObjectN);
        } else {
            rvVarW.n(n(iQg), bArrN);
            rvVarW.n("x-pglcypher", String.valueOf(iQg));
        }
        boolean z2 = false;
        rvVarW.n(RequestParamsUtils.USER_AGENT_KEY, this.w.qg(false));
        String strOptString = "error unknown";
        try {
            com.byazt.qk.oa oaVarN = rvVarW.n();
            if (oaVarN == null) {
                return new com.byazt.jeb.n(false, 0, "error unknown", false, "ignore");
            }
            if (!oaVarN.x() || TextUtils.isEmpty(oaVarN.fs())) {
                z = false;
            } else {
                JSONObject jSONObject2 = new JSONObject(oaVarN.fs());
                int iOptInt = jSONObject2.optInt("code", -1);
                strOptString = jSONObject2.optString(f.R, "");
                boolean z3 = iOptInt == 20000;
                if (iOptInt == 60005) {
                    z2 = z3;
                    z = true;
                } else {
                    z = false;
                    z2 = z3;
                }
            }
            return new com.byazt.jeb.n(z2, oaVarN.n(), !oaVarN.x() ? oaVarN.qg() : strOptString, z, "ignore", oaVarN.cp());
        } catch (Throwable th) {
            return new com.byazt.jeb.n(false, 511, th.getMessage(), false, "ignore", th);
        }
    }

    public byte[] n(JSONObject jSONObject, int i) {
        byte[] bArrS = s(jSONObject);
        k kVar = (k) com.byazt.qp.q.n("encrypt_service");
        if (bArrS == null || kVar == null || !kVar.qg() || i <= 3) {
            return null;
        }
        byte[] bArrN = kVar.n(bArrS);
        if (bArrN != null) {
            return bArrN;
        }
        int iS = kVar.s();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("error_code", 3);
            jSONObject2.put("cost_time", -1);
            jSONObject2.put("type", "stats");
            jSONObject2.put("armor_load_status", iS);
            this.s.n().n(jSONObject2);
            return bArrN;
        } catch (Exception unused) {
            return bArrN;
        }
    }
}
