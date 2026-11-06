package com.byazt.qs;

import com.byazt.dd.c;
import com.byazt.dd.nt;
import com.byazt.wg.x;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 670, 20})
public class hn implements x {
    public final nt pr;

    public hn(nt ntVar) {
        this.pr = ntVar;
    }

    @Override // com.byazt.wg.x
    public void pr(String str, String str2, Map<String, Object> map, com.byazt.wg.hw hwVar) {
        nt ntVar = this.pr;
        if (ntVar == null) {
            com.byazt.wk.pr.pr("node_create_failed");
        } else {
            ntVar.pr(str, str2, "", pr(map), pr(hwVar));
        }
    }

    private static Map<String, Object> pr(Map<String, Object> map) {
        HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        if (!map2.containsKey("framework")) {
            map2.put("framework", "uttie");
        }
        return map2;
    }

    private c pr(final com.byazt.wg.hw hwVar) {
        if (hwVar == null) {
            return null;
        }
        return new c() { // from class: com.byazt.qs.hn.1
            @Override // com.byazt.dd.c
            public void pr() {
                hwVar.pr();
            }
        };
    }
}
