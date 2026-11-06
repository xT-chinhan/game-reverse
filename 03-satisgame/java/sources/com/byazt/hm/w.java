package com.byazt.hm;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qk.x;
import com.byazt.qyu.PluginConstants;
import com.byazt.tk.hd;
import com.byazt.vf.cp;
import com.byazt.vf.k;
import com.byazt.vf.oa;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.qq.e.comm.pi.ACTD;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 49, 13})
public class w {
    private static String n(int i) {
        return i >= 4 ? "application/octet-stream" : "application/octet-stream;tt-data=a";
    }

    public static int n() {
        return ((cp) com.byazt.qp.q.n("csj_settings", com.byazt.vgx.s.n().n(com.byazt.vyf.s.cy().ou()))).n() ? 4 : 3;
    }

    private static byte[] n(JSONObject jSONObject) throws Throwable {
        GZIPOutputStream gZIPOutputStream = null;
        if (jSONObject == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(jSONObject.toString().getBytes());
                    gZIPOutputStream2.close();
                } catch (Exception unused) {
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            }
        } catch (Exception unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] n(JSONObject jSONObject, int i) throws Throwable {
        byte[] bArrN = n(jSONObject);
        k kVar = (k) com.byazt.qp.q.n("encrypt_service");
        if (bArrN == null || kVar == null || !kVar.qg() || i <= 3) {
            return null;
        }
        return kVar.n(bArrN);
    }

    public static void n(String str, JSONObject jSONObject, Throwable th) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("scene", str);
            jSONObject2.putOpt("object", jSONObject);
            if (th != null) {
                jSONObject2.putOpt("exception", Log.getStackTraceString(th));
            }
        } catch (Exception unused) {
        }
        n("exception", jSONObject2, true);
    }

    public static void n(String str, JSONObject jSONObject, boolean z) {
        com.byazt.sf.s sVarN;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.vyf.s.cy().sh();
        if (!z || (sVarN = com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou())) == null || sVarN.n(str, 1.0d)) {
            com.byazt.vf.n nVarN = com.byazt.vgx.s.n().n(com.byazt.vyf.s.cy().ou());
            oa oaVar = (oa) com.byazt.qp.q.n("device_info_new");
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", str);
                jSONObject2.put("ad_sdk_version", tj.w);
                jSONObject2.put("app_version", nVarN.cd());
                jSONObject2.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, System.currentTimeMillis() / 1000);
                jSONObject2.put(ACTD.APPID_KEY, com.byazt.vyf.s.cy().ou());
                jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
                jSONObject2.put("is_plugin", tj.n());
                jSONObject2.put("os_api", Build.VERSION.SDK_INT);
                jSONObject2.put("conn_type", hd.qg(rv.getContext()));
                jSONObject2.put("device_info", n(oaVar));
                if (jSONObject != null) {
                    jSONObject2.put("event_extra", jSONObject.toString());
                }
                JSONObject jSONObject3 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(0, jSONObject2);
                jSONObject3.put("stats_list", jSONArray);
                qg(jSONObject3);
            } catch (Exception unused) {
            }
        }
    }

    private static JSONObject n(oa oaVar) {
        JSONObject jSONObject = new JSONObject();
        com.byazt.vf.s sVar = (com.byazt.vf.s) com.byazt.qp.q.n("embed_applog");
        try {
            jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, 1);
            com.byazt.hnb.n.s(jSONObject);
            jSONObject.put("oaid", sVar.n(false));
            jSONObject.put("model", oaVar.qg());
            jSONObject.put("android_id", oaVar.n());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("package_name", com.byazt.vgx.w.fs());
            jSONObject.put("ua", oaVar.qg(false));
            jSONObject.put("applog_did", sVar.n());
            jSONObject.put("ip", ((oa) com.byazt.qp.q.n("device_info_new")).s(false)[0]);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void qg(JSONObject jSONObject) throws Throwable {
        com.byazt.qk.rv rvVarQ = com.byazt.phf.s.q(com.byazt.vgx.w.tj("/api/ad/union/sdk/stats/batch/"));
        int iN = n();
        rvVarQ.n(n(iN), n(jSONObject, iN));
        rvVarQ.n("x-pglcypher", String.valueOf(iN));
        rvVarQ.n(RequestParamsUtils.USER_AGENT_KEY, ((oa) com.byazt.qp.q.n("device_info_new")).qg(false));
        rvVarQ.n(new x() { // from class: com.byazt.hm.w.1
            @Override // com.byazt.qk.x
            public void n(com.byazt.qk.oa oaVar) {
                com.byazt.vyf.s.cy().sh();
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str, Throwable th) {
                com.byazt.vyf.s.cy().sh();
            }
        });
    }
}
