package com.byazt.uc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, 866})
public class py implements com.byazt.uk.n {
    public com.byazt.mn.q n;

    public py(com.byazt.mn.q qVar) {
        this.n = qVar;
    }

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        throw new UnsupportedOperationException();
    }

    @Override // com.byazt.uk.n
    public com.byazt.mn.l n() {
        return this.n;
    }

    public String toString() {
        return qg();
    }

    @Override // com.byazt.uk.n
    public String qg() {
        return this.n.n();
    }
}
