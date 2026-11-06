package com.byazt.mj;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1996, 37})
public class pr {
    public volatile Map<String, hn> pr = new HashMap();

    public hn pr(String str) {
        if (this.pr.containsKey(str) && this.pr.get(str) != null) {
            return this.pr.get(str);
        }
        hw hwVar = new hw();
        this.pr.put(str, hwVar);
        return hwVar;
    }

    public void pr(String str, hn hnVar) {
        if (this.pr.containsKey(str) && this.pr.get(str) != null) {
            return;
        }
        this.pr.put(str, hnVar);
    }
}
