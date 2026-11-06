package com.byazt.zvd;

import com.byazt.si.cd;
import com.byazt.si.d;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1640, 26})
public class qg {
    public static cd n() {
        return new cd() { // from class: com.byazt.zvd.qg.1
            public WeakHashMap<String, String> n = new WeakHashMap<>();

            @Override // com.byazt.si.cd
            public String n(d dVar) {
                return n(dVar.qg() + "#width=" + dVar.s() + "#height=" + dVar.q() + "#scaletype=" + dVar.l() + "#bitmapConfig=" + dVar.fs());
            }

            @Override // com.byazt.si.cd
            public String qg(d dVar) {
                return n(dVar.qg());
            }

            private String n(String str) {
                String str2 = this.n.get(str);
                if (str2 != null) {
                    return str2;
                }
                String strN = com.byazt.wvr.s.n(str);
                this.n.put(str, strN);
                return strN;
            }
        };
    }
}
