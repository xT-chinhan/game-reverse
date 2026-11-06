package com.byazt.tki;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1549, 48})
public class lb extends yb {
    public static final ThreadLocal<StringBuilder> x = new ThreadLocal<StringBuilder>() { // from class: com.byazt.tki.lb.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public lb() {
        super(com.byazt.yiq.hn.PLUS);
    }

    @Override // com.byazt.awu.pr
    public Object pr(Map<String, JSONObject> map) {
        Object objPr;
        Object objPr2 = this.pr.pr(map);
        if (objPr2 == null || (objPr = this.hw.pr(map)) == null) {
            return null;
        }
        if ((objPr2 instanceof String) || (objPr instanceof String)) {
            StringBuilder sb = x.get();
            sb.append(objPr2).append(objPr);
            String string = sb.toString();
            sb.setLength(0);
            return string;
        }
        return com.byazt.qc.zo.pr((Number) objPr2, (Number) objPr);
    }
}
