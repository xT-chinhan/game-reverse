package com.byazt.gf;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.jy.fw;
import com.byazt.jy.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.z;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 20})
public class hn {
    public static volatile hn pr;
    public final ConcurrentHashMap<String, JSONObject> hw = new ConcurrentHashMap<>();

    private hn() {
    }

    public static hn pr() {
        if (pr == null) {
            synchronized (hn.class) {
                if (pr == null) {
                    pr = new hn();
                }
            }
        }
        return pr;
    }

    public JSONObject pr(String str, JSONObject jSONObject) {
        fw fwVarPr;
        if (TextUtils.isEmpty(str) || (fwVarPr = x.pr().pr(str)) == null) {
            return null;
        }
        try {
            return pr(fwVarPr, jSONObject);
        } catch (Throwable th) {
            ho.hw("Tme_TTStrategyCalCenter", "processStrategy error:" + th.toString());
            return null;
        }
    }

    private JSONObject pr(fw fwVar, JSONObject jSONObject) {
        if (fwVar == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        pr(fwVar, jSONObject, jSONObject2);
        JSONObject jSONObjectHw = hw(fwVar, jSONObject2);
        if (jSONObjectHw != null) {
            this.hw.put(fwVar.pr(), jSONObjectHw);
        }
        return jSONObjectHw;
    }

    private void pr(fw fwVar, JSONObject jSONObject, JSONObject jSONObject2) {
        Object objHw;
        List<zo> listHw = fwVar.hw();
        if (listHw == null || listHw.isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("params", jSONObject);
            jSONObject3.putOpt(z.a, com.byazt.uw.pr.pr());
            pr(jSONObject3, jSONObject2);
            pr(jSONObject3, pr.pr().hw());
            for (zo zoVar : listHw) {
                if (zoVar != null && !TextUtils.isEmpty(zoVar.hw()) && (objHw = hw(zoVar.pr(), jSONObject3)) != null) {
                    jSONObject2.putOpt(zoVar.hw(), objHw);
                    jSONObject3.putOpt(zoVar.hw(), objHw);
                }
            }
        } catch (Throwable th) {
            ho.hw("Tme_TTStrategyCalCenter", "executeFunctions error:" + th.toString());
        }
    }

    private JSONObject hw(fw fwVar, JSONObject jSONObject) {
        Object objHw;
        JSONObject jSONObject2 = new JSONObject();
        List<com.byazt.jy.hw> listHn = fwVar.hn();
        if (listHn == null || listHn.isEmpty()) {
            return jSONObject2;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("results", jSONObject);
            for (com.byazt.jy.hw hwVar : listHn) {
                if (hwVar != null && !TextUtils.isEmpty(hwVar.hw()) && (objHw = hw(hwVar.pr(), jSONObject3)) != null) {
                    jSONObject2.putOpt(hwVar.hw(), objHw);
                }
            }
        } catch (Throwable th) {
            ho.hw("Tme_TTStrategyCalCenter", "generateOutputs error:" + th.toString());
        }
        return jSONObject2;
    }

    private Object hw(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.byazt.oze.pr.pr(com.byazt.uw.hn.pr(str)).pr(jSONObject);
        } catch (Throwable th) {
            ho.hw("Tme_TTStrategyCalCenter", "calcEL error:" + str + " " + th.toString());
            return null;
        }
    }

    private void pr(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject.putOpt(next, jSONObject2.opt(next));
        }
    }
}
