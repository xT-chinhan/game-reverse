package com.byazt.xdz;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.l.b;
import com.byazt.gc.AbsServerManager;
import com.byazt.hls.x;
import com.byazt.ho.BaseConstants;
import com.byazt.qk.rv;
import com.byazt.qyu.PluginConstants;
import com.byazt.vf.cp;
import com.byazt.vf.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.JProtect;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
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
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS, 26})
public class qg extends com.byazt.xdz.n {
    public long d;
    public int oa;
    public String sz;

    public qg(com.byazt.vf.n nVar, com.byazt.vr.qg qgVar, cp cpVar, oa oaVar, com.byazt.vr.l lVar) {
        super(nVar, qgVar, cpVar, oaVar, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r26v0, types: [com.byazt.xdz.qg] */
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
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.StringBuilder] */
    @Override // com.byazt.xdz.n
    public com.byazt.zad.n n(List list) {
        String str;
        byte[] bArrN;
        ?? r4;
        ?? r5;
        boolean zN;
        ?? r6;
        String str2 = "1streqid";
        String strQg = "2ndreqid";
        com.byazt.vr.s sVarN = this.s.n();
        com.byazt.jeb.n nVarN = null;
        if (sVarN != null) {
            int length = 0;
            try {
                if (sVarN.qg() && list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    String str3 = "";
                    ?? Qg = 0;
                    ?? r7 = str2;
                    while (it.hasNext()) {
                        try {
                            com.byazt.vr.n nVar = (com.byazt.vr.n) it.next();
                            if (TextUtils.equals("show", com.byazt.hls.q.n(nVar))) {
                                String strN = com.byazt.hls.q.n(nVar.n());
                                if (Qg == 0) {
                                    try {
                                        Qg = com.byazt.hls.q.qg(nVar);
                                        r6 = Qg;
                                    } catch (Throwable th) {
                                        th = th;
                                        str = strN;
                                        bArrN = null;
                                        r4 = Qg;
                                        r5 = r7;
                                    }
                                } else {
                                    strQg = com.byazt.hls.q.qg(nVar);
                                    r6 = strQg;
                                }
                                r7 = r6;
                                Qg = 1;
                                str3 = strN;
                            }
                            arrayList.add(nVar);
                            Qg = Qg;
                            r7 = r7;
                        } catch (Throwable th2) {
                            th = th2;
                            bArrN = null;
                        }
                    }
                    int iQg = qg();
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    JSONObject jSONObjectN = n(arrayList, this.qg);
                    bArrN = n(jSONObjectN, iQg);
                    try {
                        if (bArrN == null) {
                            JSONObject jSONObjectN2 = n(jSONObjectN.toString());
                            bArrN = jSONObjectN2 == null ? new byte[0] : jSONObjectN2.toString().getBytes(StandardCharsets.UTF_8);
                            nVarN = n(bArrN, w(jSONObjectN2), "application/json; charset=utf-8");
                        } else {
                            nVarN = n(bArrN, s(iQg), n(iQg));
                        }
                        if (s(arrayList)) {
                            if (n(nVarN)) {
                                s("applog");
                                zN = n("applog", nVarN);
                            } else {
                                zN = false;
                            }
                            if (zN) {
                                qg("applog");
                                com.byazt.jeb.n nVarN2 = n(arrayList, iQg, nVarN);
                                if (nVarN2 != null) {
                                    nVarN = nVarN2;
                                }
                                if (nVarN != null) {
                                    nVarN.n(true);
                                }
                            }
                        }
                        if (Qg != 0) {
                            int length2 = bArrN != null ? bArrN.length : 0;
                            if (nVarN != null) {
                                com.byazt.hls.q.n(nVarN.n, nVarN.qg, nVarN.s, r7 + "|" + strQg, length2, str3, (cp) com.byazt.qp.q.n("csj_settings", this.x), nVarN.x, nVarN.fs);
                            }
                        }
                        return nVarN;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    str = str3;
                    r4 = Qg;
                    r5 = r7;
                    try {
                        x.n("uploadEvent error", th);
                        return new com.byazt.jeb.n(false, MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_NAME, th.getMessage(), false, "error");
                    } finally {
                        if (r4 != 0) {
                            int length3 = bArrN != null ? bArrN.length : 0;
                            if (nVarN != null) {
                                com.byazt.hls.q.n(nVarN.n, nVarN.qg, nVarN.s, r5 + "|" + strQg, length3, str, (cp) com.byazt.qp.q.n("csj_settings", this.x), nVarN.x, nVarN.fs);
                            }
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                str = "";
                bArrN = null;
                r4 = 0;
                r5 = str2;
            }
        }
        return null;
    }

    private JSONObject n(List<com.byazt.vr.n> list, boolean z) {
        return n(list, z, (com.byazt.xdz.n.qg) null, (com.byazt.jeb.n) null);
    }

    private JSONObject n(List<com.byazt.vr.n> list, boolean z, com.byazt.xdz.n.qg qgVar, com.byazt.jeb.n nVar) {
        if (list != null && !list.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            try {
                oa oaVar = (oa) com.byazt.qp.q.n("device_info_new");
                boolean z2 = false;
                n(list.get(0));
                JSONArray jSONArray = new JSONArray();
                Iterator<com.byazt.vr.n> it = list.iterator();
                String strN = null;
                while (it.hasNext()) {
                    JSONObject jSONObjectN = n(it.next(), qgVar, nVar);
                    if (TextUtils.equals("pangle_live_sdk_monitor", jSONObjectN.optString(NotificationCompat.CATEGORY_EVENT))) {
                        if (!z2) {
                            z2 = true;
                        }
                        jSONObjectN.putOpt("nt", Integer.valueOf(oaVar.n(60000L)));
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObjectN.optJSONObject("params");
                    if (jSONObjectOptJSONObject != null && TextUtils.isEmpty(strN)) {
                        strN = jSONObjectOptJSONObject.optString("plugin_version_name");
                    }
                    if (jSONObjectOptJSONObject != null) {
                        jSONObjectOptJSONObject.remove("plugin_version_name");
                    }
                    jSONArray.put(jSONObjectN);
                }
                if (TextUtils.isEmpty(strN)) {
                    strN = this.s.n().n();
                }
                jSONObject.put("header", n(list, z2, z, strN));
                jSONObject.put("event_v3", jSONArray);
                jSONObject.put("magic_tag", "ss_app_log");
                jSONObject.put("_gen_time", System.currentTimeMillis());
                return jSONObject;
            } catch (JSONException e) {
                x.q(e.getMessage());
            }
        }
        return null;
    }

    private JSONObject n(com.byazt.vr.n nVar, com.byazt.xdz.n.qg qgVar, com.byazt.jeb.n nVar2) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectN = nVar.n();
        if (qgVar == null || nVar2 == null || jSONObjectN == null) {
            return jSONObjectN;
        }
        JSONObject jSONObject = new JSONObject(jSONObjectN.toString());
        if (!com.byazt.asa.qg.n.contains(jSONObject.optString(NotificationCompat.CATEGORY_EVENT)) || (jSONObjectOptJSONObject = jSONObject.optJSONObject("params")) == null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        String strOptString = jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (!TextUtils.isEmpty(strOptString)) {
            jSONObject2 = new JSONObject(strOptString);
        }
        jSONObject2.put("error_msg", n(qgVar, n(nVar2.w, nVar2.s), nVar2.fs));
        jSONObjectOptJSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
        jSONObject.put("params", jSONObjectOptJSONObject);
        return jSONObject;
    }

    private boolean s(List<com.byazt.vr.n> list) {
        if (list != null && !list.isEmpty()) {
            for (com.byazt.vr.n nVar : list) {
                if (nVar != null && com.byazt.asa.qg.n.contains(nVar.k())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0050  */
    /* JADX WARN: Code duplicated, block: B:25:0x0065  */
    /* JADX WARN: Code duplicated, block: B:27:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0072  */
    /* JADX WARN: Code duplicated, block: B:30:0x008a  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b7  */
    private com.byazt.jeb.n n(List<com.byazt.vr.n> list, int i, com.byazt.jeb.n nVar) {
        String strQg;
        String str;
        com.byazt.jeb.n nVarQg;
        com.byazt.jeb.n nVar2;
        boolean z;
        String str2;
        Throwable th;
        JSONObject jSONObjectN;
        byte[] bArrN;
        JSONObject jSONObjectN2;
        byte[] bytes;
        List<com.byazt.xdz.n.qg> listQ = q("applog");
        if (listQ.isEmpty()) {
            n("applog", nVar == null ? null : nVar.w, list, "", false);
            return null;
        }
        listQ.size();
        if (nVar == null || TextUtils.isEmpty(nVar.fs)) {
            if (this.l == null) {
                str = "";
            } else {
                strQg = this.l.qg();
            }
            nVarQg = null;
            for (com.byazt.xdz.n.qg qgVar : listQ) {
                jSONObjectN = n(list, this.qg, qgVar, nVar);
                bArrN = n(jSONObjectN, i);
                if (bArrN == null) {
                    jSONObjectN2 = n(jSONObjectN.toString());
                    if (jSONObjectN2 == null) {
                        bytes = new byte[0];
                    } else {
                        bytes = jSONObjectN2.toString().getBytes(StandardCharsets.UTF_8);
                    }
                    nVarQg = qg(str, bytes, w(jSONObjectN2), "application/json; charset=utf-8", qgVar);
                } else {
                    nVarQg = qg(str, bArrN, s(i), n(i), qgVar);
                }
                if (nVarQg == null && nVarQg.n) {
                    break;
                }
            }
            nVar2 = nVarQg;
            if (nVar2 == null && nVar2.n) {
                z = true;
            } else {
                z = false;
            }
            if (nVar2 == null) {
                str2 = "";
            } else {
                str2 = nVar2.x;
            }
            if (nVar == null) {
                th = null;
            } else {
                th = nVar.w;
            }
            n("applog", th, list, str2, z);
            return nVar2;
        }
        strQg = nVar.fs;
        str = strQg;
        nVarQg = null;
        while (r12.hasNext()) {
            jSONObjectN = n(list, this.qg, qgVar, nVar);
            bArrN = n(jSONObjectN, i);
            if (bArrN == null) {
                jSONObjectN2 = n(jSONObjectN.toString());
                if (jSONObjectN2 == null) {
                    bytes = new byte[0];
                } else {
                    bytes = jSONObjectN2.toString().getBytes(StandardCharsets.UTF_8);
                }
                nVarQg = qg(str, bytes, w(jSONObjectN2), "application/json; charset=utf-8", qgVar);
            } else {
                nVarQg = qg(str, bArrN, s(i), n(i), qgVar);
            }
            if (nVarQg == null) {
            }
        }
        nVar2 = nVarQg;
        if (nVar2 == null) {
            z = false;
        } else {
            z = false;
        }
        if (nVar2 == null) {
            str2 = "";
        } else {
            str2 = nVar2.x;
        }
        if (nVar == null) {
            th = null;
        } else {
            th = nVar.w;
        }
        n("applog", th, list, str2, z);
        return nVar2;
    }

    public List<n> qg(List<com.byazt.vr.n> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            com.byazt.vr.s sVarN = this.s == null ? null : this.s.n();
            if (sVarN != null && sVarN.qg()) {
                int iQg = qg();
                com.byazt.jeb.n nVar = new com.byazt.jeb.n(false, -2, "db_high_priority_direct_connect", false, "error", null, "", this.l == null ? "" : this.l.qg());
                int size = list.size();
                int i = 0;
                while (i < size) {
                    int i2 = i + 100;
                    ArrayList arrayList2 = new ArrayList(list.subList(i, Math.min(i2, size)));
                    n(arrayList2.get(0));
                    com.byazt.jeb.n nVarN = n(arrayList2, iQg, nVar);
                    arrayList.add(new n(arrayList2, nVarN));
                    if (nVarN == null) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        return arrayList;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS, 48})
    public static final class n {
        public final List<com.byazt.vr.n> n;
        public final com.byazt.jeb.n qg;

        public n(List<com.byazt.vr.n> list, com.byazt.jeb.n nVar) {
            this.n = list;
            this.qg = nVar;
        }
    }

    private byte[] n(JSONObject jSONObject, int i) {
        byte[] bArrS = s(jSONObject);
        if (bArrS == null) {
            return null;
        }
        if (i > 3) {
            byte[] bArrN = this.cp.n(bArrS);
            if (bArrN != null) {
                return bArrN;
            }
            int iS = this.cp.s();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("error_code", 3);
                jSONObject2.put("cost_time", -1);
                jSONObject2.put("type", "applog");
                jSONObject2.put("armor_load_status", iS);
                this.s.n().n(jSONObject2);
                return bArrN;
            } catch (Exception unused) {
                return bArrN;
            }
        }
        return ((com.byazt.vf.s) com.byazt.qp.q.n("embed_applog")).n(bArrS, bArrS.length);
    }

    @JProtect
    private JSONObject n(List<com.byazt.vr.n> list, boolean z, boolean z2, String str) {
        JSONObject jSONObject = new JSONObject();
        if (z) {
            try {
                jSONObject.put("sdk_version", this.x.py());
                jSONObject.put("display_name", this.x.s());
                jSONObject.put("app_version", this.x.cd());
                jSONObject.put(AbsServerManager.PACKAGE_QUERY_BINDER, this.x.um());
                jSONObject.put("region", Locale.getDefault().getCountry());
                jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
                jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
                jSONObject.put("sig_hash", com.byazt.hls.n.n(this.q.getContext()));
                jSONObject.put("version_code", this.x.a());
            } catch (Throwable th) {
                x.q("log_net", th.getMessage());
            }
        }
        int i = 0;
        jSONObject.put("ua", this.w.qg(false));
        if (TextUtils.equals("privacy", this.s.n().s())) {
            jSONObject.put("udid_md5", com.byazt.xdz.n.s());
        } else {
            jSONObject.put("udid", this.w.qg((Boolean) null));
            jSONObject.put("mc", this.w.s((Boolean) null));
        }
        jSONObject.put("openudid", this.w.n());
        jSONObject.put("oaid", this.fs.n(false));
        jSONObject.put("ad_sdk_version", this.x.py());
        jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, str);
        jSONObject.put("is_plugin", this.x.ou());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("client_ipv4", this.s.n().l());
        jSONObject2.put("client_ipv6", ((oa) com.byazt.qp.q.n("device_info_new")).s(false)[1]);
        jSONObject.put("custom", jSONObject2);
        jSONObject.put("sim_op", this.w.h());
        jSONObject.put("root", z2 ? 1 : 0);
        jSONObject.put("timezone", this.w.cd());
        jSONObject.put("access", com.byazt.asa.q.n(((oa) com.byazt.qp.q.n("device_info_new")).n(60000L)));
        jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        if (TextUtils.isEmpty(this.sz)) {
            this.sz = n(this.q.getContext());
        }
        jSONObject.put("device_type", this.sz);
        jSONObject.put(TapEventParamConstants.PARAM_SUB_DEVICE_MODEL, this.w.qg());
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", Build.MANUFACTURER);
        jSONObject.put("language", Locale.getDefault().getLanguage());
        jSONObject.put("resolution", this.w.py() + com.byazt.af.x.n + this.w.ou());
        int iA = this.w.a();
        jSONObject.put("density_dpi", iA);
        jSONObject.put("display_density", qg(iA));
        jSONObject.put(TapEventParamConstants.PARAM_DEVICE_ID, this.s.n().q());
        int iS = com.byazt.hls.q.s(list);
        if (iS != 0) {
            jSONObject.put("aid", String.valueOf(iS));
        } else {
            jSONObject.put("aid", "1371");
        }
        jSONObject.put(TapEventParamConstants.PARAM_SUB_ROM, this.w.hd());
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", this.w.k());
        jSONObject.put("ut", this.oa);
        jSONObject.put("uid", this.d);
        jSONObject.put("locale_language", this.w.l());
        jSONObject.put("screen_bright", Math.ceil(this.w.bb() * 10.0f) / 10.0d);
        if (!this.w.ur()) {
            i = 1;
        }
        jSONObject.put("is_screen_off", i);
        jSONObject.put("download_channel", this.x.wm());
        jSONObject.put("mnc", this.w.x());
        jSONObject.put("mcc", this.w.w());
        jSONObject.put("pan_code_serial", "1000");
        return jSONObject;
    }

    private void n(com.byazt.vr.n nVar) {
        String strOptString;
        if (nVar == null) {
            return;
        }
        JSONObject jSONObjectN = nVar.n();
        JSONObject jSONObjectOptJSONObject = jSONObjectN.optJSONObject("params");
        if (jSONObjectOptJSONObject != null) {
            strOptString = jSONObjectOptJSONObject.optString("log_extra", "");
        } else {
            strOptString = jSONObjectN.optString("log_extra", "");
        }
        long jW = w(strOptString);
        int iX = x(strOptString);
        if (jW == 0) {
            jW = this.d;
        }
        this.d = jW;
        if (iX == 0) {
            iX = this.oa;
        }
        this.oa = iX;
    }

    private long w(String str) {
        return q(fs(str));
    }

    private long q(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong("uid", 0L);
        }
        return 0L;
    }

    private int x(String str) {
        return l(fs(str));
    }

    private JSONObject fs(String str) {
        if (TextUtils.isEmpty(str) || str == null || str.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static int l(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    private Map<String, String> w(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put(b.g, "application/json; charset=utf-8");
        if (jSONObject != null && jSONObject.length() > 0) {
            map.put("Content-Encoding", "union_sdk_encode");
        }
        return map;
    }

    private Map<String, String> s(int i) {
        HashMap map = new HashMap();
        if (i >= 4) {
            map.put("Content-Encoding", "union_sdk_encode");
            map.put("x-pglcypher", String.valueOf(i));
        }
        map.put(b.g, n(i));
        return map;
    }

    private com.byazt.jeb.n n(byte[] bArr, Map<String, String> map, String str) {
        int iX;
        boolean zQg;
        boolean z;
        int i;
        boolean z2;
        String str2;
        try {
            rv rvVarW = com.byazt.hls.q.w(this.l.qg());
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    rvVarW.n(entry.getKey(), entry.getValue());
                }
            }
            rvVarW.n(str, bArr);
            rvVarW.n(RequestParamsUtils.USER_AGENT_KEY, this.w.qg(false));
            com.byazt.qk.oa oaVarN = rvVarW.n();
            if (oaVarN == null) {
                return new com.byazt.jeb.n(false, MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_DIR, "RSP IS NULL", false, "error");
            }
            if (oaVarN.x()) {
                JSONObject jSONObjectL = oaVarN.l();
                zQg = qg(jSONObjectL);
                iX = x(jSONObjectL);
            } else {
                iX = 0;
                zQg = false;
            }
            int iN = oaVarN.n();
            Map<String, String> mapS = oaVarN.s();
            String str3 = mapS != null ? mapS.get("x-tt-logid") : "error";
            boolean z3 = !zQg && iN == 200;
            String strQg = oaVarN.qg();
            if (strQg == null || TextUtils.isEmpty(strQg)) {
                strQg = "DEFAULT OK";
            }
            if (iX != 0) {
                z2 = true;
                i = iX;
                z = false;
                str2 = "RSP FAIL";
            } else {
                z = zQg;
                i = iN;
                z2 = z3;
                str2 = strQg;
            }
            qg(bArr, map, str);
            String strOa = oaVarN.oa();
            if (TextUtils.isEmpty(strOa)) {
                strOa = this.l == null ? "" : this.l.qg();
            }
            return new com.byazt.jeb.n(z, i, str2, z2, str3, oaVarN.cp(), oaVarN.d(), strOa);
        } catch (Throwable th) {
            x.n("CSJ_EVENT_UPLOAD", "uploadEvent error", th);
            return new com.byazt.jeb.n(false, 511, th.getMessage(), false, "error", th);
        }
    }

    private com.byazt.jeb.n qg(String str, byte[] bArr, Map<String, String> map, String str2, com.byazt.xdz.n.qg qgVar) {
        int iX;
        boolean zQg;
        String str3;
        boolean z;
        int i;
        boolean z2;
        com.byazt.xdz.n.C0391n c0391nN = n(str, bArr, map, str2, qgVar);
        if (c0391nN == null) {
            return null;
        }
        if (!c0391nN.n) {
            Throwable th = c0391nN.x;
            return new com.byazt.jeb.n(false, 511, n(th, "direct_connect_error"), false, "error", th, qgVar.n, str);
        }
        String str4 = c0391nN.w;
        try {
            if (!c0391nN.q || c0391nN.l == null) {
                iX = 0;
                zQg = false;
            } else {
                JSONObject jSONObject = new JSONObject(new String(c0391nN.l, StandardCharsets.UTF_8));
                zQg = qg(jSONObject);
                iX = x(jSONObject);
            }
            int i2 = c0391nN.qg;
            boolean z3 = !zQg && i2 == 200;
            String str5 = c0391nN.s;
            if (TextUtils.isEmpty(str5)) {
                str5 = "DEFAULT OK";
            }
            if (iX != 0) {
                str3 = "RSP FAIL";
                i = iX;
                z = false;
                z2 = true;
            } else {
                str3 = str5;
                z = zQg;
                i = i2;
                z2 = z3;
            }
            return new com.byazt.jeb.n(z, i, str3, z2, str4, null, qgVar.n, str);
        } catch (Throwable th2) {
            return new com.byazt.jeb.n(false, 511, th2.getMessage(), false, str4, th2, qgVar.n, str);
        }
    }

    private void qg(byte[] bArr, Map<String, String> map, String str) {
        if (bArr == null || bArr.length == 0 || this.s == null || this.s.n() == null || !TextUtils.equals(this.x.n(), "5001121")) {
            return;
        }
        rv rvVarW = com.byazt.hls.q.w(this.l.s());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                rvVarW.n(entry.getKey(), entry.getValue());
            }
        }
        rvVarW.n(str, bArr);
        rvVarW.n(RequestParamsUtils.USER_AGENT_KEY, this.w.qg(false));
        rvVarW.n(new com.byazt.qk.x() { // from class: com.byazt.xdz.qg.1
            @Override // com.byazt.qk.x
            public void n(com.byazt.qk.oa oaVar) {
                if (oaVar != null && oaVar.x()) {
                    x.n("CSJ_EVENT_UPLOAD", "onResponse: " + oaVar.fs());
                } else {
                    x.n("CSJ_EVENT_UPLOAD", "onResponse: NetResponse is null");
                }
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str2, Throwable th) {
                x.n("CSJ_EVENT_UPLOAD", "onFailure: " + th.getMessage());
            }
        });
    }

    private int x(JSONObject jSONObject) {
        int iIndexOf;
        if (jSONObject == null) {
            return 0;
        }
        try {
            String strOptString = jSONObject.optString("s_sig_ts");
            if (strOptString == null || (iIndexOf = strOptString.indexOf("_")) < 5) {
                return 512;
            }
            String strSubstring = strOptString.substring(0, iIndexOf);
            if (n(this.s.n().q() + "_" + strSubstring, strOptString.substring(iIndexOf + 1))) {
                return Math.abs((System.currentTimeMillis() / 1000) - Long.valueOf(strSubstring).longValue()) > 300 ? 513 : 0;
            }
            return 512;
        } catch (Throwable unused) {
            return 512;
        }
    }

    private boolean n(String str, String str2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(l().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    private static PublicKey l() throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }
}
