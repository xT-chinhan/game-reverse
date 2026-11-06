package com.byazt.uc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, 18})
public class l extends hd {
    public l() {
        super(com.byazt.mn.s.GT_EQ);
    }

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        Object objN;
        Object objN2 = this.n.n(map);
        if (objN2 == null || (objN = this.qg.n(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.byazt.qh.q.n(objN2, (Number) objN)).booleanValue());
    }
}
