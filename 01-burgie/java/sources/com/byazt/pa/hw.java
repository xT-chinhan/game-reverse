package com.byazt.pa;

import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.bumptech.glide.load.Key;
import com.byazt.ewn.AbsServerManager;
import com.byazt.fi.BaseConstants;
import com.byazt.hcx.aj;
import com.byazt.hcx.m;
import com.byazt.mg.PluginConstants;
import com.byazt.nn.fw;
import com.byazt.vkw.g;
import com.byazt.vkw.k;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.utils.RSAUtils;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.z;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD, 13})
public class hw extends com.byazt.pa.pr {
    public String g;
    public long k;
    public int m;

    public hw(com.byazt.vkw.pr prVar, com.byazt.hh.hw hwVar, k kVar, g gVar, com.byazt.hh.c cVar) {
        super(prVar, hwVar, kVar, gVar, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r25v0, types: [com.byazt.pa.hw] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.StringBuilder] */
    @Override // com.byazt.pa.pr
    public com.byazt.mqu.pr pr(List list) {
        String str;
        byte[] bArrPr;
        ?? r4;
        ?? r5;
        boolean zPr;
        ?? r6;
        String str2 = "1streqid";
        String strHw = "2ndreqid";
        com.byazt.hh.hn hnVarPr = this.hn.pr();
        com.byazt.av.pr prVarPr = null;
        if (hnVarPr != null) {
            try {
                if (hnVarPr.hw() && list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    String str3 = "";
                    ?? Hw = 0;
                    ?? r7 = str2;
                    while (it.hasNext()) {
                        try {
                            com.byazt.hh.pr prVar = (com.byazt.hh.pr) it.next();
                            if (TextUtils.equals("show", com.byazt.nn.x.pr(prVar))) {
                                String strPr = com.byazt.nn.x.pr(prVar.pr());
                                if (Hw == 0) {
                                    try {
                                        Hw = com.byazt.nn.x.hw(prVar);
                                        r6 = Hw;
                                    } catch (Throwable th) {
                                        th = th;
                                        str = strPr;
                                        bArrPr = null;
                                        r4 = Hw;
                                        r5 = r7;
                                    }
                                } else {
                                    strHw = com.byazt.nn.x.hw(prVar);
                                    r6 = strHw;
                                }
                                r7 = r6;
                                Hw = 1;
                                str3 = strPr;
                            }
                            arrayList.add(prVar);
                            Hw = Hw;
                            r7 = r7;
                        } catch (Throwable th2) {
                            th = th2;
                            bArrPr = null;
                        }
                    }
                    int iHw = hw();
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    JSONObject jSONObjectPr = pr(arrayList, this.hw);
                    bArrPr = pr(jSONObjectPr, iHw);
                    try {
                        if (bArrPr == null) {
                            JSONObject jSONObjectPr2 = pr(jSONObjectPr.toString());
                            bArrPr = jSONObjectPr2 == null ? new byte[0] : jSONObjectPr2.toString().getBytes(StandardCharsets.UTF_8);
                            prVarPr = pr(bArrPr, uc(jSONObjectPr2), "application/json; charset=utf-8");
                        } else {
                            prVarPr = pr(bArrPr, hn(iHw), pr(iHw));
                        }
                        if (hn(arrayList)) {
                            if (pr(prVarPr)) {
                                hn("applog");
                                zPr = pr("applog", prVarPr);
                            } else {
                                zPr = false;
                            }
                            if (zPr) {
                                hw("applog");
                                com.byazt.av.pr prVarPr2 = pr(arrayList, iHw, prVarPr);
                                if (prVarPr2 != null) {
                                    prVarPr = prVarPr2;
                                }
                                if (prVarPr != null) {
                                    prVarPr.pr(true);
                                }
                            }
                        }
                        if (Hw != 0) {
                            int length = bArrPr != null ? bArrPr.length : 0;
                            if (prVarPr != null) {
                                com.byazt.nn.x.pr(prVarPr.pr, prVarPr.hw, prVarPr.hn, r7 + "|" + strHw, length, str3, (k) uc.pr("csj_settings", this.fw), prVarPr.fw);
                            }
                        }
                        return prVarPr;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    str = str3;
                    r4 = Hw;
                    r5 = r7;
                    try {
                        fw.pr("uploadEvent error", th);
                        return new com.byazt.av.pr(false, MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_NAME, th.getMessage(), false, "error");
                    } finally {
                        if (r4 != 0) {
                            int length2 = bArrPr != null ? bArrPr.length : 0;
                            if (prVarPr != null) {
                                com.byazt.nn.x.pr(prVarPr.pr, prVarPr.hw, prVarPr.hn, r5 + "|" + strHw, length2, str, (k) uc.pr("csj_settings", this.fw), prVarPr.fw);
                            }
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                str = "";
                bArrPr = null;
                r4 = 0;
                r5 = str2;
            }
        }
        return null;
    }

    private JSONObject pr(List<com.byazt.hh.pr> list, boolean z) {
        return pr(list, z, (com.byazt.pa.pr.hw) null, (com.byazt.av.pr) null);
    }

    private JSONObject pr(List<com.byazt.hh.pr> list, boolean z, com.byazt.pa.pr.hw hwVar, com.byazt.av.pr prVar) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            g gVar = (g) uc.pr("device_info_new");
            boolean z2 = false;
            pr(list.get(0));
            JSONArray jSONArray = new JSONArray();
            Iterator<com.byazt.hh.pr> it = list.iterator();
            String strPr = null;
            while (it.hasNext()) {
                JSONObject jSONObjectPr = pr(it.next(), hwVar, prVar);
                if (TextUtils.equals("pangle_live_sdk_monitor", jSONObjectPr.optString(NotificationCompat.CATEGORY_EVENT))) {
                    if (!z2) {
                        z2 = true;
                    }
                    jSONObjectPr.putOpt("nt", Integer.valueOf(gVar.pr(60000L)));
                }
                JSONObject jSONObjectOptJSONObject = jSONObjectPr.optJSONObject("params");
                if (jSONObjectOptJSONObject != null && TextUtils.isEmpty(strPr)) {
                    strPr = jSONObjectOptJSONObject.optString("plugin_version_name");
                }
                if (jSONObjectOptJSONObject != null) {
                    jSONObjectOptJSONObject.remove("plugin_version_name");
                }
                jSONArray.put(jSONObjectPr);
            }
            if (TextUtils.isEmpty(strPr)) {
                strPr = this.hn.pr().pr();
            }
            jSONObject.put("header", pr(list, z2, z, strPr));
            jSONObject.put("event_v3", jSONArray);
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", System.currentTimeMillis());
            return jSONObject;
        } catch (JSONException e) {
            fw.x(e.getMessage());
            return null;
        }
    }

    private JSONObject pr(com.byazt.hh.pr prVar, com.byazt.pa.pr.hw hwVar, com.byazt.av.pr prVar2) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectPr = prVar.pr();
        if (hwVar == null || prVar2 == null || jSONObjectPr == null) {
            return jSONObjectPr;
        }
        JSONObject jSONObject = new JSONObject(jSONObjectPr.toString());
        if (!com.byazt.yt.hw.pr.contains(jSONObject.optString(NotificationCompat.CATEGORY_EVENT)) || (jSONObjectOptJSONObject = jSONObject.optJSONObject("params")) == null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        String strOptString = jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (!TextUtils.isEmpty(strOptString)) {
            jSONObject2 = new JSONObject(strOptString);
        }
        jSONObject2.put(Constants.ERROR_MSG_FIELD, pr(hwVar, pr(prVar2.uc, prVar2.hn)));
        jSONObjectOptJSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
        jSONObject.put("params", jSONObjectOptJSONObject);
        return jSONObject;
    }

    private boolean hn(List<com.byazt.hh.pr> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (com.byazt.hh.pr prVar : list) {
            if (prVar != null && com.byazt.yt.hw.pr.contains(prVar.ho())) {
                return true;
            }
        }
        return false;
    }

    private com.byazt.av.pr pr(List<com.byazt.hh.pr> list, int i, com.byazt.av.pr prVar) {
        boolean z;
        List<com.byazt.pa.pr.hw> listX = x("applog");
        if (listX.isEmpty()) {
            pr("applog", prVar == null ? null : prVar.uc, list, "", false);
            return null;
        }
        listX.size();
        Iterator<com.byazt.pa.pr.hw> it = listX.iterator();
        com.byazt.av.pr prVarPr = null;
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            com.byazt.pa.pr.hw next = it.next();
            JSONObject jSONObjectPr = pr(list, this.hw, next, prVar);
            byte[] bArrPr = pr(jSONObjectPr, i);
            if (bArrPr == null) {
                JSONObject jSONObjectPr2 = pr(jSONObjectPr.toString());
                prVarPr = pr(jSONObjectPr2 == null ? new byte[0] : jSONObjectPr2.toString().getBytes(StandardCharsets.UTF_8), uc(jSONObjectPr2), "application/json; charset=utf-8", next);
            } else {
                prVarPr = pr(bArrPr, hn(i), pr(i), next);
            }
            if (prVarPr != null && prVarPr.pr) {
                break;
            }
        }
        if (prVarPr != null && prVarPr.pr) {
            z = true;
        }
        pr("applog", prVar != null ? prVar.uc : null, list, prVarPr == null ? "" : prVarPr.fw, z);
        return prVarPr;
    }

    public List<pr> hw(List<com.byazt.hh.pr> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        com.byazt.hh.hn hnVarPr = this.hn == null ? null : this.hn.pr();
        if (hnVarPr == null || !hnVarPr.hw()) {
            return arrayList;
        }
        int iHw = hw();
        com.byazt.av.pr prVar = new com.byazt.av.pr(false, -2, "db_high_priority_direct_connect", false, "error");
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 100;
            ArrayList arrayList2 = new ArrayList(list.subList(i, Math.min(i2, size)));
            pr(arrayList2.get(0));
            com.byazt.av.pr prVarPr = pr(arrayList2, iHw, prVar);
            arrayList.add(new pr(arrayList2, prVarPr));
            if (prVarPr == null) {
                break;
            }
            i = i2;
        }
        return arrayList;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static final class pr {
        public final com.byazt.av.pr hw;
        public final List<com.byazt.hh.pr> pr;

        public pr(List<com.byazt.hh.pr> list, com.byazt.av.pr prVar) {
            this.pr = list;
            this.hw = prVar;
        }
    }

    private byte[] pr(JSONObject jSONObject, int i) {
        byte[] bArrHn = hn(jSONObject);
        if (bArrHn == null) {
            return null;
        }
        if (i > 3) {
            byte[] bArrPr = this.w.pr(bArrHn);
            if (bArrPr == null) {
                int iHn = this.w.hn();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(Constants.ERROR_CODE_FIELD, 3);
                    jSONObject2.put("cost_time", -1);
                    jSONObject2.put("type", "applog");
                    jSONObject2.put("armor_load_status", iHn);
                    this.hn.pr().pr(jSONObject2);
                    return bArrPr;
                } catch (Exception e) {
                    return bArrPr;
                }
            }
            return bArrPr;
        }
        return ((com.byazt.vkw.hn) uc.pr("embed_applog")).pr(bArrHn, bArrHn.length);
    }

    @JProtect
    private JSONObject pr(List<com.byazt.hh.pr> list, boolean z, boolean z2, String str) {
        JSONObject jSONObject = new JSONObject();
        if (z) {
            try {
                jSONObject.put("sdk_version", this.fw.cz());
                jSONObject.put(an.s, this.fw.hn());
                jSONObject.put("app_version", this.fw.lb());
                jSONObject.put(AbsServerManager.PACKAGE_QUERY_BINDER, this.fw.qa());
                jSONObject.put("region", Locale.getDefault().getCountry());
                jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
                jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
                jSONObject.put("sig_hash", com.byazt.nn.pr.pr(this.x.getContext()));
                jSONObject.put("version_code", this.fw.a());
            } catch (Throwable th) {
                fw.x("log_net", th.getMessage());
            }
        }
        int i = 0;
        jSONObject.put(z.d, this.uc.hw(false));
        if (TextUtils.equals("privacy", this.hn.pr().hn())) {
            jSONObject.put("udid_md5", com.byazt.pa.pr.hn());
        } else {
            jSONObject.put("udid", this.uc.hw((Boolean) null));
            jSONObject.put(an.A, this.uc.hn((Boolean) null));
        }
        jSONObject.put("openudid", this.uc.pr());
        jSONObject.put("oaid", this.zo.pr(false));
        jSONObject.put("ad_sdk_version", this.fw.cz());
        jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, str);
        jSONObject.put("is_plugin", this.fw.ny());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("client_ipv4", this.hn.pr().c());
        jSONObject2.put("client_ipv6", ((g) uc.pr("device_info_new")).hn(false)[1]);
        jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject2);
        jSONObject.put("sim_op", this.uc.b());
        jSONObject.put("root", z2 ? 1 : 0);
        jSONObject.put(an.M, this.uc.lb());
        jSONObject.put(an.Q, com.byazt.yt.x.pr(((g) uc.pr("device_info_new")).pr(60000L)));
        jSONObject.put("os", "Android");
        jSONObject.put(an.y, Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        if (TextUtils.isEmpty(this.g)) {
            this.g = pr(this.x.getContext());
        }
        jSONObject.put(an.ai, this.g);
        jSONObject.put("device_model", this.uc.hw());
        jSONObject.put(an.F, Build.BRAND);
        jSONObject.put(an.H, Build.MANUFACTURER);
        jSONObject.put("language", Locale.getDefault().getLanguage());
        jSONObject.put(an.z, this.uc.cz() + "x" + this.uc.ny());
        int iA = this.uc.a();
        jSONObject.put("density_dpi", iA);
        jSONObject.put("display_density", hw(iA));
        jSONObject.put("device_id", this.hn.pr().x());
        int iHn = com.byazt.nn.x.hn(list);
        if (iHn != 0) {
            jSONObject.put("aid", String.valueOf(iHn));
        } else {
            jSONObject.put("aid", "1371");
        }
        jSONObject.put(Common.Predefined.SUB_ROM, this.uc.yb());
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", this.uc.ho());
        jSONObject.put("ut", this.m);
        jSONObject.put("uid", this.k);
        jSONObject.put("locale_language", this.uc.c());
        jSONObject.put("screen_bright", Math.ceil(this.uc.gz() * 10.0f) / 10.0d);
        if (!this.uc.ve()) {
            i = 1;
        }
        jSONObject.put("is_screen_off", i);
        jSONObject.put("download_channel", this.fw.fo());
        jSONObject.put("mnc", this.uc.fw());
        jSONObject.put("mcc", this.uc.uc());
        jSONObject.put("pan_code_serial", "1000");
        return jSONObject;
    }

