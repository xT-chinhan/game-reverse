package com.byazt.sj;

import com.byazt.gct.bb;
import com.byazt.gct.g;
import com.byazt.gct.pk;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 83, 5})
public class q {
    public static void n(pk pkVar, int i) {
        if (pkVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("game_click_area", "play_area");
            jSONObject.put("playable_session_id", n(pkVar));
            jSONObject.put("ugen_id", qg(pkVar));
            jSONObject.put("click_count", i);
        } catch (Throwable unused) {
        }
        com.byazt.hm.n.n(pkVar, "game_page_click", jSONObject);
    }

    private static String n(pk pkVar) {
        Map<String, Object> mapWl = pkVar.wl();
        Object obj = mapWl != null ? mapWl.get("request_id") : null;
        return obj != null ? String.valueOf(obj) : "";
    }

    private static String qg(pk pkVar) {
        bb bbVarTk = pkVar.tk();
        g gVarN = bbVarTk != null ? bbVarTk.n() : null;
        return gVarN != null ? gVarN.l() : "";
    }
}
