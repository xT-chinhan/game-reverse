package com.byazt.od;

import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, 74})
@com.byazt.qa.hw
public class nt implements com.byazt.lf.hn {

    @com.byazt.qa.pr(hw = "ALL", pr = "material_meta")
    public of hn;

    @com.byazt.qa.pr(hw = "ALL", pr = "log_extra")
    public String hw;

    @com.byazt.qa.pr(hw = "ALL", pr = "type")
    public String pr;

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        if (!pr()) {
            com.byazt.ca.ho.hw("UChain_ReportStatsAction", "ifHasAllRequiredParam = false");
            prVar.pr(map2, (com.byazt.rs.pr) null);
            return false;
        }
        final JSONObject jSONObjectPr = pr(map);
        com.byazt.xk.hw.pr().pr(this.pr, null, null, null, ls.k(this.hn), null, this.hw, null, null, 0, new com.byazt.ttf.pr() { // from class: com.byazt.od.nt.1
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                return jSONObjectPr;
            }
        });
        prVar.pr(map2);
        return true;
    }

    private JSONObject pr(Map<String, Object> map) {
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
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    private boolean pr() {
        return (TextUtils.isEmpty(this.pr) || TextUtils.isEmpty(this.hw)) ? false : true;
    }
}
