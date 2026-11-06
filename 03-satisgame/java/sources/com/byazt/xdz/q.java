package com.byazt.xdz;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.af.x;
import com.byazt.gc.AbsServerManager;
import com.byazt.qk.rv;
import com.byazt.qyu.PluginConstants;
import com.byazt.vf.cp;
import com.byazt.vf.k;
import com.byazt.vf.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS, 5})
public class q extends n {
    public q(com.byazt.vf.n nVar, com.byazt.vr.qg qgVar, cp cpVar, oa oaVar, com.byazt.vr.l lVar) {
        super(nVar, qgVar, cpVar, oaVar, lVar);
    }

    @Override // com.byazt.xdz.n
    public com.byazt.zad.n n(List<com.byazt.vr.n> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.isEmpty()) {
                return null;
            }
            boolean zN = n();
            JSONObject jSONObjectQg = qg(list);
            byte[] bArrN = n(jSONObjectQg, zN);
            if (bArrN != null && bArrN.length > 0) {
                return n(this.tj.n(), bArrN, zN);
            }
            return n(this.tj.n(), this.l.x() ? rv : q(jSONObjectQg));
        } catch (Throwable unused) {
            return new com.byazt.jeb.n(false, MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_NAME, "service_busy", false, null);
        }
    }

    private byte[] q(JSONObject jSONObject) {
        try {
            return n(jSONObject.toString()).toString().getBytes("utf-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0059  */
    private com.byazt.zad.n n(String str, byte[] bArr, boolean z) {
        String str2;
        boolean z2;
        boolean z3;
        String strQg;
        String str3;
        boolean z4;
        rv rvVarW = com.byazt.hls.q.w(str);
        String strW = this.s.n().w();
        if (!TextUtils.isEmpty(strW)) {
            rvVarW.n("X-Tt-Env", strW);
            rvVarW.n("x-use-ppe", "1");
        }
        if (z) {
            rvVarW.n("x-pglcypher", "4");
            rvVarW.n("Content-Encoding", "union_sdk_encode");
            str2 = "application/octet-stream";
        } else {
            str2 = "application/octet-stream;tt-data=a";
        }
        rvVarW.n(RequestParamsUtils.USER_AGENT_KEY, this.w.cy());
        rvVarW.n(str2, bArr);
        com.byazt.qk.oa oaVarN = rvVarW.n();
        if (oaVarN != null) {
            try {
                if (n(oaVarN.l())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            } catch (Exception unused) {
                z2 = false;
            }
        } else {
            z3 = false;
        }
        z2 = z3;
        int iN = oaVarN != null ? oaVarN.n() : 0;
        if (z2 || iN != 200) {
            if (oaVarN != null) {
                strQg = oaVarN.qg();
                if (!z2) {
                    strQg = strQg + "::" + oaVarN.fs();
                }
            } else {
                strQg = "error unknown";
            }
            str3 = strQg;
            z4 = false;
        } else {
            z4 = true;
            str3 = "server say not success";
        }
        return new com.byazt.jeb.n(z2, iN, str3, z4, null, oaVarN == null ? null : oaVarN.cp());
    }

    /* JADX WARN: Code duplicated, block: B:11:0x004d  */
    private com.byazt.jeb.n n(String str, byte[] bArr) {
        boolean z;
        boolean z2;
        String strQg;
        String str2;
        boolean z3;
        com.byazt.vr.s sVarN = this.s.n();
        rv rvVarW = com.byazt.hls.q.w(str);
        String strW = sVarN.w();
        if (!TextUtils.isEmpty(strW)) {
            rvVarW.n("X-Tt-Env", strW);
            rvVarW.n("x-use-ppe", "1");
        }
        rvVarW.n(RequestParamsUtils.USER_AGENT_KEY, this.w.cy());
        rvVarW.n("Content-Encoding", "union_sdk_encode");
        rvVarW.n("application/json; charset=utf-8", bArr);
        com.byazt.qk.oa oaVarN = rvVarW.n();
        if (oaVarN != null) {
            try {
                if (n(oaVarN.l())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (Exception unused) {
                z = false;
            }
        } else {
            z2 = false;
        }
        z = z2;
        int iN = oaVarN != null ? oaVarN.n() : 0;
        if (z || iN != 200) {
            if (oaVarN != null) {
                strQg = oaVarN.qg();
                if (!z) {
                    strQg = strQg + "::" + oaVarN.fs();
                }
            } else {
                strQg = "error unknown";
            }
            str2 = strQg;
            z3 = false;
        } else {
            z3 = true;
            str2 = "server say not success";
        }
        return new com.byazt.jeb.n(z, iN, str2, z3, null, oaVarN == null ? null : oaVarN.cp());
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0033  */
    /* JADX WARN: Code duplicated, block: B:19:0x0040  */
    private byte[] n(JSONObject jSONObject, boolean z) throws Throwable {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
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
                    byteArray = byteArrayOutputStream.toByteArray();
                    if (z) {
                        return ((k) com.byazt.qp.q.n("encrypt_service")).n(byteArray);
                    }
                    return n(byteArray, byteArray.length);
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
        byteArray = byteArrayOutputStream.toByteArray();
        if (z) {
            return ((k) com.byazt.qp.q.n("encrypt_service")).n(byteArray);
        }
        return n(byteArray, byteArray.length);
    }

    private byte[] n(byte[] bArr, int i) {
        return ((com.byazt.vf.s) com.byazt.qp.q.n("embed_applog")).n(bArr, i);
    }

    private JSONObject qg(List<com.byazt.vr.n> list) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_user_agent", this.w.cy());
            jSONObject.put("client_ip", ((oa) com.byazt.qp.q.n("device_info_new")).s(false)[0]);
            JSONArray jSONArray = new JSONArray();
            Iterator<com.byazt.vr.n> it = list.iterator();
            String strN = null;
            while (it.hasNext()) {
                JSONObject jSONObjectN = it.next().n();
                jSONArray.put(jSONObjectN);
                if (jSONObjectN != null && (jSONObjectOptJSONObject = jSONObjectN.optJSONObject("params")) != null && TextUtils.isEmpty(strN)) {
                    strN = jSONObjectOptJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION);
                }
            }
            if (TextUtils.isEmpty(strN)) {
                strN = this.s.n().n();
            }
            jSONObject.put("header", w(strN));
            jSONObject.put("event_v3", jSONArray);
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private JSONObject w(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strN = ((com.byazt.vf.s) com.byazt.qp.q.n("embed_applog")).n();
            jSONObject.put(TapEventParamConstants.PARAM_DEVICE_ID, strN);
            if (TextUtils.isEmpty(strN)) {
                strN = UUID.randomUUID().toString();
            }
            jSONObject.put("user_unique_id", strN);
            jSONObject.put("sdk_version", this.x.py());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, str);
            jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, "Android");
            jSONObject.put("os_version", this.w.rv());
            jSONObject.put(TapEventParamConstants.PARAM_SUB_DEVICE_MODEL, this.w.qg());
            jSONObject.put("resolution", this.w.py() + x.n + this.w.ou());
            jSONObject.put("language", this.w.q());
            jSONObject.put("timezone", this.w.cd());
            jSONObject.put("access", com.byazt.asa.q.q());
            jSONObject.put("openudid", this.w.n());
            jSONObject.put("aid", "5685");
            jSONObject.put("display_name", this.x.s());
            jSONObject.put("app_version", this.x.cd());
            jSONObject.put(AbsServerManager.PACKAGE_QUERY_BINDER, this.x.um());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
            jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
            jSONObject.put(TapEventParamConstants.PARAM_SUB_ROM, this.w.hd());
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("sig_hash", com.byazt.hls.n.n(this.q.getContext()));
            int iA = this.w.a();
            jSONObject.put("density_dpi", iA);
            jSONObject.put("display_density", qg(iA));
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", this.w.k());
            jSONObject.put("version_code", this.x.a());
            jSONObject.put("udid", this.w.qg((Boolean) null));
            jSONObject.put("custom", l());
            String strX = ((oa) com.byazt.qp.q.n("device_info_new")).s(false)[0];
            if (TextUtils.isEmpty(strX)) {
                strX = "127.0.0.1";
            } else if (strX.contains(",")) {
                strX = x(strX);
            }
            jSONObject.put("ip", strX);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String x(String str) {
        String[] strArrSplit = str.split(",");
        return (strArrSplit == null || strArrSplit.length <= 0 || TextUtils.isEmpty(strArrSplit[0])) ? "127.0.0.1" : strArrSplit[0].trim();
    }

    private JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        com.byazt.vf.s sVar = (com.byazt.vf.s) com.byazt.qp.q.n("embed_applog");
        try {
            jSONObject.put("imei", this.w.qg((Boolean) null));
            jSONObject.put("imei_md5", n.s());
            jSONObject.put("applog_did", sVar.n());
            if (this.x != null && this.x.k() != null) {
                jSONObject.put("publisher_did", this.x.k().n());
            }
            jSONObject.put("android_id", this.w.n());
            jSONObject.put("oaid", sVar.n(false));
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
