package com.byazt.ih;

import com.byazt.ld.k;
import com.byazt.ld.lb;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1059, 13})
public class hw {
    public static lb pr() {
        return new lb() { // from class: com.byazt.ih.hw.1
            public WeakHashMap<String, String> pr = new WeakHashMap<>();

            @Override // com.byazt.ld.lb
            public String pr(k kVar) {
                return pr(kVar.hw() + "#width=" + kVar.hn() + "#height=" + kVar.x() + "#scaletype=" + kVar.c() + "#bitmapConfig=" + kVar.zo());
            }

            @Override // com.byazt.ld.lb
            public String hw(k kVar) {
                return pr(kVar.hw());
            }

            private String pr(String str) {
                String str2 = this.pr.get(str);
                if (str2 == null) {
                    String strPr = com.byazt.cb.hn.pr(str);
                    this.pr.put(str, strPr);
                    return strPr;
                }
                return str2;
            }
        };
    }
}
