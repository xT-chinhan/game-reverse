package com.byazt.pj;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.byazt.ca.yb;
import com.byazt.hcx.aj;
import com.byazt.hcx.m;
import com.byazt.mg.PluginConstants;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.vkw.g;
import com.byazt.vkw.k;
import com.byazt.vkw.nt;
import com.byazt.wt.ls;
import com.qq.e.comm.pi.ACTD;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.z;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 115, 5})
public class uc {
    public static int pr() {
        if (((k) com.byazt.zs.uc.pr("csj_settings", com.byazt.zb.pr.pr().pr(com.byazt.sd.zo.nt().ny()))).pr()) {
            return 4;
        }
        return 3;
    }

    private static byte[] pr(JSONObject jSONObject) throws Throwable {
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
                } catch (Exception e) {
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
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] pr(JSONObject jSONObject, int i) throws Throwable {
        byte[] bArrPr = pr(jSONObject);
        nt ntVar = (nt) com.byazt.zs.uc.pr("encrypt_service");
        if (bArrPr != null && ntVar != null && ntVar.hw() && i > 3) {
            return ntVar.pr(bArrPr);
        }
        return null;
    }

    public static void pr(String str, JSONObject jSONObject, Throwable th) throws Throwable {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("scene", str);
            jSONObject2.putOpt("object", jSONObject);
            if (th != null) {
                jSONObject2.putOpt("exception", Log.getStackTraceString(th));
            }
        } catch (Exception e) {
        }
        pr("exception", jSONObject2, true);
    }

    public static void pr(String str, JSONObject jSONObject, boolean z) throws Throwable {
        com.byazt.fu.hn hnVarPr;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.sd.zo.nt().i();
        if (z && (hnVarPr = com.byazt.lg.pr.pr(com.byazt.sd.zo.nt().ny())) != null && !hnVarPr.pr(str, 1.0d)) {
            return;
        }
        com.byazt.vkw.pr prVarPr = com.byazt.zb.pr.pr().pr(com.byazt.sd.zo.nt().ny());
        g gVar = (g) com.byazt.zs.uc.pr("device_info_new");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", str);
            jSONObject2.put("ad_sdk_version", iu.c);
            jSONObject2.put("app_version", prVarPr.lb());
            jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject2.put(ACTD.APPID_KEY, com.byazt.sd.zo.nt().ny());
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
            jSONObject2.put("is_plugin", iu.pr());
            jSONObject2.put("os_api", Build.VERSION.SDK_INT);
            jSONObject2.put("conn_type", yb.hw(a.getContext()));
            jSONObject2.put("device_info", pr(gVar));
            if (jSONObject != null) {
                jSONObject2.put("event_extra", jSONObject.toString());
            }
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, jSONObject2);
            jSONObject3.put("stats_list", jSONArray);
            hw(jSONObject3);
        } catch (Exception e) {
        }
    }

    private static JSONObject pr(g gVar) {
        JSONObject jSONObject = new JSONObject();
        com.byazt.vkw.hn hnVar = (com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog");
        try {
            jSONObject.put("os", 1);
            com.byazt.igw.hw.hn(jSONObject);
            jSONObject.put("oaid", hnVar.pr(false));
            jSONObject.put("model", gVar.hw());
            jSONObject.put(Common.Predefined.SUB_ANDROID_ID, gVar.pr());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("package_name", ls.zo());
            jSONObject.put(z.d, gVar.hw(false));
            jSONObject.put("applog_did", hnVar.pr());
            jSONObject.put("ip", ((g) com.byazt.zs.uc.pr("device_info_new")).hn(false)[0]);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private static void hw(JSONObject jSONObject) throws Throwable {
        aj ajVarX = com.byazt.tf.hn.x(ls.vk("/api/ad/union/sdk/stats/batch/"));
        int iPr = pr();
        ajVarX.pr(pr(iPr), pr(jSONObject, iPr));
        ajVarX.pr("x-pglcypher", String.valueOf(iPr));
        ajVarX.pr("User-Agent", ((g) com.byazt.zs.uc.pr("device_info_new")).hw(false));
        ajVarX.pr(new com.byazt.hcx.fw() { // from class: com.byazt.pj.uc.1
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                com.byazt.sd.zo.nt().i();
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str, Throwable th) {
                com.byazt.sd.zo.nt().i();
            }
        });
    }

    private static String pr(int i) {
        if (i >= 4) {
            return "application/octet-stream";
        }
        return "application/octet-stream;tt-data=a";
    }
}
