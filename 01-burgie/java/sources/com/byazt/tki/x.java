package com.byazt.tki;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1549, 121})
public class x extends yb {
    public x() {
        super(com.byazt.yiq.hn.EQ);
    }

    @Override // com.byazt.awu.pr
    public Object pr(Map<String, JSONObject> map) {
        Object objPr = this.pr.pr(map);
        Object objPr2 = this.hw.pr(map);
        if (objPr == null && objPr2 == null) {
            return Boolean.TRUE;
        }
        if (objPr == null && objPr2 != null) {
            return Boolean.FALSE;
        }
        if (objPr != null && objPr2 == null) {
            return Boolean.FALSE;
        }
        if ((objPr instanceof Number) && (objPr2 instanceof Number)) {
            return Boolean.valueOf(com.byazt.qc.hw.pr((Number) objPr, (Number) objPr2));
        }
        return Boolean.valueOf(objPr.equals(objPr2));
    }
}
