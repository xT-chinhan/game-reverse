package com.byazt.ra;

import android.text.TextUtils;
import com.byazt.hg.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, 5})
public class uc {
    public static final Map<String, pr> pr = new ConcurrentHashMap();

    public static pr pr(String str, zo.x xVar) {
        if (TextUtils.isEmpty(str)) {
            return new pr(xVar);
        }
        Map<String, pr> map = pr;
        pr prVar = map.get(str);
        if (prVar == null) {
            pr prVar2 = new pr(xVar);
            map.put(str, prVar2);
            return prVar2;
        }
        return prVar;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, 129})
    public static class pr {
        public final int pr;

        public pr(zo.x xVar) {
            this.pr = xVar.fw();
        }

        public int pr(int i, zo.x xVar) {
            int i2 = this.pr - i;
            if (i2 < 0) {
                return 0;
            }
            LinkedHashMap<Integer, Integer> linkedHashMapUc = xVar.uc();
            int i3 = -1;
            if (linkedHashMapUc == null) {
                return -1;
            }
            for (Map.Entry<Integer, Integer> entry : linkedHashMapUc.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                if (entry.getValue().intValue() + i2 <= 0 && iIntValue > i3) {
                    i3 = iIntValue;
                }
            }
            return i3;
        }

        public void pr(final int i, final com.byazt.qe.hw hwVar, final zo.x xVar, final String str, final String str2) {
            com.byazt.xk.hw.pr().pr("load_score_cache", new com.byazt.ttf.pr() { // from class: com.byazt.ra.uc.pr.1
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("slot_type", Integer.valueOf(i));
                    jSONObject2.putOpt("rit", hwVar.x());
                    jSONObject2.putOpt(MediationConstant.KEY_REASON, str);
                    jSONObject2.putOpt("reason_value", str2);
                    jSONObject2.putOpt("score", Integer.valueOf(pr.this.pr));
                    jSONObject2.putOpt("score_threshold", Integer.valueOf(xVar.x()));
                    return jSONObject2;
                }
            });
        }
    }
}
