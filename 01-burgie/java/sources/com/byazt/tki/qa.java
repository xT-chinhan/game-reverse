package com.byazt.tki;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1549, 101})
public class qa implements com.byazt.awu.hw {
    public com.byazt.awu.pr hn;
    public com.byazt.awu.pr hw;
    public com.byazt.awu.pr pr;

    @Override // com.byazt.awu.pr
    public Object pr(Map<String, JSONObject> map) {
        if (!pr(this.pr.pr(map))) {
            return this.hn.pr(map);
        }
        return this.hw.pr(map);
    }

    private boolean pr(Object obj) {
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

    @Override // com.byazt.awu.pr
    public com.byazt.yiq.c pr() {
        return com.byazt.yiq.uc.OPERATOR_RESULT;
    }

    @Override // com.byazt.awu.hw
    public void pr(com.byazt.awu.pr prVar) {
        this.pr = prVar;
    }

    @Override // com.byazt.awu.hw
    public void hw(com.byazt.awu.pr prVar) {
        this.hw = prVar;
    }

    @Override // com.byazt.awu.hw
    public void hn(com.byazt.awu.pr prVar) {
        this.hn = prVar;
    }

    @Override // com.byazt.awu.pr
    public String hw() {
        return this.pr.hw() + "?" + this.hw.hw() + ":" + this.hn.hw();
    }

    public String toString() {
        return hw();
    }
}
