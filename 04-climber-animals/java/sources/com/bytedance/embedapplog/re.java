package com.bytedance.embedapplog;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class re extends t {
    private boolean ka;
    static final long[] xr = {920000};
    static final long[] ah = {920000};
    private static final long[] d = {ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 20000, 20000, 60000, 6000, 180000, 180000, 540000, 540000};

    @Override // com.bytedance.embedapplog.t
    String d() {
        return com.kuaishou.weapon.p0.t.k;
    }

    re(b bVar) {
        super(bVar);
        this.ka = true;
    }

    @Override // com.bytedance.embedapplog.t
    long ms() {
        return this.f525ms.ka().sl() + ((long) (this.f525ms.ab().ah() ? 21600000 : 43200000));
    }

    @Override // com.bytedance.embedapplog.t
    long[] xr() {
        int iHi = this.f525ms.ka().hi();
        if (iHi == 0) {
            return d;
        }
        if (iHi == 1) {
            return ah;
        }
        if (iHi == 2) {
            return xr;
        }
        oh.xr((Throwable) null);
        return ah;
    }

    @Override // com.bytedance.embedapplog.t
    boolean ah() throws JSONException {
        JSONObject jSONObjectMs;
        JSONObject jSONObject = new JSONObject();
        jw jwVarKa = this.f525ms.ka();
        JSONObject jSONObjectMs2 = jwVarKa.ms();
        if (jSONObjectMs2 != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            synchronized (jwVarKa) {
                jSONObjectMs = zd.ms(jSONObjectMs2);
            }
            jSONObject.put("header", jSONObjectMs);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            if (!TextUtils.isEmpty(jSONObjectMs.optString("device_id")) && zd.d() && this.ka) {
                this.ka = false;
                return false;
            }
            JSONObject jSONObjectMs3 = am.ms(sa.ms(this.f525ms.xr(), this.f525ms.ka().ms(), this.f525ms.x().ms(), true, ms.d()), jSONObject);
            if (jSONObjectMs3 != null) {
                return this.f525ms.ka().ms(jSONObjectMs3, jSONObjectMs3.optString("device_id", ""), jSONObjectMs3.optString("install_id", ""), jSONObjectMs3.optString("ssid", ""));
            }
        } else {
            oh.xr((Throwable) null);
        }
        return false;
    }
}
