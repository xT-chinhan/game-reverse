package com.byazt.uc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, 26})
public class qg extends hd {
    public qg() {
        super(com.byazt.mn.s.DOUBLE_AMP);
    }

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        return Boolean.valueOf(com.byazt.dr.qg.n(this.n.n(map)) && com.byazt.dr.qg.n(this.qg.n(map)));
    }

    @Override // com.byazt.uc.hd
    public String toString() {
        return qg();
    }
}
