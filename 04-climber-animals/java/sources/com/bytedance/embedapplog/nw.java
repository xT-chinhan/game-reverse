package com.bytedance.embedapplog;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class nw extends t {
    @Override // com.bytedance.embedapplog.t
    String d() {
        return "c";
    }

    nw(b bVar) {
        super(bVar);
    }

    @Override // com.bytedance.embedapplog.t
    long ms() {
        return this.f525ms.d().ab() + 21600000;
    }

    @Override // com.bytedance.embedapplog.t
    long[] xr() {
        return re.ah;
    }

    @Override // com.bytedance.embedapplog.t
    public boolean ah() throws JSONException {
        JSONObject jSONObjectMs = this.f525ms.ka().ms();
        if (this.f525ms.ka().hi() == 0 || jSONObjectMs == null || this.f525ms.d().ab() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", jSONObjectMs);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject jSONObjectXr = am.xr(am.ms(sa.ms(this.f525ms.xr(), this.f525ms.ka().ms(), this.f525ms.x().ah(), true, ms.d()), am.ah), jSONObject);
        ms.hi().ms(!zd.ms(jSONObjectXr, this.f525ms.d().c()), jSONObjectXr);
        if (jSONObjectXr == null) {
            return false;
        }
        this.f525ms.d().ms(jSONObjectXr);
        return true;
    }
}
