package com.byazt.lbp;

import android.text.TextUtils;
import com.byazt.gct.pk;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 579, 210})
public class k implements com.byazt.jjq.s {

    @com.byazt.phr.n(n = "label", qg = "ALL")
    public String n;

    @com.byazt.phr.n(n = "log_extra", qg = "ALL")
    public String qg;

    @com.byazt.phr.n(n = "material_meta", qg = "ALL")
    public pk s;

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        if (!n()) {
            com.byazt.tk.k.qg("UChain_ReportEventAction", "ifHasAllRequiredParam = false");
            nVar.n(map2, (com.byazt.bds.n) null);
            return false;
        }
        JSONObject jSONObjectN = n(map);
        com.byazt.hm.n.qg(this.s, com.byazt.vgx.w.qg(this.s), this.n, jSONObjectN);
        nVar.n(map2);
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

    private boolean n() {
        return (TextUtils.isEmpty(this.n) || TextUtils.isEmpty(this.qg) || this.s == null) ? false : true;
    }
}
