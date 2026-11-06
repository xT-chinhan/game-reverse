package com.anythink.core.common.l;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.anythink.core.api.ATCustomRuleKeys;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.ATUserDeviceInfo;
import com.anythink.core.common.h.cb;
import com.varbto.utils.api.MediationUtilsManager;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final String A = "ps_id";
    public static final String B = "it_src";
    public static final String C = "lat";
    public static final String D = "lon";
    public static final String E = "inst_wx";
    public static final String F = "mini_sdk";
    public static final String G = "ms_type";
    public static final String H = "device_set";
    public static final String I = "gdpr_cs";
    public static final String J = "abtest_id";
    public static final String K = "first_init_time";
    public static final String L = "days_from_first_init";
    public static final String M = "cs_cl";
    public static final String N = "is_ofm";
    public static final String O = "app_id";
    public static final String P = "api_ver";
    public static final String Q = "custom";
    public static final String R = "data";
    public static final String S = "tcp_tk_da_type";
    public static final String T = "ofl";
    public static final String U = "tcp_rate";
    public static final String V = "sample_rate";
    public static final String W = "p";
    public static final String X = "p2";
    public static final String Y = "sign";
    public static final String Z = "common";
    public static final String a = "platform";
    public static final String aA = "u_a";
    public static final String aB = "b_p";
    public static final String aC = "d_s";
    public static final String aD = "s_d";
    public static final String aE = "a_cl";
    public static final String aF = "http_type";
    public static final String aG = "ip_v4";
    public static final String aH = "ip_v6";
    public static final String aI = "test_mode";
    public static final String aJ = "cpu";
    public static final String aK = "isroot";
    public static final String aL = "isagent";
    public static final String aM = "is_sim";
    public static final String aN = "is_mul";
    public static final String aO = "is_vpn";
    public static final String aP = "is_charge";
    public static final String aQ = "battery";
    public static final String aR = "http_able";
    public static final String aS = "bld_type";
    public static final String aT = "bld_tags";
    public static final String aU = "bld_user";
    public static final String aV = "bld_radio";
    public static final String aW = "bld_bootloader";
    public static final String aX = "bld_hardware";
    public static final String aY = "bld_host";
    public static final String aZ = "bld_codename";
    public static final int aa = 1;
    public static final int ab = 2;
    public static final int ac = 3;
    public static final String ad = "area_type";
    public static final String ae = "sp_http";
    public static final String af = "os_fw";
    public static final String ag = "is_test";
    public static final String ah = "user_num";
    public static final String ai = "cp_device_id";
    public static final String aj = "cp_pl_id";
    public static int ak = -1;
    public static int al = -1;
    public static final String am = "al_it_apil";
    public static final String an = "wx_data";
    public static final String ao = "cached";
    public static final String ap = "cached";
    public static final String aq = "n_cache";
    public static final String ar = "get_1st_rl";
    public static final String as = "value_d";
    public static final String at = "pl_type";
    public static final String au = "amazon_id";
    public static final String av = "amazon_lat";
    public static final String aw = "t_mem";
    public static final String ax = "c_num";
    public static final String ay = "t_store";
    public static final String az = "s_c";
    public static final String b = "os_vn";
    public static final String bA = "u_t";
    public static final String bB = "channel_from";
    public static final String bC = "is_fdevice";
    public static final String bD = "d_r_ls";
    public static final String bE = "sensor_deny";
    public static final String bF = "device_minor_data_deny";
    public static final String bG = "ail_deny";
    public static final String bH = "bil_deny";
    public static final String bI = "app_info";
    public static final String bJ = "accessibility_status";
    public static final String bK = "volume_status";
    public static final String bL = "build_info";
    public static final String bM = "properties_info";
    public static final String bN = "sys_ua";
    public static final String bO = "sp_nw";
    public static final String bP = "anr_sw";
    public static final String bQ = "new_upid";
    public static final String bR = "open_ns";
    public static final String bS = "mb_track_id";
    public static final String bT = "req_rsn";
    public static final String bU = "host";
    public static final String bV = "anr_num";
    public static final String bW = "dyn_score";
    public static final String bX = "static_score";
    public static final String bY = "mmed_m_a_c";
    public static final String bZ = "pg_ctm";
    public static final String ba = "bld_incremental";
    public static final String bb = "bld_serial";
    public static final String bc = "bld_display";
    public static final String bd = "bld_version_codes";
    public static final String be = "bld_board";
    public static final String bf = "ps";
    public static final String bg = "pm";
    public static final String bh = "is_s";
    public static final String bi = "m_data";
    public static final String bj = "sdk_ext";
    public static final String bk = "pil_s_fu";
    public static final String bl = "al_it_apil_t";
    public static final String bm = "demand_ids";
    public static final String bn = "pl_id";
    public static final String bo = "session_id";
    public static final String bp = "debug_key";
    public static final String bq = "wf";
    public static final String br = "sdk_time";
    public static final String bs = "sdk_start_time";
    public static final String bt = "cpu_d";
    public static final String bu = "mem_d";
    public static final String bv = "stack_d";
    public static final String bw = "stack_s";
    public static final String bx = "cpu_info_s";
    public static final String by = "cpu_core_c";
    public static final String bz = "mem_t_s";
    public static final String c = "os_vc";
    public static final String d = "package_name";
    public static final String e = "app_vn";
    public static final String f = "app_vc";
    public static final String g = "brand";
    public static final String h = "model";
    public static final String i = "screen";
    public static final String j = "network_type";
    public static final String k = "mnc";
    public static final String l = "mcc";
    public static final String m = "language";
    public static final String n = "timezone";
    public static final String o = "sdk_ver";
    public static final String p = "gp_ver";
    public static final String q = "nw_ver";
    public static final String r = "ua";
    public static final String s = "orient";
    public static final String t = "system";
    public static final String u = "oaid";
    public static final String v = "android_id";
    public static final String w = "gaid";
    public static final String x = "channel";
    public static final String y = "sub_channel";
    public static final String z = "upid";

    public static JSONObject a(int i2) {
        return a(i2, (List<String>) null);
    }

    public static JSONObject a(int i2, List<String> list) {
        String str;
        JSONArray[] jSONArrayArrB;
        Map<String, String> mapC;
        JSONObject jSONObjectAV;
        com.anythink.core.common.u.l.o(com.anythink.core.common.d.s.b().g());
        JSONObject jSONObject = new JSONObject();
        Context contextG = com.anythink.core.common.d.s.b().g();
        try {
            jSONObject.put("cpu", com.anythink.core.common.u.l.r());
            jSONObject.put("platform", 1);
            jSONObject.put("os_vn", com.anythink.core.common.u.l.e());
            jSONObject.put("os_vc", com.anythink.core.common.u.l.d());
            jSONObject.put("package_name", com.anythink.core.common.u.l.j(contextG));
            jSONObject.put("app_vn", com.anythink.core.common.u.l.h(contextG));
            jSONObject.put("app_vc", com.anythink.core.common.u.l.g(contextG));
            jSONObject.put("brand", com.anythink.core.common.u.l.b());
            jSONObject.put("model", com.anythink.core.common.u.l.a());
            jSONObject.put("screen", com.anythink.core.common.u.l.i(contextG));
            jSONObject.put("network_type", com.anythink.core.common.u.l.l(contextG));
            jSONObject.put("mnc", com.anythink.core.common.u.l.c(contextG));
            jSONObject.put("mcc", com.anythink.core.common.u.l.b(contextG));
            jSONObject.put("language", com.anythink.core.common.u.l.e(contextG));
            jSONObject.put("timezone", com.anythink.core.common.u.l.c());
            jSONObject.put("sdk_ver", com.anythink.core.common.u.o.a());
            jSONObject.put("gp_ver", com.anythink.core.common.u.l.g());
            jSONObject.put("ua", com.anythink.core.common.u.l.i());
            jSONObject.put("orient", com.anythink.core.common.u.l.f(contextG));
            jSONObject.put("system", 1);
            if (!TextUtils.isEmpty(com.anythink.core.common.d.s.b().n())) {
                jSONObject.put("channel", com.anythink.core.common.d.s.b().n());
            }
            if (!TextUtils.isEmpty(com.anythink.core.common.d.s.b().o())) {
                jSONObject.put("sub_channel", com.anythink.core.common.d.s.b().o());
            }
            String strD = "";
            jSONObject.put("upid", com.anythink.core.common.d.u.a(contextG).b() ? com.anythink.core.common.d.s.b().C() : "");
            jSONObject.put("ps_id", com.anythink.core.common.d.s.b().r());
            com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(contextG).b(com.anythink.core.common.d.s.b().p());
            if (bVarB != null) {
                if (!TextUtils.isEmpty(bVarB.D())) {
                    strD = bVarB.D();
                }
                jSONObject.put(J, strD);
            }
            jSONObject.put(K, com.anythink.core.common.d.s.b().h());
            jSONObject.put(L, com.anythink.core.common.d.s.b().i());
            jSONObject.put(I, new StringBuilder().append(com.anythink.core.common.d.s.b().e()).append(com.anythink.core.common.d.u.a(contextG).a()).toString());
            if (com.anythink.core.common.d.s.b().j() == 1) {
                jSONObject.put(N, 1);
            }
            jSONObject.put(bO, 1);
            if (com.anythink.core.common.d.s.b().K()) {
                str = com.anythink.core.common.d.s.b().L() ? "1" : "3";
            } else {
                str = com.anythink.core.common.d.s.b().L() ? "2" : "4";
            }
            jSONObject.put(ae, str);
            com.anythink.core.common.d.r rVarC = com.anythink.core.common.d.s.b().c();
            if (rVarC != null) {
                rVarC.fillRequestDeviceData(jSONObject, i2);
            }
            String strL = com.anythink.core.common.u.l.l();
            if (!TextUtils.isEmpty(strL)) {
                jSONObject.put(af, Integer.parseInt(strL));
            }
            if ((i2 & 4) == 4) {
                try {
                    com.anythink.core.e.b bVarB2 = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
                    if (bVarB2 != null && (jSONObjectAV = bVarB2.aV()) != null) {
                        jSONObject.put("a_c", jSONObjectAV);
                    }
                } catch (Exception unused) {
                }
            }
            if ((i2 & 16) == 16 && (mapC = com.anythink.core.common.c.b.a().c()) != null && !mapC.isEmpty()) {
                for (Map.Entry<String, String> entry : mapC.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                        jSONObject.put(key, value);
                    }
                }
            }
            if ((i2 & 64) == 64) {
                jSONObject.put("isroot", com.anythink.core.common.u.l.s());
                jSONObject.put("isagent", com.anythink.core.common.u.l.s(contextG));
                jSONObject.put(aM, com.anythink.core.common.u.l.u(contextG));
                jSONObject.put(aN, com.anythink.core.common.u.l.v(contextG));
                jSONObject.put(aO, com.anythink.core.common.u.l.t(contextG));
                jSONObject.put(aP, com.anythink.core.common.u.l.w(contextG));
                jSONObject.put("battery", com.anythink.core.common.u.l.x(contextG));
                jSONObject.put(aR, com.anythink.core.common.u.l.t());
            }
            if ((i2 & 128) == 128 && (jSONArrayArrB = com.anythink.core.common.c.b.a().b()) != null && jSONArrayArrB.length == 2) {
                JSONArray jSONArray = jSONArrayArrB[0];
                if (jSONArray != null && jSONArray.length() > 0) {
                    jSONObject.put(am, jSONArray);
                }
                JSONArray jSONArray2 = jSONArrayArrB[1];
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    jSONObject.put(bl, jSONArray2);
                }
            }
            jSONObject.put(bf, com.anythink.core.common.u.n.b(com.anythink.core.common.u.l.b(contextG, bf)));
            jSONObject.put(bg, com.anythink.core.common.u.n.b(com.anythink.core.common.u.l.c(contextG, bg)));
            if (bVarB != null && list != null && list.contains("http_type") && bVarB.aC() == 2) {
                jSONObject.put("http_type", 1);
            }
            if (ATSDK.isCnSDK()) {
                jSONObject.put("app_id", com.anythink.core.common.d.s.b().p());
                com.anythink.core.bridge.a.b.a().a(com.anythink.core.common.d.s.b().g(), jSONObject);
            }
            try {
                Map<String, Object> staticPerformanceDataMap = MediationUtilsManager.getInstance(contextG).getStaticPerformanceDataMap();
                if (staticPerformanceDataMap != null) {
                    for (Map.Entry<String, Object> entry2 : staticPerformanceDataMap.entrySet()) {
                        jSONObject.put(entry2.getKey(), entry2.getValue());
                    }
                }
            } catch (Throwable unused2) {
            }
            b(jSONObject);
            JSONObject jSONObjectAh = com.anythink.core.common.d.s.b().ah();
            if (jSONObjectAh != null) {
                jSONObject.put("mmed_m_a_c", jSONObjectAh);
            }
            String strW = com.anythink.core.common.d.s.b().w();
            if (!TextUtils.isEmpty(strW)) {
                jSONObject.put(bZ, strW);
            }
        } catch (Exception unused3) {
        }
        return jSONObject;
    }

    public static JSONObject b(int i2) {
        return b(i2, (List<String>) null);
    }

    /* JADX WARN: Code duplicated, block: B:150:0x0322 A[Catch: all -> 0x033e, TRY_LEAVE, TryCatch #3 {all -> 0x033e, blocks: (B:4:0x0023, B:6:0x0029, B:9:0x0030, B:11:0x003b, B:18:0x0049, B:20:0x004f, B:22:0x0065, B:23:0x0068, B:26:0x0070, B:28:0x007b, B:30:0x0089, B:31:0x009b, B:33:0x00a9, B:34:0x00b2, B:37:0x00bb, B:41:0x00ce, B:52:0x00eb, B:56:0x00f3, B:61:0x0102, B:63:0x010c, B:65:0x0123, B:66:0x0128, B:68:0x012e, B:69:0x0133, B:71:0x0139, B:72:0x013e, B:74:0x014d, B:75:0x0152, B:82:0x0180, B:84:0x018a, B:85:0x018f, B:87:0x0195, B:88:0x019a, B:90:0x01a0, B:92:0x01aa, B:93:0x01b7, B:95:0x01c1, B:96:0x01ce, B:98:0x01dc, B:99:0x01e9, B:101:0x01ee, B:103:0x01f8, B:104:0x01fd, B:106:0x0207, B:107:0x020c, B:109:0x0216, B:110:0x021b, B:112:0x0225, B:113:0x022a, B:115:0x0234, B:116:0x0239, B:118:0x0243, B:119:0x0248, B:121:0x0252, B:122:0x0257, B:124:0x0261, B:125:0x0266, B:127:0x0270, B:128:0x0275, B:130:0x027f, B:131:0x0284, B:133:0x028e, B:134:0x0293, B:136:0x029d, B:137:0x02a2, B:139:0x02ac, B:141:0x02b3, B:143:0x02bb, B:144:0x02df, B:147:0x02fb, B:148:0x02fe, B:150:0x0322, B:57:0x00f7, B:59:0x00fd, B:60:0x0100, B:42:0x00d2, B:50:0x00e6, B:51:0x00e9, B:27:0x0076), top: B:162:0x0023, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0044  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.anythink.core.common.d.r] */
    /* JADX WARN: Type inference failed for: r10v7, types: [com.anythink.core.bridge.a.b] */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    public static JSONObject b(int i2, List<String> list) {
        String strI;
        boolean z2;
        Context contextG = com.anythink.core.common.d.s.b().g();
        ?? jSONObject = new JSONObject();
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(contextG).b(com.anythink.core.common.d.s.b().p());
        if (bVarB != null) {
            try {
                strI = bVarB.I();
            } catch (Throwable unused) {
            }
        } else {
            strI = "";
        }
        if (TextUtils.isEmpty(strI)) {
            z2 = true;
        } else {
            try {
                JSONObject jSONObject2 = new JSONObject(strI);
                if (jSONObject2.isNull("a") || jSONObject2.optInt("a") == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (Exception unused2) {
            }
        }
        jSONObject.put("android_id", z2 ? com.anythink.core.common.u.l.d(contextG) : "");
        jSONObject.put("gaid", com.anythink.core.common.u.l.f());
        ?? C2 = com.anythink.core.common.d.s.b().c();
        if (C2 != 0) {
            C2.fillRequestData(jSONObject, bVarB, i2);
        }
        if (ATSDK.isCnSDK()) {
            jSONObject.put("is_cn_sdk", "1");
        } else {
            jSONObject.put("is_cn_sdk", "0");
        }
        String strK = com.anythink.core.common.u.l.k(contextG);
        Location locationT = com.anythink.core.common.d.s.b().t();
        if (locationT != null) {
            jSONObject.put("lat", locationT.getLatitude());
            jSONObject.put(D, locationT.getLongitude());
        }
        String strU = com.anythink.core.common.d.s.b().u();
        if (!TextUtils.isEmpty(strU)) {
            jSONObject.put(E, Integer.parseInt(strU));
        }
        jSONObject.put("it_src", TextUtils.isEmpty(strK) ? "" : strK);
        jSONObject.put(ad, com.anythink.core.common.d.i.f.a);
        int i3 = ak;
        if (i3 == -1) {
            boolean zC = com.anythink.core.common.u.o.c(contextG);
            boolean zB = com.anythink.core.common.u.o.b(contextG);
            ?? r6 = zB ? 2 : zC;
            if (zC && zB) {
                r6 = 3;
            }
            if (r6 > 0) {
                jSONObject.put(G, r6);
            }
            ak = r6;
        } else if (i3 > 0) {
            jSONObject.put(G, i3);
        }
        int i4 = al;
        if (i4 == -1) {
            boolean zC2 = com.anythink.core.common.u.o.c();
            if (zC2) {
                jSONObject.put(F, 1);
            }
            al = zC2 ? 1 : 0;
        } else if (i4 == 1) {
            jSONObject.put(F, i4);
        }
        ATUserDeviceInfo aTUserDeviceInfoQ = com.anythink.core.common.d.s.b().Q();
        if (aTUserDeviceInfoQ != null) {
            String devGaid = aTUserDeviceInfoQ.getDevGaid();
            String devImei = aTUserDeviceInfoQ.getDevImei();
            String devOaid = aTUserDeviceInfoQ.getDevOaid();
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(devGaid)) {
                jSONObject3.put("set_gaid", devGaid);
            }
            if (!TextUtils.isEmpty(devImei)) {
                jSONObject3.put("set_imei", devImei);
            }
            if (!TextUtils.isEmpty(devOaid)) {
                jSONObject3.put("set_oaid", devOaid);
            }
            jSONObject.put(H, jSONObject3);
            String devUID2Token = aTUserDeviceInfoQ.getDevUID2Token();
            if (!TextUtils.isEmpty(devUID2Token)) {
                jSONObject.put(bA, devUID2Token);
            }
        }
        Map<String, Object> mapM = com.anythink.core.common.d.s.b().m();
        try {
            Object obj = mapM.get(ATCustomRuleKeys.USER_NUMBER);
            if (obj != null) {
                jSONObject.put(ah, Long.parseLong(obj.toString()));
            }
        } catch (Throwable unused3) {
        }
        try {
            Object obj2 = mapM.get(ATCustomRuleKeys.USER_DEVICE_ID);
            if (obj2 != null) {
                jSONObject.put(ai, obj2.toString());
            }
        } catch (Throwable unused4) {
        }
        String strP = com.anythink.core.common.u.l.p();
        if (!TextUtils.isEmpty(strP)) {
            jSONObject.put("amazon_id", strP);
        }
        int iQ = com.anythink.core.common.u.l.q();
        if (iQ > 0) {
            jSONObject.put(av, iQ);
        }
        if ((i2 & 32) == 32) {
            if (com.anythink.core.common.n.e.a().f() > 0) {
                jSONObject.put("t_mem", com.anythink.core.common.n.e.a().f());
            }
            if (com.anythink.core.common.n.e.a().g() > 0) {
                jSONObject.put("c_num", com.anythink.core.common.n.e.a().g());
            }
            if (com.anythink.core.common.n.e.a().h() > 0) {
                jSONObject.put("t_store", com.anythink.core.common.n.e.a().h());
            }
        }
        if ((i2 & 64) == 64) {
            String strU2 = com.anythink.core.common.u.l.u();
            if (!TextUtils.isEmpty(strU2)) {
                jSONObject.put("bld_type", strU2);
            }
            String strV = com.anythink.core.common.u.l.v();
            if (!TextUtils.isEmpty(strV)) {
                jSONObject.put("bld_tags", strV);
            }
            String strW = com.anythink.core.common.u.l.w();
            if (!TextUtils.isEmpty(strW)) {
                jSONObject.put("bld_user", strW);
            }
            String strX = com.anythink.core.common.u.l.x();
            if (!TextUtils.isEmpty(strX)) {
                jSONObject.put("bld_radio", strX);
            }
            String strY = com.anythink.core.common.u.l.y();
            if (!TextUtils.isEmpty(strY)) {
                jSONObject.put("bld_bootloader", strY);
            }
            String strZ = com.anythink.core.common.u.l.z();
            if (!TextUtils.isEmpty(strZ)) {
                jSONObject.put("bld_hardware", strZ);
            }
            String strA = com.anythink.core.common.u.l.A();
            if (!TextUtils.isEmpty(strA)) {
                jSONObject.put("bld_host", strA);
            }
            String strB = com.anythink.core.common.u.l.B();
            if (!TextUtils.isEmpty(strB)) {
                jSONObject.put("bld_codename", strB);
            }
            String strC = com.anythink.core.common.u.l.C();
            if (!TextUtils.isEmpty(strC)) {
                jSONObject.put("bld_incremental", strC);
            }
            String strD = com.anythink.core.common.u.l.D();
            if (!TextUtils.isEmpty(strD)) {
                jSONObject.put("bld_serial", strD);
            }
            String strE = com.anythink.core.common.u.l.E();
            if (!TextUtils.isEmpty(strE)) {
                jSONObject.put("bld_display", strE);
            }
            String strF = com.anythink.core.common.u.l.F();
            if (!TextUtils.isEmpty(strF)) {
                jSONObject.put("bld_version_codes", strF);
            }
            String strG = com.anythink.core.common.u.l.G();
            if (!TextUtils.isEmpty(strG)) {
                jSONObject.put("bld_board", strG);
            }
        }
        if (list != null && list.contains(com.anythink.core.common.d.i.ac.a)) {
            jSONObject.put("s_c", com.anythink.core.common.u.l.z(contextG));
            jSONObject.put("u_a", com.anythink.core.common.u.l.A(contextG));
            jSONObject.put(aB, com.anythink.core.common.u.l.B(contextG));
            jSONObject.put("d_s", com.anythink.core.common.u.l.C(contextG));
            try {
                jSONObject.put(aD, Integer.parseInt(com.anythink.core.common.u.l.u(contextG)));
                jSONObject.put(aE, Integer.parseInt(com.anythink.core.common.u.l.v(contextG)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            jSONObject.put("ip_v4", com.anythink.core.common.u.l.I());
            jSONObject.put("ip_v6", com.anythink.core.common.u.l.J());
            com.anythink.core.common.b.f.a();
            jSONObject.put("anr_sw", com.anythink.core.common.b.f.c());
            if (ATSDK.isCnSDK()) {
                jSONObject.put("app_id", com.anythink.core.common.d.s.b().p());
                com.anythink.core.bridge.a.b.a().b(com.anythink.core.common.d.s.b().g(), jSONObject);
            }
        } else {
            jSONObject.put("ip_v4", com.anythink.core.common.u.l.I());
            jSONObject.put("ip_v6", com.anythink.core.common.u.l.J());
            com.anythink.core.common.b.f.a();
            jSONObject.put("anr_sw", com.anythink.core.common.b.f.c());
            if (ATSDK.isCnSDK()) {
                jSONObject.put("app_id", com.anythink.core.common.d.s.b().p());
                com.anythink.core.bridge.a.b.a().b(com.anythink.core.common.d.s.b().g(), jSONObject);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.json.JSONObject] */
    private static void b(Context context, JSONObject jSONObject) throws JSONException {
        int i2 = ak;
        if (i2 == -1) {
            boolean zC = com.anythink.core.common.u.o.c(context);
            boolean zB = com.anythink.core.common.u.o.b(context);
            ?? r3 = zB ? 2 : zC;
            if (zC && zB) {
                r3 = 3;
            }
            if (r3 > 0) {
                jSONObject.put(G, r3);
            }
            ak = r3;
        } else if (i2 > 0) {
            jSONObject.put(G, i2);
        }
        int i3 = al;
        if (i3 != -1) {
            if (i3 == 1) {
                jSONObject.put(F, i3);
            }
        } else {
            boolean zC2 = com.anythink.core.common.u.o.c();
            if (zC2) {
                jSONObject.put(F, 1);
            }
            al = zC2 ? 1 : 0;
        }
    }

    private static void c(JSONObject jSONObject) throws JSONException {
        ATUserDeviceInfo aTUserDeviceInfoQ = com.anythink.core.common.d.s.b().Q();
        if (aTUserDeviceInfoQ != null) {
            String devGaid = aTUserDeviceInfoQ.getDevGaid();
            String devImei = aTUserDeviceInfoQ.getDevImei();
            String devOaid = aTUserDeviceInfoQ.getDevOaid();
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(devGaid)) {
                jSONObject2.put("set_gaid", devGaid);
            }
            if (!TextUtils.isEmpty(devImei)) {
                jSONObject2.put("set_imei", devImei);
            }
            if (!TextUtils.isEmpty(devOaid)) {
                jSONObject2.put("set_oaid", devOaid);
            }
            jSONObject.put(H, jSONObject2);
            String devUID2Token = aTUserDeviceInfoQ.getDevUID2Token();
            if (TextUtils.isEmpty(devUID2Token)) {
                return;
            }
            jSONObject.put(bA, devUID2Token);
        }
    }

    public static void a(JSONObject jSONObject) {
        try {
            cb cbVarR = com.anythink.core.common.d.s.b().R();
            JSONObject jSONObject2 = new JSONObject();
            int i2 = 1;
            if (cbVarR.b() != 1) {
                i2 = 0;
            }
            jSONObject2.put("has_sdk", i2);
            jSONObject2.put("sdk_ver", String.valueOf(cbVarR.c()));
            jSONObject2.put("sdk_api_ver", String.valueOf(cbVarR.d()));
            jSONObject2.put("open_app_id", com.anythink.core.common.u.l.n());
            jSONObject.put(an, jSONObject2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject a() {
        return a(com.anythink.core.common.d.s.b().m());
    }

    public static JSONObject a(String str) {
        return a(com.anythink.core.common.d.s.b().d(str));
    }

    public static JSONObject a(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str : map.keySet()) {
                    Object obj = map.get(str);
                    if (obj != null) {
                        try {
                            jSONObject.put(str, obj.toString());
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            return jSONObject;
        } catch (Throwable unused3) {
            return null;
        }
    }

    public static void a(Context context, JSONObject jSONObject) throws JSONException {
        jSONObject.put("app_id", com.anythink.core.common.d.s.b().p());
        boolean z2 = true;
        jSONObject.put("platform", 1);
        jSONObject.put("sdk_ver", com.anythink.core.common.u.o.a());
        jSONObject.put("upid", com.anythink.core.common.d.u.a(context).b() ? com.anythink.core.common.d.s.b().C() : "");
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(context).b(com.anythink.core.common.d.s.b().p());
        String strI = bVarB != null ? bVarB.I() : "";
        if (!TextUtils.isEmpty(strI)) {
            try {
                JSONObject jSONObject2 = new JSONObject(strI);
                if (!jSONObject2.isNull("a") && jSONObject2.optInt("a") != 1) {
                    z2 = false;
                }
            } catch (Exception unused) {
            }
        }
        jSONObject.put("android_id", z2 ? com.anythink.core.common.u.l.d(context) : "");
        jSONObject.put("gaid", com.anythink.core.common.u.l.f());
        com.anythink.core.common.d.r rVarC = com.anythink.core.common.d.s.b().c();
        if (rVarC != null) {
            rVarC.fillRequestData(jSONObject, bVarB, -1);
        }
    }

    public static void b(JSONObject jSONObject) throws JSONException {
        com.anythink.core.common.b.f.a();
        jSONObject.put(bV, com.anythink.core.common.b.f.g());
        com.anythink.core.common.b.f.a();
        jSONObject.put(bW, com.anythink.core.common.b.f.h());
        com.anythink.core.common.b.f.a();
        jSONObject.put(bX, com.anythink.core.common.b.f.i());
    }
}
