package com.byazt.uc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, 8})
public class s extends hd {
    public s() {
        super(com.byazt.mn.s.DOUBLE_BAR);
    }

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        return Boolean.valueOf(com.byazt.dr.qg.n(this.n.n(map)) || com.byazt.dr.qg.n(this.qg.n(map)));
    }

    @Override // com.byazt.uc.hd
    public String toString() {
        return qg();
    }
}
