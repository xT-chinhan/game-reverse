package com.bytedance.sdk.openadsdk.xr;

import com.bytedance.sdk.component.utils.sl;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private String ah;
    private long d;
    private long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f4305ms;
    private String xr;

    public ms(JSONObject jSONObject) {
        this.f4305ms = jSONObject.optLong("cid");
        this.xr = jSONObject.optString("url");
        this.ah = jSONObject.optString("file_hash");
        this.d = jSONObject.optLong("effective_time");
        this.ka = jSONObject.optLong("expiration_time");
    }

    public String ms() {
        return this.xr;
    }

    public String xr() {
        return this.ah;
    }

    public long ah() {
        return this.d;
    }

    public boolean d() {
        return System.currentTimeMillis() >= this.ka;
    }

    public long ms(String str) {
        File file = new File(str, this.ah);
        if (file.exists()) {
            return file.lastModified();
        }
        return System.currentTimeMillis();
    }

    public JSONObject ka() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.f4305ms);
            jSONObject.put("url", this.xr);
            jSONObject.put("file_hash", this.ah);
            jSONObject.put("effective_time", this.d);
            jSONObject.put("expiration_time", this.ka);
        } catch (Exception e) {
            sl.xr("BrandVideo", e.getMessage());
        }
        return jSONObject;
    }

    public boolean xr(String str) {
        File file = new File(str, this.ah);
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
