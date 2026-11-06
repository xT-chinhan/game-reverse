package com.byazt.msp;

import android.text.TextUtils;
import com.byazt.gct.fs;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 107, 13})
public class w {
    public static final Map<String, n> n = new ConcurrentHashMap();

    public static n n(String str, fs.l lVar) {
        if (TextUtils.isEmpty(str)) {
            return new n(lVar);
        }
        Map<String, n> map = n;
        n nVar = map.get(str);
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(lVar);
        map.put(str, nVar2);
        return nVar2;
    }

    @com.byazt.cp.n(n = {0, 1, 107, 108})
    public static class n {
        public final int n;

        public n(fs.l lVar) {
            this.n = lVar.x();
        }

        public int n(int i, fs.l lVar) {
            int i2 = this.n - i;
            if (i2 < 0) {
                return 0;
            }
            LinkedHashMap<Integer, Integer> linkedHashMapW = lVar.w();
            int i3 = -1;
            if (linkedHashMapW == null) {
                return -1;
            }
            for (Map.Entry<Integer, Integer> entry : linkedHashMapW.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                if (entry.getValue().intValue() + i2 <= 0 && iIntValue > i3) {
                    i3 = iIntValue;
                }
            }
            return i3;
        }

        public void n(final int i, final com.byazt.zq.qg qgVar, final fs.l lVar, final String str, final String str2) {
            com.byazt.eji.s.n().n("load_score_cache", new com.byazt.rs.n() { // from class: com.byazt.msp.w.n.1
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("slot_type", Integer.valueOf(i));
                    jSONObject2.putOpt("rit", qgVar.q());
                    jSONObject2.putOpt(MediationConstant.KEY_REASON, str);
                    jSONObject2.putOpt("reason_value", str2);
                    jSONObject2.putOpt("score", Integer.valueOf(n.this.n));
                    jSONObject2.putOpt("score_threshold", Integer.valueOf(lVar.q()));
                    return jSONObject2;
                }
            });
        }
    }
}
