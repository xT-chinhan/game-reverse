package com.byazt.tki;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1549, 74})
public class nt implements com.byazt.awu.pr {
    public final com.byazt.yiq.hn pr;

    public nt(com.byazt.yiq.hn hnVar) {
        this.pr = hnVar;
    }

    @Override // com.byazt.awu.pr
    public Object pr(Map<String, JSONObject> map) {
        throw new UnsupportedOperationException();
    }

    @Override // com.byazt.awu.pr
    public com.byazt.yiq.c pr() {
        return this.pr;
    }

    @Override // com.byazt.awu.pr
    public String hw() {
        return this.pr.pr();
    }

    public String toString() {
        return hw();
    }
}
