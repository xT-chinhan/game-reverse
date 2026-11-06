package com.byazt.ph;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.ehw.DeviceUtils;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qit.l;
import com.byazt.qit.x;
import com.byazt.qyu.PluginConstants;
import com.byazt.tk.hd;
import com.byazt.vf.k;
import com.byazt.vf.oa;
import com.byazt.vgx.w;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 513, 26})
public class qg extends x {
    private qg() {
        super("PluginSettingsFetchTask");
    }

    @com.byazt.cp.n(n = {0, 1, 513, 48})
    private static class n {
        public static final qg n = new qg();
    }

    public static qg n() {
        return n.n;
    }

    public void qg() {
        if (hd.n(rv.getContext())) {
            l.qg(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.byazt.qk.rv rvVarQ = com.byazt.phf.s.q(w.rv("/api/ad/union/sdk/settings/plugins"));
        rvVarQ.n(RequestParamsUtils.USER_AGENT_KEY, ((oa) com.byazt.qp.q.n("device_info_new")).qg(false));
        JSONObject jSONObjectS = s();
        rvVarQ.n(com.byazt.cl.s.n(jSONObjectS == null ? null : jSONObjectS.toString()));
        rvVarQ.n(new com.byazt.qk.x() { // from class: com.byazt.ph.qg.1
            @Override // com.byazt.qk.x
            public void n(com.byazt.qk.oa oaVar) {
                if (oaVar == null || !oaVar.x()) {
                    return;
                }
                try {
                    JSONObject jSONObjectL = oaVar.l();
                    if (jSONObjectL.optInt("cypher") == 3) {
                        String strQ = ((k) com.byazt.qp.q.n("encrypt_service")).q(jSONObjectL.optString("message"));
                        if (TextUtils.isEmpty(strQ)) {
                            return;
                        }
                        s.n().n(new JSONObject(strQ).optJSONArray("plugins"));
                    }
                } catch (Exception unused) {
                }
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str, Throwable th) {
                try {
                    Iterator<String> itKeys = com.byazt.vyf.s.cy().ae().keys();
                    while (itKeys.hasNext()) {
                        s.n().n(itKeys.next(), 1007);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.qp.q.n("device_info_new");
            jSONObject.put("oaid", ((com.byazt.vf.s) com.byazt.qp.q.n("embed_applog")).n(false));
            jSONObject.put("conn_type", hd.qg(rv.getContext()));
            jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", tj.w);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
            jSONObject.put("package_name", w.fs());
            jSONObject.put("app_version", w.tj());
            jSONObject.put("app_code", w.rv());
            jSONObject.put("vendor", Build.MANUFACTURER);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            String strOu = com.byazt.vyf.s.cy().ou();
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put("app_id", strOu);
            jSONObject.put("req_sign", com.byazt.tk.l.qg(strOu != null ? strOu.concat(String.valueOf(jCurrentTimeMillis)).concat(tj.w) : ""));
            jSONObject.put("channel", tj.rv);
            jSONObject.put("applog_did", com.byazt.yu.n.n().qg());
            jSONObject.put("imei", DeviceUtils.n((Boolean) null));
            jSONObject.put("source", 1);
            jSONObject.put("device_abi", com.byazt.wl.qg.n());
            jSONObject.put("plugins", q());
            jSONObject.put("csj_type", com.byazt.vyf.s.cy().oj() ? 1 : 0);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectAe = com.byazt.vyf.s.cy().ae();
        boolean zCf = rv.qg().cf();
        if (jSONObjectAe != null) {
            Iterator<String> itKeys = jSONObjectAe.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectAe.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        jSONObjectOptJSONObject.put("plugin_update_network", com.byazt.vyf.s.cy().h().n(next));
                    }
                    if (zCf && next.equals("com.byted.live.lite")) {
                        jSONObject.putOpt(s.qg(), jSONObjectOptJSONObject);
                    } else {
                        jSONObject.putOpt(next, jSONObjectOptJSONObject);
                    }
                }
            }
        }
        return jSONObject;
    }
}
