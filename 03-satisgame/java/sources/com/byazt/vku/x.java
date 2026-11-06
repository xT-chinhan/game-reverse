package com.byazt.vku;

import android.text.TextUtils;
import com.byazt.tk.k;
import com.byazt.wr.fs;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, 21})
public class x implements com.byazt.jjq.s {
    public final com.byazt.llp.w n = new com.byazt.llp.w();

    @Override // com.byazt.jjq.s
    public boolean n(final Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        com.byazt.ukb.qg.n(this.n, nVar.s(), map, map2);
        if (!n()) {
            k.qg("UChain_ReportStatsAction", "ifHasAllRequiredParam = false");
            com.byazt.ukb.qg.n(map2, fs.q);
            nVar.qg(map2, null);
            return false;
        }
        final int iD = com.byazt.vgx.w.d(com.byazt.ukb.qg.n(this.n, map2));
        com.byazt.eji.s.n().n(new com.byazt.rs.n() { // from class: com.byazt.vku.x.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                jSONObject.put("extra", x.this.n.s());
                jSONObject.put("adtype", iD);
                return x.this.n((Map<String, Object>) map);
            }
        }, this.n.qg());
        com.byazt.ukb.qg.n(map2, fs.s);
        nVar.qg(map2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject n(Map<String, Object> map) {
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
        return !TextUtils.isEmpty(this.n.qg());
    }
}
