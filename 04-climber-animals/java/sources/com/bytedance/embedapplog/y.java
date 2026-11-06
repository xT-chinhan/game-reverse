package com.bytedance.embedapplog;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class y extends t {
    private long xr;

    @Override // com.bytedance.embedapplog.t
    String d() {
        return "ab";
    }

    y(b bVar) {
        super(bVar);
    }

    @Override // com.bytedance.embedapplog.t
    long ms() {
        long jQv = this.f525ms.d().qv();
        if (jQv < 600000) {
            jQv = 600000;
        }
        return this.xr + jQv;
    }

    @Override // com.bytedance.embedapplog.t
    long[] xr() {
        return re.ah;
    }

    @Override // com.bytedance.embedapplog.t
    boolean ah() throws JSONException {
        JSONObject jSONObjectMs = this.f525ms.ka().ms();
        if (this.f525ms.ka().hi() == 0 || jSONObjectMs == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.f525ms.ka().ms());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", jCurrentTimeMillis);
        JSONObject jSONObjectAh = am.ah(am.ms(sa.ms(this.f525ms.xr(), this.f525ms.ka().ms(), this.f525ms.x().d(), true, ms.d()), am.ah), jSONObject);
        if (jSONObjectAh == null) {
            return false;
        }
        ms.hi().xr(!zd.ms(ms.c(), jSONObjectAh), jSONObjectAh);
        if (oh.xr) {
            oh.ms("getAbConfig ".concat(String.valueOf(jSONObjectAh)), null);
        }
        this.f525ms.ka().ms(jSONObjectAh);
        this.xr = jCurrentTimeMillis;
        return true;
    }
}
