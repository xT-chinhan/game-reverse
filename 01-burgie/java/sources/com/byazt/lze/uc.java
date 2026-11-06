package com.byazt.lze;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.wt.ls;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 936, 5})
public class uc implements com.byazt.lf.hn {
    public final com.byazt.af.c pr = new com.byazt.af.c();

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        com.byazt.lx.hw.pr(this.pr, prVar.hn(), map, map2);
        if (!hw(map2)) {
            ho.hw("UChain_ReportEventAction", "ifHasAllRequiredParam = false");
            com.byazt.lx.hw.pr(map2, com.byazt.wb.fw.x);
            prVar.hw(map2, null);
            return false;
        }
        JSONObject jSONObjectPr = pr(map);
        String strHn = this.pr.hn();
        if (TextUtils.isEmpty(strHn)) {
            strHn = ls.hw(com.byazt.lx.hw.pr(this.pr, map2));
        }
        com.byazt.pj.pr.hw(com.byazt.lx.hw.pr(this.pr, map2), strHn, this.pr.hw(), jSONObjectPr);
        com.byazt.lx.hw.pr(map2, com.byazt.wb.fw.hn);
        prVar.hw(map2);
        return true;
    }

    private JSONObject pr(Map<String, Object> map) {
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
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    private boolean hw(Map<String, Object> map) {
        return (TextUtils.isEmpty(this.pr.hw()) || com.byazt.lx.hw.pr(this.pr, map) == null) ? false : true;
    }
}
