package com.byazt.uc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, 101})
public class fs extends hd {
    public fs() {
        super(com.byazt.mn.s.LT_EQ);
    }

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        Object objN;
        Object objN2 = this.n.n(map);
        if (objN2 == null || (objN = this.qg.n(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.byazt.qh.s.n(objN2, (Number) objN)).booleanValue());
    }
}
