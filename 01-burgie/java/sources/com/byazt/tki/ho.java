package com.byazt.tki;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1549, 19})
public class ho implements com.byazt.awu.pr {
    public Number pr;

    public ho(String str) {
        if (str.indexOf(46) >= 0) {
            Float fValueOf = Float.valueOf(str);
            this.pr = fValueOf;
            if (Float.isInfinite(fValueOf.floatValue())) {
                this.pr = Double.valueOf(str);
                return;
            }
            return;
        }
        try {
            this.pr = Integer.valueOf(str);
        } catch (NumberFormatException e) {
            this.pr = Long.valueOf(str);
        }
    }

    @Override // com.byazt.awu.pr
    public Object pr(Map<String, JSONObject> map) {
        return this.pr;
    }

    @Override // com.byazt.awu.pr
    public com.byazt.yiq.c pr() {
        return com.byazt.yiq.uc.NUMBER;
    }

    @Override // com.byazt.awu.pr
    public String hw() {
        return this.pr.toString();
    }

    public String toString() {
        return hw();
    }
}
