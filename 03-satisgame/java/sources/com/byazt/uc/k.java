package com.byazt.uc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, 210})
public class k implements com.byazt.uk.n {
    public Number n;

    public k(String str) {
        if (str.indexOf(46) >= 0) {
            Float fValueOf = Float.valueOf(str);
            this.n = fValueOf;
            if (Float.isInfinite(fValueOf.floatValue())) {
                this.n = Double.valueOf(str);
                return;
            }
            return;
        }
        try {
            this.n = Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            this.n = Long.valueOf(str);
        }
    }

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        return this.n;
    }

    @Override // com.byazt.uk.n
    public com.byazt.mn.l n() {
        return com.byazt.mn.w.NUMBER;
    }

    @Override // com.byazt.uk.n
    public String qg() {
        return this.n.toString();
    }

    public String toString() {
        return qg();
    }
}
