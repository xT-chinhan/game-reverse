package com.byazt.bv;

import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1536, 19})
public class n {
    public long l;
    public long n;
    public long q;
    public String qg;
    public String s;

    public n(JSONObject jSONObject) {
        this.n = jSONObject.optLong("cid");
        this.qg = jSONObject.optString(ImagesContract.URL);
        this.s = jSONObject.optString("file_hash");
        this.q = jSONObject.optLong("effective_time");
        this.l = jSONObject.optLong("expiration_time");
    }

    public String n() {
        return this.qg;
    }

    public String qg() {
        return this.s;
    }

    public long s() {
        return this.q;
    }

    public boolean q() {
        return System.currentTimeMillis() >= this.l;
    }

    public long n(String str) {
        File file = new File(str, this.s);
        if (file.exists()) {
            return file.lastModified();
        }
        return System.currentTimeMillis();
    }

    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.n);
            jSONObject.put(ImagesContract.URL, this.qg);
            jSONObject.put("file_hash", this.s);
            jSONObject.put("effective_time", this.q);
            jSONObject.put("expiration_time", this.l);
        } catch (Exception e) {
            e.getMessage();
        }
        return jSONObject;
    }

    public boolean qg(String str) {
        File file = new File(str, this.s);
        if (!file.exists()) {
            return false;
        }
        try {
            return file.delete();
        } catch (Exception unused) {
            return false;
        }
    }
}
