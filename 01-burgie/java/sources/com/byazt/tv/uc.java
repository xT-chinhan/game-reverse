package com.byazt.tv;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1488, 5})
public class uc {
    public JSONObject hn;
    public String hw;
    public final int pr;

    public uc(int i) {
        this.pr = i;
    }

    public uc(int i, Throwable th) {
        this.pr = i;
        if (th != null) {
            this.hw = th.getMessage();
        }
    }

    public uc(int i, String str) {
        this.pr = i;
        this.hw = str;
    }

    public uc(int i, JSONObject jSONObject) {
        this.pr = i;
        this.hn = jSONObject;
    }

    public boolean pr() {
        return this.pr == 0;
    }
}
