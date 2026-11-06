package com.byazt.pa;

import android.text.TextUtils;
import com.byazt.hcx.aj;
import com.byazt.hcx.m;
import com.byazt.mg.PluginConstants;
import com.byazt.nn.fw;
import com.byazt.vkw.g;
import com.byazt.vkw.k;
import com.byazt.vkw.nt;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends pr {
    public c(com.byazt.vkw.pr prVar, com.byazt.hh.hw hwVar, k kVar, g gVar, com.byazt.hh.c cVar) {
        super(prVar, hwVar, kVar, gVar, cVar);
    }

    @Override // com.byazt.pa.pr
    public com.byazt.mqu.pr pr(List<com.byazt.hh.pr> list) {
        boolean z;
        String strHw;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<com.byazt.hh.pr> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().pr());
            }
            jSONObject.put("stats_list", jSONArray);
        } catch (Exception e) {
            fw.pr("_error", "uploadEvent", e);
        }
        com.byazt.hh.hn hnVarPr = this.hn.pr();
        if (hnVarPr == null || !hnVarPr.hw()) {
            return null;
        }
        aj ajVarUc = com.byazt.nn.x.uc(this.c.x());
        int iHw = hw();
        byte[] bArrPr = pr(jSONObject, iHw);
        if (bArrPr == null) {
            JSONObject jSONObjectPr = pr(jSONObject.toString());
            if (jSONObjectPr == null) {
                return null;
            }
            ajVarUc.pr(jSONObjectPr);
        } else {
            ajVarUc.pr(pr(iHw), bArrPr);
            ajVarUc.pr("x-pglcypher", String.valueOf(iHw));
        }
        boolean z2 = false;
        ajVarUc.pr("User-Agent", this.uc.hw(false));
        String strOptString = "error unknown";
        try {
            m mVarPr = ajVarUc.pr();
            if (mVarPr == null) {
                return new com.byazt.av.pr(false, 0, "error unknown", false, "ignore");
            }
            if (mVarPr.fw() && !TextUtils.isEmpty(mVarPr.zo())) {
                JSONObject jSONObject2 = new JSONObject(mVarPr.zo());
                int iOptInt = jSONObject2.optInt(PluginConstants.KEY_ERROR_CODE, -1);
                strOptString = jSONObject2.optString("data", "");
                boolean z3 = iOptInt == 20000;
                if (iOptInt != 60005) {
                    z = false;
                    z2 = z3;
                } else {
                    z2 = z3;
                    z = true;
                }
            } else {
                z = false;
            }
            int iPr = mVarPr.pr();
            if (mVarPr.fw()) {
                strHw = strOptString;
            } else {
                strHw = mVarPr.hw();
            }
            return new com.byazt.av.pr(z2, iPr, strHw, z, "ignore", mVarPr.w());
        } catch (Throwable th) {
            return new com.byazt.av.pr(false, 511, th.getMessage(), false, "ignore", th);
        }
    }

    public byte[] pr(JSONObject jSONObject, int i) {
        byte[] bArrHn = hn(jSONObject);
        nt ntVar = (nt) uc.pr("encrypt_service");
        if (bArrHn != null && ntVar != null && ntVar.hw() && i > 3) {
            byte[] bArrPr = ntVar.pr(bArrHn);
            if (bArrPr != null) {
                return bArrPr;
            }
            int iHn = ntVar.hn();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(Constants.ERROR_CODE_FIELD, 3);
                jSONObject2.put("cost_time", -1);
                jSONObject2.put("type", "stats");
                jSONObject2.put("armor_load_status", iHn);
                this.hn.pr().pr(jSONObject2);
                return bArrPr;
            } catch (Exception e) {
                return bArrPr;
            }
        }
        return null;
    }
}
