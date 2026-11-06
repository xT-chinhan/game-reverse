package com.byazt.asa;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.qyu.PluginConstants;
import com.byazt.vf.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.pi.ACTD;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS, 21})
public class x extends q {
    public com.byazt.vr.l fs;
    public String l;
    public long rv;
    public JSONObject tj;
    public long w;
    public com.byazt.rs.n x;

    @Override // com.byazt.vr.n
    public byte cp() {
        return (byte) 1;
    }

    @Override // com.byazt.vr.n
    public byte d() {
        return (byte) 3;
    }

    public x(String str, JSONObject jSONObject) {
        super(str, jSONObject);
        if (jSONObject != null) {
            this.l = jSONObject.optString("type");
            this.w = jSONObject.optLong(TapEventParamConstants.PARAM_SUB_TIMESTAMP);
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("event_extra"));
                this.tj = jSONObject2;
                this.rv = jSONObject2.optLong("stats_index");
            } catch (Exception unused) {
            }
        }
    }

    public x(String str, com.byazt.vr.l lVar) {
        super(null, null);
        this.l = str;
        this.fs = lVar;
        this.rv = s.sStatsEventIndex.incrementAndGet();
        this.w = System.currentTimeMillis() / 1000;
    }

    @Override // com.byazt.asa.q
    public JSONObject n(String str) {
        if (this.fs == null || this.s == null) {
            return this.qg;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("type", this.l);
            jSONObject.putOpt("error_code", Integer.valueOf(jSONObject.optInt("error_code")));
            jSONObject.putOpt("ad_sdk_version", this.s.py());
            jSONObject.putOpt("app_version", this.s.cd());
            jSONObject.putOpt(TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(this.w));
            jSONObject.putOpt(ACTD.APPID_KEY, this.s.n());
            jSONObject.putOpt("is_plugin", Boolean.valueOf(this.s.ou()));
            jSONObject.putOpt("os_api", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("conn_type", Integer.valueOf(s()));
            jSONObject.putOpt("device_info", tj());
            try {
                jSONObject.putOpt(PluginConstants.KEY_PLUGIN_VERSION, this.fs.n().n().n());
            } catch (Exception unused) {
            }
            com.byazt.rs.n nVar = this.x;
            if (nVar != null) {
                this.tj = nVar.n(jSONObject);
            }
            String strOptString = jSONObject.optString("event_extra");
            JSONObject jSONObjectN = n(!TextUtils.isEmpty(strOptString) ? new JSONObject(strOptString) : null, this.tj);
            this.tj = jSONObjectN;
            jSONObjectN.putOpt("stats_index", Long.valueOf(this.rv));
            this.tj.putOpt("sdk_session_id", ((com.byazt.sf.s) com.byazt.qp.q.n("ad_log", this.s)).qg());
            this.tj.putOpt("csj_type", Integer.valueOf(this.s.cy() ? 1 : 0));
            this.tj.putOpt("create_ts", Long.valueOf(System.currentTimeMillis()));
            jSONObject.putOpt("event_extra", this.tj.toString());
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    @Override // com.byazt.vr.n
    public String k() {
        return this.l;
    }

    @Override // com.byazt.vr.n
    public long sz() {
        return this.rv;
    }

    public void n(com.byazt.rs.n nVar) {
        this.x = nVar;
    }

    private JSONObject tj() {
        JSONObject jSONObject = new JSONObject();
        oa oaVarQg = this.fs.qg();
        com.byazt.vr.qg qgVarN = this.fs.n();
        try {
            jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, 1);
            if (TextUtils.equals(qgVarN.n().s(), "privacy")) {
                jSONObject.put("imei_md5", com.byazt.xdz.n.s());
            } else {
                jSONObject.put("imei", oaVarQg.qg((Boolean) null));
            }
            com.byazt.vf.s sVar = (com.byazt.vf.s) com.byazt.qp.q.n("embed_applog");
            jSONObject.put("oaid", sVar.n(false));
            jSONObject.put("model", oaVarQg.qg());
            jSONObject.put("android_id", oaVarQg.n());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("package_name", this.s.um());
            jSONObject.put("ua", oaVarQg.qg(false));
            jSONObject.put("applog_did", sVar.n());
            jSONObject.put("ip", ((oa) com.byazt.qp.q.n("device_info_new")).s(false)[0]);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
