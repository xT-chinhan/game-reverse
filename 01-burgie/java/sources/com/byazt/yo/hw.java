package com.byazt.yo;

import com.byazt.hg.of;
import com.byazt.yo.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1051, 13})
public class hw<T extends x> {
    public boolean c = false;
    public JSONObject hn;
    public String hw;
    public of pr;
    public T x;

    public hw(of ofVar, String str, JSONObject jSONObject, T t) {
        this.x = null;
        this.pr = ofVar;
        this.hw = str;
        this.hn = jSONObject;
        this.x = t;
    }

    public of pr() {
        return this.pr;
    }

    public String hw() {
        return this.hw;
    }

    public JSONObject hn() {
        if (this.hn == null) {
            this.hn = new JSONObject();
        }
        return this.hn;
    }

    public T x() {
        return this.x;
    }

    public boolean c() {
        return this.c;
    }

    public void pr(boolean z) {
        this.c = z;
    }
}