    private void pr(com.byazt.hh.pr prVar) {
        String strOptString;
        if (prVar == null) {
            return;
        }
        JSONObject jSONObjectPr = prVar.pr();
        JSONObject jSONObjectOptJSONObject = jSONObjectPr.optJSONObject("params");
        if (jSONObjectOptJSONObject != null) {
            strOptString = jSONObjectOptJSONObject.optString("log_extra", "");
        } else {
            strOptString = jSONObjectPr.optString("log_extra", "");
        }
        long jUc = uc(strOptString);
        int iFw = fw(strOptString);
        if (jUc == 0) {
            jUc = this.k;
        }
        this.k = jUc;
        if (iFw == 0) {
            iFw = this.m;
        }
        this.m = iFw;
    }

    private long uc(String str) {
        return x(zo(str));
    }

    private long x(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong("uid", 0L);
        }
        return 0L;
    }

    private int fw(String str) {
        return c(zo(str));
    }

    private JSONObject zo(String str) {
        if (TextUtils.isEmpty(str) || str == null || str.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            return null;
        }
    }

    private static int c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    private Map<String, String> uc(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json; charset=utf-8");
        if (jSONObject != null && jSONObject.length() > 0) {
            map.put("Content-Encoding", "union_sdk_encode");
        }
        return map;
    }

    private Map<String, String> hn(int i) {
        HashMap map = new HashMap();
        if (i >= 4) {
            map.put("Content-Encoding", "union_sdk_encode");
            map.put("x-pglcypher", String.valueOf(i));
        }
        map.put("Content-Type", pr(i));
        return map;
    }

    private com.byazt.av.pr pr(byte[] bArr, Map<String, String> map, String str) {
        int iFw;
        boolean zHw;
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        String str2;
        String str3 = "error";
        try {
            aj ajVarUc = com.byazt.nn.x.uc(this.c.hw());
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    ajVarUc.pr(entry.getKey(), entry.getValue());
                }
            }
            ajVarUc.pr(str, bArr);
            ajVarUc.pr("User-Agent", this.uc.hw(false));
            m mVarPr = ajVarUc.pr();
            if (mVarPr == null) {
                return new com.byazt.av.pr(false, MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_DIR, "RSP IS NULL", false, "error");
            }
            if (!mVarPr.fw()) {
                iFw = 0;
                zHw = false;
            } else {
                JSONObject jSONObjectC = mVarPr.c();
                zHw = hw(jSONObjectC);
                iFw = fw(jSONObjectC);
            }
            int iPr = mVarPr.pr();
            Map<String, String> mapHn = mVarPr.hn();
            if (mapHn != null) {
                str3 = mapHn.get("x-tt-logid");
            }
            if (!zHw && iPr == 200) {
                z = true;
            } else {
                z = false;
            }
            String strHw = mVarPr.hw();
            if (strHw == null || TextUtils.isEmpty(strHw)) {
                strHw = "DEFAULT OK";
            }
            if (iFw == 0) {
                z2 = zHw;
                i = iPr;
                z3 = z;
                str2 = strHw;
            } else {
                z3 = true;
                i = iFw;
                z2 = false;
                str2 = "RSP FAIL";
            }
            hw(bArr, map, str);
            return new com.byazt.av.pr(z2, i, str2, z3, str3, mVarPr.w(), mVarPr.k());
        } catch (Throwable th) {
            fw.pr("CSJ_EVENT_UPLOAD", "uploadEvent error", th);
            return new com.byazt.av.pr(false, 511, th.getMessage(), false, "error", th);
        }
    }

    private com.byazt.av.pr pr(byte[] bArr, Map<String, String> map, String str, com.byazt.pa.pr.hw hwVar) {
        int iFw;
        boolean zHw;
        boolean z;
        String str2;
        boolean z2;
        int i;
        boolean z3;
        com.byazt.pa.pr.C0161pr c0161prPr = pr(this.c.hw(), bArr, map, str, hwVar);
        if (c0161prPr == null) {
            return null;
        }
        if (!c0161prPr.pr) {
            Throwable th = c0161prPr.fw;
            return new com.byazt.av.pr(false, 511, pr(th, "direct_connect_error"), false, "error", th, hwVar.pr);
        }
        String str3 = c0161prPr.uc;
        try {
            if (c0161prPr.x && c0161prPr.c != null) {
                JSONObject jSONObject = new JSONObject(new String(c0161prPr.c, StandardCharsets.UTF_8));
                zHw = hw(jSONObject);
                iFw = fw(jSONObject);
            } else {
                iFw = 0;
                zHw = false;
            }
            int i2 = c0161prPr.hw;
            if (!zHw && i2 == 200) {
                z = true;
            } else {
                z = false;
            }
            String str4 = c0161prPr.hn;
            if (TextUtils.isEmpty(str4)) {
                str4 = "DEFAULT OK";
            }
            if (iFw == 0) {
                str2 = str4;
                z2 = zHw;
                i = i2;
                z3 = z;
            } else {
                str2 = "RSP FAIL";
                i = iFw;
                z2 = false;
                z3 = true;
            }
            return new com.byazt.av.pr(z2, i, str2, z3, str3, null, hwVar.pr);
        } catch (Throwable th2) {
            return new com.byazt.av.pr(false, 511, th2.getMessage(), false, str3, th2, hwVar.pr);
        }
    }

    private void hw(byte[] bArr, Map<String, String> map, String str) {
        if (bArr == null || bArr.length == 0 || this.hn == null || this.hn.pr() == null || !TextUtils.equals(this.fw.pr(), "5001121")) {
            return;
        }
        aj ajVarUc = com.byazt.nn.x.uc(this.c.hn());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                ajVarUc.pr(entry.getKey(), entry.getValue());
            }
        }
        ajVarUc.pr(str, bArr);
        ajVarUc.pr("User-Agent", this.uc.hw(false));
        ajVarUc.pr(new com.byazt.hcx.fw() { // from class: com.byazt.pa.hw.1
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                if (mVar == null || !mVar.fw()) {
                    fw.pr("CSJ_EVENT_UPLOAD", "onResponse: NetResponse is null");
                } else {
                    fw.pr("CSJ_EVENT_UPLOAD", "onResponse: " + mVar.zo());
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str2, Throwable th) {
                fw.pr("CSJ_EVENT_UPLOAD", "onFailure: " + th.getMessage());
            }
        });
    }

    private int fw(JSONObject jSONObject) {
        int iIndexOf;
        int i = 0;
        if (jSONObject == null) {
            return 0;
        }
        try {
            String strOptString = jSONObject.optString("s_sig_ts");
            if (strOptString == null || (iIndexOf = strOptString.indexOf("_")) < 5) {
                return 512;
            }
            String strSubstring = strOptString.substring(0, iIndexOf);
            if (!pr(this.hn.pr().x() + "_" + strSubstring, strOptString.substring(iIndexOf + 1))) {
                return 512;
            }
            if (Math.abs((System.currentTimeMillis() / 1000) - Long.valueOf(strSubstring).longValue()) > 300) {
                i = 513;
            }
            return i;
        } catch (Throwable th) {
            return 512;
        }
    }

    private boolean pr(String str, String str2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(RSAUtils.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(c().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName(Key.STRING_CHARSET_NAME)), 2));
    }

    private static PublicKey c() throws Exception {
        return KeyFactory.getInstance(RSAUtils.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName(Key.STRING_CHARSET_NAME)), 2)));
    }
}
