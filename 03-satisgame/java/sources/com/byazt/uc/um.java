package com.byazt.uc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, 33})
public class um implements com.byazt.uk.qg {
    public com.byazt.uk.n n;
    public com.byazt.uk.n qg;
    public com.byazt.uk.n s;

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        if (!n(this.n.n(map))) {
            return this.s.n(map);
        }
        return this.qg.n(map);
    }

    private boolean n(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof String) {
            return !((String) obj).isEmpty();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return (obj instanceof Number) && ((Number) obj).doubleValue() != 0.0d;
    }

    @Override // com.byazt.uk.n
    public com.byazt.mn.l n() {
        return com.byazt.mn.w.OPERATOR_RESULT;
    }

    @Override // com.byazt.uk.qg
    public void n(com.byazt.uk.n nVar) {
        this.n = nVar;
    }

    @Override // com.byazt.uk.qg
    public void qg(com.byazt.uk.n nVar) {
        this.qg = nVar;
    }

    @Override // com.byazt.uk.qg
    public void s(com.byazt.uk.n nVar) {
        this.s = nVar;
    }

    @Override // com.byazt.uk.n
    public String qg() {
        return this.n.qg() + "?" + this.qg.qg() + ":" + this.s.qg();
    }

    public String toString() {
        return qg();
    }
}
