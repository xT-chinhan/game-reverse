package com.byazt.yo;

import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1051, 109})
public class w extends pr {
    public String c;
    public long hn;
    public long hw;
    public String pr;
    public String uc;
    public int x;

    public void pr(String str) {
        this.pr = str;
    }

    public void pr(long j) {
        this.hw = j;
    }

    public void hw(long j) {
        this.hn = j;
    }

    public void pr(int i) {
        this.x = i;
    }

    public void hw(String str) {
        this.c = str;
    }

    public void hn(String str) {
        this.uc = str;
    }

    @Override // com.byazt.yo.x
    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.pr);
            jSONObject.put("preload_size", this.hw);
            jSONObject.put("load_time", this.hn);
            jSONObject.put(Constants.ERROR_CODE_FIELD, this.x);
            jSONObject.put("error_message", this.c);
            jSONObject.put("error_message_server", this.uc);
        } catch (Throwable th) {
        }
    }
}
