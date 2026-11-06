package com.byazt.uc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, 86})
public class cd extends hd {
    public static final ThreadLocal<StringBuilder> q = new ThreadLocal<StringBuilder>() { // from class: com.byazt.uc.cd.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public cd() {
        super(com.byazt.mn.s.PLUS);
    }

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        Object objN;
        Object objN2 = this.n.n(map);
        if (objN2 == null || (objN = this.qg.n(map)) == null) {
            return null;
        }
        if ((objN2 instanceof String) || (objN instanceof String)) {
            StringBuilder sb = q.get();
            sb.append(objN2).append(objN);
            String string = sb.toString();
            sb.setLength(0);
            return string;
        }
        return com.byazt.qh.fs.n((Number) objN2, (Number) objN);
    }
}
