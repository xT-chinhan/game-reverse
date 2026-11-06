package com.byazt.yt;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import com.byazt.vkw.g;
import com.qq.e.comm.pi.ACTD;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1312, 62})
public class fw extends x {
    public long aj;
    public String c;
    public com.byazt.ttf.pr fw;
    public long uc;
    public JSONObject vk;
    public com.byazt.hh.c zo;

    public fw(String str, JSONObject jSONObject) {
        super(str, jSONObject);
        if (jSONObject != null) {
            this.c = jSONObject.optString("type");
            this.uc = jSONObject.optLong("timestamp");
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("event_extra"));
                this.vk = jSONObject2;
                this.aj = jSONObject2.optLong("stats_index");
            } catch (Exception e) {
            }
        }
    }

    public fw(String str, com.byazt.hh.c cVar) {
        super(null, null);
        this.c = str;
        this.zo = cVar;
        this.aj = hn.sStatsEventIndex.incrementAndGet();
        this.uc = System.currentTimeMillis() / 1000;
    }

    @Override // com.byazt.yt.x
    public JSONObject pr(String str) {
        if (this.zo == null || this.hn == null) {
            return this.hw;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("type", this.c);
            jSONObject.putOpt(Constants.ERROR_CODE_FIELD, Integer.valueOf(jSONObject.optInt(Constants.ERROR_CODE_FIELD)));
            jSONObject.putOpt("ad_sdk_version", this.hn.cz());
            jSONObject.putOpt("app_version", this.hn.lb());
            jSONObject.putOpt("timestamp", Long.valueOf(this.uc));
            jSONObject.putOpt(ACTD.APPID_KEY, this.hn.pr());
            jSONObject.putOpt("is_plugin", Boolean.valueOf(this.hn.ny()));
            jSONObject.putOpt("os_api", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("conn_type", Integer.valueOf(hn()));
            jSONObject.putOpt("device_info", vk());
            try {
                jSONObject.putOpt(PluginConstants.KEY_PLUGIN_VERSION, this.zo.pr().pr().pr());
            } catch (Exception e) {
            }
            com.byazt.ttf.pr prVar = this.fw;
            if (prVar != null) {
                this.vk = prVar.pr(jSONObject);
            }
            JSONObject jSONObject2 = null;
            String strOptString = jSONObject.optString("event_extra");
            if (!TextUtils.isEmpty(strOptString)) {
                jSONObject2 = new JSONObject(strOptString);
            }
            JSONObject jSONObjectPr = pr(jSONObject2, this.vk);
            this.vk = jSONObjectPr;
            jSONObjectPr.putOpt("stats_index", Long.valueOf(this.aj));
            this.vk.putOpt("sdk_session_id", ((com.byazt.fu.hn) com.byazt.zs.uc.pr("ad_log", this.hn)).hw());
            this.vk.putOpt("csj_type", Integer.valueOf(this.hn.nt() ? 1 : 0));
            this.vk.putOpt("create_ts", Long.valueOf(System.currentTimeMillis()));
            jSONObject.putOpt("event_extra", this.vk.toString());
        } catch (Exception e2) {
        }
        return jSONObject;
    }

    @Override // com.byazt.hh.pr
    public String ho() {
        return this.c;
    }

    @Override // com.byazt.hh.pr
    public byte w() {
        return (byte) 1;
    }

    @Override // com.byazt.hh.pr
    public byte k() {
        return (byte) 3;
    }

    @Override // com.byazt.hh.pr
    public long g() {
        return this.aj;
    }

    public void pr(com.byazt.ttf.pr prVar) {
        this.fw = prVar;
    }

    private JSONObject vk() {
        JSONObject jSONObject = new JSONObject();
        g gVarHw = this.zo.hw();
        com.byazt.hh.hw hwVarPr = this.zo.pr();
        try {
            jSONObject.put("os", 1);
            if (TextUtils.equals(hwVarPr.pr().hn(), "privacy")) {
                jSONObject.put("imei_md5", com.byazt.pa.pr.hn());
            } else {
                jSONObject.put("imei", gVarHw.hw((Boolean) null));
            }
            com.byazt.vkw.hn hnVar = (com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog");
            jSONObject.put("oaid", hnVar.pr(false));
            jSONObject.put("model", gVarHw.hw());
            jSONObject.put(Common.Predefined.SUB_ANDROID_ID, gVarHw.pr());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("package_name", this.hn.qa());
            jSONObject.put(z.d, gVarHw.hw(false));
            jSONObject.put("applog_did", hnVar.pr());
            jSONObject.put("ip", ((g) com.byazt.zs.uc.pr("device_info_new")).hn(false)[0]);
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
