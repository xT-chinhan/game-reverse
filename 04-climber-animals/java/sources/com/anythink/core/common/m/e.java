package com.anythink.core.common.m;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.anythink.core.api.ATCustomRuleKeys;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.ATUserDeviceInfo;
import com.anythink.core.common.h.by;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {
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
    public static final String V = "p";
    public static final String W = "p2";
    public static final String X = "sign";
    public static final String Y = "common";
    public static final int Z = 1;
    public static final String a = "platform";
    public static final String aA = "b_p";
    public static final String aB = "d_s";
    public static final String aC = "s_d";
    public static final String aD = "a_cl";
    public static final String aE = "ip_v4";
    public static final String aF = "ip_v6";
    public static final String aG = "cpu";
    public static final String aH = "isroot";
    public static final String aI = "isagent";
    public static final String aJ = "is_sim";
    public static final String aK = "is_mul";
    public static final String aL = "is_vpn";
    public static final String aM = "is_charge";
    public static final String aN = "battery";
    public static final String aO = "http_able";
    public static final String aP = "bld_type";
    public static final String aQ = "bld_tags";
    public static final String aR = "bld_user";
    public static final String aS = "bld_radio";
    public static final String aT = "bld_bootloader";
    public static final String aU = "bld_hardware";
    public static final String aV = "bld_host";
    public static final String aW = "bld_codename";
    public static final String aX = "bld_incremental";
    public static final String aY = "bld_serial";
    public static final String aZ = "bld_display";
    public static final int aa = 2;
    public static final int ab = 3;
    public static final String ac = "area_type";
    public static final String ad = "sp_http";
    public static final String ae = "os_fw";
    public static final String af = "is_test";
    public static final String ag = "user_num";
    public static final String ah = "cp_device_id";
    public static final String ai = "cp_pl_id";
    public static int aj = -1;
    public static int ak = -1;
    public static final String al = "al_it_apil";
    public static final String am = "wx_data";
    public static final String an = "cached";
    public static final String ao = "cached";
    public static final String ap = "n_cache";
    public static final String aq = "get_1st_rl";
    public static final String ar = "value_d";
    public static final String as = "pl_type";
    public static final String at = "amazon_id";
    public static final String au = "amazon_lat";
    public static final String av = "t_mem";
    public static final String aw = "c_num";
    public static final String ax = "t_store";
    public static final String ay = "s_c";
    public static final String az = "u_a";
    public static final String b = "os_vn";
    public static final String ba = "bld_version_codes";
    public static final String bb = "bld_board";
    public static final String bc = "ps";
    public static final String bd = "pm";
    public static final String be = "is_s";
    public static final String bf = "m_data";
    public static final String bg = "sdk_ext";
    public static final String bh = "pil_s_fu";
    public static final String bi = "al_it_apil_t";
    public static final String bj = "demand_ids";
    public static final String bk = "pl_id";
    public static final String bl = "session_id";
    public static final String bm = "debug_key";
    public static final String bn = "wf";
    public static final String bo = "u_t";
    public static final String bp = "channel_from";
    public static final String bq = "is_fdevice";
    public static final String br = "d_r_ls";
    public static final String bs = "sensor_deny";
    public static final String bt = "device_minor_data_deny";
    public static final String bu = "ail_deny";
    public static final String bv = "bil_deny";
    public static final String bw = "sys_ua";
    public static final String bx = "sp_nw";
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
        String str;
        JSONObject jSONObjectAU;
        com.anythink.core.common.v.m.r(com.anythink.core.common.d.t.b().g());
        JSONObject jSONObject = new JSONObject();
        Context contextG = com.anythink.core.common.d.t.b().g();
        try {
            jSONObject.put("cpu", com.anythink.core.common.v.m.r());
            jSONObject.put("platform", 1);
            jSONObject.put("os_vn", com.anythink.core.common.v.m.e());
            jSONObject.put("os_vc", com.anythink.core.common.v.m.d());
            jSONObject.put("package_name", com.anythink.core.common.v.m.m(contextG));
            jSONObject.put("app_vn", com.anythink.core.common.v.m.i(contextG));
            jSONObject.put("app_vc", com.anythink.core.common.v.m.h(contextG));
            jSONObject.put("brand", com.anythink.core.common.v.m.b());
            jSONObject.put("model", com.anythink.core.common.v.m.a());
            jSONObject.put("screen", com.anythink.core.common.v.m.l(contextG));
            jSONObject.put("network_type", com.anythink.core.common.v.m.o(contextG));
            jSONObject.put("mnc", com.anythink.core.common.v.m.c(contextG));
            jSONObject.put("mcc", com.anythink.core.common.v.m.b(contextG));
            jSONObject.put("language", com.anythink.core.common.v.m.e(contextG));
            jSONObject.put("timezone", com.anythink.core.common.v.m.c());
            jSONObject.put("sdk_ver", com.anythink.core.common.v.p.a());
            jSONObject.put("gp_ver", com.anythink.core.common.v.m.g());
            jSONObject.put("ua", com.anythink.core.common.v.m.i());
            jSONObject.put("orient", com.anythink.core.common.v.m.f(contextG));
            jSONObject.put("system", 1);
            if (!TextUtils.isEmpty(com.anythink.core.common.d.t.b().n())) {
                jSONObject.put("channel", com.anythink.core.common.d.t.b().n());
            }
            if (!TextUtils.isEmpty(com.anythink.core.common.d.t.b().o())) {
                jSONObject.put("sub_channel", com.anythink.core.common.d.t.b().o());
            }
            String strL = "";
            jSONObject.put("upid", com.anythink.core.common.d.v.a(contextG).b() ? com.anythink.core.common.d.t.b().B() : "");
            jSONObject.put("ps_id", com.anythink.core.common.d.t.b().r());
            com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(contextG).b(com.anythink.core.common.d.t.b().p());
            if (bVarB != null) {
                if (!TextUtils.isEmpty(bVarB.L())) {
                    strL = bVarB.L();
                }
                jSONObject.put(J, strL);
            }
            jSONObject.put(K, com.anythink.core.common.d.t.b().h());
            jSONObject.put(L, com.anythink.core.common.d.t.b().i());
            jSONObject.put(I, new StringBuilder().append(com.anythink.core.common.d.t.b().e()).append(com.anythink.core.common.d.v.a(contextG).a()).toString());
            if (com.anythink.core.common.d.t.b().j() == 1) {
                jSONObject.put(N, 1);
            }
            jSONObject.put(bx, 1);
            if (com.anythink.core.common.d.t.b().K()) {
                str = com.anythink.core.common.d.t.b().L() ? "1" : "3";
            } else {
                str = com.anythink.core.common.d.t.b().L() ? "2" : "4";
            }
            jSONObject.put(ad, str);
            com.anythink.core.common.d.s sVarC = com.anythink.core.common.d.t.b().c();
            if (sVarC != null) {
                sVarC.fillRequestDeviceData(jSONObject, i2);
            }
            String strL2 = com.anythink.core.common.v.m.l();
            if (!TextUtils.isEmpty(strL2)) {
                jSONObject.put(ae, Integer.parseInt(strL2));
            }
            if ((i2 & 4) == 4) {
                try {
                    com.anythink.core.d.b bVarB2 = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
                    if (bVarB2 != null && (jSONObjectAU = bVarB2.aU()) != null) {
                        jSONObject.put("a_c", jSONObjectAU);
                    }
                } catch (Exception unused) {
                }
            }
            if ((i2 & 16) == 16) {
                List<com.anythink.core.common.c.c> listD = com.anythink.core.common.c.b.a().d();
                if (listD.size() > 0) {
                    for (int i3 = 0; i3 < listD.size(); i3++) {
                        com.anythink.core.common.c.c cVar = listD.get(i3);
                        if (cVar != null && !TextUtils.isEmpty(cVar.e()) && !TextUtils.isEmpty(cVar.c())) {
                            jSONObject.put(cVar.e(), cVar.c());
                        }
                    }
                }
            }
            if ((i2 & 64) == 64) {
                jSONObject.put("isroot", com.anythink.core.common.v.m.s());
                jSONObject.put("isagent", com.anythink.core.common.v.m.u(contextG));
                jSONObject.put(aJ, com.anythink.core.common.v.m.w(contextG));
                jSONObject.put(aK, com.anythink.core.common.v.m.x(contextG));
                jSONObject.put(aL, com.anythink.core.common.v.m.v(contextG));
                jSONObject.put(aM, com.anythink.core.common.v.m.y(contextG));
                jSONObject.put("battery", com.anythink.core.common.v.m.z(contextG));
                jSONObject.put(aO, com.anythink.core.common.v.m.t());
            }
            if ((i2 & 128) == 128) {
                JSONArray[] jSONArrayArrC = com.anythink.core.common.c.b.a().c();
                JSONArray jSONArray = jSONArrayArrC[0];
                if (jSONArray != null && jSONArray.length() > 0) {
                    jSONObject.put(al, jSONArray);
                }
                JSONArray jSONArray2 = jSONArrayArrC[1];
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    jSONObject.put(bi, jSONArray2);
                }
            }
            jSONObject.put(bc, com.anythink.core.common.v.o.b(com.anythink.core.common.v.m.c(contextG, bc)));
            jSONObject.put(bd, com.anythink.core.common.v.o.b(com.anythink.core.common.v.m.d(contextG, bd)));
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    public static JSONObject b(int i2) {
        return a(i2, (List<String>) null);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0044  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.anythink.core.common.d.s] */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    public static JSONObject a(int i2, List<String> list) {
        String strQ;
        boolean z2;
        Context contextG = com.anythink.core.common.d.t.b().g();
        ?? jSONObject = new JSONObject();
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(contextG).b(com.anythink.core.common.d.t.b().p());
        if (bVarB != null) {
            try {
                strQ = bVarB.Q();
            } catch (Throwable unused) {
            }
        } else {
            strQ = "";
        }
        if (TextUtils.isEmpty(strQ)) {
            z2 = true;
        } else {
            try {
                JSONObject jSONObject2 = new JSONObject(strQ);
                if (jSONObject2.isNull("a") || jSONObject2.optInt("a") == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (Exception unused2) {
            }
        }
        jSONObject.put("android_id", z2 ? com.anythink.core.common.v.m.d(contextG) : "");
        jSONObject.put("gaid", com.anythink.core.common.v.m.f());
        ?? C2 = com.anythink.core.common.d.t.b().c();
        if (C2 != 0) {
            C2.fillRequestData(jSONObject, bVarB, i2);
        }
        if (ATSDK.isCnSDK()) {
            jSONObject.put("is_cn_sdk", "1");
        } else {
            jSONObject.put("is_cn_sdk", "0");
        }
        String strN = com.anythink.core.common.v.m.n(contextG);
        Location locationS = com.anythink.core.common.d.t.b().s();
        if (locationS != null) {
            jSONObject.put("lat", locationS.getLatitude());
            jSONObject.put(D, locationS.getLongitude());
        }
        String strT = com.anythink.core.common.d.t.b().t();
        if (!TextUtils.isEmpty(strT)) {
            jSONObject.put(E, Integer.parseInt(strT));
        }
        jSONObject.put("it_src", TextUtils.isEmpty(strN) ? "" : strN);
        jSONObject.put(ac, com.anythink.core.common.d.j.f.a);
        int i3 = aj;
        if (i3 == -1) {
            boolean zC = com.anythink.core.common.v.p.c(contextG);
            boolean zB = com.anythink.core.common.v.p.b(contextG);
            ?? r6 = zB ? 2 : zC;
            if (zC && zB) {
                r6 = 3;
            }
            if (r6 > 0) {
                jSONObject.put(G, r6);
            }
            aj = r6;
        } else if (i3 > 0) {
            jSONObject.put(G, i3);
        }
        int i4 = ak;
        if (i4 == -1) {
            boolean zC2 = com.anythink.core.common.v.p.c();
            if (zC2) {
                jSONObject.put(F, 1);
            }
            ak = zC2 ? 1 : 0;
        } else if (i4 == 1) {
            jSONObject.put(F, i4);
        }
        ATUserDeviceInfo aTUserDeviceInfoQ = com.anythink.core.common.d.t.b().Q();
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
                jSONObject.put(bo, devUID2Token);
            }
        }
        Map<String, Object> mapM = com.anythink.core.common.d.t.b().m();
        try {
            Object obj = mapM.get(ATCustomRuleKeys.USER_NUMBER);
            if (obj != null) {
                jSONObject.put(ag, Long.parseLong(obj.toString()));
            }
        } catch (Throwable unused3) {
        }
        try {
            Object obj2 = mapM.get(ATCustomRuleKeys.USER_DEVICE_ID);
            if (obj2 != null) {
                jSONObject.put(ah, obj2.toString());
            }
        } catch (Throwable unused4) {
        }
        String strP = com.anythink.core.common.v.m.p();
        if (!TextUtils.isEmpty(strP)) {
            jSONObject.put("amazon_id", strP);
        }
        int iQ = com.anythink.core.common.v.m.q();
        if (iQ > 0) {
            jSONObject.put(au, iQ);
        }
        if ((i2 & 32) == 32) {
            if (com.anythink.core.common.o.e.a().f() > 0) {
                jSONObject.put("t_mem", com.anythink.core.common.o.e.a().f());
            }
            if (com.anythink.core.common.o.e.a().g() > 0) {
                jSONObject.put("c_num", com.anythink.core.common.o.e.a().g());
            }
            if (com.anythink.core.common.o.e.a().h() > 0) {
                jSONObject.put("t_store", com.anythink.core.common.o.e.a().h());
            }
        }
        if ((i2 & 64) == 64) {
            String strU = com.anythink.core.common.v.m.u();
            if (!TextUtils.isEmpty(strU)) {
                jSONObject.put("bld_type", strU);
            }
            String strV = com.anythink.core.common.v.m.v();
            if (!TextUtils.isEmpty(strV)) {
                jSONObject.put("bld_tags", strV);
            }
            String strW = com.anythink.core.common.v.m.w();
            if (!TextUtils.isEmpty(strW)) {
                jSONObject.put("bld_user", strW);
            }
            String strX = com.anythink.core.common.v.m.x();
            if (!TextUtils.isEmpty(strX)) {
                jSONObject.put("bld_radio", strX);
            }
            String strY = com.anythink.core.common.v.m.y();
            if (!TextUtils.isEmpty(strY)) {
                jSONObject.put("bld_bootloader", strY);
            }
            String strZ = com.anythink.core.common.v.m.z();
            if (!TextUtils.isEmpty(strZ)) {
                jSONObject.put("bld_hardware", strZ);
            }
            String strA = com.anythink.core.common.v.m.A();
            if (!TextUtils.isEmpty(strA)) {
                jSONObject.put("bld_host", strA);
            }
            String strB = com.anythink.core.common.v.m.B();
            if (!TextUtils.isEmpty(strB)) {
                jSONObject.put("bld_codename", strB);
            }
            String strC = com.anythink.core.common.v.m.C();
            if (!TextUtils.isEmpty(strC)) {
                jSONObject.put("bld_incremental", strC);
            }
            String strD = com.anythink.core.common.v.m.D();
            if (!TextUtils.isEmpty(strD)) {
                jSONObject.put("bld_serial", strD);
            }
            String strE = com.anythink.core.common.v.m.E();
            if (!TextUtils.isEmpty(strE)) {
                jSONObject.put("bld_display", strE);
            }
            String strF = com.anythink.core.common.v.m.F();
            if (!TextUtils.isEmpty(strF)) {
                jSONObject.put("bld_version_codes", strF);
            }
            String strG = com.anythink.core.common.v.m.G();
            if (!TextUtils.isEmpty(strG)) {
                jSONObject.put("bld_board", strG);
            }
        }
        if (list != null && list.contains(com.anythink.core.common.d.j.aa.a)) {
            jSONObject.put("s_c", com.anythink.core.common.v.m.B(contextG));
            jSONObject.put("u_a", com.anythink.core.common.v.m.C(contextG));
            jSONObject.put(aA, com.anythink.core.common.v.m.D(contextG));
            jSONObject.put("d_s", com.anythink.core.common.v.m.E(contextG));
            try {
                jSONObject.put(aC, Integer.parseInt(com.anythink.core.common.v.m.w(contextG)));
                jSONObject.put(aD, Integer.parseInt(com.anythink.core.common.v.m.x(contextG)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        jSONObject.put("ip_v4", com.anythink.core.common.v.m.I());
        jSONObject.put("ip_v6", com.anythink.core.common.v.m.J());
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.json.JSONObject] */
    private static void a(Context context, JSONObject jSONObject) throws JSONException {
        int i2 = aj;
        if (i2 == -1) {
            boolean zC = com.anythink.core.common.v.p.c(context);
            boolean zB = com.anythink.core.common.v.p.b(context);
            ?? r3 = zB ? 2 : zC;
            if (zC && zB) {
                r3 = 3;
            }
            if (r3 > 0) {
                jSONObject.put(G, r3);
            }
            aj = r3;
        } else if (i2 > 0) {
            jSONObject.put(G, i2);
        }
        int i3 = ak;
        if (i3 != -1) {
            if (i3 == 1) {
                jSONObject.put(F, i3);
            }
        } else {
            boolean zC2 = com.anythink.core.common.v.p.c();
            if (zC2) {
                jSONObject.put(F, 1);
            }
            ak = zC2 ? 1 : 0;
        }
    }

    private static void b(JSONObject jSONObject) throws JSONException {
        ATUserDeviceInfo aTUserDeviceInfoQ = com.anythink.core.common.d.t.b().Q();
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
            jSONObject.put(bo, devUID2Token);
        }
    }

    public static void a(JSONObject jSONObject) {
        try {
            by byVarR = com.anythink.core.common.d.t.b().R();
            JSONObject jSONObject2 = new JSONObject();
            int i2 = 1;
            if (byVarR.b() != 1) {
                i2 = 0;
            }
            jSONObject2.put("has_sdk", i2);
            jSONObject2.put("sdk_ver", String.valueOf(byVarR.c()));
            jSONObject2.put("sdk_api_ver", String.valueOf(byVarR.d()));
            jSONObject2.put("open_app_id", com.anythink.core.common.v.m.n());
            jSONObject.put(am, jSONObject2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject a() {
        return a(com.anythink.core.common.d.t.b().m());
    }

    public static JSONObject a(String str) {
        return a(com.anythink.core.common.d.t.b().d(str));
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
}
