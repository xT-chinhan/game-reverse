package com.byazt.tki;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1549, 5})
public class uc extends yb {
    public uc() {
        super(com.byazt.yiq.hn.GT);
    }

    @Override // com.byazt.awu.pr
    public Object pr(Map<String, JSONObject> map) {
        Object objPr;
        Object objPr2 = this.pr.pr(map);
        if (objPr2 == null || (objPr = this.hw.pr(map)) == null) {
            return null;
        }
        return com.byazt.qc.hn.pr(objPr2, (Number) objPr);
    }
}
