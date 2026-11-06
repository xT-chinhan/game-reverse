package com.byazt.qu;

import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1011, 37})
public class pr {
    public long c;
    public String hn;
    public String hw;
    public long pr;
    public long x;

    public pr(JSONObject jSONObject) {
        this.pr = jSONObject.optLong("cid");
        this.hw = jSONObject.optString(BreakpointSQLiteKey.URL);
        this.hn = jSONObject.optString("file_hash");
        this.x = jSONObject.optLong("effective_time");
        this.c = jSONObject.optLong("expiration_time");
    }

    public String pr() {
        return this.hw;
    }

    public String hw() {
        return this.hn;
    }

    public long hn() {
        return this.x;
    }

    public boolean x() {
        return System.currentTimeMillis() >= this.c;
    }

    public long pr(String str) {
        File file = new File(str, this.hn);
        if (file.exists()) {
            return file.lastModified();
        }
        return System.currentTimeMillis();
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.pr);
            jSONObject.put(BreakpointSQLiteKey.URL, this.hw);
            jSONObject.put("file_hash", this.hn);
            jSONObject.put("effective_time", this.x);
            jSONObject.put("expiration_time", this.c);
        } catch (Exception e) {
            e.getMessage();
        }
        return jSONObject;
    }

    public boolean hw(String str) {
        File file = new File(str, this.hn);
        if (file.exists()) {
            try {
                return file.delete();
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
