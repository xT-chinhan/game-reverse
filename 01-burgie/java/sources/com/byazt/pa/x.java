package com.byazt.pa;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.ewn.AbsServerManager;
import com.byazt.hcx.aj;
import com.byazt.hcx.m;
import com.byazt.mg.PluginConstants;
import com.byazt.vkw.g;
import com.byazt.vkw.k;
import com.byazt.vkw.nt;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD, 121})
public class x extends pr {
    public x(com.byazt.vkw.pr prVar, com.byazt.hh.hw hwVar, k kVar, g gVar, com.byazt.hh.c cVar) {
        super(prVar, hwVar, kVar, gVar, cVar);
    }

    @Override // com.byazt.pa.pr
    public com.byazt.mqu.pr pr(List<com.byazt.hh.pr> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.isEmpty()) {
                return null;
            }
            boolean zPr = pr();
            JSONObject jSONObjectHw = hw(list);
            byte[] bArrPr = pr(jSONObjectHw, zPr);
            if (bArrPr != null && bArrPr.length > 0) {
                return pr(this.vk.pr(), bArrPr, zPr);
            }
            return pr(this.vk.pr(), this.c.fw() ? aj : x(jSONObjectHw));
        } catch (Throwable th) {
            return new com.byazt.av.pr(false, MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_NAME, "service_busy", false, null);
        }
    }

    private byte[] x(JSONObject jSONObject) {
        try {
            return pr(jSONObject.toString()).toString().getBytes("utf-8");
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005d  */
    private com.byazt.mqu.pr pr(String str, byte[] bArr, boolean z) {
        String str2;
        boolean z2;
        boolean z3;
        int iPr;
        String str3;
        boolean z4;
        aj ajVarUc = com.byazt.nn.x.uc(str);
        String strUc = this.hn.pr().uc();
        if (!TextUtils.isEmpty(strUc)) {
            ajVarUc.pr("X-Tt-Env", strUc);
            ajVarUc.pr("x-use-ppe", "1");
        }
        if (!z) {
            str2 = "application/octet-stream;tt-data=a";
        } else {
            ajVarUc.pr("x-pglcypher", GlobalSetting.NATIVE_EXPRESS_AD);
            ajVarUc.pr("Content-Encoding", "union_sdk_encode");
            str2 = "application/octet-stream";
        }
        ajVarUc.pr("User-Agent", this.uc.nt());
        ajVarUc.pr(str2, bArr);
        m mVarPr = ajVarUc.pr();
        if (mVarPr != null) {
            try {
                if (pr(mVarPr.c())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            } catch (Exception e) {
                z2 = false;
            }
        } else {
            z3 = false;
        }
        z2 = z3;
        if (mVarPr == null) {
            iPr = 0;
        } else {
            iPr = mVarPr.pr();
        }
        if (!z2 && iPr == 200) {
            z4 = true;
            str3 = "server say not success";
        } else if (mVarPr == null) {
            str3 = "error unknown";
            z4 = false;
        } else {
            String strHw = mVarPr.hw();
            if (z2) {
                str3 = strHw;
                z4 = false;
            } else {
                str3 = strHw + "::" + mVarPr.zo();
                z4 = false;
            }
        }
        return new com.byazt.av.pr(z2, iPr, str3, z4, null, mVarPr == null ? null : mVarPr.w());
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0050  */
    private com.byazt.av.pr pr(String str, byte[] bArr) {
        boolean z;
        boolean z2;
        int iPr;
        String str2;
        boolean z3;
        com.byazt.hh.hn hnVarPr = this.hn.pr();
        aj ajVarUc = com.byazt.nn.x.uc(str);
        String strUc = hnVarPr.uc();
        if (!TextUtils.isEmpty(strUc)) {
            ajVarUc.pr("X-Tt-Env", strUc);
            ajVarUc.pr("x-use-ppe", "1");
        }
        ajVarUc.pr("User-Agent", this.uc.nt());
        ajVarUc.pr("Content-Encoding", "union_sdk_encode");
        ajVarUc.pr("application/json; charset=utf-8", bArr);
        m mVarPr = ajVarUc.pr();
        if (mVarPr != null) {
            try {
                if (pr(mVarPr.c())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (Exception e) {
                z = false;
            }
        } else {
            z2 = false;
        }
        z = z2;
        if (mVarPr == null) {
            iPr = 0;
        } else {
            iPr = mVarPr.pr();
        }
        if (!z && iPr == 200) {
            z3 = true;
            str2 = "server say not success";
        } else if (mVarPr == null) {
            str2 = "error unknown";
            z3 = false;
        } else {
            String strHw = mVarPr.hw();
            if (z) {
                str2 = strHw;
                z3 = false;
            } else {
                str2 = strHw + "::" + mVarPr.zo();
                z3 = false;
            }
        }
        return new com.byazt.av.pr(z, iPr, str2, z3, null, mVarPr == null ? null : mVarPr.w());
    }

    /* JADX WARN: Code duplicated, block: B:25:0x003b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    private byte[] pr(JSONObject jSONObject, boolean z) throws Throwable {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(jSONObject.toString().getBytes());
                    gZIPOutputStream2.close();
                } catch (Exception e) {
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                    if (z) {
                        return ((nt) uc.pr("encrypt_service")).pr(byteArray);
                    }
                    return pr(byteArray, byteArray.length);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
            }
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        byteArray = byteArrayOutputStream.toByteArray();
        if (z) {
            return ((nt) uc.pr("encrypt_service")).pr(byteArray);
        }
        return pr(byteArray, byteArray.length);
    }

    private byte[] pr(byte[] bArr, int i) {
        return ((com.byazt.vkw.hn) uc.pr("embed_applog")).pr(bArr, i);
    }

    private JSONObject hw(List<com.byazt.hh.pr> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_user_agent", this.uc.nt());
            jSONObject.put("client_ip", ((g) uc.pr("device_info_new")).hn(false)[0]);
            JSONArray jSONArray = new JSONArray();
            String strPr = null;
            Iterator<com.byazt.hh.pr> it = list.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectPr = it.next().pr();
                jSONArray.put(jSONObjectPr);
                if (jSONObjectPr != null) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectPr.optJSONObject("params");
                    if (jSONObjectOptJSONObject != null && TextUtils.isEmpty(strPr)) {
                        strPr = jSONObjectOptJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION);
                    }
                }
            }
            if (TextUtils.isEmpty(strPr)) {
                strPr = this.hn.pr().pr();
            }
            jSONObject.put("header", uc(strPr));
            jSONObject.put("event_v3", jSONArray);
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    private JSONObject uc(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strPr = ((com.byazt.vkw.hn) uc.pr("embed_applog")).pr();
            jSONObject.put("device_id", strPr);
            if (TextUtils.isEmpty(strPr)) {
                strPr = UUID.randomUUID().toString();
            }
            jSONObject.put("user_unique_id", strPr);
            jSONObject.put("sdk_version", this.fw.cz());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, str);
            jSONObject.put("os", "Android");
            jSONObject.put(an.y, this.uc.aj());
            jSONObject.put("device_model", this.uc.hw());
            jSONObject.put(an.z, this.uc.cz() + "x" + this.uc.ny());
            jSONObject.put("language", this.uc.x());
            jSONObject.put(an.M, this.uc.lb());
            jSONObject.put(an.Q, com.byazt.yt.x.x());
            jSONObject.put("openudid", this.uc.pr());
            jSONObject.put("aid", "5685");
            jSONObject.put(an.s, this.fw.hn());
            jSONObject.put("app_version", this.fw.lb());
            jSONObject.put(AbsServerManager.PACKAGE_QUERY_BINDER, this.fw.qa());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
            jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
            jSONObject.put(Common.Predefined.SUB_ROM, this.uc.yb());
            jSONObject.put(an.H, Build.MANUFACTURER);
            jSONObject.put("sig_hash", com.byazt.nn.pr.pr(this.x.getContext()));
            int iA = this.uc.a();
            jSONObject.put("density_dpi", iA);
            jSONObject.put("display_density", hw(iA));
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(an.F, Build.BRAND);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", this.uc.ho());
            jSONObject.put("version_code", this.fw.a());
            jSONObject.put("udid", this.uc.hw((Boolean) null));
            jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, c());
            String strFw = ((g) uc.pr("device_info_new")).hn(false)[0];
            if (TextUtils.isEmpty(strFw)) {
                strFw = "127.0.0.1";
            } else if (strFw.contains(",")) {
                strFw = fw(strFw);
            }
            jSONObject.put("ip", strFw);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private String fw(String str) {
        String[] strArrSplit = str.split(",");
        if (strArrSplit != null && strArrSplit.length > 0 && !TextUtils.isEmpty(strArrSplit[0])) {
            return strArrSplit[0].trim();
        }
        return "127.0.0.1";
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        com.byazt.vkw.hn hnVar = (com.byazt.vkw.hn) uc.pr("embed_applog");
        try {
            jSONObject.put("imei", this.uc.hw((Boolean) null));
            jSONObject.put("imei_md5", pr.hn());
            jSONObject.put("applog_did", hnVar.pr());
            if (this.fw != null && this.fw.ho() != null) {
                jSONObject.put("publisher_did", this.fw.ho().pr());
            }
            jSONObject.put(Common.Predefined.SUB_ANDROID_ID, this.uc.pr());
            jSONObject.put("oaid", hnVar.pr(false));
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
