package com.byazt.lze;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.wb.zo;
import com.byazt.wt.ls;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 936, 62})
public class fw implements com.byazt.lf.hn {
    public final com.byazt.af.uc pr = new com.byazt.af.uc();

    @Override // com.byazt.lf.hn
    public boolean pr(final Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        com.byazt.lx.hw.pr(this.pr, prVar.hn(), map, map2);
        if (!pr()) {
            ho.hw("UChain_ReportStatsAction", "ifHasAllRequiredParam = false");
            com.byazt.lx.hw.pr(map2, zo.x);
            prVar.hw(map2, null);
            return false;
        }
        final int iK = ls.k(com.byazt.lx.hw.pr(this.pr, map2));
        com.byazt.xk.hw.pr().pr(new com.byazt.ttf.pr() { // from class: com.byazt.lze.fw.1
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                jSONObject.put("extra", fw.this.pr.hn());
                jSONObject.put("adtype", iK);
                return fw.this.pr((Map<String, Object>) map);
            }
        }, this.pr.hw());
        com.byazt.lx.hw.pr(map2, zo.hn);
        prVar.hw(map2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject pr(Map<String, Object> map) {
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
        return !TextUtils.isEmpty(this.pr.hw());
    }
}
