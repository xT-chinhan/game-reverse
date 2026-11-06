package com.byazt.vku;

import android.text.TextUtils;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, 13})
public class w implements com.byazt.jjq.s {
    public final com.byazt.llp.l n = new com.byazt.llp.l();

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        com.byazt.ukb.qg.n(this.n, nVar.s(), map, map2);
        if (!qg(map2)) {
            k.qg("UChain_ReportEventAction", "ifHasAllRequiredParam = false");
            com.byazt.ukb.qg.n(map2, com.byazt.wr.x.q);
            nVar.qg(map2, null);
            return false;
        }
        JSONObject jSONObjectN = n(map);
        String strS = this.n.s();
        if (TextUtils.isEmpty(strS)) {
            strS = com.byazt.vgx.w.qg(com.byazt.ukb.qg.n(this.n, map2));
        }
        com.byazt.hm.n.qg(com.byazt.ukb.qg.n(this.n, map2), strS, this.n.qg(), jSONObjectN);
        com.byazt.ukb.qg.n(map2, com.byazt.wr.x.s);
        nVar.qg(map2);
        return true;
    }

    private JSONObject n(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add("label");
            hashSet.add(MediationConstant.EXTRA_ADID);
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

    private boolean qg(Map<String, Object> map) {
        return (TextUtils.isEmpty(this.n.qg()) || com.byazt.ukb.qg.n(this.n, map) == null) ? false : true;
    }
}
