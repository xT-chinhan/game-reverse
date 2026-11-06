package com.byazt.lbp;

import android.text.TextUtils;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 579, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy implements com.byazt.jjq.s {

    @com.byazt.phr.n(n = "type", qg = "ALL")
    public String n;

    @com.byazt.phr.n(n = "log_extra", qg = "ALL")
    public String qg;

    @com.byazt.phr.n(n = "material_meta", qg = "ALL")
    public pk s;

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        if (!n()) {
            com.byazt.tk.k.qg("UChain_ReportStatsAction", "ifHasAllRequiredParam = false");
            nVar.n(map2, (com.byazt.bds.n) null);
            return false;
        }
        final JSONObject jSONObjectN = n(map);
        com.byazt.eji.s.n().n(this.n, null, null, null, com.byazt.vgx.w.d(this.s), null, this.qg, null, null, 0, new com.byazt.rs.n() { // from class: com.byazt.lbp.cy.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                return jSONObjectN;
            }
        });
        nVar.n(map2);
        return true;
    }

    private JSONObject n(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add("type");
            hashSet.add("log_extra");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!hashSet.contains(entry.getKey())) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private boolean n() {
        return (TextUtils.isEmpty(this.n) || TextUtils.isEmpty(this.qg)) ? false : true;
    }
}
