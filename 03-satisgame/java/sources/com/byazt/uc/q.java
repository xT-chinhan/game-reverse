package com.byazt.uc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, 5})
public class q extends hd {
    public q() {
        super(com.byazt.mn.s.EQ);
    }

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        Object objN = this.n.n(map);
        Object objN2 = this.qg.n(map);
        if (objN == null && objN2 == null) {
            return Boolean.TRUE;
        }
        if (objN == null && objN2 != null) {
            return Boolean.FALSE;
        }
        if (objN != null && objN2 == null) {
            return Boolean.FALSE;
        }
        if ((objN instanceof Number) && (objN2 instanceof Number)) {
            return Boolean.valueOf(com.byazt.qh.qg.n((Number) objN, (Number) objN2));
        }
        return Boolean.valueOf(objN.equals(objN2));
    }
}
